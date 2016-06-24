/**
 * 拍卖场地
 * 
 * @author weiyi.wang
 */
var bid = {};
var bidName=null;
var bidPrice=null;
(function (app) {
    "use strict";
    /*jslint devel: true,debug: true,browser: true, nomen: true*/
    /*global angular: true,karam:true,$:true,ctx:true,common:true,highchartsFactory:true*/
    app.refresh = function () {
        var queryString = $("#bidForm").serialize();
        location.href = kkpager.hrefFormer + "?current=" + kkpager.pno +"&length=" + kkpager.pageSize + "&" + queryString;
    };
    app.syncDeal=function(){
        var arrChks = $("input[name='subcheck']:checked");
        var size = arrChks.length;
        if (size > 1) {
            window.alert("只能选择一条记录，不能多选几条记录");
            return false;
        }else if (size == 0) {
            window.alert("最少选择一条记录");
            return false;
        }
        var sidValue = arrChks[0].value;
        var arr = new Array();
        arr = sidValue.split(",");
        var av_Id = arr[0];//拍品ID
        var auction_type = arr[4];//竞拍类型
        var auction_status = arr[5];//竞拍状态
        if(auction_type=="0"&&(auction_status=="4"||auction_status=="7")){
            $.ajax({
                type : "post",
                dataType : "json",
                url : ctx+"/bid/queryMaxPrice",
                data : {
                    avId : av_Id
                },
                success : function(data) {
                    $.ajax({
                        url:ctx+"/bid/getAuctionVehicle",
                        data:{
                            auctionVehicleId:av_Id
                        },
                        success:function(result){
                            if (data) {
                                $("#offlineDeal #memberCellPhone").val(data.cellphone);
                                $("#offlineDeal #memberName").val(data.bidder_name);
                                $("#offlineDeal #maxBidPrice").html((data.price?data.price:0)+"元");
                            } else {
                                $("#offlineDeal #memberCellPhone").val("");
                                $("#offlineDeal #memberName").val("");
                                $("#offlineDeal #maxBidPrice").html("0元");
                            }
                            var auctionVehicle=result.data;
                            $("#offlineDeal #dealVehiclePrice").val("");
                            if(auctionVehicle.buyerCommissionRate){
                                if(auctionVehicle.buyerCommissionRate==0){
                                    $("#offlineDeal #buyerCommissionFeeLabel").html("佣金：0元");
                                    $("#offlineDeal #commionRate").val("");
                                }else{
                                    $("#offlineDeal #buyerCommissionFeeLabel").html("佣金率："+auctionVehicle.buyerCommissionRate+"%");
                                    $("#offlineDeal #commionRate").val(auctionVehicle.buyerCommissionRate);
                                }
                                $("#offlineDeal #buyerCommissionFee").val("");
                            }else if(auctionVehicle.buyerFixedCommission){
                                $("#offlineDeal #buyerCommissionFeeLabel").html("佣金："+parseFloat(auctionVehicle.buyerFixedCommission).toFixed(0)+"元");
                                $("#offlineDeal #buyerCommissionFee").val(auctionVehicle.buyerFixedCommission.toFixed(2));
                                $("#offlineDeal #commionRate").val("");
                            }else{
                                $("#offlineDeal #buyerCommissionFeeLabel").html("");
                                $("#offlineDeal #buyerCommissionFee").val("");
                                $("#offlineDeal #commionRate").val("");
                            }
                            $("#offlineDeal #exWarehouseFee").val(auctionVehicle.exWarehouseFee?auctionVehicle.exWarehouseFee.toFixed(2):"0.00");
                            if(auctionVehicle.licenseFee){
                                $("#offlineDeal #licenseFee").val(auctionVehicle.licenseFee?auctionVehicle.licenseFee.toFixed(2):"0.00");
                                $("#offlineDeal #licenseFeeLi").show();
                            }else{
                                $("#offlineDeal [name=licenseFeeType]").get(1).checked="checked";
                                $("#offlineDeal #licenseFee").val("0.00");
                                $("#offlineDeal #licenseFeeLi").hide();
                            }
                            $.LAYER.show({id:"offlineDeal"});
                        }
                    })
                }
            });
        }else{
            alert("只有同步拍的流拍车辆和取消订单的车辆才可以成交!");
        }
    };
    app.syncOfflineDealSubmit=function(){
        var arrChks=$("input[name='subcheck']:checked");
        var size = arrChks.length;
        if (size > 1) {
            window.alert("只能选择一条记录，不能多选几条记录");
            return false;
        }else if (size == 0) {
            window.alert("最少选择一条记录");
            return false;
        }
        var sidValue = arrChks[0].value;
        var arr = new Array();
        arr =   sidValue.split(","); 
        var av_Id        =  arr[0];//拍品ID
        var vehicle_Id   =  arr[1];//车辆ID
        var auctionId   =  arr[2];//拍卖会ID
        var bidder_sid    =  arr[3];//竞价人ID
        var auction_type  =  arr[4];//竞拍类型
        var auction_status = arr[5];//竞拍状态
        if(!(auction_type=="0"&&(auction_status=="4"||auction_status=="7"))){
            window.alert("只有同步拍的流拍车辆和取消订单的车辆才可以成交!");
            return false;
        } 
        var mobile=$.trim($("#offlineDeal #memberCellPhone").val());
        if(mobile.length==0){
            alert("手机号必填!");
            return;
        }
        var re = /^[1][3578]\d{9}$/;
        if (!mobile.match(re)){
            alert("手机号格式错误!");
            return;
        }
        if(!$.trim($("#offlineDeal #memberName").val())){
            alert("成交人必填!");
            return;
        }
        if(!$.trim($("#offlineDeal #dealVehiclePrice").val())){
            alert("成交车价必填!");
            return;
        }
        var bidPrice=$.trim($("#offlineDeal #dealVehiclePrice").val());
        if (!$.isNumeric(bidPrice)||bidPrice<0) {
            alert("成交车价不合法");
            return false;
        }
        var buyerCommissionFee=$.trim($("#offlineDeal #buyerCommissionFee").val());
        if (!$.isNumeric(buyerCommissionFee)||buyerCommissionFee<0) {
            alert("佣金价格不合法");
            return false;
        }
        var licenseFee=$.trim($("#offlineDeal #licenseFee").val());
        if (!$.isNumeric(licenseFee)||licenseFee<0) {
            alert("办证费不合法");
            return false;
        }
        var exWarehouseFee=$.trim($("#offlineDeal #exWarehouseFee").val());
        if (!$.isNumeric(exWarehouseFee)||exWarehouseFee<0) {
            alert("出库费不合法");
            return false;
        }
        if (confirm("确定要成交吗？")) {
            $("#offlineDeal #offlineDealFormBtn").attr("disabled", "disabled").css("cssText","background-color:#aaaaaa!important");
            $.ajax({
               url:ctx+"/bid/syncOfflineDeal",
               type:"post",
               data:{
                   avId:av_Id,
                   name:$.trim($("#offlineDeal #memberName").val()),
                   cellphone:$.trim($("#offlineDeal #memberCellPhone").val()),
                   price:bidPrice,
                   buyerCommissionFee:buyerCommissionFee,
                   licenseFee:licenseFee,
                   exWarehouseFee:exWarehouseFee,
                   licenseFeeType:$("#offlineDeal [name=licenseFeeType]:checked").val()
               },
               success:function(data){
                   if(data&&data.success){
                       alert("成交成功!");
                       location.reload();
                       $("#offlineDeal #offlineDealFormBtn").attr("disabled", "disabled").css("cssText","");
                   }else{
                       alert(data.msg);
                       $("#offlineDeal #offlineDealFormBtn").removeAttr("disabled").css("cssText","");
                   }
               }
            });
        }
    }
    app.loadOfflinePayMember=function (){
        var mobile=$.trim($("#offlineDeal #memberCellPhone").val());
        if(mobile.length==0){alert("请填写手机号!");return;}
        var re = /^[1][3578]\d{9}$/;
        if (!mobile.match(re)){
            alert("手机号格式错误!");
            return;
        }
        $.ajax({
           url:ctx+"/order/loadOfflinePayMember",
           data:{cellPhone:$("#offlineDeal #memberCellPhone").val()},
           success:function(data){
               if(data&&data.success){
                   var d=data.data;
                   if(d){
                       $("#offlineDeal #memberName").val(d.name);
                       if(d.memberLevel=="VIP1"&&d.memberCategory=="商户"){
                           $("#offlineDeal #memberType").html("认证商户");
                       }else{
                           $("#offlineDeal #memberType").html("普通会员");
                       }
                   }else{
                       $("#offlineDeal #memberName").val("");
                       $("#offlineDeal #memberType").html("非会员");
                   }
               }else{
                   alert(data.msg);
               }
           }
        });
    };
    app.failAuction=function(){
        var arrChks = $("input[name='subcheck']:checked");
        var size = arrChks.length;
        var allSids = "";
        var status = true;
        var onceStatus = false;
        var counts = true;
        if (size > 0) {
            arrChks.each(function() {
                allSids += $(this).val() + "#";
                var auction_status = $(this).attr("auction_status");
                if (auction_status != "3") {
                    status = false;
                }
              //拍卖类型
				var auction_type = $(this).attr("auction_type");
				if(auction_type==2){
					alert("您所选车辆中包含即时拍车辆，已取消操作，即时拍车辆流拍请到【拍卖>>暗拍预约】处理。");
					onceStatus = true;
					return false;
				}
            });
            if(onceStatus){
            	return;
            }
            if (allSids != "") {
                if (status) {
                    if (confirm("你确认需要进行流拍操作吗")) { //add by denghongwei
                        $.ajax({
                            type : "post",
                            dataType : "json",
                            url : ctx+"/bid/failAuction",
                            data : {
                                auctionSids : allSids
                            },
                            success : function(data) {
                                if (data) {
                                    window.alert("流拍成功!");
                                    $("#bidForm").submit();
                                    return;
                                } else {
                                    window.alert("流拍失败，系统异常请联系管理员！");
                                    return;
                                }
                            }
                        });
                    } else {
                        window.alert("本次流拍操作取消");
                    }
                } else {
                    window.alert("注意!  非成交确认状态的车辆不能进行流拍操作 ");
                    return;
                }
            }
        } else if (size == 0) {
            window.alert("请选择需要流拍的车辆~~~~");
            return;
        }
    };
    app.transactionAuction=function(){
        var arrChks = $("input[name='subcheck']:checked");
        var size = arrChks.length;
        if (size > 1) {
            window.alert("只能选择一条记录，不能多选几条记录");
            return false;
        }else if (size == 0) {
	    	window.alert("最少选择一条记录");
	        return false;
	    }
        var sidValue = arrChks[0].value;
        var arr = new Array();
        arr = sidValue.split(",");
        var av_Id = arr[0];//拍品ID
        var vehicle_Id = arr[1];//车辆ID
        var auctionId = arr[2];//拍卖会ID
        var bidder_sid = arr[3];//竞价人ID
        var auction_type = arr[4];//竞拍类型
        var auction_status = arr[5];//竞拍状态
        
        //即时拍
		if(auction_type==2){
			alert("即时拍车辆成交请到【拍卖>>暗拍预约】处理。");
			return false;
		}
		if(auction_type!="1"){
            alert("只有在线拍车辆才可以成交");
            return false;
        }
        
        if (auction_status != 3) {
            window.alert("注意!非成交确认的车辆不能成交");
            return false;
        }
        $.ajax({
            type : "post",
            dataType : "json",
            url : ctx+"/bid/queryMaxPrice",
            data : {
                avId : av_Id
            },
            success : function(data) {
                if (data) {
                    bidPrice = data.price;
                    bidName = data.bidder_name;
                    $("#bidname").val(bidName);
                    $("#transc_price").val(bidPrice);
                    loadFeatureItems();
                } else {
                    window.alert("本次车辆成交失败");
                }
            }
        });
    };
    app.choiceFeatureItems=function(flag){
        var arrChks=$("input[name='subcheck']:checked");
        var size = arrChks.length;
        if (size > 1) {
            window.alert("只能选择一条记录，不能多选几条记录");
            return false;
        }else if (size == 0) {
	    	window.alert("最少选择一条记录");
	        return false;
	    }
        var sidValue = arrChks[0].value;
        var arr = new Array();
        arr =   sidValue.split(","); 
        var av_Id        =  arr[0];//拍品ID
        var vehicle_Id   =  arr[1];//车辆ID
        var auctionId   =  arr[2];//拍卖会ID
        var bidder_sid    =  arr[3];//竞价人ID
        var auction_type  =  arr[4];//竞拍类型
        var auction_status = arr[5];//竞拍状态
        if(auction_status !=3){
            window.alert("注意!非成交确认的车辆不能成交");
            return false;
        }
        if (!$.isNumeric(bidPrice)&&bidPrice<0) {
            alert("价格不合法");
            return false;
        }
        if(!$.trim($("#featureItemDiv #memberName").val())){
            alert("成交人必填!");
            return;
        }
        if(!$.trim($("#featureItemDiv #dealVehiclePrice").val())){
            alert("成交车价必填!");
            return;
        }
        var bidPrice=$.trim($("#featureItemDiv #dealVehiclePrice").val());
        if (!$.isNumeric(bidPrice)||bidPrice<0) {
            alert("成交车价不合法");
            return false;
        }
        var buyerCommissionFee=$.trim($("#featureItemDiv #buyerCommissionFee").val());
        if (!$.isNumeric(buyerCommissionFee)||buyerCommissionFee<0) {
            alert("佣金价格不合法");
            return false;
        }
        var licenseFee=$.trim($("#featureItemDiv #licenseFee").val());
        if (!$.isNumeric(licenseFee)||licenseFee<0) {
            alert("办证费不合法");
            return false;
        }
        var exWarehouseFee=$.trim($("#featureItemDiv #exWarehouseFee").val());
        if (!$.isNumeric(exWarehouseFee)||exWarehouseFee<0) {
            alert("出库费不合法");
            return false;
        }
        $.ajax({
            url : ctx+"/bid/dealVehicleValiBidName",
            type : "get",
            data : {
                bidName : $.trim($("#featureItemDiv #memberName").val()),
                avId : av_Id
            },
            success : function(data){
                if (data.success) {
                    if (confirm("确定要成交吗？")) {
                        window.location.href = ctx+"/bid/update?name="+$.trim($("#featureItemDiv #memberName").val())+"&price="+bidPrice+"&avId="+av_Id
                        +"&bidderSid="+data.data+"&buyerCommissionFee="+buyerCommissionFee+"&licenseFee="+licenseFee
                        +"&exWarehouseFee="+exWarehouseFee+"&flag="+flag+"&licenseFeeType="+$("#featureItemDiv [name=licenseFeeType]:checked").val();
                    }
                } else {
                    alert(data.msg);
                }
            }
        });  
    };
    //更改拍卖类型后显示拍品拍品类型选项
    app.auctionTypesChange=function(obj){
        var val=$("#type").val();
        if (val=="1") {
            $("#avType").attr("disabled",false);
            $("#li_av_type").show();
        }else{
            $("#avType").attr("disabled",true);
            $("#li_av_type").hide();
        }
    };
}(bid));
