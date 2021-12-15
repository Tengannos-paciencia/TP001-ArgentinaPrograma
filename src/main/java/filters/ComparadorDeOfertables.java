package filters;

import java.util.Comparator;

import model.Ofertable;

public class ComparadorDeOfertables implements Comparator<Ofertable>{
	int tipoFavorito;

	public ComparadorDeOfertables() {
	}

	public ComparadorDeOfertables(int tipoFavorito) {
		this.tipoFavorito = tipoFavorito;
	}

	@Override
	public int compare(Ofertable o1, Ofertable o2) {
		if (o1 == null || o2 == null) {

			return 0;

		}
		double diferenciaCosto = o2.getCostoTotal() - o1.getCostoTotal();
		double diferenciaTiempo = o2.getTiempoTotal() - o1.getTiempoTotal();
		if (o1.getTipo() != tipoFavorito && o2.getTipo() == tipoFavorito) {
			return 1;
		} else if (o1.getTipo() == tipoFavorito && o2.getTipo() != tipoFavorito) {
			return -1;
		}

		if (o1.esPromocion() && o2.esAtraccion()) {
			return -1;
		} else if (o1.esAtraccion() && o2.esPromocion()) {
			return 1;
		}

		if (diferenciaCosto != 0) {
			return diferenciaCosto > 0 ? 1 : (diferenciaCosto < 0 ? -1 : 0);
		}

		return diferenciaTiempo > 0 ? 1 : (diferenciaTiempo < 0 ? -1 : 0);
	}
}
