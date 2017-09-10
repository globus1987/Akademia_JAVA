/**
 * 
 */
package pl.atena.edu.akademia1;

/**
 * @author Arkadiusz
 *
 */
public class String2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String java="Java\u2122";
		System.out.println(java);
		
		String javaSuper=java+" jest super";
		System.out.println(javaSuper);
		
		int age = 23;
		String output = age+" lata";
		System.out.println(output);
		
		String output2 = age+" lata "+(age+1)+" i rok wiêcej";
		System.out.println(output2);
		
		String kursanci = String.join(", ","Aleksander","Ewa","Krystian");
		System.out.println(kursanci);
		
		String[] tKursanci = kursanci.split(", ");
		System.out.println(tKursanci[1]);
		
		System.out.println(kursanci.length());
		System.out.println(kursanci.substring(5));
		System.out.println(kursanci.substring(10, 20));;
		
		System.out.println(kursanci.charAt(3));
		System.out.println(kursanci.toUpperCase());
		System.out.println(kursanci.toLowerCase());
		System.out.println(kursanci.indexOf("l"));
		
		String adam1="adam";
		String adam2="adam jest boski".substring(0, 4);
		System.out.println(adam2);
		boolean test1=adam1==adam2;
		System.out.println(test1);
		
		boolean test2=adam1.equals(adam2);
		System.out.println(test2);

	}

}
