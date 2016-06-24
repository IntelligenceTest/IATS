<#import "/macro/baseUrl.ftl" as baseUrl>
<#escape x as x?html>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="others" content="汽车街_竞拍大厅_同步拍_${(auction.title)!}_直播室">
<title>直播室_${(auction.title)!}_同步拍_竞拍大厅_汽车街</title>
<link href="<@baseUrl.static />/common/build/1.00/css/tinyscrollbar.css<@baseUrl.time />" rel="stylesheet">
<link href="<@baseUrl.static />/sell/build/1.00/css/auction.css<@baseUrl.time />" rel="stylesheet">
</head>
<body>
<#include "/include/header1.ftl">
<div class="position">
  <a class="positionmain" href="<@baseUrl.parentHome />/">首页</a> &gt; <a href="<@baseUrl.home />/"><span>竞拍大厅</span></a> &gt; <a href="<@baseUrl.home />/syncauction/index"><span>同步拍</span></a> &gt; <a href="<@baseUrl.home />/syncauction/detail/${(sid)!}"><span>${(auction.title)!}</span></a> &gt; <span>网络现场同步拍卖直播室</span>
</div>
<div class="wp clearfix">
  <div class="auction-list" id="scrollbar1">
    <div class="scrollbar"><div class="track"><div class="thumb"><div class="end"></div></div></div></div>
    <div class="auction-list-body viewport">
      <ul class="overview" id="overview1">
        <#list auctionVehicleList as e>
          <li<#if auctionVehicle.id == e.id> class="on"</#if>>
          	<#if (e.vehicle.source != "av")>
          	   <a target="_blank" href="<@baseUrl.home />/auction/${auction.id}/vehicle/${(e.vehicleId)!}">
          	<#else>
          	    <a>
          	</#if>
            <img src="<#if e.vehicle.firstPhotoUrl?? && (e.vehicle.firstPhotoUrl != "")><@baseUrl.image />/${(action.getThumbImgUrl("80X60", "${(e.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width: 80px; height: 60px;">
            <ins>${(e.auctionVehicleOrder?string("000"))!}</ins>  
            </a>
			<#assign tempSelledName = "">
			<#if (e.vehicle.selledName)??>
		      	  <#assign tempSelledName = e.vehicle.selledName>
			      <#if e.vehicle.selledName?starts_with(e.vehicle.vehicleModel)>
			    	   <#assign tempSelledName = e.vehicle.selledName?replace(e.vehicle.vehicleModel, '', 'f')>
			      </#if>
			</#if>
            <h3 style="float:left;width:180px"><#if (e.vehicle.source != "av")>
                    <a style="color:#666;text-decoration:none" target="_blank" href="<@baseUrl.home />/auction/${auction.id}/vehicle/${(e.vehicleId)!}">
                  <#else>
                     <a style="float:left;margin:0 10px 0 0">
                  </#if>
                   <#if (e.vehicle.source == "av")><img src="http://img.autostreetscdn.com/sell/build/1.00/images/temp.png" style="vertical-align:middle; margin:0 2px 0 0;" alt="" title="该车暂缺照片和检测报告，请以现场实车为准"></#if>${(e.vehicle.brand)!} ${(e.vehicle.vehicleModel)!}<#if e.vehicle.sweptVolumeStandard?? && e.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if>
                    </a>
                   ${(tempSelledName)!} </h3>
            <p><#if (e.vehicle.source != "av")><#if favoriteVehicleIds?seq_contains('${e.id}')><span class="span1">&radic;已收藏</span></#if></#if><#--<span class="span2">&radic;已出代理价</span>--></p>
          </li>
        </#list>
      </ul>
    </div>

    <div class="auction-list-body list-flag viewport">
      <ul class="overview" id="overview2">
        <#list auctionVehicleList as e>
          <#if auctionVehicle.id == e.id && auctionVehicle.status == 5>
            <li class="on">正在拍卖</li>
          <#else>
            <li></li>
          </#if>
        </#list>
      </ul>
    </div>
  </div>
  
  <!-- 需要刷新 -->
  <div class="auction-detail">
  	<input value="${auctionVehicle.id}" id="currentAV" type="hidden" />
	<#assign tempSelledName = (auctionVehicle.vehicle.selledName)!"">
	<#if tempSelledName!=""&&auctionVehicle.vehicle.selledName?starts_with(auctionVehicle.vehicle.vehicleModel)>
		<#assign tempSelledName = auctionVehicle.vehicle.selledName?replace(auctionVehicle.vehicle.vehicleModel, '', 'f')>
	</#if>
    <h3><strong class="s1" id="av-status"><#if auctionVehicle.status == 1>未开始<#elseif auctionVehicle.status == 5>正在拍卖<#elseif auctionVehicle.status == 6>暂停</#if></strong><label id="f_title"><#if (auctionVehicle.vehicle.source == "av")><img src="http://img.autostreetscdn.com/sell/build/1.00/images/temp.png"style="vertical-align:middle;"  alt="" title="该车暂缺照片和检测报告，请以现场实车为准"></#if>${(auctionVehicle.vehicle.brand)!} ${(auctionVehicle.vehicle.vehicleModel)!}&nbsp&nbsp<#if (auctionVehicle.vehicle.sweptVolumeStandard)?? && (auctionVehicle.vehicle.sweptVolumeStandard)?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</label></h3>
    <div class="auction-detail-img">
      <img src="<#if auctionVehicle.vehicle.firstPhotoUrl?? && (auctionVehicle.vehicle.firstPhotoUrl != "")><@baseUrl.image />/${(action.getThumbImgUrl("320X240", "${(auctionVehicle.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width: 320px; height: 240px;">
      <div id="seconds"><#if seconds??>${seconds}</#if></div>
    </div>
    <ul class="auction-detail-list">
      <li><span>地区</span><label id="f_city">${(auctionVehicle.vehicle.registerCity)!}</label></li>
      <li><span>原车牌号</span><label id="f_license"><#if auctionVehicle.vehicle.licenseCode?? && (auctionVehicle.vehicle.licenseCode?length gt 1)>${(auctionVehicle.vehicle.licenseCode?substring(0,2))!}<#else>${(auctionVehicle.vehicle.licenseCode)!}</#if> </label></li>
      <li><span>是否带牌拍</span><label id="f_licenseFlg"><#if auctionVehicle?? && auctionVehicle.vehicle?? && auctionVehicle.vehicle.withLicense?? && auctionVehicle.vehicle.withLicense>是<#else>否</#if></label></li>
      <li><span>年份</span><label id="f_prodDate">${(auctionVehicle.vehicle.registerLicenseYears?substring(0,4))!}年</label></li>
      <li><span>里程</span><label id="f_mile">${((auctionVehicle.vehicle.displayMileage)/10000)?default(0.00)?string("0.##")!}万公里</label></li>
      <li><span>变速箱</span><label id="f_transmission">${(auctionVehicle.vehicle.transmissionType)!}</label></li>
      <li><span>使用性质</span><label id="f_usingModel">${(auctionVehicle.vehicle.usingModel)!}</label></li>
      <li><span>&nbsp;</span></li>
    </ul>
    <dl>
      <dt>其他描述</dt>
      <dd id="f_otherDesc">${(auctionVehicle.vehicle.vehicleDescribe)!}</dd>
    </dl>
   <#if (auctionVehicle.vehicle.source != "av")>
    	<a id="f_detailUrl" href="<@baseUrl.home />/auction/${auctionVehicle.auctionId}/vehicle/${(auctionVehicle.vehicleId)!}" class="alink" target="_blank">更多详情 &gt;</a>
   </#if>
    <div class="renzheng">
      <#if auctionVehicle?? && auctionVehicle.vehicle?? && auctionVehicle.vehicle.certified?? && auctionVehicle.vehicle.certified>
        <img id="f_eqs" src="<@baseUrl.static />/common/build/1.00/images/eqs.png">
      </#if>
      <#if auctionVehicle?? && auctionVehicle.vehicle?? && auctionVehicle.vehicle.guaranteed?? && auctionVehicle.vehicle.guaranteed>
        <img id="f_qa" src="<@baseUrl.static />/common/build/1.00/images/qa.png">
      </#if>
    </div>
    
        
    <div>
    	<#if userVip == "1">
    		<a href="javascript:;" class="playbtn1" id="playbtn1">听音频直播</a><a href="javascript:;" class="playbtn2" id="playbtn2">看视频直播</a>
    	</#if>
    </div>
    <div class="video" id="video" style="display: none;">
      <script src="http://img.autostreetscdn.com/common/build/1.00/swf/player.js<@baseUrl.time />"></script>
      <script type="text/javascript">p2ps_embed("auto", "live", "<#noescape>${(auction.videoUrl)!}</#noescape>", "p2ps_video", "278", "190", "9.1.0", "http://img.autostreetscdn.com/common/build/1.00/swf/expressInstall.swf",{}, {allowFullScreen:true, allowScriptAccess: "always",wmode:"transparent"});</script>
      <div id="p2ps_video">
      	<h1>我们需要Flash player 10.1 或以上版本来播放。</h1>
      	<p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="安装最新的Flash player" /></a></p>
      </div>
    </div>
    <a href="javascript:;" class="tipclose closevideo" id="closevideo" style="display: none;"></a>
  </div>
  <div class="auction-pricebox">
    <ul class="auction-pricelist">
      <li>
        <span class="pricelist-l">当前价</span>
        <div class="pricelist-r">
        	<#if userVip == "1">
        		<strong class="pricemoney" id="pricemoney"><#noescape>${action.format(currentPrice)}</#noescape></strong>元
        	<#else>
        		<strong class="pricemoney" id="pricemoney" style="font-size:12px;line-height:40px;">认证商户可见</strong> <img src="<@baseUrl.static />/services/build/1.00/images/explain.png" alt="" title="欲成为认证商户请拨打：400-821-8889">
        	</#if>
        </div>
      </li>
      <#if userVip == "1">
      <li>
        <span class="pricelist-l">我的出价</span>
        <div class="pricelist-r">
        	<span class="paid-1" id="paid-1">
        		<#if myBidPrice == 0>尚未出价<#else>${myBidPrice?string("0")}</#if>
        	</span>
        	<span class="current-first" id="current-first"<#if !isTopPrice> style="display: none;"</#if>>当前最高</span>
        	<span class="current-last" id="current-last" style="display: none;">
        		出价慢了，请重新出价
        	</span>
        </div>
      </li>
      </#if>
      <#if userVip == "1">
      <li><span class="pricelist-l">出价</span>
          <div class="pricelist-r">
              <p class="clearfix"><strong class="paidbox" id="paidbox"><#noescape>${action.format(bidPrice)}</#noescape></strong>
                  <span id="has-bid" style="display: none;">${hasBid}</span>
                  <span class="adddelbox">
                      <a id="addbtn" class="addbtn" href="javascript:;"></a><a id="delbtn" class="delbtn" href="javascript:;"></a>
                  </span>
                  <span class="text-yuan">元</span> 加价幅度：<span id="plus-range">${(auctionVehicle.plusRange)!0}</span>元
              </p>
              <p class="clearfix">
                  <#--<a href="javascript:;" class="auction-btn-1<#if !bidActive || isTopPrice> auction-btn-dis</#if>" id="btn-bid">出价</a>-->
                  <a href="javascript:;" class="auction-btn-1<#if !bidActive> auction-btn-dis</#if>" id="btn-bid">出价</a>
              </p>
          </div>
      </li>
      </#if>
    </ul>
    <div class="pricelist_ul">
      <ul>
        <li>佣金率：
        	<span id="f_commPer">
	        	<#if (auctionVehicle.buyerFixedCommission)??&&(auctionVehicle.buyerFixedCommission) gt 0>
	        		-
	        	<#else>
		  			<#if !((data.auctionVehicle.buyerCommissionRate)??)>
		  				-
		  			<#else>
		        		${((auctionVehicle.buyerCommissionRate)?string("0.##"))!0}%
		  			</#if>
				</#if>
			</span>
		</li>
        <li>交易佣金：<span id="commission">${commission}</span> 元</li>
        <li>保证金：<span id="f_margin">${(auction.vehicleMargin?string("0"))!"0"}</span> 元</li>
        <li>办证手续费：<span id="f_licenFee">${(auctionVehicle.licenseFee?string("0"))!"0"}</span> 元</li>
        <li>出库费：<span id="f_exWareFee">${(auctionVehicle.exWarehouseFee?string("0"))!"0"}</span> 元</li>
        <li>停车费：<span id="f_parkingFee">${(auctionVehicle.parkingFee?string("0"))!"0"}</span> 元</li>
        <li>物流费：自理</li>
      </ul>
      <#if userVip == "1">
      	<p class="current-price">当前总价：<strong id="total-price">${totalPrice?string("0")}</strong> 元</p>
      </#if>
    </div>
  </div>
  <div class="auction-txtbox">
    <h3>现场情况</h3>
    <div class="talklist" id="talklist">
      <#if userVip == "1">
      <#list bidListWithMsg as bid>
        <dl<#if bid.bidderSid?? && userIdentity?? && bid.bidderSid == userIdentity.id> class="txt2"</#if>>
          <dt>${bid.bidTimestamp?string("HH:mm:ss")}</dt>
          <dd>${bid.content!}</dd>
        </dl>
      </#list>
      </#if>
    </div>
  </div>
</div>
<#include "/include/footer.ftl">
<script src="<@baseUrl.static />/common/build/1.00/js/jquery.tinyscrollbar.min.js<@baseUrl.time />"></script>

<script>
var divHeight = $(".viewport").height();
var ulHeight = $("#overview1").height();
var scale = ulHeight/816;
var len = $("#overview1 li").length;

function scroll2CurAV() {
	// 滚动js脚本
	var _index = $("#overview1 li.on").index();
	var _scrollHeight = _index*91;
    //console.log(_index,ulHeight,scale)
    if(len>9){
    	if(_scrollHeight+divHeight < ulHeight){
	    	$(".overview").animate({"top":-_index*91+"px"},500);
	    	$(".thumb").animate({"top":_index*91/scale+"px"},500);
	    }else{
	    	$(".overview,.thumb").css("top","auto").animate({"bottom":0},500);
	    }
    }
}
$(function() {
    //@author dongling.qu 在拍卖会不在拍卖中，退出拍卖大厅
    if (${(auction.status)} !=2) {
      	 window.location.href="http://www.autostreets.com";
    }
    
	$('#scrollbar1').tinyscrollbar();
	
    scroll2CurAV();
    
    // 单点登录js脚本
	$("#cas_logout").click(function(){
     window.location.href="https://login.autostreets.com/logout?service="+encodeURIComponent(window.location.href);
    });
    
    $("#cas_login").click(function(){
    	window.location.href="https://login.autostreets.com/login?service="+encodeURIComponent(window.location.href);
    });
    
    <#if userIdentity?? && !sessionCasIsLogin??>
		$(document.body).append("<iframe style='display:none' src='<@baseUrl.home />/cas/protected'></iframe>");
	</#if>

  // 隐藏在线客服
  //HideCustomerService();

  function format(x) {
    var s = x.toFixed(0);
    var buffer = [];
    if (s.length > 4) {
      buffer.push("<i>");
      buffer.push(s.substring(0, s.length - 4));
      buffer.push("</i>");
      buffer.push(s.substring(s.length - 4));
    } else {
      buffer.push(s);
    }
    return buffer.join("");
  }

  function format1(x) {
    var s = x.toFixed(0);
    var buffer = [];
    if (s.length > 4) {
      buffer.push("<ins>");
      buffer.push(s.substring(0, s.length - 4));
      buffer.push("</ins>");
      buffer.push(s.substring(s.length - 4));
    } else {
      buffer.push(s);
    }
    return buffer.join("");
  }
  
  function format2(x) {
    if (!x) {
    	return "0";
    }
    
    var s = x.toFixed(0);
    var buffer = [];
    if (s.indexOf(".") > 0) {      
      buffer.push(s.substring(0, s.indexOf(".")));
    } else {
      buffer.push(s);
    }
    return buffer.join("");
  }

  function formatDate(ms) {
    var buffer = [];

    var d = new Date();
    d.setTime(ms);

    if (d.getHours() < 10) {
      buffer.push("0");
    }
    buffer.push(d.getHours());
    buffer.push(":");

    if (d.getMinutes() < 10) {
      buffer.push("0");
    }
    buffer.push(d.getMinutes());
    buffer.push(":");

    if (d.getSeconds() < 10) {
      buffer.push("0");
    }
    buffer.push(d.getSeconds());

    return buffer.join("");
  }

  $("#btn-bid").click(function() {
    if ($(this).hasClass("auction-btn-dis")) {
      return;
    }
	$(this).addClass("auction-btn-dis");	
    
    var value = $("#paidbox").html().replace(/[^0-9]/g, "");

    $.ajax({
      url: "<@baseUrl.home />/member/bid/add",
      type: "post",
      async: false,
      data: {
        avId: $("#currentAV").val(),
        price: parseInt(value)
      }
    }).done(function(data) {
      if (data.success) {
        $("#paid-1").html(data.price);
        $("#pricemoney").html(format(data.price));

        $("#has-bid").html("1");

        var $paidbox = $("#paidbox");
        var price = parseInt($paidbox.html().replace(/[^0-9]/g, ""));
        if (price <= data.price) {
          var plus = parseInt($("#plus-range").html());
          $paidbox.html(format(data.price + plus));
        }

        $("#commission").html(data.commission);
        $("#total-price").html(data.totalPrice);
        $("#talklist").prepend("<dl class=\"txt2\"><dt>" + formatDate(data.bid.bidTimestamp) + "</dt><dd>" + data.bid.content + "</dd></dl>");
        $("#current-first").show();
        <#--$("#btn-bid").addClass("auction-btn-dis");-->
      } else {
      	if(data.redirectUrl){
      		 window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/auction/${sid}/live");
      	}else{
      		if (data.error) {
	          if (data.error == "1") {
	            window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/auction/${sid}/live");
	          } else {
	            $("#current-last").html(data.error).show().fadeOut(2000);
	          }
	        }
      	}
      }
    });
  });

  $("#addbtn").click(function() {
    var $paidbox = $("#paidbox");
    var price = parseInt($paidbox.html().replace(/[^0-9]/g, ""));
    var plus = parseInt($("#plus-range").html());
    $paidbox.html(format(price + plus));
  });

  $("#delbtn").click(function() {
    var $paidbox = $("#paidbox");
    var price = parseInt($paidbox.html().replace(/[^0-9]/g, ""));
    var plus = parseInt($("#plus-range").html());
    var currentPrice = parseInt($("#pricemoney").html().replace(/[^0-9]/g, ""));
    var hasBid = parseInt($("#has-bid").html());
    if (hasBid) {
      if (price - plus > currentPrice) {
        $paidbox.html(format(price - plus));
      }
    } else {
      if (price - plus >= currentPrice) {
        $paidbox.html(format(price - plus));
      }
    }
  });

  <#if userVip == "1">
  setInterval(function() {
    var userId = "<#if userIdentity??>${userIdentity.id}</#if>";

    $.ajax({
      url: "<@baseUrl.home />/auction/sync",
      type: "get",
      async: false,
      timeout: 3000,
      data: {
        avId: $("#currentAV").val(),
        auctionSid:"${auction.id}",
        t: new Date().getTime()
      }
    }).done(function(data) {
      if (data.success) {
        //@author dongling.qu 在拍卖会不在拍卖中，退出拍卖大厅
        if (data.auction.status !=2) {
        	 window.location.href="<@baseUrl.home />/";
        }
        if (data.auctionVehicle.status == "1") {
          $("#av-status").html("未开始");
          $("#btn-bid").addClass("auction-btn-dis");
          
          $("#pricemoney").html(format(data.currentPrice));
          $("#paidbox").html(format(data.bidPrice));
		  $("#commission").html(data.commission);
		  $("#total-price").html(data.totalPrice);
        } else if (data.auctionVehicle.status == "5") {
          $("#av-status").html("正在拍卖");
          $("#pricemoney").html(format(data.currentPrice));
		  $("#commission").html(data.commission);
		  $("#total-price").html(data.totalPrice);
          if (data.currentBidderSid == userId) {
          	$("#btn-bid").addClass("auction-btn-dis");
          } else {
          	$("#btn-bid").removeClass("auction-btn-dis");
          }
        } else if (data.auctionVehicle.status == "6") {
          $("#av-status").html("暂停");
          $("#btn-bid").addClass("auction-btn-dis");
        } else if (data.auctionVehicle.status == "4") {
          $("#av-status").html("流拍");
          $("#btn-bid").addClass("auction-btn-dis");
        }

		if (data.currentAvExists) {
          $("#overview1 > li").removeClass("on");
          $("#overview2 > li").removeClass("on").html("");
          $("#overview1 > li").eq(data.currentAvIndex).addClass("on");
          $("#overview2 > li").eq(data.currentAvIndex).addClass("on").html("正在拍卖");
        } else {
          $("#overview1 > li").removeClass("on");
          $("#overview2 > li").removeClass("on").html("");
          $("#overview1 > li").eq(data.currentAvIndex).addClass("on");
        }
        
  		if (data.chgFlag == 1) {
  			scroll2CurAV();
  			
  			$("#f_title").html(data.title);
  			$("#f_detailUrl").attr("href", "<@baseUrl.home />/auction/" + data.auction.id + "/vehicle/" + data.auctionVehicle.vehicle.id);
  			$(".auction-detail-img > img").attr("src", "<@baseUrl.image />/" + data.imgUrl);
  			
  			$("#currentAV").val(data.auctionVehicle.id);
  		    var lc = data.auctionVehicle.vehicle.licenseCode;
  			$("#f_city").html(data.auctionVehicle.vehicle.registerCity);
  			$("#f_license").html(lc.substring(0,2));

  			if (data.auctionVehicle.vehicle.withLicense) {
  				$("#f_licenseFlg").html("是");
  			} else {
  				$("#f_licenseFlg").html("否");
  			}
  			
  			<#--fixbug by zjz 直接截取字符串类型的registerLicenseYears-->
  			//var dd = new Date(data.auctionVehicle.vehicle.registerLicenseYears);
   			//var pd = dd.getFullYear() + "";
   			var _registerLicenseYears = data.auctionVehicle.vehicle.registerLicenseYears;
   			if(_registerLicenseYears&&_registerLicenseYears.length>=4){
				$("#f_prodDate").html(_registerLicenseYears.substring(0,4) + "年");
			}
			//fixbug 万公里转公里，并且除去小数点后多余0 by zjz 
			$("#f_mile").html(parseFloat(parseFloat(data.auctionVehicle.vehicle.displayMileage/10000).toFixed(2)) + "万公里");

			$("#f_transmission").html(data.auctionVehicle.vehicle.transmissionType);
			$("#f_sweptVolumn").html(data.auctionVehicle.vehicle.sweptVolumeStandard);
			$("#f_usingModel").html(data.auctionVehicle.vehicle.usingModel);
			
			$("#f_otherDesc").html(data.auctionVehicle.vehicle.vehicleDescribe);
			
			$("#pricemoney").html(format(data.currentPrice));
			$("#paidbox").html(format(data.bidPrice));
			
			$("#commission").html(data.commission);
        	$("#total-price").html(data.totalPrice);
        	//$("#f_margin").html(format2(data.auction.vehicleMargin));
        	$("#f_licenFee").html(format2(data.auctionVehicle.licenseFee));
        	$("#f_exWareFee").html(format2(data.auctionVehicle.exWarehouseFee));
        	$("#f_parkingFee").html(format2(data.auctionVehicle.parkingFee));
  		}
  		
  		if(data.auctionVehicle.buyerFixedCommission&&parseInt(data.auctionVehicle.buyerFixedCommission)>0){
  			$("#f_commPer").html("-");
  		}else{
  			if(data.auctionVehicle.buyerCommissionRate){
  				$("#f_commPer").html(data.auctionVehicle.buyerCommissionRate+"%");
  			}else{
  				$("#f_commPer").html("-");
  			}
  		}
        	

        if (data.bidActive) {
          if (data.currentBidderSid == userId) {
          	$("#btn-bid").addClass("auction-btn-dis");
          } else {
          	$("#btn-bid").removeClass("auction-btn-dis");
          }
        } else {
          $("#btn-bid").addClass("auction-btn-dis")
        }

        if (data.isTopPrice&&data.currentBidderSid!="000") {
          	$("#current-first").html("当前最高");
          	$("#current-first").show();
        }else if(data.isTopPrice&&data.currentBidderSid=="000"){
          	$("#current-first").html("现场有商户也出此价，请继续出价！");
          	$("#current-first").show();
        } else {
        	$("#current-first").fadeOut();
        }

        if (data.seconds && data.seconds >= 0) {
          $("#seconds").html(data.seconds.toString());
        } else {
          $("#seconds").html("");
        }

		var myPriceMoney = parseInt($("#pricemoney").html().replace(/[^0-9]/g, ""));
		if(data.currentPrice > myPriceMoney){
			$("#pricemoney").html(format(data.currentPrice));
		}
       	

        if (data.auctionVehicle.plusRange) {
          $("#plus-range").html(data.auctionVehicle.plusRange);
        } else {
          $("#plus-range").html("0");
        }

        var $paidbox = $("#paidbox");
        var bidPrice = parseInt($paidbox.html().replace(/[^0-9]/g, ""));
        if (bidPrice < data.bidPrice) {
          $paidbox.html(format(data.bidPrice));
        }

        $("#commission").html(data.commission);
        
        var myTotalPrice = parseInt($("#total-price").html());
        if(data.totalPrice > myTotalPrice){
        	$("#total-price").html(data.totalPrice);
        }
        
        if (data.myBidPrice == 0) {
          $("#paid-1").html("尚未出价");
        } else {
        	var myBidPriceCurrent = parseInt($("#paid-1").html());
	        if(data.myBidPrice > myBidPriceCurrent){
	        	$("#paid-1").html(data.myBidPrice);
	        }
        }

        var buffer = [];
        for (var i = 0; i < data.bidListWithMsg.length; ++i) {
          var bid = data.bidListWithMsg[i];

          if (bid.bidderSid == userId) {
            buffer.push("<dl class=\"txt2\"><dt>");
          } else {
            buffer.push("<dl><dt>");
          }
          buffer.push(formatDate(bid.bidTimestamp));
          buffer.push("</dt><dd>");
          buffer.push(bid.content);
          buffer.push("</dd></dl>");
        }
        $("#talklist").html(buffer.join(""));
      } else if (data.redirectUrl) {
        window.location.href = "<@baseUrl.home />" + data.redirectUrl;
      }
    });
  }, 1000);
  </#if>

  $("#playbtn1, #playbtn2").click(function() {
    $("#video").show();
    $("#closevideo").show();
  });

  $("#closevideo").click(function() {
    $("#video").hide();
    $("#closevideo").hide();
  });
});
</script>
</body>
</html>
</#escape>
