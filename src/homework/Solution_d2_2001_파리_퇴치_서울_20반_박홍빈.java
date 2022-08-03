package homework;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d2_2001_파리_퇴치_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {

		//input_fly
		System.setIn(new FileInputStream("res/input_fly.txt"));

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N,M,S;
		String input;
		
		
		for(int tc = 1; tc <= T; tc++) {
			int max = Integer.MIN_VALUE;
			input = br.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			S = N - M;
			
			int [][] big_arr = new int [N][N];
			int [][] small_arr = new int[S+1][S+1];
			
			for(int i = 0 ; i < N; i++) {
				input = br.readLine();
				st = new StringTokenizer(input," ");
				for(int j = 0 ; j < N; j++) {
					big_arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i = 0 ; i <= S; i++) {
				for(int j = 0 ; j <= S; j++) {
					for(int ii = 0 ; ii  < M; ii++) {
						for(int jj = 0 ; jj < M ; jj++) {
							small_arr[i][j] += big_arr[i+ii][j+jj];
						}
					}
				}
			}
			
			for(int i = 0 ; i <= S; i++) {
				for(int j = 0 ; j <= S; j++) {
					if(max < small_arr[i][j]) {
						max = small_arr[i][j];
					}
				}
			}
			
			System.out.println("#" + tc + " " + max);

			
		}
		
		
		
		
	}

}
