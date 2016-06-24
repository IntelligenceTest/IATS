<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>AutoStreets后台系统-出价记录查询</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
</head>
<body>
<%-- <%@ include file="/jsp/common/menu.jsp"%> 
<div class="mainblock">
 <%@ include file="/jsp/common/sub-menu.jsp"%> --%>
    <div class="m_content">
        <form:form action="${ctx }/report/bid-log" method="post" commandName="auctionVehicleVO" id="bidLogsForm">
                        <form:hidden path="id" value="${auctionVehicleVO.id }" />
                        <form:hidden path="startTimestamp" value="${startTimestamp }" />
                        <form:hidden path="endTimestamp" value="${endTimestamp }" />
                        <form:hidden path="bidderType" value="${auctionVehicleVO.bidderType }" />
        </form:form>
     <%--  <div class="s_box">
        <form:form action="${ctx }/report/bid-log?currentMenuSid=${currentMenuSid}&currentSubMenuSid=${currentSubMenuSid }" 
                        method="post" commandName="auctionVehicleVO" id="bidLogsForm">
                <ul class="s_form">
                    <li>
                       <label>车辆入库日期：</label>
                        <form:input path="startTimestamp" id="startTimestamp1" cssClass="input-10" cssStyle="width:80px;"/>
                        <label>&nbsp;至&nbsp;</label>
                        <form:input path="endTimestamp" id="endTimestamp1" cssClass="input-10" cssStyle="width:80px;" />
                    </li>
                </ul>
                <p class="controlbox">
                    <autoTag:roleButton authId="109102101" type="button" id="sub001" value="查询" btnClass="btn_lv4_1" />
                    <autoTag:roleHref authId="109102102" href="#" btnClass="link-export" id="link-export" textValue="导出EXCEL"/>
                </p>
        </form:form>
         <div class="exportselect" id="exportselect" style="display:none">
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
                        <!-- <li><input type="checkbox" name="exportCol" value="saleType#销售方式#dictionary#sale_type"><label>销售方式</label></li> -->
                        <li><input type="checkbox" name="exportCol" value="vehicleAppraiser#评估师"><label>评估师</label></li>
                        <li><input type="checkbox" name="exportCol" value="evaluationDept#评估部门"><label>评估部门</label></li>
                        <li><input type="checkbox" name="exportCol" value="brand#品牌"><label>品牌</label></li>
                        <li><input type="checkbox" name="exportCol" value="vehicleModel#型号"><label>型号</label></li>
                        <li><input type="checkbox" name="exportCol" value="vinCode#VIN码"><label>VIN码</label></li>
                        <li><input type="checkbox" name="exportCol" value="licenseCode#车牌号"><label>车牌号</label></li>
                        <li><input type="checkbox" name="exportCol" value="registerCity#上牌城市"><label>上牌城市</label></li>
                        <li><input type="checkbox" name="exportCol" value="displayMileage#表显里程(万公里)"><label>表显里程(万公里)</label></li>
                        <li><input type="checkbox" name="exportCol" value="registerLicenseDate#上牌年月"><label>上牌年月</label></li>
                        <li><input type="checkbox" name="exportCol" value="sweptVolume,sweptVolumeType#排量"><label>排量</label></li>
                        <li><input type="checkbox" name="exportCol" value="bodyColor#车辆颜色"><label>车辆颜色</label></li>
                    </ul>
                    <p align="center">
                        <input type="button" id="exportSelectAll" class="btn_lv4_1" value="全选" />
                        <input type="button" id="exportNotSelectAll" class="btn_lv4_1" value="全不选" />
                        <autoTag:roleButton authId="109102102" type="button" btnClass="btn_lv4_1" id="exportExcel" value="导出EXCEL"/>
                    </p>
                </form:form>
            </div>
      </div> --%>
    <div class="rbody">
        <div class="tbl_ctrl" style="width:99.3%;">
                 <b><font size="3" color="black">&nbsp;&nbsp;&nbsp;拍卖报表出价记录查询</font></b>
        </div>
        <table class="datelist-1" style="width:100%;">
            <thead>
                <tr>
                    <td width=60>竞拍姓名</td>
                    <td width=60>竞拍人账号</td>
                    <td width=80>出价时间</td>
                    <td width=80>出价价格(万元)</td>
                    <td width=100>竞拍人IP</td>
                </tr>
            </thead>
            <tbody>
                <c:if test="${fn:length(pagination.dataList)==0}">
                    <tr class="eq">
                        <td colspan="5">
                             <p align="center">
                                <font color="red" size="2"><b>没有相关数据！</b></font>
                            </p>
                        </td>
                    </tr>
                </c:if>
                <c:forEach items="${pagination.dataList}" var="item">
                    <tr class="eq" style="text-align: center;">
                        <td><p>${item.bidderName }</p></td>
                        <td><p>${item.bidderUsername}</p></td>
                        <td><p><fmt:formatDate value="${item.bidTimestamp}" pattern="yyyy-MM-dd HH:mm" /></p></td>
                        <td><p>
                            <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.price/10000 }"></fmt:formatNumber>
                        </p></td>
                        <td><p>${item.ip}</p></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- 分页加载 -->
      <%-- <c:if test="${pagination!=null && pagination.count>10}"> --%>
	        <div class="pagination fr">
	             <div id="kkpager"></div>
	       </div>
       <%-- </c:if> --%>
    </div>
</div>
<!-- </div> -->
<script type="text/javascript" src="${ctx}/resources/auction/all.js"></script>
<script type="text/javascript">
$(document).ready(function (){
	//分页
	kkpager.generPageHtml({
		pno : '${pagination.current}',
		//总页码
		total : '${pagination.total}',
		pageSize : '${pagination.length}',
		//总数据条数
		totalRecords : '${pagination.count}',
		//链接前部
		hrefFormer : '${ctx}/report/bid-log',
		//设置每页显示条数
		isShowSelectPageSize : true,
		//链接算法
		getLink : function(n) {
			var queryString = $('#bidLogsForm').serialize();
			return this.hrefFormer + this.hrefLatter + "?current=" + n + '&length='+ this.pageSize+ '&' + queryString;
		}
		});
	});
	
	
	//样式bug解决
	var _pagewidth;

	var settable = function() {
		if ($.cookie('leftpower') == "0") {
			_pagewidth = $('.mainblock').width() - 52 - 1;
		} else {
			_pagewidth = $('.m_content').width() - 44 - 1;
		}
		return _pagewidth;
	};
	var _tblwidth = settable();
	$.fn.TableLock({
		table : 'datatable',
		lockRow : 0,
		lockColumn : 5,
		width : _tblwidth,
		height : ''
	});
	$(".icon_arr_l").click(function() {
		var _pagewidth1;
		if ($.cookie('leftpower') == "0") {
			_pagewidth1 = $('.mainblock').width() - 44 - 202 - 1;
		} else {
			_pagewidth1 = $('.mainblock').width() - 52 - 1;
		}
		$('#divBoxing').width(_pagewidth1);
	});

	$('#datatable').find('div').each(
			function() {
			    var pheight = $(this).parent().height();
                if(pheight <= 60){
                    pheight = 60;
                }
                $(this).height(pheight);
				$(this).find('span').css("marginTop",
						-$(this).find('span').height() / 2);
			});

	$('#datatable tr td:last-child').css('border-right', '0');
</script>
<%-- <script type="text/javascript" src="${staticUrl}/common/build/1.00/js/aside.js"></script> --%>
</body>
</html>