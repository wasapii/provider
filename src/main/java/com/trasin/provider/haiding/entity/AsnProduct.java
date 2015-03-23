package com.trasin.provider.haiding.entity;

import java.sql.Timestamp;

/**
 * <p>
 * Project Name: provider <br>
 * Description: <br>
 * File Name: AsnProduct.java <br>
 * Copyright: Copyright (C) 2014 All Rights Reserved. <br>
 * Company: 浙江元幸信息科技有限公司 <br>
 * 
 * @author: zgxh
 * @email: vegaxh@gmail.com
 * @create time：2015年3月7日 下午9:34:35
 * @version: v1.1
 * 
 *           Date Author Version Description
 *           ------------------------------------------------------------------
 *           2015年3月7日 下午9:34:35 |zgxh 　　 |v1.1 |Create
 * 
 */

public class AsnProduct extends BaseEntity {

	/**
	 * 单号
	 */
	private String num;

	/**
	 * 行号
	 */
	private String line;

	/**
	 * 货品
	 */
	private Integer farticle;

	/**
	 * 货品代码
	 */
	private String farticlecode;

	/**
	 * 数量
	 */
	private Double fqty;

	/**
	 * 价格
	 */
	private Double fprice;

	/**
	 * 发送时间
	 */
	private Timestamp fsendtime;

	/**
	 * 来源组织
	 */
	private String fsrcorg ="8001";

	/**
	 * 目标组织
	 */
	private String fdestorg = "";

	/**
	 * 税率
	 */
	private Integer ftaxrate = 0;
	
	
	private String fqpcstr = "1*1";
	
	private Integer fqpc = 1;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public Integer getFarticle() {
		return farticle;
	}

	public void setFarticle(Integer farticle) {
		this.farticle = farticle;
	}

	public String getFarticlecode() {
		return farticlecode;
	}

	public void setFarticlecode(String farticlecode) {
		this.farticlecode = farticlecode;
	}

	public Double getFqty() {
		return fqty;
	}

	public void setFqty(Double fqty) {
		this.fqty = fqty;
	}

	public Double getFprice() {
		return fprice;
	}

	public void setFprice(Double fprice) {
		this.fprice = fprice;
	}

	public Timestamp getFsendtime() {
		return fsendtime;
	}

	public void setFsendtime(Timestamp fsendtime) {
		this.fsendtime = fsendtime;
	}

	public String getFsrcorg() {
		return fsrcorg;
	}

	public void setFsrcorg(String fsrcorg) {
		this.fsrcorg = fsrcorg;
	}

	public String getFdestorg() {
		return fdestorg;
	}

	public void setFdestorg(String fdestorg) {
		this.fdestorg = fdestorg;
	}

	public Integer getFtaxrate() {
		return ftaxrate;
	}

	public void setFtaxrate(Integer ftaxrate) {
		this.ftaxrate = ftaxrate;
	}
	
	

	public String getFqpcstr() {
		return fqpcstr;
	}

	public void setFqpcstr(String fqpcstr) {
		this.fqpcstr = fqpcstr;
	}

	public Integer getFqpc() {
		return fqpc;
	}

	public void setFqpc(Integer fqpc) {
		this.fqpc = fqpc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OAsnProduct [num=");
		builder.append(num);
		builder.append(", line=");
		builder.append(line);
		builder.append(", farticle=");
		builder.append(farticle);
		builder.append(", farticlecode=");
		builder.append(farticlecode);
		builder.append(", fqty=");
		builder.append(fqty);
		builder.append(", fprice=");
		builder.append(fprice);
		builder.append(", fsendtime=");
		builder.append(fsendtime);
		builder.append(", fsrcorg=");
		builder.append(fsrcorg);
		builder.append(", fdestorg=");
		builder.append(fdestorg);
		builder.append(", ftaxrate=");
		builder.append(ftaxrate);
		builder.append(", fqpcstr=");
		builder.append(fqpcstr);
		builder.append(", fqpc=");
		builder.append(fqpc);
		builder.append("]");
		return builder.toString();
	}

}
