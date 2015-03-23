package com.trasin.provider.haiding;

import org.apache.log4j.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * Project Name: provider <br>
 * Description: <br>
 * File Name: Main.java <br>
 * Copyright: Copyright (C) 2014 All Rights Reserved. <br>
 * Company: 浙江元幸信息科技有限公司 <br>
 * 
 * @author: zgxh
 * @email: vegaxh@gmail.com
 * @create time：2015年3月7日 下午9:28:37
 * @version: v1.1
 * 
 *           Date Author Version Description
 *           ------------------------------------------------------------------
 *           2015年3月7日 下午9:28:37 |zgxh 　　 |v1.1 |Create
 * 
 */

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);

	private static String store;

	private static String fDestOrg;

	private static Integer minute;

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "spring-config.xml" });
			ApplicationUtils applicationUtils = (ApplicationUtils) context
					.getBean("applicationUtils");
			SysConfig sysConfig = (SysConfig) context.getBean("sysConfig");
			if (args.length == 0) {
				if (sysConfig.getStore() == null) {
					logger.error("init error! store not config");
					return;
				} else {
					store = sysConfig.getStore();
				}
				
				if (sysConfig.getfDestOrg() == null) {
					logger.error("init error! destOrg not config");
					return;
				} else {
					fDestOrg = sysConfig.getfDestOrg();
				}

				if (sysConfig.getMinute() == null || sysConfig.getMinute() == 0) {
					logger.error("init error! minute not config");
					return;
				} else {
					minute = sysConfig.getMinute();
				}
			} else if (args.length == 2) {
				store = args[0];				
				fDestOrg = args[1];
				minute = sysConfig.getMinute();
			} else if (args.length == 3) {
				store = args[0];
				fDestOrg = args[1];
				minute = Integer.parseInt(args[2]);
			} else {
				 logger.error("init config error! args param length is" + args.length);
				 return;
			}
			logger.info("start init, store[" + store + "], fDestOrg["+fDestOrg+"], minute[" + minute
					+ "]");
			applicationUtils.init(store, fDestOrg, minute);
			logger.info("init success");
		} catch (Exception e) {
			logger.error("加载出错了", e);
		}
	}
}
