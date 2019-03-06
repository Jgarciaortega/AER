package AER;
import java.util.Scanner;

public class P433_RacimosDeUvas {

	public static void main(String[] args) {


		long uvas, i;
		long suma;
		Scanner sc = new Scanner (System.in);

		while (true) {
			
			suma=0;
			uvas = sc.nextLong();

			if (uvas == 0) {
				
				break;
			}
			
			
			for(i=1; suma<uvas; i++){
				
				suma +=i;
			}
			
			System.out.println(i-1);
			
		}

	}
}




