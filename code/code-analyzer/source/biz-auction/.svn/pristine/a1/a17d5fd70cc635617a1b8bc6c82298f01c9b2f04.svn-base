<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="UED_hide" id="vehiclesByAuctionMemberDiv">
    <div class="model-ly-offset">
        <div class="model-ly-top">
            <h1 class="model-ly-title"></h1><!-- 标题：用来放拍卖会名称（拍卖会名：XXX） -->
            <a href="javascript:void(0);" onclick="javascript: $.LAYER.close();" class="model-ly-close"></a>
        </div>
        <div class="model-ly-body">
            <ul class="model-search-form">
                <li>
                    <label class="model-label">参拍人：</label>
                </li>
                <li>
                    <label class="model-label">身份证号：</label>
                </li>
                <li>
                    <label class="model-label">手机号：</label>
                </li>
                <li>
                    <label class="model-label">成交车辆数：</label>
                </li>
                <li>
                    <label class="model-label">成交额小计：</label>
                </li>
                <li class="whole">
                    <table class="bk_table width_percent_100">
                        <colgroup>
                            <col style="width: 80px;">
                            <col style="width: 80px;">
                            <col style="width: 80px;">
                            <col style="width: 80px;">
                            <col style="width: 80px;">
                            <col style="width: 80px;">
                        </colgroup>
                        <thead>
                            <tr>
                                <th>VIN码</th>
                                <th>车牌号</th>
                                <th>品牌车型车系</th>
                                <th>成交时间</th>
                                <th>成交价格</th>
                                <th>拍卖车辆编号</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </li>
            </ul>
            <div class="model-ly-btn">
                <input type="button" class="model-btn model-cancel" value="取消" onclick="javascript: $.LAYER.close();" />
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

function openVehiclesDiv(auctionId, auctionTitle, auctionMemberName, auctionMemberIDCar, auctionMemberCellphone, auctionNumber, dealVehicleSum, dealPriceSum) {
	var div = $("#vehiclesByAuctionMemberDiv");
	div.find("h1.model-ly-title").text(auctionTitle);
	var lis = div.find("li");
	var li;
	var txt;
	for (var i = 0; i < lis.length; i++) {
		li = lis[i];
		txt = li.find("label").text();
		if (txt.indexOf("参拍人：") == 0) {
			li.find("label").text("参拍人：" + auctionMemberName);
		} else if (txt.indexOf("身份证号：") == 0) {
			li.find("label").text("身份证号：" + auctionMemberIDCar);
		} else if (txt.indexOf("手机号：") == 0) {
            li.find("label").text("手机号：" + auctionMemberCellphone);
        } else if (txt.indexOf("成交车辆数：") == 0) {
            li.find("label").text("成交车辆数：" + dealVehicleSum);
        } else if (txt.indexOf("成交额小计：") == 0) {
            li.find("label").text("成交额小计：" + dealPriceSum);
        };
	};

    $.get("${ctx}/adumanage/selectVehiclesByAuctionMember?auctionId=" + auctionId + "&auctionNumber=" + auctionNumber, function(result, status) {
        var success = result.success;
        if (success) {
            var data = result.data;
            if (data.length > 0) {
            	var av;
            	var tbody = div.find("tbody");
            	var tr;
            	var td;
            	for (var i = 0; i < data.length; i++) {
            		av = data[i];
            		tr = $("<tr></tr>");

            		td = $("<td></td>");
            		td.text(av.vinCode);
                    tr.append(td);
                    td = $("<td></td>");
                    td.text(av.licenseCode);
                    tr.append(td);
                    td = $("<td></td>");
                    td.text(av.brandModel);
                    tr.append(td);
                    td = $("<td></td>");
                    td.text(av.dealTime);
                    tr.append(td);
                    td = $("<td></td>");
                    td.text(av.dealPrice);
                    tr.append(td);
                    td = $("<td></td>");
                    td.text(av.auctionVehicleOrder);
                    tr.append(td);

            		tbody.append(tr);
            	};
			};
        } else {
            openAlertDiv("查询中拍拍品列表失败!");
        };
    });
};
</script>