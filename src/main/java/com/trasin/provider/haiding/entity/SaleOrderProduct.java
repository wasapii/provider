package com.trasin.provider.haiding.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class SaleOrderProduct extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 单号
	 * */
	private String num;
	
	/**
	 * 行号
	 * */
	private String line;
	
	/**
	 * 货品
	 * */
	private Integer fArticle;
	
	/**
	 * 货品代码
	 * */
	private String fArticleCode;
	
	/**
	 * 数量
	 * */
	private Long fQty ;
	
	/**
	 * 单价
	 * */
	private Double fPrice;
	
	/**
	 * 发送时间
	 * */
	private Timestamp fSendTime;
	
	/**
	 * 备注
	 * */
	private String fMemo;
	
	/**
	 * 来源组织
	 * */
	private String fSrcOrg = "8001";
	
	/**
	 * 目标组织
	 * */
	private String fDestOrg = "";
	
	/**
	 * 仓卡号
	 * */
	private String fWrhCard;
	
	/**
	 * 批发价格
	 * */
	private Double fAlcPrice = 0.0;
	
	/**
	 * 门店进价
	 * */
	private Double fStorePrice = 0.0;
	
	/**
	 * 生产日期
	 * */
	private Date fProduceDate;
	
	/**
	 * 生产日期2
	 * */
	private Long fDirect = 0L;
	
	/**
	 * 规格
	 * */
	private String fQpcstr;
	
	/**
	 * 优惠价格
	 * */
	private Double fFavoPrice = 0.0;
	
	/**
	 * 优惠金额
	 * */
	private Double fFavoTotal = 0.0;

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

	public Integer getfArticle() {
		return fArticle;
	}

	public void setfArticle(Integer fArticle) {
		this.fArticle = fArticle;
	}

	public String getfArticleCode() {
		return fArticleCode;
	}

	public void setfArticleCode(String fArticleCode) {
		this.fArticleCode = fArticleCode;
	}

	public Long getfQty() {
		return fQty;
	}

	public void setfQty(Long fQty) {
		this.fQty = fQty;
	}

	public Double getfPrice() {
		return fPrice;
	}

	public void setfPrice(Double fPrice) {
		this.fPrice = fPrice;
	}

	public Timestamp getfSendTime() {
		return fSendTime;
	}

	public void setfSendTime(Timestamp fSendTime) {
		this.fSendTime = fSendTime;
	}

	public String getfMemo() {
		return fMemo;
	}

	public void setfMemo(String fMemo) {
		this.fMemo = fMemo;
	}

	public String getfSrcOrg() {
		return fSrcOrg;
	}

	public void setfSrcOrg(String fSrcOrg) {
		this.fSrcOrg = fSrcOrg;
	}

	public String getfDestOrg() {
		return fDestOrg;
	}

	public void setfDestOrg(String fDestOrg) {
		this.fDestOrg = fDestOrg;
	}

	public String getfWrhCard() {
		return fWrhCard;
	}

	public void setfWrhCard(String fWrhCard) {
		this.fWrhCard = fWrhCard;
	}

	public Double getfAlcPrice() {
		return fAlcPrice;
	}

	public void setfAlcPrice(Double fAlcPrice) {
		this.fAlcPrice = fAlcPrice;
	}

	public Double getfStorePrice() {
		return fStorePrice;
	}

	public void setfStorePrice(Double fStorePrice) {
		this.fStorePrice = fStorePrice;
	}

	public Date getfProduceDate() {
		return fProduceDate;
	}

	public void setfProduceDate(Date fProduceDate) {
		this.fProduceDate = fProduceDate;
	}

	public Long getfDirect() {
		return fDirect;
	}

	public void setfDirect(Long fDirect) {
		this.fDirect = fDirect;
	}

	public String getfQpcstr() {
		return fQpcstr;
	}

	public void setfQpcstr(String fQpcstr) {
		this.fQpcstr = fQpcstr;
	}

	public Double getfFavoPrice() {
		return fFavoPrice;
	}

	public void setfFavoPrice(Double fFavoPrice) {
		this.fFavoPrice = fFavoPrice;
	}

	public Double getfFavoTotal() {
		return fFavoTotal;
	}

	public void setfFavoTotal(Double fFavoTotal) {
		this.fFavoTotal = fFavoTotal;
	}

	@Override
	public String toString() {
		return String
				.format("SaleOrderProduct [num=%s, line=%s, fArticle=%s, fArticleCode=%s, fQty=%s, fPrice=%s, fSendTime=%s, fMemo=%s, fSrcOrg=%s, fDestOrg=%s, fWrhCard=%s, fAlcPrice=%s, fStorePrice=%s, fProduceDate=%s, fDirect=%s, fQpcstr=%s, fFavoPrice=%s, fFavoTotal=%s]",
						num, line, fArticle, fArticleCode, fQty, fPrice,
						fSendTime, fMemo, fSrcOrg, fDestOrg, fWrhCard,
						fAlcPrice, fStorePrice, fProduceDate, fDirect, fQpcstr,
						fFavoPrice, fFavoTotal);
	}
	
}
