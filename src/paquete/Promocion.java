package paquete;



public class Promocion extends Ofertable {
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

	// posiblemente no sea necesario que las promociones sepan qu� tipo de
	// promociones son

	public TipoAtraccion getTipo() {
		return tipoDePromocion;
	}

	public int getPrecio() {
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
		return "[nombre: " + nombre + ", tipo de promo: " + tipoPromo + ", atracciones:" + atracciones + "precio: " + costo + "]";
	}

}