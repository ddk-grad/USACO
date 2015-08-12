package usaco.dhinesh.section1_1;

/*
ID: ddk
LANG: JAVA
TASK: friday
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class friday {

	static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	static int[] frequency = {0,0,0,0,0,0,0};
	public static void main(String... args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(new File("friday.in")));
		PrintWriter pw = new PrintWriter(new File("friday.out"));
		int numYears = Integer.valueOf(br.readLine());
		int totalDays = 0;
		int startYear = 1900;
		for(int i=0; i<numYears; i++) {
			int year = startYear + i;
			boolean leapYear = isLeapYear(year);
			for(int j=0; j<12; j++) {
				frequency[(totalDays + 13) % 7]++;
				totalDays += days[j];
				if(leapYear && j==1) {
					totalDays++;
				}
			}
		}
		pw.print(frequency[6]);
		for(int i=0; i<6; i++) {
			pw.print(" "+frequency[i]);
		}
		pw.println();
		br.close();
		pw.close();
	}
	private static boolean isLeapYear(int year) {
		if((year % 400 == 0) || (year%100 != 0 && year%4 == 0))
			return true;
		return false;
	}
}
