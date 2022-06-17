package medicare.models;

public class FrontDesk {
	private String frontdeskid;
	private String dob;
	private String email;
	private String gender;
	private String fname;
	private String lname;
	private String phone;
	private String pwd;
	private String status;
	
	
	public String getFrontdeskid() {
		return frontdeskid;
	}


	public void setFrontdeskid(String frontdeskid) {
		this.frontdeskid = frontdeskid;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "FrontDesk [frontdeskid=" + frontdeskid + ", dob=" + dob + ", email=" + email + ", gender=" + gender
				+ ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", pwd=" + pwd + ", status=" + status
				+ "]";
	}


	
	
	
}
