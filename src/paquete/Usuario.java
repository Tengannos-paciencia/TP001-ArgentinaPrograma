package paquete;

import java.util.ArrayList;
import java.util.Arrays;

public class Usuario extends Taquilla {

	private String nombre;
	private int dineroDisponible;

	private int tiempoDisponible;

	private TipoAtraccion tipoAtraccion;
	ArrayList<Promocion> promocionesAceptadas = new ArrayList<Promocion>();
	ArrayList<Atraccion> atraccionesAceptadas = new ArrayList<Atraccion>();
	private int costoFinal;
	private int tiempoFinal;

	public Usuario(String nombre, int presupuesto, int tiempoEnMinutos, TipoAtraccion tipo) {
		this.nombre = nombre;
		this.dineroDisponible = presupuesto;
		this.tiempoDisponible = tiempoEnMinutos;
		this.tipoAtraccion = tipo;
	}

	public boolean puedeComprar(Ofertable o) {
		if (dineroYTiempoSuficientes(o) && o != null) {
			return true;
		}
		return false;
	}

	public boolean atraccionYaComprada(Ofertable o) {
		if (o.esAtraccion()) {
			return atraccionesAceptadas.contains(o);
		}
		if (o.esPromocion()) {
			for (Ofertable atraccion : atraccionesAceptadas) {
				return o.getListaAtracciones().contains(atraccion);
			}

		}
		return false;
	}

	private boolean dineroYTiempoSuficientes(Ofertable o) {
		if (o == null) {
			return false;
		}
		return dineroDisponible > o.getCostoTotal() && tiempoDisponible > o.getTiempoTotal();
	}

	public void aceptarOfertado(Ofertable o) {
		if (o.esPromocion()) {
			promocionesAceptadas.add((Promocion) o);
			contabilizarAceptado(o);
			
		}
		if (o.esAtraccion()) {
			atraccionesAceptadas.add((Atraccion) o);
			contabilizarAceptado(o);
		}
	}

	private void contabilizarAceptado(Ofertable o) {

		dineroDisponible -= o.getCostoTotal();
		tiempoDisponible -= o.getTiempoTotal();
		tiempoFinal += o.getTiempoTotal();
		costoFinal += o.getCostoTotal();
	}

	public int getTiempoDisponible() {
		return tiempoDisponible;
	}

	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDineroDisponible() {
		return dineroDisponible;
	}

	@Override
	public String toString() {
		return nombre + ", Tipo de atraccion favorita: " + tipoAtraccion + ", Promociones compradas:"
				+ promocionesAceptadas + ", Atracciones compradas: " + atraccionesAceptadas + ", Costo total: "
				+ costoFinal + ", Tiempo estimado: " + tiempoFinal + "\n";
	}

}
