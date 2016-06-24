package com.autostreets.biz.auction.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.DealerUsedVehicle;
import com.autostreets.biz.auction.model.DealerUsedVehicleExample;
import com.autostreets.biz.auction.model.DealerVehicleLog;
import com.autostreets.biz.usedvehicle.model.DictBrandseries;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface DealerUsedVehicleService extends GenericService<DealerUsedVehicle, DealerUsedVehicleExample, Integer> {

    /**
     * 取得品牌列表
     * @return
     */
    List<DictBrandseries> selectBrandList();

    /**
     * 取得车辆性质列表
     * @return
     */
    List<AuctionDictionary> selectVehiclePpeList();

    /**
     * 取得销售渠道列表
     * @return
     */
    List<Map<String, String>> selectSalesChannelList();

    /**
     * 根据数据权限取得门店列表
     * @param orgScopeList
     * @return
     */
    List<Map<String, String>> selectOrgListByScopeList(List<Integer> orgScopeList);

    /**
     * 取得分页列表
     * @param pagination
     * @param dealerUsedVehicle
     * @return
     */
    Pagination selectPage(Pagination pagination, DealerUsedVehicle dealerUsedVehicle);

    /**
     * 判断相同组织机构下，vin码是否存在
     * @param vinCode
     * @param orgId
     * @return 存在返回true，不存在返回false
     */
    boolean isExistByVinAndOrgId(String vinCode, Integer orgId);

    /**
     * 车辆登记
     * @param crtUserId 
     * @param dealerUsedVehicle
     * @param orgId 
     */
    void enregisterSave(DealerUsedVehicle dealerUsedVehicle, Integer crtUserId, Integer orgId);

//    /**
//     * 申请退役
//     * @param dealerUsedVehicle
//     * @param crtUserId
//     */
//    void appliedRetireSave(DealerUsedVehicle dealerUsedVehicle, Integer crtUserId);

    /**
     * 退役审核
     * @param dealerUsedVehicle
     * @param crtUserId
     */
    void retiredSave(DealerUsedVehicle dealerUsedVehicle, Integer crtUserId);

    /**
     * 将自用车信息保存到eqs系统
     * @param id
     * @param crtUserId 
     * @param crtUserRealName 
     * @param crtOrgId 
     * @param crtOrgName 
     * @return
     * @throws IOException 
     */
    String eqsSave(Integer id, Integer crtUserId, String crtUserRealName, Integer crtOrgId, String crtOrgName) throws IOException;

    /**
     * 车辆跟踪
     * @param id
     * @return 
     */
    List<DealerVehicleLog> track(Integer id);

    String retireApply(String retireInfos, String vinCodes, String dataIds, Integer applyUserId, String applyUserName,
            String applyCompany, Integer orgId);

    /**
     * 取得eqs系统车辆编号
     * @param id
     * @return
     */
    String eqsDetail(Integer vehicleId);
}