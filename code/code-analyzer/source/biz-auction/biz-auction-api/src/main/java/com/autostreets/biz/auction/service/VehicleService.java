package com.autostreets.biz.auction.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.model.VehicleExample;
import com.autostreets.biz.usedvehicle.enums.RequirementTypeEnum;
import com.autostreets.biz.usedvehicle.enums.SaleStatusEnum;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface VehicleService extends GenericService<Vehicle, VehicleExample, Integer> {

    /**
     * 更新车辆同步信息，自动判断新增还是修改，只可由usedvehicle项目从外部调用，其余项目包括auction本身的任何功能均不可使用
     * 
     * @param vehicle
     * @return
     */
    boolean insertOrUpdate(Vehicle vehicle);

    /**
     * 删除无效的车辆同步信息，只可由usedvehicle项目从外部调用，其余项目包括auction本身的任何功能均不可使用
     * 
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 获取所属店铺的二手车数量
     * 
     * @param params
     * @return
     */
    int countByOrgMap(Map<String, Object> params);

    /**
     * 获取所属店铺的二手车列表
     * 
     * @param params
     * @return
     */
    List<Vehicle> selectByOrgMap(Map<String, Object> params);

    public Pagination selectUsedVehicle(Pagination pagination, Map<String, Object> params) throws Exception;

    public List<Map<String, Object>> selectUsedVehicleForExcel(Map<String, Object> params);

	List<Vehicle> selectByMap(Map<String, Object> params);
	/**
	 * 
	 * 功能描述: <br>
	 * 〈商家后台获取定价中心列表〉
	 *
	 * @param pagination
	 * @param vehicle
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
    Pagination selectForPricingCenter(Pagination pagination, VehicleInfo vehicle);
    /**
     * 
     * 功能描述: <br>
     * 〈查询同品牌，车型的历史成交价列表作为参考价〉
     *
     * @param brand
     * @param vehicleModel
     * @param limit
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<Vehicle> getReferencePriceList(String brand, String vehicleModel,int limit);
    
    List<Vehicle> selectVehicleListByIds(List<Integer> idList);
    /**
     * 
     * 功能描述: <br>
     * 〈根据vehicle的销售方式查询拍品或展厅记录〉
     * @author xiaofeng.zhang
     * @param vehicle
     * @param requirementType
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Vehicle getVehicleOnAuctOrFixed(Vehicle vehicle,Integer requirementType);
    
    VehicleInfo selectVehicleInfoById(Integer vehicleId);

    VehicleInfo loadVehicleInfo(Integer vehicleId);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 更新销售状态
     * </pre>
     *
     * @param vehicleId
     * @param newSaleStatus
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月24日 下午12:44:42
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updateSaleStatus(Integer vehicleId, SaleStatusEnum newSaleStatus)
            throws Exception;

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 更新销售状态，并且更新新车指导价
     * </pre>
     *
     * @param vehicleId
     * @param newSaleStatus
     * @param newVehicleSuggestionPrice
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月24日 下午12:44:42
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int updateSaleStatus(Integer vehicleId, SaleStatusEnum newSaleStatus,
            BigDecimal newVehicleSuggestionPrice) throws Exception;

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 更改销售需求
     * </pre>
     *
     * @param vehicleId
     * @param requirementTypeEnum
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月25日 下午1:27:21
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean updateRequirementType(Integer vehicleId, RequirementTypeEnum requirementTypeEnum);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 更新是否定价标识
     * </pre>
     *
     * @param vehicleId
     * @param isPricing
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月29日 上午11:30:46
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean updatePricing(Integer vehicleId, boolean isPricing);

}