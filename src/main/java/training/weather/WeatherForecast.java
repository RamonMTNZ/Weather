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

	public String getCityWeather(String city, Date datetime) throws IOException {

		if (datetime == null) {
			// Utilizamos fecha actual
			datetime = new Date();
		}
		Date fechaEn6Dias = new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 6));
		boolean fechaEnRangoDePrediccion = (datetime.before(fechaEn6Dias));
		if (fechaEnRangoDePrediccion) {
			HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
			HttpRequest request = requestFactory
				.buildGetRequest(new GenericUrl("https://www.metaweather.com/api/location/search/?query=" + city));
			String r = request.execute().parseAsString();
			JSONArray array = new JSONArray(r);
			String woe = array.getJSONObject(0).get("woeid").toString();
			requestFactory = new NetHttpTransport().createRequestFactory();
			request = requestFactory.buildGetRequest(new GenericUrl("https://www.metaweather.com/api/location/" + woe));
			r = request.execute().parseAsString();
			JSONArray results = new JSONObject(r).getJSONArray("consolidated_weather");
			for (int i = 0; i < results.length(); i++) {
				if (new SimpleDateFormat("yyyy-MM-dd").format(datetime)
					.equals(results.getJSONObject(i).get("applicable_date").toString())) {
					return results.getJSONObject(i).get("weather_state_name").toString();
				}
			}
		}
		return "";
	}
}

