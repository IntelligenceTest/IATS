<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>二手车拍卖-订单管理</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
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
				<form:form action="${ctx }/order/index" commandName="orderItem" method="post" id="orderForm">
					<ul class="filter sa-sreach-list">
                        <li class="width-250">
							<p>订单号：</p>
							<form:input path="order.orderNo" maxlength="16" />
						</li>
						<li class="width-250">
							<p>拍卖类型：</p>
							<form:select path="saleType">
								<form:option value="" label="选择类型" />
								<form:option value="1" label="同步拍" />
								<form:option value="2" label="在线拍" />
								<form:option value="3" label="即时拍" />
							</form:select>
						</li>
						<li class="width-250">
							<p>订单状态：</p>
							<form:select path="status">
								<form:option value="" label="选择状态" />
								<form:option value="0" label="已创建" />
								<form:option value="5" label="待收款确认" />
								<form:option value="11" label="已收款" />
								<form:option value="7" label="已退款" />
								<form:option value="1" label="订单取消" />
								<form:option value="8" label="已结算" />
							</form:select>
						</li>
                        <li class="width-250">
							<p>订单类型：</p>
							<spring:eval expression="@autoDictionaryService.selectResource('order_build_type')" var="orderTypeList" />
							<form:select path="orderType">
								<form:option value="">-请选择-</form:option>
							    <form:options items="${orderTypeList }" itemLabel="name" itemValue="value"/>
							</form:select>
						</li>
	                    <li class="width-250">
						 <p>竞拍区域：</p>
							<form:select path="auctionCity">
								<form:option value="" label="-请选择-"></form:option>
								<spring:eval expression="@orderItemService.getAuctionCityList()" var="citys" />
								<form:options items="${citys}" itemLabel="city" itemValue="city"></form:options>
							</form:select> 
					    </li>
                        <li class="width-250">
							<p>车辆编号：</p>
							<form:input path="vehicle.code" maxlength="20" /> 
						</li>
						<li class="width-500">
	                        <p>成交时间：</p>
	                        <form:input data-date="timestamp" path="order.startDealTimestamp" id="startDealTimestamp" />
	                       	<label class="inp-label">至</label>
	                        <form:input data-date="timestamp" id="endDealTimestamp" path="order.endDealTimestamp" />
	                    </li>
                        <li class="width-250">
							<p>vin码：</p>
							<form:input path="vehicle.vinCode" style="width:155px;" maxlength="20" /> 
						</li>
                        <li class="width-250">
							<p>车牌号：</p>
							<form:input path="vehicle.licenseCode" maxlength="11" /> 
						</li>
                        <li class="width-250">
							<p style="width: 100px;">线下收款操作人：</p>
							<form:input path="opUserName"/> 
						</li>
					</ul>
				</form:form>
                <div class="query">
	                <shiro:hasPermission name="auction:order:index">
	                	<a id="search" class="query_btn" onclick="">查询</a>
	                </shiro:hasPermission>
                	<a class="query_btn ml10" onclick="common.formReset('orderForm')">清空条件</a>
                	<shiro:hasPermission name="auct:order:exportOrder">
	                	<a id="" class="query_btn ml10" onclick="exportExcel()">导出Excel</a>
	                </shiro:hasPermission>
                </div>
           </div>
        </div>
        <div class="exportselect" id="exportselect" style="display:none;float:left;">
            <form:form id="exportForm" method="post"  accept-charset="utf-8" enctype="application/x-www-form-urlencoded">
                <ul>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="order.orderNo#订单号"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="vehicle.code#车辆编号"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="vehicle.vehicleModel#品牌型号"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="vehicle.licenseCode#车牌号"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="vehicle.vinCode#车架号"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="statusDesc#订单状态"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="order.bidderName#购买人"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="order.buyerCellphone#购买人电话"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="dealPrice#成交总价(元)"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="settlePrice#结算价(元)"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="finalPrice#车辆成交价(元)"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="buyerCommissionFee#佣金(元)"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="licenseFee#办证费(元)"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="exWarehouseFee#出库费(元)"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="saleTypeDesc#拍卖类型"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="auctionCity#竞拍区域"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="createdTimestamp#创建时间"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="order.payTimestamp#支付时间"></li>
                    <li><input type="checkbox" checked="checked" name="exportCol" value="opUserName#线下收款操作人"></li>
                </ul>
            </form:form>
        </div>
		<shiro:hasPermission name="auction:order:batchOfflinePay">
			<input onclick="batchOfflinePay()" class="addbtn query_btn_2" type="submit" style="width: 100px" value="批量线下已付">
		</shiro:hasPermission>
        <div class="container_main">
        	<div class="wrap">
		        <table id="orderListTable" style="width:2000px;" class="bk_table width_percent_100">
					<thead>
			             <tr>
			             	<td width=25><input type="checkbox" onclick="selectAll(this)" /></td>
						   <td width=60>操作</td>
							<td width=120>订单号</td>
							<td width=120>车辆编号</td>
							<td width=80>车辆照片</td>
							<td width=160>品牌型号</td>
						    <td width=80>车牌号</td>
							<td width=60>订单状态</td>
							<td width=60>购买人</td>
							<td width=120>购买人电话</td>
							<td width=80>成交总价（元）</td>
							<td width=80>结算价（元）</td>
							<td width=240>费用明细</td>
							<td width=60>拍卖类型</td>
							<td width=60>订单类型</td>
							<td width=60>竞拍区域</td>
							<td width=80>创建时间</td>
							<td width=80>支付时间</td>
							<td width=80>收款方</td>
							<td width=80>收款方式</td>
							<td width=80>付款人</td>
							<td width=80>线下收款操作人</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.dataList}" var="item">
							<tr class="eq">
								<td><input type="checkbox" onclick="setSelectAll(this)" value="${item.orderId }" id="orderChx${item.orderId}" status="${item.status}"/></td>
							    <td>
							    <shiro:hasPermission name="auction:order:cancel">
									<c:if test="${item.status=='0' or item.status=='7'}">
										<a title="${item.order.orderNo}" data-name="cancelOrder" href="javascript:void(0)" style="color: #06c;text-decoration: none;">取消</a><br>
									</c:if>
								</shiro:hasPermission>
								<shiro:hasPermission name="auction:order:offlinePay">
									<c:if test="${item.status=='0'}">
										<a onclick="offlinePay(${item.orderId})" href="javascript:void(0)" title="${item.orderId }" price="${item.finalPrice }" data-name="offlinePay" style="color: #06c;text-decoration: none;">线下已付</a><br>
									</c:if>
								</shiro:hasPermission>
									<spring:eval var="vehicleInfo" expression="@vehicleService.selectVehicleById(item.vehicleId)"></spring:eval>
									<c:if test="${item.status=='0'&& vehicleInfo.stockStatus=='0'&& item.stockRemovalApprovalStatus==2}">
										<a href="javascript:void(0);" title="${item.orderId }" data-name="stockRemoval" style="color: #06c;text-decoration: none;">出库</a><br>
									</c:if>
								<a onclick="trackOrderStatus('${item.order.orderNo}')" href="javascript:void(0)" style="color: #06c;text-decoration: none;">订单跟踪</a>
								</td>
								<td><p>${item.order.orderNo }</p></td>
								<td><p>${item.vehicle.code }</p></td>
								<spring:eval expression="@autoDictionaryService.choiceImgUrl('60X45', item.photoUrl)" var="photoUrl" />
								<spring:eval expression="@autoDictionaryService.choiceImgUrl('1024X768', item.photoUrl)" var="maxPhotoUrl" />
		                        <td>
		                            <div>
		                           		<c:choose>
		                                   <c:when test="${photoUrl == null || photoUrl == ''}">
		                                    <img style="width: 60px;height: 45px;" src="http://img.autostreetscdn.com/common/build/2.00/images/noimg.png" />
		                                   </c:when>
		                                   <c:otherwise>
										      <img style="width: 60px;height: 45px;" data-popup="true" src="${dfsHttpServer}/${maxPhotoUrl}"/>
		                                   </c:otherwise>
		                               	</c:choose>
		                            </div>
		                        </td>
		                        <td>
		                        	<p><c:if test="${item.vehicle.source eq 'av' }"><img src="${ctx}/resources/auction/临时.png" style="vertical-align:middle;"></c:if>${item.vehicle.brand }</p>
		                        	<p>${item.vehicle.vehicleModel }<c:if test="${fn:startsWith(oneVehicle.vehicle.sweptVolumeStandard, '欧')}">(进口)</c:if> ${oneVehicle.vehicle.selledName}</p>
		                        	<p>${item.vehicle.selledName }</p>
		                        </td>
		                        <td>${item.vehicle.licenseCode }</td>
		                        <td>
		                        	<p>
									    <c:if test="${item.status=='0' }">已创建</c:if>
			                            <c:if test="${item.status=='1' }">订单取消</c:if>
			                            <c:if test="${item.status=='5' }">待收款确认</c:if>
			                            <c:if test="${item.status=='7' }">已退款</c:if>
			                            <c:if test="${item.status=='8' }">已结算</c:if>
			                            <c:if test="${item.status=='9' }">协商退款</c:if>
			                            <c:if test="${item.status=='10' }">退款失败</c:if>
			                            <c:if test="${item.status=='11' }">已收款</c:if>
			                            <c:if test="${item.status=='12' }">支付确认</c:if>
			                            <c:if test="${item.status=='13' }">付款已拒绝</c:if>
									</p>
								</td>
								<td><p>${item.order.bidderName }</p></td>
								
								<td>
									<p>
									<c:if test="${!empty item.order.buyerCellphone}">
										${fn:substring(item.order.buyerCellphone,0, 3)}*****${fn:substring(item.order.buyerCellphone,fn:length(item.order.buyerCellphone)-3, fn:length(item.order.buyerCellphone))}
									</c:if>
									</p>
								</td>
								<td><p>${item.finalPrice +item.buyerCommissionFee+item.licenseFee+item.exWarehouseFee+item.parkingFee+item.trafficFee+item.trafficViolationFee}</p></td>
		                        <td><p>
		                        <c:if test="${!empty item.settlePrice }">${item.settlePrice}</c:if>
			                    <c:if test="${empty item.settlePrice }">0.00</c:if>
		                        </p></td>
		                       <td><p>
			                                            车辆成交价（元）：${item.finalPrice }<br>
			                                            佣金（元）：<c:if test="${!empty item.buyerCommissionFee }">${item.buyerCommissionFee}</c:if>
			                                   <c:if test="${empty item.buyerCommissionFee }">0.00</c:if><br>              
			                                           办证费（元）：<c:if test="${!empty item.licenseFee }">${item.licenseFee}</c:if>
			                                   <c:if test="${empty item.licenseFee }">0.00</c:if> 
			                                     <br>  
			                                           出库费 （元）:<c:if test="${!empty item.exWarehouseFee }">${item.exWarehouseFee}</c:if>
			                                   <c:if test="${empty item.exWarehouseFee }">0.00</c:if> 
		                        </p></td>
		                        <td>
		                        	<p>
									    <c:if test="${item.saleType=='1' }">同步拍</c:if>
			                            <c:if test="${item.saleType=='2' }">在线拍</c:if>
			                            <c:if test="${item.saleType=='3' }">即时拍</c:if>
			                            <c:if test="${item.saleType=='0' }">一口价</c:if>
									</p>
								</td>
								<td>
								  <spring:eval expression="@autoDictionaryService.getNameByCategoryValue('order_build_type', '${item.orderType }')" var="orderTypeName" />
		                          <p>${orderTypeName }</p>
								</td>
								<td>${item.auctionCity }</td>
							    <td><p><fmt:formatDate value="${item.createdTimestamp}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
		                        <td><p><fmt:formatDate value="${item.order.payTimestamp}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
								<td>
									<c:forEach items="${collections}" var="collection">
										<c:if test="${collection.value eq item.collectionParty and collection.category eq 'collection_party' }">${collection.name }</c:if>
									</c:forEach>
								</td>
								<td>
									<c:forEach items="${collections}" var="collection">
										<c:if test="${collection.value eq item.collectionModel and collection.category eq 'collection_model' }">${collection.name }</c:if>
									</c:forEach>
								</td>
								<td>${item.order.draweeName }</td>
		                        <spring:eval expression="@orderStatusLogService.getOrderLog(${item.orderId})" var="orderlog" />
		                        <td>
		                        <c:if test="${orderlog.userId!=null}">
		                        <spring:eval expression="@userService.selectByPrimaryKey(${orderlog.userId})" var="user" />
		                         ${user.name }
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

