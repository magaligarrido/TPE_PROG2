package reality.filtros;

import reality.*;


public class FiltroTemaMusical extends Filtro {
	
	private TemaMusical tema;
	
	

	public FiltroTemaMusical(TemaMusical tema) {
		this.tema = tema;
	}


	@Override
	public boolean cumple(Banda b) {
		return b.puedeCantar(tema);
	}
}
	
