import java.util.Arrays;

public class GestionLibroAutor {
	public static void main(String[] args) {
		Libro[] libros = null;
		Autor[] autores = null;
		Comentable[] comentarios= new Comentable[100];
		String  nombre = "", titulo = "";

		Integer opcion, cuantosLibros,posLibro=0,posAutor=0, numComentable=0;

		libros = new Libro[10];
		autores = new Autor[10];

		posAutor=creaAutores(autores,posAutor, comentarios, numComentable);
		posLibro=creaLibros(autores,posLibro,libros, comentarios, 3);
		for (int i=0; i<comentarios.length;i++){
			if (comentarios[i]!=null){
				Leer.mostrarEnPantalla(comentarios[i].comentar());
			}
		}
		
		do {
			
			libros = ampliaLibros(libros, posLibro);// amplia los libros si es necesario
			autores = ampliaAutores(autores, posAutor);// amplia los autores si es necesario
			opcion = menu();//muestra menu y lee la opción

			switch (opcion) {
			case 1: // creamos un autor guardándolo en la posición posAutor
				posAutor= creaAutor( autores, posAutor);					
				break;
			case 2: // creamos un libro guardándolo en la posición posLibro
				if(posAutor==0){
					Leer.mostrarEnPantalla("Debe crear antes al menos un autor");
				} else{
					posLibro=crearLibros( posLibro, libros, autores);					
				}
				break;
			case 3: // modificar autor 				
				if(posAutor==0){
					Leer.mostrarEnPantalla("No hay autores en la lista");
				}else {
					listarAutores(autores);
					nombre = Leer.pedirCadena("Nombre del autor a modificar (* para terminar)");
					if (!nombre.equals("*")) {
						modificarAutor(autores, nombre);
					}
				}
				break;
			case 4: // modificar libro
				if(posLibro==0){
					Leer.mostrarEnPantalla("No hay libros en la lista");
				}else {
					listarLibros(libros);
					titulo = Leer.pedirCadena("Titulo del libro a modificar (* para terminar)");
					if (!titulo.equals("*")) {
						modificarLibro(libros, titulo, autores);
					}
				}
				break;
			case 5: // listar autores
				if(posAutor==0){
					Leer.mostrarEnPantalla("No hay autores en la lista");
				}else {
					listarAutores(autores);
				}

				break;
			case 6: // listar libros
				if(posLibro==0){
					Leer.mostrarEnPantalla("No hay libros en la lista");
				}else {
					listarLibros(libros);
				}
				break;
			}
		} while (opcion != 0);

	}

	private static Integer menu() {
		Integer opcion;
		Leer.mostrarEnPantalla("\n1- Crear autor.\n2- Crear libro.\n3- Modificar autor.\n" + "4- Modificar libro.\n" + "5- Listado de autores.\n"
			+ "6- Listado de libros.\n" + "0- Salir.");
		opcion = Leer.pedirEntero("\nElija opcion","[0-6]");
		return opcion;
	}//menu y opción

	private static Autor[] ampliaAutores(Autor[] autores, Integer posAutor) {
		if(posAutor>0.8*autores.length){
			autores=Arrays.copyOf(autores, autores.length+10);
		}
		return autores;
	}// amplía el vector de autores cuando se supera el 80%

	private static Libro[] ampliaLibros(Libro[] libros, Integer posLibro) {
		if(posLibro>0.8*libros.length){
			libros=Arrays.copyOf(libros, libros.length+10);
		}
		return libros;
	}// amplía el vector de libros cuando se supera el 80%

