<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<style>
</style>
<div id="substituteAuctionVehicle" class="UED_hide" >       
    <div class="pop_box" style="width:500px;" >
        <div class="pop_tittle">
          <h3>替换临时拍品</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
            <input type="hidden" id="tempVehicleSid">
             <input type="hidden" id="tauctionVehiceleSid">
        	<ul class="s_form">
            	<li>
			    	<label>请输入正式车辆的编号:</label>
			    	<input name="code" id="subVehicleCode" style="width:150px" maxlength="50"/>   
				</li>
				<li>
			    	<input type="button" class="button_lv4_1" value="查询" id="searchAuctionVehicle"/> 
				</li>
            </ul> 
            <ul class="s_form" id="vehicle_info">
            	
            </ul> 
            <p align="center" class="controlbox">
                <input type="button" class="button_lv4_1" value="确认" id="saveSubAuctionVehicle"/>
                <input type="button" class="button_lv4_1" value="取消" id="closeSubAuctionVehicle" onclick="$.LAYER.close();" />
            </p>

        </div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	$("#saveSubAuctionVehicle").hide();
	$("#closeSubAuctionVehicle").hide();
	
	$("#searchAuctionVehicle").click(function(){
		if ($("#subVehicleCode").val() == "") {
			alert("正式车辆的编号不能为空");
			return false;
		}
		var msg = "";
		$.ajax({
			url : "${ctx}/auctionvehicle/subtitVehicleInfo",
			type: "get",
			async: false,
			dataType : "json",
			data : {
				vehicleCode : $("#subVehicleCode").val()
			},
			success : function(data) {
				if(data.success){
					//var result = "临时拍品增加成功！  临时拍品车辆编号" + data.data + "正式车辆上传后，请及时替换临时拍品";
				    $(data.data).each(function(index, item){
				    	var vehilceInfo = item;
				    	var registerLicenseDate = vehilceInfo.registerLicenseYears;
				    	registerLicenseYear = registerLicenseDate.substr(0, 4);
				    	registerLicenseMonth = registerLicenseDate.substr(5, 2);
				    	
				    	msg = "请确认正式车辆的信息：<br><br>车辆编号：" + vehilceInfo.code + 
				    	          "<br>品牌型号：" + vehilceInfo.brand + vehilceInfo.vehicleModel
				    	          +"<br>车牌号：" + vehilceInfo.licenseCode
				    	          +"<br>VIN码：" + vehilceInfo.vinCode
				    	          +"<br>排量：" + vehilceInfo.sweptVolume + vehilceInfo.sweptVolumeType
				    	          +"<br>车身颜色：" + vehilceInfo.bodyColor
				    	          +"<br>首次上牌时间：" + registerLicenseYear +"年" + registerLicenseMonth + "月<br><br>";
				       $("#vehicle_info").html(msg);
				    });
				}else{
					alert(data.msg);
				}
			} 
		});
		
		$("#saveSubAuctionVehicle").show();
		$("#closeSubAuctionVehicle").show();
	});
	
	$("#saveSubAuctionVehicle").click(function(){
		if ($("#subVehicleCode").val() == "") {
			alert("正式车辆的编号不能为空");
			return false;
		}
		
		$.ajax({
			url : "${ctx}/auctionvehicle/substituteTempVehicle",
			type: "get",
			async: false,
			dataType : "json",
			data : {
				auctionVehicleId : $("#tauctionVehiceleSid").val(),
				tempVehicleId : $("#tempVehicleSid").val(),
				vehicleCode    : $("#subVehicleCode").val()
			},
			success : function(data) {
			    if(data.data) {
			    	alert("替换成功！");
			    } else {
			    	alert("替换失败！,该拍品还没加入任何拍卖会或者已经被替换！");
			    }; 
				$.LAYER.close();
				$("#auctionVehicleForm").submit();
			} 
		});
	});
});
</script>
