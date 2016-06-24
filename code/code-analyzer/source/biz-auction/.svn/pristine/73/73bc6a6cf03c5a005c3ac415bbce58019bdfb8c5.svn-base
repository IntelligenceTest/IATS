<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<div id="selectVehicleDiv" class="UED_hide">       
    <div class="pop_box" style="width:1050px;" >
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">
             <span id="_titleSpan">选择车辆</span>
          </h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>   
        <div class="s_box">
        		<div class="s_box_content">
        		
        		</div>
			  <p align="center" class="controlbox">
	              <input type="button" class="button_lv4_1" value="确定" id="saveVehicleBtn"/>
	              <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
              </p>
        </div>
    </div>
</div>
<script>
	$.get("${ctx}/homepageRecommend/vehicle-select",function(dom){
		$("#selectVehicleDiv .s_box_content ").html(dom);
	});
	//保存
	$("#saveVehicleBtn").click(function(){
	    //var sids=common.getSelectIds("datatable");
		var fixedPrices =$("#datatable").find("input:checkbox[checked]:not(#selectAll)");
		var isAdd=$("#isAdd").val();
		if(isAdd==1&&fixedPrices.length>0){
			var sids='';
			$.each(fixedPrices,function(index,item){
				sids+=$(this).val()+',';
			});
			$.post(
				"${ctx}/homepageRecommend/save",
				{sids:sids},
				function(res){
					if(res){
						alert(res.msg);
						window.location.reload();
					}else{
						alert("保存失败，稍后再试");
				}
			});
		}else if(isAdd!=1&&fixedPrices.length==1){
			var fpRecommendId=$("#fpRecommendId").val();
			var fixedPriceId=fixedPrices.val();
			$.post("${ctx}/homepageRecommend/replace",{homepageRecommendId:fpRecommendId,fixedPriceId:fixedPriceId},
				function(res){
					if(res){
						alert(res.msg);
						window.location.reload();
					}else{
						alert("保存失败，稍后再试");
				}
			});
		}else if(isAdd!=1){
			alert("请先选择且只选择一行用于替换的记录");
		}else {
			alert("请选择一行以上记录");
		}
	});
</script>
