package AER;
import java.util.Scanner;

public class P440_EscalandoEverest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int escaladores;
		int velGrupo;
		int velEscaladores;
		int grupos;
		int grupoMayor;
		int grupoMenor;
		int integrantes;


		while (true) {

			integrantes = 1;
			grupoMayor = 1;
			grupoMenor = 1;
			escaladores = sc.nextInt();
			grupos = 1;
			if (escaladores == 0) {

				break;
			}

			velEscaladores = sc.nextInt();
			velGrupo = velEscaladores;
			grupoMayor = Integer.MIN_VALUE;
			grupoMenor = Integer.MAX_VALUE;

			for (int i = 0; i < escaladores-1; i ++) {
				
				
				velEscaladores = sc.nextInt();
				
				if (velEscaladores < velGrupo) {

					velGrupo = velEscaladores;
					grupos ++;

						
					if (integrantes > grupoMayor) {
						
						grupoMayor = integrantes;
						
						
					} 
					if (integrantes < grupoMenor){
						
						grupoMenor = integrantes;
						
					}

				integrantes = 1;	
				}else {
					
					integrantes ++;
					
				}
			}
			
			if (integrantes > grupoMayor) {
				
				grupoMayor = integrantes;
				
				if (grupos == 1) {
					
					grupoMenor = grupoMayor;
				}
				
				
			} else if (integrantes < grupoMenor) {
				
				grupoMenor = integrantes;
				
			}
			
			

			System.out.printf("%d %d %d%n", grupos, grupoMenor, grupoMayor);

		}


	}

}
