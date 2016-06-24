<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript" src="${ctx}/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.validate.method.min.js"></script>
<style>
.price-input-text {
	width:90px;
}
input, select {
	margin-right:.3em;
}
.star {
 color: #f00 !important;
}
/**fixbug 必填信息显示样式问题*/
label.error {
    color: #EF3737!important;
    font-style: italic;
    float: right;
    margin-left: 5px;
}
</style>
<div id="onSellOrEdit" class="UED_hide">       
    <div class="pop_box">
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">展品<span id="_titleSpan"></span></h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div>
        <div class="s_box" style="height: 500">
	        <form id="onSellForm" data-validate="true" method="post" >
                <input type="hidden" id="allSids" name="allIds">
                <input type="hidden" id="sid" name="id">
                <input type="hidden" id="flag" name="flag">
                <ul class="s_form">
                    <li class="lay-price-input">
                        <label>展售价格：</label>
                        <input type="text" name="price" id="price" class="price-input-text number required">万元
                    </li>
                    <li class="lay-price-input">
                    	<input type="checkbox" name="hidden" id="hidden">隐藏
                    </li>
                    <li class="lay-price-input">
                        <label>集团限价：</label>
                        <input type="text" name="lowPriceGroup" id="lowPriceGroup" class="price-input-text number required">万元
                    </li>
                  </ul>
                  <ul class="s_form"> 
                    <li class="lay-price-input">
                        <label>新车售价：</label>
                        <input type="text" name="vehicle.newVehicleSuggestionPrice" id="priceNewcar" class="price-input-text number required">万元
                    </li>
                    <li class="lay-price-input">
                    	<input type="checkbox" name="hasTaxBuy" id="hasTaxBuy">是否有购置税
                    </li>
                    <li class="lay-price-input">
                        <label>预付订金：</label>
                       	<input type="text" name="deposit" id="deposit" class="price-input-text number required">元
                    </li>
                    <li class="lay-price-input">
                        <label>展示省份：</label>
                       	<select id="province" style="width: 170px;" name="province" onchange="selectCitys('#city','#province');" class="required">
							<option value='' selected>请选择</option>
                               <spring:eval expression="@autoDictionaryService.selectProvince()" var="provinces"/>
							<c:forEach items="${provinces}" var="province">
								<option value="${province.name}" >${province.name}</option>
							</c:forEach>
						</select>
						
                    </li>
                    <li class="lay-price-input">
                        <label>展示城市：</label>
                    	<select id="city" name="city" class="required" style="width: 170px;">
                            <option value='' selected>请选择</option>
                        </select>
                    </li>
                  </ul>
                  <ul class="s_form"> 
                    <li class="lay-price-input">
                        <label>所在门店：</label>
                        <input type="text" name="whereStore" id="whereStore" class="required">
                    </li>
                    <li class="lay-price-input">
                        <label>联系电话：</label>
                        <input type="text" name="phone" id="phone" maxlength="50" class="required" >
                    </li>
                    <li class="lay-price-input">
                        <label>详细地址：</label>
                        <input type="text" name="addressDetailStore" id="addressDetailStore" maxlength="50" class="required">
                    </li>
                    <li class="lay-price-input">
                        <label>服务时间：</label>
                        <input type="text" name="serviceTime" id="serviceTime" maxlength="20" class="required">
                    </li>
                    <li style="height: 100px;">
                        <label style="float: inherit;">车辆详情：</label>
                        <textarea id="memo" name="memo" cols="45" rows="6" style="resize: none;"></textarea>
                    </li>
                </ul>
				<ul class="s_form">
					<li  class="lay-price-input">
                        <label>对应新车：</label>
                        <select id="newBrand" name="newBrand" >
							<option value='' selected>品牌</option>
							<spring:eval expression="@replacementService.selecAllAutomakers()" var="repBrands" />
							<c:forEach items="${repBrands}" var="repBrand">
								<option value="${repBrand.automaker}" >${repBrand.automaker}</option>
							</c:forEach>
						</select >
						<select id="newSeries" name="newSeries" >
							<option value='' selected>车系</option>
						</select>
                    </li>
                    <li class="lay-price-input">
                        <label>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;款:</label>
                        <select id="newYear" name="newYear">
                            <option value='' selected>年款</option>
                        </select>
                    </li>
                    <li class="lay-price-input">
                    	<label>新车名称：</label>
                        <select id="newSelledName" name="newSelledName">
							<option value='' selected>车型</option>
						</select>
						<img alt="可匹配到车型" id="rightRepModle" style="width: 20px;margin-bottom: -.5em;display: none;" src="${ctx}/resources/images/right.png">
						<input type="hidden" name="newcarParamId" id="newcarParamId">
                    </li>
				</ul>
            </form>
				<p align="center" class="controlbox">
	                <input type="button" class="button_lv4_1" value="保存" id="onSellSubmit"/>
	                <input type="button" class="button_lv4_1" value="关闭" onclick="$.LAYER.close();" />
	            </p>
        </div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	$("#onSellSubmit").click(function(){
		if (!$("#onSellForm").valid()) {
			return false;
		}
		if (!checkCashResult_apply($("#priceNewcar").val())
                || !checkCashResult_apply($("#lowPriceGroup").val())
                || !checkCashResult_apply($("#price").val())){
            return false;
        }
		if ($("#newBrand").val()&&!$("#newcarParamId").val()&&!window.confirm("您选择的新车车型暂无参数和配置是否确认提交？（提交后前台页面将不显示该新车信息）")) {
			return false;
		}
        var url = "${ctx}/fixedPrice/save";
        $.ajax({
            cache: true,
            type: "POST",
            url:url,
            data:$('#onSellForm').serialize(),
            async: false,
            error: function(request) {
                window.alert("系统异常，请联系管理员！");
            },
            success: function(data) {
                if(data.success){
                    $.LAYER.close();
                    window.alert(data.msg);
                    window.location.href="${ctx}/fixedPrice/index";
               }else{
                   window.alert(data.msg);
               }
            }
        });
        return false;
    });
	
	$("#newBrand").on("change", function() {
		selectAllSeries(this.value);
	});
	
	$("#newSeries").on("change", function() {
		selectMdYears($("#newBrand").val(), this.value);
	});
	
	$("#newYear").on("change", function() {
		selectRepModelByMdYear($("#newBrand").val(), $("#newSeries").val(), this.value);
	});
	
	$("#newSelledName").on("change", function() {
		selectDetailParametersByRepModel(this.value.split("@_@")[0]);
	});
}); 

