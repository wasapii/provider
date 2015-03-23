package com.trasin.provider.haiding.service;

import java.util.List;

import com.trasin.provider.haiding.entity.Asn;

public interface AsnService {
	
	public void addAsn(Asn mAsn);
	
	public List<Asn> getAllAsnByStoreCode(String StoreCode) ;
	
	public void updateAsn(Asn asn) ;

}
