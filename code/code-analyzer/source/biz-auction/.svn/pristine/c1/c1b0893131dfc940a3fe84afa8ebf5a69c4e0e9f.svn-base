<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>拍卖会管理-新增修改</title>
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
			<div class="rbody s_form" style="padding-left: 55px;">
				<c:if test="${auction.id!=null and flag=='view' }">
				 <script type="text/javascript">
				        $(document).ready(function(){
				        	disabledNotThisInput("cancel");
				        });
			    </script>
			    </c:if>
				<form:form action="${ctx }/auction/addOrUpdate" method="post"  commandName="auction" id="addAuctionForm" modelAttribute="auction"  enctype="multipart/form-data">
					<table class="tbl-form-1" id="tab" style="width:90%;">
						<tbody>
							<tr class="thead">
								<td colspan="4"><c:if test="${auction.id!=null and flag=='edit' }">编辑</c:if><c:if test="${auction.id==null and flag=='add' }">创建</c:if><c:if test="${auction.id!=null and flag=='view' }">查看</c:if>拍卖会</td>
							</tr>
							<tr>
								<th width="20%">竞拍名称：</th>
								<td colspan="3" width="20%">
									<form:hidden path="id"/>
									<form:hidden path="createdBy" value="${currentUser }"/>
									<form:input path="title" cssClass="from-input-1 width_150" maxlength="55"/>
								</td>
							</tr>
							<tr>
								<th >预计开始时间：</th>
								<td>
									<form:input path="startTimestamp" cssClass="from-input-1" cssStyle="width:150px"/>
								</td>
								<th width="20%">预计结束时间：</th>
								<td width="30%">
									<form:input path="endTimestamp" cssClass="from-input-1" cssStyle="width:150px"/>
								</td>
						    </tr>
                            <tr>
								<th >拍卖类型：</th>
								<td>
										<form:select path="type" cssClass="width_156">  
											<form:option value="0" label="同步拍"></form:option>
										</form:select>
								</td>
								<th>拍卖方式：</th>
								<td>
									<form:select path="auctionModel" cssClass="width_156">  
										<spring:eval expression="@autoDictionaryService.selectAuctionModel()" var="models"/>
										<form:options items="${models}" itemLabel="name"  itemValue="value"></form:options>
									</form:select>
								</td>
							</tr>
                            <tr>
								<th>选择拍卖场所：</th>
                                <td>
                                    <form:select path="placeId" cssClass="width_156">
                                    	<form:option value="" label="请选择"/>
                                    	<form:options itemLabel="name" itemValue="id" items="${auctionPlaces}"/>
                                    </form:select>
                                    <form:select path="drivewayId" cssClass="width_156">
                                    	<form:option value="" label="请选择"/>
                                    </form:select>
                                </td>
								<th>联系人：</th>
                                <td>
                                    <form:input path="contact" cssClass="from-input-1"  cssStyle="width:150px"/>
                                </td>
							</tr>
							<tr>
								<th >专场&amp;下线时间：</th>
								<td>
									<label><form:checkbox path="special" id="special" cssStyle="position: relative;top: 3px;"/>专场</label>
									<form:input path="endDisplayTime" readonly="readonly" cssClass="width_150"/>
								</td>
								<th>联系人电话：</th>
                                <td>
                                    <form:input path="contactTellphone" cssClass="from-input-1" cssStyle="width:150px"/>
                                </td>
							</tr>
                            <tr>
								<th>车辆数量：</th>
                                <td>
                                	<%--修改为只读，此属性添加拍卖车辆时会自动计算 --%>
                                    <form:input path="vehicleQuantity"  cssClass="from-input-1 width_150" />
                                </td>
                                <th>车辆数量上限：</th>
                                <td>
                                    <form:input path="vehicleMax"  cssClass="from-input-1 width_150"/>
                                </td>
							</tr>
							<tr>
								<th>拍卖人手机：</th>
								<td  colspan="3">
									<form:input path="auctioneerCellphone" cssClass="from-input-1 width_150"/>
								</td>
							</tr>
							<tr>
								<th>场次：</th>
                                <td colspan="1">
                                    <form:input path="auctionNum"  cssClass="from-input-1 width_150" disabled="true"/>
                                </td>
								<th>仓储门店：</th>
                                <td colspan="1">                     
                                    <form:select path="orgId" cssClass="width_156">
                                    	<form:option value="">请选择</form:option>
										<form:options items="${orgs}" itemLabel="orgName" itemValue="id"/>
                                    </form:select>
                                </td>                                
							</tr>
                            <tr>
								<th>是否需要保证金：</th>
								<td id="depositMarginId">
									<form:select path="depositMargin" cssClass="width_156" name="depositMargin" onchange="showDepositMargin();">
										<form:option value="false">否</form:option>
										<form:option value="true">是</form:option>
									</form:select>
								</td>
								<th id="marginId">保证金：</th>
								<td id="marginText">
									<table>
									    <tr>
										    <td  style="border-style: none;">
												<input type="radio" id="margin1" name="margin">场次保证金
													<span id="auctionMarginSpan">
													   <form:input path="auctionMargin" cssClass="from-input-1" cssStyle="width:70px"/>元/场
													</span>
											</td>
										</tr>
										<tr>
		                                   <td  style="border-style: none;">
												<input type="radio" id="margin2" name="margin">车辆保证金
												   <span id="vehicleMarginSpan">
												       <form:input path="vehicleMargin" cssClass="from-input-1" cssStyle="width:70px"/>元/辆
											   </span>
										   </td>
	                                    </tr>
									</table>
								</td>
							</tr>
							<tr>
								<th>视频地址：</th>
								<td colspan="3">
									<form:input path="videoUrl" cssStyle="width:80%;" cssClass="from-input-1"/>
								</td>
							</tr>
                            <tr>
								<th>音频地址：</th>
								<td colspan="3">
									<form:input path="audioUrl" cssStyle="width:80%;" cssClass="from-input-1"/>
								</td>
							</tr>
							<tr>
                                <th >拍卖车型描述：</th>
                                <td colspan="3">
                                    <form:textarea path="auctionModelDesc"  rows="3" cssStyle="height:40px;width:80%;"></form:textarea>
                                </td>
                            </tr>
							<tr>
                                <th >拍卖车辆描述：</th>
                                <td colspan="3">
                                    <form:textarea path="acutionVehicleDesc"  rows="3" cssStyle="height:40px;width:80%;"></form:textarea>
                                </td>
                            </tr>
							<tr>
                                <th >拍卖公告：</th>
                                <td colspan="3">
                                    <form:textarea path="content"  id="iamnotContent" rows="3" cssStyle="height:40px;width:80%;"></form:textarea>
                                </td>
                            </tr>
                            <tr>
                                <th >拍卖须知：</th>
                                <td colspan="3">
                                    <form:textarea path="notice" rows="3" cssStyle="height:40px;width:80%;"></form:textarea>
                                </td>
                            </tr>
                            <tr>
                                <th >成交指南：</th>
                                <td colspan="3">
                                    <form:textarea path="transactionGuide" rows="3" cssStyle="height:40px;width:80%;"></form:textarea>
                                </td>
                            </tr>
                            <tr>
                                <th >专场头像：</th>
                                <td colspan="3">
                                	<input type="file" name="picUrl_file" id="picUrl_file" accept="image/*" onchange="changePhoto(this.id)">
                                	<form:hidden path="picUrl"/>
                                	<spring:eval expression="@autoDictionaryService.choiceImgUrl('208X108','${auction.picUrl}')" var="imgPreview"/>
                                	<div class="img_preview"><img <c:if test="${imgPreview!=''}">src="${dfsHttpServer}/${imgPreview}"</c:if> onclick="picUrl_file.click()" width="160" height="120"/></div>
                                	<p style="color:#999;">提示：上传的图片尺寸必须为520*270</p>
                                </td>
                            </tr>
                             <tr>
                                <th>专场轮播图片：</th>
                                <td colspan="3" style="padding:0;">
                                   <table width="100%" class="bannerUrl_table">
                                	<tr><td>
	                                	<input type="file" name="banner1Url_file" id="banner1Url_file" accept="image/*" onchange="changePhoto(this.id)">
	                                	<form:hidden path="banner1Url" cssClass="bannerUrl"/>
	                                	<spring:eval expression="@autoDictionaryService.choiceImgUrl('244X112','${auction.banner1Url}')" var="imgPreview1"/>
	                                	<div class="img_preview"><img <c:if test="${imgPreview1!=''}">src="${dfsHttpServer}/${imgPreview1}"</c:if> onclick="banner1Url_file.click()" width="244" height="112"/></div>
	                                	<p style="color:#999;">提示：上传的图片尺寸必须为610*280</p>
									 </td><td>		
	                                	<input type="file" name="banner2Url_file" id="banner2Url_file" accept="image/*" onchange="changePhoto(this.id)">
	                                	<form:hidden path="banner2Url" cssClass="bannerUrl"/>
	                                	<spring:eval expression="@autoDictionaryService.choiceImgUrl('244X112','${auction.banner2Url}')" var="imgPreview2"/>
	                                	<div class="img_preview"><img <c:if test="${imgPreview2!=''}">src="${dfsHttpServer}/${imgPreview2}"</c:if> onclick="banner2Url_file.click()" width="244" height="112"/></div>
									 </td><td style="border-right:0;">
	                                	<input type="file" name="banner3Url_file" id="banner3Url_file" accept="image/*" onchange="changePhoto(this.id)">
	                                	<form:hidden path="banner3Url" cssClass="bannerUrl"/>
	                                	<spring:eval expression="@autoDictionaryService.choiceImgUrl('244X112','${auction.banner3Url}')" var="imgPreview3"/>
	                                	<div class="img_preview"><img <c:if test="${imgPreview3!=''}">src="${dfsHttpServer}/${imgPreview3}"</c:if> onclick="banner3Url_file.click()" width="244" height="112"/></div>
                                 </table>
                              </td>
                            </tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4">
									<p align="center" class="btn-box">
										<c:if test="${auction.id!=null and flag=='edit' }">
											<input type="button" class="button_lv4_1" value="更新"  id="save" /> 
										</c:if>
										<c:if test="${auction.id==null and flag=='add' }">
											<input type="button" class="button_lv4_1" value="保存"  id="save" /> 
										</c:if>
										<c:if test="${auction.id!=null and flag=='view' }">
											<script type="text/javascript">$(document).ready(function (){ $("#cancel").val("返回"); });</script>
										</c:if>
										<input type="button" class="button_lv4_1" style="margin-left:12px;" value="关闭"  id="cancel" />
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
function validatemobile(mobile)
{
    if(mobile.length==0)
    {
        return 1;
    }
    if(mobile.length!=11)
    {
        return 2;
    }
    var re = /^[1][3578]\d{9}$/;
    if (!mobile.match(re)){
        return 2;
    }
    return 3;
}
$(document).ready(function (){
	
   $("#cancel").click(function (){ closeWindow(); });
   
   showDepositMargin();
   
   var auctionMargin = "${auction.auctionMargin}";
   if(auctionMargin!=""&&parseFloat(auctionMargin)!=(0.00)){
       $("#margin1").attr("checked","checked");
   }
      
   var vehicleMargin = "${auction.vehicleMargin}";
   if(vehicleMargin!=""&&parseFloat(vehicleMargin)!=(0.00)){
       $("#margin2").attr("checked","checked");
   }
      
  checkMargin1Radio();
  $("input[name=margin]").click(function (){
  	checkMargin1Radio();
  });
  
  $("#auctionMargin").click(function(){
      $("#margin1").attr("checked","checked");
      checkMargin1Radio();
 });
 
 $("#vehicleMargin").click(function(){
      $("#margin2").attr("checked","checked");
      checkMargin1Radio();
 });
   
 //表单提交检查
    $("#save").click(function(check){  
        var type = $.trim($("#type").val());  
        var title = $.trim($("#title").val());  
        var auctionModel = $.trim($("#auctionModel").val());  
        var vehicleQuantity = $.trim($("#vehicleQuantity").val());  
        var vehicleMax = $.trim($("#vehicleMax").val());  
        //var content = $.trim($("#iamnotContent").val());  
        var auctionModelDesc = $.trim($("#auctionModelDesc").val());  
        var acutionVehicleDesc = $.trim($("#acutionVehicleDesc").val());
        var startTimestamp = $.trim($("#startTimestamp").val());
        var endTimestamp = $.trim($("#endTimestamp").val());
        var placeId = $("#placeId").val();
        var picUrl = $("#picUrl").val();//专场头像图片
        var bannerUrl  = $(".bannerUrl");//banners
        var auctionNum  = $.trim($("#auctionNum").val());//场次
        var driveway = $.trim($('#drivewayId').val());
        
        if(title==""){  
            alert("请填写拍卖标题~");  
            $("#title").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
        if(!$.trim(startTimestamp)){  
            alert("请填写预计开始时间~");  
            $("#startTimestamp").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
        if(!$.trim(endTimestamp)){  
            alert("请填写预计结束时间~");  
            $("#endTimestamp").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
    	if(startTimestamp!=""){
    	    var is1=isDateTime(startTimestamp,check);
    	    if(!is1){return;}
    	}
    	if(endTimestamp!=""){
    	    var is2=isDateTime(endTimestamp,check);
    	    if(!is2){return;}	
    	}
        if(compareDate(startTimestamp,endTimestamp) >= 0){
        	alert("预计开始时间必须小于结束时间~");  
        	$("#startTimestamp").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
        if(type==""){  
            alert("请选择拍卖类型~");  
            $("#type").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
        if(placeId==""){  
            alert("请选择拍卖场所");  
            $("#placeId").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
        if(driveway==""){  
            alert("请选择拍卖车道");  
            $("#drivewayId").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
        if(auctionModel==""){  
            alert("请选择拍卖方式~");  
            $("#auctionModel").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
        var regx = /^[1-9]+\d*$/
//         if(auctionNum==''){  
//      	    alert("场次不能为空");  
// 	        $("#auctionNum").focus();  
// 	        check.preventDefault();//阻止表单提交
//          	return;
//      	}else if(!regx.test(auctionNum)){
//      		alert("场次不正确");  
// 	        $("#auctionNum").focus();  
// 	        check.preventDefault();//阻止表单提交
//          	return;
//      	}
        
        if(vehicleQuantity!=""){
        	var reg = new RegExp("^[0-9]*$");
        	if(!reg.test(vehicleQuantity)){
	            alert("拍卖车辆数量只能为整数~");  
	            $("#vehicleQuantity").focus();  
	            check.preventDefault();//阻止表单提交
	            return;
        	}
        }
        
//         if(vehicleMax==''){
//        	   alert("拍卖车辆数量上限不能为空");  
//            $("#auctionNum").focus();  
//            check.preventDefault();//阻止表单提交
//      	   return;
//         }
        
//         if(vehicleMax!=""){
//         	var reg = new RegExp("^[0-9]*$");
//         	if(!reg.test(vehicleMax)){
// 	            alert("拍卖车辆数量上限只能为整数~");  
// 	            $("#vehicleMax").focus();  
// 	            check.preventDefault();//阻止表单提交
// 	            return;
//         	}
//         }

        if(auctionModelDesc!="" && auctionModelDesc.length>100){  
            alert("拍卖车型描述不能超过100个字~");  
            $("#auctionModelDesc").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
        if(acutionVehicleDesc!="" && acutionVehicleDesc.length>100){  
        	   alert("拍卖车辆描述不能超过100个字~");  
            $("#acutionVehicleDesc").focus();  
            check.preventDefault();//阻止表单提交
            return;
        }
        
        var mobile=validatemobile($("#auctioneerCellphone").val());
		if(mobile=="2"){
			alert("请填写正确的联系电话!");
			return;
		}
        
        //专场
        if(isSpecial){
        	if(picUrl==''){
        		alert("请上传专场头像");
        		check.preventDefault();//阻止表单提交
        		return;
        	}
        	var burl = false;
        	$(bannerUrl).each(function(i,e){
				if($(e).val()!=''){
					burl = true;
					return false;
				}        		
        	});
        	if(!burl){
        		alert("专场轮播图片至少上传一张");
        		check.preventDefault();//阻止表单提交
        		return;
        	}
        }
        if($("#margin2").is(":checked") && !testLength($("#vehicleMargin").val())){
    		alert("车辆保证金数额太大");
    		check.preventDefault();//阻止表单提交
    		return;
        }
        if($("#margin1").is(":checked") && !testLength($("#auctionMargin").val())){
    		alert("场次保证金数额太大");
    		check.preventDefault();//阻止表单提交
    		return;
        }
        
        
        $("#addAuctionForm").submit();
    });
});
var testLength = function(price){
	var reg = /^[1-9][0-9]{0,5}(\.)?\d{0,2}$/;
	return reg.test(price); 
};
var checkMargin1Radio = function(){
	 switch($("input[name=margin]:checked").attr("id")){
	  case "margin1":
	        $("#auctionMargin").removeAttr("disabled");
	        $("#auctionMarginSpan").show();
	        $("#vehicleMargin").attr("disabled","disabled");
	        $("#vehicleMarginSpan").hide();
	        break;
	  case "margin2":
	      $("#vehicleMargin").removeAttr("disabled");
	      $("#vehicleMarginSpan").show();
	      $("#auctionMargin").attr("disabled","disabled");
	      $("#auctionMarginSpan").hide();
	      break;
	  default:
	   break;
	 }
	 if('${flag}' == "view"){
		 $("#auctionMargin").attr("disabled","disabled");
		 $("#vehicleMargin").attr("disabled","disabled");
	 }
};
	
var showDepositMargin = function(){
	var depositMargin=$("#depositMargin").val();
       if(depositMargin == "false"){//否
            $("#marginId").hide();
            $("#marginText").hide();
            $("#depositMarginId").attr("colspan",3);
        }else if(depositMargin == "true"){//是
       	 $("#marginId").show();
            $("#marginText").show();
            $("#depositMarginId").attr("colspan",0);
       }
};

var compareDate = function(strDate1,strDate2)
{
    var date1 = new Date(strDate1.replace(/\-/g, "\/"));
    var date2 = new Date(strDate2.replace(/\-/g, "\/"));
    return date1-date2;
}


//专场
var isSpecial = '${auction.special}';
isSpecial = isSpecial==''||isSpecial=='false'?false:true;
$(function(){
	$("#special").change(function(){
		isSpecial = $(this).is(":checked")?true:false;
	});
});

var changePhoto = function(compId,picSize) {
    $.ajaxFileUpload({
        url: "${ctx}/auctionplace/upload",// 上传链接
        secureuri: false,         // 是否安全链接 默认false
        fileElementId: compId,    // 提取文件的标签id，即input file标签的id
        data: {name: compId},     // 传值:filepath
        dataType: "text/html",    // 指定返回content-type
        success: function(path, status) {
        	if(path.indexOf("<pre")!=-1){
        		var html = $(path).html();
	        	if(path.indexOf("group")==-1){
	        		alert(html);
	        	}else{
		        	path=html;
		        	$("#"+compId).siblings("input[type='hidden']").val(path);
		        	path = path.substring(0,path.lastIndexOf("."))+"*244*112"+path.substring(path.lastIndexOf("."));
		        	fullPath = "${dfsHttpServer}/"+path;
		        	$("#"+compId).siblings(".img_preview").children("img").attr("src",fullPath);
	        	}
        	}
        }
    });
}
var drivewayId = '${auction.drivewayId}';
$(function(){
	$("#placeId").change(function(){
		var placeId = $(this).val();
		if(placeId){
			$.post("${ctx}/auctionplace/getDriveways",{placeId:placeId},function(resp){
				$("#drivewayId").html("<option value=''>请选择</option>");
				if(resp.success){
					$(resp.data).each(function(i,e){
						var tmpl = "<option videoUrl='"+e.videoUrl+"' audioUrl='"+e.audioUrl+"' value='"+e.id+"'";
						if(e.id==drivewayId){
							tmpl+=" selected='selected'>";
						}else{
							tmpl+=">";
						}
						tmpl+=e.name+"</option>";
						$("#drivewayId").append(tmpl);
					});
					$("#drivewayId").trigger('change');
				}
			});
		}else{
			$("#drivewayId").html("<option value=''>请选择</option>");		
		}
	});
	$("#placeId").trigger('change');
	
	$("#drivewayId").change(function(){
		var videoUrl = $(this).children("option:selected").attr("videoUrl");
		var audioUrl = $(this).children("option:selected").attr("audioUrl");
		$("#videoUrl").val(videoUrl);
		$("#audioUrl").val(audioUrl);
		checkAuctionPlace();
	});
	
	/* $("#auctionNum").blur(function(){
		var auctionNum = $(this).val();
		var oldNum = $(this).prop('defaultValue');
		if(auctionNum!=''&&auctionNum!=oldNum){
			var placeId = $("#placeId").val();
			var placeName = $("#placeId").children("option:selected").text();
			if(placeId){
				$.post("${ctx}/auctionplace/getPlaceLastAuctionNum",{placeId:placeId},function(resp){
					if(resp.success){
						var lastNum = resp.data;
						if(auctionNum<=lastNum){
							alert(placeName+"当前最大场次为"+lastNum+"，请重新填写本次场次！");
							$("#auctionNum").focus().val("");
						}
					}
				});
			}else{
				alert("请先选择拍卖场所！");
				$("#auctionNum").val("");
			}
		}
	}); */
	
});

function checkAuctionPlace(){
	var drivewayId = $("#drivewayId").val();
	if(drivewayId){
		$.ajax({
			url:"${ctx}/auction/getMaxAuctionPlace",
			data:{
				placeId:drivewayId
			},
			success:function(data){
				if(data){
					$("#auctionNum").val(data+1);
				}
			}
		})
	}
}
</script>
<%--车辆数量禁止修改 --%>
<c:if test="${auction.id!=null}">
<script type="text/javascript">
	$(function(){
		$("#vehicleQuantity").attr("readonly","readonly");		
	});
</script>
</c:if>
</body>
</html>