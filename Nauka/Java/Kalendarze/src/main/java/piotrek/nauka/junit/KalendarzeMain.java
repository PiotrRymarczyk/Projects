package piotrek.nauka.junit;

public class KalendarzeMain {

	public static void main(String[] args) {
		Kalendarze kalendarze = new Kalendarze();
		
		String [] sTable = kalendarze.printMonth(2016, 12);
		
		for (String s : sTable) {
			System.out.println(s);
		}
	
	   }
		


}
