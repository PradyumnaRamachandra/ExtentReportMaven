package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelSheetTest {
	
	@Test
	public void demo() throws Exception {
		
		String path="./TestData/TestData.xlsx";
		FileInputStream fis=new FileInputStream(new File(path));
		
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Data");
		
		int row=sheet.getPhysicalNumberOfRows();
		int col=sheet.getRow(0).getPhysicalNumberOfCells();
		
		int execute_count=0;
		int dataProvider_index=0;
		
		//Iterating to get the execute column count
		for(int i=1;i<row;i++) {
			if(sheet.getRow(i).getCell(col-1).getStringCellValue().equalsIgnoreCase("yes")) {
				
				execute_count++;
			}
			
		}
		
		if(!(execute_count==0)) {
				
			
				Object[][] data=new Object[execute_count][col-1];
				
				for(int i=1;i<row;i++) {
					
					if(sheet.getRow(i).getCell(col-1).getStringCellValue().equalsIgnoreCase("yes")) {
						for(int j=0;j<=col-2;j++) {
							
							data[dataProvider_index][j]=sheet.getRow(i).getCell(j).toString();
							
						}	
						dataProvider_index++;
					}
					
				}
			
		}
		else {
			System.out.println("No rows selected for Executed ");
		}
		
	}

}
