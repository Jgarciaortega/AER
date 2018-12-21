package Resueltos;
import java.util.Scanner;

public class P217_QueLadoCalle {

	public static void main(String[] args) {
		
		
		int numero;
		String lado;
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			numero = sc.nextInt();
		
			if (numero % 2 != 0) {
				
				lado = "IZQUIERDA";
				
			}else {
				
				lado =	"DERECHA";
				
			}
		
			if (numero == 0) {
				
				break;
			}
			
		System.out.println(lado);
		
		
		}
		
		
	}

}
