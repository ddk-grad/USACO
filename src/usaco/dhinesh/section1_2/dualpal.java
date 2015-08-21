package usaco.dhinesh.section1_2;

/*
ID: ddk
LANG: JAVA
TASK: dualpal 
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class dualpal {

	public static void main(String[] args) throws Exception{
	     String name = "dualpal";
	     BufferedReader br = new BufferedReader(new FileReader(new File(name+".in")));
	     PrintWriter pw = new PrintWriter(new File(name+".out"));
	     String[] numbers = br.readLine().split(" ");
	     int n = Integer.valueOf(numbers[0]);
	     int s = Integer.valueOf(numbers[1]);
	     
	     int i = 0;
	     int j = s+1; //s++
	     while(i < n) { // n>0 and do n--
	    	 int count = 0;
	    	 for(int base = 2; base <=10; base++) {
	    		 if(isPalindrome(Integer.toString(j, base))) {
	    			 count++;
	    		 }
	    		 if(count == 2) {
	    			 pw.println(j);
	    			 i++;
	    			 break;
	    		 }
	    	 }
	    	 j++;
	     }
	     
	     br.close();
	     pw.close();
	}
	
	private static boolean isPalindrome(String s) {
		return (new StringBuilder(s).reverse().toString()).equals(s);
	}
}
