package genericUtility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int generateRandomNumber() {
		Random r = new Random();
		return r.nextInt();
	}
	
	public int generateRandomNumber(int limit) {
		Random r = new Random();
		return r.nextInt(limit);
	}
	
	public String generateCurrentDate() {
		Date d = new Date();
		SimpleDateFormat sif = new SimpleDateFormat("yyyy-MM-dd");
		return sif.format(d);
		
		/*
		 * LocalDate l = LocalDate.now();
		 * return l.toString();*/
	}
	
	public String generateSpecificDate(String by, int diff) {
		LocalDate l = LocalDate.now();
		if(by.equalsIgnoreCase("Days") && diff>0)
			return l.plusDays(diff).toString();
		else if(by.equalsIgnoreCase("Days") && diff<0)
			return l.minusDays(diff).toString();
		else if(by.equalsIgnoreCase("Months") && diff>0)
			return l.plusMonths(diff).toString();
		else if(by.equalsIgnoreCase("Months") && diff<0)
			return l.minusMonths(diff).toString();
		else if(by.equalsIgnoreCase("years") && diff>0)
			return l.plusYears(diff).toString();
		else if(by.equalsIgnoreCase("years") && diff<0)
			return l.minusYears(diff).toString();
		else
			return l.toString();
		
	}
}
