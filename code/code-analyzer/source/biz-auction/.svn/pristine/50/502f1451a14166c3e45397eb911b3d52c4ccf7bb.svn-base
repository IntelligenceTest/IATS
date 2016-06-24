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
        <h3 class="tbl-title"><span>拍品顺序设置</span></h3>
         <div class="bi_wrap">
	   			<div class="container_top">
	   			  	<div class="query">
	   			  		<p style="padding-left: 10px;">本次共拍卖${fn:length(auctionVehicleList)}辆车</p>
             		</div>
	           </div>
	     </div>
	      <input type="submit" value="排序" id="sortbtn" class="addbtn query_btn_2" />
	      <div class="container_main">
	        	<div class="wrap">
			        <form id="orderForm" method="post" action="${ctx}/auctionvehicle/itemordersave" accept-charset="utf-8" enctype="application/x-www-form-urlencoded">
			        <table class="datelist-1" id="datelist-1">
			            <thead>
			                <tr>
			                    <td width=45><div><span>序号</span></div></td>
			                    <td width=45><div><span>次序</span></div></td>
			                    <td width=100><div><span>车牌号</span></div></td>
			                    <td width=100><div><span>VIN码</span></div></td>
			                    <td width=100><div><span>品牌型号</span></div></td>
			                    <td width=60>上牌时间</td>
			                    <td width=60>起拍价</td>
			                    <td width=60>保留价</td>
			                    <td width=100>委托方</td>
			                    <td width=60>二手车经理</td>
			                    <td width=60>仓库名称</td>
			                    <td width=60>库区</td>
			                    <td width=40>库位</td>
			                </tr>
			            </thead>
			            <tbody>
			                <c:forEach items="${auctionVehicleList}" var="item" varStatus="status">
			                    <tr>
			                        <td>${status.index + 1}</td>
			                        <td><input name="auctionVehicleOrder" value="${item.auctionVehicleOrder }" style="width:80px" onblur="checkValue(this.value)"/>
			                        	<input value="${item.id }" name="id" type="hidden"></td>
			                        <td>${item.licenseCode}</td>
			                        <td>${item.vinCode}</td>
			                        <td><c:if test="${item.source eq 'av' }"><img src="${ctx}/resources/auction/临时.png" style="vertical-align:middle;"></c:if>${item.brand }${item.brandSeries }${item.vehicleModel }</td>
			                        <td>
			                          <fmt:parseDate var="registerLicenseYears" value="${item.registerLicenseYears}" pattern="yyyyMM"></fmt:parseDate>
                        			  <fmt:formatDate  value="${registerLicenseYears}" pattern="yyyy年MM月"/>
			                        </td>
			                        <td>${item.startPrice}</td>
			                        <td>${item.reservePrice}</td>
			<%--                         <td>${item.client}</td> --%>
			                        <td>委托方</td>
			                        <td></td>
			                        <td>${item.wareHouse}</td>
			                        <td>${item.wareHouseZone}</td>
			                        <td>${item.wareHouseLocation}</td>
			                    </tr>
			                </c:forEach>
			            </tbody>
			           
			          
			        </table>
			         <c:if test="${auctionVehicleList!=null && fn:length(auctionVehicleList) >0}">
				          <p align="center" class="btn-box">
		                     <input type="button" class="button_lv4_1" value="保存" id="submitBtn"/>
		                     <input type="button" class="button_lv4_1" style="margin-left:10px;" value="取消"  id="cancel" />
				         </p>
			           </c:if>
			        </form>
		      </div>
		   </div>
    </div>
   </div>
<script type="text/javascript" src="${ctx}/resources/auction/all.js"></script>   
<script type="text/javascript">
$(function(){
	//取消事件
	 $("#cancel").click(function (){
        window.location.href = "${ctx}/auction/index";
    });
  
	//提交按钮事件
	$("#submitBtn").click(function(){
		//校验次序不能为空，而且必须是数字
		var orderFlag = true;
		$("input[name='auctionVehicleOrder']").each(function(i,element) {
			var data = $(this).val();
		    if(data.length==0){
		    	orderFlag=false;
		    	alert("次序字段不能为空！");
		    	return false;
		    }else if(!IsInteger(data)){
		    	orderFlag=false;
		    	alert("次序字段必须为整数！");
		    	return false;
		    }else if(!checkValue(data)){
		    	orderFlag=false;
		        alert("次序不能大于当前拍品总数量！");
                return false;
		    }
		 });
		//edit by zjz 添加次序重复校验，和最小校验
		var orders = [];
		var avOrders=  $("input[name='auctionVehicleOrder']");
		$(avOrders).each(function(i,e){
			orders.push($(this).val());
		});
		orders.sort();
		if(orders.length>0){
			if(orders[0]<=0){
				orderFlag=false;
		        alert("次序必须大于0");
                return false;
			}
			for(var i = 0;i<orders.length-1;i++){
				if(orders[i]==orders[i+1]){
					orderFlag=false;
			        alert("次序不能重复");
	                return false;
				}
			}
		}
		//add end;
		if(!orderFlag)
			return false;
		//提交表单
		$("#orderForm").submit();
		//调用比较函数,降序
		fSort(compare_down);
		//重新排序行
		setTrIndex(thi);
	});
	//存入点击列的每一个TD的内容；
	var aTdCont = [];
	//点击列的索引值
	//重新对TR进行排序
	var setTrIndex = function(tdIndex){
		for(i=0;i<aTdCont.length;i++){
			var trCont = aTdCont[i];
			$("tbody tr").each(function() {
				var thisText = $(this).children("td:eq("+tdIndex+")").children().val();
				if(thisText == trCont){
					$(this).children("td:eq(0)").html(i+1);
					$("tbody").append($(this));
				}
	     	});		
		}
	};
	//比较函数的参数函数
	var compare_down = function(a,b){
			return a-b;
	};
	var compare_up = function(a,b){
			return b-a;
	};
	//比较函数
	var fSort = function(compare){
		aTdCont.sort(compare);
	};
	//取出TD的值，并存入数组,取出前二个TD值；
	var fSetTdCont = function(thIndex){
			$("tbody tr").each(function() {
				var tdCont = $(this).children("td:eq("+thIndex+")").children().val();
                aTdCont.push(tdCont);
            });
	};
	//点击时需要执行的函数
	var clickFun = function(thindex){
		aTdCont = [];
		//获取点击当前列的索引值
		var nThCount = thindex;
		//调用sortTh函数 取出要比较的数据
		fSetTdCont(nThCount);
	};
	//点击事件绑定函数
	var thi = 1;
	$("#sortbtn").toggle(function(){
		//var thi= 1;
		clickFun(thi);
		//调用比较函数,降序
		fSort(compare_down);
		//重新排序行
		setTrIndex(thi);
	},function(){
		clickFun(thi);
		//调用比较函数 升序
		fSort(compare_up);
		//重新排序行
		setTrIndex(thi);
	});
});
//判断输入是否为数字
var  IsInteger=function(element){
    var str = element.trim();    
    if(str.length!=0){    
    reg=/^[-+]?\d*$/;     
    if(!reg.test(str)){    
        return false;  
    }  
 } 
    return true;
};   
var size ="${fn:length(auctionVehicleList)}";
var checkValue = function(_val){
    if(!IsInteger(_val)){
        orderFlag=false;
        alert("次序字段必须为整数！");
        return false;
    }else if(_val>parseInt(size)){
    	orderFlag=false;
        alert("次序不能大于当前拍品总数量！");
        return false;
    }
    return true;
};

</script>
</body>
</html>