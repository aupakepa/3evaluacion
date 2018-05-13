



public class GestionAgencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final Integer NUMCOCHE=20;
		Coche[] coches=new Coche[NUMCOCHE];
		inicializaCoches(coches);
		int numCoche, dias;
		int opcion=menu();//opción de menú
		while (opcion!=0) {//menú
			numCoche=-1;
			switch (opcion) {//acciones de menú
			case 1://alquilar
				cochesDisponible(coches);
				numCoche=Leer.pedirEntero("Coche a alquilar ","(1?[0-9])");
				if (coches[numCoche].getDisponible()){
					coches[numCoche].alquilar();
					Leer.mostrarEnPantalla("Coche "+coches[numCoche].muestraCoche()+" alquilado");
				} else{
					Leer.mostrarEnPantalla("Coche no diponible");
				}
				break;
			case 2://devolver
				cochesOcupados(coches);
				numCoche=Leer.pedirEntero("Coche a devolver ","(1?[0-9])");
				if (!coches[numCoche].getDisponible()){
					dias=Leer.pedirEntero("Días alquilado", "[0-9]+");
					Leer.mostrarEnPantalla("Precio del alquiler: "+coches[numCoche].devolver(dias));
				} else{
					Leer.mostrarEnPantalla("Coche no ocupado");
				}
				break;
			case 3://Listar disponibles
				cochesDisponible(coches);

				break;
			case 4://Listar ocupados
				cochesOcupados(coches);
			}
			opcion = menu();
		} 
	}



	private static void cochesOcupados(Coche[] coches) {
		for (int i=0;i<coches.length;i++){
			if(!coches[i].getDisponible()) {
				Leer.mostrarEnPantalla(i+coches[i].muestraCoche());	
			}
		}
	}	
	
	
	private static void cochesDisponible(Coche[] coches) {
		for (int i=0;i<coches.length;i++){
			if(coches[i].getDisponible()) {
				Leer.mostrarEnPantalla(i+coches[i].muestraCoche());	
			}
		}
	}


	
	public static int menu(){
		int opcion;
		Leer.mostrarEnPantalla("1.- Alquilar coche");
		Leer.mostrarEnPantalla("2.- Devolver coche");
		Leer.mostrarEnPantalla("3.- Listado de coches disponibles");
		Leer.mostrarEnPantalla("4.- Listado de coches ocupados");
		Leer.mostrarEnPantalla("0.- Salir");
		opcion=Leer.pedirEntero("Elige opción", "[0-4]");
		return opcion;
	}
	
	public static String creaMatricula(){
		final String LETRAS ="ABCDEFGHIJKLMNOPRSTUVWXYZ";
		Integer numero;
		String matricula="";
		for(int i=0; i<4;i++){
			numero= (int) (Math.random()*10);
			matricula=matricula+numero;
		}
		for(int i=0; i<3;i++){
			numero= (int) (Math.random()*25);
			matricula=matricula+LETRAS.substring(numero, numero+1);
		}
		return matricula;
	}
	
	public static void inicializaCoches(Coche [] coches){
		int pos, pos2;
		String [] MARCAS={"Audi", "Volvo", "Seat", "KIA"};
		String [] MODELOS={"Berlina", "4 x 4", "Coupé","Smart"};
		for(int i=0;i<coches.length;i++){
			pos=(int) (Math.random()*4);
			pos2=(int) (Math.random()*2);
			if (i<15) {
				coches[i]=new Normal(creaMatricula(), MARCAS[pos], MODELOS[pos2], new Fecha(1,1,2001),(int) (Math.random()*11+20),"Aragonia");
			}else{
				coches[i]=new Lujo(creaMatricula(), MARCAS[pos], MODELOS[pos2+2], new Fecha(1,1,2001),(int) (Math.random()*11+50));
			}
		}
	}
}
