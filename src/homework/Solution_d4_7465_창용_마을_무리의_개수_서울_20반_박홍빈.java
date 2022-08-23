package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_d4_7465_창용_마을_무리의_개수_서울_20반_박홍빈 {

	static int[] parents;
	
	static void make(int V) {		
		parents = new int[V];
		
		for (int i = 0; i < V; i++) { 			
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]); 
	}
	
	static boolean  union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_7465.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int N,M;
		
		
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
						
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			make(N+1);
				
			for(int i = 0 ; i < M; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a,b);
			}
						
			int[] rootCount = new int[N+1];
			int count = 0;
			
			for(int i = 1 ; i < N+1; i++) {
				int root = find(i);
				rootCount[root]++;
			}
			
			for(int i = 1 ; i < N+1; i++) {
				if(rootCount[i] != 0 )
					count++;
			} 
			
			System.out.println("#" + tc + " " + count);
		}
		
	}

}
