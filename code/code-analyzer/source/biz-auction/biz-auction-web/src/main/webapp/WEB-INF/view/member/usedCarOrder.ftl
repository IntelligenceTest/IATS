<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="others" content="汽车街_会员中心_二手车订单">
<title>二手车订单_会员中心_汽车街</title>

<link href="http://img.autostreetscdn.com/user/build/1.00/css/n_uc_common.css" rel="stylesheet" type="text/css" />
<link href="http://img.autostreetscdn.com/user/build/1.00/css/uc-newcarorder.css" rel="stylesheet" type="text/css" />
</head>
<body>
<#include "/include/header2.ftl">
<@layout.nav active = "" />

<div class="uc_body">
    <div class="uc_main clear">
		<#include "/member/memberleft_v2.ftl">
        <div class="uc_container">
            <h2>二手车订单</h2>
            <div class="uc-container-menu">
                <ul class="clear">
                    <li class="uc-li-1">订单信息</li>
                    <li class="uc-li-2">申请人</li>
                    <li class="uc-li-3">金额</li>
                    <li class="uc-li-4">状态</li>
                    <li class="uc-li-5 special-li-1">操作</li>
                </ul>
            </div>
            <div class="uc-container-content">
            	<#list p.thisPageElements as oiItem>
                <div class="content-section">
                    <div class="section-title">
                        <span>下单时间：${(oiItem.createdTime?string("yyyy-MM-dd HH:mm"))!}</span>
                        <span>订单号：${(oiItem.orderNo)!}</span>
                    </div>
                    <#assign tempSelledName = "">
					<#if (oiItem.vehicle.selledName)??>
						<#assign tempSelledName = oiItem.vehicle.selledName>
				    	<#if oiItem.vehicle.selledName?starts_with(oiItem.vehicle.vehicleModel)>
				    		<#assign tempSelledName = oiItem.vehicle.selledName?replace(oiItem.vehicle.vehicleModel, '', 'f')>
				    	</#if>
					</#if>
                    <ul class="clear">
                        <li class="uc-li-1">
                            <div class="li-left">
                                <img src="<#if oiItem.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("120X90", "${(oiItem.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width:120px; height:90px;" alt="">
                            </div>
                            <div class="li-right">
                                ${(oiItem.vehicle.brand)!} ${(oiItem.vehicle.vehicleModel)!}<#if oiItem.vehicle.sweptVolumeStandard?? && oiItem.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}
                                <p>首次上牌： <#assign registerLicenseYears = (oiItem.vehicle.registerLicenseYears)!""/>
	                            <#if registerLicenseYears??&&registerLicenseYears?length==6>
	                            	${registerLicenseYears[0..3]}-${registerLicenseYears[4..5]}
	                            <#else>
	                            	${registerLicenseYears}
	                            </#if></p>
                                <p>表显里程：${((oiItem.vehicle.displayMileage)/10000)?default(0.00)?string("0.00")!}万公里</p>
                                <p>汽车街一口价：${((oiItem.item.finalPrice / 10000)?string("0.00"))!"0.00"}万元</p>
                            </div>
                        </li>
                        <li class="uc-li-2 center-li">
                            <span>${(oiItem.bidderName)!}</span>
                            <span class="special-tel">${(oiItem.buyerCellphone)!}</span>
                        </li>
                        <li class="uc-li-3 center-li">
                            <span>${(oiItem.item.prePrice?string("0.00"))!"0.00"}元</span>
                        </li>
                        <li class="uc-li-4 center-li">
                            <span class="<#if !oiItem.item.status?? || oiItem.item.status != 0>orderState-1<#else>orderState-2</#if>"><#if oiItem.item.status??>
	                    		<#if oiItem.item.status == 0>等待支付<#elseif oiItem.item.status == 1 || oiItem.item.status == 2 || oiItem.item.status == 3>交易关闭
	                    		<#elseif oiItem.item.status == 4 || oiItem.item.status == 5 || oiItem.item.status == 9>已付订金
	                    		<#elseif oiItem.item.status == 6>已退订金<#elseif oiItem.item.status == 7>已退订金<#elseif oiItem.item.status == 8>交易成功</#if>
	                    	<#else>
	                    		非法状态
	                    	</#if></span>
                        </li>
                        <li class="uc-li-5 special-li-2">
                        	<#if oiItem.item.status??>
	                    		<#if oiItem.item.status == 0>
	                    			<a href="<@baseUrl.home />/no-haggle/netpay?orderId=${oiItem.id}" class="btn-1">支付订金</a>
	                    			<a href="javascript:;" class="btn-2 order_cancel" id="c_${oiItem.id}">取消订单</a>
	                    		<#elseif oiItem.item.status == 4 || oiItem.item.status == 5 || oiItem.item.status == 9>
	                    			<a href="javascript:;" class="btn-2 refund">退款说明</a>
	                    		</#if>
	                    	</#if>
	                    	<a href="<@baseUrl.home />/no-haggle/paydetail/${oiItem.id}" class="btn-3">查看详情</a>
                        </li>
                    </ul>
                </div>
				</#list>
             </div>
             <@pagination.pagination />
        </div>
    </div>
</div>

<div class="uc_tip" id="refund">
    <a href="javascript:;" class="tipClose" onclick="$.LAYER.close();"></a>
    <h2 class="tipTitle">友情提示</h2>
    <div class="tipContent wd300">
    	<p>1、订金支付后3天未到店签订《二手车销售合同》并支付车辆余款，您可以拨打汽车街客服电话400-821-8889要求退订金。</p>
		<p>2、订金支付后3天内有线下客户直接以全款购买的方式在门店购买此车，汽车街将主动联系您确认退款事宜。</p>
		<p>3、汽车街将在与您确认退款信息后的10个工作日内完成退款，通过您支付订金的路径原路退回到您的银行账户。</p>
		<p>4、你的退款申请操作暂时仅支持拨打400电话申请，门店申请退款恕无法受理。汽车街400客服工作时间：周一到周日，8:30-17:00。</p>
        <a href="javascript:;" class="tipConfirm mrCenter" onclick="$.LAYER.close();">关闭</a>
    </div>
</div>




<div class="uc_tip" id="cancel">
	<a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
	<h2 class="tipTitle">友情提示</h2>
    <input value="" id="oi_sid" type="hidden" />
    <div class="tipContent wd200">
        <h3>您确认取消此订单吗？</h3>
        <a href="javascript:;" class="tipConfirm" id="can_confirm">确认</a>
        <a href="javascript:;" class="tipCancel" onclick="$.LAYER.close();">取消</a>
    </div>
</div>

<#include "/include/footer.ftl">

<script language="javascript" src="<@baseUrl.static />/common/build/1.00/js/jq.layer.js"></script>

<script type="text/javascript">
$(function(){
    $(".refund").click(function(){
        jQuery.LAYER.show({id:'refund',overlay:{opacity:0.5}});
    })
    $(".order_cancel").click(function(){
        var oSid = this.id.substring(2);
        $("#oi_sid").val(oSid);
        
        jQuery.LAYER.show({id:'cancel',overlay:{opacity:0.5}});
    })

	$("#can_confirm").click(function() {
		var oSid = $("#oi_sid").val();
		$.ajax({
	      url: "<@baseUrl.home />/no-haggle/cancel_order",
	      type: "post",
	      data: {
	        orderId: oSid
	      }
	    }).done(function(data) {
	      if (data.success) {
	        window.location.reload();
	      }
	    });
	});
	
})

$(document).ready(function (){
	//左边菜单选中样式
	$("#usedCar").attr("class", "cur");
});
</script>
</body>
</html>
</#escape>
