package com.autostreets.biz.auction.model.base;

import java.io.Serializable;
import java.util.Date;

public class BaseAuctionMessage implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6621115807876977337L;

	private Integer id;

    private Integer auctionId;

    private Integer avId;

    private String content;

    private Date createdTimestamp;

    private String bidSid;

    private String memberSid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Integer getAvId() {
        return avId;
    }

    public void setAvId(Integer avId) {
        this.avId = avId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getBidSid() {
        return bidSid;
    }

    public void setBidSid(String bidSid) {
        this.bidSid = bidSid == null ? null : bidSid.trim();
    }

    public String getMemberSid() {
        return memberSid;
    }

    public void setMemberSid(String memberSid) {
        this.memberSid = memberSid == null ? null : memberSid.trim();
    }
}