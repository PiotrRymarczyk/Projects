package piotrek.nauka.programowania;

/**
 * Sprawdzanie, czy na interface dziala polimorfizm
 * @author Piotr Rymarczyk
 *
 */
public class Nauka_Interfaces implements Nauka_Interface4All {
	
	private String message = "This is Nauka_Interfaces";

	/**
	 * Tablica obiektow implementujacych moj interface.<p>
	 * Do tablicy wrzucam obiekty roznych klass implemetujacych moj interface
	 * i potem iteruje sie w petli po tej tablicy i na kazdym elemencie wywoluje
	 * metode z interface - printMessage()
	 */
	@Override
	public void RunMe() {
		Nauka_Interface4All[] ni = new Nauka_Interface4All[4];
		
		ni[0] = new Nauka_Files();
		ni[1] = new Nauka_Loops();
		ni[2] = new Nauka_Stringi();
		ni[3] = new Nauka_Switch();
		
		for (Nauka_Interface4All niVar : ni)
			niVar.printMessage();
		
	}

	@Override
	public void printMessage() {
		System.out.println(message);
		
	}

}
