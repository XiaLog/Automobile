<%@ page contentType="text/html; charset=UTF-8"%>
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
		$("#editBtn").click(function(){
			coursesCreat.action="${pageContext.request.contextPath}/page/system/user/changeuser";
			var pwd1=$("#textfield1").val();
			var pwd2=$("#textfield2").val();
			if(pwd1!=pwd2){
				alert("两次密码不一致！");
				return false;
			}	
			coursesCreat.submit();
		});
	})
</script>
</head>


<body class="content-pages-body">
<div class="content-pages-wrap">
    <div class="commonTitle">
        <h2>&gt;&gt; 更改用户密码</h2>
  </div>
        <form id="coursesCreat" name="coursesCreat" method="post">
		  <table border="0" cellspacing="1" cellpadding="0" class="commonTable">
			  <tr>
				<td width="10%" align="right" class="title"><span class="required">*</span>用户姓名：</td>
				<td width="15%" align="left"><input type="text" value="${emp.name }" name="name"/></td>
				<td width="10%" align="right" class="title"><span class="required">*</span>用户名：</td>
				<td width="15%" align="left">
                <input type="text" value="${user.loginname }" name="loginname"/>
                <input type="hidden" value="${user.userid }"  name="userid"/>
				</td>
				<td width="10%" align="right" class="title"><span class="required">*</span>密码：</td>
				<td width="15%" align="left"><input name="loginpwd" type="password" class="inputTextNormal" id="textfield1" value="${user.loginpwd }" /></td>
				<td width="10%" align="right" class="title"><span class="required">*</span>确认密码：</td>
				<td width="15%" align="left">
					<input name="textfield2" type="password" class="inputTextNormal" id="textfield2" value="${user.loginpwd }" />
				</td>
			  </tr>

		 </table>
	    
		</form>
	 </div>
    <!--//commonTable-->
    <div id="formPageButton">
    	<ul>
			<li><a href="#" title="保存" id="editBtn" class="btnShort">保存</a></li>
        	<li><a href="javascript:window.history.go(-1)" title="返回" class="btnShort">返回</a></li>
        </ul>
    </div>
    <!--//commonToolBar-->
</div>
<!--//content pages wrap-->
</body>
</html>
