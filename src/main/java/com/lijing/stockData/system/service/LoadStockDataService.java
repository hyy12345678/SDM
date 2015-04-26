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
	public List<StockData> getStockData(int page, int pageSize, int flag) {
		List<StockData> result = null;
		switch (flag) {
		//分页查询stock数据
		case 0: {
			result = stockDataDao.findStockPageList(page, pageSize);
		}
			break;

		default:
			break;
		}

		return result;
	}

}
