package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AdminChangesBean;
import dao.AdminChangesDao;

/**
 * Servlet implementation class AdminChangesController
 */
public class AdminChangesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flightno = request.getParameter("flightName");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int cost = Integer.parseInt(request.getParameter("costDetails"));
		String departure = request.getParameter("departure");
		String arrival = request.getParameter("arrival");
		String duration = request.getParameter("duration");
		System.out.println(flightno+" - "+capacity+" - "+cost+" - "+departure+" - "+arrival+" - "+duration);
		int result = 0;
	    AdminChangesDao dao = new AdminChangesDao();
	    
	    AdminChangesBean bean = new AdminChangesBean(flightno, capacity, cost, departure, arrival, duration);
		result = dao.updateFlightInfo(bean);
		if(result == 1) {
			request.setAttribute("updateres", "Success");
			RequestDispatcher rd = request.getRequestDispatcher("AdminDashboard.jsp");
			rd.forward(request, response);
		}
		else {
			
		}
	}

}
