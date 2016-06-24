<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="others" content="汽车街_会员中心_我的收藏">
<title>我的收藏_会员中心_汽车街</title>

<link href="http://img.autostreetscdn.com/user/build/1.00/css/n_uc_common.css" rel="stylesheet" type="text/css" />
<link href="http://img.autostreetscdn.com/user/build/1.00/css/n_uc_info.css" rel="stylesheet" type="text/css" />
<style>
	.no-result{width: 400px;margin: 0 auto;height: 120px;}
	.no-result img{float: left;margin: 20px 0 0;}
	.no-result p{float: left;color: #999;margin: 50px 0 0;font-size: 14px;}
	.no-result p a{color: #3479ca}
</style>
</head>
<body>
<#include "/include/header2.ftl">
<@layout.nav active = "" />

<div class="uc_body clearfix">
    <div class="uc_main">
       	<#include "/member/memberleft_v2.ftl">
        <div class="uc_container">
            <h2>我的收藏</h2>

            <ul class="classify">
                <li <#if type=="0"> class="cur"</#if>><a href="<@baseUrl.parentHome />/member/favorites?type=0">新车 ${(newcarFavCount)!}</a></li>
                <li <#if type=="1"> class="cur"</#if>><a href="<@baseUrl.auctHome />/member/favorites?type=1">二手车 ${(noHaggleFavCount)!}</a></li>
                <li <#if type=="2"> class="cur"</#if>><a href="<@baseUrl.auctHome />/member/favorites?type=2">竞拍车辆 ${(avFavCount)!}</a></li>
            </ul>
            <#if type=="1">
            <#if noHaggleCount == 0>
    		<div class="no-result">
                <img src="<@baseUrl.static />/user/build/1.00/images/order.png" width="67" height="67" alt="">
                <p>您目前没有收藏该类车辆</p>
            </div>
        	<#else>
            <div class="fav_menu">
                <ul>
                    <li class="wd450">车辆信息</li>
                    <li class="wd80">所在地</li>
                    <li class="wd90">价格</li>
                    <li class="wd80">状态</li>
                    <li class="wd100 fr">操作</li>
                </ul>
            </div>
            <ul class="fav_list">
            	<#list p.thisPageElements as e>
            	<#assign  vehicle=action.getVehicleInfoRefId("${(e.vehicleId)!}") >
                <li>
                    <div class="favListTitle">
                        <p class="startTime">车辆编号：${(vehicle.code)!}</p>
                    </div>
                    <div class="favListContent clearfix">
                        <div class="conInfo wd450">
                             <a href="<@baseUrl.home />/no-haggle/${(vehicle.id)!}" target="_blank">
								<img src="<#if (vehicle.firstPhotoUrl)??><@baseUrl.image />/${(action.getThumbImgUrl("120X90", "${(vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" width="120" height="90" alt="" />
							</a>
                            <div class="carInfo ">
                                <h3>${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(vehicle.selledName)!}</h3>
                                <p>首次上牌：
                                <#assign registerLicenseYears = (vehicle.registerLicenseYears)!""/>
	                            <#if registerLicenseYears??&&registerLicenseYears?length==6>
	                            	${registerLicenseYears[0..3]}年${registerLicenseYears[4..5]}月
	                            <#else>
	                            	${registerLicenseYears}
	                            </#if></p>
                                 <p>表显里程：${((vehicle.displayMileage)/10000)?default(0.00)?string("0.00")!}万公里</p>
                                <p><#--排放标准：${(vehicle.sweptVolumeStandard)!}--></p>
                            </div>
                        </div>
                        <div class="location wd80">${e.city}</div>
                        <div class="startPrice wd90">${((e.price / 10000)?string("0.00"))!"0.00"}万元</div>
                        <div class="state wd80 <#if e.status == 3>orange</#if>"><#if e.status == 1>已下架<#elseif e.status == 2>已出售<#elseif e.status == 3>正在出售<#elseif e.status == 4 || e.status == 5 || e.status == 6>已预订</#if></div>
                        <div class="operation wd100"><a href="javascript:;" class="cancelFav order_cancel" id="can_${e.id}">取消收藏</a></div>
                    </div>
                </li>
				</#list>
                <@pagination.pagination />
             </ul>
            </#if>
            </#if>
            
            
            <#if type=="2">
            <#if avFavCount == 0>
    		<div class="no-result">
                <img src="<@baseUrl.static />/user/build/1.00/images/order.png" width="67" height="67" alt="">
                <p>您目前没有收藏该类车辆</p>
            </div>
        	<#else>
            <div class="fav_menu">
                <ul>
                    <li class="wd450">车辆信息</li>
                    <li class="wd80">所在地</li>
                    <li class="wd90">起拍价</li>
                    <li class="wd80">状态</li>
                    <li class="wd100 fr">操作</li>
                </ul>
            </div>
            <ul class="fav_list">
            	<#list p.thisPageElements as e>
                <li>
                    <div class="favListTitle">
                    	<p><#if (e.auctionVehicle.auctionType)?? && e.auctionVehicle.auctionType == 0>同步拍<#elseif (e.auctionVehicle.auctionType)?? && e.auctionVehicle.auctionType == 1>在线拍<#elseif (e.auctionVehicle.auctionType)?? && e.auctionVehicle.auctionType == 2>24小时拍</#if></p>
                        <p class="startTime">开拍时间：${(e.auctionVehicle.planStartTime?string('yyyy.MM.dd HH:mm'))!}</p>
                        <span class="code fr">车辆编号：${(e.vehicle.code)!}</span>
                    </div>
                    <div class="favListContent clearfix">
                        <div class="conInfo wd450">
                             <#if (e.auctionVehicle.auctionType)?? && e.auctionVehicle.auctionType == 0><a href="<@baseUrl.home />/auction/${(e.auctionVehicle.auctionId)!}/vehicle/${(e.vehicle.id)!}" target="_blank"></#if>
		                    	<#if (e.auctionVehicle.auctionType)?? && e.auctionVehicle.auctionType == 1><a href="<@baseUrl.home />/onlineauction/${(e.auctionVehicle.id)!}" target="_blank"></#if>
		                    	<#if (e.auctionVehicle.auctionType)?? && e.auctionVehicle.auctionType == 2><a href="<@baseUrl.home />/onceBidAuction/${(e.auctionVehicle.id)!}" target="_blank"></#if>
								<img src="<#if e.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("120X90", "${(e.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" width="120" height="90" alt="" />
								</a>
                            <div class="carInfo ">
                                <h3>${(e.vehicle.brand)! }&nbsp;${(e.vehicle.brandSeries)!}&nbsp;${(e.vehicle.vehicleModel)!}</h3>
                                <p>首次上牌：
                                ${(e.vehicle.firstPhoto)!}：
                                <#assign registerLicenseYears = (e.vehicle.registerLicenseYears)!""/>
	                            <#if registerLicenseYears??&&registerLicenseYears?length==6>
	                            	${registerLicenseYears[0..3]}-${registerLicenseYears[4..5]}
	                            <#else>
	                            	${registerLicenseYears}
	                            </#if>
	                            </p>
                                 <p>表显里程：${((e.vehicle.displayMileage)/10000)?default(0.00)?string("0.00")!}万公里</p>
                                <p><#--排放标准：${(e.vehicle.sweptVolumeStandard)!}--></p>
                            </div>
                        </div>
                        <div class="location wd80">${(e.auctionVehicle.city)!}</div>
                        <div class="startPrice wd90">
                        	<#if (e.auctionVehicle.auctionType)??&&(e.auctionVehicle.auctionType) != 2>
                       		 	<#if priceDisp == "1">${((e.auctionVehicle.startPrice / 10000)?string("0.00"))!"0.00"}万元<#else>认证商户可见</#if>
                       		 	<#else>
                       		 	&nbsp;&nbsp;
                       		 </#if>
                        </div>
                        <div class="state wd80 <#if e.auctionVehicle.status == 5>orange</#if>">
                        	<#if e.auctionVehicle.status == 1>未开始 <#elseif e.auctionVehicle.status == 2>成交<#elseif e.auctionVehicle.status == 3>成交确认<#elseif e.auctionVehicle.status == 4>流拍
	                    	<#elseif e.auctionVehicle.status == 5>拍卖中<#elseif e.auctionVehicle.status == 6>暂停<#elseif e.auctionVehicle.status == 7>已下架</#if>
	                    	</div>
                        <div class="operation wd100"><a href="javascript:;" class="cancelFav order_cancel" id="can_${e.id}">取消收藏</a></div>
                    </div>
                </li>
				</#list>
                <@pagination.pagination />
             </ul>
            </#if>
            </#if>
        </div>
    </div>
</div>

<div class="uc_tip" id="cancel">
    <a href="javascript:;" class="tipClose" onclick="$.LAYER.close();"></a>
    <h2 class="tipTitle">友情提示</h2>
    <input type="hidden" id="favID" name="favID"/>
    <div class="tipContent wd200">
        <h3>确认取消收藏吗？</h3>
        <a href="javascript:;" class="tipConfirm">确认</a>
        <a href="javascript:;" class="tipCancel" onclick="$.LAYER.close();">取消</a>
    </div>
</div>
<!-- <div class="tipBg"></div> -->

<script language="javascript" src="http://img.autostreetscdn.com/user/build/1.00/js/common.js"></script>

<#include "/include/footer.ftl">

<script type="text/javascript">
$(function(){

    $(".order_cancel").click(function(){
    	var id = this.id.substring(4);
    	$("#favID").val(id);
        jQuery.LAYER.show({id:'cancel',overlay:{opacity:0.5}});
    })
    
    $(".tipConfirm").click(function(){
    	cancelFavorite();
    })
    
    
    $("#new_car").show();
	$("#old_car").show();
	$("#auction_car").show();
})


//取消收藏
function cancelFavorite() {
	var type = '${type}';
	if (type == "2") {
		$.ajax({
			url :"<@baseUrl.home />/member/deleteById",
			type: "post",
			data : {
				fId: $("#favID").val()
			},
			success : function(data) {
				if(data == '0'){
					window.location.href = "<@baseUrl.home />/member/favorites?type=${type}";   //刷新当前页面
				}else if(data.redirectUrl){
					window.location.href="https://login.autostreets.com/login?service="+encodeURIComponent(window.location.href);
				}
			}
		});
	} else {
		$.ajax({
	      url: "<@baseUrl.home />/member/favorite/cancel",
	      type: "post",
	      data: {
	        id: $("#favID").val()
	      }
	    }).done(function(data) {
	      if (data.success) {
	        window.location.href = "<@baseUrl.home />/member/favorites?type=${type}";
	        ////window.location.reload();
	      } else {
	      	window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
	      }
	    });
	}
	
	
}


$(document).ready(function (){
	//左边菜单选中样式
	$("#myFavorites").attr("class", "cur");
});
</script>
</body>
</html>
</#escape>
