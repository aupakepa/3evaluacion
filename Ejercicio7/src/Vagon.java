import java.util.Arrays;

public class Vagon {
	private Integer num;
	private Integer asientos [] = {0,0,0,0,0,0,0,0,0,0,0};
	private Integer proximoasiento;
	private Integer siguiente=1;
	public Integer getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Integer siguiente) {
		this.siguiente = siguiente;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer[] getAsientos() {
		return asientos;
	}
	public void setAsientos(Integer[] asientos) {
		this.asientos = asientos;
	}
	@Override
	public String toString() {
		return "Vagon [num=" + num + ", asientos=" + Arrays.toString(asientos) + "]";
	}
	public Vagon() {
		super();
		this.num = siguiente;
		asientos[0]=this.num;
		siguiente++;
		this.proximoasiento=1;
	}
	public Integer getProximoasiento() {
		return proximoasiento;
	}
	public void setProximoasiento(Integer proximoasiento) {
		this.proximoasiento = proximoasiento;
	}
	public boolean completo() {
		boolean completo= true;
		for (int i = 1; i < asientos.length; i++) {
			if (asientos[i]==0) {
			completo=false;	
			}
		}
		return completo;
	}
	public void asignarasiento() {
		this.asientos[proximoasiento]=proximoasiento;
		proximoasiento++;
	}
	
}
