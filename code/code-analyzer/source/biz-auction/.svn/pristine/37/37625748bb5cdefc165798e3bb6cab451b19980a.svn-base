<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<link href="${ctx}/resources/js/ligerUI/ligerui-tree.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/js/ligerUI/base.js" type="text/javascript"></script>
<script src="${ctx}/resources/js/ligerUI/ligerTree.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$(".vehicleSrcTd").each(function(){
			var _this = $(this);
			$.ajax({
		        type:"post",
		        dataType:"json",
		        url:"${ctx}/appointmentUsedCar/queryVehicleSrc",
		        data:{"vehicleSrcSid":_this.attr("vehicleSrcSid"),"vehicleSrcType":_this.attr("vehicleSrcType")},
		        success:function(data){
		        	_this.html(data);
		        }
		    });
		});
		
	});
</script>
<title>AutoStreets后台系统-预约看车单</title>
</head>
<body>
	<jsp:include page="${ctx}/common/menu" flush="true"></jsp:include>
	<div class="mainblock">
	    <div class="mainwrap">
	        <jsp:include page="${ctx}/common/subMenu" flush="true"></jsp:include>
	    </div>
		<div class="container">
		   <div class="bi_wrap"> 
			<div class="container_top">
				<spring:eval expression="@dictionaryService.selectResource('advertise_pos')" var="posList" />
				<spring:eval expression="@dictionaryService.selectResource('advertise_status')" var="statusList" />
				<spring:eval expression="@activityInfoService.queryAlidActivity()" var="activityList" />
				<form:form id="searchLoanForm" commandName="appointmentUsedcar" modelAttribute="appointmentUsedcar" action="${ctx}/appointmentUsedCar/index">
                        <ul class="filter sa-sreach-list">
	                        <li class="width-500">
								<p>预约时间：</p>
								<form:input path="startTime" id="startTimestamp"/>
		                        <label class="inp-label">至</label>
		                        <form:input path="endTime" id="endTimestamp"/>
							</li>
                        </ul>
						<div class="query">
							<input id="searchLoanFormBtn" type="button" class="query_btn" value="查询"/>
						</div>
			     </form:form>
		         <div class="clearfix"></div>
				</div>
			</div>
			<div class="container_main">
				<div class="wrap">
					<table id="datelist-1" class="bk_table width_percent_100" data-theme="bk_table width_percent_100" data-form="searchLoanForm" data-pno="${pagination.current}" data-pageSize="${pagination.length}"
					    data-total="${pagination.total}" data-totalRecords="${pagination.count}" data-isShowSelectPageSize="true" >
						<thead>
							<tr>
								<th>预约时间</th>
								<th>客户姓名</th>
								<th>手机号</th>
								<th>省市</th>
								<th>意向车型</th>
								<th>车辆编号</th>
								<th>展售状态</th>
								<th>展售价格（万元）</th>
								<th>展售区域</th>
								<th>车牌号</th>
								<th>VIN号</th>
								<th>车辆来源</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pagination.dataList}" var="data">
								<tr class="eq">
									<td>
									   <fmt:formatDate value="${data.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td>
										${data.customerName }
									</td>
									<td>
									    ${data.cellNo }
									</td>
								    <td>
                                        ${data.province } ${data.city }
                                    </td>
                                    <c:choose>
                                        <c:when test="${data.saleType == 2}">
                                            <spring:eval expression="@fixedPriceService.selectByPrimaryKey(data.refSid)" var="fixedPrice" />
                                            <spring:eval expression="@vehicleService.selectVehicleById(fixedPrice.vehicleId)" var="vehicle" />
                                            <td>
		                                         ${vehicle.brand } ${vehicle.vehicleModel } <c:if test="${fn:startsWith(vehicle.sweptVolumeStandard, '欧')}">(进口)</c:if> ${vehicle.selledName}
		                                    </td>
		                                    <td>
                                                ${vehicle.code }
                                            </td>
                                            <td>
                                                <c:if test="${ fixedPrice.id==null}">待售</c:if>
				                                <c:if test="${ fixedPrice.status==0}"><font color="green">上架申请</font></c:if>
				                                <c:if test="${ fixedPrice.status==1}"><font color="gray"><b>已下架</b></font></c:if>
				                                <c:if test="${ fixedPrice.status==2}"><font color="purple"><b>已出售</b></font></c:if>
				                                <c:if test="${ fixedPrice.status==3}"><font color="blue"><b>已上架</b></font></c:if>
				                                <c:if test="${ fixedPrice.status==4}"><font color="green"><b>已预订</b></font></c:if>
				                                <c:if test="${ fixedPrice.status==5}"><font color="red">已付定金</font></c:if>
				                                <c:if test="${ fixedPrice.status==6}"><font color="red"><b>已付全款</b></font></c:if>
                                            </td>
                                            <td>
                                                <c:if test="${fixedPrice.price != null}">
					                                <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${fixedPrice.price/10000 }"></fmt:formatNumber>
					                            </c:if>
                                            </td>
                                            <td>
                                                ${fixedPrice.province } ${fixedPrice.city }
                                            </td>
                                            <td>
                                                ${vehicle.licenseCode }
                                            </td>
                                            <td>
                                                ${vehicle.vinCode }
                                            </td>
                                            <td class="vehicleSrcTd" vehicleSrcType="${vehicle.vehicleSrcType }" vehicleSrcSid ="${vehicle.vehicleSrcId }">
                                                
                                            </td>
                                        </c:when>
                                    </c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
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
<script type="text/javascript" src="${ctx}/resources/auction/all.js"></script>	
<script type="text/javascript">
	//分页
	kkpager.generPageHtml({
	    pno : '${pagination.current}',
	    //总页码
	    total : '${pagination.total}',
	    //总数据条数
	    totalRecords : '${pagination.count}',
	    //链接前部
	    hrefFormer : '${ctx}/appointmentUsedCar/index',
	    //链接算法
	    getLink : function(n){
	        var queryString = $('#searchLoanForm').serialize(); 
	        return this.hrefFormer + this.hrefLatter + "?current=" + n + "&" + queryString;
	    }
	});
	
	$("#searchLoanFormBtn").click(function(e){
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
    	$("#searchLoanForm").submit();
    });
	
</script>	
</body>
</html>