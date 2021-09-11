package paquete;

public class Usuario extends Taquilla {
	
	private String nombre;
	private double dineroDisponible;
	private int tiempoDisponible;
	private TipoAtraccion tipoAtraccion;
	
	public Usuario (String nombre, double presupuesto, int tiempoEnSegundos, TipoAtraccion tipo){
		this.nombre = nombre;
		this.dineroDisponible = presupuesto; 
		this.tiempoDisponible = tiempoEnSegundos;
		this.tipoAtraccion = tipo;
	}
	
	// ArrayList<Promocion> promocionesAceptadas = new ArrayList<Promocion>();
	// ArrayList<Atraccion> atraccionesAceptadas = new ArrayList<Atraccion>();
	//
	// private int costoFinal;
	// private double tiempoFinal;

	// public void aceptarOfertado(Ofertable) {
	// }

}
