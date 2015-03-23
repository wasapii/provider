package com.trasin.provider.haiding.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trasin.provider.haiding.DatabaseContextHolder;
import com.trasin.provider.haiding.dao.AsnDao;
import com.trasin.provider.haiding.entity.Asn;
import com.trasin.provider.haiding.entity.AsnProduct;
import com.trasin.provider.haiding.service.AsnService;

@Service
public class AsnServiceImpl implements AsnService {

	private static final Logger logger = Logger.getLogger(AsnServiceImpl.class);

	@Autowired
	private AsnDao asnDao;

	@Override
	public void addAsn(Asn asn) {
		//DatabaseContextHolder.setOracleCustomerType();
		// ���ݹ�Ӧ�̴����ѯ��Ӧ��
		Integer supplierId = asnDao.getSupplierIdByCode(asn.getFvdrcode());
		if (supplierId == null) {
			String msg = "["+asn.getInitStore()+"]������Ӧ�̴�����ת����ȱ�ٱ��Ϊ" + asn.getFvdrcode() + "��������Ӧ�̱���";
			logger.error(msg);
			throw new RuntimeException(msg);
		}
		// ����Ӧ�̴������Ϣ���뵽ʵ��
		asn.setFvendor(supplierId);
		Timestamp time = new Timestamp(new Date().getTime());
		asn.setFcreatetime(time);// ����ʱ��
		asn.setFsendtime(time);// ����ʱ��
		// �����ɹ�����wms
		logger.info("["+asn.getInitStore()+"]�����ɹ�����Ϣ" + asn + "��WMS");
		if (asn.getFmemo() == null) {
			asn.setFmemo("");
		}
		if (asn.getFmemo().length() >= 8) {
			StringBuffer fmemo = new StringBuffer(asn.getFmemo());
			String memo = asn.getFmemo();
			memo = memo.substring(memo.length() - 8, memo.length());
			if ("[�ѷ���WMS]".equals(memo)) {
				fmemo.delete(fmemo.length() - 8, fmemo.length());
				asn.setFmemo(fmemo.toString());
			}
		}
		asnDao.addAsn(asn);
		List<AsnProduct> asnProducts = asn.getProducts();
		for (AsnProduct asnProduct : asnProducts) {
			// ��ѯ��ƷID
			Integer productId = asnDao.getProductIdByCode(asnProduct
					.getFarticlecode());
			if (productId == null) {
				String msg = "["+asn.getInitStore()+"]��Ʒ��Ϣ���ת����ȱ�ٱ��Ϊ" + asnProduct.getFarticle() + "��������Ӧ�̱���";
				logger.error(msg);
				throw new RuntimeException(msg);
			}
			// ��ȱʧ��Ϣ���뵽ʵ��
			asnProduct.setFdestorg(asn.getFdestorg());
			asnProduct.setFarticle(productId);
			asnProduct.setFsendtime(time);// ����ʱ��
			// �����ɹ�����ϸ��WMS
			logger.info("["+asn.getInitStore()+"]�����ɹ�����ϸ��Ϣ" + asnProduct + "��WMS");
			asnDao.addAsnProduct(asnProduct);
		}
		//this.updateAsn(asn);
	}

	public void updateAsn(Asn asn) {
		// �޸�����ƽ̨�ɹ���״̬
		// DatabaseContextHolder.setMysqlCustomerType();
		
		StringBuffer fmemo = new StringBuffer(asn.getFmemo());
		if (asn.getFmemo().length() < 8) {
			fmemo.append("[�ѷ���WMS]");
			asn.setFmemo(fmemo.toString());
		}
		String memo = asn.getFmemo();
		memo = memo.substring(memo.length() - 8, memo.length());
		if (!"[�ѷ���WMS]".equals(memo)) {
			fmemo.append("[�ѷ���WMS]");
		}
		asn.setFmemo(fmemo.toString());

		logger.info("["+asn.getInitStore()+"]���²ɹ�����Ϊ" + asn.getNum() + "״̬��Ϣ");
		asnDao.updateByAsnNo(asn);
	}

	@Override
	public List<Asn> getAllAsnByStoreCode(String StoreCode) {

		List<Asn> asns = asnDao.getAsnsByStoreCode(StoreCode);
		logger.info("���ݲֿ���" + StoreCode + "��ѯ�ɹ�������Ϣ�ɹ���Ϊ" + asns);
		if (asns == null || asns.size() == 0) {
			return asns;
		}

		List<Asn> newAsns = new ArrayList<Asn>(asns.size());

		for (Asn asn : asns) {
			List<AsnProduct> products = this.asnDao.getProductsByAsnNo(asn
					.getNum());
			logger.info("���ݲɹ����ţ�" + asn.getNum() + "��ѯ��ϸ��ɹ�,Ϊ��" + products);
			asn.setProducts(products);
			newAsns.add(asn);
		}
		return newAsns;
	}

}
