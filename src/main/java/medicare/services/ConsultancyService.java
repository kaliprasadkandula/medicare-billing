package medicare.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import medicare.models.Consultancy;
import medicare.models.Room;

@Service
public class ConsultancyService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	
	public List<Consultancy> allConsultancies(){
		return temp.query("SELECT * FROM consultancies", new ConsultancyRowMapper());
	}
	
	
	
	
	private class ConsultancyRowMapper implements RowMapper<Consultancy>{

		@Override
		public Consultancy mapRow(ResultSet rs, int rowNum) throws SQLException {
			Consultancy s=new Consultancy();
			s.setConsultansytype(rs.getString("consultansytype"));
			s.setPrice(rs.getString("price"));
			return s;
		}
		
	}
}
