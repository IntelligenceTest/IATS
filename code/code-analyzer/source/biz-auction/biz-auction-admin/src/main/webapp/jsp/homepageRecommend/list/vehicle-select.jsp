<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<style>
.s_box input {
	width: 50px;
}

#vinCode {
	width: 100px;
}

#code {
	width: 100px;
}

#datatable td {
	border: 1px solid #ddd;
	padding-left: 10px;
}

#datatable .locklast {
	border: none;
}
</style>
<form:form commandName="fixedPrice" name="vehicleSelectForm"
	id="vehicleSelectForm">
	<%--隐藏文本域 --%>
	<input type="hidden" id="currentPage" name="current" value="1">
	<input type="hidden" id="isAdd" name="isAdd" />
	<input type="hidden" id="fpRecommendId" name="fpRecommendId" />
	<div class="s_box">
		<ul class="s_form">
			<li class="lay-price-input">
				<label>VIN码：</label>
				<form:input path="vehicle.vinCode" cssClass="input-10" cssStyle="width:135px;" />
			</li>
			<li class="lay-price-input">
				<label>车辆编号：</label>
				<form:input path="vehicle.code" cssClass="input-10" cssStyle="width:135px;" />
			</li>
			<li class="lay-price-input">
				<label>上架时间：</label>
				<form:input path="startTimestamp" cssClass="input-10" cssStyle="width:125px;" />
				<label class="inp-label">至</label>
				<form:input path="endTimestamp" cssClass="input-10" cssStyle="width:125px;" /></li>
			<li>
				<input type="button" class="query_btn" id="searchVehicleBtn" value="查询" />
				<input type="button" class="query_btn ml10" id="clear" value="清空"/>
			</li>
		</ul>
	</div>
</form:form>
<div class="rbody vehicle-list"></div>
<p class="vehicle-loading" style="width: 145px; height: 32px; line-height: 32px; text-align: center; margin: auto; padding: 0; display: none;">
	<img src="${ctx}/resources/ajaxfileupload/loading.gif" style="float: left;">
	<span style="display: inline-block; height: 100%; color: #777">查询中，请稍候...</span>
</p>
<script>
    common.showDateTimePicker("#startTimestamp");
    common.showDateTimePicker("#endTimestamp");
    var loading = $(".vehicle-loading");
    $("#searchVehicleBtn").click(function () {
        var startTimestamp = $("#startTimestamp").val();
    	var endTimestamp = $("#endTimestamp").val();
    	if(startTimestamp!=""){
    	    var is1=common.isDateTime(startTimestamp,e);
    	    if(!is1){return;}
    	    common.setDateTime("startTimestamp",startTimestamp);
    	}
    	if(endTimestamp!=""){
    	    var is2=common.isDateTime(endTimestamp,e);
    	    if(!is2){return;}
    	    common.setDateTime("endTimestamp",endTimestamp);
    	}
        var formParams = $("#vehicleSelectForm").serialize();
        //显示加载等待
        $(".vehicle-list").html(loading);
        loading.show();
        $.get("${ctx}/homepageRecommend/vehicle-list", formParams, function (dom) {
            $(".vehicle-list").html(dom);
        });
    });
    $("#clear").click(function () {
        common.formClean("vehicleSelectForm");
        //$("#vehicleSelectForm").clearForm();
    });

    //打开页面，默认查询一次
    $("#searchVehicleBtn").click();
</script>