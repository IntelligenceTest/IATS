package com.autostreets.biz.auction.mapper;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.framework.common.dal.GenericMapper;

public interface AuctionVehicleMapper extends GenericMapper<AuctionVehicle, AuctionVehicleExample, Integer> {

    /**
     * 查询拍卖会拍品
     * 
     * @param param
     * @return
     */
    List<Map<String, String>> listAuctionVehicleByAcutionId(Map<String, Integer> param);

    /**
     * 获取拍品数据总条数
     * 
     * @return int
     * @author youpeng.zhang Date: 2015年8月20日 上午9:00:06
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    int selectAuctionVehiclesTotal(AuctionVehicle auctionVehicle);

    /**
     * 获取拍品数据列表
     * 
     * @return List<AuctionVehicle>
     * @author youpeng.zhang Date: 2015年8月20日 上午9:01:00
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<AuctionVehicle> selectAuctionVehicles(AuctionVehicle auctionVehicle);

    /**
     * 通过车辆ID查询车辆信息
     * 
     * @return AuctionVehicle
     * @author youpeng.zhang Date: 2015年8月20日 下午2:36:13
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    AuctionVehicle selectVehicle(AuctionVehicle av);

    /**
     * 查询某条拍品信息
     * 
     * @return void
     * @author youpeng.zhang Date: 2015年8月20日 下午3:05:26
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    AuctionVehicle selectAuctionVehicle(AuctionVehicle av);

    /**
     * 批量设置价格
     * 
     * @param params
     */
    void volumeSetPrice(Map<String, Object> params);

    /**
     * 根据条件获取拍品SID
     * 
     * @return void
     * @author youpeng.zhang Date: 2015年8月25日 上午11:01:14
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    Integer selectAvId(Map<String, Object> params);

    /**
     * 计算昨天以前的同步拍数量
     * 
     * @author youpeng.zhang Date: 2015年5月26日 下午5:20:11
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    int getOnlineAunctionCount();

    /**
     * 判断今天有没同步拍
     * 
     * @author youpeng.zhang Date: 2015年5月26日 下午5:20:14
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    int isOnlineAunction();

    List<AuctionVehicle> findAuctionVehicle1(Map<String, Object> params);

    int countAuctionVehicle1(Map<String, Object> params);

    /**
     * 推荐列表
     * 
     * @return List<AuctionVehicle>
     * @author youpeng.zhang Date: 2015年7月16日 下午4:19:25
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<AuctionVehicle> findAuctionVehicleRecommend();

    /**
     * 移动端用 同步拍城市列表
     * 
     * @return List<String>
     * @author youpeng.zhang Date: 2015年10月22日 上午9:04:20
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<String> getCityList();

    /**
     * 
     * 功能描述: <br>
     * 〈在线拍城市选择列表〉
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<Map<String, Boolean>> getCityListforAuction();

    List<Map<String, Boolean>> getCityListforAuction(Map<String, Object> params);

    int countAuctionVehicle(Map<String, Object> params);

    List<AuctionVehicle> findAuctionVehicle(Map<String, Object> params);

    void resetOnlineEndTime(Map<String, Object> params);

    int getOnceBidAuctionCount(AuctionVehicle auctionVehicle);

    List<AuctionVehicle> getOnceBidAuction(AuctionVehicle auctionVehicle);

    /**
     * @param auctionId
     * @return
     */
    List<AuctionVehicle> getAuctionVehicles(Integer auctionId);

    /**
     * @param avId
     * @return
     */
    AuctionVehicle getAuctionVehicleAndVehicle(Integer avId);

    List<Vehicle> selectStockRemovalAuction(Integer auctionId);

    /**
     * @param auctionId
     * @return
     */
    List<AuctionVehicle> getNextAvList(Integer auctionId);

    int selectOnlineDealSum(Integer auctionIn);

    List<AuctionVehicle> exportCatalog(Auction auction);
}