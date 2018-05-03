import java.util.ArrayList;

import utilidades.Fecha;

/*�	Cada tren se identifica con un n�mero de tren,  una hora de salida 
y las estaciones de salida y llegada. El n�mero de tren es �nico.*/

public class Tren implements Comparable<Tren> {
	private Integer numero;
	private String salida;
	private String llegada;
	static Integer siguiente = 1;
	private Fecha fecha;
	private ArrayList<Vagon> vagones = new ArrayList<Vagon>();

	public Tren(Fecha fecha) {
		super();
		this.salida = "10:00";
		this.llegada = "14:00";
		this.fecha = fecha;
		this.vagones.add(new Vagon());
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
	private void a�adirvagon() {
		vagones.add(new Vagon());
	}
	public void venderBillete() {
		if (vagones.get(vagones.size()-1).completo()){
			a�adirvagon();
		}
		 vagones.get(vagones.size()-1).asignarasiento();
		}

	public ArrayList<Vagon> getVagones() {
		return vagones;
	}

	public void setVagones(ArrayList<Vagon> vagones) {
		this.vagones = vagones;
	}

	@Override
	public int compareTo(Tren o) {
		// TODO Auto-generated method stub
		int num=this.numero-o.getNumero();
		if (num==0) {
			return this.fecha.getAnio()*10000 + this.fecha.getMes()*100+this.fecha.getDia()-(o.fecha.getAnio()*10000 + o.fecha.getMes()*100+o.fecha.getDia());
		}else {
			return this.numero-o.getNumero();

		}
		
		
	}
}
