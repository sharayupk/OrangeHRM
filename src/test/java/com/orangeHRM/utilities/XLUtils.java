package com.orangeHRM.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlFile,String xlSheet) throws Exception
	{
		fis=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlSheet);
		int row=sh.getLastRowNum();
		return row;
		
	}
	
	public static int getCellCount(String xlFile,String xlSheet,int rownum) throws Exception
	{
		fis=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlSheet);
		int row=sh.getLastRowNum();
		int cell=sh.getRow(rownum).getLastCellNum();
		return cell;
		
	}
	
	public static String getCellData(String xlFile,String xlSheet,int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlSheet);
		row=sh.getRow(rownum);
		cell=row.getCell(colnum);
		
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fis.close();
		return data;

	}
	
	public static void setCellData(String xlFile,String xlSheet,int rownum,int colnum,String data) throws IOException
	{
		fis=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlSheet);
		row=sh.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlFile);
		wb.write(fo);		
		wb.close();
		fis.close();
		fo.close();
	}

}
