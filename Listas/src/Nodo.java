
public class Nodo {

private int valor;
private Nodo siguientenodo;

public Nodo(int valor) {
	this.valor = valor;
	siguientenodo=null;
}

public int getValor() {
	return valor;
}

public void setValor(int valor) {
	this.valor = valor;
}

public Nodo getSiguientenodo() {
	return siguientenodo;
}

public void setSiguientenodo(Nodo siguientenodo) {
	this.siguientenodo = siguientenodo;
}
@Override
public String toString() {
	return "Nodo [valor=" + valor + ", siguientenodo=\n" + siguientenodo + "]";
}
}
