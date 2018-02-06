<c:choose>
	<c:when test="${ !empty books }">
		<table class="table table-hover table-striped">
			<tr>
				<th>Titre</th>
				<th>Auteur</th>
				<th>Prix</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>
					<a href="${bookDetailUrl}">Détail</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p class="text-center m-4">Vous ne pouvez accéder au composant.</p>
	</c:otherwise>
</c:choose>