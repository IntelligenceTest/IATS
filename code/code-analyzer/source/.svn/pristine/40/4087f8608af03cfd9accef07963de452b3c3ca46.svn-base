<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="others" content="汽车街_同步拍_${(auction.title)!}">
<title>${(auction.title)!}_同步拍_汽车街</title>
<link href="http://img.autostreetscdn.com/common/build/2.00/css/b.css" rel="stylesheet" type="text/css" />
<link href="http://img.autostreetscdn.com/sell/build/1.00/css/list.css" rel="stylesheet" type="text/css" />
</head>

<body class="sell_bg w950">
<#include "/include/header2.ftl">
<@layout.nav active = "sync-auction"/>
<div class="position w950">
  <a class="positionmain" href="<@baseUrl.parentHome />/">首页</a> &gt; <a href="<@baseUrl.home />"><span>竞拍大厅</span></a> &gt; <span>${(auction.title)!}</span>
</div>
<div class="pm">
	<div class="auction_banner">
        <div class="slide">
            <div class="slide_pic">
                <ul>
                	<#if (auction.banner1Url)??&&auction.banner1Url!=''>
                		<li><a href="javascript:void(0);"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('610*280','${(auction.banner1Url)!}')!}" alt=""/></a></li>
                	</#if>
                	<#if (auction.banner2Url)??&&auction.banner2Url!=''>
                		<li><a href="javascript:void(0);"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('610*280','${(auction.banner2Url)!}')!}" alt=""/></a></li>
                	</#if>
                	<#if (auction.banner3Url)??&&auction.banner3Url!=''>
                		<li><a href="javascript:void(0);"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('610*280','${(auction.banner3Url)!}')!}" alt=""/></a></li>
                	</#if>
                	<#if (!((auction.banner1Url)??)||!(auction.banner1Url!=''))&&(!((auction.banner2Url)??)||!(auction.banner2Url!=''))&&(!((auction.banner3Url)??)||!(auction.banner3Url!=''))>
                		<#if (auctionPlace.banner1Url)??&&(auctionPlace.banner1Url)!=''>
                			<li><a href="javascript:void(0);"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('610*280','${(auctionPlace.banner1Url)!}')!}" alt=""/></a></li>
                		</#if>
                		<#if (auctionPlace.banner2Url)??&&(auctionPlace.banner2Url)!=''>
                			<li><a href="javascript:void(0);"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('610*280','${(auctionPlace.banner2Url)!}')!}" alt=""/></a></li>
                		</#if>
                		<#if (auctionPlace.banner3Url)??&&(auctionPlace.banner3Url)!=''>
                			<li><a href="javascript:void(0);"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('610*280','${(auctionPlace.banner3Url)!}')!}" alt=""/></a></li>
                		</#if>
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
	<div class="pm_info">
		<h2 title="${(auction.title)!}"><ins>${(auction.title)!}</ins><span>第${(auction.auctionNum)!}场</span></h2>
		<p><label>参拍数量：</label><span>${(auction.vehicleQuantity)!}台</span></p>
		<p><label>竞拍时间：</label><span>${(auction.startTimestamp?string('MM月dd日 HH:mm'))!} - ${(auction.endTimestamp?string('MM月dd日 HH:mm'))!}</span></p>
		<p><label>竞拍地址：</label><span><#if (auction.placeId)??>${(action.getAuctionAddress((auction.placeId)!))!}</#if></span></p>
		<#if userVip == "1" && auction.status == 2>
      		<a href="javascript:;" id="auctionlive">进入直播室</a>
      	<#else>
      		<a href="javascript:;" class="close">进入直播室</a>
      		<p class="notice"><span>仅认证商户可见，<a href="<@baseUrl.parentHome />/dealerapply/auctionindex" class="apply">申请成为认证商户&gt;&gt;</a></span></p>   <!-- 未认证提示语 -->
      	</#if>
      	
		
	</div>
