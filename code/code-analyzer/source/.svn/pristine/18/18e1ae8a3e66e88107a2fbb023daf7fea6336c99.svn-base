<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>出价管理</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
<script language="javascript" src="${ctx}/resources/auction/bid.js?randomId=<%=System.currentTimeMillis()%>"></script>
<style>
	#changeFinalPriceDiv td{
	    height: 35px;
  		padding:0 10px;
	}
</style>
</head>
<body>
<jsp:include page="${ctx}/common/menu" flush="true"/>
<div class="mainblock">
	<div class="mainwrap">
        <jsp:include page="${ctx}/common/subMenu" flush="true"/>
    </div>
    <div class="container">
   		<div class="bi_wrap">
   			<ul id="tab_title" class="bk_title mb10">
				<li class="cur"><a href="javascript:void(0);">车辆模式</a></li>
				<li><shiro:hasPermission name="auct:bid:b_model"><a href="${ctx}/bid/querybid"></shiro:hasPermission>出价模式</a></li>
			</ul>
   			<div class="container_top">
				<form:form action="${ctx}/bid/query" method="post" commandName="bid" id="bidForm">
					<ul class="filter sa-sreach-list">
						<li class="width-250">
							<p>品牌：</p>
							<spring:eval expression="@brandseriesService.selectDictBrandseries(null,null,null)" var="brandList" />
							<form:select path="brand" onchange="selectSeriesList();">
								<form:option value="" label="选择品牌" />
								<c:forEach items="${brandList}" var="brand">
									<form:option value="${brand.name}" label="${brand.firstPinyin}-${brand.name}" />
								</c:forEach>
							</form:select>
						</li>
						<li class="width-250"><p>车牌号：</p><form:input path="license_code" maxlength="15" /></li>
						<li class="width-250"><p>车辆编号：</p><form:input path="code" maxlength="15" /></li>
						<li class="width-250">
							<p>拍卖类型：</p>
							<spring:eval expression="@autoDictionaryService.selectAuctionType()" var="auction_types" />
							<form:select path="type" onchange="bid.auctionTypesChange(this);">
								<form:option value="" label="选择类型" />
								<form:options items="${auction_types}" itemLabel="name" itemValue="value" />
							</form:select>
						</li>
						<li class="width-250">
							<p>拍卖状态：</p>
							<form:select path="status" name="status">
								<form:option value="">选择状态</form:option>
								<form:option value="2">拍卖成功</form:option>
								<form:option value="3">成交确认</form:option>
								<form:option value="4">流拍</form:option>
								<form:option value="5">正在拍</form:option>
								<form:option value="7">订单取消</form:option>
							</form:select></li>
						<li class="width-250" id="li_av_type" style="display:none">
							<p>拍品类型：</p>
							<spring:eval expression="@autoDictionaryService.selectResource('av_type')" var="av_types" />
							<form:select path="avType">
								<form:option value="" label="选择类型" />
								<form:options items="${av_types}" itemLabel="name" itemValue="value" />
							</form:select>
						</li>
						<li class="width-250"><p>竞拍区域：</p><form:input path="city" maxlength="15" /></li>
						<li class="width-250"><p>评估部门：</p><form:input path="evaluation_dept" maxlength="15" /></li>
						<li class="width-250"><p>发拍人：</p><form:input path="creatorName" maxlength="15" /><form:hidden path="creatorId"/></li>
						<li class="width-550">
							<p>拍卖时间：</p>
							<form:input path="startTimestamp" />
							<lable class="inp-label">至</lable>
							<form:input path="endTimestamp"/>
						</li>
					</ul>
				</form:form>
				<div class="query">
                	<shiro:hasPermission name="auct:bid:query"><a class="query_btn" id="search" onclick="">查询</a></shiro:hasPermission>
                	<shiro:hasPermission name="auct:bid:singleQuery"><a class="query_btn ml10" id="singleSearch" onclick="">单条查询</a></shiro:hasPermission>
                </div>
            </div>
        </div>
        <shiro:hasPermission name="auct:bid:transaction"><input onclick="bid.transactionAuction();" class="addbtn query_btn_2" type="submit" value="在线拍成交"></shiro:hasPermission>
       	<shiro:hasPermission name="auct:bid:fail"><input onclick="bid.failAuction();" class="addbtn query_btn_2" type="submit" value="车辆流拍"></shiro:hasPermission>
       	<shiro:hasPermission name="auct:bid:syncDeal"><input onclick="bid.syncDeal();" class="addbtn query_btn_2" type="submit" value="同步拍成交"></shiro:hasPermission>
