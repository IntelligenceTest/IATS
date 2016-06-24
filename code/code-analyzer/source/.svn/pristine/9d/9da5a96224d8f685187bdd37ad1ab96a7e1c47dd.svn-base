package com.autostreets.biz.auction.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.MemberVehicleMapper;
import com.autostreets.biz.auction.model.MemberVehicle;
import com.autostreets.biz.auction.model.MemberVehicleExample;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.service.MemberVehicleService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

/**
 * 会员车辆服务类
 * 
 * @author meng.zhao
 * 
 */
@Service("memberVehicleService")
public class MemberVehicleServiceImpl extends GenericServiceImpl<MemberVehicle, MemberVehicleExample, Integer>
        implements MemberVehicleService {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberVehicleServiceImpl.class);
    @Autowired
    private MemberVehicleMapper memberVehicleMapper;

    @Override
    protected GenericMapper<MemberVehicle, MemberVehicleExample, Integer> getGenericMapper() {
        return memberVehicleMapper;
    }

    /**
     * 查询会员竞得车辆信息
     * 
     * @param sid
     * @return
     */
    @Override
    public List<Order> listMemberAuctionedVehicle(HashMap<String, Object> params) {
        return memberVehicleMapper.listMemberAuctionedVehicle(params);
    }

    /**
     * 查询会员参与过竞拍的车辆信息
     * 
     * @param sid
     * @return
     */
    @Override
    public List<MemberVehicle> listMemberBiddedVehicle(HashMap<String, Object> params) {
        return memberVehicleMapper.listMemberBiddedVehicle(params);
    }

    /**
     * 查询会员关注过的车辆信息
     * 
     * @param sid
     * @return
     */
    @Override
    public List<MemberVehicle> listMemberFavoriteVehicle(HashMap<String, Object> params) {
        return memberVehicleMapper.listMemberFavoriteVehicle(params);
    }

    /**
     * 查询竞得车辆总数
     */
    @Override
    public int getMemberAuctionedVehicleCount(String sid) {
        return memberVehicleMapper.getMemberAuctionedVehicleCount(sid);
    }

    @Override
    public int getMemberBiddedVehicleCount(String sid) {
        return memberVehicleMapper.getMemberBiddedVehicleCount(sid);
    }

    @Override
    public int getMemberFavoriteVehicleCount(String sid) {
        return memberVehicleMapper.getMemberFavoriteVehicleCount(sid);
    }

    @Override
    public List<MemberVehicle> loadMemberBiddedVehicleList(Map<String, Object> params) {
        return memberVehicleMapper.loadMemberBiddedVehicleList(params);
    }

    @Override
    public List<MemberVehicle> loadMemberAuctionedVehicleList(Map<String, Object> params) {
        return memberVehicleMapper.loadMemberAuctionedVehicleList(params);
    }

    @Override
    public List<MemberVehicle> loadMemberFavoriteVehicleList(Map<String, Object> params) {
        return memberVehicleMapper.loadMemberFavoriteVehicleList(params);
    }

    @Override
    public List<MemberVehicle> loadTransferVehicleByMember(Map<String, Object> params) {
        return memberVehicleMapper.loadTransferVehicleByMember(params);
    }

    @Override
    public List<MemberVehicleFavorite> listMemberFavoriteList(HashMap<String, Object> params) {
        return memberVehicleMapper.listMemberFavorite(params);
    }
}
