/**
 * 
 */

/**
 * @author maalvarez
 *
 */
public class Normal extends Coche {
	private String parking;
	
	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param fechaFabricacion
	 * @param precioDiario
	 */
	public Normal(String matricula, String marca, String modelo, Fecha fechaFabricacion, Integer precioDiario, String parking) {
		super(matricula, marca, modelo, fechaFabricacion, precioDiario);
		this.parking=parking;
		// TODO Auto-generated constructor stub
	}


	public String muestraCoche() {
		return "NORMAL "+ super.muestraCoche() + ", parking " + parking;
	}
	

}
