<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="others" content="汽车街 _支付详情">
<title>支付详情_汽车街 </title>
<link href="<@baseUrl.static />/common/build/2.00/css/b.css<@baseUrl.time />" rel="stylesheet" type="text/css" />
<link href="<@baseUrl.static />/user/build/1.00/css/uc.css<@baseUrl.time />" rel="stylesheet" type="text/css" />

</head>

<body class="body-1">
<#include "/include/header1.ftl">
<@layout.nav active = "buy-now" />

<div id="apply">
	<#if prepayOrder.item.status == 0>
		<blockquote class="notice">
        	<img src="<@baseUrl.static />/user/build/1.00/images/important.png" width="66" alt="" class="notice_icon">
        	<h3>交易中，等待您付款!</h3>
    	</blockquote>
	<#elseif prepayOrder.item.status == 5>
		<blockquote class="notice">
	        <img src="<@baseUrl.static />/user/build/1.00/images/important.png" width="66" alt="" class="notice_icon">
	        <h3>支付确认中!</h3>
	    </blockquote>
	<#elseif prepayOrder.item.status == 1 || prepayOrder.item.status == 2 || prepayOrder.item.status == 3>
		<blockquote class="notice">
	        <img src="<@baseUrl.static />/user/build/1.00/images/important.png" width="66" alt="" class="notice_icon">
	        <h3>交易关闭!</h3>
	        <p>原因：<#if prepayOrder.item.status == 1>系统取消<#elseif prepayOrder.item.status == 2>您取消了该订单<#elseif prepayOrder.item.status == 3>超出时间未付款</#if></p>
	    </blockquote>
    <#elseif prepayOrder.item.status == 6 || prepayOrder.item.status == 7>
    	<blockquote class="notice">
	        <img src="<@baseUrl.static />/user/build/1.00/images/important.png" width="66" alt="" class="notice_icon">
	        <h3>交易关闭!</h3>
	        <p>原因：<#if prepayOrder.item.status == 6>您申请了退款，订金已退回<#else>您申请了退款，全款已退回</#if></p>
	    </blockquote>
	<#elseif prepayOrder.item.status == 8 || prepayOrder.item.status == 11 || prepayOrder.item.status == 12 || prepayOrder.item.status == 13>
		<blockquote class="notice">
			<img src="<@baseUrl.static />/user/build/1.00/images/success.png" width="66" alt=""  class="notice_icon">
        	<h3>交易完成，祝您用车愉快!</h3>
        	<div class="other">
                                          您还可以：<a href="<@baseUrl.parentHome />/service/finance">申请个人贷款</a>|<a href="<@baseUrl.parentHome />/service/warranty">预定延保服务</a>|<a href="<@baseUrl.parentHome />/service/cosmetology">预约美容服务</a>
        	</div>
    	</blockquote>
	<#else>
		<blockquote class="notice">
        	<img src="<@baseUrl.static />/user/build/1.00/images/error.png" width="66" alt="" class="notice_icon">
        	<h3>支付失败!</h3>
        	<p>请联系客服：<img src="<@baseUrl.static />/user/build/1.00/images/phone2.png" width="16" alt="">400-821-8889</p>
    	</blockquote>
	</#if>
    
    <div class="clear_fix"></div>

    <div class="apply_exchange">
        <div class="your_car">
        	<#assign tempSelledName = "">
			<#if (prepayOrder.vehicle.selledName)??>
				<#assign tempSelledName = prepayOrder.vehicle.selledName>
			    <#if prepayOrder.vehicle.selledName?starts_with(prepayOrder.vehicle.vehicleModel)>
			    	 <#assign tempSelledName = prepayOrder.vehicle.selledName?replace(prepayOrder.vehicle.vehicleModel, '', 'f')>
			    </#if>
			</#if>
            <div class="order_content">
                <h4>订单内容</h4><p>申请人：${(prepayOrder.bidderName)!}</p><p>订单号：${(prepayOrder.orderNo)!}</p><p class="contact">如有疑问可联系：<img src="<@baseUrl.static />/user/build/1.00/images/phone2.png" width="16" alt="">400-821-8889</p>
            </div>
            <img src="<#if prepayOrder.vehicle?? && prepayOrder.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("120X80", "${(prepayOrder.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width:180px; height:110px;" alt="" class="model">
            <blockquote>
                <h3>${(prepayOrder.vehicle.brand)!} ${(prepayOrder.vehicle.vehicleModel)!}<#if prepayOrder.vehicle?? && prepayOrder.vehicle.sweptVolumeStandard?? && prepayOrder.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</h3>
                <p><span>首次上牌：${(prepayOrder.vehicle.registerLicenseYears?substring(0,4))!}-${(prepayOrder.vehicle.registerLicenseYears?substring(4))!}</span> <span>表显里程：${((prepayOrder.vehicle.displayMileage)/10000)?string("0.00")!}万公里</span></p>
                <p>
	                <span>成交车价：￥${(prepayOrder.item.finalPrice)!}</span> <span>交易佣金：￥${(prepayOrder.item.buyerCommissionFee)!}</span>
	                <span>办证费：￥${(prepayOrder.item.licenseFee)!}</span> <span>出库费：￥${(prepayOrder.item.exWarehouseFee)!}</span>
                </p>
            </blockquote>
            <div class="order_price">
                <p>车辆总价：￥${(prepayOrder.item.finalPrice+prepayOrder.item.buyerCommissionFee+prepayOrder.item.licenseFee+prepayOrder.item.exWarehouseFee)!}</p>
            </div>
            <div class="clear_fix"></div>
        </div>
    </div>
    <div class="clear_fix"></div>
</div>    


<#include "/include/footer.ftl">

</body>
</html>
</#escape>
