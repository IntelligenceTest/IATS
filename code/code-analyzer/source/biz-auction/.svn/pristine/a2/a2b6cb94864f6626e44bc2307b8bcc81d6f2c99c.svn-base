<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="auctionSeeCarDiv" class="UED_hide">       
    <div class="pop_box">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">看车批量设置</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	        <form:form id="auctionVehicleSeeCarForm" action="${ctx}/auctionvehicle/allUpdate" method="post" commandName="auctionVehicle" modelAttribute="auctionVehicle">
	            <form:hidden path="seeCarAllSids"/>
                <ul class="s_form ">
                    <li class="lay-price-input">
                        <label>看车时间：</label>
                        <form:input path="seeCarTime" cssClass="from-input-1" />
                    </li>
                    <li class="lay-price-input">
                        <label>看车地点：</label>
                        <form:input path="seeCarAddr" cssClass="from-input-1" style="width:255px;"/>
                    </li>
                </ul>
            </form:form>
            <p align="center" class="controlbox">
               <input type="button" class="button_lv4_1" value="确定" id="seeCarSubmit"/>
               <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
            </p>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function(){
	//表单提交检查
     $("#seeCarSubmit").click(function(check){  
         var seeCarTime = $("#seeCarTime").val();
         var seeCarAddr = $("#seeCarAddr").val();
         if(seeCarTime==""){ 
             alert("请填写看车时间~");  
             $("#seeCarTime").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         if(seeCarAddr==""){ 
             alert("请填写看车地点~");
             $("#seeCarAddr").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         $("#auctionVehicleSeeCarForm").submit();
     });  
}); 
</script>