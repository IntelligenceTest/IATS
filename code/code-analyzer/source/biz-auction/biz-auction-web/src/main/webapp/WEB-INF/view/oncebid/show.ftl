<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<#assign tempSelledName = "">
<#if (vehicle.selledName)??>
    <#assign tempSelledName = vehicle.selledName>
	<#if vehicle.selledName?starts_with(vehicle.vehicleModel)>
		 <#assign tempSelledName = vehicle.selledName?replace(vehicle.vehicleModel, '', 'f')>
	</#if>
</#if>
<meta name="others" content="汽车街_竞拍大厅_即时拍_${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}">
<title>${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}_即时拍_竞拍大厅_汽车街</title>
<link href="<@baseUrl.static />/common/build/2.00/css/b.css" rel="stylesheet" type="text/css" />
<link href="<@baseUrl.static />/sell/build/1.00/css/detail.css<@baseUrl.time />" rel="stylesheet">
</head>
<body>
<#include "/include/header1.ftl">
<@layout.nav active = "auction" />

<div class="position">
  <a class="positionmain" href="<@baseUrl.parentHome />/">首页</a> &gt; <a href="<@baseUrl.home />"><span>竞拍大厅</span></a>  &gt; <a href="<@baseUrl.home />/onceBidAuction/index"><span>24小时拍</span></a> &gt; <span>车辆详情</span>
