package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SignUpBean;
import service.SignUpFilter;

/**
 * @author Ankit Shrivastav
 * @version 1.1.0
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;

		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String username = request.getParameter("username");
		long mobile = Long.parseLong(request.getParameter("mobile").toString());
		String email = request.getParameter("email");

		//Handling Date for java.sql
		String temp_dob =  request.getParameter("dob");
		temp_dob = temp_dob.replace("/", "-");
		Date dob = Date.valueOf(temp_dob);
		//Handling completed and stored in dob
		
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");

		if (!password.equals(cpassword)) {
			response.sendRedirect("SignUp.jsp");
		}

		SignUpBean bean = new SignUpBean();
		bean.setFirst_name(fname);
		bean.setLast_name(lname);
		bean.setUser_name(username);
		bean.setMobile(mobile);
		bean.setEmail(email);
		bean.setDob(dob);
		bean.setGender(gender);
		bean.setPassword(password);

		SignUpFilter filter = new SignUpFilter();
		try {
			result = filter.insertData(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 1) {
			response.sendRedirect("Login.jsp");
		} else {
			response.sendRedirect("SignUp.html");
		}
	}

}
