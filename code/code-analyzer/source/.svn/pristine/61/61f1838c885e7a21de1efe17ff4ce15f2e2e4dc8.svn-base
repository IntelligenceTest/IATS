<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/jsp/common/meta.jsp"%>
<title>车辆详情</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
</head>

<body>
<div class="mainblock">
    <div class="container">
        <div class="bi_wrap">
            <ul id="nav_ul" class="bk_title">
                <li id="nav_li_1" class="cur">
                    <a href="javascript:;">基本信息</a>
                </li>
                <li id="nav_li_2">
                    <a href="javascript:;">车辆配置</a>
                </li>
                <li id="nav_li_3">
                    <a href="javascript:;">车辆照片</a>
                </li>
                <li id="nav_li_4">
                    <a href="javascript:;">外观检测</a>
                </li>
                <li id="nav_li_5">
                    <a href="javascript:;">骨架检测</a>
                </li>
                <li id="nav_li_6">
                    <a href="javascript:;">内饰检测</a>
                </li>
                <li id="nav_li_7">
                    <a href="javascript:;">车况检测</a>
                </li>
                <li id="nav_li_8">
                    <a href="javascript:;">附件信息</a>
                </li>
                <li id="nav_li_9">
                    <a href="javascript:;">客户需求</a>
                </li>
            </ul>
        </div>
        <div id="nav_content_1" class="bi_wrap nav_content" style="display: block;">
            <%@include file="tabs-1.jsp" %>
        </div>
        <div id="nav_content_2" class="bi_wrap nav_content" style="display: none;">
            <%@include file="tabs-2.jsp" %>
        </div>
        <div id="nav_content_3" class="bi_wrap nav_content" style="display: none;">
            <%@include file="tabs-3.jsp" %>
        </div>
        <div id="nav_content_4" class="bi_wrap nav_content" style="display: none;">
            <%@include file="tabs-4.jsp" %>
        </div>
        <div id="nav_content_5" class="bi_wrap nav_content" style="display: none;">
            <%@include file="tabs-5.jsp" %>
        </div>
        <div id="nav_content_6" class="bi_wrap nav_content" style="display: none;">
            <%@include file="tabs-6.jsp" %>
        </div>
        <div id="nav_content_7" class="bi_wrap nav_content" style="display: none;">
            <%@include file="tabs-7.jsp" %>
        </div>
        <div id="nav_content_8" class="bi_wrap nav_content" style="display: none;">
            <%@include file="tabs-8.jsp" %>
        </div>
        <div id="nav_content_9" class="bi_wrap nav_content" style="display: none;">
            <%@include file="tabs-9.jsp" %>
        </div>
    </div>
</div>

<script type="text/javascript">
$(function() {

    /*车辆配置li选择*/
    $('.func').find('li').click(function () {
        $(this).toggleClass('cur');
    });

    $('.carconfig').each(function () {
        var $li = $(this).children('li');
        var len = $li.length;

        for (var i = 0; i < len; i++) {
            if (i > 23) {
                $($li[i]).hide();
            }
        }
    });

    $('.morechoice').click(function () {
        var $li = $(this).siblings('.carconfig').children('li');
        var len = $li.length;
        var lenvisi = $(this).siblings('.carconfig').children('li:visible').length;
        if (lenvisi > 24) {
            $(this).html('[更多选择]');
            for (var i = 0; i < len; i++) {
                if (i > 23) {
                    $($li[i]).hide();
                }
            }

        } else {
            $(this).html('[收起]');
            for (var i = 0; i < len; i++) {

                $($li[i]).show();

            }
        }
    });

    /*导航*/
    $('#nav_content_1').show();
    $('#nav_ul').find('li').click(function () {
        if (!$(this).hasClass('cur')) {
            $(this).addClass('cur').siblings().removeClass('cur');
            var id = $(this).attr('id').substring(7);
            
            $('.nav_content').hide();
            $('#nav_content_' + id).show();
        }
    });

    /*滚轮*/
    $('#facade_div').scroll(function () {
        var wscry = document.getElementById('facade_div').scrollTop;
        var top = wscry;
        var maxtop = $('#facade_table').height() - $('#facade').height();
        if (top > 0 && top < maxtop) {
            $('#facade').css('top', top + 'px');
        } else if (top >= maxtop) {
            $('#facade').css('top', maxtop + 'px');
        } else {
            $('#facade').css('top', '0px');
        }
    });

    $(window).scroll(function () {
        if ($('#nav_li_5').hasClass('cur')) {
            var wscry = window.scrollY;
            var top = wscry - 241;
            var maxtop = $('#framework_table').height() - $('#framework').height();
            if (top > 0 && top < maxtop) {
                $('#framework').css('top', top + 'px');
            } else if (top >= maxtop) {
                $('#framework').css('top', maxtop + 'px');
            } else {
                $('#framework').css('top', '0px');
            }
        } else if ($('#nav_li_6').hasClass('cur')) {
            var wscry = window.scrollY;
            var top = wscry - 241;
            var maxtop = $('#upholstery_table').height() - $('#upholstery').height();
            if (top > 0 && top < maxtop) {
                $('#upholstery').css('top', top + 'px');
            } else if (top >= maxtop) {
                $('#upholstery').css('top', maxtop + 'px');
            } else {
                $('#upholstery').css('top', '0px');
            }
        }
    });

    $(".e").click(function() {
        $(".e img").hide();
        $("img", this).show();
    });

    $(document).click(function(event) {
        var $e = $(event.target);
        if ($e.parents(".carimg-1,.carimg-2,.carimg-3").length == 0) {
            $(".e img").hide();
        }
    });

    var featureItems = "${vehicle.featureItems}";
    if (featureItems != "") {
        var items = featureItems.split(",");
        for (var i = 0; i < items.length; i++) {
            $("#ul_featureItem").find("li[title='" + items[i] + "']").click();
        }
    }

    var personalFeatureItems = "${vehicle.personalFeatureItems}";
    if (personalFeatureItems != "") {
        var items = personalFeatureItems.split(",");
        for (var i = 0; i < items.length; i++) {
            $("#ul_personalFeatureItem").find("li[title='" + items[i] + "']").click();
        }
    }
});
</script>
</body>
</html>