import java.util.ArrayList;

public class Platos {
	private String nombre;
	private Double precio;
	private ArrayList<Ingredientes> ingredientes;
	public Platos(String nombre, ArrayList<Ingredientes> ingredientes) {
		super();
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.establecerPrecio();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public ArrayList<Ingredientes> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	} 
	public void establecerPrecio() {
		Double precio = 1.0;
		for (Ingredientes ingredientes2 : this.ingredientes) {
			precio = precio + ingredientes2.getCoste();
		}
		
		this.setPrecio(precio);
	} 
}