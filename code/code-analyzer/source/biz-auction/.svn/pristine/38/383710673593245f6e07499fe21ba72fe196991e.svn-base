<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<#assign tempSelledName = "">
<#if (av.vehicle.selledName)??>
    <#assign tempSelledName = av.vehicle.selledName>
    <#if av.vehicle.selledName?starts_with(av.vehicle.vehicleModel)>
         <#assign tempSelledName = av.vehicle.selledName?replace(av.vehicle.vehicleModel, '', 'f')>
    </#if>
</#if>
<meta name="others" content="汽车街_竞拍大厅_在线拍_${(av.vehicle.brand)!} ${(av.vehicle.vehicleModel)!}<#if av.vehicle.sweptVolumeStandard?? && av.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}">
<title>${(av.vehicle.brand)!} ${(av.vehicle.vehicleModel)!}<#if av.vehicle.sweptVolumeStandard?? && av.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}_在线拍_竞拍大厅_汽车街</title>

<link href="<@baseUrl.static />/sell/build/1.00/css/detail.css<@baseUrl.time />" rel="stylesheet">
</head>
<body>
<#include "/include/header1.ftl">
<@layout.nav active = "auction" />

<div class="position">
  <a class="positionmain" href="<@baseUrl.parentHome />/">首页</a> &gt; <a href="<@baseUrl.home />"><span>竞拍大厅</span></a> &gt; <a href="<@baseUrl.home />/onlineauction/index"><span>在线拍</span></a> &gt; <span>车辆详情</span>
