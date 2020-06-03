package bean;

import java.sql.Date;

public class UpcomingFlightsBean {
	private String username;
	private String flightNo;
	private String pnr;
	private int bookingId;
	private String source;
	private String departure;
	private String destination;
	private String arrival;
	private String duration;
	private Date date;
	private String passenger;
	
	
	public UpcomingFlightsBean(String flightNo, String pnr, int bookingId, String source, String departure,
			String destination, String arrival, String duration, Date date, String passenger) {
		this.flightNo = flightNo;
		this.pnr = pnr;
		this.bookingId = bookingId;
		this.source = source;
		this.departure = departure;
		this.destination = destination;
		this.arrival = arrival;
		this.duration = duration;
		this.date = date;
		this.passenger = passenger;
	}
	
	public UpcomingFlightsBean() {
	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPassenger() {
		return passenger;
	}

	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}
	
	
	
}
