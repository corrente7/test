package test.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Weather {

    private int time;
    private int wind;
    private int visibility;
}
