
public class Libro {
	private String titulo;
	private Autor autor;
	private Double precio;
	private Integer cantidad;

	public Libro(String titulo, Autor autor, Double precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		cantidad = 0;
	}

	public Libro(String titulo, Autor autor, Double precio, Integer cantidad) {
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public String cadenaLibro() {
		String cadena = "Libro [titulo = " + titulo  +  "; precio = " + precio + " cantidad = "
				+ cantidad + "\n        " + autor.cadenaAutor() + "]";
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

}// Libro
