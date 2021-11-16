package reality.filtros;

import reality.Banda;

public class FiltroIdioma extends Filtro {
	private String idioma;

	public FiltroIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public boolean cumple(Banda b) {
		return b.getIdiomas().contains(this.idioma);
	}

}
