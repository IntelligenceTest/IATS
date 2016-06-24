<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>二手车推荐</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<link href="${ctx}/resources/js/ligerUI/ligerui-tree.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/js/ligerUI/base.js" type="text/javascript"></script>
<script src="${ctx}/resources/js/ligerUI/ligerTree.js" type="text/javascript"></script>
<style>
	.button_lv4_1{
		float:none!important;
		padding:0!important;
	}
</style>
</head>
<body>
	<spring:eval expression="@autoDictionaryService.selectResource('advertise_pos')" var="posList" />
	<spring:eval expression="@autoDictionaryService.selectResource('advertise_status')" var="statusList" />
<jsp:include page="${ctx}/common/menu" flush="true"></jsp:include>
<div class="mainblock">
    <div class="mainwrap">
        <jsp:include page="${ctx}/common/subMenu" flush="true"></jsp:include>
    </div>
    <div class="container">
    	<div class="bi_wrap">
    		<div class="container_top">
    			<form:form action="${ctx}/homepageRecommend/index" method="post" modelAttribute="homepageRecommend" commandName="homepageRecommend" id="searchLoanForm">
    				<ul class="filter sa-sreach-list">
    					<li class="width-250">
							<p>车辆编号：</p>
							<form:input path="vehicle.code"/>
						</li>
						<li class="width-250">
							<p>VIN码：</p>
							<form:input path="vehicle.vinCode"/>
						</li>
    				</ul>
	    			<div class="query">
	    				<shiro:hasPermission name="auct:recommend:query">
		                    <a id="search" class="query_btn" onclick="$('#searchLoanForm').submit();">查询</a>
		                    <a class="query_btn ml10" onclick="common.formReset('searchLoanForm')">清空条件</a>
	                    </shiro:hasPermission>
	                </div>
	            </form:form>
	        </div>
	    </div>
	    <shiro:hasPermission name="auct:recommend:add">
	    	<input id="add" class="addbtn query_btn_2" type="submit" value="新增">
	    </shiro:hasPermission>
	    <shiro:hasPermission name="auct:recommend:del">
        	<input id="del" class="addbtn query_btn_2" type="submit" value="删除">
        </shiro:hasPermission>
	    <div class="container_main">
	    	<div class="wrap">
	    		<table id="datelist-1" class="bk_table width_percent_100" data-theme="bk_table width_percent_100" data-form="searchLoanForm" data-pno="${pagination1.current}" data-pageSize="${pagination1.length}"
				    data-total="${pagination1.total}" data-totalRecords="${pagination1.count}" data-isShowSelectPageSize="true" >
					<thead>
						<tr>
							<th class="l"><input type="checkbox" id="selectAll" onclick="selectAll(this)"/></th>
							<th>操作</th> 
							<th>图片</th> 
							<th>销售名称</th>
							<th>状态</th>
							<th>展售区域</th>
							<th>排序</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.dataList}" var="data">
							<tr class="eq">
								<td><input onclick="setSelectAll(this)" type="checkbox" name="subcheck" value="${data.id}" /></td>
								<td>
									<div>
										<span>
											<shiro:hasPermission name="auct:recommend:rep">
				                        		<a href="javascript:void(0);" onclick="replace('${data.id}')">替换</a>
				                        	</shiro:hasPermission>
				                        </span>
			                      	</div>
			                    </td>
								<td>
									<div>
	                                    <span>
	                                        <c:choose>
	                                            <c:when test="${data.vehicle.firstPhotoUrl || data.vehicle.firstPhotoUrl == ''}"><img style="width: 120px;height:90px;" src="${staticUrl}/common/build/1.00/images/no.jpg"></c:when>
	                                            <c:otherwise>
	                                                <spring:eval expression="@autoDictionaryService.choiceImgUrl('1024X768', data.vehicle.firstPhotoUrl)" var="photoUrl" />
	                                                <img style="width: 60px;height: 45px;" data-popup="true" src="${dfsHttpServer}/${photoUrl}">
	                                            </c:otherwise>
	                                        </c:choose>
	                                    </span>
	                                </div>
								</td>
								<td>
									${data.vehicle.selledName}
								</td>
								<td>
									<p>
	                            	<!-- 展品状态：0-上架申请、1-已下架、2-已出售、3-已上架、4-已预订、5-已付定金、6-已付全款 -->
	                                <c:if test="${ data.fixedPrice.status==0}"><font color="green">上架申请</font></c:if>
	                                <c:if test="${ data.fixedPrice.status==1}"><font color="gray"><b>已下架</b></font><br></c:if>
	                                <c:if test="${ data.fixedPrice.status==2}"><font color="purple"><b>已出售</b></font></c:if>
	                                <c:if test="${ data.fixedPrice.status==3}"><font color="blue"><b>已上架</b></font></c:if>
	                                <c:if test="${ data.fixedPrice.status==4}"><font color="green"><b>已预订</b></font></c:if>
	                                <c:if test="${ data.fixedPrice.status==5}"><font color="red">已付定金</font></c:if>
	                                <c:if test="${ data.fixedPrice.status==6}"><font color="red"><b>已付全款</b></font></c:if>
	                                <c:if test="${ data.fixedPrice.status!=3&&data.fixedPrice.status!=4}"><font color="red">该展品状态不能为推荐</font></c:if>
                           			</p>
								</td>
								<td>
									${data.fixedPrice.addressDetailStore}
								</td>
								<td >
									<shiro:hasPermission name="auct:recommend:seq">
										<input type="text" id="seqNo${data.id}" value="${data.seqNo}" style="width: 30px;"/>
										<a href="javascript:void(0);" onclick="modify('${data.id}')">修改序号</a>
									</shiro:hasPermission>
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

	<jsp:include page="selectVehicle.jsp"></jsp:include>
	<!-- 查看/编辑 -->
	<%-- <script type="text/javascript" src="${ctx}/resources/serviceSuport/serviceSuport.js"></script>
	<script type="text/javascript" src="${ctx}/resources/warrExtend/warrantyExtension.1.0.js"></script> --%>
