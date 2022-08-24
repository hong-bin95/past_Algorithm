package homework;

import java.io.*;
import java.util.*;

public class Main_bj_7576_토마토_서울_20반_박홍빈 {

	
	static int[] dx =  {-1,0,0,1};//{ 0, 1, 0, -1 };
	static int[] dy =  {0,1,-1,0};//{ 1, 0, -1, 0 };
	static int[][] map;
	static int M,N;
	
	static int count = 0;
	
	static void bfs() {
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if(map[i][j] == 1) {
					q.offer(new int[] { i,j });
				}
			}
		}

		while(q.isEmpty() == false) {			
			int[] temp = q.poll();
			
			for(int i = 0 ; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
															// 익지 않은 토마토는 
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = map[temp[0]][temp[1]] + 1;						// 익힌다. -> 날짜를저장한다.
					q.offer(new int[] { nx, ny });
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/bj7576.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0 ; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		int MAX = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if(map[i][j] == 0) {
					System.out.println("-1");
					System.exit(0);
				}
				if(MAX < map[i][j])
					MAX = map[i][j];
			}
		}
		
		System.out.println(MAX-1);
		
	}

}
