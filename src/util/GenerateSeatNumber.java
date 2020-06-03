package util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.GenerateSeatNumberDao;

public class GenerateSeatNumber {

	public static int[] allotedSeats(String flightNo, Date journeyDate, int passengers) {
		// TODO Auto-generated method stub
		List<Integer> slist = new ArrayList<Integer>();
		GenerateSeatNumberDao dao = new GenerateSeatNumberDao();
		slist = dao.getFilledSeats(flightNo, journeyDate);
		
		int j = 0;
		int no = passengers;
		int[] seats = new int[passengers];
		int[] totalseats = new int[40];
		
		//Loop for making all the values inside totalseats array to 0 (default condition)
		for (int i = 0; i < totalseats.length; i++) {
			totalseats[i] = 0;
		}
		
		//for each loop for checking the value inside the list and assigning 1 to totalseats array at that position
		if(!slist.isEmpty()) {
			for (Integer i : slist) {
				totalseats[i-1] = 1;
			}
		}
		
		//Loop for assigning the seat to each individual passenger
		for (int i = 0; i < totalseats.length; i++) {
			if(totalseats[i] == 0 && no > 0) {
				seats[j] = i+1;
				j++;
				no--;
			}
		}
		
		return seats;
	}

}
