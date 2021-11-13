package reality;

import java.util.ArrayList;

public class Reality {

	private ArrayList<Banda> concursantes;
	private ArrayList<TemaMusical> temasMusicales;
	
	
	public Reality() {
		this.concursantes = new ArrayList<>();
		this.temasMusicales = new ArrayList<>();
	}
	
	public void addConcursante(Banda concursante) {
		//preguntamos si contiene o repetido?
		this.concursantes.add(concursante);
		
	}
	
	public void addTemaMusical(TemaMusical temaMusical) {
		//preguntamos si contiene o repetido?
		this.temasMusicales.add(temaMusical);
		
	}
	
}
