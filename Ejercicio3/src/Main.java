import java.util.ArrayList;
import java.util.List;

import utilidades.Leer;

/*Ejercicio 3.
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
int nota3;*/
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
for (Alumnos alumno : alumnos) {
	Leer.mostrarEnPantalla(alumno.toString());
}
	}

}
