package test.formatter;

import test.model.FlightStatus;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String formatTo(List<Map<String, Object>> list) {

        StringBuilder strResult = new StringBuilder();
        for (Map<String, Object> map: list) {
            strResult.append(map.get("flight") + " | "
                            + map.get("from") + " -> "
                            + map.get("to") + " | " + ((FlightStatus)map.get("flightStatus")).getName() + '\n');
            }
    return strResult.substring(0, strResult.length() - 1);
    }
}
