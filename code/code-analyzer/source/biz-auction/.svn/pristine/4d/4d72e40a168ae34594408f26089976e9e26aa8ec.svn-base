<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/pagination.ftl" as pagination>
<#import "/macro/layout.ftl" as layout>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
<meta name="others" content="汽车街_同步拍">
    <title>同步拍_汽车街</title>
    <link href="http://img.autostreetscdn.com/common/build/2.00/css/b.css" rel="stylesheet" type="text/css" />
    <link href="http://img.autostreetscdn.com/sell/build/1.00/css/auction.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="http://img.autostreetscdn.com/sell/build/1.00/css/auction_index.css"/>
</head>
<body class="w950">
<#include "/include/header2.ftl">
<@layout.nav active = "sync-auction"/>
<div class="position">
  <a class="positionmain" href="<@baseUrl.parentHome />/">首页</a> &gt; <a href="<@baseUrl.home />"><span>竞拍大厅</span></a> &gt; <span>同步拍</span>
</div>
<div id="sync_auction">
    <div class="auction_banner">
        <div class="slide">
            <div class="slide_pic">
                <ul>
                	<#if advList??&&advList?size gt 0>
            			<#list advList as adv>
                		 	<li>
                       		 	<#if adv.clickUrl??&&adv.clickUrl != ''>
		                        	<a href="${adv.clickUrl}" onclick="_hmt.push(['_trackEvent', '竞拍大厅banner', 'click', '${adv.name}']);_traceEvent('竞拍大厅banner', '点击', '${adv.name}','10','false');" target="_blank"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('950*300','${(adv.adDesign)!}')!}"/></a>
		                     	<#else>
		                     		<a href="javascript:;"><img src="<@baseUrl.image/>/${action.getThumbImgUrl('950*300','${(adv.adDesign)!}')!}"/></a>
		                    	</#if>
                        	</li>
                    	</#list>
		  		    </#if>
                </ul>
            </div>
            <div class="slide_num">
                <ul></ul>
            </div>
            <a href="javascript:void(0)" class="slide_btn prev_btn"></a>
            <a href="javascript:void(0)" class="slide_btn next_btn"></a>
        </div>
    </div>
    <div class="info">
        <p><span>参拍咨询热线</span><span class="tel">400-821-8889</span></p>
        <div class="apply">
            <a onclick="isVipMember()" href="javascript:void(0);">申请竞拍资格</a>
        </div>
    </div>
    <a href="<@baseUrl.home />/center" class="au_banner"><img src="http://img.autostreetscdn.com/sell/build/1.00/images/au_center.png" alt=""/></a>
    <div class="sync_auction">
        <h2 class="au_h2">同步拍</h2>
        <a href="<@baseUrl.home />/syncauction/list" class="view_more">查看更多</a>
        <ul>
           <#list auctionList as auction>
             <li>
                <#assign tempPicUrl = "">
        		<#if (auction.picUrl)?? && auction.picUrl != ''>
        			<#assign tempPicUrl=action.getThumbImgUrl("520*270",auction.picUrl)>
        		<#elseif (auction.placeId)??>
        			<#assign tempPicUrl = action.getThumbImgUrl("520*270",action.getAuctionPicUrl(auction.placeId))/>
        		</#if>
                <img class="shop_img lazy_img" original="<@baseUrl.image />/${(tempPicUrl)!}" alt=""/>
                <div class="auction_detail">
                    <div class="au_tit">
                        <i class="au_idx">第${(auction.auctionNum)!}场</i>
                        <h3>${(auction.title)!}</h3>
                    </div>
                    <div class="au_desc">
                    	<#if (auction.auctionModelDesc)??&&auction.auctionModelDesc!="">
	                        <dl>
	                            <dt>主要品牌：</dt>
	                            <dd>${(auction.auctionModelDesc)!}</dd>
	                        </dl>
                    	</#if>
                        <dl>
                            <dt>参拍数量：</dt>
                            <dd>${(auction.vehicleQuantity)!}台</dd>
                        </dl>
                        <dl>
                            <dt>开始时间：</dt>
                            <dd>${(auction.startTimestamp?string('yyyy年MM月dd日 HH:mm'))!}</dd>
                        </dl>
                        <dl>
                            <dt>竞拍地址：</dt>
                            <dd><#if (auction.placeId)??>${(action.getAuctionAddress((auction.placeId)!))!}</#if></dd>
                        </dl>
                    </div>
                    <#if (auction.status)?? && auction.status == 1 >
                      <a href="<@baseUrl.home />/syncauction/detail/${(auction.id)!}" class="au_btn au_will"><span class="au_icon">即将开始</span><i class="inside_btn">查看详情</i></a>
                    <#elseif (auction.status)?? && auction.status == 2 >
                      <a href="<@baseUrl.home />/syncauction/detail/${(auction.id)!}" class="au_btn au_ing"><span class="au_icon">竞拍中</span><i class="inside_btn white_btn">查看详情</i></a>
                    <#else>
                      <a href="<@baseUrl.home />/syncauction/detail/${(auction.id)!}" class="au_btn au_end"><span class="au_icon">已结束</span><i class="inside_btn white_btn">查看详情</i></a>
                    </#if>
                </div>
             </li>
           </#list>
        </ul>
    </div>
</div>

<div class="UED_hide" id="tip-success">
    <div class="tip-success">
        <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
        <div class="tip-success-box">
            <p>您已经认证成功!</p>
            <span>3秒后自动关闭</span>
        </div>
    </div>
</div>

<#include "/include/footer.ftl">
<script language="javascript" src="http://img.autostreetscdn.com/common/build/2.00/js/jquery.MinmyLazyload.js"></script>
<script src="http://img.autostreetscdn.com/fed/build/1.00/js/slide.js"></script>
<script src="http://img.autostreetscdn.com/sell/build/1.00/js/auction_index.js"></script>
<script src="http://img.autostreetscdn.com/common/build/1.00/js/jq.layer.js"></script>
<script>
function isVipMember(){
	$.ajax({
		url:"<@baseUrl.home />/syncauction/isVipMember",
		success:function(data){
			if(data){
				jQuery.LAYER.show({id:'tip-success',overlay:{opacity:0.5}});
                setTimeout('$.LAYER.close()',3000);
			}else{
				location="http://www.autostreets.com/dealerapply/auctionindex";
			}
		}
	})
}
</script>
</body>
</html>
