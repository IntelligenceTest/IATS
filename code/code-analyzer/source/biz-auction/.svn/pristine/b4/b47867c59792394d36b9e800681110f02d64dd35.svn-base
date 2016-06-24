<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit">
<meta name="keywords" content="汽车,汽车街,二手车,二手车拍卖,汽车图片,汽车询价,经销商,新车,宝马,置换,新车置换,汽车之家" />
<meta name="description" content="汽车街为您提供最新汽车报价，汽车图片，汽车价格大全，优质二手车展厅，二手车拍卖、免费上门评估、检测、置换" />
<#assign tempSelledName = "">
<#if (vehicle.selledName)??>
    <#assign tempSelledName = vehicle.selledName>
    <#if vehicle.selledName?starts_with(vehicle.vehicleModel)>
         <#assign tempSelledName = vehicle.selledName?replace(vehicle.vehicleModel, '', 'f')>
    </#if>
</#if>
<meta name="others" content="汽车街_二手车展厅_${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}">
<title>${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}_二手车展厅_汽车街</title>

<link href="<@baseUrl.static />/common/build/2.00/css/b.css<@baseUrl.time />" rel="stylesheet" type="text/css" />
<link href="<@baseUrl.static />/common/build/2.00/css/tinyscrollbar.css<@baseUrl.time />" rel="stylesheet" type="text/css" />
<link href="<@baseUrl.static />/common/build/2.00/css/used_car_detail.css<@baseUrl.time />" rel="stylesheet" type="text/css" />
<link href="<@baseUrl.static />/used_car/build/2.00/css/banner.css<@baseUrl.time />" rel="stylesheet" type="text/css" />
</head>

<body class="w950">

<#if (usedcarShop.bannerTemplateName)?? && usedcarShop.bannerTemplateName != ''>
<div class="b-main">
    <div class="b-banner">
        <a href="<#if (usedcarShop.bannerLinkUrl)??  && usedcarShop.bannerLinkUrl != ''>${(usedcarShop.bannerLinkUrl)!}<#else> <@baseUrl.newHome />/dealerShop/index2?orgSid=${(shop.sid)!}</#if>">
            <div class="${(usedcarShop.bannerTemplateName)!}" id="bannerPageShow">
                <#if logoLists??>
                <#list logoLists as logo>
                    <#if logo_index == 1>
                        <img src="<@baseUrl.static />/${(logo)!}" alt="" class="img${(logo_index + 1)!}" />
                    <#else>
                        <img src="<@baseUrl.static />/${(logo)!}" alt="" />
                    </#if>
                </#list>
                </#if>
                <span>${(shop.orgName)!}</span>
            </div>
        </a>
    </div>
</div>
</#if>

<#include "/include/header2.ftl">
<@layout.nav active = "buy-now" />

