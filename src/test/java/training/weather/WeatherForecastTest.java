package training.weather;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Test;

public class WeatherForecastTest {

	@Test
	public void unfinished_test() throws IOException {
		WeatherForecast weatherForecast = new WeatherForecast();
		String forecast = weatherForecast.getCityWeather("Madrid", new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 6)));
		System.out.println(forecast);
	}
}


