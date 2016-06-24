<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="onSellConfirmDIV" class="UED_hide">       
    <div class="pop_box" style="width: 295px;">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">展品上架确认</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	      <%--   <form:form id="onSellConfirmForm" action="${ctx}/fixedPrice/onsell-confirm?currentMenuSid=${currentMenuSid}&currentSubMenuSid=${currentSubMenuSid }" 
	           method="post" commandName="fixedPrice"> --%>
	            <%-- <form:hidden path="vehicleSid" id="vehicleSid"/>  --%>
	             <input type="hidden" name="allIds" id="confirmIds"/>
                <ul class="s_form">
                    <li>
                        <font color="red"><b>进行此操作前表示您已确认以下信息准确无误，所选展品将进行上架销售。</b></font>
                    </li>
                 </ul>
                 <ul class="s_form">
                    <li>
                        <label>【展售价格】<font color="green" style="font-size: 20px;">✔</font><label>
                    </li>
                    <li>
                        <label>【新车指导价】<font color="green" style="font-size: 20px;">✔</font><label>
                    </li>
                     <li>
                        <label>【展售区域】<font color="green" style="font-size: 20px;">✔</font><label>
                    </li>
                    <li>
                        <label>【购置税价格】<font color="green" style="font-size: 20px;">✔</font><label>
                    </li>
                 </ul>
                <p align="center" class="controlbox">
                    <input type="button" class="button_lv4_1" value="确定" id="confirmSubmit"/>
                    <input type="button" class="button_lv4_1" value="取消" onclick="$.LAYER.close();" />
                </p>
           <%-- </form:form>  --%>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function(){
	//表单提交检查
     $("#confirmSubmit").click(function(check){  
         var allId = $("#confirmIds").val();
         
         if(allId==""){
        	 window.alert("非法操作！");
        	 return;
         }
         
         var url = "${ctx}/fixedPrice/onsell-confirm";
         $.ajax({
             cache: true,
             type: "get",
             url:url,
             data:{"allId":allId},
             async: false,
             error: function(request) {
                 window.alert("系统异常，请联系管理员！");
             },
             success: function(data) {
                 $.LAYER.close();
                 window.alert(data.msg);
                 window.location.href="${ctx}/fixedPrice/index";
             }
         });
     });  
}); 

</script>