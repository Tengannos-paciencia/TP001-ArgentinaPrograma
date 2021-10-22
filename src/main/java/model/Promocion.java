package model;

import java.util.ArrayList;
import java.util.List;

import ofertable.Ofertable;
import varios.TipoAtraccion;

public abstract class Promocion extends Ofertable {
	protected Atraccion[] atracciones;
	protected String nombre;
	protected TipoAtraccion tipoDePromocion;
	protected int costo;
	protected String tipoPromo;
	protected int costoTotal;
	protected int tiempoTotal;

	public Promocion() {
	}

	public Promocion(String nombre, Atraccion[] atracciones, TipoAtraccion tipo) {
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setTipoDePromocion();
		this.setCostoTotal();
		this.setTiempoTotal();
		this.setCosto();
	}

	public Promocion(String nombre, Atraccion[] atracciones, TipoAtraccion tipo, String tipoPromo) {
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setTipoDePromocion();
		this.setCostoTotal();
		this.setTiempoTotal();
		this.tipoPromo = tipoPromo;
		this.setCosto();
	}

	public TipoAtraccion getTipo() {
		return tipoDePromocion;
	}

	public boolean cupoDisponible() {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getCupo() > 0) {
				return true;
			}
		}
		return false;
	}

	public int getCosto() {
		return costo;
	}

	@Override
	public int getCostoTotal() {
		return costoTotal;
	}

	@Override
	public int getTiempoTotal() {
		return tiempoTotal;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected void setTipoDePromocion() {
		this.tipoDePromocion = atracciones[0].getTipo();
	}

	public void setCosto() {
		for (Atraccion atraccion : atracciones) {
			this.costo += atraccion.getCosto();
		}
	}

	public void ocuparAtraccion() {
		for (Atraccion atraccion : atracciones) {
			atraccion.cupo--;
		}
	}

	public List<Atraccion> getListaAtracciones() {
		ArrayList<Atraccion> lista = new ArrayList<Atraccion>();

		for (Atraccion atraccion : atracciones) {
			String nombreAtraccion = atraccion.getNombre();
			lista.add(obtenerAtraccionPorNombreAtraccion(nombreAtraccion));
		}
		return lista;
	}

	public Atraccion obtenerAtraccionPorNombreAtraccion(String nombreAtraccion) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombreAtraccion)) {
				return atraccion;
			}
		}
		return null;
	}

	@Override
	public void setCostoTotal() {
	}

	@Override
	public void setTiempoTotal() {
		for (Atraccion atraccion : atracciones) {
			this.tiempoTotal += atraccion.getTiempo();
		}
	}

	@Override
	public String toString() {
		return "[nombre: " + nombre + ", atracciones:" + atracciones + "precio: " + costo + "]";
	}

	@Override
	public int getTiempo() {
		return tiempoTotal;

	}

}