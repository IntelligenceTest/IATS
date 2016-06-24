package com.autostreets.biz.auction.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.AuctionUploadLogMapper;
import com.autostreets.biz.auction.model.AuctionUploadLog;
import com.autostreets.biz.auction.service.AuctionUploadLogService;
import com.autostreets.biz.sys.model.user.User;
import com.autostreets.biz.sys.model.user.UserExample;
import com.autostreets.biz.sys.service.user.UserService;
import com.autostreets.framework.common.dal.Pagination;
import com.google.common.collect.Lists;

@Service("auctionUploadLogService")
public class AuctionUploadLogServiceImpl implements AuctionUploadLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionUploadLogServiceImpl.class);

    @Autowired
    private AuctionUploadLogMapper auctionUploadLogMapper;

    @Autowired
    private UserService userService;

    @Override
    public Pagination selectAuctionUploadLogByPage(Pagination pagination, AuctionUploadLog auctionUploadLog) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 操作时间
        if (null != auctionUploadLog.getStartTime())
            map.put("startTime", auctionUploadLog.getStartTime());

        if (null != auctionUploadLog.getEndTime())
            map.put("endTime", auctionUploadLog.getEndTime());

        // 操作人
        if (StringUtils.isNotBlank(auctionUploadLog.getCreateByName())) {
            // map.put("createByName", auctionUploadLog.getCreateByName());
            List<Integer> list = Lists.newArrayList();
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            // 未删除
            criteria.andDelFlagEqualTo(0);
            criteria.andNameLike("%" + auctionUploadLog.getCreateByName() + "%");
            List<User> users = userService.selectByExample(example);

            StringBuilder createBys = new StringBuilder();
            if (null != users && users.size() > 0) {
                for (User u : users) {
                    createBys.append(u.getId());
                    createBys.append(",");
                }
            }
            if (createBys.lastIndexOf(",") > 0) {
                createBys.deleteCharAt(createBys.lastIndexOf(","));
            }
            map.put("createBy", createBys.toString());

        }
        // 总数
        int count = auctionUploadLogMapper.countByMap(map);
        pagination.setCount(count);
        map.put("limit", pagination.getLength());
        map.put("offset", pagination.getBegin());
        List<AuctionUploadLog> list = auctionUploadLogMapper.selectByMap(map);
        if (null != list && list.size() > 0) {
            for (AuctionUploadLog log : list) {
                if (null != log.getCreatedBy()) {
                    User user = userService.selectByPrimaryKey(log.getCreatedBy());
                    if (null != user) {
                        log.setCreateByName(user.getName());
                    }
                }
            }
        }

        pagination.setDataList(list);
        return pagination;
    }

    @Override
    public void insertLog(AuctionUploadLog log) {
        auctionUploadLogMapper.insertSelective(log);
    }
}