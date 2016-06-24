<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="others" content="汽车街_同步拍_${auction.title}_同步控制台">
<title>同步控制台_${auction.title}_同步拍_汽车街</title>
<link href="http://bk.autostreetscdn.com/common/build/1.00/css/default/b.css" rel="stylesheet" type="text/css" />
<link href="http://bk.autostreetscdn.com/panel/build/1.00/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="panl-body">
<div class="clearfix nfixwmain">
  <div class="panl-l">
    <div class="panl-img">
      <h3 class="panl-title">拍品图片</h3>
       <spring:eval expression="@auctionDictionaryService.choiceImgUrl('200X150','${auctionVehicle.vehicle.firstPhotoUrl}')" var="firstPhotoUrl"></spring:eval>
        <c:choose>
           <c:when test="${!empty firstPhotoUrl}">
             <img src="${dfsHttpServer}/${firstPhotoUrl}" style="width: 200px; height: 150px;">
           </c:when>
           <c:otherwise>
              <img src="http://img.autostreetscdn.com/common/build/1.00/images/noimg.png" style="width: 200px; height: 150px;">
           </c:otherwise>
        </c:choose>
    </div>
    <div class="panl-summary">
      <h3 class="panl-title">拍品描述</h3>
      <p>${auctionVehicle.vehicle.vehicleDesc}</p>
    </div>
    <c:set var="vehiclename"  value="${auctionVehicle.vehicle.brand} ${auctionVehicle.vehicle.vehicleModel} ${auctionVehicle.vehicle.selledName}"/>
    <c:if test="${!(empty auctionVehicle.vehicle.sweptVolumeStandard) and (fn:startsWith(auctionVehicle.vehicle.sweptVolumeStandard,'欧'))}">
    	  <c:set var="vehiclename"  value="${auctionVehicle.vehicle.brand} ${auctionVehicle.vehicle.vehicleModel}(进口) ${auctionVehicle.vehicle.selledName}"/>
    </c:if>
    <div class="panl-info">
      <h3 class="panl-title">拍品信息</h3>
      <ul>
        <li><label>拍品号：</label><input type="text" readonly value="${auctionVehicle.auctionVehicleOrder}"></li>
        <li><label>拍品名称：</label><input type="text" readonly value="${vehiclename}"></li>
        <li><label>起拍价格：</label><input type="text" readonly value="<fmt:formatNumber value='${empty auctionVehicle.startPrice?0:auctionVehicle.startPrice}' pattern='#'/>" id="start-price-input"></li>
        <li><label>佣金：</label><input type="text" readonly value="${commission}" id="commission-input"></li>
        <li><label>计量数量：</label><input type="text" readonly value=""></li>
        <li><label>计量单位：</label><input type="text" readonly value=""></li>
        <li><label>计价方式：</label><input type="text" readonly value=""></li>
        <li><label>需保证金：</label><input type="text" readonly value="<fmt:formatNumber value='${empty auction.vehicleMargin?0:auction.vehicleMargin}' pattern='#'/>" ></li>
      </ul>
    </div>
    <div class="panl-time">
      <p></p>
    </div>
  </div>
  <div class="panl-c">
  	<div class="current-price">
      <div class="price-body">
      	<input value="${auctionVehicle.status}" id="av_status" type="hidden" />
        <h3 class="panl-title">当前出价</h3>
        <p class="price-show-box"><span class="price-show"><strong id="price-show">${currentPriceFormat}</strong>元</span><span id="price-show-cn">${currentPriceFormatCN}</span></p>
        <div class="price-show-txt">
          <p>应付佣金：<i>${commission}</i>元</p>
          <p>网络用户：<i>200</i>人</p>
        </div>
      </div>
      <div class="panl-status">
        <a class="controlbtn" href="javascript:;" id="btn-start-auction"<c:if test="${auction.status ne 1}"> style="display: none;"</c:if>>[点此拍卖会开始]</a>
    	<a class="controlbtn" href="javascript:;" id="btn-end-auction"<c:if test="${auction.status ne 2}"> style="display: none;"</c:if>>[点此拍卖会结束]</a>
        <span class="s1" id="s1"><c:if test="${auction.status eq 1}">尚未开始</c:if><c:if test="${auction.status eq 2}">正在拍卖</c:if><c:if test="${auction.status eq 3}">拍卖结束</c:if></span>
      </div>
    </div>
    <div class="clearfix nfixwcenter">
    <div class="panl-mt">
      <h3 class="panlmt-title panlmt-title-1">手动价</h3>
      <div class="setprice-box">
        <p class="setprice-inputbox">
        	<input type="text" id="wan" name="wan" value="0" onblur="if(this.value=='')this.value='0'" onfocus="if(this.value=='0')this.value=''"> 万 <input type="text" id="qian" name="qian" value="0" onblur="if(this.value=='')this.value='0'" onfocus="if(this.value=='0')this.value=''"> 千 <input type="text" id="yuan" name="yuan" value="0" onblur="if(this.value=='')this.value='0'" onfocus="if(this.value=='0')this.value=''"> 元
        </p>
        <p><a href="javascript:;" class="setprice-btn mr20" id="btn-1">设保留价</a><a href="javascript:;" class="setprice-btn" id="btn-2">设起拍价</a><a href="javascript:;" class="setprice-btn" id="btn-manual">手动出价</a></p>
      </div>
      <h3 class="panlmt-title">加价幅度：<strong>${empty auctionVehicle.plusRange?0:auctionVehicle.plusRange}</strong>元</h3>
      <ul class="setprice-btnbox clearfix">
        <li><a href="javascript:;">100</a></li>
        <li><a href="javascript:;">200</a></li>
        <li><a href="javascript:;">300</a></li>
        <li><a href="javascript:;">400</a></li>
        <li><a href="javascript:;">1000</a></li>
        <li><a href="javascript:;">2000</a></li>
        <li><a href="javascript:;">5000</a></li>
        <li><a href="javascript:;">10000</a></li>
      </ul>
      <p class="setprice-mt">手动设置加价幅度 <input type="text" id="plus-range" name="plusRange" class="setprice-input-1" value="0"> <a href="javascript:;" class="setprice-btn setprice-btn-1" id="btn-3">设置</a></p>
    </div>
    <div class="panl-at">
      <h3 class="panl-title-3">本次拍品最高代理价：<c:if test="${!empty maxProxyPrice}"><i>${maxProxyPrice}</i>元</c:if><c:if test="${empty maxProxyPrice}"><i>无</i></c:if></h3>
      <div class="panl-at-box">
        <div>
          <p>
            当前价格
          <span id="cur-price"><fmt:formatNumber value='${empty currentPrice?0:currentPrice}' pattern='#'/></span>
          </p>
          <a href="javascript:;" class="panl-at-btn1" id="btn-cancel"></a>
          <a href="javascript:;" class="panl-at-btn2<c:if test="${!onlineEndActive}"> disabled </c:if>" id="btn-online-end" style="font-size: 32px;"><c:if test="${!empty seconds and (seconds > 0)} ">${seconds}</c:if></a>
        </div>
        <div id="bid-list">
          <c:forEach items="${bidPriceList}" var="bidPrice" >
            <a href="javascript:;"<c:if test="${auctionVehicle.status eq 5}"> class="on"</c:if>><fmt:formatNumber value='${empty bidPrice?0:bidPrice}' pattern='#,#00'/></a>
          </c:forEach>
        </div>
      </div>
    </div>
    <div class="panl-btnbox">
      <ul>
      	<c:if test="${auction.status eq 2}">
	       <c:if test="${auctionVehicle.status eq 1}">
	          <li><a href="javascript:;" class="panl-btn-1" id="btn-start">开始</a></li>
	          <li><a href="javascript:;" class="panl-btn-2-off" id="btn-pause">暂停</a></li>
	          <li><a href="javascript:;" class="panl-btn-3-off" id="btn-complete">成交</a></li>
	          <li><a href="javascript:;" class="panl-btn-4-off" id="btn-fail">流拍</a></li>
	          <li><a href="javascript:;" class="panl-btn-5-off" id="btn-retry">再次拍卖</a></li>
	          <li><a href="javascript:;" class="panl-btn-6-off" id="btn-next">下一拍品</a></li>
	        </c:if>
	        <c:if test="${auctionVehicle.status eq 2}">
	          <li><a href="javascript:;" class="panl-btn-1-off" id="btn-start">开始</a></li>
	          <li><a href="javascript:;" class="panl-btn-2-off" id="btn-pause">暂停</a></li>
	          <li><a href="javascript:;" class="panl-btn-3-off" id="btn-complete">成交</a></li>
	          <li><a href="javascript:;" class="panl-btn-4-off" id="btn-fail">流拍</a></li>
	          <li><a href="javascript:;" class="panl-btn-5-off" id="btn-retry">再次拍卖</a></li>
	          <li><a href="javascript:;" class="panl-btn-6" id="btn-next">下一拍品</a></li>
	         </c:if>
	         <c:if test="${auctionVehicle.status eq 4}">
	          <li><a href="javascript:;" class="panl-btn-1" id="btn-start">开始</a></li>
	          <li><a href="javascript:;" class="panl-btn-2-off" id="btn-pause">暂停</a></li>
	          <li><a href="javascript:;" class="panl-btn-3-off" id="btn-complete">成交</a></li>
	          <li><a href="javascript:;" class="panl-btn-4-off" id="btn-fail">流拍</a></li>
	          <li><a href="javascript:;" class="panl-btn-5-off" id="btn-retry">再次拍卖</a></li>
	          <li><a href="javascript:;" class="panl-btn-6-off" id="btn-next">下一拍品</a></li>
	         </c:if>
	          <c:if test="${auctionVehicle.status eq 5}">
	          <li><a href="javascript:;" class="panl-btn-1-off" id="btn-start">开始</a></li>
	          <li><a href="javascript:;" class="panl-btn-2" id="btn-pause">暂停</a></li>
	          <li><a href="javascript:;" class="panl-btn-3" id="btn-complete">成交</a></li>
	          <li><a href="javascript:;" class="panl-btn-4" id="btn-fail">流拍</a></li>
	          <li><a href="javascript:;" class="panl-btn-5" id="btn-retry">再次拍卖</a></li>
	          <li><a href="javascript:;" class="panl-btn-6-off" id="btn-next">下一拍品</a></li>
	         </c:if>
	         <c:if test="${auctionVehicle.status eq 6}">
	          <li><a href="javascript:;" class="panl-btn-1" id="btn-start">开始</a></li>
	          <li><a href="javascript:;" class="panl-btn-2-off" id="btn-pause">暂停</a></li>
	          <li><a href="javascript:;" class="panl-btn-3-off" id="btn-complete">成交</a></li>
	          <li><a href="javascript:;" class="panl-btn-4-off" id="btn-fail">流拍</a></li>
	          <li><a href="javascript:;" class="panl-btn-5-off" id="btn-retry">再次拍卖</a></li>
	          <li><a href="javascript:;" class="panl-btn-6-off" id="btn-next">下一拍品</a></li>
	         </c:if>
	     </c:if>
	     <c:if test="${auction.status ne 2}"> 
        	<li><a href="javascript:;" class="panl-btn-1-off" id="btn-start">开始</a></li>
	        <li><a href="javascript:;" class="panl-btn-2-off" id="btn-pause">暂停</a></li>
	        <li><a href="javascript:;" class="panl-btn-3-off" id="btn-complete">成交</a></li>
	        <li><a href="javascript:;" class="panl-btn-4-off" id="btn-fail">流拍</a></li>
	        <li><a href="javascript:;" class="panl-btn-5-off" id="btn-retry">再次拍卖</a></li>
	        <li><a href="javascript:;" class="panl-btn-6-off" id="btn-next">下一拍品</a></li>
         </c:if>
      </ul>
    </div>
