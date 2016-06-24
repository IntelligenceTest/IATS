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
public enum VehicleMileRangeEnum {

	URDER_ONE(1, "1万公里以内", ",1"),
	ONE_THREE(2, "1-3万公里", "1,3"),
	THREE_SIX(3, "3-6万公里", "3,6"),
	SIX_TEN(4, "6-10万公里", "6,10"),
	TEN_FIFTEEN(5, "10-15万公里", "10,15"),
	OVER_FIFTEEN(6, "15万公里以上", "15,");
    private int code = 0;
    private String name = null;
    private String range = null;
    
    private VehicleMileRangeEnum(int code, String name, String range) {
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
        for (VehicleMileRangeEnum s : EnumSet.allOf(VehicleMileRangeEnum.class)) {  
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
        VehicleMileRangeEnum[] values = VehicleMileRangeEnum.values();
        for (int i = 0; i < values.length; i++) {
        	VehicleMileRangeEnum temp = values[i];
        	TreeMap<String, String> map = new TreeMap<String, String>();
            map.put("key", String.valueOf(temp.code));
            map.put("value", temp.name);
            list.add(map);
        }
        return list;
    }
}
