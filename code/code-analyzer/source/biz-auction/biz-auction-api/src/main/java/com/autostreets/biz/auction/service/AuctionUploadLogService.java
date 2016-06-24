package com.autostreets.biz.auction.service;

import com.autostreets.biz.auction.model.AuctionUploadLog;
import com.autostreets.framework.common.dal.Pagination;

public interface AuctionUploadLogService {

    /**
     * @Title: selectAuctionsBypage
     * @Description: 分页查询同步拍数据操作记录
     * @param auctionUploadLog
     *            查询条件
     * @param pagination
     *            分页载体对象
     * @return void 查询数据并装载完成
     * @throws
     * @author dingding
     */
    Pagination selectAuctionUploadLogByPage(Pagination pagination, AuctionUploadLog auctionUploadLog);

    void insertLog(AuctionUploadLog log);
}