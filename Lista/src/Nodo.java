/**
 * 
 */

/**
 * @author yo
 *
 */
public class Nodo {
	private Integer valor;
	private Nodo nodosig;
	
	
	public Nodo(Integer valor) {
		this.valor = valor;
		this.nodosig = null;
	}


	@Override
	public String toString() {
		return "valor=" + valor ;
	}


	public Integer getValor() {
		return valor;
	}


	public void setValor(Integer valor) {
		this.valor = valor;
	}


	public Nodo getNodosig() {
		return nodosig;
	}


	public void setNodosig(Nodo nodosig) {
		this.nodosig = nodosig;
	}
	
	
}
