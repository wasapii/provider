package com.trasin.provider.haiding.vo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trasin.provider.haiding.DatabaseContextHolder;
import com.trasin.provider.haiding.entity.Asn;
import com.trasin.provider.haiding.service.AsnService;
import com.trasin.provider.haiding.vo.AsnVO;

@Service
public class AsnVOImpl implements AsnVO {

	private static final Logger logger = Logger.getLogger(AsnVOImpl.class);

	@Autowired
	private AsnService asnService;

	public void init(final String store, final String fDestOrg, Integer minute) {
		String threadName = "["+ store +"]采购单";
		Timer timer = new Timer(threadName);

		timer.schedule(new TimerTask() {
			public void run() {
				logger.info("["+store+"]采购单定时查询开始...");
				List<Asn> asns = new ArrayList<Asn>();
				try {
					DatabaseContextHolder.setMysqlCustomerType();
					asns = asnService.getAllAsnByStoreCode(store);
					logger.info("["+store+"]采购单定时查询，本次查询到记录数共[" + asns.size() + "]条");
				} catch (Exception e) {
					logger.error("["+store+"]采购单定时查询，出错了", e.fillInStackTrace());
				}

				for (Asn asn : asns) {
					try {
						DatabaseContextHolder.setOracleCustomerType();
						asn.setInitStore(store);
						asn.setFdestorg(fDestOrg);
						asnService.addAsn(asn);
						DatabaseContextHolder.setMysqlCustomerType();
						asnService.updateAsn(asn);
					} catch (Exception e) {
						logger.error("["+store+"]采购单推送出错了" + asn.toString());
						logger.error("["+store+"]采购单推送出错了", e.fillInStackTrace());
					}
				}
				logger.info("["+store+"]采购单定时处理结束");
			}
		}, 0, minute * 60 * 1000);
	}
}
