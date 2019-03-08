import java.util.Scanner;

public class P124_CuantasMeLlevo {

	public static void main(String[] args) {

		int iteraciones;
		String num1,num2;
		int acarreo;
		String numChar1 = null;
		String numChar2;
		int numMayor;
		int laQueTeLlevas;
		Scanner sc = new Scanner (System.in);

		while(true) {

			laQueTeLlevas = 0;
			acarreo = 0;
			iteraciones = 0;
			num1 = sc.next();
			num2 = sc.next();
			numMayor = num1.length();

			if (num1.equals("0") && num2.equals("0")) break;


			if(num1.length() == num2.length()) {

				for(int i = num1.length(); i > 0; i--) {

					numChar1 = "" + num1.charAt(i-1)  ;
					numChar2 = "" + num2.charAt(i-1) ;

					if(Integer.parseInt(numChar1) + Integer.parseInt(numChar2) + laQueTeLlevas >= 10 && i != 1) {

						acarreo ++;
						laQueTeLlevas = 1;

					}else {
						
						laQueTeLlevas = 0;
						
					}
				}

			}else {

				iteraciones = num1.length() - num2.length();

				//Si num2 es mayor que num1
				if (iteraciones < 0 ) {

					iteraciones *= -1;
					numMayor = num2.length();

					for(int i = num2.length() ,  y = num1.length(); i > 0; i-- , y--) {

						if ( y != 0) {
						
							numChar1 = "" + num1.charAt(y-1) ;
						}
						
						numChar2 = "" + num2.charAt(i-1) ;

						if(Integer.parseInt(numChar1) + Integer.parseInt(numChar2) + laQueTeLlevas >= 10 && y!= 1) {

							acarreo ++;
							laQueTeLlevas = 1;

						}else {
							
							laQueTeLlevas = 0;
						}

					}

					//Si num1 es mayor que num2
				}else {

					for(int i = num1.length() ,  y = num2.length(); i > iteraciones || y > 0; i-- , y--) {

						numChar1 = "" + num1.charAt(i-1) ;
						numChar2 = "" + num2.charAt(y-1) ;

						if(Integer.parseInt(numChar1) + Integer.parseInt(numChar2) + laQueTeLlevas >= 10 && y!= 1) {

							acarreo ++;
							laQueTeLlevas = 1;

						}else {
							
							laQueTeLlevas = 0;
						}
					}
				}

			}
			System.out.println(acarreo);
		}
	}
}

