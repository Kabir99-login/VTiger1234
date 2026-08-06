package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public FileInputStream fis;
	public int totalNumberOfRows(String sheetName) throws Exception {
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.close();
		
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	
	public int totalNumberOfColumns(String sheetName) throws Exception{
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.close();
		
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}
	
	public String readDataFromExcel(String sheetName,int row,int cell) throws Exception {
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		return wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
	}
	
	public void setCellDataInExcel(String sheetName,int row,int cell,String value) throws Exception {
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream("./src/test/resoutces/TestData.xlsx");
		wb.write(fos);
		
		wb.close();
		
	}
	
	public void updateCellDataInExcel(String sheetName,int row,int cell,String value) throws Exception {
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream("./src/test/resoutces/TestData.xlsx");
		wb.write(fos);
		
		wb.close();
	}
}