<%--        	<shiro:hasPermission name="auct:bid:changeFinalPrice"><input onclick="getFinalPrice()" class="addbtn query_btn_2" type="submit" value="查看交易信息"></shiro:hasPermission> --%>
       	<div class="container_main">
        	<div class="wrap">
        		<table class="bk_table width_percent_100" id="datelist-1">
					<thead>
						<tr>
							<th style="width:4%;">
								<input type="checkbox" onclick="selectAll(this)">
							</th>
							<th style="width:8%">拍卖状态</th>
							<th style="width:8%;">拍卖类型</th>
							<th style="width:8%;">拍品类型</th>
							<th style="width:8%;">发拍人</th>
							<th style="width:12%;">品牌类型与编号</th>
							<th style="width:15%;">车辆信息</th>
							<th style="width:15%;">价格信息</th>
							<th style="width:30%;">出价记录</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.dataList}" var="bd">
							<tr class="eq">
								<td>
									<input type="checkbox" auction_type="${bd.auction_type}" auction_status="${bd.status}" id="subcheck" av_sid="${bd.id}" bidder_sid="${bd.bidder_sid}" vehicle_sid="${bd.vehicle_id}" auctionSid="${bd.auction_id}" name="subcheck" value="${bd.id},${bd.vehicle_id},${bd.auction_id},${bd.bidder_sid},${bd.auction_type},${bd.status}" vehicleModel="${bd.brand} ${bd.vehicle_model} ${bd.swept_volume_standard} ${bd.selled_name}" onclick="setSelectAll(this)" />
								</td>
								<td><c:if test="${bd.status=='0' }">待拍卖</c:if> <c:if test="${bd.status=='1' }">已上架</c:if> <c:if test="${bd.status=='2' }">拍卖成功</c:if>
									<c:if test="${bd.status=='3' }">成交确认</c:if> <c:if test="${bd.status=='4' }">流拍</c:if> <c:if test="${bd.status=='5' }">正在拍</c:if>
									<c:if test="${bd.status=='7' }">订单取消</c:if>
								</td>
								<td><c:if test="${bd.auction_type=='0' }">同步拍</c:if> <c:if test="${bd.auction_type=='1' }">在线拍</c:if><c:if test="${bd.auction_type=='2' }">即时拍</c:if></td>
								<td><c:if test="${bd.avType=='0' }">有底价</c:if> <c:if test="${bd.avType=='1' }">无底价</c:if></td>
								<td>
									<c:if test="${bd.avCreatedBy!=null}">
										<spring:eval expression="@userService.selectByPrimaryKey(${bd.avCreatedBy})" var="user"/>
										${user.name}
									</c:if>
								</td>
								<td><c:if test="${bd.source eq 'av' }"><img src="${ctx}/resources/auction/临时.png" style="vertical-align:middle;"></c:if>${bd.brand} ${bd.vehicle_model} ${bd.swept_volume_standard} ${bd.selled_name} ${bd.code}</td>
								<td>
									<table class="innerTable">
										<tr>
											<td>区域：</td>
											<td>${bd.city}</td>
										</tr>
										<tr>
											<td>车牌：</td>
											<td>${bd.license_code}</td>
										</tr>
										<tr>
											<td>排量：</td>
											<td>${bd.swept_volume}</td>
										</tr>
									</table>
								</td>
								<td>
									<table class="innerTable">
										<tr>
											<td>起拍价:</td>
											<td><strong style="color: green;">
											   <fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${bd.start_price/10000 }"></fmt:formatNumber>
											   </strong>万</td>
										</tr>
										<tr>
											<td>保留价:</td>
											<td><strong style="color: red">
											   <fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${bd.reserve_price/10000 }"></fmt:formatNumber>
											</strong>万</td>
										</tr>
										<tr>
											<td>加价幅度:</td>
											<td><strong style="color: green;">${bd.plus_range }</strong>元</td>
										</tr>
									</table>
								</td>
								<td>
									<div style="text-align: left">
									    <c:if test="${bd.status=='5'}">
									         <input type="hidden" name="isRefresh" value="${bd.id}">
									    </c:if>
										<p style="font-weight: bold">
											以下是出价记录，共 <strong style="color: red;font-size:16px;" title="bid_quantity"> ${bd.bid_quantity} </strong> 次出价记录
											<c:if test="${bd.status=='5' || bd.bid_quantity > 2  }">
											   <a href="#" onclick="javascript:getMoreBidInfo('${bd.id}', ${bd.status })">更多</a>
											</c:if>
											<c:if test="${bd.source ne 'av' }">
										    <a href="javaScript:;" onclick="preview(this, ${bd.auction_type},${bd.status},'${bd.id}','${bd.auction_id}','${bd.vehicle_id}')" style="font-size:16px" target="_blank">预 览</a>
										    </c:if>
										</p>
										<div title="bid_record_items">
											<c:forEach items="${bd.bidList}" var="bidder" varStatus="bid_price_index">
												<p id="bidder_name${bd.id}" style="text-indent: 24px">
													<fmt:formatDate value="${bidder.bid_timestamp }" pattern="yyyy-MM-dd HH:mm:ss" />
													<span style="margin: 0 1em;">${bidder.bidder_name }</span>
													<c:if test="${bid_price_index.index == 0 }">
	                                                        <strong style="color: red;font-size:16px;">
	                                                      </c:if>
	                                                      <c:if test="${bid_price_index.index != 0 }">
	                                                        <strong style="color: red;">
	                                                      </c:if>
														  <fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${bidder.price }"></fmt:formatNumber>
														</strong>元
												</p>
											</c:forEach>
										</div>
							       </div>
							       <input type="hidden" name="maxPriceName" id="maxPriceName${bd.id}" value="${bd.maxPriceName}" />
							       <input type="hidden" name="maxPrice" id="maxPrice${bd.id}" value="${bd.maxPrice}" />
							       <input type="hidden" name="vechile_code" id="vechile_code" value="${bd.code}" />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${pagination!=null}">
					<c:if test = "${pagination.count >10 }">
						<div class="pagination fr">
						<div id="kkpager"></div>
					</c:if>
					</div>
				</c:if>
        	</div>
        </div>
    </div>
