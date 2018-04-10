import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import utilidades.Leer;
/*7) TreemapNotasAlumnosPorApellido
Escribe un programa en Java que:
 Pida el apellido (se supone que no se repiten) y la calificación obtenida por un alumno.
La entrada de datos terminará cuando se introduzca como apellido “*”.
 Muestre un listado por orden alfabético de los datos de cada alumno.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Double> notas = new TreeMap<>();
		String apellido;
		Double nota=.0;
		do {
			apellido=Leer.pedirCadena("introduzca el apellido");
			if (!apellido.equals("*")) {
			nota = Leer.pedirDouble("introduzca la nota", "([0-9].[0-9])|10");
			notas.put(apellido, nota);
			}
		} while (!apellido.equals("*"));
		
			System.out.println(notas);
	}

}
