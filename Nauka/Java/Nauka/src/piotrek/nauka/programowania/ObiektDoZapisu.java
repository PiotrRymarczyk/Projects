package piotrek.nauka.programowania;

import java.io.Serializable;

/**
 * Klasa obiektow do Zapisu/Odczytu
 * @author Piotr Rymarczyk
 *
 */
public class ObiektDoZapisu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	
	ObiektDoZapisu() {
		name = new String("domyslny");
	}
	
	ObiektDoZapisu(String s) {
		name = new String(s);
	}
	
	public String getName() {
		return name;
	}

}
