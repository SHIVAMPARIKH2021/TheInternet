package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization {
	
	Sheet sheet;
	Workbook workbook;
	public Object[][] testData(String sheetName) {
		FileInputStream dataFile=null;
		try {
			dataFile = new FileInputStream(CommonUtil.currentDirectory+"\\OrangHRMDetails.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
	return data;
	}
	
	public static void main(String args[]) {
		Parameterization params = new Parameterization();
		params.testData("Sheet1");
	}
}
