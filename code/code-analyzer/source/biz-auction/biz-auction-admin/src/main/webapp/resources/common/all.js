/**
 * 时间控件样式控制
 * @author yanqing.luo
 * @date 2014-07-04 14:31:56
 * @version v2.0
 */
var showDateTimePicker=function(d){
	$(d).datetimepicker({
		showSecond: true,
		changeMonth: true,
	    changeYear: true,
	    yearRange:'c-30:c+10',//前30年和后0年
		dateFormat:'yy-mm-dd',
		timeFormat: 'HH:mm:ss',
		stepHour: 1,
		stepMinute: 1,
		stepSecond: 1,
		showTimezone: false,
		showAnim:'slide',
		duration: 'fast',
		showOtherMonths: true,
	    selectOtherMonths: true,
	    changeMonthUseLongNames:true,
	    monthNamesShort: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],
	    dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
		controlType: 'select',
		timeText:'时间',
		hourText:'时',
		minuteText:'分',
		secondText:'秒',
		currentText:'现在',
        closeText:'关闭'
		});    
};

var showDatePicker=function(d){
	$(d).datepicker({
		duration: 'fast',
		dateFormat:'yy-mm-dd',
		showAnim:'slide',
		showOtherMonths: true,
	    selectOtherMonths: true,
		changeMonth: true,
		changeMonthUseLongNames:true,
		monthNamesShort: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],
		dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
	    changeYear: true,
	    yearRange:'c-30:c'//前30年和后0年
	});    
};

var nullOptionHtml = "<option value ='' selected='selected'>请选择</option>";

/**
 * <pre>
 * 通用级联下拉列表加载
 * 必须设置下层级联下拉列表属性：
 * callbackVal-查询条件的值，对应下层级联属性
 * url-服务器请求路径，用于读取下层级联下拉列表数据；
 * textKey-下层级联下拉列表数据读取的key，用于生成下拉列表的展示值
 * valueKey-下层级联下拉列表数据读取的value，用于生成下拉列表的value属性
 * showNull-设置此属性表示如果下拉列表只有一条数据则去除“请选择”选项，否则默认都会生成“请选择”
 * @date 2015年3月10日 14:10:45
 * @author yanqing.luo
 * @version V1.0.0
 * </pre>
 */
var loadCascadeSelectOptions=function() {
	var arguCount = arguments.length;
	if (arguCount < 1)
		return ;
	
	var currObj = (arguCount > 0) ? arguments[0]:"undefined";
	var nextInputId = (arguCount > 1) ? arguments[1] : "cityId";
	var param = (arguCount > 2) ? arguments[2] : "";
	
	var nextObj = $("#" + nextInputId);
    if (!currObj || typeof currObj !="object" || !nextObj || typeof nextObj != "object") {
    	window.alert("系统异常！");
        throw Error("parameter error!");
    }
    
	var url = $(nextObj).attr("url");
	if (!url) {
		window.alert("系统异常！");
	    throw Error("the parameter of the url attribute is missing!");
	 }
	
	var textKey = $(nextObj).attr("textKey");
	var valueKey = $(nextObj).attr("valueKey");
	
    if (!textKey) {
    	textKey = "item.id";
    }
    
    if (!valueKey) {
    	valueKey = "item.name";
    }
    
	var currVal = $(currObj).find("option:selected").val();
	if (currVal && currVal !="" && currVal != null) {
		$.ajax({
			url :url,
			type: "get",
			dataType : "json",
			async: true,
		    cache: false,
		    ifModified: true,
		//	contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data : param,
			success : function(data) {
				$(nextObj).empty();
				var showNull = $(nextObj).attr("showNull");
				
				if(!showNull){
					$(nextObj).append(nullOptionHtml);
				}else{
					if(data.length>1){
						$(nextObj).append(nullOptionHtml);
					}
				}
				
				$.each(data, function(index, item){
					$(nextObj).append("<option value ='"+ eval(valueKey) +"'>" + eval(textKey) + "</option>");
				});
				
				var callbackVal = $(nextObj).attr("callbackVal");
				if(callbackVal && callbackVal != "" && callbackVal != "null"){
					$("#"+nextInputId+" option[value='"+callbackVal+"']").prop("selected", true);
				}
			},
			error: function(request){
				window.alert("系统服务异常！");
			}
		});
	} else {
		$(nextObj).empty();
		$(nextObj).append(nullOptionHtml);
	}
};


