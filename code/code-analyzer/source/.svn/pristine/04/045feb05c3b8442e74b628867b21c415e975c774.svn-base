<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit">
<meta name="keywords" content="汽车,汽车街,二手车,二手车拍卖,汽车图片,汽车询价,经销商,新车,宝马,置换,新车置换,汽车之家" />
<meta name="description" content="汽车街为您提供最新汽车报价，汽车图片，汽车价格大全，优质二手车展厅，二手车拍卖、免费上门评估、检测、置换" />
<meta name="others" content="汽车街_二手车展厅">
<title>二手车展厅_汽车街</title>


<link href="<@baseUrl.static />/common/build/2.00/css/used_car_list.css<@baseUrl.time />" rel="stylesheet" type="text/css" />

</head>

<body>
<#include "/include/header2.ftl">
<@layout.nav active = "buy-now" />

<input type="hidden" id="province" value="${(province)!}">
<input type="hidden" id="city" value="${(city)!}">

<div class="main clearfix">
	<!-- Start of Left -->
	<div class="left">
		<#if (brand?? && brand != "") || (city?? && city != "") || (price?? && price > 0) || (minPrice?? && minPrice > 0) || (maxPrice?? && maxPrice > 0) || (mile?? && mile > 0) || (age?? && age > 0)>
		<div class="left-selected clearfix" style='display:block;'>
			<div class="title">您已选择<a href="<@baseUrl.home />/no-haggle" class="clear-selected" id="clearSelected">清除筛选条件</a></div>
			<ul id="carSelected">
				<#if brand?? && brand != "">
					<li id="carBrand1">${brand}<a href="${action.getUrl("brand,pageNumber", ",1")}">X</a></li>
				</#if>
				<#if city?? && city != "">
					<li id="carCity1">${city}<a href="${action.getUrl("pro,city,pageNumber", ",,1")}">X</a></li>
				</#if>
				<#if (price?? && price > 0)>
					<li id="carPrice1">${action.paramName(1,price)}<a href="${action.getUrl("price,pageNumber", "0,1")}">X</a></li>
				<#else>
					<#if (minPrice?? && minPrice > 0) && (maxPrice?? && maxPrice > 0)>
						<li id="carPrice1">${minPrice}-${maxPrice}万<a href="${action.getUrl("price,min,max,pageNumber", "0,,,1")}">X</a></li>
					</#if>
				</#if>
				<#if (age?? && age > 0)>
					<li id="carYears1">${action.paramName(2,age)}<a href="${action.getUrl("age,pageNumber", "0,1")}">X</a></li>
				</#if>
				<#if (mile?? && mile > 0)>
					<li id="carMile1">${action.paramName(3,mile)}<a href="${action.getUrl("mile,pageNumber", "0,1")}">X</a></li>
				</#if>
			</ul>
		</div>
		</#if>
		
		<div class="left-option">
			<div class="content newcarlist_brand">
				<div class="title">品牌</div>
                <a href="javascript:void 0;" id="newcarlist_moreBrand">更多</a>
				<ul class="clearfix" id="carBrand">
					<#list brandList as param>
					<li>
						<a href="${action.getUrl("brand,pageNumber", "${param.name},1")}" <#if brand?? && brand?string == param.name> class="selected"</#if> onClick="_traceEvent('搜索按钮', '点击', '${(param.name)!},${(city)!},${(price)!},${(age)!},${(mile)!}','2','false');">
							<#if param.name == '沃尔沃'><span class="zw_li">${param.name}<span class="zw_sicon"></span></span><#else><span>${param.name}</span></#if>
                        </a>
                    </li>
                    </#list>
				</ul>
                <div class="newcarlist_brand_all">
                    <div class="title"><span>所有品牌</span></div>
                    <div class="newcarlist_brand_all_left">
                        <#assign firstPinyin = "">
                        <#list brandList as brand>
                            <#if firstPinyin != brand.firstPinyin>
                                <#if firstPinyin != ""> 
                                    </dd>
                                    </dl>
                                </#if>
                                <#assign firstPinyin = brand.firstPinyin>
                                <dl class="clearfix">
                                <dt>${(brand.firstPinyin)!}</dt>
                                <dd>
                                <a href="${action.getUrl("brand,pageNumber", "${brand.name},1")}">
                                    <#if brand.name == '沃尔沃'><span class="zw_li">${brand.name}<span class="zw_sicon"></span></span><#else><span>${(brand.name)!}</span></#if>
                                </a>
                            <#else>
                                <a href="${action.getUrl("brand,pageNumber", "${brand.name},1")}">
                                    <#if brand.name == '沃尔沃'><span class="zw_li">${brand.name}<span class="zw_sicon"></span></span><#else><span>${(brand.name)!}</span></#if>
                                </a>
                            </#if>
                        </#list>
                    </div>
                    <div class="newcarlist_brand_all_right">
                    </div>
                </div>
                <span class="cover"></span>
			</div>
            <hr id="line1" />

			<div class="content clearfix">
				<div class="title">价格</div>
				<ul id="carPrice">
                    <#list action.paramList(1) as param>
						<li>
                      		<a href="${action.getUrl("price,min,max,pageNumber", "${param.key},,,1")}" <#if price?? && price?string == param.key> class="selected"</#if> onClick="_traceEvent('搜索按钮', '点击', '${(brand)!},${(city)!},${(param.key)!},${(age)!},${(mile)!}','2','false');">${param.value}</a>
                      	</li>
                    </#list>
				</ul>
				<div class="priceRegion">
					<input type="text" id="priceStart" maxlength="4" value="<#if minPrice?? && (minPrice > 0)>${minPrice}</#if>"/>
					<span>至</span>
					<input type="text" id="priceEnd" maxlength="4" value="<#if maxPrice?? && (maxPrice > 0)>${maxPrice}</#if>" />
					<span>万</span>
					<img src="<@baseUrl.static />/common/build/2.00/images/used_car_list/search.jpg" id="priceSearch" />
				</div>
			</div>
			<hr id="Hr1" />
			
			<div class="content clearfix" id="Div2">
				<div class="title">表显里程</div>
				<ul id="carMile">
					<#list action.paramList(3) as param>
                    	<li>
							<a href="${action.getUrl("mile,pageNumber", "${param.key},1")}" <#if mile?? && mile?string == param.key> class="selected"</#if> onClick="_traceEvent('搜索按钮', '点击', '${(brand)!},${(city)!},${(price)!},${(age)!},${(param.key)!}','2','false');">${param.value}</a>
						</li>
                    </#list>
				</ul>
			</div>
			<hr id="Hr2" />
			
			<div class="content clearfix" id="Div3">
				<div class="title">车龄</div>
				<ul id="carYears">
				<#list action.paramList(2) as param>
					<li>
						<a href="${action.getUrl("age,pageNumber", "${param.key},1")}" <#if age?? && age?string == param.key> class="selected"</#if> onClick="_traceEvent('搜索按钮', '点击', '${(brand)!},${(city)!},${(price)!},${(param.key)!},${(mile)!}','2','false');">${param.value}</a>
					</li>
				</#list>
				</ul>
			</div>
		</div>
		 <#--广告添加-->
            <#if topAdDetails??&&topAdDetails?size gt 0>
            	<ul class="adv_list">
            		<#list topAdDetails as detail>
	               	 	<li><a href="${(detail.clickUrl)!"javascript:;"}" onclick="_hmt.push(['_trackEvent', '二手车展厅首页左侧列表上', 'click', '${detail.name!}']);_traceEvent('二手车展厅首页左侧列表上', '点击', '${detail.name!}','10','false');" target="_blank"><img src="<@baseUrl.image/>/${action.getAdPic('${(detail.adDesign)!}','190*114')!}"></a></li>
	                </#list>
            	</ul>
            </#if>
            <#if middleAdDetails??&&middleAdDetails?size gt 0>
            	<ul class="adv_list">
            		<#list middleAdDetails as detail>
	               	 	<li><a href="${(detail.clickUrl)!"javascript:;"}" onclick="_hmt.push(['_trackEvent', '二手车展厅首页左侧列表中', 'click', '${detail.name!}']);_traceEvent('二手车展厅首页左侧列表中', '点击', '${detail.name!}','10','false');" target="_blank"><img src="<@baseUrl.image/>/${action.getAdPic('${(detail.adDesign)!}','190*114')!}"></a></li>
	                </#list>
            	</ul>
            </#if>
            <#if bottomAdDetails??&&bottomAdDetails?size gt 0>
            	<ul class="adv_list">
            		<#list bottomAdDetails as detail>
	               	 	<li><a href="${(detail.clickUrl)!"javascript:;"}" onclick="_hmt.push(['_trackEvent', '二手车展厅首页左侧列表下', 'click', '${detail.name!}']);_traceEvent('二手车展厅首页左侧列表下', '点击', '${detail.name!}','10','false');" target="_blank"><img src="<@baseUrl.image/>/${action.getAdPic('${(detail.adDesign)!}','190*114')!}"></a></li>
	                </#list>
            	</ul>
            </#if>
             <#--广告添加end;-->
	</div>
    <!-- End of Left -->    

	<!-- Start of Right -->
	<div class="right">
		<div class="newcarlist_top">
			<div class="right-top-newcity newcarlist_top_city">
				<div class="newcarlist_top_city_title">
					<img src="<@baseUrl.static />/common/build/2.00/images/used_car_list/location.jpg" /><span>所在城市</span>
				</div>
				<div class="newcity-list newcarlist_top_city" id="newcitySel">
				<#if province?? && city??>
					<#if province == city> 
					<span id="newCitySpan">${(province)!}</span>
					<#else>
					<span id="newCitySpan">${(province)!}${(city)!}</span>
					</#if>
				<#else>
					<span id="newCitySpan">全国</span>
				</#if>
					<img src="<@baseUrl.static />/used_car/build/2.00/images/down.png" width="11" height="6" alt="" id="newcityClick" />
				</div>
				
				<div id="newCityList" class="newcarlist_top_city">
					<div class="newcity-top">
						<ul id="TopUl">
							<li id="TopUlS" class="selected"><span><#if province?? && province != "">${(province)!}<#else>全国</#if></span><img src="<@baseUrl.static />/new_shop/build/2.00/images/toDown.png" width="9" height="5" alt=""/></li>
			                <li id="TopUlC"><span><#if city?? && province?? && province != city>${(city)!}</#if></span><img src="<@baseUrl.static />/new_shop/build/2.00/images/toDown.png" alt=""/></li>
			                <li id="TopUlClose"><a href="javascript:void 0;" >关闭</a></li>
						</ul>
					</div>
					<ul class="newcity-option" id="newCityS">
						<li><span fullName="全国">全国</span></li>
						<#list provinceList as province>
							<li><span fullName="${(province)!}">${(province)!}</span></li>
						</#list>
					</ul>
					<ul class="newcity-option" id="newCityC"></ul>
				</div>
			</div>
			<p class="newcarlist_top-tlp">为您查找到<strong>${(count)!}</strong>辆相关二手车</p>
		</div>
		
		<div class="right-top color_333 bgcolf5">
			<div class="newcarlist_top_price">
				<div class="priStyle">
					<#if sortBy?? && sortBy == 'price'>
						<#if sort == 'asc'>
							<span>价格从低到高</span>
						<#else>
							<span>价格从高到低</span>
						</#if>
                    <#elseif sortBy == 'age'>
                        <#if sort == 'asc'>
                            <span>车龄从低到高</span>
                        <#else>
                            <span>车龄从高到低</span>
                        </#if>
                    <#elseif sortBy == 'mileage'>
                        <#if sort == 'asc'>
                            <span>里程从低到高</span>
                        <#else>
                            <span>里程从高到低</span>
                        </#if>
					<#else>
						<span>默认排序</span>
					</#if>
					<img src="<@baseUrl.static />/common/build/2.00/images/used_car_list/down2.png" alt="" />
					<input type="hidden" id="priceSort" value="" />
				</div>
				<div class="priStyle-list">
					<div class="priStyle-list-li"><a href="${action.getUrl("sb,s", "selltime,desc")}">默认排序</a></div>
					<div class="priStyle-list-li"><a href="${action.getUrl("sb,s", "price,asc")}">价格从低到高</a></div>
	                <div class="priStyle-list-li"><a href="${action.getUrl("sb,s", "price,desc")}">价格从高到低</a></div>
                    <div class="priStyle-list-li"><a href="${action.getUrl("sb,s", "age,asc")}">车龄从低到高</a></div>
                    <div class="priStyle-list-li"><a href="${action.getUrl("sb,s", "age,desc")}">车龄从高到低</a></div>
                    <div class="priStyle-list-li"><a href="${action.getUrl("sb,s", "mileage,asc")}">里程从低到高</a></div>
                    <div class="priStyle-list-li"><a href="${action.getUrl("sb,s", "mileage,desc")}">里程从高到低</a></div>
	            </div>
			</div>
			<div class="newcarlist_gift">
				<div id="giftBag">
					<#if cert?? && cert == 1>
						<span class="giftBag_ok selected"></span>
					<#else>
						<span class="giftBag_ok"></span>
					</#if>
				</div>
				<label for="giftBag" class="giftBag_label">汽车街检测认证</label>
			</div>
			<span class="newcarlist_carnum_label">每页显示</span>
			<div class="newcarlist_carnum">
				<div class="carnStyle">
					<span>${(pageSize)!}辆</span>
					<img src="<@baseUrl.static />/common/build/2.00/images/used_car_list/down2.png" alt="" />
					<input type="hidden" id="carSort" value="${(pageSize)!}辆" />
				</div>
				<div class="carnStyle-list">
					<div class="carnStyle-list-li"><a href="${action.getUrl("ps,pageNumber", "30,1")}">30辆</a></div>
					<div class="carnStyle-list-li"><a href="${action.getUrl("ps,pageNumber", "60,1")}">60辆</a></div>
					<div class="carnStyle-list-li"><a href="${action.getUrl("ps,pageNumber", "90,1")}">90辆</a></div>
                </div>
            </div> 
			<a href="${action.getUrl("d", "list")}" class="newcarlist_letterlist selected"></a>
			<a href="${action.getUrl("d", "view")}" class="newcarlist_picturelist"></a>
			<div class="newcarlist_pageNo">
				<#if p.pageNumber ==1>
					<a href="#" class="newcarlist_pageNo_ablock"><span class="newcarlist_pageNo_left limit"></span></a>
				<#else>
					<a href="#" class="newcarlist_pageNo_ablock"><span class="newcarlist_pageNo_left"></span></a>
				</#if>
				<span class="color_505fb9">${(p.pageNumber)!}</span><span>/</span><span>${(p.lastPageNumber)!}</span>
				<#if p.pageNumber != p.lastPageNumber>
					<a href="#" class="newcarlist_pageNo_ablock"><span class="newcarlist_pageNo_right"> </span></a>
				<#else>
					<a href="#" class="newcarlist_pageNo_ablock"><span class="newcarlist_pageNo_right limit"> </span></a>
				</#if>
			</div>
		</div>
		
		<#if count != 0>
		<div class="center" id="carRight">
		<#list p.thisPageElements as e>
			<#assign tempSelledName = "">
			<#if (e.vehicle.selledName)??>
				<#assign tempSelledName = e.vehicle.selledName>
		    	<#if e.vehicle.selledName?starts_with(e.vehicle.vehicleModel)>
		    		<#assign tempSelledName = e.vehicle.selledName?replace(e.vehicle.vehicleModel, '', 'f')>
		    	</#if>
			</#if>
			<div class="<#if e_index == 0>right-usedbox<#else>right-usedbox2</#if> clearfix">
				<div class="usedbox-left">
					<a href="<@baseUrl.home />/no-haggle/${e.vehicleId}" target="_blank" onClick="_traceEvent('车辆图片', '点击', '${(e.vehicleId)!},${(e.vehicle.brand)!} ${(e.vehicle.vehicleModel)!}<#if e.vehicle.sweptVolumeStandard?? && e.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(e.vehicle.selledName)!}','5','false');">
						<img original="<#if e.vehicle.firstPhotoUrl??><@baseUrl.image />/${(action.getThumbImgUrl("80X60", "${(e.vehicle.firstPhotoUrl)!}"))!}<#else><@baseUrl.static />/common/build/1.00/images/noimg.png</#if>" height="60" width="80" alt="" class="carPtr" />
					</a>
				</div>
				<div class="usedbox-right">
					<div class="usedbox-right-top clearfix">
						<div class="ubrl-60">
							<#if e.vehicle.certified?? && e.vehicle.certified>
								<img src="<@baseUrl.static />/used_car/build/2.00/images/list/e_logo.png" alt="" class="e-logo" />
							</#if>
							<#if e.vehicle.vehicleModel?? && (e.vehicle.vehicleModel?index_of("尊沃") > -1)>
								<img src="<@baseUrl.static />/common/build/2.00/images/used_car_list/zw_bicon.jpg" alt="" class="zw_bicon" />
							</#if>
							<a target="_blank" class="<#if e.vehicle.certified?? && e.vehicle.certified><#if e.vehicle.vehicleModel?? && (e.vehicle.vehicleModel?index_of("尊沃") > -1)>usedbox-title4<#else>usedbox-title</#if><#else> <#if e.vehicle.vehicleModel?? && (e.vehicle.vehicleModel?index_of("尊沃") > -1)>usedbox-title3<#else>usedbox-title2</#if></#if>" 
								title="${(e.vehicle.brand)!} ${(e.vehicle.vehicleModel)!}<#if e.vehicle.sweptVolumeStandard?? && e.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}" 
								href="<@baseUrl.home />/no-haggle/${e.vehicleId}" 
								onClick="_traceEvent('车辆标题', '点击', '${e.vehicleId},${(e.vehicle.brand)!} ${(e.vehicle.vehicleModel)!}<#if e.vehicle.sweptVolumeStandard?? && e.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(e.vehicle.selledName)!}','7','false');">${(e.vehicle.brand)!} ${(e.vehicle.vehicleModel)!}<#if e.vehicle.sweptVolumeStandard?? && e.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}
							</a>
						</div>
						<div class="ubrr-40">
							<#if e.hidden?? && e.hidden><strong>面议</strong><#else><strong>${((e.price / 10000)?string("0.00"))!"0.00"}</strong><span class="ml5">万元</span></#if>
							<#if e.vehicle.vehicleSrcType?? && (e.vehicle.vehicleSrcType == 1)>
								<div class="ubrr urenzheng">
									<img src="<@baseUrl.static />/used_car/build/2.00/images/renzheng.png" alt="该商家已通过汽车街平台认证" title="该商家已通过汽车街平台认证" class="e-logo1" />
									<a href="<@baseUrl.newHome />/dealerShop/index2?orgSid=${(e.vehicle.vehicleSrcId)!}" class="shopname" title="${(action.getUsedcarDealerName(e.vehicle.vehicleSrcId))!}"><span>${(action.getUsedcarDealerName(e.vehicle.vehicleSrcId))!}</span></a>
								</div>
							<#else>
								<div class="ubrr urenzheng">其他商家</div>
							</#if>
						</div>
					</div>
					
					<div class="usedbox-right-bottom clearfix">
						<div class="ubrl-60">
							<span>${(e.city)!}</span> <span class="mlr5">|</span> <span>${((e.vehicle.displayMileage / 10000)?string("0.00"))!"0.00"}万公里</span>
							<span class="mlr5">|</span> <span>${(e.vehicle.registerLicenseYears?substring(0,4))!}年${(e.vehicle.registerLicenseYears?substring(4))!}月上牌</span> <span class="mlr5"></span> 
							<!--<span>排放标准：</span> <span>${(e.vehicle.sweptVolumeStandard)!}</span>-->
						</div>
						<div class="ubrr-40">
							<span>新车价：</span> <span><#if e.vehicle.newVehicleSuggestionPrice??>${((e.vehicle.newVehicleSuggestionPrice)?string("0.00"))!"0.00"}<#else>0</#if></span><span>万元</span>  
							<span>+</span> <span><#if e.taxBuy??>${((e.taxBuy / 10000)?string("0.00"))!"0.00"}<#else>0</#if></span> <span>万元(购置税)</span>
						</div>
					</div>
				</div>
			</div>
		</#list>
		</div>
		<@pagination.pagination />
		<#else>
		<div id="noCar" style='display:table-cell;'>
			<img src="<@baseUrl.static />/common/build/2.00/images/used_car_list/noCar.png" width="50" height="40" alt=""/>
			<p>很抱歉，没有找到符合条件的车辆<br />您可以修改搜索条件再试试</p>
		</div>	
		</#if>
	</div>
	<!-- End of Right -->
