package com.lijing.stockData.system.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.lijing.stockData.system.model.BussinessConfig;

@Repository
public class BussinessConfigDao extends BaseDao {
	
	public List<BussinessConfig> getAllBussinessconfig()
	{
		return getHibernateTemplate().loadAll(BussinessConfig.class);
	}
}
