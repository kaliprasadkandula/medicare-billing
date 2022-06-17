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

import medicare.models.Servees;

@Service
public class ServiceService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	
	public List<Servees> allServices(){
		return temp.query("SELECT * FROM services", new ServeesRowMapper());
	}
	
	
	
	
	private class ServeesRowMapper implements RowMapper<Servees>{

		@Override
		public Servees mapRow(ResultSet rs, int rowNum) throws SQLException {
			Servees s=new Servees();
			s.setServicetype(rs.getString("servicetype"));
			s.setPrice(rs.getString("price"));
			return s;
		}
		
	}
}
