package excel.tests;

import com.excel.lib.util.Xls_Reader;

public class ExcelUtilityTest {

	public static void main(String[] args) {
		Xls_Reader reader= new Xls_Reader("./src/main/java/com/excel/lib/util/Excel Worksheet.xlsx");
        
		String sheetname="login1";
		String data=reader.getCellData(sheetname, 0, 2);
		System.out.println(data);
		
		int rowcount=reader.getRowCount(sheetname);
		System.out.println("total rows: "+rowcount);
		//reader.addColumn(sheetname, "status");
		
		//reader.addSheet("sheet1");
		if(! reader.isSheetExist("sheet1")) {
			reader.addSheet("sheet1");
		}
		
		reader.setCellData(sheetname, "status", 2, "pass");
		System.out.println(reader.getCellData(sheetname, "UserName", 3));
		reader.getColumnCount(sheetname);
		//reader.removeColumn("sheet1", 0);
		
		System.out.println(reader.getCellData("sheet1", "phonenumber", 2));
		System.out.println(reader.getCellData("sheet1", "Age", 2));
	}

}
