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

			/*X'': Este cifrado consiste en colocar las letras en posición impar al final de la cadena.
			Así por ejemplo, la letra que figure en la segunda posición (1 para los informáticos), deberá
			ser la última letra de la nueva cadena. Luego seguiremos con la que esté en posición cuarta (
			3 para los informáticos) y esta será la penultima letra. Así hasta completar todo la cadena.*/
			
			for(int i = 0; i < mensaje.length(); i++) {

				if (i % 2 == 0) { //Las que están en posición par las respetamos y las añadimos a la cadena

					digito = "" + mensaje.charAt(i);
					mensajeCifrado += digito;

				}else { //Utilizamos una pila para añadir todas las letras que irán al final. 

					digito = "" + mensaje.charAt(i);
					pila.push(digito);
					aux = pila.size();
				}				
			}

			for(int i = 0; i < aux; i++) {

				mensajeCifrado += pila.pop();//Cuando finalice la cadena solo tendremos que "volcar" el contenido de la pila
											//en el mensaje Cifrado. Al ser una pila, las que entraron en primer lugar serán las
											//primeras ha añadir.
			}

			/*X': El segundo cifrado consiste en intercambiar las secuencias de consonantes que localicemos. Por lo que las secuencias
			consonante-vocal se respetan, pero cuando localicemos varias consonantes seguidas deberemos intercambiar la primera de ellas
			por la última de la secuencia, luego, si hay más, sería la segunda por la penúltima, así hasta finalizar la secuencia.*/
			aux = 0;

			for(int i = 0; i < mensajeCifrado.length(); i++) {

				digito = "" + mensajeCifrado.charAt(i); //Recogemos el digito en formato String para añadirlo en la cadena posteriormente

				if (comprobarDigito (mensajeCifrado.charAt(i))) { //Si es vocal entramos en esta condición. Si hay contenido en la pila
																//lo añadirá al mensaje cifrado, si no lo hay directamente añadirá la vocal
					for (int j = 0; j < aux && aux > 0; j++) {  //a la secuencia.

						mensajeCifrado2 += pila.pop();

					}
					aux = 0;
					mensajeCifrado2 += digito;


				}else {	//Cuando no localiza vocal añadirá a la pila las consonantes, si solo hay una en la siguiente vocal volcará el contenido
						//en el condicional de arriba, si vuelve a haber otra consonante la añadira a la pila. 
					pila.push(digito);
					aux = pila.size();
				}				

			}

			if(aux > 0) { //Puede darse la circumnstancia de que no haya volcado todo, ya que si no localiza vocal no añade el contenido de la pila.
						 //Por esa razon creo que este condicional, el cual me dice si hay contenido en la pila, añadelo a mensaje cifrado

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