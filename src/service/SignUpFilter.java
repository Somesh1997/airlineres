package service;

import java.sql.SQLException;
import bean.SignUpBean;
import dao.SignUpDao;

public class SignUpFilter {
	public int insertData(SignUpBean bean) throws SQLException
	{
		 int result = 0;
	        
//	        String firstname = bean.getFirst_name();
//	        if (!firstname.matches("[A-Z][a-z]*")) {
//	            result = 0;
//	            //return result;
//	        }
//	        
//	        String lastname = bean.getLast_name();
//	        if (!lastname.matches("[A-Z]+([ '-][a-zA-Z]+)*")) {
//	            result = 0;
//	            //return result;
//	        }
//	        
//	        String email = bean.getEmail();
//	        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//	        if (!email.matches(regex)) {
//	            result = 0;
//	            //return result;
//	        }
//	        
//	        long number = bean.getMobile();
//	        String s = number + "";
//	        Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}");
//
//	        // Pattern class contains matcher() method
//	        // to find matching between given number
//	        // and regular expression
//	        
//	        Matcher m = p.matcher(s);
//	        boolean i = (m.find() && m.group().equals(s));
//	        if (i == false) {
//	            result = 0;
//	            //return result;
//	        }
//	        
//	        String gen = bean.getGender();
//	        gen = gen.toLowerCase();
//	        if (!(gen.equals("Male") || gen.equals("Female"))) {
//	            result = 0;
//	            
//	        }
//	        
//	        if(result!=0)
//	        {
//	            SignUpDao up = new SignUpDao();
//	            result = up.insertData(bean);
//	        }
		 
		SignUpDao dao = new SignUpDao();
		result = dao.insertData(bean);
		
		return result;
	}
}
