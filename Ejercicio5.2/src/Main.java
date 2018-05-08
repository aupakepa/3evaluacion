import java.util.ArrayList;
import java.util.List;

import utilidades.Leer;

/*Ejercicio 5.
Simulación de colas de espera en una oficina de atención a clientes.
En una oficina de atención a clientes se disponen de 5 ventanillas para los mismos,
cada una de ellas genera una cola de espera.
Cada nodo de información que se inserta en la cola tiene una tarea a despachar que
puede ser de duración 10 min, 20 min ó 30 min , se ha estimado estadísticamente que
llegan un 60% de tareas de duración 10 un 25% de tareas de duración 20 y un 15% de
tareas de duración 30.
El programa debe generar con los porcentajes descritos un nodo de tipo 15, 20 o 30. Se
sugiere generar números aleatorios entre 1 y 100 de manera que si el número
generado está entre 1 y 60 la tarea será de duración 15, si está entre 61 y 85 de
duración 20 y si está entre 86 y 100 de duración 30.
Cuando se genera un cliente(es decir nodo ó tarea), este se coloca en la cola cuya
longitud es mínima.
Se ha estimado estadísticamente también que cada 5 minutos llega un nuevo cliente
(nodo/tarea).
El programa debe simular el comportamiento de las 5 colas durante 5 horas es decir se
genera un bucle de 1 a 300 porque son trescientos minutos los que transcurren en ese
intervalo. Para cada minuto, es decir para cada paso del bucle hay que hacer dos cosas:
1. Si el minuto es múltiplo de 5 generar un cliente (tarea/nodo) y ponerlo en su cola
correspondiente.
2. Dar servicio a las 5 ventanillas esto es las tareas que estén en el frente de cada cola
descontarles un minuto que ha transcurrido y si quedan en cero suprimirlas de la
cola.
El programa debe darnos las longitudes de cada cola de espera (ventanilla) cada 15
minutos. Y al final la longitud media de cada cola, obtenidas como la suma de las
longitudes de dicha cola en cada instante dividida por el número de instantes totales
Los métodos que se proponen para este ejercicio de simulación son las siguientes:
ServirColas : su tarea es dar servicio a las 5 colas decrementando en uno los minutos
de su gestión , a las cabeceras de dichas colas y en el caso de que los minutos de ese
nodo queden a cero suprimirlos de la cola.
MedirCola : su función es darnos el número de nodos de la cola en un momento dado.
AsignarCola : su función es indicar donde debe insertarse la tarea que se genera cada 5
minutos.
InsertarTarea : insertar una tarea en la cola que le corresponda.
ExtraerTarea : eliminar una tarea cuyo número de minutos haya terminado.
Estos métodos serán indispensables para la buena ejecución del programa, pero si se
considera oportuno, se pueden crear otros métodos auxiliares.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Cliente>> colas = new ArrayList<ArrayList<Cliente>>();
		for (int i = 0; i < 5; i++) {// Crear cinco arrayList que haran la
										// funcion de colas
			colas.add(new ArrayList<Cliente>());
		}

		int contador = 0;
		while (contador < 300) {

			if (contador % 5 == 0) {
				colas.get(colaMenor(colas)).add(crearCliente(colas));

			}
			for (int i = 0; i < 5; i++) {
				if (!colas.get(i).isEmpty()) {
					colas.get(i).get(0).atencion();
					Leer.mostrarEnPantalla(colas.get(i).get(0).toString()+" Atendido");
					if (colas.get(i).get(0).terminado()) {
						Leer.mostrarEnPantalla(colas.get(i).get(0).toString()+ " Sale de la cola");
						colas.get(i).remove(0);
					}
				}

			}
			contador++;
		}

		for (ArrayList<Cliente> p : colas) {
			for (Cliente cliente : p) {
				Leer.mostrarEnPantalla(cliente.toString());
			}
		}
	}

	private static Cliente crearCliente(ArrayList<ArrayList<Cliente>> colas) {
		Cliente cliente = null;
		int tipo = (int) Math.random() * 101;
		if (tipo > 86) {
			cliente = new Cliente(30, colaMenor(colas));
		} else if (tipo < 86 && tipo > 60) {
			cliente = new Cliente(20, colaMenor(colas));
		} else {
			cliente = new Cliente(10, colaMenor(colas));
		}
		return cliente;
	}

	private static Integer colaMenor(ArrayList<ArrayList<Cliente>> colas) {
		Integer menor = 0;
		int contador = 0;
		int longitud = (colas.get(0)).size();
		for (ArrayList<Cliente> cola : colas) {
			if (cola.size() < longitud) {
				menor = contador;
			}
			contador++;
		}
		return menor;
	}

}