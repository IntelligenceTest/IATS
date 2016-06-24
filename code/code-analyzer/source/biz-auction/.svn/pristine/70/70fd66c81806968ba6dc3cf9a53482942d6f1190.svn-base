<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="others" content="汽车街_在线拍">
<title>在线拍_汽车街</title>
</head>
<body class="sell_bg w950">
<#include "/include/header2.ftl">
<link href="http://img.autostreetscdn.com/sell/build/1.00/css/list.css" rel="stylesheet" type="text/css" />
<@layout.nav active = "sync-auction"/>
<style>
.position{position:relative}
.rules{top:15px}
</style>
<div class="position">
  <a class="positionmain" href="<@baseUrl.parentHome />/">首页</a> &gt; <a href="<@baseUrl.home />"><span>竞拍大厅</span></a> &gt; <span>在线拍</span>
  <a href="<@baseUrl.parentHome />/news/details?id=1440" class="rules"  target="_blank" >查看仲裁规则</a>
</div>
<#if topAdv??&&topAdv?size gt 0>
	<div class="main_adv">
		<#list topAdv as detail>
			<a href="${(detail.clickUrl)!"javascript:;"}" onclick="_hmt.push(['_trackEvent', '在线拍-小通栏', 'click', '${detail.name!}']);_traceEvent('在线拍-小通栏', '点击', '${detail.name!}','10','false');" target="_blank"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('950X80','${(detail.adDesign)!}')!}" alt=""></a>
		</#list>
	</div>
