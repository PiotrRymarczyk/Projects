package piotrek.nauka.junit;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class KalendarzeTest {

	private static Kalendarze cut;
	
	@BeforeClass
	public static void setUp() {
		cut = new Kalendarze();
	}
	
	@Test
	public void testGetMyName() {
		assertEquals("piotrek.nauka.junit.Kalendarze", cut.getMyName());
	}

	@Test
	public void testGetFistDayOfWeek() {
		assertEquals("poniedziałek", cut.getFistDayOfWeek());
	}
	
	@Test
	public void testGetLastDayofMonth_2016_02() {
		assertEquals(29, cut.getLastDayOfMonth(2016,2));
	}
	
	@Test
	public void testGetLastDayofMonth_2016_10() {
		assertEquals(31, cut.getLastDayOfMonth(2016,10));
	}
	
	@Test
	public void testPrintWeekDaysHeader() {
		assertEquals("  Pn  Wt  Śr  Cz  Pt  So   N", cut.printWeekDaysHeader());
	}
	
	@Test
	public void testPrintMonthHeader() {
		assertEquals("października 2016", cut.printMonthHeader(2016,10));
	}
	
	@Test
	public void testPrintOctober2016() {
		String[] october2016 = {
				"października 2016",
				"  Pn  Wt  Śr  Cz  Pt  So   N",
				"                       1   2",
				"   3   4   5   6   7   8   9",
				"  10  11  12  13  14  15  16",
				"  17  18  19  20  21  22  23",
				"  24  25  26  27  28  29  30",
				"  31"
		};
		assertArrayEquals("Incorrect Month", october2016, cut.printMonth(2016, 10));
	}
	
	@Test
	public void testPrintFebruary2016() {
		String[] february2016 = {
				"lutego 2016",
				"  Pn  Wt  Śr  Cz  Pt  So   N",
				"   1   2   3   4   5   6   7",
				"   8   9  10  11  12  13  14",
				"  15  16  17  18  19  20  21",
				"  22  23  24  25  26  27  28",
				"  29",
				""
		};
		assertArrayEquals("Incorrect Month", february2016, cut.printMonth(2016, 2));
	}
	
	@Test
	public void testPrintMay2016() {
		String[] may2016 = {
				"maja 2016",
				"  Pn  Wt  Śr  Cz  Pt  So   N",
				"                           1",
				"   2   3   4   5   6   7   8",
				"   9  10  11  12  13  14  15",
				"  16  17  18  19  20  21  22",
				"  23  24  25  26  27  28  29",
				"  30  31"
		};
		assertArrayEquals("Incorrect Month", may2016, cut.printMonth(2016, 5));
	}	
}
