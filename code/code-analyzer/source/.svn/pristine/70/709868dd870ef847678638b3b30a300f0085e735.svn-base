<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>同步拍数据汇总</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<style>
.model-search-form li{margin-top: 3px;}
</style>
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
				<form:form id="searchForm" commandName="auctionDataUploadVO" modelAttribute="auctionDataUploadVO" action="${ctx}/adu/index">
                    <ul class="filter sa-sreach-list">
                        <li class="width-250">
                            <p>拍卖会名称：</p>
                            <form:select path="auctionId">
                                <form:option value="" label="请选择"></form:option>
                                <form:options items="${auctionTitleList}" itemLabel="title" itemValue="id"></form:options>
                            </form:select>
                        </li>
                        <li class="width-250">
                            <p>参拍人：</p>
                            <form:input path="auctionMemberName"/>
                        </li>
                        <li class="width-250">
                            <p>身份证号：</p>
                            <form:input path="auctionMemberIDCar" />
                        </li>
                        <li class="width-250">
                            <p>手机号：</p>
                            <form:input path="auctionMemberCellphone" />
                        </li>
                        <li class="width-250">
                            <p>VIN码：</p>
                            <form:input path="vinCode" />
                        </li>
                        <li class="width-250">
                            <p>车牌号：</p>
                            <form:input path="licenseCode" />
                        </li>
                        <li>
                            <p>成交价格：</p>
                            <form:input path="startDealPrice"/>
                            <label class="inp-label">至</label>
                            <form:input path="endDealPrice" />
                        </li>
                        <li>
                            <p>登记时间：</p>
                            <form:input path="startRegisterTime"/>
                            <label class="inp-label">至</label>
                            <form:input path="endRegisterTime" />
                        </li>
                        <li>
                            <p>成交时间：</p>
                            <form:input path="startDealTime" />
                            <label class="inp-label">至</label>
                            <form:input path="endDealTime" />
                        </li>
                    </ul>
                    <form:hidden path="dataFlag"/>
                    <form:hidden path="isShowDeal"/>
                    <form:hidden path="isShowUndeal"/>
                </form:form>
                <form style="display: none;" id="exportForm" action="${ctx}/adu/exportExcel" method="post">
	                 <c:choose>
	                    <c:when test="${auctionDataUploadVO.dataFlag == 1}">
	                        <ul>
								<li><input type="hidden" name="exportCol" value="auctionTitle#拍卖会名称"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberName#参拍人"></li>
								<li><input type="hidden" name="exportCol" value="memberType#参拍人类型"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberIDCar#身份证号"></li>
								<li><input type="hidden" name="exportCol" value="registerTime#登记时间"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberWechat#微信"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberProvince#区域省"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberCity#区域市"></li>
								<li><input type="hidden" name="exportCol" value="auctionNumber#拍卖号牌"></li>
								<!-- <li><input type="hidden" name="exportCol" value="dealVehicleSum#成交车辆数"></li>
								<li><input type="hidden" name="exportCol" value="dealPriceSum#成交额小计（元）"></li>	 -->	
							</ul>
	                    </c:when>
	                    <c:when test="${auctionDataUploadVO.dataFlag == 2}">
	                       <ul>
								<li><input type="hidden" name="exportCol" value="auctionTitle#拍卖会名称"></li>
								<li><input type="hidden" name="exportCol" value="vinCode#VIN码"></li>
								<li><input type="hidden" name="exportCol" value="licenseCode#车牌号"></li>
								<li><input type="hidden" name="exportCol" value="brandModel#品牌车型车系"></li>
								<li><input type="hidden" name="exportCol" value="dealTime#成交时间"></li>
								<li><input type="hidden" name="exportCol" value="dealPrice#成交价格（元）"></li>
								<li><input type="hidden" name="exportCol" value="auctionNumber#拍卖号牌"></li>
								<li><input type="hidden" name="exportCol" value="auctionVehicleOrder#拍卖车辆编号"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberName#参拍人"></li>
								<li><input type="hidden" name="exportCol" value="memberType#参拍人类型"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberIDCar#身份证号"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberCellphone#手机号"></li>
								<li><input type="hidden" name="exportCol" value="registerTime#注册时间"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberWechat#微信"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberProvince#区域省"></li>
								<li><input type="hidden" name="exportCol" value="auctionMemberCity#区域市"></li>
							</ul>
	                    </c:when>
	                </c:choose>
                </form>
                <div class="query">
                	<%-- <shiro:hasPermission name="auct:ap:query"> --%>
                        <a id="searchFormBtn" class="query_btn" onclick="javascript: searchFormSbmt();"> 查询</a>
                	<%-- </shiro:hasPermission> --%>
                </div>
           </div>
        </div>
        <shiro:hasPermission name="auct:adu:importFile">
           <input id="import" class="addbtn query_btn_2" type="submit" value="导入" onclick="javacript: openImportDiv();" />
        </shiro:hasPermission>
        <shiro:hasPermission name="auct:adu:exportFile">
        <input id="export" class="addbtn query_btn_2" type="submit" value="导出" onclick="javacript: openExportDiv();" />
        </shiro:hasPermission>
        <input id="export" class="addbtn query_btn_2" type="submit" value="下载模板" onclick="javacript: downLoadDiv();" />
        <shiro:hasPermission name="auct:adu:deleteFile">
        <input id="delete" class="addbtn query_btn_2" type="submit" value="删除数据" onclick="javacript: openDeleteDiv();" />
        </shiro:hasPermission>
        <div class="container_main">
        	<div class="wrap" style="padding:0px 20px;">
	            <ul class="model-search-form">
	                <li class="whole">
	                    <label class="model-label model-len8 model-checkbox-warp"><input type="radio" class="model-radio" name="dataFlagRdo" value="1" onclick="javacript: dataFlagRdoClick(this);" <c:if test="${dataFalg=='1'}">checked="checked"</c:if>  />按参拍人查看</label>
	                    <label class="model-label model-len6 model-checkbox-warp"><input type="radio" class="model-radio" name="dataFlagRdo" value="2" onclick="javacript: dataFlagRdoClick(this);" <c:if test="${dataFalg=='2'}">checked="checked"</c:if>/>按车辆查看</label>
	                </li>
	                <li class="whole">
	                    <label class="model-label model-len8 model-checkbox-warp"><input type="checkbox" name="isShowDeal"  class="model-checkbox" id="isShowDealCkb" onclick="javacript: showDealClick(this);" />显示成交数据</label>
	                    <label class="model-label model-len8 model-checkbox-warp"><input type="checkbox" name="isShowUndeal" class="model-checkbox" id="isShowUndealCkb" onclick="javacript: showUnDealClick(this);" />显示未成交数据</label>
	                </li>
	            </ul>
            </div>
        </div>
        <div class="container_main">
        	<div class="wrap">
        		<c:choose>
                    <c:when test="${auctionDataUploadVO.dataFlag == 1}">
                        <%@include file="am_tbl.jsp" %>
                    </c:when>
                    <c:when test="${auctionDataUploadVO.dataFlag == 2}">
                        <%@include file="av_tbl.jsp" %>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</div>

	<div class="UED_hide" id="importDiv">
        <div class="pop_box" style="width: 420px;">
            <div class="pop_tittle">
                <h3>导入数据</h3>
                <a href="javascript:void(0);" onclick="javascript: $.LAYER.close();" class="close"></a>
            </div>
            <div class="s_box">
                <form id="uploadForm" class="searchForm" action="${ctx}/adu/uploadFile" method="post" enctype="multipart/form-data">
                    <input type="hidden" id="count" >
                    <ul class="s_form">
                        <li class="lay-price-input">
                            <label>请选择指定的拍卖场次导入数据：</label>
                            <select class="model-select-120" name="auctionId" id="checkauctionId" onchange="javascript: choiceAuctionTitle(this);">
                                <option value="">请选择</option>
                                <c:forEach items="${auctionTitleList}" var="auctionTitle">
                                    <option value="${auctionTitle.id}">${auctionTitle.title}</option>
                                </c:forEach>
                            </select>
                        </li>
                        <li class="lay-price-input" style="width:300px;">
                            <label>场次名称：<span id="auctionName"></span></label>
                        </li>
                        <li class="lay-price-input" style="width:300px;">
                            <label>拍卖日期：<span id="auctionDate"></span></label>
                        </li>
                        <li class="lay-price-input" style="width:300px;">
                            <label>车辆数：<span id="auctionvehicleNum"></span></label>
                        </li>
                        <li class="lay-price-input" style="width:300px;">
                            <label>成交数：<span id="auctionDealNum"></span></label>
                        </li>
                        <li class="lay-price-input" >
                            <label>请选择导入文件：</label>
                            <input type="file" name="file" id="file1" onchange="viewFile()" />
                            <input type="hidden" id="fileId" />
                        </li>
		               <li class="lay-price-input" style="width:300px;">
		                   <label id = "memCount">上传参拍人数：</label>
		               </li>
		               <li class="lay-price-input" style="width:300px;">
		                   <label id = "vehicleCount">上传车辆数：</label>
		               </li>
		               <li class="lay-price-input" style="width:300px;">
		                   <label id = "dealCount">上传成交数：</label>
		               </li>
                    </ul>
                </form>
				 <p align="center" class="controlbox">
				   <input type="button" class="button_lv4_1" value="确定" onclick="javascript: uploadData();"  />
				   <input type="button" class="button_lv4_1" value="取消" onclick="$.LAYER.close();" />
                </p>
                </div>                          
        </div>
    </div>
    
    <div class="UED_hide" id="deleteDiv">
        <div  class="pop_box" style="width: 420px;">
          <div class="pop_tittle">
                <h3>删除数据</h3>
                <a href="javascript:void(0);" onclick="javascript: $.LAYER.close();" class="close"></a>
            </div>
            <div  class="s_box">
                <form id="deleteForm" class="searchForm">
                    <input type="hidden" id="count" >
                    <ul class="s_form">
                       <li class="lay-price-input">
                            <label>请选择指定的拍卖场次删除数据：</label>
                            <select class="model-select-120" name="auctionId" id="auctionId" onchange="javascript: choiceAuctionTitle(this);">
                                <option value="">请选择</option>
                                <c:forEach items="${auctionTitleList}" var="auctionTitle">
                                    <option value="${auctionTitle.id}">${auctionTitle.title}</option>
                                </c:forEach>
                            </select>
                        </li>
                        <li class="lay-price-input" style="width:300px;">
                            <label>拍卖日期：<span id="deLoadDate"></span></label>
                        </li>
                        <li class="lay-price-input" style="width:300px;">
                            <label>参拍人数：<span id="deLoadPersonNum"></span></label>
		                </li>
		                <li class="lay-price-input" style="width:300px;">
		                    <label>车辆数：<span id="deLoadVehicleNum"></span></label>
		                 </li>
		                 <li class="lay-price-input" style="width:300px;">
		                     <label>成交数：<span id="deLoadDealNum"></span></label>
		                 </li>
                    </ul>
                </form>
				 <p align="center" class="controlbox">
				   <input type="button" class="button_lv4_1" value="删除" onclick="javascript: deleteData();"  />
				   <input type="button" class="button_lv4_1" value="取消" onclick="$.LAYER.close();" />
                </p>	
              </div>   
        </div>
    </div>
   
    <div id="alertDiv" class="UED_hide">
        <div class="tip-offset">
            <a class="tipclose" href="javascript:$.LAYER.close();"></a>
            <div class="tip-refund-box clearfix">
                <h2 id="alertContent" class="fz16"></h2>
                <div class="clear"></div>
            </div>
        </div>
    </div>
