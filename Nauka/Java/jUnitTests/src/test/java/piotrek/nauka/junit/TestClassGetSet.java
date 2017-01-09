package piotrek.nauka.junit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClassGetSet {

	private static ClassGetSet cut;

	
	@BeforeClass
	public static void setup() {
		cut = new ClassGetSet("Marzenka");
	}
	
	@Before
	public void setMarzenka() {
		cut.setName("Marzenka");
	}
	
	@Test
	public void test_ClassGetSet() {
		ClassGetSet cut2 = new ClassGetSet("Magdalena");
		assertEquals("Magdalena", cut2.getName());
	}

	@Test
	public void test_setName() {
		cut.setName("Piotr");
		assertEquals("Piotr", cut.getName());
	}

	@Test
	public void test_getName_constructorMarzenka() {
		assertEquals("Marzenka", cut.getName());
	}

	@Test
	public void test_getName_setToAleksandra() {
		cut.setName("Aleksandra");
		assertEquals("Aleksandra", cut.getName());
	}	
			
	@Test
	public void test_char2string_Positive() {
		assertEquals("A", cut.char2string('A'));
	}
	
	@Test
	public void test_char2string_Negative() {
		assertNotEquals("A and a are not the same", "a", cut.char2string('A'));
	}
	
	@Test
	public void test_contains_Positive() {
		assertTrue("A or a is in Marzenka", cut.contains("A") | cut.contains("a"));
	}
	
	@Test
	public void test_contains_Negative() {
		assertFalse(cut.contains("W") | cut.contains("W"));
	}	
	
	@Test
	public void isItModified() {
		String m = cut.getName();
		m = "AAAAAA";
		String n = cut.getName();
		assertEquals("Marzenka",n);
	}
	
	/*
	 * Zwrocono orginal, ktory jak sie okazuje daje sie modyfikować
	 */
	@Test
	public void isDateModified() {
		Date d = cut.getDate();
		String sd = d.toString();
		d.setDate(d.getDate() - 100);
		Date e = cut.getDate();
		String se = e.toString();
		assertNotEquals(sd, se);
	}
	
	/*
	 * Zwrocono kopie, ktora po zmienieniu nie wplyneła na orginal
	 */
	@Test
	public void isDateCloned() {
		Date d = cut.getDateClone();
		String sd = d.toString();
		d.setDate(d.getDate() - 100);
		Date e = cut.getDateClone();
		String se = e.toString();
		assertEquals(sd, se);
	}
	
	/*
	 * Jeżeli obiekt ma metody, które mogą zmienić jego stan to zwracając go
	 * tylko do odczytu należy go skolonować.
	 */
	@Test
	public void getBuilder() {
		StringBuilder d = cut.getStringBuilder();
		String sd = d.toString();
		d.setCharAt(1, 'X');
		StringBuilder e = cut.getStringBuilder();
		String se = e.toString();
		assertNotEquals(sd, se);
	}
}
