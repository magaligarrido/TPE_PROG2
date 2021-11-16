package reality;

import java.util.ArrayList;
import java.util.Comparator;
import reality.filtros.Filtro;

public abstract class Banda {

	private String nombre;

	public Banda(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPromedioEdad() {
		return getEdad() / getCantidadParticipantes();
	}

	public abstract int getEdad();

	public abstract int getCantidadParticipantes();

	public abstract ArrayList<String> getGenerosPreferencia();

	public abstract ArrayList<String> getInterseccionGenerosPreferencia();

	public abstract ArrayList<String> getIdiomas();

	public abstract ArrayList<String> getInstrumentos();

	public abstract ArrayList<Banda> getList(Filtro f);

	public abstract ArrayList<Banda> getMejores(Comparator<Banda> c);

	@Override
	public boolean equals(Object obj) {
		try {
			Banda banda = (Banda) obj;
			if (this.getNombre().equals(banda.getNombre()) && this.getEdad() == banda.getEdad()
					&& this.getCantidadParticipantes() == banda.getCantidadParticipantes()) {
				for (String idiom : this.getIdiomas()) {
					if (!banda.getIdiomas().contains(idiom)) {
						return false;
					}
				}
				for (String instru : this.getInstrumentos()) {
					if (!banda.getInstrumentos().contains(instru)) {
						return false;
					}
				}
				for (String genero : this.getGenerosPreferencia()) {
					if (!banda.getGenerosPreferencia().contains(genero)) {
						return false;
					}
				}
				return true;
			} else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.getNombre() + "\n" + "Todos sus generos: " + this.getGenerosPreferencia() + "\n"
										+ "Generos en comun: " + this.getInterseccionGenerosPreferencia() + "\n"
										+ "Toca los siguientes instrumentos: " + this.getInstrumentos() + "\n" 
										+ "Canta en los idiomas: "+ this.getIdiomas() + "\n" 
										+ "Promedio Edad: " + this.getEdad() + "\n";
	}
		
}
