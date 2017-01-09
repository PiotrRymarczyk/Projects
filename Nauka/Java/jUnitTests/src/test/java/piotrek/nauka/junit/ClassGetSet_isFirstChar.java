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
public class ClassGetSet_isFirstChar {

	private static ClassGetSet cut;
	private static String wifeName;
	private char fInput;
	private boolean fOutput;
	
	@Parameters (name = "{index}: {0} - is {1} first letter in Marzenka?")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{false, 'm'},
				{false, 'N'},
				{false, 'n'},
				{false, '1'},
				{false, '@'},
				{true, 'M'}
			});
	}
	
	public ClassGetSet_isFirstChar(boolean output, char input) {
		fInput = input;
		fOutput = output;
	}
	
	
	@BeforeClass
	public static void setUp() {
		wifeName = "Marzenka";
		cut = new ClassGetSet(wifeName);
	}
	
	@Before
	public void setName() {
		cut.setName(wifeName);
	}
	
	@Test
	public void testIsFirstChar() {
		String message = "";
		if (fOutput == true)
			message = String.valueOf(fInput) + " is first letter in " + wifeName;
		else
			message = String.valueOf(fInput) + " is NOT first letter in " + wifeName;
		
		assertEquals(message, fOutput, cut.isFirstChar(fInput));
	}

}
