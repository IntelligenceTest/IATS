<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="others" content="汽车街_竞拍大厅_在线拍_批量出价">
<title>批量出价_在线拍_竞拍大厅_汽车街</title>

<link href="<@baseUrl.static />/sell/build/1.00/css/batch.css<@baseUrl.time />" rel="stylesheet">
</head>

<body class="body1">
<#include "/include/header1.ftl">

<div class="position">
  <a class="positionmain" href="<@baseUrl.parentHome />/">首页</a> &gt; <a href="<@baseUrl.home />"><span>竞拍大厅</span></a> &gt; <a href="<@baseUrl.home />/onlineauction/index"><span>在线拍</span></a> &gt; <span>批量出价</span>
</div>
<div class="wp minh600">
    <h3 class="pagetitle">批量出价</h3>
    <table class="batch-tbl" id='batch-tbl'>
        <thead>
            <tr>
                <th>商品信息</th>
                <th>车牌号</th>
                <th>距结束</th>
                <th width="120">当前价</th>
                <th width="120">我的出价</th>
                <th>加价幅度</th>
                <th class="txt-c" width="350">操作</th>
            </tr>
        </thead>
        <tbody>
        	<#list memberVehicles as oneVehicle>
				<#assign tempSelledName = "">
				<#if (oneVehicle.vehicle.selledName)??>
					<#assign tempSelledName = oneVehicle.vehicle.selledName>
					<#if oneVehicle.vehicle.selledName?starts_with(oneVehicle.vehicle.vehicleModel)>
				 		<#assign tempSelledName = oneVehicle.vehicle.selledName?replace(oneVehicle.vehicle.vehicleModel, '', 'f')>
					</#if>
				</#if>
        		<input name="tim2end_${(oneVehicle.id)!}" id="tim2end_${(oneVehicle.id)!}" value="${(oneVehicle.timeIntervalEnd)!}" type="hidden">
        		<input name="av_sid_${(oneVehicle.id)!}" id="av_sid_${(oneVehicle.id)!}" value="${oneVehicle.avId}" type="hidden">
        		<input name="startPrice_${(oneVehicle.id)!}" id="startPrice_${(oneVehicle.id)!}" value="${oneVehicle.auctionVehicle.startPrice}" type="hidden">
        		<input name="maxBidPrice_${(oneVehicle.id)!}" id="maxBidPrice_${(oneVehicle.id)!}" value="${oneVehicle.auctionVehicle.maxBidPrice}" type="hidden">
        		<input name="avStatus_${(oneVehicle.id)!}" id="avStatus_${(oneVehicle.id)!}" value="${oneVehicle.auctionVehicle.status}" type="hidden">
        		<input name="sid" value="${(oneVehicle.id)!}" type="hidden">
        		
        		<tr id="row_${(oneVehicle.id)!}" <#if oneVehicle.auctionVehicle.status != 5>class="dis"</#if>>
        			<td><a target="_blank" class="title" href="<@baseUrl.home />/onlineauction/${oneVehicle.avId}">
        			  
        			  ${(oneVehicle.vehicle.brand)!} ${(oneVehicle.vehicle.vehicleModel)!} <#if oneVehicle.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> 
        			  ${(tempSelledName)!}</a></td>
					<td><#if oneVehicle.vehicle.licenseCode?? && (oneVehicle.vehicle.licenseCode?length gt 1)>${(oneVehicle.vehicle.licenseCode?substring(0,2))!}<#else>${(oneVehicle.vehicle.licenseCode)!}</#if></td>
					<td>
						<span class="timer" id="timeDisp_${(oneVehicle.id)!}">
							<#if oneVehicle.auctionVehicle.status == 5 || oneVehicle.auctionVehicle.status == 3 || oneVehicle.auctionVehicle.status == 4>已结束</#if>
							<#if oneVehicle.auctionVehicle.status == 1>尚未开始</#if>
							<#if oneVehicle.auctionVehicle.status == 6>暂停</#if>
						</span>
					</td>
                	<td>
                		<span class="money" id="currPrice_${(oneVehicle.id)!}">
                			<strong>${action.getMaxBidPriceByAV(oneVehicle.avId)}</strong> 元
                		</span>
                	</td>
                	<td>
                		<span class="money-1" id="myBid_${(oneVehicle.id)!}">
                			<strong>${action.getMaxBidPriceByAVandUser(oneVehicle.avId, userIdentity.id)}</strong> 元
                			<#if oneVehicle.auctionVehicle.status == 5>
                				<#if (action.getMaxBidPriceByAVandUser(oneVehicle.avId, userIdentity.id) > 0) && (action.getMaxBidPriceByAV(oneVehicle.avId) > action.getMaxBidPriceByAVandUser(oneVehicle.avId, userIdentity.id))>
                					<ins class="ins-1">出价被超</ins>
                				<#elseif (action.getMaxBidPriceByAV(oneVehicle.avId) > 0) && (action.getMaxBidPriceByAV(oneVehicle.avId) <= action.getMaxBidPriceByAVandUser(oneVehicle.avId, userIdentity.id))>
                					<ins class="ins-2">当前最高</ins>
                				</#if>
                			</#if>
                	 	</span>
                	</td>
                	<td><span id="range_${(oneVehicle.id)!}">${oneVehicle.auctionVehicle.plusRange}</span><span>元</span></td>
                	<td>
	                    <div class="pricebox">
	                        <a href="javascript:;" class="btn-del" id="btn-del_${(oneVehicle.id)!}"></a>
	                        <input type="text" readonly class="priceinput" id="myPrice_${(oneVehicle.id)!}" value="${action.getBidPrice(oneVehicle.avId)}"/>
	                        <a href="javascript:;" class="btn-add" id="btn-add_${(oneVehicle.id)!}"></a>
	                        
	                        <#if oneVehicle.auctionVehicle.status == 2>
	                        	<#if action.checkBidedByVehicleAndUser('${userIdentity.id}','${oneVehicle.vehicle.id}') == 1>
	                        		<span class="state-3">竞得</span>
	                        	<#else>
	                        		<span class="state-1">未竞得</span>
	                        	</#if>
	                        <#elseif oneVehicle.auctionVehicle.status == 3>
	                        	<span class="state-2">成交确认</span>
	                        <#elseif oneVehicle.auctionVehicle.status == 4>
	                        	<span class="state-2">流拍</span>
	                        <#elseif oneVehicle.auctionVehicle.status == 6>
	                        	<span class="state-2">暂停</span>
	                        <#elseif oneVehicle.auctionVehicle.status == 5>
	                        	<a href="javascript:;" class="btn-price" id="btn-price_${(oneVehicle.id)!}"></a>
	                        <#else>
	                        	<a href="javascript:;" class="btn-price-dis"></a>
	                        </#if>
	                        <a href="javascript:;" class="closeline" id="closeline_${(oneVehicle.id)!}"></a>
	                    </div>
                	</td>
        		</tr>
        	</#list>
        </tbody>
    </table>
