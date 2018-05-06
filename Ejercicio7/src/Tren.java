import java.io.Serializable;
import java.util.ArrayList;


/*•	Cada tren se identifica con un número de tren,  una hora de salida 
y las estaciones de salida y llegada. El número de tren es único.*/

public class Tren implements Comparable<Tren>,Serializable,Separable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numero;
	private String salida;
	private String llegada;
	static Integer siguiente = 1;
	private ArrayList<Vagon> vagones = new ArrayList<Vagon>();

	public Tren() {
		super();
		this.salida = "10:00";
		this.llegada = "14:00";
		this.vagones.add(new Vagon(this));
		this.numero=siguiente;
		siguiente++;
	}

	@Override
	public String toString() {
		return numero+getSeparador()+salida+getSeparador()+llegada+getSeparador()+vagones+getSeparador()+siguiente+"\n";

	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getLlegada() {
		return llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}
	public void añadirvagon() {
		this.vagones.add(new Vagon(this));
	}
	public void venderBillete() {
		
		 vagones.get(this.buscarVagon()).asignarasiento(this);
		 if (this.trenCompleto()) {
				this.añadirvagon();
			}
		}
	public Integer buscarVagon() {
		int vagon=vagones.size()-1;
		for (int i = vagones.size()-1; i >=0 ; i--) {
					if (!vagones.get(i).completo()) {
						vagon=i;
					}
				}
		return vagon;
			}
	public boolean trenCompleto() {
		boolean completo=true;
		for (int i = 0; i < vagones.size(); i++) {
			if (!vagones.get(i).completo()) {
				completo=false;
			}
		}
		return completo;
	}
	public void anularBillete(Integer vagon,Integer asiento) {
		 vagones.get(vagones.size()-1).asignarasiento(this);
		}
	public ArrayList<Vagon> getVagones() {
		return this.vagones;
	}

	public void setVagones(ArrayList<Vagon> vagones) {
		this.vagones = vagones;
	}

	@Override
	public int compareTo(Tren tren) {
		// TODO Auto-generated method stub
		return this.numero-tren.getNumero();
	}
}
