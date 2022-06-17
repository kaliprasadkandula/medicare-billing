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

import medicare.models.Ticket;

@Service
public class TicketService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	public void saveTicket(Ticket t) {
		Ticket tt=findById(t.getUserid());
		final String sql;
		if(tt!=null)
		{
			sql="update tickets set query=:query,resolution=:resolution where userid=:userid";
			
		}
		else
		{
			sql="insert into tickets(userid,query,resolution) "
				                    + "values(:userid,:query,:resolution)";
		 }
		temp.update(sql, getSqlParameterByModel(t));
		}
	
	public List<Ticket> allTickets(){
		return temp.query("SELECT * FROM tickets", new TicketRowMapper());
	}
	public List<Ticket> allTicketsforUser(String userid){
		MapSqlParameterSource map=new MapSqlParameterSource();
		System.out.println(userid+"huiii");
		map.addValue("userid", userid);
		return temp.query("select * from tickets where userid=:userid",
				map,new TicketRowMapper());
		}
	
	public long countTickets() {
		return temp.queryForObject("SELECT count(*) from  tickets",getSqlParameterByModel(null),Long.class);
	}
	
	public Ticket findById(String userr) {
		Ticket t=new Ticket();
		t.setUserid(userr);
		try {
		return temp.queryForObject("SELECT * from tickets WHERE userid=:userid", 
				getSqlParameterByModel(t), new TicketRowMapper());
		}catch(Exception ex) {
			return null;
		}

	}
	
	
	private SqlParameterSource getSqlParameterByModel(Ticket t) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (t != null) {
        	ps.addValue("userid", t.getUserid());
        	ps.addValue("query",t.getQuery());
        	ps.addValue("resolution", t.getResolution());
        	
        }
        return ps;
    }
	
	private class TicketRowMapper implements RowMapper<Ticket>{

		@Override
		public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
			Ticket t=new Ticket();
			t.setUserid(rs.getString("userid"));
			t.setQuery(rs.getString("query"));
			t.setResolution(rs.getString("resolution"));
			return t;
		}
		
	}
}
