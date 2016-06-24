<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
        <!-- <col style="width: 80px;">
        <col style="width: 80px;"> -->
        <col style="width: 80px;">
    </colgroup>
    <thead>
        <tr>
            <th>序号</th>
            <th>拍卖会名</th>
            <th>参拍人</th>
            <th>参拍人类型</th>
            <th>身份证号</th>
            <th>手机号</th>
            <th>登记时间</th>
            <th>微信</th>
            <th>区域省</th>
            <th>区域市</th>
            <th>拍卖号牌</th>
            <!-- <th>成交车辆数</th>
            <th>成交额小计(元)</th> -->
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
	    <c:if test="${pagination.count eq 0}">
	    	<tr>
	    		<td colspan="12">无数据</td>
	    	</tr>
	    </c:if>
        <c:set var="index" value="${pagination.begin}" />
        <c:forEach items="${pagination.dataList}" var="data" varStatus="status">
            <tr>
                <td>${((pagination.current-1)*pagination.length)+status.index+1}</td>
                <td>${data.auctionTitle}</td>
                <td>${data.auctionMemberName}</td>
                <td>${data.memberType}</td>
                <td>${data.auctionMemberIDCar}</td>
                <td>${data.auctionMemberCellphone}</td>
                <td><fmt:formatDate value="${data.registerTime}" pattern="yyyy-MM-dd" /></td>
                <td>${data.auctionMemberWechat}</td>
                <td>${data.auctionMemberProvince}</td>
                <td>${data.auctionMemberCity}</td>
                <td>${data.auctionNumber}</td>
                <%-- <td>${data.dealVehicleSum}</td>
                <td><fmt:formatNumber value="${data.dealPriceSum}" minFractionDigits="0" maxFractionDigits="2" /></td> --%>
                <td>
                  <shiro:hasPermission name="auct:adu:view">
                    <c:if test="${data.dealVehicleSum > 0}">
                        <input type="button" class="model-btn model-white model-len2" value="查看" onclick="javascript: vehiclesDiv(${data.auctionId},'${data.auctionTitle }','${data.memberSid}', '${data.auctionMemberName}', '${data.auctionMemberIDCar}', '${data.auctionMemberCellphone}', '${data.dealVehicleSum}', '${data.dealPriceSum}');" />
                   </c:if>
                  </shiro:hasPermission>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<ul class="model-search-form">
	<li class="lay-price-input">
   		<label class="model-label model-len8">参拍人次：<span>${data.auctionPersonNum}</span></label> 
   		<label class="model-label model-len8">参拍人(去重)：${data.auctionDistinctPersonNum }</label> 
   		<%-- <label class="model-label model-len8">成交车次：${data.auctionDealNum }</label>
   		<label class="model-label model-len12">成交总额：<c:if test="${empty data.dealVehicleVolume}">0.00</c:if><c:if test="${!empty data.dealVehicleVolume}">${data.dealVehicleVolume}</c:if>(元)</label> --%>
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
<%@include file="viewBymem/view.jsp" %>
<script type="text/javascript">
function vehiclesDiv(auctionId,auctionTitle,memberId,auctionMemberName,auctionMemberIDCar,auctionMemberCellphone,dealVehicleSum,dealPriceSum){
	$.LAYER.show({
		id : "vehicleByMemberDiv"
	});
	$("#aucName").html(auctionTitle);
	$("#perName").html(auctionMemberName);
	$("#idNum").html(auctionMemberIDCar);
	$("#teleNum").html(auctionMemberCellphone);
	$("#veDealNum").html(dealVehicleSum);
	$("#memId").val(memberId);
	$("#auctionId").val(auctionId);
	loadPersonList();
}

function loadPersonList(){
	var auctionId=$("#auctionId").val();
	var memberSid=$("#memId").val();
	var idCardNum= $("#idNum").html();
	$("#auctionPersonDiv").load("${ctx}/adu/getVehicleInfoByAuctionPersonList",{ auctionId:auctionId,memberSid:memberSid,idCardNum:idCardNum});
}
</script>