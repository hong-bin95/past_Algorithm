package homework;

import java.io.*;
import java.util.*;

public class Main_bj_1197_최소_스패닝_트리_서울_20반_박홍빈 {
	static int[] p;
	
	static void make(int V) {
		p = new int[V];
		
		for(int i = 0 ; i < V; i++)
			p[i] = i;
	}
	
	static int find(int a) {
		if(p[a] == a)
			return p[a];
		
		
	}
	
	static void findSet(int a,int b) {
		int rootA = find(a);
		int rootB = find(b);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj1197.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<int[]> pq= new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));	
		
		for(int i = 0 ; i < E; i++) {
			pq.add(new int[] {0,0,0});
		}
		
		
		int cnt = 0;
		
		while(pq.isEmpty() == false) {
			int[] current = pq.poll();
			
			
			
		}
		
		

	}

}
