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
		public double getPromedioEdad() {
			return getEdad()/getCantidadParticipantes();
		}		
		public abstract int getEdad();
		public abstract int getCantidadParticipantes();
		
		public abstract ArrayList<String> getGenerosPreferencia();
		
		public abstract ArrayList<String> getIdiomas();
		public abstract ArrayList<String> getInstrumentos();
		
		public abstract boolean puedeCantar(TemaMusical t);
		
		public abstract ArrayList<Banda> getList(Filtro f);

		protected abstract ArrayList<String> getGenerosEnComun(ArrayList<String> generosPreferencia);
		
}
