package flightBooking;

import java.util.List;

public class Airport {
      private String airPortName;
      private Address address;
      private String uniqueueCode;
      Flight flight;
      private List<Flight> flightList;
      public List<Flight> getCurrentFlights(){
		return flightList;	  
      }
}
