import java.util.TreeSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author yo
 *
 */
public class Notas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> listaNombres  = new TreeMap<>();
		Map<Integer, String> notas = new TreeMap<>();
		Map<Integer, TreeSet<String>> notaLista = new TreeMap<>();
		Set<String> nombresLista = new TreeSet<>();
		String nombre,nom;
		Integer nota;
		nombre = Leer.pedirCadena("Nombre (* para terminar)");
		while(!nombre.equals("*")){ 
			nota=Leer.pedirEntero("Nota (0-10)", "[0-9]|10");
			buscaNombre(listaNombres, notas, notaLista, nombre);//controlar si el nombre ya existía 
			listaNombres.put(nombre, nota);//   inserta/actualiza en el primer mapa
			if(notas.containsKey(nota)){// tratar los dos mapas siguientes si la nota existe en el mapa
				nombresLista=notaLista.get(nota);// obtener el treemap de la nota
				nombresLista.add(nombre);// añadir el nombre al set
				nom=notas.get(nota);// obtener la cadena de nombres
				nom=nom+"//"+nombre;// concatenar el nuevo nombre
				//notas.put(nota,nom);
				notas.replace(nota, nom);// actualizar el mapa
			}else{// tratar los dos mapas siguientes si la nota NO existe en el mapa
				nombresLista = new TreeSet<>(); // crea el nuevo set
				nombresLista.add(nombre);// añadir el nombre al set
				notaLista.put(nota, (TreeSet<String>) nombresLista);// añadir el nodo de la nueva nota y set
				notas.put(nota, nombre);// añadir el nodo de la nueva nota y cadena 
			}
			nombre = Leer.pedirCadena("Nombre (* para terminar)");
		}
		
		Leer.mostrarEnPantalla("Alumnos y sus notas");
		for (Entry<String, Integer> e: listaNombres.entrySet()){// escribir el mapa de los nombres y sus notas
			Leer.mostrarEnPantalla("Alumno : "+e.getKey()+" nota "+e.getValue());
		}
		Leer.mostrarEnPantalla("---------------------\nNotas y sus alumnos separados por //");
		for (Entry<Integer, String> e: notas.entrySet()){//escribir el mapa de las notas y los nombres en cadena
			Leer.mostrarEnPantalla("Nota : "+e.getKey()+" alumnos "+e.getValue());
		}
		Leer.mostrarEnPantalla("---------------------\nNotas y sus alumnos en lista");
		for (Entry<Integer, TreeSet<String>> e: notaLista.entrySet()){// escribir el mapa de las notas y los set de nombres
			Leer.mostrarEnPantalla("Nota : "+e.getKey()+" alumnos "+e.getValue().toString());
		}
	}

	private static void buscaNombre(Map<String, Integer> listaNombres, Map<Integer, String> notas,
			Map<Integer, TreeSet<String>> notaLista, String nombre) {
		Set<String> nombresLista;
		String nom;
		Integer notant;
		if(listaNombres.containsKey(nombre)){//si el nombre se repite hay que arreglar los dos mapas de notas
			notant=listaNombres.get(nombre);// nota antigua del nombre
			// arreglar el mapa nota-set
			nombresLista=notaLista.get(notant);// recupera el set del mapa nota-set
			nombresLista.remove(nombre);//elimina del set el nombre
			if (nombresLista.isEmpty()){// si deja el set vacío solo estaba ese nombre-> hay que borrar el nodo de la nota
				notaLista.remove(notant);
			}
			// arreglar el mapa nota-cadena
			nom=notas.get(notant);// recupera el String de los nombres de la nota antigua
			nom=nom.replaceFirst(nombre, "");// borra el nombre de la cadena
			if(nom.indexOf("//")==-1){// si en la cadena no quedan // era el único nombre-> hay que borrar el nodo nota-cadena
				notas.remove(notant);
			}else if(nom.indexOf("//")==0){// si aparecen // en las primeras posiciones, hemos borrado el primer nombre.
				nom=nom.substring(2);// quitamos las // del inicio
				notas.put(notant, nom);// actualizamos el nodo nota-cadena
			}else if(nom.indexOf("//")==nom.length()-2){// si aparecen // en las últimas posiciones, hemos borrado el último nombre.
				nom=nom.substring(0,nom.length()-2);// eliminamos las // del final
				notas.put(notant, nom);// actualizamos el nodo nota-cadena
			}else {// el nombre estaba en medio
				nom=nom.replaceFirst("////", "//");// habrán quedado cuatro / seguidas, las dejamos en dos
				notas.put(notant, nom);// actualizamos el nodo nota-cadena
			}
		}
	}
}
