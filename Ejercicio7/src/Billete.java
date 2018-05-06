import java.io.Serializable;

/*La venta de billetes se realiza para una fecha (utiliza la clase Fecha) en un tren concreto, un vagón y un asiento. (atributos de la clase billete: número, fecha, tren, vagón, asiento y precio) Cada billete lleva su precio y su número identificador.
•	Los billetes se pueden devolver (borrar el billete), lo que dejará el asiento correspondiente libre que serán los primeros en ser ofertados en la siguiente venta para la fecha correspondiente. Los billetes se guardan en una list o set.
•	Los billetes podrán ser ordenada por diferentes criterios: 
o	número de billete: datos de billetes (de billetes)
o	fecha, tren, vagón y asiento: (este puede salir del mapa con clave la fecha y valor que puede ser el billete).
o	tren, fecha, vagón : asientos vendidos (de billetes)*/
public class Billete implements Serializable,Separable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numBillete;
	static Integer siguiente = 1;
	private Fecha fecha;
	private Integer vagon;
	private Tren tren;
	private Integer asiento;

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Integer getVagon() {
		return vagon;
	}

	public void setVagon(Integer vagon) {
		this.vagon = vagon;
	}

	public Tren getTren() {
		return tren;
	}

	public void setTren(Tren tren) {
		this.tren = tren;
	}

	public Integer getAsiento() {
		return asiento;
	}

	public void setAsiento(Integer asiento) {
		this.asiento = asiento;
	}

	@Override
	public String toString() {
		return "Billete [numBillete=" + numBillete + ", fecha=" + fecha + ", vagon=" + vagon + ", tren=" + tren.getNumero()
				+ ", asiento=" + asiento +"]"+ "\n";
	}

	public Billete(Fecha fecha, Integer vagon, Tren tren, Integer asiento) {
		super();
		this.fecha = fecha;
		this.vagon = vagon;
		this.tren = tren;
		this.asiento = asiento;
		this.numBillete = siguiente;
		siguiente++;
	}

}
