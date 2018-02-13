<c:if test='${redirect}'>
	<c:redirect url="/admin/books/list" />
</c:if>

<form action="<c:url value='/signin'/>" method="POST">
	<input type="text" name="firstname" placeholder="firstname" />
	<input type="text" name="lastname" placeholder="lastname" />
	<input type="text" name="pseudo" placeholder="pseudo" />
	<input type="date" name="birthday" placeholder="birthday" />
	<input type="password" name="password" placeholder="password" />
	
	<br /><br />
	
	<input type="text" name="street" placeholder="street" />
	<input type="text" name="zip" placeholder="zip" />
	<input type="text" name="city" placeholder="city" />
	
	<br /><br />
	
	<input type="submit" value="Valider" />
</form>