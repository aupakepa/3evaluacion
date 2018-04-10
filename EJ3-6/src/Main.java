import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import utilidades.Leer;

/*6) ListarNumPalabrasOrdenadas
Escribe un programa en Java que:
 Pida al usuario que introduzca un número indeterminado de palabras. La introducción
de datos terminará cuando introduzca un “*” (que por supuesto no se tendrá en
cuenta para hacer lo que se pide en el ejercicio).
 Pida que se diga un número entero positivo num que no puede ser mayor que el
número de palabras distintas que se han dado.
 Muestre las num primeras palabras en orden alfabético de la lista de palabras que ha
dado el usuario.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word;
		Set<String> palabras= new TreeSet<String>();
		int numero;
		do {
			word = Leer.pedirCadena("Introduzca una palabra o presione *");
			if (!word.equals("*")) {
				palabras.add(word);	
			}
		} while (!word.equals("*"));
		
		do {
			numero = Leer.pedirEntero("introduzca el numero de palabras");
		} while (numero < 0 || numero > palabras.size());
		
		Iterator<String> it = palabras.iterator();
		
		for (int i = 0; i < numero; i++) {
			String cadena= it.next();
			Leer.mostrarEnPantalla(cadena+" ");
		}
	}

}
