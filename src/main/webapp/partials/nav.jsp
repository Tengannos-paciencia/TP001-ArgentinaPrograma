<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="bd-subnavbar py-2 navbar-expand-lg navbar-dark bg-dark" id="navFijo">
	<div class="container">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Inicio</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Atracciones</a>
				</li>
				<li class="nav-item dropdown">
					<a	class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Promos
					</a>
					
					<ul class="dropdown-menu dropdown-menu-dark"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#">Absoluta</a></li>
						<li><a class="dropdown-item" href="#">Procentual</a></li>
						<li><a class="dropdown-item" href="#">AxB</a></li>
					</ul>
				</li>
			</ul>
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<c:if test="${user.isAdmin()}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/turismo/users/index.do">Usuarios</a></li>
				</c:if>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							<c:out value="${user.nombre}"></c:out>
					</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li>
							<a class="dropdown-item disabled" style="color: black;">
								<i title="monedas" style="color: gold;" class="bi bi-coin"></i>
								<c:out value="$ ${user.dineroDisponible}"></c:out>
							</a>
						</li>
						<li>
							<a class="dropdown-item disabled" style="color: black;">
								<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i>
								<c:out value="${user.tiempoDisponible}h"></c:out>
							</a>
						</li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="logout" class="dropdown-item">Salir</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>

<c:if test="${success != null}">
	<div class="alert alert-success">
		<p>
			<c:out value="${success}" />
		</p>
	</div>
</c:if>
