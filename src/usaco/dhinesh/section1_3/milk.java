package usaco.dhinesh.section1_3;


/*
ID: ddk
LANG: JAVA
TASK: milk
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class milk {
	
	public static void main(String[] args) throws Exception{
	     String name = "milk";
	     BufferedReader br = new BufferedReader(new FileReader(new File(name+".in")));
	     PrintWriter pw = new PrintWriter(new File(name+".out"));
	     String line = br.readLine();
	     String[] items = line.split(" ");
	     int totalAmount = Integer.valueOf(items[0]);
	     int numFarmers = Integer.valueOf(items[1]);
	     Farmer[] farmers = new Farmer[numFarmers];
	     for(int i=0; i < numFarmers; i++) {
	    	 line = br.readLine();
	    	 items = line.split(" ");
	    	 farmers[i] = new Farmer(Integer.valueOf(items[0]), Integer.valueOf(items[1]));
	     }
	     
	     Arrays.sort(farmers, new Comparator<Farmer>() {

			@Override
			public int compare(Farmer o1, Farmer o2) {
				return o1.unitcost - o2.unitcost;
			}
		});
	     
	     int minimumCost = 0;
	     int index = 0;
	     int amountRetrieved = 0;
	     while(amountRetrieved < totalAmount) {
	    	if (amountRetrieved + farmers[index].availableUnit < totalAmount) {
	    		amountRetrieved += farmers[index].availableUnit;
	    		minimumCost += farmers[index].unitcost * farmers[index].availableUnit;
	    	} else {
	    		int units = totalAmount - amountRetrieved;
	    		minimumCost += farmers[index].unitcost * units;
	    		break;
	    	}
	    	index++;
	     }
	     
	     pw.println(minimumCost);
	     br.close();
	     pw.close();
	}
	
	private static class Farmer {
		private final int unitcost;
		private final int availableUnit;
		
		Farmer(int unitcost, int availableUnit) {
			this.unitcost = unitcost;
			this.availableUnit = availableUnit;
		}
		
	}

}
