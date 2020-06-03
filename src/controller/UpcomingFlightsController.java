package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UpcomingFlightsBean;
import dao.UpcomingFlightsDao;

/**
 * Servlet implementation class UpcomingFlightsController
 */
public class UpcomingFlightsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<UpcomingFlightsBean> mylist = new ArrayList<UpcomingFlightsBean>();
		UpcomingFlightsBean bean = new UpcomingFlightsBean();
		UpcomingFlightsDao dao = new UpcomingFlightsDao();
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("uname");
		bean.setUsername(user);
		mylist = dao.getUpcomingFlights(user);
		
		if(!mylist.isEmpty()) {
		request.setAttribute("upcoming", mylist);
		RequestDispatcher rd = request.getRequestDispatcher("upcomingJourneys.jsp");
		rd.forward(request, response);
		}
		else {
			request.setAttribute("yuva", "No");
			RequestDispatcher rd = request.getRequestDispatcher("upcomingJourneys.jsp");
			rd.forward(request, response);
		}
	}

}
