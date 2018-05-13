import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Eleccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Partido> eleccion = new ArrayList<Partido>();
		Integer escanios, partidos, votos;
		partidos= Leer.pedirEntero("Número de partidos", "[0-9]+");
		generaPartidos(partidos, eleccion);
		imprimeResultado(eleccion);
		generaVotos(eleccion);
		imprimeResultado(eleccion);
		eliminaPartidos(eleccion, 5);
		imprimeResultado(eleccion);
		escanios= Leer.pedirEntero("Número de escaños", "[0-9]+");
		asignarEscanios(escanios, eleccion);
		imprimeResultado(eleccion);
		
	}
	
	public static void generaPartidos(Integer partidos, List<Partido> eleccion ){
		Partido part;
		for(int i=0; i<partidos; i++){
			part = new Partido("Partido"+i);
			eleccion.add(part);
		}
		return;
	}

	public static void generaVotos( List<Partido> eleccion){
		Integer votos;
		for(Partido part: eleccion){
			votos=(int) (Math.random()*10000+300);
			part.setVotos(votos);
		}
		return;	
	}

	public static void eliminaPartidos( List<Partido> eleccion, Integer porcentaje){
		Double votos=0.;
		Partido partido;
		for(Partido part: eleccion){
			votos=votos+part.getVotos();
		}
		Leer.mostrarEnPantalla(""+votos);
		/*for(Partido part: eleccion){
			if (part.getVotos()/votos< porcentaje/100.){
				eleccion.remove(part);
			}
		}	Esto PETA!!!!!*/
		Iterator<Partido> it = eleccion.iterator();//crea el iterador para la lista
		while(it.hasNext()){//Mira si hay un elemnto en la lista, devuelve unbooleano
			partido=it.next();//recupera el elemento siguiente de la lista
			if (partido.getVotos()/votos< porcentaje/100.){
				it.remove();//elimina el elemento del iterador y de la lista
			}
		}
		return;	
	}

	public static void asignarEscanios(Integer escanios, List<Partido> eleccion ){
		Integer max;
		Partido elegido;
		for(int i=0; i<escanios; i++){
			max=0;
			elegido=null;
			for(Partido part: eleccion){
				if (max<part.valorReparto()){
					max=part.valorReparto();
					elegido=part;
				}
			}
			elegido.asignaEscanio();
		}
		return;
	}
	
	public static void imprimeResultado(List<Partido> eleccion ){
		for(Partido part: eleccion){
			Leer.mostrarEnPantalla(part.toString());
		}
		
	}

}
