<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="auctionCashDiv" class="UED_hide">       
    <div class="pop_box">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">费用批量设置</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box ppgl">
	        <form:form id="auctionVehicleCashForm" action="${ctx}/auctionvehicle/allUpdate" method="post" commandName="auctionVehicle" modelAttribute="auctionVehicle">
	            <form:hidden path="cashAllSids"/>
				<form:hidden path="createdBy" value="${currentUser }" />
                <ul class="s_form">
                    <li>
                        <label><b>委托方</b></label>
                    </li>
                 </ul>
                 <hr>
                 <ul class="s_form ">
                    <li>
                        <label>佣金：</label>
                           <input type="radio" name="clientRadio" id="clientRate" />按比例&nbsp;
                              <span id="_clientCommissionRate">
                                <form:input path="clientCommissionRate" cssClass="from-input-1" style="width:80px;"/>%&nbsp;&nbsp;&nbsp;
                              </span>
                           <input type="radio" name="clientRadio" id="clientFixed" />固定佣金&nbsp;
                            <span id="_clientFixedCommission">
                                <form:input path="clientFixedCommission" cssClass="from-input-1" style="width:80px;"/>元
                            </span>
                    </li>
                  </ul>
                  <ul class="s_form">
                    <li>
                        <label><b>买家</b></label>
                    </li>
                  </ul>
                  <hr>
                  <ul class="s_form">
                    <li>
                        <label>佣金：</label>
                            <input type="radio" name="buyerRadio" id="buyerRate" />按比例&nbsp;
                            <span id="_buyerCommissionRate">
                                <form:input path="buyerCommissionRate" cssClass="from-input-1" style="width:80px;"/>%&nbsp;&nbsp;&nbsp;
                            </span>
	                        <input type="radio" name="buyerRadio" id="buyerFixed" />固定佣金&nbsp;
	                        <span id="_buyerFixedCommission">
	                           <form:input path="buyerFixedCommission" cssClass="from-input-1" style="width:80px;"/>元
	                        </span>
                    </li>
                  </ul>
                  <ul class="s_form">
                    <li>
                        <label>办证费：</label>
                            <form:input path="licenseFee" cssClass="from-input-1" style="width:80px;"/>元
                    </li>
                    <li>
                        <label>出库费：</label>
                            <form:input path="exWarehouseFee" cssClass="from-input-1" style="width:80px;"/>元
                    </li>
                    <li>
                        <label>停车费：</label>
                            <form:input path="parkingFee" cssClass="from-input-1" style="width:80px;"/>元
                    </li>
                    <li>
                        <label>运输费：</label>
                            <form:input path="trafficFee" cssClass="from-input-1" style="width:80px;"/>元
                    </li>
                    <li>
                        <label>违章费用：</label>
                            <form:input path="trafficViolationFee" cssClass="from-input-1" style="width:80px;"/>元
                    </li>
                </ul>
            </form:form>
            <p align="center" class="controlbox">
                <input type="button" class="button_lv4_1" value="确定" id="cashSubmit"/>
                <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
            </p>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function(){
	 checkClientRadio();
     $("input[name=clientRadio]").click(function (){
         checkClientRadio();
     });
     
     checkBuyerRadio();
     $("input[name=buyerRadio]").click(function (){
         checkBuyerRadio();
     });
	 
	//表单提交检查
     $("#cashSubmit").click(function(check){  
         var licenseFee = $("#licenseFee").val();
         var exWarehouseFee = $("#exWarehouseFee").val();
         if(licenseFee==""){ 
             alert("请填写办证费~");  
             $("#licenseFee").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         if(exWarehouseFee==""){ 
             alert("请填写出库费~");
             $("#exWarehouseFee").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         $("#auctionVehicleCashForm").submit();
     });  
}); 

var checkClientRadio = function(){
 switch($("input[name=clientRadio]:checked").attr("id")){
  case "clientRate":
        $("#clientCommissionRate").removeAttr("disabled");
        $("#_clientCommissionRate").show();
        $("#clientFixedCommission").attr("disabled","disabled");
        $("#_clientFixedCommission").hide();
        break;
  case "clientFixed":
      $("#clientFixedCommission").removeAttr("disabled");
      $("#_clientFixedCommission").show();
      $("#clientCommissionRate").attr("disabled","disabled");
      $("#_clientCommissionRate").hide();
      break;
  default:
   break;
 }
};

var checkBuyerRadio = function(){
 switch($("input[name=buyerRadio]:checked").attr("id")){
  case "buyerRate":
        $("#buyerCommissionRate").removeAttr("disabled");
        $("#_buyerCommissionRate").show();
        $("#buyerFixedCommission").attr("disabled","disabled");
        $("#_buyerFixedCommission").hide();
        break;
  case "buyerFixed":
      $("#buyerFixedCommission").removeAttr("disabled");
      $("#_buyerFixedCommission").show();
      $("#buyerCommissionRate").attr("disabled","disabled");
      $("#_buyerCommissionRate").hide();
      break;
  default:
   break;
 }
};
</script>