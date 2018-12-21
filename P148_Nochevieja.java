package Resueltos;
import java.util.Scanner;

public class P148_Nochevieja {

	public static void main(String[] args) {

		//En este ejercicio nos pide que calculemos los minutos que faltan hasta media noche

		//La idea es pasar la hora de entrada a minutos y restarla al total de minutos que son las 00:00

		String horas,minutos;
		String hora;
		int minutosTotales;
		final int minutosDoce = 1440; //Esto son los minutos que son las 00:00
		Scanner sc = new Scanner (System.in);

		while (true) {

			hora = sc.nextLine();


			horas = hora.substring(0, 2);
			minutos = hora.substring(3,5);

			if (horas.equals("00")  && minutos.equals("00")) {

				break;
			}
			minutosTotales = Integer.valueOf(horas)*60 + Integer.valueOf(minutos);

			minutosTotales = minutosDoce - minutosTotales;

			System.out.println(minutosTotales);


		}


	}

}
