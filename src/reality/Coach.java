package reality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import reality.filtros.Filtro;
import reality.filtros.FiltroDefecto;

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
		this.condicion = new FiltroDefecto();
		this.participantes = new ArrayList<>();
	}

	public void setCondicion(Filtro condicion) {
		this.condicion = condicion;
	}

	public void addParticipante(Banda p) {
		if (condicion.cumple(p)) {
			this.participantes.add(p);
		}
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
			edades +=elem.getEdad();
		}
		return edades/this.participantes.size();
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
		ArrayList<String> salida = new ArrayList<>();
		ArrayList<String> todos = new ArrayList<>();//lo uso solo para control de primer nivel
		
		for (Banda elem : this.participantes) {
			ArrayList<String> aux = elem.getGenerosPreferencia();
			
			if(todos.isEmpty()) {
				todos.addAll(aux);
				salida.addAll(aux);
			}else {
				if(!salida.isEmpty()) {
					ArrayList<String> salidaAuxiliar = new ArrayList<>();;
					for (String genero : salida) {
						if(aux.contains(genero)) {
							salidaAuxiliar.add(genero);
						}
					}
					salida = salidaAuxiliar;
				}else {
					return salida;
				}
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
	
	@Override
	public int contar(Filtro f) {
		
		int cant = 0;
		
		for (Banda elem : participantes) {
			cant+= elem.contar(f);
		}
		
		return cant;
	}
	
	

	@Override
	public String toString() {
		String salida = this.getNombre();
		for (Banda elem : participantes) {
			salida+= "\n\t" +elem.toString()+"  ";
		}
		return salida;
	}
	
	public String mostrar(int nivel) {
		nivel++;
		String salida = this.getNombre()+" "+ this.getEdad()+ this.getGenerosPreferencia()+"\n";
		for (Banda elem : participantes) {
			String aux = "";
			for(int i=0; i<nivel; i++) {
				aux +="\t";
			}
			
			salida+= aux +elem.mostrar(nivel)+"\n";
		}
		return salida;
	}


	
	

}
