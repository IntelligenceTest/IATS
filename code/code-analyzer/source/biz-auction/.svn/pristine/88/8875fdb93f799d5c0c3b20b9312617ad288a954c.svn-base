/**
 * @Title: BidReportVO.java
 * @Package com.autostreets.model.report
 * @Description:
 * @author yanqing.luo （roceys#gmail.com）
 * @date 2014年11月4日 下午2:15:54
 * @version V1.0
 * @Copyright: 2014 www.autostreets.com Inc. All rights reserved.
 * 本内容仅限于汽车街(AUTOSTREETS)内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.autostreets.biz.auction.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autostreets.framework.common.dal.Pagination;

/**
 * @ClassName: BidReportVO
 * @Description:出价记录vo
 * @author yanqing.luo （roceys#gmail.com）
 * @date 2014年11月4日 下午2:15:54
 * @version V1.0
 */
public class BidReportVO implements Serializable {
	private static final long serialVersionUID = -7230177533603317661L;
	private Integer id;
	private Integer auctionVehicleId;
	private String bidderSid;
	private String bidderName;
	private String bidderUsername;
	private Date bidTimestamp;
	private BigDecimal originPrice;
	private BigDecimal price;
	private String ip;
	private Date startTimestamp;// 查询条件开始时间
	private Date endTimestamp;
	private String bidderType;
	private List<String> insiders = new ArrayList<>(); // 内部人员账户名单
	private Pagination pagination;// 分页

	/**
	 * 添加出价记录报表查询内容 code 车辆编号 count 出价次数 maxprice 最高出价
	 * 
	 * @update by chao.duan
	 * @date 2014年12月22日 下午17:50:02
	 */
	private String code;
	private Integer count;
	private BigDecimal maxPrice;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Date getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Date endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public List<String> getInsiders() {
		return insiders;
	}

	public void setInsiders(List<String> insiders) {
		this.insiders = insiders;
	}

	public String getBidderType() {
		return bidderType;
	}

	public void setBidderType(String bidderType) {
		this.bidderType = bidderType;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getBidderSid() {
		return bidderSid;
	}

	public void setBidderSid(String bidderSid) {
		this.bidderSid = bidderSid;
	}

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	public String getBidderUsername() {
		return bidderUsername;
	}

	public void setBidderUsername(String bidderUsername) {
		this.bidderUsername = bidderUsername;
	}

	public Date getBidTimestamp() {
		return bidTimestamp;
	}

	public void setBidTimestamp(Date bidTimestamp) {
		this.bidTimestamp = bidTimestamp;
	}

	public BigDecimal getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(BigDecimal originPrice) {
		this.originPrice = originPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the auctionVehicleId
	 */
	public Integer getAuctionVehicleId() {
		return auctionVehicleId;
	}

	/**
	 * @param auctionVehicleId
	 *            the auctionVehicleId to set
	 */
	public void setAuctionVehicleId(Integer auctionVehicleId) {
		this.auctionVehicleId = auctionVehicleId;
	}
}
