package homework;

import java.io.*;
import java.util.*;

public class Main_bj_17472_다리_만들기2_서울_20반_박홍빈 {

	static int[][] map;
	
	static int N,M;
	
	static List<island> islandList;
	
	static class spot{
		int x;
		int y;
		
		public spot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class island {
		List<spot> spotList;
		int minimum;
		
		public island(List<spot> spotList) {
			this.spotList = spotList;
			this.minimum = Integer.MAX_VALUE;
		}
	}
	public static void main(String[] args) throws Exception {		
		System.setIn(new FileInputStream("res/bj17472.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		islandList = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i ++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int j = 0 ; j < M ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		List<spot> spotList = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					spotList = new ArrayList<>();
					getIsland(i,j,spotList); 
					islandList.add(new island(spotList));
					/*for(int k = 0 ; k < spotList.size() ; k++ ) {
						System.out.print(spotList.get(k).x + "," + spotList.get(k).y + "\t");
					}
					System.out.println(spotList.size());*/
				}
			}
		}
		
		int mincnt = 0;
		int totalmin = 0;
		for(int i = 0 ; i < islandList.size(); i++) {
			for(int j = 0 ; j < islandList.get(i).spotList.size(); j++) {
				int cnt = 0;
				visited = new boolean[N][M];
				int x = islandList.get(i).spotList.get(j).x;
				int y = islandList.get(i).spotList.get(j).y;
				
				getMinimun(x, y, cnt, i);				
			}
			if(islandList.get(i).minimum != Integer.MAX_VALUE) {
				mincnt++;
				totalmin += islandList.get(i).minimum;
			}
		}
		
		if(mincnt == N-1 && totalmin > 0) {
			System.out.println(totalmin);
		}
		else {
			System.out.println(-1);
		}
	}
	
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 }; 
	static boolean[][] visited ;
	
	static void getIsland(int x, int y, List<spot> spotList) {
		
		spotList.add(new spot(x, y));
		visited[x][y] = true;
		
		for(int i = 0 ; i < 4 ;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && visited[nx][ny] == false) {
				visited[nx][ny] = true;
				getIsland(nx, ny, spotList);
			}
		}
	}
	
	static void getMinimun(int x, int y, int cnt, int k) {
		visited[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == false) {
				visited[nx][ny] = true;
				if(map[nx][ny] == 0) {
					// 지속
					getMinimun(nx, ny, cnt + 1, k);
				}
				else if(map[nx][ny] == 1) {
					// 끝
					if(cnt >= 2 && cnt < islandList.get(k).minimum ) {
						islandList.get(k).minimum = cnt;
					}
				}
			}
		}
	}

}
