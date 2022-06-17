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

//import medicare.models.FrontDesk;
import medicare.models.Patient;

@Service
public class PatientService {

	@Autowired NamedParameterJdbcTemplate temp;
	public void savePatient(Patient pd) {
		Patient pdd=findByPatientId(pd.getPatientid());
		final String sql;
		if(pdd!=null)
		{
			sql="update patient set consultancy_bill=:consultancy_bill,room_bill=:room_bill,service_bill=:service_bill,medication_bill=:medication_bill,bill_status=:bill_status,"
					+ "total_bill=:consultancy_bill+:service_bill+:room_bill+:medication_bill where patientid=:patientid";
			
		}
		else
		{ sql="insert into patient(patientid,fname,lname,gender,phone,address,dob,symptoms,userid) "
				+ "values(:patientid,:fname,:lname,:gender,:phone,:address,:dob,:symptoms,:userid)";
		
			}
		temp.update(sql, getSqlParameterByModel(pd));
		}
	
	
	public List<Patient> allPatients(){
		return temp.query("SELECT * FROM patient", new PatientRowMapper());
	}
	
	public List<Patient> allUserPatients(String userid){
		MapSqlParameterSource map=new MapSqlParameterSource();
		System.out.println(userid+"huiii");
		map.addValue("userid", userid);
		return temp.query("select * from patient where userid=:userid",
				map,new PatientRowMapper());
	}
	
	public long countPatient() {
		return temp.queryForObject("SELECT count(*) from patient",getSqlParameterByModel(null),Long.class);
	}
	
	public Patient findByPatientId(String patientid) {
		Patient p=new Patient();
		p.setPatientid(patientid);
		try {
		return temp.queryForObject("SELECT * from patient WHERE patientid=:patientid", 
				getSqlParameterByModel(p), new PatientRowMapper());
		}catch(Exception ex) {
			return null;
		}
	}
	public Patient userfindByPatientId(String patientid,String userid) {
		Patient p=new Patient();
		p.setPatientid(patientid);
		p.setUserid(userid);
		try {
		return temp.queryForObject("SELECT * from patient WHERE patientid=:patientid and userid=:userid", 
				getSqlParameterByModel(p), new PatientRowMapper());
		}catch(Exception ex) {
			return null;
		}
	}
	
	private SqlParameterSource getSqlParameterByModel(Patient u) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (u != null) {
        	 ps.addValue("fname", u.getFname());
        	 ps.addValue("lname", u.getLname());
        	 ps.addValue("dob", u.getDob());
        	 ps.addValue("gender", u.getGender());
        	 ps.addValue("phone", u.getPhone());
        	 ps.addValue("address", u.getAddress());
        	 ps.addValue("patientid", u.getPatientid());
        	 ps.addValue("symptoms", u.getSymptoms());
        	 ps.addValue("userid", u.getUserid());
        	 ps.addValue("consultancy_bill", u.getConsultancy_bill());
        	 ps.addValue("service_bill", u.getService_bill());
        	 ps.addValue("room_bill", u.getRoom_bill());
        	 ps.addValue("medication_bill", u.getMedication_bill());
        	 ps.addValue("total_bill", u.getConsultancy_bill()+u.getService_bill()+u.getRoom_bill()+u.getMedication_bill());
        	 ps.addValue("bill_status", u.getBill_status());
        }
        return ps;
    }
	
	private class PatientRowMapper implements RowMapper<Patient>{

		@Override
		public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Patient pat=new Patient();
			pat.setFname(rs.getString("fname"));
			pat.setLname(rs.getString("lname"));
			pat.setDob(rs.getString("dob"));
			pat.setGender(rs.getString("gender"));
			pat.setPhone(rs.getString("phone"));
			pat.setAddress(rs.getString("address"));
			pat.setPatientid(rs.getString("patientid"));
			pat.setSymptoms(rs.getString("symptoms"));
			pat.setUserid(rs.getString("userid"));
			pat.setConsultancy_bill(rs.getInt("consultancy_bill"));
			pat.setRoom_bill(rs.getInt("room_bill"));
			pat.setService_bill(rs.getInt("service_bill"));
			pat.setMedication_bill(rs.getInt("medication_bill"));
			pat.setBill_status(rs.getString("bill_status"));
			pat.setTotal_bill(rs.getInt("medication_bill")+rs.getInt("consultancy_bill")+rs.getInt("room_bill")+rs.getInt("service_bill"));
			return pat;
		}
		
	}
}
