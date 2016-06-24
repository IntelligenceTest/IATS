package com.autostreets.biz.auction.service;

import com.autostreets.biz.auction.model.DealerPurchaseVehicle;
import com.autostreets.biz.auction.model.DealerPurchaseVehicleExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface DealerPurchaseVehicleService extends
        GenericService<DealerPurchaseVehicle, DealerPurchaseVehicleExample, Integer> {

    /**
     * 
     * 功能描述: <br>
     * 〈收购车管理列表数据〉
     *
     * @param pagination
     * @param dealerPurchaseVehicle
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Pagination selectByPage(Pagination pagination, DealerPurchaseVehicle dealerPurchaseVehicle);

    /**
     * 
     * 功能描述: <br>
     * 〈同一门店下，该vin码是否已经存在〉
     *
     * @param vinCode
     * @param orgId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Boolean noDupliVInCode(String vinCode, Integer orgId);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 评估录入
     * </pre>
     *
     * @param purchaseId
     * @return vehicle code
     * @author jingzhou.zhao
     * @datetime 2016年1月18日 上午10:24:57
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public String toAssess(Integer purchaseId, Integer orgId, String orgName);

    /**
     * 
     * 功能描述: <br>
     * 〈查询该门店下的所有的已签约的汇总〉
     *
     * @author dongling.qu
     * @param pagination
     * @param dealerPurchaseVehicle
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Pagination selectContractPurchaseV(Pagination pagination, DealerPurchaseVehicle dealerPurchaseVehicle);

    /**
     * 
     * 功能描述: <br>
     * 〈根据评估师查询〉
     *
     * @param pagination
     * @param dealerPurchaseVehicle
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Pagination selectContractPurchaseByAppraiser(Pagination pagination,
            DealerPurchaseVehicle dealerPurchaseVehicle);

    /**
     * 
     * 功能描述: <br>
     * 〈根据评估师查询总数〉
     *
     * @param dealerPurchaseVehicle
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public DealerPurchaseVehicle selectByVehicleAppraiser(DealerPurchaseVehicle dealerPurchaseVehicle);

    /**
     * 
     * 功能描述: <br>
     * 〈根据推荐人查询总数〉
     *
     * @param dealerPurchaseVehicle
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public DealerPurchaseVehicle selectByRecommender(DealerPurchaseVehicle dealerPurchaseVehicle);

    /**
     * 
     * 功能描述: <br>
     * 〈查询待销售的车辆〉
     *
     * @param pagination
     * @param dealerPurchaseVehicle
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Pagination selectByOnSaleVehicle(Pagination pagination, DealerPurchaseVehicle dealerPurchaseVehicle);

    /**
     * 功能描述:更新车辆状态为在售 <br>
     *
     * @param processType
     *            审批类型
     * @param processInstanceId
     */
    public void updateVehicleSaleStatus(Integer processType, Integer processInstanceId);

    /**
     * 
     * 功能描述: <br>
     * 〈查询所有的车辆〉
     *
     * @param pagination
     * @param dealerPurchaseVehicle
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Pagination selectAllVehicle(Pagination pagination, DealerPurchaseVehicle dealerPurchaseVehicle);
}
