package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseBid implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5817107184135463825L;

	// 主键
	private Integer id;

	// 拍品id
	private Integer auctionVehicleId;

	// 竞拍人sid
	private String bidderSid;

	// 竞拍人姓名
	private String bidderName;

	// 竞拍人账号
	private String bidderUsername;

	// 出价时间
	private Date bidTimestamp;

	// 原始价
	private BigDecimal originPrice;

	// 价格
	private BigDecimal price;

	// 竞拍人IP
	private String ip;

	// 是否是提示信息
	private Boolean msg;

	// 消息内容
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAuctionVehicleId() {
		return auctionVehicleId;
	}

	public void setAuctionVehicleId(Integer auctionVehicleId) {
		this.auctionVehicleId = auctionVehicleId;
	}

	public String getBidderSid() {
		return bidderSid;
	}

	public void setBidderSid(String bidderSid) {
		this.bidderSid = bidderSid == null ? null : bidderSid.trim();
	}

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName == null ? null : bidderName.trim();
	}

	public String getBidderUsername() {
		return bidderUsername;
	}

	public void setBidderUsername(String bidderUsername) {
		this.bidderUsername = bidderUsername == null ? null : bidderUsername.trim();
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
		this.ip = ip == null ? null : ip.trim();
	}

	public Boolean getMsg() {
		return msg;
	}

	public void setMsg(Boolean msg) {
		this.msg = msg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}