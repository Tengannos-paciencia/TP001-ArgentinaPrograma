package model;

import java.util.ArrayList;
import java.util.List;



public abstract class Promocion extends Ofertable {
	protected Integer id;
	protected List<Atraccion> atracciones;
	protected String nombre;
	protected Integer tipoDePromocion; // terror, audiovisual, exploracion
	protected Integer costo;
	protected String tipoPromo; // absoluta, porcentual, AxB --> en BD aparece como "tipoDeDescuento"
	protected Integer costoTotal;
	protected Integer tiempoTotal;

	public Promocion() {
	}

	public Promocion(String nombre, List<Atraccion> atracciones, int tipo) {
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setTipoDePromocion();
		this.setCostoTotal();
		this.setTiempoTotal();
		this.setCosto();
	}

	public Promocion(int id, String nombre, List<Atraccion> atracciones, int tipo, String tipoPromo) {
		this.id = id;
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setTipoDePromocion();
		this.setCostoTotal();
		this.setTiempoTotal();
		this.tipoPromo = tipoPromo;
		this.setCosto();
	}
	
	

	public Promocion(Integer id, String nombre, String tipoPromo/*promo*/, Integer tipoDePromocion/* atracciones*/ ) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoDePromocion = tipoDePromocion; //es el tipo de las atracciones
		this.tipoPromo = tipoPromo; //categoria de la promocion
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public Integer getTipoDePromocion() {
		return tipoDePromocion;
	}

	public void setTipoDePromocion(Integer tipoDePromocion) {
		this.tipoDePromocion = tipoDePromocion;
	}

	public String getTipoPromo() {
		return tipoPromo;
	}

	public void setTipoPromo(String tipoPromo) {
		this.tipoPromo = tipoPromo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public void setCostoTotal(Integer costoTotal) {
		this.costoTotal = costoTotal;
	}

	public void setTiempoTotal(Integer tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

	public int getTipo() {
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
		this.tipoDePromocion = atracciones.get(0).getTipo();
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
			int idAtraccion = atraccion.getID();
			lista.add(obtenerAtraccionPorIdAtraccion(idAtraccion));
		}
		return lista;
	}

	public Atraccion obtenerAtraccionPorIdAtraccion(int id) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getID() == id) {
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
	public int getID() {
		return this.id;
	}
}
