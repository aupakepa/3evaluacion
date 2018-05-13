import java.io.Serializable;

public class Persona implements Comparable<Persona>, Serializable{

	private String nombre;
	private String sexo;
	@Override
	
	
	public int compareTo(Persona arg0) {
		// TODO Auto-generated method stub
		return this.nombre.compareToIgnoreCase(arg0.nombre);
	}
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
		this.sexo = null;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", sexo=" + sexo + "]";
	}

}
