package reality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import reality.filtros.Filtro;

public class Coach extends Banda {
	private ArrayList<Banda> participantes;
	Filtro condicion;

	public Coach(String nombre, Filtro condicion) {
		super(nombre);
		this.condicion = condicion;
		this.participantes = new ArrayList<>();
	}

	public Coach(String nombre) {
		super(nombre);
		this.condicion = null;
		this.participantes = new ArrayList<>();
	}

	public void setCondicion(Filtro condicion) {
		this.condicion = condicion;
	}

	public void addParticipante(Banda p) {
		if (condicion != null) {
			if (condicion.cumple(p)) {
				this.participantes.add(p);
			}
		} else {
			this.participantes.add(p);
		}
	}

	public ArrayList<String> getInterseccionGenerosPreferencia() {
		ArrayList<String> generosUnion = this.getGenerosPreferencia();
		ArrayList<String> generosInterseccion = this.getGenerosPreferencia();
		if (!generosUnion.isEmpty()) {
			for (Banda elem : this.participantes) {
				ArrayList<String> aux = elem.getGenerosPreferencia();
				if (!aux.isEmpty()) {
					for (String genero : generosUnion) {
						if (!aux.contains(genero)) {
							generosInterseccion.remove(genero);
						}
					}
				}
			}
		}
		return generosInterseccion;
	}

	public void deleteParticipante(Banda p) {
		if (!this.participantes.isEmpty()) {
			if (this.participantes.contains(p)) {
				this.participantes.remove(p);
			}
		}
	}

	@Override
	public int getEdad() {
		int edades = 0;
		for (Banda elem : participantes) {
			edades = +elem.getEdad();
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
		ArrayList<String> generos = new ArrayList<>();
		for (Banda elem : this.participantes) {
			ArrayList<String> aux = elem.getGenerosPreferencia();
			if (!aux.isEmpty()) {
				for (String genero : aux) {
					if (!generos.contains(genero)) {
						generos.add(genero);
					}
				}
			}
		}
		Collections.sort(generos);
		return generos;
	}

	@Override
	public ArrayList<String> getIdiomas() {
		ArrayList<String> idiomas = new ArrayList<>();
		for (Banda p : participantes) {
			ArrayList<String> aux = new ArrayList<>();
			aux = p.getIdiomas();
			if (!aux.isEmpty()) {
				for (String idioma : aux) {
					if (!idiomas.contains(idioma)) {
						idiomas.add(idioma);
					}
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
			if (!aux.isEmpty()) {
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
	public ArrayList<Banda> getList(Filtro f) {
		ArrayList<Banda> salida = new ArrayList<>();
		if (f.cumple(this)) {
			salida.add(this);
		} else {
			for (Banda elem : participantes) {
				salida.addAll(elem.getList(f));
			}
		}
		return salida;
	}

	public ArrayList<Banda> getMejores(Comparator<Banda> c) {
		ArrayList<Banda> mejores = new ArrayList<>();

		for (Banda elem : participantes) {
			mejores.addAll(elem.getMejores(c));
		}
		Collections.sort(mejores, Collections.reverseOrder(c));

		return mejores;
	}

}
