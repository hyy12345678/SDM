package com.lijing.stockData.system.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.lijing.stockData.system.model.StockData;

@Repository
public class StockDataDao extends BaseDao {
	
	private String GET_ALL_DATA = "from StockData";
	private String GET_STOCK_DATA = "from StockData";
	
	//存储或更新股票数据，防止相同数据的重复导入
	public void saveExcelData(StockData stockData)
	{
		getHibernateTemplate().save(stockData);
	}
	
	//save方法存对象，如果要存一个list，需要使用的方法是saveOrUpdateAll
	//批量处理存入数据
	public void bulkSaveEcxelData(List<StockData> stockDataList)
	{
		getHibernateTemplate().saveOrUpdateAll(stockDataList);
	}
	
	//删除全表数据
	public void deleteAll(){
		getHibernateTemplate().bulkUpdate("delete from StockData");
	}
	
	//查找全部excel中的数据
	public List<StockData> findAllExcelData()
	{
		List<StockData> list = new ArrayList<StockData>();
		
		list = (List<StockData>) getHibernateTemplate().find(GET_ALL_DATA);
		
		//list = getHibernateTemplate().loadAll(StockData.class);
		
		return list;
	}
	
	//查找数据总量
	public long findCount(String sql)
	{
		return (Long) getHibernateTemplate().find(sql).iterator().next();
	}
	
	//获取分页的股票交易数据
	public List<StockData> findStockPageList(int page, int pageSize ){
		return  pagedQuery( GET_STOCK_DATA, page, pageSize);
	}
	
	//分页查询实现方法
	private List<StockData> pagedQuery(String hql, int page, int pageSize)
	{
		// 实际查询返回分页对象
		int startIndex = getStartOfPage(page, pageSize);
		Session session = SessionFactoryUtils.getSession(getHibernateTemplate().getSessionFactory(), true);
		Query query = session.createQuery(hql);
		List<StockData> list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
		return list;
	}

	//查询满足条件的数据
	public List<StockData> findDataByStockName(String queryString, String[] values){
		
		List<StockData> stockList =(List<StockData>) getHibernateTemplate().find(queryString, values);
		System.out.println(stockList.size());
		return stockList;
	}
	
	/**
	 * 获取任一页第一条数据在数据集的位置.
	 *
	 * @param pageNo   从1开始的页号
	 * @param pageSize 每页记录条数
	 * @return 该页第一条数据
	 */
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}
}
