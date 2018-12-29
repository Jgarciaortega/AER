package AER;
import java.util.Scanner;

public class P476_ProblemaDeEgos {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		int heroes;
		int [] niveles;
		int fuerza;
		int fuerza2;
		String [] preferencias;
		String signo;
		String signo2;
		int pos;
		boolean enfrentamiento = false;
		boolean sinCombate = true;

		while (true){

			heroes = sc.nextInt();
			sinCombate = true;
			
			if (heroes == 0){

				break;
			}


			niveles = new int [heroes];
			preferencias = new String [heroes];


			for (int i = 0; i < heroes; i ++){

				niveles[i] = sc.nextInt();


			}

			sc.nextLine();

			for (int i = 0; i < heroes; i ++){

				preferencias[i] = sc.next();

			}


			for (int i = 0; i < heroes; i++){

				signo = valorSigno (preferencias[i].charAt(0));
				fuerza = Integer.parseInt(preferencias[i].substring(1));
				enfrentamiento = false;

				for (int j = i+1; j < heroes; j++){
					
					
					if (niveles[i] != -1 && niveles[j] != -1) {
						
						enfrentamiento = comparaHeroes(signo,fuerza,j,niveles);
					}
					
					

					if (enfrentamiento){

						enfrentamiento = false;
						signo2 = valorSigno(preferencias[j].charAt(0));
						fuerza2 = Integer.parseInt(preferencias[j].substring(1));

						enfrentamiento = comparaHeroes(signo2,fuerza2,i,niveles);

					}if (enfrentamiento){

						System.out.println((i+1) +" "+(j+1));
						niveles[i] = -1;
						niveles[j] = -1;
						sinCombate = false;
						break;

					}
				}
			}
			
			if (sinCombate){
				
				System.out.println("NO HAY");
				
				
			}
			System.out.println("---");
		}
		

	}


	public static String valorSigno(char signoChar){

		String signo = null;

		if (signoChar == '='){

			signo = "igualQ";

		} else if (signoChar == '<'){

			signo = "menorQ";

		} else if (signoChar == '>'){

			signo = "mayorQ";

		}

		return signo;

	}

	public static boolean comparaHeroes(String signo,int fuerza,int posicion,int [] niveles){

		boolean enfrentamiento = false;


		if (signo.equals("igualQ")){

			if (niveles[posicion] == fuerza){

				enfrentamiento = true;

			}


		} else if (signo.equals("menorQ")){

			if (niveles[posicion] < fuerza){

				enfrentamiento = true;
			}


		} else if (signo.equals("mayorQ")){

			if (niveles[posicion] > fuerza){

				enfrentamiento = true;

			}
		}


		return enfrentamiento;
	}
}