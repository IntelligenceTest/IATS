package com.autostreets.biz.auction.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * 车辆价格区间表
 * @author meng.zhao
 *
 */
public enum VehiclePriceRangeEnum {

	URDER_THREE(1, "3万以下", ",3"),
	THREE_FIVE(2, "3-5万", "3,5"),
	FIVE_EIGHT(3, "5-8万", "5,8"),
	EIGHT_TEN(4, "8-10万", "8,10"),
	TEN_FIFTEEN(5, "10-15万", "10,15"),
	FIFTEEN_TWENTY(6, "15-20万", "15,20"),
	TWENTY_THIRTY(7, "20-30万", "20,30"),
	THIRTY_FIFTY(8, "30-50万", "30,50"),
	OVER_FIFTY(9, "50万以上", "50,");
    private int code = 0;
    private String name = null;
    private String range = null;
    
    private VehiclePriceRangeEnum(int code, String name, String range) {
        this.code = code;
        this.name = name;
        this.range = range;
    }

    public int getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRange() {
		return range;
	}
    
    /**
     * 根据价格查询区间code返回区间范围值
     */
    private static final Map<Integer, String> lookup = new HashMap<Integer, String>();  
  
    static {  
        for (VehiclePriceRangeEnum s : EnumSet.allOf(VehiclePriceRangeEnum.class)) {  
            lookup.put(s.getCode(), s.getRange());  
        }  
    }
    
    public static String lookup(Integer code) {  
        return lookup.get(code);  
    } 

    /**
     * 
     * 获取价格区间列表
     * 
     * @param typeName
     * @return
     */
    public static List<TreeMap<String, String>> getList() {
        List<TreeMap<String, String>> list = new ArrayList<TreeMap<String, String>>();
        VehiclePriceRangeEnum[] values = VehiclePriceRangeEnum.values();
        for (int i = 0; i < values.length; i++) {
        	VehiclePriceRangeEnum temp = values[i];
        	TreeMap<String, String> map = new TreeMap<String, String>();
            map.put("key", String.valueOf(temp.code));
            map.put("value", temp.name);
            list.add(map);
        }
        return list;
    }
}
