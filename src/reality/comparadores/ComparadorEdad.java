package reality.comparadores;

import java.util.Comparator;

import reality.Banda;

public class ComparadorEdad implements Comparator<Banda> {

	@Override
	public int compare(Banda o1, Banda o2) {
		int res = o1.getEdad() - o2.getEdad();
		if (res == 0) {
			return 0;
		} else
			return res;
	}

}
