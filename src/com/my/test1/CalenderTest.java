package com.my.test1;

import java.util.Calendar;
import java.util.Date;

public class CalenderTest {
	
	public static void main(String[] args) {
		
		int startMonth = 5;
		int startYear = 2017;
		int endMonth = 11;
		int endYear = 2017;
		
		Date date1 = getMonthStartAndEnd(startYear, startMonth)[1];
		Date date2 = getMonthStartAndEnd(endYear, endMonth)[1];
		
		System.out.println(date1);
		System.out.println(date2);
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		
		int count = 1;
		while(true) {
			
			System.out.println("loop number => " + count);
			cal1.add(Calendar.MONTH, 1);
			System.out.println(cal1.getTime());
			if(cal1.after(cal2)) {
				break;
			}
			count++;
		}
	}
	
	
	public static Date[] getMonthStartAndEnd(int year, int month) {

		Calendar aCalendar = Calendar.getInstance();
		aCalendar.set(Calendar.YEAR, year);
		aCalendar.set(Calendar.MONTH, month);
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDateOfPreviousMonth = aCalendar.getTime();
		aCalendar.set(Calendar.DATE, 1);
		Date firstDateOfPreviousMonth = aCalendar.getTime();

		Date[] dates = new Date[] { firstDateOfPreviousMonth, lastDateOfPreviousMonth };

		return dates;
	}

}
