
public class Libro implements Comentable, Comparable {
	private String titulo;
	private Autor autor;
	private Double precio;
	private Integer cantidad;
	private String resena;
	private static Integer contador=0;

	public Libro(String titulo, Autor autor, Double precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		cantidad = 0;
		contador++;
	}

	public Libro(String titulo, Autor autor, Double precio, Integer cantidad) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.cantidad = cantidad;
		contador++;
	}

	
	public String cadenaLibro() {
		return "\n [titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", resena=" + resena + "]";
	}

	public static Integer getContador() {
		return contador;
	}

	public static void setContador(Integer contador) {
		Libro.contador = contador;
	}

	public String toString() {
		String cadena = "\n"+ titulo ;
		return cadena;
	}


	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Autor getAutor() {
		return autor;
	}

	@Override
	public void comentar(String texto) {
		// TODO Auto-generated method stub
		this.resena=texto;
	}

	@Override
	public String comentario() {
		// TODO Auto-generated method stub
		return "Titulo: "+titulo+"\n Reseña:" +resena;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if ( o instanceof Autor) {
			Autor autor = (Autor) o;
			return titulo.compareTo(autor.getNombre());
		}
		else {
			Libro libro = (Libro) o;
			return this.titulo.compareTo(libro.getTitulo());
		} 
	}
	

}// Libro
