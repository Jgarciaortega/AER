package Resueltos;
import java.util.Scanner;

public class P429_OrdenandoHangares {

	public static void main(String[] args) {

		
		/* En este problema nos piden ubicar las naves en hangares. El criterio para hacerlo será mandar las naves por orden de llegada al 
		 * hangar con mayor capacidad. Esta capacidad deberá ser recalculada cada vez llegue una nave,ya que la próxima nave en aterrizar
		 * deberá acudir al hangar con mayor capacidad en ese momento. El programa devuelve "SI" cuando hay espacio para todas las naves
		 * y "NO" cuando no lo haya.
		 * 
        */
		int hangares = 0;
		int tamanyo = 0;
		int naves = 0;
		int mayorTamanyo = 0;
		int posicionMayor = 0;
		boolean espacio;

		Scanner sc = new Scanner(System.in);

		while (true) {

			
			hangares = sc.nextInt();
			int tamanyoHangar[] = new int [hangares];
			espacio = true;

			//Distribuimos los tamanyos de los hangares en un vector
			for (int i = 0; i < hangares && hangares != 0; i ++) {

				tamanyo = sc.nextInt();
				tamanyoHangar[i] = tamanyo;

				//Averiguo a la vez cual es el hangar con mayor capacidad y...
				if (tamanyoHangar[i] > mayorTamanyo) { 
					//almaceno el mayor tamanyo y me quedo en la posicion del vector en la que esta
					mayorTamanyo = tamanyoHangar[i];
					posicionMayor = i;

				}
			}		

			//Si hangares es != 0 (orden de salida del programa) pediremos las naves que desean aterrizar en los hangares
			if (hangares != 0) {

				naves = sc.nextInt();

			}
			
			//Aquí creo un bucle que se repetirá mientras existan naves por aterrizar
			while (naves > 0 && hangares != 0) {

				//Pido las dimensiones de la nave y...
				tamanyo = sc.nextInt();
				//... se la resto a la posicion que previamente he averiguado que es la mayor del hangar(posicion mayor)
				tamanyoHangar[posicionMayor] -= tamanyo;

				//Si en este paso se diera la circumnstancia de que la resta anterior es negativa significa que no ha habido en la posicion de 
				//mayor espacio del hangar sitio suficiente para el tamanyo de la nave. Por lo que cambio el valor de espacio a falso y el programa
				//ya almacena este dato hasta el final, devolviendo un "NO".
				if (tamanyoHangar[posicionMayor] < 0) {

					espacio = false;

				}
				//Inicializado las posiciones para que el programa recalcule de nuevo la situación de espacio en el hangar
				posicionMayor = 0;
				mayorTamanyo = 0;




				//Averiguo de nuevo cual es la posicion con mas espacio para ubicar la siguiente nave
				for (int i = 0; i < hangares && hangares != 0 && espacio != false; i ++) {

					if (tamanyoHangar[i] > mayorTamanyo) { 

						mayorTamanyo = tamanyoHangar[i];
						posicionMayor = i;

					}

				}

				naves --;
			}

			//Si el programa logra colocar todas las naves no habrá cambiado el estado del boolean espacio que por defecto es true, por lo que devolverá 
			//un "SI". La única forma de que devuelva un "NO"  es si el tamanyo de alguna posicion del hangar es negativo, el cual se evalua después de la
			//resta tamanyoHangar[posicionMayor] - tamanyo.
			
			if (hangares == 0) { //Si numero hangares es 0 significa stop del programa

				break;

			} else {

				if (espacio) {

					System.out.println("SI");
					mayorTamanyo = 0;

				} else {

					System.out.println("NO");
					mayorTamanyo = 0;
				}
			}

		}
	}
}


