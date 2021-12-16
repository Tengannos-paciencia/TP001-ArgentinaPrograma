package model;

import java.util.Collections;
import java.util.List;

import filters.ComparadorDeOfertables;



public class Taquilla {

	private List<Promocion> promociones;
	private List<Usuario> usuarios;
	private List<Atraccion> atracciones;

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public List<Promocion> getPromociones() {
		return promociones;

	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void agregarTodasLasAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public void agregarTodasLasPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	public void agregarTodosLosUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Atraccion obtenerAtraccionPorTipo(int tipo) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getTipo() == tipo) {
				return atraccion;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Parque del Terror [atracciones=" + atracciones + ", promociones=\n"
				+ promociones + ", usuarios=\n" + usuarios + "]";
	}

	public Atraccion obtenerAtraccionPorNombreAtraccion(String nombreAtraccion) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombreAtraccion)) {
				return atraccion;
			}
		}
		return null;
	}
	public Atraccion obtenerAtraccionPorIDAtraccion(int id) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getID() == id) {
				return atraccion;
			}
		}
		return null;
	}

	public void ordenarLasPromociones() {
		Collections.sort(this.promociones, new ComparadorDeOfertables());
	}

	public void ordenarLasAtracciones() {
		Collections.sort(this.atracciones, new ComparadorDeOfertables());
	}
}
