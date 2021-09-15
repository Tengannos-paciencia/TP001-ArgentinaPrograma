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
	Atraccion[] arrayAtraccionesAceptadas;
	private int costoFinal;
	private int tiempoFinal;
	private int cantidadAtracciones = 0;

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
		if (arrayAtraccionesAceptadas != null) {
			if (o.esAtraccion()) {
				return Arrays.asList(arrayAtraccionesAceptadas).contains(o);
			}
			if (o.esPromocion()) {
				for (Ofertable atraccion : arrayAtraccionesAceptadas) {
					return o.getListaAtracciones().contains(atraccion);
				}

			}
		}
		return false;
	}

	private boolean dineroYTiempoSuficientes(Ofertable o) {
		if (o == null) {
			return false;
		}
		return (dineroDisponible >= o.getCostoTotal() && tiempoDisponible >= o.getTiempoTotal());
	}

	public void aceptarOfertado(Ofertable o) {
		if (o.esPromocion()) {
			promocionesAceptadas.add((Promocion) o);
			contabilizarAceptado(o);
			arrayAtraccionesAceptadas = new Atraccion[o.getListaAtracciones().size() + cantidadAtracciones];
			for (int i = 0; i < o.getListaAtracciones().size(); i++) {
				arrayAtraccionesAceptadas[cantidadAtracciones + i] = o.getListaAtracciones().get(i);
				arrayAtraccionesAceptadas[cantidadAtracciones + i].cupo--;
			}

		}
		if (o.esAtraccion()) {
			arrayAtraccionesAceptadas = new Atraccion[++cantidadAtracciones];
			arrayAtraccionesAceptadas[cantidadAtracciones - 1] = (Atraccion) o;
			arrayAtraccionesAceptadas[cantidadAtracciones - 1].cupo--;
			contabilizarAceptado(o);
			atraccionesAceptadas.add((Atraccion) o);

		}
	}

	private void contabilizarAceptado(Ofertable o) {
		if (o.esPromocion()) {
			dineroDisponible -= o.getCostoTotal();
			tiempoDisponible -= o.getTiempoTotal();
			tiempoFinal += o.getTiempoTotal();
			costoFinal += o.getCostoTotal();
		}
		if (o.esAtraccion()) {
			dineroDisponible -= o.getCosto();
			tiempoDisponible -= o.getTiempo();
			tiempoFinal += o.getTiempo();
			costoFinal += o.getCosto();
		}
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
		return nombre + ", Tipo de atraccion favorita: " + tipoAtraccion + "\n" + ", Promociones compradas:"
				+ promocionesAceptadas + "\n" + ", Atracciones sin promo compradas: " + atraccionesAceptadas + "\n"
				+ " [Total a gastar:" + costoFinal + ", Tiempo total estimado: " + tiempoFinal + "]";
	}

}
