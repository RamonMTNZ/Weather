package training.weather;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        WeatherForecast weatherForecast = new WeatherForecast();
        String forecast = weatherForecast.getCityWeather("Glasgow", new Date());
        System.out.println(forecast);
    }




}
