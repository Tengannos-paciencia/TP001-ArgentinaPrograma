<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="partials/nav1.jsp"></jsp:include>
	<jsp:include page="partials/nav.jsp"></jsp:include>

	<main class="container">
		<div class="bg-dark p-4 rounded letrasDelLogin">
			<h1>
				<c:out value="${user.nombre}" />
			</h1>
			
			<jsp:include page="partials/carrousel.jsp"></jsp:include>
			
		</div>
	</main>
	
	<jsp:include page="partials/footer.jsp"></jsp:include>
</body>
</html>
