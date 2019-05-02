<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
    	$("#num").bind("input change", function (){
    		var num=$("#num").val();
        	$("#jump").click(function(){
        		$(this).attr("href","orderlist?page="+num);
        	}); 
    	 });
    });
</script>

<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt; 订单管理</h2>
	</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
       	<form id="form-search" name="form-search" action="ordersearch" method="post">
        <tr>
            <th align="right">订单编码：</th>
            <td><input name="ordercode" type="text" class="inputTextNormal" id="textfield1" /></td>
            <th align="right">订单保存时间：</th>
            <td><input name="orderdate" type="text" class="inputTextNormal" id="textfield2" /></td>
            <td align="right">订单状态：</td>
            <td>
            <select style="width:150px;" name="orderflag">
                        <option value="-1" selected>请选择</option>
                        <option value="0">未提交</option>
						<option value="1">待审核</option>
						<option value="2">已通过</option>
			</select>
            </td>

            <th align="right">
				<input type="submit" class="btnShort" value="检索" />
			</th>
        </tr>
        <tr>

          </tr>
       	</form>
    </table>


    <!--//commonTableSearch-->
    
	<input type="button" class="btnNormal" value="创建订单" onclick="location.href='${pageContext.request.contextPath }/page/ordersys/order/orderadd'"/>	

	<br>

    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
        <tr>
            <th>序号</th>
            <th>订单编码</th>
            <th>订单保存时间</th>
            <th>订单状态</th>
            <th class="editColDefault">操作</th>
        </tr>
        <c:forEach items="${list }" var="b" varStatus="t">
        <tr>
            <td align="center">${t.count }</td>
            <td align="center">${b.ordercode }</td>
            <td align="center">${b.orderdate }</td>
            <c:if test="${b.orderflag==2 }">
                <td align="center"><font color="red">${b.name }</font></td>
                <td align="center">
            	<a href="system-order-view?orderid=${b.orderid }" class="btnIconView" title="查看详情"></a>
                </td>
            </c:if>
            <c:if test="${b.orderflag==1 }">
                <td align="center"><font color="blue">${b.name }</font></td>
                <td align="center">
            	<a href="system-order-view?orderid=${b.orderid }" class="btnIconView" title="查看详情"></a>
               </td>
            </c:if>
			<c:if test="${b.orderflag==0 }">
                <td align="center">${b.name }</td>
                <td align="center">
            	<a href="system-order-view?orderid=${b.orderid }" class="btnIconView" title="查看详情"></a>
            	<a href="system-order-create-edit?orderid=${b.orderid }" class="btnIconEdit" title="更新"></a>
                <a href="orderdelete?orderid=${b.orderid }" class="btnIconDel" title="删除"></a>
                </td>
            </c:if>
			
        </tr>
        
       </c:forEach>
  </table>
    <!--//commonTable-->
    <div id="pagelist">
    	<ul class="clearfix">
        	<li><a href="orderlist?page=${page.firstPage}">首页</a></li>
            <li ><a href="orderlist?page=${page.prePage}">上页</a></li>
            <li><a href="orderlist?page=${page.nextPage}">下页</a></li>
            <li class="current"><input type="text" value="${page.pageNum }" style="text-align:right" size="1" id="num"></li>
            <li><a href="orderlist?page=${page.firstPage}" id="jump" >跳转</a></li>
            <li><a href="orderlist?page=${page.lastPage}">尾页</a></li>
            <li class="pageinfo">第${page.pageNum }页</li>
            <li class="pageinfo">共${page.pages}页</li>
        </ul>
    </div>
</div>



<!--//content pages wrap-->
</body>
</html>
