package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2164_카드2_서울_20반_박홍빈2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj2164.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input," ");
		
		// 배열 크기
		int N = Integer.parseInt(st.nextToken());
		// 계산 몇번 해야하는지!
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int [N][N];
		
		for(int i = 0 ; i < N ; i++) {
			input = br.readLine();
			st = new StringTokenizer(input," ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] answer_map = new int [N+1][N+1];
		
		// 가로로
		for(int i = 1 ; i < N+1 ; i++) {
			for(int j = 1 ; j < N+1; j++) {
				answer_map[i][j] = answer_map[i][j-1] + map[i-1][j-1];
			}
		}
		
		
		// 세로로
		for(int i = 1 ; i < N+1 ; i++) {
			for(int j = 1 ; j < N+1; j++) {
				answer_map[j][i] = answer_map[j-1][i] + answer_map[j][i];
			}
		}
		
				
		
		for(int i = 0 ; i < M ; i++) {
			input = br.readLine();
			st = new StringTokenizer(input," ");
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 인덱스화
			/*x1--;	// 2   	1
			x2--;	// 2	1
			y1--;	// 3	2
			y2--;	// 4	3			
*/			
			/*
			 * 1. 0,0 ~ x1,y2 전체 합을 구해서
			 * 2. x2,y2-y1 빼고
			 * 3. x2-x1,y2 빼고
			 * 4. x2-x1,y2-y1 더하기
			 * 
			 * 42-10-3+1
			 * */
			
			int sum = answer_map[x2][y2];
			sum -= answer_map[x1-1][y2];
			sum -= answer_map[x2][y1-1];
			sum += answer_map[x1-1][y1-1];
			
			System.out.println(sum);
		}
		
		/*for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N; j++) {
				System.out.print(answer_map[i][j] + " ");
			}
			System.out.println();
		}*/
		
	/*	for(int i = 0 ; i < N+1 ; i++) {
			for(int j = 0 ; j < N+1; j++) {
				System.out.print(answer_map[i][j] + " ");
			}
			System.out.println();
		}*/
		
		
	}

}
