<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>同步拍数据操作记录</title>
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
        <form:form action="${ctx }/auctionUploadLog/index" method="post" commandName="auctionUploadLog" id="auctionUploadLogForm">
			   <ul class="filter sa-sreach-list">
					<li>
						<p>操作时间：</p> 
					    <form:input path="startTime" cssClass="dateCls"/>
					    	<label class="inp-label">至</label>
					    <form:input path="endTime" cssClass="dateCls"/>	
					</li>
					<li>
						<p>操作人：</p>
							<form:input path="createByName" />
					</li>
			 </ul>
			 <div class="query">
	                 <a id="search" class="query_btn" onclick="">查询</a>
	                 <a class="query_btn ml10" onclick="common.formReset('auctionUploadLogForm')">清空条件</a>
             </div>
		   </form:form>
	   </div>
	  </div>
	  <div class="container_main">
	   <div class="wrap">
		<table class="bk_table width_percent_100" id="auctionTable">
			<thead>
				<tr>
					<td width=100>操作时间</td>
					<td width=100>操作人</td>
					<td width=55>操作</td>
					<td width=100>场次名称</td>
					<td width=60>拍卖日期</td>
					<td width=45>参拍人数</td>
					<td width=45>车辆数</td>
					<td width=25>成交数</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pagination.dataList}" var="log">
					<tr class="eq">
						<td>
						  <p><fmt:formatDate value="${log.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></p>
						</td>
						<td><p>${log.createByName }</p></td>
						<td><p>
							<c:if test="${log.operType==1}">导入</c:if>
							<c:if test="${log.operType==2}">导出</c:if>
							<c:if test="${log.operType==3}">删除</c:if>			    
						</p></td>
						<td><p>
							${log.title }
						</p></td>
						<td><p>
							<fmt:formatDate value="${log.auctionDate }" pattern="yyyy-MM-dd HH:mm:ss" />
						</p></td>
						<td><p>${log.memberNum }</p></td>
						<td><p>${log.vehicleNum }</p></td>
						<td><p>${log.dealNum }</p></td>
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
	$(document).ready(function (){
		
		//清空所有查询条件
		clearQueryConds("clear","m_content","${ctx}/auction/index");
	
		//分页
		kkpager.generPageHtml({
		    pno : '${pagination.current}',
		    //总页码
		    total : '${pagination.total}',
		    //总数据条数
		    totalRecords : '${pagination.count}',
		    //链接前部
		    hrefFormer : '${ctx}/auctionUploadLog/index',
		    //链接算法
		    getLink : function(n){
		        var queryString = $('#auctionUploadLogForm').serialize(); 
		        return this.hrefFormer + this.hrefLatter + "?current=" + n + "&" + queryString;
		    }
		});
		
		$(".dateCls").datetimepicker({
			showSecond: true,
			changeMonth: true,
		    changeYear: true,
		    yearRange:'c-30:c+10',//前30年和后0年
			dateFormat:'yy-mm-dd',
			timeFormat: 'HH:mm:ss',
			stepHour: 1,
			stepMinute: 1,
			stepSecond: 1,
			showTimezone: false,
			showAnim:'slide',
			duration: 'fast',
			showOtherMonths: true,
		    selectOtherMonths: true,
		    changeMonthUseLongNames:true,
		    monthNamesShort: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],
		    dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
			controlType: 'select',
			timeText:'时间',
			hourText:'时',
			minuteText:'分',
			secondText:'秒',
			currentText:'现在',
	        closeText:'关闭'
			}); 		
		
		$("#search").click(function(e){
			$('#auctionUploadLogForm').submit();
		});
	});
</script>
</body>
</html>