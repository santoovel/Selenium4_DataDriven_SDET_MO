package DataDrivenTestMO;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static  XSSFWorkbook wb;
	public static XSSFSheet sheet1;
	
	public static void main(String[] args) throws Exception {
		
		File src = new File("C:\\Selenium\\Testdata.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		wb = new XSSFWorkbook(fis);
		sheet1 = wb.getSheetAt(0);
		
		int rowCount =	sheet1.getLastRowNum();
		System.out.println("Total rows is : "+ rowCount+1);
		for(int i =0 ;i< rowCount ; i++) {
			
			String data0=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Test data from Excel is : "+data0);
			
			
		}
		
	
		 
		// String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		 //System.out.println("Data from Excel is : "+ data0);
		 
		 
	//	 String data1 = sheet1.getRow(0).getCell(1).getStringCellValue();
		 //System.out.println("Data from Excel is : "+ data1);
		 //wb.close();
		
		

	}

}
