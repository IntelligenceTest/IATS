
/**
 * 公共js
 * @author weiyi.wang
 * @date 2014-12-22 14:31:56
 * @version v1.0
 */

var common;
if (!common) {
    common = {};
}
if(!common.commontab){
	common.commontab={};
}

$.ajaxSetup({  
    //contentType:"application/x-www-form-urlencoded;charset=utf-8",
//	error: function (XMLHttpRequest, textStatus, e) {
//		if(XMLHttpRequest.getResponseHeader("Content-Length")=="0"){
//    		common.alert("提示","服务超时!请重试!");
//    	}
//	},
    complete:function(XMLHttpRequest,textStatus){
    	//debugger;//Content-Length
        //通过XMLHttpRequest取得响应头，sessionstatus，  
    	if (XMLHttpRequest.status==401) {
			window.location = "<c:url value="/" />";
		}
    }
});

//$(function() {
//	var tabs=$(".nav.nav-tabs");
//	var tabcontents=$(".tab-content");
//	if (tabs&&tabs.length>0&&tabcontents&&tabcontents.length>0) {
//		var tabsId=tabs.attr("id");
//		var tabContentId=tabcontents.attr("id");
//		var time=new Date().getTime();
//		if (tabsId) {
//			common.commontab.tabsId=tabsId;
//		}else{
//			common.commontab.tabsId="tabs"+time;
//			tabs.attr("id","tabs"+time);
//		}
//		if (tabContentId) {
//			common.commontab.tabContentId=tabContentId;
//		}else{
//			common.commontab.tabContentId="tabContentId"+time;
//			tabContentId.attr("id","tabContentId"+time);
//		}
//	}
//});

