package ObserverPattern;

public class Follower implements Observer {
	
	String followerName;
	
	

	public Follower(String followerName) {
		super();
		this.followerName = followerName;
	}

	@Override
	public void update(String status) {
		
		System.out.println(followerName + " notified : status is " + status );
		
	}

	public String getFollowerName() {
		return followerName;
	}

	public void setFollowerName(String followerName) {
		this.followerName = followerName;
	}

}
