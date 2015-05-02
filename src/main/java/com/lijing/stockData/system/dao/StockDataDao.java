package com.lijing.stockData.system.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.lijing.stockData.system.model.StockData;

@Repository
public class StockDataDao extends BaseDao {
	
	private String GET_ALL_DATA = "from StockData";
	private String GET_STOCK_DATA = "from StockData where flag=1 order by tradingTime";
	private String GET_BANK_DATA = "from StockData where flag=0  order by tradingTime";
	private String IS_STOCK_DATA_EXIST = "from StockData where tradingTime=? and tradingDcode=? ";
	private String GET_TABLE_DATA = "from StockData where flag=? order by tradingTime";
	
	
	//存储或更新股票数据，防止相同数据的重复导入
	public void saveExcelData(StockData stockData)
	{
		getHibernateTemplate().save(stockData);
	}
	
	//save方法存对象，如果要存一个list，需要使用的方法是saveOrUpdateAll
	//批量处理存入数据
	public void bulkSaveEcxelData(List<StockData> stockDataList)
	{
		Session session = getSession();
		Query query = session.createQuery(IS_STOCK_DATA_EXIST);
		Iterator<StockData> iter = null;
		StockData stockData= null;
//		for( Iterator<StockData> it=stockDataList.iterator();it.hasNext(); )
//		{
//			stockData = it.next();
//			query.setParameter(0, stockData.getTradingTime());
//			query.setParameter(1, stockData.getTradingDcode());
//			iter = query.iterate();
//			if(iter.hasNext())
//			{
//				it.remove();
//			}
//		}
		
		Iterator<StockData> it = stockDataList.iterator();
		while(it.hasNext()){
			stockData = it.next();
			query.setParameter(0, stockData.getTradingTime());
			query.setParameter(1, stockData.getTradingDcode());
			iter = query.iterate();
			if(iter.hasNext())
			{
				it.remove();
			}
		}
		System.out.println(stockDataList.size());
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
	
	//根据sql查找数据总量
	public long findCountBySql(String sql)
	{
		return (Long) getHibernateTemplate().find(sql).iterator().next();
	}
	
	/**
	 * 根据标志位，分页获取交易数据
	 * @param page 页码
	 * @param pageSize 每页显示条数
	 * @param flag 标志，0是银行，1是股票交易
	 * @return 查询数据的list
	 */
	public List<StockData> getTradingDataByFlag(int page,int pageSize,int flag)
	{
		//return getHibernateTemplate().find(GET_TABLE_DATA, flag);
		return pageQuery(GET_TABLE_DATA, page, pageSize,flag);
	}
	
	//获取分页的股票交易数据
	public List<StockData> findStockPageList(int page, int pageSize ){
		return  pageQuery( GET_STOCK_DATA, page, pageSize,1);
	}
	
	//获取分页的银行交易数据
	public List<StockData> findBankDataList(int page, int pageSize)
	{
		return pageQuery(GET_BANK_DATA,page,pageSize,0);
	}
	
	//分页查询实现方法
	private List<StockData> pageQuery(String hql, int page, int pageSize, int flag)
	{
		// 实际查询返回分页对象
		int startIndex = getStartOfPage(page, pageSize);
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, flag);
		List<StockData> list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
		session.close();
		return list;
	}

	/**
	 * 查询满足条件的数据
	 * @param queryString
	 * @param values
	 * @return
	 */
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
	
	/**
	 * 
	 * @param flag
	 * @return
	 */
	public long getSumNumOfDataByFlag(int flag)
	{
		long count = (Long) getHibernateTemplate().find("select count(*) from StockData where flag=?", flag).iterator().next();
//		getHibernateTemplate().find("from StockData");
//		getHibernateTemplate().loadAll(StockData.class);
		 return count;
	}
}