<div id="offlinePay" class="UED_hide">
    <div class="pop_box" style="width: 660px;">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">付款信息登记<span id="_titleSpan"></span></h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box" style="width: 660px;max-height: 500px;overflow: auto" id="offlinePayBox">
        </div>
    </div>
</div>
<!-- 订单跟踪  模态框 -->
<div id="addgift" class="UED_hide">
    <div class="pop_box" style="width: 600px;">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">订单状态变更记录<span id="_titleSpan"></span></h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box" style="width: 600px; max-height: 400px;overflow: auto" id="container_top">
        </div>
    </div>
</div>

<%@include file="stockRemoval.jsp" %>
<script type="text/javascript">
$(document).ready(function (){
	common.showDateTimePicker("#startDealTimestamp");
	common.showDateTimePicker("#endDealTimestamp");
    kkpager.generPageHtml({
	    pno : '${pagination.current}',
	    //总页码
	    total : '${pagination.total}',
	    //总数据条数
	    totalRecords : '${pagination.count}',
	    //链接前部
	    hrefFormer : '${ctx}/order/index',
	    //链接算法
	    getLink : function(n){
	        var queryString = $('#orderForm').serialize(); 
	        return this.hrefFormer + this.hrefLatter + "?current=" + n + "&" + queryString;
	    }
	});
	$("#orderListTable a[data-name=cancelOrder]").on("click", function(e){
	 	if(!confirm("确定要取消订单吗？")) {
		    return false;
	 	}
		var url = "${ctx }/order/cancel";
		$.post(url, {orderNo : this.title}, function(data){
			alert(data.msg);
			if (data.success) {
				var queryString = $('#orderForm').serialize();
				location.href = "${ctx}/order/index?current=" + kkpager.pno;
			}
		});
	});
	
	
	
	/* $("#orderListTable a[data-name=offlinePay]").on("click", function(e){
	 	if(!confirm("请确认用户已支付"+$(this).attr("price")+"元？")) {
		    return false;
	 	}
		var url = "${ctx }/order/offlinePay";
		$.post(url, {orderId : this.title}, function(data){
			alert(data.msg);
			if (data.success) {
				var queryString = $('#orderForm').serialize();
				location.href = "${ctx}/order/index?current=" + kkpager.pno;
			}
		});
	}); */
	
	//车辆出库
	$("#orderListTable a[data-name=stockRemoval]").on("click", function(e){
	 	var orderId=this.title;
	 	var url = "${ctx}/order/getVehicle";
	 	$.ajax({
            type : "get",
            dataType : "json",
            url : url,
            data : {orderId : orderId},
            success : function(data){
                 if (data.success) {
                        //遍历json数据填充到层
                      $("#stockRemovalForm").find(":input[type!=button]").each(function(index, dom){
                          if(dom.name=="inGarageTimestamp"){
                     		  if(null!=data.data[dom.name]){
                         		  $(dom).val(data.data[dom.name].substring(0, 10));
                     		  }
                     	  }else{
                     		  $(dom).val(data.data[dom.name]);
                     	  }
                      });
                      $("#orderId").val(orderId);
                      $.LAYER.show({id : "stockRemoval"});
                 } else {
                     alert(data.msg);
                 }
            }
        });
	});
});

