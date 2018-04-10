import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> lista = new LinkedList<Integer>();
			int cantidad = (int) (Math.random()*20+1);
			do {
				Integer numero = (int) (Math.random()*15+1);
				lista.add(numero);
				cantidad--;
			} while (cantidad>0);
			
			for (Integer i : lista) {
				System.out.println("el numero es  "+i);
			}
	System.out.println("-------------------------");
	ArrayList<Integer> lista2 = new ArrayList<Integer>();
	cantidad = (int) (Math.random()*20+1);
	do {
		Integer numero = (int) (Math.random()*15+1);
		lista2.add(numero);
		cantidad--;
	} while (cantidad>0);
	
	for (Integer i : lista2) {
		System.out.println("el numero es  "+i);
	}
}
}
