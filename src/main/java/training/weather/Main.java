package training.weather;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.getCityWeather("Madrid", null);
    }
}
