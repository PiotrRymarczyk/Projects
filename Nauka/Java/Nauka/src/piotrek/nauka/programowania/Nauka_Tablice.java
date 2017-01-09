package piotrek.nauka.programowania;

import java.util.Arrays;

/**
 * Klasa do nauki Tablic w Javie
 * @author Piotr Rymarczyk
 *
 */
public class Nauka_Tablice implements Nauka_Interface4All {

	private String message = "To jest klasa Nauka_Tablice";
	/**
	 * Domyslny konstruktor klasy Nauka_Tablice<p>
	 * <ul>
	 * <li>Wyswietla info, ze uruchomil sie konstruktor obiektu klasy Nauka_Tablice</li>
	 * <li>Dodatkowo pobawilem sie "this"</li>
	 * </ul>
	 */
	public Nauka_Tablice() {
		System.out.println("To jest konstruktor klasy Nauka_Tablice");
		System.out.println("this.toString() = " + this.toString());
		System.out.println("this.getClass().getName() = " + this.getClass().getName());
		System.out.println("this.getClass().getSimpleName() = " + this.getClass().getSimpleName());
	}


	/**
	 * Testowanie tablic<p>
	 * <ul>
	 * <li>Rozne sposoby deklarowania tablic</li>
	 * <li>Proba przypisania tablicy do tablicy - to dziala jak wskazniki w C</li>
	 * <li>Petla FOR dla tablic</li>
	 * <li>Arrays.copyOf i Arrays.sort</li>
	 * <li>tablice wielowymiarowe i tablice o zmiennej dlugosci linii)</li>
	 * </ul>
	 */
	@Override
	public void RunMe() {
		int[] smallPrimes = { 2, 3, 5, 7, 11, 13 };
		/*
		 * Przypisanie tablica = tablica to jakby ustawienie wskaznika z C
		 * Tak naprawde to nie robi sie kopia i kopiowanie tablicy robi sie inaczej
		 */
		System.out.println();
		System.out.println("smallPrimes = " + Arrays.toString(smallPrimes));
		int[] luckyNumbers = smallPrimes;
		smallPrimes[2] = 100;
		luckyNumbers [4] = 400;
		System.out.print("smallPrimes = ");
		for (int i: smallPrimes)
			System.out.print(i + " ");
		System.out.println();
		System.out.print("luckyNumbers = " + Arrays.toString(luckyNumbers));
		System.out.println();
		System.out.println("smallPrimes[2] = 100, a luckyNumers tez sie zmienilo");
		System.out.println("luckyNumbers[4] = 400, a smallPrimes tez sie zmienilo");
		
		/*
		 * Niby zmienilem smallPrimes a luckyNumbers nie zmienila sie bo
		 * smallPrimes pokazuje na inny adres.
		 */
		System.out.println();
		System.out.println("Zmiana tablicy smallPrimes na inna");
		smallPrimes = new int[] { 17, 19, 23, 29, 31, 37 };
		System.out.println("smallPrimes = " + Arrays.toString(smallPrimes));
		System.out.println("luckyNumbers = " + Arrays.toString(luckyNumbers));

		/*
		 * Proba skopiowania smallPrimes do luckyNumbers
		 */
		System.out.println();
		System.out.println("Kopiuje tablice smallPrimes do LuckyNumbers przez Arrays.copyOf");
		luckyNumbers = Arrays.copyOf(smallPrimes, smallPrimes.length);
		System.out.println("smallPrimes = " + Arrays.toString(smallPrimes));
		System.out.println("luckyNumbers = " + Arrays.toString(luckyNumbers));
		System.out.println("Pomnozylem smallPrimes * 100");
		for (int i=0; i<smallPrimes.length; i++)
			smallPrimes[i] = smallPrimes[i] * 100;
		System.out.println("Pomnozylem luckyNumbers * 2");
		for (int i=0; i<luckyNumbers.length; i++)
			luckyNumbers[i] = luckyNumbers[i] * 2;
		System.out.println("smallPrimes = " + Arrays.toString(smallPrimes));
		System.out.println("luckyNumbers = " + Arrays.toString(luckyNumbers));
		
		/*
		 * Math.Randon()
		 */
		System.out.println();
		System.out.println("Wypelniam smallPrimes przypadkowymi liczbami");
		for (int i=0; i<smallPrimes.length; i++) {
			smallPrimes[i] = (int) (Math.random() * 3);
		}
		
		/*
		 * Sortowanie
		 */
		System.out.println("smallPrimes = " + Arrays.toString(smallPrimes));
		System.out.println();
		System.out.println("Sortowanie");
		Arrays.sort(smallPrimes);
		System.out.println("smallPrimes = " + Arrays.toString(smallPrimes));
		
		/*
		 * Tablice wielowymiarowe
		 */
		String[][][] iTable = new String[2][3][4];
		for (int a = 0; a<2; a++)
			for (int b =0; b<3; b++)
				for (int c = 0; c<4; c++) {
					Integer d = new Integer(a + b + c);
					iTable[a][b][c] = d.toString();
				}
		
		for (String[][] s : iTable) {
			System.out.println();
			for (String[] a : s) {
				System.out.print(" | ");
				for (String b : a) {
					System.out.print(b + " ");
				}
			}
		}
		System.out.println();
		System.out.println("iTable = " + Arrays.deepToString(iTable));
		
		/*
		 * Tablice postrzepione
		 */
		System.out.println("Tablice postrzepione");
		int[][] wieloraka = new int[3][];
		wieloraka[0] = new int[7];
		wieloraka[1] = new int[4];
		wieloraka[2] = new int[5];
		System.out.println(wieloraka.length);
		for (int i =0; i<3; i++) {
			System.out.println(wieloraka[i].length);
			for (int x=0; x<wieloraka[i].length; x++)
				wieloraka[i][x] = (int) (Math.random() * 25);
		}
		System.out.println("wieloraka = " + Arrays.deepToString(wieloraka));
		
		
	}


	@Override
	public void printMessage() {
		System.out.println(message);
	}

}
