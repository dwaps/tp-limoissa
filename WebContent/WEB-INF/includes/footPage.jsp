		<hr />
		
		<footer class="text-center">
			<p>&copy; <fmt:formatDate value="<%= new java.util.Date() %>" pattern="YYYY" /> Copyright</p>
			<a href="${adminBooksListUrl}"><img src="${logo}" alt="Logo" /></a>
		</footer>
	</div>
	
	<script src="${JQueryJS}"></script>
	<script src="${BootstrapJS}"></script>
	<c:if test="${backend}">
	<script>
		var navlink = document.querySelectorAll('.nav-link'),
			navlink = navlink[navlink.length-1];
		navlink.style.cursor = "no-drop";
	</script>
	</c:if>
	</body>
</html>