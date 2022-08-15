package homework;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main_bj_2667_단지번호붙이기_서울_20반_박홍빈 {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int total_dan = 0;	// 총 단지수
	static int num = 1;	// 단지번호
	static ArrayList<Integer> danList;
	// 우 하 좌 상
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static Queue<Point> queue = new LinkedList<>();
	
	static void bfs(int x, int y) {
		visited[x][y] = true;
		
		queue.offer(new Point(x,y));
		
		// 원점
		int  dan_cnt = 1;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i = 0 ; i < 4; i++) {
				int nx = dx[i] + p.x;
				int ny = dy[i] + p.y;
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N
						&& visited[nx][ny] != true && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.offer(new Point(nx,ny));
					dan_cnt++;
				}
			}
		}
		
		danList.add(dan_cnt);
		
		//queue
	}
	static void bfs2(int x, int y) {
		visited[x][y] = true;

		System.out.println("["+x+","+y+"]");
		queue.offer(new Point(x,y));
		
		// 원점
		int  dan_cnt = 1;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i = 0 ; i < 4; i++) {
				int nx = dx[i] + p.x;
				int ny = dy[i] + p.y;
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N
						&& visited[nx][ny] != true && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					System.out.println("["+nx+","+ny+"]");
					queue.offer(new Point(nx,ny));
					dan_cnt++;
				}
			}
		}
		
		danList.add(dan_cnt);
		
		//queue
	}
	
	
	static void dfs(int x,int y) {
		visited[x][y] = true;
		danList.set(total_dan, danList.get(total_dan) +1);
		
		for(int i = 0 ; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N
					&& visited[nx][ny] != true && map[nx][ny] == 1) {
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj2667.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		danList = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();

			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs2(4,4);
		
	/*	for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(visited[i][j] == false && map[i][j] == 1) {
					bfs(i,j);
				}
			}
		}
		*/
		total_dan = danList.size();
		
		/*for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(visited[i][j] == false && map[i][j] == 1) {
					danList.add(0);
					dfs(i,j);
					total_dan++;
				}
			}
		}*/
		
		
		
        Collections.sort(danList);
		System.out.println(total_dan);
		for(int i = 0 ; i < danList.size() ; i++) {
			System.out.println(danList.get(i));
		}
		
	}

}
