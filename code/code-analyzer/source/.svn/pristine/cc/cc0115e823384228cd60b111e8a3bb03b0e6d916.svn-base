<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="others" content="汽车街_即时拍">
<title>即时拍_汽车街</title>
<link href="<@baseUrl.static />/common/build/2.00/css/b.css" rel="stylesheet" type="text/css" />
<link href="<@baseUrl.static />/sell/build/1.00/css/list.css<@baseUrl.time />" rel="stylesheet" type="text/css">
</head>
<body class="sell_bg w950">
<#include "/include/header2.ftl">
<@layout.nav active = "sync-auction"/>
<div class="position">
  <a class="positionmain" href="<@baseUrl.parentHome />/">首页</a> &gt; <a href="<@baseUrl.home />"><span>竞拍大厅</span></a> &gt; <span>24小时拍</span>
</div>
<#if topAdv??&&topAdv?size gt 0>
	<div class="main_adv">
		<#list topAdv as detail>
			<a href="${(detail.clickUrl)!"javascript:;"}" onclick="_hmt.push(['_trackEvent', '24小时拍-小通栏', 'click', '${detail.name!}']);_traceEvent('24小时拍-小通栏', '点击', '${detail.name!}','10','false');" target="_blank"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('950X80','${(detail.adDesign)!}')!}" alt=""></a>
		</#list>
	</div>
