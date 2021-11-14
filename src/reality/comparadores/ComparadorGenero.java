package reality.comparadores;

import java.util.Comparator;

import reality.Banda;

public class ComparadorGenero implements Comparator<Banda> {

	@Override
	public int compare(Banda o1, Banda o2) {
		return o1.getInterseccionGenerosPreferencia().size() - o2.getInterseccionGenerosPreferencia().size();
	}
	
}
