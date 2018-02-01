<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="${homeUrl}">
  	<img src="${logo}" alt="Logo" />
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    	<c:forEach items="${tabs}" var="tab">
      <li class="nav-item">
        <a class="nav-link ${tab.active ? 'active' : ''}" href="${tab.url}">
        		${tab.label}
      	</a>
      </li>
    	</c:forEach>
    </ul>
  </div>
</nav>