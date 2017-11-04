package ObserverPattern;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Channel implements Subject {
	
	String status;
	List<Observer > observers = new ArrayList<>(); 

	public String getStatus() {
		return status;
	}

	public Channel(String status) {
		super();
		this.status = status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObserver() {
		
		for(Observer observer: observers) {
			observer.update(status);
		}
	}

}
