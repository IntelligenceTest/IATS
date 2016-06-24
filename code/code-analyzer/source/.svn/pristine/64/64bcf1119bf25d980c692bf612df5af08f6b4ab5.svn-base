<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<div id="auctionPriceDiv" class="UED_hide">       
    <div class="pop_box" style="width: 350px;">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">价格批量设置</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	        <form id="auctionPriceForm" action="${ctx}/auctionvehicle/volumeSetPrice" method="post" commandName="auctionVehicle" modelAttribute="auctionVehicle">
	            <input type="hidden" value="" id="auctionId" name="auctionId"/>
                <ul class="s_form">
                    <li class="lay-price-input">
                        <label for="startPrice">&nbsp;&nbsp;&nbsp;起拍价：</label>
                            <input type="text" id="startPrice" name="startPrice" />元
                    </li>
                    <li class="lay-price-input">
                        <label for="plusRange">加价幅度：</label>
                            <input type="text" id="plusRange" name="plusRange" />元
                    </li>
                </ul>
               
            </form>
             <p align="center" class="controlbox">
                  <input type="button" class="button_lv4_1" value="确定" id="volumeSetSubmit"/>
                  <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
             </p>
        </div>
    </div>
</div>
<script type="text/javascript">
  $(function(){
	//表单提交检查
     $("#volumeSetSubmit").click(function(check){  
         var startPrice = $("#startPrice").val();
         var plusRange = $("#plusRange").val();
         if("" == startPrice || null == startPrice){
        	 alert("起拍价不能为空");
        	 $("#startPrice").focus();  
        	 check.preventDefault();//阻止表单提交
        	 return;
         }
         if("" == plusRange || null == plusRange){
        	 alert("加价幅度不能为空");
        	 $("#startPrice").focus();  
        	 check.preventDefault();//阻止表单提交
        	 return;
         }
         if(isNaN(startPrice)){ 
             alert("请填写正确价格~");  
             $("#startPrice").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         if(isNaN(plusRange)){ 
             alert("请填写正确数字~");
             $("#plusRange").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         $("#auctionPriceForm").submit();
     });  
});  
</script>