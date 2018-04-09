import java.util.ArrayList;
import java.util.LinkedList;

/*3) EjerDosListInt
Programa que genera un número aleatorio de datos que consisten en números al azar con
valores entre 1 y 15 y los va insertando:
 En un objeto de clase ArrayList.
 En un objeto de clase LinkedList.
Ejercicios básicos de Conjuntos y Mapas Página 2 de 3
Una vez hecho hace un recorrido de cada objeto y muestra todos sus elementos.
Muestra en pantalla el resultado de invocar al método toString de cada uno de los objetos.
Ejemplo de ejecución:
Se van a generar 14 datos.
Insertando:
15 * 4 * 9 * 1 * 6 * 12 * 13 * 15 * 1 * 11 * 5 * 8 * 12 * 8 *
Valores de objArrayList:
15 4 9 1 6 12 13 15 1 11 5 8 12 8
Valores de objLinkedList:
15 4 9 1 6 12 13 15 1 11 5 8 12 8
Valores de objArrayList: [15, 4, 9, 1, 6, 12, 13, 15, 1, 11, 5, 8, 12, 8]
Valores de objLinkedList: [15, 4, 9, 1, 6, 12, 13, 15, 1, 11, 5, 8, 12, 8]*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> array = new ArrayList<Integer>();
		LinkedList <Integer> linked = new LinkedList <Integer> ();
		
		for (int i = 0; i < 15; i++) {
			array.add((int)(Math.random()*15)+1);
			linked.add((int)(Math.random()*15)+1);
		}
		System.out.println("-------------------------------");
		for (Integer integer : array) {
			System.out.print(integer+" ");
		}
		System.out.println();
		System.out.println("-------------------------------");
		for (Integer integer : linked) {
			System.out.print(integer+" ");
		}
		System.out.println();
		System.out.println("-------------------------------");
		
		System.out.println(linked.toString());
		System.out.println(array.toString());
	}

}
