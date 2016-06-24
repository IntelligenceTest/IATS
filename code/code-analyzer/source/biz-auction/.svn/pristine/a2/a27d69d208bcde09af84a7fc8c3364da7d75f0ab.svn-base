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
<meta name="others" content="汽车街_竞拍大厅_同步拍_${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}_${(auction.title)!}">
<title>${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}_${(auction.title)!}_同步拍_竞拍大厅_汽车街</title>
<link href="<@baseUrl.static />/sell/build/1.00/css/detail.css<@baseUrl.time />" rel="stylesheet">
</head>
<body>
<#include "/include/header1.ftl">
<@layout.nav active = "sync-auction" />

<div class="position">
    <a class="positionmain" href="<@baseUrl.parentHome />/">首页</a> &gt; <a href="<@baseUrl.home />"><span>竞拍大厅</span></a> &gt; <a href="<@baseUrl.home />/syncauction/index"><span>同步拍</span></a> &gt; <a href="<@baseUrl.home />/syncauction/detail/${(auctionVehicle.auctionId)!}"><span>${(auction.title)!}</span></a> &gt; <span>车辆详情</span>
</div>
<div class="box detailbox clearfix">
  <div class="detailbox-l">
    <div class="bigimgbox">
    	<#if firstVehiclePhoto?? && firstVehiclePhoto.photoUrl?? && (firstVehiclePhoto.photoUrl != "")>
    		<img src="<@baseUrl.image />/${(action.getThumbImgUrl("520X390", "${(firstVehiclePhoto.photoUrl)!}"))!}" style="width:520px; height:390px;" rel="<@baseUrl.image />/${(action.getThumbImgUrl("1024X768", "${(firstVehiclePhoto.photoUrl)!}"))!}" id="jqzoom">
    		<i>${(auctionVehicle.auctionVehicleOrder?string("000"))!}</i>
    		<a href="javascript:;" class="left"><</a><a href="javascript:;" class="right">></a>
    	<#else>
    		<img src="<@baseUrl.static />/common/build/1.00/images/noimg.png" style="width:520px; height:390px;" rel="<@baseUrl.static />/common/build/1.00/images/noimg.png" id="jqzoom">
    		<i>${(auctionVehicle.auctionVehicleOrder?string("000"))!}</i>
    		<a href="javascript:;" class="left"><</a><a href="javascript:;" class="right">></a>
    	</#if>
    </div>
    <p class="img-txt"><i id="current">1</i>/${photoNum!} <span id="current-name">${(firstVehiclePhoto.photoName)!}</span></p>
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
    		<a href="javascript:;" class="detail-control-1" id="a3-3" style="display: none;">关注</a>
        	<a href="javascript:;" class="detail-control-1-on" id="a1-1">取消关注</a>
        <#else>
        	<a href="javascript:;" class="detail-control-1" id="a3-3">关注</a>
        	<a href="javascript:;" class="detail-control-1-on" id="a1-1" style="display: none;">取消关注</a>
    	</#if>
      
      <!-- <a href="javascript:;" class="detail-control-2">发到手机</a>   -->
    </p>
  </div>
  <div class="detailbox-r">
	<#assign tempSelledName = "">
	<#if (vehicle.selledName)??>
		  <#assign tempSelledName = vehicle.selledName>
		  <#if vehicle.selledName?starts_with(vehicle.vehicleModel)>
			   <#assign tempSelledName = vehicle.selledName?replace(vehicle.vehicleModel, '', 'f')>
		  </#if>
	</#if>
    <h2 class="detail-title">
      <#if vehicle.certified?? && vehicle.certified>
      	<img src="<@baseUrl.static />/common/build/1.00/images/eqs.png">
      </#if>
      ${(vehicle.brand)!} ${(vehicle.vehicleModel)!}<#if vehicle.sweptVolumeStandard?? && vehicle.sweptVolumeStandard?starts_with("欧")>(进口)</#if> ${(tempSelledName)!}
    </h2>
    <p class="detail-subtitle">所属专场：${(auction.title)!}（${(auction.startTimestamp?string('yyyy-MM-dd HH:mm'))!} - ${(auction.endTimestamp?string('yyyy-MM-dd HH:mm'))!}）
    	<#if auction.status == 2>
    		<#if priceDisp == "1"><a href="<@baseUrl.home />/auction/${auction.id}/live">进入参拍</a></#if>
    	</#if>
    </p>
    
    <div class="detail-info detail-info-on">
        <#if priceDisp == "1">
	      <div class="strat-sell">
			加价幅度 <span class="money">${(auctionVehicle.plusRange?string("0"))!"0"}</span>元
		  </div>
        </#if>
      <ul>
      	<#if ((auctionVehicle.buyerFixedCommission)?? && (auctionVehicle.buyerFixedCommission &gt; 0))|| ((auctionVehicle.buyerCommissionRate)?? && (auctionVehicle.buyerCommissionRate)==0)>
      	    <li>交易佣金：${commission} 元</li>
      	<#else>
      		<li>佣金率：${((auctionVehicle.buyerCommissionRate)?string("0.##"))!0}%</li>
      	</#if>
        
        
        <li>保证金：${(auction.vehicleMargin?string("0"))!"0"} 元</li>
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
      <li><span>首次上牌：</span> ${(vehicle.registerLicenseYears?substring(0,4))!}-${(vehicle.registerLicenseYears?substring(4))!}</li>
      <#if vehicle.displayMileage??>
		  <li><span>表显里程：</span> ${((vehicle.displayMileage)/10000)?default(0.00)?string("0.00")!}万公里</li>
	  </#if>
      <!--<li><span>排放标准：</span> ${(vehicle.sweptVolumeStandard)!}</li>-->
      <li><span>变速箱：</span> ${(vehicle.transmissionType)!}</li>
      <li><span>使用性质：</span> ${(vehicle.usingModel)!}</li>
    </ul>
    <dl class="other-info">
      <dt>车辆描述</dt>
      <dd>${(vehicle.vehicleDesc)!}</dd>
    </dl>
    
    <!-- 暂时不用
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
            	<p class="tip-eqs">该车经过了200项严酷检测，车辆骨架无损伤，车况为A级。</p>
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
                    		<span class="lv-${vehicle.grade?substring(0,1)?lower_case}">${(vehicle.grade)!}</span>
                    	</#if>
                    </td>
                    <td style="padding-left:50px;">车况</td>
                    <td style="padding-left:50px;">${(vehicle.score?string("0.0"))!}</td>
                </tr>
                <#if vehicleCheckCategoryScore?? && vehicleCheckCategoryScore?size gt 0 >
                	<#list vehicleCheckCategoryScore as categoryScore>
                		<#if (categoryScore.itemName) == "4">
		                <tr>
		                    <td style="padding-left:50px;">车身外观</td>
		                    <td style="padding-left:50px;">${(categoryScore.baseScore)?string("0.0")!}</td>
		                </tr>
		                </#if>                 		
                	</#list>
                	<#list vehicleCheckCategoryScore as categoryScore>
                		<#if (categoryScore.itemName) == "5">
		                <tr>
		                    <td style="padding-left:50px;">驾驶舱</td>
		                    <td style="padding-left:50px;">${(categoryScore.baseScore)?string("0.0")!}</td>
		                </tr>  
		                </#if>               		
                	</#list>
                	<#list vehicleCheckCategoryScore as categoryScore>
                		<#if (categoryScore.itemName) == "6">
		                <tr>
		                    <td style="padding-left:50px;">发动机舱</td>
		                    <td style="padding-left:50px;">${(categoryScore.baseScore)?string("0.0")!}</td>
		                </tr>
		                </#if>                 		
                	</#list>
                	<#list vehicleCheckCategoryScore as categoryScore>
                		<#if (categoryScore.itemName) == "7">
		                <tr>
		                    <td style="padding-left:50px;">启动检查</td>
		                    <td style="padding-left:50px;">${(categoryScore.baseScore)?string("0.0")!}</td>
		                </tr>  
		                </#if>               		
                	</#list>
                	<#list vehicleCheckCategoryScore as categoryScore>
                		<#if (categoryScore.itemName) == "8">
		                <tr>
		                    <td style="padding-left:50px;">路试</td>
		                    <td style="padding-left:50px;">${(categoryScore.baseScore)?string("0.0")!}</td>
		                </tr>
		                </#if>                 		
                	</#list>
                	<#list vehicleCheckCategoryScore as categoryScore>
                		<#if (categoryScore.itemName) == "9">
		                <tr>
		                    <td style="padding-left:50px;">底盘</td>
		                    <td style="padding-left:50px;">${(categoryScore.baseScore)?string("0.0")!}</td>
		                </tr>   
		                </#if>             		
                	</#list>
                </#if>
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
                        <td>${(vehicle.producedYears?substring(0,4))!}年${(vehicle.producedYears?substring(4))!}月</td>
                    </tr>
                    <tr>
                        <th>上牌日期</th>
                        <td>${(vehicle.registerLicenseYears?substring(0,4))!}年${(vehicle.registerLicenseYears?substring(4))!}月</td>
                    </tr>
                    <tr>
                        <th>排气量</th>
                        <td>${(vehicle.sweptVolume)?string("0.0")!}${(vehicle.sweptVolumeType)!}</td>
                    </tr>
                    <!-- <tr>
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
                        <td>${(vehicle.vehicleLicense?string("有","无"))!"元"}</td>
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
                        <td>${(vehicle.purchaseTaxProof?string("有","无"))!"无"}</td>
                    </tr>
                    <tr>
                        <th>产证</th>
                        <td>${(vehicle.propertyCertificate?string("有","无"))!"无"}</td>
                    </tr>
                </tbody>
            </table>
        </div>
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
                        	<#list carconditionList as condItem>
                        		<#if condItem.subCategory == 5>
                        			<tr>
                        				<td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                        			</tr>
                        		</#if>
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
                        	<#list carconditionList as condItem>
                        		<#if condItem.subCategory == 6>
                        			<tr>
                        				<td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                        			</tr>
                        		</#if>
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
                        	<#list carconditionList as condItem>
                        		<#if condItem.subCategory == 7>
                        			<tr>
                        				<td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                        			</tr>
                        		</#if>
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
                        	<#list carconditionList as condItem>
                        		<#if condItem.subCategory == 8>
                        			<tr>
                        				<td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                        			</tr>
                        		</#if>
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
                        	<#list carconditionList as condItem>
                        		<#if condItem.subCategory == 9>
                        			<tr>
                        				<td>${(condItem.itemDesc)!}</td><td class="col2"><#if condItem.good><span class="gou-ico"></span><#else>否</#if></td>
                        			</tr>
                        		</#if>
                        	</#list>
                        </tbody>
                    </table>
                </div>
                
                <#if carOtherList?? && (carOtherList?size > 0) >
                <div class="chekuangtbl">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">其他</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<#list carOtherList as otherItem>
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
                    <li><i>1</i><strong>钥匙</strong><span>${(vehicle.annexKey)!}</span></li>
                    <#if (vehicle.accessoryList) ?? >
                        <#list vehicle.accessoryList as accessory>
                        	<li><i>${accessory_index+2}</i>
                        		<strong>${(accessory.accessoryName)!}</strong>
                        		<span>${(accessory.optionSelected)!}</span>
                        	</li>
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
	        <input type="text" id="tip-phoneinput" class="tip-phoneinput tip-phoneinput-normal" value="请输入手机号码"><label id="phone-errorlabel" class="phone-errorlabel"></label>
	    </div>
	    <div class="tip-btnbox tip-txtl">
	        <a href="javascript:;" class="btn-1" id="btn-sms-1">确定</a>
	        <a href="javascript:;" class="btn-2" id="btn-sms-2">取消</a>
	    </div>
	</div>
