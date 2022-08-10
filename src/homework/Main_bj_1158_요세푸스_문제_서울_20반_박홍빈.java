package homework;

import java.io.*;
import java.util.*;

public class Main_bj_1158_요세푸스_문제_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/bj1158.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		sb.append("<");
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1 ; i <= N; i++) {
			q.offer(i);
		}
		
		while(q.size() >= K) {
			for(int i = 0 ; i < K-1; i++) {
				q.offer(q.poll());
			}
			
			sb.append(q.poll() + ", ");
		}
		
		while(!q.isEmpty()) {
			sb.append(q.poll() + (q.size() > 0 ? ", " : ""));
		}
		

		sb.append(">");
		
		System.out.println(sb);
		
	}

}
