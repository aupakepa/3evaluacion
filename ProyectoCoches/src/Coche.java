/**
 * 
 */

/**
 * @author maalvarez
 *
 */
public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	private Fecha fechaFabricacion;
	private Boolean disponible;
	private Integer precioDiario;
	
	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param fechaFabricacion
	 * @param precioDiario
	 */
	public Coche(String matricula, String marca, String modelo, Fecha fechaFabricacion, Integer precioDiario) {

		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaFabricacion = fechaFabricacion;
		this.disponible = true;
		this.precioDiario = precioDiario;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String muestraCoche() {
		String disp=(disponible)? " disponible ":" ocupado ";
		return "Coche :matricula=" + matricula + ", marca: " + marca + ", modelo:" + modelo + ", fecha fabricacion: "
				+ fechaFabricacion.fechaTexto() + disp  + ", precio diario: "+ precioDiario;
	}

	/**
	 * @return the disponible
	 */
	public Boolean getDisponible() {
		return disponible;
	}

	/**
	 * @param disponible the disponible to set
	 */
	public void alquilar() {
		this.disponible = false;
	}
	
	/**
	 * @param disponible the disponible to set
	 */
	public Integer devolver(Integer dias) {
		this.disponible = true;
		return dias*precioDiario;
	}


	
}
