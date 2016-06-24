package com.autostreets.biz.auction.mapper;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.AuctionMemberUpload;
import com.autostreets.biz.auction.model.AuctionMemberUploadExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface AuctionMemberUploadMapper extends
        GenericMapper<AuctionMemberUpload, AuctionMemberUploadExample, Integer> {

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param params
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer deleteUploadData(Map<String, Integer> params);

    void insertBatch(List<AuctionMemberUpload> data);
}