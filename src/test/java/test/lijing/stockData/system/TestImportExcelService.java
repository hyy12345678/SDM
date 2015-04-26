package test.lijing.stockData.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lijing.stockData.system.service.ProcessImportExcelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContextTest.xml")
public class TestImportExcelService {
	@Autowired
	private ProcessImportExcelService processImportExcelService;
	@Test
	public void testImportExcel() throws FileNotFoundException
	{
		File file = new File("D:\\股票分析\\1.xls");
		if (file.exists())
		{
			
		}
		InputStream excelFile = new FileInputStream(file);
		processImportExcelService.processExcel(excelFile);
	}

}
