
public class P465_ElCuelloDeLosPilotos {

	public static void main(String[] args) {

		int x , y;
		int curvas = 0;
		char [][] circuito = {
				{'#' , 'O' , '#'},
				{'#' , '.' , '#'},
				{'#' , '#' , '#'},
		};

		curvas = localizar(circuito, 0 , 0);
		System.out.println(curvas);
	}

	public static int localizar(char [][] circuito, int i , int j) {

		int filas = circuito.length -1;
		int columnas = circuito[0].length -1;
		int curvas = 0;
		String direccion;

		if(circuito[i][j] == 'O') {

			if(i != filas && circuito[i+1][j] == '#') {

				i++;
				direccion = "i";
				curvas = recorrer(circuito, i, j, direccion);

			}else if (j != columnas && circuito[i][j+1] == '#') {

				j++;
				direccion = "j";
				curvas = recorrer(circuito, i, j, direccion);

			}else if (j != 0 && circuito[i][j-1] == '#') {

				j--;
				direccion = "j";
				curvas = recorrer(circuito, i, j, direccion);
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

			localizar(circuito, i , j);
		}

		return curvas;
	}


	public static int recorrer(char[][] circuito,int i,int j, String direccion) {

		int curvas = 0;
		int filas = circuito.length -1;
		int columnas = circuito[0].length -1;
		boolean fin = false;


		if(circuito[i][j] == 'O') {

			fin = true;
		}

		if(circuito[i][j] == '#' && direccion.equals("i") && !fin) {

			if(i != filas && circuito[i+1][j] == '#') {

				i++;
				recorrer(circuito, i , j, direccion);

			}else {

				direccion = "j";
				curvas++;
				recorrer(circuito, i , j, direccion);
				
			}

		}else if(circuito[i][j] == '#' && direccion.equals("j") && !fin) { {

			if(j != columnas && circuito[i][j+1] == '#') {

				j++;
				recorrer(circuito, i , j, direccion);


			}else {

				direccion = "i";
				curvas++;
				recorrer(circuito, i , j, direccion);
				
			}

		}

		}
		return curvas;
	}

}
