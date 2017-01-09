package piotrek.nauka.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClassGetSet_isLetterIncludedIgnoreCase_String_Negative  {

	private static ClassGetSet cut;
	private String fInput;
	private static String wifeName = "Marzenka";
	
	public ClassGetSet_isLetterIncludedIgnoreCase_String_Negative(String input) {
		fInput = input;
	}
	
	@BeforeClass
	public static void setup() {
		cut = new ClassGetSet(wifeName);
	}
	
	@Before
	public void setMarzenka() {
		cut.setName(wifeName);
	}
	
	@Parameters(name = "{index}: {0} is NOT in Marzenka")
	public static Object[] data() {
	    return new Object[] { "W", "w", "0", "?", "@"};
	}
	
	@Test
	public void testIsLetterIncludedIgnoreCase_char() {
		assertFalse(fInput + " is NOT in " + wifeName, cut.isLetterIncludedIgnoreCase(fInput));
	}
}
