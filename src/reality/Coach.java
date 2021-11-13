package reality;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Coach extends Banda {
	private ArrayList<Banda> participantes;

	public Coach(String nombre) {
		super(nombre);
		this.participantes = new ArrayList<>();
	}
	
	public void addParticipante(Banda p) {
		this.participantes.add(p);
	}
	
	public void deleteParticipante(Banda p) {
		if (this.participantes.contains(p)) {
			this.participantes.remove(p);
		}
	}
	
	//esto lo hago nuevo: ------------------------
	@Override
	public int getEdad() {
		return getPromedioEdad();
	}
	
	//la hago aparte para delegar y porque coach desea poder 
	//obtener el promedio
	
	public int getPromedioEdad() {
		int edad = 0;
		int cantidad =0;
		for (Banda p : participantes) {
			edad =+ p.getEdad();
			cantidad =+ 1;
		}
		return edad/cantidad;
	}
	
	/* TODO ESTO ES LA PRUEBA PARA LA INTERSECCION DE LOS GENEROS DE M,. JAJAJ
	 * 
	public ArrayList<String> intersectionList(ArrayList<String> l1, ArrayList<String> l2){
		ArrayList<String> resultado = new ArrayList<>();
		for (String i : l2) {
			if (l1.contains(i)){
				resultado.add(i);
			}
		}
		return resultado;
	}
	
	
	
	@Override
	public ArrayList<String> getGenerosPreferencia() {
		ArrayList<String> generosPreferencia = new ArrayList<>();
		for (Banda p : participantes) {
			ArrayList<String> aux = new ArrayList<>();
			aux = p.getGenerosPreferencia();
			if (aux.isEmpty()) {
				if(generosPreferencia.isEmpty()) {
					generosPreferencia.addAll(aux); 
				}
			}
		}
					
	return generosPreferencia;
	}*/
	
	// hasta aca -------------------------------

	@Override
	public ArrayList<String> getIdiomas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getInstrumentos() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
}
