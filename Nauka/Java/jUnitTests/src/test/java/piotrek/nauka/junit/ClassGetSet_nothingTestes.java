package piotrek.nauka.junit;

import static org.junit.Assert.*;

//import java.util.Arrays;
//import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClassGetSet_nothingTestes {

	private static ClassGetSet cut;
	private static String wifeName;
	private String fExpected;
	private int fInput;
	
	@Parameters (name = "{index}: {0} <= {1}")
	public static Object[][] data() {
		return new Object[][] {
			{"One",      1},
			{"Zero",     0},
			{"Default",  4},
			{"Default", -7},
			{"Two",      2},
			{"Default",    7}
		};
	}
	
	/*
	@Parameters (name = "{index}: {0} <= {1}")
	//public static Iterable<Object[]> data() {
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{"One",      1},
			{"Zero",     0},
			{"Default",  4},
			{"Default", -7},
			{"Two",      2},
			{"Default",  7}
           });
    }
	*/
	
	
	public ClassGetSet_nothingTestes (String expected, int input) {
		fExpected = expected;
		fInput = input;
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
	public void testNothingTestes() {
		assertEquals(fExpected, cut.nothingTestes(fInput));
	}
	
}
