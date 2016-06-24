package com.autostreets.biz.auction.model;

import java.util.Date;

import com.autostreets.biz.auction.model.base.BaseAuctionUploadLog;

public class AuctionUploadLog extends BaseAuctionUploadLog {

    private static final long serialVersionUID = 4356695009337965161L;
    
    private Date startTime;
    
    private Date endTime;
    
    private String createByName;
    
    private String title;
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getAuctionDate() {
		return auctionDate;
	}

	public void setAuctionDate(Date auctionDate) {
		this.auctionDate = auctionDate;
	}

	private Date auctionDate;
    
    public AuctionUploadLog() {
        super();
    }
    
    public AuctionUploadLog(Integer id, Integer auctionId, Integer operType, Integer memberNum, Integer vehicleNum, Integer dealNum, Date createTime, Integer createdBy) {
    	super(id,auctionId,operType,memberNum,vehicleNum,dealNum,createTime,createdBy);
    }

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}
}