<c:if test="${ backend && reload }">
	<c:redirect url="/admin/books/list" />
</c:if>

<div class="row mt-3">
<form action="" method="POST" id="book-form"></form>
	<input name="id" type="hidden" value="${book.id}" />
	
	<div class="form-group col-md-4 offset-1">
		<input name="title" type="text" value="${book.title}" placeholder="Titre" class="form-control form-control-sm" form="book-form" required />
		<br />
		<input name="author" type="text" value="${book.author}" placeholder="Auteur" class="form-control form-control-sm" form="book-form" required />
		<br />
		<input name="img" type="text" value="${book.img}" placeholder="Image" class="form-control form-control-sm" form="book-form" />
		<br />
		<input name="price" type="text" value="${book.price}" placeholder="Prix" class="form-control form-control-sm" form="book-form" required />
		<br />
		<label style="cursor:pointer">Disponible en stock ? <input name="available" type="checkbox" value="${book.available}" checked="checked" form="book-form" /></label>
	</div>
	
	<div class="form-group col-md-4 offset-1">
		<textarea name="description" placeholder="Description" cols="20" rows="5" class="form-control form-control-sm" form="book-form">${book.description}</textarea>
		<br />
		<button type="submit" class="btn btn-sm btn-info" form="book-form">Valider</button>
	</div>
</div>