<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>

<table class="pic_table mb_20 width_percent_100">
    <tbody>
        <c:forEach var="vehiclePhoto" items="${vehicle.starPhotoList}" varStatus="status">
            <c:set var="i" value="${status.index}" />
            <c:if test="${i%5==0}"><tr></c:if>
                <td>
                    <table>
                        <tr>
                            <td>
                                <c:choose>
                                    <c:when test="${vehiclePhoto.photoUrl == null || vehiclePhoto.photoUrl == ''}">
                                        <img id="starPhotoList${i}Pic" class="img-polaroid" name="starPhotoList[${i}].picUrl" style="width: 90px;height: 66px;" src="${staticUrl}/common/build/1.00/images/no.jpg" />
                                    </c:when>
                                    <c:otherwise>
                                        <spring:eval expression="@auctionDictionaryService.choiceImgUrl('90X66', vehiclePhoto.photoUrl)" var="photoUrlSmall" />
                                        <img id="starPhotoList${i}Pic" class="img-polaroid" name="starPhotoList[${i}].picUrl" style="width: 90px;height: 66px;" src="${dfsHttpServer}/${photoUrlSmall}" onclick="javascript: $.LAYER.show({id:'starPhotoList${i}BigPic', overlay:{opacity:0.5}});" />
                                        <div id="starPhotoList${i}BigPic" class="UED_hide UED_LAYER_PARENT_V1">
                                            <div class="tip-offset_5">
                                                <a class="tipclose" href="javascript:$.LAYER.close();"></a>
                                                <div class="tip-refund-box clearfix">
                                                    <spring:eval expression="@auctionDictionaryService.choiceImgUrl('520X390', vehiclePhoto.photoUrl)" var="photoUrlBig" />
                                                    <img src="${dfsHttpServer}/${photoUrlBig}"/>
                                                    <div class="clear"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr><td>${vehiclePhoto.photoName}</td></tr>
                    </table>
                </td>
            <c:if test="${(i+1)%5==0}"></tr></c:if>
        </c:forEach>
    </tbody>
</table>

<script type="text/javascript">
</script>