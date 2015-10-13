package usaco.dhinesh.section1_3;

/*
ID: ddk
LANG: JAVA
TASK: barn1
*/
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class barn1 {

	public static void main(String[] args) throws Exception{
	     String name = "barn1";
	     Scanner br = new Scanner(new File(name+".in"));
	     PrintWriter pw = new PrintWriter(new File(name+".out"));
	     
	     int boards = br.nextInt();
	     br.nextInt();
	     int cows = br.nextInt();
	     
	     int[] stalls = new int[cows];
	     for(int i=0; i<cows ; i++) {
	    	 stalls[i] = br.nextInt();
	     }
	     
	     Arrays.sort(stalls);
	     
	     int[] difference = new int[cows];
	     for(int i=0; i<stalls.length-1; i++) {
	    	 difference[i] = stalls[i+1] - stalls[i] - 1;
	     }
	     
	     Arrays.sort(difference);
	    
	     int sum = cows;
	     for(int i=0; i <= difference.length - boards; i++) {
	    	 sum += difference[i];
	     }
	     
	     pw.println(sum);
	     
	     br.close();
	     pw.close();
	}
}
