<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>拍品管理</title>
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
          <form:form action="${ctx }/auctionvehicle/index" method="post" commandName="auctionVehicle" modelAttribute="auctionVehicle" id="auctionVehicleForm">
                <ul class="filter sa-sreach-list low" id="filter">
                    <li class="width-250">
                    <p>品牌：</p> 
                          <spring:eval expression="@brandseriesService.selectDictBrandseries(null,null,null)" var="brands" />
                          <form:select path="brand">
                              <form:option value="" label="请选择" />
                               <c:forEach items="${brands}" var="b">
                                   <form:option value="${b.name}" label="${b.firstPinyin}-${b.name}" />
                               </c:forEach>
                          </form:select>
                    </li>
                    <li id="show1" class="width-250">
                    <p>拍卖类型：</p> 
                        <form:select path="type">
                            <form:option value="" label="请选择"></form:option>
                            <spring:eval expression="@auctionDictionaryService.selectAuctionType()" var="types"/>
                            <form:options items="${types}" itemLabel="name"  itemValue="value"></form:options>
                        </form:select>
                    </li>
                    <li id="show2" class="width-250">
                    	<p>拍品类型：</p> 
                  		<spring:eval expression = "@auctionDictionaryService.selectResource('av_type')" var="avTypes"/>
                        <form:select path="avType">
                        	<form:option value="">请选择</form:option>
                        	<form:options items="${avTypes}" itemLabel="name" itemValue="value"/>
                        </form:select>
                    </li>
                    <li class="width-250">
                        <p>拍品状态：</p>
                            <form:select path="status" onchange="dateHidden();">
                                <form:option value="99" label="请选择"></form:option>
                                <form:option value="9" label="待售"></form:option>
                                <spring:eval expression="@auctionDictionaryService.selectStatusOfAuction()" var="status" />
                                <form:options items="${status}" itemLabel="name" itemValue="value"></form:options>
                            </form:select>
                    </li>
                     <li class="width-250">
                        <p>VIN码：</p> 
                        <form:input path="vinCode" cssClass="input-10" />
                    </li>
                    <li class="width-250">
                        <p>车辆编号：</p> 
                        <form:input path="code" cssClass="input-10" />
                    </li>
                    <li class="width-250">
                        <p>车牌号：</p> 
                        <form:input path="licenseCode" cssClass="input-10" />
                    </li>
                    <li id="_auctionCode" class="width-250">
                        <p>拍卖会编号：</p>
                        <form:input path="auctionCode" cssClass="input-10" />
                    </li>
                    <li class="width-250">
                        <p>评估部门：</p>
                          <form:input path="evaluationDept" cssClass="input-10"/>
                    </li>
                    <li class="width-250">
                        <p>评估师：</p>
                       <form:input path="vehicleAppraiser" cssClass="input-10"/>
                    </li>
                     <li class="width-500">
                        <p>车辆所在地：</p>
                        <form:select path="currentProvince" onchange="selectCity('#currentCity','#currentProvince');">
                            <form:option value="" label="请选择" />
                            <spring:eval expression="@autoDictionaryService.selectProvince()" var="currentProvince" />
                            <form:options items="${currentProvince}" itemLabel="name"  itemValue="name" />
                        </form:select>
                        <form:select path="currentCity">
                            <form:option value="" label="请选择" />
                            <c:if test="${null != auctionVehicle.registerProvince}">
                                <spring:eval expression="@autoDictionaryService.selectCity(auctionVehicle.currentProvince)" var="currentCity" />
                                <form:options items="${currentCity}" itemLabel="name"  itemValue="name" />
                            </c:if>
                        </form:select>
                    </li>
                      <li id="dateShow" class="width-500">
                       <p>拍卖开始时间：</p>
                        <form:input path="startTimestamp" cssClass="input-10"/>
                       <label class="inp-label">至</label>
                        <form:input path="endTimestamp" cssClass="input-10"/>
                    </li>
                    <li id="dateShow" class="width-500">
                       <p>评估日期：</p>
                        <form:input path="evalStartTimestamp" cssClass="input-10"/>
                        <label class="inp-label">至</label>
                        <form:input path="evalEndTimestamp" cssClass="input-10"/>
                    </li>
                    
                    <li class="width-500 advancedSearch">
                        <p>上牌城市：</p>
                        <form:select path="registerProvince"  onchange="selectCity('#registerCity','#registerProvince');">
                            <form:option value="" label="请选择" />
                            <spring:eval expression="@autoDictionaryService.selectProvince()" var="registerProvince" />
                            <form:options items="${registerProvince}" itemLabel="name"  itemValue="name" />
                        </form:select>
                        <form:select path="registerCity" >
                            <form:option value="" label="请选择" />
                            <c:if test="${null != auctionVehicle.registerProvince}">
                                <spring:eval expression="@autoDictionaryService.selectCity(auctionVehicle.registerProvince)" var="registerCity" />
                                <form:options items="${registerCity}" itemLabel="name"  itemValue="name" />
                            </c:if>
                        </form:select>
                    </li>
                    <li class="width-250 advancedSearch">
                        <p>车辆类型：</p>
                        <spring:eval expression="@usedvehicleDictionaryService.selectVehicleType()" var="vehicleType" />
                        <form:select path="vehicleType">
                            <form:option value="" label="请选择" />
                            <form:options items="${vehicleType}" itemLabel="name"  itemValue="name" />
                        </form:select>
                    </li>
                    <li class="width-250 advancedSearch">
                        <p>委托方：</p>
                        <form:input path="memberName"/>
                    </li>
                    <li class="width-250 advancedSearch">
                        <p>热门推荐：</p>
                        <form:select path="recommend">
                            <form:option value="" label="请选择" />
                            <form:option label="是" value="true" />
                            <form:option label="否" value="false" />
                        </form:select>
                    </li>
                </ul>
                <div class="query">
                	<shiro:hasPermission name="auct:av:query">
	                 	<a id="search" class="query_btn" onclick="">查询</a>
	                 	<a id="morechoice" class="query_btn ml10">高级选项</a>
	                 	<a class="query_btn ml10" onclick="common.formReset('auctionVehicleForm')">清空条件</a>
                 	</shiro:hasPermission>
             	</div>
         </form:form>
        </div>
    </div>
    <shiro:hasPermission name="auct:av:auctionSync"><input id="auctionSync"        class="addbtn query_btn_2" type="submit" value="同步拍"></shiro:hasPermission>
	<shiro:hasPermission name="auct:av:online"><input id="online"             class="addbtn query_btn_2" type="submit" value="在线拍"></shiro:hasPermission>
	<shiro:hasPermission name="auct:av:onceBid"><input id="onceBid"            class="addbtn query_btn_2" type="submit" value="即时拍"></shiro:hasPermission>
    <shiro:hasPermission name="auct:av:cash"><input id="cash"               class="addbtn query_btn_2" type="submit" value="费用批量设置"></shiro:hasPermission>
    <shiro:hasPermission name="auct:av:seeCar"><input id="seeCar"             class="addbtn query_btn_2" type="submit" value="看车批量设置"></shiro:hasPermission>
    <shiro:hasPermission name="auct:av:cancelAuction"><input id="cancelAuction"      class="addbtn query_btn_2" type="submit" value="取消拍卖"></shiro:hasPermission>
    <shiro:hasPermission name="auct:av:cancelAuction1"><input id="cancelAuction1"     class="addbtn query_btn_2" type="submit" value="撤拍"></shiro:hasPermission>
    <shiro:hasPermission name="auct:av:tempAuctionVehicle"><input id="tempAuctionVehicle" class="addbtn query_btn_2" type="submit" value="新建临时拍品"></shiro:hasPermission>
    <shiro:hasPermission name="auct:av:subAuctionVehicle"><input id="subAuctionVehicle"  class="addbtn query_btn_2" type="submit" value="替换临时拍品"></shiro:hasPermission>
    <shiro:hasPermission name="auct:av:changeSaleRequest"><input id="changeSaleRequest"  class="addbtn query_btn_2" type="submit" value="更改销售需求"></shiro:hasPermission>
    <shiro:hasPermission name="auct:av:postedOn"><input id="postedOn"           class="addbtn query_btn_2" type="submit" value="直接发布展厅"></shiro:hasPermission>
    <div class="container_main">
     <div style="padding:10px 20px;">
        <table  id="auctionvehicleTable" style="width:2000px;">
            <thead>
                <tr>
                    <td width=25><div><span><input type="checkbox" onclick="selectAll(this)"></span></div></td>
                    <td width=60><div><span>操作</span></div></td>
                    <td width=120><div><span>车辆编号</span></div></td>
                    <td width=80><div><span>车辆照片</span></div></td>
                    <td width=160><div class="locklast"><span>品牌型号</span></div></td>
                    <td width=80>车牌号</td>
                    <td width=60>车辆来源</td>
                    <td width=60>拍卖类型</td>
                    <td width=60>拍品类型</td>
                    <td width=60>拍卖状态</td>
                    <td width=60>竞拍区域</td>
                    <td width=70>开始时间</td>
                    <td width=70>结束时间</td>
                    <td width=80>起拍价(万元)</td>
                    <td width=80>加价幅度(元)</td>
                    <td width=80>保留价(万元)</td>
                    <td width=60>竞得人</td>
                    <td width=60>成交车价</td>
                    <td width=60>佣金</td>
                    <td width=60>成交总价</td>
                    <td width=60>办证费</td>
                    <td width=60>出库费</td>
                    <td width=50>最高出价(万元)</td>
                    <td width=60>VIN码</td>
                    <td width=60>排量</td>
                    <td width=60>车辆颜色</td>
                    <td width=80>首次上牌时间</td>
                    <td width=60>入库时间</td>
                    <td width=60>评估师</td>
                    <td width=60>委托方</td>
                    <td width=60>评估部门</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pagination.dataList}" var="item">
                    <tr>
                        <td>
                            <div>
                              <span auditFlag = "${item.vehicle.auditFlag}">
                                     <%--edit by zjz 只有普通审核的车辆才允许操作（商家审核车辆不允许） 2015-11-26 09:37:39--%>
                                     <c:if test="${item.vehicle.auditFlag==0}">
	                                      <input type="checkbox" id="chk${item.vehicleId}" value="${item.id },${item.vehicleId}"  avSid="${item.id }"  status="${item.status }"  auctionType="${item.auctionType }" onclick="setSelectAll(this)" />
	                                      <input type="hidden" name="source" value="${item.source}">
	                                      <input type="hidden" value="${item.status}">
	                                      <input type="hidden" value="${item.code }${item.brand }${item.vehicleModel }${item.selledName }">
                                      </c:if>
                                </span>
                             </div>
                        </td>
                        <td><div><span>
                        	<c:if test="${item.vehicle.auditFlag==0}">
	                            <c:if test="${item.status=='0'||item.status=='1'}">
	                                <a href="${ctx}/auctionvehicle/view?vehicleId=${item.vehicleId}&id=${item.id}" target="_blank">编辑</a>
	                            </c:if>
                            </c:if>
                        </span></div></td>
                        <td><div><span>
                           <c:choose>
                            <c:when test="${item.source eq 'av' }">
		                         <a href="javascript:;"  onclick="editTempAuctionVehicle('${item.vehicleId}')" >
		                         ${item.code }
		                         </a>
                            </c:when>
                            <c:otherwise>
		                          ${item.code }
                            </c:otherwise>
                            </c:choose>
                        </span></div></td>
                        <td>
                        <div><span>
                            <spring:eval expression="@autoDictionaryService.choiceImgUrl('60X45', item.photoUrl)" var="photoUrl" />
                            <c:choose>
                               <c:when test="${empty photoUrl}">
                                   <img style="width: 60px;height: 45px;" src="http://img.autostreetscdn.com/common/build/2.00/images/noimg.png" />
                               </c:when>
                               <c:otherwise>
                           			 <img style="width: 60px;height: 45px;" src="${dfsHttpServer}/${photoUrl}" />
                               </c:otherwise>
                            </c:choose>
                        </span></div>
                        </td>
                        <td style="text-align: left;">
                            <div class="locklast">
                                <span style="text-align: left; margin-left: 5px;">
                                    <c:if test="${item.recommend}">［热］<!-- <img src="${ctx}/resources/auction/临时.png" style="vertical-align:middle;"> --></c:if>
                                    <c:if test="${item.source eq 'av'}"><img src="${ctx}/resources/auction/临时.png" style="vertical-align:middle;"></c:if>
                                    <a href="http://admin-auction.autostreets.com/vehicle/vehicleDetail?code=${item.code}" target="_blank" style="text-decoration:none">
                                        ${item.brand}${item.vehicleModel}<br/>${item.selledName}
                                    </a>
                                </span>
                            </div>
                        </td>
                        <td><p>${item.licenseCode}</p></td>
                        <td>
                            <p>
                            	<c:if test="${item.vehicleSrcType== 1 }">集团客户</c:if>
	                            <c:if test="${item.vehicleSrcType== 2 }">大客户</c:if>
	                            <c:if test="${item.vehicleSrcType== 3 }">个人</c:if>
                            </p>
                        </td>
                        <td>
                            <p>
	                            <c:if test="${item.auctionType== 0 }">同步拍</c:if>
	                            <c:if test="${item.auctionType== 1 }">在线拍</c:if>
	                            <c:if test="${item.auctionType== 2 }">即时拍</c:if>
                            </p>
                        </td>
                        <td>
                            <p>
	                            <c:if test="${item.avType==0}">有底价</c:if>
	                            <c:if test="${item.avType==1}">无底价</c:if>
                            </p>
                        </td>
                        <td>
                            <p>
                                <c:if test="${item.status=='0' }">待拍卖</c:if>
                                <c:if test="${item.status=='1' }">已上架</c:if>
                                <c:if test="${item.status=='2' }">拍卖成功</c:if>
                                <c:if test="${item.status=='3' }">成交确认</c:if>
                                <c:if test="${item.status=='4' }">流拍</c:if>
                                <c:if test="${item.status=='5' }">正在拍</c:if>
                                <c:if test="${item.status=='6' }">暂停</c:if>
                                <c:if test="${item.status=='7' }"><font color="red">取消订单</font></c:if>
                            </p>
                        </td>
                        <td><p><%-- ${item.province } --%>${item.city }</p></td>
                        <td><p><fmt:formatDate value="${item.planStartTime}" pattern="yyyy-MM-dd HH:mm" /></p></td>
                        <td><p><fmt:formatDate value="${item.planEndTime}" pattern="yyyy-MM-dd HH:mm" /></p></td>