/**
 * 格式化日期
 * Y 年
 * M 月
 * d 日
 * h 小时
 * m 分
 * s 秒
 * S 毫秒
 * @param format 格式化日期字符串
 * @eg:YYYY年MM月dd日 HH:mm:ss  return 2014年12月21日 15:40:18
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.dateFormat = function(dateObj, format) {
    var o = {
        "M+": dateObj.getMonth() + 1,
        //month
        "d+": dateObj.getDate(),
        //day
        "H+": dateObj.getHours(),
        //hour
        "m+": dateObj.getMinutes(),
        //minute
        "s+": dateObj.getSeconds(),
        //second
        "q+": Math.floor((dateObj.getMonth() + 3) / 3),
        //quarter
        "S": dateObj.getMilliseconds() //millisecond
    }
    if (/(Y+)/.test(format)) {
        format = format.replace(RegExp.$1, (dateObj.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};

/**
 * @param param<br>
 * &nbsp;&nbsp;key:title 打开tab的标题<br>
 * &nbsp;&nbsp;key:url 要打开的层url<br>
 * &nbsp;&nbsp;key:divId 要打开的tabId<br>
 * &nbsp;&nbsp;key:loadDataAfter 回调函数，可在数据加载完成使用<br>
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.addTab=function(title,url,divId,loadDataAfter){
	var tabs = $("#"+common.commontab.tabsId);
	var aes=tabs.find("li a");
	var flag=true;
	$.each(aes,function(i,n){
		if($(n).html()==title){
			flag=false;
			return;
		}
	});
	//是否存在这个tab页，如果存在，flag=false，直接显示，否则flag=true，加载文档，显示
	if(flag){
		var tabContent=$("#"+common.commontab.tabContentId);
		var loadDataAfter=loadDataAfter?loadDataAfter:$.loop;
		//var time=new Date().getTime();
		$.get(url, function(receiveData){
			tabs.append("<li><a href='#"+divId+"' data-toggle='tab'>"+title+"</a></li>")
			var aId=$($(tabs).find("li:last").find("a").get(0)).attr("href");
			if(loadDataAfter){
				eval(loadDataAfter());
			}
			var divObj=$("#"+divId);//判断是否存在这个div
			if (divObj&&divObj.length>0) {
				$(divObj).remove();
			}
			var divStartHtml="<div id='"+aId.substring(1)+"' class='tab-pane' style='padding-top:10px;'>";
			var divEndHtml="</div>";
			$(tabContent).append(divStartHtml+receiveData+divEndHtml);
			var form=divObj.find("form")[0];//.attr("id");
			$(form).find(":input").attr("autocomplete","off");
			divObj=$("#"+divId);
			$("a[href='"+aId+"']").tab("show");
		});
	}else{
		var aId=$($(tabs).find("li:last").find("a").get(0)).attr("href");
		$("a[href='"+aId+"']").tab("show");
	}
};

common.closeTab=function(divId){
	var tabs=$('a[data-toggle="tab"]').parent();
	if (tabs.length>1) {
		if(divId&&$("#"+divId).length>0){
			$("#"+divId).remove();
		}
		var closeTab=$("a[href='#"+divId+"']").parent();
		$(closeTab).remove();
		var showTab=$('a[data-toggle="tab"]')[0];
		$(showTab).tab("show");
	}
	//event.preventDefault();
};

common.closeTabByTitle=function(title){
	var tabs = $("#"+common.commontab.tabsId);
	if (tabs.length>1) {
		var aes=tabs.find("li a");
		var divId=null;
		$.each(aes,function(i,n){
			if($(n).html()==title){
				divId=$(n).attr("href").substring(1);
				return;
			}
		});
		if(divId&&$("#"+divId).length>0){
			$("#"+divId).remove();
		}
		var closeTab=$("a[href='#"+divId+"']").parent();
		$(closeTab).remove();
		var showTab=$('a[data-toggle="tab"]')[0];
		$(showTab).tab("show");
	}
	//event.preventDefault();
};

/**
 * ajax表单提交，返回JsonResult对象
 * @param formId 表单id
 * @param type 提交类型 POST|GET,可以不传，默认POST
 * @param refreshFormId 要刷新的表单Id
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.save=function(formId,type,refreshFormId){
	if(!type){
		type="POST";
	};
	$.ajax({
		url:$("#"+formId).attr("action"),
        type: type,
        data: $("#"+formId).serialize(),
        dataType: "json",
        success: function(jsonResult) {
        	if(jsonResult){
        		if(jsonResult.success){
        			alert(jsonResult.msg);
        			if(refreshFormId){
        				$("#"+refreshFormId).submit();
        			}
        		}else{
        			alert(jsonResult.msg);
        		}
        	}
        }
    });
};

/**
 * 编辑、详情或删除操作的时候检查是否有选中的行
 * @param tableId 要检查的表格id
 * @param maxRow 能选择的最大行数，如果为空则不限制
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.checkSelect=function(tableId,maxRow){
	var checkBoxes = $("#"+tableId).children("tbody").children();
    var length = checkBoxes.find(":checkbox:checked").length;
    if (length==0) {
    	alert("您未选择任何一行!");
		return false;
	}
    if (maxRow&&$.isNumeric(maxRow)) {
    	if (length>maxRow) {
    		alert("最多只能选择"+maxRow+"行!");
    		return false;
    	}
	}
    return true;
};

/**
 * 获取表格所有选中的id
 * @param tableId 要检查的表格id
 * @returns id集合,以数组形式返回
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.getSelectIds=function(tableId){
	var array=[];
	var checkBoxes = $("#"+tableId).children("tbody").children().find(":checkbox:checked");
	$.each(checkBoxes,function(i,n){
		array.push($(n).val());
	});
	return array;
};

/**
 * 重置表单条件并查询
 * @param formId 表单Id
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.formReset = function(formId) {
	$(':input','#'+formId).not(':button, :submit, :reset, :hidden').val("").removeAttr('checked').removeAttr('selected');
    $("#" + formId)[0].submit();
};

/**
 * 重置表单条件
 * @param formId 表单Id
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.selectFormClean = function(formId) {
	$(':input','#'+formId).not(':button, :submit, :reset').val("").removeAttr('checked').removeAttr('selected');
};

/**
 * 重置表单条件 隐藏域不清空
 * @param formId 表单Id
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.formClean = function(formId) {
    $(':input','#'+formId).not(':button, :submit, :reset,:hidden').val("").removeAttr('checked').removeAttr('selected');
};

/**
 * 设置表单值
 * @param divId 表单所属的divId
 * @param data 要为表单设置的json对象
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.setData = function(divId, data) {
    var inputs = $("#" + divId).find("form [name]");
    $.each(inputs,function(i, n) {
        var localName = n.localName;
        var paramName = $(n).attr("paramName");
        if (paramName) {
            for (var paramName in data) {
                $("#" + divId).find("[paramName=" + paramName + "]").val(data[paramName]);
                if (localName == "select" && n.onchange) {
                    n.change();
                }
            }
        } else {
            for (var name in data) {
                $("#" + divId).find("[name=" + name + "]").val(data[name]);
                var _change = n.onchange;
                if (localName == "select" && n.onchange && $.isFunction(n.onchange)) {
                    _change();
                }
            }
        }
    });
};

/**
 * 复选框事件  
 * 全选、取消全选的事件  
 * @param obj 全选/反选操作的Chekbox
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
var selectAll = function(obj) {
    var isChecked = $(obj).get(0).checked;
    if (isChecked) {
        $(obj).parents("table").children("tbody").children().find(":checkbox").each(function(){$(this).get(0).checked=true});
    } else {
        $(obj).parents("table").children("tbody").children().find(":checkbox").each(function(){$(this).get(0).checked=false});
    }
};

/**
 * 子复选框的事件
 * @param obj 触发事件的Chekbox
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
var setSelectAll = function(obj) {
    var isChecked = $(obj).get(0).checked;
    if (!isChecked) {
        $(obj).parents("table").children("thead").children().find(":checkbox:first").attr("checked", false);
    } else {
        var checkBoxes = $(obj).parents("table").children("tbody").children();
        var length = checkBoxes.find(":checkbox").length;
        var length2 = checkBoxes.find(":checkbox:checked").length;
        if (length == length2) {
            $(obj).parents("table").children("thead").children().find(":checkbox:first").get(0).checked=true;//.attr("checked", true);
        } else {
            $(obj).parents("table").children("thead").children().find(":checkbox:first").get(0).checked=false;//.attr("checked", false);
        }
    }
};

/**
 * 时间控件样式控制 年月日时分秒
 * @author yanqing.luo
 * @date 2014-07-04 14:31:56
 * @version v2.0
 */
