import java.io.*;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import utilidades.Leer;

public class Fichero {
	private BufferedReader entrada;
	private BufferedWriter salida;

	public Fichero(String nombre, String io){
		//fin=false;
		if (io.equals("I")){//abrir el fichero para leer
			try{
				entrada=new BufferedReader(new FileReader(nombre));//asignar fichero a buffer
			}catch(IOException e){//controlar el error
				Leer.mostrarEnPantalla("Error al abrir el archivo de entrada "+e.getMessage());
				System.exit(1);
			}
		}
		if (io.equals("O")){//abrir el fichero para escribir
			try{
				salida=new BufferedWriter(new FileWriter(nombre));//asignar fichero a buffer
			}catch(IOException e){//controlar el error
				Leer.mostrarEnPantalla("Error al abrir el archivo de salida "+e.getMessage());
				System.exit(1);
			}
		}
	}
	
	public String leer(){
		//Persona persona=null;
		String linea=null;
		try {
			linea = entrada.readLine();//leemos un registro
			
			//persona=new Persona(nombre,apellido,edad);
			//return persona;
		}catch(IOException e){
			Leer.mostrarEnPantalla("Error al leer en el archivo "+e.getMessage());
			System.exit(1);
		} catch (NullPointerException e) {
			//return null;
		}
	return linea;
	}

	public Boolean escribir(TreeMap<String,String> contraseñas){
		
		try {
			
			Iterator<Entry<String, String>> it = contraseñas.entrySet().iterator();
			while (it.hasNext()) {
				String nombre = it.next().getKey();
				String contraseña = contraseñas.get(nombre);
				if(nombre!=null){//si el objeto existe lo escribimos
					salida.write(nombre+Separable.getSeparador()+contraseña+"\n");
				}
			}
			
		}catch(IOException e){//controlar el error de escritura
			Leer.mostrarEnPantalla("Error al leer en el archivo "+e.getMessage());
			System.exit(1);
		} catch (NullPointerException e) {//controlar el error de asignación de fichero
	        return false;
	    }
		return true;
	}
	
	public void cerrar(String io){ 
		try{
			if(io.equals("I")){//cerrar el buffer de entrada
				entrada.close();
			}
			if(io.equals("O")){//cerrar el buffer de salida
				salida.close();
			}
		}catch(IOException e){//controlar la excepción
			Leer.mostrarEnPantalla("Error al cerrar el archivo "+e.getMessage());
			System.exit(1);
		}
	}
}
