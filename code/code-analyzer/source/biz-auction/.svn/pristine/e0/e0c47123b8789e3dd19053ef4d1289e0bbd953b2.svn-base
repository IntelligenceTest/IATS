<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="auctionSyncDiv" class="UED_hide">       
    <div class="pop_box">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">同步拍</h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box">
	        <form:form id="auctionVehicleSyncForm" action="${ctx}/auctionvehicle/syncUpdate" 
	           method="post" commandName="auctionVehicle">
	            <form:hidden path="allSids"/>
	            <form:hidden path="auctionType" value="0"/>
				<form:hidden path="createdBy" value="${user.id }" />
                <ul class="s_form">
                    <li>
                        <label>请选择已有的拍卖会：</label>
                         <form:select path="auctionId"  cssClass="input-10" cssStyle="width:200px;" >  
                              <form:option value=""  label="未选择"  ></form:option>
                              <%-- <spring:eval expression="@auctionService.selectAutions(null)" var="autions" />
                               <form:options items="${autions}" itemLabel="title"  itemValue="id" /> --%>
                          </form:select>
                    </li>
                    <li id="createAuction"><label>或<a href="javascript:void(0);" onclick="toAddAuction();">新建拍卖会</a></label></li> 
                </ul>
            </form:form>
            <p align="center" class="controlbox">
               <input type="button" class="button_lv4_1" value="确定" id="syncSubmit"/>
               <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
            </p>
        </div>
    </div>
</div>
<script type="text/javascript">
 $(function(){
     $.ajax({
         url:"${ctx}/auctionvehicle/getAuctionList",
         success:function(data){
             if(data&&data.length>0){
	             var html=[];
	             html.push("<option value=''>未选择</option>");
	             $.each(data,function(i,n){
	                 html.push("<option value="+n.id+">"+n.title+"</option>")
	             })
	             $("#auctionId").html(html.join(""));
             }
         }
     })
	//表单提交检查
     $("#syncSubmit").click(function(check){  
         var val = $("#auctionId").find("option:selected").val();
         if(val==""){  
             alert("请选择拍卖会~");  
             $("#auctionId").focus();  
             check.preventDefault();//阻止表单提交
             return;
         }
         
         var url = "${ctx}/auctionvehicle/syncUpdate";
         $.ajax({
             cache: true,
             type: "POST",
             url:url,
             data:$('#auctionVehicleSyncForm').serialize(),
             async: false,
             error: function(request) {
                 window.alert("系统异常，请联系管理员！");
             },
             success: function(data) {
                 $.LAYER.close();
                 window.alert(data);
                 window.location.href="${ctx}/auctionvehicle/index";
             }
         });
     });  
}); 
	//跳转到新增画面
	var toAddAuction = function() {
		window.open("${ctx}/auction/op");
	};
</script>