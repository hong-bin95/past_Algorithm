package homework;

import java.io.*;
import java.util.*;


public class Main_bj_1600_말이_되고픈_원숭이_서울_20반_박홍빈 {
	
	static class monkey{
		public int x;
		public int y;
		public int cnt;
		public int k;
		
		public monkey(int x, int y, int cnt, int k) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
	
	static int [][] map;
	static int K,W,H;
	static boolean [][][] visited;	// 방문 여부  x, y, 말의 움직임 최소 횟수

	static int[] hx = {-2, -2, 2, 2, 1, -1, 1, -1};
	static int[] hy = {1, -1, 1, -1, 2, 2, -2, -2};
	static int[] mx = { 1, 0, 0, -1 };
	static int[] my = { 0, 1, 0, -2 };
	
	public static void bfs() {
		Queue<monkey> q = new LinkedList<>();
		q.add(new monkey(0, 0, 0, K));
		
		while(!q.isEmpty()) {
			monkey cm = q.poll();
			
			if( cm.x == W - 1 && cm.y == H - 1 ) {
				System.out.println(cm.cnt);
				return;
			}
			

			if(cm.x >= W || cm.y >= H || cm.x < 0 || cm.y < 0) continue;
			if(map[cm.y][cm.x] == 1) continue;
			
			if(visited[cm.y][cm.x][cm.k]) continue;
			visited[cm.y][cm.x][cm.k] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = cm.x + mx[i];
				int ny = cm.y + my[i];
				
				q.add(new monkey(nx, ny, cm.cnt+1,  cm.k));
				
			}
			
			if(cm.k == 0) continue;
			for(int i = 0; i < 8; i++) {
				int nx = cm.x + hx[i];
				int ny = cm.y + hy[i];
				
				q.add(new monkey(nx, ny, cm.cnt+1, cm.k-1));
				
			}
		}
		
		System.out.println("-1");
		return;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj1600.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		visited = new boolean[H][W][31];
		visited[0][0][0] = true;
		
		for(int i = 0; i < H; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();

	}

}
