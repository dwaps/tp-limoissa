<table class="table table-hover table-striped text-center">
	<tr>
		<th>Titre</th>
		<th>Auteur</th>
		<th>Prix</th>
		<c:if test="${ backend }"><th>Action</th></c:if>
	</tr>
	<c:forEach items="${ books }" var="book">
	<tr class="main-row">
		<td>${ book.title }</td>
		<td>${ book.author }</td>
		<td>${ book.price }</td>
		<c:if test="${ backend }"><td>
			<a class="text-info ml-2" href="${ adminBooksEditUrl }?id=${ book.id }">
				<i class="mt-2 material-icons">mode_edit</i></a>
			<a class="text-info" href="${ adminBooksDeleteUrl }?id=${ book.id }">
				<i class="mt-2 material-icons">delete</i></a>
		</td></c:if>
	</tr>
	<tr class="toggle-row">
		<td colspan="4">
			<%@ include file="detail-book.jsp" %>
		</td>
	</tr>
	</c:forEach>
</table>

<script>
'use strict';

	var mainRows = document.querySelectorAll('tr.main-row');
	var toggleRows = document.querySelectorAll('tr.toggle-row');
	var isActive = [];
	
	var Dwaps = function() {
		this.init = function() {
			isActive.push(false);
		};
		this.initToggleRows = function(notThisOne) {
			toggleRows.forEach(function(row, index) {
				if (index != notThisOne) {
					row.className = 'toggle-row';
					isActive[index] = false;
				}
			});
		};
		this.toggleRows = function() {
			let THIS = this;
			this.init();
			
			toggleRows.forEach(function(row, index) {
				mainRows[index].addEventListener('click', function() {
					setTimeout(function() {
						row.className = isActive[index] ? 'toggle-row' : 'toggle-row active';
						isActive[index] = !isActive[index];
						THIS.initToggleRows(index);
					}, 100); // Delay for deleting : does not appears when delete action is called !
				});
			});
		};
		this.go = function() {
			this.toggleRows();
		};
	};
	
	(new Dwaps()).go();
</script>