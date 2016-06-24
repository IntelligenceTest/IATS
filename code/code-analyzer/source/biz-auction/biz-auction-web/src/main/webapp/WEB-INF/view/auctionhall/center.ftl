<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="汽车,汽车街,二手车,二手车拍卖,汽车图片,汽车询价,经销商,新车,宝马,置换,新车置换,汽车之家" />
    <meta name="description" content="汽车街为您提供最新汽车报价，汽车图片，汽车价格大全，优质二手车展厅，二手车拍卖、免费上门评估、检测、置换" />
<meta name="others" content="汽车街_竞拍大厅">
    <title>竞拍大厅_汽车街</title>
    
    <link href="http://img.autostreetscdn.com/sell/build/1.00/css/list.css" rel="stylesheet" type="text/css" />
</head>
<body>
<#include "/include/header2.ftl">
<@layout.nav active = "sync-auction"/>
	<div class="position">
		<a class="positionmain" href="<@baseUrl.home />/">首页</a> &gt; <span>汽车街拍卖中心</span>
	</div>
    <div class="main clearfix">
        <h2>汽车街拍卖中心</h2>
        <ul class="shop_list">
            <#list avpList as place>
	        <li>
	           <#assign picUrl = action.choiceModelPic("290*150", place.picUrl)/>
	           <img src="<@baseUrl.image />/${(picUrl)!}" alt="">
	           <h3>${(place.name)!}</h3>
	           <p>时间：${(place.period)!}</p>
	           <p>电话：${(place.telephone)!}</p>
	           <p>地址：${(place.addr)!}</p>
	        </li>
            </#list>
        </ul>
    </div>
    <div class="clearfix"></div>
 <#include "/include/footer.ftl">
<script>
$(function(){
    $('.shop_list li').each(function(){
        var _index = $('.shop_list li').index(this)
        if((_index+1)%3 == 0)$(this).css('margin',"0 0 20px 0")
    })
})
</script>
</body>
</html>
</#escape>
