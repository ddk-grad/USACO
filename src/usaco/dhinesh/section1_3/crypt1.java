package usaco.dhinesh.section1_3;

/*
ID: ddk
LANG: JAVA
TASK: crypt1
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class crypt1 {

	public static void main(String[] args) throws Exception{
		String name = "crypt1";
		Scanner scanner = new Scanner(new File(name+".in"));
		PrintWriter pw = new PrintWriter(new File(name+".out"));

		int numdigits = scanner.nextInt();
		int[] digits = new int[10];
		for(int i=0; i<numdigits; i++) {
			digits[scanner.nextInt()] = 1;
		}
		int solutions = 0;
		for(int i = 100; i<1000; i++) {
			for(int j = 10; j < 100; j++) {
				if(checkDigits(i, digits) && checkDigits(j, digits)) {
					int a = i * (j%10);
					int b = i * (j/10);
					if( a > 99 && a < 1000 && b > 99 && b < 1000 && checkDigits(a, digits)
							&& checkDigits(b, digits) && checkDigits((10*b)+a, digits)) {
						//System.out.println(i+"," + j + "," +(b+(a*10)));
						solutions++; 
					}
				}
			}
		}
		pw.println(solutions);
		scanner.close();
		pw.close();
	}

	private static boolean checkDigits(int j, int[] digits) {
		while(j > 0) {
			if (digits[j % 10] != 1) {
				return false;
			} else {
				j = j/10;
			}
		}
		return true;
	}
}
