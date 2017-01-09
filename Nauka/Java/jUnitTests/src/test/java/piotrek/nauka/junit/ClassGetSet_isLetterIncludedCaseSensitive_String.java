package piotrek.nauka.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClassGetSet_isLetterIncludedCaseSensitive_String {

	private static ClassGetSet cut;
	private static String wifeName = "Marzenka";
	private String fInput;
	private boolean fOutput;
	
	@Parameters (name = "{index}: {0} - is {1} in Marzenka?")
	public static Collection<Object[]> data() {
		Object[][] testdata = new Object[][] {
			{true, "M"},
			{true, "a"},
			{true, "r"},
			{true, "z"},
			{true, "e"},
			{true, "n"},
			{true, "k"},
			{false, "m"},
			{false, "A"},
			{false, "R"},
			{false, "Z"},
			{false, "E"},
			{false, "N"},
			{false, "K"},
			{false, "@"},
			{false, "!"},
			{false, "1"},
			{false, "w"},
			{false, "W"}
		};
		return Arrays.asList(testdata);
	}	
	
	@BeforeClass
	public static void setUp() {
		cut = new ClassGetSet(wifeName);
	}
	
	@Before
	public void setName() {
		cut.setName(wifeName);
	}
	public ClassGetSet_isLetterIncludedCaseSensitive_String (boolean output, String input) {
		fInput = input;
		fOutput = output;
	}
	
	@Test
	public void testIsLetterIncludedCaseSensitiveString() {
		String message = "";
		if (fOutput)
			message = fInput + " is in " + wifeName;
		else
			message = fInput + " is NOT in " + wifeName;
		
		assertEquals(message, fOutput, cut.isLetterIncludedCaseSensitive(fInput));
	}

}