</#if>
<div class="listbody-1">
	<img src="http://img.autostreetscdn.com/sell/build/1.00/images/process_bg.png" alt="" class="process_title" />
	<#if recommends??  && recommends?size &gt; 0 > 
	 <div class="hot_recommend">
        <div class="inner">
            <h2 class="h2_tit">热门推荐</h2>
            <div class="slide_wrap" id="hot_recommed_slide">
                <div class="slide_pic">
                   <ul>
                    <#assign m = 1 />
                    <#list recommends as rmd>
                       <#if m % 3 == 1>
                		   <#if m == 1>
                		       <li class="slide_item">
                		   <#else>
                		      </li>
                		      <li class="slide_item">
                		   </#if>
                		 </#if>
                      <#assign m = m + 1 />
                      <#assign tempSelledName = "">
					   <#if (rmd.vehicle.selledName)??>
				       	 <#assign tempSelledName = rmd.vehicle.selledName>
					   	 <#if rmd.vehicle.selledName?starts_with(rmd.vehicle.vehicleModel)>
					  	  <#assign tempSelledName = rmd.vehicle.selledName?replace(rmd.vehicle.vehicleModel, '', 'f')>
					   	 </#if>
					    </#if>
                          <div class="hot_item">
                           <a class="hot_item_pic" target="_blank" title="${(rmd.vehicle.brand)!} ${(rmd.vehicle.vehicleModel)!}<#if (rmd.vehicle.sweptVolumeStandard)?? && rmd.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}" href="<@baseUrl.home />/onlineauction/${(rmd.id)!}"><img src="<#if (rmd.vehicle.firstPhotoUrl)??><@baseUrl.image />/${(action.getThumbImgUrl("100X75", "${(rmd.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width: 100px; height: 75px;"></a>
						   <div class="r_box">
								<h3 class="hot_item_tit" style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;width:112px" ><a  target="_blank" title="${(rmd.vehicle.brand)!} ${(rmd.vehicle.vehicleModel)!}<#if (rmd.vehicle.sweptVolumeStandard)?? && rmd.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}" href="<@baseUrl.home />/onlineauction/${rmd.id}">${(rmd.vehicle.brand)!} ${(rmd.vehicle.vehicleModel)!}<#if (rmd.vehicle.sweptVolumeStandard)?? && rmd.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</a></h3>
								<p class="hot_item_desc" title="${rmd.city}"><#if (rmd.city)?length gt 4>${(rmd.city)?substring(0,4)}<#else>${rmd.city}</#if> | ${((rmd.vehicle.displayMileage)/10000)?string("0.00")!}万公里</p>
								<p class="hot_item_desc">结束时间:${(rmd.planEndTime?string('MM.dd HH:mm'))}</p>
                            </div>
                          </div>
                       </#list>
                      </li>
                    </ul>
                </div>
                <div id="trigger"></div>
                <a href="javascript:void(0)" class="prev_btn slide_btn"></a>
                <a href="javascript:void(0)" class="next_btn slide_btn"></a>
            </div>
        </div>
    </div>
  </#if>

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
                <li><a href="${action.getUrl("dateflag,pageNumber", "1,1")}"<#if dateflag?? && dateflag == 1> class="current"</#if>>竞拍中</a></li>
                <li><a href="${action.getUrl("dateflag,pageNumber", "2,1")}"<#if dateflag?? && dateflag == 2> class="current"</#if>>等待竞拍</a></li>
            </ul>
            <div class="filter_info">
                   <div class="times">
                                            第<span>${auctionCount}</span>场</div>
                        <div class="hot_filter">
                            <div class="location">
                                <div class="location_hd"><#if city??>${city}<#else>全国</#if></div>
                                <div class="location_bd">
                                    <ul class="location_list">
                                        <li><a href="${action.getUrl("city,pageNumber", ",1")}"<#if !city?? || city == ""> class="curr"</#if>>全国</a></li>
                                        <#list action.cityList as cityItem>
								            <#if cityItem["act"]>
								            <li><a href="${action.getUrl('city,pageNumber', '${cityItem[\'city\']},1')}" <#if city?? && city == cityItem["city"]> class="on curr"<#else>class="curr"</#if>>
								               <#if cityItem["city"]?length gt 6>${(cityItem["city"])?substring(0,6)}<#else>${cityItem["city"]}</#if></a></li>
								            <#else>
								            <li><a href="${action.getUrl('city,pageNumber', '${cityItem[\'city\']},1')}"<#if city?? && city == cityItem["city"]> class="curr"</#if>>
								               <#if cityItem["city"]?length gt 6>${(cityItem["city"])?substring(0,6)}<#else>${cityItem["city"]}</#if></a></li>
								            </#if>	                
								         </#list>
                                    </ul>
                                </div>
                            </div>
                        </div>
                         <label class="is_hot_control" for="is_hot" id="isRecommend">
                             <#if recommend>
                             <a href="${action.getUrl("recommend,pageNumber", "false,1")}">
                               <strong class="span_checkbox hot_checked"></strong>热门推荐</a>
                             </#if>
                              <#if !recommend>
                              <a href="${action.getUrl("recommend,pageNumber", "true,1")}">
                               <strong class="span_checkbox"></strong>热门推荐</a>
                               </#if>
                              <input id="is_hot" type="hidden">
                           </label>
                </div>
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
                        <a target="_blank" href="<@baseUrl.home />/onlineauction/${e.id}"><img src="<#if e.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("120X90", "${(e.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" style="width: 120px; height: 90px;"></a>
                    </div>
                </li>
                <li class="col-2 listtitlebox">
                    <#assign tempTitle = ((e.vehicle.brand)!"")+((e.vehicle.vehicleModel)!"")>
                    <#if e.vehicle.sweptVolumeStandard?? && e.vehicle.sweptVolumeStandard?starts_with("欧")>
                    	<#assign tempTitle = (tempTitle!"")+"(进口)"+(tempSelledName!"")>
                   	<#else>
                   		<#assign tempTitle = (tempTitle!"")+(tempSelledName!"")>
                    </#if>
                    <h3><#if (e.recommend)?? && e.recommend><strong class="recommond_icon">推荐</strong></#if><a target="_blank" title="${(tempTitle)!}" href="<@baseUrl.home />/onlineauction/${e.id}">
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
                    <p><span>${(e.city)!}</span>|<span><#if e.vehicle.licenseCode?? && (e.vehicle.licenseCode?length gt 1)>${(e.vehicle.licenseCode?substring(0,2))!}<#else>${(e.vehicle.licenseCode)!}</#if></span>|<span>${(e.vehicle.registerLicenseYears?substring(0,4))!}年${(e.vehicle.registerLicenseYears?substring(4))!}月上牌</span>
                    <#if (e.vehicle.displayMileage)??>
                    	|<span>${((e.vehicle.displayMileage)/10000)?string("0.00")}万公里</span>
                    </#if>
                    </p>
                     <#if avSids?seq_contains(e.id)>
	                	<a href="javascript:;" class="addbatch-on" name="batchHref" id="bat-${e.id}-${e.vehicleId}">批量出价</a>
					<#else>        
						<a href="javascript:;" class="addbatch" name="batchHref" id="bat-${e.id}-${e.vehicleId}">批量出价</a>
					</#if>
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
	                    		<p>开始时间：${(e.planStartTime?string('MM.dd HH:mm'))!}</p>
	                    		<p>结束时间：${(e.planEndTime?string('MM.dd HH:mm'))!}</p>
	                    	<#elseif e.status == 5>
	                    		<p>结束时间：${(e.planEndTime?string('MM.dd HH:mm'))!}</p>
	                    	</#if>
	                    </#if>
					</p>
				</li>
                <li class="col-9">
                	<#if priceDisp == "1" || isSp>
                		<span class="money"><strong>
                		<#if e.maxBidPrice &gt; 0>
	                		${((e.maxBidPrice / 10000)?string("0.00"))!"0.00"}
	                	<#else>
	                		${((e.startPrice / 10000)?string("0.00"))!"0.00"}
                		</#if>
	                	</strong>万元</span>
                	<#else>
                		<span class="color-1">价格隐藏</span>
                		<p>仅认证商户可见</p>
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
<#include "/include/footer.ftl">
<div class="cartbox" id="cartbox">
    <div class="cartbox-l hide" id="cartboxpower">
        <ul id="rightMenuSell">
            <li class="li_1">
                <span class="cartboxspan">批量竞价</span>
                <span class="cartboxspan-1" id="batchCount">${mvbCount}</span>
            </li>
            <li>
                <span class="img1"></span>
                <div class="ewMoudle_1 ewMoudle">
                <div class="ewMain">
                    <img src="http://img.autostreetscdn.com/common/build/2.00/images/rightside/ewmkf.jpg" width="126" height="126"><p>微信扫一扫</p><p>享受一对一服务</p><div class="ewMoudle_1_phone"><img src="http://img.autostreetscdn.com/common/build/2.00/images/rightside/greenphone_icon.png"><span>400-821-8889</span></div></div></div></li>
            <li>
                <span class="img2"></span>
                <div class="ewMoudle_2 ewMoudle"><div class="ewMain"><img src="http://img.autostreetscdn.com/common/build/2.00/images/rightside/ewmapp.jpg" width="114" height="114"><p>扫一扫</p><p>下载手机汽车街</p></div></div>
            </li>
            <li>
                <span class="img3"></span>
                <div class="ewMoudle_2 ewMoudle"><div class="ewMain"><img src="http://img.autostreetscdn.com/common/build/2.00/images/rightside/ewmgzh.jpg" width="120" height="120"><p>微信扫一扫</p><p>汽车街官方微信</p></div></div>
            </li>
            <li onclick="gotoTop()"><span class="img4"></span>
            </li>
        </ul>
    </div>
    <div class="cartboxlist" id="cartboxlist">
        <div class="cartboxlist-close">
            <span class="cartboxlist-close-name">批量竞价</span>
            <span class="cartboxlist-close-btn"></span>
        </div>
        <ul id="ul-mvb">
        	<#list mvbList as mvb>
	        	<#if (mvb.vehicle)??>
			<#assign tempSelledName = "">
			<#if (mvb.vehicle.selledName)??>
	        	<#assign tempSelledName = mvb.vehicle.selledName>
			    <#if mvb.vehicle.selledName?starts_with(mvb.vehicle.vehicleModel)>
			    	 <#assign tempSelledName = mvb.vehicle.selledName?replace(mvb.vehicle.vehicleModel, '', 'f')>
			    </#if>
			</#if>
            <li id="mvbRow-${mvb.id}">
                <img src="<@baseUrl.image />/${(action.getThumbImgUrl("70X52", "${(mvb.vehicle.firstPhotoUrl)!}"))!}" style="width:70px; height:52px;">
                <div>
                    <h3>${(mvb.vehicle.brand)!} ${(mvb.vehicle.vehicleModel)!}  ${(tempSelledName)!}</h3>
		                    <p>
		                    	<#if (mvb.vehicle.licenseCode)??>
			                    	<#if mvb.vehicle.licenseCode?? && (mvb.vehicle.licenseCode?length gt 1)>
				                    	${(mvb.vehicle.licenseCode?substring(0,2))!}
				                    <#else>
				                    	${(mvb.vehicle.licenseCode)!}
				                    </#if>	
		                    	</#if>
		                    </p>
                </div>
                <a href="javascript:;" class='del' id="del-${mvb.id}-${mvb.avId}"> － 删除</a>
            </li>
	        	</#if>
            </#list>
        </ul>
        <a class="cartboxbtn" id='cartboxbtn'>批量出价</a>
    </div>
</div>
<script language="javascript" src="http://img.autostreetscdn.com/fed/build/2.00/js/slide.js"></script>
<script language="javascript" src="http://img.autostreetscdn.com/sell/build/1.00/js/batch.js"></script>
<script>
$(function(){
    HideCustomerService();
    
	$('.moreopen').click(function(){
		$(this).hide()
		$('.area').css('height','auto')
		var _width = $('.area').height()
		$('.area_title').css('height',_width)
	})
    var isclick = true;
    $("#cartbox,.addbatch").mouseenter(function(){
		  isclick = false;
    });
    $("#cartbox,.addbatch").mouseleave(function(){
		  isclick = true;
    });
	//按body时隐藏弹出层
    $('html').click(function () {
            //alert($("#cartbox").css('right'));
			if(isclick != false && $("#cartbox").css('right') == '0px')
			{
           	 $("#cartbox").animate({right:-318},"slow");
           	 $('.cartboxpower a').css("display","none");
           	 
           	 $('#rightMenuSell').animate({right:0},"slow");
                setTimeout(function(){
                    $('.cartbox-l').addClass('hide');
                },600);
                
			 isclick = true;
			}
    });
    $('.addbatch').click(function(){
       $("#cartbox").fadeOut('fast',function(){
           $("#cartbox").fadeIn('fast');
       });        //绑定震动目标
    });
     
  //热门推荐
    $('#isRecommend').click(function() {
        var $self = $('#isRecommend').find('.span_checkbox');
        if ($self.hasClass('hot_checked')) {
            $self.removeClass('hot_checked');
        } else {
            $self.addClass('hot_checked');
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
	
	      			var sid = data.extras.mvbSid; 
	      			
	      			//Get the thumbImgUrl
	      			var strImgUrl = "";
	      			$.ajax({
	      			  async: false,
				      url: "<@baseUrl.home />/onlineauction/thumbImg",
				      type: "get",
				      data: {
				        spec: "70X52",
				        imgUrl: data.extras.vehicle.firstPhotoUrl
				      }
				    }).done(function(ret) {
				      if (ret.success) {
				      	strImgUrl = ret.data;
				      }
				    });
	      			var abcd = ""+data.extras.vehicle.licenseCode;
	      			var liTxt = "<li id='mvbRow-" + sid + "'>"
	      					  + "<img src='<@baseUrl.image />/" + strImgUrl + "' style='width:71px; height:52px;'>"
	      					  + "<div><h3>" + data.extras.vehicle.brand + " " + data.extras.vehicle.vehicleModel + " " + data.extras.vehicle.selledName + "</h3>"
	      					  + "<p>" + abcd.substring(0,2) + "</p></div>"
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

      	$("#bat-" + avSid + "-" + data.extras.vSid).removeClass("addbatch-on");
      	$("#bat-" + avSid + "-" + data.extras.vSid).addClass("addbatch");
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
      			var sid = data.extras.sid;
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
        }else{
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
        }else{
            window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
        }
    });
});
});

</script>
</body>
</html>
</#escape>
