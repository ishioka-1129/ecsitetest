<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>ログイン</title>

<script>
function goLoginAction(){
	document.getElementById("form").action="LoginAction";
}
function goCreateUserAction(){
	document.getElementById("form").action="CreateUserAction";
}
function goResetPasswordAction(){
	document.getElementById("form").action="ResetPasswordAction";
}
</script>

</head>

<body>

	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>ログイン画面</h1>
	<s:form id="form" action="LoginAction">
		<table class="login-table">
		<tr>
			<td>
			<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.loginIdErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
			</s:if>
			<s:if test="!#session.passwordErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
					<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
		<tr>
			<th scope="row"><s:label value="ログインID:"/></th>
			<s:if test="#session.savedLoginId==true">
			<td><s:textfield name="loginId" class="txt" placeholder="ログインID" value='%{#session.loginId}' autocomplete="off"/></td>
			</s:if>
			<s:else>
			<td><s:textfield name="loginId" class="txt" placeholder="ログインID" autocomplete="off"/></td>
			</s:else>
		</tr>
		<tr>
			<th scope="row"><s:label value="パスワード:"/></th>
			<td><s:password name="password" class="txt" placeholder="パスワード" autocomplete="off"/></td>
		</tr>
		<tr>
			<td>
			<s:if test="#session.savedLoginId==true">
				<s:checkbox name="savedLoginId" checked="checked"/>
			</s:if>
			<s:else>
				<s:checkbox name="savedLoginId"/>
			</s:else>
			<s:label value="ログインID保存"/><br>
			</td>
		</tr>
		<tr>
			<th><div class="aaa"><s:submit value="ログイン" class="submit_btn" onclick="goLoginAction();"/></div>
		</th>
		</table>
	</s:form>
	<br>

	<div class="submit_btn_box">
	<div id="contents-btn-set">
		<s:form action="CreateUserAction">
			<s:submit value="新規ユーザー登録" class="submit_btn" />
		</s:form>
	</div>
	</div>

	<div class="submit_btn_box">
	<div id="contents-btn-set">
		<s:form action="ResetPasswordAction">
			<s:submit value="パスワード再設定" class="submit_btn" />
		</s:form>
	</div>
	</div>
	</div>

	<s:include value="footer.jsp"/>

</body>
</html>