package model;

import java.util.ArrayList;
import java.util.LinkedList;

import ofertable.Ofertable;
import varios.TipoAtraccion;

public class Usuario extends Taquilla {

	private String nombre;
	private int dineroDisponible;
	private int tiempoDisponible;
	private TipoAtraccion tipoAtraccion;
	ArrayList<Promocion> promocionesAceptadas = new ArrayList<Promocion>();
	LinkedList<Atraccion> atraccionesCompradas = new LinkedList<Atraccion>();
	ArrayList<Atraccion> atraccionesCompradasSinPromo = new ArrayList<Atraccion>();
	private int costoFinal;
	private int tiempoFinal;

	public Usuario(String nombre, int presupuesto, int tiempoEnMinutos, TipoAtraccion tipo) {
		this.nombre = nombre;
		this.dineroDisponible = presupuesto;
		this.tiempoDisponible = tiempoEnMinutos;
		this.tipoAtraccion = tipo;
	}

	public int getCostoFinal() {
		return costoFinal;
	}

	public int getTiempoFinal() {
		return tiempoFinal;
	}

	public LinkedList<Atraccion> getAtraccionesCompradas() {
		return atraccionesCompradas;
	}

	public boolean puedeComprar(Ofertable o) {
		if (dineroYTiempoSuficientes(o) && o != null) {
			return true;
		}
		return false;
	}

	public boolean atraccionYaComprada(Ofertable o) {
		if (o.esAtraccion()) {
			return atraccionesCompradas.contains(o);
		}
		if (o.esPromocion()) {
			for (Ofertable atraccion : atraccionesCompradas) {
				return o.getListaAtracciones().contains(atraccion);
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
			o.ocuparAtraccion();
			for (Atraccion atraccion : o.getListaAtracciones()) {
				atraccionesCompradas.add(atraccion);
			}
		}
		if (o.esAtraccion()) {
			contabilizarAceptado(o);
			atraccionesCompradas.add((Atraccion) o);
			atraccionesCompradasSinPromo.add((Atraccion) o);
			o.ocuparAtraccion();
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
		return nombre + ", Tipo de atraccion favorita: " + tipoAtraccion + "\nPromociones compradas:"
				+ promocionesAceptadas + "\nAtracciones sin promo compradas: " + atraccionesCompradasSinPromo
				+ "\n[Total a gastar:" + costoFinal + ", Tiempo total estimado: " + tiempoFinal + "]" + "\n\n";

	}
}
