package AER;
import java.util.Scanner;

public class P115_NumeroKaprekar {

	public static void main(String[] args) {

		int num;
		int potenciaNum;
		String numero;	
		String num1,num2;
		String num2S; //Utilizado para verificar que no lleguen dos 0 seguidos. Lo que invalida suma
		char check0;
		int suma;
		boolean Kaprekar;
		
		Scanner sc = new Scanner(System.in);


		while (true) {

			Kaprekar = false;
			suma = 0;
			num = sc.nextInt();
			potenciaNum = 0;

			if (num == 0) {

				break;
			}

			potenciaNum = (int) Math.pow(num, 2);
			numero = Integer.toString(potenciaNum);
			int digitosNum = ((numero.length())-1);
			
			for (int i = 0; i < numero.length()-1; i ++) {

				num1 = numero.substring(0, i+1);
				num2 = numero.substring(i+1 , numero.length());
				
				//Hay que invalidar si en num2 llegan dos ceros seguidos
				//Por ello si primer numero de  num2 = 0 aux suma 1
				if (num2.charAt(0) == '0' && num2.charAt(digitosNum-(i+1)) == '0') {
					
										
				} else {

					suma = Integer.valueOf(num1) + Integer.valueOf(num2);

				} 
			
				//Si suma coincide con num obtenemos kaprekar = true
				if (suma == num ) {

					Kaprekar = true;
					break;

				}

			}

			if (Kaprekar || potenciaNum == 1) {

				System.out.println("SI");

			} else {

				System.out.println("NO");

			}
		}

	}


}


