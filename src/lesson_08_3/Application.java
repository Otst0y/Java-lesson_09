/*
 * Console program 
 * */

package lesson_08_3;

import java.util.Scanner;

/**
 * @version 1.00 27 Jan 2023
 * @author Oleksii 
 * @since 27/01/2023 
 */
public class Application {

	/**
	 * enum 'Seasons' with 4 constants
	 * */
	enum Seasons {
		WINTER, SPRING, SUMMER, FALL;
	}
	
	/**
	 * enum ''Months with 12 constants. Each constant has 2 parameters, days and season.
	 * */
	enum Months {
		JANUARY(Seasons.WINTER, 31), FEBRUARY(Seasons.WINTER, 28), MARCH(Seasons.SPRING, 31), APRIL(Seasons.SPRING, 30),
		MAY(Seasons.SPRING, 31), JUNE(Seasons.SUMMER, 30), JULY(Seasons.SUMMER, 31), AUGUST(Seasons.SUMMER, 31),
		SEPTEMBER(Seasons.FALL, 30), OCTOBER(Seasons.FALL, 31), NOVEMBER(Seasons.FALL, 30),
		DECEMBER(Seasons.WINTER, 31);

		/* variable season of Season enum */
		Seasons season;
		
		/* variable days of integer type */
		int days;

		/**
		 * Constructor for enum 'Months', sets value for 'days' and 'season'.  
		 * 
		 * @param season The initial value for 'season' variable
		 * 
		 * @param days The initial value for 'days' variable
		 * */
		Months(Seasons season, int days) {
			this.season = season;
			this.days = days;
		}

		/**
		 * Method 'getSeason' returns current value of 'season'.
		 * 
		 * @return Value of 'season'
		 * */
		public Seasons getSeason() {
			return season;
		}

		/**
		 * Method 'setSeason' sets the value of 'season'.
		 * 
		 * @param season The new value for 'season'.
		 * */
		public void setSeason(Seasons season) {
			this.season = season;
		}

		/**
		 * Method 'getDays' return the value of days.
		 * 
		 * @return Value of 'days'
		 * */
		public int getDays() {
			return days;
		}

		/**
		 * Method 'setDays' sets the value of 'days'.
		 * 
		 * @param days The new value for 'days'.
		 * */
		public void setDays(int days) {
			this.days = days;
		}

	}

	/**
	 * Method 'menu' displays custom menu in a console.
	 * 
	 * @param no input parameters.
	 * */
	static void menu() {
		System.out.println("Press 1 to check if there such a month.");
		System.out.println("Press 2 to display all months with that have the same season.");
		System.out.println("Press 3 to display all months that have the same number of days.");
		System.out.println("Press 4 to display all months with fewer days.");
		System.out.println("Press 5 to display all months with more days.");
		System.out.println("Press 6 to display the next season .");
		System.out.println("Press 7 to display previous season.");
		System.out.println("Press 8 to display all months with an even number of days.");
		System.out.println("Press 9 to display all months with an odd number of days.");
		System.out.println("Press 10 to display whether the month has an even number of days.");
	}