</div>

<style>
.wd{width:90px;}
</style>

<div id="featureItemDiv" class="UED_hide">
    <div class="pop_box" style="width: 450px;">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">在线拍成交<span id="_titleSpan"></span></h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box" style="width: 450px;max-height: 500px;overflow: auto">
			<form id="onlineDealForm" data-validate="true" method="post" >
				<ul class="s_form" style="padding: 0px 22px 0;">
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">成交车辆：</label>
					    <label style="cursor: default;" id="vehicleModel">丰田威驰1.3手动GL</label>
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*竞得人：</label>
						<input type="text" name="memberName" id="memberName" maxlength="11">
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*车辆成交价：</label>
					    <input type="text" id="dealVehiclePrice" name="dealVehiclePrice" maxlength="11" onchange="changePrice('featureItemDiv')">
					    <label>元</label>
					    <input type="button" style="height: 25px;width: 70px;" value="计算佣金" onclick="calcCommissionFee('featureItemDiv')" />
					    <input type="hidden" id="commionRate" />
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*佣金：</label>
					    <input type="text" id="buyerCommissionFee" name="buyerCommissionFee" maxlength="10" onchange="changePrice('featureItemDiv')">
					    <label>元</label>
					    <label id="buyerCommissionFeeLabel" style="color:red;cursor: default;"></label>
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*办证费：</label>
					    <input type="radio" checked="checked" name="licenseFeeType" value="1" onchange="changeLicenseFeeType(this,'featureItemDiv')" />汽车街代办
					    <input type="radio" name="licenseFeeType" value="2" onchange="changeLicenseFeeType(this,'featureItemDiv')" />买家自理<br>
					</li>
					<li class="lay-price-input" style="clear: both;" id="licenseFeeLi">
					    <label style="cursor: default;" class="wd">&nbsp;&nbsp;&nbsp;&nbsp;</label>
					    <input type="text" id="licenseFee" name="licenseFee" maxlength="10" onchange="changePrice('featureItemDiv')">元
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*出库费：</label>
					    <input type="text" id="exWarehouseFee" name="exWarehouseFee" maxlength="10" onchange="changePrice('featureItemDiv')">元
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">总金额：</label>
					    <label style="cursor: default;" id="totalPrice">0</label>元
					</li>
				</ul>
				<p align="center" class="controlbox" style="margin-top: 0px;">
					<input id="offlineDealFormBtn" type="button" class="button_lv4_1" value="保存" onclick="bid.choiceFeatureItems('v');"/>
					<input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
				</p>
			</form>
        </div>
    </div>