</div>

<#include "/include/footer.ftl">

<script language="javascript" src="<@baseUrl.static />/common/build/2.00/js/jquery.MinmyLazyload.js<@baseUrl.time />"></script>
<script language="javascript" src="<@baseUrl.static />/used_car/build/2.00/js/list.js<@baseUrl.time />"></script>
<script language="javascript" src="<@baseUrl.static />/common/build/2.00/js/jquery.MinmyLazyload.js"></script>

<script type="text/javascript">
$(function() {
    
    $(".newcarlist_pageNo_right").click(function() {
        window.location.href = $(".page a:last").attr("href");
    });
    
    $(".newcarlist_pageNo_left").click(function() {
       window.location.href = $(".page a:first").attr("href");
    });

    //更多品牌
    $('#newcarlist_moreBrand').mouseover(function () {
        if ($('.newcarlist_brand_all_right').length > 0) {
            $('.newcarlist_brand_all').css('width', '570px');
        }
        else {
            $('.newcarlist_brand_all').css('width', '260px');
        }
        $('.newcarlist_brand_all').show();
        $('.newcarlist_brand').addClass('active');
        $('.cover').css('height', (parseInt($('.newcarlist_brand').css('height')) + 34) + 'px');
    });

    $('.newcarlist_brand').mouseleave(function () {
        $('.newcarlist_brand_all').hide();
        $('.newcarlist_brand').removeClass('active');
    });

    //点击品牌进入已选择框
    $(document).on('click', '.newcarlist_brand_all a', function () {
        if (!$(this).hasClass('selected')) {
            var id = 'carBrand1';
            var value = $(this).html();
            $('.newcarlist_brand_all').find('a').removeClass('selected');
            $('#carBrand').find('a').removeClass('selected');
            $(this).addClass('selected');
            if ($('#' + id).length > 0) {
                $('#' + id).html(value + '<a href="#">X</a>');
            }
            else {
                $('#carSelected').append('<li id="' + id + '">' + value + '<a href="#">X</a></li>');
            }
            $('.left-selected').show();
        }
    });
    
    //价格范围
    $('#priceStart,#priceEnd').focus(function () {
        $(this).addClass('active');
    }).blur(function () {
        $(this).removeClass('active');
    });
    
    $('#priceSearch').click(function () {
        var value1 = parseInt($('#priceStart').val());
        var value2 = parseInt($('#priceEnd').val());
        var value;
        var min;
        var max;

        if (value1 > 0 && value2 > 0) {
			if (value1 < value2) {
				value = value1 + '-' + value2 + '万';
				min = value1;
				max = value2;
            } else {
                value = value2 + '-' + value1 + '万';
                min = value2;
                max = value1;
            }
            direct2Url("min,max,price,pageNumber",""+min+","+max+",,1");
        } else {
            return;
        }
    });
    
    $('#priceStart,#priceEnd').keyup(function () {
        var value = $(this).val().replace(/[^\d]/g, '');
        if (parseInt(value) == 0) {
            value = '';
        }
        $(this).val(value);
    });    
    
    /*城市*/
    $('#newcitySel').click(function () {
        if ($('#newCityList').css('display') == 'none') {
            $('#newCityList').show();
            $('#newcitySel').css('border-bottom', 'none');
            $('#newCitySpan').css('color', '#505fbb');
        } else {
            $('#newCityList').hide();
            $('#newcitySel').css('border-bottom', '1px solid #e5e5e5');
            $('#newCitySpan').css('color', '#333');
        }
        
        <#if province?? && (province != "") && city?? && (province != city)>
        	$('#TopUlS').removeClass('selected').children('img').css('visibility', 'hidden');
            $('#TopUlC').show().addClass('selected');
            $('#TopUlC').children('img').css('visibility', 'visible');
            $('#newCityS').hide();
            $('#newCityC').show();
		</#if>
    });
    
    $('#TopUlClose a').click(function () {
        $('#newCityList').hide();
        $('#newcitySel').css('border-bottom', '1px solid #e5e5e5');
        $('#newCitySpan').css('color', '#333');
    });
    
    $('#TopUlS').click(function () {
	    $('#newCityS').show();
	    $('#newCityC').hide();
	    $('#TopUlS').addClass('selected').children('img').css('visibility', 'visible');
	    $('#TopUlC').removeClass('selected').children('img').css('visibility', 'hidden');
	});
	
	$('#TopUlC').click(function () {
	    $('#newCityS').hide();
	    $('#newCityC').show();
	    $('#TopUlC').addClass('selected').children('img').css('visibility', 'visible');
	    $('#TopUlS').removeClass('selected').children('img').css('visibility', 'hidden');
	});
	
	//右边默认排序
    $('.priStyle').click(function (event) {
        if ($('.priStyle-list').css('display') == 'none') {
            $('.priStyle-list').show();
        } else {
            $('.priStyle-list').hide();
        }
        event.stopPropagation();
    });
    
	$('.priStyle-list-li').click(function () {
        var value = $(this).html();
        $('#priceSort').val(value).siblings('span').html(value);
        $('.priStyle-list').hide();
    });
    
	$('body').click(function () {
        $('.priStyle-list').hide();
        $('.carnStyle-list').hide();
    });
	
	//右边每页显示
    $('.carnStyle').click(function (event) {
        if ($('.carnStyle-list').css('display') == 'none') {
            $('.carnStyle-list').show();
        } else {
            $('.carnStyle-list').hide();
        }
        event.stopPropagation();
    })

    $('.carnStyle-list-li').click(function () {
        var value = $(this).html();
        $('#carSort').val(value).siblings('span').html(value);
        $('.carnStyle-list').hide();
    });
    
    //有检测认证
    $('#giftBag,.giftBag_label').click(function () {
        var $self = $('#giftBag').find('.giftBag_ok');
        if ($self.hasClass('selected')) {
            $self.removeClass('selected');
            direct2Url("cert,pageNumber",",1");
        }
        else {
            $self.addClass('selected');
            direct2Url("cert,pageNumber","1,1");
        }
    });

    <#if province?? && (province != "") && city?? && (province != city)>    
    	$.ajax({
	        async: false,
	        url: "<@baseUrl.home />/no-haggle/getUsedcarCity",
	        dataType: "json",
	        type: "get",
	        data: {
	            province: '${province}'
	        }
	    }).done(function(result) {
	        $("#newCityC").children().remove();
	        if (result.success) {
	           var data = result.data;
				$(data).each(function(index, item) {
					if (item) {
						$("#newCityC").append("<li><span fullName='" + item + "'>" + item + "</span></li>");
						cityName = item;
					}
				});
			}
	    });
	    
    </#if>

});

