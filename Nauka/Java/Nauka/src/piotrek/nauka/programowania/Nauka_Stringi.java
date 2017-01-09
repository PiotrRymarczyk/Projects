package piotrek.nauka.programowania;

/**
 * Testy jak zachowuje sie obiekt klasy String przy przypisaniu do innego.
 * @author Piotr Rymarczyk
 *
 */
public class Nauka_Stringi implements Nauka_Interface4All {
	
	private String message = "This is Nauka_Stringi";
	private String myString1;
	private String myString2;
	
	public Nauka_Stringi() {
		System.out.println("Konstruktor klasy Nauka_Stringi");
		myString1 = new String("Marzenka");
		myString2 = myString1;
	}
	
	/**
	 * Konstruktor umozliwiajacy ustawienie obu stringow
	 * @param s1 - String, ktory bedzie przypisany do myString1
	 * @param s2 - String, ktory bedzie przypisany do myString2
	 */
	public Nauka_Stringi(String s1, String s2) {
		System.out.println("Konstruktor klasy Nauka_Stringi z parametrami");
		myString1 = s1;
		myString2 = s2;
		
	}

	@Override
	public void RunMe() {
		System.out.println("Hello Stringi");
		System.out.println("myString1 = " + myString1);
		System.out.println("myString2 = " + myString2);
		if (myString1.equals(myString2) ) {
			System.out.println("Porównanie equals: myString1 == myString2");
		}
		else {
			System.out.println("Porównanie equals: myString1 i myString2 nie sa identyczne");
		}
		
		if (myString1.equalsIgnoreCase(myString2)) {
			System.out.println("Porównanie equalsIgnoreCase: myString1 == myString2");
		}
		else {
			System.out.println("Porównanie IgnoreCase: myString1 i myString2 nie sa identyczne");			
		}
		
		myString1 = "Podmieniony";
		System.out.println("myString1 = " + myString1);
		System.out.println("myString2 = " + myString2);		
	}

	@Override
	public void printMessage() {
		System.out.println(message);
		
	}

}
