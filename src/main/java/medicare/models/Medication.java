package medicare.models;

public class Medication {
	private String medicationtype;
	private String price;
	public String getMedicationtype() {
		return medicationtype;
	}
	public void setRoomtype(String medicationtype) {
		this.medicationtype = medicationtype;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Room [medicationtype=" + medicationtype + ", price=" + price + "]";
	}
	
	
}


	
	
	

