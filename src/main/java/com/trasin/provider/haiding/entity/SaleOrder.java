package com.trasin.provider.haiding.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SaleOrder extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 单号
	 * */
	private String num;
	
	/**
	 * 收货门店
	 * */
	private String fStoreCode;
	
	/**
	 * 配货原因(正常配货，仓库调拨)
	 * */
	private String fAlcReason ="正常配货";
	
	/**
	 * 来源单位
	 * */
	private String fSrc = "8001";
	
	/**
	 * 出货仓库01正常仓，02退货仓
	 * */
	private String fWrh = "01";
	
	/**
	 * 填单人
	 * */
	
	private String fFiller;
	
	/**
	 * 生成时间
	 * */
	private Timestamp fCreateTime;
	
	/**
	 * 发送时间
	 * */
	private Timestamp fSendTime;
	
	/**
	 * 配货时间
	 * */
	private Timestamp fAlcTime;
	
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
	 * 类型(’正常’，‘调拨’)
	 * */
	private String fCls = "正常";
	
	/**
	 * 总金额
	 * */
	private Double fFavoTotal = 0.0;
	
	/**
	 * 承运商
	 * */
	private String fCarrier = "待定";
	
	/**
	 * 渠道
	 * */
	private String fMerchant = "商城";
	
	/**
	 * 上游销售单号
	 * */
	private String fCstNum;
	
	/**
	 * 平台订单号
	 * */
	private String fCstSrcNum;
	
	/**
	 * 买家ID
	 * */
	private String fPurchaser;
	
	/**
	 * 买家电话
	 * */
	private String fPurchaserTel;
	
	/**
	 * 买家备注
	 * */
	private String fPurchaserMsg;
	
	/**
	 * 收货人
	 * */
	private String fRcvName;
	
	/**
	 * 收货人电话
	 * */
	private String fRcvTel;
	
	/**
	 * 收货人地址省
	 * */
	private String fRcvAddProv;
	
	/**
	 * 收货人市
	 * */
	private String fRcvAddCity;
	
	/**
	 * 区
	 * */
	private String fRcvAddDist;
	
	/**
	 * 收货人地址
	 * */
	private String fRcvAddRess;
	
	/**
	 * 邮编
	 * */
	private String fRcvZip;
	
	/**
	 * 发票需求
	 * */
	private Integer fNeedInvoice = 0;
	
	/**
	 * 发票打印时间
	 * */
	private Timestamp fInvoicePrintTime;
	
	/**
	 * 账单号
	 * */
	private String fAccountNum;
	
	/**
	 * 购买时间
	 * */
	private Timestamp fPurchaserTime;
	
	/**
	 * 代收运费
	 * */
	private Double fExpressCharge = 0.0;
	
	/**
	 * 支付方式
	 * */
	private String fPayMethod;
	
	/**
	 * 配送方式
	 * */
	private String fDeliveryMethod;
	
	/**
	 * 实收金额
	 * */
	private Double fReciveTotal = 0.0;

	private List<SaleOrderProduct> saleOrderProducts = new ArrayList<SaleOrderProduct>();
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getfStoreCode() {
		return fStoreCode;
	}

	public void setfStoreCode(String fStoreCode) {
		this.fStoreCode = fStoreCode;
	}

	public String getfAlcReason() {
		return fAlcReason;
	}

	public void setfAlcReason(String fAlcReason) {
		this.fAlcReason = fAlcReason;
	}

	public String getfSrc() {
		return fSrc;
	}

	public void setfSrc(String fSrc) {
		this.fSrc = fSrc;
	}

	public String getfWrh() {
		return fWrh;
	}

	public void setfWrh(String fWrh) {
		this.fWrh = fWrh;
	}

	public String getfFiller() {
		return fFiller;
	}

	public void setfFiller(String fFiller) {
		this.fFiller = fFiller;
	}

	public Timestamp getfCreateTime() {
		return fCreateTime;
	}

	public void setfCreateTime(Timestamp fCreateTime) {
		this.fCreateTime = fCreateTime;
	}

	public Timestamp getfSendTime() {
		return fSendTime;
	}

	public void setfSendTime(Timestamp fSendTime) {
		this.fSendTime = fSendTime;
	}

	public Timestamp getfAlcTime() {
		return fAlcTime;
	}

	public void setfAlcTime(Timestamp fAlcTime) {
		this.fAlcTime = fAlcTime;
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

	public String getfCls() {
		return fCls;
	}

	public void setfCls(String fCls) {
		this.fCls = fCls;
	}

	public Double getfFavoTotal() {
		return fFavoTotal;
	}

	public void setfFavoTotal(Double fFavoTotal) {
		this.fFavoTotal = fFavoTotal;
	}

	public String getfCarrier() {
		return fCarrier;
	}

	public void setfCarrier(String fCarrier) {
		this.fCarrier = fCarrier;
	}

	public String getfMerchant() {
		return fMerchant;
	}

	public void setfMerchant(String fMerchant) {
		this.fMerchant = fMerchant;
	}

	public String getfCstNum() {
		return fCstNum;
	}

	public void setfCstNum(String fCstNum) {
		this.fCstNum = fCstNum;
	}

	public String getfCstSrcNum() {
		return fCstSrcNum;
	}

	public void setfCstSrcNum(String fCstSrcNum) {
		this.fCstSrcNum = fCstSrcNum;
	}

	public String getfPurchaser() {
		return fPurchaser;
	}

	public void setfPurchaser(String fPurchaser) {
		this.fPurchaser = fPurchaser;
	}

	public String getfPurchaserTel() {
		return fPurchaserTel;
	}

	public void setfPurchaserTel(String fPurchaserTel) {
		this.fPurchaserTel = fPurchaserTel;
	}

	public String getfPurchaserMsg() {
		return fPurchaserMsg;
	}

	public void setfPurchaserMsg(String fPurchaserMsg) {
		this.fPurchaserMsg = fPurchaserMsg;
	}

	public String getfRcvName() {
		return fRcvName;
	}

	public void setfRcvName(String fRcvName) {
		this.fRcvName = fRcvName;
	}

	public String getfRcvTel() {
		return fRcvTel;
	}

	public void setfRcvTel(String fRcvTel) {
		this.fRcvTel = fRcvTel;
	}

	public String getfRcvAddProv() {
		return fRcvAddProv;
	}

	public void setfRcvAddProv(String fRcvAddProv) {
		this.fRcvAddProv = fRcvAddProv;
	}

	public String getfRcvAddCity() {
		return fRcvAddCity;
	}

	public void setfRcvAddCity(String fRcvAddCity) {
		this.fRcvAddCity = fRcvAddCity;
	}

	public String getfRcvAddDist() {
		return fRcvAddDist;
	}

	public void setfRcvAddDist(String fRcvAddDist) {
		this.fRcvAddDist = fRcvAddDist;
	}

	public String getfRcvAddRess() {
		return fRcvAddRess;
	}

	public void setfRcvAddRess(String fRcvAddRess) {
		this.fRcvAddRess = fRcvAddRess;
	}

	public String getfRcvZip() {
		return fRcvZip;
	}

	public void setfRcvZip(String fRcvZip) {
		this.fRcvZip = fRcvZip;
	}

	public Integer getfNeedInvoice() {
		return fNeedInvoice;
	}

	public void setfNeedInvoice(Integer fNeedInvoice) {
		this.fNeedInvoice = fNeedInvoice;
	}

	public Timestamp getfInvoicePrintTime() {
		return fInvoicePrintTime;
	}

	public void setfInvoicePrintTime(Timestamp fInvoicePrintTime) {
		this.fInvoicePrintTime = fInvoicePrintTime;
	}

	public String getfAccountNum() {
		return fAccountNum;
	}

	public void setfAccountNum(String fAccountNum) {
		this.fAccountNum = fAccountNum;
	}

	public Timestamp getfPurchaserTime() {
		return fPurchaserTime;
	}

	public void setfPurchaserTime(Timestamp fPurchaserTime) {
		this.fPurchaserTime = fPurchaserTime;
	}

	public Double getfExpressCharge() {
		return fExpressCharge;
	}

	public void setfExpressCharge(Double fExpressCharge) {
		this.fExpressCharge = fExpressCharge;
	}

	public String getfPayMethod() {
		return fPayMethod;
	}

	public void setfPayMethod(String fPayMethod) {
		this.fPayMethod = fPayMethod;
	}

	public String getfDeliveryMethod() {
		return fDeliveryMethod;
	}

	public void setfDeliveryMethod(String fDeliveryMethod) {
		this.fDeliveryMethod = fDeliveryMethod;
	}

	public Double getfReciveTotal() {
		return fReciveTotal;
	}

	public void setfReciveTotal(Double fReciveTotal) {
		this.fReciveTotal = fReciveTotal;
	}

	public List<SaleOrderProduct> getSaleOrderProducts() {
		return saleOrderProducts;
	}

	public void setSaleOrderProducts(List<SaleOrderProduct> saleOrderProducts) {
		this.saleOrderProducts = saleOrderProducts;
	}

	@Override
	public String toString() {
		return String
				.format("SaleOrder [num=%s, fStoreCode=%s, fAlcReason=%s, fSrc=%s, fWrh=%s, fFiller=%s, fCreateTime=%s, fSendTime=%s, fAlcTime=%s, fMemo=%s, fSrcOrg=%s, fDestOrg=%s, fCls=%s, fFavoTotal=%s, fCarrier=%s, fMerchant=%s, fCstNum=%s, fCstSrcNum=%s, fPurchaser=%s, fPurchaserTel=%s, fPurchaserMsg=%s, fRcvName=%s, fRcvTel=%s, fRcvAddProv=%s, fRcvAddCity=%s, fRcvAddDist=%s, fRcvAddRess=%s, fRcvZip=%s, fNeedInvoice=%s, fInvoicePrintTime=%s, fAccountNum=%s, fPurchaserTime=%s, fExpressCharge=%s, fPayMethod=%s, fDeliveryMethod=%s, fReciveTotal=%s, saleOrderProducts=%s]",
						num, fStoreCode, fAlcReason, fSrc, fWrh, fFiller,
						fCreateTime, fSendTime, fAlcTime, fMemo, fSrcOrg,
						fDestOrg, fCls, fFavoTotal, fCarrier, fMerchant,
						fCstNum, fCstSrcNum, fPurchaser, fPurchaserTel,
						fPurchaserMsg, fRcvName, fRcvTel, fRcvAddProv,
						fRcvAddCity, fRcvAddDist, fRcvAddRess, fRcvZip,
						fNeedInvoice, fInvoicePrintTime, fAccountNum,
						fPurchaserTime, fExpressCharge, fPayMethod,
						fDeliveryMethod, fReciveTotal, saleOrderProducts);
	}
	
}
