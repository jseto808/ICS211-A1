package edu.ics211.h01;

public class HW1 {

	public static void main(String[] args) {
		Dates datesInstance = new Dates(); //Calls Date class and method
		
		Reader readerInstance = new Reader(); //Calls Reader class and method
		for (String fileName : args) {
			int numWords = readerInstance.numWords(fileName); //Counting number of words with Reader class
			if (numWords == -1) {
				System.out.println(fileName + " Not Found"); //If file does not exist
			} else {
				System.out.println(fileName + " " + numWords); //File found and counted
			}
		}
		
		System.out.println("\nLeap Year Examples:"); //Using Date class to compute leap year date
		System.out.println(datesInstance.computeDateTime(-1, true));
		System.out.println(datesInstance.computeDateTime(0, true));
		System.out.println(datesInstance.computeDateTime(1, true));
		System.out.println(datesInstance.computeDateTime(3600, true));
		System.out.println(datesInstance.computeDateTime(43200, true));
		System.out.println(datesInstance.computeDateTime(31536000, true));
		System.out.println(datesInstance.computeDateTime(31622400, true));
		
		System.out.println("\nRegular Year Examples:"); //Using Date class to compute regular year date
		System.out.println(datesInstance.computeDateTime(-1, false));
		System.out.println(datesInstance.computeDateTime(0, false));
		System.out.println(datesInstance.computeDateTime(1, false));
		System.out.println(datesInstance.computeDateTime(3600, false));
		System.out.println(datesInstance.computeDateTime(43200, false));
		System.out.println(datesInstance.computeDateTime(31536000, false));
		System.out.println(datesInstance.computeDateTime(31622400, false));
		
		System.out.println("\nUsing loop to find number of seconds"); //For loop computing seconds
		String specificDateTime = "Jun 30 14:45:36";
		for (long seconds = 0; seconds <= 31622400; seconds++) { //For loop to compute seconds in leap year
			String computedDateTime = datesInstance.computeDateTime(seconds, true);
			if (computedDateTime.equals(specificDateTime)) {
				System.out.println("Seconds for " + specificDateTime + " in a leap year: " + seconds);
				break;
			}
		}
		
		for (long seconds = 0; seconds <= 31536000; seconds++) { //For loop to compute seconds in regular year
			String computedDateTime = datesInstance.computeDateTime(seconds, false);
			if (computedDateTime.equals(specificDateTime)) {
				System.out.println("Seconds for " + specificDateTime + " in a regular year: " + seconds);
				break;
			}
		}
	}
}
