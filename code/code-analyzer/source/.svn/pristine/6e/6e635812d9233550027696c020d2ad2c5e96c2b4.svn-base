package com.autostreets.biz.auction.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.MemberVehicle;
import com.autostreets.biz.auction.model.MemberVehicleExample;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.framework.common.dal.GenericMapper;

public interface MemberVehicleMapper extends GenericMapper<MemberVehicle, MemberVehicleExample, Integer> {

    /**
     * 查询会员竞得车辆信息
     * 
     * @param sid
     * @return
     */
    List<Order> listMemberAuctionedVehicle(HashMap<String, Object> params);

    /**
     * 查询会员参与过竞拍的车辆信息
     * 
     * @param sid
     * @return
     */
    List<MemberVehicle> listMemberBiddedVehicle(HashMap<String, Object> params);

    /**
     * 查询会员关注过的车辆信息
     * 
     * @param sid
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
     * 查询出价车辆总数
     * 
     * @param id
     * @return
     */
    int getMemberBiddedVehicleCount(String sid);

    /**
     * 查询关注车辆总数
     * 
     * @param id
     * @return
     */
    int getMemberFavoriteVehicleCount(String sid);

    List<MemberVehicle> loadMemberBiddedVehicleList(Map<String, Object> params);

    List<MemberVehicle> loadMemberFavoriteVehicleList(Map<String, Object> params);

    List<MemberVehicle> loadMemberAuctionedVehicleList(Map<String, Object> params);

    /**
     * @param params
     * @return
     */
    List<MemberVehicle> loadTransferVehicleByMember(Map<String, Object> params);

    // 查询会员收藏的所有记录
    List<MemberVehicleFavorite> listMemberFavorite(HashMap<String, Object> params);
}
