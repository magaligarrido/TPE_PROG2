package reality;

import java.util.ArrayList;
import reality.comparadores.*;

public class Main {

	public static void main(String[] args) {
		
		/*
			-3  Clase Requisito vacía.
			-4  En lugar de preguntar por condicion != null en addParticipante, 
				es mejor tener un filtro que retorne True. De esta forma se está preguntando por tipo implicitamente.
			-6  Mal delegada la responsabilidad en Reality.batallaConTema, 
				se usa tema.getRequisito().cumple(a) cuando se debe delegar en tema y preguntar tema.puedeSerInterpretardo(a).
			-7  En ComparadorEdad.compare el if es innecesario
			
			
		 * - 1 No esta mal pensar al Coach como parte del composite, 
		 * 		pero hay algunas cosas que se calculan distinto, por ejemplo,
		 *  	los generos o el control para agregar un participante.
		 *  
			-2  Clase Coach (compuesto) no cumple con la intersección en el getGeneros(),
			 	se agrega otro metodo para cumplirlo (getInterseccionGenerosPreferencia)
	
			-5  Coach.getEdad() retorna el promedio de la edad de los subelementos del primer nivel.	
			
			-8  En FiltroFinal no se cumple la consigna.
				 Está bien el uso del filtro f1 pero debería proveer un contar(f1) el composite.
				  Como está implementado no hay relacion entre el cumplimiento del criterio y la cantidad que lo cumplen.
				  

				  */
	

		// batalla de preba
		// !!!IMPORTANTE : El archivo .html muestra el modelo usado para estas pruebas
		Reality show = new Reality(new ComparadorGenero());

		cargarTemas(show);
		cargarParticipantes(show);

		Banda b1 = getBatalladorRandom(show);
		Banda b2 = getBatalladorRandom(show);
		TemaMusical t1 = getTemaRandom(show);

		if (b1 != null && b2 != null && b1 != b2) {
			System.out.println(b1.toString() + "\n" + b2.toString() + "\n");
			System.out.println("Batalla: " + b1.getNombre() + " contra: " + b2.getNombre());
			System.out.println(b1.getNombre() + " Tiene como sus mejores :");

			for (Banda part : b1.getMejores(new ComparadorGenero())) {
				System.out.println(part.getNombre() + " " + part.getInterseccionGenerosPreferencia() + "\n");
			}

			System.out.println(b2.getNombre() + " Tiene como sus mejores :");
			for (Banda part : b2.getMejores(new ComparadorGenero())) {
				System.out.println(part.getNombre() + " " + part.getInterseccionGenerosPreferencia() + "\n");

			}
			System.out.println(b1.getNombre() + "\n" + b1.getInterseccionGenerosPreferencia());
			System.out.println(b2.getNombre() + "\n" + b2.getInterseccionGenerosPreferencia());
//			System.out.println(t1.toString());
			System.out.println(show.batallaConTema(b1, b2, t1));
		}
	}

	public static Banda getBatalladorRandom(Reality show) {

		if (show.getConcursantes() > 0) {
			int bandaRandom = (int) ((Math.random() * show.getConcursantes()) + 1);
			Banda banda = show.getConcursante(bandaRandom);
			return banda;
		}
		return null;
	}

	public static TemaMusical getTemaRandom(Reality show) {

		if (show.getTemas() > 0) {
			int temaRandom = (int) ((Math.random() * show.getTemas()) + 1);
			TemaMusical tema = show.getTema(temaRandom);
			return tema;
		}
		return null;
	}

	public static ArrayList<String> asignarRandom(ArrayList<String> arr) {
		ArrayList<String> salida = new ArrayList<>();
		if (arr.size() > 0) {
			ArrayList<Integer> generados = new ArrayList<>();
			int cantRandom = (int) ((Math.random() * arr.size()) + 1);
			for (int i = 0; i < cantRandom; i++) {
				boolean generado = false;
				while (!generado) {
					int posRandom = (int) ((Math.random() * arr.size()) + 1);
					if (!generados.contains(posRandom)) {
						generado = true;
						generados.add(posRandom);
					}
				}
			}
			for (int i = 0; i < generados.size(); i++) {
				salida.add(arr.get(i));
			}
		}
		return salida;
	}

	public static ArrayList<String> cargarIdiomas() {
		ArrayList<String> idiomas = new ArrayList<>();
		idiomas.add("Espaniol");
		idiomas.add("Ingles");
		idiomas.add("Frances");
		idiomas.add("Italiano");
		idiomas.add("Portugues");
		return idiomas;
	}

	public static ArrayList<String> cargarGeneros() {
		ArrayList<String> generos = new ArrayList<>();
		generos.add("Rock");
		generos.add("Rap");
		generos.add("Melodico");
		generos.add("Pop");
		generos.add("Cumbia");
		generos.add("Reggeton");
		return generos;
	}

