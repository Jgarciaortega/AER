package AER;

import java.math.BigInteger;
import java.util.Scanner;

public class P484_ElIncidenteDeDhahran {

	public static void Imprimir1(String cadena) {
		
		boolean start = false;
		
		// Empiezo a imprimir despues de encontrar el primero numero != 0 
		for (int i = 0; i < cadena.length(); i++) {
			
			if (cadena.charAt(i) != '0') {
				start = true;
			}
			
			if (start) System.out.print(cadena.charAt(i));
		}
		
	}
	
	
	public static void Imprimir2(String cadena) {
		
		int pos = 0;
		
		// Recorro el string hasta que me encuentro un numero != 0, encontes obtengo su posicion
		for (int i = cadena.length(); i > 0; i--) {
			if (cadena.charAt(i-1) != '0') {
				pos = i-1;
				break;
			}
		}

		// Imprimo hasta la posicion que obtengo(en la cual he desechado los 0s a la izq)
		for (int i = 0; i <= pos; i++) System.out.print(cadena.charAt(i));
	}
	
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String cadena;
		String left;
		String right;
		int compareValue;
		int compareValueLeft;
		int compareValueRight;
		
		while (s.hasNext()) {

			cadena = s.next();

			if (cadena.indexOf(".") != -1) { // CASO CON DECIMALES 
											 // 00032.32300 -> 32.32 || 000.3200 -> 0.32
											 // 00.00 -> 0           || 0032.000 -> 32
				
				String[] separacion = cadena.split("\\.");

				left  = separacion[0];
				right = separacion[1];

				compareValueLeft  = new BigInteger(left).compareTo(new BigInteger("0"));
				compareValueRight = new BigInteger(right).compareTo(new BigInteger("0"));

				if (compareValueLeft == 0 && compareValueRight == 1) {
					System.out.print("0" + ".");
					Imprimir2( right );
				} 
				else if (compareValueLeft == 1 && compareValueRight == 0){
					Imprimir1( left );
				} 
				else if (compareValueLeft == 0 && compareValueRight == 0){
					System.out.print("0");
				}
				else {
					Imprimir1( left );
					System.out.print(".");
					Imprimir2( right );
				}
				
				System.out.println("");
			} 
			else { // CASO SIN DECIMALES -> 00432 -> 432
				
				// Devuelve 1 si la el numero recojido es mayor que 0
				compareValue = new BigInteger(cadena).compareTo(new BigInteger("0"));
				
				if (compareValue == 1) {
					Imprimir1( cadena );
				} 
				else {
					System.out.print("0");
				}

				System.out.println("");					
			}

		} // While true

	} // Main	

} // Class
