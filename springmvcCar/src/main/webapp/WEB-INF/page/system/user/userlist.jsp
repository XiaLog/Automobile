<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>物资采购与产品整合管理系统</title>
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script>
	$(function(){
		$("#num").bind("input change", function (){
    		var num=$("#num").val();
        	$("#jump").click(function(){
        		$(this).attr("href","userlist?page="+num);
        	}); 
    	 });
	})
</script>
</head>

<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt; 用户管理</h2>
	</div>
	<form name="queryForm" method="post" action="usersearch">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
       
        <tr>
            <th align="right">用户名：</th>
            <td><input name="loginname" type="text" class="inputTextNormal"  id="textfield1" /></td>
            <th align="right">姓名：</th>
            <td><input name="name" type="text" class="inputTextNormal" id="textfield2" /></td>
            <th align="right">
				<input type="submit" id="queryBtn" class="btnShort" value="检索" />
			</th>
        </tr>
       	
    </table>


    <!--//commonTableSearch-->
    
	<input type="button" class="btnNormal" value="新增用户" onclick="location.href='${pageContext.request.contextPath }/page/system/user/useradd'"/>	

	<br>

    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
        <tr>
            <th>序号</th>
            <th>用户姓名</th>
            <th>用户名</th>
            <th>最近登录时间</th>
            <th class="editColDefault">操作</th>
        </tr>
        <c:forEach items="${userList }" var="user" varStatus="c">
        <tr>
            <td align="center">${c.count }</td>
            <td align="center">${user.name }</td>
            <td align="center">${user.loginname }</td>
			<td align="center"><fmt:formatDate value="${user.logintime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td align="center">
            	<a href="${pageContext.request.contextPath }/page/system/user/useredit?userid=${user.userID}" class="btnIconEdit" title="更新"></a>
                <a href="${pageContext.request.contextPath }/page/system/user/userdelete?userid=${user.userID}" class="btnIconDel" title="删除"></a>
            </td>
        </tr>
        </c:forEach>
              
  </table>
    <!--//commonTable-->
    <div id="pagelist">
    	<ul class="clearfix">
        	   
 <li><a href="userlist?page=${page.firstPage}" id="first">首页</a></li>
            <li ><a href="userlist?page=${page.prePage}" id="up">上页</a></li>
            <li><a href="userlist?page=${page.nextPage}" id="down">下页</a></li>
            <li class="current"><input type="text" id="num" name="pageNo" value="${page.pageNum }" style="text-align:right" size="1"></li>
            <li><a href="userlist?page=${page.firstPage}" id="jump">跳转</a></li>
            <li><a href="userlist?page=${page.lastPage}" id="last">尾页</a></li>
            <li class="pageinfo">第${page.pageNum }页</li>
            <li class="pageinfo">共${page.pages}页</li>
        </ul>
    </div>
    </form>
</div>
<!--//content pages wrap-->
</body>
</html>
