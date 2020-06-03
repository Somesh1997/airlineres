package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PassengerDetailsBean;
import dao.PassengerDetailsDao;

/**
 * Servlet implementation class PassengerDetailsController
 */
public class PassengerDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PassengerDetailsDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dao = new PassengerDetailsDao();
		List<PassengerDetailsBean> mylist = dao.showPassengersDetails();
		request.setAttribute("details", mylist);
		RequestDispatcher rd = request.getRequestDispatcher("PassengerDetails.jsp");
		rd.forward(request, response);
	}


}
