package homework;

import java.io.*;
import java.util.*;

public class Main_bj_1260_DFS와_BFS_서울_20반_박홍빈 {
	
	static boolean[][] map;
	static boolean[] visited;
	static int N,M,V;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/bj1260.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken()); 
		
		sb = new StringBuilder();
		
		map = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0 ; i < M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = map[b][a] = true;
		}
		
		dfs(V);
		
		sb.append("\n");
		
		visited = new boolean[N+1];

		bfs(V);
		
		System.out.print(sb);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		sb.append(start + " ");
		
		for(int i = 1 ; i < N + 1 ; i++) {
			if(map[start][i] == true && visited[i] == false) {
		        dfs(i);
		      }
		}
		
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		q.offer(start);
		visited[start] = true;
		
		while(q.isEmpty() == false) {
			int temp = q.poll();
			sb.append(temp + " ");
			
			for(int i = 1 ; i < N+1; i++) {
				if(visited[i] == false && map[temp][i] == true) {
					visited[i] = true;
					q.offer(i);
				}
			}			
		}
		
		
	}

}
