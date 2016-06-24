package com.autostreets.biz.auction.enums;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

/**
 * 精品二手车相关的车价区间列表
 * @author chunfeng.huang
 *
 */
public enum NoHagglePriceRangeEnum {

	UNDER_EIGHT(1, "8万以下", ",8"),
    EIGHT_TEN(2, "8-10万", "8,10"), 
    TEN_FIFTEEN(3, "10-15万", "10,15"), 
    FIFTEEN_TWENTY(4, "15-20万", "15,20"), 
    TWENTY_THIRTY(5, "20-30万", "20,30"), 
    THIRTY_FIFTY(6, "30-50万", "30,50"), 
    FIFTY_UP(7, "50万以上", "50,");

    private int code = 0;
    private String name = null;
    private String range = null;

    private NoHagglePriceRangeEnum(int code, String name, String range) {
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
        for (NoHagglePriceRangeEnum e : EnumSet.allOf(NoHagglePriceRangeEnum.class)) {
            lookup.put(e.getCode(), e.getRange());
        }
    }
    
    public static String lookupByValue(BigDecimal value) {
    	String ret = null;
    	
    	String temp = "";
    	String[] valArray = new String[2];
    	for (NoHagglePriceRangeEnum e : EnumSet.allOf(NoHagglePriceRangeEnum.class)) {
    		temp = e.getRange();
    		valArray = temp.split(",");
    		
    		BigDecimal min = StringUtils.isBlank(valArray[0]) ? new BigDecimal("0") : new BigDecimal(valArray[0]);
    		BigDecimal max = new BigDecimal("99999");
    		if (valArray.length > 1) {
    			max = StringUtils.isBlank(valArray[1]) ? new BigDecimal("99999") : new BigDecimal(valArray[1]);
    		}

    		if ((value.compareTo(min) >= 0) && (value.compareTo(max) < 0)) {
    			ret = e.getRange();
    			break;
    		}
    	}
    	return ret;
    }
    
    public static String lookup(Integer code) {  
        return lookup.get(code);  
    }
    
    public static String lookupName(Integer code) {
        String ret = "";
        for (NoHagglePriceRangeEnum e : EnumSet.allOf(NoHagglePriceRangeEnum.class)) {
            if (e.getCode() == code) {
                ret = e.getName();
                break;
            }
        }
        return ret;
    }
    
    public static List<TreeMap<String, String>> getList() {
        List<TreeMap<String, String>> list = new ArrayList<TreeMap<String, String>>();
        NoHagglePriceRangeEnum[] values = NoHagglePriceRangeEnum.values();
        for (int i = 0; i < values.length; i++) {
            NoHagglePriceRangeEnum temp = values[i];
            TreeMap<String, String> map = new TreeMap<String, String>();
            map.put("key", String.valueOf(temp.code));
            map.put("value", temp.name);
            list.add(map);
        }
        return list;
    }
    
    public static void main(String[] args) {
    	BigDecimal v = new BigDecimal("7.5");
    	BigDecimal v1 = new BigDecimal("8");
    	BigDecimal v2 = new BigDecimal("28");
    	BigDecimal v3 = new BigDecimal("50");
    	BigDecimal v4 = new BigDecimal("105");
    	System.out.println(NoHagglePriceRangeEnum.lookupByValue(v));    	
    	System.out.println(NoHagglePriceRangeEnum.lookupByValue(v1));
    	System.out.println(NoHagglePriceRangeEnum.lookupByValue(v2));
    	System.out.println(NoHagglePriceRangeEnum.lookupByValue(v3));
    	System.out.println(NoHagglePriceRangeEnum.lookupByValue(v4));
    	
    }

}
