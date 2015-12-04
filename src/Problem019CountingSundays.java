// 1 Jan 1900 was a Monday.
// Thirty days has September,
// April, June and November.
// All the rest have thirty-one,
// Saving February alone,
// Which has twenty-eight, rain or shine.
// And on leap years, twenty-nine.
// A leap year occurs on any year evenly divisible by 4, but not on a century 
// unless it is divisible by 400.

// How many Sundays fell on the first of the month during the twentieth century 
// (1 Jan 1901 to 31 Dec 2000)?

public class Problem019CountingSundays {

	int day = 1;
	int dayOfWeek = 2;

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		int sundays = 0;
		final int startYear = 1901;
		final int endYear = 2000;

		Problem019CountingSundays problemObject = new Problem019CountingSundays();

		for (int i = startYear; i <= endYear; i++) {
			if (i % 100 == 0) {
				if (i % 400 == 0) {
					sundays += problemObject.returnSundays(true);
				} else {
					sundays += problemObject.returnSundays(false);
				}
			} else if (i % 4 == 0) {
				sundays += problemObject.returnSundays(true);
			} else {
				sundays += problemObject.returnSundays(false);
			}
		}
		System.out.println("Answer: " + sundays);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

	private int returnSundays(boolean leapYear) {

		int month = 1;
		int daysInMonth = 0;
		int sundays = 0;

		while (month <= 12) {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				daysInMonth = 31;
				break;
			case 2:
				if (leapYear == true) {
					daysInMonth = 29;
				} else {
					daysInMonth = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				daysInMonth = 30;
				break;
			}
			while (day <= daysInMonth) {
				if ((dayOfWeek % 7 == 0) && (day == 1)) {
					sundays += 1;
					dayOfWeek += 1;
				} else {
					dayOfWeek++;
				}
				day++;
			}
			month++;
			day = 1;
		}

		return sundays;
	}
}