package reality.filtros;

import java.util.ArrayList;
import reality.*;


public class FiltroTemaMusical extends Filtro {
	
	private TemaMusical tema;
	
	

	public FiltroTemaMusical(TemaMusical tema) {
		this.tema = tema;
	}


	/*@Override
	public boolean cumple(Banda b) {
		if(!b.getIdiomas().contains(tema.getIdioma())) {
			return false;
		}else {
			ArrayList<String>generos = b.getGenerosPreferencia();
			for (String genero : tema.getGeneros()) {
				if(!generos.contains(genero)) {
					return false;
				}
			}
			ArrayList<String>instrumentos = b.getInstrumentos();
			for (String instrumento : tema.getInstrumentos()) {
				if(!instrumentos.contains(instrumento)) {
					return false;
				}
			}
			return true;
		}
		//opcion 1 es asi
		//opcion 2 seria crear y llamar al metodo puedeCantar(TemaMusical t)
		// y hacer algo similar pero dentro de la clase participante y dentro del coach
		//la implemento y despues vemos con cual nos quedamos
		 
		 //EN CASO DE HACERLO ASI, EVITAMOS EL METODO PUEDECANTAR, RESOLVERIAMOS TODO EN UN SOLO METODO
		
	}*/
	
	
	//me gusto mas asi
	
	public boolean cumple(Banda b) {
		return this.tema.getRequisito().cumple(b);
	}
}
	
