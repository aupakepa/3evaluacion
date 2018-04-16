import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import utilidades.Leer;

/*Implementar el tipo abstracto de datos pila de enteros (se podrán almacenar un
número indeterminado de números enteros y a la hora de extraer información el
último elemento que se haya añadido será el primero en salir) con las operaciones de:
 Apilar en la cima
 Desapilar de la cima
 Número de elementos apilados
 Visualización de elementos de la pila. Tener en cuenta que al mostrar un
elemento de una pila lo borramos.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> pila = new ArrayList<Integer>();
		Integer numero;
		int key=-1;
		do {
			numero= Leer.pedirEntero("introduzca un entero o presione 9999 para finalizar");
			if (numero!=9999) {
				pila.add(0, numero);
			}
		} while (numero!=9999);

		do {
			Leer.mostrarEnPantalla("1. Introducir elementos");
			Leer.mostrarEnPantalla("2. Sacar elementos");
			Leer.mostrarEnPantalla("0. Salir");
			Leer.mostrarEnPantalla("-------------------------------------");
			key=Leer.pedirEntero("introduzca una opcion");
			switch (key) {
			case 1:
				numero= Leer.pedirEntero("introduzca un entero");
				pila.add(0, numero);
				Leer.mostrarEnPantalla(numero+" insertado");
				break;
			case 2:
				numero =(int) pila.get(0);
				pila.remove(0);
				Leer.mostrarEnPantalla(numero + " eliminado");
				for (Object numero2 : pila) {
					Leer.mostrarEnPantalla(numero2.toString());
				}
				break;	
			case 3:
				Iterator<Integer> it = pila.iterator();
				for (int i = 0; i < pila.size(); i++) {
					int numero2 = it.next();
					if (numero2 % 2 != 0) {
						it.remove();
					}
				}
				for (Integer integer : pila) {
					Leer.mostrarEnPantalla(integer.toString());
				}


				break;	
			case 0:

				break;
			default:
				break;	
			}
		} while (key!=0);
	}

}
