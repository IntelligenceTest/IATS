<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="auctionEidtPriceOnline" class="UED_hide">       
    <div class="pop_box">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">在线拍保留价编辑</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	            <input type="hidden" id="sid"/>
                <ul class="s_form">
                    <li>
                        <label>车辆：</label>
                        <span id="vehicleTitle"></span>
                    </li>
                    <li>
                        <label>当前最高出价：</label>
                        <span id="maxPrice"></span>&nbsp;&nbsp;万元
                    </li>
                    <li>
                        <label style="font-size: 20px;color: red;">保留价：</label>
                        <input id="newPrice" maxlength="11" class="from-input-1" style="width:100px;color:red;font-size:22px;height: 22px;" />
                        &nbsp;&nbsp;<span style="font-size: 20px;color: red;">万元</span>
                    </li>
                </ul>
                <p align="center" class="controlbox">
                    <input type="button" class="button_lv4_1" value="保存" id="onlinePriceSubmit"/>
                    <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
                </p>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function(){
	//表单提交检查
     $("#onlinePriceSubmit").click(function(){  
         var reservePrice = $("#newPrice").val();
         var sid = $("#sid").val();
         if(reservePrice==""){  
             alert("请填写保留价~");  
             $("#newPrice").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         if(!checkCashResult(reservePrice)){return;};
         
         if(!confirm("是否确认设置保留价为("+reservePrice+")万元？"))
             return;
         
         $.ajax({
             type:"post",
             dataType:"json",
             url:"${ctx}/auctionvehicle/edit-price",
             data:{id:sid,newPrice:reservePrice},
             success:function(data){
                 if(data){
                	 $.LAYER.close();
                	 //$("#status").val("1");
                     window.alert("保留价成功设置为("+reservePrice+")万元！");
                     $("#auctionVehicleForm").submit();
                 }else {
                     window.alert("系统异常请联系管理员！");
                     return;
                 }
             }
         });
         
         
     });  
}); 
 //金额校验
var checkCash=function(cash){
    return (/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test(cash.toString());
};

var checkCashResult=function(a){
    if(!checkCash(a)){
        window.alert("金额无效~");
        return false;
    }else  {
        var cash = parseFloat(a);
        if(cash<(0.01)||cash>(10000001.00)) {
             window.alert("金额只能大于0及小于10000001.00");
             return false;
        }
        return true;
    }
};
</script>