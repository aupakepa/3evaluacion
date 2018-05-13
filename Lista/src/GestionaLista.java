/**
 * 
 */

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
		Nodo lista=null;

		Integer valor=0;
		valor=Leer.pedirEntero("Primer número de la lista (-1 para finalizar)");
		while(valor!=-1){
			lista = creaNodo(lista, valor);
			valor=Leer.pedirEntero("Siguiente número (-1 para finalizar)");
		}
		imprimeLista(lista);
		
	}

	private static void imprimeLista(Nodo lista) {
		Nodo nodo;
		Integer cont=1;

		if(lista==null){
			Leer.mostrarEnPantalla("Lista vacía");
		}else {
			nodo=lista;
			while(nodo.getNodosig()!=null){
				Leer.mostrarEnPantalla("Nodo "+cont+": "+nodo.toString());
				cont++;
				nodo=nodo.getNodosig();
			}
			Leer.mostrarEnPantalla("Nodo "+cont+": "+nodo.toString());
			
		}
	}

	private static Nodo creaNodo(Nodo lista, Integer valor) {
		Nodo nodo, aux;
		nodo=new Nodo(valor);
		if(lista==null){
			lista=nodo;
		} else{
			aux=lista;
			while(aux.getNodosig()!=null){
				aux=aux.getNodosig();
			}
			aux.setNodosig(nodo);
		}
		return lista;
	}

}