var checkCash=function(cash){
    return (/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test(cash.toString());
};

var checkCashResult_apply=function(a){
    if(!checkCash(a)){
        window.alert("价格无效~");
        return false;
    } else  {
        var cash = parseFloat(a);
        if(cash<(0.00)||cash>(9001.00)) {
             window.alert("价格只能大于等于0及小于9001.00万元");
             return false;
        }
        return true;
    }
};

var selectAllSeries = function(automaker) {
	var newSeries = $("#newSeries").empty().append('<option value="">车系</option>');
	var url = "${ctx}/fixedPrice/selectForAuctionAllSeries";
	$.ajax({
		url : url,
		type : "get",
		data : {automaker : automaker},
		success : function(data) {
			if (data && data.length > 0) {
				var html = "";
				$.each(data, function(index, obj){
					html += '<option value="'+ obj.series +'">'+ obj.series +'</option>';
				});
				newSeries.append(html);
			} 
			newSeries.trigger("change");
		}
	});
};

var selectMdYears = function(automaker, series) {
	var newYear = $("#newYear").empty().append('<option value="">年款</option>');
	var url = "${ctx}/fixedPrice/selectMdYears";
	$.ajax({
		url : url,
		type : "get",
		data : {automaker : automaker, series : series},
		success : function(data) {
			if (data && data.length > 0) {
				var html = "";
				$.each(data, function(index, value){
					html += '<option value="'+ value +'">'+ value +'</option>';
				});
				newYear.append(html);
			}
			newYear.trigger("change");
		}
	});
};

var selectRepModelByMdYear = function(automaker, series, mdYear) {
	var newSelledName = $("#newSelledName").empty().append('<option value="">车型</option>');
	var url = "${ctx}/fixedPrice/selectRepModelByMdYear";
	$.ajax({
		url : url,
		type : "get",
		data : {automaker : automaker, series : series, carYear : mdYear},
		success : function(data) {
			if (data && data.length > 0) {
				var html = "";
				$.each(data, function(index, obj){
					html += '<option value="'+ obj.sid + '@_@'+ obj.model+ '@_@' + obj.selledName +'">'+ obj.selledName +'</option>';
				});
				newSelledName.append(html);
			}
			newSelledName.trigger("change");
		}
	});
};

var selectDetailParametersByRepModel = function(repModelSid) {
	if (!repModelSid) {
		$("#newcarParamId").val("");
		$("#rightRepModle").hide();
		return false;
	}
	var url = "${ctx}/fixedPrice/selectDetailParametersByRepModel";
    $.ajax({
        url : url,
        type : "get",
        data : {repModelSid : repModelSid},
        success : function(data) {
            if (data) {
            	$("#newcarParamId").val(data.id);
            	$("#rightRepModle").show();
            } else {
            	$("#newcarParamId").val("");
            	$("#rightRepModle").hide();
            }
        }
    });
};
var selectCitys = function(cityInput,proInput){
	var proName = $(proInput).val();
	var cityValue = $(cityInput).val();
	if (proName!=""&&null != proName) {
		$.ajax({
			url :"${ctx}/auctionvehicle/getCitys",
			type: "get",
			dataType : "json",
			async:false,
			//contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data : {proId:proName},
			success : function(data) {
				$(cityInput).empty();
				if(data.length>1){
					$(cityInput).append("<option value ='' selected='selected'>请选择</option>");
				}
				$.each(data, function(index, item){
					//item.id
					$(cityInput).append("<option value ='"+ item.city +"'>" +item.city + "</option>");
				});
				if(cityValue!=""){
					$(cityInput+" option[value='"+cityValue+"']").prop("selected", true);
				}
			}
		});
	} else {
		$(cityInput).empty();
		$(cityInput).append("<option value ='' selected='selected'>请选择</option>");
	}
};	
</script>