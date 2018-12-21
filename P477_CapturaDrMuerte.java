package Resueltos;
import java.util.Scanner;

public class P477_CapturaDrMuerte {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int vida;
		int armas;
		int posMenorDanyo = 0;
		int [] civiles;
		int [] villanos;
		int [] posArmas;
		int menorDanyo;
		int aux;



		while (true) {

			vida = sc.nextInt();

			if (vida == 0) {

				break;
			}


			armas = sc.nextInt();
			civiles = new int [armas];
			villanos = new int [armas];
			aux = 0;

			posArmas = new int [armas];



			//Relleno dos vectores con los datos de daño a civiles y villanos
			for (int i = 0; i < armas; i ++) {

				civiles[i] = sc.nextInt();
				villanos[i] = sc.nextInt();
			}


			//Con dos FOR analizo cada arma. El FOR principal se ejecuta mientras queden armas o vida
			for (int j = 0; j < armas && vida > 0; j ++) {	

				posMenorDanyo = Integer.MAX_VALUE;
				menorDanyo = Integer.MAX_VALUE;

				//Este segundo FOR va mirando en cada posición cual es la mejor arma (menor danyo ciudadano)
				for ( int i = 0; i < armas ; i ++) {

					//Analizo posicion y si es menor que lo que tengo almacenado en menorDanyo entro y me quedo con esa informacion.
					//Añado otra condicion (>-1). Una vez he seleccionado la mejor fuerza en esa tirada pongo su valor a -1 para no volver
					//a analizarla a la siguiente tirada
					if (civiles[i] < menorDanyo && civiles[i] > -1) {
						
						//Me quedo con la posicion que produce menos daño al ciudadano
						posMenorDanyo = i;
						//Almaceno cual es el menorDanyo de esa celda para chequearlo en la proxima tirada
						menorDanyo = civiles[i];
						//Guardo en otro vector en que posicion esta la arma que ha atacado, ya que al final del programa tendremos que imprimirlas
						//en el orden en el que se han producido
						posArmas[j] = i + 1;

						
					//Si existe otra arma con igual danyo a ciudadano hay que quedarse con la que mas danyo haga al villano	
					} else if (civiles[i] == menorDanyo) {
						
						//Aparte de ver cual es mas dolorosa para el villano ha de ser mayor de -1, que es el digito que estoy poniendo a las armas ya
						//usadas
						if (villanos[i] > villanos [posMenorDanyo] && civiles[i] > -1) {

							//Esto es igual que en el anterior. Me quedo con las posiciones que me interesan, almacenoel menorDanyo y guardo posicion arma
							//usada en el vector posArmas.
							menorDanyo = civiles[i];
							posMenorDanyo = i;
							posArmas[j] = i + 1;


						}
					}
				}		

				//Resto vida y pongo en las posiciones utilizadas del vector un -1
				vida -= villanos[posMenorDanyo];
				civiles[posMenorDanyo] = -1;
				villanos[posMenorDanyo] = -1;

			}	

			//Si se ha agotado la vida tengo que imprimir las posiciones del vector posArmas
			if (vida <= 0) {

				//Ya que tenemos 0 en las posiciones donde no hemos almacenado dato hay que filtrarlo para imprimir solo las
				//que tienen valor
				for (int j = 0; j < posArmas.length; j ++) {

					
					//Ademas hay que considerar que si la ultima celda es > 0 tendremos que imprmirla por lo que:
					if (posArmas[posArmas.length-1] > 0){

						//Imprimimos todas las posiciones que sean mayores de 0, excepto la ultima, que aunque sera mayor de 0
						//no debe dejar espacio al final y tendra que cambiar de linea
						if (posArmas[j] > 0 && j != posArmas.length-1) {

							System.out.printf("%d ",posArmas[j]);
							
						//En este caso si es mayor de 0 y la j esta en la ultima posicion no deja espacio y tabula	
						}else if (posArmas[j] > 0 && j == posArmas.length-1) {

							System.out.printf("%d\n",posArmas[j]);
						}

					//Opcion en la que hay 0 en la ultima posicion del vector	
					}else {
						
						//Buscamos cual es la ultima posicion, contando por la derecha, que contiene 0
						for (int x = posArmas.length-1; x >= 0; x --) {
							
							//Una vez la tenemos almacenamos su posicion en aux
							if (posArmas[x] != 0) {
								
								aux = x;
								break;
							}
						}
						
						//Sabiendo donde esta el ultimo 0 imprimos hasta el dejando un espacio tras %d
							if (j < aux) {
								
								System.out.printf("%d ", posArmas[j]);
								
						//Cuando j llega a aux sabemos que en la siguiente posicion tendremos el ultimo 0 por lo que la imprimos
						//sin dejar espacio y tabulamos
							} else if (j == aux) {
								
								System.out.printf("%d\n", posArmas[j]);
								
							}
		
					}
				}
				
			//Si no he matado al villano imprimos que escapa	
			} else {

				System.out.println("MUERTE ESCAPA");

			}

		}

	}


}