</#if>
<div class="listbody-1">
	<img src="<@baseUrl.static />/sell/build/1.00/images/process_bg.png" alt="" class="process_title" />
    <div class="listbodybox">
        <div class="selecetlist selecetlist-1">
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
        <dl>
        		<dt class="area_title">地区</dt>
        		<dd>
        			<ul class="area">
	                <li><a href="${action.getUrl("city,pageNumber", ",1")}"<#if !city?? || city == ""> class="on"</#if>>全部</a></li>
	                <#list action.cityList as cityItem>
	                <#if cityItem["act"]>
	                <li><a href="${action.getUrl('city,pageNumber', '${cityItem[\'city\']},1')}" <#if city?? && city == cityItem["city"]> class="on active"<#else>class="active"</#if>>${cityItem["city"]}</a></li>
	                <#else>
	                <li><a href="${action.getUrl('city,pageNumber', '${cityItem[\'city\']},1')}"<#if city?? && city == cityItem["city"]> class="on"</#if>>${cityItem["city"]}</a></li>
	                </#if>	                
	                </#list>
	            </ul>
        		</dd>
        		<#if (action.cityList?size) gt 7>
        			<a href="javascript:;" class="moreopen">更多 &gt;&gt;</a>
        		</#if>
        </dl>
        </div>
    </div>
        <div>
            <div class="tabbox">
            <ul class="clearfix">
                <li><a href="${action.getUrl("dateflag,pageNumber", "0,1")}"<#if !dateflag?? || dateflag == 0> class="current"</#if>>全部</a></li>
                <li><a href="${action.getUrl("dateflag,pageNumber", "1,1")}"<#if dateflag?? && dateflag == 1> class="current"</#if>>竞拍中</a></li>
                <li><a href="${action.getUrl("dateflag,pageNumber", "2,1")}"<#if dateflag?? && dateflag == 2> class="current"</#if>>等待竞拍</a></li>
            </ul>
            </div>
        </div>
        <div class="listbodybox onlinelist">
        <div>
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
                        <a target="_blank" href="<@baseUrl.home />/onceBidAuction/${e.id}"><img src="<#if e.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("120X90", "${(e.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width: 120px; height: 90px;"></a>
                    </div>
                </li>
                <li class="col-2 listtitlebox">
                    <#assign tempTitle = ((e.vehicle.brand)!"")+((e.vehicle.vehicleModel)!"")>
                    <#if e.vehicle.sweptVolumeStandard?? && e.vehicle.sweptVolumeStandard?starts_with("欧")>
                    	<#assign tempTitle = (tempTitle!"")+"(进口)"+(tempSelledName!"")>
                   	<#else>
                   		<#assign tempTitle = (tempTitle!"")+(tempSelledName!"")>
                    </#if>
                    <h3><a target="_blank" title="${(tempTitle)!}" href="<@baseUrl.home />/onceBidAuction/${e.id}">
                    <#if (tempTitle)?length &gt; 20>
	                	${(tempTitle?substring(0,20))!}...
	                </#if>
	                <#if (tempTitle)?length &lt;=20>
	                	${(tempTitle)!}
	                </#if>
	                </a>
	                <#if (e.activity)?? && e.activity>
	                	<i title="${(e.activityTitle)!}">活动</i>
	                </#if>
	                </h3>
                    <p><span>${(e.city)!}</span>|<span><#if e.vehicle.licenseCode?? && (e.vehicle.licenseCode?length gt 1)>${(e.vehicle.licenseCode?substring(0,2))!}<#else>${(e.vehicle.licenseCode)!}</#if></span>|<span>${(e.vehicle.registerLicenseYears?substring(0,4))!}年${(e.vehicle.registerLicenseYears?substring(4))!}月</span>|<span>${((e.vehicle.displayMileage)/10000)?default(0.00)?string("0.00")!}万公里</span></p>
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
                    <span class="addtipbox"><i class="addtip" id="errtip-${e.id}"></i></span>
                </li>
                <li class="col-2_5">
                    <#if e.vehicle.certified?? && e.vehicle.certified>
                    <p title="该车经过了200项严酷检测，车辆骨架无损伤，车况为A级。" class="renzheng1">EQS认证</p>
	                </#if>
	                <#if e.vehicle.guaranteed?? && e.vehicle.guaranteed>
	                <p title="该车通过了EQS检测认证且符合购买车辆延保服务的条件。" class="renzheng2">延保服务</p>
	                </#if>
                </li>
                <li class="col-7">
	                <span class="color-1">
		                <#if e.status??>
		                	<#if e.status == 1>
	                			<span class="color-2">等待竞拍</span>
	                		<#elseif e.status == 5>
	                			<span class="color-1">竞拍中</span>
	                		<#else>
	                			<span class="color-3">已结束</span>
	                		</#if>
                		</#if>
					</span>
					<p>
	                    <#if e.status??>
	                    	<#if e.status == 1>
	                    		<p>开始时间：${(e.planStartTime?string('MM.dd HH:mm'))}</p>
	                    		<p>结束时间：${(e.planEndTime?string('MM.dd HH:mm'))}</p>
	                    	<#elseif e.status == 5>
	                    		<p>结束时间：${(e.planEndTime?string('MM.dd HH:mm'))}</p>
	                    	</#if>
	                    </#if>
					</p>
				</li>
                <li class="col-9">
                	<#if priceDisp == "1">
                	  <#if e.status ==1>
                	       <span class="grey_state">尚未开始</span>
                	  <#elseif e.status == 5>
                	      <#if (e.curBidPrice)??>
							<span class="money"><strong>${(e.curBidPrice/10000)!?string("#.##")}</strong>万元</span><p class="color-4">您的出价</p>
						  <#else>
						    <span class="make_offer" index="${(e.id)!}">出价</span>
                            <blockquote class="price_area">
                            <div class="offer_price">
                            	<input type="text">元
                            </div>
                              <p class="">出价须为100的整数倍</p>
                            <span class="make_offer2" index="${(e.id)!}">出价</span>
                            </blockquote>	   
						  </#if>
					  <#else>
                	  		<span class="grey_state">已结束</span>
                	  	   <#if (e.curBidPrice)??>
                	  		 <span class="money">${(e.curBidPrice/10000)!?string("#.##")}万元</span>
                	  		 <p class="color-4">您的出价</p>
                	  	   </#if>
                	  </#if>
                	<#else>
                		<span class="color-3">仅认证商户可出价</span>
                		<span class="color-3 line" onclick="javascript:location.href='<@baseUrl.parentHome />/dealerapply/auctionindex';">申请竞拍认证</span>
                	</#if>
                 </li>
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
<input type="hidden" id="selAvId">
<div class="UED_hide" id="friendly_tip">
    <div class="tip-offset">
        <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
        <div class="friendly_tip">
            <h3>友情提示</h3>
            <p>即时拍只能出价一次，请确认您的出价</p>
            <p class="your_price">您的出价<span>26.75</span>万元</p>
        </div>
        <div class="friendly_btn">
            <a href="javascript:;" class="confirm" >确认出价</a>
            <a href="javascript:;" class="cancel" onclick="$.LAYER.close();">取消</a>
        </div>
    </div>
</div>

<#include "/include/footer.ftl">
<script language="javascript" src="http://img.autostreetscdn.com/sell/build/1.00/js/batch.js"></script>
<script>
$(function(){
	$('.moreopen').click(function(){
		$(this).hide()
		$('.area').css('height','auto')
		var _width = $('.area').height()
		$('.area_title').css('height',_width)
	})
    var isclick = true;
	//按body时隐藏弹出层
    $('html').click(function () {
            //alert($("#cartbox").css('right'));
			if(isclick != false && $("#cartbox").css('right') == '0px')
			{
           	 $("#cartbox").animate({right:-318},"slow");
           	 $('.cartboxpower a').css("display","none");
			 isclick = true;
			}
    });
    
    $('.listtbody').hover(function(){
        $(this).css('background',"#fffeef");
    },function(){
        $(this).css('background',"#ffffff");
    });

    if($("#otherCarLogo li").hasClass("on")){
        $("#otherCarLogo").show()
    };

    if($("#otherCity li a").hasClass("on")){
        $("#otherCity").show()
    };
    
	$(".cartboxbtn").click(function() {
		window.location = "<@baseUrl.home />/online-batchbid/list";
	});

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
	        } else {
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
	        } else {
	            window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
	        }
	    });
	});
	
	/*出价出错*/
    $('.make_offer').click(function(){
        $('.listtbody .price_area').hide()
        $("#selAvId").val($(this).attr("index"));
        $(this).next('.price_area').show()
    });
    
    var _val;
    var _index;
    $('.make_offer2').click(function(){
       $("#selAvId").val($(this).attr("index"));
        _val = $(this).parent().find('.offer_price').children('input').val()
        if( _val%100 != 0 || _val == '' || _val == 0){
            $(this).prev().addClass('error')
            return false
        }else{
            $(this).prev().removeClass('error')
            jQuery.LAYER.show({id:'friendly_tip',overlay:{opacity:0.5}});
            $('.your_price span').text(_val/10000)
            var _t = $(this).parent().parent().parent()
            _index = $('.listtbody').index(_t)
        }
    });
    
    $('.confirm').click(function(){
       var avId = $("#selAvId").val();
        $.ajax({
            url: "<@baseUrl.home />/onceBidAuction/bid",
            type: "post",
            data: {avId  : avId,
                   bidAmt: _val}
        }).done(function (data) {
         	 if (!data.success) {
		    	if(data.msg){
		    		alert(data.msg);
		    		location.reload();
		    	}
			 }
        });
        $('.price_area').hide()
        var html = '<span class="money"><strong>'+_val/10000+'</strong>万元</span><p class="color-4">您的出价</p>';
        $('.listtbody').eq(_index).find('.make_offer').hide()
        $('.listtbody').eq(_index).find('.col-9').append(html)
        $.LAYER.close();    
    });
    
    $('.cancel,.tipclose').click(function(){
        $('.listtbody').eq(_index).find('.make_offer').show()
        $('.listtbody').eq(_index).find('.price_area').hide()
        $.LAYER.close()
    });
});

</script>
</body>
</html>
</#escape>
