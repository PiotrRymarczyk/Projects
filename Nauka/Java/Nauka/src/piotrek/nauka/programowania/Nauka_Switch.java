package piotrek.nauka.programowania;

import java.util.Scanner;

/**
 * Prosty test potwierdzajacy, ze bez break w sekcji case w switchu
 * program poleci z od danego case do samego konca
 * @author Piotr Rymarczyk
 *
 */
public class Nauka_Switch implements Nauka_Interface4All{
	
	private String message = "This is Nauka_Switch";
	
	public Nauka_Switch() {
		System.out.println("Konstruktor klasy Nauka_Switch");		
	}

	/**
	 * Prosty odczyt liczby z klawiatury a potem odpalenie switcha bez break
	 * i switcha z break
	 */
	@Override
	public void RunMe() {
		/*
		 * Proste zczytywanie klawiatury
		 */
		Scanner in = new Scanner(System.in);
		System.out.print("Podaj liczbę : ");
		int i = in.nextInt();
	
		/*
		 * SWITCH bez BREAK
		 */
		System.out.println("Switch bez BREAK");
		switch (i) {
			case 1:
				System.out.println("To jest sekcja dla 1");
			case 2:
				System.out.println("To jest sekcja dla 2");
			case 3:
				System.out.println("To jest sekcja dla 3");
			case 4:
				System.out.println("To jest sekcja dla 4");
			case 5:
				System.out.println("To jest sekcja dla 5");
			default:
				System.out.println("Takiej wartości nie obsługujemy specjalnie");
		}

		/*
		 * SWITCH z BREAK
		 */
		System.out.println("Switch z BREAK");
		switch (i) {
			case 1:
				System.out.println("To jest sekcja dla 1");
				break;
			case 2:
				System.out.println("To jest sekcja dla 2");
				break;
			case 3:
				System.out.println("To jest sekcja dla 3");
				break;
			case 4:
				System.out.println("To jest sekcja dla 4");
				break;
			case 5:
				System.out.println("To jest sekcja dla 5");
				break;
			default:
				System.out.println("Takiej wartości nie obsługujemy specjalnie");
				break;
		}
		
		/*
		 * Tutaj zamykamy strumień defaultowy używany do czytania klawiatury
		 */
		in.close();

		
	}

	@Override
	public void printMessage() {
		System.out.println(message);
		
	}


}
