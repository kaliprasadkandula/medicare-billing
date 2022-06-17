package medicare.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import medicare.models.Review;
import medicare.models.Ticket;

@Service
public class ReviewService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	public void saveReview(Review r) {
		Review rr=findById(r.getUserid());
		final String sql;
		if(rr!=null)
		{
			sql="update reviews set review=:review  where userid=:userid";
			
		}
		else
		{
			sql="insert into reviews(userid,review) "
				                    + "values(:userid,:review)";
		 }
		temp.update(sql, getSqlParameterByModel(r));
		}
	
	public List<Review> allReviews(){
		return temp.query("SELECT * FROM reviews", new ReviewRowMapper());
	}
	public List<Review> allReviewsforUser(String userid){
		MapSqlParameterSource map=new MapSqlParameterSource();
		System.out.println(userid+"huiii");
		map.addValue("userid", userid);
		return temp.query("select * from reviews where userid=:userid",
				map,new ReviewRowMapper());
		}
	
	public long countReviews() {
		return temp.queryForObject("SELECT count(*) from  reviews",getSqlParameterByModel(null),Long.class);
	}
	
	public Review findById(String userr) {
		Review r=new Review();
		r.setUserid(userr);
		try {
		return temp.queryForObject("SELECT * from reviews WHERE userid=:userid", 
				getSqlParameterByModel(r), new ReviewRowMapper());
		}catch(Exception ex) {
			return null;
		}

	}
	
	
	private SqlParameterSource getSqlParameterByModel(Review r) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (r != null) {
        	ps.addValue("userid", r.getUserid());
        	ps.addValue("review",r.getReview());
        	
        }
        return ps;
    }
	
	private class ReviewRowMapper implements RowMapper<Review>{

		@Override
		public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
			Review r=new Review();
			r.setUserid(rs.getString("userid"));
			r.setReview(rs.getString("review"));
			return r;
		}
		
	}
}
