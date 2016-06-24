<#import "/macro/baseUrl.ftl" as baseUrl>
<#import "/macro/layout.ftl" as layout>
<#escape x as x?html>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="others" content="汽车街_二手车展厅_支付订单">
<title>支付订单_二手车展厅_汽车街</title>
<link href="<@baseUrl.static />/common/build/1.00/css/b.css<@baseUrl.time />" rel="stylesheet" />
<link href="<@baseUrl.static />/newvolo/build/1.00/css/main.css<@baseUrl.time />" rel="stylesheet" />
</head>

<body>
<div class="header-body">
<#include "/include/header1.ftl">
<@layout.nav active="buy-now"/>
</div>
<div class="position">
</div>
 <form name="netpayForm" action="https://netpay.cmbchina.com/netpayment/basehttp.dll?prepayc2" method="post" target="_blank" id="netpayForm">
          <input type=hidden name="branchid" id="branchid" value="0021">
          <input type=hidden name="cono" id="cono" value="003967">
          <input type="hidden" name="date" id="date" value="${(billDate)!}">
          <input type="hidden" name="BillNo" id="billno" value="${(billNo)!}">
          <input type="hidden" name="amount" id="amount" value="${(despositAmt?string("0.00"))!"0.00"}">
          <input type=hidden name="ExpireTimeSpan" value="30">
          <input type=hidden name="merchantUrl" value="http://www.autostreets.com/netpay/callback">
          <input type=hidden name="MerchantReturnUrl" value="http://www.autostreets.com/netpay/callback">
          <input type=hidden name="merchantCode" id="merchantCode">
          
          <input type="hidden" name="orgbillNo" id="orgbillNo" value="${(orgbillNo)!}">
      </form>   
<div class="orderbody">
    <div class="paytxtbox">
        <h3>订金支付 <span>订单号：${(orgbillNo)!}</span></h3><span class="paymoney">应付：<strong>${(despositAmt?string("0.00"))!"0.00"}</strong></span>
    </div>
    <div class="paytxtbox">
        <ul class="payboxform">
            <li class="clearfix">
                <label>你的用户名：</label>
                 ${(username)!}
            </li>
            <li class="clearfix">
                <label>应付：</label>
                <span class="paymoney1"><strong>${(despositAmt?string("0.00"))!"0.00"}</strong>元</span>
            </li>
            <li class="btnbox-1"><a class="paybtn-1" onclick="formTit()"></a></li>
        </ul>
    </div>
</div>
<#include "/include/footer.ftl">
<div class="UED_hide" id="tip-phonemsg">
    <div class="tip-paysucess">
        <a href="javascript:;" onclick="$.LAYER.close();" class="tipclose"></a>
        <h4 class="tiph4-1">请在新开网银页面完成付款</h4>
        <p class="payokbox"><a href="javascript:;" class="payok" onclick="paySuccess()"></a>遇到问题请咨询：400-821-8889</p>
    </div>
</div>
<script src="<@baseUrl.static />/common/build/1.00/js/jq.layer.js<@baseUrl.time />"></script>
<script>
    $(function(){
        var isclick = true;

        $("#select-1,#select-2").mouseenter(function(){
  		  isclick = false;
        });
	
        $("#select-1,#select-2").mouseleave(function(){
  		  isclick = true;
        });
        
        $("#select-1").click(function(){
            $("#select-1-box").show();
        })
        $("#select-2").click(function(){
            $("#select-2-box").show();
        });
	
	//按body时隐藏弹出层
    $('html').click(function () {
			if(isclick != false && $("#select-1-box").css('display') != 'none')
			{
           	 $("#select-1-box").hide();
			 isclick = true;
			}
			else if(isclick != false && $("#select-2-box").css('display') != 'none')
			{
           	 $("#select-2-box").hide();
			 isclick = true;
			}
    });
    
       $("#select-1-box li a").click(function(){
           $("#select-1").html($(this).html());
       });
     //  jQuery.LAYER.show({id:'tip-phonemsg'});
    });
    
	$("#netpayForm").submit(function() {
	    var result = false;
	    $.ajax({
	  	  async: false,
	        url: "<@baseUrl.home />/netpay/merchantCode",
	   	  	type: "post",
	        data:{
		      	branchid:   $("#branchid").val(),
		      	cono:       $("#cono").val(),
		      	date:       $("#date").val(),
		      	billno:     $("#billno").val(),
		      	amount:     $("#amount").val(),
		      	payType:    "${(orderType)!}",
		      	refId:      "${(orgbillNo)!}"
	        }
	    }).done(function(data) {
	      if (data.success) {
	      	$("#merchantCode").val(data.sign);
			jQuery.LAYER.show({id:'tip-phonemsg'});
	
			result = true;
	      }
	    });
	    return result;
	});
	
	function formTit(){
		$("#netpayForm").submit();
	}
	 
    function paySuccess(){
	     $.LAYER.close();
	     window.location.href = "<@baseUrl.home />/no-haggle/payResult?orgbillNo=${(orgbillNo)!}&billNo=${(billNo)!}";
	}

</script>
</body>
</html>
</#escape>
