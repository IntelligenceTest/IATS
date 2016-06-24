<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>

<table class="bk_table width_percent_100" id="dataTbl">
    <colgroup>
        <col style="width: 40px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
        <col style="width: 80px;">
    </colgroup>
    <thead>
        <tr>
            <th>序号</th>
            <th>拍卖会名</th>
            <th>VIN码</th>
            <th>车牌号</th>
            <th>品牌车型车系</th>
            <th>成交时间</th>
            <th>成交价格(元)</th>
            <th>拍卖号牌</th>
            <th>拍卖车辆编号</th>
            <th>参拍人</th>
            <th>参拍人类型</th>
            <th>身份证号</th>
            <th>手机号</th>
            <th>登记时间</th>
            <th>微信</th>
            <th>区域省</th>
            <th>区域市</th>
        </tr>
    </thead>
    <tbody>
	    <c:if test="${pagination.count eq 0}">
	    	<tr>
	    		<td colspan="17">无数据</td>
	    	</tr>
	    </c:if>
        <c:set var="index" value="${pagination.begin}" />
        <c:forEach items="${pagination.dataList}" var="data" varStatus="status">
            <tr>
                <td>${((pagination.current-1)*pagination.length)+status.index+1}</td>
                <td>${data.auctionTitle}</td>
                <td><a href="http://admin-auction.autostreets.com/vehicle/vehicleDetail?code=${data.code}" target="_blank">${data.vinCode}</a></td>
                <td>${data.licenseCode}</td>
                <td>${data.brandModel}</td>
                <td><fmt:formatDate value="${data.dealTime}" pattern="yyyy-MM-dd" /></td>
                <td>${data.dealPrice}</td>
                <td>${data.auctionNumber}</td>
                <td>${data.auctionVehicleOrder}</td>
                <td>${data.auctionMemberName}</td>
                <td>${data.memberType}</td>
                <td>${data.auctionMemberIDCar}</td>
                <td>${data.auctionMemberCellphone}</td>
                <td><fmt:formatDate value="${data.registerTime}" pattern="yyyy-MM-dd" /></td>
                <td>${data.auctionMemberWechat}</td>
                <td>${data.auctionMemberProvince}</td>
                <td>${data.auctionMemberCity}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<ul class="model-search-form">
	<li class="lay-price-input">
   		<label class="model-label model-len8">车次：<span>${data.vehicleNum}</span></label> 
   		<label class="model-label model-len8">车辆数(去重)：${data.vehicleDistinctNum }</label>
   		<label class="model-label model-len8">成交人(去重)：${data.dealPersonNum }</label>
   		<label class="model-label model-len8">成交车次：${data.dealVehicleNum}</label>
   		<label class="model-label model-len12">成交总额：<c:if test="${empty data.dealVehicleVolume}">0.00</c:if><c:if test="${!empty data.dealVehicleVolume}">${data.dealVehicleVolume}</c:if>(元)</label>
   		<label class="model-label model-len8">未成交车次：${data.unDealVehicleNum}</label>
	</li>
</ul>
<c:if test="${pagination!=null}">
    <c:if test="${pagination.count>10}">
        <div class="model-page-warp">
            <div class="pagination fr">
                <div id="kkpager"></div>
            </div>
        </div>
    </c:if>
</c:if>

<%@include file="am_tbl_vehicles.jsp" %>

<script type="text/javascript">
</script>