</div>
<div class="box detailbox clearfix">
 <a href="<@baseUrl.parentHome />/news/details?id=1440" class="rules">查看仲裁规则</a>
    <div class="detailbox-l">
        <div class="bigimgbox">
        <#if (av.vehicle.starPhotoList?? && av.vehicle.starPhotoList[0].photoUrl?? && av.vehicle.starPhotoList[0].photoUrl != "")>
            <img src="<@baseUrl.image />/${(action.getThumbImgUrl("520X390", "${(av.vehicle.starPhotoList[0].photoUrl)!}"))!}" style="width:520px; height:390px;" rel="<@baseUrl.image />/${(action.getThumbImgUrl("1024X768", "${(av.vehicle.starPhotoList[0].photoUrl)!}"))!}" id="jqzoom">
            <a href="javascript:;" class="left"><</a><a href="javascript:;" class="right">></a>
        <#else>
            <img src="<@baseUrl.static />/common/build/1.00/images/noimg.png" style="width:520px; height:390px;" rel="<@baseUrl.static />/common/build/1.00/images/noimg.png" id="jqzoom">
            <a href="javascript:;" class="left"><</a><a href="javascript:;" class="right">></a>
        </#if>
        </div>
        
        <!--
        <p class="img-txt"><i id="current">1</i>/${(photoNum)!} <span id="current-name">${(firstVehiclePhoto.photoName)!}</span></p>
        -->
        
        <div class="img-txt">
            展品编号：${(av.vehicle.code)!}
        </div>

        <div class="smallimgbox clearfix">
            <a class="smallimgbox-l" id="smallimgbox-l">&lt;</a>
            <div class="smallimglist">
            <ul id="smallimglist">
                <#list av.vehicle.starPhotoList as photo>
                    <#if photo?? && photo.photoUrl?? && (photo.photoUrl != "")>
                        <li>
                            <a href="javascript:;">
                                <img src="<@baseUrl.image />/${(action.getThumbImgUrl("90X66", "${(photo.photoUrl)!}"))!}" style="width: 90px; height: 66px;"
                                    mid="<@baseUrl.image />/${(action.getThumbImgUrl("520X390", "${(photo.photoUrl)!}"))!}" 
                                    big="<@baseUrl.image />/${(action.getThumbImgUrl("1024X768", "${(photo.photoUrl)!}"))!}" 
                                    data-photo-name="${(photo.photoName)!}">
                            </a>
                        </li>
                    </#if>
                </#list>
            </ul>
            </div>
            <a class="smallimgbox-r" id="smallimgbox-r">&gt;</a>
        </div>
        <#if av.auctionVehicle.seeCarAddr?? && av.auctionVehicle.seeCarAddr != "">
            <div class="detail-map">
                <#if av.auctionVehicle.seeCarAddr??>
                <p><span>看车地点</span> <span id="car-address">${(av.auctionVehicle.seeCarAddr)!}</span><#-- <a href="javascript:;">查看地图</a>--></p>
                </#if>
                <#if av.auctionVehicle.seeCarTime??>
                <p><span>看车时间</span> ${(av.auctionVehicle.seeCarTime)!} </p>
                </#if>
            </div>
        </#if>
        <p>
            <#if av.isFavorite == "1">
                <a href="javascript:;" class="detail-control-1" id="a3-3" style="display: none;">收藏</a>
                <a href="javascript:;" class="detail-control-1-on" id="a1-1">取消收藏</a>
            <#else>
                <a href="javascript:;" class="detail-control-1" id="a3-3">收藏</a>
                <a href="javascript:;" class="detail-control-1-on" id="a1-1" style="display: none;">取消收藏</a>
            </#if>
                                      
            <!-- <a href="javascript:;" class="detail-control-2">发到手机</a>  -->
        </p>
    </div>
    <div class="detailbox-r">
        <h2 class="detail-title">
        <#if av.vehicle.certified?? && av.vehicle.certified>
            <img src="<@baseUrl.static />/common/build/1.00/images/eqs.png">
        </#if>
        ${(av.vehicle.brand)!} ${(av.vehicle.vehicleModel)!}<#if av.vehicle.sweptVolumeStandard?? && av.vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</h2>
        <p class="detail-status-2">
            <#if av.auctionVehicle.status == 1>
                未开始 <span style="padding: 10px;">开始时间：${(av.auctionVehicle.planStartTime?datetime)!}</span>
            <#elseif av.auctionVehicle.status == 2>
                成交
            <#elseif av.auctionVehicle.status == 3>
                成交确认<span class="detail-subtitle">当前最高出价未达到保留价，拍卖师正在与车主协商是否降价成交</span>
            <#elseif av.auctionVehicle.status == 4>
                流拍
            <#elseif av.auctionVehicle.status == 5>
                距结束 <span id="hms" style="padding: 10px;">${av.hms}</span><span id="seconds" style="display: none;">${av.seconds}</span>
            <#elseif av.auctionVehicle.status == 6>
                暂停
            <#elseif av.auctionVehicle.status == 7>
                已下架
            </#if>
        </p>
        <#if av.auctionVehicle.status == 3>
        <#if av.isAlert>
            <#if av.auctionVehicle.avType == 1>
            <div class="detail-info detail-info-on banish">
                <blockquote>
                    <p>尊敬的客户，您当前出价：${(av.myBidPrice)!}元是最高价，我们的服务人员将尽快与委托方进行协商，如委托方愿意按此价格出售，我们将尽快和您联系。</p>
                </blockquote>
                <div class="clearfix"></div>
            </div>
            <#else>
            <div class="detail-info detail-info-on banish">
                <blockquote>
                    <h4>你只需再加价<span>${(av.auctionVehicle.reservePrice - av.myBidPrice)!}元</span>，即可竞得此车，是否加价？</h4>
                    <p>您当前出价：${(av.myBidPrice)!}元</p>
                    <p>该车保留价：${(av.auctionVehicle.reservePrice)!}元</p>
                    <a href="javascript:;" class="addprice">加价至保留价</a>
                </blockquote>
                <div class="remainder">
                    <p>剩余时间：</p>
                    <div id="CountMsg" class="HotDate">
                        <span id="restHms">${(av.restHms)!}</span><span id="restSeconds" style="display: none;">${(av.restSeconds)!}</span>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            </#if>
        </#if>
        </#if>
        
        <div class="detail-info">
        <#if av.priceDisp == "1">    
          <#if ((av.auctionVehicle.status == 3) && !av.isAlert) || (av.auctionVehicle.status != 3)>
          <div class="strat-sell">
            <div class="currentdiv">
              <label>当前价</label>
              <strong class="money" id="pricemoney"><#noescape>${(action.format(av.currentPrice))}</#noescape></strong>
              <span class="chujiacishu ">(已出价<span id="bid-count">${av.bidCount}</span>次)</span>
            </div>
            <div class="currentdiv">
              <label>我的出价</label><strong class="money" id="bid-price"><#if av.myBidPrice == 0>尚未出价<#else><#noescape>${action.format(av.myBidPrice)}</#noescape></#if></strong> <span id="current-first" class="current-first"<#if !av.isTopPrice> style="display: none;"</#if>>当前最高</span><span class="current-last" id="current-last" style="display: none;">出价慢了，请重新出价</span>
            </div>
            <div class="currentdiv">
              <label>出价</label>
              <div>
                <span id="has-bid" style="display: none;">${av.hasBid}</span>
                
                <strong id="paidbox" class="paidbox"><#noescape>${action.format(av.bidPrice)}</#noescape></strong>
                <span class="adddelbox">
                  <a href="javascript:;" id="addbtn" class="addbtn"></a>
                  <a href="javascript:;" id="delbtn" class="delbtn"></a>
                </span>
                
                <span class="addtip">加价幅度：<span id="plus-range">${(av.auctionVehicle.plusRange)!0}</span>元</span>
              </div>
            </div>
            <div class="addbtnbox">
              <p class="clearfix">
                <#--<a href="javascript:;" class="auction-btn-1<#if av.auctionVehicle.status != 5 || av.isTopPrice> auction-btn-dis</#if>" id="btn-bid">出价</a>-->
                <a href="javascript:;" class="auction-btn-1<#if av.auctionVehicle.status != 5 || av.isSp> auction-btn-dis</#if>" id="btn-bid">出价</a>
              </p>
            </div>
          </div>
          </#if>
        <#else>
            <div class="strat-sell">
            <div class="currentdiv" style="margin:20px 0 0 0">
                <label style="line-height:25px">当前价</label>
                <strong class="money" id="pricemoney" style="font-size:12px;line-height:25px;margin:5px 0 0 0;float:left">
                认证商户可见 <img src="<@baseUrl.static />/services/build/1.00/images/explain.png" alt="" title="欲成为认证商户请拨打：400-821-8889">
                </strong>
            </div>
            </div>
        </#if>
          
          <ul>
            <li>佣金率：${(av.auctionVehicle.buyerCommissionRate?string("#.##"))!"0"}%</li>
            <li>交易佣金：<span id="commission" <#if av.commission??&&av.commission != 0>style="color:red;"</#if>>
             ${av.commission}</span> 元</li>
            <li>办证手续费：${(av.auctionVehicle.licenseFee?string("0"))!"0"} 元</li>
            <li>出库费：${(av.auctionVehicle.exWarehouseFee?string("0"))!"0"} 元</li>
            <li>停车费：${(av.auctionVehicle.parkingFee?string("0"))!"0"} 元</li>
            <li>物流费：自理</li>
          </ul>
          
          <#if av.priceDisp == "1">
              <p class="curret-money">当前总价：<strong id="total-price">${av.totalPrice?string("0")}</strong> 元</p>
          </#if>
        </div>
        <ul class="detail-info-list">
          <li><span>上牌城市：</span> ${(av.vehicle.registerCity)!}</li>
          <li><span>车辆所在地：</span> ${(av.vehicle.currentCity)!}</li>
          <li><span>原车牌号：</span> <#if av.vehicle.licenseCode?? && (av.vehicle.licenseCode?length gt 1)>${(av.vehicle.licenseCode?substring(0,2))!}<#else>${(av.vehicle.licenseCode)!}</#if></li>
          <!-- <li><span>是否带牌拍：</span> <#if av.auctionVehicle?? && av.auctionVehicle.vehicle?? && av.auctionVehicle.vehicle.withLicense?? && av.auctionVehicle.vehicle.withLicense>是<#else>否</#if></li> -->
          <li><span>首次上牌：</span> ${(av.vehicle.registerLicenseYears?substring(0,4))!}-${(av.vehicle.registerLicenseYears?substring(4))!}</li>
          <#if av.vehicle.displayMileage??>
                <li><span>表显里程：</span> ${((av.vehicle.displayMileage)/10000)?string("0.00")!}万公里</li>
            </#if>
            <!-- 暂时不使用
          <li><span>排放标准：</span> ${(av.vehicle.sweptVolumeStandard)!}</li>
          -->
          <li><span>变速箱：</span> ${(av.vehicle.transmissionType)!}</li>
          <li><span>使用性质：</span> ${(av.vehicle.usingModel)!}</li>
        </ul>
        <dl class="other-info">
          <dt>车辆描述</dt>
          <dd>${(av.vehicle.vehicleDesc?replace("\r","")?replace("\n",""))!}</dd>
        </dl>
        <!-- 暂时不使用
        <#if av.vehicle.guaranteed?? && av.vehicle.guaranteed>
            <div class="qalist">
                <ul>
                    <li><h4>延保6个月</h4>
                        <p>免费赠送 <del>原价：1000元</del></p>
                    </li>
                    <li class="last"><h4>延保12个月</h4>
                        <p>延保12个月 <del>原价：2000元</del></p>
                    </li>
                </ul>
            </div>
        </#if>
        -->
    </div>
