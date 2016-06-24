package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.framework.common.dal.GenericService;

public interface MemberVehicleFavoriteService extends
        GenericService<MemberVehicleFavorite, MemberVehicleFavoriteExample, Integer> {

    /**
     * 
     * @author xiaofeng.zhang
     * 
     * 功能描述: <br>
     * 〈根据type获取当前member收藏的车辆数量〉
     *
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int getMemberFavoriteVehicleCount(MemberVehicleFavorite mf);

    /**
     * @author xiaofeng.zhang
     * 功能描述: <br>
     * 〈根据type获取当前member收藏的车辆〉
     *
     * @param mf
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<MemberVehicleFavorite> getMemberFavoriteVehicle(MemberVehicleFavorite mf);
    
}