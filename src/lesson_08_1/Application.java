package lesson_08_1;

import java.util.Scanner;

public class Application {

	enum Seasons {
		WINTER, SPRING, SUMMER, FALL;
	}

	enum Months {
		JANUARY(Seasons.WINTER, 31), FEBRUARY(Seasons.WINTER, 28), MARCH(Seasons.SPRING, 31), APRIL(Seasons.SPRING, 30),
		MAY(Seasons.SPRING, 31), JUNE(Seasons.SUMMER, 30), JULY(Seasons.SUMMER, 31), AUGUST(Seasons.SUMMER, 31),
		SEPTEMBER(Seasons.FALL, 30), OCTOBER(Seasons.FALL, 31), NOVEMBER(Seasons.FALL, 30),
		DECEMBER(Seasons.WINTER, 31);

		Seasons season;
		int days;

		Months(Seasons season, int days) {
			this.season = season;
			this.days = days;
		}

		public Seasons getSeason() {
			return season;
		}

		public void setSeason(Seasons season) {
			this.season = season;
		}

		public int getDays() {
			return days;
		}

		public void setDays(int days) {
			this.days = days;
		}

	}

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

	public static void main(String[] args) throws WrongInputConsoleParametersException{
		Scanner scan = new Scanner(System.in);
		Months[] array = Months.values();
		
		
		while (true) {
			menu();

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
			case "3": {
				 System.out.println("Enter the number of days.");
                 try {
                	 int days = scan.nextInt();
                     
                     for (Months m : array) {
                         if (m.getDays() == days) {
                             System.out.println(m);
                         }
                         if (days != 31 || days != 30 || days != 28) {
                        	 throw new WrongInputConsoleParametersException("There are no months with the same number of days.");
                         }
                     }
				} catch (WrongInputConsoleParametersException e) {
					System.err.println(e.getMessage());
				}break;
				 
                 
			}
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
			case "6" : {
				System.out.println("Enter season.");
				try {
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
					if (season != "WINTER" || season != "SPRING" || season != "SUMMER" || season != "FALL") {
						throw new WrongInputConsoleParametersException("There are no such season.");
					}
				} catch (WrongInputConsoleParametersException e) {
					System.err.println(e.getMessage());
				}
			}break;
			case "7" : {
				System.out.println("Enter season.");
				try {
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
					if (season != "WINTER" || season != "SPRING" || season != "SUMMER" || season != "FALL") {
						throw new WrongInputConsoleParametersException("There are no such season.");
					}
				} catch (WrongInputConsoleParametersException e) {
					System.err.println(e.getMessage());
				}
			}break;
			case "8" : {
				for (Months m : array) {
					if(m.getDays() % 2 == 0) {
						System.out.println(m);
					}
				}
			}
			case "9" : {
				for (Months m : array) {
					if(m.getDays() % 2 == 1) {
						System.out.println(m);
					}
				}
			}break;
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
