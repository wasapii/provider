package com.trasin.provider.haiding.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.trasin.provider.haiding.dao.SaleOrderDao;
import com.trasin.provider.haiding.entity.SaleOrder;
import com.trasin.provider.haiding.entity.SaleOrderProduct;

@Repository
public class SaleOrderDaoImpl extends BaseDaoImpl implements SaleOrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SaleOrder> getSalesOrderByStoreCode(String storeCode) {
		String sql = "SELECT t.`TCODE` AS NUM,(SELECT usercard FROM wz_user WHERE personid = t.`USERID`) AS FSTORECODE,"
				+ "t.`CZY` AS FFILLER ,t.`SHRQ` AS FALCTIME,t.`BZ` AS FMEMO,T.`ZJE` AS FFAVOTOTAL,T.`TCODE` AS FCSTNUM ,"
				+ "T.`ORIGIN_ORDER` AS FCSTSRCNUM,T.`RECEIVER` AS FRCVNAME,T.`NEWMOBILE` AS FRCVTEL, (SELECT delmodeareaname FROM  xs_delmode_area WHERE delmodeareaid=T.`PROVINCE`) AS fRcvAddProv,"
				+ "(SELECT delmodeareaname FROM  xs_delmode_area WHERE delmodeareaid=T.`CITY`) AS FRCVADDCITY,(SELECT delmodeareaname FROM  xs_delmode_area WHERE delmodeareaid=T.`COUNTY`) AS FRCVADDDIST,T.`NEWADD` AS FRCVADDRESS,T.`linkcode` AS FRCVZIP,"
				+ " t.`kdrq` AS fPurchaserTime,t.`FREIGHT` AS FEXPRESSCHARGE,t.`SHIPTYPE` AS FDELIVERYMETHOD,t.`amount_receivable` AS FRECIVETOTAL ,"
				+ " CASE  WHEN t.`PAYMENT` = 0 THEN '在线支付' ELSE '货到付款' END AS FPAYMETHOD FROM xs_td t "
				+ "WHERE t.issend_logistics = 0 AND t.djlx = 1 AND t.`STOREID` = (SELECT storeid FROM kc_ck WHERE ckbm = '"
				+ storeCode + "');";
		return (List<SaleOrder>) jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<SaleOrder>(SaleOrder.class));
	}
	
	@Override
	public List<SaleOrderProduct> getProductsBySaleOrderNo(String SalesNo) {
		String sql = "SELECT t.`TCODE` AS NUM, mx.`product_no` AS LINE, dm.`PRODUCT_CODE` AS FARTICLECODE,"
				+ "mx.`SL` AS FQTY, mx.`dj` AS FPRICE, mx.`BZ` AS FMEMO, mx.`xsj` AS FALCPRICE FROM xs_tdhw mx "
				+ " LEFT JOIN xs_td t ON t.`TDID` = mx.`TDID`"
				+ " LEFT JOIN kc_dm dm ON dm.`CPID` = mx.`CPID` WHERE t.`TCODE` = '"
				+ SalesNo + "'";
		return (List<SaleOrderProduct>) jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<SaleOrderProduct>(SaleOrderProduct.class));
	}

	@Override
	public int addSaleOrder(final SaleOrder saleOrder) {
		String sql = "insert into MIS_WM_TALCNTC(NUM,FSTORECODE,FALCREASON,FSRC,FWRH,FFILLER,FCREATETIME,FSENDTIME,FALCTIME,FMEMO,FSRCORG,FDESTORG,"
					+"FCLS,FFAVOTOTAL,FCARRIER,FMERCHANT,FCSTNUM,FCSTSRCNUM,FPURCHASER,FPURCHASERTEL,FPURCHASERMSG,FRCVNAME,FRCVTEL,FRCVADDPROV,"
					+"FRCVADDCITY,FRCVADDDIST,FRCVADDRESS,FRCVZIP,FNEEDINVOICE,FINVOICEPRINTTIME,FACCOUNTNUM,FPURCHASETIME,FEXPRESSCHARGE,FPAYMETHOD,"
					+"FDELIVERYMETHOD,FRECIVETOTAL) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, saleOrder.getNum());
						ps.setString(2, saleOrder.getfStoreCode());
						ps.setString(3, saleOrder.getfAlcReason());
						ps.setString(4, saleOrder.getfSrc());
						ps.setString(5, saleOrder.getfWrh());
						ps.setString(6, saleOrder.getfFiller());
						ps.setTimestamp(7, saleOrder.getfCreateTime());
						ps.setTimestamp(8, saleOrder.getfSendTime());
						ps.setTimestamp(9, saleOrder.getfAlcTime());
						ps.setString(10, saleOrder.getfMemo());
						ps.setString(11, saleOrder.getfSrcOrg());
						ps.setString(12, saleOrder.getfDestOrg());
						ps.setString(13, saleOrder.getfCls());
						ps.setDouble(14, saleOrder.getfFavoTotal());
						ps.setString(15, saleOrder.getfCarrier());
						ps.setString(16, saleOrder.getfMerchant());
						ps.setString(17, saleOrder.getfCstNum());
						ps.setString(18, saleOrder.getfCstSrcNum());
						ps.setString(19, saleOrder.getfPurchaser());
						ps.setString(20, saleOrder.getfPurchaserTel());
						ps.setString(21, saleOrder.getfPurchaserMsg());
						ps.setString(22, saleOrder.getfRcvName());
						ps.setString(23, saleOrder.getfRcvTel());
						ps.setString(24, saleOrder.getfRcvAddProv());
						ps.setString(25, saleOrder.getfRcvAddCity());
						ps.setString(26, saleOrder.getfRcvAddDist());
						ps.setString(27, saleOrder.getfRcvAddRess());
						ps.setString(28, saleOrder.getfRcvZip());
						ps.setInt(29, saleOrder.getfNeedInvoice());
						ps.setTimestamp(30, saleOrder.getfInvoicePrintTime());
						ps.setString(31, saleOrder.getfAccountNum());
						ps.setTimestamp(32, saleOrder.getfPurchaserTime());
						ps.setDouble(33, saleOrder.getfExpressCharge());
						ps.setString(34, saleOrder.getfPayMethod());
						ps.setString(35, saleOrder.getfDeliveryMethod());
						ps.setDouble(36, saleOrder.getfReciveTotal());
					}
				});
	}

	@Override
	public int addSaleOrderProduct(final SaleOrderProduct saleOrderProduct) {
		String sql = "insert into MIS_WM_TALCNTCDTL(NUM,LINE,FARTICLE,FARTICLECODE,FQTY,FPRICE,FSENDTIME,FMEMO,"
					+"FSRCORG,FDESTORG,FWRHCARD,FALCPRICE,FSTOREPRICE,FPRODUCEDATE,FDIRECT,FQPCSTR,FFAVOPRICE,FFAVOTOTAL"
					+") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	return jdbcTemplate.update(sql,
			new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setString(1, saleOrderProduct.getNum());
					ps.setInt(2, Integer.parseInt(saleOrderProduct.getLine()));
					ps.setInt(3, saleOrderProduct.getfArticle());
					ps.setString(4, saleOrderProduct.getfArticleCode());
					ps.setLong(5, saleOrderProduct.getfQty());
					ps.setDouble(6, saleOrderProduct.getfPrice());
					ps.setTimestamp(7, saleOrderProduct.getfSendTime());
					ps.setString(8,saleOrderProduct.getfMemo());
					ps.setString(9, saleOrderProduct.getfSrcOrg());
					ps.setString(10, saleOrderProduct.getfDestOrg());
					ps.setString(11, saleOrderProduct.getfWrhCard());
					ps.setDouble(12, saleOrderProduct.getfAlcPrice());
					ps.setDouble(13, saleOrderProduct.getfStorePrice());
					ps.setDate(14, saleOrderProduct.getfProduceDate());
					ps.setLong(15, saleOrderProduct.getfDirect());
					ps.setString(16, saleOrderProduct.getfQpcstr());
					ps.setDouble(17, saleOrderProduct.getfFavoPrice());
					ps.setDouble(18, saleOrderProduct.getfFavoTotal());
				}
			});
	}

	@Override
	public void updateBySaleOrderNo(final SaleOrder saleOrder) {
		jdbcTemplate.update(
				"update xs_td set bz=? ,issend_logistics =? where tcode=?",
				new PreparedStatementSetter() {
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, saleOrder.getfMemo());
						ps.setInt(2, 1);
						ps.setString(3, saleOrder.getNum());
					}
				});
	}

}
