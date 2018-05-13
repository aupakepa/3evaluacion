import java.util.Arrays;

/**
 * @author yo
 *
 */
public class Lista {
	Nodo inicio;//Nodo de inicio de la lista
	
	public Lista(){
		inicio=null;//cuando se construye la lista pero sin un nodo, en vacío
	}
	
	public Lista(Nodo nodo){
		inicio=nodo;//Cuando se inicia la lista con un nodo
	}
	
	public Boolean listaVacia(){//Para saber si la lista está vacía
		Boolean vacia=false;
		if (inicio==null){
			vacia=true;
		}
		return vacia;
	}
	
	public void anadeNodo(Nodo nodo) {//añade el nodo pasado, al inicio si la lista está vacía o al final de la lista
		Nodo aux;
		if(this.listaVacia()){
			inicio=nodo;
		} else{
			aux=inicio;
			while(aux.getNodosig()!=null){
				aux=aux.getNodosig();
			}
			aux.setNodosig(nodo);
		}
	}
	
	public String[] imprimeLista() {//devuelve un vector de cadenas. En cada elemento el contenido de un nodo
		Nodo aux;
		Integer cont=1;
		String [] salida = new String[1];

		if(this.listaVacia()){
			salida[0]="Lista vacía\n";
		}else {
			aux=inicio;
			while(aux.getNodosig()!=null){
				salida[cont-1]="Nodo "+cont+": "+aux.toString()+"\n";
				cont++;
				salida=Arrays.copyOf(salida, cont);
				aux=aux.getNodosig();
			}
			salida[cont-1]="Nodo "+cont+": "+aux.toString()+"\n";
		}
		return salida;
	}
	
	public Integer buscaNodo(Nodo nodo) {// devuelve la posición de la primera vez que aparece el valor del nodo pasado.
		//Si no está devuelve -1
		Nodo aux;
		Integer pos=-1,cont;
		if(!this.listaVacia()){
			aux=inicio;
			cont=1;
			do {
				if(aux.getValor().equals(nodo.getValor())){//compara los velores del nodo pasado y el que recorremos
					pos=cont;
					break;
				}
				cont++;
				aux=aux.getNodosig();
			} while(aux!=null);
		}
		return pos;
	}
	
	public String borraNodo(Nodo nodo) {// borra el primer nodo que encuentra con el valor del nodo pasado
		Nodo aux=null;
		String salida=null;
		Integer pos;
		pos=this.buscaNodo(nodo);
		if(pos==-1){//cuando no está el nodo en la lista
			salida="El nodo no está en la lista";
		} else if(pos==1) {//cuando el nodo está en el inicio de la lista
			inicio = inicio.getNodosig();
			salida="El nodo 1 con valor "+nodo.getValor()+", borrado.";
		} else {//cuando el nodo está en otra posición de la lista
			aux=inicio;
			for (int i = 1; i<pos-1; i++){
				aux=aux.getNodosig();
			}
			aux.setNodosig(aux.getNodosig().getNodosig());//ponemos en siguiente(anterior al encintrado), el siguiente (del que borramos) del siguiente (el borrado) 
			salida="El nodo "+pos+" con valor "+nodo.getValor()+", borrado";
		}
		return salida;
	}

}
