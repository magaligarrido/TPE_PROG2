package reality.comparadores;

import java.util.Comparator;

import reality.Banda;

public class ComparadorGenero implements Comparador{

	@Override
	public int compare(Banda o1, Banda o2) {
		return o1.getGenerosPreferencia().size() - o2.getGenerosPreferencia().size();
	}
	
}
