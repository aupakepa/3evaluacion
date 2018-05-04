import java.util.ArrayList;

import utilidades.Fecha;


/*•	Cada tren se identifica con un número de tren,  una hora de salida 
y las estaciones de salida y llegada. El número de tren es único.*/

public class Tren implements Comparable<Tren>{
	private Integer numero;
	private String salida;
	private String llegada;
	static Integer siguiente = 1;
	private Fecha fecha;
	private ArrayList<Vagon> vagones = new ArrayList<Vagon>();

	public Tren(Fecha fecha) {
		super();
		this.fecha=fecha;
		this.salida = "10:00";
		this.llegada = "14:00";
		this.vagones.add(new Vagon(this));
		this.numero=siguiente;
		siguiente++;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Tren [numero=" + numero + ", salida=" + salida + ", llegada=" + llegada + ", fecha=" + fecha
				+ ", vagones=" + vagones + "]";
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
		 vagones.get(vagon-1).getAsientos()[asiento]=0;
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
