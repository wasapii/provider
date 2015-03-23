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
		String threadName = "["+ store +"]�ɹ���";
		Timer timer = new Timer(threadName);

		timer.schedule(new TimerTask() {
			public void run() {
				logger.info("["+store+"]�ɹ�����ʱ��ѯ��ʼ...");
				List<Asn> asns = new ArrayList<Asn>();
				try {
					DatabaseContextHolder.setMysqlCustomerType();
					asns = asnService.getAllAsnByStoreCode(store);
					logger.info("["+store+"]�ɹ�����ʱ��ѯ�����β�ѯ����¼����[" + asns.size() + "]��");
				} catch (Exception e) {
					logger.error("["+store+"]�ɹ�����ʱ��ѯ��������", e.fillInStackTrace());
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
						logger.error("["+store+"]�ɹ������ͳ�����" + asn.toString());
						logger.error("["+store+"]�ɹ������ͳ�����", e.fillInStackTrace());
					}
				}
				logger.info("["+store+"]�ɹ�����ʱ�������");
			}
		}, 0, minute * 60 * 1000);
	}
}
