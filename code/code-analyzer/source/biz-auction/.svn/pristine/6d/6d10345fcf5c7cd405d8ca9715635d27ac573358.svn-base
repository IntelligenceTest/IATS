package com.autostreets.biz.auction.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * 车辆年龄区间表
 * @author meng.zhao
 *
 */
public enum VehicleAgeRangeEnum {

	URDER_ONE(1, "1年以下", ",1"),
	ONE_THREE(2, "1-3年", "1,3"),
	THREE_FIVE(3, "3-5年", "3,5"),
	FIVE_EIGHT(4, "5-8年", "5,8"),
	OVER_EIGHT(5, "8年以上", "8,");
    private int code = 0;
    private String name = null;
    private String range = null;
    
    private VehicleAgeRangeEnum(int code, String name, String range) {
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
        for (VehicleAgeRangeEnum s : EnumSet.allOf(VehicleAgeRangeEnum.class)) {  
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
        VehicleAgeRangeEnum[] values = VehicleAgeRangeEnum.values();
        for (int i = 0; i < values.length; i++) {
        	VehicleAgeRangeEnum temp = values[i];
        	TreeMap<String, String> map = new TreeMap<String, String>();
            map.put("key", String.valueOf(temp.code));
            map.put("value", temp.name);
            list.add(map);
        }
        return list;
    }
}
