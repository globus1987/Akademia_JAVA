/**
 * 
 */
package pl.atena.edu.akademia1;
import java.util.Scanner;
/**
 * @author Arkadiusz
 *
 */
public class PoleProstokata {

	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Podaj d�ugo�� boku A:");
		String da =scanner.nextLine();

		System.out.println("Podaj d�ugo�� boku B:");
		String db =scanner.nextLine();
		
		double dlugoscA2=Double.valueOf(da), dlugoscB2=Double.valueOf(db);
		double Pole2=dlugoscA2*dlugoscB2;
		System.out.println("D�ugo�� A:"+dlugoscA2+",d�ugo�� B:"+dlugoscB2+", Pole:"+Pole2);
		
	}

}
