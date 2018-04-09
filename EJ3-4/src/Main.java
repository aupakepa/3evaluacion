import java.util.ArrayList;
import java.util.LinkedList;

/*4) EjerDosListString
Hacer lo mismo que en el ejercicio anterior pero con conjuntos de String y asignando los
elementos al azar a partir de un vector de Strings.
Ejemplo de ejecución:
Se van a generar 3 datos.
Insertando:
este * este * bajo *
Valores de objArrayList:
este este bajo
Valores de objLinkedList:
este este bajo
Valores de objArrayList: [este, este, bajo]
Valores de objLinkedList: [este, este, bajo]*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String vector[] = { "este", "este", "bajo" };
		ArrayList<String> array = new ArrayList<String>();
		LinkedList<String> linked = new LinkedList<String>();
		
		for (int i = 0; i < vector.length; i++) {
				array.add(vector[i]);
				linked.add(vector[i]);
		}
		for (String string : linked) {
			System.out.print(string+",");
		}
		System.out.println();
		System.out.println("------------------------------");
		for (String string : array) {
			System.out.print(string+",");
		}
		System.out.println();
		System.out.println(linked.toString());
		}
	}


