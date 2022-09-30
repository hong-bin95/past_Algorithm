package homework;

import java.io.*;
import java.util.*;



public class Main_bj_17070_파이프_옮기기_1_서울_20반_박홍빈 {
	public static int[][][] dp;		// 세번째는 0 오른쪽, 1 대각선, 2 아래
	public static int[][] map;
	
	public static int[] mr = { 1, 1, 0 };	// 오른쪽 대각선 아래
	public static int[] mc = { 0, 1, 1 };
	
	public static int N;
	
	public static int answer;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj10971.txt"));
		
		answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][N+1][3];
		map = new int[N+1][N+1];
		
		for(int i = 1; i < N + 1; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][0] = 1;		// 0 : 오른쪽
		
		/*가로 : 0, 세로 : 1, 대각선 : 2*/
		for(int i = 1 ; i < N; i++) {
			for(int j= 2 ; j < N ; j++) {
				if( map [i][j] == 1) {	// 가로는 가로만 0이면 된다.
					continue;					
				}
				// 가로로 이동 하려면 이 전칸(왼쪽)으로 올 때 가로로 오거나 세로로 와야한다
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
			/*	
				dp[i][j][]

				if( i == 1 ) {
					continue;
				}	// 시작점
				*/
				
			}
		}

	}

}
