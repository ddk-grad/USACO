package usaco.dhinesh.section1_2;

/*
ID: ddk
LANG: JAVA
TASK: milk2
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class milk2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(new File("milk2.in")));
		PrintWriter pw = new PrintWriter(new File("milk2.out"));
		int count = Integer.valueOf(br.readLine());
		Interval[] intervals = new Interval[count];
		for(int i=0; i<count; i++) {
			String[] fields = br.readLine().split(" ");
			intervals[i] = new Interval(Integer.valueOf(fields[0]), Integer.valueOf(fields[1]));
		}
		
		Arrays.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
			
		});
		Interval answer =  findIntervals(intervals);
		String ans = answer.start+" "+answer.end;
		pw.println(ans);
		
		br.close();
		pw.close();
	}
	
	private static Interval findIntervals(Interval[] intervals) {
		Interval milking = new Interval(intervals[0].start, intervals[0].end);
		int maxMilking = milking.duration;
		int maxNotMilking = 0;
		
		for(int i=1; i<intervals.length; i++) {
			if(intervals[i].start <= milking.end) {
				milking.setEnd(Math.max(intervals[i].end, milking.end));
				if(milking.duration > maxMilking) {
					maxMilking = milking.duration;
				}
			} else {
				int notMilking = intervals[i].start - milking.end;
				if(notMilking > maxNotMilking) {
					maxNotMilking = notMilking;
				}
				milking.setStart(intervals[i].start);
				milking.setEnd(intervals[i].end);
				if(milking.duration > maxMilking) {
					maxMilking = milking.duration;
				}
			}
		}
		return new Interval(maxMilking, maxNotMilking);
	}

	private static class Interval implements Comparable<Interval>{
		int start;
		int end;
		int duration;
		
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
			duration = end - start;
		}
		
		public void setStart(int start) {
			this.start = start;
			duration = end - start;
		}
		
		public void setEnd(int end) {
			this.end = end;
			duration = end - start;
		}
		@Override
		public int compareTo(Interval o) {
			return this.duration - o.duration;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + ", duration="
					+ duration + "]";
		}
		
		
	}
}
