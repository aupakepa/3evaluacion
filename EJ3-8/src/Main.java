import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import utilidades.Leer;

/*7) TreemapNotasAlumnosPorApellido
Escribe un programa en Java que:
 Pida el apellido (se supone que no se repiten) y la calificación obtenida por un alumno.
La entrada de datos terminará cuando se introduzca como apellido “*”.
 Muestre un listado por orden alfabético de los datos de cada alumno.*/
/*8) TreemapNotasAlumnosPorNota
Modifica el programa del ejercicio anterior para que podamos mostrar un listado ordenado
por notas, teniendo en cuenta que puede haber repeticiones de notas.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Double, ArrayList<String>> notas = new TreeMap<>();
		Map<String, ArrayList<Double>> alumnos = new TreeMap<>();

		String apellido;
		ArrayList<String> apellidos = new ArrayList<String>();
		ArrayList<Double> listanotas = new ArrayList<Double>();
		Double nota = .0;
		int menu =-1;
		do {
			Leer.mostrarEnPantalla("1. introducir notas");
			Leer.mostrarEnPantalla("2. eliminar notas");
			Leer.mostrarEnPantalla("3. modificar notas");
			Leer.mostrarEnPantalla("4. imprimir notas");
			Leer.mostrarEnPantalla("0. introducir notas");
			menu=Leer.pedirEntero("introduzca la opcion de menu");
			switch (menu) {
			case 1:
				do {
					apellido = Leer.pedirCadena("introduzca el apellido");
					if (!apellido.equals("*")) {
						nota = Leer.pedirDouble("introduzca la nota", "([0-9].?[0-9]?)|10");
						if (notas.containsKey(nota)) {
							notas.get(nota).add(apellido);
						} else {
							apellidos = new ArrayList<String>();
							apellidos.add(apellido);
							notas.put(nota, apellidos);
						}
						if (alumnos.containsKey(apellido)) {
							listanotas.add(nota);
						} else {
							listanotas = new ArrayList<Double>();
							listanotas.add(nota);
							alumnos.put(apellido, listanotas);
						}
					}
				} while (!apellido.equals("*"));

				break;

			case 2:
				String alumno= Leer.pedirCadena("introduzca el alumno a modificar");
				alumnos.remove(alumno);
				Iterator<Entry<Double, ArrayList<String>>> it = notas.entrySet().iterator();
				while (it.hasNext()) {
					ArrayList<String> e=it.next().getValue();
					Iterator<String> it2 =e.iterator();
					while (it2.hasNext()) {
						String d=it2.next();
						if (d.equals(alumno)) {
							it2.remove();
						}
					}
				}
				break;

			case 3:
				alumno= Leer.pedirCadena("introduzca el alumno a modificar");
				ArrayList<Double> notasnueva=alumnos.get(alumno);
				alumnos.remove(alumno);
				alumnos.put(Leer.pedirCadena("introduzca la modificacion"), notasnueva);
				it = notas.entrySet().iterator();
				while (it.hasNext()) {
					ArrayList<String> e=it.next().getValue();
					Iterator<String> it2 =e.iterator();
					while (it2.hasNext()) {
						String d=it2.next();
						if (d.equals(alumno)) {
						}
					}
				}
				break;

			case 4:
				Leer.mostrarEnPantalla(alumnos.toString());
				Leer.mostrarEnPantalla("---------------------");
				Leer.mostrarEnPantalla(notas.toString());
				break;

			case 0:
				
				break;

			default:
				break;
			}
		} while (menu!=0);
		
		System.out.println(notas);

	}

}