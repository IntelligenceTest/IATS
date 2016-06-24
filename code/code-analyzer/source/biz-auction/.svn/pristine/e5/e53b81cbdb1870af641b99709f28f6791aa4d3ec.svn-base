<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<table class="bk_table width_percent_100" style="margin: 10px 25px 20px 15px; width: 90%; ">
	<c:forEach var="order" items="${orders }">
		<tr>
			<td>${order.vehicle.brand}${order.vehicle.vehicleModel}${order.vehicle.selledName}</td>
			<td>${order.item.finalPrice+order.item.buyerCommissionFee+order.item.licenseFee+order.item.exWarehouseFee}元</td>
			<td>${order.item.auctionVehicle.city }</td>
			<td>${order.vehicle.licenseCode}</td>
		</tr>
	</c:forEach>
</table>
<form id="offlinePayForm" data-validate="true" method="post" >
	<ul class="s_form" style="padding: 0px 22px 0;">
		<input type="hidden" name="orderIds" id="offlinePayFormOrderId" value="${orderIds}" />
		<li>
		    <label>*收款方：</label>
		    <select id="collectionParty" name="item.collectionParty">
		    	<spring:eval expression="@auctionDictionaryService.selectResource('collection_party')" var="collectionPartys" />
		    	<c:forEach items="${collectionPartys}" var="collectionParty">
		    		<option value="${collectionParty.value}">${collectionParty.name }</option>
		    	</c:forEach>
		    </select>
		    <label>*收款方式：</label>
		    <select id="collectionModel" name="item.collectionModel">
		    	<spring:eval expression="@auctionDictionaryService.selectResource('collection_model')" var="collectionModels" />
		    	<c:forEach items="${collectionModels}" var="collectionModel">
		    		<option value="${collectionModel.value}">${collectionModel.name }</option>
		    	</c:forEach>
		    </select>
		</li>
		<li style="height: 150px;">
		    <label>备注：</label>
		    <textarea style="width: 500px; height: 100px;" name="remark" id="offlinePayRemark" maxlength="100"></textarea>
	    </li>
	</ul>
	<p align="center" class="controlbox" style="margin-top: 0px;">
		<input type="button" class="button_lv4_1" value="保存" onclick="batchOfflinePayFormSubmit()"/>
		<input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
	</p>
</form>
