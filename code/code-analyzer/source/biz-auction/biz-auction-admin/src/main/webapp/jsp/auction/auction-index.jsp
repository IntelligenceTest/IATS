<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>拍卖会管理</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
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
        <form:form action="${ctx }/auction/index" method="post" commandName="auction" id="auctionForm">
			   <ul class="filter sa-sreach-list">
					<li class="width-250">
						<p>拍卖会编号：</p> 
					    <form:input path="code" maxlength="15" /> 
					</li>
					<li class="width-250">
						<p>拍卖会状态：</p>
							<form:select path="status">
								<form:option value="" label="请选择"></form:option>
								<spring:eval expression="@autoDictionaryService.selectAuctionStatus()" var="status" />
								<form:options items="${status}" itemLabel="name" itemValue="value"></form:options>
							</form:select> 
					</li>
					<li class="width-250">
						<p>竞拍区域：</p>
							<form:select path="city">
								<form:option value="" label="请选择"></form:option>
								<spring:eval expression="@auctionPlaceService.getAuctionPlaceCityList(null)" var="citys" />
								<form:options items="${citys}" itemLabel="city" itemValue="city"></form:options>
							</form:select> 
					</li>
					<li class="width-500">
					   <p>开始时间：</p>
					   <form:input path="startTimestamp" />
					   <label class="inp-label">至</label>
					   <form:input path="endTimestamp"/>
					</li>
			 </ul>
			 <div class="query">
			 	<shiro:hasPermission name="auct:auct_idx:query">
	                 <a id="search" class="query_btn" onclick="">查询</a>
	                 <a class="query_btn ml10" onclick="common.formReset('auctionForm')">清空条件</a>
                </shiro:hasPermission> 
             </div>
		   </form:form>
	   </div>
	  </div>
	  <shiro:hasPermission name="auct:auct_idx:add"><input id="add"           class="addbtn query_btn_2" type="submit" value="拍卖会创建"></shiro:hasPermission>
	  <shiro:hasPermission name="auct:auct_idx:release"><input id="release"       class="addbtn query_btn_2" type="submit" value="拍卖会发布"></shiro:hasPermission>
      <shiro:hasPermission name="auct:auct_idx:cancelRelease"><input id="cancelRelease" class="addbtn query_btn_2" type="submit" style="width: 100px" value="拍卖会取消发布"></shiro:hasPermission>
      <shiro:hasPermission name="auct:auct_idx:itemorder"><input id="itemorder"     class="addbtn query_btn_2" type="submit" value="拍品顺序设置"></shiro:hasPermission>
      <shiro:hasPermission name="auct:auct_idx:volumeSet"><input id="volumeSet"     class="addbtn query_btn_2" type="submit" value="价格批量设置"></shiro:hasPermission>
      <shiro:hasPermission name="auct:auct_idx:synccatalog">
      	<input id="synchronizationCatalog"     class="addbtn query_btn_2" type="submit" value="同步拍卖目录">
      </shiro:hasPermission>
	  <div class="container_main">
	   <div class="wrap">
		<table class="bk_table width_percent_100" id="auctionTable">
			<thead>
				<tr>
					<td width=10><input type="checkbox" onclick="selectAll(this)"></td>
					<td width=50>操作</td>
					<td width=150>拍卖会名称</td>
					<td width=55>拍卖会状态</td>
					<td width=100>拍卖会编号</td>
					<td width=60>开始时间</td>
					<td width=45>拍卖类型</td>
					<td width=45>拍卖方式</td>
					<td width=25>车辆数量</td>
					<td width=90>竞拍区域</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pagination.dataList}" var="auction">
					<tr class="eq">
						<td>
						  <c:if test="${auction.status!='3'}">
							<input type="checkbox" id="chk${auction.id }" name="subcheck" value="${auction.id }" status="${auction.status }" counts="${auction.vehicleQuantity }"  pushTms="${auction.pushTms }" onclick="setSelectAll(this)"/>
						  </c:if>
						</td>
						<td style="margin:0;">
                            <c:if test="${auction.status=='0'||auction.status=='1' }">
                            	<shiro:hasPermission name="auct:auct_idx:edit">
                            		<a href="${ctx}/auction/op?auctionId=${auction.id }&flag=edit" target="_blank" style="margin:0 0px">编辑</a>
                            	</shiro:hasPermission>
                            </c:if>
                            <c:if test="${auction.status!='0' }">
                            	<shiro:hasPermission name="auct:auct_idx:exportCatalog">
                            		<a href="${ctx}/auction/exportCatalog?id=${auction.id }" target="_blank" style="margin:0 0px">目录导出</a>
                            	</shiro:hasPermission>
                            </c:if>
                            <c:if test="${auction.status!='0'&&auction.status!='3' }">
                            	<shiro:hasPermission name="auct:auct_idx:panel">
                            		<a href="http://admin-auction.autostreets.com/panel/${auction.id}" target="_blank" style="margin:0 0px">助手</a>
                            	</shiro:hasPermission>
                            </c:if>
                            <c:if test="${auction.status!='0'&&auction.status!='3' }">
                            	<shiro:hasPermission name="auct:auct_idx:screen">
                            		<a href="http://auction.autostreets.com/screen/${auction.id}" target="_blank" style="margin:0 0px">投影</a>
                            	</shiro:hasPermission>
                            </c:if>
                            <c:if test="${auction.status!='0'&&auction.status!='3' }">
                            	<shiro:hasPermission name="auct:auct_idx:screenList">
                            		<a href="http://auction.autostreets.com/screen/${auction.id}/list" target="_blank" style="margin:0 0px">投影列表</a>
                            	</shiro:hasPermission>
                            </c:if>
                        </td>
                        <td><p>
                        		<a href="${ctx}/auction/op?auctionId=${auction.id }&flag=view" target="_blank" >${auction.title }</a>
                        </p></td>
						<td><p>
							<c:if test="${auction.status=='0' }">未发布</c:if>
							<c:if test="${auction.status=='1' }"><font color="green">已发布</font></c:if>
							<c:if test="${auction.status=='2' }"><font color="red">拍卖开始</font></c:if>
							<c:if test="${auction.status=='3' }"><font color="blue">拍卖结束</font></c:if>
						</p></td>
						<td><p>${auction.code }</p></td>
						<td><p>
						    <fmt:formatDate value="${auction.startTimestamp}" pattern="yyyy-MM-dd HH:mm:ss" />
						</p></td>
						<td><p>
							<c:if test="${auction.type==0}">同步拍</c:if>
							<c:if test="${auction.type==1}">在线拍</c:if>
						</p></td>
						<td><p>
							<c:if test="${auction.auctionModel=='0' }">明拍</c:if>
							<c:if test="${auction.auctionModel=='1' }">暗拍</c:if>
						</p></td>
						<td><p>${auction.vehicleQuantity }</p></td>
						<td><p>${auction.province }${auction.city }</p></td>
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
<jsp:include page="auction-vehicle-price.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/resources/auction/all.js"></script>
<script type="text/javascript">
$(document).ready(function (){
	
	$('#synchronizationCatalog').click(function(){
		if(!confirm("确认要推送到仓储物流系统吗？推送后拍品顺序将无法修改")){
			return;
		}
		var url = "${ctx}/auction/synchronizationCatalog";
		
		var arrChks=$("input[name='subcheck']:checked");
	    var size = arrChks.length;
        if(size==1){
        	if($(arrChks[0]).attr("status")!=1){
        		alert("请选择一个已发布的拍卖会");
        		return;
        	}
        	if($(arrChks[0]).attr("pushTms")=="true"){
        		alert("该拍卖会已经推送到仓储");
        		return;
        	}
        	var auctionId=$(arrChks[0]).val();
        	$.ajax({
                cache: true,
                type: "POST",
                url:url,
                data:{auctionId : auctionId },
                async: false,
                error: function(request) {
                    window.alert("系统异常，请联系管理员！");
                },
                success: function(data) {
                    if(data.success){
                        $.LAYER.close();
                        window.alert(data.msg);
                        window.location.href="${ctx}/auction/index?currentMenuSid=${currentMenuSid}&currentSubMenuSid=${currentSubMenuSid }";
                   }else{
                       window.alert(data.msg);
                   }
                }
            });	
        }else if(size==0){
        	alert("请选择一个拍卖会");
        }else{
        	alert("至多选择一个拍卖会");
        }
        
		
	});
	
	//跳转到新增画面
	$("#add").click(function (){ window.open("${ctx}/auction/op"); });
	//编辑、查看、删除
	$("#edit").click(function (){ operation("edit");  });
	$("#view").click(function (){ operation("view");  });
	<%-- $("#delete").click(function (){ operation("delete"); });--%> 
	//发布
	$("#release").click(function (){ releaseAuction(this); });
	//取消发布
	$("#cancelRelease").click(function (){ cancelReleaseAuction(); });
	//拍品排序
	$("#itemorder").click(function (){ 
		//判断选中框，不能为空或者大于1
// 	    var orderItems = $("input[name='subcheck']:checked"); 
		var orderItems = common.getSelectIds("auctionTable");
		if(orderItems.length == 0){
			window.alert("请选择要操作的拍卖会~~~~");
			return false;
		}else if(orderItems.length > 1){
			alert("拍卖会不能大于1个~~~~");
			return false;
		}else{
			var auction_choice = $("#auctionTable").find("input[type='checkbox'][value='"+orderItems[0]+"']")
			if(auction_choice.attr("pushTms")=='true'){
				alert("拍卖会车辆信息已经推送到仓储,不能再修改");
			}else{
				window.open("${ctx}/auctionvehicle/itemorder?auctionId="+ orderItems[0]); 
			}
		}
	});
	
	//价格批量设置
	$("#volumeSet").click(function () {
		var orderItems= common.getSelectIds("auctionTable");
		if(orderItems.length == 0) {
	        window.alert("请选择要操作的拍卖会~~~~");
			return false;
		} else if(orderItems.length > 1) {
			alert("拍卖会不能大于1个~~~~");
			return false;
		} else {
			$("#auctionId").val(orderItems[0]);
			$.LAYER.show({id : "auctionPriceDiv"});
            return;
		}
	});
	
	//清空所有查询条件
	clearQueryConds("clear","m_content","${ctx}/auction/index");
	   
	$("#selectAll").click(function (){ selectAll(cbId);  });
	
	//编辑\查看\删除
	var operation=function(flag){
		 var arrChks=$("input[name='subcheck']:checked");
		 var size = arrChks.length;
		 var msg="编辑";
		 if(flag=="view"){
			 msg="查看";
		 }else if(flag=="delete"){
			 msg="删除";
		 }
		 if(size>1){
			 window.alert("淡定~~一次只能"+msg+"一条记录~~~~");
			 return;
		 }else if(size==0){
			 window.alert("请选中要"+msg+"的记录~~~~");
			 return;
		 }
		 if(flag=="delete"){
			 if(!confirm("是否确认删除？"))
				 return false;
		 }
		var id = arrChks[0].value;
		window.open("${ctx}/auction/op?auctionid="+id+"&flag="+flag);
	};

	//分页
	kkpager.generPageHtml({
	    pno : '${pagination.current}',
	    //总页码
	    total : '${pagination.total}',
	    //总数据条数
	    totalRecords : '${pagination.count}',
	    //链接前部
	    hrefFormer : '${ctx}/auction/index',
	    //链接算法
	    getLink : function(n){
	        var queryString = $('#auctionForm').serialize(); 
	        return this.hrefFormer + this.hrefLatter + "?current=" + n + "&" + queryString;
	    }
	});
});

