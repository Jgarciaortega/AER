package Resueltos;
import java.util.Scanner;

public class P434_RomancePalomar {

	public static void main(String[] args) {

		
		
		int palomas;
		int habitaculos;
		int noches;
		
		Scanner sc = new Scanner(System.in);
		noches = sc.nextInt();
		
		for (int i = 0; i < noches; i++) {
			
			palomas = sc.nextInt();
			habitaculos = sc.nextInt();
			
			if (palomas <= habitaculos) {
				
				System.out.println("ROMANCE"); 
				
			}else  {
				
				System.out.println("PRINCIPIO"); 
				
			}
			
			
		}
		

	}

}
