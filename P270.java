import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class P270 {

	public static void main(String[] args) {


		int casos;
		String resultado;
		String nombre;
		Scanner sc = new Scanner(System.in);
		int puntuacionObtenida = 0;
		SortedMap <String,Integer> lista;

		while(true) {

			casos = sc.nextInt();
			lista = new TreeMap <String,Integer>();
			
			if(casos == 0) {

				break;
			}


			sc.nextLine();

			while(casos > 0) {

				
				nombre = sc.nextLine();
				resultado = sc.nextLine();
				
				if(resultado.equals("CORRECTO")) {
					
					puntuacionObtenida = 1;
				}

				if(resultado.equals("INCORRECTO")) {
					
					puntuacionObtenida = -1;
					
				}

				if(lista.containsKey(nombre)) {
					
					int puntuacionTotal = lista.get(nombre) + puntuacionObtenida;
					
					lista.put(nombre, puntuacionTotal);
					
				}else {
					
					lista.put(nombre, puntuacionObtenida);
					
				}
				
				casos--;
			}

			imprimirLista(lista);

		}

	}

	private static void imprimirLista(SortedMap<String, Integer> lista) {
		
		String nombre;
		int puntuacion;
		
		for(String obj : lista.keySet()) {
			
			nombre = obj;
			
			puntuacion = lista.get(nombre);
			
			if(puntuacion != 0) {
				
				System.out.println(nombre +  ", " + puntuacion);
			}
		}
		
		System.out.println("---");
		
		//lista.entrySet().forEach(entry -> System.out.println(entry.getKey() + ", " + entry.getValue()));
		
	}

}
