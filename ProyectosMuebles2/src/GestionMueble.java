/**
 * 
 */

/**
 * @author maalvarez
 *
 */
public class GestionMueble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mueble muebles[]= new Mueble[15];
		Almacen almacenes[]= new Almacen[4];
		inicializa(almacenes, muebles);
		pintaMuebles(muebles);
		Leer.mostrarEnPantalla("-------");
		pintaAlmacen(almacenes);
		Leer.mostrarEnPantalla("-------");
		localizaAlmacen(almacenes);
		
	}
	
	public static void inicializa(Almacen[] almacenes, Mueble [] muebles){
		almacenes[0]= new Almacen("Almacen 1", "c/Constitución");
		almacenes[1]= new Almacen("Almacen 2", "c/Goya");
		almacenes[2]= new Almacen("Almacen 3", "c/Gran Vía");
		almacenes[3]= new Almacen("Almacen 4", "avd/ Navarra");
		muebles[0]= new Mueble("Armario",120, 170, 50);
		muebles[1]= new Mueble("Mesa",80, 80, 80);
		muebles[2]= new Mueble("Mesa",120, 70, 80);
		muebles[3]= new Mueble("Mesa",50, 50, 50);
		muebles[4]= new Mueble("Cama",150, 70, 200);
		muebles[5]= new Mueble("Cama",105, 70, 190);
		muebles[6]= new Mueble("Cama",120, 70, 200);
		muebles[7]= new Mueble("Armario",180, 180, 50);
		muebles[8]= new Mueble("Silla",70, 130, 50);
		muebles[9]= new Mueble("Silla",70, 150, 50);
		muebles[10]= new Mueble("Silla",70, 170, 50);
		muebles[11]= new Mueble("Sofá",120, 150, 70);
		muebles[12]= new Mueble("Sofá",150, 160, 70);
		muebles[13]= new Mueble("Sofá",120, 150, 50);
		muebles[14]= new Mueble("Armario",220, 220, 50);
		int numeroAlmacen;
		for(int i=0; i<15; i++){
			numeroAlmacen=(int) (Math.random()*4);
			Leer.mostrarEnPantalla(almacenes[numeroAlmacen].asignaMueble(muebles[i]));
		}
	}
	
	public static void pintaMuebles(Mueble [] muebles){
		for (int i=0; i<muebles.length;i++){
			Leer.mostrarEnPantalla(muebles[i].muestraMueble());
		}
	}
	
	public static void pintaAlmacen(Almacen [] almacenes){
		for (int i=0; i<almacenes.length;i++){
			Leer.mostrarEnPantalla(almacenes[i].muestraAlmacen());
		}
	}
	
	public static void localizaAlmacen(Almacen [] almacenes){
		Mueble[] muebles;
		for(int i= 0; i<almacenes.length; i++){
			Leer.mostrarEnPantalla(almacenes[i].muestraAlmacen());
			muebles=almacenes[i].getMuebles();
			for (int j= 0; j<almacenes[i].getSig();j++){
				Leer.mostrarEnPantalla("\t"+muebles[j].muestraMueble());
			}
		}
	}

}