/**
 * 清除查询条件
 * @param divId 查询条件控件顶层DIV
 * @author yanqing.luo
 * @date 2014年6月30日 13:28:40
 */
var clearQueryObj=function(divId){
	var inputObjs=jQuery("#"+divId+" input[type='text']");
	  for(var i=0;i<inputObjs.length;i++){
	   var inputObj = inputObjs[i];
	   inputObj.value="";
	  }
	  var selectObjs = jQuery("#"+divId+" select");
	  for(var i=0;i<selectObjs.length;i++){
	   var selectObj = selectObjs[i];
	   selectObj.value="";
	  }
};

/**
 * 禁用id为fields之外的元素
 * @author yanqing.luo
 * @date 2014年6月30日 17:45:21
 */
var disabledNotThisInput = function(fields){  
    fields = ','+fields+','; 
    var inputTypes=new Array("input","select","checkbox","radio","textarea");  
    for(var k = 0 ; k < inputTypes.length ; k ++ ){  
      var inputArray=$(inputTypes[k]);//循环得到某种类型的所有元素  
      inputArray.each(  
        function (){  
          var input =$(this); 
          var tempId = input.attr("id");  
          if(fields.indexOf(tempId) < 0 ){  
              $('#'+tempId).attr("disabled", "disabled");  
          }  
        }  
      );
    }
};

var clearQueryConds=function(a,b,c){
	//清空所有查询条件
	$("#"+a).click(function (){
		   clearQueryObj(b);
		   window.location.href = c;
	   });	
};

var closeWindow=function(){
	if (confirm("您确定要关闭么？")){
		window.opener=null;
		window.open('','_self');
		window.close();
	}
};


$.fn.clearForm = function() {
	  return this.each(function() {
	    var type = this.type, tag = this.tagName.toLowerCase();
	    if (tag == 'form')
	      return $(':input',this).clearForm();
	    if (type == 'text' || type == 'password' || tag == 'textarea')
	      this.value = '';
	    else if (type == 'checkbox' || type == 'radio')
	      this.checked = false;
	    else if (tag == 'select')
	      this.selectedIndex = 0; //-1 为清空
	  });
	};

var  roceysTrim=function(str,is_global){
    var result;
    result = str.replace(/(^\s+)|(\s+$)/g,"");
    if(is_global){
        result = result.replace(/\s/g,"");
     }
    return result;
};

/**
 * 判断查询条件中两个时间的合法性
 */
var checkDateTime=function(startTime,endTime){
    var start=new Date(Date.parse(startTime.replace("-", "/").replace("-", "/")));
    var end=new Date(Date.parse(endTime.replace("-", "/").replace("-", "/")));
    var curDate=new Date();
    if(start < curDate){
    	return false;
    }
    if(end < curDate){
    	return false;
    }
    if(end < start){
        return false;
    }
    return true;
};

//金额校验
var checkCash=function(cash){
    return (/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test(cash.toString());
};

var checkCashResult=function(a){
    if(!checkCash(a)){
        window.alert("金额无效~");
        return false;
    }else  {
        var cash = parseFloat(a);
        if(cash<(0.00)||cash>(10000001.00)) {
             window.alert("金额只能大于0及小于10000001.00");
             return false;
        }
        return true;
    }
};

/**
 * 0和整数
 */
var checkCash1 = function(cash){
	return (/^(0|[1-9][0-9]*)$/).test(cash.toString());
};

var checkCashResult1=function(a){
    if(!checkCash1(a)){
        window.alert("金额无效~");
        return false;
    }else  {
        var cash = parseInt(a);
        if(cash<(0)||cash>(30000)) {
             window.alert("金额只能大于等于0小于3万~");
             return false;
        }
        return true;
    }
};

//add by zjz 日期格式化
Date.prototype.format = function(format){ 
var o = { 
"M+" : this.getMonth()+1, //month 
"d+" : this.getDate(), //day 
"h+" : this.getHours(), //hour 
"m+" : this.getMinutes(), //minute 
"s+" : this.getSeconds(), //second 
"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
"S" : this.getMilliseconds() //millisecond 
} 

if(/(y+)/.test(format)) { 
format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
} 

for(var k in o) { 
if(new RegExp("("+ k +")").test(format)) { 
format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
} 
} 
return format; 
} 
