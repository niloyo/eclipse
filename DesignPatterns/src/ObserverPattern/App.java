package ObserverPattern;

public class App {
	
	public static void main(String[] args) {
		Channel channel = new Channel("Started");
		
		Follower follower1 = new Follower("follwer1");
		Follower follower2 = new Follower("follwer2");
		Follower follower3 = new Follower("follwer3");
		
		channel.registerObserver(follower1);
		channel.registerObserver(follower2);
		channel.registerObserver(follower3);
		
		channel.notifyObserver();
		
		channel.removeObserver(follower2);
		
		channel.setStatus("ended");
		
		channel.notifyObserver();

		
	}
}
