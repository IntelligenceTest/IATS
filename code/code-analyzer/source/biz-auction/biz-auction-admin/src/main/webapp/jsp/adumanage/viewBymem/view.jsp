<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<div id="vehicleByMemberDiv" class="UED_hide">       
    <div class="pop_box" style="width:1050px;" max-height: 400px;"  >
        <div class="pop_tittle">
          <h3 id="UED_layer_h3_v31">
             <span id="_titleSpan">查看成交车辆</span>
          </h3>
          <a href="javascript:void(0);" onclick="$.LAYER.close();" class="close"></a>
        </div> 
        <input type="hidden" id="memId" val="">
	    <input type="hidden" id="auctionId" />
        <div class="s_box" style="max-height: 400px; overflow: scroll;">
        <ul class="s_form">
          <li style="margin-bottom: 0px;height: auto;">
			<label style="cursor: default;">拍卖会名：<span id="aucName"></span></label>
		</li>
		</ul>
		 <ul class="s_form">
			<li style="margin-bottom: 0px;height: auto;">
				<label style="cursor: default;">参拍人：<span id="perName"></span></label>
			</li>
			<li style="margin-bottom: 0px;height: auto;">
				<label style="cursor: default;">身份证号：<span id="idNum"></span></label>
			</li>
			<li style="margin-bottom: 0px;height: auto;">
				<label style="cursor: default;">手机号：<span id="teleNum"></span></label>
			</li>
		    <li style="margin-bottom: 0px;height: auto;">
				<label style="cursor: default;">成交车辆数：<span id="veDealNum"></span></label>
			</li>
		</ul>
  		<div class="rbody vehicle-list" id="auctionPersonDiv">
  		
  		</div>
	</div>  
    </div>
</div>
<script>
	
</script>