<%--                         <spring:eval expression="@vehiclePriceLogService.selectLastLogByVehicleId(${item.vehicleId},0)" var="dj" /> --%>
                        <td><p>
                        <span>
                        	<fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.startPrice/10000 }"></fmt:formatNumber>
                        </span>
                        <c:if test="${item.status==1&&item.auctionType==1 }">
                            <img onclick="openStartPrice('${item.id}',this)" src="${ctx}/resources/auction/icon_editsmall.gif" style="width: 12px; cursor: pointer;" align="absmiddle">
                        </c:if>
                        </p></td>
                        <td><p>${item.plusRange}</p></td>
                        <td><p>
                        <span>
                            <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.reservePrice/10000 }"></fmt:formatNumber>
                        </span>
                        <c:if test="${(item.status==1||item.status==5||item.status==6)&&item.auctionType==1 }">
                            <img onclick="openReservePrice('${item.id}',this)" src="${ctx}/resources/auction/icon_editsmall.gif" style="width: 12px; cursor: pointer;" align="absmiddle">
                        </c:if>
                        </p>
                        </td>
                        <td><p>${item.bidderName}</p></td>
                        <td><p>${item.finalPrice}</p></td>
                        <td><p>${item.commission}</p></td>
	                    <td><p>${item.finalPrice+item.commission+item.licenseFee+item.exWarehouseFee }</p></td>
	                    <td><p>${item.licenseFee}</p></td>
	                    <td><p>${item.exWarehouseFee }</p></td>
                        <%--  <td><p>${item.bidQuantity}</p></td> --%> 
                        <td><p>
                            <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.maxPrice/10000 }"></fmt:formatNumber>
                        </p></td>
                        <td><p>${item.vinCode}</p></td>
                        <td><p>${item.sweptVolume}<c:if test="${item.sweptVolume!=null}">${item.sweptVolumeType }</c:if></p></td>
                        <td><p>${item.bodyColor}</p></td>
                        <td><p>
                        <fmt:parseDate var="registerLicenseYears" value="${item.registerLicenseYears}" pattern="yyyyMM"></fmt:parseDate>
                        <fmt:formatDate  value="${registerLicenseYears}" pattern="yyyy年MM月"/>
                        </p></td>
                        <td><p><fmt:formatDate value="${item.inGarageTimestamp}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
                        <td><p>${item.vehicleAppraiser}</p></td>
                        <td><p>${item.client}</p></td>
                        <td><p>${item.evaluationDept}</p></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
        <!-- 分页加载 -->
      <c:if test="${pagination!=null}">
       <c:if test="${pagination.count>10 }">
	        <div class="pagination fr">
	             <div id="kkpager"></div>
	       </div>
        </c:if>
       </c:if>
       <!-- 同步拍 -->
       <%@include file="auctionVehicleSync.jsp" %>
       <!-- 在线拍 -->
       <%@include file="auctionVehicleOnline.jsp" %>
       <!-- 即时拍 -->
       <%@include file="auctionVehicleOnceBid.jsp" %>       
       <!-- 费用批量设置 -->
       <%@include file="auctionVehicleCash.jsp" %>
       <!-- 看车批量设置 -->
       <%@include file="auctionVehicleSeeCar.jsp" %>
       <%@include file="editOnlineReservePrice.jsp" %>
       <%@include file="editOnlineStartPrice.jsp" %>
       <!--新增临时拍品 -->
       <%@include file="tempAuctionVehicle.jsp" %>
       
       
       <!--替换临时拍品 -->
       <%@include file="substituteAuctionVehicle.jsp" %>
    </div>
    </div>
