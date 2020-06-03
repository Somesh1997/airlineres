package bean;

import java.sql.Date;

public class SearchFlightsBean {
	private String from;
	private String to;
	private Date depDate;
	private int noOfPassenger;
	private String category;
	
	private String flightNo;
	private String flightName;
	private String source;
	private String departureTime;
	private String destination;
	private String arrivalTime;
	private String duration;
	private int cost;
	
	public SearchFlightsBean(String from, String to, Date depDate, int noOfPassenger, String category) {
		this.from = from;
		this.to = to;
		this.depDate = depDate;
		this.noOfPassenger = noOfPassenger;
		this.category = category;
	}
	
	public SearchFlightsBean(String flightNo, String flightName, String source, String departureTime, String destination,
			String arrivalTime, String duration, int cost) {
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.source = source;
		this.departureTime = departureTime;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.cost = cost;
	}

	public SearchFlightsBean() {
		
	}

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}
	public int getNoOfPassenger() {
		return noOfPassenger;
	}
	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
