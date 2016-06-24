<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="others" content="汽车街_同步拍">
<title>同步拍_汽车街</title>
<link href="http://img.autostreetscdn.com/common/build/2.00/css/b.css" rel="stylesheet" type="text/css" />
<link href="http://img.autostreetscdn.com/sell/build/1.00/css/list.css" rel="stylesheet" type="text/css" />
</head>
<body class="body1 w950">
<#include "/include/header2.ftl">
<@layout.nav active = "sync-auction"/>
<div class="listbody">
    <div>
        <table class="plist">
            <thead>
                <tr>
                    <td class="plist_name">拍卖场地
                    <select onchange="getAuctionByPlaceId(this.value)">
                    	<option value="">全部</option>
                    	<#list auctionPlaces as auctionPlace>
                    		<option <#if auctionPlaceId??&&auctionPlaceId==auctionPlace.id>selected="selected"</#if> value="${(auctionPlace.id)!}">${(auctionPlace.name)!}</option>
                    	</#list>
                    </select>
                    </td>
                    <td class="plist_city">所在城市</td>
                    <td class="plist_num">拍品数量</td>
                    <td class="plist_state">状态</td>
                </tr>
            </thead>
            <tbody>
              <#list p.thisPageElements as e>
                <tr>
                    <td class="plist_name">
                        <#assign tempPicUrl = "">
        				<#if (e.picUrl)?? && e.picUrl != ''>
        				  <#assign tempPicUrl=action.getThumbImgUrl("102*77",e.picUrl)>
        			    <#elseif (e.placeId)??>
        				  <#assign tempPicUrl = action.getThumbImgUrl("102*77",action.getAuctionPicUrl(e.placeId))/>
        			    </#if>
                        <a href="<@baseUrl.home />/syncauction/detail/${e.id}"><img src="<@baseUrl.image />/${(tempPicUrl)!}" alt=""></a>
                        <h3><a href="<@baseUrl.home />/syncauction/detail/${e.id}">${(e.title)!}</h3>
                        <p class="p1">${(e.startTimestamp?string("yyyy年MM月dd日 HH:mm"))!}-${(e.endTimestamp?string("yyyy年MM月dd日 HH:mm"))!}</p>
                    </td>
                    <td class="plist_city">${(e.city)!}</td>
                    <td class="plist_num">${(e.vehicleQuantity)!0} 辆</td>
                    <td class="plist_state"><#if e.status??><#if e.status == 1><span class="span-3">即将开始</span><#elseif e.status == 2><span class="span-1">竞拍中</span><#elseif e.status == 3><span class="span-2">竞拍结束</span></#if></#if></td>
                </tr>
              </#list>
            </tbody>
        </table>
        <@pagination.pagination />
    </div>
</div>
<#include "/include/footer.ftl">
<script>
/**
 * 根据场地id获取拍卖会信息
*/
function getAuctionByPlaceId(placeId){
	location="<@baseUrl.home />/syncauction/list?auctionPlaceId="+placeId;
}

$(function(){
	
});
</script>
</body>
</html>

