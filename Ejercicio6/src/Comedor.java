import java.util.ArrayList;

import utilidades.Leer;

/*1.	Escribe un proyecto en Java que tenga: 
Una clase llamada Comedor en la que estará el método public static void main() 
y en la que se instanciarán los objetos de las clases que sean necesarias para:
•	El restaurante elabora una serie de platos que se componen de los productos que tiene en su lista de ingredientes.
 Cada plato tiene como precio el de la suma de ingredientes más un fijo que es de 1 euro 
 (gasto de luz, utensilios, tiempo,…)
•	Mostrar la carta de cada día de un restaurante que se compondrá de 6 platos de la lista de platos 
que elabora el restaurante. En cada plato se mostrarán los ingredientes que lo componen y el precio de ese plato. 
•	Cada menú consta de dos platos que es lo que cada cliente solicitará. 
A la bebida y el postre invita la casa. 
•	A cada cliente que vaya al restaurante se le anotarán los platos que han formado su menú y la mesa en que está.
 A la hora de pagar se mostrará la cuenta en pantalla: el detalle de los menús que tiene que pagar (los de la mesa), 
 indicando el precio de cada plato y el de cada menú, el total a pagar, el dinero entregado y el cambio. 
 */
public class Comedor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Platos> platos = new ArrayList<Platos>();
		ArrayList<Ingredientes> ingredientes = new ArrayList<Ingredientes>();
		ingredientes.add(new Ingredientes("Tomate", 1.0));
		ingredientes.add(new Ingredientes("Pasta", 1.0));
		ingredientes.add(new Ingredientes("Queso parmesano", 1.5));
		ingredientes.add(new Ingredientes("Albaca", 1.2));
		ingredientes.add(new Ingredientes("Pesto", 1.15));
		ingredientes.add(new Ingredientes("Nata", 1.0));
		ingredientes.add(new Ingredientes("panceta", 1.7));
		ingredientes.add(new Ingredientes("champiñon", 0.9));
		ingredientes.add(new Ingredientes("piña", 1.0));
		ingredientes.add(new Ingredientes("Queso Azul", 2.0));
		ingredientes.add(new Ingredientes("Cebolla", 0.5));

		/*
		 * ArrayList<Ingredientes> componentes = new ArrayList<Ingredientes>();
		 * componentes.add(ingredientes.get(6)); componentes.add(ingredientes.get(5));
		 * componentes.add(ingredientes.get(10)); platos.add(new
		 * Platos("Pizza Carbonara",componentes));
		 * 
		 * ArrayList<Ingredientes> componentes1 = new ArrayList<Ingredientes>();
		 * 
		 * componentes1.add(ingredientes.get(0)); componentes1.add(ingredientes.get(4));
		 * componentes1.add(ingredientes.get(10)); platos.add(new
		 * Platos("Pizza Al pesto",componentes1));
		 * 
		 * ArrayList<Ingredientes> componentes2 = new ArrayList<Ingredientes>();
		 * 
		 * componentes2.add(ingredientes.get(8)); componentes2.add(ingredientes.get(0));
		 * componentes2.add(ingredientes.get(10)); platos.add(new
		 * Platos("Pizza Hawayana",componentes2));
		 * 
		 * ArrayList<Ingredientes> componentes3 = new ArrayList<Ingredientes>();
		 * 
		 * componentes3.add(ingredientes.get(9)); componentes3.add(ingredientes.get(1));
		 * componentes3.add(ingredientes.get(10)); platos.add(new
		 * Platos("Pizza de quesos",componentes3));
		 * 
		 * ArrayList<Ingredientes> componentes4 = new ArrayList<Ingredientes>();
		 * 
		 * 
		 * componentes4.add(ingredientes.get(6)); componentes4.add(ingredientes.get(1));
		 * componentes4.add(ingredientes.get(10)); platos.add(new
		 * Platos("Pizza Margarita",componentes4));
		 * 
		 * ArrayList<Ingredientes> componentes5 = new ArrayList<Ingredientes>();
		 * 
		 * componentes5.add(ingredientes.get(9)); componentes5.add(ingredientes.get(6));
		 * componentes5.add(ingredientes.get(10)); platos.add(new
		 * Platos("Pizza de la casa",componentes5));
		 */
		ArrayList<Ingredientes> componentes = new ArrayList<Ingredientes>();
		componentes.add(ingredientes.get(6));
		componentes.add(ingredientes.get(5));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza Carbonara", componentes));

		componentes = new ArrayList<Ingredientes>();

		componentes.add(ingredientes.get(0));
		componentes.add(ingredientes.get(4));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza Al pesto", componentes));

		componentes = new ArrayList<Ingredientes>();

		componentes.add(ingredientes.get(8));
		componentes.add(ingredientes.get(0));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza Hawayana", componentes));

		componentes = new ArrayList<Ingredientes>();

		componentes.add(ingredientes.get(9));
		componentes.add(ingredientes.get(1));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza de quesos", componentes));

		componentes = new ArrayList<Ingredientes>();

		componentes.add(ingredientes.get(6));
		componentes.add(ingredientes.get(1));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza Margarita", componentes));

		componentes = new ArrayList<Ingredientes>();

		componentes.add(ingredientes.get(9));
		componentes.add(ingredientes.get(6));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza de la casa", componentes));
		for (Platos plato : platos) {
			plato.establecerPrecio();
		}
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		int menu = -1;
		do {
			Leer.mostrarEnPantalla("1. mostrar carta");
			Leer.mostrarEnPantalla("2. Servir Cliente");
			Leer.mostrarEnPantalla("3. Pagar cuenta");
			Leer.mostrarEnPantalla("1. mostrar carta");
			Leer.mostrarEnPantalla("-------------------");
			menu = Leer.pedirEntero("introduzca una opcion del menu");
			switch (menu) {
			case 1:
				int contador = 0;
				int indice = (int) (Math.random() * platos.size());
				while (contador < 4) {
					Leer.mostrarEnPantalla(
							platos.get(indice).getNombre() + " Precio: " + platos.get(indice).getPrecio());
					Leer.mostrarEnPantalla("-------------------------");
					for (Ingredientes ingrediente : platos.get(indice).getIngredientes()) {
						Leer.mostrarEnPantalla(ingrediente.getNomIngred());
					}
					Leer.mostrarEnPantalla("-------------------------");
					contador++;
					indice++;
					if (indice == platos.size()) {
						indice = 0;
					}
				}

				break;
			case 2:
				for (int i = 0; i < 20; i++) {
					ArrayList<Platos> comanda = new ArrayList<Platos>();
					comanda.add(platos.get((int) (Math.random() * platos.size())));
					comanda.add(platos.get((int) (Math.random() * platos.size())));
					int mesa = (int) (Math.random() * 10);
					clientes.add(new Cliente(comanda, mesa));
				}

				for (Cliente cliente : clientes) {
					Leer.mostrarEnPantalla(cliente.toString());
				}
				break;
			case 0:
				Leer.mostrarEnPantalla("El cliente ha abandonado el restaurante");

				break;
			case 3:
				int mesa = Leer.pedirEntero("Introduzca la mesa a facturar");
				double preciomesa = 0;
				for (Cliente cliente : clientes) {
					if (cliente.getMesa() == mesa) {
						for (Platos comensal : cliente.getMenu()) {
							Leer.mostrarEnPantalla(comensal.getNombre() +" Precio: "+ comensal.getPrecio());
							preciomesa = preciomesa + comensal.getPrecio();

						}
					}
				}
				Leer.mostrarEnPantalla("------------------------");
				Leer.mostrarEnPantalla("Total Factura: "+preciomesa);
				double pago = Leer.pedirDouble("introducir pago");
				Leer.mostrarEnPantalla("Total pago: "+pago);
				double cambio = pago - preciomesa;
				Leer.mostrarEnPantalla("Total cambio: "+cambio);
				break;

			default:
				break;
			}
		} while (menu != 0);

	}

}