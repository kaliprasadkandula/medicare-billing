package medicare.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import medicare.models.Admin;

@Service
public class AdminService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	public void saveAdmin(Admin admin) {
		final String sql="insert into admin(userid,pwd) values(:userid,:pwd)";
		temp.update(sql, getSqlParameterByModel(admin));//here admin is the model by which we can get parameters
	}
	
	public long countUser() {//used in main application
		return temp.queryForObject("SELECT count(*) from admin", getSqlParameterByModel(null), Long.class);
	//have a doubt
	}
	
	public Admin validate(Admin a) {
		try {
		return temp.queryForObject("SELECT * from admin WHERE userid=:userid and pwd=:pwd", 
				getSqlParameterByModel(a), new AdminMapper());
		}
		catch(Exception ex) {
			return null;
		}
	}
	
	private SqlParameterSource getSqlParameterByModel(Admin a) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (a != null) {
            ps.addValue("userid", a.getUserid());
            ps.addValue("pwd", a.getPwd());
        }
        return ps;
    }
	
	private class AdminMapper implements RowMapper<Admin>{

		@Override
		public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Admin(rs.getString("userid"), rs.getString("pwd"));
		}
		
	}
	
	
}
