import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

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
		HashMap<Fecha, Tren> trenes = new HashMap<Fecha, Tren>();
		trenes.put(new Fecha(24, 04, 2018), new Tren());
		trenes.put(new Fecha(27, 04, 2018), new Tren());
		trenes.put(new Fecha(28, 04, 2018), new Tren());
		for (Entry<Fecha, Tren> tren : trenes.entrySet()) {
			Leer.mostrarEnPantalla(tren.getKey() + tren.getValue().toString());
		}
		ArrayList<Billete> billetes = new ArrayList<Billete>();
		for (int i = 0; i < 100; i++) {
			Iterator<Fecha> it = trenes.keySet().iterator();
			int trenazar = (int) (Math.random() * trenes.size());
			Fecha fecha = it.next();
			for (int j = 0; j < trenazar - 1; j++) {
				fecha = it.next();
			}
			Tren tren = trenes.get(fecha);
			Vagon vagon = tren.getVagones().get(tren.getVagones().size() - 1);
			tren.venderBillete();
			Integer asiento = vagon.getAsientos()[vagon.getProximoasiento()-1];
			billetes.add(new Billete(fecha, vagon.getNum(), tren, asiento));
		}
		for (Billete billete : billetes) {
			Leer.mostrarEnPantalla(billete.toString());
		}
	}
}
