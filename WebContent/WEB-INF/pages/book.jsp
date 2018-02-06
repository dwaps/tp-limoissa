<div class="row">

	<div class="col-md-6 mt-3 mb-3">
		<div class="card" style="width: 18rem;">
		  <img class="card-img-top mt-3" src="<c:url value='${book.img}'/>" alt="Image du livre">
		  <div class="card-body text-center">
		    <a href="${booksUrl}" class="btn btn-info">Retour à la liste des livres</a>
		  </div>
		</div>
	</div>
	
	<div class="col-md-6 mt-3 mb-3 text-center">
		<h3>${book.title}</h3>
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