package reality;

import java.util.ArrayList;
import java.util.Comparator;

public class Reality {

	private ArrayList<Banda> concursantes;
	private ArrayList<TemaMusical> temasMusicales;
	private Comparator<Banda> comparador;
	
	
	public Reality(Comparator<Banda> comparadorGenero) {
		this.comparador = comparadorGenero;
		this.concursantes = new ArrayList<>();
		this.temasMusicales = new ArrayList<>();
	}
	
	public int getConcursantes() {
		return this.concursantes.size();
	}
	public int getTemas() {
		return this.temasMusicales.size();
	}
	public TemaMusical getTema(int i) {
		TemaMusical salida = this.temasMusicales.get(i-1);
		return salida;
	}
	
	public Banda getConcursante(int i) {
		Banda salida = this.concursantes.get(i-1);
		return salida;
	}
	
	public void setComportamiento(Comparator<Banda> comparador) {
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
	
	public int batallaConTema(Banda a, Banda b,TemaMusical tema) {
		if(this.concursantes.contains(a) && this.concursantes.contains(b)) {
			if(tema.getRequisito()!=null) {
				if((tema.getRequisito().cumple(a)) && (tema.getRequisito().cumple(b))) {
					return this.comparador.compare(a,b);
				}if((!tema.getRequisito().cumple(a)) && (!tema.getRequisito().cumple(b))) {
					return -20;
				}if(tema.getRequisito().cumple(b)){
					return -10; //Gano b
				}if(tema.getRequisito().cumple(a)){
					return 10;// Gano a
				}
			}else
				return this.comparador.compare(a,b);
		}			
		return -2;
	}
	
}
