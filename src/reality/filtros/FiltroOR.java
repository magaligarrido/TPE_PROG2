package reality.filtros;

import reality.Banda;

public class FiltroOR extends Filtro {
	private Filtro f1, f2;

	public FiltroOR(Filtro f1, Filtro f2) {
		this.f1 = f1;
		this.f2 = f2;
	}

	@Override
	public boolean cumple(Banda b) {
		return f1.cumple(b) || f2.cumple(b);
	}

}
