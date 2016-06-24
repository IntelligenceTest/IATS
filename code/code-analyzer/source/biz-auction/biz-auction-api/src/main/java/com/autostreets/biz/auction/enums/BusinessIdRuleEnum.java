package com.autostreets.biz.auction.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 业务ID对应关系
 * @author meng.zhao
 *
 */
public enum BusinessIdRuleEnum {

	/**
	 * 车辆相关
	 */
	VEHICLE("10", "车辆", "vehicle_id"),
	AV_ONLINE("11", "拍品（在线拍）", "av_id"),
	AV_SYN("12", "拍品（同步拍）", "av_id"),
	AV_FIXED("13", "拍品（一口价）", "av_id"),
	AV_ONCEBID("14", "拍品（即时拍）", "av_id"),
	/**
	 * 拍卖会
	 */
	AUCTION("22", "拍卖会（同步拍）", "autction_id"),
	/**
	 * 二手车订单
	 */
	OV_ONLINE("31", "二手车订单（在线拍）", "ov_id"),
	OV_SYN("32", "二手车订单（同步拍）", "ov_id"),
	OV_FIXED("33", "二手车订单（一口价）", "ov_id"),
	OV_OTHERS("34", "二手车订单（其它）", "ov_id"),
	OV_RENZ("35", "认证订单", "ov_id"),
	OV_ONCEBID("36", "二手车订单（即时拍）", "ov_id"),
	/**
	 * 新车订单
	 */
	NV_ONLINE("41", "新车订单", "nv_id"),
	
	/**
     * 活动订单
     */
    ACT_ONLINE("42", "新车订单", "nv_id"),
	/**
	 * 预约单号
	 */
	AP_TRY_DRIVING("51", "试乘试驾", "ap_id"),
	AP_SALL_CAR("52", "预约卖车", "ap_id"),
	AP_SEE_CAR("53", "预约看车", "ap_id"),
	AP_REPLACEMENT("54", "预约置换", "ap_id"),
	AP_INQUERY("55", "预约询价", "ap_id"),
	AP_BEAUTY("56", "预约美容", "ap_id"),
	AP_MAINTENANCE("57", "预约保养维修", "ap_id"),
	/**
	 * 服务支持
	 */
	SS_FIN_APPLY("61", "贷款申请", "ss_id"),
	SS_WARRANTY("62", "延保申请", "ss_id"),
	SS_INSURANCE("63", "车险申请", "ss_id"),
	/**
	 * 代交罚单
	 */
	VIOLATION("71","代缴罚单申请","violation_id"),
	VI_PAY("72","代缴罚单支付","violation_id");

    private String code = null;
    private String name = null;
    private String sequenceId = null;
    
    private BusinessIdRuleEnum(String code, String name, String sequenceId) {
        this.code = code;
        this.name = name;
        this.sequenceId = sequenceId;
    }

    public String getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSequenceId() {
		return sequenceId;
	}

	/**
     * 根据code查询对应的SEQUENCE ID
     */
    private static final Map<String, String> lookup = new HashMap<String, String>();  
  
    static {  
        for (BusinessIdRuleEnum s : EnumSet.allOf(BusinessIdRuleEnum.class)) {  
            lookup.put(s.getCode(), s.getSequenceId());  
        }  
    }
    
    public static String lookup(String code) {  
        return lookup.get(code);  
    } 

    /**
     * 
     * 获取业务规则列表
     * 
     * @param typeName
     * @return
     */
    public static List<TreeMap<String, String>> getList() {
        List<TreeMap<String, String>> list = new ArrayList<TreeMap<String, String>>();
        BusinessIdRuleEnum[] values = BusinessIdRuleEnum.values();
        for (int i = 0; i < values.length; i++) {
        	BusinessIdRuleEnum temp = values[i];
        	TreeMap<String, String> map = new TreeMap<String, String>();
            map.put("key", temp.code);
            map.put("value", temp.name);
            list.add(map);
        }
        return list;
    }
}
