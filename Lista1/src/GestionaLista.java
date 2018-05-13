import java.util.Arrays;

/**
 * @author yo
 *
 */
public class GestionaLista {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Lista lista = new Lista();
		Nodo nodo;
		Integer valor=0,opcion,pos;
		String[] salida;
		
		do{
			opcion=menu();
			switch (opcion){
			case 1:
				valor=Leer.pedirEntero("N�mero a a�adir a la lista",null);
				nodo=new Nodo(valor);
				lista.anadeNodo(nodo);
				break;
			case 2:
				valor=Leer.pedirEntero("N�mero a borrar de la lista",null);
				nodo=new Nodo(valor);
				Leer.mostrarEnPantalla(lista.borraNodo(nodo));
				break;
			case 3:
				valor=Leer.pedirEntero("N�mero a buscar en la lista ",null);
				nodo=new Nodo(valor);
				pos=lista.buscaNodo(nodo);
				if (pos==-1){
					Leer.mostrarEnPantalla("El n�mero "+nodo.getValor()+" no est� en la lista");
				} else {
					Leer.mostrarEnPantalla("El n�mero "+nodo.getValor()+" est� en la posici�n "+pos);
				}				
				break;
			case 4:
				salida = lista.imprimeLista();
				Leer.mostrarEnPantalla(Arrays.toString(salida));
				break;
			}
		} while(opcion!=0);
	}
	
	private static Integer menu(){
		Integer opcion;
		Leer.mostrarEnPantalla("1- A�adir elemento a la lista");
		Leer.mostrarEnPantalla("2- Borrar elemento de la lista");
		Leer.mostrarEnPantalla("3- Buscar elemento en la lista");
		Leer.mostrarEnPantalla("4- Imprimir la lista");
		Leer.mostrarEnPantalla("0- Salir");
		opcion=Leer.pedirEntero("Escoge opci�n", "[0-4]");
		return opcion;
	}

}
