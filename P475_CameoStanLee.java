package AER;
import java.util.Scanner;

public class P475_CameoStanLee {

	public static void main(String[] args) {
		
		
		int casos;
		String frase;
		String nombre = "stanlee";
		char [] nombChar= nombre.toCharArray();
		int aux;
		int totalVeces; //Las veces que aparece el nombre en la frase
		
		Scanner sc = new Scanner(System.in);
		
		casos = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < casos; i ++) {
			
			totalVeces = 0;
			aux = 0;
			frase = sc.nextLine();
			frase = frase.toLowerCase();
			
			for (int j = 0; j < frase.length(); j ++) {
				
				if (frase.charAt(j) == nombChar[aux]) {
					
					aux ++;
					
				}
				
				if (aux == 7) {
					
					totalVeces ++;
					aux = 0;
				}
				
				
			}
			
			System.out.println(totalVeces);
		}
		
	}

}
