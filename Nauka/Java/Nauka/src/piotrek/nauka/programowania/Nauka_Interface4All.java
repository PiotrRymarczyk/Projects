package piotrek.nauka.programowania;

/**
 *
 * Interfejs, ktory ma zapewnic, ze wszystkie moje klasy do nauki beda mialy identyczne
 * metody, ktore:<p>
 * [1] pozwola odpalic testcase w identyczny sposob poprzez RunMe()<p>
 * [2] pozwola przetestowac polimorfizm poprzez wywolanie printMessage()<p>
 * 
 * @author Piotr Rymarczyk
 */

public interface Nauka_Interface4All {
	/**
	 * Glowna metoda interface, ktora odpala test z danej klasy
	 */
	void RunMe();
	
	/**
	 * Metoda do testowania polimorfizmu
	 */
	void printMessage();

}
