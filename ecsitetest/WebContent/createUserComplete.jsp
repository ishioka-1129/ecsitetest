<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3;URL=home.jsp">
<link rel="stylesheet" href="./css/style.css">
<title>登録完了</title>
</head>

<body>

	<s:include value="header.jsp" />
	<div class="createUserComplete">
		<h1>登録完了画面</h1>

		<h2>ユーザー登録が完了しました。</h2>
		<br>
		<h3>3秒後にホーム画面に戻ります。</h3>

	</div>

	<s:include value="footer.jsp" />

</body>
</html>