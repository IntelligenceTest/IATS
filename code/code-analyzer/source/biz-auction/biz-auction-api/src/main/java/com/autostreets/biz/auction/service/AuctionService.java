package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

/**
 * 
 *
 * @author  youpeng.zhang
 * Date:     2015年8月21日 下午5:58:10
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

/**
 * 
 *
 * @author  youpeng.zhang
 * Date:     2015年8月21日 下午5:58:12
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
/**
 * 
 *
 * @author youpeng.zhang Date: 2015年8月21日 下午5:58:16
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface AuctionService extends GenericService<Auction, AuctionExample, Integer> {

    /**
     * @Title: selectAuctionsBypage
     * @Description: 分页查询拍卖管理信息
     * @param auction
     *            查询条件
     * @param pagination
     *            分页载体对象
     * @return void 查询数据并装载完成
     * @throws @author
     *             yanqing.luo
     */
    Pagination selectAuctionsByPage(Pagination pagination, Auction auction);

    /**
     * @Title: selectAutionBySid
     * @Description: 通过Sid唯一标识查询具体对象
     * @param auctionSid
     *            数据唯一标识
     * @return Auction
     * @throws @author
     *             yanqing.luo
     */
    Auction selectAutionById(Integer id);

    /**
     * Last:2014年7月22日 22:14:53 编辑已发布拍卖会中拍品时也加载其所属拍卖会
     * 
     * @Title: selectAutions
     * @Description: 加载拍卖会列表
     * @return List<Auction> 返回拍卖会id,拍卖会名称,拍卖会编号
     * @throws @author
     *             yanqing.luo
     * @version V2.0
     * @date 2014年7月10日 上午11:00:18
     */
    List<Auction> selectAutions(Integer id);

    /**
     * @Title: updateStatus
     * @Description: 更新指定拍卖会状态为指定状态
     * @param status
     * @param auctionSid
     * @return int
     * @throws @author
     *             yanqing.luo
     * @version V2.0
     * @date 2014年7月17日 下午2:32:47
     */
    int updateStatus(Integer status, Integer id);

    /**
     * 通过拍卖会查询其所有拍品ID
     * 
     * @return void
     * @author youpeng.zhang Date: 2015年8月21日 下午5:58:19
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<Integer> queryVehicleFromAuction(Integer auctionId, Integer auctionVehicleStatus);

    /**
     * @Title: updateAuctionVehicleStatus
     * @Description: 更新拍卖会下的所有待拍卖拍品状态为指定状态
     * @param status
     * @param auctionSid
     * @param auctionVehicleStatusCond
     * @return int
     * @throws @author
     *             yanqing.luo
     * @version V2.0
     * @date 2014年7月17日 下午6:25:04
     */
    int updateAuctionVehicleStatus(Integer status, Integer auctionId, Integer auctionVehicleStatusCond);

    /**
     * @Title: updateAuctionVehicleQuantity
     * @Description: 批量更新所有拍卖会的拍品数量
     * @return int
     * @throws @author
     *             yanqing.luo
     * @version V1.0
     * @date 2014年7月19日 下午6:17:01
     */
    int updateAuctionVehicleQuantity();

    List<Auction> findAutionsForNotEqUnpblish(Pagination pagination);

    /**
     * 前台同步拍列表
     * 
     * @return List<Auction>
     * @author youpeng.zhang Date: 2015年7月15日 上午9:01:32
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<Auction> selectAuctionListFP();

    /**
     * 
     * 功能描述: <br>
     * 〈查找结束的拍卖会〉
     *
     * @author dongling.qu
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<Auction> selectEndAuctionList();

    /**
     * 功能描述: 根据user权限获取拍卖会列表<br>
     * 〈功能详细描述〉
     *
     * @param auction
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<Auction> selectAuctionByOrgIds(Auction auction);

}
