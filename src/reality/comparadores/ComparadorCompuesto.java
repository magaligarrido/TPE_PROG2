package reality.comparadores;

import java.util.Comparator;

import reality.Banda;

public class ComparadorCompuesto implements Comparator<Banda> {
	
	private Comparator<Banda> c1, c2;
	
	

	public ComparadorCompuesto(Comparator<Banda> c1, Comparator<Banda> c2) {
		this.c1 = c1;
		this.c2 = c2;
	}


	@Override
	public int compare(Banda o1, Banda o2) {
		int resultado = c1.compare(o1, o2);
		if (resultado == 0) {
			return c2.compare(o1, o2);
		}
		return resultado;
	}
	
}
