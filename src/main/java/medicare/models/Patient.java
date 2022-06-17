package medicare.models;

public class Patient {
	private String fname;
	private String lname;
	private String dob;
	private String gender;
	private String phone;
	private String address;
	private String patientid;
	private String symptoms;
	private String userid;
	private int consultancy_bill;
	private int room_bill;
	private int service_bill;
	private int medication_bill;
	private int total_bill;
	private String bill_status;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getConsultancy_bill() {
		return consultancy_bill;
	}
	public void setConsultancy_bill(int i) {
		this.consultancy_bill = i;
	}
	public int getRoom_bill() {
		return room_bill;
	}
	public void setRoom_bill(int i) {
		this.room_bill = i;
	}
	public int getService_bill() {
		return service_bill;
	}
	public void setService_bill(int i) {
		this.service_bill = i;
	}
	public int getMedication_bill() {
		return medication_bill;
	}
	public void setMedication_bill(int i) {
		this.medication_bill = i;
	}
	public int getTotal_bill() {
		return total_bill;
	}
	public void setTotal_bill(int i) {
		this.total_bill = i;
	}
	public String getBill_status() {
		return bill_status;
	}
	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}
	@Override
	public String toString() {
		return "Patient [fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", gender=" + gender + ", phone="
				+ phone + ", address=" + address + ", patientid=" + patientid + ", symptoms=" + symptoms + ", userid="
				+ userid + ", consultancy_bill=" + consultancy_bill + ", room_bill=" + room_bill + ", service_bill="
				+ service_bill + ", medication_bill=" + medication_bill + ", total_bill=" + total_bill
				+ ", bill_status=" + bill_status + "]";
	}
	
	
}
