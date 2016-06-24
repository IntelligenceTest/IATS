<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@include file="/jsp/common/tag.jsp"%>
<%-- <%@include file="/jsp/common/js.jsp"%>
<%@include file="/jsp/common/css.jsp"%> --%>
<style>
	#kkpager2 span.curr {
	padding: 4px 8px;
	margin: 10px 3px;
	font-size: 12px;
	border: 1px solid #58A0DF;
	background-color: #58A0DF;
	color: #FFF;
	}
	
	#kkpager2 a {
	padding: 4px 8px;
	margin: 10px 3px;
	font-size: 12px;
	border: 1px solid #DFDFDF;
	background-color: #FFF;
	color: #9d9d9d;
	text-decoration: none;
	}
	
	#kkpager2 span.disabled {
	padding: 4px 8px;
	margin: 10px 3px;
	font-size: 12px;
	border: 1px solid #DFDFDF;
	background-color: #FFF;
	color: #DFDFDF;
	}
</style>
<p style="color:#333;text-align: right;">
		<c:if test="${pagination!=null}">
				共${pagination.count}条
		</c:if>
</p>
<table class="datelist-1" id="datatable">
    <thead>
        <tr>
            <td width=25><div><span><input type="checkbox" onclick="selectAll(this)" id="selectAll">
            </span></div></td>
            <td ><div><span>车辆编号</span></div></td>
            <td ><div class="locklast"><span>品牌型号</span></div></td>
            <td >展售状态</td>
            <td >展售价格(万元)</td>
            <td >展售区域</td>
            <td>表显里程</td>
            <td>首次上牌</td>
            <td >VIN码</td>
            <td >上架时间</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${pagination.dataList}" var="item">
            <tr>
                <td>
                    <div>
                        <span>
                          <c:if test="${ !item.isRecommend}">
                                <input type="checkbox" class="subcheck" id="subcheck" name="subcheck" value="${item.id}" onclick="setSelectAll(this)" />
                          </c:if>
                        </span>
                     </div>
                </td>
                <td><div><span>
                   ${item.vehicle.code }
                </span></div></td>
                <td style="text-align: left;">
                    <div class="locklast">
                        <span style="text-align: left; margin-left: 5px;">
                            <a href="http://auction.autostreets.com/no-haggle/${item.vehicle.id}" target="_blank">
                                ${item.vehicle.brand }${item.vehicle.vehicleModel }<br/>${item.vehicle.selledName }
                            </a>
                        </span>
                    </div>
                </td>
                <td>
                    <p>
                    <!-- 展品状态：0-上架申请、1-已下架、2-已出售、3-已上架、4-已预订、5-已付定金、6-已付全款 -->
                        <c:if test="${ item.id==null}">待售</c:if>
                        <c:if test="${ item.status==0}"><font color="green">上架申请</font></c:if>
                        <c:if test="${ item.status==1}">
                            <font color="gray"><b>已下架</b></font><br>
        <a href="javascript:void(0);" onmouseover="showOffRemark(event,this);" onmouseout="hideOffRemark();">查看原因</a>
        <input type="hidden" value=" ${item.offShelvesRemark }">
                        </c:if>
                        <c:if test="${ item.status==2}"><font color="purple"><b>已出售</b></font></c:if>
                        <c:if test="${ item.status==3}"><font color="blue"><b>已上架</b></font></c:if>
                        <c:if test="${ item.status==4}"><font color="green"><b>已预订</b></font></c:if>
                        <c:if test="${ item.status==5}"><font color="red">已付定金</font></c:if>
                        <c:if test="${ item.status==6}"><font color="red"><b>已付全款</b></font></c:if>
                    </p>
                </td>
                 <td><p>
                <span>
                    <c:if test="${ item.price != null}">
                        <fmt:formatNumber  maxFractionDigits="2" minFractionDigits="0" value="${item.price/10000 }"></fmt:formatNumber>
                    </c:if>
                </span>
                </p></td>
                 <td><p>
                <span>
                    ${item.city }
                </span>
                </p></td>
                <td><p>${item.vehicle.displayMileage }</p></td>
                <td><p>${item.vehicle.registerLicenseYears}</td>
                <td>${item.vehicle.vinCode }</td>
                <td><p><fmt:formatDate value="${item.sellTime}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<c:if test="${pagination!=null}">
	<div class="pagination" style="text-align:center;">
		<div id="kkpager2"  style="padding-top: 20px;"></div>
	</div>
</c:if>
<div class="clearfix"></div>
<script>
 $(document).ready(
	function(){
		var total=${pagination.total};
		var current=${pagination.current};
		var begin=1;
		if(current>3){
			begin=current;
		}
		/* console.log(begin);
		console.log(current);
		console.log(total); */
		var html='';
		if(current==1){
			html+='<span class="disabled">首页</span>';
		}else{
			html+='<a href="#" onclick="return clickPage(1)" title="首页">首页</a>';
		}
		for(;begin<=total&&begin<current+8;begin++){
			if(begin==current){
				html+='<span class="curr">'+begin+'</span>';
			}else{
				html+='<a href="#" onclick="return clickPage('+begin+')" title="尾页">'+begin+'</a>';
			};
		}
		if(current==total){
			html+='<span class="disabled">尾页</span>';
		}else{
			html+='<a href="#" onclick="return clickPage('+total+')" title="尾页">尾页</a>';
		}
		$("#kkpager2").append(html);
	}
	
); 
function clickPage(current){
	//alert(current);
	$("#currentPage").val(current);
	$("#searchVehicleBtn").click();
};

 $(function(){
	/* kkpager.generPageHtml({
		pagerid:'kkpager2',
		mode:'click',
	    pno : '${pagination.current}',
	    //总页码
	    total : '${pagination.total}',
	    //总数据条数
	    totalRecords : '${pagination.count}',
	    //链接算法
	    click : function(n){
	     	$("#currentPage").val(n);
	     	$("#searchVehicleBtn").click();
	    }
	});
	//设置当前页码
	kkpager.selectPage('${pagination.current}'); */
	
	//Table List选中效果
	$("#datatable tr").hover(function(){
		if(!$(this).hasClass("selected")){
			$(this).find("td").css({"background":"#d9edf7"});
		}
	},function(){
		if(!$(this).hasClass("selected")){
			$(this).find("td").css({"background":"transparent"});
		}
	});
	$("#datatable tr").click(function(){
		$(this).parent().find("tr").removeClass("selected");
		$(this).parent().find("td").css({"background":"transparent"});
		$(this).find("td").css({"background":"#dff0d8"});
		$(this).addClass("selected");
	});
}); 
</script>