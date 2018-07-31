<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品リスト</title>
</head>

<body>

	<jsp:include page="header.jsp"/>

	<div class="contents">
		<s:if test="productInfoDTOList == null">
			<s:if test="!#session.keywordsErrorMessageList.isEmpty()">
				<s:iterator value="#session.keywordsErrorMessageList"><s:property /></s:iterator>
			</s:if>
			<s:else>
			<div class="info">
				検索結果がありません。
			</div>
			</s:else>
		</s:if>

		<s:else>
			<div class="top">
				<h1>商品一覧</h1>
			</div>

				<div class="pager-top">
					<s:if test="#session.hasPreviousPage">
						<div id="num"><a href='<s:url action="SearchItemAction">
						<s:param name="pageNo" value="#session.previousPageNo" />
						<s:param name='categoryId' value='%{categoryId}'/><s:param name='keywords' value='%{keywords}'/>
						</s:url>' class="font">&laquo;</a></div>
					</s:if>

					<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
						<s:if test="#session.currentPageNo == #pageNo.count">
							<div id="num"><s:property value="%{#pageNo.count}"/></div>
						</s:if>
						<s:else>
							<div id="num"><a href="<s:url action='SearchItemAction'><s:param name='pageNo' value='%{#pageNo.count}'/>
							<s:param name='categoryId' value='%{categoryId}'/><s:param name='keywords' value='%{keywords}'/></s:url>" class="font"><s:property value="%{#pageNo.count}"/></a></div>
						</s:else>
					</s:iterator>

					<s:if test="#session.hasNextPage">
						<div id="num"><a href='<s:url action="SearchItemAction">
						<s:param name="pageNo" value="#session.nextPageNo" />
						<s:param name='categoryId' value='%{categoryId}'/><s:param name='keywords' value='%{keywords}'/>
						</s:url>' class="font">&raquo;</a></div>
					</s:if>
				</div>

				<div class="flexbox">
				<s:iterator value="#session.productInfoDTOList">
					<div class="productList-box">
						<ul>
							<li>
								<a href='<s:url action="ProductDetailsAction"><s:param name="productId" value="%{productId}"/></s:url>'>
									<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'/>
								</a><br>
								<s:property value="productName"/><br>
								<s:property value="productNameKana"/><br>
								<s:property value="price"/>円<br>
							</li>
						</ul>
					</div>
				</s:iterator>
				</div>

				<div class="pager-bottom">

					<s:if test="#session.hasPreviousPage">
						<div id="num"><a href='<s:url action="SearchItemAction">
						<s:param name="pageNo" value="#session.previousPageNo" />
						<s:param name='categoryId' value='%{categoryId}'/><s:param name='keywords' value='%{keywords}'/>
						</s:url>'>&laquo;</a></div>
					</s:if>

					<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
						<s:if test="#session.currentPageNo == #pageNo.count">
							<div id="num"><s:property value="%{#pageNo.count}"/></div>
						</s:if>
						<s:else>
							<div id="num"><a href="<s:url action='SearchItemAction'><s:param name='pageNo' value='%{#pageNo.count}'/>
							<s:param name='categoryId' value='%{categoryId}'/><s:param name='keywords' value='%{keywords}'/></s:url>"><s:property value="%{#pageNo.count}"/></a></div>
						</s:else>
					</s:iterator>

					<s:if test="#session.hasNextPage">
						<div id="num"><a href='<s:url action="SearchItemAction">
						<s:param name="pageNo" value="#session.nextPageNo" />
						<s:param name='categoryId' value='%{categoryId}'/><s:param name='keywords' value='%{keywords}'/>
						</s:url>'>&raquo;</a></div>
					</s:if>
				</div>
		</s:else>
	</div>
	<div class="clearfix"></div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>