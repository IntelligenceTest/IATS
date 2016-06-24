<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>

<table class="form_table width_percent_100 mb_20">
    <tbody>
        <tr>
            <th>车辆评分评级:</th>
            <td>
                <label>车架评级：${vehicle.grade}</label>
                <label>车况评分：${vehicle.score}</label>
            </td>
            <th>车辆评分详情:</th>
            <td>
                <c:forEach var="score" items="${vehicle.checkItemCategoryScoreList}" varStatus="status">
                    <label>
                        <c:choose>
                            <c:when test="${score.checkitemCategoryId == 4}">车身外观：<fmt:formatNumber groupingUsed="false" maxFractionDigits="1" value="${score.score}" /></c:when>
                            <c:when test="${score.checkitemCategoryId == 5}">驾驶舱：<fmt:formatNumber groupingUsed="false" maxFractionDigits="1" value="${score.score}" /></c:when>
                            <c:when test="${score.checkitemCategoryId == 6}">发动机舱：<fmt:formatNumber groupingUsed="false" maxFractionDigits="1" value="${score.score}" /></c:when>
                            <c:when test="${score.checkitemCategoryId == 7}">启动检查：<fmt:formatNumber groupingUsed="false" maxFractionDigits="1" value="${score.score}" /></c:when>
                            <c:when test="${score.checkitemCategoryId == 8}">路试：<fmt:formatNumber groupingUsed="false" maxFractionDigits="1" value="${score.score}" /></c:when>
                            <c:when test="${score.checkitemCategoryId == 9}">底盘：<fmt:formatNumber groupingUsed="false" maxFractionDigits="1"   value="${score.score}" /></c:when>
                        </c:choose>
                    </label>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <th rowspan="5">行驶证:</th>
            <td rowspan="5">
                <label style="display: inline;">是否见到行驶证：</label>
                <c:if test="${vehicle.vehicleLicense}"><label style="display: inline;">有</label></c:if>
                <c:if test="${!vehicle.vehicleLicense}"><label style="display: inline;">无</label></c:if>
                <br>
                <c:choose>
                    <c:when test="${vehicle.vehicleLicenseUrl == null || vehicle.vehicleLicenseUrl == ''}">
                        <img align="middle" id="vehicleLicenseFilePic" style="width: 240px;height: 180px;" src="${staticUrl}/common/build/1.00/images/no.jpg" />
                    </c:when>
                    <c:otherwise>
                        <img align="middle" class="img-polaroid" id="vehicleLicenseFilePic" style="width: 240px;height: 180px;" src="${dfsHttpServer}/${vehicleLicenseUrlSmall}" onclick="javascript: $.LAYER.show({id:'vehicleLicenseFilePicBig', overlay:{opacity:0.5}});" />
                    </c:otherwise>
                </c:choose>
            </td>
            <th>VIN码:</th>
            <td><label>${vehicle.vinCode}</label></td>
        </tr>
        <tr>
            <th>VIN码是否清晰:</th>
            <td>
                <c:if test="${vehicle.clearVin}"><label>是</label></c:if>
                <c:if test="${!vehicle.clearVin}"><label>否</label></c:if>
            </td>
        </tr>
        <tr>
            <th>品牌厂商车系车型:</th>
            <td><label style="display: inline;">${vehicle.brand}</label>/<label style="display: inline;">${vehicle.manufacturer}</label>/<label style="display: inline;">${vehicle.brandSeries}</label>/<label style="display: inline;">${vehicle.vehicleModel}</label>/<label style="display: inline;"><c:if test="${vehicle.modelYear!=null}">${vehicle.modelYear}款</c:if></label></td>
        </tr>
        <tr>
            <th>销售名称:</th>
            <td><label>${vehicle.selledName}</label></td>
        </tr>
        <tr>
            <th>出厂年月:</th>
            <td><label>${vehicle.producedYears}</label></td>
        </tr>
        <tr>
            <th>车牌号:</th>
            <td><label>${vehicle.licenseCode}</label></td>
            <th>上牌年月:</th>
            <td><label>${vehicle.registerLicenseYears}</label></td>
        </tr>
        <tr>
            <th>上牌城市:</th>
            <td><label style="display: inline;">${vehicle.registerProvince}</label><label style="display: inline;">${vehicle.registerCity}</label>
            </td>
            <th>车辆所在城市:</th>
            <td><label style="display: inline;">${vehicle.currentProvince}</label><label style="display: inline;">${vehicle.currentCity}</label>
        </tr>
        <tr>
            <th>发动机编号:</th>
            <td><label>${vehicle.engineCode}</label></td>
            <th>排气量:</th>
            <td><label>${vehicle.sweptVolume}${vehicle.sweptVolumeType}</label></td>
        </tr>
        <tr>
            <th>表显里程(公里):</th>
            <td><label>${vehicle.displayMileage}</label></td>
            <th>环保标准:</th>
            <td><label>${vehicle.sweptVolumeStandard}</label></td>
        </tr>
        <tr>
            <th>表显里程是否清晰:</th>
            <td>
                <c:if test="${vehicle.clearDisplayMileage}"><label>是</label></c:if>
                <c:if test="${!vehicle.clearDisplayMileage}"><label>否</label></c:if>
            </td>
            <th>最大功率(KW):</th>
            <td><label>${vehicle.power}</label></td>
        </tr>
        <tr>
            <th>车辆颜色:</th>
            <td><label>${vehicle.bodyColor}</label></td>
            <th>内饰颜色:</th>
            <td><label>${vehicle.interiorColor}</label></td>
        </tr>
        <tr>
            <th>燃料类型:</th>
            <td><label>${vehicle.oilType}</label></td>
            <th>变速器类型:</th>
            <td><label>${vehicle.transmissionType}</label></td>
        </tr>
    </tbody>
</table>

<div id="vehicleLicenseFilePicBig" class="UED_hide UED_LAYER_PARENT_V1">
    <div class="tip-offset_5">
        <a class="tipclose" href="javascript:$.LAYER.close();"></a>
        <div class="tip-refund-box clearfix">
            <img src="${dfsHttpServer}/${vehicleLicenseUrlBig}"/>
            <div class="clear"></div>
        </div>
    </div>
</div>

<script type="text/javascript">
</script>