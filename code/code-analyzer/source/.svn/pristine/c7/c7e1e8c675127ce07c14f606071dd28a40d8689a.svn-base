<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>AutoStreets后台系统-精品二手车报表</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
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
                <div class="query">
                	<shiro:hasPermission name="auct:usedcarreport:exportexcel">
	                	<a class="query_btn" id="link-export">导出Excel</a>
                	</shiro:hasPermission>
                </div>
	            <div class="exportselect" id="exportselect" style="display:none;float:left;">
	                <form:form id="exportForm"  method="post"  accept-charset="utf-8" enctype="application/x-www-form-urlencoded">
	                    <ul>
	                        <li><input type="checkbox" name="exportCol" value="code#车辆编号"><label>车辆编号</label></li>
	                        <li><input type="checkbox" name="exportCol" value="city#展售区域"><label>展售区域</label></li>
	                        <li><input type="checkbox" name="exportCol" value="status#展售状态#dictionary#fixed_price_status"><label>展售状态</label></li>
	                        <li><input type="checkbox" name="exportCol" value="price#展售价(元)"><label>展售价(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="lowPriceGroup#集团最低限价(元)"><label>集团最低限价(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="priceNewcar#新车售价(元)"><label>新车售价(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="taxBuy#购置税(元)"><label>购置税(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="finalPrice#购买价(元)"><label>购买价(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="inGarageTimestamp#入库时间"><label>入库时间</label></li>
	                        <li><input type="checkbox" name="exportCol" value="outGarageTimestamp#出库时间"><label>出库时间</label></li>
	                        <li><input type="checkbox" name="exportCol" value="sellTime#上架时间"><label>上架时间</label></li>
	                        <li><input type="checkbox" name="exportCol" value="createdTimestamp#成交时间"><label>成交时间</label></li>
	                        <li><input type="checkbox" name="exportCol" value="bidderName#购买人"><label>购买人</label></li>
	                        <li><input type="checkbox" name="exportCol" value="vehicleAppraiser#评估师"><label>评估师</label></li>
	                        <li><input type="checkbox" name="exportCol" value="evaluationDept#评估部门"><label>评估部门</label></li>
	                        <li><input type="checkbox" name="exportCol" value="brand#品牌"><label>品牌</label></li>
	                        <li><input type="checkbox" name="exportCol" value="vehicleModel#型号"><label>型号</label></li>
	                        <li><input type="checkbox" name="exportCol" value="vinCode#VIN码"><label>VIN码</label></li>
	                        <li><input type="checkbox" name="exportCol" value="licenseCode#车牌号"><label>车牌号</label></li>
	                        <li><input type="checkbox" name="exportCol" value="registerCity#上牌城市"><label>上牌城市</label></li>
	                        <li><input type="checkbox" name="exportCol" value="displayMileage#表显里程(万公里)"><label>表显里程(万公里)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="registerLicenseYears#上牌年月"><label>上牌年月</label></li>
	                        <li><input type="checkbox" name="exportCol" value="sweptVolume,sweptVolumeType#排量"><label>排量</label></li>
	                        <li><input type="checkbox" name="exportCol" value="bodyColor#车辆颜色"><label>车辆颜色</label></li>
	                    </ul>
	                    <p align="center">
	                        <input type="button" id="exportSelectAll" class="btn_lv4_1" value="全选" />
	                        <input type="button" id="exportNotSelectAll" class="btn_lv4_1 ml10" value="全不选" />
	                        <input type="button" id="exportExcel" class="btn_lv4_1 ml10" style="width:100px;" value="导出EXCEL"/>
	                    </p>
	                </form:form>
	            </div>
           </div>
        </div>
        <div class="container_main">
        	<div class="wrap">
	            <table id="datatable" style="width:2500px;">
		            <thead>
		                <tr>
		                    <td width=150><div><span>品牌型号</span></div></td>
		                    <td width=120><div class="locklast"><span>车辆编号</span></div></td>
		                    <td width=80>展售状态</td>
		                    <td width=60>展售区域</td>
		                    <td width=100>入库时间</td>
		                    <td width=100>出库时间</td>
		                    <td width=100>上架时间</td>
		                    <td width=100>成交时间</td>
		                    <td width=60>购买人</td>
		                    <td width=80>购买价(万元)</td>
		                    <td width=80>展售价(万元)</td>
		                    <td width=90>集团最低限价(万元)</td>
		                    <td width=80>新车价格(万元)</td>
		                    <td width=80>购置税价格(万元)</td> 
		                    <td width=60>VIN码</td>
		                    <td width=80>车牌号</td>
		                    <td width=60>评估师</td>
		                    <td width=60>评估部门</td>
		                    <td width=60>上牌城市</td>
		                    <td width=80>表显里程(万公里)</td>
		                    <td width=60>上牌年月</td>
		                    <td width=60>排量</td>
		                    <td width=60>车辆颜色</td>
		                </tr>
		            </thead>
		            <tbody>
		                <c:if test="${fn:length(pagination.dataList)==0}">
		                    <tr>
		                        <td><div><span><p> </p></span></div></td>
		                        <td><div class="locklast"><span><p> </p></span></div></td>
		                        <td colspan="20">
		                        <p align="left">
		                            <font color="red" size="2"><b>没有相关数据！</b></font>
		                            </p>
		                        </td>
		                    </tr>
		                </c:if>
		                <c:forEach items="${pagination.dataList}" var="item">
		                    <tr>
		                        <td>
		                            <div><span>
		                            <p>${item.brand}${item.vehicleModel }${item.selledName }</p>
		                            </span></div>
		                        </td>
		                        <td><div class="locklast"><span><p>${item.code}</p></span></div></td>
		                        <td>
		                            <p>
		                                <c:if test="${item.status=='0' }">已上架</c:if>
		                                <c:if test="${item.status=='1' }">已下架</c:if>
		                                <c:if test="${item.status=='2' }"><font color="red"><b>已出售</b></font></c:if>
		                            </p>
		                        </td>
		                        <td><p><%-- ${item.province } --%>${item.city }</p></td>
		                        <td><p><fmt:formatDate value="${item.inGarageTimestamp}" pattern="yyyy-MM-dd HH:mm" /></p></td>
		                        <td><p><fmt:formatDate value="${item.outGarageTimestamp}" pattern="yyyy-MM-dd HH:mm" /></p></td>
		                        <td><p><fmt:formatDate value="${item.sellTime}" pattern="yyyy-MM-dd HH:mm" /></p></td>
		                        <td><p><fmt:formatDate value="${item.createdTimestamp}" pattern="yyyy-MM-dd HH:mm" /></p></td>
		                        <td><p>${item.bidderName}</p></td>
		                        <td><p>
		                            <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.finalPrice/10000 }"></fmt:formatNumber>
		                        </p></td>
		                        <td><p>
		                            <fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.price/10000 }"></fmt:formatNumber>
		                        </p></td>
		                        <td><p>
		                            <fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.lowPriceGroup/10000 }"></fmt:formatNumber>
		                        </p></td>
		                        <td><p>
		                            <fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.priceNewcar/10000 }"></fmt:formatNumber>
		                        </p></td>
		                        <td><p>
		                            <fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.taxBuy/10000 }"></fmt:formatNumber>
		                        </p></td>
		                        <td><p>${item.vinCode}</p></td>
		                        <td><p>${item.licenseCode}</p></td>
		                        <td><p>${item.vehicleAppraiser}</p></td>
		                        <td><p>${item.evaluationDept}</p></td>
		                        <td><p>${item.registerCity}</p></td>
		                        <td><p>${item.displayMileage}</p></td>
		                        <td><p>${item.registerLicenseYears}</p></td>
		                        <td><p>${item.sweptVolume}${item.sweptVolumeType}</p></td>
		                        <td><p>${item.bodyColor}</p></td>
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
	common.showDatePicker("#startTimestamp1");
	common.showDatePicker("#endTimestamp1");
	
	$("#sub001").click(function(){
		  var startTimestamp = $("#startTimestamp1").val();
	      var endTimestamp = $("#endTimestamp1").val();
	      var i = isDate(startTimestamp,endTimestamp);
	      if(!i){
	          alert("日期格式必须为YYYY-MM-DD");
	          return;
	      }
		 $("#usedCarForm").submit();
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
       var queryString = $('#usedCarForm').serialize();
       var actionUrl = "${ctx}/report/exportusedcarexcel?" + queryString;
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
		hrefFormer : '${ctx}/report/usedcarreport',
		//设置每页显示条数
		isShowSelectPageSize : true,
		//链接算法
		getLink : function(n) {
			var queryString = $('#usedCarForm').serialize();
			return this.hrefFormer + this.hrefLatter + "?current=" + n + '&length='+ this.pageSize+ '&' + queryString;
		}
		});
	
	$.fn.TableLock({
		table : 'datatable',
		lockRow : 0,
		lockColumn : 5,
		width : $('.container_top').width()- 24,
		height : ''
	});

	$('#datatable').find('div').each(
			function() {
			    var pheight = $(this).parent().height();
	          if(pheight <= 60){
	              pheight = 60;
	          }
	          $(this).height(pheight);
				$(this).find('span').css("marginTop",-$(this).find('span').height() / 2);
	});
	aside_h();
});

</script>
</body>
</html>