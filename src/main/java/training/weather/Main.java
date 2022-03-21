package training.weather;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        WeatherForecast weatherForecast = new WeatherForecast();
        String forecast = weatherForecast.getCityWeather("Madrid", new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 6)));
        System.out.println(forecast + " is the weather");
    }


}
