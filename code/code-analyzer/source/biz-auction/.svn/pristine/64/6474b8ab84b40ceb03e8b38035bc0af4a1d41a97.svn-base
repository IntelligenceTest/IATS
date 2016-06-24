<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>网上展厅</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<style type="text/css">
#showOffShelvesRemark {
	   position: absolute;
	   height: 100px;
       width: 200px;
       background-color:gray; 
	}
	#showOffShelvesRemark h1 {
       text-align: center;
       font-weight: bold;
       color: blue;
       padding-top: 5px;
	}
	#showOffShelvesRemark p {
       padding: 0 5px 5px 5px;
	}
</style>
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
          <form:form action="${ctx }/fixedPrice/index" method="post" commandName="fixedPrice" id="fixedPriceForm">
             <ul class="filter sa-sreach-list">
                 <li class="width-250">
                 	  <p>品牌：</p> 
                      <spring:eval expression="@brandseriesService.selectDictBrandseries(null,null,null)" var="brands" />
                      <form:select path="vehicle.brand" >
                          <form:option value="" label="请选择" />
                          <c:forEach items="${brands}" var="b">
                              <form:option value="${b.name}" label="${b.firstPinyin}-${b.name}" />
                          </c:forEach>
                      </form:select>
                 </li>
                 <li class="width-250">
                 	  <p>车辆来源：</p>
                      <form:select path="vehicle.source" >
                          <form:option value="" label="请选择"></form:option>
                          <spring:eval expression="@autoDictionaryService.selectResource('vehicle_source')" var="source" />
                          <form:options items="${source}" itemLabel="name" itemValue="value"></form:options>
                      </form:select>
                 </li>
                 <li class="width-250">
                    <p>VIN码：</p> 
                    <form:input path="vehicle.vinCode"  />
                 </li>
                 <li class="width-250">
                    <p>车辆编号：</p> 
                    <form:input path="vehicle.code"  />
                 </li>
                 <li class="width-250">
                   <p>车牌号：</p> 
                      <form:input path="vehicle.licenseCode"/>
                 </li>
                 <li class="width-250">
                   <p>评估部门：</p>
                   <form:input path="vehicle.evaluationDept" />
                 </li>
                 <li class="width-250">
                   <p>展售状态：</p>
                      <form:select path="status"  onchange="dateHidden();">
	                      <form:option value="99" label="请选择"></form:option>
	                      <form:option value="9" label="待售"></form:option>
	                      <spring:eval expression="@autoDictionaryService.selectResource('fixed_price_status')" var="status" />
	                      <form:options items="${status}" itemLabel="name" itemValue="value"></form:options>
                      </form:select>
                  </li>
	              <li class="width-250">
	                 <p>展品编号：</p> 
	                 <form:input path="code" id="fpcode"  maxlength="40"/>
	              </li>
	              <li class="width-500">
	                 <p>上架时间：</p>
	                 <form:input path="startTimestamp" />
	                 <label class="inp-label">至</label>
	                 <form:input path="endTimestamp" />
	              </li>
                </ul>
                <div class="query">
                	<shiro:hasPermission name="auct:fp:query">
	                    <a id="search" class="query_btn">查询</a>
	                    <a class="query_btn ml10" onclick="common.formReset('fixedPriceForm')">清空条件</a>
                    </shiro:hasPermission>
                </div>
            </div>
        </form:form>
       </div>
       <shiro:hasPermission name="auct:fp:on">
      		<input id="onSell1" class="addbtn query_btn_2" type="submit" value="上架">
      </shiro:hasPermission>
       <shiro:hasPermission name="auct:fp:off">
	  		<input id="off" class="addbtn query_btn_2" type="submit" value="下架">
	   </shiro:hasPermission>
	   <shiro:hasPermission name="auct:fp:change">
      		<input id="changToAuction"  class="addbtn query_btn_2" type="submit" style="width: 100px" value="更改销售需求">
      </shiro:hasPermission>
      <div class="container_main">
       <div class="wrap">
        <table id="datatable" style="width:2500px">
            <thead>
                <tr>
                    <td width=25><div><span><input type="checkbox" onclick="selectAll(this)"></span></div></td>
                    <td width=100><div><span>操作</span></div></td>
                    <td width=80><div><span>车辆编号</span></div></td>
                    <td width=50><div><span>车辆照片</span></div></td>
                    <td width=120><div class="locklast"><span>品牌型号</span></div></td>
                    <td width=40>展品编号</td>
                    <td width=40>车辆来源</td>
                    <td width=60>展售状态</td>
                    <td width=80>展售价格(万元)</td>
                    <td width=60>集团最低限价(万元)</td>
                    <td width=80>新车售价(万元)</td>
                    <td width=80>购置税(万元)</td>
                    <td width=70>展售区域</td>
                    <td width=80>车牌号</td>
                    <td width=60>VIN码</td>
                    <td width=60>排量</td>
                    <td width=60>车辆颜色</td>
                    <td width=60>成交人</td>
                    <td width=60>成交价</td>
                    <td width=60>评估师</td>
                    <td width=60>评估部门</td>
                    <td width=60>上架申请时间</td>
                    <td width=60>上架时间</td>
                    <td width=40>浏览人数</td>
                    <td width=40>收藏人数</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pagination.dataList}" var="item">
                    <tr>
                        <td>
                            <div>
                                <span auditFlag = "${item.vehicle.auditFlag}">
                                	<%--edit by zjz 只有普通审核的车辆才允许操作（商家审核车辆不允许） 2015-12-8 11:26:02--%>
                                     <c:if test="${item.vehicle.auditFlag==0}">
	                                    <c:if test="${item.status != 2 && item.status != 6}">
	                                        <input type="checkbox" name="subcheck" value="${item.vehicle.id}" index="${item.id}" id="chk${item.vehicle.id}" status="${item.status }" onclick="setSelectAll(this)" />
	                                        <input type="hidden" name="source" value="${item.vehicle.source}">
	                                    </c:if>
                                    </c:if>
                                </span>
                             </div>
                        </td>
                        <td><%--edit by zjz 只有普通审核的车辆才允许操作（商家审核车辆不允许） 2015-12-8 11:26:02--%>
                                     <div><c:if test="${item.vehicle.auditFlag==0}"><span>
                        	<c:if test="${item.status == null || item.status == 1 || item.status==7 }">
                        		<shiro:hasPermission name="auct:fp:apply">
	                            	<a href="javascript:;" onclick="applyShelves('${item.id}','${item.vehicle.id }',false)" target="_blank" style="margin:0 0px;text-decoration:none">上架申请</a>
	                            </shiro:hasPermission>
	                            <shiro:hasPermission name="auct:fp:shelves">
	                            	<a href="javascript:;" onclick="applyShelves('${item.id}','${item.vehicle.id }',true)"  target="_blank" style="margin:0 0px;text-decoration:none">直接上架</a>
	                             </shiro:hasPermission>
                            </c:if>
                             <c:if test="${item.status == 0}">
                             	<shiro:hasPermission name="auct:fp:edit">
	                            	<a href="javascript:;" onclick="editFixedPrice('${item.id}')"  target="_blank" style="margin:0 0px;text-decoration:none">编辑</a>
	                            </shiro:hasPermission>
	                            <shiro:hasPermission name="auct:fp:failure">
	                           		<a href="javascript:;" onclick="onAuditFailure('${item.id}')"  target="_blank" style="margin:0 0px;text-decoration:none">上架失败</a>
	                            </shiro:hasPermission>
                            </c:if>
                            <c:if test="${item.status == 3 || item.status == 4 || item.status == 5}">
                             	 <shiro:hasPermission name="auct:fp:deal">
                            	 	<a href="javascript:void(0);" onclick="deal('${item.id}','${item.vehicle.id }',this)"  style="margin:0 0px;text-decoration:none">成交</a>
                            	 </shiro:hasPermission>
                                 <input type="hidden" value="${item.vehicle.code }">
                                 <input type="hidden" value="${item.vehicle.brand }${item.vehicle.vehicleModel }${item.vehicle.selledName }">
                                 <input type="hidden" value="${item.vehicle.licenseCode}">
                            </c:if>
                        </span></c:if></div></td>
                        <td><div><span>
	                          ${item.vehicle.code }
                        </span></div></td>
                        <td>
                        <div class="locklast"><span>
                            <spring:eval expression="@autoDictionaryService.choiceImgUrl('60X45', item.vehicle.firstPhotoUrl)" var="photoUrl" />
                            <img style="width: 60px;height: 45px;" src="${dfsHttpServer}/${photoUrl}" />
                        </span></div>
                        </td>
                         <%-- <td>
                         	${item.vehicle.source }
                         </td> --%>
                        <td style="text-align: left;">
                            <div>
                                <span style="text-align: left; margin-left: 5px;">
                                    <a href="http://admin-auction.autostreets.com/vehicle/vehicleDetail?code=${item.vehicle.code}" target="_blank" style="text-decoration:none">
                                        ${item.vehicle.brand }${item.vehicle.vehicleModel }<br/>${item.vehicle.selledName }
                                    </a>
                                </span>
                            </div></td>
                        <td><p>
                              ${item.code }
                        </p></td>
                        <td><p>
                              ${item.vehicle.source }
                        </p></td>
                        <td>
                            <p>
                            <!-- 展品状态：0-上架申请、1-已下架、2-已出售、3-已上架、4-已预订、5-已付定金、6-已付全款 -->
                                <c:if test="${ item.id==null}">待售</c:if>
                                <c:if test="${ item.status==0}"><font color="green">上架申请</font></c:if>
                                <c:if test="${ item.status==1}">
                                    <font color="gray"><b>已下架</b></font><br>
							         <a href="javascript:void(0);" onmouseover="showOffRemark(event,this);" onmouseout="hideOffRemark();">查看原因</a>
							         <input type="hidden" value=" ${item.offShelvesRemark }">
                                </c:if>
                                <c:if test="${ item.status==2}"><font color="purple"><b>已出售</b></font></c:if>
                                <c:if test="${ item.status==3}"><font color="blue"><b>已上架</b></font></c:if>
                                <c:if test="${ item.status==4}"><font color="green"><b>已预订</b></font></c:if>
                                <c:if test="${ item.status==5}"><font color="red">已付定金</font></c:if>
                                <c:if test="${ item.status==6}"><font color="red"><b>已付全款</b></font></c:if>
                                <c:if test="${ item.status==7}">
	                                <font color="gray"><b>上架失败</b></font><br>
									<a href="#" title="${item.id }" data-name="trackFpFailLog">查看原因</a>
                                </c:if>
                            </p>
                        </td>
                         <td><p>
                        <span>
                            <c:if test="${ item.price != null}">
                                <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.price/10000 }"></fmt:formatNumber>
                            </c:if>
                        </span>
                         <c:if test="${item.hidden==true}">(隐藏)</c:if>
                        </p></td>
                         <td><p>
                        <span>
                            <c:if test="${ item.lowPriceGroup != null}">
                                <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.lowPriceGroup/10000 }"></fmt:formatNumber>
                            </c:if>
                        </span>
                        </p></td>
                         <td><p>
                        <span>
                            <c:if test="${ item.newVehicleSuggestionPrice != null}">
                                <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.newVehicleSuggestionPrice}"></fmt:formatNumber>
                            </c:if>
                        </span>
                        </p></td>
                         <td><p>
                        <span>
                            <c:if test="${ item.taxBuy != null}">
                                <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.taxBuy/10000 }"></fmt:formatNumber>
                            </c:if>
                        </span>
                        </p></td>
                        <td><p>${item.city }</p></td>
                        <td><p>${item.vehicle.licenseCode}</p></td>
                        <td><p>${item.vehicle.vinCode}</p></td>
                        <td><p>${item.vehicle.sweptVolume}<c:if test="${item.vehicle.sweptVolume!=null}">${item.vehicle.sweptVolumeType }</c:if></p></td>
                        <td><p>${item.vehicle.bodyColor}</p></td>
                        <td><p>${item.order.bidderName}</p></td>
                        <td><p>${item.orderItem.finalPrice}</p></td>
                        <td><p>${item.vehicle.vehicleAppraiser}</p></td>
                        <td><p>${item.vehicle.evaluationDept}</p></td>
                        <td><p><fmt:formatDate value="${item.applyShelvesTime}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
                        <td><p><fmt:formatDate value="${item.sellTime}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
                        <td><p>${item.clickCount}</p></td>
                        <td><p>${item.favCount}</p></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
       </div>
        <!-- 分页加载 -->
      <c:if test="${pagination!=null}">
	        <div class="pagination fr">
	             <div id="kkpager"></div>
	       </div>
       </c:if>
       <%@include file="onsell-confirm.jsp" %>
       <%@include file="save.jsp" %>
       <%@include file="deal.jsp" %>
       <%@include file="offshelves.jsp" %>
       <%@include file="onAuditFailure.jsp" %>
     
     <div id="showOffShelvesRemark" class="st" style="visibility: hidden;">
		 <div class="inner">
		  <h1>下架原因：</h1>
		  <p id="offShelvesRemarkText"></p>
		 </div>
	</div>
    <div id="dialog" class="UED_hide">
		<div class="pop_box">
			<div class="pop_tittle">
				<h3>
					<span id="_titleSpan"></span>
				</h3>
				<a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
			</div>
			<div class="s_box container_top"></div>
		</div>
	</div>
    </div>
    </div>
