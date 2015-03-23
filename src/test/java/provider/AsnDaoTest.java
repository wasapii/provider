package provider;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trasin.provider.haiding.DatabaseContextHolder;
import com.trasin.provider.haiding.dao.AsnDao;
import com.trasin.provider.haiding.entity.Asn;
import com.trasin.provider.haiding.entity.AsnProduct;
import com.trasin.provider.haiding.service.AsnService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class AsnDaoTest {

	@Autowired
	private AsnDao asnDao;
	
	@Autowired
	private AsnService asnService;
	
	@Test
	public void testMulData() {
	//	List<Asn> asns = asnService.getAllAsnByStoreCode("18767136863");
		//DatabaseContextHolder.setOracleCustomerType();

			Asn asn = new Asn();
			asn.setFvdrcode("0101");
			asnService.addAsn(asn);
	}
	
	public void testMysql() {
		DatabaseContextHolder.setMysqlCustomerType();

		List<Asn> MAsnList = asnDao.getAsnsByStoreCode("18767136863");
		System.out.println(MAsnList.size());
		for (Asn mAsn : MAsnList) {
			System.out.println(mAsn.toString());
		}
		System.out.println(MAsnList.size());
	}

	@Test
	public void testProducts(){
		List<AsnProduct> asnProducts = asnDao.getProductsByAsnNo("6000001");
		for (AsnProduct asnProduct : asnProducts) {
			System.out.println(asnProduct.toString());
		}
		System.out.println(asnProducts.size());
	}
	@Test
	public void testOracle() {
		DatabaseContextHolder.setOracleCustomerType();

		Asn oAsn = new Asn();
		oAsn.setNum("5");
		oAsn.setFvendor(1);
		oAsn.setFvdrcode("2");
		oAsn.setFexpecteddate(new java.sql.Date(System.currentTimeMillis()));
		oAsn.setFexpiredate(new java.sql.Date(System.currentTimeMillis()));
		oAsn.setFsrc("01");
		oAsn.setFwrh("01");
		oAsn.setFfiller("Öî¸ðÏþ");
		oAsn.setFcreatetime(new Timestamp(new Date().getTime()));
		oAsn.setFsendtime(new Timestamp(new Date().getTime()));
		oAsn.setFrtninfo("01");
		oAsn.setFmemo("±¸×¢");
		oAsn.setFsrcorg("Ó²±àÂë");
		oAsn.setFdestorg("Ó²±àÂë");
		oAsn.setFaction("ÑÓÆÚ");
		oAsn.setFresult("³É¹¦");

		int result = asnDao.addAsn(oAsn);
		System.out.println(result);
	}

	@Test
	public void testGetSupplierIdByCode() {
		DatabaseContextHolder.setOracleCustomerType();

		Integer code = asnDao.getSupplierIdByCode("000119");
		System.out.println( code);
		
	}

	@Test
	public void testUpdate(){
		DatabaseContextHolder.setMysqlCustomerType();
		Asn asn = new Asn();
		asn.setNum("6000001");
		asnDao.updateByAsnNo(asn);
	}
	
}
