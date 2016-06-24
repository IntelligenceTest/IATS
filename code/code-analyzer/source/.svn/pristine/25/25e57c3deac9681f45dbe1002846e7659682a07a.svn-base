<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>AutoStreets后台系统-订单管理</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
</head>
<body>
<jsp:include page="${ctx}/common/menu" flush="true"/>
<div class="mainblock">
    <div class="mainwrap">
        <jsp:include page="${ctx}/common/subMenu" flush="true"/>
    </div>
    <div class="container">
   		<div class="bi_wrap">
   			<div class="container_top">
				<form:form action="${ctx }/order/showroomorder" commandName="order" method="post" id="orderForm">
					<ul class="filter sa-sreach-list">
						<li class="width-250">
							<p>订单号：</p> 
							<form:input path="orderNo" maxlength="20" /> 
						</li>
						<li class="width-250">
							<p>购买人：</p> 
							<form:input path="bidderName" maxlength="20" /> 
						</li>
	                    <li class="width-250">
							<p>车辆编号：</p>
							<form:input path="vehicle.code" maxlength="20" /> 
						</li>
						<li class="width-250">
							<p>vin码：</p>
							<form:input path="vehicle.vinCode" maxlength="20" /> 
						</li>
						<li class="width-250">
							<p>车牌号：</p>
							<form:input path="vehicle.licenseCode" maxlength="20" /> 
						</li>
						<li class="width-250">
							<p>订单状态：</p>
							<spring:eval expression="@autoDictionaryService.selectResource('order_status')" var="statusList" />
							<form:select path="item.status">
								<form:option value=""> -- 请选择 -- </form:option>
								<form:options items="${statusList }" itemLabel="name" itemValue="value"/>
							</form:select>
						</li>
						<li class="width-250">
							<p>财务审核:</p>
							<form:select path="item.finAudit">
								<form:option value=""> -- 请选择 -- </form:option>
								<form:option value="0"> 待审核  </form:option>
								<form:option value="1"> 已审核  </form:option>
							</form:select>
						</li>
						<li class="width-600">
	                        <p>订单时间：</p>
	                        <form:input data-date="timestamp" path="startDealTimestamp" />
	                       	<label class="inp-label">至</label>
	                        <form:input data-date="timestamp" path="endDealTimestamp" />
	                    </li>
					</ul>
				</form:form>
                <div class="query">
                	<a id="orderFormBtn" class="query_btn">查询</a>
                </div>
			</div>
        </div>
        <div class="container_main">
        	<div class="wrap">
		        <table id="orderListTable" class="bk_table width_percent_100" style="width:2000px;">
					<thead>
						<tr>
							<td>操作</td>
							<td>订单号</td>
							<td style="min-width:200px;">车辆信息</td>
							<td>车辆图片</td>
							<td>车辆区域</td>
							<td>购买人</td>
							<td>购买人电话</td>
							<td style="min-width:275px;">价格(万元)</td>
							<td>上架时间</td>
							<td>订单时间</td>
							<td>修改时间</td>
							<td>订单状态</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.dataList}" var="item">
							<tr class="eq">
								<td class="link_td" style="line-height:20px">
									<c:set var="vehicleInfo" value="${item.vehicle.brand } ${item.vehicle.vehicleModel} ${item.vehicle.selledName}" ></c:set>
									<c:if test="${fn:startsWith(oneVehicle.vehicle.sweptVolumeStandard, '欧')}">
										<c:set var="vehicleInfo" value="${item.vehicle.brand } ${item.vehicle.vehicleModel}(进口) ${item.vehicle.selledName}" ></c:set>
									</c:if>
									<a href="javascript:void(0);" title="${item.orderNo }" data-name="trackOrderStatus">订单跟踪</a>
									<c:if test="${item.status == 0 }">
										<br />
										<shiro:hasPermission name="auct:fporder:cancel">
											<a href="#"   class="cancelOrder" value="${item.orderNo}">取消</a>
										</shiro:hasPermission>
									</c:if>
									<c:if test="${item.status == 4 }">
										<br />
										<shiro:hasPermission name="auct:fporder:deal">
											<a href="#" class="dealOrder"  value="${item.orderNo},${item.vehicle.code},${vehicleInfo},${item.vehicle.vinCode},${item.bidderName},${item.buyerCellphone},${item.deposit},${item.orderPrice}">成交</a>
										</shiro:hasPermission>
									</c:if>
								</td>
								<td><p>${item.orderNo }</p></td>
								<spring:eval expression="@autoDictionaryService.choiceImgUrl('60X45', item.vehicle.firstPhotoUrl)" var="photoUrl" />
								<spring:eval expression="@autoDictionaryService.choiceImgUrl('1024X768', item.vehicle.firstPhotoUrl)" var="maxPhotoUrl" />
		                        <td>
		                        	<div style="float:none;" >
										<p>编号： 
										 	<a href="http://auction.autostreets.com/no-haggle/${item.vehicle.id}" class="link" target="_blank">
				                          	${item.vehicle.code }
				                        	</a>
										</p>
										<p>vin码： ${item.vehicle.vinCode }</p>
										<p>品牌： ${item.vehicle.brand } ${item.vehicle.vehicleModel } <c:if test="${fn:startsWith(item.vehicle.sweptVolumeStandard, '欧')}">(进口)</c:if> ${item.vehicle.selledName }</p>
							       </div>
		                        </td>
		                        <td>
		                            <div>
		                           		<c:choose>
		                                   <c:when test="${photoUrl == null || photoUrl == ''}"><img style="width: 60px;height: 45px;" src="${staticUrl}/common/build/1.00/images/no.jpg"></c:when>
		                                   <c:otherwise>
										        <img style="width: 60px;height: 45px;" data-popup="true" src="${dfsHttpServer}/${maxPhotoUrl}"/>
		                                   </c:otherwise>
		                               	</c:choose>
		                            </div>
		                        </td>
		                        <td>
		                        	<p>${item.vehicle.currentCity}</p>
		                        </td>
		                        <td><p>${item.bidderName }</p></td>
								<td><p>${item.buyerCellphone }</p></td>
		                        <td>
		                           <div class="price_record">
										<p>展售价：
											<label style="color:red;"><fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.fixedPrice.price/10000 }"></fmt:formatNumber></label>
										</p>
										<p>购置税：
											<label style="color:red;"><fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.fixedPrice.taxBuy/10000 }"></fmt:formatNumber></label>
										</p>
										<p>新车售价：<label style="color:red;"><fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.fixedPrice.newVehicleSuggestionPrice }"></fmt:formatNumber></label></p>
							       </div>
							       <div class="price_record">
										<p>集团最低限价：
											<label style="color:red;"><fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.fixedPrice.lowPriceGroup/10000 }"></fmt:formatNumber></label>
										</p>
										<p>订金：
											<label style="color:red;"><fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.deposit/10000 }"></fmt:formatNumber></label>
										</p>
										<p>含订金购买价：
											<label style="color:red;"><fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.orderPrice/10000 }"></fmt:formatNumber></label>
										</p>
								   </div>
		                        </td>
								<td><p><fmt:formatDate value="${item.fixedPrice.sellTime}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
								<td><p><fmt:formatDate value="${item.createdTime}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
								<td><p><fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
								<td>
									<spring:eval expression="@autoDictionaryService.getNameByCategoryValue('order_status', '${item.status }')" var="statusName" />
									${statusName}
									<c:if test="${item.finAudit == 1}">
										(已审核)
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${pagination!=null}">
					<c:if test="${pagination.count>10 }">
						<div class="pagination fr">
							<div id="kkpager"></div>
						</div>
					</c:if>
				</c:if>
            </div>
        </div>
    </div>
