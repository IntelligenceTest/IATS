package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.AuctionPlace;
import com.autostreets.biz.auction.model.AuctionPlaceExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface AuctionPlaceService extends GenericService<AuctionPlace, AuctionPlaceExample, Integer> {

    /**
     * 
     * 功能描述: <br>
     * 〈分页查询〉
     *
     * @param pagination
     * @param auctionPlace
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Pagination getAuctionPlaceByPage(Pagination pagination, AuctionPlace auctionPlace);

    /**
     * 
     * 功能描述: <br>
     * 〈获取拍卖场地列表〉
     *
     * @param auctionPlace
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<AuctionPlace> getAuctionPlaceList(AuctionPlace auctionPlace);

    /**
     * 功能描述: <br>
     * 〈拍卖场地上一个场次〉
     * 
     * @author jingzhou.zhao
     * @datetime 2015年7月14日 下午2:53:42
     * @param placeId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Integer getPlaceLastAuctionNum(Integer placeId);

    /**
     * 
     * 功能描述: <br>
     * 〈获取拍卖场地的城市〉
     *
     * @param auctionPlace
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<AuctionPlace> getAuctionPlaceCityList(AuctionPlace auctionPlace);
}
