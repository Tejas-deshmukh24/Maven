package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Org_ContactExcelUtility {
	
public String getDataFromExcel(String sheetName, int rowNum , int celNum) throws Throwable{
		
		FileInputStream fis=new FileInputStream("./TestData/orgcontact.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;	
	}
		
    public int getRowcount(String sheetName) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./TestData/orgcontact.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
			
	}
	
   public void setDataIntExcel(String sheetName , int rowNum , int celNum , String data) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./TestData/orgcontact.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.createSheet(sheetName).createRow(rowNum).createCell(celNum).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("./TestData/orgcontact.xlsx");
		wb.write(fos);
		wb.close();		
	}
	
}



