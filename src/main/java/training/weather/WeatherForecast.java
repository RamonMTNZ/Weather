package training.weather;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherForecast {

	public String getClimaDeCiudad(String ciudad, Date fecha) throws IOException {


		if (fecha == null) {
			// Utilizamos fecha actual
			fecha = new Date();
		}


		if (fechaEsValida(fecha)) {
			// Obtén el woe ID para localizar la ciudad y el enlace necesario para ver el clima
			String enlaceCiudad = "https://www.metaweather.com/api/location/search/?query=";
			String infoDeCiudad = devuelveStringDeEnlace(enlaceCiudad + ciudad);
			if (infoDeCiudad.equals("[]")){
				return "La ciudad que ha especificado no existe, compruebe que esté escrita correctamente.";
			}
			String woe = devuelveWoeId(infoDeCiudad);

			// Usa el woe ID para obtener un array con la informacion del clima de la ciudad
			String enlaceClima = "https://www.metaweather.com/api/location/";
			String infoDeClima = devuelveStringDeEnlace(enlaceClima + woe);
			JSONArray infoClimaArray = devuelveArrayJSONSegunCategoria(infoDeClima, "consolidated_weather");

			// Busca la fecha dada por el usuario en el array y devueve el clima de esa fecha
			for (int indice = 0; indice < infoClimaArray.length(); indice++) {
				String fechaElementoIndice = infoClimaArray.getJSONObject(indice).get("applicable_date").toString();
				if (fechasCoinciden(fecha, fechaElementoIndice)) {
					return infoClimaArray.getJSONObject(indice).get("weather_state_name").toString();
				}
			}
		}
		else {
			return "Por favor, seleccione una fecha entre la fecha de hoy y los próximos 6 días.";
		}
		return "";
	}

	private boolean fechaEsValida(Date fecha){
		// Comprueba que la fecha este en el rango de fechas que metaweather calcula el clima (6 días a partir de hoy)
		Date fechaEn6Dias = new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 6));
		Date fechaHaceUnMinuto = new Date(new Date().getTime() - (1000*60));
		return fecha.before(fechaEn6Dias) && fecha.after(fechaHaceUnMinuto);
	}

	private String devuelveStringDeEnlace(String enlace) throws IOException {
		//Devuelve un string con la información del enlace
		HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
		HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(enlace));
		return request.execute().parseAsString();
	}

	private String devuelveWoeId(String infoDePagina){
		// Devuelve el identificaor utilizado en metaweather para la ciudad
		JSONArray array = new JSONArray(infoDePagina);
		return array.getJSONObject(0).get("woeid").toString();
	}

	private JSONArray devuelveArrayJSONSegunCategoria(String info, String categoria){
		// Convierte el String a JSONArray y devuelve la categoria seleccionada
		return new JSONObject(info).getJSONArray(categoria);
	}

	private boolean fechasCoinciden(Date fechaDada, String fechaArray) {
		// Comprueba que una fecha String y una fecha en formato Date coincidan
		return new SimpleDateFormat("yyyy-MM-dd").format(fechaDada).equals(fechaArray);
	}


}

