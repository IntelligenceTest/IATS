<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="others" content="汽车街_二手车展厅_在线预定_${(vehicle.brand)!}${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(vehicle.selledName)!}">
<title>${(vehicle.brand)!}${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(vehicle.selledName)!}_在线预定_二手车展厅_汽车街</title>
<link href="<@baseUrl.static />/common/build/1.00/css/b.css" rel="stylesheet" type="text/css" />
<link href="<@baseUrl.static />/sell/build/1.00/css/main.css" rel="stylesheet" type="text/css" />
</head>
<style>
.detail-map p{width:260px;height:18px;overflow:hidden}
.orderinfo .car img{width:200px;height:150px}
</style>
<body>
<#include "/include/header1.ftl">
<#assign tempSelledName = "">
<#if (vehicle.selledName)??>
	<#assign tempSelledName = vehicle.selledName>
	<#if vehicle.selledName?starts_with(vehicle.vehicleModel)>
		 <#assign tempSelledName = vehicle.selledName?replace(vehicle.vehicleModel, '', 'f')>
	</#if>
</#if>
<div class="position">
    <a class="positionmain" href="<@baseUrl.home />/">首页</a> &gt; <a href="<@baseUrl.home />/no-haggle">二手车展厅</a> &gt; ${(vehicle.brand)!}${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!} &gt; <span>在线预订</span>
</div>
<form action="<@baseUrl.home />/no-haggle/saveNoHaggleOrder" method="get"  id="order">
<div class="ordermain">
    <h2>在线预订</h2>
    <br />
    <div class="orderinfo clearfix">
        <div class="car"><img src="<#if vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("200X150", "${(vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" ></div>
        <h3>${(vehicle.brand)!}${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!} <#if (fixedPrice.hidden)??&&!fixedPrice.hidden><span class="price">汽车街一口价：${((fixedPrice.price) / 10000)?string("#.##")!}万元</span></#if></h3>
        <ul class="carinfo">
            <li><label>首次上牌：</label>${(vehicle.registerLicenseYears?substring(0,4))!}-${(vehicle.registerLicenseYears?substring(4))!}</li>
            <li><label>表显里程：</label>${((vehicle.displayMileage)/10000)?default(0.00)?string("0.##")!}万公里</li>
            <li><label>所在门店：</label>${(fixedPrice.whereStore)!}--${(fixedPrice.addressDetailStore)!}</li>
            <li><label>服务时间</label>${(fixedPrice.serviceTime)!}</li>
        </ul>
    </div>
    <div class="otherbox">
    <h3 class="othertitle">您的信息</h3>
    <ul class="clearfix">
        <li>
            <label class="disblock">姓名</label>
            <input type="text" name="customerName" maxlength="45" class="input-1 name" value="<#if member??>${(member.name)!}</#if>">
                <input type="radio" class="radio-1" name="sex"  value="男" checked="checked">
                <label class="radiolabel">男</label> 
                <input type="radio" class="radio-1" name="sex"  value="女">
                <label class="radiolabel">女</label>
            <div class="error_txt"></div>
        </li>
        <li>
            <label class="disblock">手机</label>
            <input type="text" name="cellPhone" class="input-1 mobile" value="<#if member??>${(member.cellphone)!}</#if>">
            <div class="error_txt"></div>
        </li>
    </ul>
    </div>
    
    <div class="payinfo">
        <h3 class="othertitle">应付定金</h3>
        <p class="moeny">￥ ${(prePrice)!}<span>订金可全额退款</span> </p>
        <input type="hidden" name="depositAmt" value="${(prePrice)!}">
        <input type="hidden" name="productId" value="${(fixedPrice.id)}">
        <input type="hidden" name="username" value="13761261497">
        <input type="checkbox" name="" class="again">
        <div class="protocol">
            <p>我已详细阅读并同意</p>
            <a href="javascript:;" class="refund">《订金支付协议》</a>
            <p class="error_txt"></p>
        </div>
        <div class="">
            <a href="javascript:;" class="paybtn"></a><span class="tel">400-821-8889</span>
        </div>
    </div>
</div>
</form>
<div class="UED_hide" id="refund">
    <div class="tip-offset refund_notice">
        <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
        <div class="tip-refuse-box2">
            <h3>订金支付协议</h3>
            <div class="notice_content">
                <h4>订金协议</h4>
                <ul>
                    <li>1、支付订金请详细阅读本须知，确认无误后完成订金支付。</li>
                    <li>2、订金金额${(prePrice)!}元人民币/台。</li>
                    <li>3、支付订金前，汽车街已向您展示了该车的当前全部情况。</li>
                    <li>4、支付订金后，汽车街在没有线下客户全款购车的前提下为您保留车辆3天。超过3天未到店签订合同并支付车辆余款，汽车街将认为您单方面拒绝购买，您的订金将在与您确认退款信息后的10个工作日内返还给您支付订金时候的银行账户。</li>
                    <li>5、到店签订《二手车销售合同》前，请与销售顾问确定车辆状况，如车辆状况与网上支付订金时有差异，订金将按照《退款说明》的规定全额退还，但汽车街不会因此而承担任何违约责任。</li>
                    <li>6、支付订金后3天内如有线下客户直接到店以全款支付的方式购买该车辆，汽车街将优先考虑全款支付的线下客户，您对此表示理解并确认不以此追究汽车街的任何违约责任。如该车线下全款销售成功，汽车街将全额退还您的订金，并且为您推荐类似的车型并且在购车后赠送相应的汽车服务套餐。套餐内容以各门店定义为准。</li>
                </ul>
            </div>
            <a href="javascript:;" class="correct" onclick="$.LAYER.close();">关闭</a>
            <div class="clearfix"></div>
        </div>
    </div>
</div>


<#include "/include/footer.ftl">

<script src="<@baseUrl.static />/common/build/1.00/js/lib/jquery-1.8.3.min.js"></script>
<script src="<@baseUrl.static />/common/build/1.00/js/jq.layer.js"></script>
<script src="<@baseUrl.static />/sell/build/1.00/js/batch.js"></script>
<script>
$(function(){                
    $(".refund").click(function(){
        jQuery.LAYER.show({id:'refund',overlay:{opacity:0.5}});
    })

    $(".paybtn").click(function(){
        isName($(".name").val())
        isPhone($(".mobile").val())
        isProtocol()
        if(isName($(".name").val()) && isPhone($(".mobile").val()) && isProtocol()){
	       // if ("${(userIdentity.username)!}" == "") {
	       // 	window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/no-haggle/nohaggle-order/${(fixedPrice.sid)!}");
	       //  	return false;
	       // }
            $("#order").submit();
        } else {
            return false;
        }
    })   
});

</script>

</body>
</html>
</#escape>
