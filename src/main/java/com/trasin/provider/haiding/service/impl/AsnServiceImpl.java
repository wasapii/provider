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
		// 根据供应商代码查询供应商
		Integer supplierId = asnDao.getSupplierIdByCode(asn.getFvdrcode());
		if (supplierId == null) {
			String msg = "["+asn.getInitStore()+"]物流供应商代码编号转换表缺少编号为" + asn.getFvdrcode() + "该物流供应商编码";
			logger.error(msg);
			throw new RuntimeException(msg);
		}
		// 将供应商代码等信息加入到实体
		asn.setFvendor(supplierId);
		Timestamp time = new Timestamp(new Date().getTime());
		asn.setFcreatetime(time);// 生成时间
		asn.setFsendtime(time);// 发送时间
		// 新增采购单到wms
		logger.info("["+asn.getInitStore()+"]新增采购单信息" + asn + "到WMS");
		if (asn.getFmemo() == null) {
			asn.setFmemo("");
		}
		if (asn.getFmemo().length() >= 8) {
			StringBuffer fmemo = new StringBuffer(asn.getFmemo());
			String memo = asn.getFmemo();
			memo = memo.substring(memo.length() - 8, memo.length());
			if ("[已发送WMS]".equals(memo)) {
				fmemo.delete(fmemo.length() - 8, fmemo.length());
				asn.setFmemo(fmemo.toString());
			}
		}
		asnDao.addAsn(asn);
		List<AsnProduct> asnProducts = asn.getProducts();
		for (AsnProduct asnProduct : asnProducts) {
			// 查询商品ID
			Integer productId = asnDao.getProductIdByCode(asnProduct
					.getFarticlecode());
			if (productId == null) {
				String msg = "["+asn.getInitStore()+"]商品信息编号转换表缺少编号为" + asnProduct.getFarticle() + "该物流供应商编码";
				logger.error(msg);
				throw new RuntimeException(msg);
			}
			// 将缺失信息加入到实体
			asnProduct.setFdestorg(asn.getFdestorg());
			asnProduct.setFarticle(productId);
			asnProduct.setFsendtime(time);// 发送时间
			// 新增采购单明细到WMS
			logger.info("["+asn.getInitStore()+"]新增采购单明细信息" + asnProduct + "到WMS");
			asnDao.addAsnProduct(asnProduct);
		}
		//this.updateAsn(asn);
	}

	public void updateAsn(Asn asn) {
		// 修改物流平台采购单状态
		// DatabaseContextHolder.setMysqlCustomerType();
		
		StringBuffer fmemo = new StringBuffer(asn.getFmemo());
		if (asn.getFmemo().length() < 8) {
			fmemo.append("[已发送WMS]");
			asn.setFmemo(fmemo.toString());
		}
		String memo = asn.getFmemo();
		memo = memo.substring(memo.length() - 8, memo.length());
		if (!"[已发送WMS]".equals(memo)) {
			fmemo.append("[已发送WMS]");
		}
		asn.setFmemo(fmemo.toString());

		logger.info("["+asn.getInitStore()+"]更新采购单号为" + asn.getNum() + "状态信息");
		asnDao.updateByAsnNo(asn);
	}

	@Override
	public List<Asn> getAllAsnByStoreCode(String StoreCode) {

		List<Asn> asns = asnDao.getAsnsByStoreCode(StoreCode);
		logger.info("根据仓库编号" + StoreCode + "查询采购单据信息成功，为" + asns);
		if (asns == null || asns.size() == 0) {
			return asns;
		}

		List<Asn> newAsns = new ArrayList<Asn>(asns.size());

		for (Asn asn : asns) {
			List<AsnProduct> products = this.asnDao.getProductsByAsnNo(asn
					.getNum());
			logger.info("根据采购单号：" + asn.getNum() + "查询明细表成功,为：" + products);
			asn.setProducts(products);
			newAsns.add(asn);
		}
		return newAsns;
	}

}
