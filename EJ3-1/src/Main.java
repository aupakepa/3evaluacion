import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;


/*1) EjerTresSetInt
*Programa que genera un número aleatorio de datos que consisten en números al azar con
*valores entre 1 y 15 y los va insertando:
* En un objeto de clase HashSet.
* En un objeto de clase LinkedHashSet.
* En un objeto de clase TreeSet.
*Una vez hecho hace un recorrido de cada objeto y muestra todos sus elementos.
*Muestra en pantalla el resultado de invocar al método toString de cada uno de los objetos.
*Ejemplo de ejecución:
Se van a generar 6 datos.
*Insertando:
*13 * 6 * 5 * 1 * 5 * 4 *
*Valores de objHashSet:
*1 4 5 6 13
*Valores de objLinkHashSet:
*13 6 5 1 4
*Valores de objTreeSet:
*1 4 5 6 13
*Valores de objHashSet: [1, 4, 5, 6, 13]
*Valores de objLinkHashSet: [13, 6, 5, 1, 4]
*Valores de objTreeSet: [1, 4, 5, 6, 13]*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet <Integer> has = new HashSet<Integer>();
		TreeSet <Integer> tree = new TreeSet<Integer>();
		LinkedHashSet<Integer> linked = new LinkedHashSet<Integer>();

		for (int i = 0; i < 6; i++) {
			has.add((int) (Math.random()*15+1));	
		}
		System.out.print("Valores de objHashSet: [");
		for (Integer integer : has) {
			System.out.print(integer.toString()+ "* ");
		}
		System.out.println("]");
		System.out.println("-------------------------");

		for (int i = 0; i < 6; i++) {
			linked.add((int) (Math.random()*15+1));	
		}
		System.out.print("Valores de LinkedHashSet: [");
		for (Integer integer : linked) {
			System.out.print(integer.toString()+ "* ");
		}
		System.out.println("]");
		System.out.println("-------------------------");
		for (int i = 0; i < 6; i++) {
			tree.add((int) (Math.random()*15+1));	
		}
		System.out.print("Valores de objtreeSet: [");
		for (Integer integer : tree) {
			System.out.print(integer.toString()+ "* ");
		}
		System.out.println("]");
		System.out.println("-------------------------");
	}

}
