package reality.comparadores;

import java.util.Comparator;

import reality.Banda;

public class ComparadorIngles implements Comparator<Banda>  {
	
	@Override
	public int compare(Banda o1, Banda o2) {
		return o1.getIdiomas().size() - o2.getIdiomas().size();
	}
}
