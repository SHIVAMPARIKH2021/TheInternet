package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet{
	static Workbook work;
    static Sheet sheet;
//Step-1: creating method with 2D Object Array because 
//a) my excelsheet'd data can have any datatype wich object array can handel	
//b) these data will be in rows and columns so 2D array is only option
//c) For patameterization @Dataprovider can have only objet array
	
	public static Object[][] readdata(String sheetname){
		
//Using 'FileInputStream' with its reference variable 'file' so that JVM can open my excel file 
		FileInputStream file = null;
//I can write FileInputStream file = new FileInputStream("path of file") but
//I am keeping it null because in my try..catch..block I want only 'file' variabel
		try {
		file=new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\HRManagement\\src\\test\\java\\testdata\\OrangHRMDetails.xlsx");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//Step-2: Allowing JVM to create .xlsx file in its own readable formate(xls or xlsx) so that JVM can read data of my exel workbook
//a) 'WorkbookFacotry' is a class whose method 'create()' will create a readable format for JVM
//b) 'Workbook' is an interface through which is 'IMPLEMENTED' by 'WorkbookFactory' so that JVM can create a readable format(xls or xlsx) of .xlsx
//declaring 'work' as global variable
//c) 'Workbook' interface will be implemented by two classes only 
//1>: HSSFWorkbook for older version of MSExell to read/write data
//2>: XSSFWorkbook for 2007 version and version after 2007 of MSExcell to read/write data 
//Whenever dealing with external files, use try...catch...always
	try {
		work =	WorkbookFactory.create(file); 
	}
	 catch (IOException a) {
		a.printStackTrace();
	}
//Step-3: Allwoing SELENIUM to read data of my WORKSHEET which is in my WORKBOOK(Telling SELENIUM to fetch my WorkSheet from my WORKBOOK)
//getSheet() is the method of interface 'Workbook'
//'sheetname' parameter of method getSheet() is actually the parameter of my method readdata()
//Here 'Sheet' is the interface(apache.poi.ss) through which SELENIUM will fectch my worksheet's data (THIS WILL FETCH MY WHOLE WORKSHEET!!) 
//'Sheet' has some methods to maniuplate my data within the ExcelSheet
//'sheet' is the reference variable for interface 'Sheet' (declaring 'sheet' as global variable)
//I want to store this data in new Object[][] as 'result'

	sheet = work.getSheet(sheetname);
	Object[][] result = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
//Step-4: Allowing SELENIUM to fetch data one by one from my 'result 2D Object Array'
//For this I am using "for loop" because it is the only way to get data one by one from 2D Array
//Here I am using 'nested for loop' one for Rows and one for Columns
	
	for(int i=0;i<sheet.getLastRowNum();i++) {
		
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			result[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	
return result;

	}
}
