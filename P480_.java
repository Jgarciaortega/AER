package AER;

import java.util.Scanner;

public class P480_ {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int casos;
		int uvas,A,B;
		int uvasMalas;
		int cont;


		casos = sc.nextInt();

		while (casos > 0) {

			uvas = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			cont = B;
			uvasMalas = 0;

			for (int i = 0; i < uvas; i++) {


				if (cont == B) {

					if (A < uvas - i) {

						uvasMalas += A;
						cont = 0;
						
					}else {
						
						uvasMalas += (uvas - i);
								
					}
				}

				cont ++;

			}

			System.out.println(uvasMalas);

			casos --;
		}




	}

}