</div>
<div class="listbody">
    <img src="http://img.autostreetscdn.com/sell/build/1.00/images/process_bg2.png" alt="" class="process_title">
    <ul class="tab">
        <li><a>拍品列表</a></li>
    </ul>
    <div class="listbodybox">
        <div class="selecetlist">
        <dl>
            <dt>价格</dt>
            <dd>
                <ul>
                    <li><a href="${action.getUrl("price,pageNumber", "0,1")}"<#if !price?? || price == 0> class="on"</#if>>不限</a></li>
                    <#list action.paramList(1) as param>
                    <li><a href="${action.getUrl("price,pageNumber", "${param.key},1")}"<#if price?? && price?string == param.key> class="on"</#if>>${param.value}</a></li>
                    </#list>
                </ul>
            </dd>
        </dl>
        <dl>
            <dt>车龄</dt>
            <dd>
                <ul>
                    <li><a href="${action.getUrl("age,pageNumber", "0,1")}"<#if !age?? || age == 0> class="on"</#if>>不限</a></li>
                    <#list action.paramList(2) as param>
                    <li><a href="${action.getUrl("age,pageNumber", "${param.key},1")}"<#if age?? && age?string == param.key> class="on"</#if>>${param.value}</a></li>
                    </#list>
                </ul>
            </dd>
        </dl>
        <dl>
            <dt>里程</dt>
            <dd>
                <ul>
                    <li><a href="${action.getUrl("mileage,pageNumber", "0,1")}"<#if !mileage?? || mileage == 0> class="on"</#if>>不限</a></li>
                    <#list action.paramList(3) as param>
                    <li><a href="${action.getUrl("mileage,pageNumber", "${param.key},1")}"<#if mileage?? && mileage?string == param.key> class="on"</#if>>${param.value}</a></li>
                    </#list>
                </ul>
            </dd>
        </dl>
        </div>
    </div>

    <div>
            <ul class="clearfix listthead">
                <li class="col-1_5">拍品编号</li>
                <li class="col-6">保障</li>
                <li class="col-3">地区</li>
                <li class="col-6">车牌号</li>
                <li class="col-6">首次上牌</li>
                <li class="col-6">表显里程</li>
            </ul>
          <#list p.thisPageElements as e>
            <#assign tempSelledName = "">
			<#if (e.vehicle.selledName)??>
	          	<#assign tempSelledName = e.vehicle.selledName>
				<#if e.vehicle.selledName?starts_with(e.vehicle.vehicleModel)>
				  <#assign tempSelledName = e.vehicle.selledName?replace(e.vehicle.vehicleModel, '', 'f')>
				</#if>
		    </#if>
            <ul class="clearfix listtbody">
                <li class="col-1_5">
                    <div class="listimg">
                        <span>${(e.auctionVehicleOrder?string("000"))!}</span>
                        <#if (!e.vehicle.source?? || (e.vehicle.source != "av"))><a target="_blank" href="<@baseUrl.home />/auction/${id}/vehicle/${e.vehicleId}"></#if><img src="<#if e.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("120X90", "${(e.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width: 120px; height: 90px;"></a>
                    </div>
                    <div class="car_name">
                        <h3><#if (e.vehicle.source?? && (e.vehicle.source == "av"))><img src="http://img.autostreetscdn.com/sell/build/1.00/images/sample.png" style="vertical-align:middle;" alt="" title="该车暂缺照片和检测报告，请以现场实车为准"></#if><#if (!e.vehicle.source?? || (e.vehicle.source != "av"))><a target="_blank" href="<@baseUrl.home />/auction/${id}/vehicle/${e.vehicleId}"></#if>${(e.vehicle.brand)!} ${(e.vehicle.vehicleModel)!} <#if e.vehicle.sweptVolumeStandard?? && e.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</a></h3>
                        <#if e.vehicle.vehicleDesc?? && (e.vehicle.vehicleDesc?trim?length > 0)>
                      	<p title="${(e.vehicle.vehicleDesc)!}"><#if (e.vehicle.vehicleDesc?trim?length > 22)>${(e.vehicle.vehicleDesc?substring(0,22))!}...<#else>${(e.vehicle.vehicleDesc)!}</#if></p>
                        <#else>
                   	    <p>该车暂无描述！</p>
                        </#if>
                        <#if (!e.vehicle.source?? || (e.vehicle.source != "av"))> 
		                    <#if (favoriteVehicleIds?size > 0)>
		  	                	<#if favoriteVehicleIds?seq_contains(e.id)>
		                      	<a href="javascript:;" class="addgz" id="a3-${e.id}" style="display: none;">收藏</a>
		                      	<a href="javascript:;" class="addgz-on" id="a1-${e.id}">取消收藏</a>
		                    	<#else>
		                      	<a href="javascript:;" class="addgz" id="a3-${e.id}">收藏</a>
		                      	<a href="javascript:;" style="display: none;" class="addgz-on" id="a1-${e.id}">取消收藏</a>
		                    	</#if>
		                    <#else>
		                    	<a href="javascript:;" class="addgz" id="a3-${e.id}">收藏</a>
		                      	<a href="javascript:;" style="display: none;" class="addgz-on" id="a1-${e.id}">取消收藏</a>
		                    </#if>
                   		</#if>
                    </div>
                </li>
                <li class="col-6">
                    <#if e.vehicle.certified?? && e.vehicle.certified>
                    <p title="该车经过了200项严酷检测，车辆骨架无损伤，车况为A级。" class="renzheng1">EQS认证</p>
	                </#if>
	                <#if e.vehicle.guaranteed?? && e.vehicle.guaranteed>
	                <p title="该车通过了EQS检测认证且符合购买车辆延保服务的条件。" class="renzheng2">延保服务</p>
	                </#if>
                </li>
                <li class="col-3">${(e.vehicle.registerCity)!}</li>
                <li class="col-6"><#if e.vehicle.licenseCode?? && (e.vehicle.licenseCode?length gt 1)>${(e.vehicle.licenseCode?substring(0,2))!}<#else>${(e.vehicle.licenseCode)!}</#if></li>
                <li class="col-6">${(e.vehicle.registerLicenseYears?substring(0,4))!}年${(e.vehicle.registerLicenseYears?substring(4))!}月</li>
                <li class="col-6">${((e.vehicle.displayMileage)/10000)?default(0.00)?string("0.00")!}万公里</li>
            </ul>
		 </#list>
        </div>
         <@pagination.pagination />
	</div>

