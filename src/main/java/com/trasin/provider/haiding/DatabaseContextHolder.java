package com.trasin.provider.haiding;

/**
 * <p>
 * Project Name: provider <br>
 * Description: <br>
 * File Name: DatabaseContextHolder.java <br>
 * Copyright: Copyright (C) 2014 All Rights Reserved. <br>
 * Company: �㽭Ԫ����Ϣ�Ƽ����޹�˾ <br>
 * 
 * @author: zgxh
 * @email: vegaxh@gmail.com
 * @create time��2015��3��7�� ����9:12:50
 * @version: v1.1
 * 
 *           Date Author Version Description
 *           ------------------------------------------------------------------
 *           2015��3��7�� ����9:12:50 |zgxh ���� |v1.1 |Create
 * 
 */

public class DatabaseContextHolder {
	
	public static final String  MYSQL_CUSTOMERTYPE = "mysqlDataSource";
	public static final String  ORACLE_CUSTOMERTYPE = "oracleDataSource";
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	public static void setMysqlCustomerType() {
		setCustomerType(MYSQL_CUSTOMERTYPE);
	}
	
	public static void setOracleCustomerType() {
		setCustomerType(ORACLE_CUSTOMERTYPE);
	}

	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	public static String getCustomerType() {
		return contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}
}
