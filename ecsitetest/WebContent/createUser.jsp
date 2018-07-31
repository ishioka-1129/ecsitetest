<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>新規ユーザー登録</title>
</head>

<body>
<s:include value="header.jsp" />

	<div class="contents">

	<h1>ユーザー情報入力画面</h1>

	<s:form action="CreateUserConfirmAction">
		<table class="createUser-table">

			<s:if test="!#session.family_nameErrorMessageList.isEmpty()">
				<tr>
					<td colspan="4">
						<div class="error-message">
						<s:iterator value="#session.family_nameErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
						</div>
					</td>
				</tr>
			</s:if>
			<s:if test="!#session.first_nameErrorMessageList.isEmpty()">
				<tr>
					<td colspan="4">
						<div class="error-message">
							<s:iterator value="#session.first_nameErrorMessageList">
								<s:property />
								<br>
							</s:iterator>
						</div>
					</td>
				</tr>
			</s:if>
			<tr>
				<th scope="row" class = "tag">姓：</th>
				<td><s:textfield name="familyName"
						value="%{familyName}" label="姓" placeholder="姓"
						class="txt" /></td>
				<th scope="row" class = "tag">名：</th>
				<td><s:textfield name="firstName"
						value="%{firstName}" label="名" placeholder="名"
						class="txt" /></td>
			</tr>
			<s:if test="!#session.family_name_kanaErrorMessageList.isEmpty()">
				<tr>
					<td colspan="4">
						<div class="error-message">
							<s:iterator value="#session.family_name_kanaErrorMessageList">
								<s:property />
								<br>
							</s:iterator>
						</div>
					</td>
				</tr>
			</s:if>

			<!-- first_name_kanaが空欄の場合にエラーをだす -->
			<s:if test="!#session.first_name_kanaErrorMessageList.isEmpty()">
				<tr>
					<td colspan="4">
						<div class="error-message">
							<s:iterator value="#session.first_name_kanaErrorMessageList">
								<s:property />
								<br>
							</s:iterator>
						</div>
					</td>
				</tr>
			</s:if>
			<tr>
				<th scope="row" class = "tag">せい：</th>
				<td><s:textfield name="familyNameKana"
						value="%{familyNameKana}" label="せい"
						placeholder="せい" class="txt" /></td>
				<th scope="row" class = "tag">めい：</th>
				<td><s:textfield name="firstNameKana"
						value="%{firstNameKana}" label="めい"
						placeholder="めい" class="txt" /></td>
			</tr>
			<tr>
				<th scope="row" class = "tag">性別：</th>
				<td><s:radio name="sex" list="%{#session.sexList}"
						value="%{#session.sex}" label="性別" placeholder="性別" /></td>
			</tr>
			<s:if test="!session.emailErrorMessageList.isEmpty()">
				<tr>
					<td colspan="4">
						<div class="error-message">
							<s:iterator value="#session.emailErrorMessageList">
								<s:property />
								<br>
							</s:iterator>
						</div>
					</td>
				<tr>
			</s:if>
			<tr>
				<th scope="row" class = "tag">メールアドレス：</th>
				<td><s:textfield name="email" value="%{email}"
						label="メールアドレス" placeholder="メールアドレス" class="txt" /></td>
			</tr>
			<s:if test="!#session.user_idErrorMessageList.isEmpty()">
				<tr>
					<td colspan="4">
						<div class="error-message">
							<s:iterator value="#session.user_idErrorMessageList">
								<s:property />
								<br>
							</s:iterator>
						</div>
					</td>
				</tr>
			</s:if>
			<s:if test="session.containsKey('UserIdCheckError')">
				<tr>
					<td colspan="4">
						<div class="error-message">
							<s:property value="#session.UserIdCheckError"/>
						</div>
					</td>
				</tr>
			</s:if>
			<tr>
				<th scope="row" class = "tag">ログインID：</th>
				<td><s:textfield name="LoginId" value="%{loginId}"
						label="ログインID" placeholder="ログインID" class="txt" /></td>
			</tr>
			<s:if test="!#session.passwordErrorMessageList.isEmpty()">
				<tr>
					<td colspan="4">
						<div class="error-message">

							<s:iterator value="#session.passwordErrorMessageList">
								<s:property />
								<br>
							</s:iterator>
						</div>
					</td>
				</tr>
			</s:if>
			<tr>
				<th scope="row" class = "tag">パスワード：</th>
				<td><s:password name="password" value="%{password}" label="パスワード"
						placeholder="パスワード" class="txt" /></td>
			</tr>
		</table>
		<div class="submit_box">
			<div class="submit_btn_box1">
				<div id=".contents-btn-set">
					<s:submit value="登録" class="submit_btn" />
				</div>
			</div>
		</div>

		</s:form>

		</div>
		<div class="clearfix"></div>

	<s:include value="footer.jsp" />

</body>
</html>