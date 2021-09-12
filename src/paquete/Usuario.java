package paquete;

import java.util.ArrayList;

public class Usuario extends Taquilla {

	private String nombre;
	private int dineroDisponible;
	private int tiempoDisponible;
	private TipoAtraccion tipoAtraccion;
	ArrayList<Promocion> promocionesAceptadas = new ArrayList<Promocion>();
	ArrayList<Atraccion> atraccionesAceptadas = new ArrayList<Atraccion>();
	private int costoFinal = dineroDisponible;
	private double tiempoFinal = tiempoDisponible;

	public Usuario(String nombre, int presupuesto, int tiempoEnMinutos, TipoAtraccion tipo) {
		this.nombre = nombre;
		this.dineroDisponible = presupuesto;
		this.tiempoDisponible = tiempoEnMinutos;
		this.tipoAtraccion = tipo;
	}

	public void aceptarOfertado(Ofertable o) {
		if (o.esPromocion()) {
			promocionesAceptadas.add((Promocion) o);
			costoFinal -= o.getCostoTotal();
					}
		if (o.esAtraccion()) {
			atraccionesAceptadas.add((Atraccion) o);
			tiempoFinal -= o.getTiempoTotal();
		}
	}

	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Usuario [nombre= " + nombre + ", Tipo de atraccion favorita= " + tipoAtraccion + ", Promociones compradas="
				+ promocionesAceptadas + ", Atracciones compradas= " + atraccionesAceptadas + ", Costo total= " + costoFinal
				+ ", Tiempo estimado= " + tiempoFinal + "]";
	}
	
}
