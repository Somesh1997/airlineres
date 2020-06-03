package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.FlightOperationBean;
import dao.FlightOperationDao;

/**
 * @author Ankit Shrivastav
 */
public class FlightOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightOperationDao dao;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dao = new FlightOperationDao();
		List<FlightOperationBean> list;
		list=(List<FlightOperationBean>)dao.showFlights();
		request.setAttribute("flightlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("AdminFlightManipulation.jsp");
		rd.forward(request, response);
	}

}
