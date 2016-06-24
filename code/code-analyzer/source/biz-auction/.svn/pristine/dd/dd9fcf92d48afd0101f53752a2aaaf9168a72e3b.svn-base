<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>编辑拍品信息</title>
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
			<div class="rbody s_form">
				<form:form action="${ctx }/auctionvehicle/update" method="post"  commandName="auctionVehicle" id="auctionVehicleForm" modelAttribute="auctionVehicle">
					<table class="tbl-form-1" id="tab">
						<tbody>
							<tr class="thead">
								<td colspan="4">拍品编辑</td>
							</tr>
							<tr>
								<th width="15%">车辆编号：</th>
								<td colspan="3">
									<form:hidden path="id"/>
									<form:hidden path="vehicleId"/>
									<form:hidden path="status"/>
									<form:hidden path="createdTimestamp"/>
									<form:hidden path="createdBy" value="${currentUser }"/>
									<form:hidden path="code" value="${auctionVehicle.code }"/>
									<form:hidden path="vinCode" value="${auctionVehicle.vinCode }"/>
									<form:hidden path="brand" value="${auctionVehicle.brand }"/>
									<form:hidden path="vehicleModel" value="${auctionVehicle.vehicleModel }"/>
									<form:hidden path="licenseCode" value="${auctionVehicle.licenseCode }"/>
									<form:hidden path="auctionType" value="${auctionVehicle.auctionType }"/>
									<form:hidden path="auctionId" value="${auctionVehicle.auctionId }"/>
									 ${ auctionVehicle.code}
								</td>
							</tr>
							<tr>
								<th width="15%">VIN码：</th>
								<td colspan="3">
								     ${ auctionVehicle.vinCode}
								</td>
							</tr>
							<tr>
								<th width="15%">品牌型号：</th>
								<td width="20%">
									    ${ auctionVehicle.brand}${ auctionVehicle.vehicleModel}
								</td>
								<th  width="15%">车牌号：</th>
								<td>
									    ${ auctionVehicle.licenseCode}
								</td>
						    </tr>
                            <tr>
								<th width="15%">拍卖类型：</th>
								<td id="auctionSelect">
										<form:select path="auctionType"  onchange="showAuction();" disabled="true">  
											<form:option value=""  label="请选择"  ></form:option>
											<spring:eval expression="@autoDictionaryService.selectAuctionType()" var="types"/>
											<form:options items="${types}" itemLabel="name"  itemValue="value"></form:options>
										</form:select>
								</td>
								<th width="15%" id="onlineAuction">拍卖计划：</th>
								<td id="onlineAuctionText">
                                    <form:input path="planStartTime" cssClass="from-input-1"  cssStyle="width:150px;float:none;" />至<form:input path="planEndTime" cssClass="from-input-1" cssStyle="width:150px;float:none;" />
                                </td>
							</tr>
							 <tr id="onlineAuction1">
                                <th>拍卖方式：</th>
                                <td>
                                    <form:select path="auctionModel" >  
                                           <spring:eval expression="@autoDictionaryService.selectAuctionModel()" var="models"/>
                                           <form:options items="${models}" itemLabel="name"  itemValue="value"></form:options>
                                      </form:select>
                                <th>竞拍区域：</th>
                                <td>
                                    <form:select path="province"  cssStyle="width:160px;"  onchange="selectCity('#province','#city');">  
                                            <form:option value=""  label="请选择"  ></form:option>
                                            <spring:eval expression="@autoDictionaryService.selectProvince()" var="provinces"/>
                                            <form:options items="${provinces}" itemLabel="name" itemValue="name"/>
                                        </form:select>
                                    <form:select path="city" id="city" name="city"  cssStyle="width:200px;">
                                        <form:option value="" selected="selected">请选择</form:option>
                                          <c:if test="${null != auctionVehicle.city}">
                                                <spring:eval expression="@autoDictionaryService.selectCity(auctionVehicle.province)" var="subSetCitys" />
                                                <form:options items="${subSetCitys}" itemLabel="name"  itemValue="name" />
                                           </c:if>
                                    </form:select>
                                </td>
                            </tr>
							<tr id="showAuction">
                                <th width="15%">拍卖会：</th>
                                <td colspan="3">
                                   <form:select path="auctionId" cssStyle="width:300px;" disabled="true">  
                                           <form:option value=""  label="请选择拍卖会"></form:option>
                                           <spring:eval expression="@auctionService.selectAutions(auctionVehicle.auctionId)" var="autions" />
                                           <c:forEach items="${autions}" var="item">
                                                <form:option value="${item.id }" label="${item.title }" startDate="${item.startTimestamp}"  endDate="${item.endTimestamp}" ></form:option>
                                           </c:forEach>
                                       </form:select>
                                </td>
                             </tr>
							<tr>
								<th >起拍价：</th>
								<td>
									<form:input path="startPrice" cssClass="from-input-1" cssStyle="width:80px;" />元
								</td>
								<th>加价幅度：</th>
								<td>
									<form:input path="plusRange" cssClass="from-input-1" cssStyle="width:80px;" />元
								</td>
							</tr>
                            <tr>
								<th>保留价：</th>
								<td>
									<form:input path="reservePrice" cssClass="from-input-1" cssStyle="width:80px;" />元
								</td>
								<th>是否显示保留价：</th>
								<td>
									<form:select path="displayReservePrice" cssStyle="width:80px;">
                                        <form:option value="false">否</form:option>
                                        <form:option value="true">是</form:option>
                                    </form:select>
								</td>
							</tr>
							<tr>
								<th>拍品类型：</th>
								<td colspan="3">
								<spring:eval expression = "@autoDictionaryService.selectResource('av_type')" var="avTypes"/>
								<form:select path="avType" cssClass="form-input-1" cssStyle="width:65px;">
                           			<form:options items="${avTypes}" itemLabel="name" itemValue="value"/>
                           		</form:select>
								</td>
							</tr>
							<%--在线拍 --%>
							<c:if test="${auctionVehicle.auctionType==1}">
								<tr>
									<th>热门推荐：</th>
									<td>
										<form:checkbox path="recommend"/>
									</td>
									<th>活动拍品：</th>
									<td>
									<form:checkbox path="activity" id="activity"/>
									<form:input path="activityTitle" cssClass="from-input-1" cssStyle="margin-left:50px;width:300px;" maxlength="30"/>
									</td>									
								</tr>
							</c:if>
                            <tr>
								<th rowspan="3">延保服务：</th>
								<td colspan="3">
									<input type="checkbox"  checked="checked" name="margin" value="6个月延保"  />6个月延保&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									原价<input id="margin" disabled="disabled"  class="from-input-1" value="0" style="width:80px;" />元&nbsp;&nbsp;&nbsp;
									优惠价<input id="margin" class="from-input-1" value="0" style="width:80px;"/>元
								</td>
							</tr>
                            <tr>
								<td colspan="4">
									<input type="checkbox"  checked="checked" value="12个月延保" />12个月延保&nbsp;&nbsp;&nbsp;
									原价<input id="margin" disabled="disabled"  class="from-input-1" value="" style="width:80px;"/>元&nbsp;&nbsp;&nbsp;
									优惠价<input id="margin" class="from-input-1" value="0" style="width:80px;"/>元
								</td>
							</tr>
                            <tr>
								<td colspan="4">
									<input type="checkbox"  checked="checked" value="18个月延保" />18个月延保&nbsp;&nbsp;&nbsp;
									原价<input id="margin" disabled="disabled"  class="from-input-1" value="2000" style="width:80px;"/>元&nbsp;&nbsp;&nbsp;
									优惠价<input id="margin" class="from-input-1" value="0" style="width:80px;"/>元
								</td>
							</tr>
                            <tr>
								<th rowspan="4">整备服务：</th>
								<td colspan="3">
									<input type="checkbox"  checked="checked" value="A套餐" />A套餐&nbsp;&nbsp;&nbsp;
									原价<input id="margin" disabled="disabled"  disabled="disabled" class="from-input-1" value="0" style="width:80px;"/>元&nbsp;&nbsp;&nbsp;
									优惠价<input id="margin" class="from-input-1" value="0" style="width:80px;"/>元
								</td>
							</tr>
                            <tr>
								<td colspan="4">
									<input type="checkbox"  checked="checked"  value="B套餐" />B套餐&nbsp;&nbsp;&nbsp;
									原价<input id="margin" disabled="disabled"  class="from-input-1" value="2000" style="width:80px;"/>元&nbsp;&nbsp;&nbsp;
									优惠价<input id="margin" class="from-input-1" value="0" style="width:80px;"/>元
								</td>
							</tr>
                            <tr>
								<td colspan="4">
									<input type="checkbox"  checked="checked" value="C套餐" />C套餐&nbsp;&nbsp;&nbsp;
									原价<input id="margin" disabled="disabled"  class="from-input-1" value="4000" style="width:80px;"/>元&nbsp;&nbsp;&nbsp;
									优惠价<input id="margin" class="from-input-1" value="0" style="width:80px;"/>元
								</td>
							</tr>
                            <tr>
								<td colspan="4">
									<input type="checkbox"  checked="checked" value="D套餐" />D套餐&nbsp;&nbsp;&nbsp;
									原价<input id="margin" disabled="disabled"  class="from-input-1" value="8000" style="width:80px;"/>元&nbsp;&nbsp;&nbsp;
									优惠价<input id="margin" class="from-input-1" value="0" style="width:80px;"/>元
								</td>
							</tr>
							  <tr>
                                <th><b>委托方</b></th>
                                <td colspan="3">
                                    佣金：
                                   <input type="radio" name="clientRadio" id="clientRate" />按比例&nbsp;
                                      <span id="_clientCommissionRate">
                                        <form:input path="clientCommissionRate" cssClass="from-input-1" style="width:80px;float:none"/>%&nbsp;&nbsp;&nbsp;
                                       </span>
                                   <input type="radio" name="clientRadio" id="clientFixed"/>固定佣金&nbsp;
                                      <span id="_clientFixedCommission">
                                        <form:input path="clientFixedCommission" cssClass="from-input-1" style="width:80px;float:none"/>元
                                      </span>
                                </td>
                            </tr>
							  <tr>
                                <th><b>买家</b></th>
                                <td colspan="3">
                                    佣金：
                                    <input type="radio" name="buyerRadio" id="buyerRate" />按比例&nbsp;
                                        <span id="_buyerCommissionRate">
                                            <form:input path="buyerCommissionRate" cssClass="from-input-1" style="width:80px;float:none"/>%&nbsp;&nbsp;&nbsp;
                                        </span>
                                    <input type="radio" name="buyerRadio" id="buyerFixed"/>固定佣金&nbsp;
                                        <span id="_buyerFixedCommission">
                                            <form:input path="buyerFixedCommission" cssClass="from-input-1" style="width:80px;float:none"/>元
                                        </span>
                                </td>
                            </tr>
							<tr>
                               <th >办证费：</th>
                               <td>
                                   <form:input path="licenseFee" cssClass="from-input-1" style="width:80px;"/>元
                               </td>
                               <th >出库费：</th>
                               <td>
                                    <form:input path="exWarehouseFee" cssClass="from-input-1" style="width:80px;"/>元
                               </td>
	                        </tr>
							<tr>
                               <th >停车费：</th>
                               <td>
                                   <form:input path="parkingFee" cssClass="from-input-1" style="width:80px;"/>元
                               </td>
                               <th >运输费：</th>
                               <td>
                                    <form:input path="trafficFee" cssClass="from-input-1" style="width:80px;"/>元
                               </td>
	                        </tr>
							<tr>
                               <th >违章费用：</th>
                               <td colspan="3">
                                   <form:input path="trafficViolationFee" cssClass="from-input-1" style="width:80px;"/>元
                               </td>
	                        </tr>
							<tr>
                                <th >看车时间：</th>
                                <td colspan="3">
                                    <form:input path="seeCarTime" cssClass="from-input-1"  cssStyle="width:200px;"/>
                                </td>
                           </tr>
						   <tr>
                                <th >看车地点：</th>
                                <td colspan="3">
                                    <form:input path="seeCarAddr" cssClass="from-input-1" style="width:255px;"/>
                                </td>
                           </tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4">
									<p align="center" class="btn-box">
										<input type="button" class="button_lv4_1" value="保存" id="save"/> 
										<input type="button" class="button_lv4_1" value="关闭"  id="cancel" />
									</p>
								</td>
							</tr>
						</tfoot>
					</table>
				</form:form>
			</div>
		</div>
	</div>
