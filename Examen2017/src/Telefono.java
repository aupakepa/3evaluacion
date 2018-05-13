import java.io.Serializable;

public class Telefono implements Serializable {
private String numero;
private String tipo;

public Telefono(String numero, String tipo) {
	super();
	this.numero = numero;
	this.tipo = tipo;
}

public String getNumero() {
	return numero;
}

public void setNumero(String numero) {
	this.numero = numero;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

@Override
public String toString() {
	return "Telefono [numero=" + numero + ", tipo=" + tipo + "]";
}

}