</div>


<#include "/include/footer.ftl">

<script language="javascript" src="<@baseUrl.static />/common/build/1.00/js/lib/jquery-1.8.3.min.js"></script>
<script language="javascript" src="<@baseUrl.static />/sell/build/1.00/js/batch.js<@baseUrl.time />"></script>

<script>
// 隐藏在线客服
$(function() {
	//HideCustomerService();
});

function fmoney(s, n)
{  
   m = n > 0 && n <= 20 ? n : 2;
   s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(m) + "";  
   var l = s.split(".")[0].split("").reverse(),  
   r = s.split(".")[1];  
   t = "";  
   for(var i = 0; i < l.length; i++ )
   {  
      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");  
   }
   var str;
   if (n > 0) {
	   str = t.split("").reverse().join("") + "." + r.substring(0,2);
   } else {
	   str = t.split("").reverse().join("");
   }
   return str;
}

function getHtml(timeInt) {
	var LeftDays = Math.floor(timeInt/(1000*60*60*24));
	var LeftHours = Math.floor(timeInt/(1000*60*60)%24);
	var LeftMinutes = Math.floor(timeInt/(1000*60)%60);
	var LeftSeconds = Math.floor(timeInt/1000%60);

	var strHtml = [];
	
	if (LeftDays > 0) {
		LeftHours = LeftHours + 24 * LeftDays;		
	}
	
	if (LeftHours < 10) {
		strHtml.push("0");
	}
	strHtml.push(LeftHours);
	strHtml.push(":");
	
	if (LeftMinutes < 10) {
		strHtml.push("0");
	}
	strHtml.push(LeftMinutes);
	strHtml.push(":");
	
	if (LeftSeconds < 10) {
		strHtml.push("0");
	}
	strHtml.push(LeftSeconds);
	//strHtml = "" + LeftHours + ":" + LeftMinutes + ":" + LeftSeconds;
	return strHtml.join("");
}

