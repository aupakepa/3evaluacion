
public class Autor implements Comentable, Comparable {
	private String nombre;
	private String email;
	private Character sexo;
	private String biografia;
	private static Integer siguiente=0;
	
	public Autor(String nombre, String email, char sexo) {
		this.nombre = nombre;
		this.email = email;
		this.sexo = sexo;
		this.biografia=null;
		siguiente++;
	}
	
	public Autor(String nombre, String email, String sexo) {
		this.nombre = nombre;
		this.email = email;
		this.sexo = sexo.charAt(0);
		this.biografia=null;
		siguiente++;
	}
	
	@Override
	public String toString() {
		return "\n" + nombre ;
	}

	public static Integer getSiguiente() {
		return siguiente;
	}

	public static void setSiguiente(Integer siguiente) {
		Autor.siguiente = siguiente;
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

	@Override
	public void comentar(String texto) {
		// TODO Auto-generated method stub
		this.biografia=texto;
	}

	@Override
	public String comentario() {
		// TODO Auto-generated method stub
		return "Nombre: "+nombre+"\n Biografia:" +biografia;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		
		if ( o instanceof Autor) {
			Autor autor = (Autor) o;
			return nombre.compareTo(autor.getNombre());
		}
		else {
			Libro libro = (Libro) o;
			return this.nombre.compareTo(libro.getTitulo());
		} 
	}
	
}
