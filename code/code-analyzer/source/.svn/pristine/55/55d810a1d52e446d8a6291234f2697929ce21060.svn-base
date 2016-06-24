<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>AutoStreets后台系统-拍卖统计</title>
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
   				<form:form action="${ctx }/report/auctionreport" method="post" commandName="auctionVehicleVO" id="auctionVehicleForm">
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
								<form:option value="99" label="请选择"></form:option>
								<spring:eval expression="@autoDictionaryService.selectAuctionType('desc')" var="types" />
								<form:options items="${types}" itemLabel="name" itemValue="value"></form:options>
							</form:select>
						</li>
						<li id="li_av_type" class="width-250">
							<p>拍品类型：</p>
							<spring:eval expression="@autoDictionaryService.selectResource('av_type')" var="av_types" />
							<form:select path="avType" >
								<form:option value="" label="选择类型" />
								<form:options items="${av_types}" itemLabel="name" itemValue="value" />
							</form:select>
						</li>
						<li class="width-250">
							<p>拍品状态：</p>
							<form:select path="status">
								<form:option value="99" label="请选择"></form:option>
								<form:option value="2" label="拍卖成功"></form:option>
								<form:option value="3" label="成交确认"></form:option>
								<form:option value="4" label="流拍"></form:option>
								<form:option value="7" label="取消订单"></form:option>
							</form:select>
						</li>
						<li class="width-250">
							<p>竞拍区域：</p>
							<form:input path="city" maxlength="12"/>
						</li>
						<li class="width-250">
							<p>VIN码：</p>
							<form:input path="vinCode" maxlength="30" />
						</li>
						<li class="width-250">
							<p>车辆编号：</p>
							<form:input path="code" maxlength="36" />
						</li>
						<li class="width-250">
							<p>车牌号：</p>
							<form:input path="licenseCode" maxlength="10"/>
						</li>
						<li class="width-250">
							<p>评估师：</p>
							<form:input path="vehicleAppraiser" maxlength="12"/>
						</li>
						<li class="width-250">
							<p>评估部门：</p>
							<form:input path="evaluationDept" maxlength="20"/>
						</li>
						<li class="width-250">
							<p>发拍人：</p>
							<form:input path="creatorName" maxlength="20"/>
							<form:hidden path="creatorId"/>
						</li>						
						<li id="dateShow" class="width-600">
							<p>竞拍时间：</p>
							<form:input path="startTimestamp" id="startTimestamp1"/>
							<label class="inp-label">至</label>
							<form:input path="endTimestamp" id="endTimestamp1"/>
						</li>
						<li class="width-250 advancedSearch">
							<p>竞得人：</p>
							<form:input path="bidderName" maxlength="12" />
						</li>
						<li class="width-250 advancedSearch">
							<p>竞价人类型：</p>
							<form:select path="bidderType" >
								<form:option value="99" label="请选择" />
								<form:option value="0" label="客户" />
								<form:option value="1" label="内部人员" />
							</form:select>
						</li>
						<li class="width-250 advancedSearch">
							<p>数据筛选方式：</p>
							<form:select path="dataQueryPattern">
								<form:option value="99" label="请选择" />
								<form:option value="0" label="按最高出价" />
								<form:option value="1" label="按最新拍品" />
							</form:select>
						</li>
					</ul>
   				</form:form>
                <div class="query">
                	<a id="search" class="query_btn">查询</a>
                 	<a id="morechoice" class="query_btn ml10">高级选项</a>
                	<a class="query_btn ml10" onclick="common.formReset('auctionVehicleForm')">清空条件</a>
                	<shiro:hasPermission name="auct:auctionreport:exportexcel">
	                	<a class="query_btn ml10" id="link-export">导出Excel</a>
                	</shiro:hasPermission>
                </div>
                <div class="exportselect" id="exportselect" style="display:none;float:left;">
	                <form:form id="exportForm" method="post" accept-charset="utf-8" enctype="application/x-www-form-urlencoded">
	                    <ul>
	                        <li><input type="checkbox" name="exportCol" value="brand,vehicleModel,selledName#品牌型号"><label>品牌型号</label></li>
	                        <li><input type="checkbox" name="exportCol" value="code#车辆编号"><label>车辆编号</label></li>
	                        <li><input type="checkbox" name="exportCol" value="auctionType#拍卖类型#dictionary#auction_type"><label>拍卖类型</label></li>
	                        <li><input type="checkbox" name="exportCol" value="avType#拍品类型#dictionary#av_type"><label>拍品类型</label></li>
	                        <li><input type="checkbox" name="exportCol" value="status#拍品状态#dictionary#auction_vehicle_status"><label>拍品状态</label></li>
	                        <li><input type="checkbox" name="exportCol" value="recommendText#热门推荐"><label>热门推荐</label></li>
	                        <li><input type="checkbox" name="exportCol" value="city#竞拍区域"><label>竞拍区域</label></li>
	                        <li><input type="checkbox" name="exportCol" value="planStartTime#开始时间"><label>开始时间</label></li>
	                        <li><input type="checkbox" name="exportCol" value="planEndTime#结束时间"><label>结束时间</label></li>
	                        <li><input type="checkbox" name="exportCol" value="startPrice#起拍价(元)"><label>起拍价(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="plusRange#加价幅度(元)"><label>加价幅度(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="reservePrice#保留价(元)"><label>保留价(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="bidderName#竞得人"><label>竞得人</label></li>
	                        <li><input type="checkbox" name="exportCol" value="finalPrice#成交价(元)"><label>成交价(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="proceeds#拍卖增值(元)"><label>拍卖增值(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="maxBidderName#最高出价人"><label>最高出价人</label></li>
	                        <li><input type="checkbox" name="exportCol" value="bidderNum#竞拍人数"><label>竞拍人数</label></li>
	                        <li><input type="checkbox" name="exportCol" value="counts#出价人次"><label>出价人次</label></li>
	                        <li><input type="checkbox" name="exportCol" value="frameScore,level#评估等级"><label>评估等级</label></li>
	                        <li><input type="checkbox" name="exportCol" value="maxPrice#最高出价(元)"><label>最高出价(元)</label></li>
	                        <li><input type="checkbox" name="exportCol" value="vinCode#VIN码"><label>VIN码</label></li>
	                        <li><input type="checkbox" name="exportCol" value="licenseCode#车牌号"><label>车牌号</label></li>
	                        <li><input type="checkbox" name="exportCol" value="registerLicenseYears#首次上牌时间"><label>首次上牌时间</label></li>
	                        <li><input type="checkbox" name="exportCol" value="inGarageTimestamp#入库时间"><label>入库时间</label></li>
	                        <li><input type="checkbox" name="exportCol" value="vehicleAppraiser#评估师"><label>评估师</label></li>
	                        <li><input type="checkbox" name="exportCol" value="evaluationDept#评估部门"><label>评估部门</label></li>
	                    </ul>
	                    <p align="center">
	                        <input type="button" id="exportSelectAll" class="btn_lv4_1" value="全选" />
	                        <input type="button" id="exportNotSelectAll" class="btn_lv4_1 ml10" value="全不选" />
	                        <input id="exportExcel" type="button" class="btn_lv4_1 ml10" style="width:100px;" value="导出EXCEL" />
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
		                    <td width=60>拍卖类型</td>
		                    <td width=60>拍品类型</td>
		                    <td width=60>拍品状态</td>
		                    <td width=60>热门推荐</td>
		                    <td width=60>竞拍区域</td>
		                    <td width=100>开始时间</td>
		                    <td width=100>结束时间</td>
		                    <td width=60>起拍价(万元)</td>
		                    <td width=60>加价幅度(元)</td>
		                    <td width=60>保留价(万元)</td>
		                    <td width=60>竞得人</td>
		                    <td width=60>成交价(万元)</td>
		                    <td width=60>拍品增值(元)</td>
		                    <td width=60>最高出价人</td>
		                    <td width=60>竞拍人数</td>
		                    <td width=60>出价人次</td>
		                    <td width=80>最高出价(万元)</td>
		                    <td width=60>VIN码</td>
		                    <td width=80>车牌号</td>
		                    <td width=100>首次上牌时间</td>
		                    <td width=100>入库时间</td>
		                    <td width=60>评估等级</td>
		                    <td width=60>评估师</td>
		                    <td width=60>评估部门</td>
		                    <td width=60>发拍人</td>
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
		                            <div>
		                            <span>
		                                <p>${item.brand}${item.vehicleModel }${item.selledName }</p>
		                            </span>
		                            </div>
		                        </td>
		                        <td><div class="locklast"><span><p>${item.code}</p></span></div></td>
		                         <td>
		                            <p>
		                                <c:if test="${item.auctionType=='0' }">同步拍</c:if>
		                                <c:if test="${item.auctionType=='1' }">在线拍</c:if>
		                                <c:if test="${item.auctionType=='2' }">即时拍</c:if>
		                            </p>
		                        </td>
		                         <td>
		                            <p>
		                                <c:if test="${item.avType=='0' }">有底价</c:if>
		                                <c:if test="${item.avType=='1' }">无底价</c:if>
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
		                        <td>
		                        	<p>
		                                <c:if test="${item.recommend }">是</c:if>
		                                <c:if test="${!item.recommend }">否</c:if>
		                            </p>
		                        </td>
		                        <td><p>${item.city }</p></td>
		                        <td><p><fmt:formatDate value="${item.planStartTime}" pattern="yyyy-MM-dd HH:mm" /></p></td>
		                        <td><p><fmt:formatDate value="${item.planEndTime}" pattern="yyyy-MM-dd HH:mm" /></p></td>
		                        <td><p>
		                            <fmt:formatNumber maxFractionDigits="2" minFractionDigits="0" value="${item.startPrice/10000 }"></fmt:formatNumber>
		                        </p></td>
		                        <td><p>${item.plusRange}</p></td>
		                        <td><p>
			                        <span>
			                            <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.reservePrice/10000 }"></fmt:formatNumber>
			                        </span>
		                        </p></td>
		                        <td><p>${item.bidderName}</p></td>
		                        <td><p>
		                            <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.finalPrice/10000 }"></fmt:formatNumber>
		                        </p></td>
		                        <td><p>${item.proceeds}</p></td>
		                         <td><p>${item.maxBidderName}</p></td> 
		                         <td>
		                            <p>
		                               <c:choose>
			                               <c:when test="${item.bidderNum !=0}">
<%-- 			                               		${item.bidderNum } --%>
			                                  <a href="javascript:void(0);" onclick="showBidderLog('${item.id}')">${item.bidderNum }</a>
			                               </c:when>
			                               <c:otherwise>0</c:otherwise>
			                           </c:choose>
		                              </p>
		                         </td> 
		                         <td>
		                            <p>
		                            <c:choose>
		                                <c:when test="${item.counts !=0}">
		                                    <a href="javascript:void(0);" onclick="showBidLog('${item.id}')">${item.counts }</a>
<%-- 		                                    ${item.counts } --%>
		                                </c:when>
		                                <c:otherwise>0</c:otherwise>
		                            </c:choose>
		                            </p>
		                        </td> 
		                        <td><p>
		                            <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.maxPrice/10000 }"></fmt:formatNumber>
		                        </p></td>
		                        <td><p>${item.vinCode}</p></td>
		                        <td><p>${item.licenseCode}</p></td>
		                        <td><p>${item.registerLicenseYears}</p></td>
		                        <td><p><fmt:formatDate value="${item.inGarageTimestamp}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
		                        <td><p><fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.frameScore}"></fmt:formatNumber>${item.level}</p></td>
		                        <td><p>${item.vehicleAppraiser}</p></td>
		                        <td><p>${item.evaluationDept}</p></td>
								<td>
									<p><c:if test="${item.creatorId!=null}">
										<spring:eval expression="@userService.selectByPrimaryKey(${item.creatorId})" var="user"/>
										${user.name}
									</c:if></p>
								</td>		                        
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
<script type="text/javascript" src="${ctx}/resources/auction/adv.query.js"></script>
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

$(function(){
	showDatePicker("#startTimestamp1");
	showDatePicker("#endTimestamp1");
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
  
	var av_morechoice=sessionStorage.getItem("auctionreport_morechoice");
    if (av_morechoice=="隐藏选项") {
        $("#morechoice").click();
    }
	sessionStorage.removeItem("auctionreport_morechoice");
	
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
    	//验证发拍人是否存在
    	var isExistName = true;
    	if($.trim($("#creatorName").val()) != ""){
    		$.ajax({
    			url:"${ctx}/bid/isExistName",
    			type:"get",
    			async:false,
    			dataType:"json",
    			data:{creatorName:$("#creatorName").val()
    				},
    			success:function(result){
    					if(!result.success){
    						alert("发拍人不存在！");
    						isExistName = false;
    						return;
    					}else{
    						$("#creatorId").val(result.data);
    					}
    				}	
    		});
    	}else{
    		$("#creatorId").val("");
    	}
    	if(!isExistName){
    		return;
    	}
    	sessionStorage.setItem("auctionreport_morechoice",$("#morechoice").html());
    	$("#auctionVehicleForm").submit();
    });
	
// 	$("#sub001").click(function(){
// 		  var startTimestamp = $("#startTimestamp1").val();
// 	      var endTimestamp = $("#endTimestamp1").val();
// 	      var i = isDate(startTimestamp,endTimestamp);
// 	      if(!i){
// 	          alert("日期格式必须为YYYY-MM-DD");
// 	          return;
// 	      }
// 		 $("#auctionVehicleForm").submit();
// 	});
	
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
	//验证发拍人是否存在
  	var isExistName = true;
	if($.trim($("#creatorName").val()) != ""){
		$.ajax({
			url:"${ctx}/bid/isExistName",
			type:"get",
			async:false,
			dataType:"json",
			data:{creatorName:$("#creatorName").val()
				},
			success:function(result){
					if(!result.success){
						alert("发拍人不存在！");
						isExistName = false;
						return;
					}else{
						$("#creatorId").val(result.data);
					}
				}	
		});
	}else{
		$("#creatorId").val("");
	}
	if(!isExistName){
		return;
	}
      var queryString = $('#auctionVehicleForm').serialize();
      var actionUrl = "${ctx}/report/exportauctionexcel?" + queryString;
       $("#exportForm").attr("action", actionUrl);
       $("#exportForm").submit();
    });
    
    //日期格式校验
    var isDate = function(a,b){
        if(a!=""&&!isDateStr(a)){
            return false;
        }
        if(b!=""&&!isDateStr(b)){
            return false;
        }
        return true;
    };
    
	//分页
	kkpager.generPageHtml({
		pno : '${pagination.current}',
		//总页码
		total : '${pagination.total}',
		pageSize : '${pagination.length}',
		//总数据条数
		totalRecords : '${pagination.count}',
		//链接前部
		hrefFormer : '${ctx}/report/auctionreport',
		//设置每页显示条数
		isShowSelectPageSize : true,
	    mode : 'click', //设置为click模式
        click : function(n){
        	sessionStorage.setItem("auctionreport_morechoice",$("#morechoice").html());
            var queryString = $('#auctionVehicleForm').serialize();
            location.href=this.hrefFormer + this.hrefLatter + "?current=" + n +'&length='+ this.pageSize+ '&' + queryString;
	    },
	    //getHref是在click模式下链接算法，一般不需要配置，默认代码如下
	    getHref : function(n){
	        return '#';
	    }
		/* //链接算法
		getLink : function(n) {
			var queryString = $('#auctionVehicleForm').serialize();
			return this.hrefFormer + this.hrefLatter + "?current=" + n + '&length='+ this.pageSize+ '&' + queryString;
		} */
	});
	var val=$("#type").val();
	
	if (val=="1") {
		$("#av_type").attr("disabled",false);
		$("#li_av_type").show();
	}else{
		$("#av_type").attr("disabled",true);
		$("#li_av_type").hide();
	}
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
//更改拍卖类型后显示拍品拍品类型选项
$("#type").change(function(){
	var val=$("#type").val();
	if (val=="1") {
		$("#avType").attr("disabled",false);
		$("#li_av_type").show();
	}else{
		$("#avType").attr("disabled",true);
		$("#li_av_type").hide();
	}
});  

	//出价记录查询
	var showBidLog = function(id){
		var queryString = $('#auctionVehicleForm').serialize();
		var url  = "${ctx}/report/bid-log"+"?id=" +id + "&" + queryString;
		PopupCenter(url,"【拍卖报表】出价记录查询",1200,600);
	};
	
	//竞拍人最高出价详情查询（2014年12月17日 17:20:38）
	var showBidderLog = function(sid){
		var queryString = $('#auctionVehicleForm').serialize();
		var url  = "${ctx}/report/bidder-log"+"?id=" +sid + "&" + queryString;
		PopupCenter(url,"【拍卖报表】竞拍人最高出价记录详情查询",1200,600);
	};
</script>
</body>
</html>