<script type="text/javascript">

$(function(){
    $("#startRegisterTime").datepicker({
        duration: 'fast',
        dateFormat:'yy-mm-dd',
        showAnim:'slide',
        showOtherMonths: true,
        selectOtherMonths: true,
        changeMonth: true,
        changeMonthUseLongNames:true,
        monthNamesShort: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],
        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
        changeYear: true,
        yearRange:'c-30:c'//前30年和后0年
    });

    $("#endRegisterTime").datepicker({
        duration: 'fast',
        dateFormat:'yy-mm-dd',
        showAnim:'slide',
        showOtherMonths: true,
        selectOtherMonths: true,
        changeMonth: true,
        changeMonthUseLongNames:true,
        monthNamesShort: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],
        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
        changeYear: true,
        yearRange:'c-30:c'//前30年和后0年
    });

    $("#startDealTime").datepicker({
        duration: 'fast',
        dateFormat:'yy-mm-dd',
        showAnim:'slide',
        showOtherMonths: true,
        selectOtherMonths: true,
        changeMonth: true,
        changeMonthUseLongNames:true,
        monthNamesShort: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],
        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
        changeYear: true,
        yearRange:'c-30:c'//前30年和后0年
    });

    $("#endDealTime").datepicker({
        duration: 'fast',
        dateFormat:'yy-mm-dd',
        showAnim:'slide',
        showOtherMonths: true,
        selectOtherMonths: true,
        changeMonth: true,
        changeMonthUseLongNames:true,
        monthNamesShort: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],
        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
        changeYear: true,
        yearRange:'c-30:c'//前30年和后0年
    });

    //分页
    kkpager.generPageHtml({
        pno: "${pagination.current}",
        //总页码
        total: "${pagination.total}",
        //总数据条数
        totalRecords: "${pagination.count}",
        //链接前部
        hrefFormer: "${ctx}/adu/index",
        //链接算法
        getLink: function(n){
            var queryString = $("#searchForm").serialize(); 
            return this.hrefFormer + this.hrefLatter + "?current=" + n + "&" + queryString;
        }
    });

   // $("input:radio[name=dataFlagRdo][value=${auctionDataUploadVO.dataFlag}]").click();
    if ("${auctionDataUploadVO.isShowDeal}" == "true") {
		$("#isShowDealCkb").attr("checked", "checked");
	} else {
		$("#isShowDealCkb").removeAttr("checked");
	};
    if ("${auctionDataUploadVO.isShowUndeal}" == "true") {
        $("#isShowUndealCkb").attr("checked", "checked");
    } else {
        $("#isShowUndealCkb").removeAttr("checked");
    };
});