function offlinePay(id){
    $("#offlinePayBox").load("${ctx}/order/loadOfflinePay",{orderId:id},function(){
        $("#offlinePayFormOrderId").val(id);
	    $.LAYER.show({id:"offlinePay"});
    })
}

function batchOfflinePay(){
    var orderIds=common.getSelectIds("orderListTable");
    if(orderIds&&orderIds.length>0){
        var bool=false;
        $.each(orderIds,function(i,n){
            if($("#orderChx"+n).attr("status")!="0"){
                bool=true;
            }
        });
        if(bool){
        	alert("请选择待支付的订单");
            return;
        }
        $("#offlinePayBox").load("${ctx}/order/loadBatchOfflinePay",{orderIds:orderIds.join(",")},function(){
    	    $.LAYER.show({id:"offlinePay"});
        })
    }else{
        alert("未选择任何订单!")
    }
}

function loadOfflinePayMember(){
    $.ajax({
       url:"${ctx}/order/loadOfflinePayMember",
       data:{cellPhone:$("#memberCellPhone").val()},
       success:function(data){
           if(data&&data.success){
               var d=data.data;
               if(d){
                   $("#memberName").val(d.name);
                   $("#draweeName").val(d.name);
                   var tagName=$("#memberType").get(0).tagName;
                   if("LABEL"==tagName){
                       $("#memberType").html("会员");
                   }else{
	                   $("#memberType").val("会员");
                   }
                   var vouchers=d.vouchers;
                   if (vouchers&&vouchers.length>0) {
                       var html=[];
                       $.each(vouchers,function(i,n){
                           if(i==0){
	                           html.push("<span style='padding-left: 0px;'><input type='checkbox' onclick='calcSettlePrice(this)' name='voucherId' value='"+n.voucherCode+"' voucherPrice='"+n.voucherPrice+"'>"+n.voucherCode+"&nbsp;&nbsp;&nbsp;&nbsp;面值&nbsp;&nbsp;"+n.voucherPrice+"元&nbsp;&nbsp;&nbsp;&nbsp;"+(n.endTime?n.endTime:"永久有效")+"</span><br>");
                           }else{
	                           html.push("<span style='padding-left: 78px;'><input type='checkbox' onclick='calcSettlePrice(this)' name='voucherId' value='"+n.voucherCode+"' voucherPrice='"+n.voucherPrice+"'>"+n.voucherCode+"&nbsp;&nbsp;&nbsp;&nbsp;面值&nbsp;&nbsp;"+n.voucherPrice+"元&nbsp;&nbsp;&nbsp;&nbsp;"+(n.endTime?n.endTime:"永久有效")+"</span><br>");
                           }
                       })
                       $("#vouchers").html(html.join(""));
                   }else{
                       $("#vouchers").html("无优惠券");
                   }
               }else{
                   $("#memberName").val("");
                   $("#draweeName").val("");
                   $("#vouchers").html("无优惠券");
                   var tagName=$("#memberType").get(0).tagName;
                   if("LABEL"==tagName){
                       $("#memberType").html("非会员");
                   }else{
	                   $("#memberType").val("非会员");
                   }
               }
           }else{
               alert(data.msg);
           }
       }
    });
}
function batchOfflinePayFormSubmit(){
    if(!$.trim($("#collectionParty").val())){
        alert("请选择收款方");
        return;
    }
    if(!$.trim($("#collectionModel").val())){
        alert("请选择收款方式");
        return;
    }
    var orderIds=$("#offlinePayFormOrderId").val();
    $.ajax({
        url:"${ctx}/order/batchOfflinePay",
        type:"POST",
        traditional:true,
        data:{
            orderIds:orderIds,
            "item.collectionParty":$("#collectionParty").val(),
            "item.collectionModel":$("#collectionModel").val(),
            remark:$("#offlinePayRemark").val()
        },
        success:function(data){
            if(data&&data.success){
	            alert(data.msg);
	            $.LAYER.close();
	            location.href = "${ctx}/order/index?current=" + kkpager.pno;
            }else{
                alert(data.msg);
            }
        }
    })
}

