package test.model;

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