</div>

<div id="changeFinalPriceDiv" class="UED_hide">
	<div class="pop_box" style="width: 800; height: 600">
		<div class="pop_tittle">
			<h3 id="UED_layer_h3_v31">查看交易信息</h3>
			<a href="javascript:void 0" onclick="$.LAYER.close();" class="close"></a>
		</div>
		<div class="s_box">
			<table>
				<tr>
					<td style="text-align:right;">买家姓名：</td><td class="buyer_name" style="text-align:left;"></td>
					<td style="text-align:right;">卖家姓名：</td><td class="seller_name" style="text-align:left;"></td>
				</tr>
				<tr>
					<td style="text-align:right;">买家联系方式：</td><td class="buyer_phone" style="text-align:left;"></td>
					<td style="text-align:right;">卖家联系方式：</td><td class="seller_phone" style="text-align:left;"></td>
				</tr>
			</table>
			<p align="center" class="btn-box">
				<input type="button" style="float: none;" class="button_lv4_1" value="追价" onclick="changeFinalPrice()" />
				<input type="button" style="float: none;" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
			</p>
		</div>
	</div>
</div>

<div id="offlineDeal" class="UED_hide">
    <div class="pop_box" style="width: 450px;">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">同步拍成交<span id="_titleSpan"></span></h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box" style="width: 450px;max-height: 500px;overflow: auto" id="offlineDealBox">
			<form id="offlineDealForm" data-validate="true" method="post" >
				<ul class="s_form" style="padding: 0px 22px 0;">
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*手机号：</label>
						<input type="text" name="buyerCellphone" id="memberCellPhone" maxlength="11">
						<input type="button" value="查询" onclick="bid.loadOfflinePayMember()" />
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*成交人：</label>
					    <input type="text" id="memberName" name="bidderName" maxlength="20">
					    <label style="cursor: default;">用户类型:</label>
					    <label style="cursor: default;" id="memberType"></label>
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*成交车价：</label>
					    <input type="text" id="dealVehiclePrice" name="dealVehiclePrice" maxlength="11" onchange="changePrice('offlineDeal')">
					    <label>元</label>
					    <input type="button" style="height: 25px;width: 70px;" value="计算佣金" onclick="calcCommissionFee('offlineDeal')" />
					    <input type="hidden" id="commionRate" />
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">当前最高出价：</label>
					    <label style="cursor: default;" id="maxBidPrice">1000元</label>
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*佣金：</label>
					    <input type="text" id="buyerCommissionFee" name="buyerCommissionFee" maxlength="10" onchange="changePrice('offlineDeal')">
					    <label>元</label>
					    <label id="buyerCommissionFeeLabel" style="color:red;cursor: default;"></label>
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*办证费：</label>
					    <input type="radio" checked="checked" name="licenseFeeType" value="1" onchange="changeLicenseFeeType(this,'offlineDeal')" />汽车街代办
					    <input type="radio" name="licenseFeeType" value="2" onchange="changeLicenseFeeType(this,'offlineDeal')" />买家自理<br>
					</li>
					<li class="lay-price-input" style="clear: both;" id="licenseFeeLi">
					    <label style="cursor: default;" class="wd">&nbsp;&nbsp;&nbsp;&nbsp;</label>
					    <input type="text" id="licenseFee" name="licenseFee" maxlength="10" onchange="changePrice('offlineDeal')">元
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">*出库费：</label>
					    <input type="text" id="exWarehouseFee" name="exWarehouseFee" maxlength="10" onchange="changePrice('offlineDeal')">元
					</li>
					<li class="lay-price-input" style="clear: both;">
					    <label style="cursor: default;" class="wd">总金额：</label>
					    <label style="cursor: default;" id="totalPrice">0</label>元
					</li>
				</ul>
				<p align="center" class="controlbox" style="margin-top: 0px;">
					<input id="offlineDealFormBtn" type="button" class="button_lv4_1" value="保存" onclick="bid.syncOfflineDealSubmit()"/>
					<input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
				</p>
			</form>
        </div>
    </div>