</div>
<div class="UED_hide" id="tip-setdl">
  <div class="tip-setdl">
    <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
    <div class="tip-setdl-top">
      <h3>设置代理价<a href="javascript:;" class="help" title="在拍卖会开始之前，车商可以设定自己的车辆意向价，竞拍开始后，由系统代理自动出价。注意：拍卖会开始后，不可修改或取消代理价。">什么是代理价</a></h3>
      <dl class="">
        <dt>当前价</dt>
        <dd><span class="money"><strong id="layer-current-price"><#if auctionVehicle?? && auctionVehicle.startPrice??><#noescape>${action.format1(auctionVehicle.startPrice)}</#noescape><#else>0</#if></strong>元</span>加价幅度：<#if auctionVehicle?? && auctionVehicle.plusRange??>${auctionVehicle.plusRange}<#else>0</#if>元</dd>
      </dl>
      <dl>
      <dt>我的代理价</dt>
        <dd><span class="money1"><strong id="layer-proxy-price"><#if proxyPrice??><#noescape>${action.format1(proxyPrice)}</#noescape><#elseif auctionVehicle?? && auctionVehicle.startPrice??><#noescape>${action.format1(auctionVehicle.startPrice)}</#noescape><#else>0</#if></strong>元</span> 请输入（当前价+加价幅度的整数倍）
          <ul class="btnaddbox">
            <li><a href="javascript:;" class="x">+<#if auctionVehicle?? && auctionVehicle.plusRange??>${auctionVehicle.plusRange * 1}<#else>0</#if></a></li>
            <li><a href="javascript:;" class="x">+<#if auctionVehicle?? && auctionVehicle.plusRange??>${auctionVehicle.plusRange * 2}<#else>0</#if></a></li>
            <li><a href="javascript:;" class="x">+<#if auctionVehicle?? && auctionVehicle.plusRange??>${auctionVehicle.plusRange * 4}<#else>0</#if></a></li>
            <li><a href="javascript:;" class="x">+<#if auctionVehicle?? && auctionVehicle.plusRange??>${auctionVehicle.plusRange * 10}<#else>0</#if></a></li>
            <li><a href="javascript:;" class="x">+<#if auctionVehicle?? && auctionVehicle.plusRange??>${auctionVehicle.plusRange * 20}<#else>0</#if></a></li>
            <li><a href="javascript:;" class="x">+<#if auctionVehicle?? && auctionVehicle.plusRange??>${auctionVehicle.plusRange * 40}<#else>0</#if></a></li>
            <li><a href="javascript:;" class="x">+<#if auctionVehicle?? && auctionVehicle.plusRange??>${auctionVehicle.plusRange * 100}<#else>0</#if></a></li>
            <li><a href="javascript:;" id="layer-reset">重置</a></li>
          </ul>
        </dd>
      </dl>
    </div>
    <div class="tip-btnbox">
      <a href="javascript:;" class="btn-1" id="layer-btn-1">确定</a>
      <a href="javascript:;" class="btn-2" id="layer-btn-2">取消</a>
    </div>
  </div>
