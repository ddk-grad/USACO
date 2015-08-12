package usaco.dhinesh.section1_2;



/*
ID: ddk
LANG: JAVA
TASK: transform
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class transform {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(new File("transform.in")));
		PrintWriter pw = new PrintWriter(new File("transform.out"));
		int dimension = Integer.valueOf(br.readLine());
		int[][] source = new int[dimension][dimension];
		int[][] destination = new int[dimension][dimension];
		int sourceOnes = 0;
		int destinationOnes = 0;
		int answer = 7;
		for(int i=0; i<dimension; i++) {
			char[] arr = br.readLine().toCharArray();
			source[i] = new int[dimension];
			for(int j=0; j<dimension; j++) {
				if(arr[j] == '@') {
					source[i][j] = 1;
					sourceOnes++;
				} 
			}
		}
		
		for(int i=0; i<dimension; i++) {
			char[] arr = br.readLine().toCharArray();
			destination[i] = new int[dimension];
			for(int j=0; j<dimension; j++) {
				if(arr[j] == '@') {
					destination[i][j] = 1;
					destinationOnes++;
				} 
			}
		}
		
		if(sourceOnes == destinationOnes ) {
			answer = 0;
			int[][] sample = source.clone();
			boolean found = false;
			for(int i=1; i <= 3; i++) {
				answer++;
				sample = rotate(sample);
				if(gridCheck(destination, sample)) {
					found = true;
					break;
				}
			}
			
			if(!found) {
				answer++;
				sample = reflect(source);
				if(!gridCheck(destination, sample)) {
					answer++;
					for(int i=0; i<3; i++) {
						sample = rotate(sample);
						if(gridCheck(destination, sample)) {
							found = true;
							break;
						}
					}
				} else {
					found = true;
				}
			}
			
			if(!found) {
				answer++;
				if(gridCheck(source, destination)) {
					found = true;
				}
			}
			
			if(!found) {
				answer = 7;
			}
			
		}
		pw.println(answer);
		
		br.close();
		pw.close();
		
	}

	private static int[][] reflect(int[][] source) {
		int[][] answer = new int[source.length][source.length];
		for(int i=0; i<source.length; i++) {
			answer[i] = new int[source.length];
			for(int sj=source.length-1, dj=0; sj >= 0; sj--,dj++) {
				answer[i][dj] = source[i][sj];
			}
		}
		return answer;
	}

	private static boolean gridCheck(int[][] destination, int[][] sample) {
		for(int i=0; i<sample.length; i++) {
			for(int j=0; j<sample.length; j++) {
				if(destination[i][j] != sample[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static int[][] rotate(int[][] sample) {
		int[][] answer = new int[sample.length][sample.length];
		for(int c=0; c<sample.length;c++) {
			answer[c] = new int[sample.length];
			for(int r=sample.length-1, j=0; r>=0; r--,j++) {
				answer[c][j] = sample[r][c];
			}
		}
		return answer;
	}

		
	
}
