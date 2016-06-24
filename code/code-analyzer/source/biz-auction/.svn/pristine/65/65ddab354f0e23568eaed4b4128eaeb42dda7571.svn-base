<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>

<table class="form_table width_percent_100 mb_20">
    <tbody>
        <tr>
            <th class="wid_60">车辆配置:</th>
            <td class="chepei">
                <ul id="ul_featureItem" class="func carconfig">
                    <c:forEach var="featureItems" items="${featureItemsList}" varStatus="status">
                        <li title="${featureItems.featureColumnText}">${featureItems.featureColumnText}</li>
                    </c:forEach>
                </ul>
                <a href="javascript:void(0)" class="inline_btn morechoice">[更多选择]</a>
            </td>
        </tr>
        <tr>
            <th class="wid_60">个性配置:</th>
            <td>
                <ul id="ul_personalFeatureItem" class="func carconfig">
                    <c:forEach var="featureItems" items="${featureItemsList}" varStatus="status">
                        <li title="${featureItems.featureColumnText}">${featureItems.featureColumnText}</li>
                    </c:forEach>
                </ul>
                <a href="javascript:void(0)" class="inline_btn morechoice">[更多选择]</a>
            </td>
        </tr>
    </tbody>
</table>

<script type="text/javascript">
</script>