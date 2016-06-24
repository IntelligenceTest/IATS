package com.autostreets.biz.auction.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.MemberVehicle;
import com.autostreets.biz.auction.model.MemberVehicleExample;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.framework.common.dal.GenericService;

/**
 * 会员车辆服务接口
 * 
 * @author meng.zhao
 * 
 */
public interface MemberVehicleService extends GenericService<MemberVehicle, MemberVehicleExample, Integer> {

    /**
     * 查询会员竞得车辆信息
     * 
     * @param sid
     * @param pagination
     * @return
     */
    List<Order> listMemberAuctionedVehicle(HashMap<String, Object> params);

    /**
     * 查询会员参与过竞拍的车辆信息
     * 
     * @param sid
     * @param pagination
     * @return
     */
    List<MemberVehicle> listMemberBiddedVehicle(HashMap<String, Object> params);

    /**
     * 查询会员关注过的车辆信息
     * 
     * @param sid
     * @param pagination
     * @return
     */
    List<MemberVehicle> listMemberFavoriteVehicle(HashMap<String, Object> params);

    /**
     * 查询竞得车辆总数
     * 
     * @param id
     * @return
     */
    int getMemberAuctionedVehicleCount(String sid);

    /**
     * 查询会员竞得车辆总数
     * 
     * @param id
     * @return
     */
    int getMemberBiddedVehicleCount(String sid);

    /**
     * 查询会员出价车辆总数
     * 
     * @param id
     * @return
     */
    int getMemberFavoriteVehicleCount(String sid);

    /**
     * 移动端查询车辆出价信息
     * 
     * @return List<MemberVehicle>
     * @author youpeng.zhang Date: 2015年10月26日 下午5:06:37
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<MemberVehicle> loadMemberBiddedVehicleList(Map<String, Object> params);

    /**
     * 查询竞得拍品列表
     * 
     * @param params
     * @return
     */
    List<MemberVehicle> loadMemberAuctionedVehicleList(Map<String, Object> params);

    /**
     * 查询会员关注拍品列表
     * 
     * @param params
     * @return
     */
    List<MemberVehicle> loadMemberFavoriteVehicleList(Map<String, Object> params);

    /**
     * 查询会员竞得拍品列表
     * 
     * @param sid
     * @param pagination
     * @return
     */
    List<MemberVehicle> loadTransferVehicleByMember(Map<String, Object> params);

    /**
     * 查询会员所有车辆关注列表
     * 
     * @param params
     * @return
     * @Date: 2015年3月13日 下午4:26:57
     * @author haoju.li
     * @since [1.4.0]
     */
    List<MemberVehicleFavorite> listMemberFavoriteList(HashMap<String, Object> params);
}
