package usaco.dhinesh.section1_1;

/*
ID: ddk
LANG: JAVA
TASK: ride
*/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class ride {

	public static void main(String... args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(new File("ride.in")));
		PrintWriter pr = new PrintWriter(new File("ride.out"));
		int comet = getMod(br.readLine());
		int group = getMod(br.readLine());
		if(comet == group) 
			 pr.println("GO");
		else
			pr.println("STAY");
		pr.close();
		br.close();
	}

	private static int getMod(String str) {
		char[] arr = str.toCharArray();
		int num = 1;
		for(int i=0; i<arr.length; i++) {
			num = num * (((int)arr[i])-64);
		}
		
		return num % 47;
	}

}
