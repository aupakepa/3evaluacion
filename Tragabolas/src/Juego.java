/**
 * 
 */

/**
 * @author yo
 *
 */
public class Juego {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Traga2 tragabolas=null;
		Letras_LCD ver;
		String color;
		Integer bolasM;
		Integer opcion=9;
		
		while(opcion!=0){
			if(tragabolas==null){
				Leer.mensaje("1.- Crea tragabolas");
			}else{
				Leer.mensaje("2.- Ver tragabolas");
				Leer.mensaje("3.- Come");
				Leer.mensaje("4.- Duerme");
				Leer.mensaje("5.- Trota");
			}
			Leer.mensaje("0.- Salir");
			opcion=Leer.pedirEntero("Escoja opción");
			if(tragabolas==null&&opcion>1){
				opcion=9;
			}
			if(tragabolas!=null&&opcion==1){
				opcion=9;
			}
			switch(opcion){
			case 1:
				do{
					color=Leer.pedirCadena("Dame un color");
					bolasM=Leer.pedirEntero("Dame Bolas Máximas");
					tragabolas=new Traga2(color, bolasM);
				}while(tragabolas.getColor()==null||tragabolas.getBolasMaximas()==null);
				break;
			case 2:
				Leer.mensaje(tragabolas.cadena());
				break;
			case 3:
				Leer.mensaje(tragabolas.comer());
				break;
			case 4:
				ver = new Letras_LCD( tragabolas.dormir());
				break;
			case 5:
				Leer.mensaje(tragabolas.trotar());
				break;
			}
		}
		
	}

}
