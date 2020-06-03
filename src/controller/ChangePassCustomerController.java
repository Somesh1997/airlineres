package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ChangePassCustomerBean;
import dao.ChangePassCustomerDao;

/**
 * @author Ankit Shrivastav
 * @version 1.6.0
 */
public class ChangePassCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChangePassCustomerDao dao;
	private ChangePassCustomerBean bean;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		dao = new ChangePassCustomerDao();
		bean = new ChangePassCustomerBean();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("uname");
		String pass = request.getParameter("password");
		String npass = request.getParameter("npassword");
		String cpass = request.getParameter("cpassword");
		
		bean.setUsername(username);
		bean.setOldPass(pass);
		bean.setNewPass(npass);
		bean.setConfirmNewPass(cpass);
		
		if(session.getAttribute("uname") != null) {
			
			if(dao.CheckOldPassword(bean) == 1) {
				System.out.println("In if of old pass");
				if(npass.equals(cpass)) {
					System.out.println("In if of check new and confirm new pass");
						if(dao.updateNewPassword(bean) == 1) {
							System.out.println("In if of update pass");
							request.setAttribute("success", "Password changed succcessfully");
							RequestDispatcher rd = request.getRequestDispatcher("ChangePasswordCustomer.jsp");
							rd.forward(request, response);
						}
						else {
								request.setAttribute("error", "Can't Update password. Please try after some time");
								RequestDispatcher rd = request.getRequestDispatcher("ChangePasswordCustomer.jsp");
								rd.forward(request, response);
						}		
					}
					else {
						request.setAttribute("mismatch", "New and confirm password does not match");
						RequestDispatcher rd = request.getRequestDispatcher("ChangePasswordCustomer.jsp");
						rd.forward(request, response);
					}
			}
			else {
				request.setAttribute("oldPass", "Old password not valid");
				RequestDispatcher rd = request.getRequestDispatcher("ChangePasswordCustomer.jsp");
				rd.forward(request, response);
			}
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}

}
