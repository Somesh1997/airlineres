package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CancelTicketBean;
import dao.CancelTicketDao;

/**
 * Servlet implementation class CancelTicketController
 */
public class CancelTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result = 0;
		int bookid = Integer.parseInt(request.getParameter("bookingid"));
		CancelTicketBean bean = new CancelTicketBean();
		CancelTicketDao dao = new CancelTicketDao();
		bean.setBookingId(bookid);
		
		result = dao.updateStatus(bean.getBookingId());
		if(result > 0) {
			request.setAttribute("cancel", "Canceled");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerDashboard.jsp");
			rd.forward(request, response);
		}
		else {
			//on monday we have to prompt
			request.setAttribute("ncancel", "Ticket not canceled");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerDashboard.jsp");
			rd.forward(request, response);
		}
	}

}
