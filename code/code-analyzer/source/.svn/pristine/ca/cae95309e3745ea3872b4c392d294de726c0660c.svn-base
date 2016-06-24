<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>

<div class="hscroll_600 mb_20" id="facade_div">
    <table id="framework_table" class="form_table mb_20 width_percent_100">
        <tbody>
            <tr>
                <td rowspan="${skeletonCount}" class="detection">
                    <div id="framework" class="fixed_facade">
                        <p>骨架检测：共包含${skeletonCount}个监测点，已用圆圈标出</p>
                        <div class="carimg-1">
                            <c:forEach var="checkitem" items="${vehicle.checkitemList}">
                                <c:set var="i" value="${checkitem.itemOrder}" />
                                <c:if test="${checkitem.category==1&&checkitem.itemGroup==1}">
                                    <c:choose>
                                        <c:when test="${checkitem.good}">
                                            <span id="skeletonList${i}CarImg" style="top:${checkitem.axisy}px; left:${checkitem.axisx}px;">${i}</span>
                                        </c:when>
                                        <c:otherwise>
                                            <spring:eval expression="@auctionDictionaryService.choiceImgUrl('350X200', checkitem.photoUrl)" var="damagePhotoSmall" />
                                            <span id="skeletonList${i}CarImg" class="e" style="cursor: pointer; top:${checkitem.axisy}px; left:${checkitem.axisx}px;">${i}
                                                <a href="${dfsHttpServer}/${damagePhotoSmall}" target="_blank"><img src="${dfsHttpServer}/${damagePhotoSmall}" style="position: absolute; z-index: 10000; width: 350px; height: 200px; left: 16px; top: 16px; display: none; max-width:350px; max-height: 200px;"></a>
                                            </span>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </td>
                <c:forEach var="checkitem" items="${vehicle.checkitemList}" varStatus="status">
                    <c:set var="i" value="${checkitem.itemOrder}" />
                    <c:if test="${checkitem.category==1&&checkitem.itemGroup==1}">
                        <c:if test="${i > 1}"><tr></c:if>
                        <th>(${i})${checkitem.itemDesc}</th>
                        <c:choose>
                            <c:when test="${checkitem.good}">
                                <td>OK</td>
                            </c:when>
                            <c:when test="${checkitem.damageStatusSelected != null && checkitem.damageStatusSelected.length() > 0}">
                                <td>${checkitem.damageStatusSelected}</td>
                            </c:when>
                            <c:when test="${checkitem.good == false}">
                                <td>NO</td>
                            </c:when>
                            <c:otherwise>
                                <td></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
</script>