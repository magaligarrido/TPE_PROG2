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
	public Reality( ) {
		this.comparador = null;// sin comparador? no podria realizarse la batalla?
		this.concursantes = new ArrayList<>();
		this.temasMusicales = new ArrayList<>();
	}
	
	public int getConcursantes() {
		return this.concursantes.size();
	}
	
	public Banda getConcursante(int i) {
		Banda salida = this.concursantes.get(i-1);
		return salida;
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
	
	public int batalla(Banda a, Banda b) {
		if(this.concursantes.contains(a) && this.concursantes.contains(b)) {
			return this.comparador.compare(a,b);
		}			
		return -2;
	}
	
}
