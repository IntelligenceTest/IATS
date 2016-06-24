<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>AutoStreets后台系统-首页</title>
<%@include file="/jsp/common/css.jsp"%>
<%@include file="/jsp/common/js.jsp"%>
<style>
    .datelist-1 td a{text-decoration:blink;}
</style>
<script type="text/javascript">
    //全选/反选操作
    var cbId ="selectAll",subId="subcheck";
    var ctx = "${ctx}";
    var showStores = "${maintenAppointment.showStores}";
</script>
</head>
<body>
<jsp:include page="${ctx }/common/menu" flush="true"></jsp:include>
<div class="mainblock">
    <div class="m_content">
        <div class="rbody">
            <div class="bkmain">
                <h3>欢迎您登录汽车街拍卖后台系统！</h3>
                <dl>
                    <dt>系统公告</dt>
                    <dd>[2014.07.28] 系统上线！</dd>
                </dl>
                <dl>
                    <dt>操作须知</dt>
                    <dd>1.为了更好的体验本系统，请使用chrome浏览器！</dd>
                    <dd>2.在使用过程中，如遇到问题，请及时联系我们的技术支持！</dd>
                </dl>
                <div>
                    <h4>技术支持：</h4>
                    <ul>
                        <li><span>电话：</span>021-33291730</li>
                        <li><span>邮箱：</span><a href="mailto:tech@autostreets.com">tech@autostreets.com</a></li>
                    </ul>
                </div>
            </div>
        </div>
        </div>
    </div>
</body>
</html>