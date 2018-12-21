package Resueltos;
import java.util.Scanner;

public class P428_TendenciaAlLadoOscuro {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner (System.in);
		
		int casos = 0;
		int midiclorianos = 0;
    	int prueba = 0;

		casos = sc.nextInt();
		
		
		while (casos > 0) {
			
			boolean ladoOscuro = false;
			int aux = 0;
			
			midiclorianos = sc.nextInt();
			
			while (midiclorianos > 5 && aux < 2) {
				
			
				prueba = midiclorianos % 5;
				midiclorianos /= 5;
				
				if (prueba == 4) {
					
					aux ++;
					
				}
			}
			
			if (midiclorianos == 4) {
				
				aux ++;
				
			}
			
			if (aux >= 2) {
				
				ladoOscuro = true;
				
			} 
			casos--;
			
			if (ladoOscuro) {
				
				System.out.println("SI");
				
			}else {
				
				System.out.println("NO");
			}
		}
		
	}

}