function offlinePayFormSubmit(){
    if(!$.trim($("#collectionParty").val())){
        alert("请选择收款方");
        return;
    }
    if(!$.trim($("#collectionModel").val())){
        alert("请选择收款方式");
        return;
    }
    if($.trim($("#draweeName").val())&&$.trim($("#draweeName").val()).length>5){
        alert("收款人不能超过5个字!");
        return;
    }
    var voucherIdCheckBoxs=$("[name=voucherId]");
    var voucherCodes=[];
    $.each(voucherIdCheckBoxs,function(i,n){
        if(n.checked){
            voucherCodes.push($(n).val());
        }
    });
    $.ajax({
        url:"${ctx}/order/offlinePay",
        type:"POST",
        traditional:true,
        data:{
            orderId:$("#offlinePayFormOrderId").val(),
            "item.collectionParty":$("#collectionParty").val(),
            "item.collectionModel":$("#collectionModel").val(),
            buyerCellphone:$("#memberCellPhone").val()?$("#memberCellPhone").val():$("#memberCellPhone").html(),
            bidderName:$("#memberName").val()?$("#memberName").val():$("#memberName").html(),
            draweeName:$.trim($("#draweeName").val()),
            remark:$("#offlinePayRemark").val(),
            voucherCodes:voucherCodes
        },
        success:function(data){
            if(data&&data.success){
	            alert(data.msg);
	            $.LAYER.close();
	            location.href = "${ctx}/order/index?current=" + kkpager.pno;
            }else{
                alert(data.msg);
                location.reload();
            }
        }
    })
}

