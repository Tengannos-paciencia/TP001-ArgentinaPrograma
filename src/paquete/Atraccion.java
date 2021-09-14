package paquete;

import java.util.List;

public class Atraccion extends Ofertable {
	protected String nombre;
	protected TipoAtraccion tipoDeAtraccion;
	protected int tiempoEnMinutos;
	protected int costo;
	protected int cupo;

	public Atraccion(String nombre, int costo, int tiempo, int cupo, TipoAtraccion tipo) {
		this.nombre = nombre;
		this.tiempoEnMinutos = tiempo;
		this.costo = costo;
		this.cupo = cupo;
		this.tipoDeAtraccion = tipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoAtraccion getTipo() {
		return this.tipoDeAtraccion;
	}

	public double getTiempo() {
		return this.tiempoEnMinutos;
	}

	public int getCosto() {
		return this.costo;
	}

	@Override
	public int getCostoTotal() {
		return costoTotal;
	}

	public int getCupo() {
		return this.cupo;
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

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "[" + nombre + ", costo: " + costo + " monedas" + ", tiempo: " + tiempoEnMinutos + " minutos" + ", cupo: "
				+ cupo + ", tipo: " + tipoDeAtraccion + "]";
	}

	@Override
	public List<Atraccion> getAtracciones() {
		return null;
	}

	@Override
	public int getTiempoTotal() {
		return tiempoEnMinutos;
	}
}
