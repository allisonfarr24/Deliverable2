import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;

public class dates {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userDate1;
		String userDate2;
		Date date1;
		Date date2;

		// creating SimpleDateFormat object
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		// prompting user to enter first input
		System.out.println("Please enter your date of birth in the format MM/dd/yyyy: ");
		userDate1 = scnr.nextLine();

		// prompting user to enter second input
		System.out.println("Please enter todays date in the format MM/dd/yyyy: ");
		userDate2 = scnr.nextLine();

		// using a try-catch block to handle potential parse exception
		try {
			// parsing the user input from String to Date format
			date1 = format.parse(userDate1);
			date2 = format.parse(userDate2);

			// converting from the Date class to Joda-Time DateTime
			DateTime dt1 = new DateTime(date1);
			DateTime dt2 = new DateTime(date2);

			// using Joda-Time to find the difference between the two dates in years,
			// months, and days
			System.out.print(Years.yearsBetween(dt1, dt2).getYears() + " years, ");
			System.out.print(Months.monthsBetween(dt1, dt2).getMonths() % 52 + " months, ");
			System.out.print(Days.daysBetween(dt1, dt2).getDays() % 30 + " days ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
