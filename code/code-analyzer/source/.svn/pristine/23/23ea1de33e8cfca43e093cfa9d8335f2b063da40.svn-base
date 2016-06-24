<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<meta name="others" content="汽车街_竞拍大厅">
    <title>竞拍大厅_汽车街</title>
    <link href="http://img.autostreetscdn.com/common/build/2.00/css/b.css" rel="stylesheet" type="text/css" />
    <link href="http://img.autostreetscdn.com/sell/build/1.00/css/auction.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="http://img.autostreetscdn.com/sell/build/1.00/css/auction_index.css"/>
</head>
<body class="w950">
<#include "/include/header2.ftl">
<@layout.nav active = "sync-auction"/>
<div id="auction_house">
    <div class="hd">
        <div class="auction_article">
           <div class="inner">
               <div class="auction_list">
                   <h2>竞拍场次</h2>
                   <ul>
                      <#list auctionNumbers as new>
                       <li><a href="<@baseUrl.parentHome />/news/jingpaidetails?id=${(new.id)!}&type=${(new.type)!}">${(new.title)!}</a></li>
                      </#list>
                   </ul>
                   <a href="<@baseUrl.parentHome />/news/jingpai?type=1" class="more">更多</a>
               </div>
               <div class="qa">
                   <h2>常见问题</h2>
                   <ul>
                     <#list auctionProblems as new>
                       <li><a href="<@baseUrl.parentHome />/news/jingpaidetails?id=${(new.id)!}&type=${(new.type)!}">${(new.title)!}</a></li>
                     </#list>
                   </ul>
                   <a href="<@baseUrl.parentHome />/news/jingpai?type=2" class="more">更多</a>
               </div>
           </div>
        </div>
        <div class="auction_banner">
            <div class="slide">
                <div class="slide_pic">
                    <ul>
                		<#if advList??&&advList?size gt 0>
                			<#list advList as adv>
	                		 	<li>
	                       		 	<#if adv.clickUrl??&&adv.clickUrl != ''>
			                        	<a href="${adv.clickUrl}" onclick="_hmt.push(['_trackEvent', '竞拍大厅banner', 'click', '${adv.name}']);_traceEvent('竞拍大厅banner', '点击', '${adv.name}','10','false');" target="_blank"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('670*310','${(adv.adDesign)!}')!}"/></a>
			                     	<#else>
			                     		<a href="javascript:;"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('670*310','${(adv.adDesign)!}')!}"/></a>
			                    	</#if>
	                        	</li>
                        	</#list>
			  		    </#if>
                    </ul>
                </div>
                <div class="slide_txt">
                    <ul>
                    	<#if advList??&&advList?size gt 0>
                			<#list advList as adv>
	                		 	<li>${adv.name}</li>
                        	</#list>
			  		    </#if>
                    </ul>
                </div>
                <div class="slide_num">
                    <ul></ul>
                </div>
                <a href="javascript:void(0)" class="slide_btn prev_btn"></a>
                <a href="javascript:void(0)" class="slide_btn next_btn"></a>
            </div>
        </div>
    </div>
    <a href="<@baseUrl.home />/center" class="au_banner"><img src="http://img.autostreetscdn.com/sell/build/1.00/images/au_center.png" alt=""/></a>
    <div class="sync_auction">
        <h2 class="au_h2">同步拍</h2>
        <a href="<@baseUrl.home />/syncauction/list" class="view_more">查看更多</a>
        <ul>
        	<#list auctions as auction>
        		<li>
        			<#assign tempPicUrl = "">
        			<#if (auction.picUrl)?? && auction.picUrl != ''>
        				<#assign tempPicUrl=action.getThumbImgUrl("520*270",auction.picUrl)>
        			<#elseif (auction.placeId)??>
        				<#assign tempPicUrl = action.getThumbImgUrl("520*270",action.getAuctionPicUrl(auction.placeId))/>
        			</#if>
	                <img class="shop_img " src="<@baseUrl.image />/${(tempPicUrl)!}" alt="" />
	                <div class="auction_detail">
	                    <div class="au_tit">
	                        <i class="au_idx">第${(auction.auctionNum)!}场</i>
	                        <h3>${(auction.title)!}</h3>
	                    </div>
	                    <div class="au_desc">
	                    	<#if (auction.auctionModelDesc)??&&auction.auctionModelDesc!="">
		                        <dl>
		                            <dt>主要品牌：</dt>
		                            <dd>${(auction.auctionModelDesc)!}</dd>
		                        </dl>
	                    	</#if>
	                        <dl>
	                            <dt>参拍数量：</dt>
	                            <dd>${(auction.vehicleQuantity)!}台</dd>
	                        </dl>
	                        <dl>
	                            <dt>开始时间：</dt>
	                            <dd>${(auction.startTimestamp?string("yyyy年MM月dd日 HH:mm"))!}</dd>
	                        </dl>
	                        <dl>
	                            <dt>竞拍地址：</dt>
                            	<dd><#if (auction.placeId)??>${(action.getAuctionAddress((auction.placeId)!))!}</#if></dd>
	                        </dl>
	                    </div>
	                    <#if (auction.status)?? && auction.status == 1 >
	                      <a href="<@baseUrl.home />/syncauction/detail/${(auction.id)!}" class="au_btn au_will"><span class="au_icon">等待竞拍</span><i class="inside_btn">查看详情</i></a>
	                    <#elseif (auction.status)?? && auction.status == 2 >
	                      <a href="<@baseUrl.home />/syncauction/detail/${(auction.id)!}" class="au_btn au_ing"><span class="au_icon">竞拍中</span><i class="inside_btn white_btn">查看详情</i></a>
	                    <#else>
	                      <a href="<@baseUrl.home />/syncauction/detail/${(auction.id)!}" class="au_btn au_end"><span class="au_icon">已结束</span><i class="inside_btn white_btn">查看详情</i></a>
	                    </#if>
	                </div>
	            </li>
        	</#list>
        </ul>
    </div>
    <a class="au_banner" href="<@baseUrl.home />/eqs"><img src="http://img.autostreetscdn.com/sell/build/1.00/images/au_usedCar.png" alt=""/></a>
    <div class="online_auction">
        <h2 class="au_h2">在线拍</h2>
        <a href="<@baseUrl.home />/onlineauction/index" class="view_more">查看更多</a>
        <ul>
        	<#if (auctionVehicleList?size==0)>
	        	<li>
	                <img src="http://img.autostreetscdn.com/sell/build/1.00/images/no_data.png" alt="" class="no_data">
	            </li>
        	</#if>
        	<#list auctionVehicleList as auctionVehicle>
				<#assign tempSelledName = "">
				<#if (auctionVehicle.selledName)??>
					<#assign tempSelledName = auctionVehicle.selledName>
					<#if auctionVehicle.selledName?starts_with(auctionVehicle.vehicleModel)>
						<#assign tempSelledName = auctionVehicle.selledName?replace(auctionVehicle.vehicleModel, '', 'f')>
					</#if>
				</#if>
        		<li>
	                <a href="<@baseUrl.home />/onlineauction/${auctionVehicle.id}" class="img" target="_blank"><img style="width: 120px; height: 90px;" class="lazy_img" original="<#if auctionVehicle.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("120X90", "${(auctionVehicle.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" alt=""/></a>
	                <div class="car_info">
	                    <h3><a target="_blank" href="<@baseUrl.home />/onlineauction/${auctionVehicle.id}">${(auctionVehicle.vehicle.brand)!} ${(auctionVehicle.vehicle.vehicleModel)!}<#if auctionVehicle.vehicle.sweptVolumeStandard?? && auctionVehicle.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</a></h3>
	                    <p><span>${(auctionVehicle.city)!}</span>|<span><#if auctionVehicle.vehicle.licenseCode?? && (auctionVehicle.vehicle.licenseCode?length gt 1)>${(auctionVehicle.vehicle.licenseCode?substring(0,2))!}<#else>${(auctionVehicle.vehicle.licenseCode)!}</#if></span>|<span>${(auctionVehicle.vehicle.registerLicenseYears?substring(0,4))!}年${(auctionVehicle.vehicle.registerLicenseYears?substring(4))!}月</span>
	                    <#if (auctionVehicle.vehicle.displayMileage)??>
		                    |<span>${((auctionVehicle.vehicle.displayMileage)/10000)?string("0.00")!}万公里</span>
	                    </#if>
	                    </p>
	                    <div class="opt">
		                    <#if (favoriteVehicleIds?size > 0)>
		  	                	<#if favoriteVehicleIds?seq_contains(auctionVehicle.id)>
			                      	<a href="javascript:;" class="addgz" id="a3-${auctionVehicle.id}" style="display: none;">收藏</a>
			                      	<a href="javascript:;" class="addgz-on" id="a1-${auctionVehicle.id}">取消收藏</a>
		                    	<#else>
			                      	<a href="javascript:;" class="addgz" id="a3-${auctionVehicle.id}">收藏</a>
			                      	<a href="javascript:;" style="display: none;" class="addgz-on" id="a1-${auctionVehicle.id}">取消收藏</a>
		                    	</#if>
		                    <#else>
		                    	<a href="javascript:;" class="addgz" id="a3-${auctionVehicle.id}">收藏</a>
		                      	<a href="javascript:;" style="display: none;" class="addgz-on" id="a1-${auctionVehicle.id}">取消收藏</a>
		                    </#if>
	                    </div>
	                </div>
	                <div class="rz">
		                <#if auctionVehicle.certified?? && auctionVehicle.certified>
	                    	<p title="该车经过了200项严酷检测，车辆骨架无损伤，车况为A级。" class="eqs">EQS认证</p>
		                </#if>
		                <#if auctionVehicle.guaranteed?? && auctionVehicle.guaranteed>
		                	<p title="该车通过了EQS检测认证且符合购买车辆延保服务的条件。" class="yb">延保服务</p>
		                </#if>
	                </div>
	                <div class="status">
	                    <p class="status_txt">
	                    	<#if auctionVehicle.status??>
	                    		<#if auctionVehicle.status == 1>
	                    			<span class="color-2">等待竞拍</span>
	                    		<#elseif auctionVehicle.status == 5>
	                    			<span class="color-1">竞拍中</span>
	                    		<#else>
	                    			<span class="color-3">已结束</span>
	                    		</#if>
	                    	</#if>
	                    </p>
	                    <p class="status_time">结束时间：${(auctionVehicle.planEndTime?string("MM.dd HH:mm"))!}</p>
	                </div>
	                <div class="col-9">
	                	<#if priceDisp == "1" || isSp>
	                		<span class="money"><strong>
		                	<#if auctionVehicle.maxBidPrice &gt; 0>
		                		${((auctionVehicle.maxBidPrice / 10000)?string("0.00"))!"0.00"}
		                	<#else>
		                		${((auctionVehicle.startPrice / 10000)?string("0.00"))!"0.00"}
	                		</#if>
	                		</strong>万元</span>
	                	<#else>
	                		<span class="color-1">价格隐藏</span>
	                		<p>仅认证商户可见</p>
	                	</#if>
	                </div>
	            </li>
        	</#list>
        </ul>
    </div>
    <div class="au_guarantee">
        <h2 class="au_h2">汽车街二手车服务保障</h2>
        <dl class="dl_01">
            <dt><img class="lazy_img" original="http://img.autostreetscdn.com/sell/build/1.00/images/au_bz01.png" alt=""/></dt>
            <dd>车辆来源有保障</dd>
        </dl>
        <dl class="dl_02">
            <dt><img class="lazy_img" original="http://img.autostreetscdn.com/sell/build/1.00/images/au_bz02.png" alt=""/></dt>
            <dd>现场&网络三端同步参与</dd>
        </dl>
        <dl class="dl_03">
            <dt><img class="lazy_img" original="http://img.autostreetscdn.com/sell/build/1.00/images/au_bz03.png" alt=""/></dt>
            <dd>足不出户一站式购车</dd>
        </dl>
    </div>
</div>
<div class="q_a">
    <div class="inner">
        <h2 class="au_h2">客服答疑</h2>
        <ul class="qa_list">
           <!-- <li>
                <h3><span>Q：</span>商户如何加盟汽车街参与竞拍？</h3>
                <div><span>A：</span><p>在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金</p></div>
            </li>
            <li>
                <h3><span>Q：</span>商户如何加盟汽车街参与竞拍？</h3>
                <div><span>A：</span><p>在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金</p></div>
            </li>
            <li>
                <h3><span>Q：</span>商户如何加盟汽车街参与竞拍？</h3>
                <div><span>A：</span><p>在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金在线注册会员并缴纳保证金</p></div>
            </li>-->
        </ul>
    </div>
</div>
<#include "/include/footer.ftl">
<script language="javascript" src="http://img.autostreetscdn.com/common/build/2.00/js/jquery.MinmyLazyload.js"></script>
<script src="http://img.autostreetscdn.com/fed/build/1.00/js/slide.js"></script>
<script src="http://img.autostreetscdn.com/sell/build/1.00/js/auction_index.js"></script>
<script>
$(".addgz").click(function () {
    var avId = this.id.substring(3);
    $.ajax({
        url: "<@baseUrl.home />/member/favorite/add",
        type: "post",
        data: {
            avId: avId
        }
    }).done(function (data) {
        if (data.success) {
            $("#a1-" + avId).show();
            $("#a3-" + avId).hide();
        } else{
            window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
        }
    });
});

$(".addgz-on").click(function () {
    var avId = this.id.substring(3);
    $.ajax({
        url: "<@baseUrl.home />/member/favorite/remove",
        type: "post",
        data: {
            avId: avId
        }
    }).done(function (data) {
        if (data.success) {
            $("#a1-" + avId).hide();
            $("#a3-" + avId).show();
        } else if (data.redirectUrl) {
            window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
        }
    });
});
</script>
</body>
</html>
</#escape>
