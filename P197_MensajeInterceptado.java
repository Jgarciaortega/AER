import java.util.Scanner;
import java.util.Stack;

public class P197_MensajeInterceptado {

	public static void main(String[] args) {
		
		String mensaje;
		String mensajeCifrado;
		Stack <String> pila;
		String digito;
		Scanner sc = new Scanner(System.in);
		int aux;
		int cont;
		
		while(sc.hasNext()) {
			
			mensaje = sc.nextLine();
			pila = new Stack <String>();
			mensajeCifrado ="";
			aux = 0;
			cont = 0;
			
			//X''
			for(int i = 0; i < mensaje.length(); i++) {
				
				if (i % 2 == 0) {
					
					digito = "" + mensaje.charAt(i);
					mensajeCifrado += digito;
					
				}else {
					
					digito = "" + mensaje.charAt(i);
					pila.push(digito);
					aux = pila.size();
				}				
			}
			
			for(int i = 0; i < aux; i++) {
				
				mensajeCifrado += pila.pop();
				
			}
			
			//X'
			
			for(int i = 0; i < mensajeCifrado.length(); i++) {
				
				
				
				
			}
						
		}

	}
	
	public static boolean comprobarLetra(String letra){
		
		
		return true;
	}
}
