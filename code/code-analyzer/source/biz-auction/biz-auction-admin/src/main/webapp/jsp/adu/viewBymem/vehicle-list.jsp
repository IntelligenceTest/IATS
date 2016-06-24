<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<table class="bk_table width_percent_100"  id="datatable" style="margin-bottom: 20px;">
    <thead>
        <tr>
             <td >VIN码</td>
             <td>车牌号</td>
             <td>品牌车系车型</td>
             <td >成交时间</td>
             <td >成交价格(元)</td>
             <td >拍卖号牌</td>
             <td ><div><span>车辆编号</span></div></td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${auctionDataUploads}" var="item">
            <tr>
                <td><a href="http://admin-auction.autostreets.com/vehicle/vehicleDetail?code=${item.code}" target="_blank">${item.vinCode }</a></td>
                <td>${item.licenseCode }</td>
                <td>${item.brandModel }</td>
                <td><fmt:formatDate value="${item.dealTime}" pattern="yyyy-MM-dd" /></td>
               <td>${item.dealPrice }</td>
               <td>${item.auctionNumber }</td>
              <td>${item.auctionVehicleOrder }</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div class="clearfix"></div>