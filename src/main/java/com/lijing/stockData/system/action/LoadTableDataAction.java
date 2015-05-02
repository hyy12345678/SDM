package com.lijing.stockData.system.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lijing.stockData.system.model.StockData;
import com.lijing.stockData.system.service.LoadStockDataService;

@Controller
public class LoadTableDataAction {
	@Autowired
	private LoadStockDataService loadStockDataService;

	@RequestMapping(value = "/stockData/getTradingData", method = RequestMethod.POST)
	public void getTradingDataAction(HttpServletRequest request,
			HttpServletResponse response) {
		String jstr = request.getParameter("jstr");
		response.setCharacterEncoding("UTF-8");

		if ("".equals(jstr)|| null==jstr) {

		}
		JSONObject jstrOj = JSONObject.fromObject(jstr);
		// 判断jstr是否为空
		try {
			int page = (Integer) jstrOj.get("page");
			int pageSize = (Integer) jstrOj.get("pageSize");
			int flag = (Integer) jstrOj.get("flag");

			if (page < 0 || pageSize <= 0) {
				// exception
			}
			long pageNumber = loadStockDataService.getPageNumber(pageSize,flag);
			List<StockData> resultList = loadStockDataService
					.getTradingDataService(page, pageSize, flag);
			if (resultList.size() == 0) {
				// branch
			}
			JSONObject oj = new JSONObject();
			oj.put("status", "success");
			oj.put("pageNum", pageNumber);
			oj.put("resultList", resultList);
			PrintWriter out;
			out = response.getWriter();
			out.print(oj.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 获取股票交易
	@RequestMapping(value = "/stockData/getStockData", method = RequestMethod.POST)
	public void getStockDataAction(HttpServletRequest request,
			HttpServletResponse response) {

		String jstr = request.getParameter("jstr");
		response.setCharacterEncoding("UTF-8");

		JSONObject jstrOj = JSONObject.fromObject(jstr);
		// 判断jstr是否为空
		try {
			int page = (Integer) jstrOj.get("page");
			int pageSize = (Integer) jstrOj.get("pageSize");

			if (page < 0 || pageSize <= 0) {
				// exception
			}

			List<StockData> listStock = loadStockDataService
					.getTradingDataService(page, pageSize, 0);
			if (listStock.size() == 0) {
				// branch
			}

			/*
			 * 
			 * List<Map<String, String>> resultList = new ArrayList<Map<String,
			 * String>>(); Map<String, String> stockNode; for (int i = 0; i <
			 * 10; i++) { stockNode = new HashMap<String, String>();
			 * stockNode.put("stockName", "名称" + i); stockNode.put("stockCode",
			 * "60066" + i); stockNode.put("tradeData", "2014-12-" + i);
			 * stockNode.put("strikePrice", "1.00"); stockNode.put("strikeNum",
			 * "100.00"); stockNode.put("totalAmount", "-457.0" + i);
			 * stockNode.put("accountBalance", i + "446.00");
			 * stockNode.put("bussinessName", "证券买入"); stockNode.put("fees",
			 * "5.00"); stockNode.put("stampTax", "0.00");
			 * stockNode.put("transferFee", "1.00");
			 * stockNode.put("closingCost", "0.00"); resultList.add(stockNode);
			 * }
			 */

			/* 测试代码 */
			// for (int i = 0; i < 10; i++) {
			// stock = new HashMap<String, String>();
			// stock.put("stockName", "名称" + i);
			// stock.put("stockCode", "60066" + i);
			// stock.put("tradeData", "2014-12-" + i);
			// stock.put("strikePrice", "1.00");
			// stock.put("strikeNum", "100.00");
			// stock.put("totalAmount", "-457.0" + i);
			// stock.put("accountBalance", i + "446.00");
			// stock.put("bussinessName", "证券买入");
			// stock.put("fees", "5.00");
			// stock.put("stampTax", "0.00");
			// stock.put("transferFee", "1.00");
			// stock.put("closingCost", "0.00");
			// listStock.add(stock);
			// }

			JSONObject oj = new JSONObject();
			oj.put("liststock", listStock);

			PrintWriter out;
			out = response.getWriter();
			out.print(oj.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/stockData/getBankData", method = RequestMethod.POST)
	public void getBankDataAction(HttpServletRequest request,
			HttpServletResponse response) {
		String jstr = request.getParameter("jstr");
		response.setCharacterEncoding("UTF-8");
		try {
			JSONObject jstrOj = JSONObject.fromObject(jstr);
			int page = (Integer) jstrOj.get("page");
			int pageSize = (Integer) jstrOj.get("pageSize");

			List<StockData> listBank = loadStockDataService
					.getTradingDataService(page, pageSize, 1);

			// Map<String, String> stock;
			// for (int i = 0; i < 10; i++) {
			// stock = new HashMap<String, String>();
			// stock.put("bussinessName", "银行转存");
			// stock.put("tradeData", "2014-12-" + i);
			// stock.put("totalAmount", "500.00" + i);
			// stock.put("accountBalance", i + "1446.00");
			// listBank.add(stock);
			// }

			JSONObject oj = new JSONObject();
			oj.put("listBank", listBank);
			PrintWriter out;
			out = response.getWriter();
			out.print(oj.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/stockData/getSumPageNum",method=RequestMethod.POST)
	public void getSumPageNum(HttpServletRequest request,
			HttpServletResponse response){
		try {
			String jstr = request.getParameter("jstr");
			response.setCharacterEncoding("utf-8");
			JSONObject obj = JSONObject.fromObject(jstr);
			int pageSize =(Integer) obj.get("pageSize");
			int flag = (Integer)obj.get("flag");
			long sumPageNum = loadStockDataService.getPageNumber(pageSize, flag);
			JSONObject oj = new JSONObject();
			oj.put("sumPageNum", sumPageNum);
			PrintWriter out;
			out = response.getWriter();
			out.print(oj.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="stockData/getEachStockData", method=RequestMethod.POST)
	public void getEachStockData(HttpServletRequest request,
			HttpServletResponse response){
		try {
			String jstr = request.getParameter("jstr");
			response.setCharacterEncoding("utf-8");
			JSONObject obj = JSONObject.fromObject(jstr);
			int flag = (Integer)obj.get("flag");
			
			JSONObject oj = new JSONObject();
			PrintWriter out;
			out = response.getWriter();
			out.print(oj.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
