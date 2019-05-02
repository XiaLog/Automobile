<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
	   $("#check").change(function(){
   		var flag=$(this).val();
   		$("#type").empty();
			$("#type").append($("<option>").val("0").html("请选择"));
   		if(flag==1){
   			$("#type").append($("<option>").val("1").html("订单出库"));
   			$("#type").append($("<option>").val("2").html("调拨出库"));
   			$("#type").append($("<option>").val("3").html("其他出库"));
   		}
   		if(flag==2){
   			$("#type").append($("<option>").val("1").html("采购入库"));
   			$("#type").append($("<option>").val("2").html("调拨入库"));
   			$("#type").append($("<option>").val("3").html("其他入库"));
   		}
   	});
	   
	   $("#s").click(function(){
		  $("#coursesCreat").submit();
	   });
   });
</script>

<body class="content-pages-body">
<div class="content-pages-wrap">
    <div class="commonTitle">
        <h2>&gt;&gt; 配件出入库</h2>
  </div>
        <form id="coursesCreat" name="coursesCreat" action="save" method="post">
		  <table border="0" cellspacing="1" cellpadding="0" height="70" class="commonTable">
			  <tr>
				<td width="10%" align="right" class="title"><span class="required">*</span>类型：</td>
				<td width="15%" align="left">
					<select style="width:150px;" id="check" name="choose">
						<option value="0">请选择</option>
						<option value="1">出</option>
						<option value="2">入</option>
					</select>
				</td>
				<td width="10%" align="right" class="title"><span class="required">*</span>出/入库类型：</td>
				<td width="15%" align="left">
					<select style="width:150px;" id="type">
						<option value="0">请选择</option>
					</select>
				</td>
				<td width="10%" align="right" class="title"><span class="required">*</span>出/入库日期：</td>
				<td width="15%" align="left">2011-10-30</td>
				<td width="10%" align="right" class="title"><span class="required">*</span>操作员：</td>
				<td width="15%" align="left">张三</td>
			  </tr>
			  <tr>
				<td width="10%" align="right" class="title"><span class="required">*</span>配件：</td>
				<td width="15%" align="left">
					<select style="width:150px;" name="partsid">
						<option value="0">请选择</option>
						<c:forEach items="${list }" var="n">
						  <option value="${n.PartsId }">${n.partsname }</option>
						</c:forEach>
					</select>
				</td>
				<td width="10%" align="right" class="title"><span class="required">*</span>出/入库数量：</td>
				<td width="15%" align="left">
					<input type="text" style="width:150px;height:20px" name="partsreqcount">
				</td>
				<td width="10%" align="right" class="title"><span class="required">*</span>说明：</td>
				<td width="15%" align="left" colspan="3"><input type="text" style="width:470px;height:20px"></td>
			  </tr>
		 </table>
		</form>
	 </div>
    <!--//commonTable-->
    <div id="formPageButton">
    	<ul>
			<li><a href="#" title="保存" class="btnShort" id="s">保存</a></li>
        	<li><a href="javascript:window.history.go(-1)" title="返回" class="btnShort">返回</a></li>
        </ul>
    </div>
    <!--//commonToolBar-->
</div>
<!--//content pages wrap-->
</body>
</html>
