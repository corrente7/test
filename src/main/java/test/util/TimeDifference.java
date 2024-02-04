package test.util;

import java.util.Objects;

public class TimeDifference {

    public static final int TIME_ZONE_MSK_OMS = 3;
    public static final int TIME_ZONE_MSK_NSK = 4;
    public static final int TIME_ZONE_OMS_NSK = 1;

    public static final int TIME_ZONE_NSK_OMS = -1;
    public static final int TIME_ZONE_OMS_MSK = -3;
    public static final int TIME_ZONE_NSK_MSK = -4;

    public static int checkTimeDifference(String cityFrom, String cityTo) {
        int result = 0;
        if (Objects.equals(cityFrom, "novosibirsk") && Objects.equals(cityTo, "moscow"))
            result = TIME_ZONE_NSK_MSK;
        if (Objects.equals(cityFrom, "moscow") && Objects.equals(cityTo, "novosibirsk"))
            result = TIME_ZONE_MSK_NSK;
        if (Objects.equals(cityFrom, "omsk") && Objects.equals(cityTo, "novosibirsk"))
            result = TIME_ZONE_OMS_NSK;
        return result;
    }
}
