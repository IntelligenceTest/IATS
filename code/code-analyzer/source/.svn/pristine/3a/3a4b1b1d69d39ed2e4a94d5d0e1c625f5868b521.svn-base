<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>

<div class="hscroll_600 mb_20">
    <table id="cardetail_table" class="form_table mb_20 width_percent_100 td50">
        <tbody>
            <c:set var="i" value="1" />
            <c:forEach var="subCategory" items="${vehicle.checkItemCategoryList}">
                <c:if test="${subCategory.name != '车身外观'}">
                    <tr>
                        <th colspan="2" class="head">${subCategory.name}</th>
                    </tr>
                    <c:forEach var="checkitem" items="${vehicle.checkitemList}" varStatus="status">
                        <c:set var="i" value="${checkitem.itemOrder}" />
                        <c:set var="j" value="${status.index}" />
                        <c:if test="${checkitem.subCategory==subCategory.id&&checkitem.itemGroup==2}">
                            <tr>
                                <th>
                                    <c:choose>
                                        <c:when test="${checkitem.good == false && (checkitem.itemDesc == '车内是否无水泡痕迹' || checkitem.itemDesc == '发动机机油是否无冷却液混入')}">
                                            <label style="color: red;">(${i})${checkitem.itemDesc}</label>
                                        </c:when>
                                        <c:otherwise>
                                            <label>(${i})${checkitem.itemDesc}</label>
                                        </c:otherwise>
                                    </c:choose>
                                </th>
                                <c:choose>
                                    <c:when test="${checkitem.good == true}">
                                        <td>OK</td>
                                    </c:when>
                                    <c:when test="${checkitem.damageLevelSelected != null && checkitem.damageLevelSelected.length() > 0}">
                                        <td>${checkitem.damageLevelSelected}</td>
                                    </c:when>
                                    <c:when test="${checkitem.good == false}">
                                        <td>NO</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>无</td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </c:if>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
</script>