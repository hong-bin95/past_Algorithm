package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_17406_배열_돌리기_4_서울_20반_박홍빈 {

	static int[][] arr;
	static int[][] temp;
	static int [][] K_List;
	
	static int C;
	
	static void 회전(int sx, int sy, int ex, int ey) {
		
		int temp1,temp2,temp3,temp4;
		
		// 오른쪽으로 이동
		for(int i = sy; i < ey; i++) {
			
		}
		// 아래로 이동
		for(int i = sx; i < ex; i++) {
			
		}
		// 왼쪽으로 이동
		for(int i = ey; i > sy; i--) {
			
		}
		// 위로 이동
		for(int i = ex; i > sx; i--) {
	
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj17406.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열 크기, 크기, 회전배열 수
		int N,M,K;
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 회전배열
		K_List = new int[K][3];
		arr = new int[N][M];
		temp = new int[N][M];
		
		for(int i = 0 ; i< N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i< K; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int j = 0 ; j < 3 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

}
