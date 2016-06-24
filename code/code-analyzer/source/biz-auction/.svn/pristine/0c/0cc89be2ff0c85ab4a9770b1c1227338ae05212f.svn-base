<#import "/macro/baseUrl.ftl" as baseUrl>
<#escape x as x?html>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="others" content="汽车街_竞拍大厅_同步拍_拍卖信息">
<title>拍卖信息_同步拍_竞拍大厅_汽车街</title>
<link href="<@baseUrl.static />/sell/build/1.00/css/live.css<@baseUrl.time />" rel="stylesheet">
</head>
<body>
<div class="live-1">
  <img src="<#if photoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("520X390", "${(photoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" id="img" class="liveimg" style="width: 520px; height: 390px;">
  <h2 class="livetitle">
      <span id="order-number">${(orderNumber)!}</span><i id="license-code">${(licenseCode)!}</i>
  </h2>
  <h3 class="protitle">
      <img src="http://img.autostreetscdn.com/sell/build/1.00/images/sample_64x64.png" style="vertical-align:middle;" id="linshi" alt="" title="该车暂缺照片和检测报告，请以现场实车为准" >
  <span id="title">${(title)!}</span></h3>
  <div class="current">
		<blockquote>
			<p id="f_commission">佣金${(commission)!}元</p><p id="f_licenseFee">办证费${(licenseFee)!}元</p><p id="f_exWarehouseFee">出库费${(exWarehouseFee)!}元</p>
			<b id="f_currentTotal" <#if bidType == "现场出价">style="color:#3EF708"<#elseif bidType == "网络出价">style="color:#E3FD02"<#else>style="color:#E3FD02"</#if>>当前总价 <span id="f_totalPrice">${(totalPrice)!}</span> 万元</b>
		</blockquote>
		<span class="currentby" style="font-size:70px">当前价<br>
		<strong id="bid-type" <#if bidType == "现场出价">style="color:#3EF708;font:bold 80px/80px '微软雅黑';"<#elseif bidType == "网络出价">style="color:#E3FD02;font:bold 80px/80px '微软雅黑';"<#else>style="color:#E3FD02;font:bold 80px/80px '微软雅黑';"</#if>>${(bidType)!}</strong>
		</span>
		<span class="currentmoney">
		<strong id="max-bid-price" <#if bidType == "现场出价">style="color:#3EF708"<#elseif bidType == "网络出价">style="color:#E3FD02"<#else>style="color:#E3FD02"</#if>>${(currentPrice)!}</strong>
		<i <#if bidType == "现场出价">style="color:#3EF708"<#elseif bidType == "网络出价">style="color:#E3FD02"<#else>style="color:#E3FD02"</#if>>万元</i>
		</span>
  </div>
</div>

<script language="javascript" src="<@baseUrl.static />/common/build/1.00/js/lib/jquery-1.8.3.min.js"></script>

<script>
$(function() {
   if ('${(source)!}' != 'av'){
   	  $("#linshi").hide();
   }
    
  setInterval(function() {
    $.ajax({
      url: "<@baseUrl.home />/screen-refresh",
      type: "get",
      timeout: 3000,
      data: {
        auctionSid: "${auctionSid}",
        t: new Date().getTime()
      }
    }).done(function(data) {
      if (data.success) {
        $("#title").html(data.title);
        var photoFlg = data.hasPhoto;
        if (photoFlg == "0") {
        	$("#img").attr("src", "<@baseUrl.static />/common/build/1.00/images/noimg.png");
        } else {
        	$("#img").attr("src", "<@baseUrl.image />/" + data.photoUrl);
        }
        
        if(data.source=='av'){
       		$("#linshi").show();
        } else {
            $("#linshi").hide();
        };
        $("#order-number").html(data.orderNumber);
        $("#license-code").html(data.licenseCode);
        $("#max-bid-price").html(data.currentPrice);
        $("#bid-type").html(data.bidType);
        
        $("#f_commission").html("佣金" + data.commission + "元");
        $("#f_licenseFee").html("办证费" + data.licenseFee + "元");
        $("#f_exWarehouseFee").html("出库费" + data.exWarehouseFee + "元");
        $("#f_totalPrice").html(data.totalPrice);
        
        if (data.bidType == "现场出价") {
        	$("#bid-type").css("color","#3EF708");
        	$("#max-bid-price").css("color","#3EF708");
        	$("#f_currentTotal").css("color","#3EF708");
        	$(".currentmoney i").css("color","#3EF708");
        } else if (data.bidType == "网络出价") {
        	$("#bid-type").css("color","#E3FD02");
        	$("#max-bid-price").css("color","#E3FD02");
        	$("#f_currentTotal").css("color","#E3FD02");
        	$(".currentmoney i").css("color","#E3FD02");
        } else {
        	$("#bid-type").css("color","#E3FD02");
        	$("#max-bid-price").css("color","#E3FD02");
        	$("#f_currentTotal").css("color","#E3FD02");
        	$(".currentmoney i").css("color","#E3FD02");
        }
        
        if (data.hasEnd == "1") {
        	$("#max-bid-price").css("color","red");
        	$(".currentmoney i").css("color","red");
        	$("#f_currentTotal").css("color","red");
        }
      }
    });
  }, 1000);
});
</script>
</body>
</html>
</#escape>
