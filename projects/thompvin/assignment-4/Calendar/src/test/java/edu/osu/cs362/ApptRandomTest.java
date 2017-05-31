package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setDescription","isValid"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	
    /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");

		 long randomseed =10;//System.currentTimeMillis();
		 //			System.out.println(" Seed:"+randomseed );
		 Random random = new Random(randomseed);

			for (int iteration = 0; elapsed < TestTimeout; iteration++) {

				
				 int startHour=13;
				 int startMinute=30;
				 int startDay=10;
				 int startMonth=4;
				 int startYear=2017;
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 //Construct a new Appointment object with the initial data	 
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")) {
						   String newTitle = ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
					   }
					   else if(methodName.equals("setDescription")){
					   		String newDescription= ValuesGenerator.getString(random);
							appt.setDescription(newDescription);
					   }
					   else if (methodName.equals("isValid")){
						   startHour = random.nextInt(30)-3;
						   startMinute = random.nextInt(70)-5;
						   startDay = random.nextInt(35)-2;
						   startMonth = random.nextInt(20)- 4;


						   //System.out.println(startDay);
						   //System.out.println(startHour);
						   //System.out.println(startMinute);
						   //System.out.println(startMonth);
						   //System.out.println(startYear);

						   appt = new Appt(startHour,
								   startMinute ,
								   startDay ,
								   startMonth ,
								   startYear ,
								   title,
								   description);
						   //System.out.println(appt.toString());
						 //  try {
							   //use discription to get me into the valid check
							   String newDescription = ValuesGenerator.getString(random);
							   appt.setDescription(newDescription);


							/*   if (23 < startHour || 0 > startHour ||
									   59 < startMinute || 0 > startMinute ||
									   31 < startDay || 1 > startDay ||
									   12 < startMonth || 1 > startMonth) {
								fail();
							   }
						   }
						   catch (){
							   if (23 < startHour || 0 > startHour ||
									   59 < startMinute || 0 > startMinute ||
									   31 < startDay || 1 > startDay ||
									   12 < startMonth || 1 > startMonth) {

							   }
							   else{
							   	fail();
							   }
						   }*/

					   }

				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}


		 System.out.println("Done testing...");
	 }


	
}
