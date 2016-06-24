<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="others" content="汽车街_会员中心_我的竞拍_竞得车辆">
<title>竞得车辆_我的竞拍_会员中心_汽车街</title>
<link href="http://img.autostreetscdn.com/user/build/1.00/css/n_uc_common.css" rel="stylesheet" type="text/css" />
<link href="http://img.autostreetscdn.com/user/build/1.00/css/n_uc_info.css" rel="stylesheet" type="text/css" />
<style>
	.nodate{background:url(http://img.autostreetscdn.com/user/build/1.00/images/nocar.jpg) 380px 100px no-repeat;height:400px;padding:120px 0 0 450px;color:#999}
</style>
</head>
<body>
<#include "/include/header2.ftl">
<@layout.nav active = "" />
<div class="uc_body clearfix">
    <div class="uc_main">
        <#include "/member/memberleft_v2.ftl">
        <div class="uc_container">
            <h2>竞得车辆</h2>
			<#if (p.thisPageElements?size==0)> 
		       <div class="nodate">暂无拍到的车辆</div> 
			<#else>
            <div class="fav_menu">
                <ul>
                    <li class="wd450">订单信息</li>
                    <li class="wd80">车牌号</li>
                    <li class="wd90">竞得总价</li>
                    <li class="wd80">状态</li>
                    <li class="wd100 fr">操作</li>
                </ul>
            </div>
            <ul class="fav_list">
            	<#list p.thisPageElements as data>
                <li>
                	<#assign tempSelledName = "">
					<#if (data.vehicle.selledName)??>
						<#assign tempSelledName = data.vehicle.selledName>
				    	<#if data.vehicle.selledName?starts_with(data.vehicle.vehicleModel)>
				    		<#assign tempSelledName = oiItem.vehicle.selledName?replace(data.vehicle.vehicleModel, '', 'f')>
				    	</#if>
					</#if>
                    <div class="favListTitle">
                        <span class="code mr10">下单时间：${(data.dealTimestamp?string("yyyy-MM-dd HH:mm"))!}</span>
                        <span class="code">订单号：${(data.orderNo)!}</span>
                    </div>
                    <div class="favListContent clearfix">
                        <div class="conInfo wd450">
                            <img src="<#if data.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("120X90", "${(data.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width:120px; height:90px;" alt="">
                            <div class="carInfo ">
                                <h3>${(data.vehicle.brand)!} ${(data.vehicle.vehicleModel)!}<#if data.vehicle.sweptVolumeStandard?? && data.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</h3>
                                <p>首次上牌：<#assign registerLicenseYears = (data.vehicle.registerLicenseYears)!""/>
		                            <#if registerLicenseYears??&&registerLicenseYears?length==6>
		                            	${registerLicenseYears[0..3]}-${registerLicenseYears[4..5]}
		                            <#else>
		                            	${registerLicenseYears}
		                            </#if></p>
                                <p>表显里程：${((data.vehicle.displayMileage)/10000)?default(0.00)?string("0.00")!}万公里</p>
                                <p>汽车街一口价：${(data.item.finalPrice?string("0.00"))!"0.00"}元</p>
                            </div>
                        </div>
                        <div class="location wd80"><#if data.vehicle.licenseCode?? && (data.vehicle.licenseCode?length gt 1)>${(data.vehicle.licenseCode?substring(0,2))!}<#else>${(data.vehicle.licenseCode)!}</#if></div>
                        <div class="startPrice wd90">${((data.item.finalPrice+data.item.buyerCommissionFee+data.item.licenseFee+data.item.exWarehouseFee)?string("0.00"))!"0.00"}元</div>
                        <div class="state wd80 <#if !data.item.status?? || data.item.status == 0>orange</#if>"><#if data.item.status??>
		                    		<#if data.item.status == 0>等待支付
		                    		<#elseif data.item.status == 1 || data.item.status == 2 || data.item.status == 3>交易关闭
		                    		<#elseif data.item.status == 4 || data.item.status == 5 || data.item.status == 11>等待提车
		                    		<#elseif data.item.status == 6 || data.item.status == 7>已退全款
		                    		<#elseif data.item.status == 8 || data.item.status == 12 || data.item.status == 13>交易成功
		                    		</#if>
		                    	<#else>
		                    		非法状态
		                    	</#if></div>
                        <div class="operation wd100">
                        	<#if data.item.status??>
	                    		<#if data.item.status == 11 || data.item.status == 12 || data.item.status == 13>
	                    			<a href="javascript:;" class="btn-1 tiche" onclick="querentiche(${data.id})">确认提车</a>
	                    			<br />
	                    		</#if>
	                    	</#if>
                        	<a href="<@baseUrl.home />/member/paydetail/${data.id}" class="checkDetail">查看详情</a>
                        </div>
                    </div>
                </li>
				</#list>
			</ul>
        	<@pagination.pagination />
        	</#if>
        </div>
    </div>
</div>

<div class="uc_tip" id="tiche">
    <a href="javascript:;" class="tipClose" onclick="$.LAYER.close();"></a>
    <h2 class="tipTitle">友情提示</h2>
    <div class="tipContent wd200">
        <h3>确认提车吗？</h3>
        <input type="hidden" id="orderId"/>
        <a href="javascript:;" class="tipConfirm" onclick="tiche()">确认</a>
        <a href="javascript:;" class="tipCancel" onclick="$.LAYER.close();">取消</a>
    </div>
</div>
<!-- <div class="tipBg"></div> -->

<#include "/include/footer.ftl">
<script type="text/javascript">
$(document).ready(function (){
	//左边菜单选中样式
	$("#auctionedVehicle").attr("class", "cur");
});
function querentiche(orderId){
	$("#orderId").val(orderId);
	jQuery.LAYER.show({id:'tiche',overlay:{opacity:0.5}});
}

function tiche(){
	var orderId=$("#orderId").val();
	$.ajax({
		url:"<@baseUrl.home />/member/tiche",
		data:{orderId:orderId},
		success:function(r){
			if(r&&r.success){
				location.reload();
			}
		}
	})
}
</script>
</body>
</html>
</#escape>
