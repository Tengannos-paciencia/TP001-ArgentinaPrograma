package paquete;

import java.util.ArrayList;

public class Usuario extends Taquilla {
	
	private String nombre;
	private int dineroDisponible;
	private int tiempoDisponible;
	private TipoAtraccion tipoAtraccion;
	ArrayList<Promocion> promocionesAceptadas = new ArrayList<Promocion>();
	ArrayList<Atraccion> atraccionesAceptadas = new ArrayList<Atraccion>();
	
	
	public Usuario (String nombre, int presupuesto, int tiempoEnMinutos, TipoAtraccion tipo){
		this.nombre = nombre;
		this.dineroDisponible = presupuesto; 
		this.tiempoDisponible = tiempoEnMinutos;
		this.tipoAtraccion = tipo;
	}
	
	
	private int costoFinal;
	private double tiempoFinal;

	public void aceptarOfertado(Ofertable o) {
	}

}