common.showDateTimePicker = function(d) {
    $(d).datetimepicker({
        showSecond: true,
        changeMonth: true,
        changeYear: true,
        yearRange: 'c-30:c+10',
        //前30年和后0年
        dateFormat: 'yy-mm-dd',
        timeFormat: 'HH:mm:ss',
        stepHour: 1,
        stepMinute: 1,
        stepSecond: 1,
        showTimezone: false,
        showAnim: 'slide',
        duration: 'fast',
        showOtherMonths: true,
        selectOtherMonths: true,
        changeMonthUseLongNames: true,
        monthNamesShort: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        dayNamesShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
        controlType: 'select',
        timeText: '时间',
        hourText: '时',
        minuteText: '分',
        secondText: '秒',
        currentText: '现在',
        closeText: '关闭'
    });
};
/**
 * 时间控件样式控制 年月日
 * @author yanqing.luo
 * @date 2014-07-04 14:31:56
 * @version v2.0
 */
common.showDatePicker = function(d) {
    $(d).datepicker({
        duration: 'fast',
        dateFormat: 'yy-mm-dd',
        showAnim: 'slide',
        showOtherMonths: true,
        selectOtherMonths: true,
        changeMonth: true,
        changeMonthUseLongNames: true,
        monthNamesShort: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        dayNamesShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
        changeYear: true,
        yearRange: 'c-30:c' //前30年和后0年
    });
};
/**
 * 序列化表单数据成对象
 * @param form 要序列化的表单对象
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.serializeObject=function(form){
	var o={};
	$.each(form.serializeArray(),function(index){
		if (o[this['name']]) {
			o[this['name']]=o[this['name']]+","+this['value'];
		} else {
			o[this['name']]=this['value'];
		}
	});
	return o;
};

/**
 * 设置cookies
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.setCookie=function(name, value){
   var argv = common.setCookie.arguments;
   var argc = common.setCookie.arguments.length;   
   var expires = (argc > 2) ? argv[2] : null;
   var LargeExpDate = new Date ();
   if(expires!=null){
       LargeExpDate.setTime(LargeExpDate.getTime() + (expires*1000*3600*24));           
   }
   document.cookie = name + "=" + escape (value)+((expires == null) ? "" : ("; expires=" +LargeExpDate.toGMTString()))+";path=/";
};

/**
 * 获得cookies
 * @param Name
 * @returns 
 * @author weiyi.wang
 * @date 2014年12月18日 15:40:18
 */
