package observerHeadFirst;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay =
				new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasureMents(80, 65, 30.4f);
		weatherData.setMeasureMents(82, 70, 29.2f);
		weatherData.setMeasureMents(78, 90, 30.4f);

	}

}
