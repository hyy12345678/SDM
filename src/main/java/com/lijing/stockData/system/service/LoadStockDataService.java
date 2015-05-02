package com.lijing.stockData.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijing.stockData.system.dao.StockDataDao;
import com.lijing.stockData.system.model.StockData;

@Service
public class LoadStockDataService {
	@Autowired
	private StockDataDao stockDataDao;

	/**
	 * 
	 * @param page当前显示页
	 * @param pageSize每页显示个数
	 * @param flag查询类型
	 * @return
	 */
	public List<StockData> getTradingDataService(int page, int pageSize, int flag) {
		List<StockData> result = null;
		//分页查询stock数据
		result = stockDataDao.getTradingDataByFlag(page, pageSize, flag);
//		switch (flag) {
//		
//		case 0: {
//			result = stockDataDao.findStockPageList(page, pageSize);
//			break;
//		}
//		case 1:{
//			result = stockDataDao.findBankDataList(page, pageSize);
//			break;
//		}
//		default:
//			break;
//		}

		return result;
	}
	
	public long getPageNumber(int pageSize,int flag)
	{
		long sumDataCount = stockDataDao.getSumNumOfDataByFlag(flag);
		
		return sumDataCount%pageSize>0?(sumDataCount/pageSize+1):(sumDataCount/pageSize);
	}
	
	public static void main(String[] args) {
		int sumDataCount = 15;
		int pageSize = 4;
		System.out.println(sumDataCount%pageSize>0?true:false);
	}

}
