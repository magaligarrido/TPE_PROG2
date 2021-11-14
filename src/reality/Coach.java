package reality;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import reality.comparadores.Comparador;
import reality.filtros.Filtro;

public class Coach extends Banda {
	private ArrayList<Banda> participantes;
	Filtro condicion;

	public Coach(String nombre,Filtro condicion) {
		super(nombre);
		this.condicion = condicion;
		this.participantes = new ArrayList<>();
	}
	
	public Coach(String nombre) {
		super(nombre);
		this.condicion = null; // en caso que no quiera poner una condicion
		this.participantes = new ArrayList<>();
	}
	
	public void setCondicion(Filtro condicion) {
		this.condicion = condicion;
	}
	
	public void addParticipante(Banda p) {
		if(condicion!= null) {
			if(condicion.cumple(p)) {
				this.participantes.add(p);
			}
		}else {
			this.participantes.add(p);	
		}
	}
	
	public ArrayList<String> getInterseccionGenerosPreferencia() {
		ArrayList<String> generosUnion =  this.getGenerosPreferencia();
		ArrayList<String> generosInterseccion = this.getGenerosPreferencia();
		ArrayList<String> generosInterseccionAux = this.getGenerosPreferencia();
		for (Banda elem : this.participantes) {
			ArrayList<String> aux = elem.getGenerosPreferencia();
			if(!aux.isEmpty()) {
				if(!generosInterseccion.isEmpty()) {
					for (String genero : generosInterseccion) {
						if(!aux.contains(genero)) {
							generosInterseccionAux.remove(genero);						
						}
					}
				}
			}
		}
		return generosInterseccionAux;
	}
	
	//si hacemos esto hay q redefenir el equals
	public void deleteParticipante(Banda p) {
		if(!this.participantes.isEmpty()) {
			if (this.participantes.contains(p)) {
				this.participantes.remove(p);
			}
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
		ArrayList<String> generos =  new ArrayList<>();
		for (Banda elem : this.participantes) {
			ArrayList<String> aux = elem.getGenerosPreferencia();
			if(!aux.isEmpty()) {
				for (String genero : aux) {
					if(!generos.contains(genero)) {
						generos.add(genero);
					}
				}
			}
		}
		return generos;
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
	
	public ArrayList<Banda> getMejores(Comparador c){
		ArrayList<Banda> mejores = new ArrayList<>();
		
		for (Banda elem : participantes) {
			mejores.addAll(elem.getMejores(c));
		}
		Collections.sort(mejores,c);
		return mejores;
	}



	

	
	
	
}
