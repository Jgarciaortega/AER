package Resueltos;
import java.util.Scanner;

public class P102_EncriptacionDeMensajes {

	public static void main(String[] args) {

		String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char [] abc = abecedario.toCharArray();
		String cadena;
		char [] cadenaV; 
		int posiciones;
		Scanner sc = new Scanner(System.in);
		String letras = "AEIOU";
		char [] letra = letras.toCharArray();
		String finS = "PFIN";
		char [] finC = finS.toCharArray();
		int vocales;
		boolean fin;
		int aux;
		char [] cadenaVFIN;

		while (true) {

			aux = 0;
			posiciones = 0;
			vocales = 0;
			cadena = sc.nextLine();
			cadenaVFIN = cadena.toCharArray();
			cadena = cadena.toUpperCase();
			cadenaV = cadena.toCharArray();
			fin = false;

			//Averiguamos aqui cual sera el numero de letras que debemos sumar o restar
			posiciones = cuentaDistanciaAP (cadenaV,abc);

			//Desciframos la cadena inicial
			cadenaV = descifraCadena(cadenaV,abc,posiciones);

			//Averiguo antes de contar vocales si la cadenaV devuelve FIN

			//Solo ha de aceptar FIN si la cadena inicial era en mayusculas por lo que vamos a comprobarla. Antes de transformarla en
			//un vector de char la he almacenado en otra variable (cadena1)

			if (cadenaV.length == 4) {

				for (int i = 1; i < 4; i ++) {

					if (cadenaV[i] == finC[i]) {

						if (Character.isUpperCase(cadenaVFIN[i])) {

							aux ++;
						}
					}
				}

			}
			if (aux == 3) {


				fin = true;

			}


			if (fin) {

				break;
			}


			//Contamos las vocales de cadena

			for (int i = 1; i < cadenaV.length && fin == false; i++) {

				for (int j = 0; j < letra.length; j ++) {

					if (cadenaV[i] == letra[j]) {

						vocales ++;
						break;
					}

				}

			}

			System.out.println(vocales);
		}

	}


	public static int cuentaDistanciaAP (char [] cadenaV, char [] abc) {

		/*Este primer For lo utilizo para conocer el tipo de cifrado tendra. El incremento que haya que hacer a cada letra
		 * viene dado por la diferencia del primer caracter hasta P. Para ello creamos posiciones y contamos...
		 */

		int posiciones = 0;

		//Primera opci�n. La letra se haya en el abecedario antes que P
		//Aqu� empieza a contar desde A hasta que encuentre la primera letra. Una vez la encuentre entra en un for
		//que cuenta hasta que localice P. Aqu� posiciones es positivo.
		for (int i = 0; i < abc.length ; i ++) {

			if (abc[i] == cadenaV[0]) {

				for (int j = i;  abc[j] != 'P'; j ++) {

					posiciones ++;

				}

				break;

				//Segunda opcion. La letra se haya despu�s de la P.	
				//Contamos desde P hasta que encontremos el caracter de inicio. Aqu� posiciones ser� negativo.
			} else if (abc[i] == 'P') {

				for (int x = 15; abc[x] != cadenaV[0]; x ++ ) {

					posiciones --;
				}

				break;
			}

		}	
		return posiciones;
	}


	public static char [] descifraCadena(char [] cadenaV, char [] abc, int posiciones) {

		int posicionTrasFinAbc = 0;

		//Recorremos primera la cadena introducida para analizar sus letras. Inicializamos i = 1 para ignorar la primera letra P
		for (int i = 1; i < cadenaV.length; i ++) {

			//Buscaremos esa letra en el abecedario
			for (int j = 0; j < abc.length; j ++) {

				//Posiciones es positivo lo que indica que habra que incrementar letras en abc
				if (cadenaV[i] == abc[j] && posiciones > 0) {

					//Primer if para comprobar que la nueva posicion no se pasa de la Z
					if (j + posiciones <= 25) {

						cadenaV[i] = abc[j + posiciones];
						break;
						//Segundo caso en el que la posicion si que se pasa de Z, por lo que debe continuar por A	
					} else {

						//posicionTrasFinAbc = Math.abs(posiciones - 25);
						posicionTrasFinAbc = Math.abs(25 - j - posiciones );
						cadenaV[i] = abc[posicionTrasFinAbc-1];
						break;
					}


					//Posiciones son negativas lo que indica que habra que restar letras al abc	
				} else if (cadenaV[i] == abc[j] && posiciones < 0) {

					//Primer caso para comprobar que no se pasa de la A
					if (j + posiciones >= 0) {

						cadenaV[i] = abc[j + posiciones];
						break;
						//Segundo caso en el que la posicion si que se pasa de la A, por lo que debe continuar por Z	
					} else {

						posicionTrasFinAbc =  (posiciones + j + 25);
						cadenaV[i] = abc[posicionTrasFinAbc + 1];
						break;

					}

				}

			}

		}
		return cadenaV;
	}

}
