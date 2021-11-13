package reality;

import java.util.ArrayList;

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
		
		// la unica forma q se me ocurrio para sacar el promedio
		public double getPromedioEdad() {// lista
			return getEdad()/getCantidadParticipantes();
		}		
		
		public abstract int getEdad();	// lista
		public abstract int getCantidadParticipantes();	// lista
		
		public abstract ArrayList<String> getGenerosPreferencia();	// lista
		
		public abstract ArrayList<String> getIdiomas();// lista
		public abstract ArrayList<String> getInstrumentos();// lista
		
		public abstract boolean puedeCantar(TemaMusical t); // no la necesitamos, creo q si hacemos un filtro que tenga como atribut un tema musical
		//podemos determinar si lo puede cantar o no
		
		public abstract ArrayList<Banda> getList(Filtro f);

		protected abstract ArrayList<String> getGenerosEnComun(ArrayList<String> generosPreferencia);
		
}
