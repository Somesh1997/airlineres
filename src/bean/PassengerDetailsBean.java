package bean;

import java.sql.Date;

public class PassengerDetailsBean {
	private String passenger;
	private int age;
	private int seatno;
	private Date bookingDate;
	private String flightNo;
	private String departure;
	private String arrival;
	private String username;
	
	public PassengerDetailsBean(String passenger, int age, int seatno, Date bookingDate, String flightNo,
			String departure, String arrival, String username) {
		this.passenger = passenger;
		this.age = age;
		this.seatno = seatno;
		this.bookingDate = bookingDate;
		this.flightNo = flightNo;
		this.departure = departure;
		this.arrival = arrival;
		this.username = username;
	}
	public String getPassenger() {
		return passenger;
	}
	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
