package reality;

import java.util.ArrayList;

public class TemaMusical {

		private String titulo;
		private String idioma;
		private ArrayList<String> instrumentos;
		private ArrayList<String> generos;
		public TemaMusical(String titulo, String idioma) {
			this.titulo = titulo;
			this.idioma = idioma;
			this.instrumentos = new ArrayList<>();
			this.generos = new ArrayList<>();
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
			if((this.instrumentos.size() == 0) || (!this.instrumentos.contains(instrumento))){
				this.instrumentos.add(instrumento);
			}	
		}
		
		public void addGenero(String genero) {
			if((this.generos.size() == 0) || (!this.generos.contains(genero))){
				this.generos.add(genero);
			}	
		}
		
		public ArrayList<String> getGeneros(){
			ArrayList<String> generos = new ArrayList<>();
			for (String genero : this.generos) {
				generos.add(genero);
			}
			return generos;
		}
		
		public ArrayList<String> getInstrumentos(){
			ArrayList<String> instrumentos = new ArrayList<>();
			for (String instrumento : this.instrumentos) {
				instrumentos.add(instrumento);
			}
			return instrumentos;
		}
		
}
