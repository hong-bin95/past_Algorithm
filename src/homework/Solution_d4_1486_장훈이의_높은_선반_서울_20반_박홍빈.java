package homework;

import java.io.*;
import java.util.*;

public class Solution_d4_1486_장훈이의_높은_선반_서울_20반_박홍빈 {
	
	static int[] arr;
	static boolean[] visited;
	static int N,B;
	static int min;	// 차이

	public static void subset(int cnt) {
		if(cnt == N) {
			int sum = 0;
			
			for(int i = 0 ; i < N; i++) {
				if(visited[i]) {
					sum += arr[i];					
				}
			}
			
			if(sum >= B && sum - B < min) {
				min = sum - B;
			}
			
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1486.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T; tc++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			// 직원수
			N = Integer.parseInt(st.nextToken());
			// 선반 높이
			B = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			visited = new boolean[N];
			
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for(int i = 0 ; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); 
			}
			
			min = Integer.MAX_VALUE;
			
			subset(0);
			
			System.out.println("#" + " " + min);
			
		}

	}

}