</div>

<div id="changToAuctionDiv" class="UED_hide">
    <div class="pop_box" style="width: 250px;">
        <div class="pop_tittle">
            <h3 id="UED_layer_h3_v31">请选择拍卖方式：<span id="_titleSpan"></span></h3>
            <a href="javascript: $.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
            <input type="hidden" id="allSids" />
            <ul class="s_form">
                <li style="height: 50px;">
                    <label><input type="radio" name="requirementType" value="车道拍卖" />车道拍卖</label><br>
                    <label><input type="radio" name="requirementType" value="网上有底价拍卖" />网上有底价拍卖</label><br>
                    <label><input type="radio" name="requirementType" value="网上无底价拍卖" />网上无底价拍卖</label><br>
                </li>
            </ul>
            <p align="center" class="controlbox">
                <input type="button" class="button_lv4_1" value="确认" id="changToAuctionSubmit"/>
                <input type="button" class="button_lv4_1" value="取消" onclick="javascript: $.LAYER.close();" />
            </p>
        </div>
    </div>
</div>

<script type="text/javascript" src="${ctx}/resources/auction/all.js"></script> 
<script type="text/javascript" src="${ctx}/resources/common/roceys.1.0.min.js"></script> 
<script type="text/javascript">
$(document).ready(function (){
    //清空所有查询条件
    clearQueryConds("clear","m_content","${ctx}/fixedPrice/index");
    dateHidden();
    $("#selectAll").click(function (){ common.selectAll(cbId);  });
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
    	$("#fixedPriceForm").submit();
    });
    
    //上架申请
    $("#onSell").click(function (){ showDiv("onSellOrEdit");  });
    //上架确认
    $("#onSell1").click(function (){ showDivOnSellConfirm("onSellConfirmDIV");  });
    //下架
    $("#off").click(function (){ cancelSell(); });

    //更改销售需求   展厅转拍卖
    $("#changToAuction").click(function(){
    	var arrChks=$("input[name='subcheck']:checked");
        var size = arrChks.length;
        var allSids="";
        if (size > 0) {
        	var isExistDealerVehicle = false;
       	 	arrChks.each(function() {
       	 		var source = $(this).next().val().trim();
    			if (source == "dealer") {
    				isExistDealerVehicle = true;
    			}
	            allSids += $(this).val() + "||";
	        });
       		if (isExistDealerVehicle) {
     			alert("商家的车不能转拍卖！");
  				return false; 
     	 	}

            $("#changToAuctionDiv").find("#allSids").val(allSids);
            $.LAYER.show({id : "changToAuctionDiv"});
        } else {
       		window.alert("请选中要操作的记录~~~~");
        }
    });

    $("#changToAuctionSubmit").click(function() {
        var result = false;
        var allSids = $("#changToAuctionDiv").find("#allSids").val();
        var requirementType = $("#changToAuctionDiv").find("[name='requirementType']:checked").val();
        if (requirementType == null) {
        	alert("请选择需要销售需求");
			return false;
		}
        $.ajax({
            type:"post",
            dataType:"json",
            async: false,
            url:"${ctx}/fixedPrice/changeToAuction",
            data:{
                allSids : allSids,
                requirementType : requirementType
            },
            success:function(data){
                result = data.data;
            }
        });
        if (result) {
            alert("转拍卖成功！");
            $("#fixedPriceForm").submit();
        } else {
            alert("您选择的车辆中包含未下架车辆，请重新选择！!");
            return false;
        }
    });
    
    var showDiv = function(id) {
		var arrChks = common.getSelectIds("datatable");
        var size = arrChks.length;
        var allIds="";
        //选择的数据是否包含非待售车辆、已下架
        var sellFlag = false;
        if (size > 0) {
        	$.each(arrChks, function(i, n){
        		var inputObj=$("#chk"+n);
        		allIds += $(inputObj).attr("index")+","+$(inputObj).val() + "||";
				var status=$(inputObj).attr("status");
				if(status!="" && status !="1"){
					sellFlag=true;
				}
        	});
        	
			$("#onSellForm").clearForm();
			$("#allIds").val(allIds);
			if(!sellFlag && id=="onSellOrEdit"){
				$("#_titleSpan").html("上架申请");
				 $("#city").empty();
	             $("#city").append("<option value ='' selected='selected'>请选择</option>");
	             $("#sid").val("");
			     $.LAYER.show({id : id});
			    return;
			}else{
				window.alert("您选中的部分展品为【已上架】状态，请重新选择~~~");
			}
		} else if (size == 0) {
			window.alert("请选中要操作的记录~~~~");
			return;
		}
      };
      
      /***
      上架确认
      ****************************************************
      2014年11月12日 18:27:24 add by roceys
      */
      var showDivOnSellConfirm = function(id) {
          var arrChks=$("input[name='subcheck']:checked");
          var size = arrChks.length;
          var allSids="";
          //选择的数据只能是【上架申请】
          var confirmFlag = false;
          if (size > 0) {
              arrChks.each(function() { 
                  allSids += $(this).attr("index")+"||";
                  var status=$(this).attr("status");
                  if(status !="0"){
                	  confirmFlag=true;
                  }
              });
              $("#confirmIds").val(allSids);
              if(!confirmFlag && id=="onSellConfirmDIV"){
                  $.LAYER.show({id : id});
                  return;
              }else{
                  window.alert("您只能操作状态为【上架申请】的展品，请重新选择~~~");
              }
          } else if (size == 0) {
              window.alert("请选中要操作的记录~~~~");
              return;
          }
        };
      
      
	//分页
	kkpager.generPageHtml({
		pno : '${pagination.current}',
		//总页码
		total : '${pagination.total}',
		//总数据条数
		totalRecords : '${pagination.count}',
		//链接前部
		hrefFormer : '${ctx}/fixedPrice/index',
		//链接算法
		getLink : function(n) {
			var queryString = $('#fixedPriceForm').serialize();
			return this.hrefFormer + this.hrefLatter + "?current=" + n + '&' + queryString;
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
	
	/**
	上架申请及直接上架
	******************
	C:2014年11月21日 18:31:44
	U:2014年11月24日 16:59:43
	Roceys
	V1.0
	**/
    var applyShelves = function(sid,vsid,flag){
	  if(flag == null){
		  window.alert("非法请求！");
		  return;
	  }
	  $.ajax({
          cache: false,
          type: "GET",
          url:"${ctx}/fixedPrice/load-store",
          data:{vsid:vsid},
          async: false,
          error: function(request) {
              window.alert("系统异常，请联系管理员！");
          },
          success: function(data) {
              if(data.success){
            	    var allSids = sid + "," + vsid;
            	    $("#onSellForm").clearForm();
            	    $("#allSids").val(allSids);
            	    $("#flag").val(flag);
            	    $("#_titleSpan").html("上架申请");
            	    $("#city").empty();
            	    $("#city").append("<option value ='' selected='selected'>请选择</option>");
            	    $("#sid").val("");
            	    $("#deposit").val("3000");
            	    $("#serviceTime").val("8：30-17：00");
            	    $("#whereStore").val(data.data[0]);
            	    $("#addressDetailStore").val(data.data[1]);
            	    $("#memo").val(data.data[2]);
            	    $("#phone").val("400-821-8889");
            	    $("#newBrand").val("").trigger("chang");
                    $("#onSellForm").find("label.error").hide();
            	    $.LAYER.show({id : "onSellOrEdit"});
             }else{
                 window.alert(data.msg);
             }
          }
      });
};
	
	/**
	查看下架原因
	*****************
	2014年11月13日 17:57:35
	V1.0
	Roceys
	*/
	var showOffRemark=function(event,e){  
	    var mX = event.x ? event.x : event.pageX;
	    var mY = event.y ? event.y : event.pageY;
	    $("#offShelvesRemarkText").html($(e).next().val());
	    $("#showOffShelvesRemark").css({"visibility":"visible","left":mX+"px","top":mY+"px"});
	};
	var  hideOffRemark=function(){  
	    $("#showOffShelvesRemark").css({"visibility":"hidden"});
	};  
	
	//条件隐藏
	var dateHidden= function(){
	    var status=$("#status").val();
	    if(status=="9"){
	    	$("#dateShow").hide();
	    	$("#startTimestamp").val("");
	    	$("#endTimestamp").val("");
	    	$("#fpcode").val("");
	    	$("#show1").hide();
	    }else {
	        $("#dateShow").show();
	        $("#show1").show();
	  }
	};
	
    //编辑
    var editFixedPrice = function(sid){
        $("#onSellForm").clearForm();
        $("#sid").val(sid);
        jQuery.ajax({
           type : 'GET',  
           contentType : 'application/json',  
           url : "${ctx}/fixedPrice/view",  
           dataType : 'json', 
           data:{sid:sid},
           success : function(data) {
             if (data) {
	            if(data.fixedPrice.hidden){  $("#hidden").prop("checked",true); } 
	            if(data.fixedPrice.hasTaxBuy){  $("#hasTaxBuy").prop("checked",true); } 
	            $("#price").val(data.fixedPrice.price/10000);
	            $("#lowPriceGroup").val(data.fixedPrice.lowPriceGroup/10000);
	            $("#priceNewcar").val(data.fixedPrice.newVehicleSuggestionPrice);
	            $("#province").val(data.fixedPrice.province);
	            selectCitys("#city","#province");
	            $("#city").val(data.fixedPrice.city);
                $("#whereStore").val(data.fixedPrice.whereStore);
                $("#addressDetailStore").val(data.fixedPrice.addressDetailStore);
	            $("#deposit").val(data.fixedPrice.deposit);
	            $("#serviceTime").val(data.fixedPrice.serviceTime);
	            $("#memo").val(data.fixedPrice.memo);
	            $("#_titleSpan").html("编辑");
	            if (data.fixedPrice.phone) {
	            	$("#phone").val(data.fixedPrice.phone);
	            } else {
	            	$("#phone").val("400-821-8889");
	            }
	            if(data.newVehicleDetailParameters){
	            	$("#newBrand").val(data.newVehicleDetailParameters.brand);
	 	            $("#newSeries").empty().append('<option value="'+ data.newVehicleDetailParameters.brandSeries +'">'+ data.newVehicleDetailParameters.brandSeries +'</option>');
	 	            $("#newYear").empty().append('<option value="'+ data.newVehicleDetailParameters.modelYear +'">'+ data.newVehicleDetailParameters.modelYear +'</option>');
	 	           	$("#newSelledName").empty().append('<option value="'+ data.newVehicleDetailParameters.selledName +'">'+ data.newVehicleDetailParameters.selledName +'</option>');
	 	           	$("#newcarParamId").val(data.newVehicleDetailParameters.id);
	 	            $("#rightRepModle").show();
	            }
	            $.LAYER.show({id : "onSellOrEdit"});
            }  
           },  
           error : function() {  
             window.alert("系统异常，请联系管理员！");
           }  
         });  
    };
	
   
    /**
    下架处理
    *************************************
    V2.0：2014年11月12日 18:21:00
    增加上架申请下架功能
    **/
	var cancelSell = function() {
		var arrChks=$("input[name='subcheck']:checked");
	    var size = arrChks.length;
	    var allSids="";
	    var status=true;
	    if (size > 0) {    
	        arrChks.each(function() {
	            allSids += $(this).attr("index")+","+$(this).val() + "||";
	            var f = $(this).attr("status");
	            if(f!="0"&&f!="3"){//0-上架申请、3-已上架
	                 status=false;
	            }
	        });
	        if(allSids!=""){
	            if(status){
	            	$("#offsheleve_remark").html(size);
	            	$("#cancelAllSids").val(allSids);
	            	$.LAYER.show({id:"offshelvesDiv"});
	            }else {
	                 window.alert("只能下架【上架申请】和【已上架】状态展品，请重新选择！");
	                 return;
	            }
	        }
	    }else if (size == 0) {
            window.alert("请选中要操作的记录~~~~");
            return;
        }
	};
	
	//成交
	var deal= function(sid,vehicleSid,e){
		if(sid != "" && vehicleSid != ""){
			$.ajax({
				url:"${ctx}/fixedPrice/load-nonoffline-order",
				type: "get",
				async:false,
				cache:false,
				data:{sid:sid,vehicleSid:vehicleSid},
				dataType:"json",
				success:function(data){
						if(typeof(data)!="undefined"&&data!=null){
							$("#orderInfoDIV").css({"display":"block"});
							$("#orderInfoDepositText").html(data.status);
							$("#orderInfoOrderNOText").html(data.order_no);
							$("#orderInfoBuyyerText").html(data.bidder_name);
							$("#orderInfoCellphoneText").html(data.buyer_cellphone);
						}else{
							$("#orderInfoDIV").css({"display":"none"});
                            $("#orderInfoDepositText").html("");
                            $("#orderInfoOrderNOText").html("");
                            $("#orderInfoBuyyerText").html("");
                            $("#orderInfoCellphoneText").html("");
						}
						
						$("#id1").val(sid);
			            $("#vehicleId").val(vehicleSid);
			            
			            var code = $(e).next().val();
			            var brand = $(e).next().next().val();
			            var licence = $(e).next().next().next().val();
			            
			            $("#dealCode").html(code);
			            $("#dealBrand").html(brand);
			            $("#dealLicence").html(licence);
			            
			            var brandWidth = brand.length*8.6923+160;
			            if(brandWidth<320){
			            	brandWidth = 320;
			            }
			            $("#dealPanl").css({"width":brandWidth});
			            $.LAYER.show({id : "dealDiv"});
			           },
			          error: function(request) {
			                 window.alert("系统异常，请联系管理员！");
			             }
					});
		}else{
			window.alert("非法操作！");
		}
	};
	
	//车辆上架申请驳回处理
	var onAuditFailure=function(sid){
		$("#fpSid").val(sid);
		$.LAYER.show({id : "onAuditFailureDiv"});
	};
	//上架失败原因
	$("#datatable a[data-name=trackFpFailLog]").on("click", function(e){
		var url = "${ctx }/fixedPrice/trackFpFailLog";
		$.post(
			url, 
			{fixedPriceId : this.title}, 
			function(data){
				if (data.success) {
					var html = '<div>';
					if (data.data && data.data.length > 0) {
						for (var i = 0; i < data.data.length; i++) {
							html += '<p>' + data.data[i].operationTime +'&nbsp;原因：'+data.data[i].remark+'</p>';
						}
						html += '</div>';
					} else {
						html = '<p style="margin: 2em 12em;">暂无变更记录！</p>';
					}
					$("#_titleSpan").html("展品下架变更记录");
					$("#dialog .pop_box").width(600);
					$("#dialog .container_top").html(html);
					$.LAYER.show({
						id : "dialog"
					});
				} else {
					alert(data.msg);
			    }
			});
	});
	
	//组织结构选择代码开始
	var edit_tree;
	var setTree = function(setting){
		$.get(ctx + "/org/load-tree", null, function(data) {
			$.fn.zTree.init($("#edit_organ_tree"), setting, JSON.parse(data));
			edit_tree = $.fn.zTree.getZTreeObj("edit_organ_tree");
		});
	};

	var onTreeClick = function(event, treeId, treeNode){
		
		$("#vehicleSrcSid").val(treeNode.sid);
		$("#parentName").val(treeNode.companyName);
	};

	function hideTree() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}

	function onBodyDown(event) {
		if (!(event.target.id == "parentName" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideTree();
		}
	}

	function clearParentOrgan() {
		$("#vehicleSrcSid").val("");
		$("#parentName").val("");
	}

	 var getParentId=function(node,openId){
		 var pNode = node.getParentNode();
		 console.log(pNode);
		 var tid = pNode.parentTId;
		 if(pNode!=null&&tid!=null){
			 return pNode.sid +","+getParentId(pNode,openId);
		 }else{
			 return "";
		 }
	 };
 
</script>
</body>
</html>