package piotrek.nauka.programowania;

/**
 * Testowanie budowanie stringa przez obiekt klasy StringBuilder
 * @author Piotr Rymarczyk
 *
 */
public class Nauka_StringBuilder implements Nauka_Interface4All {

	private String message = "This is Nauka_StringBuilder";
	private StringBuilder mybuilder;
	
	public Nauka_StringBuilder() {
		System.out.println("Konstruktor klasy Nauka_StringBuilder");
		mybuilder = new StringBuilder();
	}
	
	/**
	 * Doklejanie do stringa, wstawianie i usuwanie w srodku stringa,
	 * sprawdzanie co jest na danej pozycji stringa, itp
	 */
	@Override
	public void RunMe() {
		System.out.println("Test");
		mybuilder.append("Marzenka");
		System.out.println(mybuilder.toString());
		System.out.println("Aktualny rozmiar to : " + mybuilder.length());		
		mybuilder.append(' ');
		System.out.println("Dodałem spację na koniec, więc aktualny rozmiar to : " + mybuilder.length());
		mybuilder.append("Piotr");
		System.out.println(mybuilder.toString());
		System.out.println("Aktualny rozmiar to : " + mybuilder.length());
		mybuilder.insert(9, "i ");
		System.out.println(mybuilder.toString());
		System.out.println("Aktualny rozmiar to : " + mybuilder.length());
		
		System.out.println("Znak 9 to : " + mybuilder.charAt(9));
		System.out.println("Znak 0 to : " + mybuilder.charAt(0));
		mybuilder.insert(9, 'x');
		System.out.println(mybuilder.toString());
		System.out.println("Aktualny rozmiar to : " + mybuilder.length());
		mybuilder.deleteCharAt(9);
		System.out.println(mybuilder.toString());
		System.out.println("Aktualny rozmiar to : " + mybuilder.length());
		System.out.println("Capacity : " + mybuilder.capacity());
		System.out.println(mybuilder.reverse());
		System.out.println(mybuilder.toString());
	}

	@Override
	public void printMessage() {
		System.out.println(message);
	}

}
