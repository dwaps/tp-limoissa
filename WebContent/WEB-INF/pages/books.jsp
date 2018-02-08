<c:if test="${ backend && reload }">
	<c:redirect url="/admin/books/list" />
</c:if>

<c:choose>
	<c:when test="${ !empty books }">
		<%@ include file="/WEB-INF/includes/list-books.jsp" %>
	</c:when>
	<c:when test="${ empty books }">
		<p class="text-center m-4 border p-4">Il n'y a pas de livres en base de données.</p>
	</c:when>
	<c:otherwise>
		<p class="text-center m-4 border p-4">Vous ne pouvez accéder au composant.</p>
	</c:otherwise>
</c:choose>