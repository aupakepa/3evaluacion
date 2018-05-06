import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

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
		TreeMap<Fecha, ArrayList<Tren>> trenes = new TreeMap<Fecha, ArrayList<Tren>>();//lEER FICHERO TRENES
		File t = new File("trenes.txt");
		trenes = leerTrenes(trenes, t);
		ArrayList<Billete> billetes = new ArrayList<Billete>();
		billetes = leerBilletes(t, billetes);
		/*Fecha fecha = new Fecha(24, 04, 2018);
		crearTren(trenes,fecha);
		crearTren(trenes,fecha);
		crearTren(trenes,fecha);
		crearTren(trenes,new Fecha(28, 04, 2018));*/
		/*mapatrenes = new Fichero2("trenes.txt","O");//Apertura del fichero de entrada.donde escribimos
		mapatrenes.escribir(trenes);
		mapatrenes.cerrar("O");*/
		for (Entry<Fecha, ArrayList<Tren>> tren : trenes.entrySet()) {
			Leer.mostrarEnPantalla(tren.getKey() + tren.getValue().toString());
		}
		/*File f = new File("fichero.txt");
		Fichero listabilletes;
		if (f.exists()){
			listabilletes = new Fichero("fichero.txt","I");//Apertura del fichero de entrada.donde leemos
			billetes=listabilletes.leer();
			listabilletes.cerrar("I");
		}else {
			Leer.mostrarEnPantalla("El fichero no existe");
		}*/
		/*Fecha fechatren=new Fecha(1, 1, 1);
		for (int i = 0; i < 100; i++) {
			Set<Fecha> fechas = trenes.keySet();
			int diatren=(int) (Math.random() * fechas.size());
			Iterator<Fecha> it= fechas.iterator();
			int j=0;
			while (it.hasNext() && j<diatren+1) {
				Fecha fecha2 = it.next();
				fechatren = fecha2;
				j++;
			} 
			int trenazar = (int) (Math.random() * trenes.get(fechatren).size());
			Tren trenactual = trenes.get(fechatren).get(trenazar);
			Integer vagon = trenactual.buscarVagon()+1;
			Integer asiento = trenactual.getVagones().get(vagon-1).asientoVacio();
			trenactual.venderBillete();
			Billete ticket = new Billete(fechatren, vagon, trenactual, asiento);
			billetes.add(ticket);
		}
		mapatrenes = new Fichero2("trenes.txt","O");//Apertura del fichero de entrada.donde escribimos
		mapatrenes.escribir(trenes);
		mapatrenes.cerrar("O");
		File f = new File("billetes.txt");
		Fichero listaBilletes;
		listaBilletes=new Fichero("billetes.txt", "O");
		listaBilletes.escribir(billetes);
		listaBilletes.cerrar("O");*/
		Leer.mostrarEnPantalla(billetes.toString());
	
		Leer.mostrarEnPantalla("---------------------------------------------------");
		for (Entry<Fecha, ArrayList<Tren>> tren : trenes.entrySet()) {
			Leer.mostrarEnPantalla(tren.getKey() + tren.getValue().toString());
		}
	}
	private static TreeMap<Fecha, ArrayList<Tren>> leerTrenes(TreeMap<Fecha, ArrayList<Tren>> trenes, File t) {
		Fichero2 mapatrenes;
		if (t.exists()){
			mapatrenes = new Fichero2("trenes.txt","I");//Apertura del fichero de entrada.donde leemos
			trenes=mapatrenes.leer();
			mapatrenes.cerrar("I");
		}else {
			Leer.mostrarEnPantalla("El fichero no existe");
		}
		return trenes;
	}
	private static ArrayList<Billete> leerBilletes(File t, ArrayList<Billete> billetes) {
		File f = new File("billetes.txt");//lEER FICHERO BILLETES
		Fichero listaBilletes;
		if (t.exists()){
			listaBilletes = new Fichero("billetes.txt","I");//Apertura del fichero de entrada.donde leemos
			billetes=listaBilletes.leer();
			listaBilletes.cerrar("I");
		}else {
			Leer.mostrarEnPantalla("El fichero no existe");
		}
		return billetes;
	}
		private static void crearTren(TreeMap<Fecha, ArrayList<Tren>> trenes,Fecha fecha) {
			if (trenes.containsKey(fecha)) {
				trenes.get(fecha).add(new Tren());
			}else{
				trenes.put(fecha, new ArrayList<Tren>());
				trenes.get(fecha).add(new Tren());
			}


		}
	}