/**
 * 定时刷新  剩余时间值 
 */
var timepiece = function (sid) {
	var str = "";
	var timeVal = $("#tim2end_" + sid).val();
	
	if (timeVal <= 0) {
		$("#timeDisp_" + sid).html("已结束");
		$("#btn-price_" + sid).hide();		
	} else {
		str = getHtml(timeVal);
		timeVal = timeVal - 1000;
		
		$("#tim2end_" + sid).val(timeVal.toString());
		$("#timeDisp_" + sid).html(str);
		$("#btn-price_" + sid).show();
	}

	$.ajax({
		url :"/online-batchbid/endtime",
		type: "post",
		data : { avSid: $("#av_sid_" + sid).val() }
	}).done(function(data) {
		if(data.success) {
			//console.log(JSON.stringify(data))
			$("#tim2end_" + sid).val(data.times);
		}else if(data.redirectUrl){
			window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/online-batchbid/list");
		}
	});
};

/**
 * 定时刷新  当前最大拍卖价 
 */
var timeMaxPrice = function (sid) {
	var avSid = $("#av_sid_" + sid).val();
	
	$.ajax({
		url :"/online-batchbid/maxprice",
		type: "post",
		data : {
			avId: avSid
		}		
	}).done(function(data) {
		if(data.success) {
			var myPrice = $("#myPrice_" + sid).val();

			$("#currPrice_" + sid).html("<strong>" + fmoney(parseInt(data.maxPrice), 0) + "</strong> 元");
			if (parseInt(myPrice) < parseInt(data.bidPrice)) {
				$("#myPrice_" + sid).val(parseInt(data.bidPrice));
			}
							
			if (parseInt(data.myMaxPrice) > 0) {
				if (parseInt(data.maxPrice) > parseInt(data.myMaxPrice)) {
					$("#myBid_" + sid).html("<strong>" + fmoney(parseInt(data.myMaxPrice), 0) + "</strong> 元 <ins class='ins-1'>出价被超</ins>");
				} else {
					if (parseInt(data.maxPrice) > 0) {
						$("#myBid_" + sid).html("<strong>" + fmoney(parseInt(data.myMaxPrice), 0) + "</strong> 元 <ins class='ins-2'>当前最高</ins>");
					}
				}
			}
			
			$("#maxBidPrice_" + sid).val(data.maxPrice);
		}else if(data.redirectUrl){
			window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/online-batchbid/list");
		}
	});
};

$("input[name='sid']").each(function(i,element) {
	//var avId = $(this).val();
	var sid = $(this).val();
	var avStatus = $("#avStatus_" + sid).val();
	
	if (avStatus == "5") {
		setInterval(function(){
			timepiece(sid);
		}, 1000);
		
		setInterval(function(){
			timeMaxPrice(sid);
		}, 1000);
	}

	$("#btn-del_"+sid).click(function() {
		subPrice(sid);
	});
	
	$("#btn-add_"+sid).click(function() {
		addPrice(sid);
	});
		
	if (avStatus == "5") {
		$("#btn-price_"+sid).click(function() {
			addBid(sid);
		});
	}
		
	$("#closeline_"+sid).click(function() {
		delRow(sid);
	});
	
});