/**
 * 拍卖会发布
 * 2014年7月17日 16:23:22
 * Roceys
 * V2.2
 */
var releaseAuction = function(dom) {
    var arrChks= common.getSelectIds("auctionTable");
    var size = arrChks.length;
    var allSids="";
    var status=true;
    var counts=true;
    if (size > 0) {
        $.each(arrChks, function(i, n){
        	var inputObj=$("#chk"+n);
        	allSids += $(inputObj).val() + ",";
            var f = $(inputObj).attr("status");
            var f1 = $(inputObj).attr("counts");
            if(f=="1"){ status=false; }
            if(f1=="0"){ counts=false; }
        	
        });
        
    	if(allSids!=""){
        	if(status&&counts){
        		$(dom).attr("disabled", "disabled").css("cssText","background-color:#aaaaaa!important");
	        	$.ajax(
        			{
		                type:"post",
		                dataType:"json",
		                url:"${ctx}/auction/release",
		                data:{auctionSids:allSids},
		                success:function(data){
		                	$(dom).removeAttr("disabled");
	                	    window.alert(data);
	                	    window.location.href="${ctx}/auction/index";
		                },
		              error: function(){
			        	  $(dom).removeAttr("disabled");
			        	  window.alert("发布失败");
		          }});
        			
        	}else {
        		 window.alert("存在【已发布】或【无拍品】的拍卖会，请重新选择!");
                 return;
			}
        }
    }else if(size==0){
        window.alert("请选择要操作的拍卖会~~~~");
        return;
    }
};

