import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import utilidades.Leer;

/*Escribe un programa en Java que permita crear y mantener una agenda con los nombres y apellidos 
 * de los contactos y sus diferentes números de teléfono indicando para cada teléfono 
 * el tipo de teléfono que es (móvil, móvil trabajo, fijo casa, fax....). 
 * El programa se realizará con una implementación en Java con programación orientada a objeto 
 * con las opciones que más adelante se indican. 
 * 
 * Diseña la solución con las clases, colecciones y tipo de fichero que consideres más adecuados.
Ejemplo de la información de un contacto de la agenda con sus teléfonos:
Antonio Martínez; casa 976222222; móvil 600345234; móvil trabajo +34 665643577; fax +34 976670001
Los contactos se leerán (si existe) de un fichero de organización secuencial llamado agenda.dat
 que se cargará en una colección cuando se inicia el programa y que permite mantener la agenda.
No se podrán generar datos aleatoriamente. (1 punto)

A continuación se mostrará un menú con las siguientes opciones:

1 - Añadir contacto en la agenda. Si queremos añadir un nombre que ya tenemos en la agend
a nos mostrará un mensaje diciendo que ya lo tenemos. (2 puntos)
2 - Borrar contacto en la agenda (1 punto)
3 - Listado en orden alfabético de todos los contactos de la agenda. (1 punto)
4 - Buscar por nombre. En esta opción se pedirá un nombre por teclado y 
nos mostrará los teléfonos de esa persona o un mensaje indicando que ese nombre no está en la agenda. (1 punto)
5.- Añadir un teléfono a un contacto. (1 punto)
6.- Borrar un teléfono de un contacto. (solo con el número sin tener en cuenta el tipo). (1 punto)
7 - Buscar por teléfono. Se pedirá un número de teléfono por teclado 
y mostrará los nombres de las personas a las que está asociado dicho número. (1 punto)
0 - Salir.
Los números de teléfono tendrán este formato: +99 999999999. Los tres primeros dígitos podrán no estar
 y corresponden con el código del país, los nueve siguientes constituyen el número del teléfono. 
 Se validará que el número introducido sea un número posible. 
 Tened en cuenta que los ceros a la izquierda no se pueden omitir (1 punto)
Siempre que se produzca un cambio en la agenda, se guardará (escribirá) el contenido de la agenda
 en el mismo fichero que se lee al inicio del programa.
Al terminar el examen, renombra la carpeta de los fuentes del proyecto para que se denomine ejercicio1
 e insértala en una carpeta denominada TusApellidos3Ev (por ejemplo PerezLopez3Ev). 
 Utilizando los fuentes, crea un fichero DOCX o PDF, con el nombre ejercio1, dentro de esta carpeta.
Una vez haya finalizado el examen, copia la carpeta con tus apellidos (arrastrándola encima) 
en la carpeta del servidor:
\\server\dam1-comune$\Examen 3ª Evaluación\solucion
ATENCIÓN. ESTE APARTADO NO DEBE HACERSE HASTA NO HABER TERMINADO EL ANTERIOR. SUPONE EL 20% DE LA CALIFICACIÓN.
Realiza una copia del programa que ya has hecho: puedes seleccionar el proyecto en el Package Explorer de Eclipse y utilizar Edit->Copy, Edit->Paste; se abrirá un cuadro de diálogo para que asignes un nombre al nuevo proyecto.
Tareas:
 Extiende el programa para representar también el sexo (hombre, mujer) de los contactos,
 de manera que cada uno de ellos tenga información diferente; 
 por ejemplo, si los hombres tienen o no barba y/o cuántos hijos ha tenido una mujer.
 Añade una nueva entrada en el menú (8.- Asignar sexo) que, de forma aleatoria,
 asigne sexo a todos aquellos contactos para los que no esté declarado 
 y complete la información necesaria.
 Realiza las modificaciones pertinentes para mostrar también esta información como parte de la del contacto.
Crea ahora una nueva carpeta ejercicio2 con los ficheros de este segundo ejercicio
 y un DOCX o PDF sólo con las clases que hayas creado nueva y/o modificado; si son modificaciones, 
 incluye sólo el código que has añadido/modificado.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Persona, ArrayList<Telefono>> contactos = new TreeMap<Persona, ArrayList<Telefono>>();
		File t = new File("agenda.dat");
		Persona persona = null;
		ArrayList<Telefono> telefonos =null;
		Telefono telefono = null;
		if (t.exists()) {
			Fichero archivo = new Fichero("agenda.dat", "I");
			contactos=archivo.leer();
			archivo.cerrar("I");
		}
		int menu = -1;
		do {
			Leer.mostrarEnPantalla("1 - Añadir contacto en la agenda.");
			Leer.mostrarEnPantalla("2 - Borrar contacto en la agenda");
			Leer.mostrarEnPantalla("3 - Listado en orden alfabético");
			Leer.mostrarEnPantalla("4 - Buscar por nombre.");
			Leer.mostrarEnPantalla("5.- Añadir un teléfono a un contacto.");
			Leer.mostrarEnPantalla("6.- Borrar un teléfono de un contacto.");
			Leer.mostrarEnPantalla("7 - Buscar por teléfono.");
			Leer.mostrarEnPantalla("8.- Asignar sexo");
			Leer.mostrarEnPantalla("0 - Salir");
			Leer.mostrarEnPantalla("---------------------------------------");
			menu = Leer.pedirEntero("introduzca una opcion de menu","[0-8]");
			switch (menu) {
			case 1:

				crearContactos(contactos);
				grabarDatos(contactos);
				break;

			case 2:
				
				persona = buscarClave(contactos, persona);
				contactos.remove(persona);
				grabarDatos(contactos);

				break;

			case 3:

				Leer.mostrarEnPantalla(contactos.toString());
				break;

			case 4:

				persona = buscarClave(contactos, persona);
				Leer.mostrarEnPantalla(contactos.get(persona).toString());
				break;

			case 5:
				persona = buscarClave(contactos, persona);
				telefono = crearTelefono();
				contactos.get(persona).add(telefono);
				grabarDatos(contactos);

				break;

			case 6:
				persona = buscarClave(contactos, persona);
				int i=0;
				Leer.mostrarEnPantalla("----------------------------");
				for (Telefono telefono2 : contactos.get(persona)) {
					Leer.mostrarEnPantalla(i+"-"+telefono2.getTipo()+telefono2.getNumero());
					i++;
				}
				Leer.mostrarEnPantalla("----------------------------");
				contactos.get(persona).remove(Leer.pedirEntero("introduzca el id de telefono a borrar","0-i"));
				grabarDatos(contactos);

				break;

			case 7:
				String numero = Leer.pedirCadena("introduzca un numero de telefono","[+]?([0-9]{2})?[0-9]{9}");
				for (Entry<Persona, ArrayList<Telefono>> contacto : contactos.entrySet()) {
					for (Telefono telefono2 : contacto.getValue()) {
						if (telefono2.getNumero().equals(numero)) {
							Leer.mostrarEnPantalla(contacto.toString());
						}
					}

				}
				
				break;

			case 8:

				break;

			case 0:
					Leer.mostrarEnPantalla("FIN DEL PROGRAMA");
				break;

			default:
				break;
			}

		} while (menu != 0);
	}

	private static Telefono crearTelefono() {
		Telefono telefono;
		telefono = new Telefono(Leer.pedirCadena("introduzca un numero de telefono","[+]?([0-9]{2})?[0-9]{9}"), Leer.pedirCadena("introduzca el tipo de telefono"));
		return telefono;
	}

	private static Persona buscarClave(TreeMap<Persona, ArrayList<Telefono>> contactos, Persona persona) {
		Iterator<Persona> it = contactos.keySet().iterator();
		String pedirCadena = Leer.pedirCadena("introduzca el contacto");
		for (Persona persona2 : contactos.keySet()) {
			if (persona2.getNombre().equals(pedirCadena)) {
			persona = persona2;	
			}
		}
		return persona;
	}

	private static void crearContactos(TreeMap<Persona, ArrayList<Telefono>> contactos) {
		Persona persona;
		ArrayList<Telefono> telefonos;
		Telefono telefono;
		persona = new Persona(Leer.pedirCadena("introduzca un nuevo contacto"));
		telefono = crearTelefono();
		telefonos = new ArrayList<Telefono>();
		telefonos.add(telefono);
		contactos.put(persona, telefonos);
	}

	private static void grabarDatos(TreeMap<Persona, ArrayList<Telefono>> contactos) {
		Fichero archivo2= new Fichero("agenda.dat", "O");
		archivo2.escribir(contactos);
		archivo2.cerrar("O");
	}

}
