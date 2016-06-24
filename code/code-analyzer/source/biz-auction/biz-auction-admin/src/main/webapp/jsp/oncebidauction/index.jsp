<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<title>暗拍预约</title>
<style>
	#track-text{
		width: 380px;
	    margin: 0 8px;
	    border: solid #ddd 1px;
	    border-radius: 3px;
	    min-height: 100px;
	    padding: 0;
	}
	.track-tips{
		padding-left:8px;
		color:#666;
		font-size:13px;
		margin:5px 0;
	}
	
	#track-history-tab{
		width:780px;
		margin:auto;
	}
	#track-history-tab tr{
		border-bottom:dotted #ddd 1px;
	}
	#track-history-tab th,td{
		padding:8px;
		text-align:center;
	}
	#track-history-box .s_box{
		background:#fff;
		padding-bottom:20px;
	}
	.left-text{
	   text-align: left!important;
	}
	#saveTrackInfo{
		float:none;
	}
</style>
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
					<form:form id="onceBidForm" method="post" commandName="auctionVehicle" modelAttribute="auctionVehicle" action="${ctx}/oncebidauction/index">
						<ul class="filter sa-sreach-list">
	                        <li class="width-250" style="width:216px!important;">
								<p>拍卖时间：</p>
								<form:input path="startTimestamp" class="input-120" />
							</li>
							<li>至：</li>
	                        <li class="width-250">
								<form:input path="endTimestamp" class="input-120" />
							</li>
						</ul>
					</form:form>
	                <div class="query">
	                	<a id="search" class="query_btn" onclick="">查询</a>
	                </div>
	           </div>
	        </div>
	         <div class="container_main">
        	<div class="wrap">
		        <table class="datelist-1">
					<thead>
						<tr>
					    <th width="150px">操作</th>
						<th>拍卖状态</th>
						<th>拍卖类型</th>
						<th width="150px">结束时间</th>
						<th>品牌类型与编号</th>
						<th>买家信息</th>
						<th>卖家信息</th>
						<th>次高价格</th>
						<th>客服跟踪</th>
						</tr>
					</thead>
					<tbody>
							<c:forEach items="${pagination.dataList}" var="data">
									<spring:eval expression="@vehicleService.selectVehicleByCode(data.code)" var="vehicleInfo" />
									<spring:eval expression="@bidService.getSecondPrice(data.id)" var="bidInfo" />
									<spring:eval expression="@bidService.getMaxPriceBidder(data.id)" var="maxBidInfo" />
								<tr class="eq">
									<td>
										<c:if test = "${maxBidInfo != null}">
											<a href="javascript:void(0);" onclick="changeStatus('${data.id}','success');" style="margin:0 0;">拍卖成功</a>
										</c:if>
										<a href="javascript:void(0);" onclick="changeStatus('${data.id}','fail');" style="margin:0 0;">流拍</a>
										<a href="javascript:void(0);" onclick="trackinfo('${data.id}');" style="margin:0 0;">客服跟踪</a>
									</td>
									<td>
										<c:if test="${data.status eq 3 }">
											成交确认
										</c:if>
									</td>
									<td>
										<c:if test="${data.auctionType eq 2 }">
											即时拍
										</c:if>
									</td>
									<td>
										<fmt:formatDate value="${data.onlineEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
										${data.brand}&nbsp;${data.vehicleModel}&nbsp;${data.selledName}<br>
										${data.avNo}
									</td>
									<c:choose>
										<c:when test="${maxBidInfo != null }">
											<spring:eval expression="@memberService.selectByPrimaryKey(maxBidInfo.bidderSid)" var="memberInfo" />
											<td>
												${memberInfo.username}&nbsp;${memberInfo.cellphone}
											</td>
										</c:when>
										<c:otherwise>
											<td></td>
										</c:otherwise>
									</c:choose>
									<td>
										${vehicleInfo.custName}&nbsp;${vehicleInfo.custPhone}
									</td>
									<td>
										${bidInfo.price}
									</td> 
									<td>
										<a href="javascript:;" class="history-track-info" data-id="${data.id}">跟踪历史</a>
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


