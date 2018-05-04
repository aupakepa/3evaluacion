import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import utilidades.Fecha;
import utilidades.Leer;

/*2.	Escribe un proyecto en Java que permita gestionar la venta de billetes de tren.

Crea las clases que se necesiten, los métodos adecuados en cada clase y las colecciones que sean más adecuadas. 
(crea tres trenes de forma fija)
•	Cada tren se identifica con un número de tren,  una hora de salida y las estaciones de salida y llegada. 
El número de tren es único.
•	El tren para una fecha se compondrá de vagones.
Cada vagón tiene una capacidad de 10 asientos, numerados del 1 al 10. 
Los vagones se numeran secuencialmente. Al tren se le van añadiendo vagones según se van llenando.
(cada vagón se puede guardar en un array de 11 elementos en el que la posición 0.
se guarda el número de vagón y de las posiciones 1 a la 10 un 0 si están libres ó un 1 si están ocupados. 
También se puede guardar el número del billete en el que se ha vendido).
•	La venta de billetes se realiza para una fecha (utiliza la clase Fecha) en un tren concreto, un vagón y un asiento. (atributos de la clase billete: número, fecha, tren, vagón, asiento y precio) Cada billete lleva su precio y su número identificador.
•	Los billetes se pueden devolver (borrar el billete), lo que dejará el asiento correspondiente libre que serán los primeros en ser ofertados en la siguiente venta para la fecha correspondiente. Los billetes se guardan en una list o set.
•	Los billetes podrán ser ordenada por diferentes criterios: 
o	número de billete: datos de billetes (de billetes)
o	fecha, tren, vagón y asiento: (este puede salir del mapa con clave la fecha y valor que puede ser el billete).
o	tren, fecha, vagón : asientos vendidos (de billetes)
•	El menú del programa tiene venta de billetes, anulación de billetes y listados por las tres opciones anteriores.
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Tren> trenes = new ArrayList<Tren>();
		trenes.add(new Tren(new Fecha(24, 04, 2018)));
		trenes.add(new Tren(new Fecha(27, 04, 2018)));
		trenes.add(new Tren(new Fecha(28, 04, 2018)));

		ArrayList<Billete> billetes = new ArrayList<Billete>();
		for (int i = 0; i < 100; i++) {
			int trenazar = (int) (Math.random() * trenes.size());
			Tren trenactual = trenes.get(trenazar);
			Integer vagon = trenactual.buscarVagon()+1;
			Fecha fecha = trenactual.getFecha();
			Integer asiento = trenactual.getVagones().get(vagon-1).asientoVacio();
			trenactual.venderBillete();
			Billete ticket= new Billete(fecha, vagon, trenactual, asiento);
			billetes.add(ticket);
		}
		int menu = -1;
		do {
			Leer.mostrarEnPantalla("1.Venta de Billetes");
			Leer.mostrarEnPantalla("2.Anulacion de Billetes");
			Leer.mostrarEnPantalla("3.Orden por fechas");
			Leer.mostrarEnPantalla("4.Orden por num Tren");
			Leer.mostrarEnPantalla("5.Orden por num");
			Leer.mostrarEnPantalla("6.Listar Blletes");
			Leer.mostrarEnPantalla("0.alir");
			Leer.mostrarEnPantalla("-------------------------");
			menu = Leer.pedirEntero("Introducir Opcion del menu");
			switch (menu) {
			case 1:
				int i = 1;
				for (Tren tren : trenes) {
					Leer.mostrarEnPantalla(i+".-"+tren.toString());
					i++;
				}
				Leer.mostrarEnPantalla("-----------------------------");
				Tren trenactual = trenes.get(Leer.pedirEntero("introduzca el tren para el que desea el viaje")-1);
				Fecha fecha = trenactual.getFecha();
				Integer vagon = trenactual.buscarVagon()+1;
				Integer asiento = trenactual.getVagones().get(vagon-1).asientoVacio();
				trenactual.venderBillete();
				Billete ticket = new Billete(fecha, vagon, trenactual,asiento);
				billetes.add(ticket);
				break;

			case 2:
				for (Tren tren : trenes) {
					Leer.mostrarEnPantalla(tren.getNumero()+".-"+tren.toString());
				}
				Integer numeroBillete = Leer.pedirEntero("introduce el numero de billete");
				
				int j=0;
				int posicion=-1;
				for (Billete billete : billetes) {
					if (billete.getNumBillete()==numeroBillete) {
					posicion=j;
					}
				j++;	
				}
				vagon = billetes.get(posicion).getVagon();
				asiento= billetes.get(posicion).getAsiento();
				trenactual = billetes.get(posicion).getTren();
				trenactual.anularBillete(vagon, asiento);
				if (posicion!=-1) {
					billetes.remove(posicion);
					Leer.mostrarEnPantalla("Billete : "+numeroBillete+ " anulado");
				}else {
					Leer.mostrarEnPantalla("El billete no es correcto");
				}
				break;

			case 3:Collections.sort(billetes, fechaComparator);

			for (Billete billete : billetes) {
				Leer.mostrarEnPantalla(billete.toString());
			}


				break;

			case 4:

				break;

			case 5:

				break;

			case 0:

				break;

			case 6:
				for (Billete billete : billetes) {
					Leer.mostrarEnPantalla(billete.toString());
				}
				break;

			default:
				break;
			}
		} while (menu != 0);

		
		Collections.sort(trenes);
		Leer.mostrarEnPantalla("---------------------------------------");
		for (Tren tren : trenes) {
			Leer.mostrarEnPantalla(tren.toString());
		}
	}

	public static Comparator<Billete> fechaComparator = new Comparator<Billete>() {

		public int compare(Billete billete1, Billete billete2) {

			int ordenFecha = -billete1.getFecha().difFechas(billete2.getFecha()) * 100;
			int ordenTren = (billete1.getTren().getNumero() - billete2.getTren().getNumero()) * 10000;
			int ordenVagon = (billete1.getVagon() - billete2.getVagon()) * 10;
			int ordenAsiento = billete1.getAsiento() - billete2.getAsiento();
			return (ordenFecha + ordenTren + ordenVagon + ordenAsiento);

		}
	};

}