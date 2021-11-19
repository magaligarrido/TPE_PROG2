package reality.filtros;

import reality.Banda;

public class FiltroDefecto extends Filtro {

	@Override
	public boolean cumple(Banda b) {
		return true;
	}

}
