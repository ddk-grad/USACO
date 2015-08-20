package usaco.dhinesh.section1_2;

/*
ID: ddk
LANG: JAVA
TASK: palsquare 
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class palsquare {

	static char[] digits = {'0','1','2','3','4','5','6','7','8','9',
							'A','B','C','D','E','F','G','H','I','J'};
	
	public static void main(String[] args) throws Exception{
	     String name = "palsquare";
	     BufferedReader br = new BufferedReader(new FileReader(new File(name+".in")));
	     PrintWriter pw = new PrintWriter(new File(name+".out"));
	     int base = Integer.valueOf(br.readLine());
	     for(int i=1; i<=300; i++) {
	    	 String square = numToBase(i*i, base);
	    	 if(isPalindrome(square)) {
	    		 pw.println(numToBase(i, base)+" "+square);
	    	 }
	     }
	     br.close();
	     pw.close();
		 
	}
	
	private static String numToBase(int num, int base) {
		StringBuilder sb = new StringBuilder();
		while(num >= base) {
			sb.append(digits[num % base]);
			num = num / base;
		}
		sb.append(digits[num]);
		return sb.reverse().toString();
	}
	
	private static boolean isPalindrome(String str) {
		return (new StringBuilder(str).reverse().toString()).equals(str);
	}
}
