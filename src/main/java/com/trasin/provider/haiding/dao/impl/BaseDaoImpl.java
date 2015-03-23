package com.trasin.provider.haiding.dao.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trasin.provider.haiding.dao.BaseDao;

@Repository
public  class BaseDaoImpl implements BaseDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer getSupplierIdByCode(String supplierCode) {
		String sql = "select fgid from V_TVENDOR where fcode=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, supplierCode);
	}

	@Override
	public Integer getProductIdByCode(String productCode) {
		String sql = "select fgid from V_TARTICLE where fcode=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, productCode);
	}

}
