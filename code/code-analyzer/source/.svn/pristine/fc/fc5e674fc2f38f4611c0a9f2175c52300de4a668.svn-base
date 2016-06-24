<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<form id="offlinePayForm" data-validate="true" method="post">
	<ul class="s_form" >
		<table class="bk_table width_percent_100">
			<thead>
				<th>时间</th>
				<th>操作</th>
				<th>备注</th>
				<th>操作人</th>
			</thead>
			<c:forEach var="log" items="${logs }">
				<tr>
					<td><fmt:formatDate value="${log.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${log.prepStatusName }--&gt;${log.postStatusName }</td>
					<td <c:if test="${fn:length(log.memo) ge 10}">title="${log.memo }"</c:if>>
						<c:if test="${fn:length(log.memo) ge 10}">${fn:substring(log.memo,0,10)}</c:if>
						<c:if test="${fn:length(log.memo) lt 10}">${log.memo}</c:if>
					</td>
					<td>${log.userName }</td>
				</tr>
			</c:forEach>
		</table>
	</ul>
</form>