</div>
<div class="wp">
    <div class="detail-tab-box" id="detail-tab-box">
    <ul class="detail-tab">
        <li><a href="#a1" class="on">车辆信息</a></li>
        <li><a href="#a2">骨架损伤图</a></li>
        <li><a href="#a3">外观损伤图</a></li>
        <li><a href="#a4">内饰损伤图</a></li>
        <li><a href="#a5">车况检测</a></li>
        <li><a href="#a6">附件检测</a></li>
    </ul>
    </div>
    <div class="box detailtbl" id="a1">
        <div>
            <h3>检测报告<span>质检时间${(av.vehicle.assessmentDatetime?string('yyyy-MM-dd'))!}</span></h3>
            <#if av.vehicle.certified?? && av.vehicle.certified>
                <p class="tip-eqs">该车辆经过200项严酷检测，已成功通过EQS认证！</p>
            </#if>
            <table class="test-report">
            <thead>
                <tr>
                    <td width="355" class="txt-c">综合评分</td>
                    <td style="padding-left:50px;width:350px;">主要检测项目</td>
                    <td style="padding-left:50px;">得分</td>
                </tr>
            </thead>
            <tbody>
                <#list av.vehicle.checkItemCategoryScoreList as checkItemCategoryScore>
                    <#if (checkItemCategoryScore_index == 0)>
                        <tr>
                            <td rowspan="${av.vehicle.checkItemCategoryScoreList?size}" class="txt-c"><p>车况评分：${(av.vehicle.score?string("0.0"))!}</p>
                                <#if av.vehicle.grade?? && (av.vehicle.grade?trim != "")>
                                    <span class="lv-${av.vehicle.grade?substring(0,1)?lower_case}">${(av.vehicle.grade)!}</span>
                                </#if>
                            </td>
                            <td style="padding-left:50px;">${(checkItemCategoryScore.categoryName)!}</td>
                            <td style="padding-left:50px;">${(checkItemCategoryScore.score?string("0.0"))!}</td>
                        </tr>
                    <#else>
                        <tr>
                            <td style="padding-left:50px;">${(checkItemCategoryScore.categoryName)!}</td>
                            <td style="padding-left:50px;">${(checkItemCategoryScore.score?string("0.0"))!}</td>
                        </tr>
                    </#if>
                </#list>
            </tbody>
        </table>
            <h3>详细信息</h3>
            <div class="clearfix">
            <table class="infotbl">
                    <tr>
                        <th>VIN码</th>
                        <td>${(av.vehicle.vinCode)!}(${(av.vehicle.clearVin?string('清晰','不清晰'))!})</td>
                    </tr>
                    <tr>
                        <th>出厂日期</th>
                        <td>${(av.vehicle.producedYears?substring(0,4))!}年${(av.vehicle.producedYears?substring(4))!}月</td>
                    </tr>
                    <tr>
                        <th>上牌日期</th>
                        <td>${(av.vehicle.registerLicenseYears?substring(0,4))!}年${(av.vehicle.registerLicenseYears?substring(4))!}月</td>
                    </tr>
                    <tr>
                        <th>排气量</th>
                        <td>${(av.vehicle.sweptVolume)?string("0.0")!}${(av.vehicle.sweptVolumeType)!}</td>
                    </tr>
                    <!--<tr>
                        <th>环保标准</th>
                        <td>${(av.vehicle.sweptVolumeStandard)!}</td>
                    </tr> -->
                    <tr>
                        <th>上牌城市</th>
                        <td>${(av.vehicle.registerCity)!}</td>
                    </tr>
                    <tr>
                        <th>车辆所在地</th>
                        <td>${(av.vehicle.currentCity)!}</td>
                    </tr>
                    <tr>
                        <th>发动机号</th>
                        <td>${(av.vehicle.engineCode)!}</td>
                    </tr>
                </tbody>
            </table>
            <table class="infotbl infotbl-c">
                    <tr>
                        <th>车牌号</th>
                        <td><#if av.vehicle.licenseCode?? && (av.vehicle.licenseCode?length gt 1)>${(av.vehicle.licenseCode?substring(0,2))!}<#else>${(av.vehicle.licenseCode)!}</#if></td>
                    </tr>
                    <tr>
                        <th>车辆颜色</th>
                        <td>${(av.vehicle.bodyColor)!}</td>
                    </tr>
                    <tr>
                        <th>内饰颜色</th>
                        <td>${(av.vehicle.interiorColor)!}</td>
                    </tr>
                    <tr>
                        <th>最大功率</th>
                        <td>${(av.vehicle.power?c)!}kw</td>
                    </tr>
                    <tr>
                        <th>表显里程</th>
                        <td>
                        	<#if (av.vehicle.displayMileage)??>
	                        	${((av.vehicle.displayMileage)/10000)?string("0.00")!}万公里
                        	</#if>
                        </td>
                    </tr>
                    <tr>
                        <th>行驶证</th>
                        <td>${(av.vehicle.vehicleLicense?string("有","无"))!}</td>
                    </tr>
                    <!-- <tr>
                        <th>发动机号是否清晰</th>
                        <td>${(av.vehicle.clearEnginCode?string('是','否'))!}</td>
                    </tr> -->
                    <tr>
                        <th>变速箱类型</th>
                        <td>${(av.vehicle.transmissionType)!}</td>
                    </tr>
                </tbody>
            </table>
            <table class="infotbl">
                    <tr>
                        <th>燃料类型</th>
                        <td>${(av.vehicle.oilType)!}</td>
                    </tr>
                    <!-- <tr>
                        <th>车辆类型</th>
                        <td>${(av.vehicle.vehicleType)!}</td>
                    </tr> -->
                    <tr>
                        <th>使用性质</th>
                        <td>${(av.vehicle.usingModel)!}</td>
                    </tr>
                    <tr>
                        <th>过户次数</th>
                        <td>${(av.vehicle.transferNumber)!}</td>
                    </tr>
                    <tr>
                        <th>年审有效期</th>
                        <td>${(av.vehicle.nextAnnualExamination?string('yyyy年MM月dd日'))!}</td>
                    </tr>
                    <tr>
                        <th>交强险有效期</th>
                        <td>${(av.vehicle.nextCompulsoryInsurance?string('yyyy年MM月dd日'))!}</td>
                    </tr>
                    <tr>
                        <th>购置附加税完税证明</th>
                        <td>${(av.vehicle.purchaseTaxProof?string("有","无"))!}</td>
                    </tr>
                    <tr>
                        <th>产证</th>
                        <td>${(av.vehicle.propertyCertificate?string("有","无"))!}</td>
                    </tr>
                </tbody>
            </table>
        </div>
            <#if av.featureItem??>
                <h3>车辆配置</h3>
                <div class="configure">
                <ul>
                    <#if av.featureItem??>
                    <#list av.featureItem as s>
                        <#if (s?trim?length > 0)>
                            <li>${s}</li>
                        </#if>
                    </#list>
                    </#if>
                </ul>
                </div>
            </#if>
        </div>
        <div class="infotbl-1" id="a2">
            <h2>骨架损伤图 </h2>
            <div class="clearfix">
                
                <div class="listul-img">
                    <div class="carimg-1">
                      <#list av.vehicle.frameList as cfl>
                          <#if !cfl.good>
                              <#if cfl.axisx?? && cfl.axisy??>
                                  <div class="listul-img-ico" style="cursor: pointer; top:${(cfl.axisy)!}px; left:${(cfl.axisx)!}px;">${(cfl.itemOrder)!}
                                      <div class="ss-detail">
                                        <ins></ins>
                                        <p>
                                            <span class="listul-img-ico">${(cfl.itemOrder)!}</span>${(cfl.damageStatusSelected)!}
                                        </p>
                                        <img src="<@baseUrl.image />/${(action.getThumbImgUrl("350X200", "${(cfl.photoUrl)!}"))!}" style="width: 350px; height: 200px;">
                                    </div>                                      
                                  </div>
                              </#if>
                          </#if>
                      </#list>
                    </div>
                </div>
                <ul class="listul">
                    <#list av.vehicle.frameList as cfl>
                        <li>
                            <i>${(cfl.itemOrder)!}</i>
                            <strong>${(cfl.itemName)!}</strong>
                            <span>
                            <#if cfl.good>
                                <ins></ins>
                            <#else>
                              <del title="<#if cfl.damageStatusSelected?? && cfl.damageStatusSelected != "">${cfl.damageStatusSelected}<#else>有损伤</#if>"><#if cfl.damageStatusSelected?? && cfl.damageStatusSelected != "">${cfl.damageStatusSelected}<#else>有损伤</#if></del>
                            </#if>
                            </span>
                        </li>
                    </#list>
                </ul>
            </div>
        </div>
        <div class="infotbl-1" id="a3">
            <h2>外观损伤图</h2>
            <div class="clearfix">
                <div class="listul-img">
                    <div class="carimg-2">
                        <#list av.vehicle.featureList as cal>
                            <#if !cal.good>
                                <#if cal.axisx?? && cal.axisy??>
                                    <div class="listul-img-ico" style="cursor: pointer; top:${(cal.axisy)!}px; left:${(cal.axisx)!}px;">${(cal.itemOrder)!}
                                            <div class="ss-detail">
                                                <ins></ins>
                                                <p>
                                                    <span class="listul-img-ico">${(cal.itemOrder)!}</span>${(cal.damageStatusSelected)!}
                                                </p>
                                                <img src="<@baseUrl.image />/${(action.getThumbImgUrl("350X200", "${(cal.photoUrl)!}"))!}" style="width: 350px; height: 200px;">
                                            </div>
                                        </div>
                                    </#if>
                                </#if>
                        </#list>
                    </div>
                </div>
                <ul class="listul">
                    <#list av.vehicle.featureList as cal>
                        <li>
                            <i>${(cal.itemOrder)!}</i>
                            <strong>${(cal.itemName)!}</strong>
                            <span>
                            <#if cal.good>
                                <ins></ins>
                            <#else>
                              <del title="<#if cal.damageStatusSelected?? && cal.damageStatusSelected != "">${cal.damageStatusSelected}<#else>有损伤</#if>"><#if cal.damageStatusSelected?? && cal.damageStatusSelected != "">${cal.damageStatusSelected}<#else>有损伤</#if></del>
                            </#if>
                            </span>
                        </li>
                    </#list>
                </ul>
            </div>
        </div>

        <div class="infotbl-1" id="a4">
            <h2>内饰损伤图</h2>
            <div class="clearfix">
                <div class="listul-img">
                    <div class="carimg-3">
                        <#list av.vehicle.interiorList as ccl>
                                <#if !ccl.good>
                                    <#if ccl.axisx?? && ccl.axisy??>
                                        <div class="listul-img-ico" style="cursor: pointer; top:${(ccl.axisy)!}px; left:${(ccl.axisx)!}px;">${(ccl.itemOrder)!}
                                            <div class="ss-detail">
                                                <ins></ins>
                                                <p>
                                                    <span class="listul-img-ico">${(ccl.itemOrder)!}</span>${(ccl.damageStatusSelected)!}  
                                                </p>
                                                <img src="<@baseUrl.image />/${(action.getThumbImgUrl("350X200", "${(ccl.photoUrl)!}"))!}" style="width: 350px; height: 200px;">
                                            </div>
                                        </div>
                                    </#if>
                                </#if>
                         </#list>
                    </div>
                </div>
                <ul class="listul">
                    <#list av.vehicle.interiorList as ccl>
                        <li>
                            <i>${(ccl.itemOrder)!}</i>
                            <strong>${(ccl.itemName)!}</strong>
                            <span>
                            <#if ccl.good>
                                <ins></ins>
                            <#else>
                              <del title="<#if ccl.damageStatusSelected?? && ccl.damageStatusSelected != "">${ccl.damageStatusSelected}<#else>有损伤</#if>"><#if ccl.damageStatusSelected?? && ccl.damageStatusSelected != "">${ccl.damageStatusSelected}<#else>有损伤</#if></del>
                            </#if>
                            </span>
                        </li>
                    </#list>
                </ul>
            </div>
        </div>

        <div class="infotbl-1" id="a5">
            <h2>车况检测</h2>
            <div class="chekuangtblbox">
            <div class="clearfix chekuangtblmain">
                <div class="chekuangtbl">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">驾驶舱</th>
                            </tr>
                        </thead>
                        <tbody>
                            <#list av.vehicle.dricabList as condItem>
                                <tr>
                                    <td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                                </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
                <div class="chekuangtbl">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">发动机</th>
                            </tr>
                        </thead>
                        <tbody>
                            <#list av.vehicle.engineList as condItem>
                                <tr>
                                    <td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                                </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
                <div class="chekuangtbl">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">启动</th>
                            </tr>
                        </thead>
                        <tbody>
                            <#list av.vehicle.startList as condItem>
                                <tr>
                                    <td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                                </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="clearfix chekuangtblmain">
                <div class="chekuangtbl">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">路试</th>
                            </tr>
                        </thead>
                        <tbody>
                            <#list av.vehicle.roadList as condItem>
                                <tr>
                                    <td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                                </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
                <div class="chekuangtbl">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">底盘</th>
                            </tr>
                        </thead>
                        <tbody>
                            <#list av.vehicle.chassisList as condItem>
                                <tr>
                                    <td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                                </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
                
                <#if av.vehicle.otherList?? && (av.vehicle.otherList?size > 0) >
                <div class="chekuangtbl">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">其他</th>
                            </tr>
                        </thead>
                        <tbody>
                            <#list av.vehicle.otherList as otherItem>
                                <tr>
                                	<#if otherItem.good??&&!otherItem.good>
	                                    <td>
	                                    	${(otherItem.itemDesc)!}
	                                    </td>
	                                    <td class="col2">否</td>
                                	</#if>
                                </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
                </#if>
            </div>
            </div>
        </div>
        
        <div class="infotbl-1" id="a6">
            <h2>附件检测</h2>
            <div class="clearfix">
                <ul class="listul">
                    <#list av.vehicle.accessoryList as accessory>
                        <li><i>${accessory_index + 1}</i><strong>${accessory.accessoryName}</strong><span>${(accessory.optionSelected)!}</span></li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="UED_hide" id="tip-banish">
