<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="auctionOnceBidDiv" class="UED_hide">       
    <div class="pop_box">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">即时拍</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	        <form:form id="auctionVehicleOnceBidForm" action="" method="post" commandName="auctionVehicle">
	            <form:hidden path="onceBidSids"/>
	            <%-- 即时拍 --%>
	            <form:hidden path="auctionType" value="2"/>
				<form:hidden path="createdBy" value="${currentUser }" />
                <ul class="s_form">
                    <li class="lay-price-input">
                        <label>拍卖计划：</label>
                        <form:input path="planStartTime" id="onceBidPlanStartTime" cssClass="from-input-1"/>
						<label class="inp-label">至</label>
						<form:input path="planEndTime" id="onceBidPlanEndTime" cssClass="from-input-1"/>
                    </li>
                    <li style="display:inline;">
                        <label>竞拍区域：</label>
                        <form:select path="province" id="onceBidProvince" cssStyle="width:150px;float:none"  onchange="getCitys();">  
                            <form:option value=""  label="请选择"  ></form:option>
                            <spring:eval expression="@autoDictionaryService.selectProvince()" var="provinces"/>
                            <form:options items="${provinces}" itemLabel="name" itemValue="name"/>
                        </form:select>
                        <form:select path="city" id="onceBidCity" name="city"  cssStyle="width:150px;float:none">
                            <form:option value="" selected="selected">请选择</form:option>
                            <c:if test="${null != auction.city}">
                                 <spring:eval expression="@autoDictionaryService.selectCity(auction.province)" var="subSetCitys" />
                                 <form:options items="${subSetCitys}" itemLabel="name"  itemValue="name" />
                            </c:if>
                        </form:select>
                    </li>                    
                    <li>
                        <label>活动车辆：<form:checkbox path="activity" id="onceBidActivity"/></label>
                        <form:input path="activityTitle" id="onceBidActivityTitle" cssClass="from-input-1" cssStyle="width:300px;float:right;" maxlength="30"/>                        
                    </li>                    
                </ul>
                <p align="center" class="controlbox">
                    <input type="button" class="button_lv4_1" value="保存" id="onceBidSubmit"/>
                    <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
                </p>
            </form:form>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function(){
	 if(!$('#onceBidActivity').attr('checked')){
		 $('#onceBidActivityTitle').attr("disabled","disabled");
	 }
	 $("#onceBidActivity").change(function(){
		 if($(this).is(':checked')){
			 $('#onceBidActivityTitle').removeAttr("disabled");
		 }else{
			 $('#onceBidActivityTitle').val("").attr("disabled","disabled");
		 }
	 });
	 showDateTimePicker("#onceBidPlanStartTime");
     showDateTimePicker("#onceBidPlanEndTime");
	//表单提交检查
     $("#onceBidSubmit").click(function(check){  
         var val = $("#auctionSid").find("option:selected").val();
         var planStartTime = $("#onceBidPlanStartTime").val();
         var planEndTime = $("#onceBidPlanEndTime").val();
         /* var auctionModel = $("#auctionModel").val();
         var province = $("#province").val();
         var city = $("#city").val(); */
         if(planStartTime==""){  
             alert("请选择计划开始时间~");  
             $("#onceBidPlanStartTime").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         if(planEndTime==""){  
             alert("请选择计划结束时间~");  
             $("#onceBidPlanEndTime").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         if(planStartTime != "" && planEndTime != ""){
        	 if(!checkDateTime(planStartTime,planEndTime)){
                 alert("拍卖起始时间必须超过当前时间，且结束时间必须超过开始时间！");
                 check.preventDefault();//阻止表单提交
                 return;
             }
         }
         
         if(planStartTime!=""){
      	    var is1=common.isDateTime(planStartTime,check);
      	    if(!is1){return;}
    	    common.setDateTime("onceBidPlanStartTime",planStartTime);
	     }
         
      	 if(planEndTime!=""){
      	    var is2=common.isDateTime(planEndTime,check);
      	    if(!is2){return;}	
    	    common.setDateTime("onceBidPlanEndTime",planEndTime);
      	 }
         
         var url = "${ctx}/auctionvehicle/onceBid";
         $.ajax({
             cache: true,
             type: "POST",
             url:url,
             data:$('#auctionVehicleOnceBidForm').serialize(),
             async: false,
             error: function(request) {
                 window.alert("系统异常，请联系管理员！");
                 return;
             },
             success: function(data) {
                 $.LAYER.close();
                 window.alert(data.msg);
                 window.location.href="${ctx}/auctionvehicle/index";
             }
         });
     });  
}); 
var getCitys=function(){
		var proId=$('#onceBidProvince').val();
		if(proId!=""){
			$('#onceBidCity').empty().append("<option value=''>---请选择---</option>");
			$.get("${ctx}/auctionplace/getCitys",{proId:proId},function(data){
				$.each(data,function(items,e){
					var options="<option value="+e.city+">&nbsp;&nbsp;&nbsp;"+e.city+"</option>";
					$('#onceBidCity').append(options);
				});
			});
		}
	}
</script>