</div>
<div class="box detailbox clearfix">
    <div class="detailbox-l">
        <div class="bigimgbox">
        <#if firstVehiclePhoto?? && firstVehiclePhoto.photoUrl?? && (firstVehiclePhoto.photoUrl != "")>
        	<img src="<@baseUrl.image />/${(action.getThumbImgUrl("520X390", "${(firstVehiclePhoto.photoUrl)!}"))!}" style="width:520px; height:390px;" rel="<@baseUrl.image />/${(action.getThumbImgUrl("1024X768", "${(firstVehiclePhoto.photoUrl)!}"))!}" id="jqzoom">
        	<a href="javascript:;" class="left"><</a><a href="javascript:;" class="right">></a>
        <#else>
        	<img src="<@baseUrl.static />/common/build/1.00/images/noimg.png" style="width:520px; height:390px;" rel="<@baseUrl.static />/common/build/1.00/images/noimg.png" id="jqzoom">
        	<a href="javascript:;" class="left">&lt;</a><a href="javascript:;" class="right">&gt;</a>
        </#if>
        </div>
        
        <!--
        <p class="img-txt"><i id="current">1</i>/${(photoNum)!} <span id="current-name">${(firstVehiclePhoto.photoName)!}</span></p>
        -->
        
        <div class="img-txt">
        	展品编号：${(vehicle.code)!}
        </div>

        <div class="smallimgbox clearfix">
            <a class="smallimgbox-l" id="smallimgbox-l">&lt;</a>
            <div class="smallimglist">
            <ul id="smallimglist">
            	<#list checkPhotoList as photo>
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
        <#if auctionVehicle.seeCarAddr?? && auctionVehicle.seeCarAddr != "">
        	<div class="detail-map">
        		<#if auctionVehicle.seeCarAddr??>
        		<p><span>看车地点</span> <span id="car-address">${(auctionVehicle.seeCarAddr)!}</span><#-- <a href="javascript:;">查看地图</a>--></p>
        		</#if>
        		<#if auctionVehicle.seeCarTime??>
        		<p><span>看车时间</span> ${(auctionVehicle.seeCarTime)!} </p>
        		</#if>
        	</div>
        </#if>
        <p>
        	<#if isFavorite == "1">
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
        <#if vehicle.certified?? && vehicle.certified>
        	<img src="<@baseUrl.static />/common/build/1.00/images/eqs.png">
        </#if>
        ${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}</h2>
        <p class="detail-status-2">
        	<#if auctionVehicle.status == 1>
        		未开始 <span style="padding: 10px;">开始时间：${(auctionVehicle.planStartTime?datetime)!}</span>
        	<#elseif auctionVehicle.status == 2>
        		成交
        	<#elseif auctionVehicle.status == 3>
        		成交确认<#--<span class="detail-subtitle">当前最高出价未达到保留价，拍卖师正在与车主协商是否降价成交</span>-->
        	<#elseif auctionVehicle.status == 4>
        		流拍
        	<#elseif auctionVehicle.status == 5>
        		<#--距结束 <span id="hms" style="padding: 10px;">${hms}</span><span id="seconds" style="display: none;">${seconds}</span>-->
        	<#elseif auctionVehicle.status == 6>
        		暂停
        	<#elseif auctionVehicle.status == 7>
        		已下架
        	</#if>
        </p>
        <div class="detail-info">
          <div class="strat-sell">
	        <#if priceDisp == "1">	
	          <#if (myBidPrice)?? && myBidPrice gt 0 >
		          <div class="after_offer" id="myBidshow">
		            <label>我的出价</label>
		            <p class="my_price"><span>${(myBidPrice/10000)!?string("#.##")}</span>万元</p>
		          </div>
	           <#else>
	              <div class="after_offer">
		            <label>我的出价</label>
		            <p class="my_price"><span>${(myBidPrice/10000)!?string("#.##")}</span>万元</p>
		          </div>
	              <div class="currentdiv">
	                 <label>出价</label>
	                 <div>
	                 <input type="text" class="paidbox" <#if (auctionVehicle.status) != 5>disabled="disabled"</#if>>
	                     <span class="addtip">出价须为100的整数倍</span>
	                 </div> 
	              </div>
	              <div class="addbtnbox">
	                 <p class="clearfix">
	                    <a href="javascript:;" class="auction-btn-1 <#if (auctionVehicle.status) != 5>auction-btn-dis</#if>">出价</a>
	                 </p>
	              </div>
	            </#if>
	        <#else>
	        	  <div class="currentdiv" style="margin:20px 0 0 0">
	        		<label style="line-height:25px">当前价</label>
	        		<strong class="money" id="pricemoney" style="font-size:12px;line-height:25px;margin:5px 0 0 0;float:left">
	        		认证商户可见 <img src="<@baseUrl.static />/services/build/1.00/images/explain.png" alt="" title="欲成为认证商户请拨打：400-821-8889">
	        		</strong>
	              </div>
	        </#if>
          </div>
          <ul>
            <li>佣金率：${(auctionVehicle.buyerCommissionRate)!0}%</li>
           	<li>交易佣金：<span id="commission">${commission}</span> 元</li>
            <li>办证手续费：${(auctionVehicle.licenseFee?string("0"))!"0"} 元</li>
            <li>出库费：${(auctionVehicle.exWarehouseFee?string("0"))!"0"} 元</li>
            <li>停车费：${(auctionVehicle.parkingFee?string("0"))!"0"} 元</li>
            <li>物流费：自理</li>
          </ul>
        </div>
        <ul class="detail-info-list">
          <li><span>上牌城市：</span> ${(vehicle.registerCity)!}</li>
          <li><span>车辆所在地：</span> ${(vehicle.currentCity)!}</li>
          <li><span>原车牌号：</span> <#if vehicle.licenseCode?? && (vehicle.licenseCode?length gt 1)>${(vehicle.licenseCode?substring(0,2))!}<#else>${(vehicle.licenseCode)!}</#if></li>
          <!-- <li><span>是否带牌拍：</span> <#if auctionVehicle?? && auctionVehicle.vehicle?? && auctionVehicle.vehicle.withLicense?? && auctionVehicle.vehicle.withLicense>是<#else>否</#if></li> -->
          <li><span>首次上牌：</span> ${(vehicle.registerYear)!}-${(vehicle.registerMonth)!}</li>
          <#if vehicle.displayMileage??>
		  	  <li><span>表显里程：</span> ${((vehicle.displayMileage)/10000)?default(0.00)?string("0.00")!}万公里</li>
	  	  </#if>
	  	  <!-- 暂时不使用
          <li><span>排放标准：</span> ${(vehicle.sweptVolumeStandard)!}</li>
          -->
          <li><span>变速箱：</span> ${(vehicle.transmissionType)!}</li>
          <li><span>使用性质：</span> ${(vehicle.usingModel)!}</li>
        </ul>
        <dl class="other-info">
          <dt>车辆描述</dt>
          <dd>${(vehicle.vehicleDesc?replace("\r","")?replace("\n",""))!}</dd>
        </dl>
        <!-- 暂时不使用
        <#if vehicle.guaranteed?? && vehicle.guaranteed>
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
            <h3>检测报告<span>质检时间${(vehicle.assessmentDatetime?string('yyyy-MM-dd'))!}</span></h3>
            <#if vehicle.certified?? && vehicle.certified>
            	<p class="tip-eqs">该车辆经过200项严酷检测，已成功通过EQS认证！</p>
        	</#if>
            <table class="test-report">
            <thead>
                <tr>
                    <td width="355" class="txt-c">综合评分</td>
                    <td style="padding-left:50px;width:350px;">主要检测项目</td>
                    <td style="padding-left:50px;">得分</td>
                    <!--
                    <td width="255" class="txt-c">质检专员</td>
                    -->
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td rowspan="7" class="txt-c"><p>车况评分：${(vehicle.score?string("0.0"))!}</p>
                    	<#if vehicle.grade?? && (vehicle.grade?trim != "")>
                    		<span class="lv-${(vehicle.grade)!?substring(0,1)?lower_case}">${(vehicle.grade)!}</span>
                    	</#if>
                    </td>
                    <td style="padding-left:50px;">车况</td>
                    <td style="padding-left:50px;">${(vehicle.score?string("0.0"))!}</td>
                </tr>
                <tr>
                    <td style="padding-left:50px;">车身外观</td>
                    <td style="padding-left:50px;"><#if vehicleCheckCategoryScore["外观"]??>${(vehicleCheckCategoryScore["外观"]?string("0.0"))!}</#if></td>
                </tr>
                <tr>
                    <td style="padding-left:50px;">内饰</td>
                    <td style="padding-left:50px;"><#if vehicleCheckCategoryScore["内饰"]??>${(vehicleCheckCategoryScore["内饰"]?string("0.0"))!}</#if></td>
                </tr>
                <tr>
                    <td style="padding-left:50px;">发动机</td>
                    <td style="padding-left:50px;"><#if vehicleCheckCategoryScore["发动机舱"]??>${(vehicleCheckCategoryScore["发动机舱"]?string("0.0"))!}</#if></td>
                </tr>
                <tr>
                    <td style="padding-left:50px;">启动检测</td>
                    <td style="padding-left:50px;"><#if vehicleCheckCategoryScore["启动检查"]??>${(vehicleCheckCategoryScore["启动检查"]?string("0.0"))!}</#if></td>
                </tr>
                <tr>
                    <td style="padding-left:50px;">路试</td>
                    <td style="padding-left:50px;"><#if vehicleCheckCategoryScore["路试"]??>${(vehicleCheckCategoryScore["路试"]?string("0.0"))!}</#if></td>
                </tr>
                <tr>
                    <td style="padding-left:50px;">底盘</td>
                    <td style="padding-left:50px;"><#if vehicleCheckCategoryScore["底盘"]??>${(vehicleCheckCategoryScore["底盘"]?string("0.0"))!}</#if></td>
                </tr>
            </tbody>
        </table>
            <h3>详细信息</h3>
            <div class="clearfix">
            <table class="infotbl">
                    <tr>
                        <th>VIN码</th>
                        <td>${(vehicle.vinCode)!}(${(vehicle.clearVin?string('清晰','不清晰'))!})</td>
                    </tr>
                    <tr>
                        <th>出厂日期</th>
                        <td>${(vehicle.producedYear)!}年${(vehicle.producedMonth)!}月</td>
                    </tr>
                    <tr>
                        <th>上牌日期</th>
                        <td>${(vehicle.registerYear)!}年${(vehicle.registerMonth)!}月</td>
                    </tr>
                    <tr>
                        <th>排气量</th>
                        <td>${(vehicle.sweptVolume)?string("0.0")!}${(vehicle.sweptVolumeType)!}</td>
                    </tr>
                    <!--<tr>
                        <th>环保标准</th>
                        <td>${(vehicle.sweptVolumeStandard)!}</td>
                    </tr> -->
                    <tr>
                        <th>上牌城市</th>
                        <td>${(vehicle.registerCity)!}</td>
                    </tr>
                    <tr>
                        <th>车辆所在地</th>
                        <td>${(vehicle.currentCity)!}</td>
                    </tr>
                    <tr>
                        <th>发动机号</th>
                        <td>${(vehicle.engineCode)!}</td>
                    </tr>
                </tbody>
            </table>
            <table class="infotbl infotbl-c">
                    <tr>
                        <th>车牌号</th>
                        <td><#if vehicle.licenseCode?? && (vehicle.licenseCode?length gt 1)>${(vehicle.licenseCode?substring(0,2))!}<#else>${(vehicle.licenseCode)!}</#if></td>
                    </tr>
                    <tr>
                        <th>车辆颜色</th>
                        <td>${(vehicle.bodyColor)!}</td>
                    </tr>
                    <tr>
                        <th>内饰颜色</th>
                        <td>${(vehicle.interiorColor)!}</td>
                    </tr>
                    <tr>
                        <th>最大功率</th>
                        <td>${(vehicle.power?c)!}kw</td>
                    </tr>
                    <tr>
                        <th>表显里程</th>
                        <td>${((vehicle.displayMileage)/10000)?default(0.00)?string("0.00")!}万公里</td>
                    </tr>
                    <tr>
                        <th>行驶证</th>
                        <td>${(vehicle.vehicleLicense?string("有","无"))!}</td>
                    </tr>
                    <!-- <tr>
                        <th>发动机号是否清晰</th>
                        <td>${(vehicle.clearEnginCode?string('是','否'))!}</td>
                    </tr> -->
                    <tr>
                        <th>变速箱类型</th>
                        <td>${(vehicle.transmissionType)!}</td>
                    </tr>
                </tbody>
            </table>
            <table class="infotbl">
                    <tr>
                        <th>燃料类型</th>
                        <td>${(vehicle.oilType)!}</td>
                    </tr>
                    <!-- <tr>
                        <th>车辆类型</th>
                        <td>${(vehicle.vehicleType)!}</td>
                    </tr> -->
                    <tr>
                        <th>使用性质</th>
                        <td>${(vehicle.usingModel)!}</td>
                    </tr>
                    <tr>
                        <th>过户次数</th>
                        <td>${(vehicle.transferNumber)!}</td>
                    </tr>
                    <tr>
                        <th>年审有效期</th>
                        <td>${(vehicle.nextAnnualExamination?string('yyyy年MM月dd日'))!}</td>
                    </tr>
                    <tr>
                        <th>交强险有效期</th>
                        <td>${(vehicle.nextCompulsoryInsurance?string('yyyy年MM月dd日'))!}</td>
                    </tr>
                    <tr>
                        <th>购置附加税完税证明</th>
                        <td>${(vehicle.purchaseTaxProof?string("有","无"))!}</td>
                    </tr>
                    <tr>
                        <th>产证</th>
                        <td>${(vehicle.propertyCertificate?string("有","无"))!}</td>
                    </tr>
                </tbody>
            </table>
        </div>
            <#if featureItem??>
            	<h3>车辆配置</h3>
	            <div class="configure">
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
            </#if>
        </div>
        <div class="infotbl-1" id="a2">
            <h2>骨架损伤图 </h2>
            <div class="clearfix">
            	
                <div class="listul-img">
                    <div class="carimg-1">
                      <#list carframeList as cfl>
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
                	<#list carframeList as cfl>
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
                    	<#list carappearanceList as cal>
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
                	<#list carappearanceList as cal>
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
                    	<#list carcockpitList as ccl>
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
                	<#list carcockpitList as ccl>
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
                        	<#list cardricabList as condItem>
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
                        	<#list carengineList as condItem>
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
                        	<#list carstartList as condItem>
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
                        	<#list carroadList as condItem>
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
                        	<#list carchassisList as condItem>
                    			<tr>
                    				<td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                    			</tr>
                        	</#list>
                        </tbody>
                    </table>
                </div>
                
                <#if carotherList?? && (carotherList?size > 0) >
                <div class="chekuangtbl">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">其他</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<#list carotherList as otherItem>
                    			<#if otherItem.good??&&!otherItem.good>
                                	<tr>
	                                    <td>
	                                    	${(otherItem.itemDesc)!}
	                                    </td>
	                                    <td class="col2">否</td>
	                                </tr>
                                </#if>
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
                    <#--<li><i>1</i><strong>遥控钥匙</strong><span>${(vehicle.annexRemoteKey)!}</span></li>
                    <li><i>2</i><strong>非遥控钥匙</strong><span>${(vehicle.annexNonRemoteKey)!}</span></li>
                    <li><i>3</i><strong>随车工具</strong><span>${(vehicle.annexTool)!}</span></li>
                    <li><i>4</i><strong>三角警示牌</strong><span>${(vehicle.annexWarningTriangle)!}</span></li>
                    <li><i>5</i><strong>保养手册</strong><span>${(vehicle.annexMaintenanceManual)!}</span></li>
                    <li><i>6</i><strong>使用说明书</strong><span>${(vehicle.annexInstructionManual)!}</span></li>
                    <li><i>7</i><strong>点烟器</strong><span>${(vehicle.annexCigarLighter)!}</span></li>
                    <li><i>8</i><strong>车内用遥控器</strong><span>${(vehicle.annexRemoteControl)!}</span></li>
                    <li><i>9</i><strong>备胎</strong><span>${(vehicle.annexSpareWheel)!}</span></li>
                    -->
                    <#if caraccessoryList??&&(caraccessoryList?size>0)>
                    	<#list caraccessoryList as accessory>
                    			<li><i>${accessory_index+1}</i><strong>${(accessory.accessoryName)!}</strong><span>${(accessory.optionSelected)!}</span></li>
                    	</#list>
                    </#if>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="UED_hide" id="tip-phonemsg">
    <div class="tip-phonemsg">
        <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
        <div class="tip-phonemsg-body">
            <h3>发送到手机</h3>
            <p class="txt">地址信息会以短信方式发送到您的手机</p>
            <input type="text" class="tip-phoneinput tip-phoneinput-normal" value="请输入手机号码"><label class="phone-errorlabel">请输入正确的手机号码</label>
        </div>
        <div class="tip-btnbox tip-txtl">
            <a href="#" class="btn-1">确定</a>
            <a href="#" class="btn-2">取消</a>
        </div>
    </div>
