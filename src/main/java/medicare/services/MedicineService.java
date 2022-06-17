package medicare.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import medicare.models.Medication;
import medicare.models.Room;

@Service
public class MedicineService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	
	public List<Medication> allMedications(){
		return temp.query("SELECT * FROM medicines", new RoomRowMapper());
	}
	
	
	
	
	private class RoomRowMapper implements RowMapper<Medication>{

		@Override
		public Medication mapRow(ResultSet rs, int rowNum) throws SQLException {
			Medication s=new Medication();
			s.setRoomtype(rs.getString("medicationtype"));
			s.setPrice(rs.getString("price"));
			return s;
		}
		
	}
}
