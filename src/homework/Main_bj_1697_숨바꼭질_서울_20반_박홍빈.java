package homework;

import java.io.*;
import java.util.*;

public class Main_bj_1697_숨바꼭질_서울_20반_박홍빈 {

	static int N,K;
	static final int MAX = 100001;
	static boolean[] visited;
	static int[] arr;
	 
	
	
	static int bfs() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		// 시작점은 수빈이의 위치
		q.add(N);
		// 방문처리
		visited[N] = true;
		arr[N] = 0;
		
		while(q.isEmpty() == false) {
			int temp = q.poll();
			int nN;
						
			// 순간이동
			nN = temp * 2;
			if(nN >= 0 && nN < MAX && visited[nN] == false) {
				visited[nN] = true;	
				arr[nN] = arr[temp] + 1;
				if(nN == K) {
					return arr[nN];	
				}
				q.add(nN);				
			}
			
			// 앞으로 한칸
			nN = temp + 1;
			if(nN >= 0 && nN < MAX && visited[nN] == false) {
				visited[nN] = true;
				arr[nN] = arr[temp] + 1;
				if(nN == K) {
					return arr[nN];	
				}
				q.add(nN);
			}
			
			// 뒤로 한칸
			nN = temp - 1;
			if(nN >= 0 && nN < MAX && visited[nN] == false) {
				visited[nN] = true;		
				arr[nN] = arr[temp] + 1;
				if(nN == K) {
					return arr[nN];	
				}
				q.add(nN);
			}
			
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj_1967.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		// 수빈 위치
		N = Integer.parseInt(st.nextToken());
		// 동생 위치
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[MAX];
		arr = new int[MAX];
		
		if(N == K)
			System.out.println(0);
		else
			System.out.println(bfs());

	}

}
