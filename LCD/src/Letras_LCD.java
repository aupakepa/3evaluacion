import java.util.Scanner;

/**
 * 
 */

/**
 * @author usuario
 *
 */
public class Letras_LCD {
	private final String ABECEDARIO="abcdefghijklmn�opqrstuvwxyz1234567890";
	private String lcdA="";
	private String lcdM="";
	private String lcdB="";
	
	//Getters, en esta claso no he puesto ningun setter ya que no modifican ningun 
	//valor dentro de esta clase no hace falrta
	public String getAbecedario() {
		return ABECEDARIO;
	}
	
	public String getLcdA() {
		return lcdA;
	}
	
	public String getLcdM() {
		return lcdM;
	}
	
	public String getLcdB() {
		return lcdB;
	}
	
	//Constructor
	public Letras_LCD(String frase) {
		frase=frase.toLowerCase();		//Transforma la frase que se ha introducido y coloca todas las mayusculas en minusculas
		
		for (int i = 0; i < frase.length(); i++) {
			LCD(ABECEDARIO.indexOf(frase.substring(i, i+1))); //Ejecuta el LCD
		}
		Imprimir(); //Imprime los valores finales
	}
	
	//Es el metodo para imprimir el texto correctamente
	private void Imprimir() {
		System.out.println(lcdA);
		System.out.println(lcdM);
		System.out.println(lcdB);
	}
	
	//El metodo que por cada letra introduce un valor a "lcdA (LCD parte de arriba), lcdM (LCD parte del medio) 
	//y lcdB (LCD parte de abajo)"
	private void LCD(Integer letra) {
	//Al detectar el numero de letra donde esta posicionada la letra de la frase dentro del abecedario, se introduce en el 
	//switch donde coloca los datos de la letra introducida PD:Incluye numeros
		switch (letra) {
		case 0:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|_|";
			lcdB=lcdB+"| |";
			break;
		case 1:
			lcdA=lcdA+"__ ";
			lcdM=lcdM+"|_|";
			lcdB=lcdB+"|_|";
			break;
		case 2:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|  ";
			lcdB=lcdB+"|_ ";
			break;
		case 3:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"| \\";
			lcdB=lcdB+"|_/";
			break;
		case 4:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|_ ";
			lcdB=lcdB+"|_ ";
			break;
		case 5:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|_ ";
			lcdB=lcdB+"|  ";
			break;
		case 6:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"| _";
			lcdB=lcdB+"|_|";
			break;
		case 7:
			lcdA=lcdA+"   ";
			lcdM=lcdM+"|_|";
			lcdB=lcdB+"| |";
			break;
		case 8:
			lcdA=lcdA+"   ";
			lcdM=lcdM+" | ";
			lcdB=lcdB+" | ";
			break;
		case 9:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+" | ";
			lcdB=lcdB+"\\| ";
			break;
		case 10:
			lcdA=lcdA+"   ";
			lcdM=lcdM+"|/ ";
			lcdB=lcdB+"|\\ ";
			break;
		case 11:
			lcdA=lcdA+"  ";
			lcdM=lcdM+"| ";
			lcdB=lcdB+"|_";
			break;
		case 12:
			lcdA=lcdA+"   ";
			lcdM=lcdM+"|V|";
			lcdB=lcdB+"| |";
			break;
		case 13:
			lcdA=lcdA+"    ";
			lcdM=lcdM+"|\\ |";
			lcdB=lcdB+"| \\|";
			break;
		case 14:
			lcdA=lcdA+" -- ";
			lcdM=lcdM+"|\\ |";
			lcdB=lcdB+"| \\|";
			break;
		case 15:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"| |";
			lcdB=lcdB+"|_|";
			break;
		case 16:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|_|";
			lcdB=lcdB+"|  ";
			break;
		case 17:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"| |";
			lcdB=lcdB+"|_\\";
			break;
		case 18:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|_|";
			lcdB=lcdB+"| \\";
			break;
		case 19:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|_ ";
			lcdB=lcdB+" _|";
			break;
		case 20:
			lcdA=lcdA+"___";
			lcdM=lcdM+" | ";
			lcdB=lcdB+" | ";
			break;
		case 21:
			lcdA=lcdA+"   ";
			lcdM=lcdM+"| |";
			lcdB=lcdB+"|_|";
			break;
		case 22:
			lcdA=lcdA+"   ";
			lcdM=lcdM+"| |";
			lcdB=lcdB+" v ";
			break;
		case 23:
			lcdA=lcdA+"   ";
			lcdM=lcdM+"| |";
			lcdB=lcdB+"|^|";
			break;
		case 24:
			lcdA=lcdA+"   ";
			lcdM=lcdM+"\\/ ";
			lcdB=lcdB+"/\\ ";
			break;
		case 25:
			lcdA=lcdA+"   ";
			lcdM=lcdM+" \\/";
			lcdB=lcdB+" / ";
			break;
		case 26:
			lcdA=lcdA+"__ ";
			lcdM=lcdM+" / ";
			lcdB=lcdB+"/_ ";
			break;
		case 27:
			lcdA=lcdA+"   ";
			lcdM=lcdM+"/| ";
			lcdB=lcdB+" | ";
			break;
		case 28:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+" _|";
			lcdB=lcdB+"|_ ";
			break;
		case 29:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+" _|";
			lcdB=lcdB+" _|";
			break;
		case 30:
			lcdA=lcdA+"   ";
			lcdM=lcdM+"|_|";
			lcdB=lcdB+"  |";
			break;
		case 31:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|_ ";
			lcdB=lcdB+" _|";
			break;
		case 32:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|_ ";
			lcdB=lcdB+"|_|";
			break;
		case 33:
			lcdA=lcdA+"__ ";
			lcdM=lcdM+" / ";
			lcdB=lcdB+"/  ";
			break;
		case 34:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|_|";
			lcdB=lcdB+"|_|";
			break;
		case 35:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"|_|";
			lcdB=lcdB+"  |";
			break;
		case 36:
			lcdA=lcdA+" _ ";
			lcdM=lcdM+"| |";
			lcdB=lcdB+"|_|";
			break;
		
		default:
			
			lcdA=lcdA+"   ";
			lcdM=lcdM+"   ";
			lcdB=lcdB+"   ";
			break;
		}
	}
}
//System.out.println("CONVERSOR A LCD. Introduzca una frase:");
//Scanner teclado=new Scanner(System.in);
//String frase=teclado.nextLine();
//Letras_LCD letras= new Letras_LCD(frase);

