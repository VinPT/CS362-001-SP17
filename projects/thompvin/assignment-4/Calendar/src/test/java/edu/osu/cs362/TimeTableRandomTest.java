package edu.osu.cs362;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		 Calendar rightnow = Calendar.getInstance();
		 int thisMonth = rightnow.get(Calendar.MONTH) + 1;
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);

		 int startHour;
		 int startMinute;
		 int startDay;
		 int startMonth;
		 int startYear;

		 int loop;

		 LinkedList<Appt> appts;
		 Appt appt;
		 long randomseed = 10;//System.currentTimeMillis();
		 Random random = new Random(randomseed);

		 int failure = 0;

		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {

			 //			System.out.println(" Seed:"+randomseed );
			 TimeTable table = new TimeTable();
			 CalDay cal = new CalDay(today);

			 loop = random.nextInt(10);
			for(int i=0;i <= loop; i++) {
				//System.out.println(i);
				startHour = random.nextInt(20) +2;
				startMinute = random.nextInt(60);
				startDay = thisDay;
				startMonth = thisMonth;
				startYear = thisYear;
				//System.out.println(startDay);
				//System.out.println(startHour);
				//System.out.println(startMinute);
				//System.out.println(startMonth);
				//System.out.println(startYear);


				String title = ValuesGenerator.getString(random);
				String description = ValuesGenerator.getString(random);
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
			}



			appts = cal.getAppts();

			Appt nullAppt = null;
			LinkedList<Appt> nullAppts = null;

			for(int i =0 ;i <= loop ;) {
				//System.out.println(i);
				switch(random.nextInt(5)){
					case 0:
						//System.out.println("W");
						appt = appts.get(0);
						appts = table.deleteAppt(appts, appt);
						i++;
						break;
					case 1:
						//System.out.println("X");
						appt = null;
						try{
							nullAppts = table.deleteAppt(appts, appt);
						}
						catch(Exception e){
							failure++;

						}

						break;
					case 2:
						//System.out.println("Y");
						appt = appts.get(0);
						nullAppts = null;
						nullAppts = table.deleteAppt(nullAppts, appt);
						break;
					case 3:
						//System.out.println("Z");
						appt = null;
						nullAppts = null;
						try{
							nullAppts = table.deleteAppt(nullAppts, appt);
						}
						catch(Exception e){
							failure++;
						}
						break;
					case 4:
						//System.out.println("X");
						appt = new Appt((random.nextInt(20)-3),2,2,2,2,"Exist","I do not.");
						try{
							nullAppts = table.deleteAppt(appts, appt);
						}
						catch(Exception e){
							failure++;
						}
						break;
					default:
						//System.out.println("d");
						fail("Switch failed");
						break;
				}

				//System.out.println(i);
			}




				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 // System.out.println(iteration);
				 if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);


		 }


		 System.out.println("Done testing...");
		 if(0 != failure){
			 System.out.println("This code failed "+failure+" times.");
			 fail();
		 }
		 else{
			 System.out.println("Success");
		 }
	 }

}
