package test.lijing.stockData.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lijing.stockData.system.dao.StockDataDao;
import com.lijing.stockData.system.model.StockData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
public class TestStrockDataDAO {
	@Autowired
	private StockDataDao stockDataDAO;
	//测试获取数据总量
	@Test
	public void testFindCount()
	{
		long count = stockDataDAO.findCount("select count(*) from StockData");
		System.out.println(count);
	}
	
	//测试按照名称查找股票数据
	@Test
	public void testFindDataByStockName()
	{
		List<StockData> stockList = stockDataDAO.findDataByStockName("from StockData where stockName=?", new String[] {"江淮汽车"});
	}
	
//	//测试全表删除
//	@Test
//	public void testDeleteAll()
//	{
//		stockDataDAO.deleteAll();
//	}
	
	//测试查找所有数据
	@Test
	public void testFindAllExcelData()
	{
		List<StockData> stockDataList = stockDataDAO.findAllExcelData();
		for(StockData stockData:stockDataList)
		{
			System.out.println(stockData.getTotalAmount());
		}
	}
	
	//测试分页查找
	@Test
	public void testPagedQuery()
	{
		List<StockData> stockDataList = stockDataDAO.findStockPageList(2, 10);
		System.out.println("…………………………………………");
		for(StockData stockData:stockDataList)
		{
			System.out.println(stockData.getTotalAmount());
		}
		System.out.println("…………………………………………");
	}
	
	@Test
	public void testListToString()
	{
		/*测试代码*/
		List<Map<String, String>> listStock = new ArrayList<Map<String, String>>();
		Map<String, String> stock;
		for (int i = 0; i < 10; i++) {
			stock = new HashMap<String, String>();
			stock.put("stockName", "名称" + i);
			stock.put("stockCode", "60066" + i);
			stock.put("tradeData", "2014-12-" + i);
			stock.put("strikePrice", "1.00");
			stock.put("strikeNum", "100.00");
			stock.put("totalAmount", "-457.0" + i);
			stock.put("accountBalance", i + "446.00");
			stock.put("bussinessName", "证券买入");
			stock.put("fees", "5.00");
			stock.put("stampTax", "0.00");
			stock.put("transferFee", "1.00");
			stock.put("closingCost", "0.00");
			listStock.add(stock);
		}
		System.out.println(listStock.toString());
		
	}

	
}
