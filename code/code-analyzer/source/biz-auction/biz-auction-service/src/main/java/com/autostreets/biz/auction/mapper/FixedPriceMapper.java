package com.autostreets.biz.auction.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.FixedPriceExample;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.framework.common.dal.GenericMapper;

public interface FixedPriceMapper extends GenericMapper<FixedPrice, FixedPriceExample, Integer> {

    int countByMap(Map<String, Object> params);

    List<FixedPrice> selectByMap(Map<String, Object> params);

    List<FixedPrice> selectFavoriteByMap(Map<String, Object> params);

    /**
     * 一口价首页
     * 
     * @return List<FixedPrice>
     * @author youpeng.zhang Date: 2015年8月26日 下午1:48:56
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<FixedPrice> queryFixedPrices(FixedPrice fixedPrice);

    /**
     * 首页总数查询
     * 
     * @return int
     * @author youpeng.zhang Date: 2015年8月26日 下午1:48:58
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    int queryFixedPriceTotal(FixedPrice fixedPrice);

    /**
     * 前提：车辆在车辆表中只能是唯一的
     * 
     * @Title: updateVehicleSaleStatus
     * @Description: 更新车辆销售状态为指定状态，可根据某一状态筛选
     * @param saleStatus
     *            要更新的状态
     * @param saleStatusCond
     *            筛选状态
     * @param vehicleSid
     *            车辆id
     * @return int 更新数量
     * @throws @author
     *             yanqing.luo
     * @version V1.0
     * @date 2014年8月25日 17:32:25
     */
    int updateVehicleSaleStatus(@Param("saleStatus") String saleStatus, @Param("saleStatusCond") String saleStatusCond,
            @Param("vehicleSid") String vehicleSid);

    /**
     * @Title: querySidByCond
     * @Description: 根据车辆SID、展品最新状态、展品状态查询对应展品
     * @param param
     * @return FixedPrice
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年8月25日 下午5:26:43
     */
    FixedPrice querySidByCond(HashMap<String, Object> param);

    /**
     * <pre>
     * 展品参数：fpSid
     * 车辆参数：vSid
     * </pre>
     * 
     * @Title: queryUsedCarOrderNum
     * @Description: 通过展品SID或车辆SID查询有效订单数
     * @param param
     * @return int
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月25日 下午6:33:53
     */
    int queryUsedCarOrderNum(HashMap<String, Object> param);

    /**
     * @Title: queryUsedCarOrderEnabled
     * @Description: 通过展品SID或车辆SID查询有效订单
     * @param param
     * @return List<String> 返回订单明细SID
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月26日 下午5:40:42
     */
    List<String> queryUsedCarOrderEnabled(HashMap<String, Object> param);

    /**
     * @Title: queryUsedCarOrderOnline
     * @Description: 通过展品SID或车辆SID查询线上预订展品订单（已预订、已付定金）
     * @param param
     * @return List<OrderItem> 订单明细集
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年12月4日 上午10:48:55
     */
    List<OrderItem> queryUsedCarOrderOnline(HashMap<String, Object> param);

    /**
     * @Title: queryUsedCarLatest
     * @Description: 通过车辆SID查询有效参展展品
     * @param vSid
     * @return List<FixedPrice>
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月26日 下午4:56:42
     */
    List<FixedPrice> queryUsedCarLatest(@Param("vSid") String vSid);

    /**
     * @Title: queryNonOffLineOrder
     * @Description: 通过展品SID或车辆SID查询有效线上订单
     * @param param
     * @return HashMap<String,Object>
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月27日 上午11:29:58
     */
    HashMap<String, Object> queryNonOffLineOrder(HashMap<String, Object> param);

    List<FixedPrice> queryForFpRecommend(FixedPrice fixedPrice);

    Integer countForFpRecommend(FixedPrice fixedPrice);

    /**
     * 取得前台列表页可能出现的展品所在省列表
     * 
     * @return
     */
    List<String> selectAllProvince();

    /**
     * @Title: queryUsedCarLatest
     * @Description: 通过车辆ID查询有效参展展品
     * @param vSid
     * @return List<FixedPrice>
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月26日 下午4:56:42
     */
    List<FixedPrice> queryUsedCarLatest(@Param("vId") Integer vId);

    List<String> selectBrandByFixedPrice(@Param("orgId") Integer orgId);

    List<String> selectCityByFixedPrice();

    /**
     * 
     * 功能描述: <br>
     * 〈查询当前省有车的城市〉
     *
     * @param province
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<FixedPrice> selectCityByVehicleProvince(String province);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @param params
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年11月12日 上午10:36:55
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer updateFavCount(Map<String, Object> params);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<FixedPrice> queryExpirationFixedPrice();
}