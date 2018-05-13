import java.util.Arrays;

/**
 * 
 */

/**
 * @author maalvarez
 *
 */
public class Almacen {
	private String nombre;
	private String direcion;
	private Mueble[] muebles;
	private Integer sig;
	
	
	/**
	 * @param nombre
	 * @param direcion
	 */
	public Almacen(String nombre, String direcion) {
		this.nombre = nombre;
		this.direcion = direcion;
		muebles= new Mueble[10];
		sig=0;
	}

	/**
	 * @return atributos del almacén
	 */
	public String muestraAlmacen() {
		return "Almacen : " + nombre + ", direcion=" + direcion ;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @param nombre the nombre to set
	 */
	public String asignaMueble(Mueble mueble) {
		String texto=mueble.muestraMueble();
		if (mueble.getAsignado()){
			texto=texto+" ya asignado a un almacén";
		}else{
			if(sig>muebles.length*0.8){
				this.muebles=Arrays.copyOf(muebles, muebles.length+10);
			}
			this.muebles[sig]=mueble;
			mueble.setAsignado(true);
			sig++;		
			texto=texto+ " asignado al "+muestraAlmacen();
		}
		return texto;
	}

	/**
	 * @return the muebles
	 */
	public Mueble[] getMuebles() {
		return muebles;
	}

	/**
	 * @param muebles the muebles to set
	 */
	private void setMuebles(Mueble[] muebles) {
		this.muebles = muebles;
	}

	/**
	 * @return the sig
	 */
	public Integer getSig() {
		return sig;
	}

	/**
	 * @param sig the sig to set
	 */
	private void setSig(Integer sig) {
		this.sig = sig;
	}
}
