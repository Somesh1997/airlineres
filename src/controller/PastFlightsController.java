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

import bean.PastFlightsBean;
import dao.PastFlightsDao;

/**
 * Servlet implementation class PastFlightsController
 */
public class PastFlightsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<PastFlightsBean> mylist = new ArrayList<PastFlightsBean>();
		PastFlightsBean bean = new PastFlightsBean();
		PastFlightsDao dao = new PastFlightsDao();
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("uname");
		bean.setUsername(user);
		mylist = dao.getPastFlights(user);
		
		if(!mylist.isEmpty()) {
			request.setAttribute("past", mylist);
			RequestDispatcher rd = request.getRequestDispatcher("PastJourney.jsp");
			rd.forward(request, response);
			}
			else {
				request.setAttribute("yuva", "No");
				RequestDispatcher rd = request.getRequestDispatcher("PastJourney.jsp");
				rd.forward(request, response);
			}
		
	}

}
