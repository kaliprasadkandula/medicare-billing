package medicare.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import medicare.models.Room;
import medicare.models.Servees;

@Service
public class RoomService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	
	public List<Room> allRooms(){
		return temp.query("SELECT * FROM rooms", new RoomRowMapper());
	}
	
	
	
	
	private class RoomRowMapper implements RowMapper<Room>{

		@Override
		public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
			Room s=new Room();
			s.setRoomtype(rs.getString("roomtype"));
			s.setPrice(rs.getString("price"));
			return s;
		}
		
	}
}
