import java.io.*;

import utilidades.Leer;

public class Fichero {
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;

	public Fichero(String nombre, String io){
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
	
	public Billete leer( ) {
		Billete billete=null;
		try {
			billete = (Billete) entrada.readObject();//leemos un registro
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			billete=null;
		} catch (NullPointerException e) {
			billete= null;
		} catch(IOException e){
			//Leer.mostrarEnPantalla("Error al leer en el archivo "+e.getMessage());
			billete=null;
		} 
		return billete;
	}

	public Boolean escribir(Billete billete ){
		
		try {
			if(billete!=null){//si el objeto existe lo escribimos
				salida.writeObject(billete);
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
	public boolean exist() {
		salida.equals(obj)
	}
}
