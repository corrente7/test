package test.service;

import test.model.FlightStatus;
import test.model.Weather;
import test.parser.Parser;

import java.io.FileNotFoundException;
import java.util.Collection;

public class WeatherService {

    public static FlightStatus getConditionsFrom(String city, int time) throws FileNotFoundException {

        Collection<Weather> conditions = Parser.getWeather(city);
        FlightStatus status = null;

        for (Weather weather : conditions) {
            if (weather.getTime() == time) {
                if (weather.getWind() > 30 || weather.getVisibility() > 200) {
                    status = FlightStatus.CANCELED;
                } else
                    status = FlightStatus.AS_PLANNED;
            }
        }
        return status;
    }
}