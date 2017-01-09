import piotrek.nauka.programowania.*;

/**
 * Prosta klasa do nauki Javy zawierajaca tylko metode main, w ktorej jest tworzony
 * obiekt klasy z pakietu piotrek.nauka.programowania<br>
 * Importuje pakiet piotrek.nauka.programowania, w ktorym sa wszystkie moje klasy i interfejsy
 * @author Piotr Rymarczyk
 *
 */
public class Nauka {

	public static void main(String[] args) {

		System.out.println("Hello Packages!");
		
		//Nauka_Files nauka_instance = new Nauka_Files("Hello World z klasy Nauka_Files");
		//Nauka_Loops nauka_instance = new Nauka_Loops();
		//Nauka_Switch nauka_instance = new Nauka_Switch();	
		//Nauka_Stringi nauka_instance = new Nauka_Stringi();
		//Nauka_Interfaces nauka_instance = new Nauka_Interfaces();
		//Nauka_StringBuilder nauka_instance = new Nauka_StringBuilder();
		//Nauka_BigIntegers nauka_instance = new Nauka_BigIntegers();
		//Nauka_Tablice nauka_instance = new Nauka_Tablice();
		//Nauka_ObjectFiles nauka_instance = new Nauka_ObjectFiles();
		Nauka_Kalendarze nauka_instance = new Nauka_Kalendarze();
		nauka_instance.RunMe();
		
		//Nauka_Stringi ns2 = new Nauka_Stringi("Aleksandra", "Magdalena");
		//ns2.RunMe();
		
		//Nauka_Stringi ns3 = new Nauka_Stringi("Ola", "ola");
		//ns3.RunMe();
		
	}

}
