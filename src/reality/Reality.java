package reality;

import java.util.ArrayList;

import reality.comparadores.Comparador;

public class Reality {

	private ArrayList<Banda> concursantes;
	private ArrayList<TemaMusical> temasMusicales;
	private Comparador comparador;
	
	
	public Reality(Comparador comparador) {
		this.comparador = comparador;
		this.concursantes = new ArrayList<>();
		this.temasMusicales = new ArrayList<>();
	}
	
	public void setComportamiento(Comparador comparador) {
		this.comparador = comparador;
	}
	
	public void addConcursante(Banda concursante) {
		if(this.concursantes.isEmpty()||(!this.concursantes.contains(concursante))) {
			this.concursantes.add(concursante);
		}
	}
	
	public void addTemaMusical(TemaMusical temaMusical) {
		if(this.temasMusicales.isEmpty()||(!this.temasMusicales.contains(temaMusical))) {
			this.temasMusicales.add(temaMusical);			
		}
	}
	
	public int batalla(Banda a, Banda b, TemaMusical tema) {
		if(this.temasMusicales.contains(tema)) {
			if(this.concursantes.contains(a) && this.concursantes.contains(b)) {
				return this.comparador.compare(a,b);
			}			
		}
		return -2;
	}
	
}
