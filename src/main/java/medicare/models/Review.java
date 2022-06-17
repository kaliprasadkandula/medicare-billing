package medicare.models;

public class Review {
	private String userid;
	private String review;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "Review [userid=" + userid + ", review=" + review + "]";
	}
	
	
}


	
	
	

