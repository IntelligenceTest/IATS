package com.autostreets.biz.auction.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.FixedPriceExample;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.pagination.Pagination1;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface FixedPriceService extends GenericService<FixedPrice, FixedPriceExample, Integer> {

    /**
     * 展厅首页
     * 
     * @return Pagination
     * @author youpeng.zhang Date: 2015年8月26日 下午1:45:25
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    Pagination queryFixedPrices(Pagination pagination, FixedPrice fixedPrice);

    /**
     * 通过展品SID或车辆SID查询有效订单数
     * 
     * @return int
     * @author youpeng.zhang Date: 2015年8月28日 上午11:16:22
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    int queryUsedCarOrderNum(HashMap<String, Object> param);

    /**
     * <pre>
     * 更新车辆销售状态
     * 销售状态：0、待售；1、 出售中；2、已出售
     * </pre>
     * 
     * V2.0:增加新车售价（2014年10月15日 17:58:36）
     * 
     * @Title: updateVehicleSaleStatus
     * @Description:
     * @param vehicleSid
     *            车辆主键
     * @param status
     *            要设置的状态
     * @return void
     * @throws @author
     *             tao.huang
     * @version V1.0
     * @date 2014年7月29日 下午1:45:04
     * @see tao.huang 2015-03-05 EQS分离 修改车辆销售状态接口
     * 
     */
    // public boolean updateVehicleSaleStatusEQS(Integer vehicleId, String
    // status, BigDecimal priceNewcar);

    Pagination1<FixedPrice> selectFixedPricePage(String brand, Integer age, String pro, String city, Integer price,
            Integer mile, Integer min, Integer max, Integer cert, Integer ps, String sb, String s, int pageNumber,
            String d, int pageSize);

    /**
     * 取得车辆详情
     * 
     * @param vehicleId
     *            车辆id
     * @return
     * @since 1.0
     */
    Map<String, Object> loadVehicleInfo(Integer vehicleId, String loginUserId);

    /**
     * 获取可能喜欢的车辆列表
     * 
     * @param params
     * @return
     */
    List<FixedPrice> selectFavoriteByMap(Map<String, Object> params);

    FixedPrice loadFixedPrice(Integer vehicleId);

    /**
     * 取得前台列表页可能出现的展品所在省列表
     * 
     * @return
     */
    List<String> selectAllProvince();

    /**
     * @Title: queryNonOffLineOrder
     * @Description: 通过展品SID或车辆SID查询有效线上订单
     * @param param
     * @return HashMap<String,Object>
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月27日 上午11:32:01
     */
    HashMap<String, Object> queryNonOffLineOrder(HashMap<String, Object> param);

    /**
     * @Title: queryUsedCarLatest
     * @Description: 通过车辆ID查询有效参展展品
     * @param vSid
     * @return List<FixedPrice>
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月26日 下午4:59:30
     */
    List<FixedPrice> queryUsedCarLatest(Integer vSid);

    /**
     * @Title: queryUsedCarOrderOnline
     * @Description: 通过展品SID或车辆SID查询线上预订展品订单（已预订、已付定金）
     * @param param
     * @return List<OrderItem> 订单明细集
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年12月4日 上午10:51:55
     */
    List<OrderItem> queryUsedCarOrderOnline(HashMap<String, Object> param);

    /**
     * 
     * 查询所有符合条件的展品（不分页）
     *
     * @param fixedPrice
     * @return
     * @author tao.huang
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<FixedPrice> queryAllFixedPrices(FixedPrice fixedPrice);

    List<Map<String, String>> selectBrandByVehicleNum(Integer orgId);

    List<Map<String, String>> selectCityByVehicleNum();

    /**
     * 移动端用展厅列表
     * 
     * @return List<FixedPrice>
     * @author youpeng.zhang Date: 2015年10月26日 下午4:08:18
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<FixedPrice> selectByMap(Map<String, Object> params);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author zxf
     * @param vehicleId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean isVehicleToAuction(Integer vehicleId);

    List<String> selectCityByVehicleProvince(String province);

    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @param fpId
     *            展品ID
     * @param isAdd
     *            是否添加收藏 ，true：+1，false：-1
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年11月12日 上午10:23:37
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer updateFavCount(Integer fpId, boolean isAdd);

    /**
     * 查找超过下架时间的车辆，进行下架操作 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<FixedPrice> queryExpirationFixedPrice();

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 修改展厅状态（并且修改车辆销售状态）
     * 展品状态   车辆销售状态
     * 
     * 0 上架申请     出售中
     * 1 已下架         待售
     * 3 已出售        已出售
     * 3 已上架        出售中
     * 4 已预订        出售中
     * 5 已付定金    出售中
     * 6 已付全款     已出售
     * 7 上架失败     待售
     * </pre>
     *
     * @param fpId
     * @param vehicleId
     * @param oldStatus
     * @param newStatus
     * @param offShelvesRemark
     * @param offShelvesTime
     * @param updateUserId
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月24日 下午4:20:14
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean updateFixedPriceStatus(Integer fpId, Integer vehicleId, Integer oldStatus, Integer newStatus,
            String offShelvesRemark, Integer updateUserId) throws Exception;

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 修改展厅状态（并且修改车辆销售状态）
     * 展品状态   车辆销售状态
     * 
     * 0 上架申请     出售中
     * 1 已下架         待售
     * 3 已出售        已出售
     * 3 已上架        出售中
     * 4 已预订        出售中
     * 5 已付定金    出售中
     * 6 已付全款     已出售
     * 7 上架失败     待售
     * </pre>
     *
     * @param fpId
     * @param vehicleId
     * @param oldStatus
     * @param newStatus
     * @param offShelvesRemark
     * @param offShelvesTime
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月24日 下午4:20:14
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean updateFixedPriceStatus(Integer fpId, Integer vehicleId, Integer oldStatus, Integer newStatus,
            String offShelvesRemark)
            throws Exception;

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 修改展厅状态（并且修改车辆销售状态）
     * 展品状态   车辆销售状态
     * 
     * 0 上架申请     出售中
     * 1 已下架         待售
     * 3 已出售        已出售
     * 3 已上架        出售中
     * 4 已预订        出售中
     * 5 已付定金    出售中
     * 6 已付全款     已出售
     * 7 上架失败     待售
     * </pre>
     *
     * @param fpId
     * @param vehicleId
     * @param oldStatus
     * @param newStatus
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月24日 下午4:20:14
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean updateFixedPriceStatus(Integer fpId, Integer vehicleId, Integer oldStatus, Integer newStatus)
            throws Exception;

}