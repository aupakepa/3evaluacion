
public class Lista {
private Nodo inicial;


public Lista(Nodo inicial) {
	this.inicial = inicial;
}
public Nodo getInicial() {
	return inicial;
}

public void setInicial(Nodo inicial) {
	this.inicial = inicial;
}
private String[] imprimeLista() {
	Nodo nodo;
	Integer cont=1;
	String cadena[] = new String[this.contarNodo()];

	if(this.getInicial()==null){
		cadena[0] = "lista vacia";
	}else {
		nodo=this.inicial;
		while(nodo.getNodosig()!=null){
			cadena [cont-1] ="Nodo "+cont+": "+nodo.toString();
			cont++;
			nodo=nodo.getNodosig();
		}
		cadena[cont-1]="Nodo "+cont+": "+nodo.toString();
		
	}
	return cadena;
}
//devuelve el numero de elementos de una lista

private Integer contarNodo(){
	Integer contador = 0;
	Nodo aux;
	aux=inicial;
	do {
		if (aux.getNodosig()!=null) {
			contador++;
			aux=aux.getNodosig();
		}
		else {
			contador++;
		}
	} while (aux.getNodosig()!=null);
	
	return contador;
}
public void creaNodo(Integer valor) {
	Nodo nodo, aux;
	nodo=new Nodo(valor);
	if(this.getInicial()==null){
		this.inicial=nodo;
	} else{
		aux=inicial;
		while(aux.getNodosig()!=null){
			aux=aux.getNodosig();
		}
		aux.setNodosig(nodo);
	}
}

}
