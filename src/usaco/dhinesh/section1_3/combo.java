package usaco.dhinesh.section1_3;

/*
ID: ddk
LANG: JAVA
TASK: combo
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class combo {

	private static int[] numbers = {-2,-1,0,1,2};
	public static void main(String[] args) throws Exception{
		 //String prefix = "/Users/dhinesh/competitions/input/";
	     String name =  "combo";
	     Scanner scanner = new Scanner(new File(name+".in"));
	     PrintWriter pw = new PrintWriter(new File(name+".out"));
	     
	     int n = scanner.nextInt();
	     
	     int[] farmer = new int[3];
	     int[] master = new int[3];
	     
	     for(int i=0; i<3; i++) {
	    	 farmer[i] = scanner.nextInt();
	     }

	     for(int i=0; i<3; i++) {
	    	 master[i] = scanner.nextInt();
	     }
	     
	     Set<Triple> tripleSet = new HashSet<Triple>();
	     
	     generateTriples(farmer, n, tripleSet);
	     generateTriples(master, n, tripleSet);
	     
	     pw.println(tripleSet.size());
	     
	     scanner.close();
	     pw.close();
	}
	
	private static void generateTriples(int[] lock, int n,
			Set<Triple> tripleSet) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				for(int k=0; k<5; k++) {
					int x = (lock[0] + numbers[i] + n)%n;
					int y = (lock[1] + numbers[j] + n)%n;
					int z = (lock[2] + numbers[k] + n)%n;
					tripleSet.add(new Triple(x,y,z));
				}
			}
		}
	}

	private static class Triple {
		final int a,b,c;
		Triple(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Triple other = (Triple) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "[a=" + a + ", b=" + b + ", c=" + c + "]";
		}
		
		
	}
}
