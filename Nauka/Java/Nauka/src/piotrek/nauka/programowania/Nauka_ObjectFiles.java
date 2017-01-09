/**
 * 
 */
package piotrek.nauka.programowania;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Klasa do zapisu do pliku i odczytu z pliku obiektów 
 * @author Piotr Rymarczyk
 *
 */
public class Nauka_ObjectFiles implements Nauka_Interface4All {

	private String message = "To jest klasa Nauka_ObjectFiles";
	
	/**
	 * Domyślny konstruktor klasy Nauka_ObjectFiles
	 */
	public Nauka_ObjectFiles() {
		System.out.println("Konstruktor klasy Nauka_ObjectFiles");
	}


	@Override
	public void RunMe() {
		Scanner in = new Scanner(System.in);
		System.out.println("1. Czytamy");
		System.out.println("2. Piszemy");
		System.out.println("Co wybierasz?");
		String s = " ";
		do {
			s = in.nextLine();
		} while ( !(s.equals("1") || s.equals("2")));
		in.close();
		if (s.equals("1")) {
			System.out.println("Wybrales odczyt z pliku");
			OdczytajWszystko();
		}
		else {
			System.out.println("Wybrales zapis do pliku");
			Zapis("Marzenka");
			//Zapis("Piotr");
			//Zapis("Aleksandra");
			//Zapis("Magdalena");
		}
	}

	@Override
	public void printMessage() {
		System.out.println(message);
	}

	private void Zapis(String s) {
		ObiektDoZapisu odz = new ObiektDoZapisu(s);
		ObiektDoZapisu odz2 = new ObiektDoZapisu("Piotr");
		ObiektDoZapisu odz3 = new ObiektDoZapisu("Aleksandra");
		ObiektDoZapisu odz4 = new ObiektDoZapisu("Magdalena");
		
        try{
            FileOutputStream fos = new FileOutputStream("Name.txt", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(odz);
            oos.writeObject(odz2);
            oos.writeObject(odz3);
            oos.writeObject(odz4);
            oos.flush();
            oos.close();
        } catch(Exception e){
            e.printStackTrace();
        }		
	}
	
	private void OdczytajWszystko() {
		try{
			FileInputStream fis = new FileInputStream("Name.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println(ois.available());
			ObiektDoZapisu person = (ObiektDoZapisu )ois.readObject();
			System.out.println(person.getName());
			System.out.println(ois.available());
			person = (ObiektDoZapisu )ois.readObject();
			System.out.println(person.getName());
			System.out.println(ois.available());
			person = (ObiektDoZapisu )ois.readObject();
			System.out.println(person.getName());
			System.out.println(ois.available());
			person = (ObiektDoZapisu )ois.readObject();
			System.out.println(person.getName());			
			System.out.println(ois.available());
			ois.close();

		} catch(Exception e){
			e.printStackTrace();
		}
		

	}
	
}

