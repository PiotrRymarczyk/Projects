package piotrek.nauka.programowania;

import java.math.BigInteger;

/**
 * Klasa do nauki BigIntegers
 * @author Piotr Rymarczyk
 *
 */
public class Nauka_BigIntegers implements Nauka_Interface4All {

	private String message = "To jest klasa Nauka_BigIntegers";
	private BigInteger mybi;
	
	/**
	 * Domyslny konstruktor.<br>
	 * Wyswietla info, ze odpalil sie konstruktor obiektu klasy Nauka_BigInteger<br>
	 * Tworzy prywatny obiekt klasy BigInteger na postawie stringa
	 */
	public Nauka_BigIntegers() {
		System.out.println("To jest konstruktor klasy Nauka_BigIntegers");
		mybi = new BigInteger("500");
	}

	/**
	 * Proste operacje na BigInteger
	 */
	@Override
	public void RunMe() {
		System.out.println(mybi);
		System.out.println("bitCount = " + mybi.bitCount());
		System.out.println("bitLength = " + mybi.bitLength());
		System.out.println(mybi.add(BigInteger.valueOf(700)));
		System.out.println(mybi);
		mybi = BigInteger.valueOf(1L);
		System.out.println(mybi);
		System.out.println("bitCount = " + mybi.bitCount());
		System.out.println("bitLength = " + mybi.bitLength());
	}


	@Override
	public void printMessage() {
		System.out.println(message);
	}

}
