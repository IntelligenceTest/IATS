<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<style>
.price-input-text {
	width:90px;
}
input, select {
	margin-right:.3em;
}
.star {
 color: #f00 !important;
}
.button_lv4_1{
	float:none!important;
}
select{
	float:none;
}
#stockRemoval li label {
    float: left;
}
#stockRemoval li{
	width:100%;
}
</style>
<div id="stockRemoval" class="UED_hide">       
    <div class="pop_box">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">车辆出库<span id="_titleSpan"></span></h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box" style="height: 500">
	        <form id="stockRemovalForm" data-validate="true" method="post" >
                <input type="hidden" id="flag" name="flag">
                <input type="hidden" id="orderId" name="orderId">
                <ul class="s_form">
                    <li>
                        <label style="padding-left: 20px;">vin码：</label>
                        <input type="text" name="vinCode" id="vinCode"  readonly="true">
                    </li>
                    <li>
                        <label>车辆描述：</label>
                        <input type="text" name="selledName" id="selledName"  readonly="true">
                    </li>
                    <li>
                        <label>入库时间：</label>
                        <input type="text" name="inGarageTimestamp" id="inGarageTimestamp"  readonly="true">
                    </li>
                    <li>
                        <label>车辆状态：</label>
                        <select id="avStatus" name="avStatus" style="width: 173px;" readonly="true"  disabled="disabled">
                            <option value="9">待售</option>
                            <option value="0">待拍卖</option>
                            <option value="1">已上架</option>
                            <option value="2">拍卖成功</option>
                            <option value="3">成交确认</option>
                            <option value="4">流拍</option>
                            <option value="5">正在拍</option>
                            <option value="7">取消订单</option>
                        </select>
                    </li>
                    <li>
                        <label>车辆分类：</label>
                        <input type="text" name="vehicleType" id="vehicleType" maxlength="20"  readonly="true">
                    </li>
                    <li>
                        <label style="padding-left: 24px;">颜色：</label>
                        <input type="text" name="bodyColor" id="bodyColor"  readonly="true" >
                    </li>
                  </ul>
                  <ul class="s_form"> 
                    <li>
                        <label>付款方式：</label>
                       	<input type="text" name="deposit" id="deposit"  class="required" readonly="true">
                    </li>
                    <li>
                        <label>出库类型：</label>
                        <select id="stockRemovalType" style="width: 173px;" name="stockRemovalType" class="required">
							<option value='' selected>请选择</option>
                               <spring:eval expression="@autoDictionaryService.selectResource('stock_removal_type')" var="stockRemovalTypes"/>
							<c:forEach items="${stockRemovalTypes}" var="stockRemovalType">
								<option value="${stockRemovalType.value}" >${stockRemovalType.name}</option>
							</c:forEach>
						</select>
                    </li>
                    <li>
                        <label>提车方式：</label>
                        <select id="takeCarWay" style="width: 173px;" name="takeCarWay" class="required">
							<option value='' selected>请选择</option>
                               <spring:eval expression="@autoDictionaryService.selectResource('take_car_way')" var="takeCarWays"/>
							<c:forEach items="${takeCarWays}" var="takeCarWay">
								<option value="${takeCarWay.name}" >${takeCarWay.name}</option>
							</c:forEach>
						</select>                    
					</li>
                  </ul>
				<p align="center" class="controlbox">
	                <input type="button" class="button_lv4_1" value="出库" id="onSellSubmit"/>
	                <input type="button" class="button_lv4_1" value="取消" onclick="$.LAYER.close();" />
	            </p>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	$("#onSellSubmit").click(function(){
		if($("#stockRemovalType").val()==""||null==$("#stockRemovalType").val()){
			alert("请选择出库类型");
			return;
		}
		if($("#takeCarWay").val()==""||null==$("#stockRemovalType").val()){
			alert("请选择提车方式");
			return;
		}
        var url = "${ctx}/order/stockRemoval";
        $("#avStatus").removeAttr("disabled"); 
        $.ajax({
            cache: true,
            type: "POST",
            url:url,
            data:$('#stockRemovalForm').serialize(),
            async: false,
            error: function(request) {
                window.alert("系统异常，请联系管理员！");
            },
            success: function(data) {
                if(data.success){
                    $.LAYER.close();
                    window.alert("出库成功");
                    location.reload();
               }else{
                   window.alert("出库失败");
                   location.reload();
               }
            }
        });
        return false;
    });
});

</script>