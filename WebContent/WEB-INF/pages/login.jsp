<c:if test='${redirect}'>
	<c:redirect url="/admin/books/list" />
</c:if>

<form action="<c:url value='/login'/>" method="POST">
	<input type="text" name="pseudo" placeholder="pseudo" />
	<input type="password" name="password" placeholder="password" />
	
	<br /><br />
	
	<input type="submit" value="Valider" />
</form>