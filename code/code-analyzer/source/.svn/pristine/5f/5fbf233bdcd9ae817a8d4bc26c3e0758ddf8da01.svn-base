<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>

<table id="clientele_table" class="form_table mb_20 width_percent_100 client">
    <tbody>
        <tr>
            <th>客户姓名:</th>
            <td><label>${vehicle.custName}</label></td>
        </tr>
        <tr>
            <th>客户联系电话:</th>
            <td><label>${vehicle.custPhone}</label></td>
        </tr>
        <tr>
            <th>客户所在省市:</th>
            <td><label>${vehicle.custProvince}</label><label>${vehicle.custCity}</label></td>
        </tr>
        <tr>
            <th>客户详细地址:</th>
            <td><label>${vehicle.custAddress}</label></td>
        </tr>
        <tr>
            <th>车辆来源:</th>
            <td>
                <label>
                    <c:choose>
                        <c:when test="${vehicle.vehicleSrcType==1}">集团客户</c:when>
                        <c:when test="${vehicle.vehicleSrcType==2}">大客户</c:when>
                        <c:when test="${vehicle.vehicleSrcType==3}">个人</c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose>
                </label>
            </td>
        </tr>
        <tr>
            <th>车辆所属门店:</th>
            <td><label>${vehicle.storeGroupName}${vehicle.storeCity}${vehicle.vehicleSrcOrg}</label></td>
        </tr>
        <tr>
            <th>车辆性质:</th>
            <td><label>${vehicle.vehiclePpe}</label></td>
        </tr>
        <tr>
            <th>销售需求:</th>
            <td><label>${vehicle.requirementType}</label></td>
        </tr>
        <tr>
            <th>客户售价需求:</th>
            <td>起拍价：<span>${vehicle.startBidPrice}元</span>  保底价：<span>${vehicle.reservePrice}元</span>  展售价：<span>${vehicle.salePrice}元</span></td>
        </tr>
        <tr>
            <th>如有违章，相关费用由:</th>
            <td><label>${vehicle.trafficViolationFines}</label></td>
        </tr>
        <tr>
            <th>保险是否随车销售:</th>
            <td>
                <c:if test="${vehicle.saleInsurance}"><label>是</label></c:if>
                <c:if test="${!vehicle.saleInsurance}"><label>否</label></c:if>
            </td>
        </tr>
        <tr>
            <th>特殊约定（仅后台网站展示）:</th>
            <td>
                <textarea cols="80" rows="5" class="textarea_td" readonly="readonly">${vehicle.remark}</textarea>
            </td>
        </tr>
        <tr>
            <th>车辆描述（仅前台网站展示）:</th>
            <td>
                <textarea cols="80" rows="5" class="textarea_td" readonly="readonly">${vehicle.vehicleDesc}</textarea>
            </td>
        </tr>
        <tr>
            <th rowspan="2">其他备注:</th>
            <td>
                <c:forEach items="${vehicle.otherPhotoList}" var="otherPhoto" varStatus="status">
                    <c:set var="i" value="${status.index}" />
                    <div class="wd-240">
                        <c:choose>
                            <c:when test="${otherPhoto.photoUrl == null || otherPhoto.photoUrl == ''}">
                                <img align="middle" id="otherPhotoList${i}Pic" style="width: 240px;height: 180px;" src="${staticUrl}/common/build/1.00/images/no.jpg" />
                            </c:when>
                            <c:otherwise>
                                <spring:eval expression="@auctionDictionaryService.choiceImgUrl('240X180', otherPhoto.photoUrl)" var="otherPhotoUrlSmall" />
                                <img id="otherPhotoList${i}Pic" class="img-polaroid" style="width: 240px;height: 180px;" src="${dfsHttpServer}/${otherPhotoUrlSmall}" onclick="javascript: $.LAYER.show({id:'otherPhotoList${i}BigPic', overlay:{opacity:0.5}});" />
                                <div id="otherPhotoList${i}BigPic" class="UED_hide UED_LAYER_PARENT_V1">
                                    <div class="tip-offset_5">
                                        <a class="tipclose" href="javascript: $.LAYER.close();"></a>
                                        <div class="tip-refund-box clearfix">
                                            <spring:eval expression="@auctionDictionaryService.choiceImgUrl('520X390', otherPhoto.photoUrl)" var="photoUrlBig" />
                                            <img src="${dfsHttpServer}/${photoUrlBig}"/>
                                            <div class="clear"></div>
                                        </div>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>
                <textarea cols="80" rows="5" class="textarea_td" readonly="readonly">${vehicle.other}</textarea>
            </td>
        </tr>
    </tbody>
</table>

<script type="text/javascript">
</script>