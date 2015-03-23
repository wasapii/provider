package com.trasin.provider.haiding.service;

import java.util.List;


import com.trasin.provider.haiding.entity.SaleOrder;

public interface SaleOrderService {

	public void addSaleOrder(SaleOrder saleOrder);
	
	public List<SaleOrder> getAllSaleOrderByStoreCode(String storeCode) ;
	
	public void updateSaleOrder(SaleOrder saleOrder);
	
}
