package reality.filtros;

import reality.Banda;

public class FiltroGenero extends Filtro {
	private String genero;

	public FiltroGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public boolean cumple(Banda b) {
		return b.getGenerosPreferencia().contains(this.genero);
	}
		

}
