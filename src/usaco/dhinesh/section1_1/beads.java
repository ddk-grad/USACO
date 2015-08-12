package usaco.dhinesh.section1_1;

/*
ID: ddk
LANG: JAVA
TASK: beads
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class beads {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(new File("beads.in")));
		PrintWriter pw = new PrintWriter(new File("beads.out"));
		br.readLine();
		char[] beads = br.readLine().toCharArray();
		int maxCollected = breakNecklace(beads);
		pw.println(maxCollected);
		br.close();
		pw.close();
	}

	private static int breakNecklace(char[] beads) {
		int maxCount = 0;
		int size = beads.length;
		for(int i=0; i < size; i++) {
			int wCount = 0;
			int index = i;
			if(beads[index] == 'w') {
				do{
					wCount++;
					index = (index + 1) % size;
				}while(index != i && beads[index] == 'w') ;
				
				if(index == i) {
					return size;
				}
			}
			
			
			int count = wCount;
			char startBead = beads[index];
			do {
				count++;
				index = (index + 1) % size;
			} while(index != i && (startBead == beads[index] || beads[index] == 'w'));

			if(index == i) {
				return size;
			}

			char nextBead = beads[index];
			do {
				count++;
				index = (index + 1) % size;
			} while(index != i && (nextBead == beads[index] || beads[index] == 'w'));

			if(index == i) {
				return size;
			}
			
			if(count > maxCount) {
				maxCount = count;
			}
		}


		return maxCount;
	}

}
