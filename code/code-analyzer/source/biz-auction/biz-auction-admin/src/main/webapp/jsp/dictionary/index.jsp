<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>参数设置</title>
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
		   		<form:form action="${ctx }/auctionDictionary/index" method="post" commandName="auctionDictionary" id="auctionDictionaryForm">
					<ul class="filter sa-sreach-list">
                        <li class="width-250">
							<p>参数：</p>
							<form:input path="category" autocomplete="false"></form:input>
						</li>
                        <li class="width-250">
							<p>显示名称：</p>
							<form:input path="name" autocomplete="false"></form:input>
						</li>
                        <li class="width-250">
							<p>参数描述：</p>
							<form:input path="categoryDesc" autocomplete="false"/>
						</li>
					</ul>
				</form:form>
                <div class="query">
                	<shiro:hasPermission name="auct:auctionDictionary:query">
	                	<a id="search" class="query_btn" onclick="$('#auctionDictionaryForm').submit();">查询</a>
	                	<a class="query_btn ml10" onclick="common.formReset('auctionDictionaryForm')">清空条件</a>
                	</shiro:hasPermission>
                </div>
           </div>
        </div>
        <shiro:hasPermission name="auct:auctionDictionary:add">
        	<input onclick="add();" class="addbtn query_btn_2" type="submit" value="新增">
        </shiro:hasPermission>
        <div class="container_main">
        	<div class="wrap">
	            <table class="bk_table width_percent_100" id="auctionDictionaryTable">
					<thead>
						<tr>
							<td style="width:10%;">操作</td>
							<td style="width:16%;">参数</td>
							<td style="width:10%;">显示名称</td>
							<td style="width:10%;">值</td>
							<td style="width:8%;">显示次序</td>
							<td style="width:16%;">参数描述</td>
							<td style="width:15%;">更新时间</td>
							<td style="width:10%;">操作人</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.dataList}" var="auctionDictionary">
							<tr>
								<td>
									<shiro:hasPermission name="auct:auctionDictionary:edit">
										<a href="javascript:void(0);" onclick="edit(${auctionDictionary.id})">[编辑]</a>
							        </shiro:hasPermission>
									<shiro:hasPermission name="auct:auctionDictionary:delete">
										<a href="javascript:void(0);" onclick="deleteDictionary(${auctionDictionary.id})">[删除]</a>
							        </shiro:hasPermission>
								</td>
								<td>${auctionDictionary.category }</td>
								<td>${auctionDictionary.name}</td>
								<td>${auctionDictionary.value}</td>
								<td>${auctionDictionary.itemOrder}</td>
								<td>${auctionDictionary.categoryDesc}</td>
								<td><fmt:formatDate value="${auctionDictionary.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
								<spring:eval expression="@userService.selectByPrimaryKey(auctionDictionary.updateUser)" var="user" />
								<td>${user.name}</td>
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

<div id="addDiv" class="UED_hide">
	<div class="pop_box" style="width: 800px; ">
		<div class="pop_tittle">
			<h3 id="UED_layer_h3_v31">新增参数</h3>
			<a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
		</div>
		<div class="pop_mainbox" style="width: 780px;" id="addDic">
	        
		</div>
	</div>
</div>
<div id="editDiv" class="UED_hide">
	<div class="pop_box" style="width: 800px; ">
		<div class="pop_tittle">
			<h3 id="UED_layer_h3_v31">编辑参数</h3>
			<a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
		</div>
		<div class="pop_mainbox" style="width: 780px;" id="editDic">
	        
		</div>
	</div>
</div>
	
<script type="text/javascript">
//修改记录
function edit(id){
	$("#editDic").load("${ctx}/auctionDictionary/get?id="+id,{},function(){
		$.LAYER.show({id:"editDiv"});
	});
}

function add(){
    $("#addDic").load("${ctx}/auctionDictionary/add",{},function(){
		$.LAYER.show({id:"addDiv"});
    });
}

function deleteDictionary(id){
    if(window.confirm("您确定要删除这个参数吗?")){
		$.ajax({
		    url:"${ctx}/auctionDictionary/delete",
		    data:{id:id},
		    success:function(data){
		        if(data.success){
		            alert(data.msg);
		            location.reload();
		        }else{
		            alert("删除失败!");
		        }
		    }
		})
    }
}

$(document).ready(function (){
	
	//分页
	kkpager.generPageHtml({
	    pno : '${pagination.current}',
	    //总页码
	    total : '${pagination.total}',
	    //总数据条数
	    totalRecords : '${pagination.count}',
	    //链接前部
	    hrefFormer : '${ctx}/auctionDictionary/index',
	    //链接算法
	    getLink : function(n){
	        var queryString = $('#auctionDictionaryForm').serialize(); 
	        return this.hrefFormer + this.hrefLatter + "?current=" + n + "&" + queryString;
	    }
	});
	setWidth();
});
</script>
</body>
</html>