package com.ninja.test.qa;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicEmailMethod {
	public static final int implicitWaitTime = 10; 
	public static final int pageLoadtimeOut = 10; 
	
	public static String createEmailDynamically() {
		Date d = new Date();
		String main = d.toString().replace(" ", "_").replace(":","_"); 
		return "poojankhatri"+main+"@gmail.com";
	}
	
	
	public static Object[][] getDataFromTheExcel(String sheetName) {
		File excelfile = new File(System.getProperty("user.dir") + "//src//main//java//com//tutorialninja//qa//config//TutorialsNinjaTestData.xlsx");
		XSSFWorkbook workbook = null; 
		try {
			FileInputStream fls = new FileInputStream(excelfile); 
			 workbook = new XSSFWorkbook(fls); 
		}catch(Exception e) {
		   e.printStackTrace(); 
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows  = sheet.getLastRowNum();
		int cols =  sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object [rows][cols]; 
		
		for(int i = 0; i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1); 
			for(int j =0; j<cols; j++) {
				XSSFCell cell = row.getCell(j); 
				CellType celltype = cell.getCellType();
				
				switch(celltype) {
				case STRING: 
					data[i][j] = cell.getStringCellValue();
					break; 
				case NUMERIC: 
					data[i][j] = Integer.toString((int)cell.getNumericCellValue()); 
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue(); 
					break; 
				}
			}
		}
		
		return data; 
	}
	
	
}
