package training.weather;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        WeatherForecast weatherForecast = new WeatherForecast();
        String predccionTiempo = weatherForecast.getClimaDeCiudad("Madrid", new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 30)));
        System.out.println(predccionTiempo);
    }




}
