package AER;
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

		for(int i = 0; i < casos; i++) {

			lista = new ArrayList<String>();
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

			if (camas >= lista.size()) {

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

			}
			if(camas == lista.size() && !fin) {

				for(int j = 0; j < lista.size(); j++) {

					if (j != lista.size()-1) {

						System.out.print(lista.get(j) + " ");

					}else {

						System.out.println(lista.get(j));
					}

				}

			}else {

				System.out.println(res);
			}
		}
	}
}