</div>
<div class="clearfix nfixwcenter">
    <div class="worldtalk">
      <h3 class="panl-title-2">现场状况</h3>
      <div class="talklist" id="talklist">
        <c:forEach items="${bidListWithMsg}" var="bid">
          <dl>
            <dt><fmt:formatDate value="${bid.bidTimestamp}" pattern="HH:mm:ss" /></dt>
            <dd>${bid.content}</dd>
          </dl>
        </c:forEach>
      </div>
      <div class="postmsg">
        <p><input type="text" name="msg" value="" id="msg"><a href="javascript:;" id="btn-send">发送</a></p>
        <p><select><option>请选择常用消息进行发送</option></select><a href="javascript:;">加入常用</a></p>
      </div>
    </div>
    <div class="panl-history">
      <h3 class="panl-title-2">出价记录</h3>
      <table class="panl-history-tbl1">
        <thead>
          <tr>
            <th>时间</th>
            <th>用户</th>
            <th>出价</th>
          </tr>
        </thead>
      </table>
      <div class="panl-history-box">
        <table>
          <tbody id="bid-log">
            <c:forEach items="${bidList}" var="bid">
              <tr>
                <td><fmt:formatDate value="${bid.bidTimestamp}" pattern="HH:mm:ss" /></td>
                <td>${bid.bidderUsername}</td>
                <td><fmt:formatNumber value='${empty bid.price?0:bid.price}' pattern='#'/>元</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  </div>
  <div class="panl-r">
    <h3 class="panl-title">拍品列表</h3>
    <div class="panlall-list">
      <ul>
        <c:forEach items="${auctionVehicleList}" var="e">
          <c:if test="${e.status eq 5 or e.status eq 6 or e.status eq 1 or e.status eq 4}">
            <li id="li-${e.id}">
              <div class="panlimgbox">
              	<span class="num">${e.auctionVehicleOrder}</span>
              	 <spring:eval expression="@auctionDictionaryService.choiceImgUrl('120X80','${e.vehicle.firstPhotoUrl}')" var="fPhotoUrl"></spring:eval>
              	<c:choose>
              	   <c:when test="${empty e.vehicle.firstPhotoUrl}">
              	      <img src="http://img.autostreetscdn.com/common/build/1.00/images/noimg.png" style="width: 120px; height: 80px;">
              	   </c:when>
              	   <c:otherwise>
              	      <img src="${dfsHttpServer}/${fPhotoUrl}" style="width: 120px; height: 80px;">
              	   </c:otherwise>
              	</c:choose>

              	<div class="repai">
              		<div class="repaibtn"><span><c:if test="${e.status eq 1}">[待拍] </c:if> <c:if test="${e.status eq 4}" >[流拍]</c:if>
              		<c:if test="${e.status eq 5}">[拍中] </c:if><c:if test="${e.status eq 6}">[停拍]</c:if></span>
              	      <c:choose>
              	         <c:when test="${e.status eq 1 or e.status eq 4}">
              	            <a name="avItem" id="av-${e.id}">开始拍卖</a>
              	         </c:when>
              	         <c:otherwise>
              	         	<a name="avItem" id="av-${e.id}" style="display: none;">开始拍卖</a>
              	         </c:otherwise>
              	      </c:choose>
					</div>
                	<div class="repaibg"></div>
              	</div>
              </div>
              
              <p>
              <c:if test="${e.vehicle.source eq 'av'}">
              	<img src="http://img.autostreetscdn.com/sell/build/1.00/images/sample.png" style="vertical-align:middle;" alt="" title="该车暂缺照片和检测报告，请以现场实车为准">
              </c:if>
              ${e.vehicle.brand} ${e.vehicle.vehicleModel} ${e.vehicle.selledName}
              </p>
              <c:if test="${e.id eq auctionVehicle.id}"><div class="now"></div></c:if>
            </li>
         </c:if>
        </c:forEach>
      </ul>
    </div>
  </div>
