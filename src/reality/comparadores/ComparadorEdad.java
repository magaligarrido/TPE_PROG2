package reality.comparadores;

import java.util.Comparator;

import reality.Banda;

public class ComparadorEdad implements Comparator<Banda> {

	@Override
	public int compare(Banda o1, Banda o2) {
		return o1.getEdad() - o2.getEdad();		
	}

}
