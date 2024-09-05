package edu.ics211.h01;

public class Dates {
	public String computeDateTime(long sec, boolean leapYear) { //Method to compute date and time
		if (sec < 0 || sec >= (leapYear ? 31622400 : 31536000)) {
			return "Illegal number of seconds"; //If seconds is negative or exceeds 1 year
		}
		
		int[] daysInMonth = {31, (leapYear ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //Days in each month
		long secInDay = 86400; //Seconds in one day
		long day = sec / secInDay + 1; //Calculating one day
		long remain = sec % secInDay; //Calculating remaining seconds after computing number of days
		int month = 0, hour = 0, min = 0, second = 0; //Setting counters for month, hour, minutes and seconds to zero
		
		while(day > daysInMonth[month]) { //Using number of days to find month
			day -= daysInMonth[month];
			month++;
		}
		
		hour = (int)(remain / 3600); //Calculating hours
		min = (int)(remain % 3600 / 60); //Calculating minutes
		second = (int)(remain % 3600 % 60); //Calculating seconds
		
		return String.format("%3s %d %02d:%02d:%02d", new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}[month], day, hour, min, second); //Formatting date and time
	}

	public static void main(String[] args) { //Unit test
		Dates datesInstance = new Dates();
		System.out.println(datesInstance.computeDateTime(0, false));
	}
}
