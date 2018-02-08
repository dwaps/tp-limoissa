<div class="row">
	<div class="col-md-6">
		<div class="card mx-auto" style="width: 18rem;">
		  <img class="card-img-top mt-3" src="<c:url value='${book.img}'/>" alt="Image du livre">
		  <div class="card-body text-center">
		    <a href="" class="btn btn-info"><i class="mt-2 material-icons">share</i></a>
		  </div>
		</div>
	</div>
	<div class="col-md-6 mt-3 book-detail text-center mx-auto">
		<h3 class="book-title">${book.title}</h3>
		<p>
			<strong>Résumé :</strong><br />
			${book.description}
		</p>
		<p>
			<strong>Auteur :</strong> ${book.author}
			<br />
			<strong>Prix :</strong> ${book.price}
		</p>
		<c:if test="${book.available}"><div class="badge badge-success">Disponible</div></c:if>
		<c:if test="${!book.available}"><div class="badge badge-danger">Indisponible</div></c:if>
	</div>
</div>