	public static ArrayList<String> cargarInstrumentos() {
		ArrayList<String> instrumentos = new ArrayList<>();
		instrumentos.add("Guitarra");
		instrumentos.add("Bajo");
		instrumentos.add("Bateria");
		instrumentos.add("Pandereta");
		instrumentos.add("Flauta");
		return instrumentos;
	}

	public static void cargarTemas(Reality show) {
		ArrayList<String> instrumentos = cargarInstrumentos();
		ArrayList<String> generos = cargarGeneros();
		TemaMusical t1 = new TemaMusical("Titulo 1", "Espaniol", asignarRandom(generos), asignarRandom(instrumentos));
		TemaMusical t2 = new TemaMusical("Titulo 2", "Ingles", asignarRandom(generos), asignarRandom(instrumentos));
		TemaMusical t3 = new TemaMusical("Titulo 3", "Espaniol", asignarRandom(generos), asignarRandom(instrumentos));
		TemaMusical t4 = new TemaMusical("Titulo 4", "Ingles", asignarRandom(generos), asignarRandom(instrumentos));
		TemaMusical t5 = new TemaMusical("Titulo 5", "Ingles", asignarRandom(generos), asignarRandom(instrumentos));
		TemaMusical t6 = new TemaMusical("Titulo 6", "Espaniol", asignarRandom(generos), asignarRandom(instrumentos));
		TemaMusical t7 = new TemaMusical("Titulo 7", "Espaniol", asignarRandom(generos), asignarRandom(instrumentos));
		TemaMusical t8 = new TemaMusical("Titulo 8", "Italiano", asignarRandom(generos), asignarRandom(instrumentos));
		TemaMusical t9 = new TemaMusical("Titulo 9", "Espaniol", asignarRandom(generos), asignarRandom(instrumentos));
		TemaMusical t10 = new TemaMusical("Titulo 10", "Espaniol", asignarRandom(generos), asignarRandom(instrumentos));

		show.addTemaMusical(t1);
		show.addTemaMusical(t2);
		show.addTemaMusical(t3);
		show.addTemaMusical(t4);
		show.addTemaMusical(t5);
		show.addTemaMusical(t6);
		show.addTemaMusical(t7);
		show.addTemaMusical(t8);
		show.addTemaMusical(t9);
		show.addTemaMusical(t10);
	}

	public static void cargarParticipantes(Reality show) {
		ArrayList<String> instrumentos = cargarInstrumentos();
		ArrayList<String> generos = cargarGeneros();
		ArrayList<String> idiomas = cargarIdiomas();
		Participante p1 = new Participante("nombre1", "apellido 1", 20, asignarRandom(generos),
				asignarRandom(instrumentos), asignarRandom(idiomas));
		Participante p2 = new Participante("nombre2", "apellido 2", 24, asignarRandom(generos),
				asignarRandom(instrumentos), asignarRandom(idiomas));
		Participante p3 = new Participante("nombre3", "apellido 3", 30, asignarRandom(generos),
				asignarRandom(instrumentos), asignarRandom(idiomas));
		Participante p4 = new Participante("nombre4", "apellido 4", 32, asignarRandom(generos),
				asignarRandom(instrumentos), asignarRandom(idiomas));
		Participante p5 = new Participante("nombre5", "apellido 5", 23, asignarRandom(generos),
				asignarRandom(instrumentos), asignarRandom(idiomas));
		Participante p6 = new Participante("nombre6", "apellido 6", 33, asignarRandom(generos),
				asignarRandom(instrumentos), asignarRandom(idiomas));
		Participante p7 = new Participante("nombre7", "apellido 7", 50, asignarRandom(generos),
				asignarRandom(instrumentos), asignarRandom(idiomas));
		Participante p8 = new Participante("nombre8", "apellido 8", 42, asignarRandom(generos),
				asignarRandom(instrumentos), asignarRandom(idiomas));
		Participante p9 = new Participante("nombre9", "apellido 9", 60, asignarRandom(generos),
				asignarRandom(instrumentos), asignarRandom(idiomas));
		Participante p10 = new Participante("nombre10", "apellido 10", 19, asignarRandom(generos),
				asignarRandom(instrumentos), asignarRandom(idiomas));
		
		Coach coach1 = new Coach("Coach1");
		Coach coach2 = new Coach("Coach2");
		Coach coach3 = new Coach("Coach3");
		Coach coach4 = new Coach("Coach4");
		Coach coach5 = new Coach("Coach5");
		
		coach1.addParticipante(p2);
		coach1.addParticipante(p3);
		show.addConcursante(coach1);

		coach5.addParticipante(p10);
		
		coach4.addParticipante(p8);
		coach4.addParticipante(coach5);
		coach4.addParticipante(p9);

		coach2.addParticipante(p4);
		coach2.addParticipante(coach4);
		coach2.addParticipante(p5);
		show.addConcursante(coach2);

		coach3.addParticipante(p6);
		coach3.addParticipante(p7);

		show.addConcursante(coach3);

		show.addConcursante(p1);

	}

}
