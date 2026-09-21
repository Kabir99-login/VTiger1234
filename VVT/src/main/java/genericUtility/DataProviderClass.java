package genericUtility;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider
	public Object[][] provideData() {
		Object obj [][] = new Object[3][4];
		
		obj[0][0]="Salman Khan";
		obj[0][1]=60;
		obj[0][2]="Actor";
		obj[0][3]="TZH";
		
		obj[1][0]="Amir Khan";
		obj[1][1]=61;
		obj[1][2]="Actor";
		obj[1][3]="3Idoits";
		
		obj[2][0]="Shaha rukh Khan";
		obj[2][1]=60;
		obj[2][2]="Actor";
		obj[2][3]="DDLJ";
		
		return obj;
	}
}
