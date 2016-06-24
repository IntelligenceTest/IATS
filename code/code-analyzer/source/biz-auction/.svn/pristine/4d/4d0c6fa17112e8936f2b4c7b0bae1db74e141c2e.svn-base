package com.autostreets.biz.auction.mapper;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.model.VehicleExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface VehicleMapper extends GenericMapper<Vehicle, VehicleExample, Integer> {

	/**
	 * @param params
	 * @return
	 */
	int countByOrgMap(Map<String, Object> params);

	/**
	 * @param params
	 * @return
	 */
	List<Vehicle> selectByOrgMap(Map<String, Object> params);
    
    Integer selectUsedVehicleCountByMap(Map<String, Object> params);

    List<Map<String,Object>> selectUsedVehicleByMap(Map<String, Object> params);

	/**
	 * @param params
	 * @return
	 */
	List<Vehicle> selectByMap(Map<String, Object> params);
	
	Integer countForPricingCenter(Vehicle vehicle);
	
	List<Vehicle> selectForPricingCenter(Vehicle vehicle);
	/**
	 * 
	 * 功能描述: <br>
	 * 〈获取当前品牌车型的历史成交价列表作为参考价〉
	 * 
	 * map包含三个参数
	 * @param brand
	 * @param vehicleModel
	 * @param limi 查询 0~limi的数据
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
    List<Vehicle> getReferencePriceList(Map<String,Object> map);
    
    
}