<div class="attention2">
	<#if (!((auction.notice)??)||auction.notice=="")&&(!((auction.transactionGuide)??)||auction.transactionGuide=="")>
		
	<#else>
		<div class="content">
			<#if (auction.notice)??&&auction.notice!="">
				<h2>拍卖须知</h2>
				<p>${(auction.notice)!}</p>
			</#if>
			<#if (auction.transactionGuide)??&&auction.transactionGuide!="">
				<h2>成交指南</h2>
				<p>${(auction.transactionGuide)!}</p>
			</#if>
		</div>
	</#if>
</div>

<#include "/include/footer.ftl">

<div class="UED_hide" id="agreement">
    <div class="agreement-box">
        <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
        <div class="ag-container">
            <h3>汽车街同步拍用户许可协议</h3>
            <p>于2014年10月23日更新</p>
            <div class="detail">
                <h4>请仔细阅读如下内容，点击“同意”按钮后，即视为您已阅读、理解并同意本协议的全部内容，本协议即在您与汽车街之间产生法律效力，成为对双方均具有约束力的法律文件。</h4>
                <p>本场竞卖会为现场与网络同步拍卖，竞买人可选择网上竞价。网络竞买人一旦参与网上竞价，即认同和接受：网络竞卖的客观状态、竞卖会现场传导给客户端的竞卖标的图文信息和音频视频直播信号、竞卖主持人、竞卖成交价的确认。由于互联网可能出现不稳定情况，不排除网络竞卖发生故障（包括但不限于网络故障、电路故障、系统故障）以及被网络黑客恶意攻击，网络竞买人必须充分估计上述原因导致网上竞价不同于现场竞价所带来的风险，如果发生上述情况以及网络竞买人操作差错所造成的损失由网络竞买人承担。网络竞买人若有恶意竞价行为，本公司有权取消其竞买人资格并追究其法律责任本场竞卖会为现场与网络同步拍卖，竞买人可选择网上竞价。网络竞买人一旦参与网上竞价，即认同和接受：网络竞卖的客观状态、竞卖会现场传导给客户端的竞卖标的图文信息和音频视频直播信号、竞卖主持人、竞卖成交价的确认。由于互联网可能出现不稳定情况，不排除网络竞卖发生故障（包括但不限于网络故障、电路故障、系统故障）以及被网络黑客恶意攻击，网络竞买人必须充分估计上述原因导致网上竞价不同于现场竞价所带来的风险，如果发生上述情况以及网络竞买人操作差错所造成的损失由网络竞买人承担。网络竞买人若有恶意竞价行为，本公司有权取消其竞买人资格并追究其法律责任本场竞卖会为现场与网络同步拍卖，竞买人可选择网上竞价。网络竞买人一旦参与网上竞价，即认同和接受：网络竞卖的客观状态、竞卖会现场传导给客户端的竞卖标的图文信息和音频视频直播信号、竞卖主持人、竞卖成交价的确认。由于互联网可能出现不稳定情况，不排除网络竞卖发生故障（包括但不限于网络故障、电路故障、系统故障）以及被网络黑客恶意攻击，网络竞买人必须充分估计上述原因导致网上竞价不同于现场竞价所带来的风险，如果发生上述情况以及网络竞买人操作差错所造成的损失由网络竞买人承担。网络竞买人若有恶意竞价行为，本公司有权取消其竞买人资格并追究其法律责任本场竞卖会为现场与网络同步拍卖，竞买人可选择网上竞价。网络竞买人一旦参与网上竞价，即认同和接受：网络竞卖的客观状态、竞卖会现场传导给客户端的竞卖标的图文信息和音频视频直播信号、竞卖主持人、竞卖成交价的确认。由于互联网可能出现不稳定情况，不排除网络竞卖发生故障（包括但不限于网络故障、电路故障、系统故障）以及被网络黑客恶意攻击，网络竞买人必须充分估计上述原因导致网上竞价不同于现场竞价所带来的风险，如果发生上述情况以及网络竞买人操作差错所造成的损失由网络竞买人承担。网络竞买人若有恶意竞价行为，本公司有权取消其竞买人资格并追究其法律责任。</p>
            </div>
            <p class="checkbox"><input type="checkbox" id="checkbox123"> 本人已认真阅读且同意竞拍协议</p>
            <div class="ag_btn">
                <a href="#" class="agree">同意并继续</a>
            </div>
        </div>
    </div>
