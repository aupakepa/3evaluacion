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





}
