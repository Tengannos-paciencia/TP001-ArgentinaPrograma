<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav1.jsp"></jsp:include>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Usuarios</h1>
		</div>

		<c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nuevo Usuario
				</a>
			</div>
		</c:if>
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Dinero Disponible</th>
					<th>Tiempo Disponible</th>
					<th>Rol</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="tmp_user">
					<tr>
						<td><strong><c:out value="${tmp_user.nombre}"></c:out></strong></td>
						<td><c:out value="${tmp_user.dineroDisponible}"></c:out></td>
						<td><c:out value="${tmp_user.tiempoDisponible}"></c:out></td>
						<td>
							<c:choose>
								<c:when test="${tmp_user.isAdmin()}">
									Admin
								</c:when>
								<c:otherwise>
									Normal
								</c:otherwise>
							</c:choose>						
						</td>
						<td><c:if test="${user.isAdmin() && (!tmp_user.isAdmin() || tmp_user.id == user.id)}">
								<a href="usuarios/edit.do?id=${tmp_user.id}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="usuarios/delete.do?id=${tmp_user.id}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>