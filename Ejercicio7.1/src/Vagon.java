import java.io.Serializable;
import java.util.Arrays;

public class Vagon implements Serializable {
	private Integer num;
	private Integer asientos[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };


	public Integer getNum() {
		return this.num;
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

	public Vagon(Tren tren) {
		super();
		this.num = tren.getVagones().size()+1;
		asientos[0] = this.num;
	}
	public boolean completo() {
		boolean completo = true;
		for (int i = 1; i < asientos.length; i++) {
			if (asientos[i] == 0) {
				completo = false;
			}
		}
		return completo;
	}

	public void asignarasiento(Tren tren) {
		
		this.asientos[this.asientoVacio()] = this.asientoVacio();	
	}
 public Integer asientoVacio() {
	 Integer asiento=null;
	 for (int i = asientos.length-1; i > 0 ; i--) {
		if (asientos[i]==0) {
			asiento=i;
		}
	}
	 return asiento;
 }
}