function calcSettlePrice(obj){
    var voucherIdCheckBoxs=$("[name=voucherId]");
    var voucherPrices=[];
    var sumVoucherPrice=0.0;
    $.each(voucherIdCheckBoxs,function(i,n){
        if(n.checked){
            sumVoucherPrice=parseFloat(sumVoucherPrice)+parseFloat($(n).attr("voucherPrice"));
        }
    });
    var _tempPrice=(parseFloat($("#sumDealPrice").html())-sumVoucherPrice).toFixed(2);
    if(parseFloat(_tempPrice)<0){
	    $("#settlePrice").html("0");
    }else{
        $("#settlePrice").html(_tempPrice);
    }
}

$(function(){
	$("#search").click(function(e){
		var startDealTimestamp = $("#startDealTimestamp").val();
    	var endDealTimestamp = $("#endDealTimestamp").val();
    	if(startDealTimestamp!=""){
    	    var is1=common.isDateTime(startDealTimestamp,e);
    	    if(!is1){return;}
    	    common.setDateTime("startDealTimestamp",startDealTimestamp);
    	}
    	if(endDealTimestamp!=""){
    	    var is2=common.isDateTime(endDealTimestamp,e);
    	    if(!is2){return;}	
    	    common.setDateTime("endDealTimestamp",endDealTimestamp);
    	}
    	$('#orderForm').submit();
	});
	
});

function trackOrderStatus(orderNo){
	
	  $("#container_top").load("${ctx}/order/trackOrderStatus",{orderNo:orderNo},function(){
	        $.LAYER.show({
				id : "addgift"
			});
	    });

}
function exportExcel(){
    var queryString=$("#orderForm").serialize();
    var actionUrl = "${ctx}/order/exportOrder?" + queryString;
    $("#exportForm").attr("action", actionUrl);
    $("#exportForm").submit();
}
</script>
</body>
</html>