common.getCookie=function(Name){   
   var search = Name + "=";
   if(document.cookie.length > 0){
       offset = document.cookie.indexOf(search);
       if(offset != -1){
           offset += search.length;
           end = document.cookie.indexOf(";", offset);
           if(end == -1) end = document.cookie.length;
           return unescape(document.cookie.substring(offset, end));
       }
       else return null;
   }
};

common.deleteCookie=function(name){
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval=common.getCookie(name);
	if(cval){document.cookie= name + "="+cval+";expires="+exp.toGMTString()+";path=/";}
};

common.srollBack=function(){
	if(common.getCookie("scroll")){
		document.documentElement.scrollTop=common.getCookie("scroll");
	}
};

/**
 * 随机产生数值
 * @param length 随机数长度
 * @returns {String}
 */
common.mathRand=function(length){ 
	var Num=""; 
	for(var i=0;i<length;i++){ 
		Num+=Math.floor(Math.random()*10); 
	}
	return Num;
}

common.alert=function(title,content,callback){
    layer.open({
        closeBtn:false,
        title:title,
        content:content,
        icon:1,
        tipsMore:true,
        yes : function(index){
            if (callback instanceof Function) {
                try {
                    callback();
                    layer.close(index);
                } catch (e) {
                    throw new Error(e);
                }
            }else if(callback==null){
                layer.close(index);
            }else{
                throw new Error("不是正确的回调函数!");
            }
        }
    })
};

common.isDateTime = function(str, e) {
    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
    var r = str.match(reg);
    if(r==null){
        var reg2 = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
        var r2 = str.match(reg2);
        if(r2==null){
            alert("请输入准确的时间格式");    
            if (e && e.preventDefault) {
                e.preventDefault();
            } else {
                window.event.returnValue = false;
            }
            return false;
        }
    }
    return true;
}

common.setDateTime=function(id,str){
    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
    var r = str.match(reg);
    if(r!=null){
        $("#"+id).val(str+" 00:00:00");
    }
}

/**
 * 格式化金额
 */
common.formatMoney=function(money, precision){
   precision = precision > 0 && precision <= 20 ? precision : 0;
   var temp=parseFloat((money + "").replace(/[^\d\.-]/g, "")).toFixed(precision);
   money = parseFloat((money + "").replace(/[^\d\.-]/g, "").replace("-","")).toFixed(precision) + "";
   var l = money.split(".")[0].split("").reverse(),
   r = money.split(".")[1];
   t = "";
   for(i = 0; i < l.length; i ++ ){
       t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
   }
   if(temp>0){
       if(r){
           return t.split("").reverse().join("") + "." + r;
       }else{
           return t.split("").reverse().join("");
       }
   }else if(temp==0){
       return 0;
   }else{
       if(r){
            return "-"+t.split("").reverse().join("") + "." + r;
       }else{
           return "-"+t.split("").reverse().join("");
       }
   }
}
