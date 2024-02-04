package test.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import test.model.Flight;
import test.model.Flights;
import test.model.Weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class Parser {


    public static List<Flight> getFlights() {

        List<Flight> flightsList = null;

        try {
            ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            File file = new File("src/main/resources/flights_and_forecast.json");

            Flights flights = mapper.reader()
                .forType(Flights.class)
                .readValue(file);
            flightsList = flights.getFlights();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightsList;
    }

    public static Collection<Weather> getWeather(String city) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/flights_and_forecast.json"));
        JsonObject obj = new Gson().fromJson(reader, JsonObject.class);
        String result = obj.getAsJsonObject("forecast")
                .get(city)
                .toString();

        Type collectionType = new TypeToken<Collection<Weather>>(){}.getType();
        return new Gson().fromJson(result, collectionType);
    }
}
