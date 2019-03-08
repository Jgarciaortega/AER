
public class P465_ElCuelloDeLosPilotos {

	public static void main(String[] args) {

		int x , y;
		int curvas = 0;
		char [][] circuito = {
				{'#' , 'O' , '#'},
				{'#' , '.' , '#'},
				{'#' , '#' , '#'},
		};

		curvas = localizar(circuito, 0 , 0 , curvas);
		System.out.println(curvas);
	}

	public static int localizar(char [][] circuito, int i , int j,int curvas) {

		int filas = circuito.length -1;
		int columnas = circuito[0].length -1;
		String direccion;

		if(circuito[i][j] == 'O') {

			if(i != filas && circuito[i+1][j] == '#') {

				i++;
				direccion = "i";
				curvas = recorrer(circuito, i, j, direccion, curvas,true , true);

			}else if (j != columnas && circuito[i][j+1] == '#') {

				j++;
				direccion = "j";
				curvas = recorrer(circuito, i, j, direccion , curvas, true, true);

			}else if (j != 0 && circuito[i][j-1] == '#') {

				j--;
				direccion = "j";
				curvas = recorrer(circuito, i, j, direccion , curvas, true, true);
			}

		}else {

			if (i != filas || j != columnas) {

				if(j == columnas) {

					j = 0;
					i ++;

				}else {

					j++;
				}
			}

			localizar(circuito, i , j , curvas);
		}

		return curvas;
	}


	public static int recorrer(char[][] circuito,int i,int j, String direccion , int curvas, boolean RetrocedeI, boolean RetrocedeJ) {

	
		int filas = circuito.length -1;
		int columnas = circuito[0].length -1;
		boolean fin = false;
		

		if(circuito[i][j] == 'O') {

			fin = true;
		}

		if(circuito[i][j] == '#' && direccion.equals("i") && !fin) {

			if(i != filas && circuito[i+1][j] == '#') {

				i++;
				RetrocedeI = false;
				recorrer(circuito, i , j, direccion, curvas, RetrocedeI, RetrocedeJ);
				
			/*}else if (i != 0 && circuito[i-1][j] == '#' && RetrocedeI && !fin) {
				
				i--;
				RetrocedeI = false;
				recorrer(circuito, i , j, direccion , curvas, RetrocedeI, RetrocedeJ);*/

			}else {

				direccion = "j";
				curvas++;
				RetrocedeI = true;
				recorrer(circuito, i , j, direccion , curvas,RetrocedeI, RetrocedeJ);
				
			}

		}else if(circuito[i][j] == '#' && direccion.equals("j") && !fin) { {

			if(j != columnas && circuito[i][j+1] == '#') {

				j++;
				RetrocedeJ = false;
				recorrer(circuito, i , j, direccion, curvas, RetrocedeI, RetrocedeJ);
/*
			}else if (j != 0 && circuito[i][j-1] == '#' && RetrocedeJ && !fin) {
				
				j--;
				RetrocedeJ = false;
				recorrer(circuito, i , j, direccion , curvas, RetrocedeI, RetrocedeJ);*/

			}else {

				direccion = "i";
				curvas++;
				RetrocedeJ = true;
				recorrer(circuito, i , j, direccion, curvas,RetrocedeI, RetrocedeJ);
				
			}

		}

		}
		return curvas;
	}

}
