package medicare.models;

public class Ticket {
	private String userid;
	private String query;
	private String resolution;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	@Override
	public String toString() {
		return "Ticket [userid=" + userid + ", query=" + query + ", resolution=" + resolution + "]";
	}
	
	
	
}


	
	
	

