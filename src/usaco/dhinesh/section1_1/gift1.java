package usaco.dhinesh.section1_1;

/*
ID: ddk
LANG: JAVA
TASK: gift1
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class gift1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(new File("gift1.in")));
		PrintWriter pr = new PrintWriter(new File("gift1.out"));
		Map<String, Integer> initialMoneyMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> finalMoneyMap = new HashMap<String, Integer>();
		int numPeople = Integer.valueOf(br.readLine());
		while(numPeople > 0) {
			String name = br.readLine();
			initialMoneyMap.put(name, 0);
			finalMoneyMap.put(name, 0);
			numPeople--;
		}
		String name = null;
		while((name = br.readLine()) != null) {
			String line = br.readLine();
			String[] fields = line.split(" ");
			int initialMoney = Integer.valueOf(fields[0]);
			numPeople = Integer.valueOf(fields[1]);
			initialMoneyMap.put(name, initialMoney);
			if(numPeople != 0) {
				int share = initialMoney/numPeople;
				int leftover = initialMoney % numPeople;
				int previous = finalMoneyMap.get(name);
				finalMoneyMap.put(name, previous + leftover);
				while(numPeople > 0) {
					String friend = br.readLine();
					previous = finalMoneyMap.get(friend);
					finalMoneyMap.put(friend, previous + share);
					numPeople--;
				}
			}
		}
		
		for(Entry<String, Integer> entry : initialMoneyMap.entrySet()) {
			name = entry.getKey();
			int value = finalMoneyMap.get(name) - entry.getValue();
			pr.println(name+" " + value);
		}
		
		br.close();
		pr.close();
		
	}
	
	
}