function closeCity() {
    $('#newCityList').hide();
    $('#newcitySel').css('border-bottom', '1px solid #e5e5e5');
    $('#newCitySpan').css('color', '#333').html($('#TopUlS span').html() + $('#TopUlC span').html());
};

function direct2Url(pars, vals) {
	$.ajax({
        async: false,
        url: "<@baseUrl.home />/no-haggle/replUrl",
        dataType: "json",
        type: "get",
        data: {
            param: "" + pars + ",brand",
            value: "" + vals + ",${(brand)!}",
            url: "" + window.location.href
        }
    }).done(function(result) {
        if (result.success) {
			window.location.href = result.data;
		}
    });
}

$(document).on('click', '#newCityC li', function () {
	var city = $(this).text();
	$('#city').val(city);
    $('#TopUlC span').html(city);
    if (!$('#TopUlC').hasClass('selected')) {
        $('#TopUlC').addClass('selected');
        $('#TopUlS').removeClass('selected');
    }
    closeCity();
    
    direct2Url("pro,city,pageNumber",""+$('#province').val()+","+$('#city').val()+",1");
});

$(document).on('click', '#newCityS li', function() {
    var province = $(this).children('span').attr("fullName");
    $("#province").val(province);
 
    var cityName = "";
    $.ajax({
        async: false,
        url: "<@baseUrl.home />/no-haggle/getUsedcarCity",
        dataType: "json",
        type: "get",
        data: {
            province: province
        }
    }).done(function(result) {
        $("#newCityC").children().remove();
        if (result.success) {
           var data = result.data;
			$(data).each(function(index, item) {
				if (item) {
					$("#newCityC").append("<li><span fullName='" + item + "'>" + item + "</span></li>");
					cityName = item;
				}
			});
		}
    });

    $('#TopUlS span').html($(this).children('span').html());
    if (!$('#TopUlS').hasClass('selected')) {
        $('#TopUlS').addClass('selected');
        $('#TopUlC').removeClass('selected');
    }

    if ($(this).find("span").html() == '全国') {
    	$("#city").val("");
    	$("#province").val("");
    	
        $('#newCityList').hide();
        $('#newcitySel').css('border-bottom', '1px solid #e5e5e5');
        $('#newCitySpan').css('color', '#333').html($('#TopUlS span').html());
        
        direct2Url("pro,city,pageNumber",",,1");
    } else {
        if (province == cityName) { //直辖市
            $('#newCityList').hide();
            $('#newcitySel').css('border-bottom', '1px solid #e5e5e5');
            $('#newCitySpan').css('color', '#333').html($('#TopUlS span').html());
            $("#city").val(cityName);
          
            direct2Url("pro,city,pageNumber",""+$("#city").val()+","+$("#city").val()+",1");
        } else {
            $('#TopUlS').removeClass('selected').children('img').css('visibility', 'hidden');
            $('#TopUlC').show().addClass('selected');
            $('#TopUlC').children('img').css('visibility', 'visible');
            $('#TopUlC span').html('请选择');
            $('#newCityS').hide();
            $('#newCityC').show();
        }
    }
    
});


</script>
</body>
</html>
</#escape>