	public static void main(String[] args) {
		
		/* create a scanner object */
		Scanner scan = new Scanner(System.in);
		
		/* create an array 'array' of values of enum 'Months' */
		Months[] array = Months.values();
		
		/* code displays the menu, that user can interact with by inserting numbers from 1 to 10 */
		while (true) {
			menu();

			/* 
			 * User enters a month and the program call 'isMonthExists
			 * method to check if the entered month exists in enumeration.
			 * If the month does not exist, the program displays a message saying 
			 * "Months doesn't exists."
			 * */
			switch (scan.next()) {
			case "1": {
				System.out.println("Enter month.");
				scan = new Scanner(System.in);
				String month = scan.next().toUpperCase();
				
				boolean flag = isMonthExists(array, month);

				if (!flag) {
					System.out.println("Months doesn't exists.");
				}
				break;
			}
			
			/*
			 * User enters a season and the program iterates through the enumeration
			 * to check if any of the months have a season that matches with the one entered.
			 * If there is a match, the program displays all the months that have
			 * the same season. If there is no match, the program displays a message 
			 * "Season doesn't exists." 
			 * */
			case "2": {
				System.out.println("Enter season.");
				scan = new Scanner(System.in);
				String season = scan.next().toUpperCase();
				
				boolean flag = false;

				for (Months m : array) {

					if (m.getSeason().name().equals(season)) {
						flag = true;
					}
				}
				
				if(flag) {
					for (Months m : array) {
						if(m.getSeason().toString().equalsIgnoreCase(season)) {
							System.out.println(m);
						}
					}
				}
				
				if (!flag) {
					System.out.println("Season doesn't exists.");
				}
				break;
			}
			
			/*
			 * User enters a number of days and the program iterates through 
			 * the enumeration to check if any of the months have the same number of 
			 * days. If there is a match, the program displays the month. 
			 * */
			case "3": {
				 System.out.println("Enter the number of days.");
                 int days = scan.nextInt();
         
                 for (Months m : array) {
                     if (m.getDays() == days) {
                         System.out.println(m);
                     }
                 }
                 break;
			}
			
			/*
			 * User enters a number of days, then loops through an array of
			 * Months objects and prints out any months that have fewer days than the 
			 * number entered by the user.
			 * */
			case "4": {
				System.out.println("Enter the number of days.");
				int days = scan.nextInt();
				
				for(Months m : array) {
					if(m.getDays() < days) {
						System.out.println(m);
					}
				}
				break;
			}
			
			/*
			 * Similar to case '4' but prints months that have fewer days than the
			 * number entered by the user.
			 * */
			case "5" : {
				System.out.println("Enter the number of days.");
				int days = scan.nextInt();
				
				for (Months m : array) {
					if(m.getDays() > days) {
						System.out.println(m);
					}
				}
				break;
			}
			
			/*
			 * User enters a season (in lowercase), program converts the input to uppercase
			 * and then prints out the next season, using switch statement. 
			 * */
			case "6" : {
				System.out.println("Enter season.");
				String season = scan.next().toUpperCase();
				
				switch(season) {
				case "WINTER" : {
					System.out.println("SPRING");
				}
				break;
				case "SPRING" : {
					System.out.println("SUMMER");
				}
				break;
				case "SUMMER" : {
					System.out.println("FALL");
				}
				break;
				case "FALL" : {
					System.out.println("WINTER");
				}
				break;
				}
			}break;
			
			/*
			 * Similar to case '6' but the program prints out previous season.
			 * */
			case "7" : {
				System.out.println("Enter season.");
				String season = scan.next().toUpperCase();
				
				switch(season) {
				case "WINTER" : {
					System.out.println("FALL");
				}
				break;
				case "FALL" : {
					System.out.println("SUMMER");
				}
				break;
				case "SUMMER" : {
					System.out.println("SPRING");
				}
				break;
				case "SPRING" : {
					System.out.println("WINTER");
				}
				break;
				}
			}break;
			
			/*
			 * Program loops through the array of Months objects and prints out
			 * any months that have an even number of days.
			 * */
			case "8" : {
				for (Months m : array) {
					if(m.getDays() % 2 == 0) {
						System.out.println(m);
					}
				}
			}
			
			/*
			 * Program loops through the array of Months objects and prints out 
			 * any months that have an odd number of days.*/
			case "9" : {
				for (Months m : array) {
					if(m.getDays() % 2 == 1) {
						System.out.println(m);
					}
				}
			}break;
			
			/*
			 * User enters a month in lowercase, program converts input to uppercase and 
			 * and then uses the input to create a Months object. Program checks if number
			 * of days is even or odd and prints out appropriate message.
			 * */
			case "10" : {
				System.out.println("Enter month.");
				String monthInput = scan.next().toUpperCase();
				
				Months month = Months.valueOf(monthInput);
				
				if (month.getDays() % 2 == 0) {
					System.out.println("Month has an even number of days.");
				} else {
					System.out.println("Month has an odd number of days.");
				}
			}
		}
	}
}

	private static boolean isMonthExists(Months[] array, String month) {
		boolean flag = false;

		for (Months m : array) {

			if (m.name().equals(month)) {
				System.out.println("Month exists.");
				flag = true;
			}
		}
		return flag;
	}
}
