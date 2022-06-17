package medicare.models;

public class Service {
	private String servicetype;
	private String price;
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Service [servicetype=" + servicetype + ", price=" + price + "]";
	}
	
	
}


	
	
	

