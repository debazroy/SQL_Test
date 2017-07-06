package ExcelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
	@Test
	public void ExcelConnection() throws Exception {
			File src = new File ("C:\\EclipseJava\\Book1.xlsx");
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh1 = wb.getSheetAt(0);
			int rowLength = sh1.getLastRowNum();
			for (int i=0; i<rowLength+1; i++) {
				String data = sh1.getRow(i).getCell(1).getStringCellValue();
			System.out.println(data);
			}
			
	FileOutputStream fout = new FileOutputStream(src);
	sh1.getRow(1).createCell(4).setCellValue(true);
	sh1.getRow(1).createCell(4).setCellValue(false);
	wb.write(fout);
	fout.close();
	wb.close();
	}	
}
