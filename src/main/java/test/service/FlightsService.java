package test.service;

import test.model.Flight;
import test.parser.Parser;
import test.util.TimeDifference;

import java.io.FileNotFoundException;
import java.util.*;

import static test.model.FlightStatus.AS_PLANNED;

public class FlightsService {

    public static List<Map<String, Object>> getFlightStatusFrom() throws FileNotFoundException {

        List<Flight> flightsList = Parser.getFlights();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Flight flight : flightsList) {
            String cityFrom = flight.getFrom();
            int timeFrom = flight.getDeparture();
            Map<String, Object> map = new HashMap<>();
            map.put("flight", flight.getNo());
            map.put("departure", flight.getDeparture());
            map.put("from", cityFrom);
            map.put("to", flight.getTo());
            map.put("duration", flight.getDuration());
            map.put("flightStatus", WeatherService.getConditionsFrom(cityFrom, timeFrom));
            result.add(map);
            }
        return result;
        }

        public static List<Map<String, Object>> getFlightStatusTo(List<Map<String, Object>> list) throws FileNotFoundException {
                for (Map<String, Object> map : list) {
                    if ((map.get("flightStatus")).equals(AS_PLANNED)) {
                        int timeDifference = TimeDifference.checkTimeDifference((String) map.get("from"), (String) map.get("to"));
                        int arrivalTime = (int)(map.get("departure")) + (int) map.get("duration") + timeDifference;
                        map.replace("flightStatus", WeatherService.getConditionsFrom((String) map.get("to"), arrivalTime));
                    }
                }
        return list;
        }
}
