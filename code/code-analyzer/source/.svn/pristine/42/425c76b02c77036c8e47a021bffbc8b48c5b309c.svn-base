package com.autostreets.biz.auction.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum NoHaggleMileRangeEnum {

    UNDER_ONE(1, "1万公里以内", ",1"), 
    ONE_THREE(2, "1-3万公里", "1,3"), 
    THREE_SIX(3, "3-6万公里", "3,6"), 
    SIX_TEN(4, "6-10万公里", "6,10"), 
    TEN_UP(5, "10万公里以上", "10,"); 

    private int code = 0;
    private String name = null;
    private String range = null;

    private NoHaggleMileRangeEnum(int code, String name, String range) {
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

    private static final Map<Integer, String> lookup = new HashMap<Integer, String>();
    
    static {
        for (NoHaggleMileRangeEnum e : EnumSet.allOf(NoHaggleMileRangeEnum.class)) {
            lookup.put(e.getCode(), e.getRange());
        }
    }
    
    public static String lookup(Integer code) {  
        return lookup.get(code);  
    }
    
    public static String lookupName(Integer code) {
        String ret = "";
        for (NoHaggleMileRangeEnum e : EnumSet.allOf(NoHaggleMileRangeEnum.class)) {
            if (e.getCode() == code) {
                ret = e.getName();
                break;
            }
        }
        return ret;
    }
    
    public static List<TreeMap<String, String>> getList() {
        List<TreeMap<String, String>> list = new ArrayList<TreeMap<String, String>>();
        NoHaggleMileRangeEnum[] values = NoHaggleMileRangeEnum.values();
        for (int i = 0; i < values.length; i++) {
            NoHaggleMileRangeEnum temp = values[i];
            TreeMap<String, String> map = new TreeMap<String, String>();
            map.put("key", String.valueOf(temp.code));
            map.put("value", temp.name);
            list.add(map);
        }
        return list;
    }
}
