import utilidades.Leer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Nodo lista = null;
		Nodo aux = null;
		for (int i = 0; i < 10; i++) {
			Nodo nodo = new Nodo(Leer.pedirCadena("Introduce una cadena"));
			aux = lista;
			if (lista == null) {
				lista = nodo;
			} else {
				while (aux.getSiguiente() != null) {
					aux = aux.getSiguiente();
				}
				aux.setSiguiente(nodo);
			}
			Leer.mostrarEnPantalla(lista.toString());
		}
	}
}
