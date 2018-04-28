
public class Ingredientes  {

	private String nomIngred;
	private double coste;
	public String getNomIngred() {
		return nomIngred;
	}
	public void setNomIngred(String nomIngred) {
		this.nomIngred = nomIngred;
	}
	public double getCoste() {
		return coste;
	}
	public void setCoste(double coste) {
		this.coste = coste;
	}
	public Ingredientes(String nomIngred, double coste) {
		this.nomIngred = nomIngred;
		this.coste = coste;
	}
}