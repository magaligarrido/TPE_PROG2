package reality.comparadores;

import java.util.Comparator;

import reality.Banda;

public class ComparadorInstrumento implements Comparator<Banda>{
	
	@Override
	public int compare(Banda o1, Banda o2) {
		return o1.getInstrumentos().size() - o2.getInstrumentos().size();
	}
	
	
}
