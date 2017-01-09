/**
 * 
 * @author Piotrek
 *
 * Nauka programowania w Javie
 *
 */


import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Nauka_Files {

	public static void main(String[] args) {
		
		String s = "Hello World!";
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
		Integer age = 41;
		System.out.printf("%s, w przyszłym roku będziesz mieć lat %d\n", name, age);
		String message = String.format("%s, w przyszłym roku będziesz mieć lat %d", name, age);
		System.out.println(message);
		
		/*
		 * Prosty zapis do pliku - poprzednia zawartość jest usuwana
		 */
		PrintWriter pw;
		try {
			pw = new PrintWriter("mojplik2.txt");
			pw.println("To jest moja pierwsza linia");
			pw.println("To jest moja druga linia");
			pw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found - mojplik2.txt");
		}
	}

}