function openAlertDiv(alertMsg) {
    $("#alertContent").text(alertMsg);
    $.LAYER.show({id:"alertDiv", overlay:{opacity:0.5}});
};

function searchFormSbmt() {
    var ckb = $("#isShowDealCkb:checked");
    if (null == ckb||ckb.length==0) {
        $("#isShowDeal").val(false);
    } else {
        $("#isShowDeal").val(true);
    };
    ckb = $("#isShowUndealCkb:checked");
    if (null == ckb||ckb.length==0) {
        $("#isShowUndeal").val(false);
    } else {
        $("#isShowUndeal").val(true);
    };
    $("#searchForm").submit();
};

function dataFlagRdoClick(rdo) {
	$("#dataFlag").val(rdo.value);
	$("#searchFormBtn").click();
};

function showDealClick(rdo) {
	$("#isShowDeal").val(rdo.checked==true?1:0);
	$("#searchFormBtn").click();
};
function showUnDealClick(rdo) {
	$("#isShowUndeal").val(rdo.checked==true?1:0);
	$("#searchFormBtn").click();
};

function openImportDiv() {
    $("#checkauctionId").val("");
	$("#auctionName").html("");
	$("#auctionDate").html("");
	$("#auctionvehicleNum").html("");
	$("#auctionDealNum").html("");
	$("#memCount").text("上传参拍人数：" + "");
	$("#vehicleCount").text("上传车辆数：" + "");
	$("#dealCount").text("上传成交数：" + "");
	$("#deLoadDate").html("");
	$("#deLoadPersonNum").html("");
	$("#deLoadVehicleNum").html("");
	$("#deLoadDealNum").html("");
    $.LAYER.show({id:"importDiv", overlay:{opacity:0.5}});
};
function openExportDiv() {
	if (confirm("是否确认导出？")) {
		var queryString = $('#searchForm').serialize();
	    var actionUrl = "${ctx}/adu/exportExcel?" + queryString;
	    $("#exportForm").attr("action", actionUrl);
	    $("#exportForm").submit();
	}
};
function downLoadDiv() {
	if (confirm("是否确认下载？")) {
	 location.href= "${ctx}/adu/download?fileName=线下数据导入导出模版.xlsx";
	}
};



