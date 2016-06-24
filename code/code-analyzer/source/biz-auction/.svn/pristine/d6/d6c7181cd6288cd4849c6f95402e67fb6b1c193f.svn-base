<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<style>
.wd{width:75px;}
</style>
<form id="offlinePayForm" data-validate="true" method="post" >
	<ul class="s_form" style="padding: 0px 22px 0;">
		<input type="hidden" name="orderId" id="offlinePayFormOrderId" />
		<li class="lay-price-input">
			<label style="cursor: default;" class="wd">车型：</label>
			<label style="cursor: default;color: blue;">${vehicle.brand}${vehicle.vehicleModel}${vehicle.selledName}</label>
		</li>
		<li class="lay-price-input">
		    <label style="cursor: default;" class="wd">成交车价：</label>
		    <label style="cursor: default;">
		    	<c:if test="${empty orderItem.finalPrice }">0.00</c:if>
		    	<c:if test="${!empty orderItem.finalPrice }">
		    		<fmt:formatNumber type="currency" pattern="0.00" value="${orderItem.finalPrice}"></fmt:formatNumber>
		    	</c:if>元
		    </label>
		    <label style="cursor: default;">佣金：</label>
		    <label style="cursor: default;">
		    	<c:if test="${empty orderItem.buyerCommissionFee }">0.00</c:if>
		    	<c:if test="${!empty orderItem.buyerCommissionFee }">
		    		<fmt:formatNumber type="currency" pattern="0.00" value="${orderItem.buyerCommissionFee}"></fmt:formatNumber>
		    	</c:if>元
		    </label>
		    <label style="cursor: default;">出库费：</label>
		    <label style="cursor: default;">
		    	<c:if test="${empty orderItem.exWarehouseFee }">0.00</c:if>
		    	<c:if test="${!empty orderItem.exWarehouseFee }">
		    		<fmt:formatNumber type="currency" pattern="0.00" value="${orderItem.exWarehouseFee}"></fmt:formatNumber>
		    	</c:if>元
		    </label>
		    <label style="cursor: default;">办证费：</label>
		    <label style="cursor: default;">
		    	<c:if test="${empty orderItem.licenseFee }">0.00</c:if>
		    	<c:if test="${!empty orderItem.licenseFee }">
		    		<fmt:formatNumber type="currency" pattern="0.00" value="${orderItem.licenseFee}"></fmt:formatNumber>
		    	</c:if>元
		    </label>
		</li>
		<li class="lay-price-input">
		    <label style="cursor: default;" class="wd">成交总价：</label>
		    <label style="cursor: default;"><span id="sumDealPrice">${orderItem.finalPrice+orderItem.buyerCommissionFee+orderItem.licenseFee+orderItem.exWarehouseFee}</span>元</label>
		    <label style="cursor: default;" class="wd">结算价：</label>
		    <label style="cursor: default;"><span id="settlePrice" style="color: red;">${orderItem.finalPrice+orderItem.buyerCommissionFee+orderItem.licenseFee+orderItem.exWarehouseFee}</span>元</label>
		</li>
		<li>
		    <label style="cursor: default;" class="wd">*收款方：</label>
		    <select id="collectionParty" name="item.collectionParty" style="margin-left: 7px;">
		    	<spring:eval expression="@auctionDictionaryService.selectResource('collection_party')" var="collectionPartys" />
		    	<c:forEach items="${collectionPartys}" var="collectionParty">
		    		<option value="${collectionParty.value}">${collectionParty.name }</option>
		    	</c:forEach>
		    </select>
		    <label style="cursor: default;" class="wd">*收款方式：</label>
		    <select id="collectionModel" name="item.collectionModel">
		    	<spring:eval expression="@auctionDictionaryService.selectResource('collection_model')" var="collectionModels" />
		    	<c:forEach items="${collectionModels}" var="collectionModel">
		    		<option value="${collectionModel.value}">${collectionModel.name }</option>
		    	</c:forEach>
		    </select>
		</li>
		<li class="lay-price-input" style="clear: both;">
		    <label style="cursor: default;" class="wd">成交人手机：</label>
		    <c:if test="${!empty member}">
		    	<label style="cursor: default;" id="memberCellPhone">${member.cellphone }</label>
		    </c:if>
		    <c:if test="${empty member}">
			    <input type="text" name="buyerCellphone" id="memberCellPhone" maxlength="11">
		    </c:if>
		    <c:if test="${empty member}">
		    	<input type="button" value="查询" onclick="loadOfflinePayMember()" />
		    </c:if>
		</li>
		<li class="lay-price-input" style="clear: both;">
		    <label style="cursor: default;" class="wd">成交人姓名：</label>
		    <c:if test="${!empty member}">
		    	<label style="cursor: default;" id="memberName">${member.name }</label>
		    </c:if>
		    <c:if test="${empty member}">
		    	<input type="text" id="memberName" name="bidderName" maxlength="20" value="${member.name }">
		    </c:if>
		    <label style="cursor: default;" class="wd">用户类型:</label>
		    <label style="cursor: default;" id="memberType">
		    	<c:if test="${empty member}">非会员</c:if>
		    	<c:if test="${!empty member}">会员</c:if>
		    </label>
		</li>
		<li class="lay-price-input" style="clear: both;">
		    <label style="cursor: default;" class="wd">付款人：</label>
		    <input type="text" id="draweeName" name="draweeName" maxlength="5" value="${member.name }">
		</li>
		<li id="voucherDiv" style="height: auto; overflow:auto; width: 100%;">
			<label style="cursor: default;" class="wd">优惠券：</label>
			<insd id="vouchers">
			<c:if test="${empty voucherList }">
				<label style="cursor: default;">无优惠券</label>
			</c:if>
			<c:forEach items="${voucherList}" var="voucher" varStatus="status">
				<c:if test="${status.index eq 0}">
					<span style="padding-left: 0px;">
				</c:if>
				<c:if test="${status.index ne 0}">
					<span style="padding-left: 78px;">
				</c:if>
				<input onclick="calcSettlePrice(this)" type="checkbox" name="voucherId" value="${voucher.voucherCode}" voucherPrice="${voucher.voucherPrice}">${voucher.voucherCode}&nbsp;&nbsp;&nbsp;&nbsp;面值&nbsp;&nbsp;<c:if test="${empty voucher.voucherPrice }">0.00</c:if>
		    	<c:if test="${!empty voucher.voucherPrice }">
		    		<fmt:formatNumber type="currency" pattern="0.00" value="${voucher.voucherPrice}"></fmt:formatNumber>
		    	</c:if>元&nbsp;&nbsp;&nbsp;&nbsp;
		    	<c:if test="${empty voucher.endTime }">
		    		永久有效
		    	</c:if>
		    	<c:if test="${!empty voucher.endTime }">
			    	<fmt:formatDate value="${voucher.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
		    	</c:if>
		    	</span><br>
			</c:forEach>
			</insd>
		</li>
		<li style="height: 150px;">
		    <label style="cursor: default;" class="wd">备注：</label>
		    <textarea style="width: 480px; height: 100px; margin-left: 83px;" name="remark" id="offlinePayRemark" maxlength="100"></textarea>
	    </li>
	</ul>
	<p align="center" class="controlbox" style="margin-top: 0px;">
		<input type="button" class="button_lv4_1" value="保存" onclick="offlinePayFormSubmit()"/>
		<input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
	</p>
</form>
