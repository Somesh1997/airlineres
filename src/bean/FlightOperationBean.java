package bean;

public class FlightOperationBean {
	private int routeId;
	private String flightno;
	private int capacity;
	private String source;
	private String departure;
	private String destination;
	private String arrival;
	private String duration;
	private int cost;
	
	
	public FlightOperationBean(int routeId, String flightno, int capacity, String source, String departure,
			String destination, String arrival, String duration, int cost) {
		
		this.routeId = routeId;
		this.flightno = flightno;
		this.capacity = capacity;
		this.source = source;
		this.departure = departure;
		this.destination = destination;
		this.arrival = arrival;
		this.duration = duration;
		this.cost = cost;
	}
	public FlightOperationBean()
	{
		
	}
	
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
