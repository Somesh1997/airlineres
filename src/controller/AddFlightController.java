package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddFlightBean;
import dao.AddFlightDao;

/**
 * Servlet implementation class AddFlightController
 */
public class AddFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddFlightBean bean;
	private AddFlightDao dao;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flightno = request.getParameter("flightNo");
		String flightName = request.getParameter("flightName");
		int routeID = Integer.parseInt(request.getParameter("routeID"));
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int cost = Integer.parseInt(request.getParameter("costDetails"));
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String departure = request.getParameter("departure");
		String arrival = request.getParameter("arrival");
		String duration = request.getParameter("duration");
		int result = 0;
		
		dao = new AddFlightDao();
		
		if(dao.checkExistingRoute(source, destination) == 0) {
			bean = new AddFlightBean(flightno, flightName, routeID, capacity, cost, source, destination, departure, arrival, duration);
			result = dao.addNewFlight(bean);
			if(result == 2) {
				request.setAttribute("addres", "Success");
				RequestDispatcher rd = request.getRequestDispatcher("AdminDashboard.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("addresfail", "Fail");
				RequestDispatcher rd = request.getRequestDispatcher("AdminDashboard.jsp");
				rd.forward(request, response);
			}
		}
		else {
			//Else ka logic likhna hai
			
		}
	}

}
