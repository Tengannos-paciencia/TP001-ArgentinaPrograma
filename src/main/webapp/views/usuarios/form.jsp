<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="nombre" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre"
		required value="${tmp_user.nombre}">
</div>
<div class="mb-3">
	<label for="dineroDisponible"
		class='col-form-label ${tmp_user.errors.get("dineroDisponible") != null ? "is-invalid" : "" }'>Dinero disponible:</label>
	<input class="form-control" type="number" id="dineroDisponible" name="dineroDisponible"
		required value="${tmp_user.dineroDisponible}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("dineroDisponible")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="tiempoDisponible"
		class='col-form-label ${tmp_user.errors.get("tiempoDisponible") != null ? "is-invalid" : "" }'>Tiempo disponible:</label>
	<input class="form-control" type="number" id="tiempoDisponible" name="tiempoDisponible"
		required value="${tmp_user.tiempoDisponible}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("tiempoDisponible")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="password"
		class='col-form-label ${tmp_user.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label>
	<input type="password" class="form-control" id="password" name="password"
		required value="${tmp_user.password}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("password")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="isAdmin"
		class='col-form-label ${tmp_user.errors.get("isAdmin") != null ? "is-invalid" : "" }'>Rol:</label>
		<br>
		<label for=isAdmin>Admin</label> 
		<input type="radio" id="isAdmin" name="isAdmin" value="1">
		<br>
		<label for="isAdmin">Normal</label>
		<input type="radio" id="isAdmin" name="isAdmin" value="0">
		<br>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("isAdmin")}'></c:out>
	</div>
</div>

<div class="mb-3">

	<label for="tipo" class='col-form-label ${attraction.errors.get("tipo") != null ? "is-invalid" : "" }'>Tipo de atraccion favorita:</label>

	<select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" id="tipo" name="tipo">
	  <option value="1">Terror</option> 
	  <option value="2">Audiovisual</option>
	  <option value="3">Exploracion</option>
	</select>
	
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
