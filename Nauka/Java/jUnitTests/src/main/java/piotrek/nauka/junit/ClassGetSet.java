/**
 * Pakiet do nauki jUnit
 */
package piotrek.nauka.junit;

import java.util.Date;

/**
 * Klasa do szybkich testów jUnit
 * @author Piotr Rymarczyk
 *
 */
public class ClassGetSet {

	private String name;
	private Date todayIsTheDay;
	private StringBuilder sName;
	
	/**
	 * Konstruktor klasy
	 * @param s - String, ktory zostanie przypisany do prywatnego pola <i><b>name</b></i>
	 */
	ClassGetSet (String s) {
		name = new String(s);
		todayIsTheDay = new Date();
		sName = new StringBuilder(s);
	}
	
	/**
	 * Setter do zmiany wartosci pola name
	 * @param s - String, ktory zostanie przypisany do prywatnego pola <i><b>name</b></i>
	 */
	public void setName (String s) {
		name = s;
	}
	
	public String getName () {
		return name;
	}
	
	public Date getDate() {
		return todayIsTheDay;
	}
	
	public Date getDateClone() {
		return (Date) todayIsTheDay.clone();
		
	}
	
	public StringBuilder getStringBuilder() {
		return sName;
	}

	/**
	 * Sprawdza ignorujac rozmiar liter czy String s zawiera sie w prywatnym polu <i><b>name</b></i>
	 * @param s - szukany string
	 * @return true kiedy jest zawarty, false w przeciwnym wypadku
	 */
	public boolean isLetterIncludedIgnoreCase(String s) {
		String upperCaseName = name.toUpperCase();
		String upperCaseS = s.toUpperCase();
		int i = upperCaseName.lastIndexOf(upperCaseS);
		if ( i >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Sprawdza ignorujac rozmiar liter czy znak c zawiera sie w prywatnym polu <i><b>name</b></i>
	 * @param c - szukany znak
	 * @return true kiedy jest zawarty, false w przeciwnym wypadku
	 */
	public boolean isLetterIncludedIgnoreCase(char c) {
		int i = name.toUpperCase().lastIndexOf(String.valueOf(c).toUpperCase());
		if (i >= 0 )
			return true;
		else
			return false;
	}
	
	
	/**
	 * Sprawdza uwzgledniajac rozmiar liter czy String s zawiera sie w prywatnym polu <i><b>name</b></i>
	 * @param s - szukany string
	 * @return true kiedy jest zawarty, false w przeciwnym wypadku
	 */
	public boolean isLetterIncludedCaseSensitive(String s) {
		int i = name.lastIndexOf(s);
		if ( i >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Sprawdza uwzgledniajac rozmiar liter czy znak c zawiera sie w prywatnym polu <i><b>name</b></i>
	 * @param c - szukany znak
	 * @return true kiedy jest zawarty, false w przeciwnym wypadku
	 */
	public boolean isLetterIncludedCaseSensitive(char c) {
		int i = name.lastIndexOf(String.valueOf(c));
		if (i >= 0 )
			return true;
		else
			return false;
	}	
	
	
	public String char2string (char c) {
		String s = String.valueOf(c);
		return s;
	}
	
	public boolean contains(String s) {
		return name.contains(s);
	}
	
	public String nothingTestes(int i) {
		switch (i) {
			case 0:
				return "Zero";
			case 1:
				return "One";
			case 2:
				return "Two";
			default:
				return "Default";
		}
		
	}
	
	public boolean isFirstChar(char c) {
		return (name.charAt(0) == c);
	}

}
