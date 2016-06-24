package com.autostreets.biz.auction.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum NoHaggleAgeRangeEnum {

    UNDER_ONE(1, "1年以内", ",1"), 
    UNDER_TWO(2, "2年以内", ",2"), 
    UNDER_THREE(3, "3年以内", ",3"), 
    THREE_FIVE(4, "3-5年", "3,5"), 
    FIVE_TEN(5, "5-10年", "5,10"),
    TEN_UP(6, "10年以上", "10,");

    private int code = 0;
    private String name = null;
    private String range = null;

    private NoHaggleAgeRangeEnum(int code, String name, String range) {
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
        for (NoHaggleAgeRangeEnum s : EnumSet.allOf(NoHaggleAgeRangeEnum.class)) {
            lookup.put(s.getCode(), s.getRange());
        }
    }

    public static String lookup(Integer code) {
        return lookup.get(code);
    }
    
    public static String lookupName(Integer code) {
        String ret = "";
        for (NoHaggleAgeRangeEnum e : EnumSet.allOf(NoHaggleAgeRangeEnum.class)) {
            if (e.getCode() == code) {
                ret = e.getName();
                break;
            }
        }
        return ret;
    }

    public static List<TreeMap<String, String>> getList() {
        List<TreeMap<String, String>> list = new ArrayList<TreeMap<String, String>>();
        NoHaggleAgeRangeEnum[] values = NoHaggleAgeRangeEnum.values();
        for (int i = 0; i < values.length; i++) {
            NoHaggleAgeRangeEnum temp = values[i];
            TreeMap<String, String> map = new TreeMap<String, String>();
            map.put("key", String.valueOf(temp.code));
            map.put("value", temp.name);
            list.add(map);
        }
        return list;
    }

}
