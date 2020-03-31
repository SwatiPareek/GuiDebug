
public class DateLibrary {

	public static void main(String[] args) {
		String calenderdate = "2000-02-29";
		System.out.println(isValidDateFormat(calenderdate)); // true
		System.out.println(isLeapYear(2000)); // true
		System.out.println(getMonth(calenderdate));
		System.out.println(getYear(calenderdate)); // 2000
		System.out.println(isValidDate(calenderdate)); // true
		System.out.println(compare("2010-12-07", "2002-02-07")); // 1
	}

	public static boolean isValidDateFormat(String date) {
		if (date.charAt(4) != '-' || date.charAt(7) != '-' || date.length() != 10) {
			return false;
		}
		String y = date.substring(0, 4);
		String m = date.substring(5, 7);
		String d = date.substring(8, 10);
		for (int i = 0; i < y.length(); i++) {
			if (Character.isDigit(y.charAt(i)) == false) {
				return false;
			}
		}
		for (int i = 0; i < m.length(); i++) {
			if (Character.isDigit(m.charAt(i)) == false) {
				return false;
			}
		}
		for (int i = 0; i < d.length(); i++) {
			if (Character.isDigit(d.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public static int getYear(String date) {
		if (isValidDateFormat(date) == true) {
			int year = Integer.parseInt(date.substring(0, 4));
			if (year >= 0 && year <= 9999) {
				return year;
			}
		}
		return -1;
	}

	public static int getMonth(String date) {
		if (isValidDateFormat(date) == true) {
			int month = Integer.parseInt(date.substring(5, 7));
			if (month >= 1 && month <= 12) {
				return month;
			}
		}
		return -1;
	}

	public static int getDay(String date) {
		if (isValidDateFormat(date) == true) {
			int day = Integer.parseInt(date.substring(8, 10));
			if (day >= 1 && day <= 31) {
				return day;
			}
		}
		return -1;
	}

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		}
		return false;
	}

	public static boolean isValidDate(String date) {
		if (isValidDateFormat(date) == true) {
			int year = Integer.parseInt(date.substring(0, 3));
			int month = Integer.parseInt(date.substring(5, 7));
			int day = Integer.parseInt(date.substring(8, 10));
			if (month == 1 && day <= 31) {
				return true;
			}
			if (month == 2) {
				if (isLeapYear(year) && day <= 29) {
					return true;
				} else if (day <= 28) {
					return true;
				}
			}

			if (month == 3 && day <= 31) {
				return true;
			}
			if (month == 4 && day <= 30) {
				return true;
			}
			if (month == 5 && day <= 31) {
				return true;
			}
			if (month == 6 && day <= 30) {
				return true;
			}
			if (month == 7 && day <= 31) {
				return true;
			}
			if (month == 8 && day <= 31) {
				return true;
			}
			if (month == 9 && day <= 30) {
				return true;
			}
			if (month == 10 && day <= 31) {
				return true;
			}
			if (month == 11 && day <= 30) {
				return true;
			}
			if (month == 12 && day <= 31) {
				return true;
			}
		}
		return false;
	}

	public static int compare(String date1, String date2) {
		if(date1.compareTo(date2) > 0) 
			return 1;
		if(date1.compareTo(date2) < 0)
			return -1;
		return 0;
	}
}
