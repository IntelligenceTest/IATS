package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.VehicleSales;
import com.autostreets.biz.auction.model.VehicleSalesExample;
import com.autostreets.framework.common.dal.GenericService;

public interface VehicleSalesService
		extends GenericService<VehicleSales, VehicleSalesExample, Integer> {

    boolean insertOrUpdate(VehicleSales vehicleSales);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @param vehicleSales
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月30日 下午1:58:21
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Integer> selectIdsByCondition(VehicleSales vehicleSales);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 获取车辆销售方式
     * </pre>
     *
     * @param vehicleId
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月30日 下午6:28:10
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Integer getRequirementType(Integer vehicleId);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 销售方式是否拍卖
     * </pre>
     *
     * @param vehicleId
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月30日 下午6:33:08
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean isAuction(Integer vehicleId);
}
