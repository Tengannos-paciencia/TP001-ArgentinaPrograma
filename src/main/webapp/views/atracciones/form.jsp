<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="nombre" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre" required
		value="${attraction.nombre}">
</div>
<div class="mb-3">
	<label for="costo"
		class='col-form-label ${attraction.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
	<input class="form-control" type="number" id="costo" name="costo"
		required value="${attraction.costo}"></input>
	<div class="invalid-feedback">
		<c:out value='${attraction.errors.get("costo")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="tiempo"
		class='col-form-label ${attraction.errors.get("tiempo") != null ? "is-invalid" : "" }'>tiempo
		en minutos:</label> <input class="form-control" type="number" id="tiempo"
		name="tiempo" required value="${attraction.tiempo}"></input>
	<div class="invalid-feedback">
		<c:out value='${attraction.errors.get("tiempo")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="cupo"
		class='col-form-label ${attraction.errors.get("cupo") != null ? "is-invalid" : "" }'>cupo:</label>
	<input class="form-control" type="number" id="cupo" name="cupo"
		required value="${attraction.cupo}"></input>
	<div class="invalid-feedback">
		<c:out value='${attraction.errors.get("cupo")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="tipo" class='col-form-label ${attraction.errors.get("tipo") != null ? "is-invalid" : "" }'>Tipo de atraccion:</label>
		<br>
		<label for="terror">Terror</label> 
		<input type="radio" id="tipo" name="tipo" value="1">
		<br>
		<label for="audiovisual">Audiovisual</label>
		<input type="radio" id="tipo" name="tipo" value="2">
		<br>
		<label for="exploracion">Exploracion</label>
		<input type="radio" id="tipo" name="tipo" value="3">
</div>
<div class="mb-3">
	<label for="descripcion" class='col-form-label ${attraction.errors.get("descripcion") != null ? "is-invalid" : "" }'>Descripcion:</label><br>
	<textarea name="descripcion" id="descripcion" rows="10" cols="50" placeholder="${ attraction.descripcion }"></textarea>
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
