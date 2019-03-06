package AER;
import java.util.Scanner;

public class P154_Matriculas {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		String abc = "BCDFGHJKLMNPQRSTVWXYZ";
		char [] letras = abc.toCharArray();
		char [] letrasV;
		String matricula;
		String letrasM;
		int numeroMatricula;
		String numeroMatriculaS = null;
		boolean fin;
	

		while (true) {

			matricula = sc.nextLine();
			fin = false;

			if (matricula.equals("9999 ZZZ")) {

				break;

			}

			//Separo aquí el número de las letras

			numeroMatricula = Integer.valueOf(matricula.substring(0, 4)) ;

			letrasM = matricula.substring(5);

			if (numeroMatricula != 9999) {

				numeroMatricula ++;

				//Si es menor de 1000 hay que completar los 4 digitos de la matricula
				if (numeroMatricula < 1000) {
					
					float numeroMatriculaF = numeroMatricula;
					System.out.printf("%04.0f %s\n", numeroMatriculaF,letrasM);
				
				//Si no es mayor simplemente incremento 1 al digito de la matricula
				} else {

					System.out.printf("%d %s\n", numeroMatricula,letrasM);

				}
			} else { //En este caso se produce un cambio de letra
				
				
				letrasV = letrasM.toCharArray();
				numeroMatriculaS = "0000";

				for (int i = letrasV.length; i > 0; i --) { //Este primer for le manda la primera letra para que sea rastreada en el array de letras

					for (int j = 0; j < letras.length; j ++) { //Aquí recorre el array de letras

						if (fin) {
							
							break;
						}
						
						if (letrasV[i-1] == 'Z'){ //Si encuentra Z la convierte en B y vuelve al primer for

							letrasV[i-1] = 'B';
							
							break;

						}else if (letrasV[i-1] == letras[j]) { //Si encuentra alguna letra que sea diferente de Z le incrementa una y convierte fin en true, lo que
															   //producirá que salga del programa, ya que no habrá más cambios en la matrícula	
							letrasV[i-1] = letras[j+1];
							fin = true;
							break;

						}
					}

				}
				String  matriculaFinal = (numeroMatriculaS+ " " +letrasV[0]+letrasV[1]+letrasV[2]);
				System.out.printf("%s\n",matriculaFinal);
			}
		}

	}

}
