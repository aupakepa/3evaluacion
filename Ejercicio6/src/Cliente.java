import java.util.ArrayList;

public class Cliente {
private ArrayList<Platos> menu;
private double total;
private Integer mesa;

public Cliente(ArrayList<Platos> menu, Integer mesa) {
	super();
	this.menu = menu;
	this.mesa = mesa;
	this.factura();
}
public ArrayList<Platos> getMenu() {
	return menu;
}
public void setMenu(ArrayList<Platos> menu) {
	this.menu = menu;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public Integer getMesa() {
	return mesa;
}
public void setMesa(Integer mesa) {
	this.mesa = mesa;
}

public void factura() {
	this.total=this.menu.get(0).getPrecio()+this.menu.get(1).getPrecio();
}
@Override
public String toString() {
	return "Cliente [menu=" + menu.get(0).getNombre()+"/" +menu.get(1).getNombre() + ", total=" + total + ", mesa=" + mesa + "]";
}

}
