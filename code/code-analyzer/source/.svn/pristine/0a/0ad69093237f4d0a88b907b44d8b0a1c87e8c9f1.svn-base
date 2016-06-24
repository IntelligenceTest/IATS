package com.autostreets.biz.auction.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.MemberVehicleFavoriteMapper;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.biz.auction.service.MemberVehicleFavoriteService;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("memberVehicleFavoriteService")
public class MemberVehicleFavoriteServiceImpl extends
        GenericServiceImpl<MemberVehicleFavorite, MemberVehicleFavoriteExample, Integer> implements MemberVehicleFavoriteService {

    @Autowired
    private MemberVehicleFavoriteMapper memberVehicleFavoriteMapper;

    @Override
    protected MemberVehicleFavoriteMapper getGenericMapper() {
        return memberVehicleFavoriteMapper;
    }

    private MemberVehicleFavoriteExample getExample(MemberVehicleFavorite mf){
        MemberVehicleFavoriteExample example =  new MemberVehicleFavoriteExample();
        MemberVehicleFavoriteExample.Criteria criteria = example.createCriteria();
        if(mf != null){
            if(mf.getType() != null){
                criteria.andTypeEqualTo(mf.getType());                
            }
            if(StringUtils.isNotBlank(mf.getMemberSid())){
                criteria.andMemberSidEqualTo(mf.getMemberSid());
            }
        }
        example.setPagination(mf.getPagination());
        return example;
    }
    
    @Override
    public int getMemberFavoriteVehicleCount(MemberVehicleFavorite mf) {
        return countByExample(getExample(mf));
    }

    @Override
    public List<MemberVehicleFavorite> getMemberFavoriteVehicle(MemberVehicleFavorite mf) {
        return selectByExample(getExample(mf));
    }

}