</div>
<#include "/include/footer.ftl">
<script src="<@baseUrl.static />/common/build/1.00/js/fed-fixed.js<@baseUrl.time />"></script>
<script src="<@baseUrl.static />/common/build/1.00/js/jquery.imagezoom.min.js<@baseUrl.time />"></script>
<script src="<@baseUrl.static />/sell/build/1.00/js/detail.js<@baseUrl.time />"></script>
<script src="<@baseUrl.static />/common/build/1.00/js/jq.layer.js<@baseUrl.time />"></script>
<script>
$(document).ready(function() {
	// 隐藏在线客服
	//HideCustomerService();

	$("#smallimglist li:first").addClass("on");
	
	$('div.listul-img-ico').hover(function(){$(this).children('.ss-detail').show();},function(){$(this).children('.ss-detail').hide();});
	
	$(".detail-tab li a").click(function() {
		$(".detail-tab li a").removeClass("on");
		$(this).addClass("on");
	});

		<#--发送到手机-->
		$(".detail-control-2").click(function() {
	    	$.LAYER.show({id: "tip-phonemsg"});
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
	    $("#btn-sms-1").click(function() {
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
		      url: "<@baseUrl.home />/send-car-address-sms",
		      type: "post",
		      data: {
		      	mobile: phoneNum,
		        avId: "${auctionVehicle.id}"
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
	    $("#btn-sms-2").click(function(){
	    	$.LAYER.close({id : "tip-phonemsg"});
	    });

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

  $("#btn-proxy-bid, #btn-proxy-bid-edit").click(function() {
    $.LAYER.show({id: "tip-setdl"});
  });

  $("#btn-proxy-bid-cancel").click(function() {
    $.ajax({
      url: "<@baseUrl.home />/member/cancel-proxy-price",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}"
      }
    }).done(function(data) {
      if (data.success) {
        window.location.reload();
      } else {
        alert(data.error);
      }
    });
  });

  $("#layer-btn-1").click(function() {
    $.ajax({
      url: "<@baseUrl.home />/member/set-proxy-price",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}",
        price: parseInt($("#layer-proxy-price").html().replace(/[^0-9]/g, ""))
      }
    }).done(function(data) {
      if (data.success) {
        window.location.reload();
      } else {
        alert(data.error);
      }
    });
  });

  $("#layer-btn-2").click(function() {
    $.LAYER.close();
  });

  $("#tip-setdl .btnaddbox a.x").click(function() {
    var price = parseInt($(this).html().replace(/[^0-9]/g, ""));
    var $layerProxyPrice = $("#layer-proxy-price");
    var proxyPrice = parseInt($layerProxyPrice.html().replace(/[^0-9]/g, ""));
    $layerProxyPrice.html(format1(price + proxyPrice));
  });

  $("#layer-reset").click(function() {
    $("#layer-proxy-price").html($("#layer-current-price").html());
  });

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
	        avId: "${auctionVehicle.id}"
	      }
	    }).done(function(data) {
	      if (data.success) {
	        $("#a1-1").show();
	        $("#a3-3").hide();
	      } else{
	      	window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/auction/${(auction.id)!}/vehicle/${(vehicle.id)!}");
	      }
	    });
  	});

  $(".detail-control-1-on").click(function() {
    $.ajax({
      url: "<@baseUrl.home />/member/favorite/remove",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}"
      }
    }).done(function(data) {
      if (data.success) {
        $("#a1-1").hide();
        $("#a3-3").show();
      }else{
      	window.location.href = "https://login.autostreets.com/login?service=" + encodeURIComponent("<@baseUrl.home />/auction/${(auction.sid)!}/vehicle/${(vehicle.sid)!}");
      }
    });
  });
    
});
</script>
</body>
</html>
</#escape>
