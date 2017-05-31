package edu.osu.cs362;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		 Calendar rightnow = Calendar.getInstance();
		 int thisMonth = rightnow.get(Calendar.MONTH) + 1;
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 CalDay cal = new CalDay(today);

		 int startHour;
		 int startMinute;
		 int startDay;
		 int startMonth;
		 int startYear;

		 Appt appt;
		 long randomseed = 10;//System.currentTimeMillis();
		 Random random = new Random(randomseed);

		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {

			 //			System.out.println(" Seed:"+randomseed );



				 startHour = random.nextInt(50) - 13;
				 startMinute = random.nextInt(100) - 20;


			 startDay = thisDay;
			 startMonth = thisMonth;
			 startYear = thisYear;
			 //System.out.println(startDay);
			 //System.out.println(startHour);
			 //System.out.println(startMinute);
			 //System.out.println(startMonth);
			 //System.out.println(startYear);



			 String title= ValuesGenerator.getString(random);
			 String description= ValuesGenerator.getString(random);
			 //Construct a new Appointment object with the initial data
			  appt = new Appt(startHour,
					 startMinute,
					 startDay,
					 startMonth,
					 startYear,
					 title,
					 description);

			  //System.out.println(appt.toString());
			 cal.addAppt(appt);


			// i dont know why this is not working
			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			// System.out.println(iteration);
			 if((iteration%1000)==0 && iteration!=0 )
				 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);


		 }


		 System.out.println("Done testing...");
		 System.out.println(cal.toString());
	 }
	
}
