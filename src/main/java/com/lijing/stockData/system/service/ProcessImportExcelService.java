package com.lijing.stockData.system.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijing.stockData.system.dao.StockDataDao;
import com.lijing.stockData.system.model.StockData;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Service
public class ProcessImportExcelService {
	@Autowired
	private StockDataDao importExcelDAO;

	// 分析excel文件中的数据，并入库
	public String processExcel(InputStream excelFile) {
		String result = "";
		if (null == excelFile) {
			return result;
		}
		Workbook workbook = null;
		Sheet sheet[] = null;
		try {
			workbook = Workbook.getWorkbook(excelFile);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (null == workbook) {
			return "文件不存在";
		}
		sheet = workbook.getSheets();
		
		// 文件只有一个sheet页才对
		List<StockData> stockDataList = new ArrayList<StockData>();
		StockData stockData = null;
		try {
			for (int a = 0; a < sheet.length; a++) {
				// 先行row再列column
				for (int i = 1; i < sheet[a].getRows(); i++) {
					stockData = new StockData();
					// 币种
					stockData.setCurrency(sheet[a].getCell(0, i).getContents());
					// 证券名称
					stockData
							.setStockName(sheet[a].getCell(1, i).getContents());
					// 成交日期
					stockData.setTradingTime(setCellDate(sheet[a].getCell(2, i)
							.getContents().substring(0, 8)));
					stockData.setTradingDcode(sheet[a].getCell(2, i)
							.getContents().substring(8));
					// 成交价格
					stockData.setStrikePrice(setCellNum(sheet[a].getCell(3, i)
							.getContents()));
					// 成交数量
					stockData.setStrikeNum(setCellNum(sheet[a].getCell(4, i)
							.getContents()));
					// 发生金额
					stockData.setTotalAmount(setCellNum(sheet[a].getCell(5, i)
							.getContents()));
					// 资金余额
					stockData.setBalance(setCellNum(sheet[a].getCell(6, i)
							.getContents()));
					// 合同编号
					stockData.setContract(setCellStr(sheet[a].getCell(7, i)
							.getContents()));
					// 业务名称
					stockData.setBussinessName(sheet[a].getCell(8, i)
							.getContents());
					// 手续费
					stockData.setFees(setCellNum(sheet[a].getCell(9, i)
							.getContents()));
					// 印花税
					stockData.setStampTax(setCellNum(sheet[a].getCell(10, i)
							.getContents()));
					// 过户费
					stockData.setTransferFee(setCellNum(sheet[a]
							.getCell(11, i).getContents()));
					// 结算费
					stockData.setClearingFees(setCellNum(sheet[a].getCell(12,
							i).getContents()));
					// 证券代码
					stockData.setStockCode(setCellStr(sheet[a].getCell(13, i)
							.getContents()));
					// 股东代码
					stockData.setShareholderCode(setCellStr(sheet[a].getCell(
							14, i).getContents()));
					//银行或证券的标志
					stockData.setFlag("---".equals(sheet[a].getCell(
							3, i).getContents()) ? 0 : 1);

					stockDataList.add(stockData);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

		try {
			System.out.println(stockDataList.size());
			importExcelDAO.bulkSaveEcxelData(stockDataList);
		} catch (Exception e) {
			System.out.println("there is something wrong...");
			e.printStackTrace();
			return "error";
			
		}
		return "success";
	}

	private Date setCellDate(String str) throws ParseException {
		Date date = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		date = sdf.parse(str);
		return date;
	}
	
	private float setCellNum(String str) {
		if (null == str || "---".equals(str)) {
			return 0f;
		}
		return Float.valueOf(str);
	}

	//
	private String setCellStr(String str) {
		if (null == str || "---".equals(str)) {
			return "";
		}
		return str;
	}
	
/*	(1,'银行转存','0010',0);
	(2,'银行转取','0011',1);
	(3,'批量利息归本','0030',0);
	(4,'证券买入','0021',1);
	(5,'证券卖出','0020',1);
	(6,'股息入帐','0040',1);
	(7,'','0050',0);*/
	private String setBussinessName(String str)
	{
		
		return null;
	}

}
