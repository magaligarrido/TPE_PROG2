package reality.filtros;

import reality.Banda;

public class FiltroNOT extends Filtro {

	private Filtro f;

	public FiltroNOT(Filtro f) {
		this.f = f;
	}

	@Override
	public boolean cumple(Banda b) {
		return !f.cumple(b);
	}

}
