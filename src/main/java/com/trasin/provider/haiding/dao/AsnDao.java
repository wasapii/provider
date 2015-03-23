package com.trasin.provider.haiding.dao;

import java.util.List;

import com.trasin.provider.haiding.entity.Asn;
import com.trasin.provider.haiding.entity.AsnProduct;

/**
 * <p>
 * Project Name: provider <br>
 * Description: <br>
 * File Name: AsnDao.java <br>
 * Copyright: Copyright (C) 2014 All Rights Reserved. <br>
 * Company: 浙江元幸信息科技有限公司 <br>
 * 
 * @author: zgxh
 * @email: vegaxh@gmail.com
 * @create time：2015年3月7日 下午10:17:50
 * @version: v1.1
 * 
 *           Date Author Version Description
 *           ------------------------------------------------------------------
 *           2015年3月7日 下午10:17:50 |zgxh 　　 |v1.1 |Create
 * 
 */

public interface AsnDao extends BaseDao {

	public List<AsnProduct> getProductsByAsnNo(String asnNo);

	public void updateById(String id);

	public int addAsn(Asn oAsn);

	public int addAsnProduct(AsnProduct asnProduct);
	
	public List<Asn> getAsnsByStoreCode(String storeCode);

	public void updateByAsnNo(Asn asn);
}
