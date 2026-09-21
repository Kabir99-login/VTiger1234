package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int genRandomNumber() {
		Random r = new Random();
		return r.nextInt();
	}
	
	public String currentDate() {
		Date d =new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		return sim.format(d);
	}
}
