package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains reusable methods to perform action excel file
 * @author srisr
 *
 */

public class ExcelUtility 
{
private Workbook wb;

/**
 * this method is used to initialize the excel file
 * @param excelpath
 */

public void execelIntialization(String excelpath)
{
	FileInputStream fis = null;
	try
	{
		fis = new FileInputStream(excelpath);
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	try
	{
		wb=WorkbookFactory.create(fis);
		
	}
	catch(EncryptedDocumentException | IOException e)
	{
		e.printStackTrace();
	}
	
}
/**
 * this method is used to read single data from excel
 * @param sheetName
 * @param rownum
 * @param cellNum
 * @return
 */
public String readdatafromexcel(String sheetName ,int rownum,int cellNum)
{
	
	return wb.getSheet(sheetName).getRow(rownum).getCell(cellNum).getStringCellValue();
}

/**
 * this method is used to read multilple data from excel file
 * @param sheetName
 * @return
 */

public List<String> readDataFromExcel(String sheetName)
{
	Sheet sh=wb.getSheet(sheetName);
	List<String> datalist=new ArrayList<>();
	
	for (int i=0;i<= sh.getLastRowNum();i++) 
	{
		datalist.add(sh.getRow(i).getCell(1).getStringCellValue());
		
	}
	return datalist;
}
/**
 * this method is used to close the excel workbook
 */

public void closeexcel()
{
	try
	{
		wb.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}

}
