package bean;

public class AddFlightBean {
	private String flightno;
	private String flightName;
	private int routeID;
	private int capacity;
	private int cost;
	private String source;
	private String destination;
	private String departure;
	private String arrival;
	private String duration;
	
	
	
	public AddFlightBean(String flightno, String flightName, int routeID, int capacity, int cost, String source, String destination,
			String departure, String arrival, String duration) {
		this.flightno = flightno;
		this.flightName = flightName;
		this.routeID = routeID;
		this.capacity = capacity;
		this.cost = cost;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.duration = duration;
	}
	
	
	public AddFlightBean(String flightno, String flightName, int routeID, int capacity, int cost, String departure,
			String arrival, String duration) {
		this.flightno = flightno;
		this.flightName = flightName;
		this.routeID = routeID;
		this.capacity = capacity;
		this.cost = cost;
		this.departure = departure;
		this.arrival = arrival;
		this.duration = duration;
	}

	
	public AddFlightBean() {
	}
	
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	
	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getRouteID() {
		return routeID;
	}
	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
