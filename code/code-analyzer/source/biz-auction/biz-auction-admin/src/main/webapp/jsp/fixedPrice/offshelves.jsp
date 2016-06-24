<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="offshelvesDiv" class="UED_hide">       
    <div class="pop_box" style="width: 380px;">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">展品下架</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	        <form:form id="offshelvesForm" method="post" commandName="fixedPrice">
	            <form:hidden path="allIds" id="cancelAllSids"/>
              <ul class="s_form">
                   <li>
                     <label><b>请说明所选车辆（共<font color="red" style="font-size: 25px;"><span id="offsheleve_remark"></span></font>辆）下架原因：</b></label>
                   </li>
                </ul>
                <ul class="s_form_1">
                    <li class="nowidth">
                        <form:textarea path="offShelvesRemark" cssClass="from-input-1"  rows="3" cssStyle="height:80px;width:90%;"/>
                    </li>
                 </ul>
                <p align="center" class="controlbox">
                    <input type="button" class="button_lv4_1" value="保存" id="offshelvesSubmit"/>
                    <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
                </p>
            </form:form>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function(){
	//表单提交检查
     $("#offshelvesSubmit").click(function(check){  
         var sids = $("#cancelAllSids").val();
         if(sids==""){
        	 window.alert("非法操作！");
        	 return;
         }
         
         var offShelvesRemark = $("#offShelvesRemark").val();
         if(offShelvesRemark==""){
        	 window.alert("请填下架原因！");
        	 $("#offShelvesRemark").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }else if(offShelvesRemark.length>30){
        	 window.alert("下架原因不能超过30个字数！");
             $("#offShelvesRemark").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         
         if(!confirm("是否确认下架？"))
             return;
         
         var url = "${ctx}/fixedPrice/cancel";
         $.ajax({
        	 cache: true,
        	 async: false,
             type:"get",
             dataType:"json",
             url:url,
             data:{allSids:sids,offShelvesRemark:offShelvesRemark},
             error: function(request) {
                 window.alert("系统异常，请联系管理员！");
             },
             success:function(data){
                 if(data.success){
                	 $.LAYER.close();
                     window.alert(data.msg);
                     $("#fixedPriceForm").submit();
                 }else {
                	 window.alert(data.msg);
                 }
             }
         }); 
         
     });  
}); 
</script>