<div id="main">
    <!--面包屑-->
    <div class="crumbs">
        <a href="<@baseUrl.home />/no-haggle" id="comeback">&lt; 返回二手车展厅</a>
        <div class="fav_share">
            <input type="hidden" id="favoriteID" name="favoriteID" value="${favID}"/>
            <div class="bdsharebuttonbox" data-tag="share_1"><a class="bds_more" data-cmd="more">分享</a></div>
            <img src="<@baseUrl.static />/common/build/2.00/images/used_car/share.png" alt="">
            <#if favID == 0>
                  <span id="fav_no">
                      <a href="javascript:;" onClick="addFavorite();" class="fav">收藏</a><img src="<@baseUrl.static />/common/build/2.00/images/used_car/star2.png" alt="">
                  </span>
                  <span id="fav_ed" style="display:none;">
                      <a href="javascript:;" onClick="cancelFavorite();" class="fav" id="collection">已收藏</a><img src="<@baseUrl.static />/common/build/2.00/images/used_car/star.png" alt="">
                  </span>
            <#else>
                <span id="fav_ed">
                    <a href="javascript:;" onClick="cancelFavorite();" class="fav" id="collection">已收藏</a><img src="<@baseUrl.static />/common/build/2.00/images/used_car/star.png" alt="">
                </span>
                <span id="fav_no" style="display:none;">
                    <a href="javascript:;" onClick="addFavorite();" class="fav">收藏</a><img src="<@baseUrl.static />/common/build/2.00/images/used_car/star2.png" alt="">
                </span>
            </#if>
        </div>
    </div>

    <div id="container">
        <!--左侧内容-->
        <div class="aside">
        	<#--edit by zjz 是否可以下定通过订金判断 2015-12-10 16:56:53-->
            <#if !(fp.deposit)?? ||  (fp.deposit == 0)>
                <a class="<#if (shop.telephone)?? && shop.telephone != "" && (shop.telephone?length < 14)>telephone f18<#else>telephone f16</#if>">
                    <img src="<@baseUrl.static />/common/build/2.00/images/used_car/phone.png" width="17" alt="">
                    <#if (shop.telephone)?? && shop.telephone != "">${shop.telephone}<#else>400-821-8889</#if>
                </a>
            <#else>
                <#if prepayFlag == "1">
                    <a href="javascript:;" class="buy_now">立即下订</a>
                <#elseif prepayFlag == "2">
                    <a href="javascript:;" class="reservation">已预订</a>
                <#elseif prepayFlag == "3">
                    <a href="javascript:;" class="sold">已售出</a>
                <#else>
                    <a href="javascript:;" class="under_carriage">已下架</a>
                </#if>
            </#if>

            <div id="price"><#if vehicle.hidden?? && vehicle.hidden>面议<#else><b>${((vehicle.finalTransactionPrice / 10000)?string("0.00"))!"0.00"}</b><span>万元</span></#if></div>
            <#if !(fp.deposit)?? ||  (fp.deposit == 0)>
            <#else>
                <div class="price_detail">
                    <p class="prominent">订金${(prePrice)!}元，可全额退款</p>
                </div>
            </#if>
                        
            <div class="loan_calu">
                <a href="#" class="apply_calu" id="apply_calu"><img src="<@baseUrl.static />/common/build/2.00/images/used_car/calc.png" alt="" width="20">贷款计算器</a>
            </div>
            <div class="buss_info">
                <p class="title">${(fp.whereStore)!}</p>
                <p>电话：<#if fp.phone?? && fp.phone != "">${(fp.phone)!}<#else>400-821-8889</#if></p>
                <p>地址：${(fp.addressDetailStore)!}</p>
                <p>服务时间：${(fp.serviceTime)!}</p>
            </div>
            <div class="booking_for_car is_area">
                <h3>预约看车</h3>
                <span class="error_text"></span>
                <input type="text" class="name" value="请输入姓名" name="customerName" id="customerName">
                <input type="text" class="mobile" value="请输入手机"  name="cellphone" id="cellphone">
                <input type="hidden" id="province" name="province"/>
                <input type="hidden" id="city" name="city"/>

                <div class="select_area">
                    <span>请选择省份</span>
                    <ul>
                        <#list provinceList as province>
                            <li onclick="selectCity('${(province.province)!}');">${(province.province)!}</li>
                        </#list>
                    </ul>
                </div>
                <div class="select_city">
                    <span>请选择城市</span>
                    <ul>
                    </ul>
                </div>
                <input type="button" value="" class="booking_now" id="booking_now">
            </div>
            <div class="interest">
                <h3>您可能喜欢</h3>
                <ul>
                    <#if favVehicleList??>
                        <#list favVehicleList as vItem>
                            <#if (vItem_index &lt; 3)>
                            <#assign tempSelledName = "">
                            <#if (vItem.vehicle.selledName)??>
                                <#assign tempSelledName = vItem.vehicle.selledName>
                                <#if vItem.vehicle.selledName?starts_with(vItem.vehicle.vehicleModel)>
                                     <#assign tempSelledName = vItem.vehicle.selledName?replace(vItem.vehicle.vehicleModel, '', 'f')>
                                </#if>
                            </#if>
                                <li>
                                    <a href="<@baseUrl.home />/no-haggle/${vItem.vehicleId}"><img src="<@baseUrl.image />/${(action.getThumbImgUrl("180X135", "${(vItem.vehicle.firstPhotoUrl)!}"))!}" alt="" width="178"></a>
                                    <a href="<@baseUrl.home />/no-haggle/${vItem.vehicleId}"><h4>${(vItem.vehicle.brand)!} ${(vItem.vehicle.vehicleModel)!}<#if vItem.vehicle.sweptVolumeStandard?? && vItem.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</h4></a>
                                    <p class="recommend_price">${((vItem.price / 10000)?string("0.00"))!"0.00"}<span>万元</span></p>
                                    <p class="addr">${(vItem.vehicle.currentCity)!}</p>
                                </li>
                            </#if>
                        </#list>
                    </#if>
                </ul>
            </div>
        </div>

        <!--右侧内容-->
        <div class="contain_r">
            <div class="intro">
                <#assign tempSelledName = "">
                <#if (vehicle.selledName)??>
                    <#assign tempSelledName = vehicle.selledName>
                    <#if vehicle.selledName?starts_with(vehicle.vehicleModel)>
                         <#assign tempSelledName = vehicle.selledName?replace(vehicle.vehicleModel, '', 'f')>
                    </#if>
                </#if>
                <h2>${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</h2>
                <p>新车价：<#if (vehicle.newVehicleSuggestionPrice)??>${((vehicle.newVehicleSuggestionPrice)?string("0.00"))!"0.00"}<#else>0</#if>万元+<#if fp.taxBuy??>${((fp.taxBuy / 10000)?string("0.00"))!"0.00"}<#else>0</#if>万元(购置税) | 所在：${(vehicle.currentCity)!} | ${((vehicle.displayMileage)/10000)?default(0.00)?string("0.##")!}万公里 | ${(vehicle.registerLicenseYears?substring(0,4))!}年${(vehicle.registerLicenseYears?substring(4))!}月上牌</p>
                <span>已有${((fp.clickCount)!0)+1}人浏览</span>
            </div>
            
            <!--车型图片-->
            <div class="car_picture">
                <div class="big">
                    <img src="<@baseUrl.static />/common/build/2.00/images/loading2.gif" width="64" alt="" class="loading">
                    <#if ((vehicle.starPhotoList)[0])?? && ((vehicle.starPhotoList)[0]).photoUrl?? && (((vehicle.starPhotoList)[0]).photoUrl != "")>
                        <img src="<@baseUrl.image />/${(action.getThumbImgUrl("590X443", "${(((vehicle.starPhotoList)[0]).photoUrl)!}"))!}" style="width:590px" alt="" class="big_pic">
                    <#else>
                        <img src="<@baseUrl.static />/common/build/1.00/images/noimg.png" style="width:590px" alt="">
                    </#if>
                    <a href="javascript:;" class="big_arrow_l"></a>
                    <a href="javascript:;" class="big_arrow_r"></a>
                </div>
                <div class="small">
                    <p class="pic_count">共${(photoNum)!}张照片</p>
                    <i class="left arrow_l"></i>
                    <div class="pic_list">
                        <div class="page_all">
                            <#if vehicle.starPhotoList??>
                                <#assign m = 1 />
                                <#list vehicle.starPhotoList?chunk(10) as row>
                                    <ul class="page_${(m)!}">
                                    <#list row as cell>
                                        <#if cell.photoUrl?? && (cell.photoUrl != "")>
                                        <li>
                                            <img src="<@baseUrl.image />/${(action.getThumbImgUrl("80X60", "${(cell.photoUrl)!}"))!}" width="80" alt="" class="prod_img" srcBig="<@baseUrl.image />/${(action.getThumbImgUrl("750X563", "${(cell.photoUrl)!}"))!}">
                                            <img src="<@baseUrl.static />/common/build/2.00/images/used_car/cur.png" width="80" alt="" class="image_cur">
                                        </li>
                                        </#if>
                                    </#list>
                                    </ul>
                                    <#assign m = m + 1 />
                                </#list>
                            </#if>
                        </div>
                    </div>
                    <i class="right arrow_r"></i>
                </div>
            </div>
            <!--车型图片结束-->

            <div class="adv">
                <#if advInfo??>
                    <#if advInfo.clickUrl??>
                        <a href="${advInfo.clickUrl}" onclick="_hmt.push(['_trackEvent', '二手车详情页', 'click', '${advInfo.name}']);_traceEvent('二手车详情页', '点击', '${advInfo.name}','10','false');" target="_blank">
                            <img src="<@baseUrl.image />/${(action.getThumbImgUrl("150X628", "${(advInfo.adDesign)!}"))!}" alt="">
                        </a>
                    <#else>
                            <img src="<@baseUrl.image />/${(action.getThumbImgUrl("150X628", "${(advInfo.adDesign)!}"))!}" alt="">
                    </#if>
                </#if>
            </div>

            <div class="car_info">
                <ul class="info_nav">
                    <li class="cur" id="base_info">车辆信息</li>
                    <#if !vehicle.source?? || vehicle.source != "dealer">
                        <li id="report">检测报告</li>
                    </#if>
                    <#if vinVehicle??>
                        <li id="para_detail">详细参数</li>
                    </#if>
                    <li id="service_car">购车服务</li>
                </ul>
                <div class="car_number">车辆编号：${vehicle.code}</div>
                
                <div class="info_content">
                    <!--车辆信息-->
                    <div class="base_info content_tab">
                        <div class="title">
                            <#assign tempSelledName = "">
                            <#if (vehicle.selledName)??>
                                <#assign tempSelledName = vehicle.selledName>
                                <#if vehicle.selledName?starts_with(vehicle.vehicleModel)>
                                     <#assign tempSelledName = vehicle.selledName?replace(vehicle.vehicleModel, '', 'f')>
                                </#if>
                            </#if>
                            <h3>${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</h3>
                            <p>新车价：<#if vehicle.newVehicleSuggestionPrice??>${((vehicle.newVehicleSuggestionPrice)?string("0.00"))!"0.00"}<#else>0</#if>万元+<#if fp.taxBuy??>${((fp.taxBuy / 10000)?string("0.00"))!"0.00"}<#else>0</#if>万元(购置税) | 所在：${(vehicle.currentCity)!} | ${((vehicle.displayMileage)/10000)?default(0.00)?string("0.##")!}万公里 | ${(vehicle.registerLicenseYears?substring(0,4))!}年${(vehicle.registerLicenseYears?substring(4))!}月上牌 </p>
                        </div>
                        <div class="detail_info">
                            <h3>详细信息</h3>
                            <ul>
                                <!-- <li><label>出厂日期</label><p>${(vehicle.producedYears?substring(0,4))!}年${(vehicle.producedYears?substring(4))!}月</p></li> -->
                                <li><label>上牌日期</label><p>${(vehicle.registerLicenseYears?substring(0,4))!}年${(vehicle.registerLicenseYears?substring(4))!}月</p></li>
                                <li><label>排气量</label><p>${(vehicle.sweptVolume)?string("0.0")!}${(vehicle.sweptVolumeType)!}</p></li>
                                <!-- <li><label>环保标准</label><p>${(vehicle.sweptVolumeStandard)!}</p></li> -->
                                <!--<li><label>上牌城市</label><p>${(vehicle.registerCity)!}</p></li> -->
                                <li><label>车辆所在地</label><p>${(vehicle.currentCity)!}</p></li>
                                <li><label>燃料类型</label><p>${(vehicle.oilType)!}</p></li>
                                <!-- <li><label>车辆类型</label><p>${(vehicle.vehicleType)!}</p></li> -->
                                <!--<li><label>车牌号</label><p><#if vehicle.licenseCode?? && (vehicle.licenseCode?length > 1)>${(vehicle.licenseCode?substring(0,2))!}<#else>${(vehicle.licenseCode)!}</#if></p></li> -->
                                <li><label>车辆颜色</label><p>${(vehicle.bodyColor)!}</p></li>
                                <!-- <li><label>内饰颜色</label><p>${(vehicle.interiorColor)!}</p></li> -->
                                <!-- <li><label>最大功率</label><p>${(vehicle.power?c)!}kw</p></li> -->
                                <#if (vehicle.displayMileage)??>
                                    <li><label>表显里程</label><p>${((vehicle.displayMileage)/10000)?default(0.00)?string("0.##")!}万公里</p></li>
                                </#if>
                                <!-- <li><label>VIN码是否清晰</label><p>${(vehicle.clearVin?string('是','否'))!}</p></li> -->
                                <!-- <li><label>发动机号是否清晰</label><p>${(vehicle.clearEnginCode?string('是','否'))!}</p></li> -->
                                <li><label>变速箱类型</label><p>${(vehicle.transmissionType)!}</p></li>
                                <li><label>使用性质</label><p>${(vehicle.usingModel)!}</p></li>
                                <!-- <li><label>过户次数</label><p>${(vehicle.transferNumber)!}</p></li> -->
                                <li><label>年审有效期</label><p>${(vehicle.nextAnnualExamination?string('yyyy年MM月dd日'))!}</p></li>
                                <li><label>交强险有效期</label><p>${(vehicle.nextCompulsoryInsurance?string('yyyy年MM月dd日'))!}</p></li>
                                <!-- <li><label>购置附加税完税证明</label><p>${(vehicle.purchaseTaxProof?string("有","无"))!"无"}</p></li> -->
                                <li><label>产证</label><p>${(vehicle.propertyCertificate?string("有","无"))!"无"}</p></li>
                                <li><label>行驶证</label><p>${(vehicle.vehicleLicense?string("有","无"))!"元"}</p></li>
                            </ul>
                        </div>
                        <div class="configure">
                            <h3>车辆配置</h3>
                            <ul>
                                <#if featureItem??>
                                    <#list featureItem as s>
                                        <#if (s?trim?length > 0)>
                                            <li>${s}</li>
                                        </#if>
                                    </#list>
                                </#if>
                            </ul>
                        </div>
                        <div class="describe">
                            <h3>车辆描述</h3>
                            <p id="vehicleDesc"></p>
                        </div>
                    </div>

                    <!--检测报告-->
                    <#if !vehicle.source?? || vehicle.source != "dealer">
                    <div class="report content_tab">
                        <h3>检测报告</h3><p>质检时间：${(vehicle.assessmentDatetime?string('yyyy-MM-dd'))!}</p>
                        <div class="clearfix"></div>
                        
                        <#if vehicle.certified?? && vehicle.certified>
                            <img src="<@baseUrl.static />/common/build/2.00/images/used_car/eqs.png" alt="" width="60" class="e_logo">
                            <p class="eqs">该车辆经过200项严酷检测，已成功通过EQS认证!</p>
                        </#if>                        

                        <div class="grade">
                            <blockquote>
                                <p class="item_1">综合评分</p>
                                <p class="item_2">主要检测项目</p>
                                <p class="item_3">得分</p>
                            </blockquote>
                            <div class="score">
                                <h4><#if vehicle.grade?? && (vehicle.grade?trim != "")>${(vehicle.grade)!}</#if></h4>
                                <div class="score_detail">
                                    <h5>骨架评级</h5>
                                    <p>车况评分${(vehicle.score?string("0.0"))!}</p>
                                </div>
                            </div>
                            <ul class="item_score">
                                <#list vehicle.checkItemCategoryScoreList as score>
                                    <li>
                                        <p>${score.categoryName}</p>
                                        <span>${(score.score?string("0.0"))!}</span>
                                    </li>
                                </#list>
                            </ul>
                        </div>

                        <div class="check_item">
                            <h3>骨架损伤</h3>
                            <ul>
                                <#list vehicle.frameList as cfl>
                                    <li>
                                        <p>${(cfl.itemName)!}</p>
                                        <#if cfl.good>
                                            <span><img src="<@baseUrl.static />/common/build/2.00/images/used_car/tick2.png" alt=""></span>
                                        <#else>
                                            <span class="scar">
                                                <b><#if cfl.damageStatusSelected?? && cfl.damageStatusSelected != "">${cfl.damageStatusSelected}<#else>有损伤</#if></b>
                                                <img src="<@baseUrl.static />/common/build/2.00/images/used_car/magnifier.png" alt="">
                                                <blockquote>
                                                    <img src="<@baseUrl.image />/${(action.getThumbImgUrl("350X200", "${(cfl.photoUrl)!}"))!}" width="350" alt="" class="horn_pic">
                                                    <ins><#if cfl.damageStatusSelected?? && cfl.damageStatusSelected != "">${cfl.damageStatusSelected}<#else>有损伤</#if></ins>
                                                    <img src="<@baseUrl.static />/common/build/2.00/images/used_car/horn.png" width="18" alt="" class="horn">
                                                </blockquote>
                                            </span>
                                        </#if>
                                    </li>
                                </#list>
                            </ul>
                        </div>

                        <div class="check_item">
                            <h3>外观损伤</h3>
                            <ul>
                                <#list vehicle.featureList as cal>
                                    <li>
                                        <p>${(cal.itemName)!}</p>
                                        <#if cal.good>
                                            <span><img src="<@baseUrl.static />/common/build/2.00/images/used_car/tick2.png" alt=""></span>
                                        <#else>
                                            <span class="scar">
                                                <b><#if cal.damageStatusSelected?? && cal.damageStatusSelected != "">${cal.damageStatusSelected}<#else>有损伤</#if></b>
                                                <img src="<@baseUrl.static />/common/build/2.00/images/used_car/magnifier.png" alt="">
                                                <blockquote>
                                                    <img src="<@baseUrl.image />/${(action.getThumbImgUrl("350X200", "${(cal.photoUrl)!}"))!}" width="350" alt="" class="horn_pic">
                                                    <ins><#if cal.damageStatusSelected?? && cal.damageStatusSelected != "">${cal.damageStatusSelected}<#else>有损伤</#if></ins>
                                                    <img src="<@baseUrl.static />/common/build/2.00/images/used_car/horn.png" width="18" alt="" class="horn">
                                                </blockquote>
                                            </span>
                                        </#if>
                                    </li>
                                </#list>
                            </ul>
                        </div>

                        <div class="check_item">
                            <h3>内饰损伤</h3>
                            <ul>
                                <#list vehicle.interiorList as ccl>
                                    <li>
                                        <p>${(ccl.itemName)!}</p>
                                        <#if ccl.good>
                                            <span><img src="<@baseUrl.static />/common/build/2.00/images/used_car/tick2.png" alt=""></span>
                                        <#else>
                                            <span class="scar">
                                                <b><#if ccl.damageStatusSelected?? && ccl.damageStatusSelected != "">${ccl.damageStatusSelected}<#else>有损伤</#if></b>
                                                <img src="<@baseUrl.static />/common/build/2.00/images/used_car/magnifier.png" alt="">
                                                <blockquote>
                                                    <img src="<@baseUrl.image />/${(action.getThumbImgUrl("350X200", "${(ccl.photoUrl)!}"))!}" width="350" alt="" class="horn_pic">
                                                    <ins><#if ccl.damageStatusSelected?? && ccl.damageStatusSelected != "">${ccl.damageStatusSelected}<#else>有损伤</#if></ins>
                                                    <img src="<@baseUrl.static />/common/build/2.00/images/used_car/horn.png" width="18" alt="" class="horn">
                                                </blockquote>
                                            </span>
                                        </#if>
                                    </li>
                                </#list>
                            </ul>
                        </div>

                        <div class="check_item state">
                            <h3>车况检测</h3>
                            <ul>
                                <li class="state_title">驾驶舱</li>
                                <#list vehicle.dricabList as condItem>
                                    <li>
                                        <p>${(condItem.itemDesc)!}</p>
                                        <span><#if condItem.good><img src="<@baseUrl.static />/common/build/2.00/images/used_car/tick2.png" alt=""><#else>否</#if></span>
                                    </li>
                                </#list>
                            </ul>
                            <ul>
                                <li class="state_title">发动机</li>
                                <#list vehicle.engineList as condItem>
                                    <li>
                                        <p>${(condItem.itemDesc)!}</p>
                                        <span><#if condItem.good><img src="<@baseUrl.static />/common/build/2.00/images/used_car/tick2.png" alt=""><#else>否</#if></span>
                                    </li>
                                </#list>
                            </ul>
                        </div>
                        <div class="check_item state">
                            <ul>
                                <li class="state_title">启动</li>
                                <#list vehicle.startList as condItem>
                                    <li>
                                        <p>${(condItem.itemDesc)!}</p>
                                        <span><#if condItem.good><img src="<@baseUrl.static />/common/build/2.00/images/used_car/tick2.png" alt=""><#else>否</#if></span>
                                    </li>
                                </#list>
                            </ul>
                            <ul>
                                <li class="state_title">路试</li>
                                <#list vehicle.roadList as condItem>
                                    <li>
                                        <p>${(condItem.itemDesc)!}</p>
                                        <span><#if condItem.good><img src="<@baseUrl.static />/common/build/2.00/images/used_car/tick2.png" alt=""><#else>否</#if></span>
                                    </li>
                                </#list>
                            </ul>
                            
                        </div>
                        <div class="check_item state">
                            <ul>
                                <li class="state_title">底盘</li>
                                <#list vehicle.chassisList as condItem>
                                    <li>
                                        <p>${(condItem.itemDesc)!}</p>
                                        <span><#if condItem.good><img src="<@baseUrl.static />/common/build/2.00/images/used_car/tick2.png" alt=""><#else>否</#if></span>
                                    </li>
                                </#list>
                            </ul>
                            <#if (vehicle.chassisList)?? && ((vehicle.chassisList)?size > 0) >
                            <ul>
                                <li class="state_title">其他</li>
                                <#list vehicle.otherList as otherItem>
                                	<#if otherItem.good??&&!otherItem.good>
	                                    <li>
	                                        <p>${(otherItem.itemDesc)!}</p>
	                                        <span>否</span>
	                                    </li>
                                    </#if>
                                </#list>
                            </ul>
                            </#if>
                        </div>

                        <div class="check_item attachment">
                            <h3>附件检测</h3>
                            <ul>
                                <#list vehicle.accessoryList as accessory>
                                    <li>
                                        <p>${(accessory.accessoryName)!}</p>
                                        <span>${(accessory.optionSelected)!}</span>
                                    </li>
                                </#list>
                            </ul>
                        </div>
                    </div>
                    </#if>

                    <!--详细参数-->
                    <#if vinVehicle??>
                    <div class="para_detail content_tab">
                        <h3>基本参数</h3>
                              <ul>
                                <li>
                                    <p><span class="key">厂商</span><span class="val">${(vinVehicle.manufacturer)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">车辆类型</span><span class="val">${(vinVehicle.category)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">车系</span><span class="val">${(vinVehicle.brandSeries)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">车型</span><span class="val">${(vinVehicle.selledName)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">级别</span><span class="val">${(vinVehicle.level)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">年款</span><span class="val">${(vinVehicle.modelYear)!'无'}款</span></p>
                                </li>
                                <li>
                                    <p><span class="key">车体结构</span><span class="val">${(vinVehicle.bodyType)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">车门数(个)</span><span class="val">${(vinVehicle.doorQuantity)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">座位数(个)</span><span class="val">${(vinVehicle.seatQuantity)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">长(mm)</span><span class="val">${(vinVehicle.length)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">宽(mm)</span><span class="val">${(vinVehicle.width)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">高(mm)</span><span class="val">${(vinVehicle.height)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">轴距(mm)</span><span class="val">${(vinVehicle.wheelBase)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">前轮距(mm)</span><span class="val">${(vinVehicle.frontWheelSpan)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">后轴距(mm)</span><span class="val">${(vinVehicle.endWheelSpan)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">最大马力(Ps)</span><span class="val">${(vinVehicle.maxHorsepower)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">最小离地间隙(mm)</span><span class="val"> ${(vinVehicle.minClearance)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">后备箱容积(L)</span><span class="val">${(vinVehicle.trunkCapacity)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">油箱容积(L)</span><span class="val">${(vinVehicle.tankCapacity)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">最大载重量(kg)</span><span class="val">${(vinVehicle.maxLoad)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">最高时速(km/h)</span><span class="val">${(vinVehicle.maxSpeed)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">0-100km/h加速时间(s)</span><span class="val">${(vinVehicle.accelerationTime)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">综合工况油耗(L/100km)</span><span class="val">${(vinVehicle.standardOilConsumption)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">进气形式</span><span class="val">${(vinVehicle.airType)!'无'}</span></p>
                                </li>
                            </ul>

                            <h3>发动机参数</h3>
                            <ul>
                                <li>
                                    <p><span class="key">发动机位置</span><span class="val">${(vinVehicle.enginePosition)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">气缸容积(Vh)</span><span class="val">${(vinVehicle.cylinderVolume)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">排量(L)</span><span class="val">${(vinVehicle.sweptVolume)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">市区工况油耗(L/100km)</span><span class="val">${(vinVehicle.downtownOilConsumption)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">汽缸排列形式</span><span class="val">${(vinVehicle.cylinderArrange)!'无'}</span></p>
                                </li>    
                                <li>
                                    <p><span class="key">汽缸数(个)</span><span class="val">${(vinVehicle.quantityCylinder)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">每缸气门数(个)</span><span class="val">${(vinVehicle.quantityCylinderDoor)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">压缩比</span><span class="val">${(vinVehicle.compressionRatio)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">最大功率(kW)</span><span class="val">${(vinVehicle.maxPower)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">最大功率转速(rpm)</span><span class="val">${(vinVehicle.maxPowerRpm)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">最大扭矩(N&middot;m)</span><span class="val">${(vinVehicle.maxTorque)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">最大扭矩转速(rpm)</span><span class="val">${(vinVehicle.maxTorqueRpm)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">燃油标号</span><span class="val">${(vinVehicle.oilNumber)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">供油方式</span><span class="val">${(vinVehicle.oilFeedingType)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">燃油类型</span><span class="val">${(vinVehicle.oilType)!'无'}</span></p>
                                </li>
                            </ul>

                            <h3>变速箱参数</h3>
                            <ul>
                                <li>
                                    <p><span class="key">变速器描述</span><span class="val">${(vinVehicle.transmissionDesc)!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">变速器类型</span><span class="val">${(vinVehicle.transmissionType)!'无'}</span></p> 
                                </li>
                                <li>
                                    <p><span class="key">挡位个数</span><span class="val">${(vinVehicle.gearNumber)!'无'}</span></p> 
                                </li>
                            </ul>
                            <h3>底盘转向参数</h3>
                            <ul>
                                <li>
                                    <p><span class="key">主动转向系统 </span><span class="val">
                                     <#if vinVehicle.activeSteeringSystem ??>  
                                     <#if vinVehicle.activeSteeringSystem =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.activeSteeringSystem =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                      <#if vinVehicle.activeSteeringSystem =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                      <ins class="pz-3"></ins>
                                    </#if>
                                     </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">驱动方式</span><span class="val">${(vinVehicle.driveModel )!'无'}</span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前悬挂类型</span><span class="val">${(vinVehicle.frontSuspension )!'无'}</span></p>
                                </li>
                                <li>
                                    <p><span class="key">后悬挂类型</span><span class="val">${(vinVehicle.endSuspension )!'无'}</span></p> 
                                </li>
                            </ul>
                            <h3>车轮制动参数</h3>
                            <ul>
                                <li>
                                    <p><span class="key">前制动器类型</span><span class="val">${(vinVehicle.frontBrakeType )!'无'}</span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后制动器类型</span><span class="val">${(vinVehicle.endBrakeType )!'无'}</span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前轮胎规格</span><span class="val">${(vinVehicle.frontWheel )!'无'}</span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后轮胎规格</span><span class="val">${(vinVehicle.endWheel )!'无'}</span></p> 
                                </li>
                            </ul>
                            
                            <h3>安全配置 </h3>
                            <ul>
                                <li>
                                    <p><span class="key">驾驶座安全气囊</span><span class="val">
                                   <#if vinVehicle.driverAirbag ??>  
                                    <#if vinVehicle.driverAirbag =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.driverAirbag =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.driverAirbag =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                      <ins class="pz-3"></ins>
                                    </#if> 
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">副驾驶安全气囊</span><span class="val">
                                     <#if vinVehicle.codriverAirbag ??>  
                                     <#if vinVehicle.codriverAirbag =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.codriverAirbag =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                      <#if vinVehicle.codriverAirbag =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前排侧气囊</span><span class="val">
                                     <#if vinVehicle.frontSideAirbag ??>  
                                     <#if vinVehicle.frontSideAirbag =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.frontSideAirbag =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.frontSideAirbag =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>   
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排侧气囊</span><span class="val">
                                     <#if vinVehicle.endSideAirbag ??>  
                                    <#if vinVehicle.endSideAirbag =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.endSideAirbag =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.endSideAirbag =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if> 
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前排头部气囊气帘</span><span class="val">
                                     <#if vinVehicle.frontHeadAirbag ??>  
                                     <#if vinVehicle.frontHeadAirbag =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.frontHeadAirbag =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.frontHeadAirbag =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>   
                                    </span></p>
                                </li>
                                <li>
                                    <p><span class="key">后排头部气囊气帘</span><span class="val">
                                     <#if vinVehicle.endHeadAirbag ??>  
                                     <#if vinVehicle.endHeadAirbag =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.endHeadAirbag =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.endHeadAirbag =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">膝部气囊</span><span class="val">
                                    <#if vinVehicle.kneeAirbag ??>  
                                    <#if vinVehicle.kneeAirbag =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.kneeAirbag =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.kneeAirbag =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p>
                                </li>
                                <li>
                                    <p><span class="key">胎压监测装置</span><span class="val">
                                     <#if vinVehicle.tirePressureMonitor ??>  
                                     <#if vinVehicle.tirePressureMonitor =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.tirePressureMonitor =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.tirePressureMonitor =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">零胎压继续行驶</span><span class="val">
                                     <#if vinVehicle.zeroPressureRunning ??>  
                                     <#if vinVehicle.zeroPressureRunning =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.zeroPressureRunning =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.zeroPressureRunning =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if> 
                                    </span></p>
                                </li>
                                <li>
                                    <p><span class="key">安全带未系提示</span><span class="val">
                                     <#if vinVehicle.remindSafetyBelt ??>  
                                     <#if vinVehicle.remindSafetyBelt =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.remindSafetyBelt =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.remindSafetyBelt =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">儿童座椅接口</span><span class="val">
                                     <#if vinVehicle.childSeatInterface ??>  
                                     <#if vinVehicle.childSeatInterface =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.childSeatInterface =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.childSeatInterface =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">LATCH座椅接口(兼容ISO FIX)</span><span class="val">
                                    <#if vinVehicle.latchSeatInterface ??>  
                                    <#if vinVehicle.latchSeatInterface =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.latchSeatInterface =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.latchSeatInterface =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">遥控钥匙</span><span class="val">
                                     <#if vinVehicle.remoteKey ??>  
                                     <#if vinVehicle.remoteKey =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.remoteKey =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.remoteKey =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p>
                                </li>
                                <li>
                                    <p><span class="key">车内中控锁</span><span class="val">
                                     <#if vinVehicle.centralLock ??>  
                                     <#if vinVehicle.centralLock =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.centralLock =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.centralLock =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">无钥匙启动系统</span><span class="val">
                                    <#if vinVehicle.keylessStartSystem ??>  
                                    <#if vinVehicle.keylessStartSystem =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.keylessStartSystem =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.keylessStartSystem =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if> 
                                    </span></p>
                                </li>
                                <li>
                                    <p><span class="key">发动机电子防盗</span><span class="val">
                                     <#if vinVehicle.antiTheftForEngine ??>  
                                     <#if vinVehicle.antiTheftForEngine =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.antiTheftForEngine =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.antiTheftForEngine =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p> 
                                </li>
                            </ul>
                            <h3>操控配置</h3>
                            <ul>
                                <li>
                                    <p><span class="key">ABS防抱死</span><span class="val">
                                     <#if vinVehicle.abs ??>  
                                     <#if vinVehicle.abs =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.abs =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.abs =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>  
                                    </span></p>
                                </li>
                                <li>
                                    <p><span class="key">制动力分配(EBD/CBC等)</span><span class="val">
                                     <#if vinVehicle.brakeForceDistribution ??>  
                                     <#if vinVehicle.brakeForceDistribution =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.brakeForceDistribution =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.brakeForceDistribution =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if> 
                                    </span></p>
                                </li>
                                <li>
                                    <p><span class="key">刹车辅助(EBA/BAS/BA等)</span><span class="val">
                                     <#if vinVehicle.bas ??>  
                                     <#if vinVehicle.bas =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.bas =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.bas =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p>
                                </li>
                                <li>
                                    <p><span class="key">牵引力控制(ASR/TCS/TRC等)</span><span class="val">
                                     <#if vinVehicle.tractionControlSystem ??>  
                                      <#if vinVehicle.tractionControlSystem =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.tractionControlSystem =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.tractionControlSystem =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">车身稳定控制(ESP/DSC/VSC等)</span><span class="val">
                                    <#if vinVehicle.stabilityControl ??>  
                                     <#if vinVehicle.stabilityControl =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.stabilityControl =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.stabilityControl =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p>
                                </li>
                                <li>
                                    <p><span class="key">陡坡缓降</span><span class="val">
                                     <#if vinVehicle.hillDecentControl ??>  
                                     <#if vinVehicle.hillDecentControl =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.hillDecentControl =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.hillDecentControl =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">自动驻车</span><span class="val">
                                     <#if vinVehicle.automaticParking ??>  
                                     <#if vinVehicle.automaticParking =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.automaticParking =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.automaticParking =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">上坡辅助</span><span class="val">
                                     <#if vinVehicle.hillStartAssist ??>  
                                     <#if vinVehicle.hillStartAssist =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.hillStartAssist =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.hillStartAssist =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">可变悬挂</span><span class="val">
                                     <#if vinVehicle.variableSuspension ??>  
                                     <#if vinVehicle.variableSuspension =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.variableSuspension =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.variableSuspension =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">空气悬挂</span><span class="val">
                                     <#if vinVehicle.airSuspension ??>  
                                     <#if vinVehicle.airSuspension =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.airSuspension =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.airSuspension =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">可变转向比</span><span class="val">
                                     <#if vinVehicle.variableSteeringRatio ??>  
                                     <#if vinVehicle.variableSteeringRatio =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.variableSteeringRatio =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.variableSteeringRatio =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                            </ul>
                            <h3>外部配置</h3>
                            <ul>
                                <li>
                                    <p><span class="key">电动天窗</span><span class="val">
                                    <#if vinVehicle.electricSkylight ??>  
                                     <#if vinVehicle.electricSkylight =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricSkylight =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.electricSkylight =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">全景天窗</span><span class="val">
                                     <#if vinVehicle.panoramaSkylight ??>  
                                     <#if vinVehicle.panoramaSkylight =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.panoramaSkylight =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.panoramaSkylight =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">运动外观套件</span><span class="val">
                                     <#if vinVehicle.sportAppearance ??>  
                                     <#if vinVehicle.sportAppearance =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.sportAppearance =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.sportAppearance =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">电动吸合门</span><span class="val">
                                     <#if vinVehicle.electricDool ??>  
                                     <#if vinVehicle.electricDool =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricDool =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.electricDool =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">电动后备箱</span><span class="val">
                                    <#if vinVehicle.electricTrunk ??>  
                                    <#if vinVehicle.electricTrunk =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricTrunk =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.electricTrunk =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                            </ul>
                            <h3>内部配置</h3>
                            <ul>
                                <li>
                                    <p><span class="key">真皮方向盘</span><span class="val">
                                    <#if vinVehicle.leatherSteeringWheel ??>  
                                    <#if vinVehicle.leatherSteeringWheel =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.leatherSteeringWheel =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.leatherSteeringWheel =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">方向盘上下调节</span><span class="val">
                                    <#if vinVehicle.verticalAdjustSteeringWheel ??>  
                                     <#if vinVehicle.verticalAdjustSteeringWheel =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.verticalAdjustSteeringWheel =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.verticalAdjustSteeringWheel =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">方向盘前后调节</span><span class="val">
                                     <#if vinVehicle.horizontalAdjustSteeringWheel ??>  
                                     <#if vinVehicle.horizontalAdjustSteeringWheel =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.horizontalAdjustSteeringWheel =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.horizontalAdjustSteeringWheel =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">方向盘电动调节</span><span class="val">
                                     <#if vinVehicle.electricAdjustSteeringWheel ??>  
                                     <#if vinVehicle.electricAdjustSteeringWheel =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricAdjustSteeringWheel =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.electricAdjustSteeringWheel =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">多功能方向盘</span><span class="val">
                                     <#if vinVehicle.multiFunctionSteeringWheel ??>  
                                     <#if vinVehicle.multiFunctionSteeringWheel =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.multiFunctionSteeringWheel =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.multiFunctionSteeringWheel =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">方向盘换挡</span><span class="val">
                                     <#if vinVehicle.steeringWheelShift ??>  
                                     <#if vinVehicle.steeringWheelShift =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.steeringWheelShift =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.steeringWheelShift =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">定速巡航</span><span class="val">
                                     <#if vinVehicle.ccs ??>  
                                     <#if vinVehicle.ccs =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.ccs =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.ccs =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">自适应巡航</span><span class="val">
                                     <#if vinVehicle.acc ??>  
                                     <#if vinVehicle.acc =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.acc =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.acc =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前倒车雷达</span><span class="val">
                                     <#if vinVehicle.reversingRadar ??>  
                                     <#if vinVehicle.reversingRadar =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.reversingRadar =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.reversingRadar =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后倒车雷达</span><span class="val">
                                     <#if vinVehicle.reversingRadarEnd ??>  
                                     <#if vinVehicle.reversingRadarEnd =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.reversingRadarEnd =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.reversingRadarEnd =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">倒车视频影像</span><span class="val">
                                     <#if vinVehicle.reverseVideo ??>  
                                     <#if vinVehicle.reverseVideo =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.reverseVideo =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.reverseVideo =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">泊车辅助</span><span class="val">
                                    <#if vinVehicle.parkingAssist ??>  
                                    <#if vinVehicle.parkingAssist =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.parkingAssist =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.parkingAssist =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">全景摄像头</span><span class="val">
                                     <#if vinVehicle.panoramaCamera ??>  
                                     <#if vinVehicle.panoramaCamera =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.panoramaCamera =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.panoramaCamera =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">行车电脑显示屏</span><span class="val">
                                    <#if vinVehicle.ecuDisplay ??>  
                                    <#if vinVehicle.ecuDisplay =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.ecuDisplay =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.ecuDisplay =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">自动泊车入位</span><span class="val">
                                    <#if vinVehicle.pav ??>  
                                    <#if vinVehicle.pav =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.pav =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.pav =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">HUD抬头数字显示</span><span class="val">
                                     <#if vinVehicle.hudDisplay ??>  
                                     <#if vinVehicle.hudDisplay =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.hudDisplay =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.hudDisplay =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">夜视系统</span><span class="val">
                                     <#if vinVehicle.nvs ??>  
                                     <#if vinVehicle.nvs =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.nvs =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.nvs =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">并线辅助</span><span class="val">
                                     <#if vinVehicle.doublingAssit ??>  
                                     <#if vinVehicle.doublingAssit =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.doublingAssit =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.doublingAssit =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">主动刹车</span><span class="val">
                                    <#if vinVehicle.activeBrake ??>  
                                     <#if vinVehicle.activeBrake =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.activeBrake =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.activeBrake =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                            </ul>
                            <h3>座椅配置</h3>
                            <ul>
                                <li>
                                    <p><span class="key">真皮座椅</span><span class="val">
                                     <#if vinVehicle.leatherSeat ??>  
                                     <#if vinVehicle.leatherSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.leatherSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.leatherSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">运动座椅</span><span class="val">
                                     <#if vinVehicle.sportSeat ??>  
                                     <#if vinVehicle.sportSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.sportSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.sportSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">座椅高低调节</span><span class="val">
                                    <#if vinVehicle.adjustSeatHeight ??>  
                                     <#if vinVehicle.adjustSeatHeight =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustSeatHeight =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustSeatHeight =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">腰部支撑调节</span><span class="val">
                                     <#if vinVehicle.adjustLumbarSupport ??>  
                                     <#if vinVehicle.adjustLumbarSupport =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustLumbarSupport =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustLumbarSupport =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">肩部支撑调节</span><span class="val">
                                     <#if vinVehicle.adjustShoulderSupport ??>  
                                     <#if vinVehicle.adjustShoulderSupport =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustShoulderSupport =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustShoulderSupport =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">驾驶座座椅电动调节</span><span class="val">
                                     <#if vinVehicle.electricAdjustDriverSeat ??>  
                                     <#if vinVehicle.electricAdjustDriverSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricAdjustDriverSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.electricAdjustDriverSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">副驾驶座座椅电动调节</span><span class="val">
                                     <#if vinVehicle.electricAdjustCodriverSeat ??>  
                                     <#if vinVehicle.electricAdjustCodriverSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricAdjustCodriverSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.electricAdjustCodriverSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排座椅电动调节</span><span class="val">
                                    <#if vinVehicle.electricAdjustEndSeat ??>  
                                    <#if vinVehicle.electricAdjustEndSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricAdjustEndSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.electricAdjustEndSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">电动座椅记忆</span><span class="val">
                                     <#if vinVehicle.electricMemorySeat ??>  
                                     <#if vinVehicle.electricMemorySeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricMemorySeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.electricMemorySeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前排座椅加热</span><span class="val">
                                     <#if vinVehicle.heatFrontSeat ??>  
                                     <#if vinVehicle.heatFrontSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.heatFrontSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.heatFrontSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排座椅加热</span><span class="val">
                                    <#if vinVehicle.heatEndSeat ??>  
                                    <#if vinVehicle.heatEndSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.heatEndSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.heatEndSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前排座椅通风</span><span class="val">
                                    <#if vinVehicle.ventilationSeat ??>  
                                    <#if vinVehicle.ventilationSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.ventilationSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.ventilationSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排座椅通风</span><span class="val">
                                    <#if vinVehicle. ventilationSeatEnd ??>  
                                    <#if vinVehicle. ventilationSeatEnd =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle. ventilationSeatEnd =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.ventilationSeatEnd =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前排座椅按摩</span><span class="val">
                                     <#if vinVehicle.massageSeat ??>  
                                     <#if vinVehicle.massageSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.massageSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.massageSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排座椅按摩</span><span class="val">
                                     <#if vinVehicle.massageSeatEnd ??>  
                                     <#if vinVehicle.massageSeatEnd =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.massageSeatEnd =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.massageSeatEnd =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排座椅整体放倒</span><span class="val">
                                    <#if vinVehicle.allDownEndSeat ??>  
                                    <#if vinVehicle.allDownEndSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.allDownEndSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.allDownEndSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排座椅比例放倒</span><span class="val">
                                    <#if vinVehicle.ratioDownEndSeat ??>  
                                    <#if vinVehicle.ratioDownEndSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.ratioDownEndSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.ratioDownEndSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">第二排靠背角度调节</span><span class="val">
                                    <#if vinVehicle.adjustSecondBackrestAngle ??>  
                                    <#if vinVehicle.adjustSecondBackrestAngle =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustSecondBackrestAngle =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustSecondBackrestAngle =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">第二排座椅移动</span><span class="val">
                                     <#if vinVehicle.adjustSecondSeatMove ??>  
                                     <#if vinVehicle.adjustSecondSeatMove =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustSecondSeatMove =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustSecondSeatMove =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">第三排座椅</span><span class="val">
                                     <#if vinVehicle.thirdSeat ??>  
                                     <#if vinVehicle.thirdSeat =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.thirdSeat =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.thirdSeat =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前座中央扶手</span><span class="val">
                                    <#if vinVehicle.frontCentralArmrest ??>  
                                    <#if vinVehicle.frontCentralArmrest =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.frontCentralArmrest =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.frontCentralArmrest =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后座中央扶手</span><span class="val">
                                     <#if vinVehicle.endCentralArmrest ??>  
                                     <#if vinVehicle.endCentralArmrest =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.endCentralArmrest =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.endCentralArmrest =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排杯架</span><span class="val">
                                    <#if vinVehicle.endCupHolder ??>  
                                    <#if vinVehicle.endCupHolder =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.endCupHolder =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.endCupHolder =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                            </ul>
                            <h3>多媒体配置</h3>
                            <ul>
                                <li>
                                    <p><span class="key">中控台彩色大屏</span><span class="val">
                                    <#if vinVehicle.controlLargeScreen ??>  
                                     <#if vinVehicle.controlLargeScreen =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.controlLargeScreen =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.controlLargeScreen =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">中控液晶屏分屏显示</span><span class="val">
                                    <#if vinVehicle.consoleScreenDisplay ??>  
                                    <#if vinVehicle.consoleScreenDisplay =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.consoleScreenDisplay =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.consoleScreenDisplay =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">人机交互系统</span><span class="val">
                                    <#if vinVehicle.humanComputer ??>  
                                     <#if vinVehicle.humanComputer =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.humanComputer =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.humanComputer =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">GPS导航系统</span><span class="val">
                                     <#if vinVehicle.gps ??>  
                                     <#if vinVehicle.gps =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.gps =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.gps =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">定位互动服务</span><span class="val">
                                     <#if vinVehicle.locationInteractionService ??>  
                                     <#if vinVehicle.locationInteractionService =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.locationInteractionService =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.locationInteractionService =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">蓝牙/车载电话</span><span class="val">
                                     <#if vinVehicle.bluetoothCarPhone ??>  
                                     <#if vinVehicle.bluetoothCarPhone =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.bluetoothCarPhone =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.bluetoothCarPhone =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">车载信息服务</span><span class="val">
                                     <#if vinVehicle.carTelematics ??>  
                                     <#if vinVehicle.carTelematics =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.carTelematics =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.carTelematics =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">外接音源接口(AUX/USB/iPod等)</span><span class="val">
                                     <#if vinVehicle.aux ??>  
                                     <#if vinVehicle.aux =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.aux =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.aux =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">音频格式支持(MP3,WMA,CD)</span><span class="val">
                                     <#if vinVehicle.mp3 ??>  
                                     <#if vinVehicle.mp3 =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.mp3 =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.mp3 =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">单碟CD</span><span class="val">
                                     <#if vinVehicle.simpleCd ??>  
                                     <#if vinVehicle.simpleCd =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.simpleCd =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.simpleCd =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">多碟CD</span><span class="val">
                                     <#if vinVehicle.multiCd ??>  
                                     <#if vinVehicle.multiCd =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.multiCd =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.multiCd =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">虚拟多碟CD</span><span class="val">
                                     <#if vinVehicle.virtualMultiCd ??>  
                                     <#if vinVehicle.virtualMultiCd =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.virtualMultiCd =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.virtualMultiCd =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">单碟DVD</span><span class="val">
                                     <#if vinVehicle.simpleDvd ??>  
                                     <#if vinVehicle.simpleDvd =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.simpleDvd =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.simpleDvd =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">多碟DVD</span><span class="val">
                                     <#if vinVehicle.multiDvd ??>  
                                     <#if vinVehicle.multiDvd =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.multiDvd =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.multiDvd =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">扬声器数量</span><span class="val">
                                    <#if vinVehicle.speakerNumber ??>  
                                     ${(vinVehicle.speakerNumber)}
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排液晶屏</span><span class="val">
                                    <#if vinVehicle.endLcd ??>  
                                     <#if vinVehicle.endLcd =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.endLcd =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.endLcd =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">车载电视</span><span class="val">
                                    <#if vinVehicle.carTv ??>  
                                     <#if vinVehicle.carTv =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.carTv =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.carTv =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">内置硬盘</span><span class="val">
                                    <#if vinVehicle.builtInHardDisk ??>  
                                    <#if vinVehicle.builtInHardDisk =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.builtInHardDisk =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.builtInHardDisk =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                            </ul>
                            <h3>空调/冰箱</h3>
                            <ul>
                                <li>
                                    <p><span class="key">空调</span><span class="val">
                                    <#if vinVehicle.airConditioning ??>  
                                     <#if vinVehicle.airConditioning =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.airConditioning =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.airConditioning =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">自动空调</span><span class="val">
                                     <#if vinVehicle.autoAirConditioning ??>  
                                     <#if vinVehicle.autoAirConditioning =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.autoAirConditioning =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.autoAirConditioning =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排独立空调</span><span class="val">
                                    <#if vinVehicle.individualAirConditioning ??>  
                                     <#if vinVehicle.individualAirConditioning =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.individualAirConditioning =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.individualAirConditioning =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">温度分区控制</span><span class="val">
                                     <#if vinVehicle.tempZoneControl ??>  
                                     <#if vinVehicle.tempZoneControl =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.tempZoneControl =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.tempZoneControl =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后座出风口</span><span class="val">
                                     <#if vinVehicle.endSeatAirOutlet ??>  
                                     <#if vinVehicle.endSeatAirOutlet =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.endSeatAirOutlet =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.endSeatAirOutlet =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">空气调节/花粉过滤</span><span class="val">
                                    <#if vinVehicle.airFiltration ??>  
                                    <#if vinVehicle.airFiltration =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.airFiltration =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.airFiltration =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">车载冰箱</span><span class="val">
                                     <#if vinVehicle.carFridge ??>  
                                      <#if vinVehicle.carFridge =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.carFridge =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.carFridge =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                            </ul>
                            <h3>照明视野</h3>
                            <ul>
                                <li>
                                    <p><span class="key">氙气大灯</span><span class="val">
                                     <#if vinVehicle.hid ??>  
                                      <#if vinVehicle.hid =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.hid =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.hid =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">LED大灯</span><span class="val">
                                    <#if vinVehicle.led ??>  
                                     <#if vinVehicle.led =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.led =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.led =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">日间行车灯</span><span class="val">
                                    <#if vinVehicle.daytimeDrivingLight ??>  
                                    <#if vinVehicle.daytimeDrivingLight =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.daytimeDrivingLight =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.daytimeDrivingLight =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前雾灯</span><span class="val">
                                     <#if vinVehicle.frontFogLight ??>  
                                     <#if vinVehicle.frontFogLight =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.frontFogLight =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.frontFogLight =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">自动头灯</span><span class="val">
                                     <#if vinVehicle.autoHeadlight ??>  
                                     <#if vinVehicle.autoHeadlight =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.autoHeadlight =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.autoHeadlight =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">转向头灯(辅助灯)</span><span class="val">
                                     <#if vinVehicle.frontTurningLight ??>  
                                     <#if vinVehicle.frontTurningLight =='有'>
                                      <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.frontTurningLight =='选'>
                                      <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.frontTurningLight =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">大灯高度可调</span><span class="val">
                                    <#if vinVehicle.adjustHeadlightHeight ??>  
                                    <#if vinVehicle.adjustHeadlightHeight =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.adjustHeadlightHeight =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.adjustHeadlightHeight =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">大灯清洗装置</span><span class="val">
                                     <#if vinVehicle.clearHeadlight ??>  
                                     <#if vinVehicle.clearHeadlight =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.clearHeadlight =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.clearHeadlight =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前电动车窗</span><span class="val">
                                     <#if vinVehicle.electricFrontWindow ??>  
                                     <#if vinVehicle.electricFrontWindow =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricFrontWindow =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.electricFrontWindow =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后电动车窗</span><span class="val">
                                     <#if vinVehicle.electricEndWindow ??>  
                                     <#if vinVehicle.electricEndWindow =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricEndWindow =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.electricEndWindow =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">前车窗防夹手功能</span><span class="val">
                                    <#if vinVehicle.preventClampHandWindow ??>  
                                    <#if vinVehicle.preventClampHandWindow =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.preventClampHandWindow =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.preventClampHandWindow =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后车窗防夹手功能</span><span class="val">
                                    <#if vinVehicle.preventClampHandEnd ??>  
                                    <#if vinVehicle.preventClampHandEnd =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.preventClampHandEnd =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.preventClampHandEnd =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">隔热玻璃</span><span class="val">
                                     <#if vinVehicle.heatGlass ??>  
                                     <#if vinVehicle.heatGlass =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.heatGlass =='选'>
                                     <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.heatGlass =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">感应雨刷</span><span class="val">
                                    <#if vinVehicle.inductionRearWiper ??>  
                                     <#if vinVehicle.inductionRearWiper =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.inductionRearWiper =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.inductionRearWiper =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后视镜电动调节</span><span class="val">
                                    <#if vinVehicle.electricAdjustRearviewMirror ??>  
                                     <#if vinVehicle.electricAdjustRearviewMirror =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.electricAdjustRearviewMirror =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.electricAdjustRearviewMirror =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后视镜电动折叠</span><span class="val">
                                     <#if vinVehicle.autoFoldRearviewMirror ??>  
                                     <#if vinVehicle.autoFoldRearviewMirror =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.autoFoldRearviewMirror =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.autoFoldRearviewMirror =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">内后视镜自动防眩目</span><span class="val">
                                     <#if vinVehicle.preventDazzleRearviewMirror ??>  
                                      <#if vinVehicle.preventDazzleRearviewMirror =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.preventDazzleRearviewMirror =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.preventDazzleRearviewMirror =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">外后视镜自动防眩目</span><span class="val">
                                     <#if vinVehicle.preventDazzleRearviewMirrorOut ??>  
                                      <#if vinVehicle.preventDazzleRearviewMirrorOut =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.preventDazzleRearviewMirrorOut =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.preventDazzleRearviewMirrorOut =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后视镜记忆</span><span class="val">
                                     <#if vinVehicle.memoryRearviewMirror ??>  
                                     <#if vinVehicle.memoryRearviewMirror =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.memoryRearviewMirror =='选'>
                                     <ins class="pz-2"></ins>
                                    </#if>
                                    <#if vinVehicle.memoryRearviewMirror =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后视镜加热</span><span class="val">
                                     <#if vinVehicle.heatRearviewMirror ??>  
                                     <#if vinVehicle.heatRearviewMirror =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.heatRearviewMirror =='选'>
                                     <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.heatRearviewMirror =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后排侧遮阳帘</span><span class="val">
                                     <#if vinVehicle.endSideWindowsSunshade ??>  
                                     <#if vinVehicle.endSideWindowsSunshade =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.endSideWindowsSunshade =='选'>
                                     <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.endSideWindowsSunshade =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后风挡遮阳帘</span><span class="val">
                                    <#if vinVehicle.endWindshieldSunshade ??>  
                                    <#if vinVehicle.endWindshieldSunshade =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.endWindshieldSunshade =='选'>
                                     <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.endWindshieldSunshade =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">遮阳板化妆镜</span><span class="val">
                                    <#if vinVehicle.sunVisorMirror ??>  
                                    <#if vinVehicle.sunVisorMirror =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.sunVisorMirror =='选'>
                                     <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.sunVisorMirror =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">后雨刷</span><span class="val">
                                     <#if vinVehicle.rearWiper ??>
                                      <#if vinVehicle.rearWiper =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.rearWiper =='选'>
                                     <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.rearWiper =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                    <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                                <li>
                                    <p><span class="key">车内氛围灯</span><span class="val">
                                     <#if vinVehicle.interiorAtmosphereLight ??>  
                                     <#if vinVehicle.interiorAtmosphereLight =='有'>
                                     <ins class="pz-1"></ins>
                                     </#if>
                                     <#if vinVehicle.interiorAtmosphereLight =='选'>
                                     <ins class="pz-2"></ins>
                                     </#if>
                                     <#if vinVehicle.interiorAtmosphereLight =='无'>
                                      <ins class="pz-3"></ins>
                                     </#if>
                                     <#else>   
                                     <ins class="pz-3"></ins>
                                    </#if>
                                    </span></p> 
                                </li>
                            </ul>
                        </div>
                         <ul class="exegesis" style="margin:0 0 20px 20px;">
                            <li><ins class="pz-1"></ins>标配</li>
                            <li><ins class="pz-2"></ins>选配</li>
                            <li><ins class="pz-3"></ins>无</li>
                          </ul>
                    </#if>
                    
                    <!--购车服务-->
                    <div class="service_car content_tab">
                        <blockquote>
                            <h3>车辆上牌、过户服务</h3>
                            <p>购车后汽车街为您提供方便快捷的车辆上牌、过户服务，让复杂繁琐的手续办理变得轻松简单。</p>
                        </blockquote>
                        <blockquote>
                            <h3>车辆金融服务</h3>
                            <p>汽车街提供多种灵活便捷的金融产品和服务，助您提前拥有爱车。手续简便、审批高效、放款迅速。</p>
                            <a href="<@baseUrl.parentHome />/service/finance">点击进入</a>
                        </blockquote>
                        <blockquote>
                            <h3>车辆定损服务</h3>
                            <p>汽车街为您办理保险办理、车辆续保、事故定损、车辆维修、保险理赔在内的一站式服务。</p>
                            <a href="<@baseUrl.parentHome />/service/assess">点击进入</a>
                        </blockquote>
                        <blockquote>
                            <h3>车辆延保服务</h3>
                            <p>车龄5年且行驶里程8万公里，通过汽车街二手车认证的车辆均可参加质保计划，并提供6个月至1年不等的服务期限。</p>
                            <a href="<@baseUrl.parentHome />/service/warranty">点击进入</a>
                        </blockquote>
                        <blockquote>
                            <h3>车辆美容和保养服务</h3>
                            <p>多种美容套餐及常规保养套餐供您选择，媲美原厂的服务品质让您的爱车增值加分。</p>
                            <a href="<@baseUrl.parentHome />/service/cosmetology">点击进入</a>
                        </blockquote>
                    </div>
                    <!--End of 购车服务-->
                </div>
                <!-- End of info_content -->
            </div>
            <!-- End of car_info -->
            <div class="second_booking">
                <#--edit by zjz 是否可以下定通过订金判断 2015-12-10 16:56:53-->
            	<#if !(fp.deposit)?? ||  (fp.deposit == 0)>
                    <a class="<#if (shop.telephone)?? && shop.telephone != "" && (shop.telephone?length < 14)>telephone f18<#else>telephone f16</#if>">
                        <img src="<@baseUrl.static />/common/build/2.00/images/used_car/phone.png" width="17" alt="">
                        <#if (shop.telephone)?? && shop.telephone != "">${shop.telephone}<#else>400-821-8889</#if>
                    </a> 
                <#else>
                    <#if prepayFlag == "1">
                        <a href="javascript:;" class="buy_now">立即下订</a>
                    <#elseif prepayFlag == "2">
                        <a href="javascript:;" class="reservation">已预订</a>
                    <#elseif prepayFlag == "3">
                        <a href="javascript:;" class="sold">已售出</a>
                    <#else>
                        <a href="javascript:;" class="under_carriage">已下架</a>
                    </#if>
                </#if> 
                
                <div id="price2">
                    <#if !(fp.deposit)?? ||  (fp.deposit == 0)>
                        <div class="ckj2"><span class="white">参考价</span><#if vehicle.hidden?? && vehicle.hidden>面议<#else><b>${((vehicle.finalTransactionPrice / 10000)?string("0.00"))!"0.00"}</b><span>万元</span></#if></div>
                    <#else>
                        <div class="ckj1"><span class="white">参考价</span><#if vehicle.hidden?? && vehicle.hidden>面议<#else><b>${((vehicle.finalTransactionPrice / 10000)?string("0.00"))!"0.00"}</b><span>万元</span></#if></div>
                        <p>订金${(prePrice)!}元，可全额退款</p>
                    </#if>
                </div>
            </div>
        </div>
        <!-- End of 右侧内容 -->
    </div>
    <!-- End of container -->
</div>

<div class="clearfix"></div>

<!--计算器-->
<div id="calcu" class="tip">
    <a class="tipclose"></a>
    <h2>贷款计算器</h2><p class="ps">计算结果仅供参考，实际费用请垂询经销商</p>
    <div class="clearfix"></div>
    <div class="calcu_content">
        <div class="amount">
            <p class="result">每月还款</p>
            <div class="sum">
                <span></span><ins>元</ins>
            </div>
        </div>
        
        <div class="row">
            <p>车价</p><span class="error_text"></span>
            <div class="input-1">
                <input type="text" class="price"><label>万元</label>
            </div>
        </div>
        <div class="row">
            <p>首付款</p><span class="error_text"></span>
            <div class="input-1">
                <input type="text" class="first"><label>万元</label>
            </div>
        </div>
        <div class="row">
            <p>期限</p>
            <div class="select_month">
                <#if DefaultInterestRate??>
                <span id="cal1Rate" value="${(DefaultInterestRate.interestRate?if_exists?string.number)!}">${(DefaultInterestRate.loanPeriod)!}期</span>
                <ul>
                    <#list finInterestRates as interestRate>
                        <li onclick="modifyRate1('${(interestRate.interestRate?if_exists?string.number)!}')">${(interestRate.loanPeriod)!}期</li>
                    </#list>
                </ul>
               </#if>
            </div>
        </div>
        <button></button>
        <div class="clearfix"></div>
    </div>
</div>
<!--计算器end-->

<div class="UED_hide" id="tip-success">
    <div class="tip-success">
        <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
        <div class="tip-success-box">
            <p>预约成功，我们的工作人员会尽快与您联系</p>
            <span>3秒后自动关闭</span>
        </div>
    </div>
</div>

<#include "/include/footer.ftl">

<script language="javascript" src="<@baseUrl.static />/common/build/2.00/js/jq.layer.js<@baseUrl.time />"></script>
<script language="javascript" src="<@baseUrl.static />/common/build/2.00/js/used_car/used_car.js<@baseUrl.time />"></script>
<script language="javascript" src="<@baseUrl.static />/common/build/2.00/js/jquery.cookie.js"></script>

<script>
$(document).ready(function() {
    $(".small .pic_list li:first").addClass("cur");
       $(".exegesis").hide();
    /*金融服务*/
    $(".calculator a").click(function(){
        var _tip = $(this).attr("id");
        switch(_tip){
            case 'yg':$.LAYER.show({id:'calcu',overlay:{opacity:0}});break
        }
        bgShow();
    })
    
    $("#calcu button").click(function(){
        var corpus = $("#calcu .price").val() - $("#calcu .first").val();           //贷款本金(单位万元)
        var rate = $("#cal1Rate").attr("value")/12;                                 //利率(单位%)
        var _string = $("#calcu .select_month span").text().indexOf("期")
        var month = $("#calcu .select_month span").text().substr(0,_string);  //还款月数
        
        if( errorText3($("#calcu .price"),"请输入您要计算的车价") && errorText3($("#calcu .first"),"请输入您准备支付的首付款")){
            var amount = monthLoan(corpus,rate,month)
            $("#calcu .result span").text(figure(amount))
            $(this).parent().parent().find(".amount").slideDown();
        }
    })


    $(".info_nav li").click(function(){
        var _index = $(".info_nav li").index(this);
        var _tab = $(this).attr("id")
        $(".info_nav li").eq(_index).addClass("cur").siblings().removeClass("cur");
        $(".content_tab").hide();
        switch(_tab){
            case "base_info":
              $(".base_info").show()
               $(".exegesis").hide()
              break;
            case "report":
              $(".report").show()
              break;
            case "para_detail":
              $(".para_detail").show()
               $(".exegesis").show()
              break;
            case "service_car":
              $(".service_car").show()
              break;
        }
    })

    $("#vehicleDesc").html(unescape("<#if fp.memo??>${(fp.memo?replace("\r","")?replace("\n",""))!}<#else> </#if>"));
    
    $(".buy_now").click(function() {
       //  if ("${(userIdentity.username)!}" == "") {
       //     window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/no-haggle/${(vehicle.id)!}");
       //    return false;    
       //  }
        window.location.href = "<@baseUrl.home />/no-haggle/nohaggle-order/${fp.id}";
    });
    
    //预约处理
    $("#booking_now").click(function(){
        var area = $(".select_area span").text();
        if(area == "请选择省份") {
            area = "";
        }
        var city = $(".select_city span").text();
        if(city == "请选择城市") {
            city = "";
        }
        var _name = $(".name").val();
        var _phone = $(".mobile").val();
        if( isName(_name) && isPhone(_phone) && isArea(area,city) ){
            var flag = $.cookie(_phone + "_" + ${fp.id});
            if (flag == "1") {
                alert("该车您已预约！");
                  return;
               }
               
            $.ajax({
                 url :"<@baseUrl.home />/no-haggle/appoint",
                 type: "post",
                 cache: false,
                 data : {
                     customerName: _name,
                     cellPhone: _phone,
                     province: area,
                     city: city,
                     id: "${fp.id}"
                 }
            }).done(function(result) {
                if (result.success) {
                    var data = result.data;
                    jQuery.LAYER.show({id:'tip-success',overlay:{opacity:0.5}});
                    setTimeout('$.LAYER.close()',3000);
                    $(".name").val("");
                    $(".mobile").val("");
                    $(".select_area span").text("省份").css("color","#aaa");
                    $(".select_city span").text("城市").css("color","#aaa");
                    $.cookie(_phone + "_" + ${fp.id},"1",{expires:30});
                }
            });
        } else {
            return false;
        }
    });
    
    // 统计点击数量
    $.ajax({
         url :"<@baseUrl.home />/no-haggle/count",
         type: "post",
         data : {
             id: "${fp.id}"
         }
    }).done(function(data) {
    });
    
    
    var _bdUrl = location.href;
    var _bdDesc = '${(vehicle.brand)!} ${(vehicle.vehicleModel)!} ${(vehicle.sweptVolumeStandard)!} ${(vehicle.selledName)!}';
    var _bdPic = $(".car_picture .big").find("img").attr("src");
    
    var _defaultText = _bdDesc;
    /*分享代码*/
    window._bd_share_config = {
        common : {
            bdText : _defaultText, 
            bdDesc :'', 
            bdUrl :_bdUrl,   
            bdPic : _bdPic,
            bdMiniList:['weixin','tsina','qzone','renren','tqq','tieba','douban','sqq','ty']
        },
        share : [{
            "bdSize" : 16
        }],
    }
    with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion='+~(-new Date()/36e5)];
    
});


//定义其他js方法
function escape2Html(str) {
    if (str == null || str == '') return '';
    var arrEntities={'lt':'<','gt':'>','nbsp':' ','amp':'&','quot':'"'};
    return str.replace(/&(lt|gt|nbsp|amp|quot);/ig,function(all,t){return arrEntities[t];});
};

function return2Br(str) {
 return str.replace(/\n\r/g,'');
}

function removeHtmlTab(tab) {
    return tab.replace(/<[^<>]+?>/g,'');    //删除所有HTML标签
};

/*月供计算器*/
function monthLoan(corpus,rate,month){      
    var pow = Math.pow((1+rate/100),month);
    var loan = corpus*10000*rate/100*pow/(pow-1);
    return loan.toFixed(2);
}

/*修改计数器1的利率*/
function modifyRate1(rate){
    $("#cal1Rate").attr("value", rate);
}

//通过省市一级联动由id查询更新为按省市名查询
function selectCity(provinceName) {
    if (provinceName!="") {
        $.ajax({
            url :"<@baseUrl.home />/no-haggle/getUsedcarCity",
            type: "get",
            data : {province : provinceName},
            success : function(result) {
                $(".select_city ul").empty();
                $(".select_city span").html("城市");

                $.each(result.data, function(index, item){
                    $(".select_city ul").append("<li>" +item + "</li>");
                });
            }
        });
    } 
}

//添加收藏
function addFavorite() {
    $.ajax({
      url: "<@baseUrl.home />/member/favorite/new",
      type: "post",
      data: {
        refID: "${fp.id}",
        type: "1"
      }
    }).done(function(data) {
      if (data.success) {
        $("#fav_ed").show();
        $("#fav_no").hide();
        $("#favoriteID").val(data.id);
      } else {
          window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
      }
    });
}

//取消收藏
function cancelFavorite() {
    $.ajax({
      url: "<@baseUrl.home />/member/favorite/cancel",
      type: "post",
      data: {
        id: ${fp.id}
      }
    }).done(function(data) {
      if (data.success) {
        $("#fav_ed").hide();
        $("#fav_no").show();
      } else {
          window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent(window.location.href);
      }
    });
}


</script>

</body>
</html>
</#escape>
