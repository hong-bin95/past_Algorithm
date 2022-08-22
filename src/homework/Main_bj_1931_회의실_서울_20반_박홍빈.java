package homework;

import java.io.*;
import java.util.*;

public class Main_bj_1931_회의실_서울_20반_박홍빈 {

	public static class meeting1931 implements Comparable<meeting1931>{
		int start;
		int end;
		
		public meeting1931() {
			
		}
		
		public meeting1931(int start,int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "start : " + start + "\t end : " + end;
		}

		@Override
		public int compareTo(meeting1931 o) {
			// 종료시간 같으면 시작시간으로 봐야한다. 중요!
			
			if(end == o.end)
				return start - o.start;
			return end - o.end;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj1931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<meeting1931> meetingList = new ArrayList<>();
		
		String str;
		StringTokenizer st;
		
		for(int i = 0 ;i < N; i++) {

		str = br.readLine();
		st = new StringTokenizer(str);

		meetingList.add(new meeting1931(Integer.parseInt(st.nextToken()), 
				Integer.parseInt(st.nextToken())));
		
		}
		
		 Collections.sort(meetingList);
		 
		 int end = meetingList.get(0).end;
		 
		 int cnt = 1;
		 
		 for(int i = 1; i < N ; i++) {
			 if(meetingList.get(i).start >= end) {
				 System.out.println(meetingList.get(i).toString());
				 cnt++;
				 end = meetingList.get(i).end;
			 }
		 }
		 
		 System.out.println(cnt);
		   
	}
}
