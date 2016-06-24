package com.autostreets.biz.auction.service;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.domain.AuctionDataUploadVO;
import com.autostreets.framework.common.dal.Pagination;

public interface AuctionDataUploadService {

    /**
     * 首页分页查询
     * 
     * @param pagination
     * @param auctionDataUploadVO
     * @return
     */
    Pagination selectPage(Pagination pagination, AuctionDataUploadVO auctionDataUploadVO);

    /**
     * 按参拍人查询时查看成交车辆列表
     * 
     * @param auctionDataUploadVO
     * @return
     */
    List<AuctionDataUploadVO> selectVehiclesByAuctionMember(AuctionDataUploadVO auctionDataUploadVO);

    /**
     * 保存上传数据
     * 
     * @param auctionId
     * @param memberList
     * @param avList
     */
    void insertUploadData(Integer crtUserId, Integer auctionId, List<AuctionDataUploadVO> memberList,
            List<AuctionDataUploadVO> avList);

    /**
     * 检查拍卖会是否可以被导入
     * 
     * @param auctionId
     * @return
     */
    boolean uploadCheck(AuctionDataUploadVO auctionDataUploadVO);

    /**
     * 查询拍卖后台指定拍卖会统计信息
     * 
     * @param auctionDataUploadVO
     * @return
     */
    Map<String, Object> loadAuctionInfo(AuctionDataUploadVO auctionDataUploadVO);

    /**
     * 功能描述: 删除指定拍卖会数据<br>
     * 
     * @param auctionId
     */
    boolean deleteUploadData(Integer auctionId, Integer userId);

    /**
     * 功能描述:获取指定拍卖会的上传信息 <br>
     *
     * @param auctionId
     * @return auctionTitle 拍卖会标题<br>
     *         auctionDate 拍卖会日期<br>
     *         auctionVehicleNum 拍卖车辆<br>
     *         auctionSuccessNum 车辆成交数<br>
     *         auctionPersonNum 参拍人数<br>
     */
    Map<String, Object> getUploadFileInfoCount(Integer auctionId);

    /**
     * 功能描述:获取上传的车辆数量，参拍人数量等信息 <br>
     * 
     * @param type
     *            1:按参拍人查看 2：按车辆查看<br>
     * @return type=1:totalDealVolume 总成交额<br>
     *         type=1:auctionDealNum 车辆成交数<br>
     *         type=1:auctionPersonNum 参拍人次<br>
     *         type=1:auctionDistinctPersonNum 参拍人次(去重)<br>
     *         type=1:dealVehicleVolume 成交总额<br>
     *         type=2:vehicleNum 车次<br>
     *         type=2:vehicleDistinctNum 车次(去重)<br>
     *         type=2:dealPersonNum 成交人(去重)<br>
     *         type=2:dealVehicleNum 成交车次<br>
     *         type=2:dealVehicleVolume 成交总额<br>
     *         type=2:unDealVehicleNum 未成交车次<br>
     */
    Map<String, Object> getUploadCalcInfo(Integer type, AuctionDataUploadVO auctionDataUploadVO);

    /**
     * 功能描述: 根据参拍人和拍卖会id获取拍卖的车辆信息<br>
     * 〈功能详细描述〉
     *
     * @param auctionId
     * @param memberSid
     * @param idCardNum
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AuctionDataUploadVO> getVehicleInfoByAuctionPerson(Integer auctionId, String memberSid, String idCardNum,
            Integer UserId);
}