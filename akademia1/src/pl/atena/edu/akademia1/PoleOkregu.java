/**
 * 
 */
package pl.atena.edu.akademia1;

import java.util.Scanner;

/**
 * @author Arkadiusz
 *
 */
public class PoleOkregu {

	/**
	 * @param args
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Podaj d³ugoœæ promienia:");
		String r =scanner.nextLine();
		
		
		double promien = 0;
		try {
			promien = Double.valueOf(r);

		} catch (Exception e) {
			System.out.println("To nie promieñ!!!");
		}
		double pole=Math.PI*Math.pow(promien, 2);
		System.out.println("Promieñ:"+promien+", Pole:"+pole);

	}

}
