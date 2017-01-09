package piotrek.nauka.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClassGetSet_isLetterIncludedIgnoreCase_char_Positive  {

	private static ClassGetSet cut;
	private static String wifeName;
	private char fInput;
	
	public ClassGetSet_isLetterIncludedIgnoreCase_char_Positive(char input) {
		fInput = input;
	}
	
	@BeforeClass
	public static void setup() {
		wifeName = "Marzenka";
		cut = new ClassGetSet(wifeName);
	}
	
	@Before
	public void setMarzenka() {
		cut.setName(wifeName);
	}
	
	@Parameters(name = "{index}: {0} is in Marzenka")
	public static Object[] data() {
	    return new Object[] { 'M', 'm', 'A', 'a', 'R', 'r', 'Z', 'z', 'E', 'e', 'N', 'n', 'K', 'k' };
	}

	@Test
	public void testIsLetterIncludedIgnoreCase_char() {
		assertTrue(String.valueOf(fInput) + " is in " + wifeName, cut.isLetterIncludedIgnoreCase(fInput));
	}
}