</div>

<jsp:include page="more-bid-info.jsp"></jsp:include>
	<script type="text/javascript">
	$(function(){
	    common.showDateTimePicker("#startTimestamp");
	    common.showDateTimePicker("#endTimestamp");
		var val=$("#type").val();
		if (val=="1") {
			$("#avType").attr("disabled",false);
			$("#li_av_type").show();
		}else{
			$("#avType").attr("disabled",true);
			$("#li_av_type").hide();
		}
		kkpager.generPageHtml({
		    pno : '${pagination.current}',
		    //总页码
		    total : '${pagination.total}',
		    //总数据条数
		    totalRecords : '${pagination.count}',
		    //链接前部
		    hrefFormer : '${ctx}/bid/query',
		    //链接算法
		    getLink : function(n){
		        var queryString = $('#bidForm').serialize(); 
		        return this.hrefFormer + this.hrefLatter + "?current=" + n + "&" + queryString;
		    }
		});
	});
	
	function changeLicenseFeeType(obj,divId){
	    if($(obj).val()=="1"){
	        $("#"+divId+" #licenseFeeLi").show();
	        $("#"+divId+" #licenseFee").val("0");
	    }else{
	        $("#"+divId+" #licenseFeeLi").hide();
	        $("#"+divId+" #licenseFee").val("0");
	    }
	    changePrice(divId);
	}
	
	function calcCommissionFee(divId){
	    if($("#"+divId+" #commionRate").val()){
	        if($.isNumeric($("#"+divId+" #dealVehiclePrice").val())){
		    	$("#"+divId+" #buyerCommissionFee").val((parseFloat($("#"+divId+" #dealVehiclePrice").val())*parseFloat($("#"+divId+" #commionRate").val())/100).toFixed(2));
	        }else{
	            $("#"+divId+" #buyerCommissionFee").val("");
	        }
	    }
	    changePrice(divId);
	}
	
	function changePrice(divId){
	    var totalPrice=(strToNum($("#"+divId+" #dealVehiclePrice").val())+strToNum($("#"+divId+" #buyerCommissionFee").val())
	            +strToNum($("#"+divId+" #licenseFee").val())+strToNum($("#"+divId+" #exWarehouseFee").val()));
	    $("#"+divId+" #totalPrice").html($.isNumeric(totalPrice)?common.formatMoney(totalPrice,2):0);
	}
	
	function strToNum(str){
	    if(str){
	        if($.isNumeric(str)){
	            return parseFloat(str);
	        }
	    }
	    return 0; 
	}
	
	function getMoreBidInfo(avSid, status) {
		findBidByAvId(avSid);
	    $.LAYER.show({
	        id : "moreBidInfoDiv"
	    });
	}
	
	function findBidByAvId(avSid) {
		var bid_record_items = $("#bid_record_items").empty();
		$.get("${ctx}/bid/findBidByAvId", {avSid : avSid}, function(data){
			if (data || data.length > 0) {
				$("#bid_record_count").html(data.length);
				$(data).each(function(index, obj) {
					var item = '<p style="text-indent: 24px;">' + obj.bid_timestamp +'<span style="margin: 0 2em;">'+ obj.bidder_name
					 + '</span><strong style="color: red;">' + obj.price + '</strong>元 </p>';
					bid_record_items.append(item);
				});
			}
        });
    }
	
