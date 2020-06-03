package util;

import java.sql.Date;

public class CurrentDate {
	public static Date Today() {
		long millis=System.currentTimeMillis();  
		Date date=new Date(millis);  
		return date; 
	}
}
