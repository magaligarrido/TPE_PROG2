package reality;

import java.util.ArrayList;
import java.util.Comparator;
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

	public Participante(String nombre, String apellido, int edad, ArrayList<String> generos,
			ArrayList<String> instrumentos, ArrayList<String> idiomas) {
		super(nombre);
		this.apellido = apellido;
		this.edad = edad;
		setGeneros(generos);
		setInstrumentos(instrumentos);
		setIdiomas(idiomas);
	}

	public void addGeneroMusical(String genero) {
		if ((this.generosMusicales.size() == 0) || (!this.generosMusicales.contains(genero))) {
			this.generosMusicales.add(genero);
		}
	}

	private void setGeneros(ArrayList<String> generos) {
		this.generosMusicales = new ArrayList<>();
		for (String elem : generos) {
			this.addGeneroMusical(elem);
		}
	}

	public void addIdioma(String idioma) {
		if ((this.idiomas.size() == 0) || (!this.idiomas.contains(idioma))) {
			this.idiomas.add(idioma);
		}
	}

	private void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = new ArrayList<>();
		for (String elem : idiomas) {
			this.addIdioma(elem);
		}
	}

	public void addInstrumento(String instrumento) {
		if ((this.instrumentos.size() == 0) || (!this.instrumentos.contains(instrumento))) {
			this.instrumentos.add(instrumento);
		}
	}

	private void setInstrumentos(ArrayList<String> instrumentos) {
		this.instrumentos = new ArrayList<>();
		for (String elem : instrumentos) {
			this.addInstrumento(elem);
		}
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

	@Override
	public ArrayList<String> getInterseccionGenerosPreferencia() {
		return this.getGenerosPreferencia();
	}

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
	public ArrayList<Banda> getList(Filtro f) {
		ArrayList<Banda> participante = new ArrayList<>();
		if (f.cumple(this)) {
			participante.add(this);
		}
		return participante;
	}

	@Override
	public ArrayList<Banda> getMejores(Comparator<Banda> c) {
		ArrayList<Banda> participante = new ArrayList<>();
		participante.add(this);
		return participante;
	}
}
