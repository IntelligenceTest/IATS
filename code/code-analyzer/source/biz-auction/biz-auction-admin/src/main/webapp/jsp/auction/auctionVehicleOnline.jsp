<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="auctionOnlineDiv" class="UED_hide">       
    <div class="pop_box">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">在线拍</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	        <form:form id="auctionVehicleOnlineForm" action="${ctx}/auctionvehicle/online" method="post" commandName="auctionVehicle">
	            <form:hidden path="onlineSids"/>
	            <form:hidden path="auctionType" value="1"/>
				<form:hidden path="createdBy" value="${currentUser }" />
                <ul class="s_form">
                    <li class="lay-price-input">
                        <label>拍卖计划：</label>
                        <form:input path="planStartTime" cssClass="from-input-1" />
                        <label class="inp-label">至</label>
                        <form:input path="planEndTime" cssClass="from-input-1" />
                    </li>
                    <li class="lay-price-input">
                        <label>起拍价：</label>
                        <form:input path="startPrice" cssClass="from-input-1" />万元
                    </li>
                    <li class="lay-price-input">
                        <label>加价幅度：</label>
                        <form:input path="plusRange" cssClass="from-input-1"  value="500" />元
                    </li>
                    <li class="lay-price-input">
                        <label>保留价：</label>
                        <form:input path="reservePrice" cssClass="from-input-1" />万元
                    </li>
                    <li class="lay-price-input">
                        <label>拍卖方式：</label>
                        <form:select path="auctionModel" cssStyle="width:65px;float:none" >  
                            <spring:eval expression="@autoDictionaryService.selectAuctionModel()" var="models"/>
                            <form:options items="${models}" itemLabel="name"  itemValue="value"></form:options>
                        </form:select>
                    </li>
                    <li class="lay-price-input">
                        <label>代理价：</label>
                        <form:input path="agentPrice" cssClass="from-input-1" cssStyle="width:80px;" value="0"/>元
                    </li>
                     <li class="lay-price-input">
                        <label>拍品类型：
                           <form:select path="avType" cssClass="form-input-1" cssStyle="width:65px;float:none">
<%--                            		<form:options items="${avTypes}" itemLabel="name" itemValue="value"/> --%>
                           		<form:option value="0">有底价</form:option>
                           		<form:option value="1">无底价</form:option>
                           </form:select></label>
                    </li>
                    <!-- edit by zjz 添加热门推荐 -->
                    <li class="lay-price-input">
                        <label>热门推荐：<form:checkbox path="recommend"/></label>
                    </li>
                    <!-- edit end; -->
                    <li style="display:inline;">
                        <label>竞拍区域：</label>
                        <form:select path="province" cssStyle="width:150px;float:none"  onchange="getcitys();">  
                            <form:option value=""  label="请选择"  ></form:option>
                            <spring:eval expression="@autoDictionaryService.selectProvince()" var="provinces"/>
                            <form:options items="${provinces}" itemLabel="name" itemValue="name"/>
                        </form:select>
                        <form:select path="city" id="city" name="city" cssStyle="width:150px;float:none">
                            <form:option value="" selected="selected">请选择</form:option>
                            <c:if test="${null != auction.city}">
                                <spring:eval expression="@autoDictionaryService.selectCity(auction.province)" var="subSetCitys" />
                                <form:options items="${subSetCitys}" itemLabel="name"  itemValue="name" />
                            </c:if>
                        </form:select>
                    </li>
                    <li>
                        <label>活动车辆：<form:checkbox path="activity" id="activity"/></label>
                        <form:input path="activityTitle" cssClass="from-input-1" cssStyle="width:300px;float: right;" maxlength="30"/>                        
                    </li>                    
                </ul>
            </form:form>
            <p align="center" class="controlbox">
				<input type="button" class="button_lv4_1" value="保存" id="onlineSubmit" />
				<input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
            </p>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function(){
	 if(!$('#activity').attr('checked')){
		 $('#activityTitle').attr("disabled","disabled");
	 }
	 $("#activity").change(function(){
		 if($(this).is(':checked')){
			 $('#activityTitle').removeAttr("disabled");
		 }else{
			 $('#activityTitle').val("").attr("disabled","disabled");
		 }
	 });
	 showDateTimePicker("#planStartTime");
     showDateTimePicker("#planEndTime");
	//表单提交检查
     $("#onlineSubmit").click(function(check){  
         var val = $("#auctionSid").find("option:selected").val();
         var planStartTime = $("#planStartTime").val();
         var planEndTime = $("#planEndTime").val();
         var startPrice = $("#startPrice").val();
         var plusRange = $("#plusRange").val();
         var reservePrice = $("#reservePrice").val();
        
         if(planStartTime != "" && planEndTime != ""){
        	 if(!checkDateTime(planStartTime,planEndTime)){
                 alert("拍卖起始时间必须超过当前时间，且结束时间必须超过开始时间！");
                 return;
             }
         }
         
         if(planStartTime!=""){
     	    var is1=common.isDateTime(planStartTime,check);
     	    if(!is1){return;}
    	    common.setDateTime("planStartTime",planStartTime);
     	}
     	if(planEndTime!=""){
     	    var is2=common.isDateTime(planEndTime,check);
     	    if(!is2){return;}	
    	    common.setDateTime("planEndTime",planEndTime);
     	}
     	
         if(planStartTime!=""){
     	    var is1=common.isDateTime(planStartTime,check);
     	    if(!is1){return;}
    	    common.setDateTime("planStartTime",planStartTime);
     	}else{
     	    alert("请填写计划开始时间");
     	    return;
     	}
     	if(planEndTime!=""){
     	    var is2=common.isDateTime(planEndTime,check);
     	    if(!is2){return;}	
    	    common.setDateTime("planEndTime",planEndTime);
     	}else{
     	   alert("请填写计划结束时间");
    	    return;
     	}
     	
         if(startPrice!=""){
        	    if(!checkCashResult(startPrice)){return;};
         }
         if(plusRange!=""){
        	   if(!checkCashResult1(plusRange)){return;};
         }
         if(reservePrice!=""){
        	    if(!checkCashResult(reservePrice)){return;}; 
         }
         
         //if(!checkCashResult(agentPrice)){return;};
         
         var url = "${ctx}/auctionvehicle/online";
         $.ajax({
             cache: true,
             type: "POST",
             url:url,
             data:$('#auctionVehicleOnlineForm').serialize(),
             async: false,
             error: function(request) {
                 window.alert("系统异常，请联系管理员！");
             },
             success: function(data) {
                 $.LAYER.close();
                 window.alert(data.msg);
                 window.location.href="${ctx}/auctionvehicle/index";
             }
         });
     });  
	
    
}); 

var getcitys=function(){
	var proId=$('#province').children("option:selected").val();
	if(proId!=""){
		$.get("${ctx}/auctionvehicle/getCitys",{proId:proId},function(data){
			$('#city').empty().append("<option value=''>---请选择---</option>");
			$.each(data,function(items,e){
				var options="<option value="+e.city+">&nbsp;&nbsp;&nbsp;"+e.city+"</option>";
				$('#city').append(options);
			});
		});
	}
}
</script>