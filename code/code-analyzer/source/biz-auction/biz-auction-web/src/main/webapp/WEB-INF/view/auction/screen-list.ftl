<#import "/macro/baseUrl.ftl" as baseUrl>
<#escape x as x?html>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="others" content="汽车街_竞拍大厅_同步拍_拍卖列表">
<title>拍卖列表_同步拍_竞拍大厅_汽车街</title>
<link href="<@baseUrl.static />/sell/build/1.00/css/live.css<@baseUrl.time />" rel="stylesheet">
</head>
<body>
	
<div class="live-2" id="livelist">
	<span id="current-av-sid" style="display:none;">${(currentAV.sid)!}</span>
	<ul>
		<#list avList as av>
			<li <#if (currentAV?? && av.id == currentAV.id)>class="on"</#if> id="row-${(av.id)!}">
				<#assign tempSelledName = "">
				<#if (av.vehicle.selledName)??>
			      	  <#assign tempSelledName = av.vehicle.selledName>
				      <#if av.vehicle.selledName?starts_with(av.vehicle.vehicleModel)>
				    	   <#assign tempSelledName = av.vehicle.selledName?replace(av.vehicle.vehicleModel, '', 'f')>
				      </#if>
				</#if>
				<span class="span1">${(av.auctionVehicleOrder?string("000"))!}</span>
				<span class="span2">${(av.vehicle.licenseCode)!}</span>
				<span class="span3">&nbsp;&nbsp;<#if (av.vehicle.source?? && av.vehicle.source == "av")><img src="http://img.autostreetscdn.com/sell/build/1.00/images/sample_32x32.png" style="vertical-align:middle;" alt="" title="该车暂缺照片和检测报告，请以现场实车为准"></#if>${(av.vehicle.brand)!} ${(av.vehicle.vehicleModel)!}<#if av.vehicle.sweptVolumeStandard?? && av.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</span>
			</li>
		</#list>
	</ul>
</div>

<script language="javascript" src="<@baseUrl.static />/common/build/1.00/js/lib/jquery-1.8.3.min.js"></script>

<script>
$(function() {
  setInterval(function() {
  	var currAvSid = $("#current-av-sid").html();
    $.ajax({
      url: "<@baseUrl.home />/screen-listrefresh",
      type: "get",
      timeout: 3000,
      data: {
        auctionSid: "${auctionSid}",
        t: new Date().getTime()
      }
    }).done(function(data) {
      if (data.success) {
        var nowAvSid = data.currentAvSid;
        var i = 0;
        
        if (nowAvSid != "") {
        	i = $("#livelist ul li").index($("#row-" + nowAvSid));
        	if (currAvSid != nowAvSid) {
        		$("#row-" + currAvSid).removeClass("on");
        		$("#row-" + nowAvSid).addClass("on");
        	}
        	$("#current-av-sid").html(nowAvSid);
        } else {
        	$("#row-" + currAvSid).removeClass("on");
        	$("#current-av-sid").html(nowAvSid);
        }
        
        if (i > 4) {
        	$("#livelist ul").animate({top: '-' + 100*(i-4) + 'px'});
        } else {
        	$("#livelist ul").animate({top: '0px'});
        }        
                
      }
    });
  }, 1000);
});
</script>
</body>
</html>
</#escape>
