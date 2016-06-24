<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>

<table id="affix_table" class="form_table mb_20 width_percent_100">
    <tbody>
        <tr>
            <th colspan="2" class="head">车辆资料</th>
        </tr>
        <tr>
            <th>使用性质:</th>
            <td>
                <label>${vehicle.usingModel}</label>
            </td>
        </tr>
        <tr>
            <th>产证:</th>
            <td>
                <c:if test="${vehicle.propertyCertificate}"><label>有</label></c:if>
                <c:if test="${!vehicle.propertyCertificate}"><label>未见</label></c:if>
            </td>
        </tr>
        <tr>
            <th>购置附加税完税证明:</th>
            <td>
                <c:if test="${vehicle.purchaseTaxProof}"><label>有</label></c:if>
                <c:if test="${!vehicle.purchaseTaxProof}"><label>未见</label></c:if>
            </td>
        </tr>
        <tr>
            <th>年审有效期:</th>
            <td><label><fmt:formatDate value="${vehicle.nextAnnualExamination}" pattern="yyyy-MM-dd" /></label></td>
        </tr>
        <tr>
            <th>钥匙:</th>
            <td><label>${vehicle.annexKey}</label></td>
        </tr>
        <tr>
            <th>交强险有效期:</th>
            <td><label><fmt:formatDate value="${vehicle.nextCompulsoryInsurance}" pattern="yyyy-MM-dd" /></label></td>
        </tr>
        <tr>
            <th>过户次数:</th>
            <td><label>${vehicle.transferNumber}</label></td>
        </tr>
        <tr>
            <th colspan="2" class="head">车辆附件</th>
        </tr>
        <c:forEach var="accessory" items="${vehicle.accessoryList}" varStatus="status">
            <c:set var="i" value="${status.index}" />
            <c:set var="optionSelected" value="${accessory.optionSelected}" />
            <tr>
                <th>${accessory.accessoryName}:</th>
                <td>${accessory.optionSelected}</td>
            </tr>
        </c:forEach>
        <tr>
            <th>附件备注:</th>
            <td>
                <textarea rows="5" cols="80" class="textarea_td" readonly="readonly">${vehicle.accessoryRemark}</textarea>
            </td>
        </tr>
    </tbody>
</table>

<script type="text/javascript">
</script>