/**
 * 拍卖会取消发布
 * 2014年7月19日 18:52:22
 * Roceys
 * V1.0
 */
var cancelReleaseAuction = function() {
	var arrChks= common.getSelectIds("auctionTable");
    var size = arrChks.length;
    var allSids="";
    var status=true;
    if (size > 0) {
        $.each(arrChks, function(i, n){
        	var inputObj=$("#chk"+n);	
        	allSids += $(inputObj).val() + ",";
            var f = $(inputObj).attr("status");
            if(f=="0"){
            	status=false;
            }
        });
        
        if(allSids!=""){
        	if(status){
	        	$.ajax({
	                type:"post",
	                dataType:"json",
	                url:"${ctx}/auction/cancelRelease",
	                data:{auctionIds:allSids},
	                success:function(data){
	                	if(data){
	                	    window.alert("取消发布完成!");
	                	    window.location.href="${ctx}/auction/index";
	                	    return;
	                	}else {
	                	    window.alert("系统异常请联系管理员！");
	                	    return;
						}
	                }
	            });
        	}else {
        		 window.alert("存在【未发布】的拍卖会，请重新选择!");
                 return;
			}
        }
    }else if(size==0){
        window.alert("请选择要操作的拍卖会~~~~");
        return;
    }
};


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
		$('#auctionForm').submit();
	});
	
});
</script>
</body>
</html>