package com.trasin.provider.haiding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trasin.provider.haiding.vo.AsnVO;
import com.trasin.provider.haiding.vo.SaleOrderVO;

@Component
public class ApplicationUtils {

	private static final int DEFAULT_MINUTE = 5;

	@Autowired
	private AsnVO asnVO;
	
	@Autowired
	private SaleOrderVO saleOrderVO;

	public void init(String store, String fDestOrg, Integer minute) {
		if (minute == null || minute == 0) {
			minute = DEFAULT_MINUTE;
		}
		asnVO.init(store, fDestOrg, minute);		
		saleOrderVO.init(store, fDestOrg, minute);
	}
}
