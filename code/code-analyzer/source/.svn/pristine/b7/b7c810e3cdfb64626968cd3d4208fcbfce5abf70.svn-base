<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="others" content="汽车街_会员中心_我的竞拍_出价车辆">
<title>出价车辆_我的竞拍_会员中心_汽车街</title>
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
            <h2>出价的车辆</h2>
			<#if (p.thisPageElements?size==0)> 
				<div class="nodate">暂无出价的车辆</div> 
			<#else>
            <div class="fav_menu">
                <ul>
                    <li class="wd520">订单信息</li>
                    <li class="wd80">车牌号</li>
                    <li class="wd90">我的出价</li>
                    <li class="wd100 fr">拍卖状态</li>
                </ul>
            </div>
            <ul class="fav_list">
            	<#list p.thisPageElements as data>
                <li>
                    <div class="favListTitle">
                       <!-- <span class="code mr10">下单时间：2014-01-01 18:00</span>-->
                        <span class="code">拍品编号：${(data.avNo)! }</span>
                    </div>
                    <div class="favListContent clearfix">
                        <div class="conInfo wd520">
                            <#if data.source?? && data.source== 'av'>
		                     <img src="<@baseUrl.static />/common/build/1.00/images/noimg.png" style="width: 120px; height: 90px;"/>
		                   <#else>
		                     <#if data.auctionType?? && data.auctionType == '0' ><a href="<@baseUrl.home />/auction/${(data.auctionId)! }/vehicle/${(data.id)! }" target="_blank"></#if>
		                    <#if data.auctionType?? && data.auctionType == '1' ><a href="<@baseUrl.home />/onlineauction/${(data.avId)! }" target="_blank"></#if>
		                    <#if data.auctionType?? && data.auctionType == '2' ><a href="<@baseUrl.home />/onceBidAuction/${(data.avId)! }" target="_blank"></#if>
		                    	<img src="<@baseUrl.image />/${(action.getThumbImgUrl("120X90", "${(data.photoUrl)!}"))!}" style="width: 120px; height: 90px;"></a>
		                   </#if> 
                            <div class="carInfo wd330">
                                <h3><#if (data.source == "av")><img src="http://img.autostreetscdn.com/sell/build/1.00/images/sample.png" alt="" title="该车暂缺照片和检测报告，请以现场实车为准"></#if>${(data.brand)! }&nbsp;${(data.brandSeries)!}&nbsp; ${(data.vehicleModel)!}</h3>
                                <p>颜色：${(data.bodyColor)! }</p>
                                <p>首次上牌： <#assign registerLicenseYears = (data.registerLicenseYears)!""/>
	                            <#if registerLicenseYears??&&registerLicenseYears?length==6>
	                            	${registerLicenseYears[0..3]}-${registerLicenseYears[4..5]}
	                            <#else>
	                            	${registerLicenseYears}
	                            </#if></p>
                                <p>表显里程：<#if data.displayMileage??>
	                    	  ${(((data.displayMileage)!0)/10000)?string("0.00")}万公里
	                   		</#if>
	                   		</p>
                            </div>
                        </div>
                        <div class="location wd80"><#if data.licenseCode?? && (data.licenseCode?length gt 1)>${(data.licenseCode?substring(0,2))!}<#else>${(data.licenseCode)!}</#if></div>
                        <div class="startPrice wd90">${(data.price)?string("0.####")}元</div>
                        <div class="operation wd100">
                            <#if data.status??>
		                    	<#if data.status == 1>未开始 
		                    	<#elseif data.status == 2>成交
	                    		<#elseif data.status == 3 && data.finalBidStatus == 1>
		                    	  <p class="orange">商家议价<br />${(data.finalBidPrice)!}元</p>
		                    	  <a href="javascript:void(0);" class="btn-1 qryj" onclick="zjprice(${(data.avId)!})">确认议价</a>
	                        	<#elseif data.status == 4><p>流拍</p>
	                        	<#elseif data.status == 3 && data.finalBidStatus != 1><p>流拍确认</p>
	                    	 	<#elseif data.status == 5><p>拍卖中</p>
	                    	 	<#elseif data.status == 6><p>暂停</p>
	                    	 	<#elseif data.status == 7><p>已下架</p>
	                            </#if>
	                      	</#if>
	                      	
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

<div class="uc_tip" id="zhuijia">
    <a href="javascript:;" class="tipClose" onclick="$.LAYER.close();"></a>
    <h2 class="tipTitle">议价确认</h2>
    <div class="tipContent wd220">
        <p>商家发起议价，您当前还有1次议价机会</p>
        <h3>您的出价 <span id="currentPrice"></span>元<input type="hidden" id="avId"></h3>
        <h4>商家出价 <span class="sjyj"  id="zjinput"></span></h4>
        <a href="javascript:;" class="tipConfirm accept" onclick="zjyijia()">接受议价</a>
        <a href="javascript:$.LAYER.close();" class="tipCancel">取消</a>
    </div>
</div>

<div class="uc_tip" id="zhuijia2">
    <a href="javascript:;" class="tipClose" onclick="$.LAYER.close();"></a>
    <h2 class="tipTitle">友情提示</h2>
    <div class="tipContent wd300">
        <img src="http://img.autostreetscdn.com/user/build/1.00/images/lay-success.png" alt="">
        <div class="lay-success">
            <h3>提交成功，您已接受议价</h3>
            <span class="new_price">新的出价，<span id="newBidPrice"><span>元</span>
            <a href="<@baseUrl.home />/member/biddedvehicle" class="tipConfirm">确定</a>
        </div>
    </div>
</div>
<!-- <div class="tipBg"></div> -->
<script>
$(function(){
    $('.discuss').on('click',function(){
        $('#discuss_price').show()
    })
    $('.accept').on('click',function(){
        $('#discuss_price').hide()
        $('#accept_price').show()
    })
})
</script>


<#include "/include/footer.ftl">
<script type="text/javascript">
    $(function(){
        $('.qryj').click(function(){
            jQuery.LAYER.show({ id: 'zhuijia', overlay: { opacity: 0.5} });
        })
    })
    
function zjprice(avId){
	$.ajax({
		url:"<@baseUrl.home />/member/getmaxbidprice",
		data:{avId:avId},
		async:false,
		success:function(data){
			if(data.data){
				$("#currentPrice").text(data.data.maxBidPrice);
				$(".sjyj").html(data.data.finalBidPrice);
				$("#avId").val(avId);
				jQuery.LAYER.show({ id: 'zhuijia', overlay: { opacity: 0.5} });
			}
		}
	})
}
function zjyijia(){
	var price=$('#zjinput').text();
    	$.ajax({
    		url:"<@baseUrl.home />/member/addbid",
    		async:false,
    		data:{avId:$("#avId").val()},
    		success:function(data){
    			if(data&&data.success){
        			$('#zjErr').css('visibility','hidden');
		            $.LAYER.close();
		            $("#newBidPrice").html(price);
		            jQuery.LAYER.show({ id: 'zhuijia2', overlay: { opacity: 0.5} });
    			}
    		}
    	})
}

$(document).ready(function (){
	//左边菜单选中样式
	$("#biddedVehicle").attr("class", "cur");
});
</script>
</body>
</html>
</#escape>
