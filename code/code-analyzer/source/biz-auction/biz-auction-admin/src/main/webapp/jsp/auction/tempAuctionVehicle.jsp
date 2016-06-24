<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<style>
.s_form .required{color:#f00;}
</style>
<div id="addTempAuctionVehicle" class="UED_hide" >       
    <div class="pop_box" style="width:500px;" >
        <div class="pop_tittle">
          <h3 id="addTempAuctionVehicle_title">新建临时拍品</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box newpp">
             <form:form action="${ctx}/auctionvehicle/index" method="post" commandName="vehicleInfo" id="vehicleInfoForm">
                <input type="hidden" name="saleStatus" value="0" />
				<input type="hidden" name="clearDisplayMileage" value="1" />
				<input type="hidden" name="auditedStatus" value="1" />
				<input type="hidden" name="requirementType" value="车道拍卖" />
				<input type="hidden" name="stockStatus" value="0" />
				<input type="hidden" name="vehicleSrcType" value="3" />
				<input type="hidden" name="code" id="tempCode"/>
				<input type="hidden" name="operation" id="operation"/>
				<input type="hidden" name="tempVehicleId" id="tempVehicleId"/>
                 <ul class="s_form">
                     <li>
					    	<label class="required">*品牌：</label>
						    <select name="brand" id="tempBrand" style="width:250px;float:none" onchange="changeBrand();">
	                           <option value="">请选择</option>
	                           	<c:forEach items="${brands}" var="brand">
	                           		 <option value="${brand.name}">${fn:substring(brand.pinyinAbbreviations, 0, 1)}-${brand.name} </option>
	                           	</c:forEach>
                            <select> 
						</li>
						
                 </ul> 
                  <ul class="s_form">
                     <li>
					    	<label class="required">*车系：</label>
						    <select name="brandSeries" id="tempBrandSeries" style="width:250px;float:none">
	                           <option value="">请选择</option>
                            <select> 
					    </li>
                 </ul> 
                 <ul class="s_form">
                      <li>
					    	<label>车型：</label>
						    <input name="vehicleModel" id="tempVehicleModel" style="width:250px" maxlength="50"/>   
						</li>
                 </ul> 
                 <ul class="s_form">
                      <li>
					   	  <label>车牌号：</label>
						  <input name="licenseCode" id="tempLicenseCodeId" style="width:230px"/>   
					  </li>
                 </ul> 
                  <ul class="s_form">
                      <li>
					   	  <label>上牌年月：</label>
						  <select name="registerYear" id="tempRegisterYear" style="width:100px;float:none">
	                          <option value="">选择上牌年</option>
	                          <c:forEach items="${yearList}" var="year">
	                           		 <option value="${year}">${year}</option>
	                          </c:forEach>
                          <select> 
						  <select name="registerMonth" id="tempRegisterMonth" style="width:100px;float:none">
	                      	  <option value="">选择上牌月</option>
	                          <c:forEach items="${monthsList}" var="month">
	                             <option value="${month}">${month}</option>
	                          </c:forEach>
                          <select> 
					  </li>
                 </ul>
                  <ul class="s_form">
                      <li>
					   	  <label>表显里程：</label>
						  <input name="displayMileage" id="tempDisplayMileage" style="width:140px;text-align: right"/>公里
					  </li>
                 </ul> 
                 <ul class="s_form">
                      <li>
					   	  <label>起拍价：</label>
						  <input name="startBidPrice" id="tempStartBidPrice" style="width:150px;text-align: right"/>元
					  </li>
                 </ul> 
                 <ul class="s_form">
                      <li>
					   	  <label class="required">*保留价：</label>
						  <input name="reservePrice"  id="tempReservePrice" style="width:150px; text-align: right"/>元
					  </li>
                 </ul>
             </form:form>
             <p align="center" class="controlbox">
             	<input type="button" class="button_lv4_1" value="保存" id="saveTempVehcile"/>
                <input type="button" class="button_lv4_1" value="取消"  onclick="$.LAYER.close();" />
             </p>
        </div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	$("#saveTempVehcile").click(function(){
		var licenseCode = $("#tempLicenseCodeId").val();
		if (licenseCode.length < 5 && licenseCode != "") {
			alert("车牌号不能低于5位");
			return false;
		};
		
		var brand = jQuery("#tempBrand option:selected").val();
		if (brand == "") {
			alert("品牌不能为空！");
			return false;
		};
		
		var BrandSeries = jQuery("#tempBrandSeries option:selected").val();
		if (BrandSeries == "") {
			alert("车系不能为空！");
			return false;
		};
		var partten = /^\d*([\.]\d+){0,1}$/;
		 if(!partten.exec($("#tempDisplayMileage").val())){
			alert("表显里程只能输入数字！");
			return false;
		} 
		
		if(!partten.exec($("#tempStartBidPrice").val())){
			alert("起拍价只能输入数字！");
			return false;
		}
		
		if ($("#tempReservePrice").val() == ""||!partten.exec($("#tempReservePrice").val())) {
			alert("保留价不能为空且只能输入数字！");
			return false;
		};
		
		if ($("#operation").val() == "edit") {
			var isExistAv = false; 
		   var temp = $("#tempVehicleId").val();
			$.ajax({
				url : "${ctx}/auctionvehicle/isTempAuctionVehicle",
				type: "get",
				async: false,
				dataType : "json",
				data : {tempVehicleId :$("#tempVehicleId").val() },
				success : function(data) {
					isExistAv = data.data;
				} 
			});
			
			if (!isExistAv) {
				alert("该临时拍品已经加入拍卖会!");
				return false;
			}
		}
		
		$.ajax({
			url : "${ctx}/auctionvehicle/saveTempVehicle",
			type: "get",
			async: false,
			dataType : "json",
			data : $('#vehicleInfoForm').serialize(),
			success : function(data) {
				if(data.msg==("保存成功!")){
					var result = "临时拍品增加成功！\n临时拍品车辆编号" + data.data + "正式车辆上传后，请及时替换临时拍品";
				}else{
					var result = "临时拍品修改成功！\n临时拍品车辆编号" + data.data + "正式车辆上传后，请及时替换临时拍品";
				}
			    confirm(result); 
				$.LAYER.close();
				$("#auctionVehicleForm").submit();
			} 
		});
	});
});

var changeBrand = function(){
	var brand = jQuery("#tempBrand option:selected").val();
	
	if (brand != "" && brand != null) {
		$.ajax({
			url : "${ctx}/auctionvehicle/selectSeries",
			type: "get",
			async: false,
			dataType : "json",
			data : "brand=" +brand,
			success : function(data) {
				jQuery("#tempBrandSeries").empty();
				jQuery("#tempBrandSeries").append("<option value ='' selected='selected'>请选择</option>");
				$.each(data, function(index, item){
					jQuery("#tempBrandSeries").append("<option value ='"+ item.name +"'>" +item.name + "</option>");
						
				});
			
			} 
		});
	} else {
		jQuery("#tempBrandSeries").empty();
		jQuery("#tempBrandSeries").append("<option value ='' selected='selected'>请选择</option>");
	}
	   
};
</script>
