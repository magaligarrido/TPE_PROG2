package reality;

import java.util.ArrayList;
import reality.filtros.*;

public class TemaMusical {

	private String titulo;
	private String idioma;
	private ArrayList<String> instrumentos;
	private ArrayList<String> generos;
	private Filtro requisito;

	public TemaMusical(String titulo, String idioma, Filtro requisito) {
		this.titulo = titulo;
		this.idioma = idioma;
		this.requisito = requisito;
		this.instrumentos = new ArrayList<>();
		this.generos = new ArrayList<>();
	}

	public TemaMusical(String titulo, String idioma) {
		this.titulo = titulo;
		this.idioma = idioma;
		this.requisito = null;// new FiltroFinal(2,new FiltroGenero("Rock"));
		this.instrumentos = new ArrayList<>();
		this.generos = new ArrayList<>();
	}

	public TemaMusical(String titulo, String idioma, ArrayList<String> generos, ArrayList<String> instrumentos,
			Filtro requisito) {
		this.titulo = titulo;
		this.idioma = idioma;
		this.requisito = requisito;
		setInstrumentos(instrumentos);
		;
		setGeneros(generos);
	}

	public TemaMusical(String titulo, String idioma, ArrayList<String> generos, ArrayList<String> instrumentos) {
		this.titulo = titulo;
		this.idioma = idioma;
		this.requisito = null;
		setInstrumentos(instrumentos);
		;
		setGeneros(generos);
	}

	public Filtro getRequisito() {
		return this.requisito;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
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

	public void addGenero(String genero) {
		if ((this.generos.size() == 0) || (!this.generos.contains(genero))) {
			this.generos.add(genero);
		}
	}

	private void setGeneros(ArrayList<String> generos) {
		this.generos = new ArrayList<>();
		for (String elem : generos) {
			this.addGenero(elem);
		}
	}

	public ArrayList<String> getGeneros() {
		ArrayList<String> generos = new ArrayList<>();
		for (String genero : this.generos) {
			generos.add(genero);
		}
		return generos;
	}

	public ArrayList<String> getInstrumentos() {
		ArrayList<String> instrumentos = new ArrayList<>();
		for (String instrumento : this.instrumentos) {
			instrumentos.add(instrumento);
		}
		return instrumentos;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj == null) {
				return false;
			}
			TemaMusical tema = ((TemaMusical) obj);
			for (String elem : this.getGeneros()) {
				if (!tema.getGeneros().contains(elem)) {
					return false;
				}
			}
			for (String elem : this.getInstrumentos()) {
				if (!tema.getInstrumentos().contains(elem)) {
					return false;
				}
			}
			if (this.getIdioma().equals(tema.getIdioma()) && this.getTitulo().equals(tema.getTitulo())) {
				return true;
			} else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.getTitulo() + "\n" + this.getIdioma() + "\n" + this.getGeneros() + "\n" + this.getInstrumentos()
				+ "\n";
	}

}
