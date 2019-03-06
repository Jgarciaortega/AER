package AER;


import java.util.ArrayList;
import java.util.Scanner;

public class P473_AlMundialEnTransatlantico {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int balones;
		int posicion;
		int ultPosicion;
		int cont;
		int tamaño = 0;
		int posFinal;
		
		while (true) {

			ArrayList <Integer> lista = new ArrayList <Integer>();
			balones = sc.nextInt();
			posicion = sc.nextInt();
			ultPosicion = 0;
			posFinal = 0;
			int j = 0;


			if (balones == 0 && posicion == 0) {

				break;

			}


			for (int i = 0; i < balones; i++) {

				lista.add(i+1);

			}



			for (int i = 0; i < balones; i++) {

				cont = 0;
				tamaño = lista.size();


				while(cont < posicion) {

					j++;	
					cont++;

					if(lista.size()==1) {

						break;

					}

					if (cont == posicion) {

						if (j == tamaño) {

							lista.remove(j-1);
							j = 0;

						}else {

							j --;
							lista.remove(j);
						}

					}

					if  (j == tamaño) {

						j = 0;

					}
				}
			}
			
			System.out.println(lista.get(0));
			
		}
	}
}
