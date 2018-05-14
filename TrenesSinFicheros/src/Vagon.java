import java.util.Arrays;

public class Vagon {
	private Integer[] vagon;

	public Vagon(Integer numero) {//inicializa los asiento y el número de vagón
		this.vagon = new Integer[11];
		this.vagon[0] = numero;
		for (int i=1; i<11; i++){
			vagon[i]=0;
		}
	}
	
	public void borra(Integer num){//libera el asiento
		vagon[num]=0;
	}
	
	public Integer[] getVagon() {
		return vagon;
	}
	
	public Integer getVagon(int i) {
		return vagon[i];
	}
	
	public int venta(){//busca el primer asiento libre
		int asiento=-1;// si no encuentra  asientos libres devuelve -1
		for (int i=1; i<11; i++){
			if (vagon[i]==0){
				asiento=i;//devuleve el primer libre (valor 0) que encuentra
				vagon[i]=1;// lo ocupa
				break;
			}
		}
		return asiento;
	}
	
	@Override
	public String toString() {//muestra el vagón
		if(vagon[0]!=1){
			return "\n\t\t\tvagon=" + Arrays.toString(vagon);		
		}else{
			return "\tvagon=" + Arrays.toString(vagon);		
		}
	}
	
}
