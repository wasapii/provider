package provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import com.trasin.provider.haiding.service.AsnService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class AsnServiceTest {
	
	@Autowired
	private AsnService asnService;
	
	@Test
	public void testGetAllAsns() {
		asnService.getAllAsnByStoreCode("20150213222");
	}
}
