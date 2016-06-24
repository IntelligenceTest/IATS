<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="others" content="汽车街 _支付结果">
<title>支付结果_汽车街 </title>
<link href="<@baseUrl.static />/common/build/2.00/css/b.css<@baseUrl.time />" rel="stylesheet" type="text/css" />
<link href="<@baseUrl.static />/user/build/1.00/css/uc.css<@baseUrl.time />" rel="stylesheet" type="text/css" />
<style>
.body-1{background:#fff!important}
.order_price p{width:150px}
</style>
</head>

<body class="body-1">
<#include "/include/header1.ftl">
<@layout.nav active = "buy-now" />

<div id="apply">
	<#if payResult == "Y">
		<blockquote class="notice">
			<img src="<@baseUrl.static />/user/build/1.00/images/success.png" width="66" alt=""  class="notice_icon">
        	<h3>订金支付成功!</h3>
        	<p>请在3天内到店签订购车合同并支付余款，我们的工作人员也会尽快联系您。</p>
        	<div class="other">
                                          您还可以：<a href="<@baseUrl.parentHome />/service/finance">申请个人贷款</a>|<a href="<@baseUrl.parentHome />/service/warranty">预定延保服务</a>|<a href="<@baseUrl.parentHome />/service/cosmetology">预约美容服务</a>
        	</div>
    	</blockquote>
	<#elseif payResult == "N">
		<blockquote class="notice">
        	<img src="<@baseUrl.static />/user/build/1.00/images/error.png" width="66" alt="" class="notice_icon">
        	<h3>支付失败!</h3>
        	<p>请联系客服：<img src="<@baseUrl.static />/user/build/1.00/images/phone2.png" width="16" alt="">400-821-8889</p>
    	</blockquote>
	<#else>
		<blockquote class="notice">
        	<img src="<@baseUrl.static />/user/build/1.00/images/important.png" width="66" alt="" class="notice_icon">
        	<h3>交易中，等待您付款!</h3>
        	<p>车辆已锁定，请您在 <span id="divdown1"></span> 内完成订金支付</p>
        	<a href="<@baseUrl.home />/no-haggle/payOrder/${prepayOrder.sid}" class="pay_for">立即支付</a>
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
                <h4>订单内容</h4><p>申请人：${(prepayOrder.bidderName)!}，${(prepayOrder.buyerCellphone)!}</p><p>订单号：${(prepayOrder.orderNo)!}</p><p class="contact">如有疑问可联系：<img src="<@baseUrl.static />/user/build/1.00/images/phone2.png" width="16" alt="">400-821-8889</p>
            </div>
            <img src="<#if prepayOrder.vehicle?? && prepayOrder.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("120X80", "${(prepayOrder.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width:180px; height:110px;" alt="" class="model">
            <blockquote>
                <h3>${(prepayOrder.vehicle.brand)!} ${(prepayOrder.vehicle.vehicleModel)!}<#if prepayOrder.vehicle?? && prepayOrder.vehicle.sweptVolumeStandard?? && prepayOrder.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</h3>
                <p><span>首次上牌：${(prepayOrder.vehicle.registerLicenseYears?substring(0,4))!}-${(prepayOrder.vehicle.registerLicenseYears?substring(4))!}</span> <span>表显里程：${((prepayOrder.vehicle.displayMileage)/10000)?default(0.00)?string("0.00")!}万公里</span></p>
                <p>看车地点：${(fp.addressDetailStore)!}</p>
                <p>服务时间：${(fp.serviceTime)!}</p>
            </blockquote>
            <div class="order_price">
                <p>应付订金： <span>￥${(despositAmt?string("0.00"))!"0.00"}</span></p><p>车辆总价：￥${(fp.price)!}</p>
            </div>
            <div class="clear_fix"></div>
        </div>
    </div>
    <div class="clear_fix"></div>
</div>    


<#include "/include/footer.ftl">

<#-- <script src="<@baseUrl.static />/common/build/1.00/js/jq.layer.js<@baseUrl.time />"></script> -->
<script>
/*倒计时*/
var flag = true;
var endTime = ${(endPayTime)!};  //获取服务器倒计时时间
function showCountDown(){

    var leftSecond = parseInt(endTime-now)/1000;
    var minute = Math.floor(leftSecond/60);
    var second = Math.floor(leftSecond-minute*60);
    if (minute <= 0 && second <= 0) {
        $(".pay_for").hide();
        flag = false;
        
        window.location.reload();
    }
    var div = document.getElementById('divdown1');
    div.innerHTML = '<span class=\"minute\">' + minute +'分</span><span class=\"second\">' + second + '秒</span>';
    
    endTime = endTime - 1000;
}

setInterval(function(){
    if (flag) {
        showCountDown();
    }
},1000);

</script>
</body>
</html>
</#escape>
