package AER;
import java.util.Scanner;
import java.util.Stack;

public class P197_MensajeInterceptado {

	public static void main(String[] args) {

		String mensaje;
		String mensajeCifrado;
		String mensajeCifrado2;
		Stack <String> pila;
		String digito;
		Scanner sc = new Scanner(System.in);
		int aux;
		boolean secuenciaConsonantes;
		int posInicioConsonante;
		int posInicioVocal;

		while(sc.hasNext()) {

			mensaje = sc.nextLine();
			pila = new Stack <String>();
			mensajeCifrado ="";
			mensajeCifrado2 = "";
			aux = 0;
			secuenciaConsonantes = false;
			posInicioConsonante = 0;
			posInicioVocal = 0;

			//X''
			for(int i = 0; i < mensaje.length(); i++) {

				if (i % 2 == 0) {

					digito = "" + mensaje.charAt(i);
					mensajeCifrado += digito;

				}else {

					digito = "" + mensaje.charAt(i);
					pila.push(digito);
					aux = pila.size();
				}				
			}

			for(int i = 0; i < aux; i++) {

				mensajeCifrado += pila.pop();

			}

			//X'
			aux = 0;

			for(int i = 0; i < mensajeCifrado.length(); i++) {

				digito = "" + mensajeCifrado.charAt(i);

				if (comprobarDigito (mensajeCifrado.charAt(i))) {

					for (int j = 0; j < aux && aux > 0; j++) {

						mensajeCifrado2 += pila.pop();

					}
					aux = 0;
					mensajeCifrado2 += digito;


				}else {

					pila.push(digito);
					aux = pila.size();
				}				

			}

			if(aux > 0) {

				for(int j = 0; j < aux; j++) {

					mensajeCifrado2 += pila.pop();
				}
			}

			System.out.println(mensaje + " => " +mensajeCifrado2);
		}		
	}


	public static boolean comprobarDigito(char digito){


		char[] vocales= {'a','e','i','o','u','A','E','I','O','U'};
		boolean comprobacion = false;

		for(int i = 0; i < vocales.length; i++) {

			if (digito == vocales[i]) {

				comprobacion = true;
			}			
		}		
		return comprobacion;
	}


}