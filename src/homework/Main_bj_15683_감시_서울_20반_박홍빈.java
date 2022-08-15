package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_15683_감시_서울_20반_박홍빈 {
	
	static int N,M;
	static int[][] map;
	static boolean[][] isPossible;
	static int result = 0;
	// 전체 cctv 갯수
	static int cctvCnt;
	
	static int minCnt = Integer.MAX_VALUE;
	
	static void cctv(int cctvType) {
		if(cctvType == 1) {
			
		}
	}
	
	static void getPossible(int x, int y, int dx, int dy) {
		int nx = x + dx;
		int ny = y + dy;
		
		if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 6 ) {
			if(map[nx][ny] == 0 && isPossible[nx][ny] == false) {
				// 빈방이고 아직 방문 가능처리 안했으면 방문가능처리
				isPossible[nx][ny] = true;
			}
			getPossible(x,y,dx,dy);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj15683.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isPossible = new boolean[N][M];
		cctvCnt = N*M;
		
		for(int i = 0 ; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int j = 0 ; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		
		
	}

}