function subPrice(sid) {
	var newPrice;
	var priceStep = $("#range_" + sid).html();	
	var minPrice = $("#startPrice_" + sid).val();
	
	var oldPrice = $("#myPrice_" + sid).val();
	var currPrice = $("#maxBidPrice_" + sid).val();

	if (minPrice == "") minPrice = 0;
	if (currPrice == "") currPrice = 0;
	if (oldPrice == "") oldPrice = 0;
	
	if (oldPrice == 0) {
		if (currPrice == 0) {
			newPrice = parseInt(minPrice);
		} else {
			newPrice = parseInt(currPrice) + parseInt(priceStep);
		}
	} else {
		newPrice = parseInt(oldPrice) - parseInt(priceStep);
	}
	
	if (currPrice == 0) {
		if (newPrice < minPrice) {
			newPrice = parseInt(minPrice);
		}
	} else {
		if (parseInt(currPrice) == parseInt(minPrice)) {
			newPrice = parseInt(minPrice);
		} else {
			if (newPrice <= currPrice) {
				newPrice = parseInt(currPrice) + parseInt(priceStep);
			}
		}
	}
	
	$("#myPrice_" + sid).val(newPrice);
}

function addPrice(sid) {
	var newPrice;
	var priceStep = $("#range_" + sid).html();
	
	var minPrice = $("#startPrice_" + sid).val();	
	var currPrice = $("#maxBidPrice_" + sid).val();
	var oldPrice = $("#myPrice_" + sid).val();
	
	if (minPrice == "") minPrice = 0;
	if (currPrice == "") currPrice = 0;
	if (oldPrice == "") oldPrice = 0;
	
	if (oldPrice == 0) {
		if (currPrice == 0) {
			newPrice = parseInt(minPrice);
		} else {
			newPrice = parseInt(currPrice) + parseInt(priceStep);
		}
	} else {
		newPrice = parseInt(oldPrice) + parseInt(priceStep);
	}
	
	$("#myPrice_" + sid).val(newPrice);
}

function addBid(sid) {
	var avSid = $("#av_sid_" + sid).val();
	$.ajax({
		url :"/online-batchbid/addbid",
		type: "post",
		data : {
			sid: sid,
			avId: avSid,
	        price: $("#myPrice_" + sid).val()
		},
		success : function(data) {
			if(data.success) {
				var priceStep = $("#range_" + sid).html();

				$("#tim2end_" + sid).val(data.times);
				
				$("#currPrice_" + sid).html("<strong>" + fmoney(parseInt(data.price), 0) + "</strong> 元");
				$("#myPrice_" + sid).val(parseInt(data.price) + parseInt(priceStep));
				
				var maxPrice = $("#maxBidPrice_" + sid).val();
				if (maxPrice > data.price) {
					$("#myBid_" + sid).html("<strong>" + fmoney(parseInt(data.price),0) + "</strong> 元 <ins class='ins-1'>出价被超</ins>");
				} else {
					$("#myBid_" + sid).html("<strong>" + fmoney(parseInt(data.price),0) + "</strong> 元 <ins class='ins-2'>当前最高</ins>");
				}
			}else if(data.redirectUrl){
				window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/online-batchbid/list");
			}
		}
	});
}

function delRow(sid) {
	$.ajax({
		url :"/online-batchbid/delRecord",
		type: "post",
		data : {
			sid: sid
		},
		success : function(data) {
			if(data.success) {
				$("#row_" + sid).hide();
			}else if(data.redirectUrl){
				window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/online-batchbid/list");
			}
		}
	});
}

</script>
</body>
</html>
</#escape>
