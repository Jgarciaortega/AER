package AER;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class P109_LigaDePadel {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);		
		String equipo1, equipo2,liga;
		int set1, set2;
		int temp = 0;
		int cont = 0;
		int partidosTotales;
		int partidosRestantes;
		String ganador;

		while (true) {

			HashMap <String,Integer> map = new HashMap <String,Integer>();
			partidosTotales = 0;
			partidosRestantes = 0;
			cont = 0;
			liga = sc.next();

			if(liga.equals("FIN")) {

				break;

			}

			while(true) {

				equipo1 = sc.next();

				if(equipo1.equals("FIN")) {

					break;

				}

				set1 = sc.nextInt();
				equipo2 = sc.next();
				set2 = sc.nextInt();


				// Estos dos if comprueban si el equipo está ya en la tabla. De no estar, los añadimos
				
				if(map.get(equipo1) == null) {

					map.put(equipo1, 0);

				}

				if(map.get(equipo2) == null) {

					map.put(equipo2, 0);

				}

				//Si set1 es mayor que set2 significa que gana equipo 1
				
				if (set1 > set2) {

					cont++; // Contamos un encuentro 
					temp = map.get(equipo1); //Obtenemos el valor de esa celda
					map.put(equipo1, temp + 2); // Le sumamos a temp dos puntos por haber ganado encuentro
					temp = map.get(equipo2); // Repetimos operación con otro equipo
					map.put(equipo2, temp + 1); //Y le sumamos 1 a temp

				//De lo contrario gana equipo 2	
				}else {

					cont++; 
					temp = map.get(equipo2);
					map.put(equipo2, temp + 2);
					temp = map.get(equipo1);
					map.put(equipo1, temp + 1);
				}

				//Formula para calcular cuantos encuentros no se han jugado en la liguilla
				partidosTotales = (map.size()*(map.size()-1));//Obtiene los hipotéticos partidos que se deberian jugar en la liga con n equipos
				partidosRestantes = partidosTotales - cont;//Restamos al hipotético total el contador de partidos, lo que nos da los partidos que han faltado por disputar

			}


			ganador = equipoGanador(map);
			System.out.println(ganador +" "+ partidosRestantes);


		}	
	}

	private static String equipoGanador(HashMap<String, Integer> map) {


		int mayor = -1;
		String ganador = null;

		//Recorremos map para buscar el mayor valor de todos. En caso de empate devuelve empate.
		Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {

			Map.Entry<String, Integer> entry = entries.next();
			
			int prueba = entry.getValue();
			
			if (entry.getValue() > mayor) {
				
				ganador = entry.getKey();
				mayor = entry.getValue();
				
			} else if (entry.getValue() == mayor) {
				
				ganador = "EMPATE";
				mayor = entry.getValue();
			}

		}
		return ganador;

	}

}
