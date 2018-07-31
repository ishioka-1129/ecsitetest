<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>宛先情報確認</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>宛先情報確認画面</h1>
		<s:form action="CreateDestinationCompleteAction">
			<!-- <p>以下の内容で登録します</p> -->
			<table class="destination-table">
				<tr>
					<th scope="row" class="tag2"><s:label value="姓 : " /></th>
					<td><s:property value="familyName" /><s:hidden name="familyName" value="%{familyName}"/></td>
					<th scope="row" class="tag2"><s:label value="名 : " /></th>
					<td><s:property value="firstName" /><s:hidden name="firstName" value="%{firstName}"/></td>
				</tr>
				<tr>
					<th scope="row" class="tag2"><s:label value="せい : " /></th>
					<td><s:property value="familyNameKana" /><s:hidden name="familyNameKana" value="%{familyNameKana}"/></td>
					<th scope="row" class="tag2"><s:label value="めい : " /></th>
					<td><s:property value="firstNameKana" /><s:hidden name="firstNameKana" value="%{firstNameKana}"/></td>
				</tr>
				<tr>
					<th scope="row" class="tag2"><s:label value="性別 : " /></th>
					<td><s:property value="sex" /><s:hidden name="sex" value="%{sex}"/></td>
				</tr>
				<tr>
					<th scope="row" class="tag2"><s:label value="住所 : " /></th>
					<td><s:property value="userAddress" /><s:hidden name="userAddress" value="%{userAddress}"/></td>
				</tr>
				<tr>
					<th scope="row" class="tag2"><s:label value="電話番号 : " /></th>
					<td><s:property value="telNumber" /><s:hidden name="telNumber" value="%{telNumber}"/></td>
				</tr>
				<tr>
					<th scope="row" class="tag2"><s:label value="メールアドレス : " /></th>
					<td><s:property value="email" /><s:hidden name="email" value="%{email}"/></td>
				</tr>
			</table>

			<div class="submit_btn_boxa">
				<div id=".contents-btn-set">
					<s:submit value="登録" class="submit_btn" />
				</div>
			</div>
		</s:form>

		<s:form action="CreateDestinationAction">
			<div class="submit_btn_boxb">
				<div id=".contents-btn-set">
					<s:submit value="戻って修正する" class="submit_btn"/>
					<s:hidden name="familyName" value="%{familyName}" />
					<s:hidden name="firstName" value="%{firstName}" />
					<s:hidden name="familyNameKana" value="%{familyNameKana}" />
					<s:hidden name="firstNameKana" value="%{firstNameKana}" />
					<s:hidden name="email" value="%{email}" />
					<s:hidden name="telNumber" value="%{telNumber}" />
					<s:hidden name="userAddress" value="%{userAddress}" />
					<s:hidden name="sex" value="%{sex}" />
				</div>
			</div>
		</s:form>
	</div>
	<s:include value="footer.jsp" />
</body>

</html>