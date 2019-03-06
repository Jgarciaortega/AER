package AER;

import java.util.Scanner;

public class P481_Ajedrez {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int fila;
		int columna;
		String letra = null;


		while (true) {


			columna = sc.nextInt();
			fila = sc.nextInt();


			if (fila == 0 && columna == 0 ) {

				break;
			}


			if (columna == 1) {

				letra = "h";

			}

			if (columna == 2) {

				letra = "g";

			}

			if (columna == 3) {

				letra = "f";

			}

			if (columna == 4) {

				letra = "e";

			}

			if (columna == 5) {

				letra = "d";

			}

			if (columna == 6) {

				letra = "c";

			}

			if (columna == 7) {

				letra = "b";

			}

			if (columna == 8) {

				letra = "a";

			}
			
			
			System.out.printf("%s%d\n",letra,fila);
			
			
		}

	}

}
