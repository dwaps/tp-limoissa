<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="${GoogleMaterialIcons}"
      rel="stylesheet">
		<link rel="stylesheet" href="${BootstrapCSS}" />
		<link rel="stylesheet" href="${customStyleCSS}" />
		<title>${title}</title>
	</head>
	
	<body>
	
		<div class="container-fluid">
		
		<%@ include file="navbar.jsp" %>
		
		<c:choose>
			<c:when test="${ !empty user }">
				<p>Bienvenue ${ user.firstname } !</p>
				<p><a href="<c:url value='/logout' />">Se déconnecter</a></p>
			</c:when>
			<c:otherwise>
				<p>
					<a href="<c:url value='/signin' />">S'inscrire</a>
					<a href="<c:url value='/login' />">Se connecter</a>
				</p>
			</c:otherwise>
		</c:choose>