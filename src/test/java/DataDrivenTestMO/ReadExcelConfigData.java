package DataDrivenTestMO;

import lib.ExcelDataConfig;

public class ReadExcelConfigData {

	public static void main(String[] args) {
		
		ExcelDataConfig excel = new ExcelDataConfig("C:\\Selenium\\Testdata.xlsx");
		System.out.println(excel.getData(1, 0, 0));

}
}