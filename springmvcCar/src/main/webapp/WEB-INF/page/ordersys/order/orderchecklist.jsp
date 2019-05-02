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
<script type="text/javascript">
    $(function(){
        	$("#jump").click(function(){
        		var num=$("#num").val();
        		$(this).attr("href","orderchecklist?page="+num);
        	}); 
        	
    });

</script>

<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt; 订单管理</h2>
	</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
       	<form id="form-search" name="form-search" action="orderchecksearch" method="post">
        <tr>
            <th align="right">订单编码：</th>
            <td><input name="ordercode" type="text" class="inputTextNormal" id="textfield1" /></td>
            <th align="right">订单保存时间：</th>
            <td><input name="orderdate" type="text" class="inputTextNormal" id="textfield2" /></td>
            <td align="right">订单状态：</td>
            <td>
            		<select id="orderstatus" name="orderflag">
						<option value="-1" selected>请选择</option>
						<option value="1">待审核</option>
	                    <option value="2">已通过</option>
						<option value="3">不通过</option>
					</select></td>

            <th align="right">
				<input type="submit" class="btnShort" value="检索" />
			</th>
        </tr>
        <tr>

          </tr>
       	</form>
    </table>


 
	<br>

    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
        <tr>
            <th>序号</th>
            <th>订单编码</th>
            <th>订单保存时间</th>
            <th>订单状态</th>
            <th class="editColDefault">操作</th>
        </tr>
      <c:forEach items="${list }" var="b" varStatus="c">
        <tr>
            <td align="center">${c.count }</td>
            <td align="center">${b.ordercode }</td>
            <td align="center">${b.orderdate }</td>
            <c:if test="${b.orderflag==1 }">
			<td align="center"><font color="BLUE">待审核</font></td>
			<td align="center">
            	<a href="${pageContext.request.contextPath }/page/ordersys/order/orderyeschange?orderid=${b.orderid }" id="pass"><font color="BLUE" >通过</font></a>
            	<a href="${pageContext.request.contextPath }/page/ordersys/order/ordernochange?orderid=${b.orderid }" id="nopass"><font color="BLUE">不通过</font></a>
            </td>
			</c:if>
			<c:if test="${b.orderflag==2 }">
			<td align="center"><font color="red">已通过</font></td>
			<td align="center">
            	
            </td>
			</c:if>
            <c:if test="${b.orderflag==3 }">
			<td align="center"><font>不通过</font></td>
			<td align="center">
            	
            </td>
			</c:if>
        </tr>
     </c:forEach>   
  </table>
    <!--//commonTable-->
    <div id="pagelist">
    	<ul class="clearfix">
        	<li><a href="orderchecklist?page=${page.firstPage}">首页</a></li>
            <li ><a href="orderchecklist?page=${page.prePage}">上页</a></li>
            <li><a href="orderchecklist?page=${page.nextPage}">下页</a></li>
            <li class="current"><input type="text" value="${page.pageNum }" id="num" style="text-align:right" size="1"></li>
            <li><a href="orderchecklist?page=${page.firstPage}" id="jump">跳转</a></li>
            <li><a href="orderchecklist?page=${page.lastPage}">尾页</a></li>
            <li class="pageinfo">第${page.pageNum }页</li>
            <li class="pageinfo">共${page.pages}页</li>
        </ul>
    </div>
</div>
<!--//content pages wrap-->
</body>
</html>
