<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>AutoStreets后台系统-拍卖中心</title>
<%@include file="/jsp/common/css.jsp"%>
<link href="${staticUrl}/eqs/build/1.00/css/eqs_1.css" rel="stylesheet" type="text/css" />
<%@include file="/jsp/common/js.jsp"%>
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
			<div class="container_main">
        		<div class="wrap">
        			<form:form action="" method="post"  commandName="auctionPlace" id="addAuctionPlaceForm" modelAttribute="auctionPlace">
        				<form:hidden path="id"/>
						<form:hidden path="enabled"/>
						<form:hidden path="createdTime"/>
						<table class="form_table width_percent_100">
							<tbody>
								<tr class="thead">
									<td colspan="4"><c:if test="${auctionPlace.id!=null }">编辑</c:if><c:if test="${auctionPlace.id == null }">创建</c:if>拍卖中心</td>
								</tr>
								<tr>
									<th><span class="need">*</span>名称：</th>
									<td>
										<form:input path="name" maxlength="50"></form:input>
									</td>
									<th><span class="need">*</span>时间：</th>
									<td>
										<form:input path="period" id="startTimestamp"/>
									</td>
								</tr>
								<tr>
									<th><span class="need">*</span>省：</th>
									<td>
										<spring:eval expression="@dictAreaService.selectProvinces()" var="provinces"/>
										<form:select path="province" onchange="getcitys();">
											<option value="">---请选择---</option>
											<c:forEach items="${provinces }" var="pro">
											<form:option value="${pro}" title="${pro}">${pro}</form:option>
											</c:forEach>										
										</form:select>
									</td>
									<th><span class="need">*</span>市：</th>	
									<td>
										<form:select path="city">
											<c:if test="${null == auctionPlace.city}">
												<form:option value="" selected="selected">---请选择---</form:option>
											</c:if>
											<c:if test="${null != auctionPlace.city}">
												<spring:eval expression="@dictAreaService.selectCityByProvince(auctionPlace.province)" var="subSetCitys" />
												<c:forEach items="${subSetCitys}" var="city">
												    <form:option value="${city}" title="${city}">${city}</form:option>
												</c:forEach>
											</c:if>
										</form:select>
									</td>
								</tr>
	                            <tr>
									<th><span class="need">*</span>地址：</th>
									<td>
										<form:input path="addr" maxlength="150"></form:input>
									</td>
									<th><span class="need">*</span>联系电话：</th>
									<td>
										<form:input path="telephone"/>
									</td>
								</tr>
								<tr>
									<th><span class="need">*</span>拍卖中心图标图片：</th>
									<td colspan="3">
										<input type="file" name="picUrl_file" id="picUrl_file" accept="image/*" onchange="changePhoto(this.id)"> <form:hidden path="picUrl" />
										<spring:eval expression="@autoDictionaryService.choiceImgUrl('208X108','${auctionPlace.picUrl}')" var="imgPreview" />
										<div class="img_preview">
											<img <c:if test="${imgPreview!=''}">src="${dfsHttpServer}/${imgPreview}"</c:if> onclick="picUrl_file.click()" width="208" height="108" />
										</div>
										<span style="color: gray">上传图片尺寸为：520*270，只支持jpg，gif，png格式</span>
									</td>
								</tr>
								<tr>
									<th rowspan="2"><span class="need">*</span>拍卖中心轮播图片：</th>
									<td colspan="3">
										<table class="width_percent_100">
											<tr>
												<td>
													<input type="file" name="banner1Url_file" id="banner1Url_file" accept="image/*" onchange="changePhoto(this.id)">
													<form:hidden path="banner1Url" cssClass="bannerUrl" />
													<spring:eval expression="@autoDictionaryService.choiceImgUrl('244X112','${auctionPlace.banner1Url}')" var="imgPreview1" />
													<div class="img_preview">
														<img <c:if test="${imgPreview1!=''}">src="${dfsHttpServer}/${imgPreview1}"</c:if> onclick="banner1Url_file.click()" width="244" height="112" />
													</div>
													<div style="color: gray">上传图片尺寸为：610*280，只支持jpg，gif，png格式</div>
												</td>
												<td>
													<input type="file" name="banner2Url_file" id="banner2Url_file" accept="image/*" onchange="changePhoto(this.id)">
													<form:hidden path="banner2Url" cssClass="bannerUrl" />
													<spring:eval expression="@autoDictionaryService.choiceImgUrl('244X112','${auctionPlace.banner2Url}')" var="imgPreview2" />
													<div class="img_preview">
														<img <c:if test="${imgPreview2!=''}">src="${dfsHttpServer}/${imgPreview2}"</c:if> onclick="banner2Url_file.click()" width="244" height="112" />
													</div>
													<div style="color: gray">上传图片尺寸为：610*280，只支持jpg，gif，png格式</div></td>
												<td>
													<input type="file" name="banner3Url_file" id="banner3Url_file" accept="image/*" onchange="changePhoto(this.id)">
													<form:hidden path="banner3Url" cssClass="bannerUrl" />
													<spring:eval expression="@autoDictionaryService.choiceImgUrl('244X112','${auctionPlace.banner3Url}')" var="imgPreview3" />
													<div class="img_preview">
														<img <c:if test="${imgPreview3!=''}">src="${dfsHttpServer}/${imgPreview3}"</c:if> onclick="banner3Url_file.click()" width="244" height="112" />
													</div>
													<span style="color: gray">上传图片尺寸为：610*280，只支持jpg，gif，png格式</span>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td colspan="3"><div style="color:gray;">注：请至少上传一张轮播图片</div></td>
								</tr>
								<tr>
									<th><span class="need">*</span>车道属性：</th>
									<td colspan="3" id='driveTable'>
										<div class='driveway'>
											<input type="hidden" name="drivewayId">
											车道位置：<input name="drivewayName"/><br>
											视频地址：<input name="videoUrl" style="width:80%"/><br>
											音频地址：<input name="audioUrl" style="width:80%"/><br>
											<input type="button" value="添加" name="addDriveway">
											<div style="color:gray">注：若未填写车道位置，将不会记录或修改该条车道属性,至少配置一条车道</div>
										</div>
									</td>
								</tr>
								<tr>
									<th>备注：</th>
									<td colspan="3">
										<textarea rows="4" id="remark" cols="60%" style="resize:none" maxlength="200" name="remark"></textarea>
									</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="4">
										<p align="center" class="btn-box">
											<c:if test="${auctionPlace.id!=null}">
												<input type="button" class="button_lv4_1" value="更新"  id="save" /> 
											</c:if>
											<c:if test="${auctionPlace.id==null}">
												<input type="button" class="button_lv4_1" value="保存"  id="save" /> 
											</c:if>
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
$(document).ready(function(){
	$('#remark').val("${auctionPlace.remark}");
	$('#cancel').click(function(){
		window.close();
	});
	$('#save').click(function(e){
		if($.trim($('#name').val())==""){
			alert("请填写拍卖中心名称");
			return;
		}
		var startTimestamp  = $("#startTimestamp").val();
	    if(startTimestamp!=""){
     	    var is1=isDateTime(startTimestamp,e);
     	    if(!is1){return;}
     	}
		if($.trim($('#province').val())==""||$.trim($('#city').val())==""){
			alert("请选择地区");
			return;
		}
		if($.trim($('#addr').val())==""){
			alert("请填写地址");
			return;
		}
		if($('#picUrl').val()==""){
			alert("请选择拍卖中心图标图片");
			return;
		}
		var hasBannerUrl=false;
		$('.bannerUrl').each(function(i,e){
			if($(e).val()!=""){
				hasBannerUrl=true;
				return;
			}
		});		
		if(!hasBannerUrl){
			alert("请至少上传一张轮播图片");
			return;
		}
	  	var names=$("#driveTable").find("input[name='drivewayName']");
	  	var hasDriveway=false;
		$(names).each(function(i,e){
			if($(names.get(i)).val()!=""){
				hasDriveway=true;
				return;
			}
		});
		if(!hasDriveway){
			alert("请至少配置一条车道信息");
			return;
		}
	  	for(var i=0;i<names.length;i++){
	  		for(var j=i+1;j<names.length;j++){
	  			if($(names.get(i)).val().trim()==$(names.get(j)).val().trim()){
	 		  		alert("多个车道名称不能重复！");
					return;
	  			}
	  		}
	  	}
		$(this).attr("disabled","disabled");
/* 	  	if(names.length>=2){
				for(i=0;i<names.length-1;i++){
					if($(names.get(i)).val().trim()==$(names.get(names.length-1)).val().trim()){
						//hasSameDriveway=true;
		 		  		alert("多个车道名称不能重复！");
		 		  		$(names.get(names.length-1)).val("");
						return;
					}
				}
	  	} */

			  var datas=$('#addAuctionPlaceForm').serialize();
			  $.post("${ctx }/auctionplace/save",datas,function(result){
			    alert(result);
				//刷新父窗口
 				window.opener.location.reload();
				$('#cancel').click(); 

			  });

	});
	//动态获取车道信息
	var placeId="${auctionPlace.id}";
	$.ajax({
		url:"${ctx}/auctionplace/getDriveways",
		type:"post",
		dataType:"json",
		data:{placeId:placeId},
		success:function(resp){
			//alert(resp.data.length);
			if(resp.data&&resp.data.length>=1){				
					var driveWay=$(".driveway").clone(true);
					$(".driveway").remove();
					$.each(resp.data, function(index, e){
						driveWay.find("input[name='drivewayId']").val(e.id);
						driveWay.find("input[name='videoUrl']").val(e.videoUrl);
						driveWay.find("input[name='drivewayName']").val(e.name);
						driveWay.find("input[name='audioUrl']").val(e.audioUrl);
						$("#driveTable").append(driveWay);
						driveWay=driveWay.clone(true);
					});
			}
			$('.driveway input:last').show();
		}		
	});	
	
	$('input[name="addDriveway"]').click(function(){
		//判断当前车道表格的名称是否已填
		  if($(this).prevAll("input[name='drivewayName']").val()==""){
		      alert("请将车道信息补全后再添加！");
		      return false;
	       }

			var newDriveway=$(".driveway:first").clone(true);
			newDriveway.find("input[name='drivewayId']").val("");
			newDriveway.find("input[name='videoUrl']").val("");
			newDriveway.find("input[name='drivewayName']").val("");
			newDriveway.find("input[name='audioUrl']").val("");
			$("#driveTable").append(newDriveway);
			$(this).hide();
			$('.driveway input:last').show();
	});
});
var getcitys=function(){
	var proId=$('#province').children("option:selected").attr("title");
	if(proId!=""){
		$.get("${ctx}/auctionplace/getCitys",{proId:proId},function(data){
			$('#city').empty().append("<option value=''>---请选择---</option>");
			$.each(data,function(items,e){
				var options="<option value="+e.city+">&nbsp;&nbsp;&nbsp;"+e.city+"</option>";
				$('#city').append(options);
			});
		});
	}
}
/**
 * 图片上传预览
 */
 var changePhoto = function(compId) {
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
</script>
</body>
</html>