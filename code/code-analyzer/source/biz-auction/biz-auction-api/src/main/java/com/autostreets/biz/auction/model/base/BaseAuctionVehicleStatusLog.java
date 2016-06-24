package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.Date;

public class BaseAuctionVehicleStatusLog implements Serializable {

    /**
     */
    private static final long serialVersionUID = -488177708807857508L;

    // 日志标识，流水号，主键
    private Integer id;

    // 拍品标识
    private Integer avId;

    // 操作人【用户标识】
    private Integer createUser;

    // 操作时间
    private Date createTime;

    // 操作之前的状态
    private Integer preStatus;

    // 操作之后的状态
    private Integer postStatus;

    // 备注
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvId() {
        return avId;
    }

    public void setAvId(Integer avId) {
        this.avId = avId;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Integer preStatus) {
        this.preStatus = preStatus;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}