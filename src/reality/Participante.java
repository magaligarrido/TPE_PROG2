package reality;

import java.lang.reflect.Array;
import java.util.ArrayList;

import reality.filtros.Filtro;

public class Participante extends Banda {
	private String apellido;
	private int edad;
	private ArrayList<String> generosMusicales;
	private ArrayList<String> idiomas;
	private ArrayList<String> instrumentos;
	
	public Participante(String nombre, String apellido, int edad) {
		super(nombre);
		this.apellido = apellido;
		this.edad = edad;
		this.generosMusicales = new ArrayList<>();
		this.idiomas = new ArrayList<>();
		this.instrumentos = new ArrayList<>();
		
	}
	
	public void addGeneroMusical(String genero) {
		this.generosMusicales.add(genero);
	}
	
	public void addIdioma(String idioma) {
		this.idiomas.add(idioma);
	}
	
	public void addInstrumento(String instrumento) {
		this.instrumentos.add(instrumento);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public boolean equals(Object o){
		return this.getNombre().equals(((Participante)o).getNombre())&&this.getApellido().equals(((Participante)o).getApellido());
		
	}
	
	@Override
	public int getEdad() {
		return edad;
	}
	@Override
	public int getCantidadParticipantes() {
		return 1;
	}
	
	@Override
	public ArrayList<String> getGenerosPreferencia() {
		ArrayList<String> generosPreferencias = new ArrayList<>();
		for (String genero : generosMusicales) {
			generosPreferencias.add(genero);
		}
		return generosPreferencias;	
	}
	/*
	@Override
	public ArrayList<String> getGenerosEnComun(ArrayList<String> generosPreferencia){
		ArrayList<String> resultado = new ArrayList<>();
		for (String genero : generosMusicales) {
			if(generosPreferencia.contains(genero)) {
				resultado.add(genero);
			}else {
				generosPreferencia.remove(genero); // ?? jjaja esta bien? o flashe
			}	
		}
		return resultado;
	}
	
	@Override
	public ArrayList<String> getGenerosPreferencia() {
		ArrayList<String> generosPreferencias = new ArrayList<>();
		for (String genero : generosMusicales) {
			generosPreferencias.add(genero);
		}
		return generosPreferencias;	
	}
*/
	
	@Override
	public ArrayList<String> getIdiomas() {
		ArrayList<String> idiomas = new ArrayList<>();
		for (String idioma : this.idiomas) {
			idiomas.add(idioma);
		}
		return idiomas;	
	}

	@Override
	public ArrayList<String> getInstrumentos() {
		ArrayList<String> instrumentos = new ArrayList<>();
		for (String instrumento : this.instrumentos) {
			instrumentos.add(instrumento);
		}
		return instrumentos;	
	}

	@Override
	public boolean puedeCantar(TemaMusical t) {
		if (!this.getIdiomas().contains(t.getIdioma())){
			return false;
		}else {
			for (String genero : t.getGeneros()) {
				if(!this.getGenerosPreferencia().contains(genero)) {
					return false;
				}
			}
			for (String instrumento : t.getInstrumentos()) {
				if(!this.getInstrumentos().contains(instrumento)) {
					return false;
				}
			}	
		}
		return true;
	}

	@Override
	public ArrayList<Banda> getList(Filtro f) {
		ArrayList<Banda> participante = new ArrayList<>();
		if (f.cumple(this)) {
			participante.add(this);
		}
		return participante;
	}
	
}