function loadFeatureItems(){
    var arrChks=$("input[name='subcheck']:checked");
    var size = arrChks.length;
    if(size>1){
    	window.alert("只能选择一条记录，不能多选几条记录");
    	return false;
    } else if (size == 0) {
    	window.alert("最少选择一条记录");
        return false;
    }
    var arr = new Array();
    var sidValue = arrChks[0].value; 
    arr =   sidValue.split(",");
    
    var av_Id        =  arr[0];//拍品ID
    //var vehicle_sid   =  arr[1];//车辆ID
    //var auction_sid   =  arr[2];//拍卖会ID
    //var bidder_sid    =  arr[3];//竞价人ID
    //var auction_type  =  arr[4];//竞拍类型
    var auction_status = arr[5];//竞拍状态
    var vehicleModel=$(arrChks[0]).attr("vehicleModel");
    bidName = $("#maxPriceName"+av_Id).val();//竞拍最高价对应的竞拍人
    bidPrice = $("#maxPrice"+av_Id).val();//竞拍最高价
    if(auction_status !=3){
    	window.alert("注意!非成交确认的车辆不能成交");
    	return false;
    } 
    $.ajax({
        type : "post",
        dataType : "json",
        url : ctx+"/bid/queryMaxPrice",
        data : {
            avId : av_Id
        },
        success : function(data) {
            $.ajax({
                url:ctx+"/bid/getAuctionVehicle",
                data:{
                    auctionVehicleId:av_Id
                },
                success:function(result){
                    $("#vehicleModel").html(vehicleModel);
                    if(bidName!=null || bidName!="" ){
                    	$("#featureItemDiv #memberName").val(bidName); 
                    }
                    if(bidPrice!=null || bidPrice!="" ){
                    	$("#featureItemDiv #dealVehiclePrice").val(bidPrice); 
                    }
                    var auctionVehicle=result.data;
                    if(auctionVehicle.buyerCommissionRate){
                        if(auctionVehicle.buyerCommissionRate==0){
                            $("#featureItemDiv #buyerCommissionFeeLabel").html("佣金：0元");
                        }else{
	                        $("#featureItemDiv #buyerCommissionFeeLabel").html("佣金率："+auctionVehicle.buyerCommissionRate+"%");
                        }
	                    $("#featureItemDiv #buyerCommissionFee").val((parseFloat(bidPrice)*parseFloat(auctionVehicle.buyerCommissionRate)/100).toFixed(2));
	                    $("#featureItemDiv #commionRate").val(auctionVehicle.buyerCommissionRate);
                    }else if(auctionVehicle.buyerFixedCommission){
                        $("#featureItemDiv #buyerCommissionFeeLabel").html("佣金："+parseFloat(auctionVehicle.buyerFixedCommission).toFixed(0)+"元");
	                    $("#featureItemDiv #buyerCommissionFee").val(auctionVehicle.buyerFixedCommission.toFixed(2));
                        $("#offlineDeal #commionRate").val("");
                    }else{
                        $("#featureItemDiv #buyerCommissionFeeLabel").html("");
                        $("#featureItemDiv #buyerCommissionFee").val("0.00");
                        $("#offlineDeal #commionRate").val("");
                    }
                    $("#featureItemDiv #exWarehouseFee").val(auctionVehicle.exWarehouseFee?auctionVehicle.exWarehouseFee.toFixed(2):"0.00");
                    if(auctionVehicle.licenseFee){
	                    $("#featureItemDiv #licenseFee").val(auctionVehicle.licenseFee?auctionVehicle.licenseFee.toFixed(2):"0.00");
                        $("#featureItemDiv #licenseFeeLi").show();
                    }else{
                        $("#featureItemDiv [name=licenseFeeType]").get(1).checked="checked";
                        $("#featureItemDiv #licenseFee").val("0.00");
                        $("#featureItemDiv #licenseFeeLi").hide();
                    }
                    changePrice("featureItemDiv");
                    $.LAYER.show({id:"featureItemDiv"});
                }
            })
        }
    });
};

function preview(dom, auction_type,status,avId,auctionId,vehicleId){
	var auction_type_target = null;
	if(auction_type==0){
		auction_type_target = "auction";
		//window.alert("注意!同步拍不支持车辆浏览，目前只支持在线拍车辆浏览");
		$(dom).attr("href", "http://auction.autostreets.com/"+auction_type_target+"/"+auctionId+"/vehicle/"+vehicleId);
    	return false;
	}else if(auction_type==1){
		auction_type_target = "onlineauction";
		$(dom).attr("href", "http://auction.autostreets.com/"+auction_type_target+"/"+avId);
	}else if(auction_type==2){//即时拍
		auction_type_target = "onceBidAuction";
		$(dom).attr("href", "http://auction.autostreets.com/"+auction_type_target+"/"+avId);
	}
	
}

