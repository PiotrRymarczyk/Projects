/**
 * 
 */
package piotrek.nauka.programowania;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Piotr Rymarczyk
 *
 */
public class Nauka_Kalendarze implements Nauka_Interface4All {

	private String message = "This is Nauka_Kalendarze";
	Date data;
	GregorianCalendar kalendarz;

	/**
	 * Domyslny konstruktor
	 */
	public Nauka_Kalendarze() {
		System.out.println("Konstruktor klasy Nauka_Kalendarze");
		data = new Date();
		kalendarz = new GregorianCalendar();
		//kalendarz.
	}

	@Override
	public void RunMe() {
		

	}

	@Override
	public void printMessage() {
		System.out.println(message);

	}

}
