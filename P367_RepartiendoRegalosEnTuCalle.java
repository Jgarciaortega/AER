package Resueltos;

import java.util.Scanner;

public class P367_RepartiendoRegalosEnTuCalle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int casos;
		int posAterriza;
		int totalPortales;
		int numPortalConRegalo;
		int [] portalesConRegalo;
		int aux;
		int diferencia;
		int posDiferenciaMenor;
		int diferenciaMenor;

		casos = sc.nextInt();

		for (int i = 0; i < casos; i ++) {

			posAterriza = sc.nextInt();
			totalPortales = sc.nextInt();
			portalesConRegalo = new int [totalPortales];

			aux = 0;
			diferencia = 0;
			posDiferenciaMenor = Integer.MAX_VALUE;


			for (int j = 0; j < totalPortales ; j ++) {

				numPortalConRegalo = sc.nextInt();
				portalesConRegalo[j] = numPortalConRegalo;

			}

			for (int j = 0; j < portalesConRegalo.length-1; j++) {

				diferenciaMenor = Integer.MAX_VALUE;

				for (int z = j; z < portalesConRegalo.length; z ++) {

					diferencia = Math.abs(portalesConRegalo[z] - posAterriza);

					if (diferencia == diferenciaMenor) {

						if (portalesConRegalo[z] > portalesConRegalo[posDiferenciaMenor]) {

							diferenciaMenor = diferencia;
							posDiferenciaMenor = z;

						}	


					} else if (diferencia < diferenciaMenor) {

						diferenciaMenor = diferencia;
						posDiferenciaMenor = z;
					}

				}

				if (posDiferenciaMenor == j) {

					portalesConRegalo[j] = portalesConRegalo[posDiferenciaMenor];
					posAterriza = portalesConRegalo[j];

				} else {

					aux = portalesConRegalo[j] ;
					portalesConRegalo[j] = portalesConRegalo[posDiferenciaMenor];
					portalesConRegalo[posDiferenciaMenor] = aux;
					posAterriza = portalesConRegalo[j];

				}
			}

			for (int j = 0; j < portalesConRegalo.length; j ++) {

				if (j != portalesConRegalo.length-1) {

					System.out.printf("%d ",portalesConRegalo[j]);

				} else {

					System.out.println(portalesConRegalo[j]);
				}


			}


		}
	}
}

