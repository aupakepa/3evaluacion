import java.io.File;
import java.util.Map.Entry;
import java.util.TreeMap;

import utilidades.Leer;

/*Ejercicio 4.
Deseamos realizar una aplicación para la gestión de usuarios y claves de acceso a un
sistema (red, base de datos, programa de gestión etc.)
Para ello vamos a utilizar mapas (TreeMap) donde el par de datos será:
 <usuario, clave de acceso>, los usuarios no pueden repetirse (TreeMap).
 Además para mayor seguridad las claves no se guardan tal y como la tecleamos
sino que se guardan codificadas con un sencillo algoritmo que consiste en
desplazar los caracteres un número fijo entero, p. ej. si la clave es ABC y el
número fijo es 2 la clave será ABC pero en el mapa guardamos CDE, de forma
que si nos pillan el fichero de claves, dicho fichero no sería el real sino el
codificado.
 Las claves deben ser de tal forma que solo admitan mayúsculas, minúsculas y
números y ningún otro carácter debe ser admitido.
Crear la aplicación para que se pueda:
 Insertar usuario, clave
 Borrar usuarios
 Modificar claves de un usuario
 Validar a un usuario si su clave es correcta*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, String> contrasenas = new TreeMap <String, String>();
		File f = new File("usuarios.txt");
		Fichero usuarios;
		if (f.exists()) {
			usuarios = new Fichero("usuarios.txt", "I");
			contrasenas=usuarios.leer();
			usuarios.cerrar("I");
		}
		int menu = -1;
		String usuario;
		do {
			Leer.mostrarEnPantalla("----------------------");
			Leer.mostrarEnPantalla("1.Introducir Usuario");
			Leer.mostrarEnPantalla("2.Borrar Usuario");
			Leer.mostrarEnPantalla("3.Modificar Clave");
			Leer.mostrarEnPantalla("4.Validar Usuario");
			Leer.mostrarEnPantalla("5.Listar Usuarios");
			Leer.mostrarEnPantalla("0.Salir");
			Leer.mostrarEnPantalla("----------------------");
			menu = Leer.pedirEntero("introduzca una opcion de menu");
			switch (menu) {
			case 1:
				crearUsuario(contrasenas);
				escribirFichero(contrasenas);
				break;
			case 2:
				usuario=Leer.pedirCadena("introduzca usuario que desa borrar");//error al introducir un usuario en blanco
				if (validarContrasena(contrasenas, usuario)) {
					contrasenas.remove(usuario);
					Leer.mostrarEnPantalla("Usuario "+ usuario+" borrado");
				} else {
					Leer.mostrarEnPantalla("La contraseña no es correcta");
				}
				escribirFichero(contrasenas);
				break;
			case 3:
				usuario=Leer.pedirCadena("introduzca el usuario a modificar");
				if (validarContrasena(contrasenas, usuario)) {
					contrasenas.replace(usuario, crearContrasena());
					Leer.mostrarEnPantalla("Usuario Modificado");
				}else {
					Leer.mostrarEnPantalla("contraseña no es correcta");
				}
				escribirFichero(contrasenas);
				break;
			case 4:
				usuario=Leer.pedirCadena("introduzca usuario que desa validar");
				if (validarContrasena(contrasenas, usuario)) {
					Leer.mostrarEnPantalla("El usuario ha sido validado");
				} else {
					Leer.mostrarEnPantalla("El usuario no a podido ser validado");
				}
				break;
			case 5:
				for (Entry<String, String> usuario1 : contrasenas.entrySet()) {
					Leer.mostrarEnPantalla(usuario1.toString());
				}
				Leer.mostrarEnPantalla(contrasenas+"");
				break;
				
			case 0:
				break;

			default:
				break;
			}
		} while (menu != 0);

	}

	private static void escribirFichero(TreeMap<String, String> contrasenas) {
		Fichero usuarios;
		usuarios = new Fichero("usuarios.txt", "O");
		usuarios.escribir(contrasenas);
		usuarios.cerrar("O");
	}

	private static boolean validarContrasena(TreeMap<String, String> contrasenas, String usuario) {
		String contrasena = Leer.pedirCadena("Introduzca la contrasena");
		contrasena = cifrarContrasena(contrasena);
		boolean validar=false;
		if (contrasenas.get(usuario).equals(contrasena)) {
			Leer.mostrarEnPantalla("La contraseña es correcta");
			validar=true;
		}
		return validar;
	}

	private static void crearUsuario(TreeMap<String, String> contrasenas) {
		String usuario,contrasena;
		Boolean validar;
		do {
			validar = true;
			usuario = Leer.pedirCadena("Introduzca el usuario");
			if (contrasenas.containsKey(usuario)) {
				validar = false;
				Leer.mostrarEnPantalla("El usuario ya existe");
			} else {
				Leer.mostrarEnPantalla("El usuario esta disponible");
			}
		} while (!validar);
		contrasena=crearContrasena();

		contrasena = cifrarContrasena(contrasena);
		contrasenas.put(usuario, contrasena);
	}

	private static String crearContrasena() {
		String contrasena1, contrasena2;
		do {
			contrasena1 = Leer.pedirCadena("introduzca contrasena");
			contrasena2 = Leer.pedirCadena("vuelva a introducir contrasena");
			if (!contrasena1.equals(contrasena2)) {
				Leer.mostrarEnPantalla("Las contraseñas no coinciden");
			}
		} while (!contrasena1.equals(contrasena2));
		return contrasena1;
	}

	private static String cifrarContrasena(String contrasena1) {
		String contrasenaCifrada = "";
		for (int j = 0; j < contrasena1.length(); j++) {
			int codigo = (int) (contrasena1.charAt(j)) + 3;
			contrasenaCifrada = contrasenaCifrada + (char) codigo;
		}
		return contrasenaCifrada;
	}

}