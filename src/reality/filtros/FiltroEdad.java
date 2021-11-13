package reality.filtros;

import reality.Banda;

public class FiltroEdad extends Filtro {
	
	private int edad;
	
	public FiltroEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public boolean cumple(Banda b) {
		return b.getEdad() > edad;
	}

}
