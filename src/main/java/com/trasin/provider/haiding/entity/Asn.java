package com.trasin.provider.haiding.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Project Name: provider <br>
 * Description: �ɹ���ʵ��<br>
 * File Name: Asn.java <br>
 * Copyright: Copyright (C) 2014 All Rights Reserved. <br>
 * Company: �㽭Ԫ����Ϣ�Ƽ����޹�˾ <br>
 * 
 * @author: zgxh
 * @email: vegaxh@gmail.com
 * @create time��2015��3��7�� ����9:34:07
 * @version: v1.1
 * 
 *           Date Author Version Description
 *           ------------------------------------------------------------------
 *           2015��3��7�� ����9:34:07 |zgxh ���� |v1.1 |Create
 * 
 */

public class Asn extends BaseEntity {

	private String num;

	/**
	 * �ɹ�������
	 */
	private String fcls = "0";

	/**
	 * ��Ӧ��Id��ERP��ȱ�����ṩ
	 */
	private Integer fvendor;

	/**
	 * provider_no ��Ӧ��CODE
	 */
	private String fvdrcode;

	/**
	 * �������� FEXPECTEDDATE
	 */
	private Date fexpecteddate;

	/**
	 * ʧЧ����
	 */
	private Date fexpiredate;

	/**
	 * ��Դ��λ
	 * */
	private String fsrc = "8001";

	/**
	 * �ջ���λ
	 */
	private String fwrh = "01";

	/**
	 * ���
	 */
	private String ffiller = "Ĭ��";

	/**
	 * ����ʱ��
	 */
	private Timestamp fcreatetime;

	/**
	 * ����ʱ��
	 */
	private Timestamp fsendtime;

	/**
	 * �˻���Ϣ
	 */
	private String frtninfo;

	/**
	 * ��ע
	 */
	private String fmemo;

	/**
	 * ��Դ��֯
	 */
	private String fsrcorg = "8001";

	/**
	 * Ŀ����֯
	 */
	private String fdestorg = "";

	/**
	 * ���� ����/�ر�
	 */
	private String faction = "";

	/**
	 * ��� �ɹ�/ʧ��
	 */
	private String fresult;

	private List<AsnProduct> products = new ArrayList<AsnProduct>();

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getFcls() {
		return fcls;
	}

	public void setFcls(String fcls) {
		this.fcls = fcls;
	}

	public Integer getFvendor() {
		return fvendor;
	}

	public void setFvendor(Integer fvendor) {
		this.fvendor = fvendor;
	}

	public String getFvdrcode() {
		return fvdrcode;
	}

	public void setFvdrcode(String fvdrcode) {
		this.fvdrcode = fvdrcode;
	}

	public Date getFexpecteddate() {
		return fexpecteddate;
	}

	public void setFexpecteddate(Date fexpecteddate) {
		this.fexpecteddate = fexpecteddate;
	}

	public Date getFexpiredate() {
		return fexpiredate;
	}

	public void setFexpiredate(Date fexpiredate) {
		this.fexpiredate = fexpiredate;
	}

	public String getFsrc() {
		return fsrc;
	}

	public void setFsrc(String fsrc) {
		this.fsrc = fsrc;
	}

	public String getFwrh() {
		return fwrh;
	}

	public void setFwrh(String fwrh) {
		this.fwrh = fwrh;
	}

	public String getFfiller() {
		return ffiller;
	}

	public void setFfiller(String ffiller) {
		this.ffiller = ffiller;
	}

	public Timestamp getFcreatetime() {
		return fcreatetime;
	}

	public void setFcreatetime(Timestamp fcreatetime) {
		this.fcreatetime = fcreatetime;
	}

	public Timestamp getFsendtime() {
		return fsendtime;
	}

	public void setFsendtime(Timestamp fsendtime) {
		this.fsendtime = fsendtime;
	}

	public String getFmemo() {
		return fmemo;
	}

	public void setFmemo(String fmemo) {
		this.fmemo = fmemo;
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

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getFresult() {
		return fresult;
	}

	public void setFresult(String fresult) {
		this.fresult = fresult;
	}

	public String getFrtninfo() {
		return frtninfo;
	}

	public void setFrtninfo(String frtninfo) {
		this.frtninfo = frtninfo;
	}

	public List<AsnProduct> getProducts() {
		return products;
	}

	public void setProducts(List<AsnProduct> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OAsn [num=");
		builder.append(num);
		builder.append(", fcls=");
		builder.append(fcls);
		builder.append(", fvendor=");
		builder.append(fvendor);
		builder.append(", fvdrcode=");
		builder.append(fvdrcode);
		builder.append(", fexpecteddate=");
		builder.append(fexpecteddate);
		builder.append(", fexpiredate=");
		builder.append(fexpiredate);
		builder.append(", fsrc=");
		builder.append(fsrc);
		builder.append(", fwrh=");
		builder.append(fwrh);
		builder.append(", ffiller=");
		builder.append(ffiller);
		builder.append(", fcreatetime=");
		builder.append(fcreatetime);
		builder.append(", fsendtime=");
		builder.append(fsendtime);
		builder.append(", frtninfo=");
		builder.append(frtninfo);
		builder.append(", fmemo=");
		builder.append(fmemo);
		builder.append(", fsrcorg=");
		builder.append(fsrcorg);
		builder.append(", fdestorg=");
		builder.append(fdestorg);
		builder.append(", faction=");
		builder.append(faction);
		builder.append(", fresult=");
		builder.append(fresult);
		builder.append(", products=");
		builder.append(products);
		builder.append("]");
		return builder.toString();
	}

}
