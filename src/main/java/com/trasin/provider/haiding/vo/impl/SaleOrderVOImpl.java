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
		String threadName = "["+ store +"]���۵�";
		Timer timer = new Timer(threadName);
		
		timer.schedule(new TimerTask() {
			public void run() {
				logger.info("["+store+"]���۵���ʱ��ѯ��ʼ...");
				List<SaleOrder> saleOrders = new ArrayList<SaleOrder>();
				try {
					DatabaseContextHolder.setMysqlCustomerType();
					saleOrders = saleOrderService.getAllSaleOrderByStoreCode(store);
					logger.info("["+store+"]���۵���ʱ��ѯ�����β�ѯ����¼����[" + saleOrders.size() + "]��");
				} catch (Exception e) {
					logger.error("["+store+"]���۵���ʱ��ѯ��������", e.fillInStackTrace());
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
						logger.error("["+store+"]���۵����ͳ�����" + saleOrder.toString());
						logger.error("["+store+"]���۵����ͳ�����", e.fillInStackTrace());
					}
				}
				logger.info("["+store+"]���۵���ʱ�������");
			}
		}, 0, minute * 60 * 1000);

	}

}