</div>

<div id="postedOnDiv" class="UED_hide">
    <div class="pop_box" style="width: 600px;">
        <div class="pop_tittle">
            <h3 id="UED_layer_h3_v31">发布完成<span id="_titleSpan"></span></h3>
            <a href="javascript: postedOnDivClose();" class="close"></a>
        </div>
        <div class="s_box">
            <ul class="s_form">
                <li id="msgLi" style="height: 200px;"></li>
            </ul>
            <p align="center" class="controlbox">
                <input type="submit" class="button_lv4_1" value="关闭" onclick="javascript: postedOnDivClose();" />
            </p>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/resources/auction/all.js"></script>
<script type="text/javascript" src="${ctx}/resources/auction/adv.query.js"></script>
<script type="text/javascript">
$(document).ready(function (){
    //高级选项
    $("#morechoice").click(function () {
        if($("#filter").hasClass('low')){      
            $(this).html("隐藏选项");
            $('.advancedSearch').show();
            $("#filter").removeClass('low');
        }
        else{
            $(this).html("高级选项");
            $('.advancedSearch').hide();
            $("#filter").addClass('low');
        }
    });

    $("#evalStartTimestamp").datetimepicker({
        showSecond: true,
        changeMonth: true,
        changeYear: true,
        yearRange:'c-30:c',//前30年和后0年
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
    $("#evalEndTimestamp").datetimepicker({
        showSecond: true,
        changeMonth: true,
        changeYear: true,
        yearRange:'c-30:c',//前30年和后0年
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
    
    $.fn.TableLock({
    	table : 'auctionvehicleTable',
    	lockRow : 0,
    	lockColumn : 5,
    	width : $('.container_top').width()- 24,
    	height : ''
    });
    
    $('#auctionvehicleTable').find('div').each(
  		function() {
  		    var pheight = $(this).parent().height();
              if(pheight <= 60){
                  pheight = 60;
              }
              $(this).height(pheight);
  			$(this).find('span').css("marginTop",-$(this).find('span').height() / 2);
    });
    aside_h();

    //$('#datatable tr td:last-child').css('border-right', '0');

    //清空所有查询条件
    clearQueryConds("clear","m_content","${ctx}/auctionVehicle/index");
    dateHidden();
    $("#selectAll").click(function (){ selectAll(cbId);  });
    
    //同步拍
    $("#auctionSync").click(function (){ showAuctionDiv("auctionSyncDiv");  });
    //即时拍
    $("#onceBid").click(function (){ showAuctionDiv("auctionOnceBidDiv");  });    
    //费用批量设置
    $("#cash").click(function (){ showAuctionDiv("auctionCashDiv");  });
    //看车批量设置
    $("#seeCar").click(function (){ showAuctionDiv("auctionSeeCarDiv");  });
    //取消拍卖
    $("#cancelAuction").click(function (){ cancelAuction();  });
    $("#cancelAuction1").click(function (){ cancelAuction1();  });
    //新建临时拍品
    $("#tempAuctionVehicle").click(function (){addTAuctionVehicle("addTempAuctionVehicle"); });
    //替换临时拍品
    $("#subAuctionVehicle").click(function (){subTAuctionVehicle("substituteAuctionVehicle"); });
    //在线拍
    $("#online").click(function (){  
    	//修正点击全选按钮后弹层的复选框也会被选中的问题
     	 $('.s_box :checkbox').attr("checked",false);
    	showAuctionDiv("auctionOnlineDiv"); });
    //更改销售需求
    $("#changeSaleRequest").click(function(){
         var arrChks = common.getSelectIds("auctionvehicleTable");
         var size = arrChks.length;
         var allSids="";
         var result = false;
         if (size > 0) {
        	if(!confirm("您是否确认将所选车辆转入网上展厅？")){
        		 return false;
        	 }
        	 var isExistTempVehicle = false;
        	 $.each(arrChks,function(i,n){
        	     var inputObj=$("#chk"+n.split(",")[1]);
        	     var source=$(inputObj).next().val();
        		 if (source == "av") {
        		 	isExistTempVehicle = true;
        		 }
 	    		 allSids += $(inputObj).val() + "||";
        	 })
    
        	 if (isExistTempVehicle) {
        		alert("临时拍品车不能转展厅！");
     			return false; 
        	 }
        	 $.ajax({
                 type:"post",
                 dataType:"json",
                 async: false,
                 url:"${ctx}/auctionvehicle/changeSaleRequest",
                 data:{allSids : allSids},
                 success:function(data){
                	 result = data.data;
                 }
         	 });
        	 
        	 if (result) {
        		 alert("转入网上展厅成功!");
        		 $("#auctionVehicleForm").submit();
        	 } else {
        		 alert("您选择的车辆中包含非流拍车辆，请重新选择！");
        		 return false;
        	 }
        	
         } else {
        	window.alert("请选中要操作的记录~~~~");
        	return false;
         }
     	
    	
    });

    // 直接发布展厅
    $("#postedOn").click(function() {
    	var arrChks = common.getSelectIds("auctionvehicleTable");
        var size = arrChks.length;
        var allSids="";
        var allNames="";
        var status;
        var name;
        if (size > 0 && size <= 10) {
            var flag = false;
            $.each(arrChks,function(i,n){
       	         var inputObj=$("#chk"+n.split(",")[1]);
	       	     status = $(inputObj).next().next().val();
	             name = $(inputObj).next().next().next().val();
	             if (status != 4) {
	                 flag = true;
	             }
	             allSids += $(inputObj).val().split(",")[0] + ",";
	             allNames += name + "\n";
            });
   
            if (flag) {
               alert("车辆非流拍，不能发布！");
               return false; 
            }
            if(!confirm("确定直接发布以下" + size + "辆车到展厅？\n" + allNames)){
                return false;
            }
            $.post("${ctx}/auctionvehicle/postedOnAPrice",{
            	allSids: allSids
            },function(result, status){
            	var success = result.success;
                var msg = "";
                var title = "";
            	if (success) {
					var data = result.data;
					var msgList = data.msgList;
					var successCount = data.successCount;
                    var failedCount = data.failedCount;
					$.each(msgList, function(index, item) {
						if (msg.length > 0) {
							msg += "<br>";
						}
						msg += item;
					});
					title = "已成功发布" + successCount + "辆，失败" + failedCount + "辆。";
				} else {
					title = "发布失败";
					msg = result.msg;
				}
                $("#postedOnDiv").find("#UED_layer_h3_v31").html(title);
                $("#postedOnDiv").find("#msgLi").html(msg);
                $.LAYER.show({id : "postedOnDiv"});
            });
        } else if (size == 0) {
           window.alert("请选中要操作的记录~~~~");
           return false;
        } else {
            window.alert("最多只能选择10条要操作的记录~~~~");
            return false;
		}
    });
    
    var showAuctionDiv = function(id) {
    	var arrChks = common.getSelectIds("auctionvehicleTable");
        var size = arrChks.length;
        var allSids="";
        //选择的数据是否包含无拍卖会关联的拍品,true--->批量设置费用
        var auctionFlag = true;
        var isShow = true;
        var isExistsTempAuctionVehicle = false;
        var source = "";
        if (size > 0) {
        	$.each(arrChks,function(i,n){
        		var inputObj=$("#chk"+n.split(",")[1]);
        		
        		allSids += $(inputObj).val() + "||";
				var status=$(inputObj).attr("status");
				if(status!="0"&&status!="1"){ auctionFlag=false;}
				if(status=="2"||status=="3"||status=="5"||status=="6"){ isShow=false;}
				$("#allSids").val(allSids);
                $("#cashAllSids").val(allSids);
                $("#seeCarAllSids").val(allSids);
                $("#onlineSids").val(allSids);
                $("#onceBidSids").val(allSids);//即时拍
                
                source = $(inputObj).next().val();
                if (source == "av") {
                	isExistsTempAuctionVehicle = true;	
              	}
        	});
		    
			if ((id=="auctionOnlineDiv"||id=="auctionOnceBidDiv")  && isExistsTempAuctionVehicle) {
				window.alert("您选中的部分拍品为临时拍品，请重新选择~~~");
				return false;
			}
		   
			if(!isShow&&(id=="auctionSyncDiv"||id=="auctionOnlineDiv"||id=="auctionOnceBidDiv"||id=="auctionCashDiv"||id=="auctionSeeCarDiv")){
			window.alert("您选中的部分拍品为【拍卖成功】或【成交确认】或【正在拍】或【暂停】不能进行此操作，请重新选择~~~");
			return;
		  }
		  
		   if(id=="auctionSyncDiv"||id=="auctionOnlineDiv"||id=="auctionOnceBidDiv"){
			  $.LAYER.show({id : id});
	             return;
	        }else if(auctionFlag&&(id=="auctionCashDiv"||id=="auctionSeeCarDiv")){
			    $.LAYER.show({id : id});
			    return;
			}else{
				window.alert("您选中的部分拍品不在竞拍中，请先进行竞拍操作~~~");
			}
		} else if (size == 0) {
			window.alert("请选中要操作的记录~~~~");
			return;
		}
      };
      //新增临时拍品
      var addTAuctionVehicle = function(id){
    	   $("#tempBrand").val("");
    	   $("#tempBrandSeries").val("");
    	   $("#tempVehicleModel").val("");
    	   $("#tempLicenseCodeId").val("");
    	   $("#tempRegisterYear").val("");
    	   $("#tempRegisterMonth").val("");
    	   $("#tempDisplayMileage").val("");
    	   $("#tempStartBidPrice").val("");
    	   $("#tempReservePrice").val("");
    	   $("#operation").val("add");
    	   $("#addTempAuctionVehicle_title").text("新建临时拍品");
    	   $.LAYER.show({id : id});
		  return; 
      }
      
      //替换临时拍品
      var subTAuctionVehicle = function(id) {
    	  var arrChks = common.getSelectIds("auctionvehicleTable");
          var size = arrChks.length;
          //选择的数据是否包含无拍卖会关联的拍品,true--->批量设置费用
          if (size > 1 || size == 0) {
          	  alert("请选择一个临时拍品！");
        	  return false;
          } 
          var source = "";
      	  $.each(arrChks,function(i,n){
	         var inputObj=$("#chk"+n.split(",")[1]);
	         source = $(inputObj).next().val();
	         $("#tauctionVehiceleSid").val($(inputObj).val().split(",")[0]);
	         $("#tempVehicleSid").val($(inputObj).val().split(",")[1]);
      	  });
		  
      	  if (source != "av") {
      		alert("您勾选的不是临时车辆，无法进行替换。请选择正确的临时车辆。");
      	  	return false;
      	  }
      	  $("#subVehicleCode").val("");
      	  $("#saveSubAuctionVehicle").hide();
    	  $("#closeSubAuctionVehicle").hide();
    	  $("#vehicle_info").html("");
          $.LAYER.show({id : id});
          return;
        };  
		
	//分页
	kkpager.generPageHtml({
		pno : '${pagination.current}',
		//总页码
		total : '${pagination.total}',
		//总数据条数
		totalRecords : '${pagination.count}',
		pageSize : '${pagination.length}',
		//链接前部
		hrefFormer : '${ctx}/auctionvehicle/index',
		//设置每页显示条数
        isShowSelectPageSize : true,
	    mode : 'click', //设置为click模式
        click : function(n){
        	sessionStorage.setItem("av_morechoice",$("#morechoice").html());
            var queryString = $('#auctionVehicleForm').serialize();
            location.href=this.hrefFormer + this.hrefLatter + "?current=" + n +'&length='+ this.pageSize+ '&' + queryString;
	    },
	    //getHref是在click模式下链接算法，一般不需要配置，默认代码如下
	    getHref : function(n){
	        return '#';
	    }
		//链接算法
		/* getLink : function(n) {
			var queryString = $('#auctionVehicleForm').serialize();
			return this.hrefFormer + this.hrefLatter + "?current=" + n +'&length='+ this.pageSize+ '&' + queryString;
		  } */
		});
});
//编辑临时拍品
var editTempAuctionVehicle = function(vehicleSid){
	//重新调用品牌级联选择函数
	
	$.ajax({
        type:"post",
        dataType:"json",
        url:"${ctx}/auctionvehicle/selectVehicleByPrimaryKey",
        data:{id:vehicleSid},
        success:function(data){
           $("#tempDisplayMileage").val(data.displayMileage);
           $("#tempCode").val(data.code);
           $("#tempBrand").val(data.brand);
           changeBrand();
           $("#tempBrandSeries").val(data.brandSeries);
           $("#tempVehicleModel").val(data.vehicleModel);
           $("#tempLicenseCodeId").val(data.licenseCode);
           $("#tempRegisterYear").val(data.registerYear);
           $("#tempRegisterMonth").val(data.registerMonth);
           $("#tempStartBidPrice").val(data.startBidPrice);
           $("#tempReservePrice").val(data.reservePrice);
           $("#tempVehicleId").val(vehicleSid);
        }
	});
	$("#operation").val("edit");
	$("#addTempAuctionVehicle_title").text("编辑临时拍品");
	showLayerDiv("addTempAuctionVehicle");
};

var dateHidden= function(){
	    var status=$("#status").val();
	    if(status=="9"){
	    	$("#dateShow").hide();
	    	$("#startTimestamp").val("");
	    	$("#endTimestamp").val("");
	    	$("#auctionCode").val("");
	    	$("#_auctionCode").hide();
	    	$("#show1").hide();
	    	$("#show2").hide();
	    	$("#type").val("");
	    	$("#avType").val("");
	    }else {
	        $("#dateShow").show();
	        $("#show1").show();
	        $("#show2").show();
	        $("#_auctionCode").show();
	  }
};
	

	/**
	 * 拍品取消
	 * 2014年7月21日 13:53:13
	 * Roceys
	 * V1.0
	 */
var cancelAuction = function() {
    	var arrChks = common.getSelectIds("auctionvehicleTable");
	    var size = arrChks.length;
	    var allSids="";
	    //拍品状态判断
	    var status=true;
	    //同步拍判断
	    var sync=true;
	    //在线拍判断
	    var online=true;
	    if (size > 0) { 
	    	$.each(arrChks, function(i, n){
	    		var inputObj=$("#chk"+n.split(",")[1]);
	    		allSids += $(inputObj).val() + "||";
		        var f = $(inputObj).attr("status");
		        var f1 = $(inputObj).attr("auctionType");
		        if(f!="0"&&f!="1"){//待拍卖、已上架
		            status=false;
		        }
		        if(f1=="0"&&f!="0"){//同步拍状态为待拍卖
		           sync=false;
		        }
		        if(f1=="1"&&f!="1"){//在线拍状态为已上架
	               online=false;
	            }
	    	});
	    	
	        if(allSids!=""){
	            if(status&&sync&&online){
	                $.ajax({
	                    type:"post",
	                    dataType:"json",
	                    url:"${ctx}/auctionvehicle/cancel",
	                    data:{allSids:allSids},
	                    success:function(data){
	                        if(data){
	                            window.alert("拍品取消成功!");
	                            $("#auctionVehicleForm").submit();
	                            return;
	                        }else {
	                            window.alert("系统异常请联系管理员！");
	                            return;
	                        }
	                    }
	                });
	            }else {
	                 window.alert("只能取消同步拍中【待拍卖】或在线拍中【已上架】拍品，请重新选择!");
	                 return;
	            }
	        }
	    }else if (size == 0) {
            window.alert("请选中要操作的记录~~~~");
            return;
        }
};
	
/**
 * 撤拍
 * 2014年8月29日 14:52:07
 * Roceys
 * V1.0
 */
var cancelAuction1 = function() {
	var arrChks = common.getSelectIds("auctionvehicleTable");
    var size = arrChks.length;
    var allIds="";
    //拍品状态判断
    var status=true;
    if (size > 0) {    
    	$.each(arrChks, function(i, n){
    	    var inputObj=$("#chk"+n.split(",")[1]);
    	    allIds += $(inputObj).val() + "||";
            var f = $(inputObj).attr("status");
            if(f==""){//待售
            	status=false;
            }
    	});
        
        if(allSids!=""){
            if(status){
                $.ajax({
                    type:"post",
                    dataType:"json",
                    url:"${ctx}/auctionvehicle/cancel1",
                    data:{allIds:allIds},
                    success:function(data){
                        if(data){
                            window.alert("撤拍成功！");
                            $("#auctionVehicleForm").submit();
                            return;
                        }else {
                            window.alert("系统异常请联系管理员！");
                            return;
                        }
                    },  
                    error : function() {  
                        window.alert("系统异常，请联系管理员！");
                      }
                });
            }else {
                 window.alert("只能撤消【非待售】状态拍品，请重新选择!");
                 return;
            }
        }
    }else if (size == 0) {
        window.alert("请选中要操作的记录~~~~");
        return;
    }
};
/**
 * 拍品保留价编辑
 *2014年7月29日 19:53:15
 * Roceys
 * V2.0
 */
var openReservePrice = function(sid,a) {
	 var trNode = $(a).parent().parent().parent();
	 var inputCheck = trNode.children().eq(0).find("input");
	 var status = inputCheck.attr("status");
     var auctionType = inputCheck.attr("auctionType");
     
	 var forthChildTdNode =  trNode.children().eq(4);  
	 $("#vehicleTitle").html(forthChildTdNode.text());
	 
	 var currentPrice = $(a).prev().text(); 
	 currentPrice=roceysTrim(currentPrice,true);
	 $("#newPrice").val(currentPrice);
	 
      $.ajax({
          type:"get",
          dataType:"json",
          url:"${ctx}/auctionvehicle/to-edit-price",
          data:{sid:sid},
          success:function(data){
        	  if(data==null||data==""){
        		  data="0";
        	  }
        	  $("#sid").val(sid);
        	  $("#maxPrice").html(data);
        	  $.LAYER.show({id : "auctionEidtPriceOnline"});
          },
          error: function(XMLHttpRequest, textStatus, errorThrown){  
        	  alert("系统异常请联系管理员！");
        	  return;
          }
      });
      
};

/**
 * 拍品起拍价编辑
 */
var openStartPrice = function(sid,a) {
	 var trNode = $(a).parent().parent().parent();
	 var inputCheck = trNode.children().eq(0).find("input");
	 var status = inputCheck.attr("status");
     var auctionType = inputCheck.attr("auctionType");
     
	 var forthChildTdNode =  trNode.children().eq(4);  
	 $("#startPriceVehicleTitle").html(forthChildTdNode.text());
	 
	 var currentPrice = $(a).prev().text(); 
	 currentPrice=roceysTrim(currentPrice,true);
	 $("#editStartPriceLicenseCode").html(trNode.children().eq(5).text());
	 $("#newStartPrice").val(currentPrice);
	 $("#startPriceSid").val(sid);
	  $.LAYER.show({id : "auctionEditStartPriceOnline"});
};

var showLayerDiv = function(id) {
	 $.LAYER.show({id : id});
    return;
};

function postedOnDivClose() {
	$.LAYER.close();
	$("#auctionVehicleForm").submit();
};

var selectCity = function(cityInput,proInput){
	var proName = $(proInput).val();
	var cityValue = $(cityInput).val();
	if (proName!=""&&null != proName) {
		$.ajax({
			url :"${ctx}/auctionvehicle/getCitys",
			type: "get",
			dataType : "json",
			//contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data : {proId:proName},
			success : function(data) {
				$(cityInput).empty();
				if(data.length>1){
					$(cityInput).append("<option value ='' selected='selected'>请选择</option>");
				}
				$.each(data, function(index, item){
					//item.id
					$(cityInput).append("<option value ='"+ item.city +"'>" +item.city + "</option>");
				});
				if(cityValue!=""){
					$(cityInput+" option[value='"+cityValue+"']").prop("selected", true);
				}
			}
		});
	} else {
		$(cityInput).empty();
		$(cityInput).append("<option value ='' selected='selected'>请选择</option>");
	}
};

$("#auctionVehicleForm").keydown(function(e){
    var e = e || event,
    keycode = e.which || e.keyCode;
    if (keycode==13) {
    	$("#search").trigger("click");
    }
});

$(function(){
    var av_morechoice=sessionStorage.getItem("av_morechoice");
    if (av_morechoice=="隐藏选项") {
        $("#morechoice").click();
    }
	sessionStorage.removeItem("av_morechoice");
	$("#search").click(function(e){
		var startTimestamp = $("#startTimestamp").val();
    	var endTimestamp = $("#endTimestamp").val();
		var evalStartTimestamp = $("#evalStartTimestamp").val();
    	var evalEndTimestamp = $("#evalEndTimestamp").val();
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
    	if(evalStartTimestamp!=""){
    	    var is1=common.isDateTime(evalStartTimestamp,e);
    	    if(!is1){return;}
    	    common.setDateTime("evalStartTimestamp",evalStartTimestamp);
    	}
    	if(evalEndTimestamp!=""){
    	    var is2=common.isDateTime(evalEndTimestamp,e);
    	    if(!is2){return;}	
    	    common.setDateTime("evalEndTimestamp",evalEndTimestamp);
    	}
    	sessionStorage.setItem("av_morechoice",$("#morechoice").html());
    	$('#auctionVehicleForm').submit();
	});
	
});

</script>
</body>
</html>