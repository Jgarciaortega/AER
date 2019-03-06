package AER;

import java.util.Scanner;

public class P439_VelocidadTiempo {

	public static void main(String[] args) {



		Scanner teclado=new Scanner(System.in);
		int veces = teclado.nextInt();
		String palabra1;
		String palabra2;
		char letra1;
		char letra2;
		int numero1;
		int numero2;
		int velocidad;
		int desplazamiento;
		int tiempo;

		for (int i = 1; i <= veces; i++) {
			velocidad = 0;
			desplazamiento = 0;
			tiempo = 0;

			palabra1 = teclado.next();
			palabra2 = teclado.next();

			letra1 = palabra1.charAt(0);
			letra2 = palabra2.charAt(0);

			numero1 = Integer.parseInt(palabra1.substring(2));
			numero2 = Integer.parseInt(palabra2.substring(2));

			if (letra1 == 'D' && letra2 == 'T') {

				velocidad = numero1 / numero2;

			} else if ( letra1 == 'T' && letra2 == 'D') {

				velocidad = numero2 / numero1;


			} else if (letra1 == 'T' && letra2 == 'V' || letra2 == 'T' && letra1 == 'V') {


				desplazamiento = numero1 * numero2;


			} else if (letra1 == 'D' && letra2 == 'V' ) {

				tiempo = numero1 / numero2;

			}else if (letra1 == 'V' && letra2 == 'D') {

				tiempo = numero2 / numero1;

			}


			if (velocidad > 0 ) {

				System.out.println("V="+velocidad);
			}
			if (desplazamiento > 0 ) {

				System.out.println("D="+desplazamiento);
			}
			if (tiempo > 0 ) {

				System.out.println("T="+tiempo);
			}


		}




	}


}
