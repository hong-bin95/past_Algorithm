package homework;

import java.io.*;
import java.util.*;

public class Solution_d9_4012_요리사_서울_dfs_20반_박홍빈 {

	static int N;
	static int[][] taste;	
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	static void dfs(int depth, int start) {
		if(depth == N/2) {
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = i+1 ; j < N; j++) {
					if(visited[i]) {
						sum1 += taste[i][j] + taste[j][i]; 
					}
					else {
						sum2 += taste[i][j] + taste[j][i];
					}
				}
			}
			
			if(min > Math.abs(sum1 - sum2)) {
				min = Math.abs(sum1 - sum2);
			}
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[depth]) {
				visited[depth] = true;
				dfs(depth+1, i+1);
				visited[depth] = false;
			}
		}

	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_4012.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			taste = new int[N][N];
			visited = new boolean[N];
			for(int i = 0 ; i < N; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for(int j = 0 ; j < N ; j++) {
					taste[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0);
			
			System.out.println("#" + tc + " " + min);
			
		}

	}

}
