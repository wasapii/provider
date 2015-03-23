package com.trasin.provider.haiding.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trasin.provider.haiding.dao.AsnDao;
import com.trasin.provider.haiding.entity.Asn;
import com.trasin.provider.haiding.entity.AsnProduct;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

/**
 * <p>
 * Project Name: provider <br>
 * Description: <br>
 * File Name: AsnDaoImpl.java <br>
 * Copyright: Copyright (C) 2014 All Rights Reserved. <br>
 * Company: 浙江元幸信息科技有限公司 <br>
 * 
 * @author: zgxh
 * @email: vegaxh@gmail.com
 * @create time：2015年3月7日 下午10:17:17
 * @version: v1.1
 * 
 *           Date Author Version Description
 *           ------------------------------------------------------------------
 *           2015年3月7日 下午10:17:17 |zgxh 　　 |v1.1 |Create
 * 
 */

@Repository
public class AsnDaoImpl extends BaseDaoImpl implements AsnDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Asn> getAsnsByStoreCode(String StoreCode) {
		String sql = "SELECT t.ASN_SN AS NUM , (select customer_code from dwtx where dwtxid = t.dwtxid) AS FVDRCODE, t.FEXPIREDATE AS FEXPECTEDDATE,t.FEXPECTEDDATE AS FEXPIREDATE , t.CZY AS FFILLER,t.BZ AS FMEMO FROM cg_htjhd t WHERE t.issend_logistics = 0 and t.djlx = 1 and t.`STOREID` = (select storeid from kc_ck where ckbm = '"
				+ StoreCode + "')";
		return (List<Asn>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Asn>(
				Asn.class));
	}

	@Override
	public List<AsnProduct> getProductsByAsnNo(String asnNo) {
		String sql = "SELECT cg.`ASN_SN` AS NUM,t.product_no AS LINE, dm.`PRODUCT_CODE`AS FARTICLECODE, t.`SL` AS FQTY, t.`HSDJ` AS FPRICE,'0' AS FTAXRATE,'1*1' AS FQPCSTR,'1'AS FQPC FROM cg_htjhdhw t LEFT JOIN kc_dm dm ON dm.cpid = t.`CPID` LEFT JOIN cg_htjhd cg ON cg.`JHDID` = t.`JHDID` WHERE cg.asn_sn = '"
				+ asnNo + "';";
		return (List<AsnProduct>) jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<AsnProduct>(AsnProduct.class));
	}

	@Override
	public void updateById(String id) {

	}

	@Override
	public int addAsn(final Asn oAsn) {
		StringBuffer sql = new StringBuffer(
				"insert into MIS_WM_TSTKINORD(NUM, FCLS, FVENDOR, FVDRCODE, FEXPECTEDDATE,");
		sql.append("FEXPIREDATE, FSRC, FWRH, FFILLER, FCREATETIME,")
				.append("FSENDTIME, FRTNINFO, FMEMO, FSRCORG, FDESTORG")
				// .append("FACTION, FRESULT")
				.append(") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		return jdbcTemplate.update(sql.toString(),
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, oAsn.getNum());
						ps.setString(2, oAsn.getFcls());
						ps.setInt(3, oAsn.getFvendor());
						ps.setString(4, oAsn.getFvdrcode());
						ps.setDate(5, oAsn.getFexpecteddate());
						ps.setDate(6, oAsn.getFexpiredate());
						ps.setString(7, oAsn.getFsrc());
						ps.setString(8, oAsn.getFwrh());
						ps.setString(9, oAsn.getFfiller());
						ps.setTimestamp(10, oAsn.getFcreatetime());
						ps.setTimestamp(11, oAsn.getFsendtime());
						ps.setString(12, oAsn.getFrtninfo());
						ps.setString(13, oAsn.getFmemo());
						ps.setString(14, oAsn.getFsrc());
						ps.setString(15, oAsn.getFdestorg());
						// ps.setString(16, oAsn.getFaction());
						// ps.setString(17, oAsn.getFresult());
					}

				});
	}

	@Override
	public int addAsnProduct(final AsnProduct asnProduct) {
		StringBuffer sql = new StringBuffer(
				"insert into MIS_WM_TSTKINORDDTL(NUM, LINE, FARTICLE, FARTICLECODE, FQTY, ");
		sql.append("FPRICE, FSENDTIME, FSRCORG, FDESTORG, FTAXRATE, ")
				.append("FQPCSTR, FQPC)")
				.append("values(?,?,?,?,?,?,?,?,?,?,?,?)");

		return jdbcTemplate.update(sql.toString(),
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, asnProduct.getNum());
						ps.setInt(2, Integer.parseInt(asnProduct.getLine()));
						ps.setInt(3, asnProduct.getFarticle());
						ps.setString(4, asnProduct.getFarticlecode());
						ps.setDouble(5, asnProduct.getFqty());
						ps.setDouble(6, asnProduct.getFprice());
						ps.setTimestamp(7, asnProduct.getFsendtime());
						ps.setString(8, asnProduct.getFsrcorg());
						ps.setString(9, asnProduct.getFdestorg());
						ps.setInt(10, asnProduct.getFtaxrate());
						ps.setString(11, asnProduct.getFqpcstr());
						ps.setInt(12, asnProduct.getFqpc());
					}
				});
	}

	@Override
	public void updateByAsnNo(final Asn asn) {
		jdbcTemplate.update(
				"update cg_htjhd set bz=? ,issend_logistics =? where asn_sn=?",
				new PreparedStatementSetter() {
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, asn.getFmemo());
						ps.setInt(2, 1);
						ps.setString(3, asn.getNum());
					}
				});
	}
}