</div>

<div class="UED_hide" id="friendly_tip">
    <div class="tip-offset">
        <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
        <div class="friendly_tip">
            <h3>友情提示</h3>
            <p>即时拍只能出价一次，请确认您的出价</p>
            <p class="your_price">您的出价<span>26.75</span>万元</p>
        </div>
        <div class="friendly_btn">
            <a href="javascript:;" class="confirm">确认出价</a>
            <a href="javascript:;" class="cancel" onclick="$.LAYER.close();">取消</a>
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
	
	$(".detail-tab li a").click(function() {
		$(".detail-tab li a").removeClass("on");
		$(this).addClass("on");
	});

	
	
	// 隐藏在线客服
	//HideCustomerService();
	$('#myBidshow').show();
	var _val;
    var _index;
    <#if (auctionVehicle.status) == 5>
	    $('.auction-btn-1').click(function(){
	        _val = $('.paidbox').val()
	        if( _val%100 != 0 || _val == '' || _val == 0){
	            $('.addtip').addClass('error')
	            return false
	        }else{
	            $(this).next().removeClass('error')
	            jQuery.LAYER.show({id:'friendly_tip',overlay:{opacity:0.5}});
	            $('.your_price span').text(_val/10000)
	            // var _t = $(this).parent().parent().parent()
	            // _index = $('.listtbody').index(_t)
	        }
	    })
    </#if>
    $('.confirm').click(function(){
        $('.currentdiv,.addbtnbox').hide()
        $('.after_offer .my_price span').text(_val/10000)
        $('.after_offer').show()
	    $.ajax({
			url: "<@baseUrl.home />/onceBidAuction/bid",
		    type: "post",
		    data: {avId  : "${(auctionVehicle.id)!}",
		           bidAmt: _val}
		    }).done(function (data) {
			    if (!data.success) {
			    	if(data.msg){
			    		alert(data.msg);
		    			location.reload();
			    	}
			    }
	    });
        $.LAYER.close()
    })
    $('.cancel').click(function(){
        //$('.listtbody').eq(_index).find('.make_offer').show()
        $.LAYER.close()
    })
    
    $(".detail-control-1").click(function() {
	    $.ajax({
	      url: "<@baseUrl.home />/member/favorite/add",
	      type: "post",
	      data: {
	        avId: ${(auctionVehicle.id)!}
	      },
	      success:function(data){
		      if (data.success) {
		        $("#a1-1").show();
		        $("#a3-3").hide();
		      } else{
		      	window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/onceBidAuction/${avId}");
		      }
	      }
	    });
  	});

	  $(".detail-control-1-on").click(function() {
	    $.ajax({
	      url: "<@baseUrl.home />/member/favorite/remove",
	      type: "post",
	      data: {
	        avId: "${(auctionVehicle.id)!}"
	      }
	    }).done(function(data) {
	      if (data.success) {
	        $("#a1-1").hide();
	        $("#a3-3").show();
	      }else{
	      	window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/onceBidAuction/${(auctionVehicle.id)!}");
	      }
	    });
	  });
	  
});
</script>
</body>
</html>
</#escape>
