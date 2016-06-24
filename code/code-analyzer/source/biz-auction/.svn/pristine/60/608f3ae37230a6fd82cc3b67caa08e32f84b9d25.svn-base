package com.autostreets.biz.auction.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.mapper.AuctionMapper;
import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionExample;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Service("auctionService")
public class AuctionServiceImpl extends GenericServiceImpl<Auction, AuctionExample, Integer>implements AuctionService {

    @Autowired
    private AuctionMapper auctionMapper;

    @Override
    protected GenericMapper<Auction, AuctionExample, Integer> getGenericMapper() {
        return auctionMapper;
    }

    @Override
    public Pagination selectAuctionsByPage(Pagination pagination, Auction auction) {
        // LOGGER.debug("****************************进入拍卖管理分页查询****************************");
        AuctionExample auctionExample = new AuctionExample();
        com.autostreets.biz.auction.model.base.BaseAuctionExample.Criteria criteria = auctionExample.createCriteria();

        // 标题
        if (StringUtils.isNotBlank(auction.getTitle()))
            criteria.andTitleLikeInsensitive(GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT + auction.getTitle()
                    + GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT);// 大小写敏感
                                                                    // 需要添加%%
        // criteria.andTitleLike(GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT+auction.getTitle()+GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT);

        // 省份
        if (StringUtils.isNotBlank(auction.getProvince()))
            criteria.andProvinceEqualTo(auction.getProvince());

        // 拍卖会编号
        if (StringUtils.isNotBlank(auction.getCode()))
            criteria.andCodeLikeInsensitive(GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT + auction.getCode()
                    + GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT);

        // 拍卖会状态
        if (auction.getStatus() != null)
            criteria.andStatusEqualTo(auction.getStatus());

        // 城市
        if (StringUtils.isNotBlank(auction.getCity()))
            criteria.andCityEqualTo(auction.getCity());

        // 拍卖类型
        if (auction.getType() != null)
            criteria.andTypeEqualTo(auction.getType());

        // 拍卖方式
        if (auction.getAuctionModel() != null)
            criteria.andAuctionModelEqualTo(auction.getAuctionModel());

        // 预计开始时间，查询区间值
        if (null != auction.getStartTimestamp() && null != auction.getEndTimestamp())
            criteria.andStartTimestampBetween(auction.getStartTimestamp(), auction.getEndTimestamp());

        // 没有选择拍卖结束时间，可以通过拍卖开始时间查询
        if (null != auction.getStartTimestamp() && null == auction.getEndTimestamp())
            criteria.andStartTimestampGreaterThan(auction.getStartTimestamp());

        // 没有选择拍卖开始时间，可以通过拍卖结束时间查询（小于等于当前结束时间）
        if (null == auction.getStartTimestamp() && null != auction.getEndTimestamp())
            criteria.andStartTimestampLessThanOrEqualTo(auction.getEndTimestamp());

        // 拍卖地址
        if (StringUtils.isNotBlank(auction.getAddress()))
            criteria.andAddressLikeInsensitive(GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT + auction.getAddress()
                    + GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT);

        // 联系人
        if (StringUtils.isNotBlank(auction.getContact()))
            criteria.andContactLikeInsensitive(GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT + auction.getContact()
                    + GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT);

        // 联系人电话
        if (StringUtils.isNotBlank(auction.getContactTellphone()))
            criteria.andContactTellphoneLikeInsensitive(GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT
                    + auction.getContactTellphone() + GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT);

        // 拍卖人手机
        if (StringUtils.isNotBlank(auction.getAuctioneerCellphone()))
            criteria.andAuctioneerCellphoneLikeInsensitive(GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT
                    + auction.getAuctioneerCellphone() + GlobalConstants.SQL_OPERATION_SYMBOL_PERCENT);

        // 是否需要保证金
        if (null != auction.getDepositMargin())
            criteria.andDepositMarginEqualTo(auction.getDepositMargin());

        // 只加载未删除数据
        criteria.andEnableEqualTo(true);

        if (auction.getOrgIds() != null && auction.getOrgIds().size() > 0) {
            criteria.andOrgIdIn(auction.getOrgIds());
        }

        // 总数
        int count = countByExample(auctionExample);
        pagination.setCount(count);
        auctionExample.setPagination(pagination);
        auctionExample.setOrderByClause(" created_timestamp desc ");
        List<Auction> auctions = auctionMapper.selectByExample(auctionExample);
        pagination.setDataList(auctions);
        return pagination;
    }

    /**
     * 查找状态不是未发布的拍卖会
     * 
     * @return
     */
    @Override
    public List<Auction> findAutionsForNotEqUnpblish(Pagination pagination) {
        AuctionExample ae = new AuctionExample();
        AuctionExample.Criteria aeCriteria = ae.createCriteria();
        aeCriteria.andStatusNotEqualTo(0);
        ae.setOrderByClause("start_timestamp desc");
        ae.setPagination(pagination);
        return auctionMapper.selectByExample(ae);
    }

    @Override
    public Auction selectAutionById(Integer id) {
        return auctionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Auction> selectAutions(Integer id) {
        return auctionMapper.selectAuction(id);
    }

    @Override
    public int updateStatus(Integer status, Integer id) {
        return auctionMapper.updateAuctionStatus(status, id);
    }

    @Override
    public List<Integer> queryVehicleFromAuction(Integer auctionSid, Integer auctionVehicleStatus) {
        return auctionMapper.queryVehicleFromAuction(auctionSid, auctionVehicleStatus);
    }

    @Override
    public int updateAuctionVehicleStatus(Integer status, Integer auctionSid, Integer auctionVehicleStatusCond) {
        return auctionMapper.updateAuctionVehicleStatus(status, auctionSid, auctionVehicleStatusCond);
    }

    @Override
    public int updateAuctionVehicleQuantity() {
        return auctionMapper.updateAuctionVehicleQuantity();
    }

    @Override
    public List<Auction> selectAuctionListFP() {
        return auctionMapper.selectAuctionListFP();
    }

    @Override
    public List<Auction> selectEndAuctionList() {
        return auctionMapper.selectEndAuctionList();
    }

    @Override
    public List<Auction> selectAuctionByOrgIds(Auction auction) {
        return auctionMapper.selectAuctionByOrgIds(auction);
    }

}
