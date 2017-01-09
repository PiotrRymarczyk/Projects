package piotrek.nauka.junit;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Kalendarze {

	private GregorianCalendar gCalendar;
	private DateFormatSymbols formatdaty;
	
	public String getMyName() {
		return this.getClass().getName();
	}
	
	public Kalendarze () {
		gCalendar = new GregorianCalendar();
		formatdaty = new DateFormatSymbols();
		//gCalendar.setFirstDayOfWeek(1);
	}

	public String getFistDayOfWeek() {
		String[] weekdays = formatdaty.getWeekdays();
		return weekdays[gCalendar.getFirstDayOfWeek()];
	}
	
	public int getLastDayOfMonth(int year, int month) {
		gCalendar.set(year, month-1, 1);
		int lastDay = gCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return lastDay;
	}
	
	public String printWeekDaysHeader() {
		StringBuilder sb = new StringBuilder();
		int firstDay = gCalendar.getFirstDayOfWeek();
		String[] shortWeekdays = formatdaty.getShortWeekdays();
		int index = firstDay;
		do {
			sb.append(String.format("%4s", shortWeekdays[index]));
			if (index == 7)
				index = 1;
			else
				index++;
		} while (index != firstDay);
		return sb.toString();
	}
	
	public String printMonthHeader(int year, int month) {
		String[] months = formatdaty.getMonths();
		return months[--month] + " " + year;
	}
	
	public String[] printMonth(int year, int month) {
		String[] printedMonth = new String[8];
		
		printedMonth[0] = printMonthHeader(year, month);
		printedMonth[1] = printWeekDaysHeader();
		printedMonth[2] = "";
		printedMonth[3] = "";
		printedMonth[4] = "";
		printedMonth[5] = "";
		printedMonth[6] = "";
		printedMonth[7] = "";
		int printedMonthIndex = 2;
		
		gCalendar.set(year, month-1, 1);
		int firstDay = gCalendar.get(Calendar.DAY_OF_WEEK);
		int firstDayofWeek = gCalendar.getFirstDayOfWeek();
		int currentDay = 1;
		int lastDayOfMonth = gCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		StringBuilder sb = new StringBuilder();

		if (firstDay == firstDayofWeek) {
			sb.append("   1   2   3   4   5   6   7");
			currentDay = 8;
		} else if ((firstDay - firstDayofWeek)>0){
			//7
			//2
			int i = firstDay - firstDayofWeek;
			do {
				sb.append("    ");
			} while ((--i) !=0);
			i = firstDay - firstDayofWeek;
			do {
				sb.append(String.format("%4d", currentDay++));
				i++;
			} while (i<7);
		} else {	
			sb.append("                           1");
			currentDay = 2;
		}
		printedMonth[printedMonthIndex] = sb.toString();
		
		while ((currentDay+7) <= lastDayOfMonth) {
			int i = 0;
			sb.setLength(0);
			do {
				sb.append(String.format("%4d", currentDay++));
				i++;
			} while (i<7);
			printedMonth[++printedMonthIndex] = sb.toString();	
		}
		sb.setLength(0);
		if (currentDay <= lastDayOfMonth) {
			while (currentDay <= lastDayOfMonth) {
				sb.append(String.format("%4d", currentDay++));
			};
			printedMonth[++printedMonthIndex] = sb.toString();
		}
		


		
		return printedMonth;
	}
		
/*		
   GregorianCalendar d = new GregorianCalendar();

      int today = d.get(Calendar.DAY_OF_MONTH);
      int month = d.get(Calendar.MONTH);

      // set d to start date of the month
      d.set(Calendar.DAY_OF_MONTH, 1);

      int weekday = d.get(Calendar.DAY_OF_WEEK);

      // get first day of week (Sunday in the U.S.)
      int firstDayOfWeek = d.getFirstDayOfWeek();

      // determine the required indentation for the first line
      int indent = 0;
      while (weekday != firstDayOfWeek)
      {
         indent++;
         d.add(Calendar.DAY_OF_MONTH, -1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      }

      // print weekday names
      String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
      do
      {
         System.out.printf("%4s", weekdayNames[weekday]);
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      }
      while (weekday != firstDayOfWeek);
      System.out.println();

      for (int i = 1; i <= indent; i++)
         System.out.print("    ");

      d.set(Calendar.DAY_OF_MONTH, 1);
      do
      {
         // print day
         int day = d.get(Calendar.DAY_OF_MONTH);
         System.out.printf("%3d", day);

         // mark current day with *
         if (day == today) System.out.print("*");
         else System.out.print(" ");

         // advance d to the next day
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);

         // start a new line at the start of the week
         if (weekday == firstDayOfWeek) System.out.println();
      }
      while (d.get(Calendar.MONTH) == month);
      // the loop exits when d is day 1 of the next month

      // print final end of line if necessary
      if (weekday != firstDayOfWeek) System.out.println();
	*/	

}
