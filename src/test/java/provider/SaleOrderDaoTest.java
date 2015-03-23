package provider;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trasin.provider.haiding.DatabaseContextHolder;
import com.trasin.provider.haiding.dao.SaleOrderDao;
import com.trasin.provider.haiding.entity.SaleOrder;
import com.trasin.provider.haiding.entity.SaleOrderProduct;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class SaleOrderDaoTest {

	@Autowired
	private SaleOrderDao saleOrderDao;
	
	@Test
	public void testMysql() {
		DatabaseContextHolder.setMysqlCustomerType();

		List<SaleOrder> MAsnList = saleOrderDao.getSalesOrderByStoreCode("NJADD");
		System.out.println(MAsnList.size());
		for (SaleOrder saleOrder : MAsnList) {
			System.out.println(saleOrder);
		}
	}

	@Test
	public void testProducts(){
		List<SaleOrderProduct> asnProducts = saleOrderDao.getProductsBySaleOrderNo("201503116820682");
		for (SaleOrderProduct saleOrderProduct : asnProducts) {
			System.out.println(saleOrderProduct);
		}
		System.out.println(asnProducts.size());
	}
	@Test
	public void testOracle() {
		DatabaseContextHolder.setOracleCustomerType();
		/*SaleOrder saleOrder = new SaleOrder();
		saleOrder.setNum("123");
		saleOrder.setfStoreCode("123");
		saleOrder.setfAlcReason("Õý³£");
		saleOrder.setfSrc("123");
		saleOrder.setfWrh("123");
		saleOrder.setfFiller("123");
		saleOrder.setfCreateTime(new Timestamp(new Date().getTime()));
		saleOrder.setfSendTime(new Timestamp(new Date().getTime()));
		saleOrder.setfNeedInvoice("123");
		saleOrderDao.addSaleOrder(saleOrder);*/
		
		
		SaleOrderProduct orderProduct = new SaleOrderProduct();
		orderProduct.setNum("123");
		orderProduct.setLine("123");
		orderProduct.setfArticle(123);
		orderProduct.setfArticleCode("123");
		orderProduct.setfQty(10L);
		orderProduct.setfPrice(1.2);
		orderProduct.setfSendTime(new Timestamp(new Date().getTime()));
		saleOrderDao.addSaleOrderProduct(orderProduct);
	}


	@Test
	public void testUpdate(){
		DatabaseContextHolder.setMysqlCustomerType();
	}
	
}
