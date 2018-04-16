import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import utilidades.Leer;

/*Ejercicio 3.
Ejercicio 3.
En este ejercicio se generan los datos a partir de dos vectores de 10 nombres y 10
apellidos combinándolos al azar. Hay que generar un ArrayList de 50 alumnos para
guardar el nombre, el apellido y las notas obtenidas en tres exámenes parciales que se
puntúan entre 0 y 100.
El programa debe:
1. Generar al azar los datos de 50 alumnos. Cada alumno se almacenará en un
elemento del ArrayList. Los datos que queremos guardar de cada alumno son:
string nombre;
string apellido;
int nota1;
int nota2;
int nota3;
2. Después generar tres mapas (TreeMap), uno para cada nota, donde la key será la
nota por la que ordenamos y el dato asociado un ArrayList con los índices del
vector donde aparece esa nota (puede haber varios alumnos que tengan la misma
nota).
3. Presentar un menú para poder listar la clase por cualquiera de las tres notas en
orden ascendente, es decir ascen1ª, ascen2ª, ascen3ª.
4. Presentar en pantalla el listado requerido
De esta forma no hay que reordenar el ArrayList cada vez que se pide un tipo de
listado pues el ArrayList, aunque este desordenado, es accesible en el orden de las
notas según el mapa que se recorra.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String apellidos[] = { "Perez", "Martinez", "Monforte", "Taboada", "Rodriguez", "Buj", "Lopez", "Notivol",
				"Bezares", "Sans" };
		String nombres[] = { "Javier", "Ruben", "Juan", "Martin", "Guillermo", "Felipe", "Alberto", "Maria", "Lucia",
		"Raquel" };
		List<Alumnos> alumnos = new ArrayList<Alumnos>();
		for (int i = 0; i < 50; i++) {
			int j = (int) (Math.random() * 10);
			int k = (int) (Math.random() * 10);
			int nota1 = (int) (Math.random() * 101);
			int nota2 = (int) (Math.random() * 101);
			int nota3 = (int) (Math.random() * 101);
			alumnos.add(new Alumnos(nombres[j], apellidos[k], nota1, nota2, nota3));

		}
		
		TreeMap<Integer, ArrayList<Alumnos>> notas = new TreeMap<>();
		ArrayList<Alumnos> alumnosnota1;	
		for (int i = 0; i < alumnos.size(); i++) {

			Integer nota = alumnos.get(i).getNota1();
			Alumnos alumno = alumnos.get(i);
			if (notas.containsKey(nota)) {
				alumnosnota1 = notas.get(nota);
				alumnosnota1.add(alumno);
			} else {
				alumnosnota1 = new ArrayList<Alumnos>();
				alumnosnota1.add(alumno);
				notas.put(nota, alumnosnota1);
			}
		}
		TreeMap<String, ArrayList<Integer>> nombreCompleto = new TreeMap<>();
		ArrayList<Integer> alumnosnota2;	
		for (int i = 0; i < alumnos.size(); i++) {

			Integer nota = alumnos.get(i).getNota1();
			String alumno = alumnos.get(i).getApellidos()+" "+alumnos.get(i).getNombre();
			if (nombreCompleto.containsKey(alumno)) {
				alumnosnota2 = nombreCompleto.get(alumno);
				alumnosnota2.add(nota);
			} else {
				alumnosnota2 = new ArrayList<Integer>();
				alumnosnota2.add(nota);
				nombreCompleto.put(alumno, alumnosnota2);
			}
		}

			Leer.mostrarEnPantalla("---------------------------------");
			for (Entry<Integer, ArrayList<Alumnos>> alumnos2 : notas.entrySet()) {
			Leer.mostrarEnPantalla(alumnos2.getKey().toString());
			Leer.mostrarEnPantalla(alumnos2.getValue().toString());
			}
			Leer.mostrarEnPantalla("---------------------------------");
			for (Entry<String, ArrayList<Integer>> alumno : nombreCompleto.entrySet()) {
			Leer.mostrarEnPantalla((alumno.getKey().toString()));	
			Leer.mostrarEnPantalla(alumno.getValue().toString());
			}
		}
		
	}