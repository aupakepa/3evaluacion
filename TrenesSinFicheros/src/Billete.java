
public class Billete {
	private String numeroTren;
	private Fecha fecha;
	private Integer vagon;
	private Integer asiento;
	private Integer numeroBillete;
	private static Integer siguiente=1000;//comienzo de billetes
	
	
	public Billete(String numeroTren, Fecha fecha, Integer vagon, Integer asiento) {
		this.numeroTren = numeroTren;
		this.fecha = fecha;
		this.vagon = vagon;
		this.asiento = asiento;
		numeroBillete=siguiente;
		siguiente++;
	}

	public Billete(String numeroTren, Fecha fecha, String vagonYasiento) {//crea un billete con la reserva de asiento, vagón, tren en la fecha correspondiente
		int posicion=vagonYasiento.indexOf(" ");
		this.numeroTren = numeroTren;
		this.fecha = fecha;
		this.vagon = Integer.parseInt(vagonYasiento.substring(0, posicion));
		this.asiento = Integer.parseInt(vagonYasiento.substring(posicion+1));
		numeroBillete=siguiente;
		siguiente++;
	}

	public String getNumeroTren() {
		return numeroTren;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public Integer getVagon() {
		return vagon;
	}

	public Integer getAsiento() {
		return asiento;
	}

	public Integer getNumeroBillete() {
		return numeroBillete;
	}

	public static void setSiguiente(Integer siguiente) {
		Billete.siguiente = siguiente;
	}

	@Override
	public String toString() {//muestra el billete
		return "Billete [numeroTren=" + numeroTren + ", fecha=" + fecha.fechaTexto() + ", vagon=" + vagon + ", asiento=" + asiento
				+ ", numeroBillete=" + numeroBillete + "]\n";
	}
}
