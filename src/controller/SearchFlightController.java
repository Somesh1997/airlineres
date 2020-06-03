package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SearchFlightsBean;
import dao.SearchFlightsDao;

/**
 * @author Ankit Shrivastav
 * @version 1.6.0
 */
public class SearchFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SearchFlightsBean bean;
	SearchFlightsDao dao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from = request.getParameter("from");
		String to = request.getParameter("too");
		
		String temp_date = request.getParameter("departure");
		temp_date.replace("/", "-");
		Date date = Date.valueOf(temp_date);
		
		int passengers = Integer.parseInt(request.getParameter("passengers"));
		String category = request.getParameter("class");
		
		bean = new SearchFlightsBean(from, to, date, passengers, category);
		
		dao = new SearchFlightsDao();
		
		List<SearchFlightsBean> myList = dao.getFlightsDetails(bean);
		if(!myList.isEmpty()) {
		
		request.setAttribute("date", date);
		request.setAttribute("passengers", passengers);
		request.setAttribute("category", category);
		request.setAttribute("flightsInfo", myList);
		RequestDispatcher rd = request.getRequestDispatcher("FlightDetails.jsp");
		rd.forward(request, response);
		}
		else {
			//no records found code to be written here
		}
	}

}
