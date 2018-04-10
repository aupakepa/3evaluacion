import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utilidades.Leer;

/*Ejercicio 2
Este ejercicio pretende desarrollar el programa de cálculo de escaños en unas
elecciones, teniendo como datos de entrada: El número de partidos que se presentan
(N), el número de escaños a repartir (M) y los votos que ha obtenido cada partido
A partir de aquí, hay que hacer lo siguiente se dividen los votos de cada partido entre
1, 2, 3....M y se obtienen M divisiones y así sucesivamente para el partido 2,3,...N es
decir se obtendrán NxM cocientes, y de esos cocientes se eligen los M mayores, puesto
que hay M diputados a repartir
Un ejemplo sería el siguiente:
PARTIDOS: 4
ESCAÑOS: 5
Partidos 1 2 3 4 5
Part1 10000 5000 3333 2500 2000
Part2 25000 12500 8333 6250 5000
Part3 30000 15000 10000 7500 6000
Part4 12000 6000 4000 3000 2400
Una vez hechos los cálculos habrá que ver a qué partidos le corresponden los 5
mayores cocientes.
El listado de resultados debe hacerse ordenado por número de votos.
Los partidos que no obtengan un 5% de los votos emitidos deben rechazarse, y no
entrarán en el reparto de escaños.
NOTA: Obligatorio el uso de colecciones para resolverlo, se puede usar un TreeMap
donde la clave es el cociente y el valor asociado un arrayList que en cada elemento
guarda el nombre del partido a quien pertenece ese cociente. El mapa debe estar
ordenado por los valores de los cocientes de mayor a menor. Si hay M escaños los M
primeros elementos de los ArrayList que se guardan en el mapa nos indican a quien
corresponden los escaños. En este ejercicio nos interesa recorrer los primeros nodos
del mapa y llevar la cuenta del número de elementos recorridos de los ArrayList que
van asociados a cada nodo porque cuando tengamos 5 en total se termina.
Se pueden utilizar otros enfoques con colecciones para resloverlo.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Partidos> electoral = new TreeSet<Partidos>();
		int numPart = Leer.pedirEntero("Introduzca el numero de partidos");
		int numVotos = Leer.pedirEntero("introduzca el numero de votos");
		int numEscanos = Leer.pedirEntero("introduzca el numero de escaños");
		
		for (int i = 0; i < numPart; i++) {
		String nombre = "Partido"+(i+1);
		Integer votos = (int) (numVotos*Math.random());
		numVotos = numVotos - votos;
		electoral.add(new Partidos(nombre, votos));
		}
		
		for (Partidos partido : electoral) {
			Leer.mostrarEnPantalla(partido.getNombre()+" " + partido.getEscanos() +"  "+ partido.getVotos());
		}
		
		for (int i = 0; i < numEscanos; i++) {
			Iterator<Partidos> it = electoral.iterator();
			it.next().asignarEscanos();
		}
		for (Partidos partidos : electoral) {
			Leer.mostrarEnPantalla(partidos.getNombre()+" " + partidos.getEscanos() +"  "+ partidos.getVotos()+partidos.getReparto());
		}
	}

}
