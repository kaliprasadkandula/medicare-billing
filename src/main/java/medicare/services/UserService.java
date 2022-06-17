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

import medicare.models.User;

@Service
public class UserService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	public void saveUser(User u) {
		User uss=findById(u.getUserid());
		final String sql;
		if(uss!=null)
		{
			sql="update user set fname=:fname,lname=:lname,pwd=:pwd where userid=:userid";
			
		}
		else
		{
			sql="insert into user(userid,fname,lname,pwd,favcolour,favnumber,favpet) "
				                    + "values(:userid,:fname,:lname,:pwd,:favcolour,:favnumber,:favpet)";
		 }
		temp.update(sql, getSqlParameterByModel(u));
		}
	
	    public void saveUserpwd(User u) {
		User uss=findById(u.getUserid());
		final String sql;
		if(uss!=null)
		{
			sql="update user set pwd=:pwd where userid=:userid";
			
		}
		else
		{
			sql="insert into user(userid,fname,lname,pwd,favcolour,favnumber,favpet) "
				                    + "values(:userid,:fname,:lname,:pwd,:favcolour,:favnumber,:favpet)";
		 }
		temp.update(sql, getSqlParameterByModel(u));
		}
	
	public List<User> allUsers(){
		return temp.query("SELECT * FROM user", new UserRowMapper());
	}
	
	public long countUsers() {
		return temp.queryForObject("SELECT count(*) from  user",getSqlParameterByModel(null),Long.class);
	}
	
	public User findById(String userr) {
		User u=new User();
		u.setUserid(userr);;
		try {
		return temp.queryForObject("SELECT * from user WHERE userid=:userid", 
				getSqlParameterByModel(u), new UserRowMapper());
		}catch(Exception ex) {
			return null;
		}

	}
	
	
	private SqlParameterSource getSqlParameterByModel(User u) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (u != null) {
        	ps.addValue("userid", u.getUserid());
        	ps.addValue("fname",u.getFname());
        	ps.addValue("lname", u.getLname());
        	ps.addValue("pwd", u.getPwd());
        	ps.addValue("favcolour", u.getFavcolour());
        	ps.addValue("favpet", u.getFavpet());
        	ps.addValue("favnumber", u.getFavnumber());
        }
        return ps;
    }
	
	private class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User u=new User();
			u.setUserid(rs.getString("userid"));
			u.setFname(rs.getString("fname"));
			u.setLname(rs.getString("lname"));
			u.setPwd(rs.getString("pwd"));
			u.setFavcolour(rs.getString("favcolour"));
			u.setFavnumber(rs.getString("favnumber"));
			u.setFavpet(rs.getString("favpet"));
			return u;
		}
		
	}
}
