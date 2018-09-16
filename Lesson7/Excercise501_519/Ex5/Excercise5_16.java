package Ex5;

import java.util.Scanner;

public class Excercise5_16 {

	/*
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Grade casper = new Grade();
		String temp = "";		
		
		System.out.println("Enter student grade: ");
		
		temp = scan.next();
		casper.setGrade(temp);
		//casper.setGrade("b+");
		
		System.out.println(temp);
		System.out.println(casper.gradeOut);
		System.out.println("Student grade is: " + casper.getGrade());
		
		scan.close();
	}
	*/
	
	static public class Grade {
		
		double gradeA = 4;
		double gradeB = 3;
		double gradeC = 2;
		double gradeD = 1;
		double gradeF = 0;
		
		private String grade = "";
		double gradeOut;
		
		public Grade() {
			grade = "No grade";
		}
		
		public void setGrade(String gradeIn) {
			grade = gradeIn;
		}
		
		public double getGrade() {
			if(grade == "A+" || grade == "a+") {
				gradeOut = gradeA + 0.3;
			}
			if(grade == "A" || grade == "a") {
				gradeOut = gradeA;
			}
			if(grade == "A-" || grade == "a-") {
				gradeOut = gradeA - 0.3;
			}			
			if(grade == "B+" || grade == "b+") {
				gradeOut = gradeB + 0.3;
			}
			if(grade == "B" || grade == "b") {
				gradeOut = gradeB;
			}
			if(grade == "B-" || grade == "b-") {
				gradeOut = gradeB - 0.3;
			}
			if(grade == "C+" || grade == "c+") {
				gradeOut = gradeC + 0.3;
			}
			if(grade == "C" || grade == "c") {
				gradeOut = gradeC;
			}
			if(grade == "C-" || grade == "c-") {
				gradeOut = gradeC - 0.3;
			}
			if(grade == "D+" || grade == "d+") {
				gradeOut = gradeD + 0.3;
			}
			if(grade == "D" || grade == "d") {
				gradeOut = gradeD;
			}
			if(grade == "D-" || grade == "d-") {
				gradeOut = gradeD - 0.3;
			}
			if(grade == "F" || grade == "f")
				gradeOut = gradeF;
			
			return gradeOut;
		}
		
	}

}
