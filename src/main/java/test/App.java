package test;


import test.formatter.Formatter;
import test.model.*;
import test.parser.Parser;
import test.service.FlightsService;
import test.service.WeatherService;

import java.io.FileNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public class App {

    public static void main(String[] args) throws FileNotFoundException {

        List<Map<String, Object>> list = FlightsService.getFlightStatusFrom();
        List<Map<String, Object>> finallist = FlightsService.getFlightStatusTo(list);
        String result = Formatter.formatTo(finallist);

        System.out.println(result);


    }
}
