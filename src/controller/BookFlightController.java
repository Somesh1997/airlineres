package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookFlightBean;
import dao.BookFlightDao;

/**
 * @author Ankit Shrivastav
 */
public class BookFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookFlightBean bean;
	BookFlightDao dao;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category_cost = 0;
		int cost = 0;
		int total_fare = 0;
		int pass = Integer.parseInt(request.getParameter("passengers"));
		String temp_date = request.getParameter("date");
		temp_date = temp_date.replace("/", "-");
		Date date = Date.valueOf(temp_date);
		String category = request.getParameter("category");
		String flightNo = request.getParameter("flightno");
		
		if(category.equals("business"))
			category_cost = 1500;
		else if(category.equals("premium"))
			category_cost = 900;
		else
			category_cost = 200;
		
		dao = new BookFlightDao();
		cost = dao.getCost(flightNo);
		total_fare = (cost + category_cost)* pass;
		
		request.setAttribute("date", date);
		request.setAttribute("passengers", pass);
		request.setAttribute("category", category);
		request.setAttribute("fare", total_fare);
		request.setAttribute("flight", flightNo);
		RequestDispatcher rd = request.getRequestDispatcher("BookFlights.jsp");
		rd.forward(request, response);
	}

}
