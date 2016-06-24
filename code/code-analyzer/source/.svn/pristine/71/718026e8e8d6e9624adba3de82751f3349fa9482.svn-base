<#macro pagination>
<#escape x as x?html>
<div class="page">
  <#if p.hasPreviousPage()>
    <a href="<@baseUrl.home />${action.getPaginationUrl(p.previousPageNumber)}">&lt;</a>
  </#if>
  
  <#assign interval = 5>
  <#assign displayTotalPages = 2 * interval - 1>
  
  <#assign preFlag = 0>
  <#assign postFlag = 0>
  
  <#if (p.pageNumber > interval + 2)>
  	<#assign preFlag = 1>
  </#if>
  
  <#if (p.lastPageNumber &gt; 2 * interval + 1) && (p.pageNumber + interval + 1 &lt; p.lastPageNumber)>
  	<#assign postFlag = 1>
  </#if>
  
  <#if preFlag == 1>
  	<#assign start = p.pageNumber - interval + 1>
  <#else>
  	<#assign start = 1>
  </#if>
  
  <#if postFlag == 1>
  	<#assign end = p.pageNumber + interval - 1>
  <#else>
  	<#assign end = p.lastPageNumber>
  </#if>
  
  <#if preFlag == 1>
  	<a href="<@baseUrl.home />${action.getPaginationUrl(1)}">1</a>
  	<span>...</span>
  </#if>
  
  <#list start..end as i>
    <#if i == p.pageNumber>
      <a href="javascript:;" class="current">${i}</a>
    <#else>
      <a href="<@baseUrl.home />${action.getPaginationUrl(i)}">${i}</a>
    </#if>
  </#list>
  
  <#if postFlag == 1>
  	<span>...</span>
  	<a href="<@baseUrl.home />${action.getPaginationUrl(p.lastPageNumber)}">${p.lastPageNumber}</a>
  </#if>

  <#if p.hasNextPage()>
    <a href="<@baseUrl.home />${action.getPaginationUrl(p.nextPageNumber)}">&gt;</a>
  </#if>
</div>
</#escape>
</#macro>
