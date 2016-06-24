<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>拍卖中心管理</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
<script language="javascript" src="${ctx}/resources/auction/auctionplace.js?randomId=<%=System.currentTimeMillis()%>"></script>
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
		   		<form:form action="${ctx }/auctionplace/index" method="post" commandName="auctionPlace" id="auctionPlaceForm">
					<ul class="filter sa-sreach-list">
                        <li class="width-250">
							<p>拍卖中心名称：</p>
							<form:input path="name"></form:input>
						</li>
                        <li class="width-250">
							<p>拍卖中心状态：</p>
							<form:select path="enabled">
							    <form:option value="">请选择</form:option>
								<form:option value="true">激活</form:option>
								<form:option value="false">禁用</form:option>
							</form:select>
						</li>
					</ul>
				</form:form>
                <div class="query">
                	<shiro:hasPermission name="auct:ap:query">
	                	<a id="search" class="query_btn" onclick="$('#auctionPlaceForm').submit();">查询</a>
	                	<a class="query_btn ml10" onclick="common.formReset('auctionPlaceForm')">清空条件</a>
                	</shiro:hasPermission>
                </div>
           </div>
        </div>
        <shiro:hasPermission name="auct:ap:add">
        	<input onclick="auctionPlace.add();" class="addbtn query_btn_2" type="submit" value="拍卖中心新建">
        </shiro:hasPermission>
        <shiro:hasPermission name="auct:ap:open">
        	<input onclick="auctionPlace.activate('open');" class="addbtn query_btn_2" type="submit" value="拍卖中心激活">
        </shiro:hasPermission>	
        <shiro:hasPermission name="auct:ap:close">
        	<input onclick="auctionPlace.activate('close');" class="addbtn query_btn_2" type="submit" value="拍卖中心禁用">
        </shiro:hasPermission>	
        <div class="container_main">
        	<div class="wrap">
	            <table class="bk_table width_percent_100" id="auctionPlaceTable">
					<thead>
						<tr>
							<td width=10><input type="checkbox" onclick="selectAll(this)"></td>
							<td width=120>拍卖中心名称</td>
							<td width=55>联系电话</td>
							<td width=70>地区</td>
							<td width=70>地址</td>
							<td width=45>时间</td>
							<td width=45>状态</td>
							<td width=100>备注</td>
							<td width=90>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.dataList}" var="auctionPlace">
							<tr class="eq">
							    <td><input type="checkbox" name="auctionPlaceList" value="${auctionPlace.id }"></td>
								<td>${auctionPlace.name}</td>
								<td>${auctionPlace.telephone}</td>
								<td>${auctionPlace.province}-${auctionPlace.city}</td>
								<td>${auctionPlace.addr}</td>
								<td>${auctionPlace.period }</td>
								<td>
								<c:if test="${auctionPlace.enabled}">
									激活
								</c:if>
								<c:if test="${!auctionPlace.enabled}">
									禁用
								</c:if>
								</td>
								<td>${auctionPlace.remark }</td>
								<td>
									<shiro:hasPermission name="auct:ap:edit"><a href="${ctx}/auctionplace/addPage?id=${auctionPlace.id }" target="_blank">编辑</a></shiro:hasPermission>
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
<script type="text/javascript">
$(function(){
	kkpager.generPageHtml({
	    pno : '${pagination.current}',
	    //总页码
	    total : '${pagination.total}',
	    //总数据条数
	    totalRecords : '${pagination.count}',
	    //链接前部
	    hrefFormer : '${ctx}/auctionplace/index',
	    //链接算法
	    getLink : function(n){
	        var queryString = $('#auctionPlaceForm').serialize(); 
	        return this.hrefFormer + this.hrefLatter + "?current=" + n + '&' + queryString;
	    }
	});
});
</script>
</body>
</html>