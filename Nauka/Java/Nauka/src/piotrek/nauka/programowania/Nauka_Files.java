package piotrek.nauka.programowania;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 
 * Proste operacje na plikach
 * @author Piotr Rymarczyk
 */
public class Nauka_Files implements Nauka_Interface4All {
	
	private String s = "Hello World!";
	private String message = "This is Nauka_Files";
	
	public Nauka_Files() {
		System.out.println("Konstruktor Nauka_Files");
	}
	
	/**
	 * Konstruktor umozliwiajacy ustawienie innej wartosci dla pola s
	 * @param new_hello - String, ktory zostanie przypisany do s
	 */
	public Nauka_Files(String new_hello) {
		s = new_hello;
		System.out.println("Konstruktor Nauka_Files z parametrem");
	}
	
	/**
	 * Glowna metoda sprawdzajaca:<p>
	 * [1] Stringi porownujemy obiektowo<p>
	 * [2] Zabawy z formatowaniem stringow poprzez String.format i printf<p>
	 * [3] Odczyt z pliku<p>
	 * [4] Zapis do pliku<p>
	 * [5] Obsluga wyjatkow
	 */
	@Override
	public void RunMe() {
		
		System.out.println(s);
		
		/*
		 * Stringi porównujemy obiektowo metodami klasy String
		 */
		
		if (s.equals("Hello World!")) {
			System.out.println("They are equal");
		}
		else {
			System.out.println("They are NOT equal");
			
		}

		/*
		 * Prosty odczyt z pliku
		 */
		
		Scanner in;
		try {
			in = new Scanner(Paths.get("mojplik2.txt"));
			while (in.hasNext()) {
				System.out.println(in.nextLine() );
			}
			in.close();	
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("File not found");
		}
		
		/*
		 * Zabawy z formatowaniem stringów
		 * Można na dwa sposoby - printf jak w C
		 * formatowanie bez wyświetlania przez String.format
		 */
		System.out.printf("%, .2f\n", -1000.0 / 3.0);
		System.out.printf("%+8.2f\n", -1000.0 / 3.0);
		String name = "Piotr";
		int age = 41;
		System.out.printf("%s, w przyszłym roku będziesz mieć lat %d\n", name, age);
		String formated_message = String.format("%s, w przyszłym roku będziesz mieć lat %d", name, age);
		System.out.println(formated_message);
		
		/*
		 * Prosty zapis do pliku - poprzednia zawartość jest usuwana
		 */
		PrintWriter pw;
		try {
			pw = new PrintWriter("mojplik2.txt");
			pw.println("To jest moja pierwsza linia w pliku");
			pw.println("To jest moja druga linia w pliku");
			pw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found - mojplik2.txt");
		}		
		
		
	}

	@Override
	public void printMessage() {
		System.out.println(message);
		
	}

}
