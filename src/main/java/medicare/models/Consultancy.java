package medicare.models;

public class Consultancy {
	private String consultansytype;
	private String price;
	public String getConsultansytype() {
		return consultansytype;
	}
	public void setConsultansytype(String consultansytype) {
		this.consultansytype = consultansytype;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Consultancy [consultansytype=" + consultansytype + ", price=" + price + "]";
	}
	
	
}


	
	
	