<div class="tip-banish">
    <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
    <div class="tip-banish-body">
        <div class="banish_msg">确认加价至${(av.auctionVehicle.reservePrice)!} 元</div>
    </div>
    <div class="tip-btnbox tip-txtl">
        <a href="#" class="btn-1" id="bidSuccess">确定</a>
        <a href="javascript:;" onclick="$.LAYER.close();" class="btn-2">取消</a>
    </div>
</div>
</div>

<div class="UED_hide" id="tip-phonemsg">
    <div class="tip-phonemsg">
        <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
        <div class="tip-phonemsg-body">
            <h3>发送到手机</h3>
            <p class="txt">地址信息会以短信方式发送到您的手机</p>
            <input type="text" id="tip-phoneinput" class="tip-phoneinput tip-phoneinput-normal" value="请输入手机号码"><label id="phone-errorlabel" class="phone-errorlabel"></label>
        </div>
        <div class="tip-btnbox tip-txtl">
            <a href="javascript:;" class="btn-1">确定</a>
            <a href="javascript:;" class="btn-2">取消</a>
        </div>
    </div>
</div>
<#include "/include/footer.ftl">
<script src="<@baseUrl.static />/common/build/1.00/js/fed-fixed.js<@baseUrl.time />"></script>
<script src="<@baseUrl.static />/common/build/1.00/js/jquery.imagezoom.min.js<@baseUrl.time />"></script>
<script src="<@baseUrl.static />/sell/build/1.00/js/detail.js<@baseUrl.time />"></script>
<script src="<@baseUrl.static />/common/build/1.00/js/jq.layer.js<@baseUrl.time />"></script>
<script>
$(function() {                
    //jQuery.LAYER.show({id:'tip-phonemsg'});
    $('div.listul-img-ico').hover(function(){$(this).children('.ss-detail').show();},function(){$(this).children('.ss-detail').hide();});
    
    // 隐藏在线客服
    //HideCustomerService();
});