function getBidName(){
	 bidName = $("#bidname").val();//竞拍最高价
     bidPrice = $("#transc_price").val();//竞拍最高价对应的竞拍人
}

function getBidPrice(){
	 bidName = $("#bidname").val();//竞拍最高价
     bidPrice = $("#transc_price").val();//竞拍最高价对应的竞拍人
}

$("#bidForm").keydown(function(e){
    var e = e || event,
    keycode = e.which || e.keyCode;
    if (keycode==13) {
    	$("#search").trigger("click");
    }
});

$(function(){
	$("#search").click(function(e){
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
    	//验证发拍人是否存在
    	var isExistName = true;
    	if($.trim($("#creatorName").val()) != ""){
    		$.ajax({
    			url:"${ctx}/bid/isExistName",
    			type:"get",
    			async:false,
    			dataType:"json",
    			data:{creatorName:$("#creatorName").val()
    				},
    			success:function(result){
    					if(!result.success){
    						alert("发拍人不存在！");
    						isExistName = false;
    						return;
    					}else{
    						$("#creatorId").val(result.data);
    					}
    				}	
    		});
    	}else{
    		$("#creatorId").val("");
    	}
    	if(!isExistName){
    		return;
    	}
    	$('#bidForm').submit();
	});
	
	$("#singleSearch").click(function(e){
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
    	//验证发拍人是否存在
    	var isExistName = true;
    	if($.trim($("#creatorName").val()) != ""){
    		$.ajax({
    			url:"${ctx}/bid/isExistName",
    			type:"get",
    			async:false,
    			dataType:"json",
    			data:{creatorName:$("#creatorName").val()
    				},
    			success:function(result){
    					if(!result.success){
    						alert("发拍人不存在！");
    						isExistName = false;
    						return;
    					}else{
    						$("#creatorId").val(result.data);
    					}
    				}	
    		});
    	}else{
    		$("#creatorId").val("");
    	}
    	if(!isExistName){
    		return;
    	}
    	var actionUrl = "${ctx}/bid/singleQuery";
        $("#bidForm").attr("action", actionUrl);
    	$('#bidForm').submit();
	});
	
	
});

function getFinalPrice(){
	var arrChks=$("input[name='subcheck']:checked");
	var size = arrChks.length;
    if(size>1){
    	window.alert("只能选择一条记录，不能多选几条记录");
    	return false;
    } else if (size == 0) {
    	window.alert("最少选择一条记录");
        return false;
    }
    
    var arr = new Array();
    var sidValue = arrChks[0].value;
    arr =   sidValue.split(",");
    var av_Id   =  arr[0];//拍品ID
    var vehicleId=arr[1];//车辆id
    $.ajax({
    	url:"${ctx}/bid/getAvMaxPriceBidder",
    	type:"get",
    	data:{avId:av_Id,vehicleId:vehicleId},
    	dataType:"json",
    	success:function(ret){
    		if(ret.success){
    			  $(".buyer_name").text(ret.data.buyerName);
    			  $(".buyer_phone").text(ret.data.buyerPhone);
    			  $(".seller_name").text(ret.data.sellerName);
    			  $(".seller_phone").text(ret.data.sellerPhone);
    			  $.LAYER.show({
    			        id : "changeFinalPriceDiv"
    			    });
    		}else{
				alert(ret.msg||'请求异常');    			
    		}
    	},
    	error:function(){
    		alert("请求失败");
    	}
    });
}

function changeFinalPrice(){
	var arrChks=$("input[name='subcheck']:checked");
	var size = arrChks.length;
    if(size>1){
    	window.alert("只能选择一条记录，不能多选几条记录");
    	return false;
    } else if (size == 0) {
    	window.alert("最少选择一条记录");
        return false;
    }
    
    var arr = new Array();
    var sidValue = arrChks[0].value; 
    arr =   sidValue.split(",");
    var av_Id   =  arr[0];//拍品ID
    
    $.ajax({
    	url:"${ctx}/bid/updateFinalPriceStatus",
    	type:"post",
    	data:{avId:av_Id},
    	dataType:"json",
    	success:function(ret){
    		if(ret.success){
    			alert(ret.msg||'保存成功');
    		}else{
				alert(ret.msg||'请求异常');    			
    		}
    	},
    	error:function(){
    		alert("请求失败");
    	}
    });
}
</script>
</body>
</html>