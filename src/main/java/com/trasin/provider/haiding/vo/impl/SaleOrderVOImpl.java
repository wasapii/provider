package com.trasin.provider.haiding.vo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trasin.provider.haiding.DatabaseContextHolder;
import com.trasin.provider.haiding.entity.SaleOrder;
import com.trasin.provider.haiding.service.SaleOrderService;
import com.trasin.provider.haiding.vo.SaleOrderVO;

@Service
public class SaleOrderVOImpl implements SaleOrderVO {
 
	private static final Logger logger = Logger.getLogger(SaleOrderVOImpl.class);
	
	@Autowired
	private SaleOrderService saleOrderService;
	
	@Override
	public void init(final String store, final String fDestOrg, Integer minute) {
		String threadName = "["+ store +"]销售单";
		Timer timer = new Timer(threadName);
		
		timer.schedule(new TimerTask() {
			public void run() {
				logger.info("["+store+"]销售单定时查询开始...");
				List<SaleOrder> saleOrders = new ArrayList<SaleOrder>();
				try {
					DatabaseContextHolder.setMysqlCustomerType();
					saleOrders = saleOrderService.getAllSaleOrderByStoreCode(store);
					logger.info("["+store+"]销售单定时查询，本次查询到记录数共[" + saleOrders.size() + "]条");
				} catch (Exception e) {
					logger.error("["+store+"]销售单定时查询，出错了", e.fillInStackTrace());
				}

				for (SaleOrder saleOrder : saleOrders) {
					try {
						DatabaseContextHolder.setOracleCustomerType();
						saleOrder.setfDestOrg(fDestOrg);
						saleOrder.setInitStore(store);
						saleOrderService.addSaleOrder(saleOrder);
						DatabaseContextHolder.setMysqlCustomerType();
						saleOrderService.updateSaleOrder(saleOrder);
					} catch (Exception e) {
						logger.error("["+store+"]销售单推送出错了" + saleOrder.toString());
						logger.error("["+store+"]销售单推送出错了", e.fillInStackTrace());
					}
				}
				logger.info("["+store+"]销售单定时处理结束");
			}
		}, 0, minute * 60 * 1000);

	}

}
