package medicare.models;

public class Room {
	private String roomtype;
	private String price;
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Room [roomtype=" + roomtype + ", price=" + price + "]";
	}
	
	
}


	
	
	

