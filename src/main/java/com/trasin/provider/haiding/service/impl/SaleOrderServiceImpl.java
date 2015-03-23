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
		// ����Ӧ�̴������Ϣ���뵽ʵ��
		Timestamp time = new Timestamp(new Date().getTime());
		saleOrder.setfCreateTime(time);
		saleOrder.setfSendTime(time);
		// �����ɹ�����wms
		logger.info("["+saleOrder.getInitStore()+"]�������۵���Ϣ" + saleOrder + "��WMS");
		
		if (saleOrder.getfMemo() == null) {
			saleOrder.setfMemo("");
		}
		
		if (saleOrder.getfMemo().length() >= 8) {
			StringBuffer fmemo = new StringBuffer(saleOrder.getfMemo());
			String memo = saleOrder.getfMemo();
			memo = memo.substring(memo.length() - 8, memo.length());
			if ("[�ѷ���WMS]".equals(memo)) {
				fmemo.delete(fmemo.length() - 8, fmemo.length());
				saleOrder.setfMemo(fmemo.toString());
			}
		}
		saleOrderDao.addSaleOrder(saleOrder);
		List<SaleOrderProduct> saleOrderProducts = saleOrder
				.getSaleOrderProducts();
		for (SaleOrderProduct saleOrderProduct : saleOrderProducts) {
			// ��ѯ��ƷID
			Integer productId = saleOrderDao
					.getProductIdByCode(saleOrderProduct.getfArticleCode());
			if (productId == null) {
				String msg = "["+saleOrder.getInitStore()+"]��Ʒ��Ϣ���ת����ȱ����Ʒ���Ϊ" + saleOrderProduct.getfArticleCode();
				logger.error(msg);
				throw new RuntimeException(msg);
			}
			
			// ��ȱʧ��Ϣ���뵽ʵ��
			saleOrderProduct.setfDestOrg(saleOrder.getfDestOrg());
			saleOrderProduct.setfSendTime(time);
			saleOrderProduct.setfArticle(productId);
			// �����ɹ�����ϸ��WMS
			logger.info("["+saleOrder.getInitStore()+"]�������۵���ϸ��Ϣ" + saleOrderProduct + "��WMS");
			saleOrderDao.addSaleOrderProduct(saleOrderProduct);
		}

	}

	@Override
	public List<SaleOrder> getAllSaleOrderByStoreCode(String storeCode) {
		List<SaleOrder> saleOrders = saleOrderDao
				.getSalesOrderByStoreCode(storeCode);
		logger.info("���ݲֿ���" + storeCode + "��ѯ���۵�����Ϣ�ɹ���Ϊ" + saleOrders);
		if (saleOrders == null || saleOrders.size() == 0) {
			return saleOrders;
		}

		List<SaleOrder> newsaSaleOrders = new ArrayList<SaleOrder>(
				saleOrders.size());
		
		

		for (SaleOrder saleOrder : saleOrders) {
			List<SaleOrderProduct> saleOrderProducts = saleOrderDao
					.getProductsBySaleOrderNo(saleOrder.getNum());
			logger.info("�������۵��ţ�" + saleOrder.getNum() + "��ѯ��ϸ��ɹ�,Ϊ��"
					+ saleOrderProducts);
			saleOrder.setSaleOrderProducts(saleOrderProducts);
			newsaSaleOrders.add(saleOrder);
		}
		return newsaSaleOrders;
	}

	public void updateSaleOrder(SaleOrder saleOrder) {
		StringBuffer fmemo = new StringBuffer(saleOrder.getfMemo());
		if (saleOrder.getfMemo().length() < 8) {
			fmemo.append("[�ѷ���WMS]");
			saleOrder.setfMemo(fmemo.toString());
		}
		String memo = saleOrder.getfMemo();
		memo = memo.substring(memo.length() - 8, memo.length());
		if (!"[�ѷ���WMS]".equals(memo)) {
			fmemo.append("[�ѷ���WMS]");
		}
		saleOrder.setfMemo(fmemo.toString());

		logger.info("�������۵���Ϊ" + saleOrder.getNum() + "״̬��Ϣ");
		saleOrderDao.updateBySaleOrderNo(saleOrder);
	}
}