function openDeleteDiv() {
	$("#deLoadDate").html("");
	$("#deLoadPersonNum").html("");
	$("#deLoadVehicleNum").html("");
	$("#deLoadDealNum").html("");
    $.LAYER.show({id:"deleteDiv", overlay:{opacity:0.5}});
};

function deleteData() {
	var frm = $("#deleteForm");
    var auctionId = frm.find("select option:selected").val();
	if (confirm("是否确认删除？")) {
		 $.get("${ctx}/adu/deleteFile?auctionId=" + auctionId, function(result, status) {
            if (result.success) {
            	alert(result.msg);
            	location.href="${ctx}/adu/index";
            } else {
            	alert(result.msg);
            	return;
            };
        });
	};
};
function choiceAuctionTitle(slct) {
	var auctionId = $(slct).find("option:selected").val();
	if(auctionId){
	    $.get("${ctx}/adu/loadAuctionInfo?auctionId=" + auctionId, function(result, status) {
	        var success = result.success;
	        if (success) { 
	        	var data = result.data;
	        	$("#auctionName").html(data.auctionTitle);
	        	$("#auctionDate").html(data.auctionDate);
	        	$("#auctionvehicleNum").html(data.auctionVehicleNum);
	        	$("#auctionDealNum").html(data.dealNum);
	        
	        	$("#memCount").text("上传参拍人数：" + data.auctionPersonNum);
	        	$("#vehicleCount").text("上传车辆数：" + data.uploadAuctionVehicleNum);
	        	$("#dealCount").text("上传成交数：" + data.auctionSuccessNum);
	        	
	        	$("#deLoadDate").html(data.auctionDate);
	        	$("#deLoadPersonNum").html(data.auctionPersonNum);
	        	$("#deLoadVehicleNum").html(data.uploadAuctionVehicleNum);
	        	$("#deLoadDealNum").html(data.auctionSuccessNum);
	        	
	        } else {
	        	alert(result.msg);
	        	
	        };
	    });
	}else{
		$("#auctionName").html("");
		$("#auctionDate").html("");
		$("#auctionvehicleNum").html("");
		$("#auctionDealNum").html("");
		$("#memCount").text("上传参拍人数：" + "");
		$("#vehicleCount").text("上传车辆数：" + "");
		$("#dealCount").text("上传成交数：" + "");
		$("#deLoadDate").html("");
		$("#deLoadPersonNum").html("");
		$("#deLoadVehicleNum").html("");
		$("#deLoadDealNum").html("");
	}
};

