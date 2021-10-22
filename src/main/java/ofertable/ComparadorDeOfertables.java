package ofertable;

import java.util.Comparator;

public class ComparadorDeOfertables implements Comparator<Ofertable> {
	TipoAtraccion tipoFavorito;

	public ComparadorDeOfertables() {
	}

	public ComparadorDeOfertables(TipoAtraccion tipoFavorito) {
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
