package flightBooking;

import java.util.Date;

enum FlightStatus{
	ONTIME,
	Delayed	
}
public class Schedule {
     Flight Flight;
     Date date;
     private String gate;
     private FlightStatus status;
}