$(document).ready(function() {
    $("#smallimglist li:first").addClass("on");

    $(".detail-tab li a").click(function() {
        $(".detail-tab li a").removeClass("on");
        $(this).addClass("on");
    });


    <#--发送到手机-->
    $(".detail-control-2").click(function() {
        $.LAYER.show({id : "tip-phonemsg"});
    });

    var flag = false;
    
    $("#tip-phoneinput").focus(function() {
        $("#tip-phoneinput").val("");
    });
    
<#--验证手机号码，文本框失去焦点的时候触发的事件 -->
  $("#tip-phoneinput").blur(function() {
      var phoneNum = $("#tip-phoneinput").val();
    if (phoneNum.length != 11) {
        $("#phone-errorlabel").html("请输入正确的手机号码");
        $("#tip-phoneinput").val("");
        return;
    }
      flag = true;
  });

  <#--确定-->
  $(".btn-1").click(function() {
      var phoneNum = $("#tip-phoneinput").val();
      if (phoneNum == "") {
          $("#phone-errorlabel").html("请输入正确的手机号码");
          return;
      }
    if (phoneNum.length != 11) {
        $("#phone-errorlabel").html("请输入正确的手机号码");
        return;
    }
      flag = true;
      $("#phone-errorlabel").html("");
      
      $.LAYER.close({id : "tip-phonemsg"});
    <#--手机号码验证正确后 -->
    $.ajax({
      url: "<@baseUrl.home />/send-car-address-sms_oav",
      type: "post",
      data: {
          mobile: phoneNum,
        avId: "${avId}"
      }
    }).done(function(data) {
      if (data.success) {
          $.LAYER.close({id : "tip-phonemsg"});
      }else{
          $("#phone-errorlabel").html("信息发送失败,请重新发送");
      }
    });
  });
  <#--取消-->
  $(".btn-2").click(function(){
      $.LAYER.close({id : "tip-phonemsg"});
  });

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

  $(".addprice").click(function(){
    jQuery.LAYER.show({id:'tip-banish'});
  });
     
  $("#bidSuccess").click(function(){
    $.LAYER.close();
    
    $.ajax({
      url: "<@baseUrl.home />/onlineauction/deal",
      type: "post",
      data: {
        avId: "${avId}"
      }
    }).done(function(data) {
        if (data.success) {
            window.location.reload();
        }
    });
  });   
  
  $("#btn-bid").click(function() {
    if ($(this).hasClass("auction-btn-dis")) {
      return;
    }

    var value = $("#paidbox").html().replace(/[^0-9]/g, "");
    $.ajax({
      url: "<@baseUrl.home />/onlineauction/bid/add",
      type: "post",
      data: {
        avId: "${avId}",
        price: parseInt(value)
      }
    }).done(function(result) {
      if (result.success) {
        <#--$("#btn-bid").addClass("auction-btn-dis");-->
        var data = result.data;
        $("#pricemoney").html(format(data.price));
        $("#bid-price").html(format(data.price));
        $("#has-bid").html("1");

        var $paidbox = $("#paidbox");
        var price = parseInt($paidbox.html().replace(/[^0-9]/g, ""));
        if (price <= data.price) {
          var plus = parseInt($("#plus-range").html());
          $paidbox.html(format(data.price + plus));
        }

        $("#bid-count").html(data.bidCount);
        $("#commission").html(data.commission);
        $("#total-price").html(data.totalPrice);
        $("#current-first").show();

        $("#seconds").html(data.seconds);
      } else {
        <#--$("#btn-bid").addClass("auction-btn-dis");-->
        if (result.msg) {
          if (result.msg == "1") {
            window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/onlineauction/${avId}");
          } else {
            $("#current-last").html(data.error).show().fadeOut(2000);
          }
        }
      }
    });
  });

  <#if av.auctionVehicle?? && av.auctionVehicle.status == 5>
  setInterval(function() {
    var $seconds = $("#seconds");
    var seconds = parseInt($seconds.html());
    --seconds;

    if (seconds <= 0) {
      window.location.reload();
      return;
    }

    $("#seconds").html(seconds.toString());
    var h = Math.floor(seconds / 3600);
    var m = Math.floor((seconds - h * 3600) / 60);
    var s = seconds - h * 3600 - m * 60;

    var buffer = [];
    if (h < 10) {
      buffer.push("0");
    }
    buffer.push(h);
    buffer.push(":");

    if (m < 10) {
      buffer.push("0");
    }
    buffer.push(m)
    buffer.push(":");

    if (s < 10) {
      buffer.push("0");
    }
    buffer.push(s)

    $("#hms").html(buffer.join(""));
  }, 1000);
  </#if>
  
  <#if av.auctionVehicle?? && av.auctionVehicle.status == 3 && av.isAlert>
  setInterval(function() {
    var $restSeconds = $("#restSeconds");
    var restSeconds = parseInt($restSeconds.html());
    --restSeconds;

    if (restSeconds <= 0) {
      window.location.reload();
      return;
    }

    $("#restSeconds").html(restSeconds.toString());
    var h = Math.floor(restSeconds / 3600);
    var m = Math.floor((restSeconds - h * 3600) / 60);
    var s = restSeconds - h * 3600 - m * 60;

    var buffer = [];
    if (h < 10) {
      buffer.push("0");
    }
    buffer.push(h);
    buffer.push(":");

    if (m < 10) {
      buffer.push("0");
    }
    buffer.push(m)
    buffer.push(":");

    if (s < 10) {
      buffer.push("0");
    }
    buffer.push(s);

    $("#restHms").html(buffer.join(""));
    
    $.ajax({
      url: "<@baseUrl.home />/onlineauction/sync",
      type: "get",
      timeout: 3000,
      data: {
        avId: "${avId}",
        t: new Date().getTime()
      }
    }).done(function(result) {
      if (result.success) {
        var data = result.data;
        if (data.status != 3) {
            window.location.reload();
            return;
        }
      }
    });
  }, 1000);
  </#if>
  
  <#if av.auctionVehicle?? && av.auctionVehicle.status == 5>
  setInterval(function() {      
    $.ajax({
      url: "<@baseUrl.home />/onlineauction/sync",
      type: "get",
      timeout: 3000,
      data: {
        avId: "${avId}",
        t: new Date().getTime()
      }
    }).done(function(result) {
      if (result.success) {
        var data = result.data;
        if (data.status != 5) {
            window.location.reload();
            return;
        }
        
        <#if av.priceDisp == "1">
        if (data.isTopPrice) {
          $("#current-first").show();
          <#--$("#btn-bid").addClass("auction-btn-dis");-->
        } else {
          $("#current-first").fadeOut();
          <#--$("#btn-bid").removeClass("auction-btn-dis");-->
        }
        $("#bid-price").html(format(data.myBidPrice));

        var $paidbox = $("#paidbox");
        var price = parseInt($paidbox.html().replace(/[^0-9]/g, ""));
        if (price < data.bidPrice) {
          $paidbox.html(format(data.bidPrice));
        }

        $("#pricemoney").html(format(data.currentPrice));
        if (data.hasBid) {
          $("#has-bid").html("1");
        }
        $("#bid-count").html(data.bidCount);
        $("#commission").html(data.commission);
        $("#total-price").html(data.totalPrice);
        </#if>
        
        var $seconds = $("#seconds");
        var seconds = parseInt($seconds.html());
        if (seconds + 2 < data.seconds) { // 增强体验，允许2秒误差
          $("#seconds").html(data.seconds);
        }
      }
    });
  }, 1000);
  </#if>

  $(".damage-photo").click(function() {
    $(".damage-photo img").hide();
    $("img", this).show();
  });

  $(document).click(function(event) {
    var $e = $(event.target);
    if ($e.parents(".carimg-1,.carimg-2,.carimg-3").length == 0) {
      $(".damage-photo img").hide();
    }
  });


    $(".detail-control-1").click(function() {
        $.ajax({
          url: "<@baseUrl.home />/member/favorite/add",
          type: "post",
          data: {
            avId: "${avId}"
          }
        }).done(function(data) {
          if (data.success) {
            $("#a1-1").show();
            $("#a3-3").hide();
          } else{
              window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/onlineauction/${avId}");
          }
        });
      });

  $(".detail-control-1-on").click(function() {
    $.ajax({
      url: "<@baseUrl.home />/member/favorite/remove",
      type: "post",
      data: {
        avId: "${avId}"
      }
    }).done(function(data) {
      if (data.success) {
        $("#a1-1").hide();
        $("#a3-3").show();
      }else{
          window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/onlineauction/${avId}");
      }
    });
  });

});
</script>
</body>
</html>
</#escape>