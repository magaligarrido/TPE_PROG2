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
	
	@Override
	public ArrayList<String> getIdiomas() {
		ArrayList<String> idiomas = new ArrayList<>();
		for (Banda p : participantes) {
			ArrayList<String> aux = new ArrayList<>();
			aux = p.getIdiomas();
			for (String idioma : aux) {
				if (!idiomas.contains(idioma)) {
					idiomas.add(idioma);
				}
			}
		}
		return idiomas;
	}

	@Override
	public ArrayList<String> getInstrumentos() {
		ArrayList<String> instrumentos = new ArrayList<>();
		for (Banda p : participantes) {
			ArrayList<String> aux = new ArrayList<>();
			aux = p.getInstrumentos();
			for (String instrumento : aux) {
				if (!instrumentos.contains(instrumento)) {
					instrumentos.add(instrumento);
				}
			}
		}
		return instrumentos;
	}

	@Override
	public boolean puedeCantar(TemaMusical t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Banda> getList(Filtro f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ArrayList<String> getGenerosEnComun(ArrayList<String> generosPreferencia) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
}
