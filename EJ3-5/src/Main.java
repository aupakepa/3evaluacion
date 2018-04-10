import java.util.TreeSet;

import utilidades.Leer;

import java.util.Set;

/*5) ListarNumerosEnOrden
Programa que pide números al usuario hasta que teclea el -9999. Una vez dado ese valor
escribe en orden creciente todos los elementos distintos de la secuencia de números
introducida por el usuario.
Para almacenar los números que diga el usuario se creará un objeto TreeSet<Integer>.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i;
		Set numeros = new TreeSet<Integer>();
		do {
			i = Leer.pedirEntero("introduzca un numero o teclee 9999 para finalizar");
			numeros.add(i);
		} while (i != 9999);
		Leer.mostrarEnPantalla(numeros.toString());
		
	}

}
