<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="others" content="汽车街_竞拍大厅_在线拍">
<title>在线拍_竞拍大厅_汽车街</title>

<link href="<@baseUrl.static />/sell/build/1.00/css/list.css<@baseUrl.time />" rel="stylesheet">
</head>
<body>
<#include "/include/header1.ftl">
<@layout.nav active = "auction" />

<div class="position">
  <a class="positionmain" href="<@baseUrl.home />/">首页</a> &gt; <a href="<@baseUrl.home />/auctionhall/index"><span>竞拍大厅</span></a> &gt; <a href="<@baseUrl.home />/onlineauction/index"><span>在线拍</span></a>
  <div class="times">第<span>${auctionCount}</span>场</div>
</div>

<div class="listbody-1 pt20">
    <div class="listbodybox">
        <div class="selecetlist selecetlist-1">
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
    	<div class="tabbox">
    		<ul class="clearfix">
    			<li><a href="${action.getUrl("dateflag,pageNumber", "0,1")}"<#if !dateflag?? || dateflag == 0> class="current"</#if>>全部</a></li>
                <li><a href="${action.getUrl("dateflag,pageNumber", "1,1")}"<#if dateflag?? && dateflag == 1> class="current"</#if>>今天结束</a></li>
                <li><a href="${action.getUrl("dateflag,pageNumber", "2,1")}"<#if dateflag?? && dateflag == 2> class="current"</#if>>明天结束</a></li>
                <li><a href="${action.getUrl("dateflag,pageNumber", "3,1")}"<#if dateflag?? && dateflag == 3> class="current"</#if>>后天结束</a></li>
                <li><a href="${action.getUrl("dateflag,pageNumber", "4,1")}"<#if dateflag?? && dateflag == 4> class="current"</#if>>其余结束</a></li>
            </ul>
    	</div>
    	
    	<ul class="clearfix citylist">
    		<li><a href="${action.getUrl("city,pageNumber", ",1")}"<#if !city?? || city == ""> class="current"</#if>>全部地区</a></li>
    		<#list action.cityList as cityItem>
    		<li><a href="${action.getUrl("city,pageNumber", "${cityItem},1")}"<#if city?? && city == cityItem> class="current"</#if>>${cityItem}</a></li>
            </#list>
            
		</ul>
    </div>

        <div class="listbodybox onlinelist">
        <div>
            <ul class="clearfix listthead">
                <li class="col-1">&nbsp;</li>
                <li class="col-2">车辆信息</li>
                <li class="col-2_5">保障</li>
                <li class="col-3">所在地</li>
                <li class="col-4">车牌号</li>
                <li class="col-5">首次上牌</li>
                <li class="col-6">表显里程</li>
                <li class="col-7">
                    <div class="selectbox">
                        <span class="selectboxshow">拍卖状态</span>
                        <ul class="selectlist" style="height: auto;">
                            <li><a href="${action.getUrl("status,pageNumber", ",1")}">全部</a></li>
                            <li><a href="${action.getUrl("status,pageNumber", "1,1")}">未开始</a></li>
                            <li><a href="${action.getUrl("status,pageNumber", "5,1")}">拍卖中</a></li>
                            <li><a href="${action.getUrl("status,pageNumber", "2,1")}">成交</a></li>
                            <li><a href="${action.getUrl("status,pageNumber", "3,1")}">成交确认</a></li>
                            <li><a href="${action.getUrl("status,pageNumber", "4,1")}">流拍</a></li>
                            <li><a href="${action.getUrl("status,pageNumber", "7,1")}">已下架</a></li>
                        </ul>
                    </div>
                </li>
                <li class="col-8">起拍价</li>
                <li class="col-9">结束时间</li>
            </ul>

			<#if (p.totalNumberOfElements > 0)>
            <#list p.thisPageElements as e>
			<#assign tempSelledName = "">
			<#if (e.vehicle.selledName)??>
	            <#assign tempSelledName = e.vehicle.selledName>
			    <#if e.vehicle.selledName?starts_with(e.vehicle.vehicleModel)>
			    	 <#assign tempSelledName = e.vehicle.selledName?replace(e.vehicle.vehicleModel, '', 'f')>
			    </#if>
			</#if>
            <ul class="clearfix listtbody">
                <li class="col-1">
                    <div class="listimg">
                        <a target="_blank" href="<@baseUrl.home />/onlineauction/${e.sid}"><img src="<#if e.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("120X90", "${(e.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width: 120px; height: 90px;"></a>
                    </div>
                </li>
                <li class="col-2 listtitlebox">
                    <h3><a target="_blank" href="<@baseUrl.home />/onlineauction/${e.sid}">${(e.vehicle.brand)!} ${(e.vehicle.vehicleModel)!}<#if e.vehicle.sweptVolumeStandard?? && e.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</a></h3>
                    <#if e.vehicle.vehicleDesc?? && (e.vehicle.vehicleDesc?trim?length > 0)>
                      <p title="${(e.vehicle.vehicleDesc)!}"><#if (e.vehicle.vehicleDesc?trim?length > 22)>${(e.vehicle.vehicleDesc?substring(0,22))!}...<#else>${(e.vehicle.vehicleDesc)!}</#if></p>
                    <#else>
                   	  <p>该车暂无描述！</p>
                    </#if>
                   
                    
                    <#if avSids?seq_contains(e.sid)>
	                	<a href="javascript:;" class="addbatch-on" name="batchHref" id="bat-${e.sid}-${e.vehicleSid}">批量出价</a>
					<#else>        
						<a href="javascript:;" class="addbatch" name="batchHref" id="bat-${e.sid}-${e.vehicleSid}">批量出价</a>
					</#if>
                    
                    <#if (favoriteVehicleIds?size > 0)>
  	                	<#if favoriteVehicleIds?seq_contains(e.sid)>
                      	<a href="javascript:;" class="addgz" id="a3-${e.sid}" style="display: none;">收藏</a>
                      	<a href="javascript:;" class="addgz-on" id="a1-${e.sid}">取消收藏</a>
                    	<#else>
                      	<a href="javascript:;" class="addgz" id="a3-${e.sid}">收藏</a>
                      	<a href="javascript:;" style="display: none;" class="addgz-on" id="a1-${e.sid}">取消收藏</a>
                    	</#if>
                    <#else>
                    	<a href="javascript:;" class="addgz" id="a3-${e.sid}">收藏</a>
                      	<a href="javascript:;" style="display: none;" class="addgz-on" id="a1-${e.sid}">取消收藏</a>
                    </#if>
                    <span class="addtipbox"><i class="addtip" id="errtip-${e.sid}"></i></span>
                </li>
                <li class="col-2_5">
                    <#if e.vehicle.certified?? && e.vehicle.certified>
                    <p title="该车经过了200项严酷检测，车辆骨架无损伤，车况为A级。" class="renzheng1">EQS认证</p>
	                </#if>
	                <#if e.vehicle.guaranteed?? && e.vehicle.guaranteed>
	                <p title="该车通过了EQS检测认证且符合购买车辆延保服务的条件。" class="renzheng2">延保服务</p>
	                </#if>
                </li>
                <li class="col-3">${(e.city)!}</li>
                <li class="col-4"><#if e.vehicle.licenseCode?? && (e.vehicle.licenseCode?length gt 1)>${(e.vehicle.licenseCode?substring(0,2))!}<#else>${(e.vehicle.licenseCode)!}</#if></li>
                <li class="col-5">${(e.vehicle.registerLicenseYears?substring(0,4))!}年${(e.vehicle.registerLicenseYears?substring(4))!}月</li>
                <li class="col-6">${(e.vehicle.displayMileage)!}万公里</li>
                <li class="col-7"><#if e.status??><#if e.status == "1">未开始<#elseif e.status == "2">已成交<#elseif e.status == "3">成交确认<#elseif e.status == "4">流拍<#elseif e.status == "5"><span class="color-1">拍卖中</span><#elseif e.status == "6">暂停<#elseif e.status == "7">已下架</#if></#if></li>
                <li class="col-8">
                	<#if priceDisp == "1" || isSp>
                		<span class="money"><strong>${((e.startPrice / 10000)?string("0.00"))!"0.00"}</strong>万元</span>
                	<#else>
                		<span class="money"><strong>&nbsp;</strong>认证商户可见</span>
                	</#if>
                	
                </li>
                <li class="col-9"><span class="color-1">${(e.planEndTime?string('MM-dd HH:mm'))!}</span></li>
            </ul>
            </#list>
            <#else>
            <div class="nonedata">
                <span>很抱歉，未查询到相关车辆，请重新筛选！</span>
            </div>
            </#if>
        </div>
        <@pagination.pagination />
    </div>
</div>

<div class="cartbox" id="cartbox">
    <div class="cartbox-l" id="cartboxpower">
        <p class="cartboxpower">
            <a href="#" class="hide"></a>
        </p>
        <span class="cartboxspan">批量竞价</span>
        <span class="cartboxspan-1" id="batchCount">${mvbCount}</span>
    </div>
    <div class="cartboxlist" id="cartboxlist">
        <ul id="ul-mvb">
        	<#list mvbList as mvb>
			<#assign tempSelledName = "">
			<#if (mvb.vehicle.selledName)??>
	        	<#assign tempSelledName = mvb.vehicle.selledName>
			    <#if mvb.vehicle.selledName?starts_with(mvb.vehicle.vehicleModel)>
			    	 <#assign tempSelledName = mvb.vehicle.selledName?replace(mvb.vehicle.vehicleModel, '', 'f')>
			    </#if>
			</#if>
            <li id="mvbRow-${mvb.sid}">
                <img src="<@baseUrl.image />/${(action.getThumbImgUrl("70X52", "${(mvb.vehicle.firstPhotoUrl)!}"))!}" style="width:70px; height:52px;">
                <div>
                    <h3>${(mvb.vehicle.brand)!} ${(mvb.vehicle.vehicleModel)!}  ${(tempSelledName)!}</h3>
                    <p><#if mvb.vehicle.licenseCode?? && (mvb.vehicle.licenseCode?length gt 1)>${(mvb.vehicle.licenseCode?substring(0,2))!}<#else>${(mvb.vehicle.licenseCode)!}</#if></p>
                </div>
                <a href="javascript:;" class='del' id="del-${mvb.sid}-${mvb.avSid}"> － 删除</a>
            </li>
            </#list>
        </ul>
        <a class="cartboxbtn">批量出价</a>
    </div>
</div>

<div class="tipbox-gg" id="popLayer1">
    <a href="javascript:;" class="tipboxclose" id='tipboxclose'></a>
</div>
<div id="UED_SHUCOVER_V11" class="UED_SHUCOVER_V1 UED_hide" style="opacity: 0.5; display: none;"><iframe src="about:blank" id="UED_SHUCOVER_IFRAME_V11" class="UED_SHUCOVER_IFRAME_V1"></iframe></div>


<#include "/include/footer.ftl">
<script language="javascript" src="<@baseUrl.static />/sell/build/1.00/js/batch.js<@baseUrl.time />"></script>

<script language="javascript" src="<@baseUrl.static />/common/build/1.00/js/jquery.cookie.js"></script>
<script language="javascript" src="<@baseUrl.static />/common/build/1.00/js/fed.guide.js"></script>

<script>
$(function() {
	<#if popValue?? && (popValue == "1")>
		$('#popLayer1').fedGuide('show','head',{left:'50%',top:100,zindex:9999},function(){});
    	$('#UED_SHUCOVER_V11').fedGuide('show','head',{left:'0',top:0,zindex:9998},function(){});
	</#if>
	
	// 隐藏在线客服
	//HideCustomerService();
	
	 $('#tipboxclose').click(function(){
	     $('#popLayer1').fedGuide('close',function(){});
	     $('#UED_SHUCOVER_V11').fedGuide('close',function(){});
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
      } else if(data.redirectUrl){
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
      }else if(data.redirectUrl){
      	window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
      }
    });
  });

  $(".selectboxshow").click(function() {
    $this = $(this);
    if ($this.attr("data-toggle") == "1") {
      $(".selectlist").hide();
      $this.attr("data-toggle", "0");
    } else {
      $(".selectlist").show();
      $this.attr("data-toggle", "1");
    }
  });
  
  $("a[name='batchHref']").each(function(i,element) {
    $this = $(this);
  	var str = this.id.substring(4);
  	var sids = str.split("-");
  	var avSid = sids[0];
  	var vSid = sids[1];
  	
  	$(this).click(function() {
  		<#if !userIdentity??>
  			window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
  			return;
  		</#if>
  		
  		if ($("#bat-" + avSid + "-" + vSid).hasClass("addbatch-on")) {
  			delMvbByAV(vSid, avSid);
  		} else {
  			$.ajax({
  				async: false,
	      		url: "<@baseUrl.home />/online-batchbid/addbatch",
	      		type: "post",
	      		data: {
	        		avId: avSid,
	        		vId: vSid,
	        		count: $("#batchCount").html()
	      		}
	    	}).done(function(data) {
	      		if (data.success) {
	      			var iTotal = $("#batchCount").html();
	      			$("#batchCount").html(parseInt(iTotal) + 1);
					
					$("#bat-" + avSid + "-" + vSid).removeClass("addbatch");
	      			$("#bat-" + avSid + "-" + vSid).addClass("addbatch-on");
	
	      			var sid = data.mvbSid; 
	      			
	      			//Get the thumbImgUrl
	      			var strImgUrl = "";
	      			$.ajax({
	      			  async: false,
				      url: "<@baseUrl.home />/onlineauction/thumbImg",
				      type: "get",
				      data: {
				        spec: "70X52",
				        imgUrl: data.vehicle.firstPhotoUrl
				      }
				    }).done(function(ret) {
				      if (ret.success) {
				      	strImgUrl = ret.imgUrl;
				      }
				    });
	      			var aaa = ""+data.vehicle.licenseCode;
	      			var liTxt = "<li id='mvbRow-" + sid + "'>"
	      					  + "<img src='<@baseUrl.image />/" + strImgUrl + "' style='width:71px; height:52px;'>"
	      					  + "<div><h3>" + data.vehicle.brand + " " + data.vehicle.vehicleModel + " " + data.vehicle.selledName + "</h3>"
	      					  + "<p>" + aaa.substring(0,2) + "</p></div>"
	      					  + "<a href='javascript:;' class='del'  id='del-" + sid + "-" + avSid + "'> － 删除 </a></li>";
	      			
	      			$("#ul-mvb").append(liTxt);
	      			$("#del-" + sid + "-" + avSid).click(function() {
	      				delMvb(sid, avSid);
	      			});
	      		} else {
	      			var iTotal = $("#batchCount").html();
	      			if (parseInt(iTotal) >= 8) {
	      				$("#errtip-" + avSid).html("最多只能添加 8 辆批量出价");
	      				$("#errtip-" + avSid).show();
	      				$("#errtip-" + avSid).fadeOut(2000);
	      			} else if(data.redirectUrl){
	      				window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
	      			}
	      		}
	    	});
  		}
  	
  	});
  	
  });
    
   $(".del").click(function() {
		var sids = this.id.substring(4);
		var sidSet = sids.split("-");
		var sid = sidSet[0];
		var avSid = sidSet[1];
		
		delMvb(sid, avSid);
   });
   
   function delMvb(sid, avSid) {
   	$.ajax({
      url: "<@baseUrl.home />/online-batchbid/delRecord",
      type: "post",
      data: {
        sid: sid
      }
    }).done(function(data) {
      if (data.success) {
        $("#mvbRow-" + sid).hide();
        var iTotal = $("#batchCount").html();
      	$("#batchCount").html(parseInt(iTotal) - 1);

      	$("#bat-" + avSid + "-" + data.vSid).removeClass("addbatch-on");
      	$("#bat-" + avSid + "-" + data.vSid).addClass("addbatch");
      }
    });	
   }
   
  function delMvbByAV(vSid, avSid) {
   	$.ajax({
  		url: "<@baseUrl.home />/online-batchbid/delRecordByAV",
      		type: "post",
      		data: {
        		avId: avSid,
        		vId: vSid
      		}
    	}).done(function(data) {
      		if (data.success) {
      			var sid = data.sid;
      			var iTotal = $("#batchCount").html();
      			$("#batchCount").html(parseInt(iTotal) - 1);
      			$("#mvbRow-" + sid).hide();
				
				$("#bat-" + avSid + "-" + vSid).removeClass("addbatch-on");
      			$("#bat-" + avSid + "-" + vSid).addClass("addbatch");
      		}
    	});
  }

	$(".cartboxbtn").click(function() {
		window.location = "<@baseUrl.home />/online-batchbid/list";
	});
  
});

$(function() {
	var isclick = true;

    $("#cartbox").mouseenter(function(){
  		isclick = false;
	});
	
	$("#cartbox").mouseleave(function(){
		isclick = true;
	});
	
	//按body时隐藏弹出层
    $('html').click(function () {
		if(isclick != false && $("#cartbox").css('right') == '0px')
		{
			$("#cartbox").animate({right:-318},"slow");
			$('.cartboxpower a').css("display","none");
				isclick = true;
		}
    });
    
    
    $('.addbatch').click(function(){
       $("#cartbox").fadeOut('fast',function(){
           $("#cartbox").fadeIn('fast');
       });        //绑定震动目标
    });
    
    $('.listtbody').hover(function(){
        $(this).css('background',"#fffeef");
    },function(){
        $(this).css('background',"#ffffff");
    });
    
})

</script>
</body>
</html>
</#escape>
