package Resueltos;
import java.util.Scanner;

/* En este problema tenemos que calcular la cantidad de midiclorianos de cada hijo de las familias dadas. Para ello el primer dato de entrada será
 * el numero de familias. En la siguiente linea encontramos primero el numero de hijos de esa familia y despues la cantidad de midiclorianos que el
 * padre ha transmitido a sus hijos. En la siguiente línea encontramos la Fuerza segun el dia de nacimiento de cada hijo. Este dato se multiplicara
 * por la cantidad de midiclorianos transmitidos por el padre. Esto se repetira por cada familia (primer dato de entrada). Por ultimo nos piden mostrar
 * los datos del mejor hijo de cada familia. Mostrar tambien estos datos de mayor a menor comparandolos con el resto da familias.
 */

public class P431_GeneticaJedi {

	public static void main(String[] args) {


		int familias;
		int hijos;
		int midiclorianos;
		int midiclorianosTransmitidos[] = new int [0];
		int mejorHijo = 0;
		int mejoresHijos [] = new int [0];
		int influenciaFuerza;

		Scanner sc = new Scanner(System.in);


		while (true) {

			familias = sc.nextInt();
			mejoresHijos = new int [familias]; 

			//Creamos bucle para establecer la cantidad de midiclorianos. Este bucle se repetira acorde con las familias que se quieran analizar
			for (int j = 0; j < familias && familias != 0; j++) {

				hijos = sc.nextInt();
				mejorHijo = 0;
				//Nos hara falta un vector para guardar la cantidad de midiclorianos que recibira cada hijo, ya que 
				//despues tendremos que ordenar esta informacion
				
				midiclorianosTransmitidos = new int [hijos]; 
				//Nos hace falta otro vector para almacenar los datos de los mejores hijos de cada familia
				
				

				midiclorianos = sc.nextInt();
				//Siguiente for anidado para , segun los hijos de cada familia, calcular el total de midiclorianos recibidos
				
				for (int i = 0; i < hijos; i ++) {

					influenciaFuerza = sc.nextInt();
					 //El calculo de midiclorianos transmitidos es la influencia de la fuerza según dia de nacimiento * midiclorianos recibidos por padre
	            	midiclorianosTransmitidos[i] = influenciaFuerza * midiclorianos;
	            	//Aquí selecciono el mejor hijo de la familia
	            	if (midiclorianosTransmitidos[i] >= mejorHijo) {
	            		
	            		mejorHijo = midiclorianosTransmitidos[i];
	            	}
	            	
				}
				
				//Cuando sabemos el mejor hijo de la familia lo introducimos en otro vector en el que apareceran los mejores hijos de cada familia
				mejoresHijos[j] = mejorHijo;
				
			}
			
			//Ordenamos el vector con una funcion e imprimimos el resultado
			mejoresHijos = ordenaVector(mejoresHijos);
			imprimirVector(mejoresHijos);

			if (familias == 0) {

				break;
			}
		}


	}


	public static int [] ordenaVector (int [] midiclorianosTransmitidos) {

		int aux = Integer.MIN_VALUE;

		for (int i = 0; i < midiclorianosTransmitidos.length; i ++) {
			for (int j = i + 1; j < midiclorianosTransmitidos.length; j++ ) {

				if (midiclorianosTransmitidos[i] < midiclorianosTransmitidos[j]) {

					aux = midiclorianosTransmitidos[i];
					midiclorianosTransmitidos[i] = midiclorianosTransmitidos[j];
					midiclorianosTransmitidos[j] = aux;

				}
			}
		}


		return midiclorianosTransmitidos;
	}
	
	
	public static void imprimirVector (int [] midiclorianosTransmitidos) {
			
		
		
			for (int i = 0; i < midiclorianosTransmitidos.length; i++) {
				
				if (i != midiclorianosTransmitidos.length -1) {
					
					System.out.printf("%d ",midiclorianosTransmitidos[i]);
						
				} else {
					
					System.out.printf("%d",midiclorianosTransmitidos[i]);
					System.out.println("");
				}
				
			}
			
	}		
	
}
