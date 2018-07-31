<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>宛先登録画面</title>
</head>

<body>
	<jsp:include page="header.jsp" />
		<div id="contents">
			<h1>宛先登録画面</h1>
			<p>商品のお届け先を入力してください</p>

			<s:form action="CreateDestinationConfirmAction">
				<table class="destinstion-table">

				<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
				<tr>
				<td colspan="4">
				<div class="error">
					<div class="error-messageA">
						<s:iterator value="#session.familyNameErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
				</td>
				</tr>
				</s:if>
				<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
				<tr>
				<td colspan="4">
				<div class="error">
					<div class="error-messageA">
						<s:iterator value="#session.firstNameErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
				</td>
				</tr>
				</s:if>
				<tr>
					<th scope="row" class="tag">姓:</th>
					<td><s:textfield name="familyName" class="txt" label="姓" value="%{familyName}"/></td>
					<th scope="row" class="tag">名:</th>
					<td><s:textfield name="firstName" class="txt" label="名" value="%{firstName}"/></td>
				</tr>
				<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
				<tr>
				<td colspan="4">
				<div class="error">
					<div class="error-messageA">
					<s:iterator value="#session.familyNameKanaErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
					</div>
				</div>
				</s:if>
				<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
				<tr>
				<td colspan="4">
				<div class="error">
					<div class="error-messageA">
						<s:iterator value="#session.firstNameKanaErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
				</td>
				</tr>
				</s:if>
				<tr>
					<th scope="row" class="tag">せい:</th>
					<td><s:textfield name="familyNameKana" class="txt" label="せい" value="%{familyNameKana}"/></td>

					<th scope="row" class="tag">めい:</th>
					<td><s:textfield name="firstNameKana" class="txt" label="めい" value="%{firstNameKana}"/></td>
				</tr>
				<tr>
					<th scope="row" class="tag">性別:</th>
					<td><s:radio name="sex" list="sexList" value="%{sex}"
							label="性別" placeholder="性別" /></td>
				</tr>
				<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
				<tr>
				<td colspan="4">
					<div class="error">
						<div class="error-messageB">
						<s:iterator value="#session.userAddressErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
						</div>
					</div>
				</td>
				</tr>
				</s:if>
				<s:if test="#session.userAddressErrorMessageList.isEmpty()">
				<tr>
				<td colspan="4">
					<div class="error-messageB">
						<s:property value="userAddressCheckError"/>
					</div>
				</td>
				</tr>
				</s:if>
				<tr>
					<th scope="row" class="tag">住所:</th>
					<td><s:textfield name="userAddress" label="住所" class="txt" value="%{userAddress}" size=""/>
					</td>
				</tr>
				<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
				<tr>
				<td colspan="4">
					<div class="error">
						<div class="error-messageB">
						<s:iterator value="#session.telNumberErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
						</div>
					</div>
				</td>
				</tr>
				</s:if>
				<tr>
					<th scope="row" class="tag">電話番号:</th>
					<td><s:textfield name="telNumber" label="電話番号" class="txt" value="%{telNumber}" size=""/>
					</td>
				</tr>
				<s:if test="!#session.emailErrorMessageList.isEmpty()">
				<tr>
				<td colspan="4">
					<div class="error">
						<div class="error-messageB">
						<s:iterator value="#session.emailErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
						</div>
					</div>
				</td>
				</tr>
				</s:if>
				<tr>
					<th scope="row" class="tag">メールアドレス:</th>
					<td><s:textfield name="email" label="メールアドレス" class="txt" value="%{email}"/>
					</td>
				</tr>
				</table>
				<div class="submit_btn_box">
					<div id=".contents-btn-set">
						<s:submit value="確認画面" class="submit_btn1" />
					</div>
				</div>
			</s:form>
		</div>

	<jsp:include page="footer.jsp" />

</body>
</html>