<div id="track-box" class="UED_hide" >
	   <div class="pop_box" style="width:400px;">
	       <div class="pop_tittle">
	       <h3 id="UED_layer_h3_v31">
             <span>客服跟踪</span>
          </h3>
	          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
	        </div> 
		  <div class="s_box">
		  		 <div>
		  		 	<p class="track-tips">请输入跟踪内容：</p>
		  		 	<input id="track-id" type="hidden"/>
		  		 	<textarea id="track-text"></textarea>
					<p class="track-tips" style="font-size:12px;color:#888;">提示：最多输入100个字符。</p>
		  		 </div>
			     <p align="center" class="controlbox">
		              <input type="button" class="button_lv4_1" value="确定" id="saveTrackInfo" style="margin-top:8px;">
			      </p>
		  </div>
	  </div>
</div>

<div id="track-history-box" class="UED_hide">
	   <div class="pop_box" style="width:800px;">
	       <div class="pop_tittle">
	       <h3 id="UED_layer_h3_v31">
             <span>客服跟踪历史</span>
          </h3>
	          <a href="javascript:void(0);" onclick="$.LAYER.close('track-history-box');" class="close"></a>
	        </div> 
		  <div class="s_box">
		  		<table id="track-history-tab" >
		  			<thead>
		  				<tr>
		  					<th style="width: 330px;">跟踪内容</th>
		  					<th>记录人</th>
		  					<th>记录时间</th>
		  				</tr>
		  			</thead>
		  			<tbody>
		  			</tbody>
		  		</table>
		  </div>
	  </div>
</div>

<script type="text/javascript" src="${ctx}/resources/auction/all.js"></script>
<script>
function changeStatus(id,op){
    $.ajax({
        url:"${ctx}/oncebidauction/changeStatus",
        data:{
            id:id,
            op:op
        },
        success:function(data){
            if(data){
                alert(data.msg);
                location.reload();
            }
        }
    });
}

function trackinfo(id){
	$("#track-text").empty();
	$("#track-id").val(id);
	$("#track-box .history-track-info").attr("data-id",id);
	 $.LAYER.show({id : "track-box"});
}
$("#saveTrackInfo").click(function(){
	var trackInfo = $("#track-text").val().trim();
	if(trackInfo==''){
		alert('请输入跟踪内容！');
	}else if(trackInfo.length>100){
		alert('跟踪内容长度超出限制！');
	}else{
		$.ajax({
			type:"post",
	        url:"${ctx}/oncebidauction/saveTrackInfo",
	        data:{
	            id:$("#track-id").val(),
	            trackInfo:trackInfo
	        },
	        success:function(resp){
	            if(resp.success){
	                alert("保存成功");
	                location.reload();
	            }else{
	            	alert(resp.msg);
	            }
	        }
	 	});
	}
});

$(".history-track-info").click(function(){
	$("#track-history-tab tbody").empty();
	var id = $(this).attr('data-id');
	if(id){
		$.ajax({
			type:"get",
	        url:"${ctx}/oncebidauction/getTrackInfo",
	        data:{
	            id:id
	        },
	        success:function(resp){
	            if(resp.success){
	            	var data = resp.data;
	            	$(data).each(function(i,e){
	            		$("#track-history-tab tbody").append("<tr><td class='left-text'>"+e.remark+"</td><td>"+e.userName+"</td><td>"+new Date(e.createdTime).format('yyyy-MM-dd hh:mm:ss')+"</td></tr>");
	            	});
	            	$.LAYER.show({id : "track-history-box"});
	            }else{
	            	alert(resp.msg);
	            }
	        }
	 	});
	}
});

Date.prototype.format = function(format){ 
	var o = { 
	"M+" : this.getMonth()+1, //month 
	"d+" : this.getDate(), //day 
	"h+" : this.getHours(), //hour 
	"m+" : this.getMinutes(), //minute 
	"s+" : this.getSeconds(), //second 
	"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
	"S" : this.getMilliseconds() //millisecond 
	} 

	if(/(y+)/.test(format)) { 
	format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 

	for(var k in o) { 
	if(new RegExp("("+ k +")").test(format)) { 
	format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
	} 
	} 
	return format; 
	} 
	
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
    	$('#onceBidForm').submit();
	});
	
});
</script>
</body>
</html>