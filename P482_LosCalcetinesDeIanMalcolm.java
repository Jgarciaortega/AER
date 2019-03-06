package AER;
import java.util.Scanner;

public class P482_LosCalcetinesDeIanMalcolm {

	public static void main(String[] args) {

		int grises;
		int negros;
		Scanner sc = new Scanner(System.in);
		String cadena;


		while(true) {

			cadena = sc.nextLine();
			negros = 0;
			grises = 0;

			if(cadena.substring(0).equals(".")){

				break;
			}

			for (int i = 0 ; i < cadena.length(); i+=2) {

				if (cadena.substring(i,i+1).equals("N")) {

					negros ++;

				}else if (cadena.substring(i,i+1).equals("G")) {

					grises ++;

				}else if (cadena.substring(i,i+1).equals(".")){

					break;

				}


			}


			System.out.println(devolverPareja(negros,grises));
		}

	}

	public static String devolverPareja(int negros, int grises) {

		String emparejamiento = null;

		if(negros % 2 == 0 && grises % 2 == 0) {

			emparejamiento = "EMPAREJADOS";

		}

		if(negros % 2 != 0 && grises % 2 != 0) {

			emparejamiento = "PAREJA MIXTA";

		}

		if(negros % 2 != 0 && grises % 2 == 0) {

			emparejamiento = "NEGRO SOLITARIO";

		}

		if(negros % 2 == 0 && grises % 2 != 0) {

			emparejamiento = "GRIS SOLITARIO";

		}

		return emparejamiento;
	}

}
