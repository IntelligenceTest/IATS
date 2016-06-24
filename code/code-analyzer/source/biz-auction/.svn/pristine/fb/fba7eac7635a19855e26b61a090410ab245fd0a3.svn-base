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
	            <li><shiro:hasPermission name="auct:bid:v_model"><a href="${ctx}/bid/query">车辆模式</a></shiro:hasPermission></li>
				<li class="cur"><a href="javascript:void(0);">出价模式</a></li>
			</ul>
   			<div class="container_top">
				<form:form action="${ctx}/bid/querybid" method="post" commandName="bid" id="bidForm">
					<ul class="filter sa-sreach-list">
						<li class="width-250">
							<p>品牌：</p>
							<spring:eval expression="@brandseriesService.selectDictBrandseries(null,null,null)" var="brandList" />
							<form:select path="brand">
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
							</form:select>
						</li>
						<li class="width-250" id="li_av_type" style="display:none">
							<p>拍品类型：</p>
							<spring:eval expression="@autoDictionaryService.selectResource('av_type')" var="av_types" />
							<form:select path="avType" >
								<form:option value="" label="选择类型" />
								<form:options items="${av_types}" itemLabel="name" itemValue="value" />
							</form:select>
						</li>
						<li class="width-250"><p>竞拍区域：</p><form:input path="city" maxlength="15" /></li>
						<li class="width-250"><p>评估部门：</p><form:input path="evaluation_dept" maxlength="15" /></li>
						<li class="width-250"><p>发拍人：</p><form:input path="creatorName" maxlength="15" /><form:hidden path="creatorId"/></li>
						<li class="width-600">
							<p>拍卖时间：</p>
							<form:input path="startTimestamp" />
							<label class="inp-label">至</label>
							<form:input path="endTimestamp"/>
						</li>
					</ul>
				</form:form>
				<div class="query">
                	<shiro:hasPermission name="auct:bid:query"><a class="query_btn" onclick="" id="search">查询</a></shiro:hasPermission>
                </div>
            </div>
	    </div>
        <shiro:hasPermission name="auct:bid:transaction">
        	<input onclick="bid.transactionAuction();" class="addbtn query_btn_2" type="submit" value="车辆成交">
        </shiro:hasPermission>
        <shiro:hasPermission name="auct:bid:fail">	
       		<input onclick="bid.failAuction();" class="addbtn query_btn_2" type="submit" value="车辆流拍">
       	</shiro:hasPermission>
       	<div class="container_main">
        	<div class="wrap">
        		<table class="bk_table width_percent_100" id="datelist-1" style="width:1500px;">
					<thead>
						<tr>
							<th style="width: 10px">
								<input type="checkbox" onclick="selectAll(this)">
							</th>
							<th style="width: 70px">预览</th>
							<th style="width: 50px">拍卖类型</th>
							<th style="width: 50px">拍品类型</th>
							<th style="width: 50px">拍卖状态</th>
							<th style="width: 120px">车辆品牌车系</th>
							<th style="width: 75px">车牌号</th>
							<th style="width: 70px">出价人</th>
							<th style="width: 30px">起拍价</th>
							<th style="width: 40px">保留价</th>
							<th style="width: 20px">当前出价</th>
							<th style="width: 40px">加价幅度</th>
							<th style="width: 60px">车辆位置</th>
							<th style="width: 80px">出价时间</th>
							<th style="width: 25px">IP</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.dataList}" var="bd">
							<tr class="eq">
								<td><input type="checkbox" auction_type="${bd.auction_type}" auction_status="${bd.status}" id="subcheck" av_sid="${bd.id}"
									bidder_sid="${bd.bidder_sid}" vehicle_sid="${bd.vehicle_id}" auctionSid="${bd.auction_id}" name="subcheck"
									value="${bd.id},${bd.vehicle_id},${bd.auction_id},${bd.bidder_sid},${bd.auction_type},${bd.status}"
									onclick="setSelectAll(this)" />
								</td>
									<td><c:if test="${bd.source ne 'av'}"><a href="#" class="preview" target="_blank">预览</a></c:if><input type="hidden" class="preview_1"
									value="${bd.auction_type},${bd.status},${bd.id},${bd.auction_id},${bd.vehicle_id}"></td>
								<td><c:if test="${bd.auction_type=='0' }">同步拍</c:if> <c:if test="${bd.auction_type=='1' }">在线拍</c:if><c:if test="${bd.auction_type=='2' }">即时拍</c:if></td>
								<td><c:if test="${bd.avType=='0' }">有底价</c:if> <c:if test="${bd.avType=='1' }">无底价</c:if></td>
								<td><c:if test="${bd.status=='0' }">待拍卖</c:if> <c:if test="${bd.status=='1' }">已上架</c:if> <c:if test="${bd.status=='2' }">拍卖成功</c:if>
									<c:if test="${bd.status=='3' }">成交确认</c:if> <c:if test="${bd.status=='4' }">流拍</c:if> <c:if test="${bd.status=='5' }">正在拍</c:if>
									<c:if test="${bd.status=='7' }">订单取消</c:if>
								</td>
								<td><c:if test="${bd.source eq 'av' }"><img src="${ctx}/resources/auction/临时.png" style="vertical-align:middle;"></c:if>${bd.brand} ${bd.vehicle_model} ${bd.brand_series}</td>
								<td>${bd.license_code}</td>
								<td>${bd.bidder_name}</td>
								<td>
									<c:if test="${not empty bd.start_price}">
										<strong style="color: green;">
										<fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${bd.start_price/10000 }"></fmt:formatNumber>
										</strong>万
									</c:if>
								</td>
								<td>
									<c:if test="${not empty bd.reserve_price}">
										<strong style="color: red">
										<fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${bd.reserve_price/10000 }"></fmt:formatNumber>
										</strong>万
									</c:if>
								</td>
								<td>
									<c:if test="${not empty bd.price}">
										<strong style="color: red">
										<fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${bd.price/10000 }"></fmt:formatNumber>
										</strong>万
									</c:if>
								</td>
								<td><strong style="color: red">${bd.plus_range }</strong>元</td>
								<td>${bd.city }</td>
								<td><fmt:formatDate value="${bd.bid_timestamp }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td><strong style="color: blue;">${bd.ip }</strong></td>
								<input type="hidden" name="maxPriceName" id="maxPriceName${bd.id}" value="${bd.maxPriceName}" />
								<input type="hidden" name="maxPrice" id="maxPrice${bd.id}" value="${bd.maxPrice}" />
								<input type="hidden" name="vechile_code" id="vechile_code" value="${bd.code}" />
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
	<div id="featureItemDiv" class="UED_hide">
		<div class="pop_box" style="width: 800; height: 600">
			<div>
				<a href="javascript:void 0" onclick="$.LAYER.close();" class="close"></a>
			</div>
			<div class="pop_mainbox">
				<h3 id="UED_layer_h3_v31" style="color: #F2683E;">车辆编号1 将被下面会员竞得</h3>
				<table>
					<ul class="s_form">
						<li><label>竞得人：</label>
							<input type="text" readonly="readonly" name="bidname" onblur="getBidName();" id="bidname" value="" style="width: 138px" />
						<li>
					</ul>
					<ul class="s_form">
						<li>
							<label>成交价：</label>
							<input type="text" readonly="readonly" name="transc_price" id="transc_price" value="" onblur="getBidPrice();" style="width: 138px" />
							<label> 元</label>
						</li>
					</ul>
				</table>
				<p align="center" class="btn-box">
					<input type="button" style="float: none;" class="button_lv4_1" value="确定" onclick="bid.choiceFeatureItems('q');" />
					<input type="button" style="float: none;" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
				</p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//确定拍品类型是否显示
		$(function(){
		    common.showDateTimePicker("#startTimestamp");
		    common.showDateTimePicker("#endTimestamp");
			var val=$("#type").val();
			if (val=="1") {
				$("#avType").attr("disabled",false);
				$("#li_av_type").show();
			}else{
				$("#av_type").attr("disabled",true);
				$("#li_av_type").hide();
			}
			kkpager.generPageHtml({
			    pno : '${pagination.current}',
			    //总页码
			    total : '${pagination.total}',
			    //总数据条数
			    totalRecords : '${pagination.count}',
			    //链接前部
			    hrefFormer : '${ctx}/bid/querybid',
			    //链接算法
			    getLink : function(n){
			        var queryString = $('#bidForm').serialize(); 
			        return this.hrefFormer + this.hrefLatter + "?current=" + n + "&" + queryString;
			    }
			});
		});
		
		$(".preview").click(
				function() {
					var _preview = [];
					_preview = $(this).parent().find(".preview_1").val().split(
							",");
					var _auction = preview(_preview[0], _preview[1],
							_preview[2],_preview[3]);
					if(_auction){
						var _href = "http://auction.autostreets.com/" + _auction + "/";
						if(_preview[0]==0){
							_href+= _preview[4];
						}else{
							_href+= _preview[2];
						}
						$(this).attr("href", _href);
					}else{
						$(this).removeAttr("target");
					}
				});
		function preview(auctionType, status, avId,auctionId) {
			var auction_type_target = null;
			if (auctionType == 0) {
				auction_type_target = "auction";
				return auction_type_target="auction/"+auctionId+"/vehicle";
			} else if (auctionType == 1) {
				auction_type_target = "onlineauction";
			}else if(auctionType==2){//即时拍
				auction_type_target = "onceBidAuction";
			}
			return auction_type_target;
		}

		function loadFeatureItems() {
			var arrChks = $("input[name='subcheck']:checked");
			var size = arrChks.length;
			if (size > 1) {
				window.alert("只能选择一条记录，不能多选几条记录");
				return false;
			}
			var arr = new Array();
			var sidValue = arrChks[0].value;
			arr = sidValue.split(",");
			var av_sid = arr[0];//拍品ID
			var vehicle_sid = arr[1];//车辆ID
			var auction_sid = arr[2];//拍卖会ID
			var bidder_sid = arr[3];//竞价人ID
			var auction_type = arr[4];//竞拍类型
			var auction_status = arr[5];//竞拍状态
			if (auction_status != 3) {
				window.alert("注意!非成交确认的车辆不能成交");
				return false;
			}
			$.LAYER.show({
				id : "featureItemDiv"
			});
			if (bidName != null || bidName != "") {
				$("#bidname").val(bidName);
			}
			if (bidPrice != null || bidPrice != "") {
				$("#transc_price").val(bidPrice);
			}
			var vechile_code = $("#vechile_code").val();
			$("#featureItemDiv #UED_layer_h3_v31").text("车辆编号" + vechile_code + "将会被下面会员竞得");
		};

		function getBidName() {
			bidName = $("#bidname").val();//竞拍最高价
			bidPrice = $("#transc_price").val();//竞拍最高价对应的竞拍人
		}

		function getBidPrice() {
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
			
		});
	</script>
</body>
</html>