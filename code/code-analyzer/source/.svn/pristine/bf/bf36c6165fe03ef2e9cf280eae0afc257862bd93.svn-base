package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.Date;

public class BaseOrderStatusLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8492327910940859997L;

	// 日志标识，流水号，主键
	private Integer id;

	// 拍品标识
	private Integer orderId;

	// 操作人【用户标识】
	private Integer userId;

	// 操作人【用户标识】
	private String memberSid;

	// 用户类型【1.后台用户（user）；2.前台用户（member）】
	private Short userType;

	// 操作时间
	private Date createTime;

	// 操作之前的状态
	private Short prepStatus;

	// 操作之后的状态
	private Short postStatus;

	// 备注
	private String memo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMemberSid() {
		return memberSid;
	}

	public void setMemberSid(String memberSid) {
		this.memberSid = memberSid == null ? null : memberSid.trim();
	}

	public Short getUserType() {
		return userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Short getPrepStatus() {
		return prepStatus;
	}

	public void setPrepStatus(Short prepStatus) {
		this.prepStatus = prepStatus;
	}

	public Short getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(Short postStatus) {
		this.postStatus = postStatus;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}
}