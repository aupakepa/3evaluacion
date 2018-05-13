
public class Partido {
	private String nombre;
	private Integer votos;
	private Integer escanio;
	
	
	public Partido(String nombre) {
		this.nombre = nombre;
		votos=0;
		escanio=0;
	}


	public Partido(String nombre, Integer votos) {
		this.nombre = nombre;
		this.votos = votos;
		escanio=0;
	}


	@Override
	public String toString() {
		return "Partido [nombre=" + nombre + ", votos=" + votos + ", escanio=" + escanio + "]\n";
	}


	public String getNombre() {
		return nombre;
	}


	private void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getVotos() {
		return votos;
	}


	public void setVotos(Integer votos) {
		this.votos = votos;
	}


	public Integer getEscanio() {
		return escanio;
	}


	private void setEscanio(Integer escanio) {
		this.escanio = escanio;
	}
	
	public void asignaEscanio(){
		escanio++;
	}
	
	public Integer valorReparto(){
		return votos/(escanio+1);
	}
	
}
