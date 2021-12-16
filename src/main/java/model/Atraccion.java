package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Atraccion extends Ofertable{
	protected Integer id;
	protected String nombre;
	protected Integer tipoDeAtraccion;
	protected Integer tiempoEnMinutos;
	protected Integer costo;
	protected Integer cupo;
	protected String descripcion;
	
	private Map<String, String> errors;
	
	
	public Atraccion(Integer id, String nombre, Integer costo, Integer tiempo, Integer cupo, Integer tipo, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.tiempoEnMinutos = tiempo;
		this.costo = costo;
		this.cupo = cupo;
		this.tipoDeAtraccion = tipo;
		this.descripcion = descripcion;
	}	
	
	public Atraccion(String nombre, Integer costo, Integer tiempo, Integer cupo, Integer tipo, String descripcion) {
		
		this.nombre = nombre;
		this.tiempoEnMinutos = tiempo;
		this.costo = costo;
		this.cupo = cupo;
		this.tipoDeAtraccion = tipo;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getTipo() {
		return this.tipoDeAtraccion;
	}

	public int getTiempo() {
		return this.tiempoEnMinutos;
	}

	public int getCosto() {
		return this.costo;
	}

	@Override
	public int getCostoTotal() {
		return getCosto();
	}

	public int getCupo() {
		return this.cupo;
	}

	public void ocuparAtraccion() {
		this.cupo--;
	}

	public boolean cupoDisponible() {
		if (this.getCupo() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void setTiempoTotal() {

	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	@Override
	public void setCostoTotal() {
	}

	@Override
	public String toString() {

		return "[" + nombre + ", costo: " + costo + " monedas, tiempo: " + tiempoEnMinutos + " minutos, cupo: " + cupo
				+ ", tipo: " + this.nombreTipo() + "]\n";
	}

	@Override
	public List<Atraccion> getAtracciones() {
		return null;

	}

	@Override
	public int getTiempoTotal() {
		return getTiempo();
	}

	@Override
	public List<Atraccion> getListaAtracciones() {
		return null;
	}
	
	public int getID() {
		return this.id;
	}

	public String nombreTipo() {
		switch (this.tipoDeAtraccion) {
		case 1: {
			return "TERROR";
		}
		case 2: {
			return "AUDIOVISUAL";
		}
		case 3: {
			return "EXPLORACION";
		}

		}
		return null;
	}
	public List<Atraccion> getAtraccionesPorId(int id){
		
		List<Atraccion> atraccionesPorId = new ArrayList<Atraccion>();
		
		for (Atraccion atraccion : atracciones) {
			if(atraccion.getID() == id) {
				atraccionesPorId.add(atraccion);
			}
		}
		return atraccionesPorId;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (costo <= 0) {
			errors.put("costo", "Debe ser positivo"); //costo pertenece al formulario creo, verificar
		}
		if (tiempoEnMinutos <= 0) { 
			errors.put("tiempo", "Debe ser positivo"); //tiempo pertenece al formulario creo, verificar
		}
		if (tiempoEnMinutos > 60) {
			errors.put("tiempo", "Excede el tiempo máximo"); //tiempo pertenece al formulario creo, verificar
		}
		if (cupo <= 0) {
			errors.put("cupo", "Debe ser positivo"); //cupo pertenece al formulario creo, verificar
		}
		if (tipoDeAtraccion < 0 || tipoDeAtraccion >3) {
			errors.put("tipo", "Debe ser tipo 1, 2, o 3"); //tipo pertenece al formulario creo, verificar
		}
		if (descripcion == "") {
			errors.put("descripcion", "Debe ingresar una descripcion"); //descripcion pertenece al formulario creo, verificar
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipoDeAtraccion(int tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	public void setTiempoEnMinutos(int tiempoEnMinutos) {
		this.tiempoEnMinutos = tiempoEnMinutos;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}
	
	
	
}
