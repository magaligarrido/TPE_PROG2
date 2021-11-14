package reality.filtros;

import java.util.ArrayList;

import reality.Banda;

public class FiltroFinal extends Filtro {
	private int cantidadQueCumplen;
	private Filtro f1;
	
	public FiltroFinal(int cantidadQueCumplen,Filtro f1) {
		this.cantidadQueCumplen = cantidadQueCumplen;
		this.f1 = f1;
	}

	@Override
	public boolean cumple(Banda b) {
		ArrayList<Banda>cumplen =b.getList(f1);
		int cant = 0;
		for (Banda banda : cumplen) {
			cant=+ banda.getCantidadParticipantes();
		}
		return this.cantidadQueCumplen <= cant;
	}

}
