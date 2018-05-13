
public class Autor {
	private String nombre;
	private String email;
	private Character sexo;
	
	public Autor(String nombre, String email, char sexo) {
		this.nombre = nombre;
		this.email = email;
		this.sexo = sexo;
	}
	
	public Autor(String nombre, String email, String sexo) {
		this.nombre = nombre;
		this.email = email;
		this.sexo = sexo.charAt(0);
	}
	
	public String cadenaAutor(){
		return "Autor[nombre = " + nombre + ", email = " + email + ", sexo = "+ sexo + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public char getSexo() {
		return sexo;
	}
	
}
