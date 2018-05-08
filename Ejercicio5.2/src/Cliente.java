public class Cliente {

	private String nombre;
	private Integer tipo;
	private Integer cola;
	static Integer numero = 1;

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getCola() {
		return cola;
	}

	public void setCola(Integer cola) {
		this.cola = cola;
	}

	public Cliente(Integer tipo, Integer cola) {
		super();
		this.tipo = tipo;
		this.cola = cola;
		this.nombre = "cliente"+numero;
		this.numero++;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static Integer getNumero() {
		return numero;
	}

	public static void setNumero(Integer numero) {
		Cliente.numero = numero;
	}

	public void atencion() {
		this.tipo--;
	}
	public boolean terminado(){
		if(this.tipo==0){
			return true;
		}else{
			return false;
		}
		
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", tipo=" + tipo + ", cola=" + cola + "]";
	}
}