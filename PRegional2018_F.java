package AER;
import java.util.Scanner;

public class PRegional2018_F {

	public static void main(String[] args) {

		String abecedario;
		String palabra;
		char [] abc;
		char [] palabraCifrada;
		int tamanyoAbc;
		int tamanyoPalabra;
		int cantidadPalabras;
		int casos;
		Scanner sc = new Scanner (System.in);

		casos = sc.nextInt();
		sc.nextLine();

		while(casos > 0) {

			abecedario = sc.nextLine();
			abc = abecedario.toCharArray();
			palabra = sc.nextLine();
			palabraCifrada = palabra.toCharArray();			
			tamanyoAbc = abc.length;
			cantidadPalabras = tamanyoAbc - 1;
			tamanyoPalabra = palabraCifrada.length;

			for (int i = 0; i < cantidadPalabras; i++) {

				palabraCifrada = cifrar(abc,palabraCifrada,tamanyoAbc,tamanyoPalabra);

				for(char c: palabraCifrada) {

					System.out.print(c);
				}
				
				System.out.println("");
			}

			casos --;
		}
	}


	public static char[] cifrar(char[] abc, char[] palabraCifrada,int tamanyoAbc, int tamanyoPalabra) {

		for(int i = 0; i < tamanyoPalabra; i++) {

			for(int j = 0; j < tamanyoAbc; j++) {

				if(palabraCifrada[i] == abc[j]) {

					if (j == tamanyoAbc-1) {

						palabraCifrada[i] = abc[0];

					}else {

						palabraCifrada[i] = abc[j+1];
						break;
					}


				}

			}

		}
		return palabraCifrada;
	}

}
