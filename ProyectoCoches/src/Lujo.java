/**
 * 
 */

/**
 * @author maalvarez
 *
 */
public class Lujo extends Coche {
	private Integer codigo;
	private static Integer siguiente=10001;

	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param fechaFabricacion
	 * @param precioDiario
	 */
	public Lujo(String matricula, String marca, String modelo, Fecha fechaFabricacion, Integer precioDiario) {
		super(matricula, marca, modelo, fechaFabricacion, precioDiario);
		codigo=siguiente;
		siguiente++;
		// TODO Auto-generated constructor stub
	}
	
	public String muestraCoche() {
		return "LUJO "+ super.muestraCoche() + ", código " + codigo;
	}


	/**
	 * 
	 */


}