</div>
</div>
<script type="text/javascript" src="${staticUrl}/common/build/1.00/js/jquery-1.8.3.min.js"></script>
<script>

$(function() {
  var li_index = $(".panlall-list > ul > li").index($("#li-${auctionVehicle.id}"));
  $(".panlall-list").scrollTop(135 * li_index);
  
  
  function fill(n) {
    return n < 10 ? "0" + n : "" + n;
  }

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

  function format1(x) {
    var s = x.toFixed(0);
    var buffer = [];
    if (s.length > 3) {
      buffer.push(s.substring(0, s.length - 3));
      buffer.push(",");
      buffer.push(s.substring(s.length - 3));
    } else {
      buffer.push(s);
    }
    return buffer.join("");
  }

  function formatCN(x) {
    var s = x.toFixed(0);
    var bai;
    var qian;
    var wan;
    if (s.length < 3) {
      return "<i>0</i>万<i>0</i>千<i>0</i>百";
    } else if (s.length == 3) {
      bai = s.substring(s.length - 3, s.length - 2);
      return "<i>0</i>万<i>0</i>千<i>" + bai + "</i>百";
    } else if (s.length == 4) {
      bai = s.substring(s.length - 3, s.length - 2);
      qian = s.substring(s.length - 4, s.length - 3);
      return "<i>0</i>万<i>" + qian + "</i>千<i>" + bai + "</i>百";
    } else {
      bai = s.substring(s.length - 3, s.length - 2);
      qian = s.substring(s.length - 4, s.length - 3);
      wan = s.substring(0, s.length - 4);
      return "<i>" + wan + "</i>万<i>" + qian + "</i>千<i>" + bai + "</i>百";
    }
  }

  function formatDate(ms) {
    var buffer = [];

    var d = new Date();
    d.setTime(ms);

    if (d.getHours() < 10) {
      buffer.push("0");
    }
    buffer.push(d.getHours());
    buffer.push(":");

    if (d.getMinutes() < 10) {
      buffer.push("0");
    }
    buffer.push(d.getMinutes());
    buffer.push(":");

    if (d.getSeconds() < 10) {
      buffer.push("0");
    }
    buffer.push(d.getSeconds());

    return buffer.join("");
  }

  setInterval(function() {
    var currentDate = new Date();
    var buffer = [];
    buffer.push(currentDate.getFullYear());
    buffer.push(" 年 ");
    buffer.push(fill(currentDate.getMonth() + 1));
    buffer.push(" 月 ");
    buffer.push(fill(currentDate.getDate()));
    buffer.push(" 日 ");
    buffer.push(fill(currentDate.getHours()));
    buffer.push(":");
    buffer.push(fill(currentDate.getMinutes()));
    buffer.push(":");
    buffer.push(fill(currentDate.getSeconds()));
    $(".panl-time > p").html(buffer.join(""));
  }, 1000);

  $("#btn-1").click(function() {
    var wan = parseInt($("#wan").val());
    var qian = parseInt($("#qian").val());
    var yuan = parseInt($("#yuan").val());

    $.ajax({
      url: "${ctx }/panel/set-reserve-price",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}",
        reservePrice: wan * 10000 + qian * 1000 + yuan
      }
    }).done(function(data) {
      if (data.success) {
        alert("设置保留价成功！");
        window.location.reload();
      }
    });
  });

  $("#btn-2").click(function() {
    var wan = parseInt($("#wan").val());
    var qian = parseInt($("#qian").val());
    var yuan = parseInt($("#yuan").val());

    $.ajax({
      url: "${ctx }/panel/set-start-price",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}",
        startPrice: wan * 10000 + qian * 1000 + yuan
      }
    }).done(function(data) {
      if (data.success) {
        alert("设置起拍价成功！");
        window.location.reload();
      }
    });
  });

  $("#btn-manual").click(function() {
    var wan = parseInt($("#wan").val());
    var qian = parseInt($("#qian").val());
    var yuan = parseInt($("#yuan").val());
	var status = $("#av_status").val();
	
	if (status != "5") {
		return;
	}
	
    $.ajax({
      url: "${ctx }/panel/bid/add",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}",
        price: wan * 10000 + qian * 1000 + yuan
      }
    }).done(function(data) {
      if (data.success) {
        $("#cur-price").html(data.price);
        $("#price-show").html(format(data.price));
        $("#price-show-cn").html(formatCN(data.price));
        //$("#commission").html(data.commission);
        $("#commission-input").val(data.commission);

        var currentPrice = data.price;
        $("#bid-list > a").each(function(i, e) {
          $(e).html(format1(currentPrice + (i + 1) * data.plusRange));
        });

        if (data.bid) {
          $("#bid-log").prepend("<tr><td>" + formatDate(data.bid.bidTimestamp) + "</td><td>" + data.bid.bidderUsername + "</td><td>" + data.bid.price + "元</td></tr>");
          $("#talklist").prepend("<dl><dt>" + formatDate(data.bid.bidTimestamp) + "</dt><dd>" + data.bid.content + "</dd></dl>");
        }
      } else {
        alert(data.error);
      }
    });
  });

  $("#btn-3").click(function() {
  	var rangeVal = parseInt($("#plus-range").val());
  	if (rangeVal > 30000) {
  		alert("您设置的值太大，请重新设置！");
  		return;
  	}
  	
    $.ajax({
      url: "${ctx }/panel/set-plus-range",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}",
        plusRange: parseInt($("#plus-range").val())
      }
    }).done(function(data) {
      if (data.success) {
        alert("设置加价幅度成功！");
        $(".panlmt-title > strong").html(data.plusRange);

        var currentPrice = parseInt($("#cur-price").html());
        $("#bid-list > a").each(function(i, e) {
          $(e).html(format1(currentPrice + (i + 1) * data.plusRange));
        });
      }
    });
  });

  $("#bid-list > a").click(function() {
    var $this = $(this);
    if (!$this.hasClass("on")) {
      return;
    }

    var price = parseInt($this.html().replace(/[^0-9]/g, ""));

    $.ajax({
      url: "${ctx }/panel/bid/add",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}",
        price: price
      }
    }).done(function(data) {
      if (data.success) {
        $("#cur-price").html(data.price);
        $("#price-show").html(format(data.price));
        $("#price-show-cn").html(formatCN(data.price));
        $("#commission").html(data.commission);
        $("#commission-input").val(data.commission);

        var currentPrice = data.price;
        $("#bid-list > a").each(function(i, e) {
          $(e).html(format1(currentPrice + (i + 1) * data.plusRange));
        });

        if (data.bid) {
          $("#bid-log").prepend("<tr><td>" + formatDate(data.bid.bidTimestamp) + "</td><td>" + data.bid.bidderUsername + "</td><td>" + data.bid.price + "元</td></tr>");
          $("#talklist").prepend("<dl><dt>" + formatDate(data.bid.bidTimestamp) + "</dt><dd>" + data.bid.content + "</dd></dl>");
        }
      } else {
        alert(data.error);
      }
    });
  });

  $(".setprice-btnbox > li > a").click(function() {
    $("#plus-range").val($(this).html());
  });

  $("#btn-start-auction").click(function() {
    $.ajax({
      url: "${ctx }/panel/start-auction",
      type: "post",
      data: {
        auctionId: "${auction.id}"
      }
    }).done(function(data) {
      if (data.success) {
        $("#s1").html("正在拍卖");
        $("#btn-start-auction").hide();
        $("#btn-end-auction").show();
        
        window.location.reload();
      }
    });
  });

  $("#btn-end-auction").click(function() {
    if (!confirm("您确认结束吗？")) {
      return;
    }

    $.ajax({
      url: "${ctx }/panel/end-auction",
      type: "post",
      data: {
        auctionId: "${auction.id}"
      }
    }).done(function(data) {
      if (data.success) {
        $("#s1").html("拍卖结束");
        $("#btn-end-auction").hide();
        
        //删除reload，防止删除流拍车辆的出价记录
        //window.location.reload();
      }else{
          alert(data.msg);
      }
    });
  });

  $("#btn-start").click(function() {
    if ($(this).hasClass("panl-btn-1-off")) {
      return;
    }

    $.ajax({
      url: "${ctx }/panel/start-av",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}"
      }
    }).done(function(data) {
      if (data.success) {
        $("#btn-start").removeClass("panl-btn-1");
        $("#btn-start").addClass("panl-btn-1-off");

        $("#btn-pause").removeClass("panl-btn-2-off");
        $("#btn-pause").addClass("panl-btn-2");

        $("#btn-complete").removeClass("panl-btn-3-off");
        $("#btn-complete").addClass("panl-btn-3");

        $("#btn-fail").removeClass("panl-btn-4-off");
        $("#btn-fail").addClass("panl-btn-4");

        $("#btn-retry").removeClass("panl-btn-5-off");
        $("#btn-retry").addClass("panl-btn-5");

        $("#btn-next").removeClass("panl-btn-6");
        $("#btn-next").addClass("panl-btn-6-off");

        $("#bid-list > a").addClass("on");
        
        $("#li-${auctionVehicle.id} .repaibtn span").html("[拍中]");
        $("#av-${auctionVehicle.id}").hide();
        
        if (data.msgBid) {
          $("#talklist").prepend("<dl><dt>" + formatDate(data.msgBid.bidTimestamp) + "</dt><dd>" + data.msgBid.content + "</dd></dl>");
        }
      }
    });
  });

  $("#btn-pause").click(function() {
    if ($(this).hasClass("panl-btn-2-off")) {
      return;
    }

    $.ajax({
      url: "${ctx }/panel/pause-av",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}"
      }
    }).done(function(data) {
      if (data.success) {
        $("#btn-start").removeClass("panl-btn-1-off");
        $("#btn-start").addClass("panl-btn-1");

        $("#btn-pause").removeClass("panl-btn-2");
        $("#btn-pause").addClass("panl-btn-2-off");

        $("#btn-complete").removeClass("panl-btn-3");
        $("#btn-complete").addClass("panl-btn-3-off");

        $("#btn-fail").removeClass("panl-btn-4");
        $("#btn-fail").addClass("panl-btn-4-off");

        $("#btn-retry").removeClass("panl-btn-5");
        $("#btn-retry").addClass("panl-btn-5-off");

        $("#btn-next").removeClass("panl-btn-6");
        $("#btn-next").addClass("panl-btn-6-off");

        $("#bid-list > a").removeClass("on");

        if (data.msgBid) {
          $("#talklist").prepend("<dl><dt>" + formatDate(data.msgBid.bidTimestamp) + "</dt><dd>" + data.msgBid.content + "</dd></dl>");
        }
      }
    });
  });

  $("#btn-complete").click(function() {
    if ($(this).hasClass("panl-btn-3-off")) {
      return;
    }

    if (!confirm("确认成交吗？")) {
      return;
    }

    $.ajax({
      url: "${ctx }/panel/complete-av",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}"
      }
    }).done(function(data) {
      if (data.success) {
        $("#btn-start").removeClass("panl-btn-1");
        $("#btn-start").addClass("panl-btn-1-off");

        $("#btn-pause").removeClass("panl-btn-2");
        $("#btn-pause").addClass("panl-btn-2-off");

        $("#btn-complete").removeClass("panl-btn-3");
        $("#btn-complete").addClass("panl-btn-3-off");

        $("#btn-fail").removeClass("panl-btn-4");
        $("#btn-fail").addClass("panl-btn-4-off");

        $("#btn-retry").removeClass("panl-btn-5");
        $("#btn-retry").addClass("panl-btn-5-off");

        $("#btn-next").removeClass("panl-btn-6-off");
        $("#btn-next").addClass("panl-btn-6");

        $("#bid-list > a").removeClass("on");
      }
    });
  });

  $("#btn-fail").click(function() {
    if ($(this).hasClass("panl-btn-4-off")) {
      return;
    }

    if (!confirm("确认流拍吗？")) {
      return;
    }

    $.ajax({
      url: "${ctx }/panel/fail-av",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}"
      }
    }).done(function(data) {
      if (data.success) {
        $("#btn-start").removeClass("panl-btn-1");
        $("#btn-start").addClass("panl-btn-1-off");

        $("#btn-pause").removeClass("panl-btn-2");
        $("#btn-pause").addClass("panl-btn-2-off");

        $("#btn-complete").removeClass("panl-btn-3");
        $("#btn-complete").addClass("panl-btn-3-off");

        $("#btn-fail").removeClass("panl-btn-4");
        $("#btn-fail").addClass("panl-btn-4-off");

        $("#btn-retry").removeClass("panl-btn-5");
        $("#btn-retry").addClass("panl-btn-5-off");

        $("#btn-next").removeClass("panl-btn-6-off");
        $("#btn-next").addClass("panl-btn-6");

        $("#bid-list > a").removeClass("on");
        
        $("#li-${auctionVehicle.id} .repaibtn span").html("[流拍]");
        $("#av-${auctionVehicle.id}").show();
        
      }
    });
  });

  $("#btn-retry").click(function() {
    if ($(this).hasClass("panl-btn-5-off")) {
      return;
    }

    $.ajax({
      url: "${ctx }/panel/retry-av",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}"
      }
    }).done(function(data) {
      if (data.success) {
        $("#bid-list > a").removeClass("on");

        window.location.reload();
      }
    });
  });

  $("#btn-next").click(function() {
    if ($(this).hasClass("panl-btn-6-off")) {
      return;
    }

    $("#bid-list > a").removeClass("on");

    $.ajax({
      url: "${ctx }/panel/next-av",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}",
        auctionId:"${auction.id}"
      }
    }).done(function(data) {
      if (data.success) {
        window.location.reload();
      }
    });
  });

  setInterval(function() {
    $.ajax({
      url: "${ctx }/panel/sync",
      type: "get",
      timeout: 1000,
      data: {
        avId: "${auctionVehicle.id}",
        t: new Date().getTime()
      }
    }).done(function(data) {
      if (data.success) {
        $("#cur-price").html(data.currentPrice);
        $("#price-show").html(format(data.currentPrice));
        $("#price-show-cn").html(formatCN(data.currentPrice));
       // $("#commission").html(data.commission);
        $("#commission-input").val(data.commission);
        
        $("#av_status").val(data.currentAVStatus);

        var buffer = [];
        for (var i = 0; i < data.bidList.length; ++i) {
          var bid = data.bidList[i];

          buffer.push("<tr><td>");
          buffer.push(formatDate(bid.bidTimestamp));
          buffer.push("</td><td>");
          buffer.push(bid.bidderUsername);
          buffer.push("</td><td>");
          buffer.push(bid.price);
          buffer.push("元</td></tr>");
        }
        $("#bid-log").html(buffer.join(""));

        buffer = [];
        for (var i = 0; i < data.bidListWithMsg.length; ++i) {
          var msgBid = data.bidListWithMsg[i];

          buffer.push("<dl><dt>");
          buffer.push(formatDate(msgBid.bidTimestamp));
          buffer.push("</dt><dd>");
          buffer.push(msgBid.content);
          buffer.push("</dd></dl>");
        }

        $("#talklist").html(buffer.join(""));

        var currentPrice = data.currentPrice;
        $("#bid-list > a").each(function(i, e) {
          $(e).html(format1(currentPrice + (i + data.hasBid) * data.plusRange));
        });

        if (data.onlineEndActive) {
          $("#btn-online-end").removeClass("disabled");
        } else {
          $("#btn-online-end").addClass("disabled");
        }

        if (data.seconds && data.seconds >= 0) {
          $("#btn-online-end").html(data.seconds.toString());
        } else {
          $("#btn-online-end").html("");
        }
      }
    });
  }, 1000);

  $("#btn-send").click(function() {
    $.ajax({
      url: "${ctx }/panel/send-msg",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}",
        content: $("#msg").val()
      }
    }).done(function(data) {
      if (data.success) {
        $("#talklist").prepend("<dl><dt>" + formatDate(data.msgBid.bidTimestamp) + "</dt><dd>" + data.msgBid.content + "</dd></dl>");
      }
    });
  });

  $("#btn-cancel").click(function() {
    $.ajax({
      url: "${ctx }/panel/cancel-price",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}"
      }
    }).done(function(data) {
      if (data.success) {
        window.location.reload();
      }
    });
  });
  
    
  $("a[name='avItem']").click(function() {
  	var curStatus = $("#av_status").val();
  	
  	var auStatus = "${auction.status}";
  	if (auStatus != "2") {
  		alert("当前拍卖会非开始状态！");
  		return;
  	}
  	
  	if (curStatus == "5" || curStatus == "6") {
  		return;
  	}
  	
  	var avId = this.id.substring(3);

    $.ajax({
      url: "${ctx }/panel/set-start-av",
      type: "post",
      data: {
        avId: avId,
        auctionId: "${auction.id}"
      }
    }).done(function(data) {
      if (data.success) {
        window.location.reload();
      }
    });
  });
  

  $("#btn-online-end").click(function() {
    if ($(this).hasClass("disabled")) {
      return;
    }

    $.ajax({
      url: "${ctx }/panel/online-end",
      type: "post",
      data: {
        avId: "${auctionVehicle.id}"
      }
    }).done(function(data) {
      if (data.success) {
        $("#btn-end").addClass("disabled");
      }
    });
  });
});
</script>
</body>
</html>