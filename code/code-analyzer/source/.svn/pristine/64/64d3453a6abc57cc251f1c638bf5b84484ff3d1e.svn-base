package com.autostreets.biz.auction.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.AuctionPlaceMapper;
import com.autostreets.biz.auction.model.AuctionPlace;
import com.autostreets.biz.auction.model.AuctionPlaceExample;
import com.autostreets.biz.auction.service.AuctionPlaceService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Service("auctionPlaceService")
public class AuctionPlaceServiceImpl extends GenericServiceImpl<AuctionPlace, AuctionPlaceExample, Integer> implements
        AuctionPlaceService {

    @Autowired
    private AuctionPlaceMapper auctionPlaceMapper;

    @Override
    protected GenericMapper<AuctionPlace, AuctionPlaceExample, Integer> getGenericMapper() {
        return auctionPlaceMapper;
    }

    @Override
    public Pagination getAuctionPlaceByPage(Pagination pagination, AuctionPlace auctionPlace) {
        AuctionPlaceExample e = new AuctionPlaceExample();
        AuctionPlaceExample.Criteria criteria = e.createCriteria();
        if (auctionPlace.getName() != null && !auctionPlace.getName().equals("")) {
            criteria.andNameLike("%" + auctionPlace.getName() + "%");
        }
        if (auctionPlace.getEnabled() != null) {
            criteria.andEnabledEqualTo(auctionPlace.getEnabled());
        }
        e.setOrderByClause("modify_time desc");
        int count = auctionPlaceMapper.countByExample(e);
        pagination.setCount(count);
        e.setPagination(pagination);
        List<AuctionPlace> aucPlacelist = auctionPlaceMapper.selectByExample(e);
        pagination.setDataList(aucPlacelist);
        return pagination;
    }

    @Override
    public List<AuctionPlace> getAuctionPlaceList(AuctionPlace auctionPlace) {
        AuctionPlaceExample example = null;
        if (auctionPlace != null) {
            example = new AuctionPlaceExample();
            AuctionPlaceExample.Criteria criteria = example.createCriteria();
            // 激活-禁用
            if (auctionPlace.getEnabled() != null) {
                criteria.andEnabledEqualTo(auctionPlace.getEnabled());
            }
        }
        return auctionPlaceMapper.selectByExample(example);
    }

    @Override
    public Integer getPlaceLastAuctionNum(Integer placeId) {
        return auctionPlaceMapper.getPlaceLastAuctionNum(placeId);
    }

    @Override
    public List<AuctionPlace> getAuctionPlaceCityList(AuctionPlace auctionPlace) {
        AuctionPlaceExample example = null;
        if (auctionPlace != null) {
            example = new AuctionPlaceExample();
            AuctionPlaceExample.Criteria criteria = example.createCriteria();
            // 激活-禁用
            if (auctionPlace.getEnabled() != null) {
                criteria.andEnabledEqualTo(auctionPlace.getEnabled());
            } else {
                criteria.andEnabledEqualTo(true);
            }
        }
        List<AuctionPlace> ap = auctionPlaceMapper.selectByExample(example);
        List<AuctionPlace> citys = new ArrayList<AuctionPlace>();
        List<String> city = new ArrayList<String>();
        if (ap.size() > 0) {
            for (AuctionPlace auctionP : ap) {
                if (!city.contains(auctionP.getCity())) {
                    city.add(auctionP.getCity());
                    citys.add(auctionP);
                }
            }
        }

        return citys;
    }
}
