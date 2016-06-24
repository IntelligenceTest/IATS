package com.autostreets.biz.auction.mapper;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.DealerPurchaseVehicle;
import com.autostreets.biz.auction.model.DealerPurchaseVehicleExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface DealerPurchaseVehicleMapper extends
        GenericMapper<DealerPurchaseVehicle, DealerPurchaseVehicleExample, Integer> {

    List<DealerPurchaseVehicle> selectByPage(DealerPurchaseVehicle DealerPurchaseVehicle);

    int countByPage(DealerPurchaseVehicle DealerPurchaseVehicle);

    List<DealerPurchaseVehicle> selectContractPurchaseV(DealerPurchaseVehicle dealerPurchaseVehicle);

    DealerPurchaseVehicle selectConandRecomSum(DealerPurchaseVehicle dealerPurchaseVehicle);

    List<DealerPurchaseVehicle> selectContractPurchaseByAppraiser(DealerPurchaseVehicle dealerPurchaseVehicle);

    int selectContractPurchaseVCount(DealerPurchaseVehicle dealerPurchaseVehicle);

    int selectContractPurchaseByAppraiserCount(DealerPurchaseVehicle dealerPurchaseVehicle);

    List<DealerPurchaseVehicle> selectByVehicleAppraiser(DealerPurchaseVehicle dealerPurchaseVehicle);

    List<DealerPurchaseVehicle> selectByRecommender(DealerPurchaseVehicle dealerPurchaseVehicle);

    int countByOnSaleVehicle(DealerPurchaseVehicle dealerPurchaseVehicle);

    List<DealerPurchaseVehicle> selectByOnSaleVehicle(DealerPurchaseVehicle dealerPurchaseVehicle);

    void updateVehicleSaleStatus(Map<String, Integer> map);

    int selectAllVehicleCount(DealerPurchaseVehicle dealerPurchaseVehicle);

    List<DealerPurchaseVehicle> selectAllVehicle(DealerPurchaseVehicle dealerPurchaseVehicle);

}