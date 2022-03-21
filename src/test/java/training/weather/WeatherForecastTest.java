package training.weather;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class WeatherForecastTest {
	WeatherForecast weatherForecast = new WeatherForecast();;
	String mensajeError = "";


	@Test
	@DisplayName("Probando que la función retorne algún tipo de clima con parametros correctos")
	public void testParametrosCorrectos() throws IOException {
		String predccionTiempo = weatherForecast.getCityWeather("Madrid", new Date());
		assertNotEquals(predccionTiempo, mensajeError);
	}

	@Test
	@DisplayName("Probando que la función retorne algún tipo de clima con parametros correctos")
	public void testSinFecha() throws IOException {
		String predccionTiempo = weatherForecast.getCityWeather("Madrid", new Date());
		assertNotEquals(predccionTiempo, mensajeError);
	}

	@Test
	@DisplayName("Probando con una fecha anterior (4 días)")
	public void testFechaAnterior() throws IOException {
		String predccionTiempo = weatherForecast.getCityWeather("Madrid", new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 4)));
		assertNotEquals(predccionTiempo, mensajeError);
	}

	@Test
	@DisplayName("Probando con una fecha posterior (4 días)")
	public void testFechaFutura() throws IOException {
		String predccionTiempo = weatherForecast.getCityWeather("Madrid", new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 4)));
		assertNotEquals(predccionTiempo, mensajeError);
	}


	@Test
	@DisplayName("Probando con una fecha posterior (30 días)")
	public void testFechaFuturaLejana() throws IOException {
		String predccionTiempo = weatherForecast.getCityWeather("Madrid", new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 30)));
		assertNotEquals(predccionTiempo, mensajeError);
	}

	@Test
	@DisplayName("Probando con una ciudad válida")
	public void testCiudadValida() throws IOException {
		String predccionTiempo = weatherForecast.getCityWeather("Rome", new Date());
		assertNotEquals(predccionTiempo, mensajeError);
	}










}


