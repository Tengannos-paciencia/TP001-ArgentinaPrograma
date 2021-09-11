package paquete;

public class Atraccion extends Ofertable {
	private String nombre;
	private TipoAtraccion tipo;
	private double tiempo;
	private double tiempoTotal;
	private int costo;
	private int cupo;

	public Atraccion(String nombre, int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.costo = costo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoAtraccion getTipo() {
		return this.tipo;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	@Override
	public double getTiempoTotal() {
		return tiempoTotal;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public void setTiempoTotal() {
		for (Atraccion atraccion : atracciones) {
			this.tiempoTotal += atraccion.getTiempo();
		}
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
		return "Atraccion [nombre: " + nombre + ", costo: " + costo + " monedas de oro" + ", tiempo: " + tiempo
				+ " horas" + ", cupo: " + cupo + ", tipo: " + tipo + "]";
	}
}
