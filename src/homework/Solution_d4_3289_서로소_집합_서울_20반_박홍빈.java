package homework;

import java.io.*;
import java.util.*;


public class Solution_d4_3289_서로소_집합_서울_20반_박홍빈 {

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
		System.setIn(new FileInputStream("res/input_3289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		String str;
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			sb.append("#" + tc + " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			make(n+1);
				
			for(int i = 0 ; i < m; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				
				int type = Integer.parseInt(st.nextToken());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if(type == 0) {
					union(a,b);
				}
				else if(type == 1) {
					if(find(a) == find(b)) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}				
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}