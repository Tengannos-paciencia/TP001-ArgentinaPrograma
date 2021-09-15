package paquete;

import java.util.Arrays;

public class PromoPorcentual extends Promocion {
	private double porcentajeDescuento;
	private int costoSinDescuento;

	public PromoPorcentual(String nombre, TipoAtraccion tipo, Atraccion[] atracciones, int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
		this.atracciones = atracciones;
		this.nombre = nombre;
		this.tipoDePromocion = tipo;
		this.setCostoTotal();
		this.setTiempoTotal();
	}

	@Override
	public void setCostoTotal() {
<<<<<<< HEAD
		this.costoTotal = (int) (this.costoSinDescuento() - (this.costoSinDescuento() * (this.porcentajeDescuento/100)));
=======
		this.costoTotal = (int) (this.costoSinDescuento()
				- (this.costoSinDescuento() * (this.porcentajeDescuento / 100)));
>>>>>>> 1bc379bfbb26860348c27bb398da63fdb3c204c1
	}
	
	private int costoSinDescuento() {
		costoSinDescuento = 0;
<<<<<<< HEAD
=======

>>>>>>> 1bc379bfbb26860348c27bb398da63fdb3c204c1
		for (Atraccion atraccion : atracciones) {
			costoSinDescuento += atraccion.getCosto();
		}
		return costoSinDescuento;
	}

	@Override
	public String toString() {

<<<<<<< HEAD
		return "------PROMO 25% OFF!------ incluye: " + "\n" + Arrays.toString(atracciones) + "\n" + "Costo con descuento: "
				+ this.costoTotal + ", tiempo total: " + this.tiempoTotal + " minutos" + "\n";
=======
		return "------PROMO 25% OFF!------ incluye:\n" + Arrays.toString(atracciones) + "\nCosto final: "
				+ this.costoTotal + ", tiempo total: " + this.tiempoTotal + " minutos\n";
>>>>>>> 1bc379bfbb26860348c27bb398da63fdb3c204c1
	}
}
