package homework;

import java.io.*;
import java.util.*;

public class Main_bj_11026_적록색약_서울_20반_박홍빈 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int oCount = 0;
	static int xCount = 0;
	static int current1;
	static int current2;
	
	static int[] dx =  {-1,0,0,1};//{ 0, 1, 0, -1 };
	static int[] dy =  {0,1,-1,0};//{ 1, 0, -1, 0 };
	
	
	static void bfs1(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0 ; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >=0 && nx < N && ny >=0 && ny < N && visited[nx][ny] == false && map[nx][ny] == current1) {
				bfs1(nx,ny);
			}
			
		}
	}
	
	static void bfs2(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0 ; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >=0 && nx < N && ny >=0 && ny < N && visited[nx][ny] == false &&( map[nx][ny] == current1 || map[nx][ny] == current2)) {
				bfs2(nx,ny);
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/bj11026.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		String str;
		
		for(int i = 0 ; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < N ; j++) {
				map[i][j] = (int)str.charAt(j);
			}
		}

		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N ; j++) {
				if(visited[i][j] == false) {
					current1 = map[i][j];
					oCount++;
					bfs1(i,j);
				}
			}
		}
		
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N ; j++) {
				if(visited[i][j] == false) {
					current1 = map[i][j];
					xCount++;
					if(current1 == 82) {
						current2 = 71;
					}
					else if(current1 == 71) {
						current2 = 82;
					}
					else {
						current2 = current1;
					}
					bfs2(i,j);
				}
			}
		}
		
		System.out.println(oCount + " " + xCount);
	}

}
