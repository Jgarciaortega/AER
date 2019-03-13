import java.util.ArrayList;
import java.util.Scanner;

public class P127_UnaDelaTolaCatola {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList <String> lista;
		int casos;
		String nombre;
		int camas;
		int palabrasCancion;
		int posI;
		int cont;
		String res;
		boolean fin;

		casos = sc.nextInt();

		while(casos > 0) {

			lista = new ArrayList<String>();
			cont = 0;
			fin = false;
			res = "";
			posI = 0;

			while(true) {

				nombre = sc.next();

				if(!nombre.equals("F")) {

					lista.add(nombre);

				}else {

					break;
				}

			}

			camas = sc.nextInt();
			palabrasCancion = sc.nextInt();


			if (camas == lista.size()) {

				res = "TODOS TIENEN CAMA";
				fin = true;

			}

			if (camas == 0) {

				res = "NADIE TIENE CAMA";
				fin = true;

			}


			while(camas != lista.size() && !fin) {

					
				posI = posI + palabrasCancion-1;
				posI = posI%lista.size();
				lista.remove(posI);

//				for(int i = posI; i <= lista.size(); i++) {
//
//					if(cont == palabrasCancion) {
//
//						lista.remove(i-1); 
//						cont = 0;
//						posI = i-1;
//						
//						if(i == lista.size()) {
//							
//							posI = 0;
//							break;
//							
//						}else {
//							
//							posI = i-1;
//							break;
//						}
//						
//						
//					}
//
//					if(i == lista.size()) {
//
//						posI = 0;
//
//					}
//
//					cont++;
//
//				}
			}

			
			
			if(camas == lista.size()) {

				for(String i: lista) {

					System.out.print(i);
				}

			}else {

				System.out.println(res);
			}

		}


	}

}
