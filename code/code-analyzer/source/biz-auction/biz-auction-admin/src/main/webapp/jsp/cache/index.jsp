<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>二手车拍卖-缓存管理</title>
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
    	<div style="color: red;text-align: center;font-size: 13px;line-height: 25px;">
	    	notice:memcache删除缓存一秒钟延迟<br>
    		拍卖字典缓存:auct_类别<br>
    		车辆缓存:vehicle_detail_loadVehicleInfo_车辆id<br>
     		首页二手车推荐缓存:autostreets_index_getHomePageUsedcar<br>
     		首页缓存:autostreets_index_getHomePageDTO<br>
     		首页二手车品牌列表缓存:autostreets_index_usedCarBrandList<br>
     		搜索框全部品牌:autostreets_index_searchRepBrands<br>
     		首页搜索省份:autostreets_index_selectProvince<br>
     		首页二手车品牌列表:www_index_getnohagglebrandlist<br>
     		首页二手车城市列表:www_index_getnohagglecitylist<br>
     		www查价缓存：WWW_HOT_DEAL_PRICE<br>
    	</div>
    	<div style="width: 400px; float: left; padding:20px;">
    		<button id="collapse-btn1">折叠</button>
			<button id="expand-btn1">展开</button>
			<input id="key1" style="width: 200px;" />
			<button onclick="getMemCacheCache()">查询</button>
			<button onclick="deleteMemCacheCache()">删除</button>
			<div id="json1" style=""></div>
    	</div>
    	<div style="width: 400px; float: right; padding:20px;">
    		<!-- <button id="collapse-btn2">折叠</button>
			<button id="expand-btn2">展开</button> -->
			<input id="key2" style="width: 200px;" />
			<!-- <button onclick="getRedisCache()">查询</button> -->
			<button onclick="deleteRedisCache()">删除</button>
			<div id="json2" style=""></div>
    	</div>
    </div>
</div>
<link href="${ctx}/resources/jsonview/jquery.jsonview.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/resources/jsonview/jquery.jsonview.js"></script>
<script type="text/javascript">
$('#expand-btn1').on('click', function() {
    $('#json1').JSONView('expand');
});
$('#collapse-btn1').on('click', function() {
    $('#json1').JSONView('collapse');
});
$('#expand-btn2').on('click', function() {
    $('#json2').JSONView('expand');
});
$('#collapse-btn2').on('click', function() {
    $('#json2').JSONView('collapse');
});

function getMemCacheCache(){
	$.ajax({
		url:"${ctx}/cache/getMemCacheCache",
		data:{key:$("#key1").val()},
		success:function(data){
			if(data){
				$("#json1").JSONView(data);
			}else{
			    $("#json1").html("无数据");
			}
		}
	})
}
function deleteMemCacheCache(){
	$.ajax({
		url:"${ctx}/cache/deleteMemCacheCache",
		data:{key:$("#key1").val()},
		success:function(data){
			if(data&&data.success){
				alert(data.msg);
			}
		}
	})
}
function getRedisCache(){
	$.ajax({
		url:"${ctx}/cache/getRedisCache",
		data:{key:$("#key2").val()},
		success:function(data){
			if(data){
				$("#json2").JSONView(data);
			}else{
			    $("#json2").html("无数据");
			}
		}
	})
}
function deleteRedisCache(){
	$.ajax({
		url:"${ctx}/cache/deleteRedisCache",
		data:{key:$("#key2").val()},
		success:function(data){
			if(data&&data.success){
				alert(data.msg);
			}
		}
	})
}
</script>
</body>
</html>