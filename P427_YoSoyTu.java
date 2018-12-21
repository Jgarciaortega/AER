package Resueltos;
import java.util.Scanner;

public class P427_YoSoyTu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int casos = 0;
		String cadena1;
		String cadena2;
		
		
		casos = sc.nextInt();
		sc.nextLine();
		while (casos > 0){
			
			cadena1 =sc.nextLine();
			cadena2 =sc.nextLine();
			
			if (cadena1.equals("Luke") && cadena2.equals("padre")) {
				
				System.out.println("TOP SECRET");
				
			}else {
				
				System.out.println(cadena1 + ", yo soy tu " + cadena2);
			}
			
			casos --;
			
		}

	}

}