	private static Integer creaAutor(Autor[] autores, Integer posAutor){
		Autor autor;
		String nombreAutor, email, sexo;
		Character letraSexo;
		Integer indiceAutor;
		// Comprobar si el autor ya está en el vector
		nombreAutor = Leer.pedirCadena("Nombre del autor?");
		indiceAutor = buscarAutor(autores, nombreAutor);// devuelve la posicion del nombre o -1 si no está
		if (indiceAutor == -1) {
			// creamos el autor y lo guardamos en el vector
			email = Leer.pedirCadena("Email autor?","^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			sexo = Leer.pedirCadena("Genero autor: (m)asculino (f)emenino ?","^[mMfF]$");
			letraSexo = sexo.charAt(0);
			autor = new Autor(nombreAutor, email, letraSexo);
			autores[posAutor] = autor;
			posAutor++;
			Leer.mostrarEnPantalla("Autor creado correctamente");
		} else {// el autor ya existe
			Leer.mostrarEnPantalla("El autor ya existe");
		}
		return posAutor;
	}//crear autor

	public static Integer crearLibros(Integer posLibros, Libro[] libros, Autor[] autores) {
		int indiceAutor, indiceTitulo;
		String titulo, nombreAutor;
		Autor autor;
		Double precio;
		Integer cantidad;
		// Comprobar si el libro ya esta en el vector 
		titulo = Leer.pedirCadena("Titulo del libro?");
		indiceTitulo = buscarTitulo(libros, titulo);
		while (indiceTitulo != -1) {
			titulo = Leer.pedirCadena("El libro ya existe y no se puede repetir. Titulo del libro?");
			indiceTitulo = buscarTitulo(libros, titulo);
		}
		// Comprobar si el autor ya esta en el vector
		nombreAutor = Leer.pedirCadena("Nombre del autor?");
		indiceAutor = buscarAutor(autores, nombreAutor);// devuelve la posicion del nombre o -1 si no lo encuentra
		if (indiceAutor == -1) {
			Leer.mostrarEnPantalla("El autor no existe");
		} else {// se crea el libro con ese autor
			autor = autores[indiceAutor];
			//pedir el resto de los datos del libro
			precio = Leer.pedirDouble("Precio del libro?","^\\d+[.][0-9]?[0-9]?$");//decimal con un máximo de dos posiciones decimales
			cantidad = Leer.pedirEntero("Cantidad de libros?","^\\d+$");//entero positivo
			libros[posLibros] = new Libro(titulo, autor, precio, cantidad);
			posLibros++;
			Leer.mostrarEnPantalla("Libro creado correctamente");
		}
		return posLibros;
	}// crear un Libro

	
	public static Integer creaAutores(Autor []autores,Integer posAutor, Comentable[] comentarios, Integer numComentable){
		// creamos 3 autores
		autores[0]= new Autor("Rosa Montero", "rmontero@gmail.com", 'f');
		comentarios[numComentable]=autores[0];
		numComentable++;
		autores[1]= new Autor("Juan Jose Millas", "jjmillas@hotmail.es",'m');
		comentarios[numComentable]=autores[1];
		numComentable++;
		autores[2]= new Autor("Almudena Grandes", "ag@gmail.com",'f');
		comentarios[numComentable]=autores[2];
		numComentable++;
		return 3;
	}// crea 3 autores
	
	public static Integer creaLibros(Autor[] autores, Integer posLibro, Libro[] libros, Comentable[] comentarios, Integer numComentable){
		// creamos 5 libros
		libros[0]= new Libro("Lágrimas en la lluvia", autores[0],19.95 ,100000);
		comentarios[numComentable]=libros[0];
		numComentable++;
		libros[1]= new Libro("La ridícula idea de no volver a verte", autores[0], 15., 200000);
		comentarios[numComentable]=libros[1];
		numComentable++;		
		libros[2]= new Libro("Desde la sombra", autores[1], 25., 75000);
		comentarios[numComentable]=libros[2];
		numComentable++;
		libros[3]= new Libro("Malena es un nombre de tango", autores[2], 22., 100000);
		comentarios[numComentable]=libros[3];
		numComentable++;		
		libros[4]= new Libro("Las edades de Lulú", autores[2], 30., 200000);
		comentarios[numComentable]=libros[4];
		numComentable++;		 
		return 5;
	}// crea 5 libros

	public static int buscarAutor(Autor[] autores, String nombre) {
		// devuelve la posicion del nombre o -1 si no lo encuentra
		int indiceAutor=-1, i=0;
		while (autores[i] != null && i < autores.length && indiceAutor==-1) {
			if (autores[i].getNombre().equals(nombre)) {
				indiceAutor = i;
			}
			i++;
		}
		return indiceAutor;
	}//buscar autor

	public static int buscarTitulo(Libro[] libros, String titulo) {
		// devuelve el indice de la posición donde está ese título o el valor -1 si no lo encuentra
		int i = 0, indiceLibro = -1;
		while ( libros[i] != null && i < libros.length && indiceLibro==-1) {
			if (libros[i].getTitulo().equals(titulo)) {
				indiceLibro = i;
			}
			i++;
		}
		return indiceLibro;
	}//buscar libro
	
	public static void listarAutores(Autor[] autores) {
		int indiceAutor;
		Leer.mostrarEnPantalla("\nListado de autores");
		Leer.mostrarEnPantalla("-------------------");
		for (indiceAutor = 0; indiceAutor < autores.length && autores[indiceAutor] != null; indiceAutor++) {
			Leer.mostrarEnPantalla("\n" + autores[indiceAutor].cadenaAutor());
		}
		Leer.mostrarEnPantalla("------------------------------------------------------------------");
	}//listarAutores

	public static void listarLibros(Libro[] libros) {
		int indiceLibro;
		Leer.mostrarEnPantalla("\nListado de libros");
		Leer.mostrarEnPantalla("------------------");
		for (indiceLibro = 0; indiceLibro < libros.length && libros[indiceLibro] != null; indiceLibro++) {
			Leer.mostrarEnPantalla("\n" + libros[indiceLibro].cadenaLibro());
		}
		Leer.mostrarEnPantalla("------------------------------------------------------------------");
	}//listarLibros

	public static void modificarAutor(Autor [] autores, String nombre){
		Integer indiceAutor, indice2;
		String email, sexo;
		Autor autor;
		
		//posicion del autor o -1 si no está
		indiceAutor = buscarAutor(autores, nombre);
		if(indiceAutor != -1){
			autor=autores[indiceAutor];
			nombre = Leer.pedirCadena("Nuevo nombre (* no cambiar)");
			if(!nombre.equals("*")){
				indice2 = buscarAutor(autores, nombre);//verificamos que el nuevo nombre no está repetido
				if(indice2!= -1){//nombre ya existente
					Leer.mostrarEnPantalla("El nuevo nombre ya está en la lista, posición "+indice2+" No se puede cambiar");
				}else{//nombre nuevo
					autor.setNombre(nombre);	
				}
			}
			email = Leer.pedirCadena("Nuevo email (* no cambiar)","^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$|[*]");
			if(!email.equals("*")){
				autor.setEmail(email);
			}
			sexo=Leer.pedirCadena("Nuevo sexo ","[mMfF]");
			autor.setSexo(sexo.charAt(0));
		}else{
			Leer.mostrarEnPantalla("Error. El autor " + nombre + " no existe");
		}
	}//modificarAutor

	public static void modificarLibro(Libro [] libros, String titulo, Autor [] autores){
		Integer indiceAutor, indice2, indiceLibro;
		Autor autor;
		Libro libro;
		Double precio;
		Integer cantidad;
		String nombre;
		
		//posicion del libro, -1 si no lo encuentra
		indiceLibro = buscarTitulo(libros, titulo); 
		if(indiceLibro != -1){
			libro=libros[indiceLibro];
			titulo = Leer.pedirCadena("Nuevo título (* no cambiar)");
			if(!titulo.equals("*")){//si no se teclea * se mantiene el título
				indice2 = buscarTitulo(libros, titulo);//verificamos que el nuevo título no está repetido
				if(indice2!= -1){//el título ya existe (puede ser el mismo)
					Leer.mostrarEnPantalla("El nuevo título ya está en la lista, posición "+indice2+" No se puede cambiar");
				}else{//el nuevo título es nuevo de verdad
					libro.setTitulo(titulo);	
				}
			}
			precio = Leer.pedirDouble("Precio "+libro.getPrecio()+" Nuevo precio del libro ","^\\d+[.][0-9]?[0-9]?$");
			libro.setPrecio(precio);
			cantidad = Leer.pedirEntero("Cantidad " +libro.getCantidad()+" Nueva cantidad de libros ","^\\d+$");
			libro.setCantidad(cantidad);
			autor=libro.getAutor();
			nombre=Leer.pedirCadena("Nombre del nuevo autor (* mantener el actual)");
			if(!nombre.equals("*")){// se ha dado un nuevo nombre de autor
				indice2=buscarAutor(autores,nombre);
				if (indice2==-1){//autor no encontrado
					Leer.mostrarEnPantalla("Ese autor no está en la lista. No se puede cambiar");
				} else {//nuevo autor encontrado
					libro.setAutor(autores[indice2]);
				}
			}
		}else{
			Leer.mostrarEnPantalla("Error. El libro " + titulo + " no existe");
		}		
	}//modificarLibro
}// class 
