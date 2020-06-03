package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.FlightActionBean;
import dao.FlightActionDao;

/**
 * Servlet implementation class FlightActionController
 */
public class FlightActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightActionDao dao;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FlightActionBean bean;
		String res = request.getParameter("frs");
		String flightno = request.getParameter("flightno");
		if(res.equals("modify")) {
			dao = new FlightActionDao();
			bean = dao.showFlightDetail(flightno);
			request.setAttribute("flightmodify", bean);
			RequestDispatcher rd = request.getRequestDispatcher("AdminChanges.jsp");
			rd.forward(request, response);
		}
		else {
			dao = new FlightActionDao();
			if(dao.deleteFlight(flightno) == 1) {
				request.setAttribute("res", "success");
				RequestDispatcher rd = request.getRequestDispatcher("AdminDashboard.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

}
