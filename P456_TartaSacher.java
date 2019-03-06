package AER;
import java.util.Scanner;

public class P456_TartaSacher {

	public static void main(String[] args) {


		int TabletasNecesitas;
		int intentos;
		int onza1;
		int onza2;
		int totalChocolate;
		

		Scanner sc = new Scanner(System.in);

		intentos = sc.nextInt();

		for (int i = 0; i < intentos; i++) {

			onza1 = sc.nextInt();
			onza2 = sc.nextInt();
			TabletasNecesitas = sc.nextInt();

			totalChocolate = onza1 * onza2;

			if (TabletasNecesitas % totalChocolate == 0) {

				TabletasNecesitas = TabletasNecesitas / totalChocolate;

			} else  {
				
				TabletasNecesitas = TabletasNecesitas / totalChocolate + 1;
					
			}



			System.out.println(TabletasNecesitas);

		}

	}

}