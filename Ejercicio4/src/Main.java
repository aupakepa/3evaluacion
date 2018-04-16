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
		TreeMap<String, String> contraseñas = new TreeMap<>();
		int menu = -1;
		String usuario;
		do {
			Leer.mostrarEnPantalla("----------------------");
			Leer.mostrarEnPantalla("1.Introducir Usuario");
			Leer.mostrarEnPantalla("2.Borrar Usuario");
			Leer.mostrarEnPantalla("3.Modificar Clave");
			Leer.mostrarEnPantalla("4.Validar Usuario");
			Leer.mostrarEnPantalla("0.Salir");
			Leer.mostrarEnPantalla("----------------------");
			menu = Leer.pedirEntero("introduzca una opcion de menu");
			switch (menu) {
			case 1:
				crearUsuario(contraseñas);

				break;
			case 2:
				usuario=Leer.pedirCadena("introduzca usuario que desa borrar");//error al introducir un usuario en blanco
				if (validarContraseña(contraseñas, usuario)) {
					contraseñas.remove(usuario);
					Leer.mostrarEnPantalla("Usuario "+ usuario+" borrado");
				} else {
					Leer.mostrarEnPantalla("La contraseña no es correcta");
				}
				break;
			case 3:
				usuario=Leer.pedirCadena("introduzca el usuario a modificar");
				if (validarContraseña(contraseñas, usuario)) {
					contraseñas.replace(usuario, crearContraseña());
					Leer.mostrarEnPantalla("Usuario Modificado");
				}else {
					Leer.mostrarEnPantalla("contraseña no es correcta");
				}
				break;
			case 4:
				usuario=Leer.pedirCadena("introduzca usuario que desa validar");
				if (validarContraseña(contraseñas, usuario)) {
					Leer.mostrarEnPantalla("El usuario ha sido validado");
				} else {
					Leer.mostrarEnPantalla("El usuario no a podido ser validado");
				}
				break;
			case 0:

				break;

			default:
				break;
			}
		} while (menu != 0);

	}

	private static boolean validarContraseña(TreeMap<String, String> contraseñas, String usuario) {
		String contraseña = Leer.pedirCadena("Introduzca la contraseña");
		contraseña = cifrarContraseña(contraseña);
		boolean validar=false;
		if (contraseñas.get(usuario).equals(contraseña)) {
			Leer.mostrarEnPantalla("La contraseña es correcta");
			validar=true;
		}
		return validar;
	}

	private static void crearUsuario(TreeMap<String, String> contraseñas) {
		String usuario,contraseña;
		Boolean validar;
		do {
			validar = true;
			usuario = Leer.pedirCadena("Introduzca el usuario");
			if (contraseñas.containsKey(usuario)) {
				validar = false;
				Leer.mostrarEnPantalla("El usuario ya existe");
			} else {
				Leer.mostrarEnPantalla("El usuario esta disponible");
			}
		} while (!validar);
		contraseña=crearContraseña();

		contraseña = cifrarContraseña(contraseña);
		contraseñas.put(usuario, contraseña);
	}

	private static String crearContraseña() {
		String contraseña1, contraseña2;
		do {
			contraseña1 = Leer.pedirCadena("introduzca contraseña");
			contraseña2 = Leer.pedirCadena("vuelva a introducir contraseña");
			if (!contraseña1.equals(contraseña2)) {
				Leer.mostrarEnPantalla("Las contraseñas no coinciden");
			}
		} while (!contraseña1.equals(contraseña2));
		return contraseña1;
	}

	private static String cifrarContraseña(String contraseña1) {
		String contraseñaCifrada = "";
		for (int j = 0; j < contraseña1.length(); j++) {
			int codigo = (int) (contraseña1.charAt(j)) + 3;
			contraseñaCifrada = contraseñaCifrada + (char) codigo;
		}
		return contraseñaCifrada;
	}

}
