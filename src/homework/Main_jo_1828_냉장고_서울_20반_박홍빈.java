package homework;

import java.io.*;
import java.util.*;

public class Main_jo_1828_냉장고_서울_20반_박홍빈 {

	static int N;
	static ArrayList<refri> refriList;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jo1828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		refriList = new ArrayList<>();
		
		for(int i = 0 ; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			refriList.add(new refri(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(refriList);
		
		// 최솟값
		int count = 1;
		
		int max =  refriList.get(0).getEnd();
		

		for(int i = 0 ; i < N; i++) {
			if(refriList.get(i).getStart() <= max ) {
				if(refriList.get(i).getEnd() < max) {
					max = refriList.get(i).getEnd();	
				}
				continue;
			}
			else {
				max = refriList.get(i).getEnd();
				count++;
			}
		}
		
		System.out.println(count);
		
		/*for(int i = 0 ; i < N; i++) {
			System.out.println(refriList.get(i).getEnd());
		}*/
		
	}
	
	static class refri implements Comparable<refri> {
		int start;
		int end;
		
		public int getStart() {
			return start;
		}
		public refri(int start,int end) {
			setStart(start);
			setEnd(end);
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		@Override
		public int compareTo(refri o) {
			return getEnd() - o.getEnd();
		}
	}

}
