package util;

public interface DBQueries {
	String INSERT_SIGNUP = "INSERT into frs_tbl_signup (FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD, EMAIL, DOB, GENDER, ISADMIN, MOBILE_NO) values(?,?,?,?,?,?,?,?,?)";
	String LOGIN = "SELECT FIRST_NAME, LAST_NAME, ISADMIN from frs_tbl_signup where user_name = ? and password = ?";
	String CHECK_LOGIN_CUSTOMER_ADMIN = "SELECT * from frs_tbl_signup where user_name = ? and password = ?";
	String UPDATE_PASSWORD = "UPDATE frs_tbl_signup set password = ? where user_name = ?";
	String FETCH_FLIGHTS = "SELECT F.FLIGHT_NO,F.FLIGHT_NAME,S.SOURCE,F.DEPARTURE_TIME,S.DESTINATION,F.ARRIVAL_TIME,F.DURATION,F.COST FROM FRS_TBL_FLIGHT_DETAILS F,FRS_TBL_SECTOR S WHERE F.ROUTE_ID=S.ROUTE_ID AND S.SOURCE=? AND S.DESTINATION=?";
	String GET_COST_OF_FLIGHT = "SELECT COST FROM FRS_TBL_FLIGHT_DETAILS WHERE FLIGHT_NO = ?";
	String GET_FILLED_SEATS = "SELECT SEAT_NO FROM FRS_TBL_BOOKING_PAGE WHERE JOURNEY_DATE = ? AND FLIGHT_NO = ? AND STATUS = ?";
	String INSERT_BOOKING_DETAILS = "INSERT INTO FRS_TBL_BOOKING_PAGE (BOOKING_ID, PNR, BOOKING_DATE, JOURNEY_DATE, AMOUNT, PASSENGER_NAME, AGE, C_ID, FLIGHT_NO, USER_NAME, SEAT_NO, STATUS) values(BOOKING_ID.nextval,?,?,?,?,?,?,?,?,?,?,?)";
	String UPCOMING_FLIGHTS = "SELECT B.PASSENGER_NAME,F.FLIGHT_NO,B.PNR,R.SOURCE,R.DESTINATION,B.BOOKING_ID,F.ARRIVAL_TIME,F.DEPARTURE_TIME,F.DURATION,B.JOURNEY_DATE FROM FRS_TBL_FLIGHT_DETAILS F,FRS_TBL_BOOKING_PAGE B,FRS_TBL_SECTOR R WHERE R.ROUTE_ID=F.ROUTE_ID AND F.FLIGHT_NO=B.FLIGHT_NO AND USER_NAME= ? AND STATUS = 'upcoming' ORDER BY JOURNEY_DATE";
	String UPDATE_STATUS = "update frs_tbl_booking_page set status = 'cancel' where booking_id=?";
	String PAST_FLIGHTS= "SELECT B.PASSENGER_NAME,F.FLIGHT_NO,B.PNR,R.SOURCE,R.DESTINATION,B.BOOKING_ID,F.ARRIVAL_TIME,F.DEPARTURE_TIME,F.DURATION,B.JOURNEY_DATE FROM FRS_TBL_FLIGHT_DETAILS F,FRS_TBL_BOOKING_PAGE B,FRS_TBL_SECTOR R WHERE R.ROUTE_ID=F.ROUTE_ID AND F.FLIGHT_NO=B.FLIGHT_NO AND USER_NAME= ? AND STATUS = 'cancel' ORDER BY JOURNEY_DATE desc";
	String SHOW_FLIGHTS = "select f.flight_no,f.capacity,r.source,r.destination,f.duration,f.cost,f.arrival_time,f.departure_time,r.route_id from frs_tbl_flight_details f,frs_tbl_sector r where r.route_id=f.route_id order by r.route_id";
	String VIEW_FLIGHT = "select f.flight_no,f.capacity,r.source,r.destination,f.duration,f.cost,f.arrival_time,f.departure_time,r.route_id from frs_tbl_flight_details f,frs_tbl_sector r where r.route_id=f.route_id and f.flight_no = ? ";
	String SELECT_SOURCE = "select distinct source from frs_tbl_sector";
	String SELECT_DESTINATION = "select distinct destination from frs_tbl_sector";
	String CHECK_ROUTES = "select * from frs_tbl_sector where source = ? and destination = ?";
	String ADD_FLIGHT = "insert into frs_tbl_flight_details values (?,?,?,?,?,?,?,?)";
	String ADD_FLIGHT_SECTORS = "insert into frs_tbl_sector values(?,?,?)";
	String VIEW_PASSENGER_DETAILS = "SELECT B.PASSENGER_NAME,B.AGE,B.SEAT_NO,B.BOOKING_DATE,F.FLIGHT_NO,F.ARRIVAL_TIME,F.DEPARTURE_TIME,B.USER_NAME FROM FRS_TBL_FLIGHT_DETAILS F,FRS_TBL_BOOKING_PAGE B WHERE F.FLIGHT_NO=B.FLIGHT_NO and B.STATUS=?";
	String DELETE_FLIGHT = "delete from frs_tbl_flight_details where flight_no = ?";
	String FIND_SRC_DEST = "SELECT SOURCE, DESTINATION FROM FRS_TBL_SECTOR WHERE ROUTE_ID = ?";
	String UPDATE_FLIGHT_INFO = "update frs_tbl_flight_details set duration = ?, departure_time = ?, arrival_time = ?, capacity = ?, cost = ? where flight_no = ?";
}

 