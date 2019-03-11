package AER;
import java.util.Scanner;

public class P196_SudokusVacios {

	public static void main(String[] args) {


		char [][] sudoku;
		int casos = 0;
		boolean valido;
		Scanner sc = new Scanner(System.in);
		int cont;
		int longitud;

		casos = sc.nextInt();
		sc.nextLine();

		while (casos > 0) {

			valido = true;
			sudoku = new char [9][9];
			sudoku = rellenarSudoku(sudoku, sc);
			longitud = sudoku.length -1 ;
			cont = 0;
			
			for(int j = 0, posJ = longitud; j <= longitud && valido; j++, posJ--) {

				for(int i = 0, posI = longitud; i <= longitud && valido; i++, posI--) {
									
					if(sudoku[j][i] != '-') {	
						
						cont++;
						valido = localizarOpuesto(sudoku,posJ,posI);
						
					}
				}
			}
			
			casos --;
			
			if(valido && cont <= 32) {

				System.out.println("SI");

			}else {

				System.out.println("NO");
			}


		}

	}


	public static char [][] rellenarSudoku(char [][] sudoku, Scanner sc) {

		String datos;
		
		sc.nextLine();
		for(int j = 0; j < sudoku.length; j++) {

			datos = sc.nextLine();

			for(int i = 0; i < sudoku.length; i++) {

				sudoku[j][i] = datos.charAt(i);

			}

		}

		return sudoku;
	}



	public static boolean localizarOpuesto (char[][] sudoku, int posJ , int posI) {

		return (sudoku[posJ][posI] != '-');
				
	}
}