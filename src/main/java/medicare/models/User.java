package medicare.models;

public class User {
	private String userid;
	private String fname;
	private String lname;
	private String pwd;
	private String favnumber;
	private String favpet;
	private String favcolour;
	public String getUserid() {
		return userid;
	}
	public String getFavnumber() {
		return favnumber;
	}
	public void setFavnumber(String favnumber) {
		this.favnumber = favnumber;
	}
	public String getFavpet() {
		return favpet;
	}
	public void setFavpet(String favpet) {
		this.favpet = favpet;
	}
	public String getFavcolour() {
		return favcolour;
	}
	public void setFavcolour(String favcolour) {
		this.favcolour = favcolour;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", fname=" + fname + ", lname=" + lname + ", pwd=" + pwd + ", favnumber="
				+ favnumber + ", favpet=" + favpet + ", favcolour=" + favcolour + "]";
	}
	
	
	
	
	
}


	
	
	

