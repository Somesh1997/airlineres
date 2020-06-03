package bean;

public class AdminChangesBean {
	private String flightNo;
	private int capacity;
	private int cost;
	private String departure;
	private String arrival;
	private String duration;
	
	public AdminChangesBean(String flightNo, int capacity, int cost, String departure, String arrival, String duration) {
		this.flightNo = flightNo;
		this.capacity = capacity;
		this.cost = cost;
		this.departure = departure;
		this.arrival = arrival;
		this.duration = duration;
	}
	
	public AdminChangesBean() {
		
	}
	
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
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