</body>
<script>
$(function(){
	$("#add").on("click", function(){
		$("#isAdd").val(1);
		advertiseInfoShow();
	});
	$("#selectAll").on("click", function(){
		selectAll(this.id);
	});
	$("#del").on("click", function(){
		var ids = "";
		$("#datelist-1").find(":checkbox[name=subcheck]:checked").each(function(index, dom){
			ids += this.value+",";
		});
		if (!ids) {
			alert("至少选择一个车辆！");
			return false;
		}
		if (!confirm("确定要删除吗？")) {
			return false;
		}
		del(ids);
	});
	
	//分页
	kkpager.generPageHtml({
		pno : '${pagination.current}',
		//总页码
		total : '${pagination.total}',
		//总数据条数
		totalRecords : '${pagination.count}',
		//链接前部
		hrefFormer : '${ctx}/homepageRecommend/index',
		//链接算法
		getLink : function(n) {
			var queryString = $('#searchLoanForm').serialize();
			return this.hrefFormer + this.hrefLatter + "?current=" + n + '&' + queryString;
		}
	 });
});

var replace=function(id){
	advertiseInfoShow();
	$("#isAdd").val(-1);
	$("#fpRecommendId").val(id);
};

var modify = function(id){
	var typeId="#seqNo"+id;
	var seqNo=$(typeId).val();
	if(isNaN(seqNo)){
		alert("请输入数字");
		return;
	}
	if(seqNo.length>6){
		alert("请输入小于100万的序号");
		return;
	}
	jQuery.ajax({
		url : '${ctx}/homepageRecommend/modify',
		data : {
		    homepageRecommendId : id,seqNo : seqNo
		},
		success : function(data) {
			if (data.success) {
				alert(data.msg);
				window.location.reload();
			} else {
				alert("保存失败请稍等");
			}
		},
		error : function() {
			window.alert("系统异常，请联系管理员！");
		}
	});
};
var del = function(ids){
	jQuery.ajax({
		url : '${ctx}/homepageRecommend/remove',
		data : {
			ids : ids
		},
		success : function(data) {
			if (data.success) {
				alert(data.msg);
				window.location.reload();
			} else {
				alert("保存失败请稍等");
			}
		},
		error : function() {
			window.alert("系统异常，请联系管理员！");
		}
	});
};

var advertiseInfoShow = function(sid) {
	$.LAYER.show({
		id : "selectVehicleDiv"
	});
};

Date.prototype.format = function(format){ 
	var o = { 
		"M+" : this.getMonth()+1, //month 
		"d+" : this.getDate(), //day 
		"h+" : this.getHours(), //hour 
		"m+" : this.getMinutes(), //minute 
		"s+" : this.getSeconds(), //second 
		"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
		"S" : this.getMilliseconds() //millisecond 
	} ;

	if(/(y+)/.test(format)) { 
		format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 

	for(var k in o) { 
		if(new RegExp("("+ k +")").test(format)) { 
		format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
		};
	} 
	return format; 
};

</script>
</html>