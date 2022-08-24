package homework;

import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소_스패닝_트리_서울_20반_박홍빈 {
	static int[] p;
	
	static void make(int V) {
		p = new int[V];
		
		for(int i = 0 ; i < V; i++)
			p[i] = i;
	}
	
	static int findSet(int a) {
		if(p[a] == a)
			return p[a];
		
		return p[a] = findSet(p[a]);
		
	}
	
	static boolean union(int a,int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA == rootB) {
			return false;
		}
		
		p[rootA] = p[rootB];
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {


			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			PriorityQueue<int[]> pq= new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));	
			
			// from, to, weight
			for(int i = 0 ; i < E; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				
				pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			make(V+1);
			
			int cnt = 0;
			long result = 0;
			
			while(pq.isEmpty() == false) {
				int[] current = pq.poll();
				
				if(union(current[0],current[1])) {
					result += current[2];
					if(++cnt == V-1)
						break;
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}

}
