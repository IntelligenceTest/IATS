package com.autostreets.biz.auction.mapper;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.domain.AuctionDataUploadVO;
import com.autostreets.biz.auction.model.AuctionDataUpload;
import com.autostreets.biz.auction.model.AuctionDataUploadExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface AuctionDataUploadMapper extends GenericMapper<AuctionDataUpload, AuctionDataUploadExample, Integer> {

    int countByAuctionMember(AuctionDataUploadVO auctionDataUploadVO);

    List<AuctionDataUploadVO> selectByAuctionMember(AuctionDataUploadVO auctionDataUploadVO);

    void auctionMemberUploadInsert(AuctionDataUploadVO auctionDataUploadVO);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param auctionId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer deleteUploadData(Map<String, Integer> params);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param auctionDataUploadVO
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> getUploadMemberCalcInfo(AuctionDataUploadVO auctionDataUploadVO);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param auctionDataUploadVO
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AuctionDataUploadVO> getVehicleInfoByAuctionPerson(AuctionDataUploadVO auctionDataUploadVO);

    /**
     * 
     * 功能描述: <br>
     * 按车辆查看总数
     *
     * @author dongling.qu
     * @param auctionDataUploadVO
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int countByAuctionVehicle(AuctionDataUploadVO auctionDataUploadVO);

    /**
     * 
     * 功能描述: <br>
     * 按车辆查看列表
     *
     * @param auctionDataUploadVO
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AuctionDataUploadVO> selectByAuctionVehicle(AuctionDataUploadVO auctionDataUploadVO);

    /**
     * 
     * 功能描述: <br>
     * 〈批量插入数据〉
     *
     * @param dataUploads
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void insertBatch(List<AuctionDataUpload> dataUploads);

}