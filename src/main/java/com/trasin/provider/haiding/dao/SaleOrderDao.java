package com.trasin.provider.haiding.dao;

import java.util.List;

import com.trasin.provider.haiding.entity.SaleOrder;
import com.trasin.provider.haiding.entity.SaleOrderProduct;

public interface SaleOrderDao extends BaseDao{

	public List<SaleOrder> getSalesOrderByStoreCode(String StoreCode);

	public List<SaleOrderProduct> getProductsBySaleOrderNo(String SalesNo);
	
	public int addSaleOrder(final SaleOrder saleOrder);

	public int addSaleOrderProduct(final SaleOrderProduct saleOrderProduct);

	public void updateBySaleOrderNo(final SaleOrder saleOrder) ;
}
