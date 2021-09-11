package paquete;

public class Atraccion extends Ofertable {
	
	private String nombre;
	private double costo;
	private double tiempoNecesario;
	private int cupoMaximo;
	private TipoAtraccion tipoDeAtraccion;
	private int cupoActual;
	
	
	
	
	
	public Atraccion(String nombre, double costo, double tiempoNecesario, int cupoMaximo, TipoAtraccion tipoDeAtraccion) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoNecesario = tiempoNecesario;
		this.cupoMaximo = cupoMaximo;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}





	public void reservarCupo() {
		if (this.cupoDisponible()) {
			cupoActual--;
		}
	}

}
