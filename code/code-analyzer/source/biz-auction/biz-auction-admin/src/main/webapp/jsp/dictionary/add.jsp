<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/jsp/common/tag.jsp"%>
<form:form action="${ctx}/auctionDictionary/save" commandName="auctionDictionary" modelAttribute="auctionDictionary" id="addDicForm" accept-charset="utf-8" method="post" >
    <table class="tbl-form-1">
        <tbody>
         <tr>
         	 <input type="hidden" id="id" name="id" value="${auctionDictionary.id }" />
         	 <input type="hidden" name="delFlag" value="0" />
             <th width="20%"><span class="star">*</span><label for="category">参数:</label></th>
             <td><form:input class="from-input-1" path="category" style="width:150px;" maxlength="20" id="categoryInput" /></td>
             <th width="20%"><span class="star">*</span><label for="value">值:</label></th>
             <td><form:input class="from-input-1" path="value" style="width:150px;" maxlength="50" id="valueInput" /></td>
         </tr>
         <tr>
             <th width="20%"><span class="star">*</span><label for="name">显示名称:</label></th>
             <td><form:input path="name" style="width:150px;" maxlength="20" id="nameInput" /></td>
             <th width="20%"><label for="itemOrder">显示顺序:</label></th>
             <td><form:input path="itemOrder" style="width:150px;" maxlength="2"/></td>
         </tr>
         <tr>
             <th width="20%"><label for="categoryDesc">参数描述:</label></th>
             <td colspan="3"><form:input path="categoryDesc" style="width:250px;" /></td>
         </tr>
     </tbody>
     <tfoot>
         <tr>
             <td colspan="4">
                 <p align="center" class="btn-box">
                     <input type="button" value="保存" id="save"/>
                 </p>
             </td>
         </tr>
        </tfoot>
    </table>
</form:form>
<script type="text/javascript">
$(function(){
    $("#save").click(function(){
        if($("#categoryInput").val()==""){
            alert("参数为必填项!");
            return;
        }
        if($("#valueInput").val()==""){
            alert("值为必填项!");
            return;
        }
        if($("#nameInput").val()==""){
            alert("名称为必填项!");
            return;
        }
       $.ajax({
           url:"${ctx}/auctionDictionary/save",
           data:$("#addDicForm").serialize(),
           success:function(data){
               if(data.success){
                   alert(data.msg);
                   location.reload();
               }else{
                   alert("保存失败!");
               }
           }
       }) 
    });
});
</script>