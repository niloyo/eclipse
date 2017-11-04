package observerHeadFirst;

import java.util.ArrayList;
import java.util.Observable;

public class WeatherData extends Observable {
	
	private float temperature;
	private float humidity;
	private float pressure;
	

	public WeatherData() {
	}

	public void setMeasureMents(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyObservers();	
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update(temperature, humidity, pressure);
		}

	}

}