<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>物资采购与产品整合管理系统</title>
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js" type="text/javascript"></script>
</head>

<body class="content-pages-body">
<div class="content-pages-wrap">
    <div class="commonTitle">
        <h2>&gt;&gt; 订单明细</h2>
  </div>
        <form id="coursesCreat" name="coursesCreat" action="" method="post">
		<table border="0" cellspacing="1" cellpadding="0" class="commonTable">
        <tr>
            <td width="19%" align="right" class="title">订单序号：</td>
            <td width="29%" align="left">${m.orderid }</td>
            <td width="19%" align="right" class="title">订单编码：</td>
            <td width="29%" align="left">${m.ordercode }</td>
        </tr>
        <tr>
            <td width="19%" align="right" class="title">订单日期：</td>
            <td width="29%" align="left">${m.orderdate }</td>
            <td width="19%" align="right" class="title">订单状态：</td>
            <td width="29%" align="left">${m.name }</td>
        </tr>
		</table>
		<br/>
		
		<table border="0" cellspacing="1" cellpadding="0" class="commonTable">
        <tr>
            <th>明细序号</th>
            <th>订单编码</th>
            <th>配件名称</th>
            <th>进货数量</th>
        </tr>
        <c:forEach items="${list }" var="l" varStatus="c">
        <tr>
            <td align="center">${c.count }</td>
            <td align="center">${l.ordercode }</td>
            <td align="center">${l.PartsName }</td>
			<td align="center">${l.PartsReqCount }</td>
        </tr>
       </c:forEach>
		</table>
		<br/>
        </form>		 
    <!--//commonTable-->
    <div id="formPageButton">
    	<ul>
        	<li><a href="javascript:window.history.go(-1)" title="返回" class="btnShort">返回</a></li>
        </ul>
    </div>
    <!--//commonToolBar-->
</div>
<!--//content pages wrap-->
</body>
</html>
