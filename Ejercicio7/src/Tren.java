import java.util.ArrayList;


/*•	Cada tren se identifica con un número de tren,  una hora de salida 
y las estaciones de salida y llegada. El número de tren es único.*/

public class Tren {
	private Integer numero;
	private String salida;
	private String llegada;
	static Integer siguiente = 1;
	private ArrayList<Vagon> vagones = new ArrayList<Vagon>();

	public Tren() {
		super();
		this.salida = "10:00";
		this.llegada = "14:00";
		this.vagones.add(new Vagon());
		this.numero=siguiente;
		siguiente++;
	}

	@Override
	public String toString() {
		return "Tren [numero=" + numero + ", salida=" + salida + ", Llegada=" + llegada + "]";
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
	private void añadirvagon() {
		vagones.add(new Vagon());
	}
	public void venderBillete() {
		if (vagones.get(vagones.size()-1).completo()){
			añadirvagon();
		}
		 vagones.get(vagones.size()-1).asignarasiento();
		}

	public ArrayList<Vagon> getVagones() {
		return vagones;
	}

	public void setVagones(ArrayList<Vagon> vagones) {
		this.vagones = vagones;
	}
}
