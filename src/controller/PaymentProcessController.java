package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.PaymentProcessBean;
import dao.BookFlightDao;
import dao.PaymentProcessDao;
import util.CurrentDate;
import util.GeneratePNR;
import util.GenerateSeatNumber;

/**
 * @author Ankit Shrivastav
 */
public class PaymentProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		int cost = 0;
		String category = "";
		List<PaymentProcessBean> mylist = new ArrayList<>();
		String PNR = String.valueOf(GeneratePNR.PNR());
		int passengers = Integer.parseInt(request.getParameter("passengers"));
		String temp_date = request.getParameter("date");
		Date journey_date = Date.valueOf(temp_date);
		String flightNo = request.getParameter("flightno");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("uname");
		BookFlightDao dao = new BookFlightDao();
		cost = dao.getCost(flightNo);
		
		if(request.getParameter("category").equals("economy")) {
			category = "E";
			cost = cost+200;
		}
		else if(request.getParameter("category").equals("business")) {
			category = "B";
			cost = cost+1500;
		}
		else {
			category = "P";
			cost = cost+900;
		}
		
		//getting the seat number for each passenger
		int[] seats = new int[passengers];
		seats = GenerateSeatNumber.allotedSeats(flightNo, journey_date, passengers);
		
		
		for (int i = 1; i <= passengers; i++) {
			PaymentProcessBean bean = new PaymentProcessBean();
			bean.setPNR(PNR);
			bean.setBookingDate(CurrentDate.Today());
			bean.setJourneyDate(journey_date);
			bean.setAmount(cost);
			bean.setPassengerName(request.getParameter("firstName"+i));
			bean.setAge(Integer.parseInt(request.getParameter("age"+i)));
			bean.setCategory(category);
			bean.setFlightNo(flightNo);
			bean.setUserName(username);
			bean.setSeatNo(seats[i-1]);
			mylist.add(bean);
		}
		
		PaymentProcessDao newdao = new PaymentProcessDao();
		result = newdao.insertBookingDetails(mylist);
		
		if(result > 0) {
		request.setAttribute("result", "Success");
		RequestDispatcher rd = request.getRequestDispatcher("CustomerDashboard.jsp");
		rd.forward(request, response);
		}
	}

}
