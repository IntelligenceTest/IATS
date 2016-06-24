package com.autostreets.biz.auction.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autostreets.biz.auction.domain.AuctionDataUploadVO;
import com.autostreets.biz.auction.enums.AuctionUploadLogOperTypeEnum;
import com.autostreets.biz.auction.mapper.AuctionDataUploadMapper;
import com.autostreets.biz.auction.mapper.AuctionMemberUploadMapper;
import com.autostreets.biz.auction.mapper.AuctionUploadLogMapper;
import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionDataUpload;
import com.autostreets.biz.auction.model.AuctionDataUploadExample;
import com.autostreets.biz.auction.model.AuctionMemberUpload;
import com.autostreets.biz.auction.model.AuctionMemberUploadExample;
import com.autostreets.biz.auction.model.AuctionUploadLog;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.base.BaseAuctionMemberUploadExample.Criteria;
import com.autostreets.biz.auction.service.AuctionDataUploadService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.model.Member;
import com.autostreets.model.MemberExample;
import com.autostreets.service.MemberService;
import com.ibm.icu.util.Calendar;

@Service("auctionDataUploadService")
public class AuctionDataUploadServiceImpl implements AuctionDataUploadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionDataUploadServiceImpl.class);

    @Autowired
    private AuctionDataUploadMapper auctionDataUploadMapper;

    @Autowired
    private AuctionMemberUploadMapper auctionMemberUploadMapper;

    @Autowired
    private AuctionUploadLogMapper auctionUploadLogMapper;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private MemberService memberService;

    @Override
    public Pagination selectPage(Pagination pagination, AuctionDataUploadVO auctionDataUploadVO) {
        LOGGER.debug("首页分页查询");
        Pagination p = pagination;

        if (1 == auctionDataUploadVO.getDataFlag().intValue()) {
            int cnt = auctionDataUploadMapper.countByAuctionMember(auctionDataUploadVO);
            p.setCount(cnt);
            auctionDataUploadVO.setBegin(p.getBegin());
            auctionDataUploadVO.setLength(p.getLength());
            List<AuctionDataUploadVO> list = auctionDataUploadMapper.selectByAuctionMember(auctionDataUploadVO);
            for (AuctionDataUploadVO av : list) {
                if (StringUtils.isNotBlank(av.getAuctionMemberIDCar())) {
                    MemberExample example = new MemberExample();
                    example.createCriteria().andIdCardNumEqualTo(av.getAuctionMemberIDCar())
                            .andMemberCategoryEqualTo("商户").andMemberLevelEqualTo("VIP1")
                            .andEnableIn(new ArrayList<String>() {

                                private static final long serialVersionUID = 1L;

                                {
                                    add("0");
                                    add("1");
                                }
                            });
                    List<Member> members = memberService.selectByExample(example);
                    if (members == null || members.size() == 0) {
                        av.setMemberType("临时会员");
                    } else {
                        av.setMemberType("认证会员");
                    }
                }
                if (StringUtils.isNotBlank(av.getMemberSid())) {
                    Member mem = memberService.selectByPrimaryKey(av.getMemberSid());
                    av.setAuctionMemberCellphone(mem.getCellphone());
                    av.setAuctionMemberIDCar(mem.getIdCardNum());
                    av.setAuctionMemberWechat(mem.getWeixin());
                    av.setAuctionMemberProvince(mem.getProvince());
                    av.setAuctionMemberCity(mem.getCity());
                }
            }
            p.setDataList(list);
        } else if (2 == auctionDataUploadVO.getDataFlag().intValue()) {
            int cnt = auctionDataUploadMapper.countByAuctionVehicle(auctionDataUploadVO);
            p.setCount(cnt);
            auctionDataUploadVO.setBegin(p.getBegin());
            auctionDataUploadVO.setLength(p.getLength());
            List<AuctionDataUploadVO> list = auctionDataUploadMapper.selectByAuctionVehicle(auctionDataUploadVO);
            for (AuctionDataUploadVO av : list) {

                if (StringUtils.isNotBlank(av.getAuctionMemberIDCar())) {
                    MemberExample example = new MemberExample();
                    example.createCriteria().andIdCardNumEqualTo(av.getAuctionMemberIDCar())
                            .andMemberCategoryEqualTo("商户").andMemberLevelEqualTo("VIP1")
                            .andEnableIn(new ArrayList<String>() {

                                private static final long serialVersionUID = 1L;

                                {
                                    add("0");
                                    add("1");
                                }
                            });
                    List<Member> members = memberService.selectByExample(example);
                    if (members == null || members.size() == 0) {
                        av.setMemberType("临时会员");
                    } else {
                        av.setMemberType("认证会员");
                    }
                }
                if (StringUtils.isNotBlank(av.getMemberSid())) {
                    Member mem = memberService.selectByPrimaryKey(av.getMemberSid());
                    av.setAuctionMemberName(mem.getName());
                    av.setAuctionMemberCellphone(mem.getCellphone());
                    av.setAuctionMemberIDCar(mem.getIdCardNum());
                    av.setAuctionMemberWechat(mem.getWeixin());
                    av.setAuctionMemberProvince(mem.getProvince());
                    av.setAuctionMemberCity(mem.getCity());
                }
            }

            p.setDataList(list);
        }

        return p;
    }

    @Override
    public List<AuctionDataUploadVO> selectVehiclesByAuctionMember(AuctionDataUploadVO auctionDataUploadVO) {
        LOGGER.debug("按参拍人查询时查看成交车辆列表");
        return null;
    }

    @Override
    public Map<String, Object> loadAuctionInfo(AuctionDataUploadVO auctionDataUploadVO) {
        LOGGER.debug("查询拍卖后台指定拍卖会统计信息");
        Map<String, Object> map;
        Integer auctionId = auctionDataUploadVO.getAuctionId();

        Auction act = auctionService.selectByPrimaryKey(auctionId);
        if (null != act) {
            map = new HashMap<String, Object>();
            map.put("auctionTitle", act.getTitle());
            map.put("auctionDate", DateFormatUtils.format(act.getStartTimestamp(), "yyyy-MM-dd"));

            AuctionVehicleExample avExample = new AuctionVehicleExample();
            avExample.createCriteria().andAuctionIdEqualTo(auctionId);
            int cnt = auctionVehicleService.countByExample(avExample);
            map.put("auctionVehicleNum", cnt);

            avExample = new AuctionVehicleExample();
            avExample.createCriteria().andAuctionIdEqualTo(auctionId).andStatusEqualTo(2);
            cnt = auctionVehicleService.countByExample(avExample);
            map.put("dealNum", cnt);

            return map;
        }

        return null;
    }

    @Override
    public boolean uploadCheck(AuctionDataUploadVO auctionDataUploadVO) {
        LOGGER.debug("检查拍卖会是否可以被导入");
        int cnt = auctionDataUploadMapper.countByAuctionMember(auctionDataUploadVO);
        if (cnt == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public void insertUploadData(Integer crtUserId, Integer auctionId, List<AuctionDataUploadVO> memberList,
            List<AuctionDataUploadVO> avList) {
        try {
            Date crtDt = new Date();
            AuctionVehicleExample avExample = new AuctionVehicleExample();
            avExample.createCriteria().andAuctionIdEqualTo(auctionId);
            List<AuctionVehicle> list = auctionVehicleService.selectByExample(avExample);

            // 保存参拍人信息
            AuctionMemberUpload amu;
            List<AuctionMemberUpload> memberUploads = new ArrayList<AuctionMemberUpload>();
            for (AuctionDataUploadVO vo : memberList) {
                amu = new AuctionMemberUpload();
                amu.setAuctionId(auctionId);
                amu.setName(vo.getAuctionMemberName());
                amu.setIdCardNum(vo.getAuctionMemberIDCar());
                amu.setCellphone(vo.getAuctionMemberCellphone());
                amu.setAuctionNumber(vo.getAuctionNumber());
                amu.setWechat(vo.getAuctionMemberWechat());
                amu.setProvince(vo.getAuctionMemberProvince());
                amu.setCity(vo.getAuctionMemberCity());
                amu.setRegisterTime(vo.getRegisterTime());
                amu.setCreateTime(crtDt);
                amu.setCreatedBy(crtUserId);
                amu.setDelFlag(false);
                memberUploads.add(amu);
            }
            auctionMemberUploadMapper.insertBatch(memberUploads);// 批量增加

            // 保存拍品信息
            AuctionDataUpload adu;
            Integer auctionVehicleOrder;
            Integer auctionVehicleId = null;
            Date dealTime;
            int dealNum = 0;
            List<AuctionDataUpload> dataUploads = new ArrayList<AuctionDataUpload>();
            for (AuctionDataUploadVO vo : avList) {
                auctionVehicleOrder = vo.getAuctionVehicleOrder();
                for (AuctionVehicle av : list) {
                    if (av.getAuctionVehicleOrder().equals(auctionVehicleOrder)) {
                        auctionVehicleId = av.getId();
                    }
                }

                adu = new AuctionDataUpload();
                adu.setAuctionId(auctionId);
                adu.setAuctionVehicleId(auctionVehicleId);
                adu.setAuctionNumber(vo.getAuctionNumber());
                adu.setAuctionVehicleOrder(auctionVehicleOrder);
                dealTime = vo.getDealTime();
                if (null != dealTime) {
                    adu.setDealTime(dealTime);
                    adu.setDealPrice(vo.getDealPrice());
                    dealNum++;
                }
                adu.setCreateTime(crtDt);
                adu.setCreatedBy(crtUserId);
                adu.setDelFlag(false);
                dataUploads.add(adu);
            }

            auctionDataUploadMapper.insertBatch(dataUploads);// 批量增加

            AuctionDataUploadVO vo = new AuctionDataUploadVO();
            vo.setAuctionId(auctionId);
            vo.setUserId(crtUserId);
            auctionDataUploadMapper.auctionMemberUploadInsert(vo);// 调用存储过程插入数据

            AuctionUploadLog aul = new AuctionUploadLog();
            aul.setAuctionId(auctionId);
            aul.setOperType(AuctionUploadLogOperTypeEnum.IMPORT_DATA.getKey());
            aul.setMemberNum(memberList.size());
            aul.setVehicleNum(avList.size());
            aul.setDealNum(dealNum);
            aul.setCreateTime(crtDt);
            aul.setCreatedBy(crtUserId);
            auctionUploadLogMapper.insertSelective(aul);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteUploadData(Integer auctionId, Integer userId) {
        if (userId != null) {
            // 超过两天不让删除
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 2);
            AuctionDataUploadExample auctionDataUploadExample = new AuctionDataUploadExample();
            com.autostreets.biz.auction.model.base.BaseAuctionDataUploadExample.Criteria criteria = auctionDataUploadExample
                    .createCriteria();
            criteria.andCreatedByEqualTo(userId);
            criteria.andAuctionIdEqualTo(auctionId).andDelFlagEqualTo(false)
                    .andCreateTimeGreaterThanOrEqualTo(calendar.getTime());
            int memberCount = auctionDataUploadMapper.countByExample(auctionDataUploadExample);

            AuctionMemberUploadExample auctionMemberUploadExample = new AuctionMemberUploadExample();
            Criteria createCriteria = auctionMemberUploadExample.createCriteria();
            createCriteria.andCreatedByEqualTo(userId);
            createCriteria.andAuctionIdEqualTo(auctionId).andDelFlagEqualTo(false)
                    .andCreateTimeGreaterThanOrEqualTo(calendar.getTime());
            int vehicleCount = auctionMemberUploadMapper.countByExample(auctionMemberUploadExample);
            if (memberCount == 0 && vehicleCount == 0) {
                return false;
            }
        }
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("auctionId", auctionId);
        params.put("userId", userId);
        int dataResult = auctionDataUploadMapper.deleteUploadData(params);
        int memberResult = auctionMemberUploadMapper.deleteUploadData(params);
        if (dataResult + memberResult > 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map<String, Object> getUploadFileInfoCount(Integer auctionId) {
        Auction auction = auctionService.selectByPrimaryKey(auctionId);
        Map<String, Object> data = new HashMap<>();
        data.put("auctionTitle", auction.getTitle());
        data.put("auctionDate", DateFormatUtils.format(auction.getStartTimestamp(), "yyyy-MM-dd"));
        AuctionDataUploadExample auctionDataUploadExample = new AuctionDataUploadExample();
        auctionDataUploadExample.createCriteria().andAuctionIdEqualTo(auctionId).andDelFlagEqualTo(false);
        int auctionVehicleNum = auctionDataUploadMapper.countByExample(auctionDataUploadExample);
        data.put("auctionVehicleNum", auctionVehicleNum);// 车辆数
        auctionDataUploadExample.clear();
        auctionDataUploadExample.createCriteria().andAuctionIdEqualTo(auctionId).andDealTimeIsNotNull()
                .andDelFlagEqualTo(false);
        int auctionSuccessNum = auctionDataUploadMapper.countByExample(auctionDataUploadExample);
        data.put("auctionSuccessNum", auctionSuccessNum);// 车辆成交数
        AuctionMemberUploadExample auctionMemberUploadExample = new AuctionMemberUploadExample();
        auctionMemberUploadExample.createCriteria().andAuctionIdEqualTo(auctionId).andDelFlagEqualTo(false);
        int auctionPersonNum = auctionMemberUploadMapper.countByExample(auctionMemberUploadExample);
        data.put("auctionPersonNum", auctionPersonNum);// 参拍人数
        return data;
    }

    @Override
    public Map<String, Object> getUploadCalcInfo(Integer type, AuctionDataUploadVO auctionDataUploadVO) {
        return auctionDataUploadMapper.getUploadMemberCalcInfo(auctionDataUploadVO);
    }

    @Override
    public List<AuctionDataUploadVO> getVehicleInfoByAuctionPerson(Integer auctionId, String memberSid,
            String idCardNum, Integer userId) {
        AuctionDataUploadVO auctionDataUploadVO = new AuctionDataUploadVO();
        auctionDataUploadVO.setUserId(userId);
        auctionDataUploadVO.setAuctionId(auctionId);
        if (StringUtils.isNotBlank(memberSid)) {
            auctionDataUploadVO.setMemberSid(memberSid);
        } else {
            auctionDataUploadVO.setAuctionMemberIDCar(idCardNum);
        }
        List<AuctionDataUploadVO> auctionDataUploadVOs = auctionDataUploadMapper
                .getVehicleInfoByAuctionPerson(auctionDataUploadVO);
        return auctionDataUploadVOs;
    }
}