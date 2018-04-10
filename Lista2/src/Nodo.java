
public class Nodo {
private String valor;
private Nodo siguiente;
public Nodo(String valor) {
	this.valor = valor;
	siguiente=null;
}
public String getValor() {
	return valor;
}
public void setValor(String valor) {
	this.valor = valor;
}
public Nodo getSiguiente() {
	return siguiente;
}
public void setSiguiente(Nodo siguiente) {
	this.siguiente = siguiente;
}
@Override
public String toString() {
	return "Nodo [valor=" + valor + ", siguiente=\n" + siguiente + "]";
}
}
