package com.trasin.provider.haiding.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trasin.provider.haiding.dao.SaleOrderDao;
import com.trasin.provider.haiding.entity.SaleOrder;
import com.trasin.provider.haiding.entity.SaleOrderProduct;
import com.trasin.provider.haiding.service.SaleOrderService;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {

	private static Logger logger = Logger.getLogger(SaleOrderServiceImpl.class);

	@Autowired
	private SaleOrderDao saleOrderDao;

	@Override
	public void addSaleOrder(SaleOrder saleOrder) {
		// 将供应商代码等信息加入到实体
		Timestamp time = new Timestamp(new Date().getTime());
		saleOrder.setfCreateTime(time);
		saleOrder.setfSendTime(time);
		// 新增采购单到wms
		logger.info("["+saleOrder.getInitStore()+"]新增销售单信息" + saleOrder + "到WMS");
		
		if (saleOrder.getfMemo() == null) {
			saleOrder.setfMemo("");
		}
		
		if (saleOrder.getfMemo().length() >= 8) {
			StringBuffer fmemo = new StringBuffer(saleOrder.getfMemo());
			String memo = saleOrder.getfMemo();
			memo = memo.substring(memo.length() - 8, memo.length());
			if ("[已发送WMS]".equals(memo)) {
				fmemo.delete(fmemo.length() - 8, fmemo.length());
				saleOrder.setfMemo(fmemo.toString());
			}
		}
		saleOrderDao.addSaleOrder(saleOrder);
		List<SaleOrderProduct> saleOrderProducts = saleOrder
				.getSaleOrderProducts();
		for (SaleOrderProduct saleOrderProduct : saleOrderProducts) {
			// 查询商品ID
			Integer productId = saleOrderDao
					.getProductIdByCode(saleOrderProduct.getfArticleCode());
			if (productId == null) {
				String msg = "["+saleOrder.getInitStore()+"]商品信息编号转换表缺少商品编号为" + saleOrderProduct.getfArticleCode();
				logger.error(msg);
				throw new RuntimeException(msg);
			}
			
			// 将缺失信息加入到实体
			saleOrderProduct.setfDestOrg(saleOrder.getfDestOrg());
			saleOrderProduct.setfSendTime(time);
			saleOrderProduct.setfArticle(productId);
			// 新增采购单明细到WMS
			logger.info("["+saleOrder.getInitStore()+"]新增销售单明细信息" + saleOrderProduct + "到WMS");
			saleOrderDao.addSaleOrderProduct(saleOrderProduct);
		}

	}

	@Override
	public List<SaleOrder> getAllSaleOrderByStoreCode(String storeCode) {
		List<SaleOrder> saleOrders = saleOrderDao
				.getSalesOrderByStoreCode(storeCode);
		logger.info("根据仓库编号" + storeCode + "查询销售单据信息成功，为" + saleOrders);
		if (saleOrders == null || saleOrders.size() == 0) {
			return saleOrders;
		}

		List<SaleOrder> newsaSaleOrders = new ArrayList<SaleOrder>(
				saleOrders.size());
		
		

		for (SaleOrder saleOrder : saleOrders) {
			List<SaleOrderProduct> saleOrderProducts = saleOrderDao
					.getProductsBySaleOrderNo(saleOrder.getNum());
			logger.info("根据销售单号：" + saleOrder.getNum() + "查询明细表成功,为："
					+ saleOrderProducts);
			saleOrder.setSaleOrderProducts(saleOrderProducts);
			newsaSaleOrders.add(saleOrder);
		}
		return newsaSaleOrders;
	}

	public void updateSaleOrder(SaleOrder saleOrder) {
		StringBuffer fmemo = new StringBuffer(saleOrder.getfMemo());
		if (saleOrder.getfMemo().length() < 8) {
			fmemo.append("[已发送WMS]");
			saleOrder.setfMemo(fmemo.toString());
		}
		String memo = saleOrder.getfMemo();
		memo = memo.substring(memo.length() - 8, memo.length());
		if (!"[已发送WMS]".equals(memo)) {
			fmemo.append("[已发送WMS]");
		}
		saleOrder.setfMemo(fmemo.toString());

		logger.info("更新销售单号为" + saleOrder.getNum() + "状态信息");
		saleOrderDao.updateBySaleOrderNo(saleOrder);
	}
}
