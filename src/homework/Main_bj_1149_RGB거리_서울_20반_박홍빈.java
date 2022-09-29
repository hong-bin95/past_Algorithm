package homework;

import java.io.*;
import java.util.*;

public class Main_bj_1149_RGB거리_서울_20반_박홍빈 {
	
	

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/bj1149.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int N = Integer.parseInt(br.readLine());
		 
		 int[][] dp = new int[N+1][3];
		 
		 for(int i = 1; i <= N; i++) {
			 String str = br.readLine();
			 StringTokenizer st = new StringTokenizer(str);
			 int r = Integer.parseInt(st.nextToken());
			 int g = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());

			 dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r;
			 dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g;
			 dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;
		 }
		 
		 System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
		 
	}

}
