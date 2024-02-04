package test.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Flight {

	private String no;
	private int departure;
	private String from;
	private String to;
	private int duration;
}
