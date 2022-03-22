package training.weather;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.util.Date;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class WeatherForecastTest {
	WeatherForecast weatherForecast = new WeatherForecast();
	String mensajeErrorFecha = "Por favor, seleccione una fecha entre la fecha de hoy y los próximos 6 días.";
	String mensajeErrorCiudad = "La ciudad que ha especificado no existe, compruebe que esté escrita correctamente.";


	@Test
	@DisplayName("Probando que la función retorne algún tipo de clima con parametros correctos")
	public void testParametrosCorrectos() throws IOException {
		String predccionTiempo = weatherForecast.getClimaDeCiudad("Madrid", new Date());
		assertNotEquals(predccionTiempo, mensajeErrorFecha);
		assertNotEquals(predccionTiempo, mensajeErrorCiudad);
	}



	@Test
	@DisplayName("Probando con una fecha anterior (4 días). Debe devolver un mensaje de error por la fecha.")
	public void testFechaAnterior() throws IOException {
		String predccionTiempo = weatherForecast.getClimaDeCiudad("Madrid", new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 4)));
		assertEquals(predccionTiempo, mensajeErrorFecha);

	}

	@Test
	@DisplayName("Probando con una fecha posterior (4 días). Debería funcionar sin problemas.")
	public void testFechaFutura() throws IOException {
		String predccionTiempo = weatherForecast.getClimaDeCiudad("Madrid", new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 4)));
		assertNotEquals(predccionTiempo, mensajeErrorFecha);
		assertNotEquals(predccionTiempo, mensajeErrorCiudad);
	}

	@Test
	@DisplayName("Probando con una fecha anterior (30 días). Debe devolver un mensaje de error por la fecha.")
	public void testFechaAnteriorLejana() throws IOException {
		String predccionTiempo = weatherForecast.getClimaDeCiudad("Madrid", new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 30)));
		assertEquals(predccionTiempo, mensajeErrorFecha);

	}

	@Test
	@DisplayName("Probando con una fecha posterior (30 días). Debe devolver un mensaje de error por la fecha.")
	public void testFechaFuturaLejana() throws IOException {
		String predccionTiempo = weatherForecast.getClimaDeCiudad("Madrid", new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 30)));
		assertEquals(predccionTiempo, mensajeErrorFecha);

	}

	@Test
	@DisplayName("Probando con una ciudad válida y la fecha de hoy. Debería funcionar sin problemas.")
	public void testCiudadValida() throws IOException {
		String predccionTiempo = weatherForecast.getClimaDeCiudad("Rome", new Date());
		assertNotEquals(predccionTiempo, mensajeErrorFecha);
		assertNotEquals(predccionTiempo, mensajeErrorCiudad);
	}

	@Test
	@DisplayName("Probando con una ciudad inválida. Devolverá un mensaje de error por ciudad inválida.")
	public void testCiudadInvalida() throws IOException {
		String predccionTiempo = weatherForecast.getClimaDeCiudad("Alcachofa", new Date());
		assertEquals(predccionTiempo, mensajeErrorCiudad);
	}








}


