import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import utilidades.Fecha;
import utilidades.Leer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Tren> trenes = new ArrayList<Tren>();
		trenes.add(new Tren(new Fecha(24, 04, 2018)));
		trenes.add(new Tren(new Fecha(27, 04, 2018)));
		trenes.add(new Tren(new Fecha(28, 04, 2018)));

		ArrayList<Billete> billetes = new ArrayList<Billete>();
		for (int i = 0; i < 100; i++) {
			int trenazar = (int) (Math.random()*trenes.size());
			Tren trenactual = trenes.get(trenazar);
			trenactual.venderBillete();
			Billete ticket = new Billete(trenactual.getFecha(), (trenactual.getVagones().size()), trenactual, trenactual.getVagones().get(trenactual.getVagones().size()-1).getProximoasiento()-1);
			billetes.add(ticket);
		}
		Collections.sort(billetes, fechaComparator);

		for (Billete billete : billetes) {
			Leer.mostrarEnPantalla(billete.toString());
		}
	}
	public static Comparator<Billete> fechaComparator = new Comparator<Billete>() {

		public int compare(Billete billete1, Billete billete2) {

	     
	      return (billete1.getFecha().getAnio()*10000+billete1.getFecha().getMes()*100+billete1.getFecha().getDia())
	    		  -(billete2.getFecha().getAnio()*10000+billete2.getFecha().getMes()*100+billete2.getFecha().getDia());

	      
	    }


};
}