package com.autostreets.biz.auction.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface AuctionMapper extends GenericMapper<Auction, AuctionExample, Integer> {

    /**
     * @Title: selectAuction
     * @Description: 拍卖会列表加载
     * @param auctionExample
     * @return List<Auction>
     * @throws @author
     *             yanqing.luo
     * @version V1.0
     * @date 2014年7月10日 上午10:59:01
     */
    List<Auction> selectAuction(Integer id);

    /**
     * @Title: updateAuctionStatus
     * @Description: 通过拍卖会标识更新其状态为指定状态
     * @param auctionStatus
     *            指定状态
     * @param auctionSid
     *            拍卖会标识
     * @return int
     * @throws @author
     *             yanqing.luo
     * @version V2.0
     * @date 2014年7月17日 下午2:21:59
     */
    int updateAuctionStatus(@Param("auctionStatus") Integer auctionStatus, @Param("auctionId") Integer auctionId);

    /**
     * @Title: queryVehicleFromAuction
     * @Description: 通过指定拍卖会查询所有车辆拍品ID
     * @param sid
     *            拍卖会标识
     * @param auctionVehicleStatus
     *            拍品状态
     * @return List<HashMap<String,String>>
     * @throws @author
     *             yanqing.luo
     * @version V2.0
     * @date 2014年7月17日 下午3:00:12
     */
    List<Integer> queryVehicleFromAuction(@Param("id") Integer id,
            @Param("auctionVehicleStatus") Integer auctionVehicleStatus);

    /**
     * @Title: updateAuctionVehicleStatus
     * @Description:更新待拍卖拍品状态为指定状态
     * @param auctionVehicleStatus
     *            待更新状态
     * @param auctionSid
     *            拍卖会
     * @param auctionVehicleStatusCond
     *            需要更新状态条件
     * @return int
     * @throws @author
     *             yanqing.luo
     * @version V2.0
     * @date 2014年7月17日 下午6:23:57
     */
    int updateAuctionVehicleStatus(@Param("auctionVehicleStatus") Integer auctionVehicleStatus,
            @Param("auctionId") Integer auctionId, @Param("auctionVehicleStatusCond") Integer auctionVehicleStatusCond);

    /**
     * @Title: updateAuctionVehicleQuantity
     * @Description: 批量更新所有拍卖会的拍品数量
     * @return int
     * @throws @author
     *             yanqing.luo
     * @version V1.0
     * @date 2014年7月19日 下午6:15:50
     */
    int updateAuctionVehicleQuantity();

    /**
     * 前台同步拍列表
     * 
     * @return List<Auction>
     * @author youpeng.zhang Date: 2015年7月15日 上午9:01:32
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<Auction> selectAuctionListFP();

    List<Auction> selectEndAuctionList();

    List<Auction> selectAuctionByOrgIds(Auction auction);
}