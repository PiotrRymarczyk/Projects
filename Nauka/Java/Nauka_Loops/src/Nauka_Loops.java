/**
 * @author Piotrek
 * 
 * Nauka programowania w Javie
 * Pętle
 *
 */
public class Nauka_Loops {


	public static void main(String[] args) {
		
		String[] string_table = new String[4];
		string_table[0] = "Marzenka";
		string_table[1] = "Piotr";
		string_table[2] = "Aleksandra";
		string_table[3] = "Madgalena";
		
		/*
		 * FOR LOOP
		 * Może się przeiterować po tablicy
		 */
		for (String s : string_table) {
			System.out.println(s);
		}
		Integer string_table_size = string_table.length;
		System.out.println("Tablica string_table ma rozmiar " + string_table_size);
		
		for (int i=0; i<string_table_size; i++) {
			System.out.println(string_table[i]);
		}
		
		/*
		 * WHILE LOOP
		 * Trzeba pamiętać o zwiększaniu licznika
		 */
		
		System.out.println("Pętla WHILE");
		int i = 0;
		while (i< string_table_size) {
			System.out.println(string_table[i++]);
		}
		
		/*
		 * DO WHILE LOOP
		 */
		
		System.out.println("Pętla DO WHILE");
		i = 0;
		do {
			System.out.print(i);
			System.out.println(string_table[i++]);
			
		} while (string_table_size-1 >= i);
		

	}

}