</div>

<script language="javascript" src="http://img.autostreetscdn.com/common/build/2.00/js/jquery.MinmyLazyload.js"></script>
<script language="javascript" src="http://img.autostreetscdn.com/common/build/1.00/js/fed.guide.js"></script>
<script language="javascript" src="http://img.autostreetscdn.com/common/build/1.00/js/jq.layer.js"></script>
<script language="javascript" src="http://img.autostreetscdn.com/fed/build/1.00/js/slide.js"></script>
<script language="javascript" src="http://img.autostreetscdn.com/sell/build/1.00/js/sell_list.js"></script>
<script language="javascript" src="<@baseUrl.static />/common/build/1.00/js/jquery.cookie.js"></script>
<script>
$(function(){
    
    $(".ag_btn a").click(function() {
  		if ($(".ag_btn a").hasClass("refuse")) {
  			return;
  		}
  	
    	if ($("input[type='checkbox']").attr("checked") == 'checked') {
    		$.cookie("${(memberSid)!}_${id}","1",{expires:3});
			$.LAYER.close();
			window.location.href = "<@baseUrl.home />/auction/${id}/live";
    	}
  	});
    
    
     $(".addgz").click(function() {
    	var avId = this.id.substring(3);

    	$.ajax({
      		url: "<@baseUrl.home />/member/favorite/add",
      		type: "post",
      		data: {
        		avId: avId
      		}
    	}).done(function(data) {
      		if (data.success) {
        		$("#a1-" + avId).show();
        		$("#a3-" + avId).hide();
      		} else{
      			window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
      		}
    	});
  });

  $(".addgz-on").click(function() {
    var avId = this.id.substring(3);

    $.ajax({
      url: "<@baseUrl.home />/member/favorite/remove",
      type: "post",
      data: {
        avId: avId
      }
    }).done(function(data) {
      if (data.success) {
        $("#a1-" + avId).hide();
        $("#a3-" + avId).show();
      }else{
      	window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
      }
    });
  });

  $("#auctionlive").click(function() {
	var syncAuctionLayerBtnOn="${(syncAuctionLayerBtnOn)!}";
	if(syncAuctionLayerBtnOn&&syncAuctionLayerBtnOn=="1"){
		tankuang();
		$("#syncAuctionLayerBtn").on('click',function(){
			window.location.href = "<@baseUrl.home />/auction/${id}/live";
		})
	}else{
		var flag = $.cookie("${(memberSid)!}_${id}");
	  	if (flag == "1") {
	  		window.location.href = "<@baseUrl.home />/auction/${id}/live";
	  	} else {
  			$("input[type='checkbox']").attr("checked",'checked');
	  		$(".ag_btn a").removeClass();
	  		$(".ag_btn a").addClass("agree");
	  		jQuery.LAYER.show({id:'agreement',overlay:{opacity:0.5}});
	  	}
	}
  });

});
    
    
</script>
</body>
</html>
</#escape>
