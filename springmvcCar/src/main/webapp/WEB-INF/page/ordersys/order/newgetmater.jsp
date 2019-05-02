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
		 $("#jump").attr("href","partsreplist?page="+num)
	  }); 
	  
$("#sub").click(function(){
			var chk_value =[]; 
		    $('input[name="partsid"]:checked').each(function(){ 
		        chk_value.push($(this).val()); 
		    }); 
		    if(chk_value.length==0)
		    	alert("请选择原料！")
		    else
			$("#form1").submit();
		});

	  
});


var obj = window.dialogArguments;

function loadForm()
{
	document.forms[1].CZType.value = obj[0];
}


function checkAll(){
	var form = document.forms[1];
	var checkObj = form.ids;
	var ids = form.partsid;
	for(var i=0;i<ids.length;i++){
		ids[i].checked = checkObj.checked;
	}
}

function catchValues(){
	var form = document.forms[1];
	var ids = form.id;
	var flag = false;
	var ary = [];
	for(var i=0;i<ids.length;i++){
		if(ids[i].checked){
			flag = true;
			ary.push(ids[i].value);
		}
	}

	if(!flag){
		alert("请选择原料！");
		return ;
	}
	window.returnValue = ary;
	window.close();
}

</script>
<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt; 订单管理&nbsp;&gt;&gt;&nbsp;配件选择列表</h2>
	</div>
	<form id="form-search" name="form-search" action="searchmater?orderid=${orderid }" method="post">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
	        <tr>
	            <th align="right">配件名称：</th>
	            <td ><input name="partsname" type="text" class="inputTextNormal" id="textfield" /></td>
				<td width="150" align="" >
					<input type="submit" value="  检    索    "/>
				</td>
				<td></td>
	        </tr>
    	</table>
    </form>
    <!--//commonTableSearch-->
    <div class="btnBar">
    	<ul class="clearfix">
        	<li><a href="javascript:void()" title="确定" class="btnLong" id="sub">确定</a></li>
        	<li><a href="javascript:window.history.go(-1)" title="关闭" class="btnLong">关闭</a></li>
        </ul>
    </div>
    <form action="assemblelist?orderid=${orderid }" name="listForm" method="post" id="form1">
	    <table width="101%" border="0" cellpadding="0" cellspacing="1" class="commonTable">
	        <tr>
	            <th>
	            	<input type="checkbox" name="ids" onclick="checkAll();">
	            </th>
	            <th>配件名称</th>
	            <th>配件库存</th>
	        </tr>
             <c:forEach items="${list }" var="m">
               <tr>
		            <td align="center" style="width:5%">
		            	<input type="checkbox" name="partsid" value="${m.PartsId }" >
		            </td>
		            <td align="center">${m.partsname }</td>
		            <td align="center">${m.PartsReqCount }</td>
		        </tr>
             </c:forEach>    
	  </table>
  </form>
    <!--//commonTable-->
    <div id="pagelist">
    	<ul class="clearfix">
        	<li><a href="getmater?page=${page.firstPage}">首页</a></li>
            <li ><a href="getmater?page=${page.prePage}">上页</a></li>
            <li><a href="getmater??page=${page.nextPage}">下页</a></li>
            <li class="current"><input type="text" value="${page.pageNum }" id="num" style="text-align:right" size="1"></li>
            <li><a href="getmater?page=${page.firstPage}" id="jump">跳转</a></li>
            <li><a href="getmater?page=${page.lastPage}">尾页</a></li>
            <li class="pageinfo">第${page.pageNum }页</li>
            <li class="pageinfo">共${page.pages}页</li>
        </ul>
    </div>
</div>
<!--//content pages wrap-->
</body>
</html>
