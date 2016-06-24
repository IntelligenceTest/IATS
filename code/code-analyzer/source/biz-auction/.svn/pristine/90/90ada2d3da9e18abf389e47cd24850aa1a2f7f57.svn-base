/**
 * 拍卖场地
 * 
 * @author weiyi.wang
 */
var auctionPlace = {};
(function (app) {
    "use strict";
    /*jslint devel: true,debug: true,browser: true, nomen: true*/
    /*global angular: true,karam:true,$:true,ctx:true,common:true,highchartsFactory:true*/
    app.add = function () {
        window.open(ctx + "/auctionplace/addPage");
    };
    app.activate = function (flag) {
        if (common.checkSelect("auctionPlaceTable", 1)) {
            var ids = common.getSelectIds("auctionPlaceTable");
            $.ajax({
                type: "post",
                url: ctx + "/auctionplace/openOrClose",
                dataType: "json",
                data: {
                    flag: flag,
                    ids: ids.join(',')
                },
                success: function (data) {
                    alert(data.msg);
                    $('#auctionPlaceForm').submit();
                }
            });
        }
    };
}(auctionPlace));