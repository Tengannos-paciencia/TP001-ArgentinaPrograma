package paquete;

public abstract class Ofertable implements Comparable<Ofertable> {

	public boolean esPromocion() {
		return false;

	}

	public double calcularTiempo() {
		return 0;

	}

	public int calcularCosto() {
		return 0;
	}

	public boolean cupoDisponible() {
		return true;
	}

	@Override
	public int compareTo(Ofertable o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
