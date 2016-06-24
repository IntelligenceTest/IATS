<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <div id="onAuditFailureDiv" class="UED_hide">       
    <div class="pop_box" style="width: 380px;">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">展品上架失败</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	        <form id="onAuditFailure">
	            <input type="hidden"  id="fpSid"/>
              <ul class="s_form">
                   <li>
                     <label><b>请说明该车辆上架失败原因：</b></label>
                   </li>
                </ul>
                <ul class="s_form_1">
                    <li class="nowidth">
                         <textarea rows="3" cols="20" id="memo1" class="from-input-1 " rows="3" style="height:80px;width:90%;"></textarea>
                    </li>
                 </ul>
                <p align="center" class="controlbox">
                    <input type="button" class="button_lv4_1" value="保存" id="onAuditFailureSave"/>
                    <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
                </p>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
<!--

//-->
$("#onAuditFailureSave").click(function(){
	var memo=$("#memo1").val();
	var sid=$("#fpSid").val();
	if(memo==""){
		alert("请输入下架原因"+memo);
		return;
	}
	if(memo.length>50){
		alert("描述不能超过50个字");
		return;
	}
	if(sid!=""){
		$.ajax({
			url:"${ctx}/fixedPrice/onAuditFailure",
			async:false,
			cache:false,
			data:{id:sid,memo:memo},
			dataType:"json",
			success:function(data){
				if(data){
					alert(data.msg);
					window.location.reload();
				}else{
					alert("系统故障请稍后再试");
				}
			},
			error: function(request) {
	             window.alert("系统异常，请联系管理员！");
	         }
		});
	};
});

</script>
