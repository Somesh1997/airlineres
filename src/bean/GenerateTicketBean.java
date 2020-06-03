package bean;

public class GenerateTicketBean {
	
	private String name;
	private int age;
	private String airlineNo;
	private String pnr;
	private int seatNo;
	public GenerateTicketBean(String name, int age, String airlineNo, String pnr, int seatNo) {
		this.name = name;
		this.age = age;
		this.airlineNo = airlineNo;
		this.pnr = pnr;
		this.seatNo = seatNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAirlineNo() {
		return airlineNo;
	}
	public void setAirlineNo(String airlineNo) {
		this.airlineNo = airlineNo;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	
}
