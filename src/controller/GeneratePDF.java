package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GenerateTicketBean;
import util.DBUtil;
/**
 * Servlet implementation class GeneratePDF
 */
public class GeneratePDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pnr = request.getParameter("pnr");
		sendRequest(request, response, pnr);	
	}
	
	public static void sendRequest(HttpServletRequest req, HttpServletResponse res, String pnr) throws ServletException, IOException {
		Connection conn = null;
		ArrayList<String> source = new ArrayList<>(); 
		ArrayList<String> destination = new ArrayList<>(); 
		ArrayList<String> departure = new ArrayList<>(); 
		ArrayList<String> arrival = new ArrayList<>(); 
		ArrayList<GenerateTicketBean> mylist = new ArrayList<>(); 
		int count = 0;
		
		try {
			conn = DBUtil.ConnectionManager();
			PreparedStatement ps = conn.prepareStatement(" SELECT B.PASSENGER_NAME,S.SOURCE,S.DESTINATION,F.DEPARTURE_TIME,F.ARRIVAL_TIME,F.FLIGHT_NO,B.SEAT_NO,B.AGE,B.PNR FROM  FRS_TBL_FLIGHT_DETAILS F,FRS_TBL_BOOKING_PAGE B,FRS_TBL_SECTOR S WHERE B.FLIGHT_NO=F.FLIGHT_NO AND S.ROUTE_ID=F.ROUTE_ID AND B.STATUS = ? AND B.PNR = ?");
			ps.setString(1, "upcoming");
			ps.setString(2, pnr);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				source.add(rs.getString("source"));
				destination.add(rs.getString("destination"));
				departure.add(rs.getString("departure_time"));
				arrival.add(rs.getString("arrival_time"));
				mylist.add(new GenerateTicketBean(rs.getString("passenger_name"), rs.getInt("age"), rs.getString("flight_no"), rs.getString("pnr"), rs.getInt("seat_no")));
				count++;
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("Exception in doGet function");
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				System.out.println("Exception in closing function");
			}
		}
		if(count <= 0) {
			req.setAttribute("ress","notfound");
			RequestDispatcher rd = req.getRequestDispatcher("WebCheckin.jsp");
			rd.forward(req, res);
		}
		else {
			req.setAttribute("pnr", pnr);
			req.setAttribute("source", source);
			req.setAttribute("destination", destination);
			req.setAttribute("departure", departure);
			req.setAttribute("arrival", arrival);
			req.setAttribute("mylist", mylist);
			RequestDispatcher rd = req.getRequestDispatcher("ticketGenerator.jsp");
			rd.forward(req, res);
		}
	}

}