<script type="text/javascript" src="${ctx}/resources/auction/all.js"></script>
<script type="text/javascript">
$(document).ready(function (){
  showAuction();
  
	 if(!$('#activity').attr('checked')){
		 $('#activityTitle').attr("readonly","readonly");
	 }
	 $("#activity").change(function(){
		 if($(this).is(':checked')){
			 $('#activityTitle').removeAttr("readonly").val('${auctionVehicle.activityTitle}');
		 }else{
			 $('#activityTitle').val("").attr("readonly","readonly");
		 }
	 });
  
  var buyerCommissionRate = "${auctionVehicle.buyerCommissionRate}";
  if(buyerCommissionRate!=""&&parseFloat(buyerCommissionRate)!=(0.0000)){
        $("#buyerRate").attr("checked","checked");
   }
  
  var buyerFixedCommission = "${auctionVehicle.buyerFixedCommission}";
  if(buyerFixedCommission!=""&&parseFloat(buyerFixedCommission)!=(0.00)){
	   $("#buyerFixed").attr("checked","checked");
   }
  var clientCommissionRate = "${auctionVehicle.clientCommissionRate}";
  if(clientCommissionRate!=""&&parseFloat(clientCommissionRate)!=(0.0000)){
	  $("#clientRate").attr("checked","checked");
  }
  
  var clientFixedCommission = "${auctionVehicle.clientFixedCommission}";
  if(clientFixedCommission!=""&&parseFloat(clientFixedCommission)!=(0.00)){
      $("#clientFixed").attr("checked","checked");
   }
  
  showDateTimePicker("#planStartTime");
  showDateTimePicker("#planEndTime");
  
  $("#auctionType").change(function(){
	  var auctionType=$("#auctionType").val();
      if(auctionType=="1"){//在线拍
          $("#planStartTime").val("");
          $("#planEndTime").val("");
          }
    });
  
   $("#cancel").click(function (){ closeWindow(); });
   
  checkClientRadio();
  $("input[name=clientRadio]").click(function (){
	  checkClientRadio();
  });
  
  checkBuyerRadio();
  $("input[name=buyerRadio]").click(function (){
	  checkBuyerRadio();
  });
  
  $("#clientCommissionRate").click(function(){
	     $("#clientRate").attr("checked","checked");
	     checkClientRadio();
	});

	$("#clientFixedCommission").click(function(){
	     $("#clientFixed").attr("checked","checked");
	     checkClientRadio();
	});
  
  $("#buyerCommissionRate").click(function(){
	     $("#buyerRate").attr("checked","checked");
	     checkBuyerRadio();
	});

	$("#buyerFixedCommission").click(function(){
	     $("#buyerFixed").attr("checked","checked");
	     checkBuyerRadio();
	});
   
//表单提交检查
$("#save").click(function(check){  
    var val = $("#auctionType").val();  
    var auctionId = $("#auctionId").val();
    if(val==""){  
        alert("请选择拍卖类型!");  
        $("#auctionType").focus();  
        check.preventDefault();//阻止表单提交
        return;
    }else if(val=="0"){
 	   if(auctionId==""){  
 		   alert("请选择拍卖会!");  
            $("#auctionId").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
    }else if(val=="1"){
 	   var startTime = $("#planStartTime").val();
        var endTime = $("#planEndTime").val();
        if(startTime==""||startTime==null){
     	    alert("请填写在线拍开始时间！");
     	    return;
     	}
     	if(endTime==""||endTime==null){
     	    alert("请填写在线拍结束时间！");
     	    return;
     	}
     	if(!checkDateTime(startTime,endTime)){
     	    alert("拍卖起始时间必须超过当前时间，且结束时间必须超过开始时间！");
     	    return;
     	}
    }
    
    var startPrice = $("#startPrice").val();
    var plusRange = $("#plusRange").val();
    var reservePrice = $("#reservePrice").val();
    
	if(startPrice!=""){
	       if(!checkCashResult(startPrice)){return;};
	 }
	 if(plusRange!=""){
	       if(!checkCashResult1(plusRange)){return;};
	 }
	 if(reservePrice!=""){
	        if(!checkCashResult(reservePrice)){return;}; 
	 }
    
    $("#auctionVehicleForm").submit();
});  

	var error =  "${auctionVehicle.msgError}";
	if(error!=""){
		alert(error);
	}

});

var showAuction=function(){
	var auctionType=$("#auctionType").val();
	if(auctionType=="0"||auctionType==""){//同步拍、请选择
           $("#onlineAuction").hide();
           $("#onlineAuction1").hide();
           $("#onlineAuctionText").hide();
           $("#auctionSelect").attr("colspan",3);
           if(auctionType==""){ $("#showAuction").hide();}
     }
	
	if(auctionType=="0"){//同步拍
	   $("#showAuction").show();
	}else if(auctionType=="1"){//在线拍
	   $("#showAuction").hide();
	   $("#onlineAuction").show();
          $("#onlineAuctionText").show();
	   $("#onlineAuction1").show();
          $("#auctionSelect").attr("colspan",0);
	}
};
	
var checkClientRadio = function(){
 switch($("input[name=clientRadio]:checked").attr("id")){
  case "clientRate":
		$("#clientCommissionRate").removeAttr("disabled");
		$("#_clientCommissionRate").show();
		$("#clientFixedCommission").attr("disabled","disabled");
		$("#_clientFixedCommission").hide();
	    break;
  case "clientFixed":
	  $("#clientFixedCommission").removeAttr("disabled");
      $("#_clientFixedCommission").show();
      $("#clientCommissionRate").attr("disabled","disabled");
      $("#_clientCommissionRate").hide();
      break;
  default:
   break;
 }
};

var checkBuyerRadio = function(){
 switch($("input[name=buyerRadio]:checked").attr("id")){
  case "buyerRate":
		$("#buyerCommissionRate").removeAttr("disabled");
		$("#_buyerCommissionRate").show();
		$("#buyerFixedCommission").attr("disabled","disabled");
		$("#_buyerFixedCommission").hide();
	    break;
  case "buyerFixed":
	  $("#buyerFixedCommission").removeAttr("disabled");
      $("#_buyerFixedCommission").show();
      $("#buyerCommissionRate").attr("disabled","disabled");
      $("#_buyerCommissionRate").hide();
      break;
  default:
   break;
 }
};
//级联select citys
var selectCity = function(proInput,cityInput){
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
</script>
</body>
</html>