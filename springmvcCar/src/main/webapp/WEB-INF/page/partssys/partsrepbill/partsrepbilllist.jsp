<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>物资采购与产品整合管理系统</title>
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js" type="text/javascript"></script>

</head>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script>
    $(function(){
    	$("#flag").change(function(){
    		var flag=$(this).val();
    		$("#type").empty();
			$("#type").append($("<option>").val("0").html("请选择"));
    		if(flag=='O'){
    			$("#type").append($("<option>").val("out1").html("订单出库"));
    			$("#type").append($("<option>").val("out2").html("调拨出库"));
    			$("#type").append($("<option>").val("out3").html("其他出库"));
    		}
    		if(flag=='I'){
    			$("#type").append($("<option>").val("in1").html("采购入库"));
    			$("#type").append($("<option>").val("in2").html("调拨入库"));
    			$("#type").append($("<option>").val("in3").html("其他入库"));
    		}
    	});
    	
    	$("#jump").click(function(){
    		var num=$("#num").val();
    	    $("#jump").attr("href","partsrepbilllist?page="+num)
    	 }); 

    });
</script>

<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt; 配件库存流水账查询</h2>
	</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
       	<form id="form-search" name="form-search" action="searchlist" method="post">
        <tr>
            <th align="right">配件名称：</th>
            <td><input name="partsname" type="text" class="inputTextNormal" id="textfield2" /></td>
            <th align="right">出/入库：</th>
            <td>
            	<select style="width:150px;" id="flag" name="billflag">
						<option value="0" checked>请选择</option>
						<option value="O">出库</option>
						<option value="I">入库</option>
				</select>
			</td>
            <th align="right">出入库类型：</th>
            <td>
            	<select style="width:150px;" id="type" name="billtype">
						<option value="0" checked>请选择</option>
				</select>
            </td>
            <th align="right">出入库日期：</th>
            <td>
            	<input name="billtime" type="text" class="inputTextNormal" id="textfield2" />
            </td>
            <th align="right">
				<input type="submit" class="btnShort" value="检索" />
			</th>
        </tr>
       	</form>
    </table>
	<br>

    <!--//commonTableSearch-->

    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
        <tr>
            <th>序号</th>
            <th>出/入库</th>
            <th>出入库类别</th>
            <th>配件名称</th>
            <th>数量</th>
            <th>时间</th>
            <th>操作人</th>
        </tr>
        <c:forEach items="${list }" var="b" varStatus="c">
        <tr>
            <td align="center">${c.count }</td>
            <c:if test="${b.billflag=='I' }">
            <td align="center">入库</td>
             </c:if>
            <c:if test="${b.billflag=='O' }">
            <td align="center">出库</td>
             </c:if>
            <td align="center">${b.name }</td>
			<td align="center">${b.PartsName }</td>
			<td align="center">${b.billcount }</td>
			<td align="center">${b.billtime }</td>
			<td align="center">张成刚</td>
        </tr>
       </c:forEach>
        
  </table>
    <!--//commonTable-->
    <div id="pagelist">
    	<ul class="clearfix">
        	<li><a href="partsrepbilllist?page=${page.firstPage}">首页</a></li>
            <li ><a href="partsrepbilllist?page=${page.prePage}">上页</a></li>
            <li><a href="partsrepbilllist?page=${page.nextPage}">下页</a></li>
            <li class="current"><input type="text" style="text-align:right" size="1" value="${page.pageNum }" id="num"></li>
            <li><a href="partsrepbilllist?page=${page.firstPage}" id="jump">跳转</a></li>
            <li><a href="partsrepbilllist?page=${page.lastPage}">尾页</a></li>
            <li class="pageinfo">第${page.pageNum }页</li>
            <li class="pageinfo">共${page.pages}页</li>
        </ul>
    </div>
</div>
<!--//content pages wrap-->
</body>
</html>