</div>
<div id="dialog" class="UED_hide">
	<div class="pop_box">
		<div class="pop_tittle">
			<h3 id="UED_layer_h3_v31">
				<span id="_titleSpan"></span>
			</h3>
			<a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
		</div>
		<div class="s_box container_top">
		</div>
	</div>
</div>
<script type="text/javascript">
var proDealOrder = function(orderNo){
	var url = "${ctx }/order/deal";
	$.post(url, {orderNo : orderNo}, function(data){
		alert(data.msg);
		if (data.success) {
			location.reload();
		}
	});	
};
$(document).ready(function (){
	common.showDateTimePicker("#startDealTimestamp");
	common.showDateTimePicker("#endDealTimestamp");
	
	$("#orderFormBtn").click(function(e){
    	var startTimestamp = $("#startDealTimestamp").val();
    	var endTimestamp = $("#endDealTimestamp").val();
    	if(startTimestamp!=""){
    	    var is1=common.isDateTime(startTimestamp,e);
    	    if(!is1){return;}
    	    common.setDateTime("startDealTimestamp",startTimestamp);
    	}
    	if(endTimestamp!=""){
    	    var is2=common.isDateTime(endTimestamp,e);
    	    if(!is2){return;}
    	    common.setDateTime("endDealTimestamp",endTimestamp);
    	}
    	$("#orderForm").submit();
    });
	
	$("#orderListTable a.cancelOrder").on("click", function(e){
		if(!confirm("确定要取消订单吗？")) {
		    return false;
	 	}
		var	url = "${ctx }/order/cancel";
		$.post(url, {orderNo : $(this).attr("value")}, function(data){
			alert(data.msg);
			if (data.success) {
				location.reload();
			}
		});
	});
	
	$("#orderListTable a.dealOrder").on("click", function(e){
		var params = $(this).attr("value").split(",");
		var content = $("#dialog .container_top").empty();
		var html = $('<div style="padding:0em 3em;">' +
				'<p><label style="margin-right:1em;">订单号：</label>'+ params[0] +'</p>' +
				'<p><label>车辆编号：</label>'+ params[1] +'</p>' +
				'<p><label>品牌型号：</label>'+ params[2] +'</p>' +
				'<p><label style="magin-left:.5em;">vin码：</label>'+ params[3] +'</p>' +
				'<p><label style="magin-left:1em;">购买人：</label>'+ params[4] +'</p>' +
				'<p><label>购买人电话：</label>'+ params[5] +'</p>' +
				'<p><label style="magin-left:1em;">订购价：</label>'+ params[6] +'</p>' +
				'<p><label style="magin-left:1em;">全款：</label>'+ params[7] +'</p>' +
				'<p class="controlbox" style="text-align:center;">' +
					'<input type="button" onclick="javascript:proDealOrder(\''+ params[0] +'\')" style="float:none;" value="确定" class="btn_lv4_1" />' +
					'<input type="button" onclick="$.LAYER.close();" style="margin-left: 12px;" value="关闭" class="btn_lv4_1" />' +
				'</p>' +
				'</div>');
		content.append(html);
		$("#_titleSpan").html("确认订单成交");
		$("#dialog .pop_box").width(350);
		$("#dialog .container_top").html(html);
		$.LAYER.show({
			id : "dialog"
		});
	});
	
	$("#orderListTable a[data-name=trackOrderStatus]").on("click", function(e){
		var url = "${ctx }/order/trackOrderStatus";
		$.post(url, {orderNo : this.title}, function(data){
			if (data.success) {
				var html = '<div>';
				if (data.data && data.data.length > 0) {
					for (var i = 0; i < data.data.length; i++) {
					    html += '<p><label style="color:red;margin-right:1em;">' + (data.data[i].userName||" 系统 ") + '</label>' + data.data[i].createTime + '<label style="color:green;margin-left:1em;">' + data.data[i].prepStatusName + ' --&gt; ' + data.data[i].postStatusName +'</label></p>';
					}
					html += '</div>';
				} else {
					html = '<p style="margin: 2em 12em;">暂无变更记录！</p>';
				}
				$("#_titleSpan").html("订单状态变更记录");
				$("#dialog .pop_box").width(400);
				$("#dialog .container_top").html(html);
				$.LAYER.show({
					id : "dialog"
				});
			} else {
				alert(data.msg);
			}
		});
	});
	kkpager.generPageHtml({
	    pno : '${pagination.current}',
	    //总页码
	    total : '${pagination.total}',
	    //总数据条数
	    totalRecords : '${pagination.count}',
	    //链接前部
	    hrefFormer : '${ctx}/order/showroomorder',
	    //链接算法
	    getLink : function(n){
	        var queryString = $('#orderForm').serialize(); 
	        return this.hrefFormer + this.hrefLatter + "?current=" + n + "&" + queryString;
	    }
	});
});
</script>
</body>
</html>