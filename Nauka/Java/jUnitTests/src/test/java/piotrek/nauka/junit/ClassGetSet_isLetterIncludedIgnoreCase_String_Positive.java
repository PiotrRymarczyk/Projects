package piotrek.nauka.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClassGetSet_isLetterIncludedIgnoreCase_String_Positive  {

	private static ClassGetSet cut;
	private String fInput;
	
	public ClassGetSet_isLetterIncludedIgnoreCase_String_Positive(String input) {
		fInput = input;
	}
	
	@BeforeClass
	public static void setup() {
		cut = new ClassGetSet("Marzenka");
	}
	
	@Before
	public void setMarzenka() {
		cut.setName("Marzenka");
	}
	
	@Parameters(name = "{index}: {0} is in Marzenka")
	public static Object[] data() {
	    return new Object[] { "M", "m", "A", "a", "R", "r", "Z", "z", "E", "e", "N", "n", "K", "k" };
	}
	
	@Test
	public void testIsLetterIncludedIgnoreCase_String() {
		assertTrue(fInput + " is in Marzenka", cut.isLetterIncludedIgnoreCase(fInput));
	}
}
