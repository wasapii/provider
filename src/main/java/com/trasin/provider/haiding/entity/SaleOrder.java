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
	 * ����
	 * */
	private String num;
	
	/**
	 * �ջ��ŵ�
	 * */
	private String fStoreCode;
	
	/**
	 * ���ԭ��(����������ֿ����)
	 * */
	private String fAlcReason ="�������";
	
	/**
	 * ��Դ��λ
	 * */
	private String fSrc = "8001";
	
	/**
	 * �����ֿ�01�����֣�02�˻���
	 * */
	private String fWrh = "01";
	
	/**
	 * ���
	 * */
	
	private String fFiller;
	
	/**
	 * ����ʱ��
	 * */
	private Timestamp fCreateTime;
	
	/**
	 * ����ʱ��
	 * */
	private Timestamp fSendTime;
	
	/**
	 * ���ʱ��
	 * */
	private Timestamp fAlcTime;
	
	/**
	 * ��ע
	 * */
	private String fMemo;
	
	/**
	 * ��Դ��֯
	 * */
	private String fSrcOrg = "8001";
	
	/**
	 * Ŀ����֯
	 * */
	private String fDestOrg = "";
	
	/**
	 * ����(������������������)
	 * */
	private String fCls = "����";
	
	/**
	 * �ܽ��
	 * */
	private Double fFavoTotal = 0.0;
	
	/**
	 * ������
	 * */
	private String fCarrier = "����";
	
	/**
	 * ����
	 * */
	private String fMerchant = "�̳�";
	
	/**
	 * �������۵���
	 * */
	private String fCstNum;
	
	/**
	 * ƽ̨������
	 * */
	private String fCstSrcNum;
	
	/**
	 * ���ID
	 * */
	private String fPurchaser;
	
	/**
	 * ��ҵ绰
	 * */
	private String fPurchaserTel;
	
	/**
	 * ��ұ�ע
	 * */
	private String fPurchaserMsg;
	
	/**
	 * �ջ���
	 * */
	private String fRcvName;
	
	/**
	 * �ջ��˵绰
	 * */
	private String fRcvTel;
	
	/**
	 * �ջ��˵�ַʡ
	 * */
	private String fRcvAddProv;
	
	/**
	 * �ջ�����
	 * */
	private String fRcvAddCity;
	
	/**
	 * ��
	 * */
	private String fRcvAddDist;
	
	/**
	 * �ջ��˵�ַ
	 * */
	private String fRcvAddRess;
	
	/**
	 * �ʱ�
	 * */
	private String fRcvZip;
	
	/**
	 * ��Ʊ����
	 * */
	private Integer fNeedInvoice = 0;
	
	/**
	 * ��Ʊ��ӡʱ��
	 * */
	private Timestamp fInvoicePrintTime;
	
	/**
	 * �˵���
	 * */
	private String fAccountNum;
	
	/**
	 * ����ʱ��
	 * */
	private Timestamp fPurchaserTime;
	
	/**
	 * �����˷�
	 * */
	private Double fExpressCharge = 0.0;
	
	/**
	 * ֧����ʽ
	 * */
	private String fPayMethod;
	
	/**
	 * ���ͷ�ʽ
	 * */
	private String fDeliveryMethod;
	
	/**
	 * ʵ�ս��
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
