package com.autostreets.biz.auction.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.pagination.Pagination1;
import com.autostreets.biz.workflow.exception.WorkflowException;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface AuctionVehicleService extends GenericService<AuctionVehicle, AuctionVehicleExample, Integer> {

    Pagination1<AuctionVehicle> selectOnlinePage(Integer price, Integer age, Integer mileage, String city,
            boolean recommend, Integer dateflag, Integer status, int pageNumber, int pageSize);

    Map<String, Object> loadVehicleInfo(Integer avId, String loginUserId);

    /**
     * 查询拍卖会拍品
     * 
     * @param param
     * @return
     */
    List<Map<String, String>> listAuctionVehicleByAcutionId(Map<String, Integer> param);

    /**
     * 分页查询加载拍品管理首页
     * 
     * @return void
     * @author youpeng.zhang Date: 2015年8月20日 上午8:57:41
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    Pagination selectAuctionVehicles(Pagination pagination, AuctionVehicle auctionVehicle);

    /**
     * 查询某一车辆信息
     * 
     * @return AuctionVehicle
     * @author youpeng.zhang Date: 2015年8月20日 下午2:31:59
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    AuctionVehicle selectVehicle(AuctionVehicle av);

    /**
     * 查询某条拍品信息
     * 
     * @return void
     * @author youpeng.zhang Date: 2015年8月20日 下午2:41:42
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    AuctionVehicle selectAuctionVehicle(AuctionVehicle av);

    /**
     * 跟新拍品表的一条记录
     * 
     * @param av
     */
    public int updateAuctionVehicle(AuctionVehicle av);

    //
    // /**
    // * @Title: updateVehicleSaleStatus
    // * @Description: 更新车辆销售状态为指定状态，可根据某一状态筛选
    // * @param saleStatus 要更新的状态
    // * @param saleStatusCond 筛选状态
    // * @param vehicleSid 车辆id
    // * @return int
    // * @throws
    // * @author yanqing.luo
    // * @version V2.0
    // * @date 2014年7月13日 下午2:10:07
    // */
    // int updateVehicleSaleStatus(String saleStatus, String saleStatusCond,
    // String vehicleSid);

    /**
     * 更新拍卖会车辆序号
     * 
     * @param sid
     * @param auctionId
     */
    void updateAuctionVehicleOrder(Integer[] sid, Integer[] auctionVehicleOrder);

    /**
     * 根据条件获取拍品SID
     * 
     * @return void
     * @author youpeng.zhang Date: 2015年8月25日 上午11:01:14
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    Integer selectAvId(Map<String, Object> params);

    List<AuctionVehicle> findAuctionVehicle1(Map<String, Object> params);

    //
    // /**
    // * @Title: updateAuctionVehicleOrders
    // * @Description: 批量更新拍品顺序
    // * @param currentAuctionSid 变更至当前的拍卖会
    // * @param oldAuctionSid 拍品原来所属拍卖会
    // * @return void
    // * @throws
    // * @author yanqing.luo
    // * @version V1.0
    // * @date 2014年7月27日 上午2:14:53
    // */
    // void updateAuctionVehicleOrders(String currentAuctionSid, String
    // oldAuctionSid);
    //

    int countAuctionVehicle(Map<String, Object> params);

    int countAuctionVehicle1(Map<String, Object> params);

    // List<AuctionVehicle> findAuctionVehicle2(AuctionVehicle auctionVehicle);

    List<AuctionVehicle> findAuctionVehicle(Map<String, Object> params);

    //
    // void updateAuctionVehicleFail(String avId);
    //

    void updateAuctionVehicleComplete(Integer avId) throws Exception;

    //
    // void resetOnlineEndTime(String avId);
    //
    // void endBid(AuctionVehicle av);
    //
    void createOrder(Integer avId);

    /**
     * 移动端用 在线拍城市列表
     * 
     * @return List<String>
     * @author youpeng.zhang Date: 2015年10月22日 上午9:10:35
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<String> getCityList();

    //
    // /**
    // * 在线拍拍品状态由成交确认转化为流拍
    // *
    // * @param avId
    // */
    // void updateOnlineAVFail(String avId);
    //
    /**
     * 引导成交的功能
     *
     * @param bid
     * @param avSid
     * @return
     */
    boolean updateOnlineComplete(Bid bid, Integer avId) throws Exception;

    //
    // /**
    // *
    // * 功能描述: <br>
    // * 通过多个车辆ID获取历史拍卖最高出价
    // *
    // * @param list 车辆sid列表
    // * @return
    // * @see [相关类/方法](可选)
    // * @since [产品/模块版本](可选)
    // * @Date 2015年3月3日 下午3:31:16
    // * @author tao.huang
    // */
    // Map<String, List<Map<String, Object>>> getHighestPriceByList(List<String>
    // list);
    //
    // /**
    // *
    // * 功能描述: <br>
    // * 通过单个车辆ID获取历史拍卖最高出价
    // *
    // * @param vehicleId 车辆sid
    // * @return
    // * @see [相关类/方法](可选)
    // * @since [产品/模块版本](可选)
    // * @Date 2015年3月3日 下午3:42:16
    // * @author tao.huang
    // */
    // List<Map<String, Object>> getHighestPriceByString(String vehicleId);
    //
    /**
     * 批量设置价格
     * 
     * @param params
     * @Date 2015年3月16日 下午16:50:16
     * @author haoju.li
     */

    /**
     * @return void
     * @author youpeng.zhang Date: 2015年8月25日 上午11:01:04
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    void volumeSetPrice(Map<String, Object> params);

    /**
     * 替换临时拍品
     * 
     * @param auctionVehicleSid
     * @param tempVehicleSid
     * @param vehicleCode
     * @author youpeng.zhang
     */
    boolean updateTempVehicleInfo(Integer auctionVehicleId, Integer tempVehicleId, String vehicleCode);

    /**
     * 功能描述: <br>
     * 〈临时拍品的拍卖会〉
     * 
     * @param tempVehicleSid
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * @author youpeng.zhang
     */
    List<AuctionVehicle> selectTempVehicleAuctionVehicle(Integer tempVehicleId);

    /**
     * 功能描述: <br>
     * 〈判断该车辆能否转为展厅〉
     * 
     * @param vehicleSid
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * @author youpeng.zhang
     */
    boolean isVehicleToFixedprice(Integer vehicleId);

    /**
     * 同步拍场次计算
     * 
     * @return int
     * @author youpeng.zhang Date: 2015年5月26日 下午5:21:51
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    int getOnlineAunctionCount();

    /**
     * 推荐列表
     * 
     * @return void
     * @author youpeng.zhang Date: 2015年8月28日 下午5:37:53
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<AuctionVehicle> findAuctionVehicleRecommend();

    /**
     *
     * 功能描述: <br>
     * 〈在线拍城市列表〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<Map<String, Boolean>> getCityListforAuction();

    /**
     * 
     * 功能描述: <br>
     * 〈在线拍城市列表〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<Map<String, Boolean>> getCityListforAuction(Map<String, Object> params);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param avId
     * @param oldStatus
     * @param newStatus
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    // int updateAvStatus(Integer avId, Integer oldStatus, Integer newStatus);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param av
     * @param status
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    // public boolean updateVehicleStatusEQS(AuctionVehicle av, int status);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param avId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void updateAuctionVehicleFail(Integer avId) throws Exception;

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param avId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void resetOnlineEndTime(Integer avId);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param fav
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void endBid(AuctionVehicle fav) throws Exception;

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param id
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void updateOnlineAVFail(Integer id);

    /**
     * 
     * 功能描述: <br>
     * 通过单个车辆ID获取历史拍卖最高出价
     * 
     * @param vehicleId
     *            车辆sid
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * @Date 2015年3月3日 下午3:42:16
     * @author tao.huang
     */
    List<Map<String, Object>> getHighestPriceByString(Integer vehicleId);

    /**
     * 
     * 功能描述: <br>
     * 通过多个车辆ID获取历史拍卖最高出价
     * 
     * @param list
     *            车辆sid列表
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * @Date 2015年3月3日 下午3:31:16
     * @author tao.huang
     */
    Map<Integer, List<Map<String, Object>>> getHighestPriceByList(List<Integer> list);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param auctionVehicle
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Pagination getOnceBidAuction(AuctionVehicle auctionVehicle);

    /**
     * 功能描述: <br>
     * 〈创建即时拍订单〉
     * 
     * @author jingzhou.zhao
     * @param auctionVehicle
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean createOnceBidOrder(AuctionVehicle auctionVehicle) throws Exception;

    /**
     * 拍卖助手优化2.0 弃用老旧的查询方式
     * 
     * @author wwy
     * @date 2015年9月29日
     * @param auctionId
     * @return
     */
    public List<AuctionVehicle> getAuctionVehicles(Integer auctionId);

    /**
     * 查询拍品和车辆信息
     * 
     * @param avId
     *            拍品id
     * @return
     */
    AuctionVehicle getAuctionVehicleAndVehicle(Integer avId);

    /**
     * 功能描述: <br>
     * 〈查询拍品顺序及vin_code ,仓储物流使用，由原autostreets VehicleService 移入。〉
     * 
     * @author jingzhou.zhao
     * @param auctionId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<Vehicle> selectStockRemovalAuction(Integer auctionId);

    /**
     * 获取接下来的拍品list
     * 
     * @param auctionId
     *            拍卖会id
     * @return
     */
    public List<AuctionVehicle> getNextAvList(Integer auctionId);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 查询拍卖会拍品最大序号
     * </pre>
     *
     * @param auctionId
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年11月11日 下午2:20:54
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int selectAuctionVehicleMaxSeq(Integer auctionId);

    /**
     * @param av
     * @param order
     * @param orderItem
     * @return
     * @throws WorkflowException
     * @throws IOException
     */
    boolean stockRemovalApply(AuctionVehicle av, Order order, OrderItem orderItem)
            throws WorkflowException, IOException;

    /**
     * @param orderNo
     * @param code
     * @param orgAddr
     * @param applyId
     * @param applyName
     * @param stockRemovalType
     * @param payType
     * @param takeCarWay
     * @param cellphone
     * @return
     * @throws WorkflowException
     * @throws IOException
     */
    boolean stockRemovalApply(String orderNo, String code, String orgAddr, String applyId, String applyName,
            String stockRemovalType, String payType, String takeCarWay, String cellphone)
                    throws WorkflowException, IOException;

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 更新拍品状态（车辆状态将会同步更新）
     * 
     * 拍品状态         车辆状态
     * 0 待拍卖
     * 1 已上架
     * 2 拍卖成功
     * 3 成交确认
     * 4 流拍 
     * 5 正在拍
     * 6 暂停
     * 7 取消订单
     * 
     * com.autostreets.biz.auction.constants.GlobalConstants 中定义：
     * WAITING_FOR_THE_AUCTION = 0;// 待拍卖
     * AUCTION_VEHICLE_STATUS_SHELVES = 1;// 已上架
     * AUCTION_VEHICLE_STATUS_SUCCESS = 2;// 拍卖成功
     * AUCTION_VEHICLE_STATUS_FAIL_CONFIRM = 3;// 成交确认
     * AUCTION_VEHICLE_STATUS_FAIL = 4;// 流拍
     * AUCTION_VEHICLE_STATUS_ON = 5;// 正在拍
     * AUCTION_VEHICLE_STATUS_PAUSE = 6;// 暂停
     * AUCTION_VEHICLE_STATUS_CANCEL = 7;// 原定义为【撤拍】，现更新为【取消订单】
     * </pre>
     *
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月24日 上午9:31:59
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean updateAuctionVehicleStatus(Integer avId, Integer vehicleId, Integer oldStatus, Integer newStatus)
            throws Exception;

    /**
     * 
     * 功能描述: <br>
     * 〈查询线上成交的车辆总数〉
     *
     * @author dongling.qu
     * @param integer
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int selectOnlineDealSum(Integer integer);

    /**
     * 功能描述: 远通集团excel导出<br>
     *
     * @param auction
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AuctionVehicle> exportCatalog(Auction auction);

}
