
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utilidades.Leer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Partidos> electoral = new ArrayList<Partidos>();
		int numPart = Leer.pedirEntero("Introduzca el numero de partidos");
		int numVotos = Leer.pedirEntero("introduzca el numero de votos");
		int numEscanos = Leer.pedirEntero("introduzca el numero de escaños");

		for (int i = 0; i < numPart; i++) {
			String nombre = "Partido" + (i + 1);
			Integer votos = (int) (numVotos * Math.random());
			numVotos = numVotos - votos;
			electoral.add(new Partidos(nombre, votos));
		}

		for (Partidos partidos : electoral) {
			Leer.mostrarEnPantalla(partidos.getNombre() + " " + partidos.getVotos());
		}
		int mayor = 0;
		for (int j = 0; j < numEscanos; j++) {
			for (int i = 0; i < electoral.size(); i++) {
				if (electoral.get(i).getReparto() > electoral.get(mayor).getReparto()) {
					mayor = i;
				}
			}
			electoral.get(mayor).asignarEscanos();
		}
		Leer.mostrarEnPantalla("--------------------------------");
		for (Partidos partidos : electoral) {
			Leer.mostrarEnPantalla(partidos.getNombre()+" "+partidos.getEscanos()+" "+partidos.getVotos()+" "+partidos.getReparto());
		}
	}
}

