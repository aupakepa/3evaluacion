import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import utilidades.Leer;

public class Configuracion implements Separable {
	private BufferedReader entrada;
	private BufferedWriter salida;

	public Configuracion(String nombre, String io) {
		// fin=false;
		if (io.equals("I")) {// abrir el fichero para leer
			try {
				entrada = new BufferedReader(new FileReader(nombre));// asignar fichero a buffer
			} catch (IOException e) {// controlar el error
				Leer.mostrarEnPantalla("Error al abrir el archivo de entrada " + e.getMessage());
				System.exit(1);
			}
		}
		if (io.equals("O")) {// abrir el fichero para escribir
			try {
				salida = new BufferedWriter(new FileWriter(nombre));// asignar fichero a buffer
			} catch (IOException e) {// controlar el error
				Leer.mostrarEnPantalla("Error al abrir el archivo de salida " + e.getMessage());
				System.exit(1);
			}
		}
	}

	public String leer() {
		String config = null;
		
		try {
			config = entrada.readLine();// leemos un registro
			if (config.length() != 0) {
			return config;}
		}
		 catch (IOException e) {
			Leer.mostrarEnPantalla("Error al leer en el archivo " + e.getMessage());
			System.exit(1);
		} catch (NullPointerException e) {
			return null;
		}
		return config;
	}

	public Boolean escribir(String config) {

		try {
			if (config != null) {// si el objeto existe lo escribimos
				salida.write(config.toString());
			}
		} catch (IOException e) {// controlar el error de escritura
			Leer.mostrarEnPantalla("Error al leer en el archivo " + e.getMessage());
			System.exit(1);
		} catch (NullPointerException e) {// controlar el error de asignación de fichero
			return false;
		}
		return true;
	}

	public void cerrar(String io) {
		try {
			if (io.equals("I")) {// cerrar el buffer de entrada
				entrada.close();
			}
			if (io.equals("O")) {// cerrar el buffer de salida
				salida.close();
			}
		} catch (IOException e) {// controlar la excepción
			Leer.mostrarEnPantalla("Error al cerrar el archivo " + e.getMessage());
			System.exit(1);
		}
	}
}
