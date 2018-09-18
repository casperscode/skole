package Ex5;

import java.util.Scanner;

public class Excercise5_15 {

	public static void main(String[] args) {
		Date dato = new Date();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter date, day(1-31) and month(1-12): ");
		
		int day = scan.nextInt();
		int month = scan.nextInt();
		
		dato.setDate(day, month);
		
		System.out.println(dato.getSeason());
		
		scan.close();
	}
	
	static public class Date{
		private int day;
		private int month;
		
		public Date() {
			day = 1;
			month = 1;
		}
		
		public void setDate(int tday, int tmonth){
			day = tday;
			month = tmonth;
		}
		
		public String getSeason() {
			String seas = " ";
			
			if(month >= 1 && month <= 3) {
				seas = "Winter";
			}else if (month >=4 && month <=6) {
				seas = "Spring";
			}else if (month >= 7 && month <= 9) {
				seas = "Summer";
			}else if (month >= 10 && month <= 12) {
				seas ="Fall";
			}
			
			
			if ((month / 3) == 0 && day >= 21) {
				if (seas == "Winter") {
					seas = "Spring";
				}else if (seas == "Spring") {
					seas = "Summer";
				}else if (seas == "Summer") {
					seas = "Fall";
				}else {
					seas = "Winter";
				}
			}
			
			return seas;
		}
	}

}
