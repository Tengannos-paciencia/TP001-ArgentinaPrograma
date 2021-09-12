package paquete;

import java.util.ArrayList;
import java.util.List;

public class Promocion extends Ofertable {
	protected List<Atraccion> atracciones = new ArrayList<Atraccion>();
	protected String nombre;
	protected TipoAtraccion tipoDePromocion;
	protected int precio;
	protected String tipoPromo;

	public Promocion() {
	}

	public Promocion(String nombre, List<Atraccion> atracciones, TipoAtraccion tipo) {
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setTipoDePromocion();
		this.setCostoTotal();
		this.setTiempoTotal();
	}

	public Promocion(String nombre, List<Atraccion> atracciones, TipoAtraccion tipo, String tipoPromo) {
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setTipoDePromocion();
		this.setCostoTotal();
		this.setTiempoTotal();
		this.tipoPromo = tipoPromo;
	}

	// posiblemente no sea necesario que las promociones sepan qué tipo de
	// promociones son
	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoAtraccion getTipo() {
		return tipoDePromocion;
	}

	public int getPrecio() {
		return precio;
	}

	@Override
	public int getCostoTotal() {
		return costoTotal;
	}

	@Override
	public double getTiempoTotal() {
		return tiempoTotal;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected void setTipoDePromocion() {
		this.tipoDePromocion = atracciones.get(0).getTipo();
	}

	public void setPrecio() {
		for (Atraccion atraccion : atracciones) {
			this.precio += atraccion.getCosto();
		}
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
}