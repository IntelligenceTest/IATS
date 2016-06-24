<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="auctionEditStartPriceOnline" class="UED_hide">       
    <div class="pop_box">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">在线拍起拍价编辑</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	            <input type="hidden" id="startPriceSid"/>
                <ul class="s_form">
                    <li>
                        <label>车辆：</label>
                        <span id="startPriceVehicleTitle"></span>
                    </li>
                    <li>
                        <label>车牌号：</label>
                        <span id="editStartPriceLicenseCode"></span>
                    </li>
                    <li>
                        <label style="font-size: 20px;color: red;">起拍价：</label>
                        <input id="newStartPrice" maxlength="11" class="from-input-1" style="width:100px;color:red;font-size:22px;height: 22px;" />
                        &nbsp;&nbsp;<span style="font-size: 20px;color: red;">万元</span>
                    </li>
                </ul>
                <p align="center" class="controlbox">
                    <input type="button" class="button_lv4_1" value="保存" id="onlineStartPriceSubmit"/>
                    <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
                </p>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function(){
	//表单提交检查
     $("#onlineStartPriceSubmit").click(function(){  
         var startPrice = $("#newStartPrice").val();
         var sid = $("#startPriceSid").val();
         if(startPrice==""){  
             alert("请填写起拍价~");  
             $("#newStartPrice").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         if(!checkCashResult(startPrice)){return;};
         
         if(!confirm("是否确认设置起拍价为("+startPrice+")万元？"))
             return;
         
         $.ajax({
             type:"post",
             dataType:"json",
             url:"${ctx}/auctionvehicle/edit-start-price",
             data:{id:sid,newPrice:startPrice},
             success:function(data){
                 if(data){
                	 $.LAYER.close();
                     window.alert("起拍价成功设置为("+startPrice+")万元！");
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