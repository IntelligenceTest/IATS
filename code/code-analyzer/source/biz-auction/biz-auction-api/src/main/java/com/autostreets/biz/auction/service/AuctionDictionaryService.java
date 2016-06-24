package com.autostreets.biz.auction.service;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionDictionaryExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface AuctionDictionaryService extends GenericService<AuctionDictionary, AuctionDictionaryExample, Integer> {

    List<AuctionDictionary> selectResource(String category);

    /**
     * 根据类型和名称获取其值
     * 
     * @param category
     *            类型标识
     * @param name
     *            名称
     * @return
     */
    String getValueByCategoryName(String category, String name);

    /**
     * 根据类型标识和值获取其名称
     * 
     * @param category
     *            类型标识
     * @param value
     *            值
     * @return
     */
    String getNameByCategoryValue(String category, String value);

    /**
     * 获取精品二手车支付订金额度值，单位：元
     * 
     * @return
     */
    String selectNoHagglePreprice();

    /**
     * 获取页面广告页是否弹出的开关值 1-开 0-关
     * 
     * @return
     */
    String selectPopSwitch();

    public List<AuctionDictionary> selectResourceOrderBy(String category, String order);

    List<AuctionDictionary> selectCommissionFeeRange();

    String choiceImgUrl(String spec, String urlColValue);

    /**
     * 获取拍品出价与保留价的差价的临界值
     * 
     * @return
     */
    Integer selectPriceDiff();

    /**
     * 获取用户补差价的倒计时值，单位：分钟
     * 
     * @return
     */
    Integer selectTimeDiff();

    /**
     * @Title: getInsidersAccount
     * @Description: 获取内部人员顶价账号
     * @return List<String>
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月3日 下午2:38:34
     */
    List<String> getInsidersAccount();

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer selectStatusChangeTime_R();

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer selectStatusChangeTime_NR();

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer selectPayTime();

    /**
     * 取得评估状态列表
     */
    Map<String, String> selectAssessmentStatusByCustomerList();

    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年11月16日 下午3:02:26
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AuctionDictionary> selectAuctionType();

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年11月16日 下午3:02:28
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AuctionDictionary> selectStatusOfAuction();

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年11月16日 下午3:13:12
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AuctionDictionary> selectAuctionModel();

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 商家在线拍加价幅度
     * </pre>
     *
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年11月25日 下午1:59:33
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer selectDealerOnlinePlusRange();

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param pagination
     * @param auctionDictionary
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Pagination selectDictionaryByPage(Pagination pagination, AuctionDictionary auctionDictionary);
}