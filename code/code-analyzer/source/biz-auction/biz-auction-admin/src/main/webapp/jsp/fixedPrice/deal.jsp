<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<style>
	/*zjz fixed*/
	.controlbox .button_lv4_1{
		float:none!important;
		padding: 0 8px!important;
		width:auto!important;
		min-width:70px!important;
	}
</style>
<div id="dealDiv" class="UED_hide">       
    <div class="pop_box" id="dealPanl" style="width: 320px;">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">展品成交</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	        <form:form id="dealForm" action="${ctx}/fixedPrice/deal "
	           method="post" commandName="fixedPrice">
	            <form:hidden path="vehicleId" id="vehicleId"/>
	            <form:hidden path="id" id="id1"/>
                <ul class="s_form">
                    <li>
                        <label>车辆编号：</label>
                        <span id="dealCode"></span>
                    </li>
                    <li id="brandLI">
                        <label>品牌型号：</label>
                        <span id="dealBrand"></span>
                    </li>
                    <li>
                        <label>　车牌号：</label>
                        <span id="dealLicence"></span>
                    </li>
                 </ul>
                  <div class="s_form" id="orderInfoDIV" style="display:none;">
	                  <table style="padding-left: 15px;">
	                    <tr>
	                        <td><font color="red" style="font-size:15px;font-family: 'Microsoft YaHei';">该车已被线上客户预订，<!-- 订单状态： --><b><span id="orderInfoDepositText"></span></b></font></td>
	                    </tr>
	                    <tr>
	                        <td>订单号：<span id="orderInfoOrderNOText"></span></td>
	                    </tr>
	                    <tr>
	                        <td>　姓名：<span id="orderInfoBuyyerText"></span></td>
	                    </tr>
	                    <tr>
	                        <td>　电话：<span id="orderInfoCellphoneText"></span></td>
	                    </tr>
	                  </table>
                  </div>
                 <hr>
                 <ul class="s_form">
                    <li>
                        <label ><font color="red" style="font-size:15px;">是否确认为线下客户成交该车？</font></label>
                        <!-- <label>录入线下客户信息和车辆成交总价</label> -->
                    </li>
                    <li class="lay-price-input">
                        <label>购买人：　　</label>
                            <form:input path="order.bidderName" id="name1" cssClass="from-input-1" cssStyle="width:80px;" />
                    </li>
	                <li class="lay-price-input">
	                    <label>购买人电话：</label>
	                        <form:input path="order.buyerCellphone" id="buyerCellphone" cssClass="from-input-1" />
	                </li>
                    <li class="lay-price-input">
                         <label>车辆总价：　</label>
                         <form:input path="orderItem.finalPrice" id="price1" cssClass="from-input-1" cssStyle="width:80px;" />万元
                    </li>
                </ul>
              
                <p align="center" class="controlbox">
                    <input type="button" class="button_lv4_1" value="确认线下成交" id="dealSubmit"/>
                    <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
                </p>
            </form:form>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function(){
	//表单提交检查
     $("#dealSubmit").click(function(check){  
         var sid = $("#id1").val();
         var vehicleSid = $("#vehicleId").val();
         
         if(sid==""||vehicleSid==""){
        	 window.alert("非法操作！");
        	 return;
         }
         
         var name1 = $("#name1").val();
         if(name1==""){
        	 window.alert("请填写成交人！");
        	 $("#name1").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         
         var price = $("#price1").val();
         if(price==""){
        	 window.alert("请填写成交价格！");
        	 $("#price1").focus();  
             check.preventDefault();//阻止表单提交
        	 return;
         }else if(price!=""){
        	  if(!checkCashResult(price)){return;};
         }
         
         var buyerCellphone = $("#buyerCellphone").val();
         if(buyerCellphone==""){ 
             alert("请填写购买人电话~");
             $("#buyerCellphone").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }else if(!checkCellPhone(buyerCellphone)&&!checkTelephone(buyerCellphone)){
             alert("请填写正确的电话号码~");
             $("#buyerCellphone").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         
         if(!confirm("是否确认该车成交？"))
            return;
         
         var url = "${ctx}/fixedPrice/deal";
         $.ajax({
             cache: true,
             type: "get",
             url:url,
             data:$('#dealForm').serialize(),
             async: false,
             error: function(request) {
                 window.alert("系统异常，请联系管理员！");
             },
             success: function(data) {
            	 if(data.success){
	                 $.LAYER.close();
	                 window.alert(data.msg);
	               /*   var city = $("#city").val();
	                 var startTimestamp = $("#startTimestamp").val();
	                 var endTimestamp = $("#endTimestamp").val();
	                 var orgSid = $("#orgSid").val();
	                 var customerName = $("#customerName").val();
	                 var cellPhone = $("#cellPhone").val();
	                 var param = "city="+city +"&startTimestamp="+startTimestamp+"&endTimestamp="+endTimestamp+"&orgSid="+orgSid+"&customerName="+customerName+"&cellPhone="+cellPhone;
	                 var menuParam = "&currentMenuSid=${currentMenuSid}&currentSubMenuSid=${currentSubMenuSid }";
	                 window.location.href="${ctx}/beauty/index?"+param+menuParam; */
	                 window.location.href="${ctx}/fixedPrice/index";
            	 }else{
            		 window.alert(data.msg);
            	 }
             }
         });
     });  
}); 
 //金额校验
var checkCash=function(cash){
    return (/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test(cash.toString());
};

var checkCashResult=function(a){
    if(!checkCash(a)){
        window.alert("价格无效~");
        return false;
    }else  {
        var cash = parseFloat(a);
        if(cash<(0.01)||cash>(9001.00)) {
             window.alert("价格只能大于0及小于9001.00万元");
             return false;
        }
        return true;
    }
};
</script>