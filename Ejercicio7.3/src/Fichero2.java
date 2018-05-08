import java.io.*;

import utilidades.Leer;

public class Fichero2 {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;

	public Fichero2(String nombre, String io){
		//fin=false;
		if (io.equals("I")){//abrir el fichero para leer
			try{
				entrada=new ObjectInputStream(new FileInputStream(nombre));//asignar fichero a buffer
			}catch(IOException e){//controlar el error
				Leer.mostrarEnPantalla("Error al abrir el archivo de entrada "+e.getMessage());
				System.exit(1);
			}
		}
		if (io.equals("O")){//abrir el fichero para escribir
			try{
				salida=new ObjectOutputStream(new FileOutputStream(nombre));//asignar fichero a buffer
			}catch(IOException e){//controlar el error
				Leer.mostrarEnPantalla("Error al abrir el archivo de salida "+e.getMessage());
				System.exit(1);
			}
		}
	}
	
	public Tren leer( ) {
		Tren tren=null;
		try {
			tren = (Tren) entrada.readObject();//leemos un registro
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tren=null;
		} catch (NullPointerException e) {
			tren= null;
		} catch(IOException e){
			//Leer.mostrarEnPantalla("Error al leer en el archivo "+e.getMessage());
			tren=null;
		} 
		return tren;
	}

	public Boolean escribir(Tren tren ){
		
		try {
			if(tren!=null){//si el objeto existe lo escribimos
				salida.writeObject(tren);
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
