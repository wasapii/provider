package com.trasin.provider.haiding;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>
 * Project Name: provider <br>
 * Description: <br>
 * File Name: DynamicDataSource.java <br>
 * Copyright: Copyright (C) 2014 All Rights Reserved. <br>
 * Company: �㽭Ԫ����Ϣ�Ƽ����޹�˾ <br>
 * 
 * @author: zgxh
 * @email: vegaxh@gmail.com
 * @create time��2015��3��7�� ����8:58:10
 * @version: v1.1
 * 
 *           Date Author Version Description
 *           ------------------------------------------------------------------
 *           2015��3��7�� ����8:58:10 |zgxh ���� |v1.1 |Create
 * 
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DatabaseContextHolder.getCustomerType();
	}
}
