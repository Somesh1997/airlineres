package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeneratePNR {
	
	public static int PNR() {
        int ticketPNR = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        ticketPNR = Integer.parseInt(dtf.format(now));
        return ticketPNR;
    }
	
}
