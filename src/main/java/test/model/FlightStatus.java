package test.model;

import lombok.Getter;

@Getter
public enum FlightStatus {
    AS_PLANNED("по расписанию"),
    CANCELED("отменен");

    private String name;

    FlightStatus(String name) {
        this.name = name;
    }

}
