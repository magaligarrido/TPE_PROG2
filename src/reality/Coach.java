package reality;

import java.lang.reflect.Array;
import java.util.ArrayList;

import reality.filtros.Filtro;

public class Coach extends Banda {
	private ArrayList<Banda> participantes;

	public Coach(String nombre) {
		super(nombre);
		this.participantes = new ArrayList<>();
	}
	
	public void addParticipante(Banda p) {
		this.participantes.add(p);
	}
	
	//si hacemos esto hay q redefenir el equals
	public void deleteParticipante(Banda p) {
		if (this.participantes.contains(p)) {
			this.participantes.remove(p);
		}
	}

	@Override
	public int getEdad() {
		int edades = 0;
		for (Banda elem : participantes) {
			edades=+ elem.getEdad();
		}
		return edades;
	}
	
	@Override
	public int getCantidadParticipantes() {
		int cantidad = 0;
		for (Banda elem : participantes) {
			cantidad += elem.getCantidadParticipantes();
		}
		return cantidad;
	}
	
	@Override
	public ArrayList<String> getGenerosPreferencia() {
		ArrayList<String> generosPreferecia = new ArrayList<>();
		for (Banda elem : this.participantes) {
			generosPreferecia = interseccion(generosPreferecia, elem.getGenerosPreferencia());
			if(generosPreferecia.isEmpty()) {
				//si la interseccion entre dos elementos dio como resultado una lista vacia
				//retorno esta lista vacia, ya no existe posibilidad de que cambie de estado
				//con esto evito que siga recorriendo sin sentido
				return generosPreferecia;
			}
		}
		return generosPreferecia;
	}
	
	private ArrayList<String> interseccion(ArrayList<String> a , ArrayList<String>b){
		ArrayList<String> salida = new ArrayList<>();
		for (String elem : a) {
			if(b.contains(elem)) {
				salida.add(elem);
			}
		}
		return salida;
	}
	
	/*
	 * ELIMINO ESTAS DOS FUNCIONES 
	 * GETEDAD AHORA DEVUELVE LA SUMA TOTAL DE EDADES
	 * CREO METODO GETCANTIDADDEPARTICIPANTES
	 * EN LA CLASE ABSTRACTA CREO METODO GETPROMEDIOEDAD, RETORNO LA DIVICION DE GETEDAD Y GETCANTIDADDEPARTICIPANTES
	 * public int getPromedioEdad() {
			int edad = 0;
			int cantidad =0;
			for (Banda p : participantes) {
				edad =+ p.getEdad();
				cantidad =+ 1; 
			}
			return edad/cantidad;
		}
		
	 * 	public int getEdad() {
			return getPromedioEdad();	
		}
		CADA NIVEL QUE ENTRE GETEDAD VA A LLAMAR A GETPROMEDIOEDAD Y SIEMPRE VA A DEVOLVER
		EL PROMEDIO DE CADA NIVEL, Y NO NOS SIRVE. NOSOTROS NECESITAMOS 
		PRIMERO CONSEGUIR LA SUMA DE TODAS LAS EDADES Y AL FINAL DIVIDIR POR LA CANTIDAD DE 
		PARTICIPANTES	
	}
	*/
	
	/* TODO ESTO ES LA PRUEBA PARA LA INTERSECCION DE LOS GENEROS DE M,. JAJAJ
	 * 
	public ArrayList<String> intersectionList(ArrayList<String> l1, ArrayList<String> l2){
		ArrayList<String> resultado = new ArrayList<>();
		for (String i : l2) {
			if (l1.contains(i)){
				resultado.add(i);
			}
		}
		return resultado;
	}
	
	
	
	@Override
	public ArrayList<String> getGenerosPreferencia() {
		ArrayList<String> generosPreferencia = new ArrayList<>();
		for (Banda p : participantes) {
			ArrayList<String> aux = new ArrayList<>();
			aux = p.getGenerosPreferencia();
			if (aux.isEmpty()) {
				if(generosPreferencia.isEmpty()) {
					generosPreferencia.addAll(aux); 
				}
			}
		}
					
	return generosPreferencia;
	}*/
	
	// hasta aca -------------------------------

	
	// EN LA ULTIMA MODIFICACION HICE ESTE
	@Override
	public ArrayList<String> getIdiomas() {
		ArrayList<String> idiomas = new ArrayList<>();
		for (Banda p : participantes) {
			ArrayList<String> aux = new ArrayList<>();
			aux = p.getIdiomas();
			//agrego preguntar si aux llega vacio, mira si hay un baterista mudo en la banda xD
			if(!aux.isEmpty()) {
				for (String idioma : aux) {
					if (!idiomas.contains(idioma)) {
						idiomas.add(idioma);
					}
				}
			}
		}
		return idiomas;
	}

	
	//ULTIMA MODIFICACION HICE ESTE:
	@Override
	public ArrayList<String> getInstrumentos() {
		ArrayList<String> instrumentos = new ArrayList<>();
		for (Banda p : participantes) {
			ArrayList<String> aux = new ArrayList<>();
			aux = p.getInstrumentos();
			//control idem que en getIdiomas
			if(!aux.isEmpty()) {
				for (String instrumento : aux) {
					if (!instrumentos.contains(instrumento)) {
						instrumentos.add(instrumento);
					}
				}
			}
		}
		return instrumentos;
	}

	

	@Override
	public boolean puedeCantar(TemaMusical t) {
		for (Banda participante : participantes) {
			if(participante.puedeCantar(t)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Banda> getList(Filtro f) {
		ArrayList<Banda> salida = new ArrayList<>();
		if(f.cumple(this)) {
			salida.add(this);
		}else {
			for (Banda elem : participantes) {
				salida.addAll(elem.getList(f));
			}
		}
		return salida;
	}



	

	
	
	
}