function uploadData() {
	var frm = $("#uploadForm");
    var auctionId = frm.find("select option:selected").val();
	var fileId = $("#fileId").val();
	if (confirm("是否确认导入？")) {
		 $.get("${ctx}/adu/uploadFile?fileId=" + fileId+"&auctionId="+auctionId, function(result, status) {
            if (result.success) {
            	alert(result.msg);
            	location.href="${ctx}/adu/index";
            }else {
            	alert(result.msg);
            	return;
            };
        });
	};
};


function viewFile(){
	ajaxFileUpload();
}

function ajaxFileUpload() {
	var auctionId=$("#checkauctionId").val();
	if(auctionId==''){
		alert("请选择一个拍卖会");
		var file = $("#file1");
        file.after(file.clone().val(""));
        file.remove();
		return;
	}
	
    $.ajaxFileUpload({
        url: '${ctx}/adu/uploadCheck', //用于文件上传的服务器端请求地址
        secureuri: false, //是否需要安全协议，一般设置为false
        fileElementId: 'file1', //文件上传域的ID
        data:{fileId:$("#fileId").val(),
        	auctionId:auctionId},
        dataType: 'json', //返回值类型 一般设置为json
        success: function (data, status){
        	if (data.success) {
        		var dd=  data.data;
            	$("#memCount").text("上传参拍人数：" + dd.personNum);
            	$("#vehicleCount").text("上传车辆数：" + dd.vehicleCount);
            	$("#dealCount").text("上传成交数：" + dd.successCount);
            	$("#fileId").val(dd.fileId);
			}else{
				alert(data.msg);
			}
        },error: function (data, status, e){
            alert(e);
        }
    })
    return false;
}
</script>
</body>
</html>