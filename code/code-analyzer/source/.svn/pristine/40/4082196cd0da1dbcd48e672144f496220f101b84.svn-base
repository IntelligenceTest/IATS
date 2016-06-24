<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>二手车拍卖-出价记录报表</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<style>
.exportselect {
    padding: 10px 20px;
    border: 1px solid #ccc;
    margin: 20px;
    background: #fff;
    float:left;
    width:95%;
}
#exportSelectAll,#exportExcel,#exportNotSelectAll{
	width: 90px;
    background: #549957!important;
    font-size: 12px;
    cursor: pointer;
    height: 28px;
    float:none;
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
   			<div class="container_top">
		        <form:form action="${ctx }/report/bidreport" method="post" commandName="bidReportVO" id="bidReportForm">
	                <ul class="filter sa-sreach-list">
	                    <li class="width-600">
	                        <p>出价时间：</p>
	                        <form:input path="startTimestamp" id="startTimestamp1" />
	                        <label class="inp-label">&nbsp;至&nbsp;</label>
	                        <form:input path="endTimestamp" id="endTimestamp1" />
	                    </li>
	                </ul>
		        </form:form>
                <div class="query">
                	<a id="search" class="query_btn" >查询</a>
                	<shiro:hasPermission name="auct:bidreport:exportexcel">
	                	<a class="query_btn ml10" id="link-export">导出Excel</a>
                	</shiro:hasPermission>
                </div>
				<div class="exportselect" id="exportselect" style="display: none">
					<form:form id="exportForm" method="post" accept-charset="utf-8" enctype="application/x-www-form-urlencoded">
						<ul>
							<li>
								<input type="checkbox" name="exportCol" value="code#车辆编号"><label>车辆编号</label>
							</li>
							<li>
								<input type="checkbox" name="exportCol" value="bidderName#出价人"><label>出价人</label>
							</li>
							<li>
								<input type="checkbox" name="exportCol" value="count#出价次数"><label>出价次数</label>
							</li>
							<li>
								<input type="checkbox" name="exportCol" value="maxPrice#最高出价(万元)"><label>最高出价(万元)</label>
							</li>
						</ul>
						<p align="center">
							<input type="button" id="exportSelectAll" class="export-button" value="全选" />
							<input type="button" id="exportNotSelectAll" class="export-button" value="全不选" />
							<input id="exportExcel" type="button" class="export-button" value="导出EXCEL" />
						</p>
					</form:form>
	            </div>
           </div>
        </div>
        <div class="container_main">
        	<div class="wrap">
		        <table class="datelist-1" style="width:100%;">
		            <thead>
		                <tr class="l">
		                    <td width=150>车辆编号</td>
		                    <td width=80>出价人</td>
		                    <td width=50>出价次数</td>
		                    <td width=100>最高出价(万元)</td>
		                </tr>
		            </thead>
		            <tbody>
		                <c:if test="${fn:length(pagination.dataList)==0}">
		                    <tr>
		                        <td colspan="4">
		                        <p align="center">
		                            <font color="red" size="2"><b>没有相关数据！</b></font>
		                            </p>
		                        </td>
		                    </tr>
		                </c:if>
		                <c:forEach items="${pagination.dataList}" var="item">
		                    <tr class="eq">
		                        <td><p>${item.code}</p></td>
		                        <td><p>${item.bidderName}</p></td>
		                        <td><p>${item.count}</p></td>
		                        <td><p>${item.maxPrice}</p></td>
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
var isDate1 = function(str, e) {
    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;     
	var r = str.match(reg);     
	if(r==null){
	    alert("请输入准确的时间格式：yyyy-MM-dd");    
	    if (e && e.preventDefault) {
            e.preventDefault();
        } else {
            window.event.returnValue = false;
        }
        return false;
	}
	return true;
}

$(document).ready(function (){
	common.showDatePicker("#startTimestamp1");
	common.showDatePicker("#endTimestamp1");
	
	$("#search").click(function(e){
    	var startTimestamp = $("#startTimestamp1").val();
    	var endTimestamp = $("#endTimestamp1").val();
    	if(startTimestamp!=""){
    	    var is1=isDate1(startTimestamp,e);
    	    if(!is1){return;}
    	}
    	if(endTimestamp!=""){
    	    var is2=isDate1(endTimestamp,e);
    	    if(!is2){return;}
    	}
    	$("#bidReportForm").submit();
    });
	
	$("#sub001").click(function(){
		  var startTimestamp = $("#startTimestamp1").val();
	      var endTimestamp = $("#endTimestamp1").val();
	      var i = isDate(startTimestamp,endTimestamp);
	      if(!i){
	          alert("日期格式必须为YYYY-MM-DD");
	          return;
	      }
		 $("#bidReportForm").submit();
	});
	
	$("#link-export").click(function(){
        $("#exportselect").toggle();
    });
	
    $("#exportSelectAll").click(function() {
        $("input:checkbox[name='exportCol']").attr("checked", "checked");
    });
    
    $("#exportNotSelectAll").click(function() {
        $("input:checkbox[name='exportCol']").removeAttr("checked");
    });
    
    $("#exportExcel").click(function(e){
	      var isCheck=false;
	      $("input[name='exportCol']").each(function(){
	      if($(this).attr("checked")=="checked"){ isCheck=true; }
      });
      
      if (!isCheck){
         alert("请选择导出列！"); 
         return;
      };
      
      var startTimestamp = $("#startTimestamp1").val();
      var endTimestamp = $("#endTimestamp1").val();
      var i = isDate(startTimestamp,endTimestamp);
      if(!i){
    	  alert("日期格式必须为YYYY-MM-DD");
    	  return;
      }
   
      var queryString = $('#bidReportForm').serialize();
      var actionUrl = "${ctx}/report/exportbidexcel?" + queryString;
       $("#exportForm").attr("action", actionUrl);
       $("#exportForm").submit();
    });
    
	//分页
	kkpager.generPageHtml({
		pno : '${pagination.current}',
		//总页码
		total : '${pagination.total}',
		pageSize : '${pagination.length}',
		//总数据条数
		totalRecords : '${pagination.count}',
		//链接前部
		hrefFormer : '${ctx}/report/bidreport',
		//设置每页显示条数
		isShowSelectPageSize : true,
		//链接算法
		getLink : function(n) {
			var queryString = $('#bidReportForm').serialize();
			return this.hrefFormer + this.hrefLatter + "?current=" + n + '&length='+ this.pageSize+ '&' + queryString;
		}
		});
	});
</script>
</body>
</html>