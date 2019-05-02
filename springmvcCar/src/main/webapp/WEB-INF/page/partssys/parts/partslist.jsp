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
<script>
   $(function(){
	  $("#jump").click(function(){
		 var num=$("#num").val();
		 $("#jump").attr("href","partslist?page="+num)
	  }); 
   });
</script>

<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt; 配件管理</h2>
	</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
       	<form id="form-search"  action="partssearch" method="post">
        <tr>
            <th align="right">配件名称：</th>
            <td><input name="partsname" type="text" class="inputTextNormal" id="textfield2" /></td>

            <th align="right">
				<input type="submit" class="btnShort" value="检索" />
			</th>
        </tr>
       	</form>
    </table>


    <!--//commonTableSearch-->
    
	<input type="button" class="btnNormal" value="新增配件" onclick="location.href='${pageContext.request.contextPath }/page/partssys/parts/partsadd'"/>	

	<br>

    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
        <tr>
            <th>序号</th>
            <th>配件编码</th>
            <th>配件名称</th>
            <th>生产厂家</th>
            <th>生产日期</th>
            <th>备注</th>
            <th class="editColDefault">操作</th>
        </tr>
        <c:forEach items="${list }" var="p" varStatus="c">
        <tr>
            <td align="center">${c.count }</td>
            <td align="center">${p.partsid }</td>
            <td align="center">${p.partsname }</td>
            <td align="center">${p.partsloc }</td>
            <td align="center">${p.partsprodate }</td>
			<td align="center">${p.partsremark }</td>
            <td align="center">
            	
            	<a href="partsedit?partsid=${p.partsid }" class="btnIconEdit" title="更新"></a>
                <a href="partsdelete?partsid=${p.partsid }" class="btnIconDel" title="删除"></a>
            </td>
        </tr>
       </c:forEach>
        
  </table>
    <!--//commonTable-->
    <div id="pagelist">
    	<ul class="clearfix">
        	<li><a href="partslist?page=${page.firstPage}">首页</a></li>
            <li ><a href="partslist?page=${page.prePage}">上页</a></li>
            <li><a href="partslist?page=${page.nextPage}">下页</a></li>
            <li class="current"><input type="text" value="${page.pageNum }" id="num" style="text-align:right" size="1"></li>
            <li><a href="partslist?page=${page.firstPage}" id="jump">跳转</a></li>
            <li><a href="partslist?page=${page.lastPage}">尾页</a></li>
            <li class="pageinfo">第${page.pageNum }页</li>
            <li class="pageinfo">共${page.pages}页</li>
        </ul>
    </div>
</div>
<!--//content pages wrap-->
</body>
</html>